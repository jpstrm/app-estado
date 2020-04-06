import { Component, OnDestroy, OnInit } from '@angular/core';
import { CityService } from '../city/city.service';
import { NewCityComponent } from '../city/new/new-city.component';
import { MatDialog } from '@angular/material/dialog';
import { skip } from 'rxjs/operators';
import { StateService } from '../state/state.service';
import { Observable, Subscription } from 'rxjs';
import { StateDto } from '../../api/state';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {

  states$: Observable<StateDto[]>;

  private subscription: Subscription;

  constructor(
    private cityService: CityService,
    private stateService: StateService,
    private dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.watchDialog();
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  watchDialog(): void {
    this.subscription = this.cityService.dialog$.pipe(skip(1))
      .subscribe(() => this.dialog.open(NewCityComponent, {
        width: '350px',
        disableClose: true
      }));
    this.states$ = this.stateService.states$.asObservable();
  }

}
