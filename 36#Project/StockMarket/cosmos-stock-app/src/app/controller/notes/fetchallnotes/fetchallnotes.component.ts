import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Router } from '@angular/router';
import { Note } from 'src/app/model/note';
import { Notes } from 'src/app/model/notes';
import { NotesService } from 'src/app/service/notes.service';

@Component({
  selector: 'app-fetchallnotes',
  templateUrl: './fetchallnotes.component.html',
  styleUrls: ['./fetchallnotes.component.css']
})
export class FetchallnotesComponent implements OnInit {

  dataSource : MatTableDataSource<Note> = new MatTableDataSource<Note>([]);
  displayedColumns: string[] = ['noteId','companyName','noteDescription','noteTakenTime'];

  constructor(private formBuilder: FormBuilder,private router:Router,private noteService:NotesService) { }


  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  ngOnInit(): void {
    this.noteService.getAllNotes()
     .subscribe((data: Notes)=>{
      console.log("received all entries for 27th July ",data);
       this.dataSource = new MatTableDataSource(data.notesList);
     }) 
  }
  applyFilter(event: Event) {
    console.log("apply filter");
    let filterValue=(event.target as HTMLInputElement).value;
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

}
