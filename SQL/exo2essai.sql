USE exo2;
-- Donnez la liste des employés ayant une commission
select comm from employes where comm is not null;

-- Donnez les noms, emplois et salaires des employés par emploi croissant, et pour chaque emploi, par salaire décroissant ?
select employes.enom, employes.prof, employes.sal from employes order by prof ASC;
select employes.enom, employes.prof, employes.sal from employes order by sal ASC;

-- Donnez le salaire moyen des employés ?
select avg(sal) as "salaire moyen des employés" from employes;

-- Donnez le salaire moyen du département Production ?


-- Donnez les numéros de département et leur salaire maximum ?

-- Donnez les différentes professions et leur salaire moyen ?
select employes.prof, avg(sal) from employes GROUP BY prof;

-- Donnez le salaire moyen par profession le plus bas ?
select employes.prof, avg(sal) as salaire_moyen
from employes 
GROUP BY prof 
order by salaire_moyen ASC;

-- Donnez-le ou les emplois ayant le salaire moyen le plus bas, ainsi que ce salaire moyen ?
select employes.prof, min(sal) AS salaire_min
from employes
GROUP BY prof
ORDER BY salaire_min ASC
limit 1;

