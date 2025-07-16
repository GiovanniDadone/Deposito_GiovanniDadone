use world;

/*Esercizio 1*/ -- lingue parlate per nazione con percentuali di utilizzo -- FUNONZIA, 
-- ordinati prima per nome e per ogni nome le lingue sono ordinate per percentuale discendente
select c.Name, cl.Language, cl.Percentage
from country as c
inner join countrylanguage as cl
on c.Code = cl.CountryCode
order by c.Name asc, cl.Percentage desc;

/*Esercizio 2*/ -- nazioni e la percentuale della lingua più parlata 
select c.Name as Paese, max(cl.Percentage)as Percentuale
from country as c
inner join countrylanguage as cl
on c.Code = cl.CountryCode
group by c.Name;

/*Esercizio 3*/ -- nazioni con nome e il nome della lingua più parlata con percentuale -- Funonzia ma bisognava mettere la subquery al where
select c.Name, cl.Language, cl.Percentage
from country as c
inner join countrylanguage as cl
on c.Code = cl.CountryCode
where cl.Percentage = (
	  select max(cl2.Percentage)
      from countrylanguage as cl2
      where cl2.CountryCode = c.Code
      );