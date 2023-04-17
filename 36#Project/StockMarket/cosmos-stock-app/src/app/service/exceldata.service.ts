import { HttpClient, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { catchError, throwError } from 'rxjs';
import { baseUrl } from 'src/environments/environment';
import { Exceldatas } from '../model/exceldatas';
import { NSEExcelDatas } from '../model/nseexcel-datas';

@Injectable({
  providedIn: 'root'
})
export class ExceldataService {
  
  excaldatas:Exceldatas;

  constructor(private http: HttpClient) { }
  getExcelDataUrl = baseUrl+"/excel/";
  getExcelDataNewUrl = baseUrl+"/readexceldata/date/";
  getAllExcelData(dateData:any) {
    let updatedUrl = this.getExcelDataNewUrl+dateData.dateValue;
    console.log(dateData.dateValue);
    console.log(updatedUrl)
    return this.http.get<NSEExcelDatas>(updatedUrl).pipe(catchError(this.handleError));
  }
  getAllExcelDataForDate(date: string) {
    let updatedUrl = this.getExcelDataNewUrl+date;
    console.log(updatedUrl)
    return this.http.get<Exceldatas>(updatedUrl).pipe(catchError(this.handleError));
  }
  getAllExcelDataBetweenaRange(rangeData:any) {
    const params = new HttpParams()
   .set('p1', rangeData.startValue)
   .set('p2', rangeData.endValue);
   console.log("call to static data");
    return this.http.get<Exceldatas>(this.getExcelDataUrl+'rangebetween',{params}).pipe(catchError(this.handleError));
  }
  /* getAllExcelDataBetweenaDefaultRange() {
    const params = new HttpParams()
   .set('p1', 0)
   .set('p2', 100000);
   console.log("call to backend");
  this.http.get<Exceldatas>(this.getExcelDataUrl+'rangebetween',{params}).pipe(catchError(this.handleError))
   .subscribe((data: Exceldatas)=>{
    console.log("WTF ",data.nseExcelObjectList);
    this.excaldatas=data;
    console.log("WTF again 01");
  });
  return this.excaldatas;
  } */

  

  private handleError(httpError: HttpErrorResponse) {
    if (httpError.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', httpError.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${httpError.status}, ` +
        `body was: ${httpError.error}`);
    }
    // Return an observable with a user-facing error message.
    return throwError('Something bad happened; please try again later.');
  }
  
}
