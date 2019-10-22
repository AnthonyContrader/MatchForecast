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
  constructor(private service: PartitaService,private tService: TeamService) { }

  ngOnInit() {
    this.getPartitas();
    this.getTeams();
  }

  getPartitas() {
    this.service.getAll().subscribe(partitas => this.partitas = partitas);
  }

  getTeams() {
    this.tService.getAll().subscribe(teams => this.teams = teams);
  }
  delete(partita: PartitaDTO) {
    this.service.delete(partita.id).subscribe(() => this.getPartitas());
  }

  update(partita: PartitaDTO) {
    this.service.update(partita).subscribe(() => this.getPartitas());
  }

  insert(partita: PartitaDTO) {
    this.service.insert(partita).subscribe(() => this.getPartitas());
  }

  clear(){
    this.partitatoinsert = new PartitaDTO();
  }
}
