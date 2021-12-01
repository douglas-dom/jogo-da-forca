import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { JogoDaForcaModule } from './jogo-da-forca';

import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    JogoDaForcaModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
