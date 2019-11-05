import { Component, OnInit } from '@angular/core';
import { InvestimentoDTO } from 'src/dto/investimentodto';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-useraflog',
  templateUrl: './useraflog.component.html',
  styleUrls: ['./useraflog.component.css']
})
export class UseraflogComponent implements OnInit {

  investimento: InvestimentoDTO;
  

  constructor( private router: Router) { }

  ngOnInit() {
  }


  nv(f: NgForm) : void {

    this.router.navigate(['/user-dashboard']);
           

  }

}
