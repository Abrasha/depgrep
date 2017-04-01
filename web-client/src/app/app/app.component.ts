import {Component} from '@angular/core';


@Component({
    selector: 'app-root',
    template: `<h2>{{title}}</h2>
        <app-searchbox></app-searchbox>
    `
})
export class AppComponent {
    title = 'MavenPlease';
}
