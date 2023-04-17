import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Companyview } from 'src/app/model/companyview';
import { watch } from 'src/app/model/Watch';
import { CompanyviewService } from 'src/app/service/companyview.service';
import { StaticService } from 'src/app/service/static.service';

@Component({
  selector: 'app-manageonecompany',
  templateUrl: './manageonecompany.component.html',
  styleUrls: ['./manageonecompany.component.css']
})
export class ManageonecompanyComponent implements OnInit {

  companyViewForm: FormGroup;
  watchListForm:FormGroup;
  trends :String[];
  watchLists : String[];
  capLists : String[];
  companyView:Companyview;
  companyNameParam:string;

  constructor(private router:Router,private formBuilder: FormBuilder,private route:ActivatedRoute,private companyviewService:CompanyviewService,private staticService:StaticService) { }

  ngOnInit(): void {
    this.trends =this.staticService.getTrendPatterns();
    this.watchLists = this.staticService.getWatchListIn();
    this.capLists = this.staticService.getCapPatterns();
    this.companyNameParam = this.route.snapshot.params['id'];
    console.log("request rest call for "+this.companyNameParam);
    this.companyViewForm= this.formBuilder.group({
      companyName:[this.companyNameParam],
      companyDaysAsNumbers:[''],
      companyTrendPattern:[''],
      companyCapSize:[''],
      companyPosition:[''],
      companyWatchlist:[''],
    });

    this.companyviewService.getCompanyViewById(this.companyNameParam)
    .subscribe((data:Companyview )=>{
      console.log("data received : ",data);
      this.companyViewForm = this.formBuilder.group({
        companyDaysAsNumbers: new FormControl(data.companyDaysAsNumbers),
        companyTrendPattern: new FormControl(data.companyTrendPattern),
        companyCapSize: new FormControl(data.companyCapSize), 
        companyPosition: new FormControl(data.companyPosition),
        companyWatchlist: new FormControl(data.companyWatchlist), 
      });
    })
  }
  onSubmit(companyViewForm:any){
    console.log(companyViewForm.value);
    this.companyView =companyViewForm.value;
    this.companyviewService.updateCompanyView(this.companyNameParam,this.companyView)
    .subscribe((data: String)=>{
      this.router.navigate(['googlelive']);
    }) 
  }
  

}
