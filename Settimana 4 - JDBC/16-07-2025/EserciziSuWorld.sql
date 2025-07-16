use world;

/*numero di città negli stati uniti*/
select c.Name, count(city.Name) as 'Numero di città'
from country as c
inner join city
on c.Code = city.CountryCode
where c.Code = 'USA'
group by c.Code;

/*popolazione e aspettativa di vita in Argentina (ARG)*/
select c.Name, c.Population, c.LifeExpectancy
from country as c
where c.Code = 'ARG';

/*quale paese ha la maggior aspettativa di vita*/  -- trovata è Andorra/83.5
select c.Name, max(c.LifeExpectancy) as count
from country c
where c.Population is not null
group by c.Name
order by count desc
limit 1;

/*qual è la capitale della spagna?*/ -- funziona ma non ce ne stanno
select c.Name, ct.Name
from country c
left join city ct
on c.Capital = ct.Name
where ct.Name is not null;

/*lista tutte le lingue parlate nella regione southeast asia*/
select c.Region, count(distinct cl.Language) as 'Numero Lingue Parlate'
from country c
left join countrylanguage cl
on c.Code = cl.CountryCode
where c.Region = 'Southeast Asia'
group by c.Region;

/*25 città dal mondo che iniziano per la lettera F*/
select ct.ID, ct.Name
from city as ct
where ct.Name like 'F%' and ct.ID is not null
limit 25;

SELECT city.Name AS Città,
	   city.Population AS Popolazione,
CASE
	WHEN Population > 5000000 THEN 'Megalopoli'
	WHEN Population > 1000000 THEN 'Grande città'
	WHEN Population > 500000 THEN 'Media città'
	ELSE 'Piccola città'
END AS Categoria
FROM city
ORDER BY city.Population DESC;

select c.Name
from country as c
order by
(case
    when c.HeadOfState is null then c.Capital
    else c.Name
end);