import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StatesComponent } from './pages/states/states.component';
import { CitiesComponent } from './pages/cities/cities.component';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: HomeComponent
  },
  {
    path: 'estados',
    component: StatesComponent,
    pathMatch: 'full'
  },
  {
    path: 'cidades',
    component: CitiesComponent,
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
