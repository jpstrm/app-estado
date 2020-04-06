import { AfterViewInit, Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { CityDto } from '../../../api/state';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-city-table',
  templateUrl: './city-table.component.html',
  styleUrls: ['./city-table.component.scss']
})
export class CityTableComponent implements OnInit, AfterViewInit {

  @Input() cities$: Observable<CityDto[]>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  displayedColumns: string[] = ['name', 'stateCode', 'population'];
  dataSource: MatTableDataSource<CityDto> = new MatTableDataSource<CityDto>([]);

  constructor() { }

  ngOnInit(): void {
    this.cities$.subscribe(c => this.dataSource.data = c);
  }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }

}
