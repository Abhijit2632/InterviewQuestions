import { TestBed } from '@angular/core/testing';

import { GoogleapiliveService } from './googleapilive.service';

describe('GoogleapiliveService', () => {
  let service: GoogleapiliveService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GoogleapiliveService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
