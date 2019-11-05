import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UseraflogComponent } from './useraflog/useraflog.component';
import { UsersComponent } from '../admin/users/users.component';
import { WorkInProgressComponent } from '../admin/work-in-progress/work-in-progress.component';
import { HistoricalsComponent } from '../admin/historicals/historicals.component';
import { PartitasComponent } from '../admin/partitas/partitas.component';
import { TeamsComponent } from '../admin/teams/teams.component';
import { SchedinasComponent } from '../admin/schedinas/schedinas.component';

/*
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [UserDashboardComponent, UseraflogComponent/*, UsersComponent,*
  TeamsComponent, PartitasComponent,HistoricalsComponent, WorkInProgressComponent, SchedinasComponent*/],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule
  ]
})
export class UserModule { }
