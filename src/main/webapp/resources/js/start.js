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
                    var str = JSON.stringify(result.response, ["aid", "artist", "genre"]);
                    userInformation.audios = str;
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
                userInformation.coords = result.geoObjects.get(0).geometry.getCoordinates();
                myMap.geoObjects.add(result.geoObjects);
                //Определяем id района по координатам юзера
                userInformation.locationId = undefined;
                for (i = 0; i < polygons.length; i++) {
                    for (j = 0; j < polygons[i].length; j++) {
                        if (polygons[i][j].geometry.contains(userInformation.coords)) {
                            userInformation.locationId = i;
                            break;
                            break;
                        }
                    }
                }
            } else {
                userInformation.coords = "low accuracy";
            }
        }, function (e) {
            console.log("Произошла ошибка при определении местоположения");
            userInformation.coords = undefined;
        });

    });

}

//Вешаем listener на кнопку send
$("#send").click(function () {
    console.log("Объект для отправки");
    console.log(userInformation);
    if (!userInformation.coords) {
        alert("Ошибка. Не определено местоположение.");
    }
    else if (coords == "low accuracy") {
        alert("Ошибка. Низкая точность местоположения.");
    }
    else if (!userInformation.audios) {
        alert("Ошибка. Не получен список аудизаписей.");
    }
    else if (!userInformation.locationId) {
        alert("Ошибка. Не определен район СПБ.")
    }
    else {
        $.post("/add_user",
            userInformation,
            console.log("Отправлено"));
    }
})