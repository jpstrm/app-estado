import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { StateDto } from '../../../api/state';
import { StateService } from '../state.service';

@Component({
  selector: 'app-state-list',
  templateUrl: './state-list.component.html',
  styleUrls: ['./state-list.component.scss']
})
export class StateListComponent implements OnInit {

  states$: Observable<StateDto[]>;

  constructor(
    private stateService: StateService
  ) { }

  ngOnInit(): void {
    this.stateService.findAll();
    this.states$ = this.stateService.states$.asObservable();
  }

}
