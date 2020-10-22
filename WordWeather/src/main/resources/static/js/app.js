var app = (function(){
    
    var module = "js/apiclient.js";
    var map;
    var geoJSON;
    var request;
    var city;
    
    function updateData(cityJ){
        city = cityJ;
        console.log(city);
        $("#CountriesTable > tbody").empty();
            var row = '<tr><td>'+city.name.toString()+'</td><td>'+city.main.temperature.toString()
                    +'</td><td>'+city.main.tempMax.toString()+'</td><td>'+city.main.tempMin.toString()
                    +'</td><td>'+city.main.pressure.toString()+'</td><td>'+city.main.humidity.toString()+'</td><td>'
                    +city.weather.description.toString()+'</td></tr>';
            $("#CountriesTable > tbody").append(row);
        document.getElementById('CountriesTable').style.visibility = "visible";
        initMap();
    }
    
    function initMap(){
        var cent = {lat: city.coord.lat, lng: city.coord.lon};
        const map = new google.maps.Map(document.getElementById("map"), {
            zoom: 4,
            center: cent});
        const marker = new google.maps.Marker({
            position: cent,
            map: map});
        
    }
    
    return {
        getCityWeather: function (cityS){
            $.getScript(module, function(){
                api.getAllInfo(cityS  ,updateData)
            });
        }
    };
})();