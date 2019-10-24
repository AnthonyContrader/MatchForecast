import { Component, OnInit } from '@angular/core';
import { PartitaService } from 'src/service/partita.service';
import { PartitaDTO } from 'src/dto/partitadto';
import {TeamService} from 'src/service/team.service';
import { TeamDTO } from 'src/dto/teamdto';
@Component({
  selector: 'app-partite',
  templateUrl: './partitas.component.html',
  styleUrls: ['./partitas.component.css']
})
export class PartitasComponent implements OnInit {

 

  

  partitas: PartitaDTO[];
  partitatoinsert: PartitaDTO = new PartitaDTO();
  teams: TeamDTO [];
  squadras: TeamDTO [];
  constructor(private service: PartitaService,private tService: TeamService,private t2Service: TeamService) { }

  ngOnInit() {
    this.getPartitas();
    this.getTeams();
    this.getSquadras();
    
  }

  getPartitas() {
    
    this.service.getAll().subscribe(partitas => this.partitas = partitas);
  }

  getTeams() {
    this.tService.getAll().subscribe(teams => this.teams = teams);
    
  }

  getSquadras() {
   
    this.t2Service.getAll().subscribe(squadras => this.squadras = squadras);
  }
  
  delete(partita: PartitaDTO) {
    this.service.delete(partita.id).subscribe(() => this.getPartitas());
  }

  update(partita: PartitaDTO) {
   
    this.service.update(partita).subscribe(() => this.getPartitas());
  }

  insert(partita: PartitaDTO) {
    
    if ((partita.team1.rating - partita.squadra.rating) < 3){
      partita.win = 30;
      partita.draw = 60;
      partita.lose = 20;

    }else if ((partita.team1.rating - partita.squadra.rating) < 6) {


      partita.win = 60;
      partita.draw = 30;
      partita.lose = 20;
     

    }else {

      partita.win = 90;
      partita.draw = 20;
      partita.lose = 10;


    }

    this.service.insert(partita).subscribe(() => this.getPartitas());
  }

  clear(){
    this.partitatoinsert = new PartitaDTO();
  }
}
