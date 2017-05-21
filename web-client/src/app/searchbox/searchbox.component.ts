import {Component, OnInit} from '@angular/core';
import {ArtifactService} from '../artifact.service';
import {Artifact} from '../model/artifact';
import {Observable} from 'rxjs';

@Component({
    selector: 'app-searchbox',
    templateUrl: 'searchbox.component.html',
    styleUrls: ['./searchbox.component.css']
})
export class SearchboxComponent implements OnInit {

    query: string;
    artifact: string;
    group: string;

    searchResults: Artifact[] = [new Artifact()];

    constructor(private artifactService: ArtifactService) {
    }

    ngOnInit(): void {
        this.pollService(this.artifactService.findByQuery('guice'));
    }

    findByGroup() {
        if (this.group) {
            this.pollService(this.artifactService.findByGroupName(this.group));
        }
    }

    findByArtifact() {
        if (this.artifact) {
            this.pollService(this.artifactService.findByArtifactName(this.artifact));
        }
    }

    findByQuery() {
        if (this.query) {
            this.pollService(this.artifactService.findByQuery(this.query));
        }
    }

    private pollService(request: Observable<Artifact[]>) {
        return request.subscribe(
            result => this.fillInResults(result)
        );
    }

    private fillInResults(result: any) {
        result.forEach(console.log);
        this.searchResults.length = 0;
        for (let obj of result) {
            this.searchResults.push(obj);
        }
    }

}
