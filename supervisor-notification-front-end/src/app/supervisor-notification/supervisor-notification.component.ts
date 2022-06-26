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
 
  /**
   * Constructor
   * 
   * @param supervisorService 
   */
  constructor(private supervisorService: SupervisorService) { }

  /**
   * As soon as this component is initialized,
   * reach out and attempt to get the supervisors
   */
  ngOnInit(): void {

    this.getSupervisors();

  }

  /**
   * This function reaches out to the backend to get an Array of supervisors
   */
  public getSupervisors(): void {

    // If the retrieval was successful, simply set the supervisors field, if an error was
    // returned, alert the user of the error
    this.supervisorService.getSupervisors().subscribe(
      (response: Supervisor[]) => {
        this.supervisors = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    )

  }

  /**
   * This function submits the value of the component's form and awaits a submission reply
   * 
   * @param submitForm 
   */
  public onSubmitRequest(submitForm: NgForm): void
  {
      this.supervisorService.submitRequest(submitForm.value)
      .subscribe(
        (response: any) => {
          // Alert the user of the response's message
          alert(response.responseMessage);
          // Clear out the form
          this.resetForm();
        },
        (error: HttpErrorResponse) => {
          // Alert the user of the error
          alert(error.error);
        }
      );
  }

  /**
   * A convenience method to reset the form in this component
   */
  public resetForm() : void {

    let modal = document.getElementById('request-form-modal');
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

  } 
  

}


