import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { CityDto, StateDto } from '../../../api/state';
import { CityService } from '../city.service';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { FormHelper } from '../../../helper/form.helper';
import { skip } from 'rxjs/operators';

@Component({
  selector: 'app-new-city-list',
  templateUrl: './new-city-list.component.html',
  styleUrls: ['./new-city-list.component.scss']
})
export class NewCityListComponent implements OnInit {

  form: FormGroup;
  states$: Observable<StateDto[]>;
  selectedState: StateDto;
  cities: CityDto[] = [];

  constructor(
    private cityService: CityService,
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<NewCityListComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Observable<StateDto[]>
  ) {
    this.states$ = this.data;
  }

  ngOnInit(): void {
    this.buildForm();
  }

  private buildForm(): void {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      population: ['', Validators.required],
      stateId: ['', Validators.required]
    });
  }

  save(): void {
    if (this.cities.length) {
      this.cityService.createList(this.cities);
      this.watchError();
    } else {
      FormHelper.markFormAsTouched(this.form);
    }
  }

  addCity(): void {
    if (this.form.valid) {
      const city = this.form.value as CityDto;
      city.stateId = this.selectedState.id;
      city.stateCode = this.selectedState.code;
      this.addOrUpdateCity(city);
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

  removeCity(city: CityDto) {
    this.cities = this.cities.filter(c => !this.isCityEqual(c, city));
  }

  private addOrUpdateCity(city: CityDto) {
    const found = this.cities.filter(c => this.isCityEqual(c, city))[0] as CityDto;
    if (found) {
      this.cities.map(c => {
        if (this.isCityEqual(c, city)) {
          c.population = city.population;
        }
      });
    } else {
      this.cities.push(city);
    }
  }

  private isCityEqual(cityA: CityDto, cityB: CityDto): boolean {

    return (cityA.name === cityB.name && cityA.stateId === cityB.stateId);
  }

}
