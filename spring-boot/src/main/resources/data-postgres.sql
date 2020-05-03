-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
--Dodavanje kartona
INSERT INTO medical_record (id, blood_type, height, weight, gender, date_of_birth)
VALUES (nextval('med_record_seq'), 0, 182.2, 89.2, 0, TO_DATE('28.02.1991', 'DD.MM.YYYY'));

--Dodavanje klinika

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za infektivne i tropske bolesti','address1', 'city1', 'country1', 'opis1', '5.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Klinika za neurohirurgiju','address2', 'city2', 'country1', 'opis2', '4.1', '2019-04-22 21:58:58.508-07');
	
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

--Dodavanje pacijenta
   
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, medical_record_id)
SELECT 'patient', nextval('user_id_generator_seq'), 'Nikola', 'Nikolic','0078944555333' ,'mail@mail.com', '1231231231234', '12345678912', '12345678912', 'address 1', 'city1', 'country1', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'mail@mail.com'
);

INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date)
SELECT 'admin_cc', nextval('user_id_generator_seq'), 'Admin', 'Adminovic','0078944005333' ,'admin@mail.com', '1231201231234', '12340678912', '12345670912', 'address 1', 'city1', 'country1', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07'
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'admin@mail.com'
);

--Uloga u sistemu

INSERT INTO authority(id, name) 
SELECT nextval('authority_seq'), 'PATIENT'
WHERE 
NOT EXISTS ( SELECT 1 FROM authority WHERE name = 'PATIENT' );
INSERT INTO authority(id, name) 
SELECT nextval('authority_seq'), 'ADMIN_CC'
WHERE 
NOT EXISTS ( SELECT 1 FROM authority WHERE name = 'ADMIN_CC' );

--Postavljanje uloga korisnicima

INSERT INTO user_account_authorities(user_account_id, authorities_id) 
SELECT u.id, a.id
FROM user_account u, authority a
WHERE u.email = 'mail@mail.com' AND a.name = 'PATIENT' AND 
NOT EXISTS ( SELECT 1 FROM user_account_authorities WHERE user_account_id = u.id );


--dodavanje korisnika sa ulogom admina

INSERT INTO user_account_authorities(user_account_id, authorities_id) 
SELECT u.id, a.id
FROM user_account u, authority a
WHERE u.email = 'admin@mail.com' AND a.name = 'ADMIN_CC' AND 
NOT EXISTS ( SELECT 1 FROM user_account_authorities WHERE user_account_id = u.id );
