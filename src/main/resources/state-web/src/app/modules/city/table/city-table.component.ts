import { AfterViewInit, Component, EventEmitter, Input, OnDestroy, OnInit, Output, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { CityDto } from '../../../api/state';
import { Observable, Subscription } from 'rxjs';

@Component({
  selector: 'app-city-table',
  templateUrl: './city-table.component.html',
  styleUrls: ['./city-table.component.scss']
})
export class CityTableComponent implements OnInit, AfterViewInit, OnDestroy {

  @Input() cities$: Observable<CityDto[]>;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @Output() deleteAction = new EventEmitter<CityDto>();

  displayedColumns: string[] = ['name', 'stateCode', 'population', 'deleteAction'];
  dataSource: MatTableDataSource<CityDto> = new MatTableDataSource<CityDto>([]);

  private subscription: Subscription;

  constructor() { }

  ngOnInit(): void {
    this.subscription = this.cities$.subscribe(c => this.dataSource.data = c);
  }

  ngAfterViewInit(): void {
    this.dataSource.paginator = this.paginator;
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  deleteState(cityDto: CityDto) {
    this.deleteAction.emit(cityDto);
  }

}
