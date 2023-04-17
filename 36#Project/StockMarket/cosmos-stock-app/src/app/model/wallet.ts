export interface Wallet {
  walletId?:number;
  cash:number;
  isWithdrawal?:boolean;
  txDate?:Date;
  totalCash?:number;
}
