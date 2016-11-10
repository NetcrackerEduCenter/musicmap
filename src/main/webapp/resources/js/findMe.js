ymaps.ready(init);

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
                myMap.geoObjects.add(result.geoObjects);
                document.getElementById('coords').value = result.geoObjects.get(0).geometry.getCoordinates();
            } else {
                document.getElementById('coords').value = 'low accuracy';
            }
            sendBrowserInformation(result.geoObjects);
        }, function (e){
            console.log("Произошла ошибка при определении местоположения");
            sendBrowserInformation(1)
        });
    });

    var sendBrowserInformation = function(geoObjects) {
        console.log(geoObjects);
        var browserInformation = {};
        if (geoObjects == 1) {
            browserInformation.errorType = 1;
        } else {
            browserInformation.errorType = 0;
            browserInformation.latitude = geoObjects.position[0];
            browserInformation.longtitude = geoObjects.position[1];
            browserInformation.accuracy = geoObjects.accuracy;
        }
        browserInformation.appVersion = navigator.appVersion;
        browserInformation.screenHeight = screen.height;
        browserInformation.screenWidth = screen.width;
        console.log(browserInformation);

        $.post("/add_user",
            browserInformation,
            console.log("Отправлено"));
    }
}