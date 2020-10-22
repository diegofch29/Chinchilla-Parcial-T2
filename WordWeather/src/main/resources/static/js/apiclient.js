api = (function(){
    return{
    getAllInfo: function(city,callback){
        $.getJSON("http://localhost:8080/WordW",city ,function (data){
            callback(data);
        });
    }
    };
})();