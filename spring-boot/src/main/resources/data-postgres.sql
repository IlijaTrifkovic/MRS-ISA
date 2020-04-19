-- Lozinke su hesovane pomocu BCrypt algoritma https://www.dailycred.com/article/bcrypt-calculator
-- Lozinka za oba user-a je 123
   
INSERT INTO user_account(id, first_name, last_name, email, lbo, address, city, country, password, active, last_password_change_date, registration_date)
SELECT nextval('nurse_id_generator_seq'), 'Nikola', 'Nikolic', 'mail@mail.com', '12345678912', 'address 1', 'city1', 'country1', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07'
WHERE 
NOT EXISTS (
    SELECT 1 FROM user_account WHERE email = 'mail@mail.com'
);
--INSERT INTO PATIENTS (first_name, last_name, email, lbo, address, city, country, password, active, last_password_change_date, registration_date) VALUES ('Nikola', 'Nikolic', 'mail@mail.com', '12345678912', 'address 1', 'city1', 'country1', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', true, '2019-04-30 21:58:58.508-07', '2019-04-22 21:58:58.508-07');
--INSERT INTO PATIENTS (first_name, last_name, email, lbo, address, city, country, password, active, last_password_change_date, registration_date) VALUES ('Simo', 'Simic', 'mail2@mail.com', '12345678910', 'address 2', 'city2', 'country2', '$2a$04$LgEy3/qIgUKxnOkoKZ/NQuxy4byrw1US9dRaL6L4aAh9ogUduj9lW', false, '2019-04-30 21:58:58.508-07', '2019-04-21 21:58:58.508-07');

INSERT INTO authority(id, name) 
SELECT nextval('authority_seq'), 'NURSE'
WHERE 
NOT EXISTS ( SELECT 1 FROM authority WHERE name = 'NURSE' );

INSERT INTO user_account_authorities(user_account_id, authorities_id) 
SELECT u.id, a.id
FROM user_account u, authority a
WHERE u.email = 'mail@mail.com' AND a.name = 'NURSE' AND 
	NOT EXISTS (
    	SELECT 1 FROM user_account_authorities WHERE user_account_id = u.id
	);

--INSERT INTO REGISTRATION_REQUEST (first_name, last_name, email, lbo, address, city, country, password, expiration date) VALUES ('Milos', 'Milosevic', 'mail3@mail.com', '12345678012', 'address 3', 'city3', 'country3', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '2020-04-30 21:58:58.508-07');
--INSERT INTO REGISTRATION_REQUEST (firstName, lastName, email, lbo, address, city, country, password, expiration_date) VALUES ('Jovan', 'Jovanovic', 'mail4@mail.com', '12345678010', 'address 4', 'city4', 'country4', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '2020-04-20 21:58:58.508-07');