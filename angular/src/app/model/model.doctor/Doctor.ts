import { Specialzation } from './Specialization';

export class Doctor{
    id:number;
    firstName:string;
    lastName:string;
    email:string;
    grade:number;
    specialzation:Specialzation=new Specialzation();
    constructor() {}
}