import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CityApiService, CityDto, CityListResponse } from '../../api/state';

@Injectable()
export class CityService {

  cities$ = new BehaviorSubject<CityDto[]>([]);

  constructor(
    private api: CityApiService
  ) { }

  public findAll(): void {
    this.api.findAllUsingGET()
      .subscribe((data: CityListResponse) => {
        this.cities$.next(data.cities);
      });
  }
}
