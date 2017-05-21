import {Component, Input} from '@angular/core';
import {Artifact} from '../model/artifact';

@Component({
    selector: 'app-artifact-list',
    templateUrl: 'artifact-list.component.html',
    styleUrls: ['./artifact-list.component.css']
})
export class ArtifactListComponent {

    @Input()
    private artifacts: Artifact[] = [];
    private currentSelectedArtifact: Artifact = null;

    selectedArtifact(selectedArtifact: Artifact): void {
        this.currentSelectedArtifact = selectedArtifact;
    }

}
