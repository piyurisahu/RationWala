import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditProfileComponent } from './account/edit-profile.component';
import { HomeComponent, OrdersComponent } from './home';
import { StoreOrdersComponent } from './home/store-orders.component';
import { AuthGuard } from './_helpers';


const accountModule = () => import('./account/account.module').then(x => x.AccountModule);

const routes: Routes = [
    { path: '', component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'orders', component: OrdersComponent, canActivate: [AuthGuard] },
    { path: 'store-orders', component: StoreOrdersComponent, canActivate: [AuthGuard] },
    { path: 'edit-profile', component: EditProfileComponent, canActivate: [AuthGuard] },
    { path: 'account', loadChildren: accountModule },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
    exports: [RouterModule]
})
export class AppRoutingModule { }