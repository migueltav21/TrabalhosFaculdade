/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   moveis.h
 * Author: joao
 *
 * Created on 20 de dezembro de 2022, 12:32
 */

#ifndef MOVEIS_H
#define MOVEIS_H

#ifdef __cplusplus
extern "C" {
#endif
#include <stdbool.h>
#include <stdio.h>

#define FICHEIRO_MATERIAIS "materiais.csv"

#define TAMANHO_CODIGO_PRODUTO 7
#define MOVEL_INEXISTENTE "Movel inexistente\n"
#define MATERIAL_INEXISTENTE "Material inexistente\n"
#define OPERACAO_CANCELADA "Operacao cancelada\n"
    
typedef struct material {
    char *nomeMaterial;
    char codigoMaterial[TAMANHO_CODIGO_PRODUTO];
    int contador;
} Material;

typedef struct materiais {
    int contador;
    Material *material;
} Materiais;

typedef struct movel {
    char *nome;
    float preco;
    char codigoProduto[6];
    float comprimento, largura, altura;
    Material *material;
    int contador_materiais;
    int quantidade;
} Movel;

typedef struct moveis {
    int contador;
    Movel *movel;
} Moveis;



void criarMovel(Moveis *moveis, Materiais materiais, char *nome, float preco, float comprimento, float largura, float altura, char codigoProduto[TAMANHO_CODIGO_PRODUTO]);
void criarMaterial(Materiais *materiais);
void editarMovel(Moveis *moveis);
void listarMovel(Moveis moveis);
int verificarMovel(Moveis moveis, char codigoProduto[TAMANHO_CODIGO_PRODUTO]);
int verificarMaterial(Moveis moveis, int posicao, char codigoProduto[TAMANHO_CODIGO_PRODUTO]);
void eliminarMovel(Moveis *moveis, char codigoProduto[TAMANHO_CODIGO_PRODUTO]);
int posicaoMovel(Moveis moveis, char codigoProduto[6]);
void eliminarMovel(Moveis *moveis, char codigoProduto[6]);
int posMaterial(Materiais materiais, char codigoMaterial[TAMANHO_CODIGO_PRODUTO]);
bool codigoExistenteMovel(Moveis moveis, char codigoProduto[TAMANHO_CODIGO_PRODUTO]);
bool codigoExistenteMateriais(Materiais materiais, char codigoMaterial[TAMANHO_CODIGO_PRODUTO]);
void limparMateriais(Materiais *materiais);
void lerFicheiroMateriais(Materiais *materiais, FILE *fMateriais, int nMateriais, char *nomeFicheiro);
void escreverFicheiroMateriais(Materiais materiais, FILE *fMateriais, char *nomeFicheiro);

#ifdef __cplusplus
}
#endif

#endif /* MOVEIS_H */

