import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-angular-color-picker',
  templateUrl: './angular-color-picker.component.html',
  styleUrls: ['./angular-color-picker.component.css']
})
export class AngularColorPickerComponent implements OnInit {
  color = '#000000';

  constructor() {
  }

  ngOnInit(): void {
  }

}
