import { Component, OnInit } from '@angular/core';
import { InvestimentoService } from 'src/service/investimento.service';
import { InvestimentoDTO } from 'src/dto/investimentodto';
import {UserService} from 'src/service/user.service';
import { UserDTO } from 'src/dto/userdto';
import {SchedinaService} from 'src/service/schedina.service';
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
  schedinas: SchedinaDTO [];
  constructor(private service: InvestimentoService,private tService: UserService,private t2Service: SchedinaService) { }

  ngOnInit() {
    this.getInvestimentos();
    this.getUsers();
    this.getSchedinas();
    
  }

  getInvestimentos() {
    
    this.service.getAll().subscribe(investimentos => this.investimentos = investimentos);
  }

  getUsers() {
    this.tService.getAll().subscribe(users => this.users = users);
    
  }

  getSchedinas() {
   
    this.t2Service.getAll().subscribe(schedinas => this.schedinas = schedinas);
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
