use world;

/*1 -- servono la lingua e la nazione di ogni città*/
select city.Name,
	   lang.Language,
       city.CountryCode
from city 
inner join countrylanguage as lang
on city.CountryCode = lang.CountryCode;

/*2 -- servono il numero  di città per nazione e mostrando anche il nome della nazione e ordinarli in base al numero di città*/
select country.Name, count(city.name) as NumeroCittà
from country
left join city
on country.Code = city.CountryCode
group by country.Name
order by NumeroCittà;

/*3 -- si vuole conoscere la lista di repubbliche con aspettativa di vita maggiore dei 70 anni, inoltre si vuole visualizzare la lingua parlata*/
select c.Name,
 c.LifeExpectancy,
 cl.Language
from country as c
inner join countrylanguage as cl
on c.Code = cl.CountryCode 
where c.GovernmentForm = 'Republic'and c.LifeExpectancy > 70
order by c.LifeExpectancy desc, c.name, cl.Language;