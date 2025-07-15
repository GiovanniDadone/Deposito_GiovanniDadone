use world;
select *
from country
where Name like 'a%';

/*un po' ridondante*/
select Name, Population
from country
where Population in (select Population 
					 from country
                     where Name like 'a%' and Population > 2000000);
         
/*seleziona i paesi e le popolazioni dove la popolazione è fra 1 e 3 milioni ad eccetto degli Emirati Arabi Uniti*/
select Name, Population
from country
where Population between 1000000 and 3000000
and Population not in (2441000);  /*Elido United Emirates*/


use supermercato;
/*esempio not between*/
select * from vendite
where prodotto not between 'Pasta Barilla' and 'iPhone'
order by prodotto;