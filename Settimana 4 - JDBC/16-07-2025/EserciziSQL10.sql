use world;

create view view1 as
select ct.CountryCode, ct.Name, ct.Population
from city as ct
where ct.CountryCode = 'ITA';

select c.CountryCode, c.Name, c.Population
from view1 c
where c.Population < 100000;

drop view view1;