import { Component, OnInit } from '@angular/core';
import { ClinicRestService } from 'src/app/service/clinic-rest.service';
import { Clinic } from 'src/app/model/Clinic';
import { ClinicPage } from 'src/app/model/ClinicPage';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-of-clinics',
  templateUrl: './list-of-clinics.component.html',
  styleUrls: ['./list-of-clinics.component.css']
})
export class ListOfClinicsComponent implements OnInit {
  json:string="";
  statusMessage:string="";
  clinics:Clinic=new Clinic();
  clinicPage:ClinicPage = new ClinicPage();
  rowCounter=0;

  constructor(private clinicService: ClinicRestService, private router:Router) { }

  ngOnInit() {
    this.clinicService.getClinic(0,15).subscribe(
      clinics => {       
        this.clinicPage=clinics;  
      }
    );
  }

  showClinicProfile(clinic){
    this.router.navigate(['home/clinic-profile', clinic.id]);
  }

}
