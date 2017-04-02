import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/publish';
import {log} from 'util';


@Injectable()
export class ArtifactService {

    static parseData(response: Response) {
        return response.json();
    }

    constructor(private http: Http) {
    }

    findByArtifactName(name: string) {
        console.log('searching by artifact name');
        return this.performQuery(`http://localhost:8080/search?artifact=${name}`);
    }

    findByGroupName(group: string) {
        console.log('searching by group name');
        return this.performQuery(`http://localhost:8080/search?group=${group}`);
    }

    findByGroupAndArtifactName(name: string, group: string) {
        console.log('searching by group and artifact name');
        return this.performQuery(`http://localhost:8080/search?artifact=${name}&group=${group}`);
    }

    findByQuery(query: string) {
        console.log('searching by query');
        return this.performQuery(`http://localhost:8080/search?q=${query}`);
    }

    private performQuery(url: string) {
        return this.http.get(url)
            .map(ArtifactService.parseData);
    }

    getArtifacts() {
        return this.http.get('http://localhost:8080/search?q=guice')
            .map(ArtifactService.parseData);
    }

}
