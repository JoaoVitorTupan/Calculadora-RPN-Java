# Calculadora Infixa para RPN em Java

## Sobre o projeto

Este projeto foi desenvolvido para uma atividade da disciplina com o objetivo de criar uma calculadora capaz de receber expressões matemáticas na notação infixa, converter essas expressões para a Notação Polonesa Reversa (RPN) e calcular o resultado utilizando uma estrutura de dados do tipo pilha.

A aplicação foi desenvolvida em Java e trabalha com números inteiros e decimais, além dos operadores `+`, `-`, `*` e `/` e da utilização de parênteses.

## Como funciona

A aplicação possui duas etapas principais.

Primeiro, a expressão infixa é convertida para RPN. Durante essa conversão, os números são enviados para a saída e os operadores são armazenados em uma pilha. A precedência dos operadores também é considerada para que a expressão mantenha a ordem correta das operações.

Depois da conversão, a expressão RPN é avaliada utilizando outra pilha. Os números são colocados na pilha e, quando um operador é encontrado, os dois valores do topo são retirados, a operação é realizada e o resultado volta para a pilha.

Por exemplo:

```text
Expressão infixa:
3 + 5 * 2

RPN:
3 5 2 * +

Resultado:
13.0
```

## Estrutura do projeto

Os arquivos principais do projeto são:

```text
src/
├── Main.java
├── Pilha.java
├── PilhaOperadores.java
├── ConversorRPN.java
└── AvaliadorRPN.java
```

### Main.java

É a classe responsável pela interação com o usuário. Ela recebe a expressão digitada, chama o conversor e depois o avaliador, mostrando a expressão original, a RPN e o resultado.

### Pilha.java

Implementa a estrutura de dados pilha utilizando um vetor de `double`. Essa pilha é utilizada para realizar os cálculos da expressão RPN.

### PilhaOperadores.java

Implementa uma pilha de `String`. Ela é utilizada durante a conversão para armazenar os operadores e os parênteses.

### ConversorRPN.java

É responsável por converter a expressão da notação infixa para RPN. Nessa etapa são consideradas a precedência dos operadores e a utilização dos parênteses.

### AvaliadorRPN.java

É responsável por calcular o resultado da expressão depois que ela já foi convertida para RPN.

## Precedência dos operadores

A aplicação considera a seguinte ordem:

| Operadores | Precedência |
| ---------- | ----------: |
| `*` e `/`  |           2 |
| `+` e `-`  |           1 |

Assim, em uma expressão como:

```text
3 + 5 * 2
```

a multiplicação é realizada antes da soma, resultando na RPN:

```text
3 5 2 * +
```

## Exemplos de testes

Foram realizados testes utilizando números inteiros, números decimais, operadores diferentes e parênteses.

### 1. Operações com inteiros

```text
Expressão: 3 + 5 * 2
RPN:       3 5 2 * +
Resultado: 13.0
```

### 2. Números decimais

```text
Expressão: 10.5 + 2.5
RPN:       10.5 2.5 +
Resultado: 13.0
```

### 3. Utilização de parênteses

```text
Expressão: (10 + 5) * 2
RPN:       10 5 + 2 *
Resultado: 30.0
```

### 4. Divisão com resultado decimal

```text
Expressão: 10 / 4
RPN:       10 4 /
Resultado: 2.5
```

### 5. Expressão com diferentes operadores e decimal

```text
Expressão: 10 + (5 * 2.5) - 4
RPN:       10 5 2.5 * + 4 -
Resultado: 18.5
```

## Tratamento de erros

Também foram adicionadas algumas validações para evitar que expressões inválidas sejam processadas.

Alguns exemplos testados:

```text
10 + *
Erro: Operador em posição inválida.
```

```text
5..5
Erro: Número decimal inválido.
```

```text
10 / 0
Erro: Divisão por zero.
```

```text
(10 + 5
Erro: Parênteses desbalanceados.
```

Também é verificado quando existem valores ou parênteses em posições que não fazem sentido na expressão.

## Como executar

Para executar o projeto, é necessário ter o Java instalado.

Primeiro, abra o terminal na pasta do projeto e compile os arquivos:

```bash
javac -d bin src/*.java
```

Depois execute a aplicação:

```bash
java -cp bin Main
```

Após iniciar, basta digitar uma expressão matemática.

Para encerrar:

```text
sair
```

## Tecnologias utilizadas

* Java
* Git
* GitHub

Além disso, foram utilizados conceitos de:

* Estrutura de dados Pilha
* Vetores
* Notação Infixa
* Notação Polonesa Reversa (RPN)
* Precedência de operadores

## Histórico do desenvolvimento

O projeto foi desenvolvido utilizando Git, mantendo os commits realizados durante o desenvolvimento.

As principais etapas registradas no histórico foram:

* Implementação da estrutura de pilha;
* Implementação da conversão de infixa para RPN;
* Implementação da avaliação da expressão RPN;
* Adição das validações das expressões;
* Organização dos arquivos compilados com `.gitignore`;
* Adição da documentação do projeto.