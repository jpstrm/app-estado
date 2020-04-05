import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CitiesComponent } from "./cities/cities.component";
import { StatesComponent } from "./states/states.component";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [
    CitiesComponent,
    StatesComponent
  ]
})
export class PagesModule { }
