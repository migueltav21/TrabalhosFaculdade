var contactos = [];

var Contacto = class {
    constructor(nome, numero, email, idade, alcunha) {
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.idade = idade;
        this.alcunha = alcunha;
    }
};

function criarContacto(
    nome,
    numero,
    email = null,
    idade = null,
    alcunha = null
) {
    try {
        if (typeof nome != "String" && typeof numero != "number") {
            throw "Nome tem de ser uma string e numero tem de ser um número!";
        } else {
            if (numero.toString().length !== 9) {
                throw new Error(
                    "Número de telefone deve ter exatamente 9 dígitos."
                );
            }
            if (nome.charAt(0) !== nome.charAt(0).toUpperCase()) {
                throw "Invalid name input";
            }
            if (!(email == null || typeof email == "string")) {
                throw "Invalid email input";
            }
            if (!(idade == null || typeof idade == "number")) {
                throw "Invalid number input";
            }
            if (!(alcunha == null || typeof alcunha == "string")) {
                throw "Invalid alcunha input";
            }
            return new Contacto(nome, numero, email, idade, alcunha);
        }
    } catch (error) {
        return error;
    }
}

function addContact(c) {
    if (c instanceof Contacto) {
        contactos.push(c);
    } else {
        console.log("O objeto não é uma instância válida de Contacto.");
    }
}

function removeContact(numero) {
    if (typeof numero !== "number") {
        return "burro";
    } else {
        for (var i = 0; i < contactos.length; i++) {
            if (numero == contactos[i].numero) {
                let c = contactos[i];
                contactos.splice(i, 1);
                return c;
            }
        }
    }
}

function numIdade(num) {
    if (typeof num !== "number") {
        return "burro";
    } else {
        let contador = 0;
        for (var i = 0; i < contactos.length; i++) {
            if (contactos[i].idade > num) {
                contador++;
            }
        }
        return contador;
    }
}

var contacto1 = criarContacto(
    "Miguel",
    123456789,
    "migueltav5@gmail.com",
    19,
    "Tavares"
);
var contacto2 = criarContacto(
    "Joao",
    939152963,
    "joaotav@gmail.com",
    17,
    "Jonny"
);
var contacto3 = criarContacto("Pedro", 999999999, "peni@gmail.com", 14, "Peni");

console.log(contacto1);

addContact(contacto1);
addContact(contacto2);
addContact(contacto3);

console.log("Lista de contactos:");
for (const element of contactos) {
    console.log(element);
}

var contactoRemovido = removeContact(123456789);
console.log("removido:");
console.log(contactoRemovido);

console.log("Lista de contactos:");
for (const element of contactos) {
    console.log(element);
}

var n= 13;
var total = numIdade(n);
console.log(`Pessoas com mais de ${n} anos: ${total}`);
