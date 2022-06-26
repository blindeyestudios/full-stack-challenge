import { TestBed } from '@angular/core/testing';

import { SupervisorService } from './supervisors.service';

describe('SupervisorService', () => {
  let service: SupervisorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SupervisorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
