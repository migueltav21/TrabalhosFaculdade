/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * File:   input.h
 * Author: joao
 *
 * Created on 16 de dezembro de 2022, 17:25
 */

#ifndef INPUT_H
#define INPUT_H

#ifdef __cplusplus
extern "C" {
#endif

#define TAMANHO_LINHA 40
#define INPUT_INVALIDO "OPCAO INVALIDA\n"
#define MAXIMO_TAMANHO_PAIS 56
#define MAXIMO_TAMANHO_NOME 50
#define MAXIMO_TAMAHNO_APELIDO 50
#define MAXIMO_TAMANHO_CIDADE 50
#define MAXIMO_TAMANHO_RUA 100
#define MAXIMO_TAMANHO_PASSWORD 100
#define PASSWORD_INCORRETA "Password incorreta\n"
#define DIGITE_OPCAO "Digite a sua opcao: "
#define DIGITE_DIA_NASCIMENTO "Digite o seu dia de nascimento: "
#define DIGITE_MES_NASCIMENTO "Digite o seu mes de nascimento: "
#define DIGITE_ANO_NASCIMENTO "Digite o seu ano de nascimento: "
#define TAMANHO_INCORRETO "Tem de ter %d caracteres\n"
void linha();
void limparBuffer();
int lerInt(int minValor, int maxValor, char *msg);
float lerFloat(float minValor, float maxValor, char *msg);
double lerDouble(double minValor, double maxValor, char *msg);
char lerChar(char *msg);
void lerString(char *str, int tamanho, char *msg);
void lerStringDinamica(char **str, char *msg);
float lerFloatSemLimite(char *msg);
int lerIntSemLimite(char *msg);

#ifdef __cplusplus
}
#endif

#endif /* INPUT_H */
