import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { TeamDTO } from 'src/dto/teamdto';
import { PartitaDTO } from 'src/dto/partitadto';
import { HistoricalDTO } from 'src/dto/historicaldto';
import { PartitaService } from 'src/service/partita.service';
import { SchedinaService } from 'src/service/schedina.service';
import { SchedinaDTO } from 'src/dto/schedinadto';

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
schedinas: SchedinaDTO[];
  user: UserDTO;
  team: TeamDTO;
  historical: HistoricalDTO;
  partita: PartitaDTO;
  schedina: SchedinaDTO;
  partitas: PartitaDTO[];
  schedinatoinsert: SchedinaDTO = new SchedinaDTO();
  constructor(private service : PartitaService,private service2 :SchedinaService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.team = JSON.parse(localStorage.getItem('currentTeam'));
    this.partita = JSON.parse(localStorage.getItem('currentPartita'));
    this.historical = JSON.parse(localStorage.getItem('currentHistorical'));
    this.schedina = JSON.parse(localStorage.getItem('currentSchedina'));
    this.getPartitas();
    this.getSchedinas();
  }
  getPartitas() {
    
    this.service.getAll().subscribe(partitas => this.partitas = partitas);
  }
  getSchedinas(){
    this.service2.getAll().subscribe(schedinas => this.schedinas = schedinas);
  }
  insert(schedina: SchedinaDTO) {
   
   // schedina.partita.id = this.schedina.partita.id;
    schedina.quota1=16;
    schedina.quotaX=22;
    schedina.quota2=24;
    console.log(schedina);
          this.service2.insert(schedina).subscribe(()=> this.getSchedinas());
}
}