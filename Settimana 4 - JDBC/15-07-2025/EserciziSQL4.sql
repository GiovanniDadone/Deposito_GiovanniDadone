drop database if exists supermercato;

create database supermercato;
use supermercato;

create table vendite (
id INT,
prodotto VARCHAR(100),
categoria VARCHAR(100),
quantita INT,
prezzo_unitario DECIMAL(6,2),
data_vendita date
);

INSERT INTO vendite (id, prodotto, categoria, quantita, prezzo_unitario, data_vendita) VALUES
(1, 'Laptop Dell XPS 13', 'Elettronica', 2, 899.99, '2024-01-15'),
(2, 'iPhone 15', 'Elettronica', 1, 999.00, '2024-01-16'),
(3, 'Maglietta Nike', 'Abbigliamento', 3, 29.99, '2024-01-17'),
(4, 'Caffè Arabica 1kg', 'Alimentari', 5, 12.50, '2024-01-18'),
(5, 'Scrivania IKEA', 'Arredamento', 1, 149.90, '2024-01-19'),
(6, 'Scarpe Adidas', 'Abbigliamento', 2, 89.99, '2024-01-20'),
(7, 'Tablet Samsung', 'Elettronica', 1, 299.00, '2024-01-21'),
(8, 'Pasta Barilla 500g', 'Alimentari', 10, 1.20, '2024-01-22'),
(9, 'Lampada da tavolo', 'Arredamento', 2, 45.00, '2024-01-23'),
(10, 'Jeans Levi''s', 'Abbigliamento', 1, 79.99, '2024-01-24'),
(11, 'Cuffie Sony', 'Elettronica', 1, 199.99, '2024-01-25'),
(12, 'Olio extravergine 1L', 'Alimentari', 3, 8.90, '2024-01-26'),
(13, 'Poltrona relax', 'Arredamento', 1, 299.00, '2024-01-27'),
(14, 'Giacca invernale', 'Abbigliamento', 1, 119.99, '2024-01-28'),
(15, 'Smartphone Xiaomi', 'Elettronica', 2, 249.99, '2024-01-29'),
(16, 'Riso Basmati 1kg', 'Alimentari', 4, 3.50, '2024-01-30'),
(17, 'Comodino legno', 'Arredamento', 2, 89.90, '2024-02-01'),
(18, 'Felpa Puma', 'Abbigliamento', 1, 49.99, '2024-02-02'),
(19, 'Monitor 24 pollici', 'Elettronica', 1, 189.99, '2024-02-03'),
(20, 'Pasta integrale 500g', 'Alimentari', 6, 1.80, '2024-02-04'),
(21, 'Divano 3 posti', 'Arredamento', 1, 599.00, '2024-02-05'),
(22, 'Sneakers Converse', 'Abbigliamento', 1, 65.00, '2024-02-06'),
(23, 'Tastiera meccanica', 'Elettronica', 1, 89.99, '2024-02-07'),
(24, 'Prosciutto San Daniele', 'Alimentari', 1, 24.90, '2024-02-08'),
(25, 'Libreria modulare', 'Arredamento', 1, 179.90, '2024-02-09'),
(26, 'Cappotto donna', 'Abbigliamento', 1, 159.99, '2024-02-10'),
(27, 'Auricolari wireless', 'Elettronica', 3, 39.99, '2024-02-11'),
(28, 'Parmigiano 24 mesi', 'Alimentari', 2, 18.50, '2024-02-12'),
(29, 'Tappeto persiano', 'Arredamento', 1, 249.00, '2024-02-13'),
(30, 'Camicia elegante', 'Abbigliamento', 2, 39.99, '2024-02-14');


select categoria, sum(quantita)
from vendite
group by categoria;

select categoria, round(avg(prezzo_unitario), 2) as Prezzo_Medio
from vendite
group by categoria;

select prodotto, quantita
from vendite
where quantita > 0
order by quantita desc;

select prodotto, prezzo_unitario
from vendite
where prezzo_unitario = (select max(prezzo_unitario) from vendite);

select prodotto, prezzo_unitario
from vendite
where prezzo_unitario = (select min(prezzo_unitario) from vendite);

select count(distinct prodotto) as numero_vendite
from vendite;

select prodotto, prezzo_unitario
from vendite
order by prezzo_unitario desc
limit 5;

select prodotto, sum(quantita) as vendita_totale
from vendite
group by prodotto
order by vendita_totale
limit 3;

select categoria,
min(prezzo_unitario) as 'prezzo minimo per categoria',
max(prezzo_unitario) as 'prezzo massimo per categoria',
round(avg(prezzo_unitario), 2) as 'media per categoria'
from vendite
group by categoria;