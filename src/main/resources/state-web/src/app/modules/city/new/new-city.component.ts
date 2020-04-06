import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CityService } from '../city.service';
import { FormHelper } from '../../../helper/form.helper';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Observable } from 'rxjs';
import { StateDto } from '../../../api/state';
import { skip } from 'rxjs/operators';

@Component({
  selector: 'app-new-city',
  templateUrl: './new-city.component.html',
  styleUrls: ['./new-city.component.scss']
})
export class NewCityComponent implements OnInit {

  form: FormGroup;
  states$: Observable<StateDto[]>;

  constructor(
    private cityService: CityService,
    public dialogRef: MatDialogRef<NewCityComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Observable<StateDto[]>
  ) {
    this.states$ = this.data;
  }

  ngOnInit(): void {
    this.buildForm();
  }

  private buildForm(): void {
    this.form = new FormGroup({
      name: new FormControl('', Validators.required),
      population: new FormControl('', Validators.required),
      stateId: new FormControl('', Validators.required)
    });
  }

  save(): void {
    if (this.form.valid) {
      this.cityService.create(this.form.value);
      this.watchError();
    } else {
      FormHelper.markFormAsTouched(this.form);
    }
  }

  watchError(): void {
    this.cityService.hasError$.pipe(skip(1))
      .subscribe(hasError => {
        if (!hasError) {
          this.dialogRef.close();
        }
      });
  }

  closeDialog(): void {
    this.dialogRef.close();
  }

}
