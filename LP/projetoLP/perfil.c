#include "perfil.h"

#include <ctype.h>
#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#include "input.h"

// Tem printf
void criarCliente(Clientes *clientes) {
    char nif[9];
    int anoAtual, anoNascimento, diaNascimento, mesNascimento;
    char *password;
    int pos = (*clientes).contador;

    time_t data_ano;  // time_t é um tipo de variavel especifica para receber datas
    time(&data_ano);  // funcao time vai atribuir a data_ano a data atual

    struct tm *data = localtime(&data_ano);  // funcao localtime vai formatar data_ano de modo a que possar ser atribuida a uma struct
                                             // struct essa que está definida na biblioteca time.h

    anoAtual = (*data).tm_year + 1900;  // temos de adicionar 1900 pois a funcao apenas nos da o nº de anos depois de 1900

    // Alocamos o espaço necessário na memória

    if (pos == 0) {
        (*clientes).cliente = (Cliente *)malloc((pos + 1) * sizeof(Cliente));
    } else {
        (*clientes).cliente = (Cliente *)realloc((*clientes).cliente, (pos + 1) * sizeof(Cliente));
    }

    // Receber o pais

    lerStringDinamica(&((*clientes).cliente[pos].pais), "Digite o seu pais: ");

    // Receber o NIF

    lerString((*clientes).cliente[pos].nif, TAMANHO_NIF - 1, "Digite o seu nif: ");

    // Receber o nome

    lerStringDinamica(&((*clientes).cliente[pos].nome), "Digite o seu nome: ");
    lerStringDinamica(&((*clientes).cliente[pos].apelido), "Digite o seu apelido: ");

    // Receber data de nascimento

    anoNascimento = lerInt(0, anoAtual, DIGITE_ANO_NASCIMENTO);
    mesNascimento = lerInt(1, 12, DIGITE_MES_NASCIMENTO);

    // Para receber o dia de nascimento temos de ter em conta anos bissextos e meses com dias diferentes

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

    (*clientes).cliente[pos].data.dia = diaNascimento;
    (*clientes).cliente[pos].data.mes = mesNascimento;
    (*clientes).cliente[pos].data.ano = anoNascimento;

    // Receber a morada

    lerStringDinamica(&((*clientes).cliente[pos].morada.cidade), "Digite a sua cidade: ");
    lerStringDinamica(&((*clientes).cliente[pos].morada.rua), "Digite a sua rua: ");
    lerStringDinamica(&((*clientes).cliente[pos].morada.numeroPorta), "Digite a sua porta e|ou numero de andar: ");
    lerString((*clientes).cliente[pos].morada.codigoPostal, TAMANHO_CODIGO_POSTAL - 1, "Digite o seu codigo postal: ");

    // Receber password

    do {
        lerStringDinamica(&password, "Digite a sua password [maximo 100 caracteres]: ");
        lerStringDinamica(&((*clientes).cliente[pos].password), "Confirme a sua password: ");

        if (strcmp(password, (*clientes).cliente[pos].password) != 0) {
            printf(PASSWORD_INCORRETA);
        }
    } while (strcmp(password, (*clientes).cliente[pos].password) != 0);

    (*clientes).cliente[pos].numeroCliente = pos;

    (*clientes).cliente[pos].estado = ATIVO;

    (*clientes).contador++;
}

void listarClientes(Clientes clientes) {
    int i;
    for (i = 0; i < clientes.contador; i++) {
        linha();
        printf("CLIENTE NUMERO: %d\n", clientes.cliente[i].numeroCliente);
        printf("NOME:%s\n", clientes.cliente[i].nome);
        printf("APELIDO:%s\n", clientes.cliente[i].apelido);
        printf("PAIS:%s\n", clientes.cliente[i].pais);
        printf("NIF:%s\n", clientes.cliente[i].nif);
        printf("DATA DE NASCIMENTO (DIA-MES-ANO):%d-%d-%d\n", clientes.cliente[i].data.dia,
               clientes.cliente[i].data.mes,
               clientes.cliente[i].data.ano);
        printf("CIDADE:%s\n", clientes.cliente[i].morada.cidade);
        printf("RUA:%s\n", clientes.cliente[i].morada.rua);
        printf("CODIGO POSTAL:%s\n", clientes.cliente[i].morada.codigoPostal);
        printf("PASSWORD:%s\n", clientes.cliente[i].password);
        linha();
    }
}

void listarAdmins(Admins admins) {
    int i;
    for (i = 0; i < admins.contador; i++) {
        printf("ADMIN NUMERO: %d\n", admins.admin[i].numeroAdmin);
        printf("NOME:%s\n", admins.admin[i].nome);
        printf("APELIDO:%s\n", admins.admin[i].apelido);
        linha();
    }
}

bool verificarCliente(Clientes cliente, char nif[9], char *password) {
    int numeroClientes = cliente.contador;
    for (int i = 0; i < numeroClientes; i++) {
        if (strcmp(cliente.cliente[i].nif, nif) == 0 && strcmp(cliente.cliente[i].password, password) == 0) {
            return true;
        }
    }
    return false;
}

bool verificarAdmins(Admins admin, int numeroAdmin, char *password) {
    int numeroAdmins = admin.contador;

    for (int i = 0; i < numeroAdmins; i++) {
        if (admin.admin[i].numeroAdmin == numeroAdmin && strcmp(admin.admin[i].password, password) == 0) {
            return true;
        }
    }
    return false;
}

// Tem printf
void criarAdmin(Admins *admin) {
    int pos = (*admin).contador;
    char *password;

    if (pos == 0) {
        (*admin).admin = (Admin *)malloc((pos + 1) * sizeof(Admin));
    } else {
        (*admin).admin = (Admin *)realloc((*admin).admin, (pos + 1) * sizeof(Admin));
    }

    lerStringDinamica(&((*admin).admin[pos].nome), LER_NOME);
    lerStringDinamica(&((*admin).admin[pos].apelido), LER_APELIDO);

    do {
        lerStringDinamica(&password, LER_PASSWORD);
        lerStringDinamica(&((*admin).admin[pos].password), CONFIRMAR_PASSWORD);

        if (strcmp(password, (*admin).admin[pos].password) != 0) {
            printf(PASSWORD_INCORRETA);
        }
    } while (strcmp(password, (*admin).admin[pos].password) != 0);

    (*admin).admin[pos].numeroAdmin = pos + 1;

    (*admin).contador++;
}

int procurarCliente(int nCliente, Clientes cliente) {
    int numeroCliente = cliente.contador;

    for (int i = 0; i < numeroCliente; i++) {
        if (nCliente == cliente.cliente[i].numeroCliente) {
            return i;
        }
    }
    return -1;
}

int procurarAdmin(int nAdmin, Admins admin) {
    int numeroAdmin = admin.contador;

    for (int i = 0; i < numeroAdmin; i++) {
        if (nAdmin == admin.admin[i].numeroAdmin) {
            return i;
        }
    }
    return -1;
}

int posCliente(Clientes clientes, int numeroCliente) {
    for (int i = 0; i < clientes.contador; i++) {
        if (clientes.cliente[i].numeroCliente == numeroCliente) {
            return i;
        }
    }

    return -1;
}

int posAdmin(Admins admins, int numAdmins) {
    for (int i = 0; i < admins.contador; i++) {
        if (admins.admin[i].numeroAdmin == numAdmins) {
            return i;
        }
    }

    return -1;
}

void removerAdmin(Admins *admins, int numeroAdmin) {
    int pos = posAdmin((*admins), numeroAdmin);
    int len;
    int tamanho = admins->contador - 1;

    if (pos == -1) {
        printf(ADMIN_NAO_EXISTENTE);
    } else {
        // Verificamos se so existe um movel
        if (pos != tamanho) {
            for (int i = pos; i < tamanho; i++) {
                admins->admin[i].numeroAdmin = admins->admin[i + 1].numeroAdmin;

                len = strlen(admins->admin[i + 1].password);
                admins->admin[i].password = (char *)realloc(admins->admin[i].password, len * sizeof(char));
                strcpy(admins->admin[i].password, admins->admin[i + 1].password);

                len = strlen(admins->admin[i + 1].nome);
                admins->admin[i].nome = (char *)realloc(admins->admin[i].nome, len * sizeof(char));
                strcpy(admins->admin[i].nome, admins->admin[i + 1].nome);

                len = strlen(admins->admin[i + 1].apelido);
                admins->admin[i].apelido = (char *)realloc(admins->admin[i].apelido, len * sizeof(char));
                strcpy(admins->admin[i].apelido, admins->admin[i + 1].apelido);
            }
        }

        free(admins->admin[tamanho].password);
        free(admins->admin[tamanho].nome);
        free(admins->admin[tamanho].apelido);

        admins->admin[tamanho].numeroAdmin = -1;

        admins->contador--;
    }
}

void removerCliente(Clientes *clientes, int numeroCliente) {
    int pos = posCliente((*clientes), numeroCliente);
    int len;
    int tamanho = clientes->contador - 1;

    if (pos == -1) {
        printf(CLIENTE_NAO_EXISTENTE);
    } else {
        if (pos != tamanho) {
            for (int i = pos; i < tamanho; i++) {
                clientes->cliente[i].numeroCliente = clientes->cliente[i + 1].numeroCliente;
                clientes->cliente[i].data.dia = clientes->cliente[i + 1].data.dia;
                clientes->cliente[i].data.mes = clientes->cliente[i + 1].data.mes;
                clientes->cliente[i].data.ano = clientes->cliente[i + 1].data.ano;
                clientes->cliente[i].estado = clientes->cliente[i + 1].estado;

                len = strlen(clientes->cliente[i + 1].pais);
                clientes->cliente[i].pais = (char *)realloc(clientes->cliente[i].pais, len * sizeof(char));
                strcpy(clientes->cliente[i].pais, clientes->cliente[i + 1].pais);

                len = strlen(clientes->cliente[i + 1].password);
                clientes->cliente[i].password = (char *)realloc(clientes->cliente[i].password, len * sizeof(char));
                strcpy(clientes->cliente[i].password, clientes->cliente[i + 1].password);

                len = strlen(clientes->cliente[i + 1].nome);
                clientes->cliente[i].nome = (char *)realloc(clientes->cliente[i].nome, len * sizeof(char));
                strcpy(clientes->cliente[i].nome, clientes->cliente[i + 1].nome);

                len = strlen(clientes->cliente[i + 1].apelido);
                clientes->cliente[i].apelido = (char *)realloc(clientes->cliente[i].apelido, len * sizeof(char));
                strcpy(clientes->cliente[i].apelido, clientes->cliente[i + 1].apelido);

                len = strlen(clientes->cliente[i + 1].morada.cidade);
                clientes->cliente[i].morada.cidade = (char *)realloc(clientes->cliente[i].morada.cidade, len * sizeof(char));
                strcpy(clientes->cliente[i].morada.cidade, clientes->cliente[i + 1].morada.cidade);

                len = strlen(clientes->cliente[i + 1].morada.rua);
                clientes->cliente[i].morada.rua = (char *)realloc(clientes->cliente[i].morada.rua, len * sizeof(char));
                strcpy(clientes->cliente[i].morada.rua, clientes->cliente[i + 1].morada.rua);

                strcpy(clientes->cliente[i].nif, clientes->cliente[i + 1].nif);

                strcpy(clientes->cliente[i].morada.codigoPostal, clientes->cliente[i + 1].morada.codigoPostal);
            }
        }

        free(clientes->cliente[tamanho].pais);
        free(clientes->cliente[tamanho].password);
        free(clientes->cliente[tamanho].nome);
        free(clientes->cliente[tamanho].apelido);
        free(clientes->cliente[tamanho].morada.cidade);
        free(clientes->cliente[tamanho].morada.rua);

        clientes->cliente[tamanho].numeroCliente = -1;
        clientes->cliente[tamanho].data.dia = -1;
        clientes->cliente[tamanho].data.mes = -1;
        clientes->cliente[tamanho].data.ano = -1;
        clientes->cliente[tamanho].estado = INATIVO;

        clientes->contador--;
    }
}

int encontarNumCliente(Clientes clientes, char nif[9]) {
    int num;
    for (int j = 0; j < clientes.contador; j++) {
        if (strcmp(clientes.cliente[j].nif, nif) == 0) {
            num = clientes.cliente[j].numeroCliente;
            return num;
        }
    }
}

void editarNomeClientes(Clientes *clientes, int nCliente, char *nome, char *apelido) {
    int check;

    check = procurarCliente(nCliente, *clientes);

    strcpy((*clientes).cliente[check].nome, nome);
    strcpy((*clientes).cliente[check].apelido, apelido);
}

void editarNIFClientes(Clientes *clientes, int nCliente, char NIF[TAMANHO_NIF]) {
    int check;

    check = procurarCliente(nCliente, *clientes);

    strcpy((*clientes).cliente[check].nif, NIF);
}

void editarPaisClientes(Clientes *clientes, int nCliente, char *pais) {
    int check;

    check = procurarCliente(nCliente, *clientes);

    strcpy((*clientes).cliente[check].pais, pais);
}

void editarPasswordClientes(Clientes *clientes, int nCliente, char *password) {
    int check;

    check = procurarCliente(nCliente, *clientes);

    strcpy((*clientes).cliente[check].password, password);
}

void editarDataClientes(Clientes *clientes, int nCliente, int diaNascimento, int mesNascimento, int anoNascimento) {
    int check;

    check = procurarCliente(nCliente, *clientes);

    (*clientes).cliente[check].data.dia = diaNascimento;
    (*clientes).cliente[check].data.mes = mesNascimento;
    (*clientes).cliente[check].data.ano = anoNascimento;
}

void editarMoradaClientes(Clientes *clientes, int nCliente, char *cidade, char *rua, char codigoPostal[TAMANHO_CODIGO_POSTAL]) {
    int check;

    check = procurarCliente(nCliente, *clientes);

    strcpy((*clientes).cliente[check].morada.cidade, cidade);
    strcpy((*clientes).cliente[check].morada.rua, rua);
    strcpy((*clientes).cliente[check].morada.codigoPostal, codigoPostal);
}

void editarDadosPessoaisAdminNome(int num, Admins *admin, char *nome, char *apelido) {
    strcpy((*admin).admin[num].nome, nome);
    strcpy((*admin).admin[num].apelido, apelido);
}

void editarDadosPessoaisAdminPassword(int num, Admins *admin, char *password) {
    strcpy((*admin).admin[num].password, password);
}

int desativarAtivarCliente(Clientes *clientes, int nCliente, Estado estado) {
    int check;
    int valor;
    check = procurarCliente(nCliente, *clientes);
    if (check == -1) {
        valor = -1;
    } else if ((*clientes).cliente[check].estado == estado) {
        valor = 0;
    } else {
        valor = 1;
        (*clientes).cliente[check].estado = estado;
    }
    return valor;
}

void iniciarFicheiro(FILE *ficheiro, char *nomeFicheiro) {
    ficheiro = fopen(nomeFicheiro, "r");

    if (ficheiro == NULL) {
        fclose(ficheiro);
        ficheiro = fopen(nomeFicheiro, "w");
    }

    fclose(ficheiro);
}

int contarLinhas(FILE *ficheiro, char *nomeFicheiro) {
    ficheiro = fopen(nomeFicheiro, "r");

    char conta;
    int nClientes = 0;

    while (!feof(ficheiro)) {
        conta = fgetc(ficheiro);
        if (conta == '\n') {
            nClientes++;
        }
    }

    fclose(ficheiro);

    return nClientes;
}

void lerFicheiroClientes(Clientes *clientes, FILE *fClientes, int nClientes, char *nomeFicheiro) {
    int i = 0, len;
    int tamanhoBuffer = 1000;

    fClientes = fopen(nomeFicheiro, "r");

    clientes->cliente = (Cliente *)malloc(nClientes * sizeof(Cliente));

    while (!feof(fClientes)) {
        clientes->cliente[i].pais = (char *)malloc(tamanhoBuffer * sizeof(char));
        clientes->cliente[i].password = (char *)malloc(tamanhoBuffer * sizeof(char));
        clientes->cliente[i].nome = (char *)malloc(tamanhoBuffer * sizeof(char));
        clientes->cliente[i].apelido = (char *)malloc(tamanhoBuffer * sizeof(char));
        clientes->cliente[i].morada.cidade = (char *)malloc(tamanhoBuffer * sizeof(char));
        clientes->cliente[i].morada.rua = (char *)malloc(tamanhoBuffer * sizeof(char));
        clientes->cliente[i].morada.numeroPorta = (char *)malloc(tamanhoBuffer * sizeof(char));

        fscanf(fClientes, "%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%d;%d;%d;%d;%d\n",
               clientes->cliente[i].nif, clientes->cliente[i].pais, clientes->cliente[i].password, clientes->cliente[i].nome,
               clientes->cliente[i].apelido, clientes->cliente[i].morada.cidade, clientes->cliente[i].morada.rua,
               clientes->cliente[i].morada.numeroPorta, clientes->cliente[i].morada.codigoPostal,
               &clientes->cliente[i].estado, &clientes->cliente[i].numeroCliente, &clientes->cliente[i].data.dia,
               &clientes->cliente[i].data.mes, &clientes->cliente[i].data.ano);

        len = strlen(clientes->cliente[i].pais);
        clientes->cliente[i].pais = (char *)realloc(clientes->cliente[i].pais, (len + 1) * sizeof(char));

        len = strlen(clientes->cliente[i].password);
        clientes->cliente[i].password = (char *)realloc(clientes->cliente[i].password, (len + 1) * sizeof(char));

        len = strlen(clientes->cliente[i].nome);
        clientes->cliente[i].nome = (char *)realloc(clientes->cliente[i].nome, (len + 1) * sizeof(char));

        len = strlen(clientes->cliente[i].apelido);
        clientes->cliente[i].apelido = (char *)realloc(clientes->cliente[i].apelido, (len + 1) * sizeof(char));

        len = strlen(clientes->cliente[i].morada.cidade);
        clientes->cliente[i].morada.cidade = (char *)realloc(clientes->cliente[i].morada.cidade, (len + 1) * sizeof(char));

        len = strlen(clientes->cliente[i].morada.rua);
        clientes->cliente[i].morada.rua = (char *)realloc(clientes->cliente[i].morada.rua, (len + 1) * sizeof(char));

        len = strlen(clientes->cliente[i].morada.numeroPorta);
        clientes->cliente[i].morada.numeroPorta = (char *)realloc(clientes->cliente[i].morada.numeroPorta, (len + 1) * sizeof(char));

        i++;
    }
    fclose(fClientes);
}

void escreverFicheiroClientes(Clientes clientes, FILE *fClientes, char *nomeFicheiro) {
    fClientes = fopen(nomeFicheiro, "w");

    for (int i = 0; i < clientes.contador; i++) {
        fprintf(fClientes, "%s;%s;%s;%s;%s;%s;%s;%s;%s;%d;%d;%d;%d;%d\n", clientes.cliente[i].nif, clientes.cliente[i].pais, clientes.cliente[i].password,
                clientes.cliente[i].nome, clientes.cliente[i].apelido, clientes.cliente[i].morada.cidade, clientes.cliente[i].morada.rua, clientes.cliente[i].morada.numeroPorta,
                clientes.cliente[i].morada.codigoPostal, clientes.cliente[i].estado, clientes.cliente[i].numeroCliente, clientes.cliente[i].data.dia,
                clientes.cliente[i].data.mes, clientes.cliente[i].data.ano);
    }

    fclose(fClientes);
}

void lerFicheiroAdmins(Admins *admins, FILE *fAdmins, int nAdmins, char *nomeFicheiro) {
    int len, i = 0;
    int tamanhoBuffer = 1000;

    fAdmins = fopen(nomeFicheiro, "r");

    admins->admin = (Admin*)malloc(nAdmins * sizeof(Admin));

    while (!feof(fAdmins)) {
        admins->admin[i].nome = (char*)malloc(tamanhoBuffer * sizeof(char));
        admins->admin[i].apelido = (char*)malloc(tamanhoBuffer * sizeof(char));
        admins->admin[i].password = (char*)malloc(tamanhoBuffer * sizeof(char));

        fscanf(fAdmins, "%[^;];%[^;];%[^;];%d\n", admins->admin[i].nome, admins->admin[i].apelido, admins->admin[i].password, &admins->admin[i].numeroAdmin);
        
        len = strlen(admins->admin[i].nome);
        admins->admin[i].nome = (char*)realloc(admins->admin[i].nome, (len + 1) * sizeof(char));

        len = strlen(admins->admin[i].apelido);
        admins->admin[i].apelido = (char*)realloc(admins->admin[i].apelido, (len + 1) * sizeof(char));

        len = strlen(admins->admin[i].password);
        admins->admin[i].password = (char*)realloc(admins->admin[i].password, (len + 1) * sizeof(char));

        i++;
    }
    fclose(fAdmins);
}

void escreverFicheiroAdmins(Admins admins, FILE *fAdmins, char *nomeFicheiro) {
    fAdmins = fopen(nomeFicheiro, "w");

    for (int i = 0; i < admins.contador; i++) {
        fprintf(fAdmins, "%s;%s;%s;%d\n", admins.admin[i].nome, admins.admin[i].apelido, admins.admin[i].password, admins.admin[i].numeroAdmin);
    }

    fclose(fAdmins);
}
