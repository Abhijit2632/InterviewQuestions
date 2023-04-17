import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { baseUrl } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class GoogleapiliveService {
  constructor(private http: HttpClient) { }
  getGoogleDataUrl = "https://script.google.com/macros/s/AKfycbwbizsypFtE4TsMFsbiU5Idxoup5ASx8qxH-kszD900lv2MFdKjE_GO-5mE7f22lMFm/exec";
  getAll() {
    return this.http.get<any>(this.getGoogleDataUrl).pipe(catchError(this.handleError));
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
