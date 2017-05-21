import {Component} from '@angular/core';


@Component({
    selector: 'app-root',
    styles: [`
        .page-background {
            background-color: #eee;
        }
        .container {
            background-color: white;
        }
    `],
    templateUrl: 'app.component.html'
})
export class AppComponent {
    title = 'MavenPlease';
}
