import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Note } from 'src/app/model/note';
import { Notes } from 'src/app/model/notes';
import { NotesService } from 'src/app/service/notes.service';

@Component({
  selector: 'app-takenote',
  templateUrl: './takenote.component.html',
  styleUrls: ['./takenote.component.css']
})
export class TakenoteComponent implements OnInit {
  noteForm:FormGroup;

  constructor(private formBuilder: FormBuilder,private route:ActivatedRoute,private noteService:NotesService) { }

  ngOnInit(): void {
    let companyName = this.route.snapshot.params['id'];
    console.log('add note for : '+companyName);

    this.noteForm= this.formBuilder.group({
      companyName:[companyName],
      noteDescription:[''],
    });
  }
  onAddNote(noteData:any){
    console.log("Add this note for today",noteData.value);
    this.noteService.saveNote(noteData.value)
     .subscribe((data: Note)=>{
       console.log("Got data as response : ",data);
     }) 

  }

}
