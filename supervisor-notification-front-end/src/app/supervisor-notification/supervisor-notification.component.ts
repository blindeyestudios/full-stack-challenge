import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { NotificationRequest } from '../NotificationRequest';
import { Supervisor } from '../supervisor';
import { SupervisorService } from '../supervisors.service';

@Component({
  selector: 'app-supervisor-notification',
  templateUrl: './supervisor-notification.component.html',
  styleUrls: ['./supervisor-notification.component.css',
            '../../w3.css']
})
export class SupervisorNotificationComponent implements OnInit {

  public supervisors!: Supervisor[];
 

  constructor(private supervisorService: SupervisorService) { }

  ngOnInit(): void {
    this.getSupervisors();
  }

  

  public getSupervisors(): void {
    this.supervisorService.getSupervisors().subscribe(
      (response: Supervisor[]) => {
        this.supervisors = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )
  }

  public onSubmitRequest(submitForm: NgForm): void
  {
      this.supervisorService.submitRequest(submitForm.value)
      .subscribe(
        (response: any) => {
          alert(response.responseMessage);
          let modal = document.getElementById('id01');
          let form : HTMLFormElement = <HTMLFormElement>document.getElementById('notification-form');
          let select : HTMLSelectElement = <HTMLSelectElement>document.getElementById('supervisor-select');
          if (modal != null)
          {
            modal.style.display='none';
          }
          if (form != null)
          {
            form.reset();
          }
          if (select != null)
          {
            select.value = "";
          }
        },
        (error: HttpErrorResponse) => {
          alert(error.error);
        }
      );
  }

      
  

}


