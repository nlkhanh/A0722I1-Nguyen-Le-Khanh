import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularCalculatorAppComponent } from './angular-calculator-app.component';

describe('AngularCalculatorAppComponent', () => {
  let component: AngularCalculatorAppComponent;
  let fixture: ComponentFixture<AngularCalculatorAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularCalculatorAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularCalculatorAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
