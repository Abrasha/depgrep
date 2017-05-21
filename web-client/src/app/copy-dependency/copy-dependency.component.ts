import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Artifact} from '../model/artifact';


@Component({
    selector: 'app-copy-dependency',
    templateUrl: 'copy-dependency.component.html'
})
export class CopyDependencyComponent implements OnInit, OnChanges {

    @Input()
    artifact: Artifact;

    @Input()
    exportType: string;

    artifactString: string;


    ngOnInit(): void {
        if (this.exportType === 'maven') {
            this.artifactString = `<dependency>
  <groupId>${this.artifact.group}</groupId>
  <artifactId>${this.artifact.artifact}</artifactId>
  <version>${this.artifact.version}</version>
</dependency>`;
        } else if (this.exportType === 'gradle') {
            this.artifactString = `compile ${this.artifact.group}:${this.artifact.artifact}:${this.artifact.version}`;
        } else if (this.exportType === 'ivy') {
            this.artifactString = `<dependency org="${this.artifact.group}" name="${this.artifact.artifact}" rev="${this.artifact.version}"`;
        }
    }


    ngOnChanges(changes: SimpleChanges): void {
        console.log(changes['exportType'].currentValue);
        this.exportType = changes['exportType'].currentValue;
        this.ngOnInit();
    }

}
