import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CityListComponent } from './list/city-list.component';
import { CityTableComponent } from './table/city-table.component';
import { CityService } from './city.service';
import { MatTableModule } from '@angular/material/table';
import { StateApiModule } from '../../api/state';
import { MatPaginatorModule } from '@angular/material/paginator';
import { NewCityComponent } from './new/new-city.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { NewCityListComponent } from './new-list/new-city-list.component';
import { MatChipsModule } from '@angular/material/chips';
import { MatIconModule } from '@angular/material/icon';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatDialogModule,
    MatSelectModule,
    StateApiModule,
    MatChipsModule,
    MatIconModule
  ],
  declarations: [
    CityTableComponent,
    CityListComponent,
    NewCityComponent,
    NewCityListComponent
  ],
  exports: [
    CityListComponent
  ],
  providers: [
    CityService
  ]
})

export class CityModule { }
