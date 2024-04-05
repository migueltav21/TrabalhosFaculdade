function callback(args){
    console.log("Do work!");
    setTimeout(function() {
        callback2(args);
    }, 5000);
}

function callback2(args){
    console.log("Do more work");
}

function workA(args, callback){
    setTimeout(function() {
        callback(args);
    }, 2000);
}

console.log("Program continues...");

// Chamando a função workA para testar
workA("args", callback);
