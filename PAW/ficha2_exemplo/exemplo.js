"use strict";
console.log("Hello world");
var num;
num = 1;
console.log(num);
var s = "Connie Client";
var fName = s.substring(0, s.indexOf(" ")); // "Connie"
var len = s.length; // 13
console.log(len);
console.log(s);
console.log(fName);

var person = ["John", "Doe", 46];
console.log(person[1]);

var person = {firstName:"John", lastName:"Doe", age:46};
console.log(person.firstName, person.age);

var s1 = "hello";
var s2 = "";
for (var i = 0; i < s1.length; i++) {
s2 += s1.charAt(i) + s1.charAt(i);
console.log(s2);
}

var x = "Miguel";
var y = "Miguel";
console.log((x===y));

function hello(a){
    console.log('Hello')
   }
   hello()
   hello("world")
   hello(true)
   hello(2)

   function demo(a,b,c){
    console.log(a)
   }
   demo(2);
   demo(2,3);
   demo(2,3,4);