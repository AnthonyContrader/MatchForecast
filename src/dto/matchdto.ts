import { TeamDTO } from './teamdto';

export class MatchDTO {

    idMatch: number;
 
    team1: TeamDTO;

    team2: TeamDTO;
 
    date: string;

    win: number;

    draw: number;

    lose: number;
 
    
 
 }