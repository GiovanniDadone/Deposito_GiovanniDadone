/*select distinct Name from world.country;
select count(distinct Name) from world.country;*/

select Name, Continent, Region, Population, HeadOfState 
from world.country 
where Region = 'Caribbean' and Population > 500000;

select Name, Continent, Region, Population, HeadOfState 
from world.country 
where Continent = 'Asia' and (Population > 500000000 or not Region = 'Southeast Asia');

select Name, Continent, Region, Population 
from world.country 
where Continent = 'Africa' and Region = 'Eastern Africa'
order by Name asc;

select Name, Continent, Region, Population 
from world.country 
where Continent = 'Africa' and Region = 'Eastern Africa'
order by Name desc;

select Code, Name, Continent, Region, Population 
from world.country 
where Continent = 'Africa'
order by Region, SurfaceArea desc;

select * from world.country
order by Region, SurfaceArea desc;

select Continent, count(Code)
from world.country
group by Continent;

select Region, count(Region)
from world.country
group by Region
order by count(Region) desc;

INSERT INTO world.country
(Code,
Name,
Continent,
Region,
SurfaceArea,
IndepYear,
Population,
LifeExpectancy,
GNP,
GNPOld,
LocalName,
GovernmentForm,
HeadOfState,
Capital,
Code2)
VALUES
('AAA', 
'Narnia',
'Asia',
'Artic',
1000.00,
1969,
4,
33,
340.00,
367.00,
'Narnia',
'Monarchy',
'None',
123,
'AA');

update world.country
set Region = 'Wardrobe'
where Code = 'AAA';

select * from world.country order by Code;

delete from world.country where Code = 'AAA';

select * from world.country order by Code;
