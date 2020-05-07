import { Component, OnInit } from '@angular/core';
import { ClinicPage } from 'src/app/model/ClinicPage';
import { ActivatedRoute } from '@angular/router';
import { ClinicRestService } from 'src/app/service/clinic-rest.service';
import { MedicalExamination } from 'src/app/model/MedicalExamination';

@Component({
  selector: 'app-clinic-profile',
  templateUrl: './clinic-profile.component.html',
  styleUrls: ['./clinic-profile.component.css']
})
export class ClinicProfileComponent implements OnInit {

  clinicId="";
  clinicProfile:ClinicPage=new ClinicPage();
  medicalExamination:MedicalExamination[]=[];

  constructor(private route:ActivatedRoute, private clinicService:ClinicRestService) { }

  ngOnInit() {
    this.clinicId=this.route.snapshot.paramMap.get('id');
    this.clinicService.getClinicById(this.clinicId).subscribe(
      clinic => {       
        this.clinicProfile=clinic;  
      }
    );
    this.clinicService.getExamination(this.clinicId).subscribe(
      data => {
        this.medicalExamination=data.content;
      }
    )
  }
}
