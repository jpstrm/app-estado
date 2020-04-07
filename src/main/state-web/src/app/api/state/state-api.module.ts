import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BASE_PATH } from './variables';
import { environment } from '../../../environments/environment';
import { APIS } from './api/api';

@NgModule({
  imports: [
    HttpClientModule,
  ],
  providers: [
    { provide: BASE_PATH, useValue: environment.stateUrl },
    APIS
  ]
})

export class StateApiModule { }
