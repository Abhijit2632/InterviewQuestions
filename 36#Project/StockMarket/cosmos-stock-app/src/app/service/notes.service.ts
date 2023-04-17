import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, throwError } from 'rxjs';
import { baseUrl } from 'src/environments/environment';
import { Note } from '../model/note';
import { Notes } from '../model/notes';

@Injectable({
  providedIn: 'root'
})
export class NotesService {

  constructor(private http: HttpClient) { }
  getNotesNewUrl = baseUrl+"/notes/";
  saveNote(note:Note) {
    let saveNotesUrl = this.getNotesNewUrl+"save";
    console.log(saveNotesUrl);
    return this.http.post<Note>(saveNotesUrl,note).pipe(catchError(this.handleError));
  }
  getAllNotes() {
    return this.http.get<Notes>(this.getNotesNewUrl).pipe(catchError(this.handleError));
  }
  getAllNotesForCompany(companyName: string) {
    return this.http.get<Notes>(this.getNotesNewUrl+'bycompany/'+companyName).pipe(catchError(this.handleError));
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
