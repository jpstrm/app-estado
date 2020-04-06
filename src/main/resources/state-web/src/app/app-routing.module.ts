import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StateListComponent } from './modules/state/list/state-list.component';
import { HomeComponent } from './modules/home/home.component';
import { CityListComponent } from './modules/city/list/city-list.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent,
    pathMatch: 'full'
  },
  {
    path: 'estados',
    component: StateListComponent,
    pathMatch: 'full'
  },
  {
    path: 'cidades',
    component: CityListComponent,
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
