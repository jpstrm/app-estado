import { SnackbarService } from '../shared/snackbar.service';
import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { ApiError } from '../api/state';

@Injectable()
export class CustomHttpInterceptor implements HttpInterceptor {

  hasError$ = new BehaviorSubject<boolean>(false);

  constructor(public snackbarService: SnackbarService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    return next.handle(request).pipe(
      catchError((error: HttpErrorResponse) => {
        const apiError: ApiError = error.error as ApiError;
        let msg = 'Erro de comunicação com a Api';
        if (apiError && apiError.detail) {
          msg = apiError.detail;
        }
        this.snackbarService.open(msg);
        return throwError(error);
      })
    );
  }

}
