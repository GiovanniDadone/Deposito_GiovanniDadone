select Name as Paese, GovernmentForm as Forma_di_Governo
from country as paesi_del_mondo;

select Continent as Continente, count(distinct Region) as n°_regioni
from country
group by Continent;

SELECT Name as popolazione_minima
FROM country
ORDER BY Population ASC
LIMIT 1;

select Name as popolazione_minima
from country
where Population = (select MIN(Population) from country);

select Name, min(SurfaceArea) as most_little_surface
from country
group by Name
order by most_little_surface;

select Name, min(SurfaceArea) as most_little_surface
from country
where SurfaceArea > 400
group by Name
order by most_little_surface;

select Continent, count(distinct Region) as n°_regioni
from country
group by Continent;

select Region, avg(Population) as media_popolazione
from country
where Population > 100000000
group by Region; 

select Continent, sum(Population) as popolazione_totale_per_continente
from country
group by Continent;