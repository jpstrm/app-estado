import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CityService } from '../city.service';
import { FormHelper } from '../../../helper/form.helper';
import { MatDialogRef } from '@angular/material/dialog';
import { Observable } from 'rxjs';
import { StateDto } from '../../../api/state';
import { StateService } from '../../state/state.service';

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
    private stateService: StateService,
    public dialogRef: MatDialogRef<NewCityComponent>
  ) { }

  ngOnInit(): void {
    this.buildForm();
    this.loadStates();
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
      this.dialogRef.close();
    } else {
      FormHelper.markFormAsTouched(this.form);
    }
  }

  closeDialog(): void {
    this.dialogRef.close();
  }

  private loadStates() {
    this.states$ = this.stateService.states$.asObservable();
    this.stateService.findAll();
  }

}
