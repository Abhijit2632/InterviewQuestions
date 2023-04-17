import { TestBed } from '@angular/core/testing';

import { ExceldataService } from './exceldata.service';

describe('ExceldataService', () => {
  let service: ExceldataService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ExceldataService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
