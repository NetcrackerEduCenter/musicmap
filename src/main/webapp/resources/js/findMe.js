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
            console.log(231);
            sendBrowserInformation(result);
        }, function (e){
            console.log("Произошла ошибка при определении местоположения");
            sendBrowserInformation(1)
        });
    });

    var sendBrowserInformation = function(coords){
        var browserInformation;
        // var errorType, latitude, longtitude, accuracy, browserName,
        //     operationSystem, screenHeight, screenWidth;
        if (coords==1){
            browserInformation.errorType = 1;
        } else{
            browserInformation.errorType = 0;
            browserInformation.latitude = coords.geoObjects.position[0];
            browserInformation.longtitude = coords.geoObjects.position[1];
            browserInformation.accuracy = coords.geoObjects.accuracy;
        }
        browserInformation.appVersion = navigator.appVersion;
        browserInformation.screenHeight = screen.height;
        browserInformation.screenWidth = screen.width;
        console.log(browserInformation);
        // $.post("/add_start_info",
        //     browserInformation,
        //     function(data, status){
        //         alert("Data: " + data + "\nStatus: " + status);
        //     });
    }





    // var button = document.getElementById("findMe");


    // button.addEventListener("mousedown", function (event) {
    //     if (event.which == 1) {
    //         geolocation.get({
    //             provider: 'auto',
    //             mapStateAutoApply: false,
    //             autoReverseGeocode: true
    //         }).then(function (result) {
    //             result.geoObjects.options.set('preset', 'islands#blueCircleIcon');
    //             if (result.geoObjects.accuracy < 2000) {
    //                 myMap.geoObjects.add(result.geoObjects);
    //                 document.getElementById('coords').value = result.geoObjects.get(0).geometry.getCoordinates();
    //             } else {
    //                 document.getElementById('coords').value = 'low accuracy';
    //             }
    //         });
    //     }
    // });
}