import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Exceldata } from 'src/app/model/exceldata';
import { Exceldatas } from 'src/app/model/exceldatas';
import { GoogleapiliveService } from 'src/app/service/googleapilive.service';
import { saveAs } from 'file-saver';
//import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-googleapilive',
  templateUrl: './googleapilive.component.html',
  styleUrls: ['./googleapilive.component.css']
})
export class GoogleapiliveComponent implements OnInit {

  displayedColumns: string[] = ['companyName','companyLTP','companyOpen','companyHigh','companyLow','companyVolume','companyPreviousClose','addnote','viewnotes','updatecompany'];

  dataSource : MatTableDataSource<Exceldata> = new MatTableDataSource<Exceldata>([]);

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private router:Router, private googleapiliveService:GoogleapiliveService,){}
    //private datepipe: DatePipe){}
  ngOnInit(): void {
    this.googleapiliveService.getAll()
     .subscribe((data: Exceldatas)=>{
       console.log("Got data as response : ",data);
       const blob = new Blob([JSON.stringify(data)], {type : 'application/json'});
       //saveAs(blob, 'abc.json');
       //let currentDateTime =this.datepipe.transform((new Date), 'MM/dd/yyyy h:mm:ss');
    //console.log(currentDateTime);

       var time = new Date();
console.log(
  time.toLocaleString('en-US', { hour: 'numeric', hour12: true })
);  
       this.dataSource = new MatTableDataSource(data.nseExcelDataList);
      this.dataSource.sort=this.sort;
      this.dataSource.paginator=this.paginator; 
     }) 
  }
  applyFilter(event: Event) {
    console.log("apply filter");
    let filterValue=(event.target as HTMLInputElement).value;
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
  onAddNote(companyName:string){
    this.router.navigate(['/takenote',companyName]);
  }
  onViewNotes(companyName:string){
    this.router.navigate(['/viewnotes',companyName]);
  }
  onUpdateToDB(companyName:string){
    this.router.navigate(['/updatecompany',companyName]);
  }

}

