import { Component, OnDestroy, OnInit } from '@angular/core';
import { CityService } from '../city.service';
import { Observable, Subscription } from 'rxjs';
import { CityDto, StateDto } from '../../../api/state';
import { SharedService } from '../../../shared/shared.service';

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.scss']
})
export class CityListComponent implements OnInit, OnDestroy {

  cities$: Observable<CityDto[]>;
  states$: Observable<StateDto[]>;
  subscription = new Subscription();

  constructor(
    private cityService: CityService,
    private sharedService: SharedService
  ) { }

  ngOnInit(): void {
    this.cityService.findAll();
    this.cities$ = this.sharedService.cities$;
    this.states$ = this.sharedService.states$;
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  deleteCity(city: CityDto) {
    this.cityService.deleteById(city.id);
  }

}
