import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { baseUrl } from 'src/environments/environment';
import { Note } from '../model/note';
import { Shareorder } from '../model/shareorder';
import { Shareorders } from '../model/shareorders';

@Injectable({
  providedIn: 'root'
})
export class ShareService {
  shareUrl = baseUrl+"/share/";
  
  constructor(private http: HttpClient) { }

  buyShare(value: any) {
    let saveShareUrl = this.shareUrl+"buy";
    return this.http.post<Shareorder>(saveShareUrl,value).pipe(catchError(this.handleError));
  }
  sellShare(value: any) {
    let sellShareUrl = this.shareUrl+"sell";
    return this.http.post<Shareorder>(sellShareUrl,value).pipe(catchError(this.handleError));
  }
  getAllOrders() {
    let getAllOrders = this.shareUrl+"orders";
    return this.http.get<Shareorders>(getAllOrders).pipe(catchError(this.handleError));
  }
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
