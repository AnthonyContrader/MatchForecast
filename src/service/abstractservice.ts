import { Service } from './service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { UserDTO } from 'src/dto/userdto';

/**
 * Service astratto, implementa tutti i metodi CRUD inviando request al server di SpringBoot. 
 * @param port il port del backend
 * @param type la mappatura del controller di ciascuna entità.
 * 
 * @see Service
 * 
 * @author Vittorio Valent
 */
export abstract class AbstractService<DTO> implements Service<DTO> {
    
    type: string;
    name: string;
    port: string = '8080';

    constructor(protected http: HttpClient) {
    }

    auth() {
        const user = JSON.parse(localStorage.getItem('currentUser')) as UserDTO;
        if (user) {
          return 'Bearer ' + user.authorities;
        } else {
          return '';
        }
      }

    getAll(): Observable<DTO[]> {
        if(this.name == null){
        return this.http.get<DTO[]>('http://localhost:' + this.port + '/' + 'api' + '/' + this.type, {

      headers:{
          Authorization: this.auth()
      }
        
        });
    } else{
        return this.http.get<DTO[]>('http://localhost:' + this.port + '/' + this.name + '/api' + '/'+ this.type, {

            headers:{
                Authorization: this.auth()
            }
              
              });
    }
}
    read(id: number): Observable<DTO> {
        if(this.name == null){
            return this.http.get<DTO>('http://localhost:' + this.port + '/' + 'api' + '/' + this.type + '/' + id, {
    
          headers:{
              Authorization: this.auth()
          }
            
            });
        } else{
            return this.http.get<DTO>('http://localhost:' + this.port + '/' + this.name + '/api' + '/' + this.type + '/' + id, {
    
                headers:{
                    Authorization: this.auth()
                }
                  
                  });
        }
    }

    delete(id: number): Observable<DTO> {
      
        if(this.name == null){
            return this.http.delete<DTO>('http://localhost:' + this.port + '/' + 'api' + '/' + this.type + '/' + id, {
    
          headers:{
              Authorization: this.auth()
          }
            
            });
        } else{
            return this.http.delete<DTO>('http://localhost:' + this.port + '/' + this.name + '/api' + '/' + this.type + '/' + id, {
    
                headers:{
                    Authorization: this.auth()
                }
                  
                  });
        }
    }

    deleteUser(login: string): Observable<DTO> {
        if(this.name == null){
          return this.http.delete<DTO>('http://localhost:' + this.port + '/' + 'api' + '/' + this.type + '/' + login , {
            headers: {
              Authorization : this.auth()
            }
          });
        }else{
          return this.http.delete<DTO>('http://localhost:' + this.port + '/' + this.name + '/api' + '/' + this.type + '/' + login , {
            headers: {
              Authorization : this.auth() 
            }
          });

        }
    }

    insert(dto: DTO): Observable<any> {
      
        if(this.name == null){
            return this.http.post<DTO>('http://localhost:' + this.port + '/' + 'api' + '/' + this.type, dto, {
    
          headers:{
              Authorization: this.auth()
          }
            
            });
        } else{
            return this.http.post<DTO>('http://localhost:' + this.port + '/' + this.name + '/api' + '/' + this.type, dto, {
    
                headers:{
                    Authorization: this.auth()
                }
                  
                  });
        }
    }

    update(dto: DTO): Observable<DTO> {
       
        if(this.name == null){
            return this.http.put<DTO>('http://localhost:' + this.port + '/' + 'api' + '/' + this.type, dto, {
    
          headers:{
              Authorization: this.auth()
          }
            
            });
        } else{
            return this.http.put<DTO>('http://localhost:' + this.port + '/' + this.name + '/api' + '/' + this.type, dto, {
    
                headers:{
                    Authorization: this.auth()
                }
                  
                  });
        }
    }
}
