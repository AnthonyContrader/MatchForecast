import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { TeamDTO } from 'src/dto/teamdto';
import { PartitaDTO } from 'src/dto/partitadto';
import { HistoricalDTO } from 'src/dto/historicaldto';
import { SchedinaDTO } from 'src/dto/schedinadto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  user: UserDTO;
  team: TeamDTO;
  historical: HistoricalDTO;
  partita: PartitaDTO;
  schedina : SchedinaDTO;
  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.team = JSON.parse(localStorage.getItem('currentTeam'));
    this.partita = JSON.parse(localStorage.getItem('currentPartita'));
    this.historical = JSON.parse(localStorage.getItem('currentHistorical'));
    this.schedina = JSON.parse(localStorage.getItem('currentSchedina'));
  }

}
