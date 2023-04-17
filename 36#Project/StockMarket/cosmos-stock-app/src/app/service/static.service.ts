import { Injectable } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Companies } from '../model/companies';
import { Company } from '../model/company';

@Injectable({
  providedIn: 'root'
})
export class StaticService {
  
  constructor(private formBuilder: FormBuilder) { }

  getUserDetails(){
    return "Abhijit";
  }
  getTrendPatterns(){
    let patterns : String[] =["UpSide",'DownSide','SideWays'];
    return patterns;
  }
  getCapPatterns(){
    let patterns : String[] =["MidCap",'SmallCap','LargeCap'];
    return patterns;
  }
  getWatchListIn(){
    let watchList:String[] =['IT_Longterm','IT_Growth',
                              'Banking','Private_Banks','Finance','MutualFunds',
                              'LTThan1000','Popular','Popular2',
                              'Monopoly','Govt',
                              'MayBe','Radar', 'Recommendation','MustBuy',
                              'BigHouse','Adani','Tata','Mahindra','Bajaj',
                              'Electronics','Paints','Cement'];
    return watchList;
  }
  getWatchListClass(){
    return this.formBuilder.group({
      IT_Longterm : false,
    IT_Growth: false,
    Banking: false,
    Private_Banks : false,
    Finance: false,
    MutualFunds: false,
    LTThan1000 : false,
    Popular: false,
    Popular2: false,
    Monopoly : false,
    Govt: false,
    MayBe: false,
    Radar : false,
    Recommendation: false,
    MustBuy: false,
    BigHouse : false,
    Adani: false,
    Tata: false,
    Mahindra : false,
    Bajaj: false,
    Electronics: false,
    Paints : false,
    Cement: false,
    });
    
  }
}
