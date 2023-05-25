import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RetailStoreComponent } from './retail-store/retail-store.component';
import { AddRetailStoreComponent } from './add-retail-store/add-retail-store.component';
import { RouteGuardService } from './services/route-guard.service';
import { LogoutComponent } from './logout/logout.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},

  {path: 'retail-store', component: RetailStoreComponent, canActivate: [RouteGuardService]},
  {path: 'add-retail-store', component: AddRetailStoreComponent, canActivate: [RouteGuardService]},
  {path: 'edit-retail-store/:storeId', component: AddRetailStoreComponent},

  {path: 'logout', component: LogoutComponent, canActivate: [RouteGuardService]},

  {path: '**', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
