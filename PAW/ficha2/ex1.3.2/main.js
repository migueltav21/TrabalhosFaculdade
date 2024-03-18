function multiplicar(a = 0, b = 0) {
    if (typeof a == "number" || typeof b == "number") {
        return a * b;
    } else {
        return "burro";
    }
}

console.log(multiplicar(3, 6));

function maiorString(a) {
    if (Array.isArray(a)) {
        var maior = a[0];
        for (i = 0; i < a.length; i++) {
            if (typeof a[i] != "string") {
                a[i] = a[i].toString();
            }
            if (a[i].length > maior.length) {
                maior = a[i];
            }
        }
        return maior;
    } else {
        return "burro";
    }
}

console.log(maiorString(["aaaa", "bbb"]));

function letraMaiuscula(a) {
    if (typeof a != "string") {
        return "burro";
    } else {
        return a.charAt(0).toUpperCase() + a.slice(1);
    }
}

console.log(letraMaiuscula("miguel"));

function mostrepeted(a) {
    var contadorFinal;

    if (Array.isArray(a)) {
        var contadorFinal = 0;
        var final;
        var numAtual;
        var contador = 0;
        for (var i = 0; i < a.length; i++) {
            contador = 0;
            numAtual = a[i];
            for (var j = i; j < a.length; j++) {
                if (numAtual == a[j]) {
                    contador++;
                }
            }
            if (contador > contadorFinal) {
                contadorFinal = contador;
                final = numAtual;
            }
        }
        return final;
    } else {
        return "burro";
    }
}

console.log(mostrepeted([2, 1, 1, 1, 1, 1, 1, 1, 1, 3, 3, 3, 3, 7]));

function emailValido(a) {
    if (typeof a != "string") {
        return "burro";
    } else {
        var re = /^\w+([.-]?\w+)@\w+([.-]?\w+)(.\w{2,3})+$/;
        return re.test(a);
    }
}

console.log(emailValido("migueltav5@gmail.com"));

function numDigitos(numero) {
    try {
        if (typeof numero === "number") {
            numero = numero.toString();
            if (numero.length > 9) {
                throw "O número tem mais de 9 dígitos.";
            } else if (numero.length === 9) {
                return numero;
            } else {
                while (numero.length < 9) {
                    numero = "0" + numero;
                }
                return numero;
            }
        } else {
            throw "Tem de passar um número como argumento";
        }
    } catch (error) {
        return error;
    }
}

console.log(numDigitos(1234567890));

function isPrimo(numero) {
    if (numero <= 1) {
        return false;
    }
    for (let i = 2; i <= Math.sqrt(numero); i++) {
        if (numero % i === 0) {
            return false; // Se for divisível, não é primo
        }
    }

    return true; // Se passar por todos os testes, é primo
}

console.log(isPrimo(7));
console.log(isPrimo(10));
console.log(isPrimo(23));
console.log(isPrimo(1));
console.log(isPrimo(0));

function moedas(num) {
    if (typeof num === "number") {
        var array = [50, 20, 10, 5, 1];
        var arrayFinal = [];

        for (var i = 0; i < array.length; i++) {
            var moeda = array[i];
            while (num >= moeda) {
                num -= moeda;
                arrayFinal.push(moeda);
            }
        }
        return arrayFinal;
    } else {
        return "burro";
    }
}

console.log(moedas(46));

function palindromo(palavra) {
    if (typeof palavra != "string") {
        return "burro";
    } else {
        var normal = palavra.replace(/\s/g, "").toLowerCase();
        var contrario = [];
        for (var i = palavra.length - 1; i >= 0; i--) {
            if (palavra[i] != " ") {
                contrario.push(palavra[i]);
            }
        }
        contrario = contrario.toString();
        contrario = contrario.replace(/,/g, "").toLowerCase();
        if (contrario === normal) {
            return true;
        } else {
            return false;
        }
    }
}

console.log(palindromo("radar"));
console.log(palindromo("Ame o poema"));
console.log(palindromo("reconhecer"));
console.log(palindromo("casa"));
console.log(palindromo(123));

function numeroDiasNoMes(ano, mes) {
    var ultimoDiaMes = new Date(ano, mes, 0).getDate();

    return ultimoDiaMes;
}

const ano = 2022;
const mes = 2;
console.log(numeroDiasNoMes(ano, mes, 555));
