import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { NotificationRequest } from './NotificationRequest';
import { Supervisor } from './supervisor';

/**
 * This class is the Supervisor service for the front-end.
 * It handles reaching out to the back end and RESTfully waiting for responses.
 */
@Injectable({
  providedIn: 'root'
})
export class SupervisorService {
  
  // Use the API base URL that we set in the environment file
  private apiServerURL = environment.apiBaseUrl;

  postId: any;

  /**
   * Constructor that takes the HttpClient injection
   * 
   * @param http 
   */
  constructor(private http: HttpClient) {}

  /**
   * This function reaches out to an endpoint to retrieve an Array of Supervisors
   * 
   * @returns 
   */
  public getSupervisors() : Observable<Supervisor[]> {

      return this.http.get<Supervisor[]>(`${this.apiServerURL}/api/supervisors`);

  }

  /**
   * This function takes a NotificationRequest submission and sends it to the endpoint
   * for handling
   * 
   * @param notificationRequest 
   * @returns 
   */
  public submitRequest(notificationRequest: NotificationRequest) {
    
    return this.http.post<NotificationRequest>(`${this.apiServerURL}/api/submit`, notificationRequest);
    
  }
}
