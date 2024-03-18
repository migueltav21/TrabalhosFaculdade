function soma(a, b) {
  return a + b;
}

console.log(soma(1, 2));
console.log(soma(1));
console.log(soma());
function concat(a, b) {
  return a + b;
}

console.log(concat("Hello ", "World"));
console.log(concat(""));
console.log(concat());

function odd_demo2(a, b) {
  if (b == undefined) {
    console.log(a);
  } else {
    console.log(a + " " + b);
  }
}

odd_demo2(1);
odd_demo2("hello", 3);
odd_demo2();

function element(index) {
  var arr = [1, 2, 3];
  if (index < 0 || index > arr.length) {
    return "index nao valido";
  } else {
    return arr[index];
  }
}

console.log(element(-1));

function sample(c) {
  if (c == undefined) {
    return console.log("variavel n passada como argumento");
  }
  console.log(c);
}

sample();
