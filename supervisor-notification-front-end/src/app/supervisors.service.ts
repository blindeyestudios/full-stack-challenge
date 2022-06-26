import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { NotificationRequest } from './NotificationRequest';
import { Supervisor } from './supervisor';

@Injectable({
  providedIn: 'root'
})
export class SupervisorService {
  
  private apiServerURL = environment.apiBaseUrl;
  postId: any;

  constructor(private http: HttpClient) {}

  public getSupervisors() : Observable<Supervisor[]> {
      return this.http.get<Supervisor[]>(`${this.apiServerURL}/api/supervisors`);
  }

  public submitRequest(notificationRequest: NotificationRequest) {
    
    return this.http.post<NotificationRequest>(`${this.apiServerURL}/api/submit`, notificationRequest);
    
  }
}
