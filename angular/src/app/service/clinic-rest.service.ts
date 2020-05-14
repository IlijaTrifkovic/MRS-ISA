import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClinicRestService {
  url = environment.baseUrl;
  clinicUrl= '/clinic';
  medicalAppointmentUrl= "/appointment";
  appointmentUrl="/patient/appointment";

  constructor(private http: HttpClient) { }
  getClinic(pageNumber,pageSize,sortBy,sortType): Observable<any> {
    return this.http.get(this.url + this.clinicUrl+"?page="+pageNumber+"&size="+pageSize+
    "&sort="+sortBy+","+sortType);
  }

  getClinicById(id):Observable<any>{
    return this.http.get(this.url + this.clinicUrl+"/"+id);
  }

  getAppointment(id):Observable<any>{
    return this.http.get(this.url + this.medicalAppointmentUrl+"/"+id);
  }

  scheduleAppointment(id):Observable<any>{
    return this.http.get(this.url + this.appointmentUrl+"/"+id);
  }

  getPatientAppointment(pageNumber,pageSize,sortBy,sortType):Observable<any>{
    return this.http.get(this.url + this.appointmentUrl+"?page="+pageNumber+"&size="+pageSize+
    "&sort="+sortBy+","+sortType);
  }

  cancelAppointment(id):Observable<any>{
    return this.http.delete(this.url + this.appointmentUrl+"/"+id);
  }

}
