import {Component, OnInit} from '@angular/core';
import {ArtifactService} from './artifact.service';
import {Artifact} from './model/artifact';


@Component({
    selector: 'app-artifacts',
    template: `
			<h1>Some text</h1>
			<ul>
				<li *ngFor="let a of artifacts">{{a.group}}:{{a.artifact}}:{{a.version}}</li>
			</ul>
    `
})
export class ArtifactsComponent implements OnInit {
    artifacts: Artifact[];

    constructor(private artifactService: ArtifactService) {
    }

    ngOnInit(): void {
        this.artifactService.getArtifacts()
            .subscribe((data: Artifact[]) => this.artifacts = data);
    }
}
