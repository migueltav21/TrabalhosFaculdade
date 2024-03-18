function verificar() {
    var data = new Date();
    var ano = data.getFullYear();
    var fano = document.getElementById("txtano");
    var res = document.getElementById("res");
    if (fano.value < 1900 || fano.value > 2024 || fano.value.lenght == 0) {
        window.alert("[ERRO] verifique os dados e tente de novo!");
    } else {
        var fsex = document.getElementsByName("radsex");
        var idade = ano - Number(fano.value);
        var genero = null;
        var img = document.getElementById("imagem");

        if (fsex[0].checked) {
            genero = "Homem";
            if (idade >= 0 && idade < 5) {
                img.src = "pexels-farhad-irani-16708553.jpg";
            } else if (idade < 17) {
                img.src = "pexels-jeffrey-reed-769745.jpg";
            } else if (idade < 40) {
                img.src = "pexels-manar-rajeep-16953492.jpg";
            } else {
                img.src = "pexels-juan-mendez-3075517.jpg";
            }
        } else {
            genero = "Mulher";
            if (idade >= 0 && idade < 5) {
                img.src = "pexels-tatiana-syrikova-3933025.jpg";
            } else if (idade >= 5 && idade < 17) {
                img.src = "pexels-julia-m-cameron-4143791.jpg";
            } else if (idade < 40) {
                img.src = "pexels-yury-oliveira-17045047.jpg";
            } else {
                img.src = "pexels-anastasia-shuraeva-5705513.jpg";
            }
        }

        res.innerHTML = "Idade calculada: " + idade + "\n Sexo: " + genero;
        res.appendChild(img);
    }
}
