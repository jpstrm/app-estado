import { Component, Input, OnInit } from '@angular/core';
import { CityDto } from '../../../api/state';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-city-table',
  templateUrl: './city-table.component.html',
  styleUrls: ['./city-table.component.scss']
})
export class CityTableComponent implements OnInit {

  displayedColumns: string[] = ['name', 'stateCode', 'population'];

  @Input() cities: Observable<CityDto[]>;

  constructor() { }

  ngOnInit(): void {
  }

}
