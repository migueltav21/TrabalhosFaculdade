#################################
## Exercicio N.48
#################################
# Abrir a base de dados, C$_Pesos_Exercicio_certo.xlsx, no Excel e gravar o ficheiro com a opção tab delimited (txt)

## Ler os dados do diretório atual

data<-read.table("C4_Pesos_Exercicio_certo.txt")
data

# Guardar a variável peso num vetor
peso<-data$V1
peso

# Calcular o tamanho da amostra
length(peso)

## Determinar a tabela de frequencias absolutas

fa<-table(peso)
fa

## Determinar a tabela de frequências relativas

fr<-prop.table(fa)
fr

# Calcular a média e o desvio padrão amostral (x barra e s) e a variância (s quadrado)

mean(peso)
sd(peso)
var(peso)

# Função que permite calcular simultaneamente o min, max, Q1, Q2, Q2 e médias da variável x
summary(peso)

#################################
## Exercicio N.49
#################################

## Construir a data.frame 
Lojas<-data.frame(
  Loja_A=c(8765,3010,4657,4869,9038,7654,7874,9876,3847,4873,4560,6785),
  Loja_B=c(6856,1984,4356,6758,7003,5460,5456,6598,5350,4640,2350,2890))
Lojas

summary(Lojas)
Lojas$Loja_A
Lojas$Loja_B

Loja_A
Loja_B

# Permite trabalhar a base de dados pelo nomes das variáveis

attach(Lojas)
Loja_A
summary(Loja_A)

mean(Loja_A)
sd(Loja_A)

Loja_B
summary(Loja_B)

mean(Loja_B)
sd(Loja_B)


## Representação gráfica
# Histograma
hist(Loja_A)
hist(Loja_B)

# Boxplot duplo
boxplot(Loja_A,Loja_B)



