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