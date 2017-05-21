import {Component, Input, OnChanges, OnInit} from '@angular/core';
import {Artifact} from '../model/artifact';

@Component({
    selector: 'app-selected-artifact',
    templateUrl: 'app-selected-artifact.html',
    styleUrls: ['./app-selected-artifact.css']
})
export class SelectedArtifactComponent implements OnInit {

    @Input()
    private selectedArtifact: Artifact;

    ngOnInit(): void {
    }

}
