async function workA(){
    console.log("Do work");
}

async function workB(){
    console.log("Do more Work!");
}

workA().then((result) => workB(result))
.then((result) => {
    console.log("Chained work ends");
}).catch((error) => {
    console.log("An exception was threwn in one of the promisses");
})