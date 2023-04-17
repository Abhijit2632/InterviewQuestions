export interface Shareorder {
      orderId:string;
      orderType:string;
      companyName:string;
      priceAt:number;
      quantityOf:number;
      totalSpend:number;
      comment:string;
      orderedAt:Date;
      orderStatus:boolean;
}