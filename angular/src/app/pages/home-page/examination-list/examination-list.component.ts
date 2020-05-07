import { Component, OnInit } from '@angular/core';
import { MedicalExamination } from 'src/app/model/MedicalExamination';
import { ClinicRestService } from 'src/app/service/clinic-rest.service';
import { Pageable } from 'src/app/model/Pageable';

@Component({
  selector: 'app-examination-list',
  templateUrl: './examination-list.component.html',
  styleUrls: ['./examination-list.component.css']
})
export class ExaminationListComponent implements OnInit {
  
  pageable:Pageable=new Pageable();
  medicalExamination:MedicalExamination[]=[];
  currentPage=0;
  pageSize=8;
  sortBy="date_time";
  sortOrder:boolean=true; //true -> ASC 
  
  constructor(private clinicService:ClinicRestService) { }
 
  getSortOrder(){
    return this.sortOrder? "ASC" : "DESC";
  }

  ngOnInit() {
    this.clinicService.getPatientExamination(this.currentPage,this.pageSize,this.sortBy,this.getSortOrder()).subscribe(
      data => {
        this.medicalExamination=data.content;
        this.pageable=data;
      }
    );
  }

  sortData(){
    this.clinicService.getPatientExamination(this.currentPage,this.pageSize,this.sortBy,this.getSortOrder()).subscribe(
      data => {       
        this.medicalExamination=data.content;
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
}
