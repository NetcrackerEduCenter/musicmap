ymaps.ready(init);

var tempInformation = {
    previousPolygonIndex: -1,
    nextPolygonIndex: -1
};

var userInformation = {};
var polygons = [];

VK.init({
    apiId: 5697583
});


$("#getAudio").click(function () {
    VK.Auth.login(function (response) {
        if (response.session) {
            /* Пользователь успешно авторизовался */
            userInformation.userID = response.session.mid;
            VK.Api.call('audio.get',
                {owner_id: userInformation.userID},
                function (result) {
                    result.response.shift();
                    userInformation.audios = result.response;
                    VK.Auth.revokeGrants();
                    console.log(userInformation);
                });
        }
        else {
            /* Пользователь нажал кнопку Отмена в окне авторизации */
        }
    }, 8);
});

function init() {
    var geolocation = ymaps.geolocation,
        myMap = new ymaps.Map('map',
            {
                center: [30.315868, 59.939095],
                zoom: 11,
                controls: ['zoomControl']
            });


    myMap.events.add('click', function (e) {
        showRegionInformation(e.get('coords'));
    });

    //Формируем полигоны из массива в location.js
    polygons = [];
    for (i = 0; i < locations.length; i++) {
        polygons[i] = new ymaps.GeoObject({
            geometry: {
                type: "Polygon",
                coordinates: locations[i].coords,
                fillRule: "nonZero"
            },
            properties: {
                // balloonContent: locations[i].name
            }
        }, {
            fillColor: '#4CAF50',
            fillOpacity: 0.15,
            strokeColor: '#0000FF',
            strokeOpacity: 0.4,
            strokeWidth: 2,
            strokeStyle: 'shortdash'
        });
        myMap.geoObjects.add(polygons[i]);
        //Добавляем функцию на клик по полигону
        polygons[i].events.add('click', function (e) {
            showRegionInformation(e.get('coords'));
        });
    }

    //Получаем кнопку с id "findMe" и вешаем на нее listener на клик
    $("#findMe").click(function () {
        geolocation.get({
            provider: 'auto',
            mapStateAutoApply: false,
            autoReverseGeocode: true
        }).then(function (result) {
            console.log("Местоположение определено. Продолжаю");

            result.geoObjects.options.set('preset', 'islands#blueCircleIcon');
            if (result.geoObjects.accuracy < 2000) {
                var coords = result.geoObjects.get(0).geometry.getCoordinates();
                userInformation.x = coords[0];
                userInformation.y = coords[1];
                myMap.geoObjects.add(result.geoObjects);
                //Определяем id района по координатам юзера
                userInformation.locationID = undefined;
                for (i = 0; i < polygons.length; i++) {
                    for (j = 0; j < polygons[i].length; j++) {
                        if (polygons[i][j].geometry.contains(coords)) {
                            userInformation.locationID = locations[i].id;
                            break;
                        }
                    }
                }
            } else {
                userInformation.x = "low accuracy";
            }
        }, function (e) {
            console.log("Произошла ошибка при определении местоположения");
            userInformation.x = undefined;
        });

    });

}

//Вешаем listener на кнопку send
$("#send").click(function () {
    console.log("Объект для отправки");
    console.log(userInformation);
    if (!userInformation.x) {
        alert("Ошибка. Не определено местоположение.");
    }
    else if (userInformation.x == "low accuracy") {
        alert("Ошибка. Низкая точность местоположения.");
    }
    else if (!userInformation.audios) {
        alert("Ошибка. Не получен список аудизаписей.");
    }
    else if (!userInformation.locationID) {
        alert("Ошибка. Не определен район СПБ.")
    }
    else {
        $.ajax({
            url: "/add_user",
            type: "POST",
            headers: {
                "Accept": "application/json; charset=utf-8"
            },
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(userInformation),
            dataType: "json"
        })
    }
})