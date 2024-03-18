class Mapa {
    constructor(tamanho) {
        this.mapa = this.inicializarMapa(tamanho);
        this.title = "Batalha Naval";
        this.contador = 0;
    }

    inicializarMapa(tamanho) {
        const mapa = [];
        for (let i = 0; i < tamanho; i++) {
            mapa.push([]);
            for (let j = 0; j < tamanho; j++) {
                mapa[i].push("O");
            }
        }
        return mapa;
    }

    printMapa() {
        console.log(`Mapa do jogo "${this.title}":`);
        for (let linha of this.mapa) {
            console.log(linha.join(" "));
        }
    }
}

function placeBoat(map, linha, coluna) {
    if (linha >= 0 && linha < map.mapa.length && coluna >= 0 && coluna < map.mapa.length) {
        map.mapa[linha][coluna] = "S";
        console.log(`Navio posicionado em (${linha}, ${coluna}).`);
    } else {
        console.log("Posição inválida para o navio.");
    }
}

function play(map, linha, coluna) {
    if (linha >= 0 && linha < map.mapa.length && coluna >= 0 && coluna < map.mapa.length) {
        if (map.mapa[linha][coluna] === "S") {
            console.log("Acertou um navio!");
            map.mapa[linha][coluna] = "X";
            map.contador++;
        } else {
            console.log("Tiro na água.");
            map.contador++;
        }
    } else {
        console.log("Posição do tiro fora do mapa.");
    }
}

const tamanho = 5;
const map = new Mapa(tamanho);


placeBoat(map, 1, 1);
placeBoat(map, 0, 0);
placeBoat(map, 2, 2);
placeBoat(map, 3, 4);
placeBoat(map, 4, 1);


map.printMapa();

play(map, 1, 1);
play(map, 0, 0); 
play(map, 2, 2); 
play(map, 3, 3); 
play(map, 4, 1); 

map.printMapa();
