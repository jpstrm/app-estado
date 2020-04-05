import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContainerModule } from './container/container.module';
import { PagesModule } from './pages/pages.module';
import { HomeComponent } from './pages/home/home.component';

@NgModule({
  imports: [
    BrowserModule,
    AppRoutingModule,
    ContainerModule,
    PagesModule
  ],
  declarations: [
    AppComponent,
    HomeComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
