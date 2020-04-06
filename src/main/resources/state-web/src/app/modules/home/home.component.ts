import { Component, OnDestroy, OnInit } from '@angular/core';
import { CityService } from '../city/city.service';
import { NewCityComponent } from '../city/new/new-city.component';
import { MatDialog } from '@angular/material/dialog';
import { skip } from 'rxjs/operators';
import { Observable, Subscription } from 'rxjs';
import { StateDto } from '../../api/state';
import { SharedService } from '../../shared/shared.service';

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
    this.watchDialog();
    this.states$ = this.sharedService.states$;
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  watchDialog(): void {
    this.subscription = this.cityService.dialog$.pipe(skip(1))
      .subscribe(() => this.dialog.open(NewCityComponent, {
        width: '350px',
        disableClose: true,
        data: this.sharedService.states$
      }));
  }

}
