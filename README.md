# DistributedFactorialSystem
4645F-04 - Programação Distribuída - Turma 128 - 2019/1 - Prof. Roland Teodorowitsch

1) Implementar uma aplicação cliente-servidor para calcular o fatorial usando sockets com
datagramas
  - Enviar um valor inteiro (int) do cliente para o servidor
  - Retornar um valor real (double) do servidor para o cliente
  - O servidor funciona até receber um valor negativo

2) Um processo servidor, rodando na máquina do professor (IP _._._._) recebe datagramas na
porta 10000. Se você enviar seu número de matrícula em formato texto (8 dígitos) em um
datagrama para a porta 10000 dessa máquina, receberá uma palavra com algumas letras
substituídas por dígitos (0=O; 1=I; 2=Z; 3=E; 4=A; 5=S; 6=G; 7=T; 8=B; 9=Q). Seu programa
deverá substituir os dígitos desta palavra pelas respectivas letras e retornar um datagrama
com o número de matrícula, seguido de “:” e da palavra sem dígitos para vencer o desafio.
Há um limite de tempo bastante pequeno responder ao desafio. O servidor retornará um
datagrama com uma mensagem de texto.
