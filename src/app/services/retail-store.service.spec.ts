import { TestBed } from '@angular/core/testing';

import { RetailStoreService } from './retail-store.service';

describe('RetailStoreService', () => {
  let service: RetailStoreService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RetailStoreService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
