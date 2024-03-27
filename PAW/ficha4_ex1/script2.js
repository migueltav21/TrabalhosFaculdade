var fs = require("fs")

fs.readFile("input.txt", function(err, data){
    if(err) return console.log("Burro do cacete o ficheiro esta mal");
    console.log(data.toString());
});

console.log("Acabou");