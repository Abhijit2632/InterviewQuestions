import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GoogleapiliveComponent } from './googleapilive.component';

describe('GoogleapiliveComponent', () => {
  let component: GoogleapiliveComponent;
  let fixture: ComponentFixture<GoogleapiliveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GoogleapiliveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GoogleapiliveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
