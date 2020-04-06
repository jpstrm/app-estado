import { Component, OnInit } from '@angular/core';
import { CityService } from '../city.service';
import { Observable } from 'rxjs';
import { CityDto } from '../../../api/state';

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.scss']
})
export class CityListComponent implements OnInit {

  cities$: Observable<CityDto[]>;

  constructor(
    private cityService: CityService
  ) { }

  ngOnInit(): void {
    this.cityService.findAll();
    this.cities$ = this.cityService.cities$.asObservable();
  }

}
