import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserLayoutComponent } from '../layout/user-layout/user-layout.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { UseraflogComponent } from './useraflog/useraflog.component';
import { UsersComponent } from '../admin/users/users.component';
import { TeamsComponent } from '../admin/teams/teams.component';
import { PartitasComponent } from '../admin/partitas/partitas.component';
import { HistoricalsComponent } from '../admin/historicals/historicals.component';
import { WorkInProgressComponent } from '../admin/work-in-progress/work-in-progress.component';
import { SchedinasComponent } from '../admin/schedinas/schedinas.component';
import { ClassificaComponent } from './classifica/classifica.component';




/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  {path:'useraflog', component:UseraflogComponent},
  { path: 'user-dashboard', component: UserLayoutComponent, children:[
    { path: '', component: UserDashboardComponent},
    {path:'classifica', component:ClassificaComponent},
   // { path: 'users', component: UsersComponent},
    { path: 'teams', component: TeamsComponent},
    { path: 'partitas', component: PartitasComponent},
    { path: 'historicals', component: HistoricalsComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent},
    { path: 'schedinas', component: SchedinasComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }