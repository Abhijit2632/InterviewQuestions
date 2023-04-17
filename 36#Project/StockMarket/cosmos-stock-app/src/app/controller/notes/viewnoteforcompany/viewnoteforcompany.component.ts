import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { Note } from 'src/app/model/note';
import { Notes } from 'src/app/model/notes';
import { NotesService } from 'src/app/service/notes.service';

@Component({
  selector: 'app-viewnoteforcompany',
  templateUrl: './viewnoteforcompany.component.html',
  styleUrls: ['./viewnoteforcompany.component.css']
})
export class ViewnoteforcompanyComponent implements OnInit {

  dataSource : MatTableDataSource<Note> = new MatTableDataSource<Note>([]);
  displayedColumns: string[] = ['noteId','companyName','noteDescription','noteTakenTime'];

  @ViewChild(MatSort) sort: MatSort;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  constructor(private route:ActivatedRoute,private noteService:NotesService) { }

  ngOnInit(): void {
    let companyName = this.route.snapshot.params['id'];
    console.log('view notes for : '+companyName);

    this.noteService.getAllNotesForCompany(companyName)
     .subscribe((data: Notes)=>{
       console.log("Got data as response : ",data);
       this.dataSource = new MatTableDataSource(data.notesList);
      this.dataSource.sort=this.sort;
      this.dataSource.paginator=this.paginator; 
     }) 
  }

}
