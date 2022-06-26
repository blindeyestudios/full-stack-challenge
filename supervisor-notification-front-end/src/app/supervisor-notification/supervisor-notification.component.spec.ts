import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SupervisorNotificationComponent } from './supervisor-notification.component';

describe('SupervisorNotificationComponent', () => {
  let component: SupervisorNotificationComponent;
  let fixture: ComponentFixture<SupervisorNotificationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SupervisorNotificationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SupervisorNotificationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
