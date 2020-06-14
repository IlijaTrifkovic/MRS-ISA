-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
--Dodavanje kartona **************************************************************
INSERT INTO medical_record (id, blood_type, height, weight, gender, date_of_birth)
VALUES (nextval('med_record_seq'), 0, 182.2, 89.2, 0, TO_DATE('28.02.1991', 'DD.MM.YYYY'));



--dodavanje specijalizacija ******************************************************
INSERT INTO specialization (id, name, description)
VALUES (1, 'Specijalizacija 1', 'opis specijalizacije 1');
INSERT INTO specialization (id, name, description)
VALUES (2, 'Specijalizacija 2', 'opis specijalizacije 2');
INSERT INTO specialization (id, name, description)
VALUES (3, 'Specijalizacija 3', 'opis specijalizacije 3');
INSERT INTO specialization (id, name, description)
VALUES (4, 'Specijalizacija 4', 'opis specijalizacije 4');
INSERT INTO specialization (id, name, description)
VALUES (5, 'Specijalizacija 5', 'opis specijalizacije 5');
INSERT INTO specialization (id, name, description)
VALUES (6, 'Specijalizacija 6', 'opis specijalizacije 6');
INSERT INTO specialization (id, name, description)
VALUES (7, 'Specijalizacija 7', 'opis specijalizacije 7');
INSERT INTO specialization (id, name, description)
VALUES (8, 'Specijalizacija 8', 'opis specijalizacije 8');
INSERT INTO specialization (id, name, description)
VALUES (9, 'Specijalizacija 9', 'opis specijalizacije 9');
INSERT INTO specialization (id, name, description)
VALUES (10, 'Specijalizacija 10', 'opis specijalizacije 10');
INSERT INTO specialization (id, name, description)
VALUES (11, 'Specijalizacija 11', 'opis specijalizacije 11');
INSERT INTO specialization (id, name, description)
VALUES (12, 'Specijalizacija 12', 'opis specijalizacije 12');
INSERT INTO specialization (id, name, description)
VALUES (13, 'Specijalizacija 13', 'opis specijalizacije 13');
INSERT INTO specialization (id, name, description)
VALUES (14, 'Specijalizacija 14', 'opis specijalizacije 14');
INSERT INTO specialization (id, name, description)
VALUES (15, 'Specijalizacija 15', 'opis specijalizacije 15');
INSERT INTO specialization (id, name, description)
VALUES (16, 'Specijalizacija 16', 'opis specijalizacije 16');
INSERT INTO specialization (id, name, description)
VALUES (17, 'Specijalizacija 17', 'opis specijalizacije 17');
INSERT INTO specialization (id, name, description)
VALUES (18, 'Specijalizacija 18', 'opis specijalizacije 18');
INSERT INTO specialization (id, name, description)
VALUES (19, 'Specijalizacija 19', 'opis specijalizacije 19');
INSERT INTO specialization (id, name, description)
VALUES (20, 'Specijalizacija 20', 'opis specijalizacije 20');


--Dodavanje tipa pregleda-operacije***************************************************
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (1, 'TIP 1', 'OPIS 1', 20, 1, 0);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (2, 'TIP 2', 'OPIS 2', 35, 2, 0);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (3, 'TIP 3', 'OPIS 3', 20, 3, 0);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (4, 'TIP 4', 'OPIS 4', 30, 4, 0);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (5, 'TIP 5', 'OPIS 5', 40, 5, 0);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (6, 'TIP 6', 'OPIS 6', 35, 6, 0);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (7, 'TIP 7', 'OPIS 7', 50, 7, 0);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (8, 'TIP 8', 'OPIS 8', 20, 8, 0);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (9, 'TIP 9', 'OPIS 9', 35, 9, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (10, 'TIP 10', 'OPIS 10', 60, 10, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (11, 'TIP 11', 'OPIS 11', 30, 11, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (12, 'TIP 12', 'OPIS 12', 20, 12, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (13, 'TIP 13', 'OPIS 13', 40, 13, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (14, 'TIP 14', 'OPIS 14', 50, 14, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (15, 'TIP 15', 'OPIS 15', 70, 15, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (16, 'TIP 16', 'OPIS 16', 20, 9, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (17, 'TIP 17', 'OPIS 17', 25, 10, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (18, 'TIP 18', 'OPIS 18', 40, 11, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (19, 'TIP 19', 'OPIS 19', 20, 12, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (20, 'TIP 20', 'OPIS 20', 30, 13, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (21, 'TIP 21', 'OPIS 21', 30, 14, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (22, 'TIP 22', 'OPIS 22', 30, 15, 1);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (23, 'TIP 23', 'OPIS 23', 35, 16, 0);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (24, 'TIP 24', 'OPIS 24', 55, 17, 0);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (25, 'TIP 25', 'OPIS 25', 30, 18, 0);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (26, 'TIP 26', 'OPIS 26', 35, 19, 0);
INSERT INTO appointment_type(id, name, description, duration, specialization_id, type) 
VALUES (27, 'TIP 27', 'OPIS 27', 30, 20, 0);



--Dodavanje klinika****************************************************************
INSERT INTO clinic (id, name, address, city, country, description, registration_date)
VALUES (1, 'Klinika za infektivne i tropske bolesti','Bulevar oslobođenja 16', 'Beograd', 'Srbija', 'Klinika za infektilne i tropske bolesti nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '2019-04-22 21:58:58.508-07');
INSERT INTO clinic (id, name, address, city, country, description, registration_date)
VALUES (2, 'Klinika za neurohirurgiju','Koste Todorovića 4', 'Beograd', 'Srbija', 'Klinika za neurohirurgiju nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '2019-04-22 21:58:58.508-07');	
INSERT INTO clinic (id, name, address, city, country, description, registration_date)
VALUES (3, 'Klinika za hematologiju','Koste Todorovića 2', 'Beograd', 'Srbija', 'Klinika za hemoterapiju nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '2019-04-22 21:58:58.508-07');
INSERT INTO clinic (id, name, address, city, country, description, registration_date)
VALUES (4, 'Klinika za kardiologiju', 'address4', 'city3', 'country1', 'Klinika za kardiologiju nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '2019-04-22 21:58:58.508-07');
INSERT INTO clinic (id, name, address, city, country, description, registration_date)
VALUES (5, 'Klinika za kardiohirurgiju', 'address1', 'city1', 'country1', 'Klinika za kardiohirurgiju nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '2019-04-22 21:58:58.508-07');
INSERT INTO clinic (id, name, address, city, country, description, registration_date)
VALUES (6, 'Klinika za vaskularnu hirurgiju', 'Koste Todorovića 8', 'Beograd', 'Srbija', 'Klinika za vaskularnu hirurgiju nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '2019-04-22 21:58:58.508-07');
INSERT INTO clinic (id, name, address, city, country, description, registration_date)
VALUES (7, 'Klinika za pulmologiju', 'Koste Todorovića 26', 'Beograd', 'Srbija', 'Klinika za pulmologiju je zdravstvena ustanova za plućne bolesti u sastavu Kliničkog centra Srbije. Ležeće bolesnike zbrinjava u zgradi Klinike za pulmologiju, a amublantne pacijente u okviru Poliklinike Kliničkog centra Srbije. Otvorena je za hitan prijem plućnih bolesnika 24 sata. ', '2019-04-22 21:58:58.508-07');
INSERT INTO clinic (id, name, address, city, country, description, registration_date)
VALUES (8, 'Klinika za nefrologiju', 'Pasterova 2', 'Beograd', 'Srbija', 'Klinika za nefrologiju nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '2019-04-22 21:58:58.508-07');
INSERT INTO clinic (id, name, address, city, country, description, registration_date)
VALUES (9, 'Klinika za očne bolesti', 'Deligradska 30', 'Beograd', 'country1', 'Klinika za očne bolesti nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '2019-04-22 21:58:58.508-07');
INSERT INTO clinic (id, name, address, city, country, description, registration_date)
VALUES (10, 'Klinika za dermatovenerologiju', 'Deligradska 34', 'Beograd', 'Srbija', 'Klinika za dermatologiju nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '2019-04-22 21:58:58.508-07');
INSERT INTO clinic (id, name, address, city, country, description, registration_date)
VALUES (11, 'Klinika za ortopedsku hirurgiju i traumatologiju', 'Koste Todorovića 26', 'Beograd', 'Srbija', 'Klinika za ortopedsku hirurgiju i traumatologiju nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '2019-04-22 21:58:58.508-07');
INSERT INTO clinic (id, name, address, city, country, description, registration_date)
VALUES (12, 'Klinika za alergologiju i imunologiju', 'Koste Todorovića 2', 'Beograd', 'Srbija', 'Klinika za alergologiju i imunologiju nalazi se u sklopu KCS-a. Radi u zdanju koje ima oko 7.000 m2 raspoređenih u tri međusobom povezane zgrade. Funkcionalno je podeljena na poliklinički i stacionarni deo. Poliklinika ima jednu opštu/trijažnu ambulantu (amb. 1), koja je istovremeno i ambulanta za urgentna stanja, i još 11 specijalizovanih ambulanti.', '2019-04-22 21:58:58.508-07');


--dodavanje cjenovnika za preglede;
INSERT INTO pricelist (id, price, clinic_id, appointment_type_id, active)
VALUES (1, 2500.00, 1, 1, true);
INSERT INTO pricelist (id, price, clinic_id, appointment_type_id, active)
VALUES (2, 2600.00, 1, 2, true);
INSERT INTO pricelist (id, price, clinic_id, appointment_type_id, active)
VALUES (3, 3500.00, 1, 3, true);
INSERT INTO pricelist (id, price, clinic_id, appointment_type_id, active)
VALUES (4, 4500.00, 1, 4, true);
INSERT INTO pricelist (id, price, clinic_id, appointment_type_id, active)
VALUES (5, 5000.99, 1, 5, true);
INSERT INTO pricelist (id, price, clinic_id, appointment_type_id, active)
VALUES (6, 1400.99, 1, 9, true);
INSERT INTO pricelist (id, price, clinic_id, appointment_type_id, active)
VALUES (7, 3200.00, 1, 10, true);
INSERT INTO pricelist (id, price, clinic_id, appointment_type_id, active)
VALUES (8, 2550.00, 1, 16, true);
INSERT INTO pricelist (id, price, clinic_id, appointment_type_id, active)
VALUES (9, 4020.00, 1, 17, true);



--Dodavanje soba - sala*************************************************************
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (1, 0, 'Soba1', 'Soba 1 - soba za preglede.', 1);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (2, 0, 'Soba2', 'Soba 2 - soba za preglede.', 1);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (3, 0, 'Soba3', 'Soba 3 - soba za preglede.', 1);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (4, 0, 'Soba4', 'Soba 4 - soba za preglede.', 1);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (5, 0, 'Soba5', 'Soba 5 - soba za preglede.', 1);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (6, 0, 'Soba6', 'Soba 6 - soba za preglede.', 1);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (7, 0, 'Soba7', 'Soba 7 - soba za preglede.', 1);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (8, 1, 'Soba8', 'Soba 8 - soba za operacije.', 1);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (9, 1, 'Soba9', 'Soba 9 - soba za operacije.', 1);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (10, 1, 'Soba10', 'Soba 1 - soba za operacije.', 1);

INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (11, 0, 'Soba1', 'Soba 1 - soba za preglede.', 2);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (12, 0, 'Soba2', 'Soba 2 - soba za preglede.', 2);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (13, 0, 'Soba3', 'Soba 3 - soba za preglede.', 2);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (14, 0, 'Soba4', 'Soba 4 - soba za preglede.', 2);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (15, 0, 'Soba5', 'Soba 5 - soba za preglede.', 2);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (16, 0, 'Soba6', 'Soba 6 - soba za preglede.', 2);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (17, 0, 'Soba7', 'Soba 7 - soba za preglede.', 2);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (18, 1, 'Soba8', 'Soba 8 - soba za operacije.', 2);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (19, 1, 'Soba9', 'Soba 9 - soba za operacije.', 2);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (20, 1, 'Soba10', 'Soba 10 - soba za operacije.', 2);

INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (21, 0, 'Soba1', 'Soba 1 - soba za preglede.', 3);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (22, 0, 'Soba2', 'Soba 2 - soba za preglede.', 3);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (23, 0, 'Soba3', 'Soba 3 - soba za preglede.', 3);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (24, 0, 'Soba4', 'Soba 4 - soba za preglede.', 3);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (25, 0, 'Soba5', 'Soba 5 - soba za preglede.', 3);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (26, 0, 'Soba6', 'Soba 6 - soba za preglede.', 3);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (27, 0, 'Soba7', 'Soba 7 - soba za preglede.', 3);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (28, 1, 'Soba8', 'Soba 8 - soba za operacije.', 3);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (29, 1, 'Soba9', 'Soba 9 - soba za operacije.', 3);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (30, 1, 'Soba10', 'Soba 10 - soba za operacije.', 3);

INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (31, 0, 'Soba1', 'Soba 1 - soba za preglede.', 4);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (32, 0, 'Soba2', 'Soba 2 - soba za preglede.', 4);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (33, 0, 'Soba3', 'Soba 3 - soba za preglede.', 4);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (34, 0, 'Soba4', 'Soba 4 - soba za preglede.', 4);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (35, 0, 'Soba5', 'Soba 5 - soba za preglede.', 4);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (36, 0, 'Soba6', 'Soba 6 - soba za preglede.', 4);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (37, 0, 'Soba7', 'Soba 7 - soba za preglede.', 4);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (38, 1, 'Soba8', 'Soba 8 - soba za operacije.', 4);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (39, 1, 'Soba9', 'Soba 9 - soba za operacije.', 4);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (40, 1, 'Soba10', 'Soba 10 - soba za operacije.', 4);

INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (41, 0, 'Soba1', 'Soba 1 - soba za preglede.', 5);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (42, 0, 'Soba2', 'Soba 2 - soba za preglede.', 5);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (43, 0, 'Soba3', 'Soba 3 - soba za preglede.', 5);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (44, 0, 'Soba4', 'Soba 4 - soba za preglede.', 5);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (45, 0, 'Soba5', 'Soba 5 - soba za preglede.', 5);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (46, 0, 'Soba6', 'Soba 6 - soba za preglede.', 5);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (47, 0, 'Soba7', 'Soba 7 - soba za preglede.', 5);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (48, 1, 'Soba8', 'Soba 8 - soba za operacije.', 5);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (49, 1, 'Soba9', 'Soba 9 - soba za operacije.', 5);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (50, 1, 'Soba10', 'Soba 10 - soba za operacije.', 5);

INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (51, 0, 'Soba1', 'Soba 1 - soba za preglede.', 6);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (52, 0, 'Soba2', 'Soba 2 - soba za preglede.', 6);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (53, 0, 'Soba3', 'Soba 3 - soba za preglede.', 6);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (54, 0, 'Soba4', 'Soba 4 - soba za preglede.', 6);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (55, 0, 'Soba5', 'Soba 5 - soba za preglede.', 6);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (56, 0, 'Soba6', 'Soba 6 - soba za preglede.', 6);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (57, 0, 'Soba7', 'Soba 7 - soba za preglede.', 6);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (58, 1, 'Soba8', 'Soba 8 - soba za operacije.', 6);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (59, 1, 'Soba9', 'Soba 9 - soba za operacije.', 6);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (60, 1, 'Soba10', 'Soba 10 - soba za operacije.', 6);

INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (61, 0, 'Soba1', 'Soba 1 - soba za preglede.', 7);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (62, 0, 'Soba2', 'Soba 2 - soba za preglede.', 7);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (63, 0, 'Soba3', 'Soba 3 - soba za preglede.', 7);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (64, 0, 'Soba4', 'Soba 4 - soba za preglede.', 7);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (65, 0, 'Soba5', 'Soba 5 - soba za preglede.', 7);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (66, 0, 'Soba6', 'Soba 6 - soba za preglede.', 7);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (67, 0, 'Soba7', 'Soba 7 - soba za preglede.', 7);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (68, 1, 'Soba8', 'Soba 8 - soba za operacije.', 7);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (69, 1, 'Soba9', 'Soba 9 - soba za operacije.', 7);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (70, 1, 'Soba10', 'Soba 10 - soba za operacije.', 7);

INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (71, 0, 'Soba1', 'Soba 1 - soba za preglede.', 8);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (72, 0, 'Soba2', 'Soba 2 - soba za preglede.', 8);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (73, 0, 'Soba3', 'Soba 3 - soba za preglede.', 8);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (74, 0, 'Soba4', 'Soba 4 - soba za preglede.', 8);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (75, 0, 'Soba5', 'Soba 5 - soba za preglede.', 8);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (76, 0, 'Soba6', 'Soba 6 - soba za preglede.', 8);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (77, 0, 'Soba7', 'Soba 7 - soba za preglede.', 8);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (78, 1, 'Soba8', 'Soba 8 - soba za operacije.', 8);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (79, 1, 'Soba9', 'Soba 9 - soba za operacije.', 8);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (80, 1, 'Soba10', 'Soba 10 - soba za operacije.', 8);

INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (81, 0, 'Soba1', 'Soba 1 - soba za preglede.', 9);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (82, 0, 'Soba2', 'Soba 2 - soba za preglede.', 9);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (83, 0, 'Soba3', 'Soba 3 - soba za preglede.', 9);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (84, 0, 'Soba4', 'Soba 4 - soba za preglede.', 9);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (85, 0, 'Soba5', 'Soba 5 - soba za preglede.', 9);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (86, 0, 'Soba6', 'Soba 6 - soba za preglede.', 9);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (87, 0, 'Soba7', 'Soba 7 - soba za preglede.', 9);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (88, 1, 'Soba8', 'Soba 8 - soba za operacije.', 9);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (89, 1, 'Soba9', 'Soba 9 - soba za operacije.', 9);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (90, 1, 'Soba10', 'Soba 10 - soba za operacije.', 9);

INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (91, 0, 'Soba1', 'Soba 1 - soba za preglede.', 10);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (92, 0, 'Soba2', 'Soba 2 - soba za preglede.', 10);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (93, 0, 'Soba3', 'Soba 3 - soba za preglede.', 10);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (94, 0, 'Soba4', 'Soba 4 - soba za preglede.', 10);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (95, 0, 'Soba5', 'Soba 5 - soba za preglede.', 10);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (96, 0, 'Soba6', 'Soba 6 - soba za preglede.', 10);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (97, 0, 'Soba7', 'Soba 7 - soba za preglede.', 10);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (98, 1, 'Soba8', 'Soba 8 - soba za operacije.', 10);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (99, 1, 'Soba9', 'Soba 9 - soba za operacije.', 10);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (100, 1, 'Soba10', 'Soba 10 - soba za operacije.', 10);

INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (101, 0, 'Soba1', 'Soba 1 - soba za preglede.', 11);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (102, 0, 'Soba2', 'Soba 2 - soba za preglede.', 11);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (103, 0, 'Soba3', 'Soba 3 - soba za preglede.', 11);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (104, 0, 'Soba4', 'Soba 4 - soba za preglede.', 11);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (105, 0, 'Soba5', 'Soba 5 - soba za preglede.', 11);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (106, 0, 'Soba6', 'Soba 6 - soba za preglede.', 11);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (107, 0, 'Soba7', 'Soba 7 - soba za preglede.', 11);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (108, 1, 'Soba8', 'Soba 8 - soba za operacije.', 11);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (109, 1, 'Soba9', 'Soba 9 - soba za operacije.', 11);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (110, 1, 'Soba10', 'Soba 10 - soba za operacije.', 11);

INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (111, 0, 'Soba1', 'Soba 1 - soba za preglede.', 12);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (112, 0, 'Soba2', 'Soba 2 - soba za preglede.', 12);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (113, 0, 'Soba3', 'Soba 3 - soba za preglede.', 12);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (114, 0, 'Soba4', 'Soba 4 - soba za preglede.', 12);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (115, 0, 'Soba5', 'Soba 5 - soba za preglede.', 12);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (116, 0, 'Soba6', 'Soba 6 - soba za preglede.', 12);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (117, 0, 'Soba7', 'Soba 7 - soba za preglede.', 12);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (118, 1, 'Soba8', 'Soba 8 - soba za operacije.', 12);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (119, 1, 'Soba9', 'Soba 9 - soba za operacije.', 12);
INSERT INTO room (id, room_type, name, description, clinic_id)
VALUES (120, 1, 'Soba10', 'Soba 10 - soba za operacije.', 12);



--Dodavanje korisnika u sistem****************************************************************
------------------------------------
--pacijent   
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, medical_record_id)
SELECT 'patient', 1, 'Nikola', 'Nikolic','0078944555333' ,'mail@mail.com', '1231231231234', '12345678912', '12345678912', 'address 1', 'city1', 'country1', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'mail@mail.com'
);


--admin*******************************************************
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date)
SELECT 'admin_cc', 2, 'Admin', 'Adminovic','0078944005333' ,'admin@mail.com', '1231201231234', '12340678912', '12345670912', 'address 1', 'city1', 'country1', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07'
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'admin@mail.com'
);

--doktor******************************************************
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', 3, 'Milos', 'Milosevic','00385667771113' ,'milos@mail.com', '1231231231231', '10040678912', '12340000912', 'Milosa Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1, 1
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'milos@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', 4, 'Uros', 'Urosevic','00385611771113' ,'uros@mail.com', '1231231231230', '10040678910', '12340000910', 'Urosa Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1, 2
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'uros@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', 5, 'Simo', 'Simic','00385667771113' ,'simo@mail.com', '1232231231231', '12240678912', '10340000912', 'Milosa Simic 12', 'Beograd', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1, 3
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'simo@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', 6, 'Jovo', 'Jovic','00385117111113' ,'jovo@mail.com', '1122221231231', '10040611112', '11143000912', 'Jove Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1, 4
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'jovo@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', 7, 'Milica', 'Milicic','00385667771113' ,'milica@mail.com', '5555231231231', '55540678912', '55540000912', 'Milosa Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 1, 5
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'milica@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', 8, 'Jovana', 'Jovovic','00385667771113' ,'jovana@mail.com', '7771231231231', '77740678912', '99340000912', 'Milosa Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07',2, 6
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'jovana@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', 9, 'Pero', 'Peric','00381237771113' ,'pero@mail.com', '1231234871231', '10003778912', '12372500912', 'Cara Dusana 45', 'Nis', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 2,7
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'pero@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', 10, 'Lazo', 'Lazic','00385000771113' ,'lazo@mail.com', '1231231244231', '14422678912', '12344200912', 'Laze Lazica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 2, 8
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'lazo@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', 11, 'Petar', 'Petrovic','00385889771113' ,'petar@mail.com', '1110231231231', '18440638912', '12340400112', 'Milosa Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 2, 9
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'petar@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', 12, 'Dragan', 'Dragovic','00385117761173' ,'dragan@mail.com', '1230001231251', '19990678914', '12343730912', 'Milosa Milosevica 12', 'Novi Sad', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 3, 10
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'dragan@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', 13, 'Ksenija', 'Milosevic','0038227771113' ,'ksenija@mail.com', '1231231412314', '17540678912', '12380033091', 'Adresa Neka 12', 'Beograd', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 3, 11
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'ksenija@mail.com'
);
INSERT INTO user_account (type, id, first_name, last_name, phone_number, email, jmbg, lbo, zk, address, city, country, password, active, last_password_change_date, registration_date, clinic_id, specialization_id)
SELECT 'doctor', 14, 'Nemanja', 'Jovanovic','0038227771113' ,'nemanja@mail.com', '1231231419937', '17546445912', '12866133091', 'Nemanjina adresa 122', 'Beograd', 'Srbija', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07', 4, 12
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'nemanja@mail.com'
);


--Dodavanje unaprijed definisanih pregleda**********************************************

INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (0, 0, null, null, '2020-06-29 12:00',1, 3, null, 1, 1, 1400.0, 200.0);

INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (2, 0, null, null, '2020-06-29 12:20',1, 3, null, 1, 1, 2000.0, 0.0);

INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (3, 0, null, null, '2020-06-29 12:15',1, 4, null, 1, 8, 3000.0, 550.0);

INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (4, 0, null, null, '2020-06-29 11:45',1, 4, null, 1, 9, 2000.0, 300.0);

INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (5, 0, null, null, '2020-06-29 11:40',1, 5, null, 1, 9, 2000.0, 300.0);


--test - infektilna -datum je prosao
INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (6, 0, null, null, '2020-04-24 21:58:58.508-07', 1, 4, null, 1, 1, 1400.0, 200.0);

INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (7, 0, null, null, '2020-04-24 21:58:58.508-07', 1, 4, null, 1, 1, 1400.0, 200.0);



INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (9, 2, null, null, '2020-04-24 21:58:58.508-07', 2, 4, 1, 4, 9, 2000.0, 300.0);

INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (10, 2, null, null, '2020-04-24 21:58:58.508-07', 2, 3, 1, 4, 9, 2000.0, 300.0);

INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (11, 2, null, null, '2020-04-24 21:58:58.508-07', 2, 3, 1, 4, 9, 2000.0, 300.0);

INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (12, 2, null, null, '2020-04-24 21:58:58.508-07', 2, 3, 1, 4, 9, 2000.0, 300.0);



INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (13, 2, null, null, '2020-04-24 21:58:58.508-07', 2, 4, 1, 4, 9, 2000.0, 300.0);

INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (14, 2, null, null, '2020-04-24 21:58:58.508-07', 2, 3, 1, 4, 9, 2000.0, 300.0);

INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (15, 2, null, null, '2020-04-24 21:58:58.508-07', 2, 4, 1, 4, 9, 2000.0, 300.0);

INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (16, 2, null, null, '2020-04-24 21:58:58.508-07', 3, 5, 1, 4, 9, 2000.0, 300.0);


INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (1, 3, null, null, '2020-04-24 21:58:58.508-07', 1, 3, 1, 1, 1, 1400.0, 200.0);




INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (17, 2, null, 5, '2020-02-20 12:00:58.508-07', 1, 3, 1, 1, 1, 1400.0, 200.0);
INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (18, 2, null, 2, '2020-02-24 13:00:58.508-07', 2, 3, 1, 1, 1, 1400.0, 200.0);
INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (19, 2, null, 2, '2020-02-22 14:50:58.508-07', 3, 3, 1, 1, 1, 1400.0, 200.0);
INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (20, 2, null, 4, '2019-04-24 14:00:58.508-07', 4, 3, 1, 1, 1, 1400.0, 200.0);
INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (21, 2, null, 5, '2019-04-25 15:30:58.508-07', 5, 3, 1, 1, 1, 1400.0, 200.0);
INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (22, 2, null, 5, '2019-04-26 12:00:58.508-07', 6, 3, 1, 1, 1, 1400.0, 200.0);
INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (23, 2, null, 3, '2019-04-27 10:10:58.508-07', 7, 3, 1, 1, 1, 1400.0, 200.0);
INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (24, 2, null, 4, '2019-04-28 09:30:58.508-07', 8, 3, 1, 1, 1, 1400.0, 200.0);
INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (25, 2, null, 4, '2019-04-29 09:40:58.508-07', 9, 3, 1, 1, 1, 1400.0, 200.0);
INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (26, 2, null, 5, '2019-04-30 11:25:58.508-07', 10, 3, 1, 1, 1, 1400.0, 200.0);
INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (27, 2, null, 3, '2019-01-24 08:25:58.508-07', 11, 3, 1, 1, 1, 1400.0, 200.0);
INSERT INTO medical_appointment (id, appointment_status, doctor_grade, clinic_grade, date_time, clinic_id, doctor_id, patient_id,
appointment_type_id, room_id, price, discount)
VALUES (28, 2, null, 5, '2019-01-25 08:20:58.508-07', 12, 3, 1, 1, 1, 1400.0, 200.0);



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

--INSERT INTO user_account_authorities(user_account_id, authorities_id) 
--SELECT u.id, a.id
--FROM user_account u, authority a
--WHERE u.email = 'trifkovic69@gmail.com' AND a.name = 'PATIENT' AND 
--NOT EXISTS ( SELECT 1 FROM user_account_authorities WHERE user_account_id = u.id );

--admin
INSERT INTO user_account_authorities(user_account_id, authorities_id) 
SELECT u.id, a.id
FROM user_account u, authority a
WHERE u.email = 'admin@mail.com' AND a.name = 'ADMIN_CC' AND 
NOT EXISTS ( SELECT 1 FROM user_account_authorities WHERE user_account_id = u.id );
