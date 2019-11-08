import { Component, OnInit } from '@angular/core';
import { TeamDTO } from 'src/dto/teamdto';
import {TeamService} from 'src/service/team.service';
@Component({
  selector: 'app-teams',
  templateUrl: './teams.component.html',
  styleUrls: ['./teams.component.css']
})
export class TeamsComponent implements OnInit {

  team: TeamDTO[];
  teamtoinsert: TeamDTO = new TeamDTO();

  constructor(private service: TeamService) { }

  ngOnInit() {
    this.getTeams();
  }

  getTeams() {
    this.service.getAll().subscribe(teams => this.team = teams);
  }

  delete(team: TeamDTO) {
    this.service.delete(team.id).subscribe(() => this.getTeams());
  }

  update(team: TeamDTO) {
    
    this.service.update(team).subscribe(() => this.getTeams());
  }

  insert(team: TeamDTO) {
    
    this.service.insert(team).subscribe(() => this.getTeams());
  }

  clear(){
    this.teamtoinsert = new TeamDTO();
  }
}
