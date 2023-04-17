import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { DashboardComponent } from './controller/dashboard/dashboard.component';
import { AdminComponent } from './controller/admin/admin.component';
import { HttpClientModule } from '@angular/common/http';
import { ManageonecompanyComponent } from './controller/company/manageonecompany/manageonecompany.component';
import { TakenoteComponent } from './controller/notes/takenote/takenote.component';
import { FetchallComponent } from './controller/excel/fetchall/fetchall.component';
import { FetchallnotesComponent } from './controller/notes/fetchallnotes/fetchallnotes.component';
import { ViewnoteforcompanyComponent } from './controller/notes/viewnoteforcompany/viewnoteforcompany.component';
import { GoogleapiliveComponent } from './controller/googleapilive/googleapilive.component';
import { WatchlistComponent } from './controller/watchlist/watchlist.component';
import { BuyComponent } from './controller/shares/buy/buy.component';
import { SellComponent } from './controller/shares/sell/sell.component';
import { OrdersComponent } from './controller/orders/orders.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    AdminComponent,
    ManageonecompanyComponent,
    TakenoteComponent,
    FetchallComponent,
    FetchallnotesComponent,
    ViewnoteforcompanyComponent,
    GoogleapiliveComponent,
    WatchlistComponent,
    BuyComponent,
    SellComponent,
    OrdersComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    MaterialModule,
    BrowserAnimationsModule,
    HttpClientModule, 
    
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule { }
