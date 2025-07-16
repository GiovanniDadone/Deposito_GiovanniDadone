create database negozio;

use negozio;

create table clienti(
	id_cliente int primary key auto_increment,
    nome varchar(100),
    email varchar(100),
    address varchar(100),
    city varchar(100));
    
INSERT INTO Clienti (Nome, Email, address, city) VALUES
('Joe', 'joe@example.it', 'Via Farlocchi, 53', 'Roma'),
('Maria', 'maria@example.it', 'Piazza Duomo, 1', 'Milano'),
('Luca', 'luca@example.it', 'Corso Vittorio Emanuele, 100', 'Napoli'),
('Sara', 'sara@example.it', 'Via Garibaldi, 25', 'Firenze');
create table ordini(
	id_ordine int primary key auto_increment,
    id_cliente int,
    prodotto varchar(100),
    categoria varchar(100),
    quantità int,
    data_ordine date,
    importo int,
    foreign key (id_cliente) references clienti(id_cliente)
);
INSERT INTO Ordini (id_cliente, prodotto, categoria, quantità, data_ordine, importo) VALUES
(1, 'XiaoMI RedMi Pro', 'Elettronica', 21, '2025-09-06', 450.00),
(2, 'Samsung Galaxy S24', 'Elettronica', 15, '2025-09-07', 899.99),
(3, 'Apple MacBook Air', 'Informatica', 8, '2025-09-08', 1200.00),
(4, 'Sony PlayStation 5', 'Gaming', 10, '2025-09-09', 549.90),
(1, 'LG OLED TV 65"', 'Elettronica', 5, '2025-09-10', 1800.00),
(2, 'Logitech G Pro Mouse', 'Informatica', 30, '2025-09-11', 79.99),
(3, 'Bose QuietComfort 45', 'Audio', 12, '2025-09-12', 299.00),
(4, 'Canon EOS R5', 'Fotografia', 3, '2025-09-13', 3500.00),
(1, 'Dyson V15 Detect', 'Elettrodomestici', 7, '2025-09-14', 650.00),
(2, 'Google Pixel 8 Pro', 'Elettronica', 18, '2025-09-15', 799.00),
(3, 'Microsoft Surface Laptop 5', 'Informatica', 6, '2025-09-16', 1350.00),
(4, 'Nintendo Switch OLED', 'Gaming', 14, '2025-09-17', 329.99),
(1, 'Samsung QLED TV 75"', 'Elettronica', 4, '2025-09-18', 2500.00),
(2, 'Razer BlackWidow V4', 'Informatica', 25, '2025-09-19', 159.99),
(3, 'JBL Flip 6', 'Audio', 20, '2025-09-20', 119.00),
(4, 'Nikon Z9', 'Fotografia', 2, '2025-09-21', 5000.00),
(1, 'iRobot Roomba j7+', 'Elettrodomestici', 9, '2025-09-22', 750.00),
(2, 'OnePlus 12', 'Elettronica', 17, '2025-09-23', 699.00),
(3, 'HP Spectre x360', 'Informatica', 7, '2025-09-24', 1450.00),
(4, 'Xbox Series X', 'Gaming', 11, '2025-09-25', 499.00);