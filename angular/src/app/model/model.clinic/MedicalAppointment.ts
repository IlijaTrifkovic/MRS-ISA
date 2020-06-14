import { Room } from './Room';
import { Doctor } from '../model.doctor/Doctor';
import { Clinic } from './Clinic';

export class MedicalAppointment{
    id:number;
    dateTime:string;
    doctor:Doctor=new Doctor();
    appointmentType:AppointmentType=new AppointmentType();
    room:Room=new Room();
    price:number;
    discount:number;
    appointmentStatus;
    doctorGrade:number;
    clinicGrade:number;
}

export class AppointmentType{
    id: 1;
    name:string;
    description:string;
    duration:number;
    constructor(){}
}
