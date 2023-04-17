import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Companies } from 'src/app/model/companies';
import { Companyview } from 'src/app/model/companyview';
import { Companyviews } from 'src/app/model/companyviews';
import { EnhancedCompanyDetailss } from 'src/app/model/EnhancedCompanyDetailss';
import { Exceldatas } from 'src/app/model/exceldatas';
import { CompanyviewService } from 'src/app/service/companyview.service';
import { StaticService } from 'src/app/service/static.service';

@Component({
  selector: 'app-watchlist',
  templateUrl: './watchlist.component.html',
  styleUrls: ['./watchlist.component.css']
})
export class WatchlistComponent implements OnInit {

  displayedColumns: string[] = ['companyPosition','companyName','companyTrendPattern','companyDaysAsNumbers','AddAlert','ViewAlerts','viewnotes','Buy'];
  watchlistForm:FormGroup;
  watchLists:String[];
  viewData:boolean=false;

  dataSource : MatTableDataSource<Companyview> = new MatTableDataSource<Companyview>([]);

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private formBuilder: FormBuilder,private router:Router, private companyviewService:CompanyviewService,private staticService:StaticService) { }

  ngOnInit(): void {
    this.watchLists = this.staticService.getWatchListIn();
    this.watchlistForm= this.formBuilder.group({
      companyWatchListIn:[''],
    });
    /* this.companyviewService.getAllCompanies()
     .subscribe((data: Companyviews)=>{
      console.log("Got response ",data);
      this.dataSource = new MatTableDataSource(data.companyList);
      this.dataSource.sort=this.sort;
      this.dataSource.paginator=this.paginator; 
     })  */
  }
  onSubmit(watchlistForm:any){
    this.viewData=true;
    this.companyviewService.getCompaniesByWatchList(watchlistForm.value.companyWatchListIn)
    .subscribe((data: Companyviews)=>{
      console.log("Got response ",data);
      this.dataSource = new MatTableDataSource(data.companyList);
      this.dataSource.sort=this.sort;
      this.dataSource.paginator=this.paginator; 
      //this.router.navigate(['googlelive']);
    }) 
    this.companyviewService.getEnhancedCompaniesByWatchList(watchlistForm.value.companyWatchListIn)
    .subscribe((data)=>{
      console.log("Got response enhanced",data);
    },
    error => {
        console.log('failed');
        console.log(error.message);
    });
  }
  applyFilter(event: Event) {
    console.log("apply filter");
    let filterValue=(event.target as HTMLInputElement).value;
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
  onAddAlert(companyName:string){
    console.log("Add Alert for this company",companyName);
    this.router.navigate(['/addaleart',companyName]);
  }
  onBuy(companyName:string){
    console.log("Buy shares from this company",companyName);
    this.router.navigate(['/buyshare',companyName]);
  }
  onViewNotes(companyName:string){
    this.router.navigate(['/viewnotes',companyName]);
  }

}
