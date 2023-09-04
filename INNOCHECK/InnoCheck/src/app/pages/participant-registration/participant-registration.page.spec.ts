import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ParticipantRegistrationPage } from './participant-registration.page';

describe('ParticipantRegistrationPage', () => {
  let component: ParticipantRegistrationPage;
  let fixture: ComponentFixture<ParticipantRegistrationPage>;

  beforeEach(async(() => {
    fixture = TestBed.createComponent(ParticipantRegistrationPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
