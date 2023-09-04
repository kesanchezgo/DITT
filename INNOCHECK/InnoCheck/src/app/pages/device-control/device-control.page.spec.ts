import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DeviceControlPage } from './device-control.page';

describe('DeviceControlPage', () => {
  let component: DeviceControlPage;
  let fixture: ComponentFixture<DeviceControlPage>;

  beforeEach(async(() => {
    fixture = TestBed.createComponent(DeviceControlPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
