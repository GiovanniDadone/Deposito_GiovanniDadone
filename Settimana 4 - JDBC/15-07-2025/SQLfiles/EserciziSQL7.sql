/*PROVE SULL'UNION*/

use world;

SELECT 
    Name AS 'Nome Città/Stato', 
    Population AS 'Popolazioni Miste'
FROM city
UNION ALL 
SELECT 
    Name,
    Population
FROM country
ORDER BY 1;  -- Orders by first column (Name)
       


SELECT City.Name AS 'Nome Città', Country.Name AS 'Nome Paese'
FROM City
LEFT JOIN Country ON City.CountryCode = Country.Code

UNION

SELECT City.Name AS 'Nome Città', Country.Name AS 'Nome Paese'
FROM City
RIGHT JOIN Country ON City.CountryCode = Country.Code;