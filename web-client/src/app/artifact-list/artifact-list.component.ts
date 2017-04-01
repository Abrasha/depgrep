import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Artifact} from '../model/artifact';

@Component({
    selector: 'app-artifact-list',
    template: `
			<table>
				<thead>
				<tr>
					<th>Group</th>
					<th>Name</th>
					<th>Version</th>
				</tr>
				</thead>
				<tbody>
				<tr *ngFor="let a of _artifacts">
					<td>{{a.group}}</td>
					<td>{{a.artifact}}</td>
					<td>{{a.version}}</td>
				</tr>
				</tbody>
			</table>
    `,
    styleUrls: ['./artifact-list.component.css']
})
export class ArtifactListComponent implements OnChanges {

    private _artifacts: Artifact[] = [];

    ngOnChanges(changes: SimpleChanges): void {
        console.log('Property changed');
    }

    @Input()
    set artifacts(artifacts: Artifact[]) {
        console.error('Property changed');
        this._artifacts = artifacts;
    }

}
