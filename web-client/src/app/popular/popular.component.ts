import {Component, OnInit} from '@angular/core';
import {ArtifactService} from '../artifact.service';
import {Artifact} from '../model/artifact';
import {Observable} from 'rxjs';

@Component({
    selector: 'app-popular',
    templateUrl: 'popular.component.html',
    styleUrls: ['popular.component.css']
})
export class PopularComponent implements OnInit {

    popularArtifacts: Artifact[] = [new Artifact()];

    constructor(private artifactService: ArtifactService) {
    }

    ngOnInit(): void {
        console.log('none');
        this.pollService(this.artifactService.findPopularArtifacts());
    }

    private pollService(request: Observable<Artifact[]>) {
        return request.subscribe(
            result => this.fillInResults(result)
        );
    }

    private fillInResults(result: any) {
        result.forEach(console.log);
        this.popularArtifacts.length = 0;
        for (let obj of result) {
            this.popularArtifacts.push(obj);
        }
    }

}
