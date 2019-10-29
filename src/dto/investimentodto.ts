import {UserDTO} from './userdto';
import {SchedinaDTO} from './schedinadto';

export class InvestimentoDTO {
 
 id: number;

 user: InvestimentoDTO;

 schedina: SchedinaDTO;

 budget: number;

 durata: number;

 fRischio: number;

}