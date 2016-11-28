function openNav() {
    $("#mySidenav").width(250);
}

function closeNav() {
    $("#mySidenav").width(0);
}
    
function setRegionInformation(locationName, numberOfUsers){
    $("#regionName").text(locationName);
    $("#numberOfUsers").text(numberOfUsers);
}

function setPolygonColor(previousPolygonIndex,nextPolygonIndex){
    if(previousPolygonIndex!=-1) {
        polygons[previousPolygonIndex].options.set('fillColor', '#4CAF50');
        polygons[previousPolygonIndex].options.set('fillOpacity', 0.15);
    }
    polygons[nextPolygonIndex].options.set('fillColor','#FF4500');
    polygons[nextPolygonIndex].options.set('fillOpacity',0.5);
}

function changeRegionInformation(previousPolygonIndex,nextPolygonIndex){
    setRegionInformation(locations[nextPolygonIndex].name,Math.ceil(Math.random()*100));
    setPolygonColor(previousPolygonIndex,nextPolygonIndex);
}

var showRegionInformation = function(coords){
    var id = getLocationIDByCoordinates(coords);
    if(getLocationIDByCoordinates(coords)>-1){
        locations.forEach(function(item, i){
            if (item.id === id){
                tempInformation.nextPolygonIndex = i;
            }
        });
        if (tempInformation.previousPolygonIndex!=tempInformation.nextPolygonIndex) {
            console.log(tempInformation);
            changeRegionInformation(tempInformation.previousPolygonIndex,
                tempInformation.nextPolygonIndex);
            tempInformation.previousPolygonIndex = tempInformation.nextPolygonIndex;
        }
        openNav();
    }else{
        closeNav()
    }
};

var getLocationIDByCoordinates = function(coords){
    for (i = 0; i < polygons.length; i++) {
        if (polygons[i].geometry.contains(coords)) {
            return locations[i].id;
        }
    }
    return -1;
}
