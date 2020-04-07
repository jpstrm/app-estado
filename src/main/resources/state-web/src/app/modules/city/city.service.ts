import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CityApiService, CityDto, CityListRequest, CityListResponse, StateApiService } from '../../api/state';
import { SharedService } from '../../shared/shared.service';
import { SnackbarService } from '../../shared/snackbar.service';
import { skip } from 'rxjs/operators';

@Injectable()
export class CityService {

  dialog$ = new BehaviorSubject<void>(null);
  dialogInLote$ = new BehaviorSubject<void>(null);
  hasError$ = new BehaviorSubject<boolean>(false);

  constructor(
    private api: CityApiService,
    private stateApi: StateApiService,
    private snackbarService: SnackbarService,
    private sharedService: SharedService
  ) {}

  findAll(): void {
    this.api.findAllUsingGET()
      .subscribe((data: CityListResponse) =>
        this.sharedService.updateCities(data.cities));
  }

  create(value: CityDto): void {
    this.api.saveUsingPOST(value)
      .subscribe(() => {
        this.loadSuccess('Cidade criada com sucesso!');
      }, () => this.hasError$.next(true));
  }

  deleteById(id: number): void {
    this.api.deleteByIdUsingDELETE(id)
      .subscribe(() => {
        this.loadSuccess('Cidade deletada com sucesso!');
      });
  }

  createList(cities: CityDto[]) {
    const request: CityListRequest = {};
    request.cities = cities;
    this.api.saveAllUsingPOST(request)
      .subscribe(() => {
        this.loadSuccess('Cidades criadas com sucesso!');
      }, () => this.hasError$.next(true));
  }

  loadSuccess(msg: string): void {
    this.hasError$.next(false);
    this.sharedService.fetchCitiesAndStates();
    this.sharedService.cities$.pipe(skip(1))
      .subscribe(() => this.snackbarService.open(msg));
  }

}
