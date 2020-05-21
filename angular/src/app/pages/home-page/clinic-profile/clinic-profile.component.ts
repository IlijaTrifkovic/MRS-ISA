import { Component, OnInit } from '@angular/core';
import { ClinicPage } from 'src/app/model/model.clinic/ClinicPage';
import { ActivatedRoute } from '@angular/router';
import { ClinicRestService } from 'src/app/service/clinic-rest.service';
import { HttpErrorResponse } from '@angular/common/http';
import { MedicalAppointment } from 'src/app/model/model.clinic/MedicalAppointment';

@Component({
  selector: 'app-clinic-profile',
  templateUrl: './clinic-profile.component.html',
  styleUrls: ['./clinic-profile.component.css']
})
export class ClinicProfileComponent implements OnInit {

  clinicId="";
  clinicProfile:ClinicPage=new ClinicPage();


  constructor(private route:ActivatedRoute, private clinicService:ClinicRestService) { }

  ngOnInit() {
    //this.submitReservatinForm=false;
    this.clinicId=this.route.snapshot.paramMap.get('id');
    this.clinicService.getClinicById(this.clinicId).subscribe(
      clinic => {       
        this.clinicProfile=clinic;  
      }
    );
  }
}
