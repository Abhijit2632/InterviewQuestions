import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { Shareorder } from 'src/app/model/shareorder';
import { Shareorders } from 'src/app/model/shareorders';
import { ShareService } from 'src/app/service/share.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  dataSource : MatTableDataSource<Shareorder> = new MatTableDataSource<Shareorder>([]);
  displayedColumns: string[] = ['orderId','companyName','orderType','priceAt','quantityOf','totalSpend','comment','orderedAt','orderStatus','viewnotes','buy','sell'];

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  constructor(private route:ActivatedRoute,private shareService:ShareService,private router:Router) { }

  ngOnInit(): void {

    this.shareService.getAllOrders()
     .subscribe((data: Shareorders)=>{
       console.log("Got data as response : ",data);
       this.dataSource = new MatTableDataSource(data.shareorderList);
      this.dataSource.sort=this.sort;
      this.dataSource.paginator=this.paginator; 
     }) 
  }
  onSellshare(companyName:string){
    this.router.navigate(['/sellshare',companyName]);
  }
  onBuy(companyName:string){
    console.log("Buy shares from this company",companyName);
    this.router.navigate(['/buyshare',companyName]);
  }
  onViewNotes(companyName:string){
    this.router.navigate(['/viewnotes',companyName]);
  }
}
