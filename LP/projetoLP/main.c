/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * File:   main.c
 * Author: joao
 *
 * Created on 16 de dezembro de 2022, 17:23
 */

#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#include "encomenda.h"
#include "input.h"
#include "moveis.h"
#include "perfil.h"

#define ACESSO_GARANTIDO "Acesso garantido\n"
#define ACESSO_NEGADO "Acesso negado\n"
#define CONTA_ACESSADA "Entrou\n"
#define CONTA_INEXISTENTE "Conta inexistente\n"
#define CONTA_CRIADA "Conta criada com sucesso\n"

enum menuInicio {
    ENTRAR = 1,
    CRIAR_CONTA,
    SAIR
};

enum menuEntrar_CriarConta {
    SAIR1 = -1,
    RETROCEDER,
    ADMIN,
    CLIENTE,

};

enum menuAdmin {
    SAIR2 = -1,
    RETROCEDER1,
    CLIENTES,
    MOVEIS,
    PRODUCAO,
    GERIR
};

enum gerirCliente {
    SAIR3 = -1,
    RETROCEDER2,
    CRIAR,
    EDITAR,
    REMOVER_DESATIVAR,
    PROCURAR,
    LISTAR
};

enum gerirConta {
    SAIR4 = -1,
    RETROCEDER3,
    EDITAR1,
    APAGAR
};

enum menuCliente {
    SAIR5 = -1,
    RETROCEDER4,
    REGISTAR,
    MODIFICAR,
    CONSULTAR,
    DEFINICOES
};

enum {
    NOME = 1,
    NIF,
    PAIS,
    PASSWORD,
    DATA,
    MORADA
};

enum escolha {
    NOMEa = 1,
    PASSWORDa
};

int main(int argc, char **argv) {
    Clientes clientes = {.contador = 0};
    Admins admins = {.contador = 0};
    Encomendas encomendas = {.contador = 0};
    Moveis moveis = {.contador = 0};
    Materiais materiais = {.contador = 0};
    Materiais materiaisTemp = {.contador = 0};
    Encomenda encomendaTemp = {.contador = 0};

    FILE *fClientes, *fMateriais, *fAdmins;

    Data data1, data2;
    int opcao, opcao1, numeroAdmin, escolha, posAdmin, check, num, dAc, diaNascimento, mesNascimento, anoNascimento;
    int numEncomenda, resultadoCheckEncomenda;
    int nClientes, nMateriais, nAdmins;
    int posicaoCliente;
    int dia, mes, ano;

    char *nome2, codigoProduto[TAMANHO_CODIGO_PRODUTO];
    int pos, opcao3, quantidade, len;
    float comprimento, largura, altura, preco;
    bool codigoExistente, run3 = true;

    char *codigoAdmin, *password, *cMovel, nif[TAMANHO_NIF], nifNovo[TAMANHO_NIF], resposta, *nome, *apelido, *pais, *password1, *password2, *cidade, *rua, cPostal[TAMANHO_CODIGO_POSTAL], *password1A, *password2A;
    bool admin, run = true, resultado;

    bool run2 = true, novaEncomenda = true;
    int opcao2, posMovelEncomenda, diaAtual, mesAtual, anoAtual;

    time_t data_ano;
    time(&data_ano);
    struct tm *data = localtime(&data_ano);
    anoAtual = (*data).tm_year + 1900;

    iniciarFicheiro(fClientes, FICHEIRO_CLIENTES);
    iniciarFicheiro(fMateriais, FICHEIRO_MATERIAIS);
    iniciarFicheiro(fAdmins, FICHEIRO_ADMINS);

    nClientes = contarLinhas(fClientes, FICHEIRO_CLIENTES);
    nMateriais = contarLinhas(fMateriais, FICHEIRO_MATERIAIS);
    nAdmins = contarLinhas(fAdmins, FICHEIRO_ADMINS);

    if (nClientes > 0) {
        clientes.contador = nClientes;
        lerFicheiroClientes(&clientes, fClientes, nClientes, FICHEIRO_CLIENTES);
    }

    if (nMateriais > 0) {
        materiais.contador = nMateriais;
        lerFicheiroMateriais(&materiais, fMateriais, nMateriais, FICHEIRO_MATERIAIS);
    }

    if (nAdmins > 0) {
        admins.contador = nAdmins;
        lerFicheiroAdmins(&admins, fAdmins, nAdmins, FICHEIRO_ADMINS);
    }
    while (run) {
    ponto1:
        linha();
        printf("MOVEIS PARA TODOS\n");
        linha();

        printf(
            "[ 1 ] - Entrar\n"
            "[ 2 ] - Criar conta\n"
            "[ 3 ] - Sair\n");
        printf("\n");
        opcao = lerInt(1, 3, DIGITE_OPCAO);
        linha();
        switch (opcao) {
            case ENTRAR:

            ponto2:
                printf("Deseja entrar como: \n");
                printf("\n");
                printf(
                    "[ 1 ] - Admin\n"
                    "[ 2 ] - Cliente\n"
                    "[ 0 ] - Retroceder\n"
                    "[ -1 ] - Fechar\n");
                printf("\n");

                opcao = lerInt(-1, 2, DIGITE_OPCAO);
                linha();
                switch (opcao) {
                    case ADMIN:

                        lerIntSemLimite("Digite o seu numero de admin: ");

                        lerStringDinamica(&password, LER_PASSWORD);
                        linha();

                        resultado = verificarAdmins(admins, numeroAdmin, password);

                        if (resultado) {
                            printf(CONTA_ACESSADA);
                            linha();

                            for (int i = 0; i < admins.contador; i++) {
                                if (admins.admin[i].numeroAdmin == numeroAdmin) {
                                    posAdmin = i;
                                }
                            }

                            admin = true;
                        } else {
                            printf("Nao foi possivel acessar a sua conta\n");
                            linha();
                            admin = false;
                            goto ponto2;
                            continue;
                        }

                        break;

                    case CLIENTE:
                        lerString(nif, TAMANHO_NIF - 1, LER_NIF);
                        lerStringDinamica(&password, LER_PASSWORD);

                        resultado = verificarCliente(clientes, nif, password);

                        if (resultado) {
                            linha();
                            printf(CONTA_ACESSADA);
                            for (int j = 0; j < clientes.contador; j++) {
                                if (strcmp(clientes.cliente[j].nif, nif) == 0) {
                                    num = clientes.cliente[j].numeroCliente;
                                }
                            }
                            admin = false;
                        } else {
                            linha();
                            printf(CONTA_INEXISTENTE);
                            linha();
                            goto ponto2;
                        }
                        break;
                    case RETROCEDER:
                        goto ponto1;
                    case SAIR1:
                        run = false;
                        continue;
                        break;
                }
                break;
            case CRIAR_CONTA:

            ponto3:
                printf("Deseja criar conta como\n");
                printf("\n");
                printf(
                    "[ 1 ] - Admin\n"
                    "[ 2 ] - Cliente\n"
                    "[ 0 ] - Retroceder\n"
                    "[ -1 ] - Fechar\n");
                printf("\n");
                opcao = lerInt(-1, 2, DIGITE_OPCAO);
                linha();

                switch (opcao) {
                    case ADMIN:
                        lerStringDinamica(&codigoAdmin, "Digite a password de admin: ");
                        linha();
                        if (strcmp(codigoAdmin, PASS_ADMIN) == 0) {
                            printf(ACESSO_GARANTIDO);
                            linha();
                            criarAdmin(&admins);
                            linha();
                            printf(CONTA_CRIADA);
                            free(codigoAdmin);
                            goto ponto1;
                        } else {
                            printf(ACESSO_NEGADO);
                            linha();
                            goto ponto3;
                        }

                        continue;
                        break;

                    case CLIENTE:
                        criarCliente(&clientes);
                        printf(CONTA_CRIADA);
                        goto ponto1;
                        continue;
                        break;

                    case RETROCEDER:
                        goto ponto1;
                        break;

                    case SAIR1:
                        run = false;
                        continue;
                        break;
                }
                break;
            case SAIR:
                run = false;
                continue;
                break;
        }

        if (admin == true) {
        ponto4:
            printf("             MENU ADMIN                      \n");
            linha();
            printf(
                "[ 1 ] - Gestao de clientes\n"
                "[ 2 ] - Gestao dos moveis\n"
                "[ 3 ] - Gestao de producao\n"
                "[ 4 ] - Definicoes da conta\n"
                "[ 0 ] - Retroceder\n"
                "[ -1 ] - Fechar\n");
            printf("\n");
            opcao = lerInt(-1, 4, DIGITE_OPCAO);
            linha();
            switch (opcao) {
                case CLIENTES:
                ponto5:
                    printf("             GESTAO DE CLIENTES                      \n");
                    linha();
                    printf(
                        "[ 1 ] - Criar cliente\n"
                        "[ 2 ] - Editar cliente\n"
                        "[ 3 ] - Remover ou desativar/ativar cliente\n"
                        "[ 4 ] - Procurar dados do cliente\n"
                        "[ 5 ] - Listar todos os dados dos clientes\n"
                        "[ 0 ] - Retroceder\n"
                        "[ -1 ] - Fechar\n");
                    linha();
                    opcao1 = lerInt(-1, 5, DIGITE_OPCAO);
                    linha();

                    switch (opcao1) {
                        case CRIAR:
                            criarCliente(&clientes);
                            printf(CONTA_CRIADA);
                            linha();
                            goto ponto5;
                            break;

                        case EDITAR:
                            posicaoCliente = lerInt(0, 120000, "Introduza o numero do cliente que deseja alterar: ");
                            for (int i = 0; i < clientes.contador; i++) {
                                if (posicaoCliente == clientes.cliente[i].numeroCliente) {
                                    check = 1;
                                } else {
                                    check = 0;
                                }
                            }
                            if (check == 0) {
                                printf(CLIENTE_NAO_EXISTENTE);
                            } else {
                                printf("\n");
                                linha();
                                do {
                                    linha();
                                    printf("Escolha o que deseja alterar: \n");
                                    printf("\n");
                                    printf(
                                        "[ 1 ] - Nome e apelido\n"
                                        "[ 2 ] - NIF\n"
                                        "[ 3 ] - Pais\n"
                                        "[ 4 ] - Password\n"
                                        "[ 5 ] - Data de nascimento\n"
                                        "[ 6 ] - Morada\n");
                                    opcao = lerInt(1, 6, DIGITE_OPCAO);
                                    printf("\n");
                                    linha();

                                    switch (opcao) {
                                        case NOME:

                                            lerStringDinamica(&nome, LER_NOME);
                                            lerStringDinamica(&apelido, LER_APELIDO);

                                            editarNomeClientes(&clientes, posicaoCliente, nome, apelido);
                                            linha();
                                            break;
                                        case NIF:

                                            lerString(nifNovo, TAMANHO_NIF, LER_NIF);

                                            editarNIFClientes(&clientes, posicaoCliente, nifNovo);
                                            linha();
                                            break;
                                        case PAIS:

                                            lerStringDinamica(&pais, LER_PAIS);

                                            editarPaisClientes(&clientes, posicaoCliente, pais);
                                            linha();
                                            break;
                                        case PASSWORD:
                                            do {
                                                lerStringDinamica(&password1, "Digite a sua nova password [maximo 100 caracteres]: ");
                                                lerStringDinamica(&password2, "Confirme a nova password: ");

                                                if (strcmp(password1, password2) != 0) {
                                                    printf(PASSWORD_INCORRETA);
                                                }
                                            } while (strcmp(password1, password2) != 0);

                                            editarPasswordClientes(&clientes, posicaoCliente, password2);
                                            linha();
                                            break;
                                        case DATA:

                                            anoNascimento = lerInt(1900, anoAtual - 18, DIGITE_ANO_NASCIMENTO);
                                            mesNascimento = lerInt(1, 12, DIGITE_MES_NASCIMENTO);

                                            if (mesNascimento == 2) {
                                                if (anoNascimento % 4 == 0) {
                                                    lerInt(1, 29, DIGITE_DIA_NASCIMENTO);
                                                } else {
                                                    lerInt(1, 28, DIGITE_DIA_NASCIMENTO);
                                                }
                                            } else {
                                                if (mesNascimento <= 7) {
                                                    if (mesNascimento % 2 == 0) {
                                                        diaNascimento = lerInt(1, 30, DIGITE_DIA_NASCIMENTO);
                                                    } else {
                                                        diaNascimento = lerInt(1, 31, DIGITE_DIA_NASCIMENTO);
                                                    }
                                                } else {
                                                    if (mesNascimento % 2 == 0) {
                                                        diaNascimento = lerInt(1, 31, DIGITE_DIA_NASCIMENTO);
                                                    } else {
                                                        diaNascimento = lerInt(1, 30, DIGITE_DIA_NASCIMENTO);
                                                    }
                                                }
                                            }

                                            editarDataClientes(&clientes, posicaoCliente, diaNascimento, mesNascimento, anoNascimento);
                                            linha();
                                            break;
                                    }

                                    case MORADA:

                                        lerStringDinamica(&cidade, "Digite a sua cidade: ");
                                        lerStringDinamica(&rua, "Digite a sua rua e porta e|ou andar: ");
                                        lerString(cPostal, TAMANHO_CODIGO_POSTAL, "Digite o seu codigo postal: ");

                                        editarMoradaClientes(&clientes, posicaoCliente, cidade, rua, cPostal);
                                        linha();
                                        break;

                                        do {
                                            resposta = lerChar("Deseja alterar mais algo (s/S)(n/N)\n");
                                        } while (resposta != 's' && resposta != 'S' && resposta != 'n' && resposta != 'N');
                                } while (resposta == 'S' || resposta == 's');
                                printf("Conta atualizada com sucesso\n");
                            }
                            linha();
                            goto ponto5;
                            break;
                        case REMOVER_DESATIVAR:
                        ponto6:
                            printf("Deseja remover, desativar ou ativar o cliente?\n");
                            printf(
                                "[ 1 ] - Remover\n"
                                "[ 2 ] - Ativar\n"
                                "[ 3 ] - Desativar\n"
                                "[ 0 ] - Retroceder\n"
                                "[ -1 ] - Fechar\n");
                            opcao = lerInt(-1, 3, DIGITE_OPCAO);
                            linha();

                            switch (opcao) {
                                case -1:
                                    run = false;
                                    break;
                                case 0:
                                    goto ponto5;
                                    break;
                                case 1:
                                    posicaoCliente = lerInt(0, 120000, "Introduza o numero do cliente que deseja remover: ");
                                    check = posCliente(clientes, posicaoCliente);
                                    if (check == -1) {
                                        printf(CLIENTE_NAO_EXISTENTE);
                                        printf("\n");
                                    } else if ((checkEncomendas(posicaoCliente, encomendas)) == 1) {
                                        printf("O cliente tem encomendas em registo apenas sera possivel mudar o estado do seu perfil\n");
                                        linha();
                                        goto ponto6;
                                    } else {
                                        printf("\n");
                                        linha();
                                        removerCliente(&clientes, posicaoCliente);
                                        printf("Cliente removido com sucesso\n");
                                        linha();
                                        goto ponto6;
                                    }
                                    break;
                                case 2:
                                    posicaoCliente = lerInt(0, 120000, "Introduza o numero do cliente que deseja ativar: ");
                                    printf("\n");
                                    linha();
                                    dAc = desativarAtivarCliente(&clientes, posicaoCliente, ATIVO);
                                    if (dAc == -1) {
                                        printf(CLIENTE_NAO_EXISTENTE);
                                        printf("\n");
                                    } else if (dAc == 0) {
                                        printf("O cliente ja se encontra no estado atual\n");
                                        linha();
                                    } else if (dAc == 1) {
                                        printf("Alteracao de estado feita com sucesso\n");
                                        linha();
                                    }
                                    goto ponto6;
                                    break;

                                case 3:
                                    posicaoCliente = lerInt(0, 120000, "Introduza o numero do cliente que deseja desativar: ");
                                    printf("\n");
                                    linha();
                                    dAc = desativarAtivarCliente(&clientes, posicaoCliente, INATIVO);
                                    if (dAc == -1) {
                                        printf(CLIENTE_NAO_EXISTENTE);
                                        printf("\n");
                                        linha();
                                    } else if (dAc == 0) {
                                        printf("O cliente ja se encontra no estado atual\n");
                                        linha();
                                    } else if (dAc == 1) {
                                        printf("Alteracao de estado feita com sucesso\n");
                                        linha();
                                    }
                                    goto ponto6;
                                    break;
                            }

                            break;
                        case PROCURAR:

                            escolha = lerInt(0, 120000, "Introduza o numero do cliente que deseja procurar: ");
                            linha();
                            posicaoCliente = posCliente(clientes, escolha);
                            if (posicaoCliente == -1) {
                                printf("Cliente nao encontrado\n");
                            } else {
                                printf("Cliente encontrado\n");
                                printf("\n");
                                printf("Nome: %s     Apelido: %s    \n", clientes.cliente[posicaoCliente].nome, clientes.cliente[posicaoCliente].apelido);
                                printf("Numero de cliente: %d \n", clientes.cliente[posicaoCliente].numeroCliente);
                                printf("NIF: %s   \n", clientes.cliente[posicaoCliente].nif);
                                printf("Nascido a: %d/%d/%d  \n", clientes.cliente[posicaoCliente].data.dia,
                                       clientes.cliente[posicaoCliente].data.mes,
                                       clientes.cliente[posicaoCliente].data.ano);
                                printf("Morada: \n    Rua: %s \n    Codigo postal: %s \n    Cidade: %s     Pais: %s \n",
                                       clientes.cliente[posicaoCliente].morada.rua,
                                       clientes.cliente[posicaoCliente].morada.codigoPostal, clientes.cliente[posicaoCliente].morada.cidade, clientes.cliente[posicaoCliente].pais);
                            }
                            linha();
                            goto ponto5;
                            break;
                        case LISTAR:
                            listarClientes(clientes);
                            goto ponto5;
                            break;
                        case RETROCEDER2:
                            goto ponto4;
                            break;
                        case SAIR3:
                            run = false;
                            break;
                    }
                    break;

                case MOVEIS:
                ponto7:
                    printf("             GESTAO DOS MOVEIS                      \n");
                    linha();
                    printf(
                        "[ 1 ] - Adicionar movel\n"
                        "[ 2 ] - Editar movel\n"
                        "[ 3 ] - Remover movel\n"
                        "[ 4 ] - Listar dados dos moveis\n"
                        "[ 0 ] - Retroceder\n"
                        "[ -1 ] - Fechar\n");
                    linha();
                    opcao1 = lerInt(-1, 4, DIGITE_OPCAO);
                    linha();

                    switch (opcao1) {
                        case CRIAR:

                            do {
                                lerString(codigoProduto, TAMANHO_CODIGO_PRODUTO - 1, "Digite o codigo do produto: ");
                                codigoExistente = codigoExistenteMovel(moveis, codigoProduto);
                            } while (codigoExistente);

                            lerStringDinamica(&nome2, "Digite o nome do movel: ");

                            comprimento = lerFloatSemLimite("Digite o comprimento: ");

                            largura = lerFloatSemLimite("Digite a largura: ");

                            altura = lerFloatSemLimite("Digite a altura: ");

                            preco = lerFloatSemLimite("Digite o preco: ");

                            // Alocar memoria para materiais
                            if (materiaisTemp.contador == 0) {
                                materiaisTemp.material = (Material *)malloc(INCREMENTO * sizeof(Material));
                            } else {
                                if (materiaisTemp.contador % 10 == 0) {
                                    materiaisTemp.material = (Material *)realloc(materiaisTemp.material, (materiaisTemp.contador + INCREMENTO) * sizeof(Material));
                                }
                            }

                            while (run3) {
                                pos = materiaisTemp.contador;
                                for (int i = 0; i < materiais.contador; i++) {
                                    printf("[ %d ] - %s\n", i, materiais.material[i].nomeMaterial);
                                }
                                printf("[ %d ] - Cancelar\n", materiais.contador);

                                opcao3 = lerInt(0, materiais.contador, "Digite a sua opcao: ");

                                if (opcao3 != materiais.contador) {
                                    quantidade = lerIntSemLimite("Digite a quantidede desejada: ");
                                    materiaisTemp.material[pos].contador = quantidade;
                                    len = strlen(materiais.material[opcao3].nomeMaterial);
                                    materiaisTemp.material[pos].nomeMaterial = (char *)malloc(len * sizeof(char));

                                    strcpy(materiaisTemp.material[pos].nomeMaterial, materiais.material[opcao3].nomeMaterial);
                                    strcpy(materiaisTemp.material[pos].codigoMaterial, materiais.material[opcao3].codigoMaterial);
                                    materiaisTemp.contador++;
                                } else if (opcao3 == materiais.contador) {
                                    run3 = false;
                                }
                            }

                            criarMovel(&moveis, materiaisTemp, nome, preco, comprimento, largura, altura, codigoProduto);
                            limparMateriais(&materiaisTemp);

                            printf("Movel adicionado\n");
                            linha();
                            goto ponto7;
                            break;

                        case EDITAR:
                            do {
                                editarMovel(&moveis);
                                printf("\n");
                                do {
                                    resposta = lerChar("Deseja alterar mais algo (s/S)(n/N)\n");
                                } while (resposta != 's' && resposta != 'S' && resposta != 'n' && resposta != 'N');
                            } while (resposta == 'S' || resposta == 's');
                            printf("Movel atualizado com sucesso\n");
                            linha();
                            goto ponto7;
                            break;

                        case REMOVER_DESATIVAR:
                            lerStringDinamica(&cMovel, "Digite o codigo do produto: ");

                            eliminarMovel(&moveis, cMovel);
                            printf("Movel eliminado com sucesso\n");
                            linha();
                            goto ponto7;
                            break;
                        case PROCURAR:
                            listarMovel(moveis);
                            goto ponto7;
                            break;
                        case RETROCEDER2:
                            goto ponto4;
                            break;
                        case SAIR3:
                            run = false;
                            break;
                    }
                    break;
                case PRODUCAO:
                ponto8:
                    printf("             GESTAO DE PRODUCAO                      \n");
                    linha();
                    printf(
                        "[ 1 ] - Ver todas as encomendas\n"
                        "[ 2 ] - Criar material\n"
                        "[ 3 ] - Ver material necessario para uma semana\n"
                        "[ 0 ] - Retroceder\n"
                        "[ -1 ] - Fechar\n");
                    opcao1 = lerInt(-1, 3, DIGITE_OPCAO);
                    linha();
                    switch (opcao1) {
                        case -1:
                            run = false;
                            break;
                        case 0:
                            goto ponto7;
                            break;
                        case 1:
                            listarEncomendas(encomendas, clientes);
                            linha();
                            goto ponto8;
                            break;
                        case 2:
                            criarMaterial(&materiais);
                            linha();
                            goto ponto8;
                            break;
                        case 3:
                            printf("Deseja ver o material preciso entre que datas:\n");
                            printf("Data 1:\n");
                            ano = lerInt(2000, 2023, "Ano:");
                            mes = lerInt(1, 12, "Mes:");
                            if (mes == 2) {
                                if (ano % 4 == 0) {
                                    dia = lerInt(1, 29, "Dia:");
                                } else {
                                    dia = lerInt(1, 28, "Dia:");
                                }
                            } else {
                                if (mes <= 7) {
                                    if (mes % 2 == 0) {
                                        dia = lerInt(1, 30, "Dia:");
                                    } else {
                                        dia = lerInt(1, 31, "Dia:");
                                    }
                                } else {
                                    if (mes % 2 == 0) {
                                        dia = lerInt(1, 31, "Dia:");
                                    } else {
                                        dia = lerInt(1, 30, "Dia:");
                                    }
                                }
                            }

                            data1.dia = dia;
                            data1.mes = mes;
                            data1.ano = ano;

                            printf("Data 2:\n");
                            ano = lerInt(2000, 2023, "Ano:");
                            mes = lerInt(1, 12, "Mes:");
                            if (mes == 2) {
                                if (ano % 4 == 0) {
                                    dia = lerInt(1, 29, "Dia:");
                                } else {
                                    dia = lerInt(1, 28, "Dia:");
                                }
                            } else {
                                if (mes <= 7) {
                                    if (mes % 2 == 0) {
                                        dia = lerInt(1, 30, "Dia:");
                                    } else {
                                        dia = lerInt(1, 31, "Dia:");
                                    }
                                } else {
                                    if (mes % 2 == 0) {
                                        dia = lerInt(1, 31, "Dia:");
                                    } else {
                                        dia = lerInt(1, 30, "Dia:");
                                    }
                                }
                            }

                            data2.dia = dia;
                            data2.mes = mes;
                            data2.ano = ano;

                            materiaisSemana(encomendas, data1, data2);
                            linha();
                            goto ponto8;
                            break;
                    }
                case GERIR:
                ponto9:
                    printf("             DEFINICOES DA CONTA                      \n");
                    linha();

                    printf(
                        "[ 1 ] - Editar conta\n"
                        "[ 2 ] - Apagar conta\n"
                        "[ 0 ] - Retroceder\n"
                        "[ -1 ] - Fechar\n");
                    linha();
                    opcao1 = lerInt(-1, 2, DIGITE_OPCAO);
                    linha();

                    switch (opcao1) {
                        case EDITAR1:

                            printf("Dados atuais:\n");
                            printf("Numero de admin: %d\n", admins.admin[posAdmin].numeroAdmin);
                            printf("Nome:%s\n", admins.admin[posAdmin].nome);
                            printf("Apelido:%s\n", admins.admin[posAdmin].apelido);
                            printf("Password:%s\n", admins.admin[posAdmin].password);
                            linha();

                            do {
                                printf("Escolha o que deseja alterar: \n");
                                printf(
                                    "[ 1 ] - Nome e apelido\n"
                                    "[ 2 ] - Password\n");
                                linha();
                                opcao = lerInt(1, 2, DIGITE_OPCAO);
                                linha();

                                switch (opcao) {
                                    case NOMEa:
                                        lerStringDinamica(&nome, LER_NOME);
                                        lerStringDinamica(&apelido, LER_APELIDO);

                                        editarDadosPessoaisAdminNome(posAdmin, &admins, nome, apelido);
                                        break;
                                    case PASSWORDa:

                                        do {
                                            lerStringDinamica(&password1A, "Digite a sua nova password [maximo 100 caracteres]: ");
                                            lerStringDinamica(&password2A, "Confirme a nova password: ");

                                            if (strcmp(password1A, password2A) != 0) {
                                                printf(PASSWORD_INCORRETA);
                                            }
                                        } while (strcmp(password1A, password2A) != 0);

                                        editarDadosPessoaisAdminPassword(posAdmin, &admins, password2A);
                                        break;
                                }
                                do {
                                    resposta = lerChar("Deseja alterar mais algo (s/S)(n/N)\n");
                                } while (resposta != 's' && resposta != 'S' && resposta != 'n' && resposta != 'N');
                            } while (resposta == 'S' || resposta == 's');
                            printf("Conta atualizada com sucesso\n");
                            linha();
                            goto ponto9;
                            break;

                        case APAGAR:
                            removerAdmin(&admins, numeroAdmin);
                            linha();
                            printf("Conta removida com sucesso\n");
                            goto ponto1;
                            break;

                        case RETROCEDER3:
                            goto ponto4;
                            break;

                        case SAIR4:
                            run = false;
                            break;
                    }

                case RETROCEDER1:
                    goto ponto1;
                    break;

                case SAIR2:
                    run = false;
                    break;
            }
        } else {
            linha();
        ponto10:
            printf("             MENU CLIENTE                      \n");

            linha();
            printf(
                "[ 1 ] - Registar encomendas\n"
                "[ 2 ] - Eliminar encomendas\n"
                "[ 3 ] - Consultar informacoes acerca de encomendas\n"
                "[ 4 ] - Definicoes da conta\n"
                "[ 0 ] - Retroceder\n"
                "[ -1 ] - Fechar\n");
            printf("\n");
            opcao = lerInt(-1, 4, DIGITE_OPCAO);
            linha();

            switch (opcao) {
                case REGISTAR:
                    while (run2) {
                        for (int i = 0; i < moveis.contador; i++) {
                            printf("[ %d ] - %s\n", i, moveis.movel[i].nome);
                        }
                        printf("[ %d ] - Cancelar\n", moveis.contador);

                        opcao = lerInt(0, moveis.contador, "Digite a sua opcao: ");

                        if (opcao != moveis.contador) {
                            if (novaEncomenda) {
                                encomendaTemp.contador = 0;
                            }

                            posMovelEncomenda = encomendaTemp.contador;

                            if (posMovelEncomenda == 0) {
                                encomendaTemp.movel = (Movel *)malloc((posMovelEncomenda + 1) * sizeof(Movel));
                            } else {
                                encomendaTemp.movel = (Movel *)realloc(encomendaTemp.movel, (posMovelEncomenda + 1) * sizeof(Movel));
                            }

                            strcpy(encomendaTemp.movel[posMovelEncomenda].codigoProduto, moveis.movel[opcao].codigoProduto);

                            len = strlen(moveis.movel[opcao].nome);

                            encomendaTemp.movel[posMovelEncomenda].nome = (char *)malloc(len * sizeof(char));
                            strcpy(encomendaTemp.movel[posMovelEncomenda].nome, moveis.movel[opcao].nome);

                            encomendaTemp.movel[posMovelEncomenda].contador_materiais = moveis.movel[opcao].contador_materiais;
                            encomendaTemp.movel[posMovelEncomenda].comprimento = moveis.movel[opcao].comprimento;
                            encomendaTemp.movel[posMovelEncomenda].largura = moveis.movel[opcao].largura;
                            encomendaTemp.movel[posMovelEncomenda].altura = moveis.movel[opcao].altura;

                            encomendaTemp.movel[posMovelEncomenda].material = (Material *)malloc(encomendaTemp.movel[posMovelEncomenda].contador_materiais * sizeof(Material));
                            for (int i = 0; i < encomendaTemp.movel[posMovelEncomenda].contador_materiais; i++) {
                                len = strlen(moveis.movel[opcao].material[i].nomeMaterial);
                                encomendaTemp.movel[posMovelEncomenda].material[i].nomeMaterial = (char *)malloc(len * sizeof(char));

                                strcpy(encomendaTemp.movel[posMovelEncomenda].material[i].nomeMaterial, moveis.movel[opcao].material[i].nomeMaterial);
                                strcpy(encomendaTemp.movel[posMovelEncomenda].material[i].codigoMaterial, moveis.movel[opcao].material[i].codigoMaterial);
                                encomendaTemp.movel[posMovelEncomenda].material[i].contador = moveis.movel[opcao].material[i].contador;
                            }

                            quantidade = lerInt(0, 1000, "Digite a quantidade que deseja: ");

                            encomendaTemp.movel[posMovelEncomenda].quantidade = quantidade;
                            encomendaTemp.preco += moveis.movel[opcao].preco * quantidade;
                            encomendaTemp.numeroCliente = num;

                            diaAtual = (*data).tm_mday;
                            mesAtual = (*data).tm_mon + 1;
                            anoAtual = (*data).tm_year + 1900;

                            encomendaTemp.data.dia = diaAtual;
                            encomendaTemp.data.mes = mesAtual;
                            encomendaTemp.data.ano = anoAtual;

                            encomendaTemp.contador++;

                            printf(
                                "[ 1 ] - Adicionar movel a encomenda\n"
                                "[ 2 ] - Confirmar encomenda\n");
                            opcao2 = lerInt(1, 2, "Digite a sua opcao: ");

                            if (opcao2 == 1) {
                                novaEncomenda = false;
                                continue;
                            } else {
                                printf("O custo da encomenda e: %f\n", encomendaTemp.preco);
                                printf(
                                    "[ 1 ] - Confirmar pagamento\n"
                                    "[ 2 ] - Cancelar encomenda\n");
                                opcao2 = lerInt(1, 2, "Digite a sua opcao: ");
                                if (opcao2 == 1) {
                                    run2 = false;
                                    criarEncomenda(&encomendas, &materiais, encomendaTemp);
                                } else {
                                    printf(OPERACAO_CANCELADA);
                                }
                            }
                        } else {
                            run2 = false;
                        }
                    }

                    limparEncomendaTemp(&encomendaTemp);

                    linha();
                    goto ponto10;
                    break;
                case MODIFICAR:
                    if (encomendas.contador > 0) {
                        listarEncomendasCliente(num, encomendas, moveis);
                        printf("Numero da encomenda que deseja cancelar:");
                        scanf("%d", &numEncomenda);
                        resultadoCheckEncomenda = checkEncomendaCancelar(num, numEncomenda, encomendas);
                        if (resultado == 0) {
                            printf("Encomenda nao existe\nImpossivel de cancelar\n");
                        } else {
                            printf("Tem a certeza que quer cancelar a encomenda\n");
                            printf("[ 1 ] - Sim\n[ 2 ] - Nao\n");
                            opcao = lerInt(1, 2, "Opcao:");
                            if (opcao == 1) {
                                cancelarEncomenda(&encomendas, numEncomenda);
                                printf("Encomenda cancelada\n");
                            }
                        }
                        linha();
                    } else {
                        printf("Nao existem encomendas\n");
                    }
                    linha();
                    goto ponto10;
                    break;
                case CONSULTAR:
                    if (encomendas.contador > 0) {
                        listarEncomendasCliente(num, encomendas, moveis);
                    } else {
                        printf("Nao existem encomendas\n");
                    }
                    linha();
                    goto ponto10;
                    break;
                case DEFINICOES:
                ponto11:
                    printf("             DEFINICOES DA CONTA                      \n");
                    linha();
                    printf(
                        "[ 1 ] - Editar perfil\n"
                        "[ 2 ] - Remover ou desativar/ativar perfil\n"
                        "[ 0 ] - Retroceder\n"
                        "[ -1 ] - Fechar\n");
                    printf("\n");
                    opcao1 = lerInt(-1, 4, DIGITE_OPCAO);
                    linha();
                    switch (opcao1) {
                        case 1:
                            do {
                                linha();
                                printf("Escolha o que deseja alterar: \n");
                                printf("\n");
                                printf(
                                    "[ 1 ] - Nome e apelido\n"
                                    "[ 2 ] - NIF\n"
                                    "[ 3 ] - Pais\n"
                                    "[ 4 ] - Password\n"
                                    "[ 5 ] - Data de nascimento\n"
                                    "[ 6 ] - Morada\n");
                                printf("\n");
                                opcao = lerInt(1, 6, DIGITE_OPCAO);
                                linha();

                                switch (opcao) {
                                    case NOME:

                                        lerStringDinamica(&nome, LER_NOME);
                                        lerStringDinamica(&apelido, LER_APELIDO);

                                        editarNomeClientes(&clientes, num, nome, apelido);
                                        linha();
                                        break;
                                    case NIF:

                                        lerString(nifNovo, TAMANHO_NIF, LER_NIF);

                                        editarNIFClientes(&clientes, num, nifNovo);
                                        linha();
                                        break;
                                    case PAIS:

                                        lerStringDinamica(&pais, LER_PAIS);

                                        editarPaisClientes(&clientes, num, pais);
                                        linha();
                                        break;
                                    case PASSWORD:
                                        do {
                                            lerStringDinamica(&password1, "Digite a sua nova password [maximo 100 caracteres]: ");
                                            lerStringDinamica(&password2, "Confirme a nova password: ");

                                            if (strcmp(password1, password2) != 0) {
                                                printf(PASSWORD_INCORRETA);
                                            }
                                        } while (strcmp(password1, password2) != 0);

                                        editarPasswordClientes(&clientes, num, password);
                                        linha();
                                        break;
                                    case DATA:

                                        anoNascimento = lerInt(1900, anoAtual - 18, DIGITE_ANO_NASCIMENTO);
                                        mesNascimento = lerInt(1, 12, DIGITE_MES_NASCIMENTO);

                                        if (mesNascimento == 2) {
                                            if (anoNascimento % 4 == 0) {
                                                lerInt(1, 29, DIGITE_DIA_NASCIMENTO);
                                            } else {
                                                lerInt(1, 28, DIGITE_DIA_NASCIMENTO);
                                            }
                                        } else {
                                            if (mesNascimento <= 7) {
                                                if (mesNascimento % 2 == 0) {
                                                    diaNascimento = lerInt(1, 30, DIGITE_DIA_NASCIMENTO);
                                                } else {
                                                    diaNascimento = lerInt(1, 31, DIGITE_DIA_NASCIMENTO);
                                                }
                                            } else {
                                                if (mesNascimento % 2 == 0) {
                                                    diaNascimento = lerInt(1, 31, DIGITE_DIA_NASCIMENTO);
                                                } else {
                                                    diaNascimento = lerInt(1, 30, DIGITE_DIA_NASCIMENTO);
                                                }
                                            }
                                        }

                                        editarDataClientes(&clientes, num, diaNascimento, mesNascimento, anoNascimento);
                                        linha();
                                        break;
                                    case MORADA:

                                        lerStringDinamica(&cidade, "Digite a sua cidade: ");
                                        lerStringDinamica(&rua, "Digite a sua rua e porta e|ou andar: ");
                                        lerString(cPostal, TAMANHO_CODIGO_POSTAL, "Digite o seu codigo postal: ");

                                        editarMoradaClientes(&clientes, num, cidade, rua, cPostal);
                                        linha();
                                        break;
                                }
                                do {
                                    resposta = lerChar("Deseja alterar mais algo (s/S)(n/N)\n");
                                } while (resposta != 's' && resposta != 'S' && resposta != 'n' && resposta != 'N');
                            } while (resposta == 'S' || resposta == 's');
                            printf("Conta atualizada com sucesso\n");
                            linha();
                            goto ponto11;
                            break;
                        case 2:
                        ponto12:
                            printf("Deseja remover, desativar ou ativar o cliente?\n");
                            printf(
                                "[ 1 ] - Remover\n"
                                "[ 2 ] - Ativar\n"
                                "[ 3 ] - Desativar\n"
                                "[ 0 ] - Retroceder\n"
                                "[ -1 ] - Fechar\n");
                            opcao = lerInt(-1, 3, DIGITE_OPCAO);
                            linha();

                            switch (opcao) {
                                case -1:
                                    run = false;
                                    break;
                                case 0:
                                    goto ponto11;
                                    break;
                                case 1:
                                    check = posCliente(clientes, num);
                                    if (check == -1) {
                                        printf(CLIENTE_NAO_EXISTENTE);
                                        printf("\n");
                                    } else if ((checkEncomendas(num, encomendas)) == 1) {
                                        printf("Tem encomendas em registo apenas sera possivel mudar o estado do seu perfil\n");
                                        linha();
                                        goto ponto12;
                                    } else {
                                        printf("\n");
                                        linha();
                                        removerCliente(&clientes, num);
                                        printf("Cliente removido com sucesso\n");
                                        goto ponto1;
                                    }
                                    break;
                                case 2:
                                    printf("\n");
                                    linha();
                                    desativarAtivarCliente(&clientes, num, ATIVO);
                                    linha();
                                    goto ponto12;
                                    break;

                                case 3:
                                    printf("\n");
                                    linha();
                                    desativarAtivarCliente(&clientes, num, INATIVO);
                                    linha();
                                    goto ponto12;
                                    break;
                            }
                            break;
                        case 0:
                            goto ponto10;
                            break;
                        case -1:
                            run = false;
                            break;
                    }

                case RETROCEDER4:
                    goto ponto1;
                    break;
                case SAIR5:
                    run = false;
                    break;
            }
        }
    }
    printf("Deseja guardar os dados?\n");
    printf(
        "[ 0 ] - Guardar\n"
        "[ 1 ] - Nao Guardar\n");
    opcao = lerInt(0, 1, "Digite a sua opcao: ");
    if (opcao == 0) {
        escreverFicheiroClientes(clientes, fClientes, FICHEIRO_CLIENTES);
        escreverFicheiroMateriais(materiais, fAdmins, FICHEIRO_MATERIAIS);
        escreverFicheiroAdmins(admins, fAdmins, FICHEIRO_ADMINS);
        printf("Dados guardados\n");
    }
    linha();

    free(clientes.cliente);
    free(admins.admin);

    return (EXIT_SUCCESS);
}
