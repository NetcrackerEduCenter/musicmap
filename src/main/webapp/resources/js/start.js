ymaps.ready(init);

var userInformation = {};

VK.init({
    apiId: 5697583
});

$("#getAudio").click(function () {
    VK.Auth.login(function (response) {
        if (response.session) {
            /* Пользователь успешно авторизовался */
            userInformation.userID = response.session.mid;
            VK.Api.call('audio.get',
                {owner_id: response.session.mid},
                function (result) {
                    result.response.shift();
                    userInformation.audios = result.response;
                });
            VK.Auth.revokeGrants();
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
                controls: []
            });

    var polygons = [];

    //Формируем полигоны из массива в location.js
    for (i = 0; i < locations.length; i++) {
        polygons[i] = [];
        for (j = 0; j < locations[i].coords.length; j++) {
            polygons[i][j] = new ymaps.GeoObject({
                geometry: {
                    type: "Polygon",
                    coordinates: [locations[i].coords[j],],
                    fillRule: "nonZero"
                },
                properties: {
                    balloonContent: locations[i].name
                }
            }, {
                fillColor: locations[i].color,
                strokeColor: '#0000FF',
                opacity: 0.3,
                strokeWidth: 4,
                strokeStyle: 'shortdash'
            });
            myMap.geoObjects.add(polygons[i][j]);
        }
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
    else if (coords == "low accuracy") {
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
            url:"/add_user",
            type:"POST",
            headers: {
                "Accept" : "application/json; charset=utf-8"
            },
            contentType:"application/json; charset=utf-8",
            data: JSON.stringify(userInformation),
            dataType:"json"
        })
    }
})