import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './controller/admin/admin.component';
import { ManageonecompanyComponent } from './controller/company/manageonecompany/manageonecompany.component';
import { DashboardComponent } from './controller/dashboard/dashboard.component';
import { FetchallComponent } from './controller/excel/fetchall/fetchall.component';
import { GoogleapiliveComponent } from './controller/googleapilive/googleapilive.component';
import { FetchallnotesComponent } from './controller/notes/fetchallnotes/fetchallnotes.component';
import { TakenoteComponent } from './controller/notes/takenote/takenote.component';
import { ViewnoteforcompanyComponent } from './controller/notes/viewnoteforcompany/viewnoteforcompany.component';
import { OrdersComponent } from './controller/orders/orders.component';
import { BuyComponent } from './controller/shares/buy/buy.component';
import { SellComponent } from './controller/shares/sell/sell.component';
import { WatchlistComponent } from './controller/watchlist/watchlist.component';

const routes: Routes = [
  { path: 'dashboard', component: DashboardComponent },
  { path: 'admin', component: AdminComponent },
  { path: 'exceldata', component: FetchallComponent },
  { path: 'notes', component: FetchallnotesComponent },
  { path: 'googlelive', component: GoogleapiliveComponent },
  { path: 'watchlist', component: WatchlistComponent },
  { path: 'orders', component: OrdersComponent },
  

  {path: "updatecompany/:id", component: ManageonecompanyComponent},
  {path: "takenote/:id", component: TakenoteComponent},
  {path: "viewnotes/:id", component: ViewnoteforcompanyComponent},

  {path: "buyshare/:id", component: BuyComponent},
  {path: "sellshare/:id", component: SellComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
