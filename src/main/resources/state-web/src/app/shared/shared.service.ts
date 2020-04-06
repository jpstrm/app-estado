import { Injectable } from '@angular/core';
import { BehaviorSubject, forkJoin } from 'rxjs';
import { CityApiService, CityDto, CityListResponse, StateApiService, StateDto, StateListResponse } from '../api/state';

@Injectable()
export class SharedService {

  private citiesSubject = new BehaviorSubject<CityDto[]>([]);
  private statesSubject = new BehaviorSubject<StateDto[]>([]);

  cities$ = this.citiesSubject.asObservable();
  states$ = this.statesSubject.asObservable();

  constructor(
    private cityApi: CityApiService,
    private stateApi: StateApiService,
  ) {}

  updateCities(cities: CityDto[]) {
    this.citiesSubject.next(cities);
  }

  updateStates(states: StateDto[]): void {
    this.statesSubject.next(states);
  }

  fetchCitiesAndStates(): void {
    forkJoin([this.cityApi.findAllUsingGET(), this.stateApi.findAllUsingGET1()])
      .subscribe(data => {
        console.log('data', data);
        this.updateCities((data[0] as CityListResponse).cities);
        this.updateStates((data[1] as StateListResponse).states);
      });
  }

}
