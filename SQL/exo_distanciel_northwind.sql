USE `northwind`;

-- EXERCICE 1 `northwind` :
-- 1. Liste des contacts français pour les clients (Customer)
select CompanyName as societe, contactname as contact, contacttitle as fonction, phone as telephone
from customers
WHERE country = "france";

-- 2. La liste des Produits vendus par Exotic Liquids
select p.productname as produit, p.unitprice as prix
from products p
where supplierid = 1;

-- 3. le nombre de Produits vendus par des sociétés Françaises du plus grand au plus petit
select s.CompanyName as societe, count(p.productid) as nbrProduits
from suppliers s
inner join products p on p.supplierid = s.supplierid
WHERE s.country = "france"
group by s.CompanyName
order by count(p.productid) DESC;

-- 4. Clients français ayant plus de 10 commandes
select CompanyName as client, count(orderid) as nbrCommandes
from customers c
inner join orders o on o.customerid = c.customerid
WHERE country = "france" and orderid > 4
group by c.CompanyName;

-- 5. Clients ayant un chiffre d'affaires > 30 000
select c.contactname as clients, sum( od.unitprice * od.quantity) as CA, c.country
from customers c
inner join orders o on o.customerid = c.customerid
inner join `order details` od on od.orderid = o.orderid
group by c.contactname, c.country
having sum( od.unitprice * od.quantity) > 30000
order by c.contactname ASC;


-- 6. Les Pays des clients chez Exotic Liquids
select distinct c.country as pays
from customers c
inner join orders o on o.customerid = c.customerid
inner join `order details` od on od.orderid = o.orderid
inner join products p on p.productid = od.productid
inner join suppliers s on s.supplierid = p.supplierid
where s.supplierid = 1;

-- 7. Montant des ventes de 1997
select sum( od.unitprice * od.quantity) as `CA 1997`
from `order details` od
inner join orders o on o.orderid = od.orderid
where o.orderdate between '1997-01-01' AND '1997-12-31';

-- 8. Montant des ventes de 1997 par mois
select MONTH(o.OrderDate) AS mois, sum( od.unitprice * od.quantity) as CA
from `order details` od
inner join orders o on o.orderid = od.orderid
where o.orderdate between '1997-01-01' AND '1997-12-31'
GROUP BY MONTH (o.OrderDate);

-- EXERCICE 2 `northwind` :
-- 1. Dernière date de commande de"Du Monde entier"
select max(o.orderdate)
from orders o
inner join customers c on c.customerid = o.customerid
where c.companyname = "Du Monde entier";

-- 2. Délais moyens de livraison
select AVG(o.shipvia) as `delai moyen`
from orders o;  -- je n'ai pas le bon resulat

-- 3. On souhaite supprimer toutes les données liées à "Specialty Biscuits"
	-- 1. Donner les démarches à effectuerau sein de la base de données actuelle pour effectuer ce nettoyage dans l'état actuel ?
    
DELETE od
FROM `order details` od
JOIN products p ON od.ProductID = p.ProductID
JOIN suppliers s ON p.SupplierID = s.SupplierID
WHERE s.CompanyName = "Specialty Biscuits, Ltd.";

DELETE p
FROM products p
JOIN suppliers s ON p.SupplierID = s.SupplierID
WHERE s.CompanyName = "Specialty Biscuits, Ltd.";
    
DELETE 
FROM suppliers
WHERE CompanyName = "Specialty Biscuits, Ltd.";
    

select supplierid, companyname
from suppliers
order by supplierid ASC;  -- ca n'a pas marché
    
    
	-- 2. Quelle modification permettrait au script de création de la base defaire en sorte d'automatiser cette suppression ?
