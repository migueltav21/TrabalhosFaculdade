function workA(args) {
    return new Promise(function (resolve, reject) {
        console.log("Do work!");
        // Se não houver erros
        resolve(args);
        // Se houver erros
        // reject('Mensagem de erro')
    });
}

function workB(args) {
    return new Promise(function (resolve, reject) {
        console.log("Do more work");
        // Se não houver erros
        resolve(args);
        // Se houver erros
        // reject('Mensagem de erro')
    });
}

workA("argumentos")
    .then(function(result){
        return workB(result);
    })
    .then((result) => {
        console.log("Chained work ends");
    })
    .catch((error) =>{
        console.log("An exception was thrown in one of the promises");
    });
