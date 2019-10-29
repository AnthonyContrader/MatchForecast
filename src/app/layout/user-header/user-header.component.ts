import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { TeamDTO } from 'src/dto/teamdto';

@Component({
  selector: 'app-user-header',
  templateUrl: './user-header.component.html',
  styleUrls: ['./user-header.component.css']
})
export class UserHeaderComponent implements OnInit {

  user: UserDTO = new UserDTO;
 
  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
    
  }

}