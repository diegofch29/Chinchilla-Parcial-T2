api = (function(){
    return{
    getAllInfo: function(city,callback){
        console.log(city);
        $.getJSON("http://localhost:8080/WordW/"+city.toString() ,function (data){
            callback(data);
        });
    }
    };
})();