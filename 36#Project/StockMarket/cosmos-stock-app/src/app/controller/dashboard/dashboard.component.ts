import { Component, OnInit } from '@angular/core';
import { Tile } from 'src/app/model/Tile';
import { StaticService } from 'src/app/service/static.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})


export class DashboardComponent implements OnInit {
  investedText = `Get From Backend!!`;
  tiles: Tile[] = [
    {text: this.investedText, cols: 3, rows: 1, color: 'lightblue'},
    {text: 'Two', cols: 1, rows: 2, color: 'lightgreen'},
    {text: 'Three', cols: 1, rows: 1, color: 'lightpink'},
    {text: 'Four', cols: 2, rows: 1, color: '#DDBDF1'},
  ];

  

  constructor(private staticdata:StaticService) { }

  ngOnInit(): void {
  }
  onGetTotalInvestment(){
    
  }

}
