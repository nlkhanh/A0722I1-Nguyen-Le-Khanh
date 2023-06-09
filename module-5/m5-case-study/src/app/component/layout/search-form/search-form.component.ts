import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-search-form',
  templateUrl: './search-form.component.html',
  styleUrls: ['./search-form.component.css']
})
export class SearchFormComponent implements OnInit {

  @Output()
  getSearch = new EventEmitter<string>();

  constructor() {
  }

  ngOnInit(): void {
  }

  search(value: string) {
    this.getSearch.emit(value);
  }
}
