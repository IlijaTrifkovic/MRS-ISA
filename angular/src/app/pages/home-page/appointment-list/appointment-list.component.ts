import { Component, OnInit } from '@angular/core';
import { MedicalAppointment} from 'src/app/model/model.clinic/MedicalAppointment';
import { ClinicRestService } from 'src/app/service/clinic-rest.service';
import { Pageable } from 'src/app/model/Pageable';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {
  
  pageable:Pageable=new Pageable();
  medicalAppointment:MedicalAppointment[]=[];
  currentPage=0;
  pageSize=8;
  sortBy="date_time";
  sortOrder:boolean=false; //true -> ASC 
  message:string="";
  cancelDialog:boolean=false;
  statusMessage:string="";
  gradeDialog:boolean;
  mAppointment:MedicalAppointment=new MedicalAppointment();

  dialogBtnSub:boolean=false;
  
  constructor(private clinicService:ClinicRestService) { }
 
  getSortOrder(){
    return this.sortOrder? "ASC" : "DESC";
  }

  ngOnInit() {
    this.sortData();
  }

  sortData(){
    this.clinicService.getPatientAppointment(this.currentPage,this.pageSize,this.sortBy,this.getSortOrder()).subscribe(
      data => {       
        this.medicalAppointment=data.content;
        this.pageable=data;
      }
    );
  }

  nextPage(){
    if(this.currentPage<this.pageable.totalPages-1){
      this.currentPage++;
      this.sortData();
    }
  }

  prevPage(){
    if(this.currentPage>0){
      this.currentPage--;
      this.sortData()
    }
  }

  sortDataBy(sortBy:string){
    this.sortOrder=!this.sortOrder;
    this.sortBy=sortBy;
    this.sortData();
  }

  cancelAppointment(){
    this.dialogBtnSub=true;
    this.statusMessage="otkazivanje...";
    this.clinicService.cancelAppointment(this.mAppointment.id).subscribe(
      data=>{
        this.dialogBtnSub=false;
        this.message=data.message+"";
        this.statusMessage=this.message;
        this.sortData();
      }
    );
  }

  openDialog(mAppointment:MedicalAppointment){
    this.mAppointment.id=mAppointment.id;
    this.mAppointment.appointmentStatus=mAppointment.appointmentStatus;
    if(mAppointment.appointmentStatus=="FINISHED"){
      this.openGradeDialog(mAppointment);
    }else{
      this.cancelDialog=true;
    }
  }

  closeDialog(){
    this.statusMessage="";
    this.dialogBtnSub=false;
    this.cancelDialog=false;
    this.gradeDialog=false;
  }

  openGradeDialog(mAppointment:MedicalAppointment){
    this.gradeDialog=true;
    this.mAppointment.doctorGrade=mAppointment.doctorGrade;
    this.mAppointment.clinicGrade=mAppointment.clinicGrade;
    if(mAppointment.appointmentStatus!="FINISHED")
      this.statusMessage="Nije moguće dati ocjenu za termin koji se nije završio."
  }

  setDoctorGrade(grade:number){
    this.clinicService.setDoctorGrade(this.mAppointment.id,grade).subscribe(
      data=> {
        this.statusMessage=data.message+"";
        this.medicalAppointment.forEach( medApp => {
          this.mAppointment.doctorGrade=grade;
        });
      }
    );
  }

  setClinicGrade(){

  }
}
