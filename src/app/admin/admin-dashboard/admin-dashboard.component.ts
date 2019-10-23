import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { TeamDTO } from 'src/dto/teamdto';
import { PartitaDTO } from 'src/dto/partitadto';

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
  partita: PartitaDTO;
  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.team = JSON.parse(localStorage.getItem('currentTeam'));
    this.partita = JSON.parse(localStorage.getItem('currentPartita'));
  }

}
