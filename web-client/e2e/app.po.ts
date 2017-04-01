import { browser, element, by } from 'protractor';

export class WebClientPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('app-heroes h1')).getText();
  }
}
