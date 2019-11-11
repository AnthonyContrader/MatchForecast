import{ Injectable } from '@angular/core';
import{ AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SchedinaDTO } from 'src/dto/schedinadto';
import { LoginDTO } from 'src/dto/logindto';
@Injectable({
    providedIn: 'root'
})
export class SchedinaService extends AbstractService<SchedinaDTO>{

    constructor(http: HttpClient) {
        super(http);
        this.type = 'schedinas';
        this.name = "micro2";
    }



}