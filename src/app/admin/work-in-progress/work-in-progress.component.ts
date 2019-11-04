import { Component, OnInit } from '@angular/core';
import { style, transition, animate, trigger, state } from '@angular/animations';
import { TeamDTO } from 'src/dto/teamdto';
import { PartitaDTO } from 'src/dto/partitadto';
import { PartitaService } from 'src/service/partita.service';
import {TeamService} from 'src/service/team.service';
@Component({
  selector: 'app-work-in-progress',
  templateUrl: './work-in-progress.component.html',
  styleUrls: ['./work-in-progress.component.css'],
  animations:[
    trigger('divState', [
      
      state('moveL', style({
        transform: 'translateX(-10%) translateY(-50%)', 
      })),
      transition('spin => move', animate('2000ms ease-out')),
      transition('*=>*', animate('1000ms ease')),
    ])
  ]
})
export class WorkInProgressComponent implements OnInit {
  partitas: PartitaDTO[];
  team: TeamDTO[];
  
  constructor(private service: PartitaService,private tService: TeamService,private t2Service: TeamService) { }

  ngOnInit() {
    this.getPartitas();
    this.getTeam();
  }

  getPartitas() {
    
    this.service.getAll().subscribe(partitas => this.partitas = partitas);
  }

  getTeam() {
    this.tService.getAll().subscribe(teams => this.team = teams);
    
  }
 
}
