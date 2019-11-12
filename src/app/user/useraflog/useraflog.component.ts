import { Component, OnInit } from '@angular/core';
import { InvestimentoService } from 'src/service/investimento.service';
import { InvestimentoDTO } from 'src/dto/investimentodto';
import {UserService} from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';

import { SchedinaDTO } from 'src/dto/schedinadto';

@Component({
  selector: 'app-useraflog',
  templateUrl: './useraflog.component.html',
  styleUrls: ['./useraflog.component.css']
})
export class UseraflogComponent implements OnInit {

 

  
  investimento: InvestimentoDTO;
  investimentos: InvestimentoDTO[];
  investimentotoinsert: InvestimentoDTO = new InvestimentoDTO();
  users: UserDTO [];
  user: UserDTO;

  constructor(private service: InvestimentoService,private tService: UserService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('AUTOKEN'));
    console.log(this.user);
    console.log(localStorage);
    this.getInvestimentos();
    this.getUsers();
    
    
  }

  getInvestimentos() {
    if (this.user.id == this.investimento.iduser) {
    this.service.getAll().subscribe(investimentos => this.investimentos = investimentos);
    }
  }

  getUsers() {
    
    this.tService.getAll().subscribe(users => this.users = users);
    
  }

 
  delete(investimento: InvestimentoDTO) {
    this.service.delete(investimento.id).subscribe(() => this.getInvestimentos());
  }

  update(investimento: InvestimentoDTO) {
   
    this.service.update(investimento).subscribe(() => this.getInvestimentos());
  }

  insert(investimento: InvestimentoDTO) {
    investimento.iduser = this.user.id;
  console.log(investimento);
  console.log(this.user);
    this.service.insert(investimento).subscribe(() => this.getInvestimentos());
  }

  clear(){
    this.investimentotoinsert = new InvestimentoDTO();
  }
}
