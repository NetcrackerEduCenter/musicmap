ymaps.ready(init);

function init() {
    var geolocation = ymaps.geolocation,
        myMap = new ymaps.Map('map',
            {
                center: [59.939095, 30.315868],
                zoom: 11,
                controls: []
            });
    var button = document.getElementById("findMe");
    button.addEventListener("mousedown", function (event) {
        if (event.which == 1) {
            geolocation.get({
                provider: 'auto',
                mapStateAutoApply: false,
                autoReverseGeocode: true
            }).then(function (result) {
                result.geoObjects.options.set('preset', 'islands#blueCircleIcon');
                if (result.geoObjects.accuracy < 2000) {
                    myMap.geoObjects.add(result.geoObjects);
                    document.getElementById('coords').value = result.geoObjects.get(0).geometry.getCoordinates();
                } else {
                    document.getElementById('coords').value = 'low accuracy';
                }
            });


        }
    });
}