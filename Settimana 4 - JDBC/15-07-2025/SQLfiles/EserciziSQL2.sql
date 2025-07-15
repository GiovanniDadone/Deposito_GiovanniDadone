select distinct Region
from world.country
where Continent = 'Europe';


select Name, Population
from world.city
where CountryCode = 'USA' and Population > 1000000;

select Continent, count(Name)
from world.country
group by Continent;

select Continent , sum(Population)
from world.country
group by Continent
order by sum(Population) desc;