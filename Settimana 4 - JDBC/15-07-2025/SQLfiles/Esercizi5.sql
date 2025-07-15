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
('Giorgio', 'Marini', 'giorgio.marini@gmail.com', 28, 'Cagliari'),
('Nicola', 'Grassi', 'nicola.grassi@gmail.com', 41, 'Roma'),
('Martina', 'Fiore', 'martina.fiore@libero.it', 30, 'Bologna'),
('Simone', 'Costa', 'simone.costa@yahoo.it', 26, 'Napoli'),
('Ilaria', 'Gentile', 'ilaria.gentile@gmail.com', 32, 'Roma'),
('Andrea', 'Sartori', 'andrea.sartori@outlook.com', 44, 'Padova'),
('Federica', 'De Luca', 'federica.deluca@hotmail.com', 39, 'Torino'),
('Paolo', 'Serra', 'paolo.serra@gmail.com', 24, 'Cagliari'),
('Silvia', 'Monti', 'silvia.monti@live.it', 37, 'Milano'),
('Giovanni', 'Neri', 'giovanni.neri@gmail.com', 33, 'Lecce'),
('Elisa', 'Colombo', 'elisa.colombo@yahoo.com', 29, 'Pisa'),
('Stefano', 'Pellegrini', 'stefano.pellegrini@gmail.com', 47, 'Roma'),
('Beatrice', 'Amato', 'beatrice.amato@libero.it', 31, 'Trieste'),
('Lorenzo', 'Martini', 'lorenzo.martini@gmail.com', 36, 'Brescia'),
('Claudia', 'Fabbri', 'claudia.fabbri@alice.it', 28, 'Parma'),
('Gabriele', 'Testa', 'gabriele.testa@gmail.com', 40, 'Modena'),
('Roberta', 'Basili', 'roberta.basili@tim.it', 35, 'Bari'),
('Daniele', 'Vitale', 'daniele.vitale@hotmail.com', 48, 'Messina'),
('Camilla', 'Rinaldi', 'camilla.rinaldi@gmail.com', 30, 'Firenze'),
('Tommaso', 'Marchetti', 'tommaso.marchetti@gmail.com', 43, 'Taranto'),
('Serena', 'Sanna', 'serena.sanna@tiscali.it', 25, 'Sassari'),
('Alberto', 'Longo', 'alberto.longo@gmail.com', 38, 'Catania'),
('Marta', 'Gatti', 'marta.gatti@yahoo.it', 34, 'Trento'),
('Riccardo', 'D''Amico', 'riccardo.damico@gmail.com', 46, 'Roma'),
('Lucia', 'Villa', 'lucia.villa@outlook.com', 27, 'L''Aquila'),
('Davide', 'Bianco', 'davide.bianco@gmail.com', 31, 'Perugia'),
('Alessia', 'Palmieri', 'alessia.palmieri@gmail.com', 23, 'Rimini'),
('Giorgia', 'Nuzzo', 'giorgia.nuzzo@gmail.com', 33, 'Ancona'),
('Christian', 'Bellini', 'christian.bellini@fastwebnet.it', 36, 'Reggio Emilia'),
('Elena', 'Pagano', 'elena.pagano@gmail.com', 30, 'Aosta'),
('Edoardo', 'Mauri', 'edoardo.mauri@gmail.com', 28, 'Campobasso');


/*seleziona i clienti che hanno come dominio gmail*/
select *
from clienti
where email like '%@gmail.com';

/*seleziona tutti i clienti col nome che inizia per A*/
select nome
from clienti
where nome like 'a%';

/*selezione dei clienti col cognome di esattamente 6 caratteri*/
select nome, cognome
from clienti
where char_length(REPLACE(cognome, '''', '')) = 6;

/*selezione dei clienti con età compresa fra 30 e 40*/
select nome, età
from clienti
where età between 30 and 40
order by età desc;

/*seleziona i clienti che abitano a Roma, minuscole e maiuscole ignorate*/
select *
from clienti
where città like 'roma'; /*GPT mi fa notare come questo like funziona di default solo per MySQL*/

/*seleziona tutti i clienti col cognome che inizia per R*/
select *
from clienti
where cognome like 'r%';