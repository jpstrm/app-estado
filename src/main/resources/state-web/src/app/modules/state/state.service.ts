import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { StateApiService, StateDto, StateListResponse } from '../../api/state';

@Injectable()
export class StateService {

  states$ = new BehaviorSubject<StateDto[]>([]);

  constructor(
    private api: StateApiService
  ) { }

  public findAll(): void {
    this.api.findAllUsingGET1()
      .subscribe((data: StateListResponse) => {
        this.states$.next(data.states);
      });
  }

}
