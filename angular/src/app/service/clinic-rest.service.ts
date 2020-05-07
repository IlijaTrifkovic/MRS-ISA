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
  medicalExamination= "/examination";

  constructor(private http: HttpClient) { }
  getClinic(pageNumber,pageSize,sortBy,sortType): Observable<any> {
    return this.http.get(this.url + this.clinicUrl+"?page="+pageNumber+"&size="+pageSize+
    "&sort="+sortBy+","+sortType);
  }

  getClinicById(id):Observable<any>{
    return this.http.get(this.url + this.clinicUrl+"/"+id);
  }

  getExamination(id):Observable<any>{
    return this.http.get(this.url + this.medicalExamination+"/"+id);
  }

}
