use world;

SELECT CountryCode, COUNT(*) AS NumeroLingue
FROM CountryLanguage
WHERE IsOfficial = 'T'
GROUP BY CountryCode
HAVING COUNT(*) > 1;

select country.Name, country.Population
from country
where Population > ALL (SELECT Population from city where city.Population > 1000000)
order by country.Population;