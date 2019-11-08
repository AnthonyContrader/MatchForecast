import { Component, OnInit } from '@angular/core';
import { InvestimentoDTO } from 'src/dto/investimentodto';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { InvestimentoService } from 'src/service/investimento.service';
import { SchedinaService } from 'src/service/schedina.service';
import { UserDTO } from 'src/dto/userdto';
import { SchedinaDTO } from 'src/dto/schedinadto';
import { UserService } from 'src/service/user.service';

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
  schedinas: SchedinaDTO [];
  schedina: SchedinaDTO;

  constructor(private service: InvestimentoService, private router: Router, private t2Service: SchedinaService, 
    private tService: UserService) { }

  

  ngOnInit() {

    this.user = JSON.parse(localStorage.getItem('currentUser'));
    this.schedina = JSON.parse(localStorage.getItem('currentSchedina'));

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
  
  
  nv(investimento: InvestimentoDTO) : void {

    this.router.navigate(['/user-dashboard']);
    investimento.user = this.user;
    
    console.log(investimento);
    this.service.insert(investimento).subscribe(() => this.getInvestimentos());       

  }

}
