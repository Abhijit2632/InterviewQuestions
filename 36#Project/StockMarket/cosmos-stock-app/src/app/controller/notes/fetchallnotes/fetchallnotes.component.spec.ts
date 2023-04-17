import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchallnotesComponent } from './fetchallnotes.component';

describe('FetchallnotesComponent', () => {
  let component: FetchallnotesComponent;
  let fixture: ComponentFixture<FetchallnotesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FetchallnotesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FetchallnotesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
