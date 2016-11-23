
function openNav() {
    $("#mySidenav").width(250);
}

function closeNav() {
    $("#mySidenav").width(0);
}
    
function setRegionInformation(numberOfUsers){
    $("#numberOfUsers").text(numberOfUsers);
}

function changeRegionInformation(locationID){
    setRegionInformation("Загрузка...");
    setRegionInformation(Math.ceil(Math.random()*100));
}

var showRegionInformation = function(coords){
    var id = getLocationIDByCoordinates(coords);
    if(getLocationIDByCoordinates(coords)>-1){
        nextLocation = locations.filter(
            function(item){
                return item.id === id;
            })[0]
        if (nextLocation.id!=browserSession.previousLocationID) {
            browserSession.previousLocationID = nextLocation.id;
            $("#regionName").text(nextLocation.name);
            changeRegionInformation();
        }
        openNav();
    }else{
        closeNav()
    }
}

var getLocationIDByCoordinates = function(coords){
    for (i = 0; i < polygons.length; i++) {
        for (j = 0; j < polygons[i].length; j++) {
            if (polygons[i][j].geometry.contains(coords)) {
                return locations[i].id;
            }
        }
    }
    return -1;
}
