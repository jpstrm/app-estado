import { Component, Input, OnInit } from '@angular/core';
import { SidebarItem } from './sidebar-item';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss']
})
export class SidebarComponent implements OnInit {

  @Input() items: SidebarItem[];

  constructor() { }

  ngOnInit(): void {
  }

}
