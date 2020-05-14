import { Room } from './Room';
import { Doctor } from '../model.doctor/Doctor';

export class MedicalAppointment{
    id:number;
    dateTime:string;
    duration:number;
    doctor:Doctor=new Doctor();
    appointmentType:AppointmentType=new AppointmentType();
    room:Room=new Room();
    price:number;
    discount:number;
    appointmentStatus;
}

export class AppointmentType{
    id: 1;
    name:string;
    description:string;

    constructor(){}
}
