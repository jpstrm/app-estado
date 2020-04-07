import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContainerModule } from './modules/container/container.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeModule } from './modules/home/home.module';
import { MatDialogModule } from '@angular/material/dialog';
import { CustomHttpInterceptor } from './interceptor/custom-http-interceptor.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { SnackbarService } from './shared/snackbar.service';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { SharedService } from './shared/shared.service';

@NgModule({
    imports: [
        BrowserModule,
        AppRoutingModule,
        ContainerModule,
        BrowserAnimationsModule,
        MatDialogModule,
        HomeModule,
        MatSnackBarModule
    ],
  declarations: [
    AppComponent
  ],
  providers: [
    SnackbarService,
    SharedService,
    { provide: HTTP_INTERCEPTORS, useClass: CustomHttpInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})

export class AppModule { }
