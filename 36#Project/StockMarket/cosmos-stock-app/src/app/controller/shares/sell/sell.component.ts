import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Shareorder } from 'src/app/model/shareorder';
import { ShareService } from 'src/app/service/share.service';

@Component({
  selector: 'app-sell',
  templateUrl: './sell.component.html',
  styleUrls: ['./sell.component.css']
})
export class SellComponent implements OnInit {

  companyName:string;
  sellShareForm:FormGroup;

  constructor(private formBuilder: FormBuilder,private route:ActivatedRoute,private router:Router,private shareService:ShareService) { }

  ngOnInit(): void {
    let companyName = this.route.snapshot.params['id'];
    console.log('add note for : '+companyName);

    this.sellShareForm= this.formBuilder.group({
      companyName:[companyName],
      priceAt:[''],
      quantityOf:[''],
      //totalSpend:[0],
      comment:['']
    });
  }

  onSellShares(shareData:any){
    console.log('Buy order: ',shareData.value);
    this.shareService.sellShare(shareData.value)
     .subscribe((data: Shareorder)=>{
       console.log("Got data as response : ",data);
       this.router.navigate(['/orders']);
     }) 
  }

}
