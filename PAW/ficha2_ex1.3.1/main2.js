function soma(a, b) {
  if (typeof a != 'number' || typeof b !== Number) {
    return "Erro: Ambos os argumentos devem ser números";
  }
  return a + b;
}

console.log(soma(1, 2));
console.log(soma(1));
console.log(soma());

function concat(a, b) {
    if (typeof a === 'undefined' || typeof b === 'undefined') {
        return "Erro: Faltam argumentos";
    }
    return a + b;
}

console.log(concat("Hello ", "World"));
console.log(concat(""));
console.log(concat()); 


function odd_demo2(a,b){
    if(a==undefined && b==undefined){
        console.log("error");
    }else
    if (b==undefined){
    console.log(a)
    }else{
    console.log(a + " " +b)
    }
   }
   odd_demo2(1)
   odd_demo2("hello", 3)
   odd_demo2()
   
   function element(index){
    var arr =[1,2,3]
    if(index < 0 || index >= arr.length){
        return "Erro: Índice fora dos limites do array";
    }else{
    return arr[index]
    }
   }
   
   console.log(element(-1));
   
   function sample(c){
    if( c == undefined){
      console.log("error")
    }else{
    console.log(c)
}
   }
   sample()
