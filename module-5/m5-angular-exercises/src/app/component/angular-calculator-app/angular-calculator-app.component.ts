import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-angular-calculator-app',
  templateUrl: './angular-calculator-app.component.html',
  styleUrls: ['./angular-calculator-app.component.css']
})
export class AngularCalculatorAppComponent implements OnInit {
  result = undefined;

  constructor() {
  }

  ngOnInit(): void {
  }

  calculate(firstNumber: string, secondNumber: string, operator: string) {
    switch (operator) {
      case 'plus':
        this.result = +firstNumber + +secondNumber;
        break;
      case 'subtract':
        this.result = +firstNumber - +secondNumber;
        break;
      case 'multiple':
        this.result = +firstNumber * +secondNumber;
        break;
      case 'division':
        this.result = +firstNumber / +secondNumber;
        break;
    }
  }

}
