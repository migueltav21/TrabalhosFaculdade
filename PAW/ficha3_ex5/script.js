function showMap() {
    var lat = document.getElementById("lat").value;
    var lon = document.getElementById("lon").value;
    var maxresults = document.getElementById("customRange1").value;
    initMap(lat, lon);
    searchChargePoints(lat, lon, maxresults);
}

var map;
function initMap(lat, lon) {
    if (!map) {
        // Se o mapa ainda não foi inicializado
        map = L.map("map").setView([lat, lon], 15);
        L.tileLayer("https://tile.openstreetmap.org/{z}/{x}/{y}.png", {
            maxZoom: 19,
            attribution:
                '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>',
        }).addTo(map);
    } else {
        // Se o mapa já foi inicializado
        map.setView([lat, lon], 15);
        map.eachLayer(function(layer) {
            if (layer instanceof L.Marker) {
                map.removeLayer(layer);
            }
        });
    }
}

var x = document.body;
function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else {
        x.innerHTML = "Your browser does not support geoLocation.";
    }
}
function showPosition(position) {
    initMap(position.coords.latitude, position.coords.longitude);
    var maxresults = document.getElementById("customRange1").value;
    searchChargePoints(position.coords.latitude, position.coords.longitude, maxresults);
}

var apiKey = 'YOUR API KEY'
function searchChargePoints(latitude, longitude, maxresults) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var response = JSON.parse(xhttp.response);
            for (let i = 0; i < response.length; i++) {
                var lat = response[i].AddressInfo.Latitude;
                var lon = response[i].AddressInfo.Longitude;
                var marker = L.marker([lat, lon]).addTo(map);
                var adress = "Adress: " + response[i].AddressInfo.Title + " " + response[i].AddressInfo.Town + "<br>";
                var connections = "Connections:<br>";
                for (let j = 0; j < response[i].Connections.length; j++) {
                    connections = connections.concat("Amps: " + response[i].Connections[j].Amps + " Voltage: " + response[i].Connections[j].Voltage + "<br>");
                }
                var distance = map.distance([latitude, longitude], [lat, lon]) / 1000;
                marker.bindPopup(adress + connections + "Distance: " + distance.toFixed(1) + "km").openPopup();
            }
        }
    };

    xhttp.open(
        "GET",
        `https://api.openchargemap.io/v3/poi/?output=json&latitude=${latitude}&longitude=${longitude}&distance=10&distanceunit=KM&maxresults=${maxresults}&compact=true&verbose=false&key=${apiKey}`,
        true
    );
    xhttp.setRequestHeader("Accept", "application/json");
    xhttp.send();
}

document.getElementById("customRange1").addEventListener("input", (event) => {
    document.getElementById("rangeValue").textContent = "Number of Charge Points: " + event.target.value;
})