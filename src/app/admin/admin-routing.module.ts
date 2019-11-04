import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { TeamsComponent } from './teams/teams.component';
import { PartitasComponent } from './partitas/partitas.component';
import { HistoricalsComponent } from './historicals/historicals.component';
import { InvestimentosComponent } from './investimentos/investimentos.component';
import { SchedinasComponent } from './schedinas/schedinas.component';
import { VistaComponent } from './vista/vista.component';
import { ImageComponent } from './image/image.component';


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
  { path: 'admin-dashboard', component: AdminLayoutComponent, children:[
    { path: '', component: AdminDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'teams', component: TeamsComponent},
    { path: 'partitas', component: PartitasComponent},
    { path: 'historicals', component: HistoricalsComponent},
    {path: 'schedinas', component: SchedinasComponent},
    {path: 'investimentos', component: InvestimentosComponent},
    { path: 'work-in-progress', component: WorkInProgressComponent},
    {path: 'vista', component: VistaComponent}, 
    {path: 'image', component: ImageComponent}, 

    
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }