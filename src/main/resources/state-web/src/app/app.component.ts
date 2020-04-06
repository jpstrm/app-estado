import { Component } from '@angular/core';
import { SidebarItem } from './modules/container/sidebar/sidebar-item';
import { CityService } from './modules/city/city.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  title = 'App Estado';
  items: SidebarItem[];

  constructor(
    private cityService: CityService
  ) {
    this.items = [
      { title: 'Cadastrar Cidade', icon: 'fa-city', action$: cityService.dialog$ }
    ];
  }

}
