import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { NewCityListComponent } from './new-city-list.component';

describe('NewListComponent', () => {
  let component: NewCityListComponent;
  let fixture: ComponentFixture<NewCityListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewCityListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewCityListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
