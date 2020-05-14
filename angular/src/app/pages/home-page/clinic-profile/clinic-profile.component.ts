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
  medicalAppointment:MedicalAppointment[]=[];
  medAppointment:MedicalAppointment= new MedicalAppointment;
  examinationID:number=-1;
  submitReservatinForm:boolean=false;
  statusMessage:string="";
  submitBtn:boolean=false;

  constructor(private route:ActivatedRoute, private clinicService:ClinicRestService) { }

  ngOnInit() {
    this.submitReservatinForm=false;
    this.clinicId=this.route.snapshot.paramMap.get('id');
    this.clinicService.getClinicById(this.clinicId).subscribe(
      clinic => {       
        this.clinicProfile=clinic;  
      }
    );
    this.clinicService.getAppointment(this.clinicId).subscribe(
      data => {
        this.medicalAppointment=data.content;
      }
    );
  }

  schedule(id:number){
    this.examinationID=id;
    this.submitReservatinForm=true;
  }

  submit(){
    this.submitBtn=true;
    this.statusMessage="Slanje zahtjeva ...";
    this.clinicService.scheduleAppointment(this.examinationID).subscribe(
      data => {
        this.medAppointment=data.content;
        this.statusMessage="Zahtjev za rezervaciju je poslat. Provjerite Vaš mail."
        this.submitBtn=false;
      },
      (error:HttpErrorResponse) =>{
        if(!error.error.details)
           this.statusMessage="Greška, pokušajte ponovo.";
        else
           this.statusMessage="Zahtjev za rezervaciju je poslat. Provjerite Vaš mail."
        this.submitBtn=false;
      }
    );
  }

  closeDialog(){
    this.statusMessage="";
    this.examinationID=-1;
    this.submitReservatinForm=false;
  }

}
