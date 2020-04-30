-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
--Dodavanje kartona
INSERT INTO medical_record (id, blood_type, height, weight, gender, date_of_birth)
VALUES (1, 0, 182.2, 89.2, 0, TO_DATE('28.2.1991', 'DD.MM.YYYY'));

--Dodavanje klinika

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Clinic1','address1', 'city1', 'country1', 'opis1', '5.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Clinic2','address2', 'city2', 'country1', 'opis2', '4.1', '2019-04-22 21:58:58.508-07');
	
INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'CClinic3','address3', 'city1', 'country16', 'opis3', '2.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Clinic4', 'address4', 'city3', 'country1', 'opis4', '3.2', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'FClinic1', 'address1', 'city1', 'country1', 'opis1', '5.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Clinic2', 'address2', 'city2', 'country3', 'opis2', '4.1', '2019-04-22 21:58:58.508-07');
	
INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'DClinic3', 'address3', 'city1', 'country1', 'opis3', '2.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'YClinic4', 'address4', 'city3', 'country1', 'opis4', '3.2', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'FClinic1', 'address1', 'city1', 'country1', 'opis1', '5.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Clinic2', 'address2', 'city2', 'country1', 'opis2', '4.1', '2019-04-22 21:58:58.508-07');
	
INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Clinic3', 'address3', 'city1', 'country1', 'opis3', '2.0', '2019-04-22 21:58:58.508-07');

INSERT INTO clinic (id, name, address, city, country, description, grade, registration_date)
VALUES (nextval('clinic_seq'), 'Clinic4', 'address4', 'city3', 'country1', 'opis4', '3.2', '2019-04-22 21:58:58.508-07');

--Dodavanje pacijenta
   
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, medical_record_id)
SELECT 'patient', nextval('user_id_generator_seq'), 'Nikola', 'Nikolic','0078944555333' ,'mail@mail.com', '1231231231234', '12345678912', '12345678912', 'address 1', 'city1', 'country1', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'mail@mail.com'
);

--Uloga u sistemu

INSERT INTO authority(id, name) 
SELECT nextval('authority_seq'), 'PATIENT'
WHERE 
NOT EXISTS ( SELECT 1 FROM authority WHERE name = 'PATIENT' );

--Postavljanje uloga korisnicima

INSERT INTO user_account_authorities(user_account_id, authorities_id) 
SELECT u.id, a.id
FROM user_account u, authority a
WHERE u.email = 'mail@mail.com' AND a.name = 'PATIENT' AND 
NOT EXISTS ( SELECT 1 FROM user_account_authorities WHERE user_account_id = u.id );
