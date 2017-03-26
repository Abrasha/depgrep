import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-custom',
  template: '<h1>Hello, {{name}}</h1>'
})
export class CustomComponent {
  @Input()
  name: string;
}
