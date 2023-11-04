#include "perfil.h"
#include "input.h"
#include "encomenda.h"

#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>


void criarEncomenda(Encomendas *encomendas, Materiais *materiais, Encomenda encomendaTemp) {
    int pos = (*encomendas).contador, posMat;
    int len;

    if (pos == 0) {
        (*encomendas).encomenda = (Encomenda *)malloc((INCREMENTO) * sizeof(Encomenda));
    } else {
        if (pos % 10 == 0) {
            (*encomendas).encomenda = (Encomenda *)realloc((*encomendas).encomenda, (pos + INCREMENTO) * sizeof(Encomenda));
        }
    }

    (*encomendas).encomenda[pos].preco = encomendaTemp.preco;
    (*encomendas).encomenda[pos].contador = encomendaTemp.contador;
    (*encomendas).encomenda[pos].data.dia = encomendaTemp.data.dia;
    (*encomendas).encomenda[pos].data.mes = encomendaTemp.data.mes;
    (*encomendas).encomenda[pos].data.ano = encomendaTemp.data.ano;
    (*encomendas).encomenda[pos].numeroCliente = encomendaTemp.numeroCliente;

    (*encomendas).encomenda[pos].movel = (Movel *)malloc(encomendaTemp.contador * sizeof(Movel));

    for (int i = 0; i < encomendaTemp.contador; i++) {
        strcpy(encomendas->encomenda[pos].movel[i].codigoProduto, encomendaTemp.movel[i].codigoProduto);
        encomendas->encomenda[pos].movel[i].quantidade = encomendaTemp.movel[i].quantidade;
        encomendas->encomenda[pos].movel[i].contador_materiais = encomendaTemp.movel[i].contador_materiais;
        encomendas->encomenda[pos].movel[i].preco = encomendaTemp.movel[i].preco;
        encomendas->encomenda[pos].movel[i].comprimento = encomendaTemp.movel[i].comprimento;
        encomendas->encomenda[pos].movel[i].largura = encomendaTemp.movel[i].largura;
        encomendas->encomenda[pos].movel[i].altura = encomendaTemp.movel[i].altura;

        len = strlen(encomendaTemp.movel[i].nome);
        encomendas->encomenda[pos].movel[i].nome = (char *)malloc(len * sizeof(char));
        strcpy(encomendas->encomenda[pos].movel[i].nome, encomendaTemp.movel[i].nome);

        encomendas->encomenda[pos].movel[i].material = (Material *)malloc(encomendas->encomenda[pos].movel[i].contador_materiais * sizeof(Material));
        for (int j = 0; j < encomendas->encomenda[pos].movel[i].contador_materiais; j++) {
            len = strlen(encomendaTemp.movel[i].material[j].nomeMaterial);
            encomendas->encomenda[pos].movel[i].material[j].nomeMaterial = (char *)malloc(len * sizeof(char));

            strcpy(encomendas->encomenda[pos].movel[i].material[j].nomeMaterial, encomendaTemp.movel[i].material[j].nomeMaterial);
            strcpy(encomendas->encomenda[pos].movel[i].material[j].codigoMaterial, encomendaTemp.movel[i].material[j].codigoMaterial);
            encomendas->encomenda[pos].movel[i].material[j].contador = encomendaTemp.movel[i].material[j].contador;
            posMat = posMaterial((*materiais), encomendas->encomenda[pos].movel[i].material[j].codigoMaterial);
            if (posMat != -1) {
                materiais->material[posMat].contador += encomendas->encomenda[pos].movel[i].material[j].contador;
            }
        }
    }

    calcularDataEntrega(&(*encomendas), pos);

    (*encomendas).contador++;
}

void calcularDataEntrega(Encomendas *encomendas, int pos) {
    int dia, mes, ano;
    dia = encomendas->encomenda[pos].data.dia;
    mes = encomendas->encomenda[pos].data.mes;
    ano = encomendas->encomenda[pos].data.ano;

    dia += TEMPO_ENTREGA;

    if (mes == 2) {
        if (ano % 4 == 0) {
            if (dia > 29) {
                mes++;
                dia -= 29;
            }
        } else {
            if (dia > 28) {
                mes++;
                dia -= 28;
            }
        }
    } else {
        if (mes <= 7) {
            if (mes % 2 == 0) {
                if (dia > 30) {
                    mes++;
                    dia -= 30;
                }
            } else {
                if (dia > 31) {
                    mes++;
                    dia -= 31;
                }
            }
        } else {
            if (mes % 2 == 0) {
                if (dia > 31) {
                    mes++;
                    dia -= 31;
                }
            } else {
                if (dia > 30) {
                    mes++;
                    dia -= 30;
                }
            }
        }
    }

    if (mes > 12) {
        ano++;
        mes = 1;
    }

    encomendas->encomenda[pos].dataEntrega.dia = dia;
    encomendas->encomenda[pos].dataEntrega.mes = mes;
    encomendas->encomenda[pos].dataEntrega.ano = ano;
}

int checkEncomendas(int num, Encomendas encomendas) {
    int valor;

    for (int i = 0; i < encomendas.contador; i++) {
        if (encomendas.encomenda[i].numeroCliente == num) {
            valor = 1;
        } else {
            valor = 0;
        }
    }
    return valor;
}

void listarEncomendas(Encomendas encomendas, Clientes clientes) {
    int tamanho = encomendas.contador;
    int n;

    if (tamanho == 0) {
        printf("Nao existem encomendas\n");
    } else {
        for (int i = 0; i < tamanho; i++) {
            printf("ENCOMENDA NUMERO: %d\n", i + 1);
            n = posCliente(clientes, encomendas.encomenda[i].numeroCliente);
            printf("Informacao do cliente:\n");
            printf("Numero de cliente: %d\n", clientes.cliente[n].numeroCliente);
            printf("Nome: %s %s\n", clientes.cliente[n].nome, clientes.cliente[n].apelido);
            printf("NIF: %s\n", clientes.cliente[n].nif);
            printf("Morada:\n");
            printf("cidade: %s\n", clientes.cliente[n].morada.cidade);
            printf("Rua: %s\n", clientes.cliente[n].morada.rua);
            printf("Codigo postal: %s\n", clientes.cliente[n].morada.codigoPostal);
            printf("Data da realizacao da encomenda: %d-%d-%d\n", encomendas.encomenda[i].data.dia, encomendas.encomenda[i].data.mes, encomendas.encomenda[i].data.ano);
            printf("Data de entrega: %d-%d-%d\n", encomendas.encomenda[i].dataEntrega.dia, encomendas.encomenda[i].dataEntrega.mes, encomendas.encomenda[i].dataEntrega.ano);
            printf("-----\n");
            for (int j = 0; j < encomendas.encomenda[i].contador; j++) {
                printf("Movel %d\n", j + 1);
                printf("Nome do movel: %s\n", encomendas.encomenda[i].movel[j].nome);
                printf("Quantidade: %d\n", encomendas.encomenda[i].movel[j].quantidade);
                printf("Codigo do produto: %s\n", encomendas.encomenda[i].movel[j].codigoProduto);
            }
            linha();
        }
    }
}

void listarEncomendasCliente(int num, Encomendas encomendas, Moveis moveis) {
    int posicao_movel, opcao, cont, n = 0, auxiliar = 0;
    for (int i = 0; i < encomendas.contador; i++) {
        if (encomendas.encomenda[i].numeroCliente == num) {
            cont++;
        }
    }
    int encomenda[cont];

    if (cont == 0) {
        printf("Ainda nao fez encomendas\n");
    } else {
        printf("\n");
        printf("ENCOMENDAS:\n");
        for (int i = 0; i < encomendas.contador; i++) {
            if (encomendas.encomenda[i].numeroCliente == num) {
                printf("ENCOMENDA NUMERO: %d\n", i + 1);
                for (int j = 0; j < encomendas.encomenda[i].contador; j++) {
                    posicao_movel = verificarMovel(moveis, encomendas.encomenda[i].movel[j].codigoProduto);
                    printf("%s\n", moveis.movel[posicao_movel].nome);
                    printf("Quantidade: %d\n", encomendas.encomenda[i].movel[j].quantidade);
                    printf("Codigo do artigo: %s\n", encomendas.encomenda[i].movel[j].codigoProduto);
                    printf("Preco: %.2f\n", moveis.movel[posicao_movel].preco * encomendas.encomenda[i].movel[j].quantidade);
                }
                printf("-----\n");
                printf("Preco total da encomenda: %.2f\n", encomendas.encomenda[i].preco);
                printf("Data da encomenda: %d-%d-%d\n", encomendas.encomenda[i].data.dia, encomendas.encomenda[i].data.mes, encomendas.encomenda[i].data.ano);
                printf("Data de entrega: %d-%d-%d\n\n", encomendas.encomenda[i].dataEntrega.dia, encomendas.encomenda[i].dataEntrega.mes, encomendas.encomenda[i].dataEntrega.ano);
                encomenda[n] = i + 1;
                n++;
            }
        }

        printf("Deseja ver detalhes de alguma encomenda:\n"
                "[ 1 ] - Sim\n"
                "[ 2 ] - Nao\n");
        opcao = lerInt(1, 2, "Opcao:");
        if (opcao == 1) {
            printf("-----\n");
            do {
                printf("Insira o número da encomenda que deseja ver os detalhes:\n");
                scanf("%d", &opcao);
                for (int i = 0; i < cont; i++) {
                    if (opcao == encomenda[i]) {
                        auxiliar = 1;
                    }
                }
            } while (auxiliar == 0);

            printf("Detalhes da encomenda %d\n", opcao);
            for (int i = 0; i < encomendas.encomenda[opcao - 1].contador; i++) {
                printf("Detalhes do/a %s\n", encomendas.encomenda[opcao - 1].movel[i].nome);
                printf("Dimensoes:%.1lfx%.1lfx%.1lf\n", encomendas.encomenda[opcao - 1].movel[i].comprimento,
                        encomendas.encomenda[opcao - 1].movel[i].largura, encomendas.encomenda[opcao - 1].movel[i].altura);
                printf("Material:\n");
                for (int m = 0; m < encomendas.encomenda[opcao - 1].movel[i].contador_materiais; m++) {
                    printf("-> %s\n", encomendas.encomenda[opcao - 1].movel[i].material[m].nomeMaterial);
                    printf("codigo: %s\n", encomendas.encomenda[opcao - 1].movel[i].material[m].codigoMaterial);
                    printf("Quantidade: %d\n\n", encomendas.encomenda[opcao - 1].movel[i].material[m].contador);
                }
            }
        } else {
            printf("\n");
        }
    }
}

int checkEncomendaCancelar(int numCliente, int numEncomenda, Encomendas encomendas) {
    int valor;
    if (numCliente == encomendas.encomenda[numEncomenda - 1].numeroCliente) {
        valor = 1;
    } else {
        valor = 0;
    }
    return valor;
}

//Ainda n esta a dar bem
void cancelarEncomenda(Encomendas *encomenda, int num) {
    int len;
    int tamanho = encomenda->contador - 1;
    if ((num - 1) != tamanho) {
        for (int i = num - 1; i < encomenda->contador - 1; i++) {
            encomenda->encomenda[i].contador = encomenda->encomenda[i + 1].contador;
            encomenda->encomenda[i].numeroCliente = encomenda->encomenda[i + 1].numeroCliente;
            encomenda->encomenda[i].preco = encomenda->encomenda[i + 1].preco;
            encomenda->encomenda[i].data.ano = encomenda->encomenda[i + 1].data.ano;
            encomenda->encomenda[i].data.mes = encomenda->encomenda[i + 1].data.mes;
            encomenda->encomenda[i].data.dia = encomenda->encomenda[i + 1].data.dia;
            encomenda->encomenda[i].dataEntrega.dia = encomenda->encomenda[i + 1].dataEntrega.dia;
            encomenda->encomenda[i].dataEntrega.mes = encomenda->encomenda[i + 1].dataEntrega.mes;
            encomenda->encomenda[i].dataEntrega.ano = encomenda->encomenda[i + 1].dataEntrega.ano;
            encomenda->encomenda[i].movel = (Movel *) realloc(encomenda->encomenda[i].movel, encomenda->encomenda[i + 1].contador * sizeof (Movel));
            for (int j = 0; j < encomenda->encomenda[i].contador; j++) {
                len = strlen(encomenda->encomenda[i + 1].movel[j].nome);
                encomenda->encomenda[i].movel[j].nome = (char *) realloc(encomenda->encomenda[i].movel[j].nome, len * sizeof (char));
                strcpy(encomenda->encomenda[i].movel[j].nome, encomenda->encomenda[i + 1].movel[j].nome);
                strcpy(encomenda->encomenda[i].movel[j].codigoProduto, encomenda->encomenda[i + 1].movel[j].codigoProduto);
                encomenda->encomenda[i].movel[j].quantidade = encomenda->encomenda[i + 1].movel[j].quantidade;
                encomenda->encomenda[i].movel[j].altura = encomenda->encomenda[i + 1].movel[j].altura;
                encomenda->encomenda[i].movel[j].comprimento = encomenda->encomenda[i + 1].movel[j].comprimento;
                encomenda->encomenda[i].movel[j].largura = encomenda->encomenda[i + 1].movel[j].largura;
                encomenda->encomenda[i].movel[j].preco = encomenda->encomenda[i + 1].movel[j].preco;
                encomenda->encomenda[i].movel[j].material = (Material *) realloc(encomenda->encomenda[i].movel[j].material, encomenda->encomenda[i + 1].movel[j].contador_materiais * sizeof (Material));
                for (int t = 0; t < encomenda->encomenda[i].movel[j].contador_materiais; t++) {
                    len = strlen(encomenda->encomenda[i + 1].movel[j].material[t].nomeMaterial);
                    encomenda->encomenda[i].movel[j].material[t].nomeMaterial = (char *) realloc(encomenda->encomenda[i].movel[j].material[t].nomeMaterial, len * sizeof (char));
                    strcpy(encomenda->encomenda[i].movel[j].material[t].nomeMaterial, encomenda->encomenda[i + 1].movel[j].material[t].nomeMaterial);
                    strcpy(encomenda->encomenda[i].movel[j].material[t].codigoMaterial, encomenda->encomenda[i + 1].movel[j].material[t].codigoMaterial);
                    encomenda->encomenda[i].movel[j].material[t].contador = encomenda->encomenda[i + 1].movel[j].material[t].contador;
                }
            }
        }
    }

    encomenda->encomenda[tamanho].numeroCliente = -1;
    encomenda->encomenda[tamanho].preco = -1;
    encomenda->encomenda[tamanho].data.dia = -1;
    encomenda->encomenda[tamanho].data.mes = -1;
    encomenda->encomenda[tamanho].data.ano = -1;
    encomenda->encomenda[tamanho].dataEntrega.dia = -1;
    encomenda->encomenda[tamanho].dataEntrega.mes = -1;
    encomenda->encomenda[tamanho].dataEntrega.ano = -1;
    for (int i = 0; i < encomenda->encomenda[tamanho].contador; i++) {
        free(encomenda->encomenda[tamanho].movel[i].nome);
        encomenda->encomenda[tamanho].movel[i].comprimento = -1;
        encomenda->encomenda[tamanho].movel[i].largura = -1;
        encomenda->encomenda[tamanho].movel[i].altura = -1;
        encomenda->encomenda[tamanho].movel[i].preco = -1;
        encomenda->encomenda[tamanho].movel[i].quantidade = -1;
        strcpy(encomenda->encomenda[tamanho].movel[i].codigoProduto, "000000");
        for (int j = 0; j < encomenda->encomenda[tamanho].movel[i].contador_materiais; j++) {
            free(encomenda->encomenda[tamanho].movel[i].material[j].nomeMaterial);
            encomenda->encomenda[tamanho].movel[i].material[j].contador = -1;
            strcpy(encomenda->encomenda[tamanho].movel[i].material[j].codigoMaterial, "000000");
        }
        encomenda->encomenda[tamanho].movel[i].contador_materiais = -1;
        free(encomenda->encomenda[tamanho].movel[i].material);
    }
    encomenda->encomenda[tamanho].contador = -1;
    free(encomenda->encomenda[tamanho].movel);
    encomenda->encomenda[tamanho].contador = -1;

    encomenda->contador--;
}

void materiaisSemana(Encomendas encomendas, Data data1, Data data2) {
    Materiais materiaisTemp = {.contador = 0};
    int valorData1, valorData2, entrega, len, n = 0;
    int pos = materiaisTemp.contador;
    valorData1 = (data1.ano * 10000) + (data1.mes * 100) + (data1.dia);
    valorData2 = (data2.ano * 10000) + (data2.mes * 100) + (data2.dia);



    if (encomendas.contador == 0) {
        printf("Sem encomendas\n");
    } else {
        for (int i = 0; i < encomendas.contador; i++) {
            entrega = (encomendas.encomenda[i].dataEntrega.ano * 10000) + (encomendas.encomenda[i].dataEntrega.mes * 100) + (encomendas.encomenda[i].dataEntrega.dia);
            if ((entrega <= valorData2 && entrega >= valorData1) || (entrega >= valorData2 && entrega <= valorData1)) {
                for (int j = 0; j < encomendas.encomenda[i].contador; j++) {
                    for (int t = 0; t < encomendas.encomenda[i].movel[j].contador_materiais; t++) {
                        if (materiaisTemp.contador == 0) {
                            materiaisTemp.material = (Material *) malloc((pos + 1) * sizeof (Material));
                            len = strlen(encomendas.encomenda[i].movel[j].material[t].nomeMaterial);
                            materiaisTemp.material[pos].nomeMaterial = (char *) malloc(len * sizeof (char));
                            strcpy(materiaisTemp.material[pos].nomeMaterial, encomendas.encomenda[i].movel[j].material[t].nomeMaterial);
                            strcpy(materiaisTemp.material[pos].codigoMaterial, encomendas.encomenda[i].movel[j].material[t].codigoMaterial);
                            materiaisTemp.material[pos].contador = encomendas.encomenda[i].movel[j].material[t].contador * encomendas.encomenda[i].movel[j].quantidade;
                            materiaisTemp.contador++;

                        } else if (materiaisTemp.contador != 0) {
                            for (int m = 0; m < materiaisTemp.contador; m++) {
                                if (strcmp(materiaisTemp.material[m].codigoMaterial, encomendas.encomenda[i].movel[j].material[t].codigoMaterial) == 0) {
                                    materiaisTemp.material[m].contador = materiaisTemp.material[m].contador + (encomendas.encomenda[i].movel[j].material[t].contador * encomendas.encomenda[i].movel[j].quantidade);
                                    n = 1;
                                }
                            }

                            if (n != 1) {
                                materiaisTemp.material = (Material *) realloc(materiaisTemp.material, (materiaisTemp.contador + 1) * sizeof (Material));
                                len = strlen(encomendas.encomenda[i].movel[j].material[t].nomeMaterial);
                                materiaisTemp.material[materiaisTemp.contador].nomeMaterial = (char *) malloc(len * sizeof (char));
                                strcpy(materiaisTemp.material[materiaisTemp.contador].nomeMaterial, encomendas.encomenda[i].movel[j].material[t].nomeMaterial);
                                strcpy(materiaisTemp.material[materiaisTemp.contador].codigoMaterial, encomendas.encomenda[i].movel[j].material[t].codigoMaterial);
                                materiaisTemp.material[materiaisTemp.contador].contador = encomendas.encomenda[i].movel[j].material[t].contador * encomendas.encomenda[i].movel[j].quantidade;
                                materiaisTemp.contador++;
                                n = 0;
                            }

                        }
                    }

                }
            }
        }
    }

    printf("Materiais precisos para a semanana entre %d-%d-%d a %d-%d-%d\n",
            data1.dia, data1.mes, data1.ano, data2.dia, data2.mes, data2.ano);
    printf("%d\n", materiaisTemp.contador);
    for (int i = 0; i < materiaisTemp.contador; i++) {
        printf("Nome:%s -> Codigo:%s\n", materiaisTemp.material[i].nomeMaterial, materiaisTemp.material[i].codigoMaterial);
        printf("Quantidade: %d\n", materiaisTemp.material[i].contador);
    }
    free(materiaisTemp.material);
}

void limparEncomendaTemp(Encomenda * encomendaTemp) {
    encomendaTemp->numeroCliente = -1;
    encomendaTemp->preco = -1;
    encomendaTemp->data.dia = -1;
    encomendaTemp->data.mes = -1;
    encomendaTemp->data.ano = -1;
    for (int i = 0; i < encomendaTemp->contador; i++) {
        free(encomendaTemp->movel[i].nome);
        encomendaTemp->movel[i].comprimento = -1;
        encomendaTemp->movel[i].largura = -1;
        encomendaTemp->movel[i].altura = -1;
        encomendaTemp->movel[i].preco = -1;
        encomendaTemp->movel[i].quantidade = -1;
        strcpy(encomendaTemp->movel[i].codigoProduto, "000000");
        for (int j = 0; j < encomendaTemp->movel[i].contador_materiais; j++) {
            free(encomendaTemp->movel[i].material[j].nomeMaterial);
            encomendaTemp->movel[i].material[j].contador = -1;
            strcpy(encomendaTemp->movel[i].material[j].codigoMaterial, "000000");
        }
        encomendaTemp->movel[i].contador_materiais = -1;
        free(encomendaTemp->movel[i].material);
    }
    encomendaTemp->contador = -1;
    free(encomendaTemp->movel);
    encomendaTemp->contador = -1;
}