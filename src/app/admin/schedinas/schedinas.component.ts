import { Component, OnInit } from '@angular/core';
import { SchedinaService } from 'src/service/schedina.service';
import { SchedinaDTO } from 'src/dto/schedinadto';

@Component({
  selector: 'app-schedinas',
  templateUrl: './schedinas.component.html',
  styleUrls: ['./schedinas.component.css']
})
export class SchedinaComponent implements OnInit {

  schedinas: SchedinaDTO[];
  schedinatoinsert: SchedinaDTO =new  SchedinaDTO();

  
  constructor(private service: SchedinaService) { }

  ngOnInit() {
    this.getSchedinas();
      }
    
      getSchedinas(){
        this.service.getAll().subscribe(schedinas => this.schedinas = schedinas);
      }

      delete(schedina: SchedinaDTO){
        this.service.delete(schedina.id).subscribe(() => this.getSchedinas());
      }
    update(schedina: SchedinaDTO) {
      this.service.update(schedina).subscribe(() => this.getSchedinas());
    }
    insert(schedina: SchedinaDTO) {

      this.service.insert(schedina).subscribe(()=> this.getSchedinas());
    }
    clear(){
      this.schedinatoinsert = new SchedinaDTO;
    }
  }


