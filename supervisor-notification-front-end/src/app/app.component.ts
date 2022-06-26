import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Supervisor } from './supervisor';
import { SupervisorService } from './supervisors.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css',
              '../w3.css']
})
export class AppComponent implements OnInit {
  
  title: any;

  constructor() {

  }
  ngOnInit(): void {
    
  }

  
}
