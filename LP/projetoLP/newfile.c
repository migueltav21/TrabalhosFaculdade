void listarEncomendasCliente(int num, Encomendas encomendas) {
    int opcao, cont, n = 0, auxiliar = 0;
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
                    printf("%s\n", encomendas.encomenda[i].movel[j].nome);
                    printf("Quantidade: %d\n", encomendas.encomenda[i].movel[j].quantidade);
                    printf("Codigo do artigo: %s\n", encomendas.encomenda[i].movel[j].codigoProduto);
                    printf("Preco: %.2f\n", encomendas.encomenda[i].movel[j].preco * encomendas.encomenda[i].movel[j].quantidade);
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
                printf("Insira o numero da encomenda que deseja ver os detalhes:\n");
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
                    printf("Quantidade: %d %s\n\n", encomendas.encomenda[opcao - 1].movel[i].material[m].contador, encomendas.encomenda[opcao - 1].movel[i].material[m].unidade);
                }
            }
        } else {
            printf("\n");
        }
    }
}
