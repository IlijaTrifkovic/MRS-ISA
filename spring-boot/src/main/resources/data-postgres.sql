-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
--Dodavanje kartona **************************************************************
INSERT INTO medical_record (id, blood_type, height, weight, gender, date_of_birth)
VALUES (nextval('med_record_seq'), 0, 182.2, 89.2, 0, TO_DATE('28.02.1991', 'DD.MM.YYYY'));



--dodavanje specijalizacija ******************************************************
INSERT INTO specialization (id, name, description)
VALUES (1, 'Specijalizacija 1', 'description text');

INSERT INTO specialization (id, name, description)
VALUES (2, 'Specijalizacija 2', 'description text');

INSERT INTO specialization (id, name, description)
VALUES (3, 'Specijalizacija 3', 'description text');

INSERT INTO specialization (id, name, description)
VALUES (4, 'Specijalizacija 4', 'description text');

INSERT INTO specialization (id, name, description)
VALUES (5, 'Specijalizacija 5', 'description text');

INSERT INTO specialization (id, name, description)
VALUES (6, 'Specijalizacija 6', 'description text');

INSERT INTO specialization (id, name, description)
VALUES (7, 'Specijalizacija 7', 'description text');

INSERT INTO specialization (id, name, description)
VALUES (8, 'Specijalizacija 8', 'description text');

INSERT INTO specialization (id, name, description)
VALUES (9, 'Specijalizacija 9', 'description text');



--Dodavanje klinika

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za infektivne i tropske bolesti','address1', 'city1', 'country1', 'Klinika za infektilne i tropske bolesti nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '5.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za neurohirurgiju','address2', 'city2', 'country1', 'Klinika za neurologiju nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '4.1', '2019-04-22 21:58:58.508-07');
	
INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za hematologiju','address3', 'city1', 'country16', 'opis3', '2.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za kardiologiju', 'address4', 'city3', 'country1', 'opis4', '3.2', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za kardiohirurgiju', 'address1', 'city1', 'country1', 'opis1', '5.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za vaskularnu hirurgiju', 'address2', 'city2', 'country3', 'opis2', '4.1', '2019-04-22 21:58:58.508-07');
	
INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za pulmologiju', 'address3', 'city1', 'country1', 'opis3', '2.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za nefrologiju', 'address4', 'city3', 'country1', 'opis4', '3.2', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za očne bolesti', 'Deligradska br. 30', 'Beograd', 'country1', 'Klinika za očne bolesti nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '5.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za dermatovenerologiju', 'Deligradska br. 34', 'Beograd', 'Srbija', 'opis1', '4.1', '2019-04-22 21:58:58.508-07');
	
INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za ortopedsku hirurgiju i traumatologiju', 'Koste Todorovića 26', 'Beograd', 'Srbija', 'opis3', '2.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za alergologiju i imunologiju', 'Koste Todorovića 2', 'Beograd', 'Srbija', 'opis4', '3.2', '2019-04-22 21:58:58.508-07');




--Dodavanje soba - sala

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (1, 0, 'Soba1', 'description', 1);

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (2, 0, 'Soba2', 'description', 1);

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (3, 0, 'Soba3', 'description', 1);

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (4, 0, 'Soba4', 'description', 1);

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (5, 0, 'Soba5', 'description', 1);

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (6, 1, 'Soba6', 'description', 1);

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (7, 1, 'Soba7', 'description', 1);

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (8, 0, 'Soba1', 'description', 51);

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (9, 0, 'Soba2', 'description', 51);

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (10, 0, 'Soba3', 'description', 51);

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (11, 1, 'Soba4', 'description', 51);

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (12, 0, 'Soba1', 'description', 101);

INSERT INTO room (id, room_type,name, description, clinic_id)
VALUES (13, 0, 'Soba2', 'description', 101);







--Dodavanje korisnika u sistem
------------------------------------
--pacijent   
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, medical_record_id)
SELECT 'patient', nextval('user_id_generator_seq'), 'Nikola', 'Nikolic','0078944555333' ,'mail@mail.com', '1231231231234', '12345678912', '12345678912', 'address 1', 'city1', 'country1', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'mail@mail.com'
);
--admin*******************************************************
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date)
SELECT 'admin_cc', nextval('user_id_generator_seq'), 'Admin', 'Adminovic','0078944005333' ,'admin@mail.com', '1231201231234', '12340678912', '12345670912', 'address 1', 'city1', 'country1', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07'
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'admin@mail.com'
);
--doktor******************************************************
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', nextval('user_id_generator_seq'), 'Milos', 'Milosevic','00385667771113' ,'milos@mail.com', '1231231231231', '10040678912', '12340000912', 'Milosa Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1, 4
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'milos@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', nextval('user_id_generator_seq'), 'Uros', 'Urosevic','00385611771113' ,'uros@mail.com', '1231231231230', '10040678910', '12340000910', 'Urosa Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 51, 5
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'uros@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', nextval('user_id_generator_seq'), 'Simo', 'Simic','00385667771113' ,'simo@mail.com', '1232231231231', '12240678912', '10340000912', 'Milosa Simic 12', 'Beograd', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 51, 9
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'simo@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', nextval('user_id_generator_seq'), 'Jovo', 'Jovic','00385117111113' ,'jovo@mail.com', '1122221231231', '10040611112', '11143000912', 'Jove Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 51,8
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'jovo@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', nextval('user_id_generator_seq'), 'Milica', 'Milicic','00385667771113' ,'milica@mail.com', '5555231231231', '55540678912', '55540000912', 'Milosa Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 101, 7
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'milica@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', nextval('user_id_generator_seq'), 'Jovana', 'Jovovic','00385667771113' ,'jovana@mail.com', '7771231231231', '77740678912', '99340000912', 'Milosa Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07',51, 3
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'jovana@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', nextval('user_id_generator_seq'), 'Pero', 'Peric','00381237771113' ,'pero@mail.com', '1231234871231', '10003778912', '12372500912', 'Cara Dusana 45', 'Nis', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 51,1
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'pero@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', nextval('user_id_generator_seq'), 'Lazo', 'Lazic','00385000771113' ,'lazo@mail.com', '1231231244231', '14422678912', '12344200912', 'Laze Lazica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1, 1
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'lazo@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', nextval('user_id_generator_seq'), 'Petar', 'Petrovic','00385889771113' ,'petar@mail.com', '1110231231231', '18440638912', '12340400112', 'Milosa Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1, 3
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'petar@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', nextval('user_id_generator_seq'), 'Dragan', 'Dragovic','00385117761173' ,'dragan@mail.com', '1230001231251', '19990678914', '12343730912', 'Milosa Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1, 3
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'dragan@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', nextval('user_id_generator_seq'), 'Ksenija', 'Milosevic','0038227771113' ,'ksenija@mail.com', '1231231412314', '17540678912', '12380033091', 'Adresa Neka 12', 'Beograd', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1, 2
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'ksenija@mail.com'
);


--Dodavanje tipa pregleda

INSERT INTO examination_type(id, name, description) 
VALUES (1, 'TIP 1', 'OPIS 1');

INSERT INTO examination_type(id, name, description) 
VALUES (2, 'TIP 2', 'OPIS 2');

INSERT INTO examination_type(id, name, description) 
VALUES (3, 'TIP 3', 'OPIS 3');

INSERT INTO examination_type(id, name, description) 
VALUES (4, 'TIP 4', 'OPIS 4');

INSERT INTO examination_type(id, name, description) 
VALUES (5, 'TIP 5', 'OPIS 5');



--Dodavanje unaprijed definisanih pregleda

INSERT INTO medical_examination (id, medical_examination_status, date_time, duration, clinic_id, doctor_id, patient_id,
examination_type_id, room_id, price, discount)
VALUES (1, 0, '10-05-2020 12:12', 20, 1, 101, null, 1, 1, 1400.0, 200.0);

INSERT INTO medical_examination (id, medical_examination_status, date_time, duration, clinic_id, doctor_id, patient_id,
examination_type_id, room_id, price, discount)
VALUES (2, 0, '10-05-2020 12:10', 20, 1, 101, null, 2, 1, 2000.0, 0.0);

INSERT INTO medical_examination (id, medical_examination_status, date_time, duration, clinic_id, doctor_id, patient_id,
examination_type_id, room_id, price, discount)
VALUES (3, 0, '10-05-2020 13:12', 20, 51, 351, null, 3, 8, 3000.0, 550.0);

INSERT INTO medical_examination (id, medical_examination_status, date_time, duration, clinic_id, doctor_id, patient_id,
examination_type_id, room_id, price, discount)
VALUES (4, 0, '10-05-2020 13:15', 20, 51, 151, null, 4, 9, 2000.0, 300.0);

INSERT INTO medical_examination (id, medical_examination_status, date_time, duration, clinic_id, doctor_id, patient_id,
examination_type_id, room_id, price, discount)
VALUES (5, 2, '10-04-2020 13:10', 20, 51, 251, 1, 4, 9, 2000.0, 300.0);


--test - infektilna -datum je prosao
INSERT INTO medical_examination (id, medical_examination_status, date_time, duration, clinic_id, doctor_id, patient_id,
examination_type_id, room_id, price, discount)
VALUES (6, 0, '05-05-2020 12:12', 20, 1, 101, null, 1, 1, 1400.0, 200.0);

INSERT INTO medical_examination (id, medical_examination_status, date_time, duration, clinic_id, doctor_id, patient_id,
examination_type_id, room_id, price, discount)
VALUES (7, 0, '05-05-2020 12:12', 20, 1, 101, null, 1, 1, 1400.0, 200.0);

INSERT INTO medical_examination (id, medical_examination_status, date_time, duration, clinic_id, doctor_id, patient_id,
examination_type_id, room_id, price, discount)
VALUES (8, 0, '08-05-2020 12:55', 20, 1, 101, null, 1, 1, 1400.0, 200.0);




INSERT INTO medical_examination (id, medical_examination_status, date_time, duration, clinic_id, doctor_id, patient_id,
examination_type_id, room_id, price, discount)
VALUES (9, 2, '10-04-2019 15:10', 24, 51, 251, 1, 4, 9, 2000.0, 300.0);

INSERT INTO medical_examination (id, medical_examination_status, date_time, duration, clinic_id, doctor_id, patient_id,
examination_type_id, room_id, price, discount)
VALUES (10, 2, '14-04-2020 13:10', 22, 51, 251, 1, 4, 9, 2000.0, 300.0);

INSERT INTO medical_examination (id, medical_examination_status, date_time, duration, clinic_id, doctor_id, patient_id,
examination_type_id, room_id, price, discount)
VALUES (11, 2, '12-04-2020 13:10', 40, 51, 251, 1, 4, 9, 2000.0, 300.0);

INSERT INTO medical_examination (id, medical_examination_status, date_time, duration, clinic_id, doctor_id, patient_id,
examination_type_id, room_id, price, discount)
VALUES (12, 2, '13-04-2020 13:10', 30, 51, 251, 1, 4, 9, 2000.0, 300.0);










--Dodavanje uloga u sistem
----------------------------

INSERT INTO authority(id, name) 
SELECT nextval('authority_seq'), 'PATIENT'
WHERE 
NOT EXISTS ( SELECT 1 FROM authority WHERE name = 'PATIENT' );
INSERT INTO authority(id, name) 
SELECT nextval('authority_seq'), 'ADMIN_CC'
WHERE 
NOT EXISTS ( SELECT 1 FROM authority WHERE name = 'ADMIN_CC' );
SELECT nextval('authority_seq'), 'DOCTOR'
WHERE 
NOT EXISTS ( SELECT 1 FROM authority WHERE name = 'DOCTOR' );





--Dodjeljivanje uloga korisnicima sistema
-----------------------------------------

--pacijent
INSERT INTO user_account_authorities(user_account_id, authorities_id) 
SELECT u.id, a.id
FROM user_account u, authority a
WHERE u.email = 'mail@mail.com' AND a.name = 'PATIENT' AND 
NOT EXISTS ( SELECT 1 FROM user_account_authorities WHERE user_account_id = u.id );

--admin
INSERT INTO user_account_authorities(user_account_id, authorities_id) 
SELECT u.id, a.id
FROM user_account u, authority a
WHERE u.email = 'admin@mail.com' AND a.name = 'ADMIN_CC' AND 
NOT EXISTS ( SELECT 1 FROM user_account_authorities WHERE user_account_id = u.id );
