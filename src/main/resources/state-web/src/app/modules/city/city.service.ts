import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CityApiService, CityDto, CityListResponse, StateApiService } from '../../api/state';
import { SharedService } from '../../shared/shared.service';
import { SnackbarService } from '../../shared/snackbar.service';

@Injectable()
export class CityService {

  dialog$ = new BehaviorSubject<void>(null);
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
          this.snackbarService.open('Cidade criada com sucesso!');
          this.hasError$.next(false);
          this.sharedService.fetchCitiesAndStates();
        },
        () => this.hasError$.next(true));
  }

  deleteById(id: number): void {
    this.api.deleteByIdUsingDELETE(id)
      .subscribe(() => {
        this.snackbarService.open('Cidade deletada com sucesso!');
        this.sharedService.fetchCitiesAndStates();
      });
  }

}
