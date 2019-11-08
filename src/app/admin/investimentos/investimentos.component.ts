import { Component, OnInit } from '@angular/core';
import { InvestimentoService } from 'src/service/investimento.service';
import { InvestimentoDTO } from 'src/dto/investimentodto';
import {UserService} from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';

import { SchedinaDTO } from 'src/dto/schedinadto';

@Component({
  selector: 'app-investimentos',
  templateUrl: './investimentos.component.html',
  styleUrls: ['./investimentos.component.css']
})
export class InvestimentosComponent implements OnInit {

 

  

  investimentos: InvestimentoDTO[];
  investimentotoinsert: InvestimentoDTO = new InvestimentoDTO();
  users: UserDTO [];
  
  constructor(private service: InvestimentoService,private tService: UserService) { }

  ngOnInit() {
    this.getInvestimentos();
    this.getUsers();
    
    
  }

  getInvestimentos() {
    
    this.service.getAll().subscribe(investimentos => this.investimentos = investimentos);
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
  console.log(investimento);
    this.service.insert(investimento).subscribe(() => this.getInvestimentos());
  }

  clear(){
    this.investimentotoinsert = new InvestimentoDTO();
  }
}
