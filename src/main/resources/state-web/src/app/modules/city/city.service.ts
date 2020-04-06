import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CityApiService, CityDto, CityListResponse } from '../../api/state';

@Injectable()
export class CityService {

  cities$ = new BehaviorSubject<CityDto[]>([]);
  dialog$ = new BehaviorSubject<void>(null);
  hasError$ = new BehaviorSubject<boolean>(false);

  constructor(private api: CityApiService) {
  }

  findAll(): void {
    this.api.findAllUsingGET()
      .subscribe((data: CityListResponse) => {
        this.cities$.next(data.cities);
      });
  }

  create(value: CityDto): void {
    this.api.saveUsingPOST(value)
      .subscribe(() => {
          this.findAll();
          this.hasError$.next(false);
        },
        () => this.hasError$.next(true));
  }

}
