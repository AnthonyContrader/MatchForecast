import { Component, OnInit } from '@angular/core';
import { HistoricalService } from 'src/service/historical.service';
import { HistoricalDTO } from 'src/dto/historicaldto';
import { PartitaDTO    } from 'src/dto/partitadto';
import { PartitaService } from 'src/service/partita.service';

@Component({
  selector: 'app-historicals',
  templateUrl: './historicals.component.html',
  styleUrls: ['./historicals.component.css']
})
export class HistoricalsComponent implements OnInit {

  historicals: HistoricalDTO[];
  historicaltoinsert: HistoricalDTO = new HistoricalDTO();
  partitas : PartitaDTO[];
  constructor(private service: HistoricalService,private pService: PartitaService) { }

  ngOnInit() {
    this.getHistoricals();
    this.getPartitas();
  }

  getHistoricals() {
    this.service.getAll().subscribe(historicals => this.historicals = historicals);
  }

  getPartitas() {
    this.pService.getAll().subscribe(partitas => this.partitas = partitas);
  }

  delete(historical: HistoricalDTO) {
    this.service.delete(historical.idHistorical).subscribe(() => this.getHistoricals());
  }

  update(historical: HistoricalDTO) {
    this.service.update(historical).subscribe(() => this.getHistoricals());
  }

  insert(historical: HistoricalDTO) {
    this.service.insert(historical).subscribe(() => this.getHistoricals());
  }

  clear(){
    this.historicaltoinsert = new HistoricalDTO();
  }
}