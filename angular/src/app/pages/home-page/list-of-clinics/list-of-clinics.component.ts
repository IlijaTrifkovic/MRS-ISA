import { Component, OnInit } from '@angular/core';
import { ClinicRestService } from 'src/app/service/clinic-rest.service';
import { Clinic } from 'src/app/model/model.clinic/Clinic';
import { ClinicPage } from 'src/app/model/model.clinic/ClinicPage';
import { Router } from '@angular/router';
import { ClinicListService } from 'src/app/service/clinic-list.service';

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
  currentPage=0;
  pageSize=5;
  sortBy="name";
  sortOrder:boolean=true; //true -> ASC 

  getSortOrder(){
    return this.sortOrder? "ASC" : "DESC";
  }

  constructor(private clinicService: ClinicRestService, private router:Router,
    private clinicListService:ClinicListService) { }
  ngOnInit() {
    this.getCurrentSortValue();
    this.clinicService.getClinic(this.currentPage,this.pageSize,this.sortBy,this.getSortOrder()).subscribe(
      data => {       
        this.clinicPage=data;  
      }
    );
    if((this.clinicPage.totalPages-1)<this.currentPage){
      this.currentPage=this.clinicPage.totalPages;
      this.sortData();
    }
  }

  showClinicProfile(clinic){
    this.router.navigate(['home/clinic-profile', clinic.id]);
  }

  sortDataBy(sortBy:string){
    this.sortOrder=!this.sortOrder;
    this.sortBy=sortBy;
    this.sortData();
  }

  sortData(){
    this.saveCurrentValue();
    this.clinicService.getClinic(this.currentPage,this.pageSize,this.sortBy,this.getSortOrder()).subscribe(
      data => {       
        this.clinicPage=data;  
      }
    );
  }

  nextPage(){
    if(this.currentPage<this.clinicPage.totalPages-1){
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

  saveCurrentValue(){
    this.clinicListService.currentPage=this.currentPage;
    this.clinicListService.sortBy=this.sortBy;
    this.clinicListService.pageSize=this.pageSize
    this.clinicListService.sortOrder=this.sortOrder;
  }

  getCurrentSortValue(){
    this.currentPage=this.clinicListService.currentPage;
    this.sortBy=this.clinicListService.sortBy;
    this.pageSize=this.clinicListService.pageSize;
    this.sortOrder=this.clinicListService.sortOrder;
  }

}
