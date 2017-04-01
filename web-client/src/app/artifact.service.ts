import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/publish';


@Injectable()
export class ArtifactService {

    static parseData(response: Response) {
        return response.json();
    }

    constructor(private http: Http) {
    }

    getArtifacts() {
        return this.http.get('http://localhost:8080/search?q=guice')
            .map(ArtifactService.parseData);
    }

}
