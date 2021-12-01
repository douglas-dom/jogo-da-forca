export class Partida {
  public totalLetras: number;
  public dica: string;
  public statusJogador: number;
  public letrasUtilizadas: Array<string>;
  public letrasDescobertas: Map<number, string>;
  public jogoEncerrado: boolean;
  public jogadorGanhou: boolean;

  constructor(
    totalLetras: number,
    dica: string,
    statusJogador: number,
    letrasUtilizadas: Array<string>,
    letrasDescobertas: Map<number, string>,
    jogoEncerrado: boolean,
    jogadorGanhou: boolean
  ) {
    this.totalLetras = totalLetras;
    this.dica = dica;
    this.statusJogador = statusJogador;
    this.letrasUtilizadas = letrasUtilizadas;
    this.letrasDescobertas = letrasDescobertas;
    this.jogoEncerrado = jogoEncerrado;
    this.jogadorGanhou = jogadorGanhou;
  }
}
