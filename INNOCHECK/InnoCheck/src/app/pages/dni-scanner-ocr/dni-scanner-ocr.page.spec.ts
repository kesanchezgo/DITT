import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DniScannerOcrPage } from './dni-scanner-ocr.page';

describe('DniScannerOcrPage', () => {
  let component: DniScannerOcrPage;
  let fixture: ComponentFixture<DniScannerOcrPage>;

  beforeEach(async(() => {
    fixture = TestBed.createComponent(DniScannerOcrPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
