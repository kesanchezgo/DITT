import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AttendanceControlPage } from './attendance-control.page';

describe('AttendanceControlPage', () => {
  let component: AttendanceControlPage;
  let fixture: ComponentFixture<AttendanceControlPage>;

  beforeEach(async(() => {
    fixture = TestBed.createComponent(AttendanceControlPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
