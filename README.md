## PROCESSO SELETIVO NEXTY

#### Introdução

Para o processo seletivo optei pelo simples jogo da forca para a elaboração do teste. O jogo Consiste em tentar adivinhar uma palavra a partir de uma dica e indicação de letras. Onde a cada letra errada e completado o desenho de um boneco até que o mesmo seja enforcado. Apesar de simples houve alguns desafios para implementa-lo como uma interface gráfica web  e um backend spring e devido ao curto espaço de tempo deixei o mais simples possível.

#### A arquitetura

O jogo tem sua regra de negócio realizada no backend passando para o front apenas o necessário para utilização da parte de visão da aplicação. Uma aplicação para apenas um jogador. Recarregar a página reinicia o jogo.

#### A solução

Ao iniciar o jogo o backend seleciona uma palavra de forma aleatória das que estão disponíveis no jogo e guarda na memória para a comparação da letra. A cada letra indicada é enviada ao back e verificada a se já foi indicada antes. Após e verificado se existe a letra na palavra e preenchida o mapa da palavra e retornado para o front para ser exibido. Caso contrário é alterado o status do jogador que caso chegue a 6 erros e encerrado com a derrota do jogador.


#### Utilizando o projeto.

abra o console ou terminal de sua escolha entre na pasta raiz digite o comando:

`mvn srping-boot:run`

em um novo terminal dessa vez na pasta front encontrada na raiz do projeto. Entre novamente na pasta raiz do projeto de front-end e execute os seguintes comandos:

`npm install`

`ng serve`

Após acesse o browser e acesse o endereço *http://localhost:4200* e divirta-se.

OBS: Só possue duas palavras cadastradas no momento.
