import {Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-modal-delete',
  templateUrl: './modal-delete.component.html',
  styleUrls: ['./modal-delete.component.css']
})
export class ModalDeleteComponent implements OnInit, OnChanges {
  modalTitle = '';
  btnAgreeText = '';

  @Input()
  modalBody: string;

  @Output()
  deleteConfirm = new EventEmitter<boolean>();

  constructor() {
  }

  ngOnInit(): void {
  }

  executeModal() {
    this.deleteConfirm.emit(true);
  }

  ngOnChanges(changes: SimpleChanges): void {
    const btnAgree = document.getElementById('btn-agree-modal');
    if ('modalBody' in changes) {
      const v = changes.modalBody.currentValue;
      if (v === '') {
        this.modalBody = 'Bạn chưa chọn đối tượng để xóa.';
        btnAgree.style.display = 'none';
      } else {
        btnAgree.style.display = 'inline-block';
      }
    }
  }
}
