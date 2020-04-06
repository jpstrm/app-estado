import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StateFlagComponent } from './state-flag.component';

describe('StateFlagComponent', () => {
  let component: StateFlagComponent;
  let fixture: ComponentFixture<StateFlagComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StateFlagComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StateFlagComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
