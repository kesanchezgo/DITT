import { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: 'com.example.app',
  appName: 'InnoCheck',
  webDir: 'www',
  server: {
    androidScheme: 'https'
  }
};

export default config;
