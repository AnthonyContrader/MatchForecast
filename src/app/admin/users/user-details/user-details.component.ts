import { Component, OnInit, Input } from '@angular/core';
import { AbstractCrudComponent } from 'src/app/utils/abstractcomponent';
import { UserService } from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';

/**
 * Questa component si occupa di mostrare i dettagli di un utente (in questo caso aggiunge solo l'ID
 * alle informazioni già mostrate nella tabella generale). L'annotation "@Input()" prende il valore di dto
 * dalla UsersComponent ( usando il binding [dto]) e nel template ne mostra i dettagli. Questa component 
 * non viene chiamata mediante routing ma viene mostrata solo quando dto non è nullo (usando la direttiva
 * *ngIf ).
 * 
 * @author Vittorio Valent
 * 
 * @see UsersComponent
 */
@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['../users.component.css']
})
export class UserDetailsComponent extends AbstractCrudComponent<UserDTO> implements OnInit {

  /**
   * Qui prende in input il valore di dto
   */
  @Input() dto: UserDTO;

  constructor(service: UserService) {
    super(service);
  }

  ngOnInit() {
  }

}
