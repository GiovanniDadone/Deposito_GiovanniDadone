use libreria;

drop table if exists clienti;


create table clienti (
id int PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100),
cognome VARCHAR(100),
email VARCHAR(100),
età INT,
città VARCHAR(100)
);

INSERT INTO clienti (nome, cognome, email, età, città) VALUES
('Luca', 'Rossi', 'luca.rossi@gmail.com', 35, 'Roma'),
('Giulia', 'Bianchi', 'giulia.bianchi@yahoo.it', 29, 'Milano'),
('Marco', 'Verdi', 'marco.verdi@hotmail.com', 42, 'Torino'),
('Elena', 'Ferrari', 'elena.ferrari@gmail.com', 31, 'Firenze'),
('Davide', 'Russo', 'davide.russo@libero.it', 38, 'Roma'),
('Chiara', 'Esposito', 'chiara.esposito@gmail.com', 27, 'Napoli'),
('Francesco', 'Ricci', 'francesco.ricci@outlook.com', 33, 'Bologna'),
('Laura', 'Gallo', 'laura.gallo@yahoo.com', 45, 'Genova'),
('Alessandro', 'Conti', 'alessandro.conti@gmail.com', 36, 'Venezia'),
('Sara', 'Mancini', 'sara.mancini@live.it', 22, 'Verona'),
('Matteo', 'Lombardi', 'matteo.lombardi@gmail.com', 39, 'Trieste'),
('Valentina', 'Moretti', 'valentina.moretti@tim.it', 40, 'Roma'),
('Federico', 'Barbieri', 'federico.barbieri@gmail.com', 50, 'Bari'),
('Anna', 'Fontana', 'anna.fontana@tiscali.it', 34, 'Palermo'),
('Giorgio', 'Marini', 'giorgio.marini@gmail.com', 28, 'Cagliari');


/*seleziona i clienti che hanno come dominio gmail*/
select *
from clienti
where email like '%@gmail.com';

/*seleziona tutti i clienti col nome che inizia per A*/
select nome
from clienti
where nome like 'a%';

/*selezione dei clienti col cognome di esattamente 5 caratteri*/
select *
from clienti
where char_length(cognome) = 5;

/*selezione dei clienti con età compresa fra 30 e 40*/
select nome, età
from clienti
where età between 30 and 40
order by età desc;

/*seleziona i clienti che abitano a Roma, minuscole e maiuscole ignorate*/
select *
from clienti
where città like 'roma'; /*GPT mi fa notare come questo like funziona di default solo per MySQL*/