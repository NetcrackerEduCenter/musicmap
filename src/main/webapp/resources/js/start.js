ymaps.ready(init);

var userInformation = {};

VK.init({
    apiId: 5697583
});

$("#getAudio").click(function(){
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
                center: [59.939095, 30.315868],
                zoom: 11,
                controls: []
            });

    //Получаем кнопку с id "findMe" и вешаем на нее listener на клик
    $("#findMe").click(function(){
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
            } else {
                userInformation.coords = "low accuracy";
            }
        }, function (e){
            console.log("Произошла ошибка при определении местоположения");
            userInformation.coords = undefined;
        });
    });
}


//Вешаем listener на кнопку send
$("#send").click(function(){
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
    else {
        $.post("/add_user",
            userInformation,
            console.log("Отправлено"));
    }
})