import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { PartitaDTO } from 'src/dto/partitadto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';

/**
 * I service sono decorati da @Injectable. 
 * Qui trovate, oltre ai metodi ereditati dall'Abstract,
 *  il metodo per il login (in mirror con il backend).
 * 
 * @author Vittorio Valent
 * 
 * @see AbstractService
 */
@Injectable({
  providedIn: 'root'
})
export class PartitaService extends AbstractService<PartitaDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'partitas';
    this.name = "micro2";
  }
  /*insert(PartitaDTO: PartitaDTO): Observable<PartitaDTO> {
    return this.http.post<any>('http://localhost:8080/' + this.type + '/partitas', PartitaDTO)
}*/
  
}
