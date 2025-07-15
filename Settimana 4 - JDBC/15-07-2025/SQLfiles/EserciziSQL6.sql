use supermercato;

drop table if exists Ordini;
drop table if exists Clienti;

create table Clienti(
id int PRIMARY KEY,
nome varchar(100),
città varchar(100)
);

-- Creazione tabella Ordini con relazione a Clienti, gentile concessione di geppetto
CREATE TABLE Ordini (
    id INT PRIMARY KEY,
    id_cliente INT,
    data_ordine DATE,
    importo DECIMAL(7, 2),
    FOREIGN KEY (id_cliente) REFERENCES Clienti(id)
);

-- Popolamento tabella Clienti
-- Inserimento clienti
INSERT INTO Clienti (id, nome, città) VALUES
(1, 'Mario Rossi', 'Roma'),
(2, 'Luigi Bianchi', 'Milano'),
(3, 'Anna Verdi', 'Napoli'),
(4, 'Paola Neri', 'Firenze'),
(5, 'Giovanni Gialli', 'Bologna'),
(6, 'Elena Blu', 'Torino');

-- Inserimento ordini
INSERT INTO Ordini (id, id_cliente, data_ordine, importo) VALUES
(101, 1, '2023-01-15', 150.50),
(102, 1, '2023-02-20', 230.00),
(103, 2, '2023-03-10', 75.99),
(104, 3, '2023-04-05', 420.00),
(105, 3, '2023-05-12', 89.50),
(106, 3, '2023-06-18', 156.75),
(107, 5, '2023-07-22', 310.25),
(108, NULL, '2023-08-30', 99.99);  -- Ordine senza cliente associato

-- 1  INNER JOIN
select Clienti.nome, Ordini.data_ordine, Ordini.importo
from Clienti
INNER JOIN Ordini on Clienti.id = Ordini.id_cliente;

-- 2  LEFT JOIN
select Clienti.nome, Ordini.data_ordine, Ordini.importo
from Clienti
LEFT JOIN Ordini on Clienti.id = Ordini.id_cliente;

-- 3 RIGHT JOIN
select Clienti.nome, Ordini.data_ordine, Ordini.importo
from Clienti
RIGHT JOIN Ordini on Clienti.id = Ordini.id_cliente;

-- 4  Clienti attivi con almeno un ordine (e somma degli importi)
SELECT 
    c.nome,
    COUNT(o.id) AS numero_ordini,
    SUM(o.importo) AS totale_speso
FROM Clienti AS c
INNER JOIN Ordini AS o ON c.id = o.id_cliente
GROUP BY c.nome;

-- 5  Clienti senza ordini
SELECT 
    c.nome, coalesce(c.nome, 'nessun ordine') as 'Nome Cliente'
FROM Clienti AS c
WHERE c.id NOT IN (SELECT DISTINCT id_cliente FROM Ordini WHERE id_cliente IS NOT NULL);

-- 6 Ordini orfani
SELECT 
    o.id AS id_ordine,
    o.data_ordine,
    o.importo
FROM Ordini AS o
LEFT JOIN Clienti AS c ON o.id_cliente = c.id
WHERE c.id IS NULL OR o.id_cliente IS NULL;