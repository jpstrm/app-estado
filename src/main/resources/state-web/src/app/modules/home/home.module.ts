import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { CityModule } from '../city/city.module';
import { StateModule } from '../state/state.module';
import { TopbarModule } from '../container/topbar/topbar.module';

@NgModule({
  imports: [
    CommonModule,
    CityModule,
    StateModule,
    TopbarModule
  ],
  declarations: [
    HomeComponent
  ],
  exports: [
    HomeComponent
  ]
})

export class HomeModule { }
