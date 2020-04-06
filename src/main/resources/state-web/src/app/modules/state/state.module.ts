import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StateListComponent } from './list/state-list.component';
import { StateTableComponent } from './table/state-table.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { StateApiModule } from '../../api/state';
import { StateService } from './state.service';

@NgModule({
  imports: [
    CommonModule,
    MatTableModule,
    MatPaginatorModule,
    StateApiModule
  ],
  declarations: [
    StateTableComponent,
    StateListComponent
  ],
  exports: [
    StateListComponent
  ],
  providers: [
    StateService
  ]
})

export class StateModule { }
