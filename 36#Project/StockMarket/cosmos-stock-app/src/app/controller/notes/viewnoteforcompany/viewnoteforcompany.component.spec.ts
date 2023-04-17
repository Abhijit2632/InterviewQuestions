import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewnoteforcompanyComponent } from './viewnoteforcompany.component';

describe('ViewnoteforcompanyComponent', () => {
  let component: ViewnoteforcompanyComponent;
  let fixture: ComponentFixture<ViewnoteforcompanyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewnoteforcompanyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewnoteforcompanyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
