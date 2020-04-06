import { Component } from '@angular/core';
import { SidebarItem } from './modules/container/sidebar/sidebar-item';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  title = 'App Estado';

  items: SidebarItem[]  = [
    { title: 'Cadastrar Cidade', url: '/#cities', icon: 'fa-city' }
  ];

}
