import { Component, OnDestroy, OnInit } from '@angular/core';
import { CityService } from '../city/city.service';
import { NewCityComponent } from '../city/new/new-city.component';
import { MatDialog } from '@angular/material/dialog';
import { skip } from 'rxjs/operators';
import { Observable, Subscription } from 'rxjs';
import { StateDto } from '../../api/state';
import { SharedService } from '../../shared/shared.service';
import { NewCityListComponent } from '../city/new-list/new-city-list.component';

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
    private sharedService: SharedService,
    private dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.watchNewCityDialog();
    this.watchNewCitiesDialog();
    this.states$ = this.sharedService.states$;
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  watchNewCityDialog(): void {
    this.subscription = this.cityService.dialog$.pipe(skip(1))
      .subscribe(() => this.dialog.open(NewCityComponent, {
        width: '350px',
        disableClose: true,
        data: this.sharedService.states$
      }));
  }

  watchNewCitiesDialog(): void {
    this.subscription = this.cityService.dialogInLote$.pipe(skip(1))
      .subscribe(() => this.dialog.open(NewCityListComponent, {
        width: '350px',
        disableClose: true,
        data: this.sharedService.states$
      }));
  }


}
