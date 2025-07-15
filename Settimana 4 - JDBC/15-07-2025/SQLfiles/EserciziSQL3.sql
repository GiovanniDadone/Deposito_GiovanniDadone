drop database if exists libreria;

create database libreria;
use libreria;

CREATE TABLE libri(
    id INT PRIMARY KEY,
    titolo VARCHAR(100),
    autore VARCHAR(100),
    genere VARCHAR(50),
    prezzo DECIMAL(5,2),
    anno_pubblicazione int
);


INSERT INTO libri (id, titolo, autore, genere, prezzo, anno_pubblicazione) VALUES
(1, 'Il Piccolo Principe', 'Antoine de Saint-Exupéry', 'Fantasy', 9.90, 1943),
(2, 'To Kill a Mockingbird', 'Harper Lee', 'Drammatico', 13.50, 1960),
(3, 'Il Signore degli Anelli', 'J.R.R. Tolkien', 'Fantasy', 25.00, 1954),
(4, 'Cime Tempestose', 'Emily Brontë', 'Romantico', 12.80, 1847),
(5, 'Il Grande Gatsby', 'F. Scott Fitzgerald', 'Classico', 14.90, 1925),
(6, 'Delitto e Castigo', 'Fëdor Dostoevskij', 'Classico', 18.50, 1866),
(7, 'Fahrenheit 451', 'Ray Bradbury', 'Fantascienza', 11.20, 1953),
(8, 'La Metamorfosi', 'Franz Kafka', 'Surrealista', 8.90, 1915),
(9, 'Anna Karenina', 'Lev Tolstoj', 'Classico', 22.00, 1877),
(10, 'Il Conte di Montecristo', 'Alexandre Dumas', 'Classico', 19.90, 1844);

select genere,
       count(*) as numero_libri,
       round(avg(prezzo), 2) as prezzo_medio
from libreria.libri
group by genere
order by genere;

select titolo, autore, prezzo, anno_pubblicazione
from libri
where anno_pubblicazione > 1940
order by anno_pubblicazione desc, prezzo asc;
