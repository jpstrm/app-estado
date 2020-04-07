import { Injectable } from '@angular/core';
import { StateApiService, StateListResponse } from '../../api/state';
import { SharedService } from '../../shared/shared.service';

@Injectable()
export class StateService {

  constructor(
    private api: StateApiService,
    private sharedService: SharedService
  ) { }

  findAll(): void {
    this.api.findAllUsingGET1()
      .subscribe((data: StateListResponse) =>
        this.sharedService.updateStates(data.states));
  }

}
