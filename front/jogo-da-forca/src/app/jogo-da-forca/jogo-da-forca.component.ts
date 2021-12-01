import { Component, OnInit, Pipe } from '@angular/core';
import { JogoDaForcaService } from './service/jogo-da-forca.service';
import { Partida } from './model/partida';

@Component({
  selector: 'app-jogo-da-forca',
  templateUrl: './jogo-da-forca.component.html',
  styleUrls: ['./jogo-da-forca.component.css']
})

export class JogoDaForcaComponent implements OnInit {

  letra: string = '';
  totalLetrasAux: Array<number> = [].constructor(0);

  private _showJogo : boolean = false;
  private _showInicio: boolean = true;

  private partida : Partida = {
    statusJogador: 0,
    jogadorGanhou: false,
    jogoEncerrado: false
  } as Partida;

  constructor(private jogoDaForcaService: JogoDaForcaService) {
  }

  ngOnInit(): void { }

  // FUNÇOES UTILITÁRIAS
  get showJogo(): boolean{
    return this._showJogo;
  }

  get showInicio(): boolean {
    return this._showInicio;
  }

  get showFinal(): boolean {
    return this.partida.jogoEncerrado;
  }

  get jogadorGanhou(): boolean {
    return this.partida.jogadorGanhou;
  }

  get imagemForca(): string {
    return './assets/imagens/forcaStatus'+this.partida.statusJogador+'.png';
  }

  get showDica(): string {
    return this.partida.dica;
  }

  get compPalavra(): number {
    return this.partida.totalLetras;
  }

  get letrasUtilizadas(): Array<string> {
    return this.partida.letrasUtilizadas;
  }

  get letrasDescobertas(): Map<number, string>{
    return this.partida.letrasDescobertas;
  }


  iniciarJogo() {
    this.jogoDaForcaService.iniciarJogo()
    .subscribe((data: Partida) => {
      this.partida = data;
      this._showInicio = false;
      this._showJogo = true;
         this.totalLetrasAux = [...[].constructor(data.totalLetras)];
        });

  }

  selecionarLetra(){
    this.jogoDaForcaService.selecionarLetra(this.letra)
    .subscribe((data: Partida) => {
      this.partida = data;
      if(data.jogoEncerrado){
        this._showInicio = false;
        this._showJogo = false;
      }
       this.letra = '';
       this.totalLetrasAux = [...[].constructor(data.totalLetras)];
      });
  }

}
