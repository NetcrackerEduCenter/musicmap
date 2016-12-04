function openNav() {
    $("#mySidenav").width(250);
}

function closeNav() {
    $("#mySidenav").width(0);
}

function setRegionInformation(locationName, numberOfUsers, rating) {
    $("#regionName").text(locationName);
    $("#numberOfUsers").text(numberOfUsers);
    if (Array.isArray(rating)){
        $("#rating").empty();
        for (var i = 0; i<5; i++){
            $("#rating").append("\<div class='row'\>"+(i+1)+") "+rating[i]+"\</div\>");
        }
    }
    else{
        $("#rating").text(rating);
    }
}

function setPolygonColor(indexUnselected,indexSelected) {
    if (indexUnselected != -1) {
        polygons[indexUnselected].options.set('fillColor', '#4CAF50');
        polygons[indexUnselected].options.set('fillOpacity', 0.15);
    }
    if (indexSelected != -1) {
        polygons[indexSelected].options.set('fillColor', '#FF4500');
        polygons[indexSelected].options.set('fillOpacity', 0.5);
    }
}

function changeRegionInformation(previousPolygonIndex, nextPolygonIndex) {
    setRegionInformation(locations[nextPolygonIndex].name, "Загрузка...", "Загрузка...");
    $.get("regStat", {locationId: locations[nextPolygonIndex].id}, function (data) {
        console.log(data);
        var object = JSON.parse(data);
        console.log(object);
        setRegionInformation(locations[nextPolygonIndex].name, object.userCount, object.topStyles)
    });
    // polygons[indexSelected].options.set('fillOpacity', 0.5);
    setPolygonColor(previousPolygonIndex, nextPolygonIndex);
}

var showRegionInformation = function (coords) {
    // console.log(coords);
    var id = getLocationIDByCoordinates(coords);
    if (getLocationIDByCoordinates(coords) > -1) {
        locations.forEach(function (item, i) {
            if (item.id === id) {
                tempInformation.nextPolygonIndex = i;
            }
        });
        if (tempInformation.previousPolygonIndex != tempInformation.nextPolygonIndex) {
            console.log(tempInformation);
            changeRegionInformation(tempInformation.previousPolygonIndex,
                tempInformation.nextPolygonIndex);
            tempInformation.previousPolygonIndex = tempInformation.nextPolygonIndex;
        }
        openNav();
    } else {
        setPolygonColor(tempInformation.nextPolygonIndex,-1);
        tempInformation.previousPolygonIndex = -1;
        tempInformation.nextPolygonIndex = -1;
        closeNav();
    }
};

var getLocationIDByCoordinates = function (coords) {
    for (i = 0; i < polygons.length; i++) {
        if (polygons[i].geometry.contains(coords)) {
            return locations[i].id;
        }
    }
    return -1;
}

function setToastText(text) {
    var $toastContent = $('<span>' + text + '</span>');
    Materialize.toast($toastContent, 5000);
}
