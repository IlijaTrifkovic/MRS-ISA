import { PatientProfile } from './model.patient/PatientProfile';

export class MedicalRecord {
    id: number;
    weight:number;
    height:number;
    bloodType:string;
    dateOfBirth:Date;
    gender:string;
    patient:PatientProfile=new PatientProfile();

    constructor() {}
}