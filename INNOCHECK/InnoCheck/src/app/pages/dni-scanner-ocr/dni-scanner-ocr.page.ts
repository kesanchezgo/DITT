import { Component, OnInit } from '@angular/core';
//import { Camera, CameraOptions } from '@ionic-native/camera/ngx';
//import Tesseract from 'tesseract.js';
/* import * as Tesseract from 'tesseract.js' */
@Component({
  selector: 'app-dni-scanner-ocr',
  templateUrl: './dni-scanner-ocr.page.html',
  styleUrls: ['./dni-scanner-ocr.page.scss'],
})
export class DniScannerOcrPage implements OnInit {

  recognizedText: string;
  constructor(/* private camera: Camera */) { 
    this.recognizedText = '';
  }

  ngOnInit() {
  }

  /* captureImage() {
    const options: CameraOptions = {
      quality: 100,
      sourceType: this.camera.PictureSourceType.CAMERA,
      destinationType: this.camera.DestinationType.DATA_URL,
      encodingType: this.camera.EncodingType.JPEG,
      targetWidth: 800,
      targetHeight: 800,
    };

    this.camera.getPicture(options).then((imageData) => {
      Tesseract.recognize(imageData, 'eng')
        .then(({ data: { text } }) => {
          this.recognizedText = text;
        })
        .catch((error) => {
          console.error('Error en el procesamiento OCR:', error);
        });
    });
  } */

}
