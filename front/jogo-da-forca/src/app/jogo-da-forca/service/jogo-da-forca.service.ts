import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Partida } from '../model/partida';

@Injectable({
  providedIn: 'root'
})
export class JogoDaForcaService {

  private readonly URL : string = 'http://localhost:8080/api/';

  constructor(private httpClient: HttpClient) {
  }

  iniciarJogo() {
    return this.httpClient.get<Partida>(this.URL + 'start');
  }

  selecionarLetra(letra:string) {
    return this.httpClient.post<Partida>(this.URL + 'letra', letra[0]);
  }
}
