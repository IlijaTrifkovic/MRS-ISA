import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClinicListService {
  currentPage=0;
  pageSize=8;
  sortBy="name";
  sortOrder:boolean=true;

  constructor() { }
}
