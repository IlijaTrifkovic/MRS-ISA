import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class PatientRestService {
  url = environment.baseUrl;
  patientProfileUrl = '/patient/profile';
  changePasswordUrl= '/changePassword';
  medicalRecordUrl='/medical-record';

  constructor(private http: HttpClient) { }

  getProfile(): Observable<any> {
    return this.http.get(this.url + this.patientProfileUrl);
  }

  updateProfile(loginInfo): Observable<any> {
    return this.http.post(this.url + this.patientProfileUrl, loginInfo, environment.httpOptions);
  }
  
  changePassword(passwordInfo): Observable<any> {
    return this.http.post(this.url+this.changePasswordUrl, passwordInfo, environment.httpOptions);
  }
  
  getMedicalRecord(): Observable<any>{
    return this.http.get(this.url + this.medicalRecordUrl);
  }

}
