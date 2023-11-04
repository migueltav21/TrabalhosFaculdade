#include "input.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void linha() {
    for (int i = 0; i < TAMANHO_LINHA - 1; i++) {
        printf("-");
    }
    printf("-\n");
}

void limparBuffer() {
    char ch;
    while ((ch = getchar()) != '\n' && ch != EOF)
        ;
}

int lerInt(int minValor, int maxValor, char *msg) {
    int num;

    printf(msg);

    while (scanf("%d", &num) != 1 || num < minValor || num > maxValor) {
        limparBuffer();
        linha();
        printf(INPUT_INVALIDO);
        linha();
        printf(msg);
    }

    limparBuffer();

    return num;
}

float lerFloat(float minValor, float maxValor, char *msg) {
    float num;

    printf(msg);

    while (scanf("%f", &num) != 1 || num < minValor || num > maxValor) {
        limparBuffer();
        linha();
        printf(INPUT_INVALIDO);
        linha();
        printf(msg);
    }

    limparBuffer();

    return num;
}

double lerDouble(double minValor, double maxValor, char *msg) {
    double num;

    printf(msg);

    while (scanf("%d", &num) != 1 || num < minValor || num > maxValor) {
        limparBuffer();
        linha();
        printf(INPUT_INVALIDO);
        linha();
        printf(msg);
    }

    limparBuffer();
    return num;
}

char lerChar(char *msg) {
    char ch;
    printf(msg);
    scanf(" %c", &ch);
    limparBuffer();
    linha();
    return ch;
}

void lerStringDinamica(char **str, char *msg) {
    int tamanho;
    char buffer[1000];

    printf(msg);
    scanf("%[^\n]", buffer);
    limparBuffer();
    tamanho = strlen(buffer);

    *str = (char *)malloc(tamanho * sizeof(char *));
    strcpy(*str, buffer);
}

void lerString(char *str, int tamanho, char *msg) {
    char buffer[1000];
    int len = 0;

    while (len != tamanho) {
        printf(msg);
        scanf("%[^\n]", buffer);
        len = strlen(buffer);
        limparBuffer();
    }
    strcpy(str, buffer);
}

float lerFloatSemLimite(char *msg) {
    float num;

    printf(msg);

    while (scanf("%f", &num) != 1 || num <= 0) {
        limparBuffer();
        linha();
        printf(INPUT_INVALIDO);
        linha();
        printf(msg);
    }

    limparBuffer();

    return num;
}

int lerIntSemLimite(char *msg) {
    int num;

    printf(msg);

    while (scanf("%d", &num) != 1 || num <= 0) {
        limparBuffer();
        linha();
        printf(INPUT_INVALIDO);
        linha();
        printf(msg);
    }

    limparBuffer();

    return num;
}