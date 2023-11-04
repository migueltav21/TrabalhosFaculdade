/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * File:   perfil.h
 * Author: joao
 *
 * Created on 16 de dezembro de 2022, 17:25
 */

#ifndef PERFIL_H
#define PERFIL_H

#ifdef __cplusplus
extern "C" {
#endif

#include <stdbool.h>
#include <stdio.h>

#include "input.h"
#include "moveis.h"

#define FICHEIRO_CLIENTES "clientes.csv"
#define FICHEIRO_ADMINS "admins.csv"

#define PASS_ADMIN "12345678"

#define TAMANHO_NIF 10
#define TAMANHO_CODIGO_POSTAL 9

#define PASSWORD_INCORRETA "Password incorreta\n"
#define DIGITE_OPCAO "Digite a sua opcao: "
#define DIGITE_DIA_NASCIMENTO "Digite o seu dia de nascimento: "
#define DIGITE_MES_NASCIMENTO "Digite o seu mes de nascimento: "
#define DIGITE_ANO_NASCIMENTO "Digite o seu ano de nascimento: "
#define LER_NOME "Digite o seu nome: "
#define LER_APELIDO "Digite o seu apelido: "
#define LER_PASSWORD "Digite a sua password [maximo 100 caracteres]: "
#define CONFIRMAR_PASSWORD "Confirme a sua password: "
#define LER_CODIGO_POSTAL "Digite o seu codigo postal: "
#define LER_RUA "Digite a sua rua e porta e|ou andar: "
#define LER_CIDADE "Digite a sua cidade: "
#define LER_NIF "Digite o seu nif: "
#define LER_PAIS "Digite o seu pais: "
#define CLIENTE_NAO_EXISTENTE "O cliente nao existe\n"
#define ADMIN_NAO_EXISTENTE "O admin nao existe\n"
#define INCREMENTO 10

typedef enum {
    INATIVO,
    ATIVO
} Estado;

typedef struct data {
    int dia, mes, ano;
} Data;

typedef struct morada {
    char *cidade;
    char *rua;
    char codigoPostal[TAMANHO_CODIGO_POSTAL];
    char *numeroPorta;
} Morada;

typedef struct cliente {
    int numeroCliente;
    char nif[TAMANHO_NIF];
    char *pais;
    char *password;
    char *nome;
    char *apelido;
    Data data;
    Morada morada;
    Estado estado;
} Cliente;

typedef struct clientes {
    int contador;
    Cliente *cliente;
} Clientes;

typedef struct admin {
    int numeroAdmin;
    char *password;
    char *nome;
    char *apelido;
} Admin;

typedef struct admins {
    int contador;
    Admin *admin;
} Admins;

void criarCliente(Clientes *clientes);
bool verificarCliente(Clientes cliente, char nif[9], char *password);
bool verificarAdmins(Admins admin, int numeroAdmin, char *password);
void criarAdmin(Admins *admin);
void listarClientes(Clientes clientes);
int procurarCliente(int nCliente, Clientes cliente);
int procurarAdmin(int nAdmin, Admins admin);
void listarAdmins(Admins admins);
void removerCliente(Clientes *clientes, int numeroCliente);
void removerAdmin(Admins *admins, int numeroAdmin);
int posCliente(Clientes clientes, int numeroCliente);
int posAdmin(Admins admins, int numAdmins);
int encontarNumCliente(Clientes clientes, char nif[9]);
void editarNomeClientes(Clientes *clientes, int nCliente, char *nome, char *apelido);
void editarNIFClientes(Clientes *clientes, int nCliente, char NIF[TAMANHO_NIF]);
void editarPaisClientes(Clientes *clientes, int nCliente, char *pais);
void editarPasswordClientes(Clientes *clientes, int nCliente, char *password);
void editarDataClientes(Clientes *clientes, int nCliente, int diaNascimento, int mesNascimento, int anoNascimento);
void editarMoradaClientes(Clientes *clientes, int nCliente, char *cidade, char *rua, char codigoPostal[TAMANHO_CODIGO_POSTAL]);
void editarDadosPessoaisAdminNome(int num, Admins *admin, char *nome, char *apelido);
void editarDadosPessoaisAdminPassword(int num, Admins *admin, char *password);
int desativarAtivarCliente(Clientes *clientes, int nCliente, Estado estado);
void iniciarFicheiro(FILE *ficheiro, char *nomeFicheiro);
int contarLinhas(FILE *fClientes, char *nomeFicheiro);
void lerFicheiroClientes(Clientes *clientes, FILE *fClientes, int nClientes, char *nomeFicheiro);
void escreverFicheiroClientes(Clientes clientes, FILE *fClientes, char *nomeFicheiro);
void lerFicheiroAdmins(Admins *admins, FILE *fAdmins, int nAdmins, char *nomeFicheiro);
void escreverFicheiroAdmins(Admins admins, FILE *fAdmins, char *nomeFicheiro);

#ifdef __cplusplus
}
#endif

#endif /* PERFIL_H */
