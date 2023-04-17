import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Company } from 'src/app/model/company';
import { Exceldata } from 'src/app/model/exceldata';
import { Exceldatas } from 'src/app/model/exceldatas';
import { CompanyService } from 'src/app/service/company.service';
import { ExceldataService } from 'src/app/service/exceldata.service';

@Component({
  selector: 'app-fetchall',
  templateUrl: './fetchall.component.html',
  styleUrls: ['./fetchall.component.css']
})
export class FetchallComponent implements OnInit {

  dateForm:FormGroup;

  dataSource : MatTableDataSource<Exceldata> = new MatTableDataSource<Exceldata>([]);
  displayedColumns: string[] = ['companyName','companyLTP','companyOpen','companyHigh','companyLow','companyVolume','companyPreviousClose','update','addnote','viewnotes'];

  constructor(private formBuilder: FormBuilder,private router:Router,private exceldataService:ExceldataService,private companyService:CompanyService) { }


  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  ngOnInit(): void {
    let date ="21-08-2022";
    this.dateForm= this.formBuilder.group({
      dateValue:['']
    });
    this.exceldataService.getAllExcelDataForDate(date)
     .subscribe((data: Exceldatas)=>{
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
  onUpdate(company:Company){
    console.log("Calling rest call to update.."+company.companyName);

    this.companyService.saveCompany(company.companyName)
    .subscribe((data: Company)=>{
         console.log(data);
       });
  }
  onDateExcelData(dateData:any){
    this.exceldataService.getAllExcelDataForDate(dateData.dateValue)
    .subscribe((data: Exceldatas)=>{
      this.dataSource = new MatTableDataSource(data.nseExcelDataList);
      this.dataSource.sort=this.sort;
      this.dataSource.paginator=this.paginator; 
    })

  }
  onAddNote(company:Company){
    console.log("Add Note for company: "+company.companyName);
    this.router.navigate(['/takenote',company.companyName]);
  }
  onViewNotes(company:Company){
    console.log("Add Note for company: "+company.companyName);
    this.router.navigate(['/viewnotes',company.companyName]);
  }

}
