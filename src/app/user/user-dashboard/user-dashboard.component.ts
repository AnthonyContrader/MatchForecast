import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { TeamDTO } from 'src/dto/teamdto';
import { PartitaDTO } from 'src/dto/partitadto';
import { HistoricalDTO } from 'src/dto/historicaldto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  user: UserDTO;
  team: TeamDTO;
  historical: HistoricalDTO;
  partita: PartitaDTO;
  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.team = JSON.parse(localStorage.getItem('currentTeam'));
    this.partita = JSON.parse(localStorage.getItem('currentPartita'));
    this.historical = JSON.parse(localStorage.getItem('currentHistorical'));
  }

}
