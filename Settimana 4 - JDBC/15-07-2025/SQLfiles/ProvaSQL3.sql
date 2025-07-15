use world;

/*restituisce un result set che unisce i dati di due tabella, ovvero JOIN*/
-- INNER JOIN
SELECT City.Name, City.Population, Country.Name AS Country
FROM City
INNER JOIN Country
ON City.CountryCode = Country.Code;

use libreria;

select clienti.nome, libri.titolo
from clienti
inner join libri
on clienti.id = libri.id;

-- LEFT  JOIN
use world;
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM City 
LEFT JOIN Country ON City.CountryCode = Country.Code;

-- RIGHT JOIN
SELECT City.Name AS CityName, Country.Name AS CountryName
FROM City 
RIGHT JOIN Country ON City.CountryCode = Country.Code;

-- CROSS JOIN
select city.name as 'Nome Città', Country.name as 'Nome Paese'
from city
cross join country on city.CountryCode = Country.Code;

-- CROSS JOIN 2
use libreria;
select clienti.id, clienti.nome, libri.id, libri.titolo
from clienti
cross join libri
on clienti.id = libri.id;