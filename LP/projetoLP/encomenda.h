/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * File:   encomenda.h
 * Author: joao
 *
 * Created on 19 de dezembro de 2022, 19:04
 */

#ifndef ENCOMENDA_H
#define ENCOMENDA_H

#ifdef __cplusplus
extern "C" {
#endif

#include "input.h"
#include "moveis.h"
#include "perfil.h"

#define OPERACAO_CANCELADA "Operacao cancelada\n"
#define TEMPO_ENTREGA 3;

typedef struct encomenda {
    int numeroCliente;
    Data data;
    Data dataEntrega;
    int contador;
    float preco;
    Movel *movel;
} Encomenda;

typedef struct encomendas {
    int contador;
    Encomenda *encomenda;
} Encomendas;

int checkEncomendas(int num, Encomendas encomendas);
void criarEncomenda(Encomendas *encomendas, Materiais *materiais, Encomenda encomendaTemp);
void listarEncomendas(Encomendas encomendas, Clientes clientes);
void listarEncomendasCliente(int num, Encomendas encomendas, Moveis moveis);
void cancelarEncomenda(Encomendas *encomenda, int num);
void calcularDataEntrega(Encomendas *encomendas, int pos);
void materiaisSemana(Encomendas encomendas, Data data1, Data data2);
int checkEncomendaCancelar(int numCliente, int numEncomenda, Encomendas encomendas);
void limparEncomendaTemp(Encomenda *encomendaTemp);
#ifdef __cplusplus
}
#endif

#endif /* ENCOMENDA_H */
