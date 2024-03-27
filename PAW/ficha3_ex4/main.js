// count initial ToDo
countTodos();

// capture click event
document.getElementById("checkAll").addEventListener("click", function () {
    AllDone();
});

//capture enter key press
document
    .getElementById("todo-to-add")
    .addEventListener("keypress", function (e) {
        if (e.which == 13) {
            // check if enter is pressed
            var todo = document.getElementById("todo-to-add").value;
            console.log(todo);
            addToDo(todo);
        }
    });

// capture click event
document.getElementById("addTODO").addEventListener("click", function () {
    var todo = document.getElementById("todo-to-add").value;
    console.log(todo);
    addToDo(todo);
});

var todos = document.querySelectorAll('#sortable li input[type="checkbox"]');
for (var i = 0; i < todos.length; i++) {
    todos[i].addEventListener("change", function () {
        if (this.checked == true) {
            var doneItem = this.parentElement.innerText;
            // $(this).parent().parent().parent().addClass('remove');
            console.log("done item: " + doneItem);
            done(doneItem);
            countTodos();
        }
    });
}

// capture click event on button minus on Already Done
var already_done_elements = document.getElementsByClassName("remove-item");
for (var i = 0; i < already_done_elements.length; i++) {
    already_done_elements[i].addEventListener("click", function () {
        console.log(this);
        removeItem(this);
    });
}

// add new todo
function addToDo(todo) {
    createTodo(todo);
    countTodos();
    saveToLocalStorage();
}

// count tasks (To Complete)
function countTodos() {
    var inputElems = document.getElementsByTagName("input"),
        count = 0;
    for (var i = 0; i < inputElems.length; i++) {
        if (inputElems[i].type === "checkbox") {
            count++;
        }
    }
    $("div.todo-footer:contains(Items Left)").html("<strong>" + count + "</strong> Items Left");

}

function createTodo(todo) {
    if (todo == "") {
        window.alert("Deve conter texto");
    } else {
        var tabela = document.getElementById("sortable");

        var linha = document.createElement("li");
        linha.className = "ui-state-default";
        var divisao = document.createElement("div");
        divisao.className = "checkbox";
        linha.appendChild(divisao);

        var lab = document.createElement("label");
        divisao.appendChild(lab);
        var inp = document.createElement("input");
        inp.type = "checkbox";
        inp.value = "";
        lab.appendChild(inp);

        var textNode = document.createTextNode(todo); // Adicionando o texto ao lado do checkbox
        lab.appendChild(textNode);
        tabela.appendChild(linha);
        document.getElementById("todo-to-add").value = "";

        inp.addEventListener("change", function () {
            if (this.checked == true) {
                var doneItem = this.parentElement.innerText;
                console.log("done item: " + doneItem);
                done(doneItem);
                countTodos();
            }
        });
    }
    saveToLocalStorage();
}

//mark task as done (To Complete)
function done(doneItem) {
    var doneList = document.getElementById("done-items");

    var newItem = document.createElement("li");
    newItem.innerHTML = doneItem;
    var botao = document.createElement("button");
    botao.className = "remove-item btn btn-default btn-xs pull-right";
    var sp = document.createElement("span");
    sp.className = "fa fa-minus-square";
    botao.appendChild(sp);
    newItem.appendChild(botao);
    doneList.appendChild(newItem);

    botao.addEventListener("click", function () {
        console.log(botao);
        removeItem(botao);
    });

    var todoListItems = document.querySelectorAll('#sortable li');

    // Itera sobre todos os itens da lista de todos
    for (var i = 0; i < todoListItems.length; i++) {
        // Marca o checkbox como checked
        var checkbox = todoListItems[i].querySelector('input[type="checkbox"]');
        if(checkbox.checked === true){

        // Obtém o texto do item
        var labelText = todoListItems[i].querySelector("label").textContent.trim();

        // Remove o item da lista de todos
        todoListItems[i].remove();
        }
    }
    saveToLocalStorage();
}

function AllDone() {
    var todoListItems = document.querySelectorAll('#sortable li');

    // Itera sobre todos os itens da lista de todos
    for (var i = 0; i < todoListItems.length; i++) {
        // Marca o checkbox como checked
        var checkbox = todoListItems[i].querySelector('input[type="checkbox"]');
        checkbox.checked = true;

        // Obtém o texto do item
        var labelText = todoListItems[i].querySelector("label").textContent.trim();

        // Remove o item da lista de todos
        todoListItems[i].remove();
        
        // Chama a função done para adicionar o item concluído na lista "Already Done"
        done(labelText);
    }

    // Atualiza a contagem de todos
    countTodos();
    saveToLocalStorage();
}


function removeItem(element) {
    var listItemToRemove = element.parentElement;
    listItemToRemove.parentElement.removeChild(listItemToRemove);
    saveToLocalStorage();
}


window.onload = function () {
    var savedTodos = localStorage.getItem('todos');
    var savedAlreadyDones = localStorage.getItem('alreadyDones');

    if (savedTodos) {
        document.getElementById("sortable").innerHTML = savedTodos;
    }

    if (savedAlreadyDones) {
        document.getElementById("done-items").innerHTML = savedAlreadyDones;
    }

    countTodos();

    // Associa os eventos aos elementos
    addEventListeners();
};

// Função para associar os eventos aos elementos
function addEventListeners() {
    var todos = document.querySelectorAll('#sortable li input[type="checkbox"]');
    for (var i = 0; i < todos.length; i++) {
        todos[i].addEventListener("change", function () {
            if (this.checked == true) {
                var doneItem = this.parentElement.innerText;
                console.log("done item: " + doneItem);
                done(doneItem);
                countTodos();
                saveToLocalStorage();
            }
        });
    }

    var already_done_elements = document.getElementsByClassName("remove-item");
    for (var i = 0; i < already_done_elements.length; i++) {
        already_done_elements[i].addEventListener("click", function () {
            console.log(this);
            removeItem(this);
            saveToLocalStorage();
        });
    }
}

// Função para salvar os todos e alreadyDones no localStorage
function saveToLocalStorage() {
    var todosHTML = document.getElementById("sortable").innerHTML;
    var alreadyDonesHTML = document.getElementById("done-items").innerHTML;

    localStorage.setItem('todos', todosHTML);
    localStorage.setItem('alreadyDones', alreadyDonesHTML);
}