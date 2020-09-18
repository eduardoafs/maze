# Gerador de Labirintos com propósitos educacionais

## Instruções de uso
1. Importar o projeto na sua IDE favorita, ou compilar a classe Maze.java. 
1. Executar a classe Maze, ela possui um método main.
1. Na entrada padrão, fornecer dois inteiros x e y, referentes às dimensões do labirinto. Ex: 5 5 para um labirinto 5x5
1. A saída será um labirinto, no seguinte formato:
- 0 indica posição vazia, caminho que pode-se percorrer
- \# indica parede, por onde não se pode passar
- A posição inicial sempre será (0,1)
- A posição final sempre será (x-1, y-2), sendo x e y as dimensões do labirinto
- x é a quantidade de linhas, y é a quantidade de colunas, como um array maze[x][y]

Atenção: esse programa não trata entradas inválidas
