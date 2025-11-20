use sparadrap;

SELECT 
    CONCAT(
        (SELECT pers_prenom FROM Personne WHERE idPersonne = cl.idPersonne),
        ' ',
        (SELECT pers_nom FROM Personne WHERE idPersonne = cl.idPersonne)
    ) AS client,
    
    CONCAT(
        (SELECT pers_prenom FROM Personne WHERE idPersonne = me.idPersonne),
        ' ',
        (SELECT pers_nom FROM Personne WHERE idPersonne = me.idPersonne)
    ) AS medecin
FROM CLIENT cl
INNER JOIN MEDECIN me ON cl.idMedecin = me.idMedecin;


SELECT * FROM MEDICAMENT;


