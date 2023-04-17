import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Shareorder } from 'src/app/model/shareorder';
import { ShareService } from 'src/app/service/share.service';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {
  buyShareForm:FormGroup;
  //total:number;
  //nConfirm:boolean=false;

  constructor(private formBuilder: FormBuilder,private route:ActivatedRoute,private router:Router,private shareService:ShareService) { }

  ngOnInit(): void {
    let companyName = this.route.snapshot.params['id'];
    console.log('add note for : '+companyName);

    this.buyShareForm= this.formBuilder.group({
      companyName:[companyName],
      priceAt:[''],
      quantityOf:[''],
      //totalSpend:[0],
      comment:['']
    });
  }
  onBuyShares(shareData:any){
    console.log('Buy order: ',shareData.value);
    this.shareService.buyShare(shareData.value)
     .subscribe((data: Shareorder)=>{
       console.log("Got data as response : ",data);
       this.router.navigate(['/orders']);
     }) 
  }
  /* onClickEvent(shareData:any){
    console.log('add note for : ',shareData.value);
    this.onConfirm=true;
    this.total=shareData.value.priceAt*shareData.value.quantityOf;
  } */

}
