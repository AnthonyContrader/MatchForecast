import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HistoricalDTO } from 'src/dto/historicaldto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class HistoricalService extends AbstractService<HistoricalDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'historical';
    this.name = "micro2";
  }
}