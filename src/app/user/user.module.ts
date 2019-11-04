import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserRoutingModule } from './user-routing.module';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UseraflogComponent } from './useraflog/useraflog.component';
import { ClassificaComponent } from './classifica/classifica.component';

/*import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { TeamsComponent } from './teams/teams.component';
import { PartitasComponent } from './partitas/partitas.component';
import { HistoricalsComponent } from './historicals/historicals.component';*/
/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [UserDashboardComponent, UseraflogComponent, ClassificaComponent, /*UsersComponent,
  TeamsComponent, PartitasComponent,HistoricalsComponent, WorkInProgressComponent*/],
  imports: [
    CommonModule,
    UserRoutingModule,
    FormsModule
  ]
})
export class UserModule { }
