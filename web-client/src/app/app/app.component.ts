import {Component} from '@angular/core';


@Component({
    selector: 'app-root',
    template: `<h2>{{title}}</h2>
		<app-artifacts></app-artifacts>
    `
})
export class AppComponent {
    title = 'MavenPlease';
}
