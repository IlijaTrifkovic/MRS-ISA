import { Component, OnInit } from '@angular/core';
import { ClinicPage } from 'src/app/model/ClinicPage';
import { ActivatedRoute } from '@angular/router';
import { ClinicRestService } from 'src/app/service/clinic-rest.service';
import { MedicalExamination } from 'src/app/model/MedicalExamination';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-clinic-profile',
  templateUrl: './clinic-profile.component.html',
  styleUrls: ['./clinic-profile.component.css']
})
export class ClinicProfileComponent implements OnInit {

  clinicId="";
  clinicProfile:ClinicPage=new ClinicPage();
  medicalExamination:MedicalExamination[]=[];
  medExamination:MedicalExamination= new MedicalExamination();
  examinationID:number=-1;
  submitReservatinForm:boolean=false;
  statusMessage:string="";

  constructor(private route:ActivatedRoute, private clinicService:ClinicRestService) { }

  ngOnInit() {
    this.submitReservatinForm=true;
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
    );
  }

  reserve(id:number){
    this.examinationID=id;
    this.submitReservatinForm=true;
  }

  submit(){
    this.clinicService.reserveExamination(this.examinationID).subscribe(
      data => {
        this.medExamination=data.content;
        this.statusMessage="Pregled je rezervisan."
      },
      (error:HttpErrorResponse) =>{
        if(!error.error.details)
           this.statusMessage="Greška, pokušajte ponovo.";
        else
           this.statusMessage=error.error.details;
      }
    );
  }

  closeDialog(){
    this.statusMessage="";
    this.examinationID=-1;
    this.submitReservatinForm=false;
  }

}
