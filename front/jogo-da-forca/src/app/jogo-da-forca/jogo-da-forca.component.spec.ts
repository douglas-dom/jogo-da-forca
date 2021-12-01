import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JogoDaForcaComponent } from './jogo-da-forca.component';

describe('JogoDaForcaComponent', () => {
  let component: JogoDaForcaComponent;
  let fixture: ComponentFixture<JogoDaForcaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JogoDaForcaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JogoDaForcaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
