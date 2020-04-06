import { MatSnackBar } from '@angular/material/snack-bar';
import { Injectable } from '@angular/core';

@Injectable()
export class SnackbarService {

  constructor(private snackBar: MatSnackBar) {}

  open(message: string, action: string = 'OK') {
    this.snackBar.open(message, action, {
      duration: 5000,
    });
  }

}
