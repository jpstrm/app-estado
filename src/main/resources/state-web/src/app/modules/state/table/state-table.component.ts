import { Component, Input, OnInit } from '@angular/core';
import { StateDto } from '../../../api/state';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-state-table',
  templateUrl: './state-table.component.html',
  styleUrls: ['./state-table.component.scss']
})
export class StateTableComponent implements OnInit {

  displayedColumns: string[] = ['name', 'code', 'population'];

  @Input() states: Observable<StateDto[]>;

  constructor() { }

  ngOnInit(): void {
  }

}
