function getlocation(){
    var latitude = document.getElementById("lat").value.trim();
    var longitude = document.getElementById("long").value.trim();
    if (latitude === '' || longitude === '') {
        alert('Por favor, insira valores válidos para latitude e longitude.');
        return;
    }
    getResult(latitude, longitude);
}

var apiKey = 'ea2cc127-bd87-4358-be42-a8c54b0e1546'
function getResult(latitude, longitude){
    const maxResults = 10;
    const apiUrl = `https://api.openchargemap.io/v3/poi/?output=json&latitude=${latitude}&longitude=${longitude}&distance=10&distanceunit=KM&maxresults=${maxResults}&compact=true&verbose=false&key=${apiKey}`;
    const xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            var data = JSON.parse(this.responseText);
            displayResults(data);
        } else if (this.readyState === 4) {
            console.error('Erro ao obter os dados.');
        }
    };
    xhttp.open("GET", apiUrl, true);
    xhttp.setRequestHeader("Accept", "application/json");
    xhttp.send();

}

function displayResults(data) {
    console.log(data)
    var i, country, lat, lon, address;
    var tbody = document.getElementById('tbody');
    
    for(i = 0; i < data.length; i++) {
        country = data[i]["AddressInfo"]["CountryID"];
        lat = data[i]["AddressInfo"]["Latitude"];
        lon = data[i]["AddressInfo"]["Longitude"];
        address = data[i]["AddressInfo"]["AddressLine1"];

        addLine(tbody, country, lat, lon, address);
    }
}

function addLine(tbody, country, lat, lon, address){
    var row = tbody.insertRow(0);
    row.insertCell(0).innerHTML = country;
    row.insertCell(1).innerHTML = lat;
    row.insertCell(2).innerHTML = lon;
    row.insertCell(3).innerHTML = address;
}
