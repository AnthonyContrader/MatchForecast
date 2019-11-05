import { Component, OnInit } from '@angular/core';
import { SchedinaService } from 'src/service/schedina.service';
import { SchedinaDTO } from 'src/dto/schedinadto';
import { PartitaDTO } from 'src/dto/partitadto';
import { PartitaService } from 'src/service/partita.service';


@Component({
  selector: 'app-schedinas',
  templateUrl: './schedinas.component.html',
  styleUrls: ['./schedinas.component.css']
})
export class SchedinasComponent implements OnInit {

  schedinas: SchedinaDTO[];
  schedinatoinsert: SchedinaDTO =new  SchedinaDTO();
  partitas: PartitaDTO [];
  
  constructor(private service: SchedinaService,private pService: PartitaService) { }

  ngOnInit() {

    this.getSchedinas();
    this.getPartitas();

      }
    
      getSchedinas(){
        this.service.getAll().subscribe(schedinas => this.schedinas = schedinas);
      }

      getPartitas(){
        this.pService.getAll().subscribe(partitas => this.partitas=partitas);
      }

      delete(schedina: SchedinaDTO){
        this.service.delete(schedina.id).subscribe(() => this.getSchedinas());
      }
    update(schedina: SchedinaDTO) {
      this.service.update(schedina).subscribe(() => this.getSchedinas());
    }
    insert(schedina: SchedinaDTO) {
console.log(schedina);
      this.service.insert(schedina).subscribe(()=> this.getSchedinas());
    }
    clear(){
      this.schedinatoinsert = new SchedinaDTO;
    }
  }


