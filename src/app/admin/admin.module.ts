import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { TeamsComponent } from './teams/teams.component';
import { PartitasComponent } from './partitas/partitas.component';
import { HistoricalsComponent } from './historicals/historicals.component';
import { InvestimentosComponent } from './investimentos/investimentos.component';
import { SchedinasComponent } from './schedinas/schedinas.component';
import { VistaComponent } from './vista/vista.component';
import { FormUploadComponent } from './upload/form-upload/form-upload.component';
import { ListUploadComponent } from './upload/list-upload/list-upload.component';
import { DetailsUploadComponent } from './upload/details-upload/details-upload.component';
import { ImageComponent } from './image/image.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent,
    TeamsComponent, PartitasComponent,HistoricalsComponent, WorkInProgressComponent, SchedinasComponent, InvestimentosComponent,VistaComponent, FormUploadComponent, ListUploadComponent, DetailsUploadComponent, ImageComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
