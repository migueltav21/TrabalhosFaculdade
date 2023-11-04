#include "moveis.h"

#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "encomenda.h"
#include "input.h"
#include "perfil.h"

bool codigoExistenteMateriais(Materiais materiais, char codigoMaterial[TAMANHO_CODIGO_PRODUTO]) {
    int pos = materiais.contador;

    for (int i = 0; i < pos; i++) {
        if (strcmp(materiais.material[i].codigoMaterial, codigoMaterial) == 0) {
            return true;
        }
    }

    return false;
}

// Tem prints
void criarMaterial(Materiais *materiais) {
    int pos = materiais->contador;
    bool codigoExistente;

    if (pos == 0) {
        materiais->material = (Material *)malloc(INCREMENTO * sizeof(Material));
    } else {
        if (pos % 10 == 0) {
            materiais->material = (Material *)realloc(materiais->material, (pos + INCREMENTO) * sizeof(Material));
        }
    }

    // Receber o nome do material
    lerStringDinamica(&(materiais->material[pos].nomeMaterial), "Nome do material: ");
    // Receber o codigo do material (tem de ser diferente dos existentes)
    do {
        lerString(materiais->material[pos].codigoMaterial, TAMANHO_CODIGO_PRODUTO - 1, "Codigo do material: ");
        codigoExistente = codigoExistenteMateriais((*materiais), materiais->material[pos].codigoMaterial);
    } while (codigoExistente);
    // Iniciar o contador (que vai contar as vezes que se usa o material) = 0
    materiais->material[pos].contador = 0;

    materiais->contador++;
}

bool codigoExistenteMovel(Moveis moveis, char codigoProduto[TAMANHO_CODIGO_PRODUTO]) {
    int pos = moveis.contador;

    for (int i = 0; i < pos; i++) {
        if (strcmp(moveis.movel[i].codigoProduto, codigoProduto) == 0) {
            return true;
        }
    }

    return false;
}

void criarMovel(Moveis *moveis, Materiais materiais, char *nome, float preco, float comprimento, float largura, float altura, char codigoProduto[TAMANHO_CODIGO_PRODUTO]) {
    int pos = moveis->contador, len;

    if (pos == 0) {
        moveis->movel = (Movel *)malloc((INCREMENTO) * sizeof(Movel));
    } else {
        if (pos % 10 == 0) {
            moveis->movel = (Movel *)realloc(moveis->movel, (pos + INCREMENTO) * sizeof(Movel));
        }
    }

    moveis->movel[pos].comprimento = comprimento;
    moveis->movel[pos].largura = largura;
    moveis->movel[pos].altura = altura;
    moveis->movel[pos].preco = preco;
    moveis->movel[pos].contador_materiais = materiais.contador;

    strcpy(moveis->movel[pos].codigoProduto, codigoProduto);

    len = strlen(nome);
    moveis->movel[pos].nome = (char *)malloc(len * sizeof(char));
    strcpy(moveis->movel[pos].nome, nome);
    moveis->movel[pos].material = (Material *)malloc(materiais.contador * sizeof(Material));

    for (int i = 0; i < materiais.contador; i++) {
        moveis->movel[pos].material[i].contador = materiais.material[i].contador;
        strcpy(moveis->movel[pos].material[i].codigoMaterial, materiais.material[i].codigoMaterial);

        len = strlen(materiais.material[i].nomeMaterial);
        moveis->movel[pos].material[i].nomeMaterial = (char *)malloc(len * sizeof(char));

        strcpy(moveis->movel[pos].material[i].nomeMaterial, materiais.material[i].nomeMaterial);
    }
    moveis->contador++;
}

void limparMateriais(Materiais *materiais) {
    int tamanho = materiais->contador;

    for (int i = 0; i < tamanho; i++) {
        free(materiais->material[i].nomeMaterial);
        materiais->material[i].contador = -1;
        strcpy(materiais->material[i].codigoMaterial, "000000");
    }

    materiais->contador = -1;
    free(materiais->material);
}

int posMaterial(Materiais materiais, char codigoMaterial[TAMANHO_CODIGO_PRODUTO]) {
    int tamanho = materiais.contador;
    for (int i = 0; i < tamanho; i++) {
        if (strcmp(materiais.material[i].codigoMaterial, codigoMaterial) == 0) {
            return i;
        }
    }
    return -1;
}

void listarMovel(Moveis moveis) {
    int i, j;
    linha();
    for (i = 0; i < moveis.contador; i++) {
        printf("Movel %d\n", i + 1);
        printf("Nome movel: %s\n", moveis.movel[i].nome);
        printf("codigo prduto: %s\n", moveis.movel[i].codigoProduto);
        printf("Dimensoes:%.1lfx%.1lfx%.1lf\n", moveis.movel[i].comprimento, moveis.movel[i].largura,
               moveis.movel[i].altura);
        printf("Preco: %.2f\n", moveis.movel[i].preco);
        printf("Material:\n");
        for (j = 0; j < moveis.movel[i].contador_materiais; j++) {
            printf("%s\n", moveis.movel[i].material[j].nomeMaterial);
            printf("Codigo material:%s\n", moveis.movel[i].material[j].codigoMaterial);
            printf("Quantidade: %d\n", moveis.movel[i].material[j].contador);
        }
        linha();
    }
}

int verificarMovel(Moveis moveis, char codigoProduto[TAMANHO_CODIGO_PRODUTO]) {
    int numero_moveis = moveis.contador, i;
    for (i = 0; i < numero_moveis; i++) {
        if (strcmp(moveis.movel[i].codigoProduto, codigoProduto) == 0) {
            return i;
        }
    }
    return -1;
}

int verificarMaterial(Moveis moveis, int posicao, char codigoProduto[TAMANHO_CODIGO_PRODUTO]) {
    int numero_materiais = moveis.movel[posicao].contador_materiais, i;
    for (i = 0; i < numero_materiais; i++) {
        if (strcmp(moveis.movel[posicao].codigoProduto, codigoProduto) == 0) {
            return i;
        }
    }
    return -1;
}

enum menu {
    NOME = 1,
    CODIGO_PRODUTO,
    DIMENSOES,
    PRECO,
    MATERIAL
};

enum menu2 {
    NOME_MATERIAL = 1,
    CODIGO,
    QUANTIDADE
};

// Tem prints
void editarMovel(Moveis *moveis) {
    char codigo[TAMANHO_CODIGO_PRODUTO], codigo_produto[TAMANHO_CODIGO_PRODUTO];
    int resultado, resultado_material, resposta;
    int comprimento, largura, altura, preco, quantidade;
    linha();
    lerString(codigo, TAMANHO_CODIGO_PRODUTO, "Insira o codigo do movel que deseja editar:");
    resultado = verificarMovel(*moveis, codigo);
    if (resultado == -1) {
        printf(MOVEL_INEXISTENTE);
    } else {
        printf(
            "[ 1 ] - Nome\n"
            "[ 2 ] - Codigo produto\n"
            "[ 3 ] - Dimensoes\n"
            "[ 4 ] - Preco\n"
            "[ 5 ] - Editar Material\n"
            "[ 6 ] - Retroceder\n");
        resposta = lerInt(1, 6, "Digite a opcao que pertende editar:");
        switch (resposta) {
            case NOME:
                lerStringDinamica(&(moveis->movel[resultado].nome), "Novo nome:");
                break;
            case CODIGO_PRODUTO:
                lerString(moveis->movel[resultado].codigoProduto, TAMANHO_CODIGO_PRODUTO, "Novo codigo do produto:");
                break;
            case DIMENSOES:
                printf("Novas dimensoes:\n");
                comprimento = lerFloat(0, 2000, "Comprimento:");
                largura = lerFloat(0, 2000, "Largura:");
                altura = lerFloat(0, 2000, "Altura:");

                moveis->movel[resultado].comprimento = comprimento;
                moveis->movel[resultado].largura = largura;
                moveis->movel[resultado].altura = altura;
                break;
            case PRECO:
                preco = lerFloat(0, 5000, "novo preco:");
                moveis->movel[resultado].preco = preco;
                break;

            case MATERIAL:
                lerString(codigo_produto, TAMANHO_CODIGO_PRODUTO - 1, "Insira o codigo do material que deseja editar:");
                resultado_material = verificarMaterial(*moveis, resultado, codigo_produto);
                if (resultado_material == -1) {
                    printf(MATERIAL_INEXISTENTE);
                } else {
                    printf(
                        "[ 1 ] - Nome\n"
                        "[ 2 ] - Codigo\n"
                        "[ 3 ] - Quantidade\n"
                        "[ 4 ] - Retroceder\n");
                    resposta = lerInt(1, 4, "Digite a opcao que pertende editar:");
                    switch (resposta) {
                        case NOME_MATERIAL:
                            lerStringDinamica(&(moveis->movel[resultado].material[resultado_material].nomeMaterial), "Novo nome material:");
                            break;
                        case CODIGO:
                            lerString(moveis->movel[resultado].material[resultado_material].codigoMaterial, TAMANHO_CODIGO_PRODUTO, "Novo codigo do material:");
                            break;
                        case QUANTIDADE:
                            quantidade = lerInt(1, 50, "Quantidade de material:");
                            moveis->movel[resultado].material[resultado_material].contador = quantidade;
                            break;
                    }
                    break;
                }
        }
    }
}

int posicaoMovel(Moveis moveis, char codigoProduto[6]) {
    int numeroMoveis = moveis.contador;

    for (int i = 0; i < numeroMoveis; i++) {
        if (strcmp(moveis.movel[i].codigoProduto, codigoProduto) == 0) {
            return i;
        }
    }

    return -1;
}

void eliminarMovel(Moveis *moveis, char codigoProduto[6]) {
    int pos = posicaoMovel((*moveis), codigoProduto);
    int tamanho = (*moveis).contador - 1;
    int tamanho_nome;
    int len;

    if (pos == -1) {
        printf(MOVEL_INEXISTENTE);
    } else {
        // Verificamos se so existe um movel
        if (pos != tamanho) {
            for (int i = pos; i < tamanho; i++) {
                len = strlen((*moveis).movel[i + 1].nome);
                (*moveis).movel[i].nome = (char *)realloc((*moveis).movel[i].nome, len * sizeof(char));
                strcpy((*moveis).movel[i].nome, (*moveis).movel[i + 1].nome);

                (*moveis).movel[i].preco = (*moveis).movel[i + 1].preco;
                strcpy((*moveis).movel[i].codigoProduto, (*moveis).movel[i + 1].codigoProduto);
                (*moveis).movel[i].comprimento = (*moveis).movel[i + 1].comprimento;
                (*moveis).movel[i].largura = (*moveis).movel[i + 1].largura;
                (*moveis).movel[i].altura = (*moveis).movel[i + 1].altura;
                len = (*moveis).movel[i + 1].contador_materiais;
                (*moveis).movel[i].contador_materiais = (*moveis).movel[i + 1].contador_materiais;
                (*moveis).movel[i].material = (Material *)realloc((*moveis).movel[i].material, len * (sizeof(Material)));
                for (int j = 0; j < len; j++) {
                    tamanho_nome = strlen((*moveis).movel[i + 1].material[j].nomeMaterial);
                    (*moveis).movel[i].material[j].nomeMaterial = (char *)realloc((*moveis).movel[i].material[j].nomeMaterial, tamanho_nome * sizeof(char));
                    strcpy((*moveis).movel[i].material[j].nomeMaterial, (*moveis).movel[i + 1].material[j].nomeMaterial);

                    strcpy((*moveis).movel[i].material[j].codigoMaterial, (*moveis).movel[i + 1].material[j].codigoMaterial);

                    (*moveis).movel[i].material[j].contador = (*moveis).movel[i + 1].material[j].contador;
                }
            }
        }

        free((*moveis).movel[tamanho].nome);
        len = (*moveis).movel[tamanho].contador_materiais;
        for (int j = 0; j < len; j++) {
            free((*moveis).movel[tamanho].material[j].nomeMaterial);
            (*moveis).movel[tamanho].material[j].contador = -1;
            strcpy((*moveis).movel[tamanho].material[j].codigoMaterial, "000000");
        }
        free((*moveis).movel[tamanho].material);
        (*moveis).movel[tamanho].preco = -1;
        (*moveis).movel[tamanho].comprimento = -1;
        (*moveis).movel[tamanho].largura = -1;
        (*moveis).movel[tamanho].altura = -1;
        (*moveis).movel[tamanho].contador_materiais = 0;
        strcpy((*moveis).movel[tamanho].codigoProduto, "000000");
        (*moveis).contador--;
    }
}

void lerFicheiroMateriais(Materiais *materiais, FILE *fMateriais, int nMateriais, char *nomeFicheiro) {
    int i = 0;
    int tamanhoBuffer = 1000;

    fMateriais = fopen(nomeFicheiro, "r");

    materiais->material = (Material *)malloc(nMateriais * sizeof(Material));

    while (!feof(fMateriais)) {
        materiais->material[i].nomeMaterial = (char *)malloc(tamanhoBuffer * sizeof(char));
        fscanf(fMateriais, "%[^;];%[^;];%d\n", materiais->material[i].nomeMaterial, materiais->material[i].codigoMaterial, &materiais->material[i].contador);
        i++;
    }

    fclose(fMateriais);
}

void escreverFicheiroMateriais(Materiais materiais, FILE *fMateriais, char *nomeFicheiro) {
    fMateriais = fopen(nomeFicheiro, "w");

    for (int i = 0; i < materiais.contador; i++) {
        fprintf(fMateriais, "%s;%s;%d\n", materiais.material[i].nomeMaterial, materiais.material[i].codigoMaterial, materiais.material[i].contador);
    }

    fclose(fMateriais);
}