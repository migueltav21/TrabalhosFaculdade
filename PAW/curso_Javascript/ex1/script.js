function carregar() {
    var msg = document.getElementById("msg");
    var img = document.getElementById("imagem");
    var data = new Date();
    var hora = data.getHours();
    msg.innerHTML = `Agora são ${data.getHours()} horas `;
    if (hora >= 0 && hora< 12) {
        document.body.style.backgroundColor = "#ffe4b5";
        img.src = "pexels-artur-roman-1167355.jpg";
    } else if (hora>= 12 && hora <= 18) {
        document.body.style.backgroundColor = "#87ceeb";
        img.src = "pexels-anderson-martins-2386144.jpg";
    } else {
        document.body.style.backgroundColor = "#191970";
        img.src = "pexels-pixabay-355465.jpg";
    }
}
