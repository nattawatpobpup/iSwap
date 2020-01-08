import { TestBed, inject } from '@angular/core/testing';
import { MeetingService } from './meeting.service';

describe('MeetingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MeetingService]
    });
  });

  it('should be created', inject([MeetingService], (service: MeetingService) => {
    expect(service).toBeTruthy();
  }));
});
