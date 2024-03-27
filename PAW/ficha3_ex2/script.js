function add(tarefa = document.getElementById("caixaTexto").value) {
    var div = document.getElementById("toDo");
    var paragrafo = document.createElement("p");
    paragrafo.id = "par";

    if (tarefa.trim() === "") {
        window.alert("Deve conter texto!");
    } else {
        paragrafo.innerHTML = tarefa;
        div.appendChild(paragrafo);
        var botao = document.createElement("button");
        botao.id = "botao2";
        botao.innerHTML = "X";
        div.appendChild(botao);
        botao.onclick = function() {
            div.removeChild(paragrafo);
            div.removeChild(botao);
            salvarTarefas();
        };
        document.getElementById("caixaTexto").value = "";
        salvarTarefas();
    }
}

function salvarTarefas() {
    var tarefas = [];
    var paragrafos = document.querySelectorAll("#toDo p");
    paragrafos.forEach(function(paragrafo) {
        tarefas.push(paragrafo.textContent);
    });
    localStorage.setItem("tarefas", JSON.stringify(tarefas));
}

window.onload = function() {
    var tarefasSalvas = localStorage.getItem("tarefas");
    if (tarefasSalvas) {
        var tarefas = JSON.parse(tarefasSalvas);
        var div = document.getElementById("toDo");
        tarefas.forEach(function(tarefa) {
          add(tarefa);
        });
    }
};

function salvarNome() {
    var nome = document.getElementById("nomeUtilizador").value;
    if (nome.trim() !== "") {
        setCookie("nomeUtilizador", nome, 1);
    }
}

function setCookie(nome, valor, dias) {
    var data = new Date();
    data.setDate(data.getDate() + dias);
    var expires = "expires=" + data.toUTCString();
    document.cookie = nome + "=" + valor + ";" + expires + ";path=/";
}

function getCookie(nome) {
    var nomeFormatado = nome + "=";
    var cookies = document.cookie.split(';');
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        while (cookie.charAt(0) == ' ') {
            cookie = cookie.substring(1);
        }
        if (cookie.indexOf(nomeFormatado) == 0) {
            return cookie.substring(nomeFormatado.length, cookie.length);
        }
    }
    return "";
}

document.addEventListener("DOMContentLoaded", function() {
    var nomeCookie = getCookie("nomeUtilizador");
    if (nomeCookie) {
        var titulo = document.getElementById("titulo");
        titulo.textContent = nomeCookie + "'s To Do List";
        document.getElementById("formNome").style.display = "none";
    } else {
        document.getElementById("formNome").style.display = "block";
    }
});