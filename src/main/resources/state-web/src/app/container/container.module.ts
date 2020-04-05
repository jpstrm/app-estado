import { NgModule } from "@angular/core";
import { CommonModule } from '@angular/common';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { FooterComponent } from './footer/footer.component';
import { SidebarComponent } from './sidebar/sidebar.component';

@NgModule({
  imports: [
    CommonModule,
    BrowserModule,
    RouterModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [
    SidebarComponent,
    FooterComponent
  ],
  declarations: [
    SidebarComponent,
    FooterComponent
  ],
  providers: [
  ]
})

export class ContainerModule { }
