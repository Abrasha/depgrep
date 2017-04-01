import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app/app.component';
import {ArtifactsComponent} from './artifacts.component';
import {ArtifactService} from './artifact.service';

@NgModule({
    declarations: [
        AppComponent,
        ArtifactsComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpModule
    ],
    providers: [ArtifactService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
