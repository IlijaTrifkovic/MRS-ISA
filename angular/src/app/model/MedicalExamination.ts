export class MedicalExamination{
    id:number;
    dateTime:string;
    duration:number;
    doctor:Doctor=new Doctor();
    examinationType:ExaminationType=new ExaminationType();
    room:Room=new Room();
    price:number;
    discount:number;
}

export class Doctor{
    id:number;
    firstName:string;
    lastName:string;
    email:string;
    specialzation:Specialzation=new Specialzation();
    constructor() {}
}

export class Specialzation{
    id:number;
    name:string;
    description:string;

    constructor(){}
}

export class ExaminationType{
    id: 1;
    name:string;
    description:string;

    constructor(){}
}

export class Room{
    id:number;
    name:string;
    description:string;

    constructor(){}
}
