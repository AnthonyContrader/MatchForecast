import {UserDTO} from './userdto';
import {SchedinaDTO} from './schedinadto';

export class InvestimentoDTO {
 
 id: number;

 user: UserDTO;

 schedina: SchedinaDTO;

 budget: number;

 durata: number;

 rischio: number;

}