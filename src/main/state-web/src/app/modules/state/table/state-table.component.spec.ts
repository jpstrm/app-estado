import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StateTableComponent } from './city-table.component';

describe('CityTableComponent', () => {
  let component: StateTableComponent;
  let fixture: ComponentFixture<StateTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StateTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StateTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
