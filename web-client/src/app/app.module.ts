import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';

import {AppComponent} from './app/app.component';
import {ArtifactsComponent} from './artifacts.component';
import {ArtifactService} from './artifact.service';
import {ArtifactListComponent} from './artifact-list/artifact-list.component';
import {SearchboxComponent} from './searchbox/searchbox.component';
import {PopularComponent} from './popular/popular.component';
import {SelectedArtifactComponent} from './selected-artifact/app-selected-artifact';

@NgModule({
    declarations: [
        AppComponent,
        ArtifactsComponent,
        ArtifactListComponent,
        SearchboxComponent,
        PopularComponent,
        SelectedArtifactComponent
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
