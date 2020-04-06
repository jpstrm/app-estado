import { Component, OnInit } from '@angular/core';
import { CityService } from '../city/city.service';
import { NewCityComponent } from '../city/new/new-city.component';
import { MatDialog } from '@angular/material/dialog';
import { skip } from 'rxjs/operators';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(
    private cityService: CityService,
    private dialog: MatDialog
  ) { }

  ngOnInit(): void {
    this.watchDialog();
  }

  watchDialog(): void {
    this.cityService.dialog$.pipe(skip(1))
      .subscribe(() => this.dialog.open(NewCityComponent, { width: '350px' }));
  }

}
