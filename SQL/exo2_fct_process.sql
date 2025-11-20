use biblio

-- 1- Créer la BD “biblio” à partir du script donné.

-- 2- Écrire une fonction qui calcule, pour un adhérent donné, le nombre de jours restant avant d’être en retard.
-- ▪Si l’adhérent n’a pas d’emprunts en cours, on renvoie NULL.
-- ▪Si l’adhérent est en retard, on renvoie un résultat négatif correspondant au nombre de jours de retard le plus grand pour ses emprunts en cours. Par exemple, s’il devait rendre un livre avant-hier et qu’il a un livre à rendre le lendemain, on renvoie « -2 » pour avant-hier.
-- ▪Si l’adhérent n’est pas en retard, on renvoie un résultat positif correspondant au nombre de jours d’emprunt restant le plus petit pour ses emprunts en cours. Par exemple, s’il doit rendre un livre demain et un autre après-demain, on renvoie « +1 » pour demain. (Pour ces deux derniers cas, on prendra en compte la possibilité d’avoir des emprunts avec des durées Max différentes et des emprunts en cours avec des dates d’emprunt différentes).

DELIMITER $

CREATE FUNCTION jours_restant_avant_retard(p_numab VARCHAR(5))
RETURNS INT
not DETERMINISTIC
BEGIN
    DECLARE nb_jours INT;

    -- Si l'abonné n'a aucun emprunt
    IF NOT EXISTS (SELECT 1 FROM pret WHERE numab = p_numab) THEN
        RETURN NULL;
    END IF;

    -- Calcul des jours restants pour chaque prêt
    -- Retard = négatif, sinon positif
    SELECT 
        CASE 
            WHEN SUM(CASE WHEN (dureemax - DATEDIFF(CURDATE(), datepret)) < 0 THEN 1 ELSE 0 END) > 0 
            THEN MIN(dureemax - DATEDIFF(CURDATE(), datepret))  -- Au moins un en retard
            ELSE MIN(dureemax - DATEDIFF(CURDATE(), datepret))  -- Tous à temps
        END
    INTO nb_jours
    FROM pret
    WHERE numab = p_numab;

    RETURN nb_jours;
END $

DELIMITER ;

-- Exemple d’appel :
SELECT jour_restant_retard('A010');

-- 3.Utiliser cette fonction pour afficher la situation de tous les adhérents.

SELECT 
    a.numab,
    a.nom,
    a.prenom,
    jours_restant_avant_retard(a.numab) AS jours_restant
FROM abonne a;

-- 4.Écrire une procédure qui permette de lister les emprunts d’un adhérent identifié par son numéro.
DELIMITER $

CREATE PROCEDURE lister_emprunts_adherent(IN p_numab VARCHAR(5))
BEGIN
    SELECT 
        p.numinv AS NumLivre,
        l.titre AS Titre,
        l.auteur AS Auteur,
        p.datepret AS DatePret,
        p.dureemax AS DureeMax,
        (p.dureemax - DATEDIFF(CURDATE(), p.datepret)) AS JoursRestants
    FROM pret p
    JOIN livre l ON p.numinv = l.numinv
    WHERE p.numab = p_numab;
END $

call lister_emprunts_adherent('A009');

-- 5.Écrire une procédure qui affiche les exemplaires disponibles d’un titre (on fera une version OUTER JOIN et une version NOT IN). Pour se faciliter la tâche, on a intérêt à d’abord traiter la question : “combien y a-t-il exemplaires disponibles du titre Dune avec les deux versions demandées, pour ensuite passer à l’écriture de la procédure stockée.
SELECT 
    l.titre,
    l.qte - COUNT(p.numinv) AS qte_disponible
FROM livre l
LEFT JOIN pret p ON l.numinv = p.numinv
WHERE l.titre = 'Dune'
GROUP BY l.titre, l.qte;

SELECT 
    titre,
    qte - (SELECT COUNT(*) 
           FROM pret 
           WHERE pret.numinv = livre.numinv) AS qte_disponible
FROM livre
WHERE titre = 'Dune';

-- 6.Écrire une procédure qui affiche les titres d’un auteur et le nombre d’exemplaires disponibles par titre. On testera avec J.R.R. Tolkien. Pour se faciliter la tâche, on a intérêt à commencer par traiter la question : « Les exemplaires dispo de J.R.R. Tolkien» puis « Le nombre d’exemplaires dispo par titre de J.R.R. Tolkien » pour enfin écrire la procédure stockée.

-- 7.Écrire une procédure qui permette d’enregistrer un emprunt.

-- 8.Modifier la table des emprunts : mettez la valeur par défaut de la durée max à 14.