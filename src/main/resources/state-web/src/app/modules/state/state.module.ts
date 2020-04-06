import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StateListComponent } from './list/state-list.component';
import { StateTableComponent } from './table/state-table.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { StateApiModule } from '../../api/state';
import { StateService } from './state.service';
import { StateFlagComponent } from './flag/state-flag.component';
import { MatCardModule } from '@angular/material/card';
import { MatSelectModule } from '@angular/material/select';
import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    MatTableModule,
    MatPaginatorModule,
    StateApiModule,
    MatCardModule,
    MatSelectModule,
    FormsModule
  ],
  declarations: [
    StateTableComponent,
    StateListComponent,
    StateFlagComponent
  ],
  exports: [
    StateListComponent,
    StateFlagComponent
  ],
  providers: [
    StateService
  ]
})

export class StateModule { }
