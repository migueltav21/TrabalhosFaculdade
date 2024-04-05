"https://code.jquery.com/jquery-3.3.1.slim.min.js";
integrity =
    "sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo";
crossorigin = "anonymous";
("https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js");
integrity =
    "sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1";
crossorigin = "anonymous";
("https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js");
integrity =
    "sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM";
crossorigin = "anonymous";

const openweathermaps_key = "fc1cd8108464da7fa28c5cccbf0b4cb8";

function searchWeather(lat, long) {
    var lat = document.getElementById("paw-form-lat").value;
    var lon = document.getElementById("paw-form-lon").value;
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            var weatherObject = JSON.parse(xhttp.response);
            var currentWeather = weatherObject["weather"][0]["description"];
            document.getElementById("paw-results-row").style.display = "block";
            document.getElementById("Results").innerHTML = currentWeather;
        }
    };

    xhttp.open(
        "GET",
        `http://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&APPID=${openweathermaps_key}`,
        true
    );
    xhttp.setRequestHeader("Accept", "application/json");
    xhttp.send();
};
