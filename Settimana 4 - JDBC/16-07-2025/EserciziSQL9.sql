use world;

/*Esercizio 1*/ -- lingue parlate per nazione con percentuali di utilizzo -- FUNONZIA, 
-- ordinati prima per nome e per ogni nome le lingue sono ordinate per percentuale discendente
select c.Name, cl.Language, cl.Percentage
from country as c
inner join countrylanguage as cl
on c.Code = cl.CountryCode
order by c.Name asc, cl.Percentage desc;

/*Esercizio 2*/ -- nazioni e la percentuale della lingua più parlata
select c.Name as Paese, max(cl.Percentage)as 'Percentuale lingua più parlata'
from country as c
inner join countrylanguage as cl
on c.Code = cl.CountryCode
group by c.Name;

/*Esercizio 3*/ -- nazioni con nome e il nome della lingua più parlata con percentuale -- Funonzia ma bisognava mettere la subquery al where
select c.Name, cl.Language, cl.Percentage as 'Percentuale Massima'
from country as c
inner join countrylanguage as cl
on c.Code = cl.CountryCode
where cl.Percentage = (
	  select max(cl2.Percentage)
      from countrylanguage as cl2
      where cl2.CountryCode = c.Code
      );
      
/*recuperare e mostrare le città con il codice della nazione che indica l'utente*/
select c.Name, ct.Name
from country as c
inner join city as ct
on c.Code = ct.CountryCode
order by c.Name, ct.Name; -- entrambi ascendenti

/*recuperare e mostrare le città con il codice della nazione che indica l'utente*/
select c.Name, ct.Name
from country as c
inner join city as ct
on c.Code = ct.CountryCode
order by c.Name, ct.Name desc; -- paesi per nome ascendenti, città per nome discendenti

/*recuperare e mostrare le città con il codice della nazione che indica l'utente*/
select c.Name, ct.Name
from country as c
inner join city as ct
on c.Code = ct.CountryCode
order by c.Name desc, ct.Name; -- paesi per nome discendenti, città per nome ascendenti

/*recuperare e mostrare le città con il codice della nazione che indica l'utente*/
select c.Code, ct.Name
from country as c
inner join city as ct
on c.Code = ct.CountryCode
order by c.Name desc, ct.Name desc; -- entrambi discendenti

/*Filtraggio delle città per un minimo di popolazione*/
SELECT 
    c.Code,
    ct.Name,
    ct.Population,
    CASE
        WHEN ct.Population > 5000000 THEN 'Megalopoli'
        WHEN ct.Population > 1000000 THEN 'Grande città'
        WHEN ct.Population > 500000 THEN 'Media città'
        ELSE 'Piccola città'
    END AS Categoria
FROM country AS c
INNER JOIN city AS ct ON c.Code = ct.CountryCode
ORDER BY c.Name, ct.Name;

/*mostrando il nome della nazione a seconda del code*/
select ct.CountryCode, c.Name, ct.Name
from country as c
inner join city as ct
on c.Code = ct.CountryCode
order by c.Name, ct.Name;