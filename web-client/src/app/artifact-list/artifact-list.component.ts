import {Component, Input} from '@angular/core';
import {Artifact} from '../model/artifact';
import {Http, HttpModule} from '@angular/http';
import {ArtifactService} from '../artifact.service';

@Component({
    selector: 'app-artifact-list',
    templateUrl: 'artifact-list.component.html',
    styleUrls: ['./artifact-list.component.css']
})
export class ArtifactListComponent {

    @Input()
    private artifacts: Artifact[] = [];
    private currentSelectedArtifact: Artifact = null;

    private exportType: string = null;


    constructor(private artifactService: ArtifactService) {
    }

    selectArtifact(selectedArtifact: Artifact): void {
        this.currentSelectedArtifact = selectedArtifact;
    }

    doExport(artifact: Artifact, exportType: string): any {
        this.exportType = exportType;
        artifact.shouldShow = true;
    }

    doApprove(artifact: Artifact): any {
        this.artifactService.approveArtifact(artifact)
            .subscribe(response => this.afterApproveCallback(artifact));
    }

    afterApproveCallback(artifact: any) {
        artifact.approved = true;
    }

}
