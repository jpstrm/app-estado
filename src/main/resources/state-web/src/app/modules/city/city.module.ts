import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CityListComponent } from './list/city-list.component';
import { CityTableComponent } from './table/city-table.component';
import { CityService } from './city.service';
import { MatTableModule } from '@angular/material/table';
import { StateApiModule } from '../../api/state';
import { MatPaginatorModule } from '@angular/material/paginator';

@NgModule({
  imports: [
    CommonModule,
    MatTableModule,
    MatPaginatorModule,
    StateApiModule,
  ],
  declarations: [
    CityTableComponent,
    CityListComponent
  ],
  exports: [
    CityListComponent
  ],
  providers: [
    CityService
  ]
})

export class CityModule { }
