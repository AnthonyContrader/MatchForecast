import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { TeamDTO } from 'src/dto/teamdto';
import { TeamService } from 'src/service/team.service';

@Component({
  selector: 'app-user-header',
  templateUrl: './user-header.component.html',
  styleUrls: ['./user-header.component.css']
})
export class UserHeaderComponent implements OnInit {
  teams: TeamDTO[];
  user: UserDTO = new UserDTO;
 
  constructor(private service: TeamService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.getTeams();
  }
  getTeams() {
    this.service.getAll().subscribe(teams => this.teams = teams);
  }
}