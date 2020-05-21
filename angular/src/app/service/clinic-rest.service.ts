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
  clinicGradeUrl="/clinic-grade";
  doctorGradeUrl="/doctor-grade";
  doctorUrl="/doctor/clinic"

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

  setClinicGrade(id,grade):Observable<any>{
    return this.http.put(this.url + this.appointmentUrl + this.clinicGradeUrl+ "?id="+id+"&grade="+grade, environment.httpOptions);
  }

  setDoctorGrade(id,grade):Observable<any>{
    return this.http.put(this.url + this.appointmentUrl + this.doctorGradeUrl+ "?id="+id+"&grade="+grade, environment.httpOptions);
  }

  getDoctorList(id):Observable<any>{
    return this.http.get(this.url+this.doctorUrl+"/"+id);
  }
}
