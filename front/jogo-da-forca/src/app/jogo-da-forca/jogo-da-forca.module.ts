import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { JogoDaForcaComponent } from './jogo-da-forca.component';
import { GetLetraDescoberta } from './pipe/letra-descoberta';
import { JogoDaForcaService } from './service/jogo-da-forca.service';


@NgModule({
  declarations: [
    JogoDaForcaComponent,
    GetLetraDescoberta
  ],
  imports: [
    CommonModule,
    FormsModule
  ],
  exports: [
    JogoDaForcaComponent
  ],
  providers: [
    JogoDaForcaService
  ]
})
export class JogoDaForcaModule { }
