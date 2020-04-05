import { Component, OnInit } from '@angular/core';
import { SidebarItem } from "./sidebar-item";

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  items: SidebarItem[] = [
    { title: 'Estados', url: '/estados', icon: 'fa-flag' },
    { title: 'Cidades', url: '/cidades', icon: 'fa-city' }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
