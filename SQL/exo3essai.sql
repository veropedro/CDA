use exo3;
-- Quelestlenombretotald’étudiants?
select count(*) from etudiant;

-- Quellessont,parmil’ensembledesnotes,lanotelaplushauteetlanotelaplusbasse?
select max(eva_note) as note_max, min(eva_note) as note_min
from evaluer;

-- Quellessontlesmoyennesdechaqueétudiantdanschacunedesmatières?[MGETU]
select etudiant.etu_nom, matiere.mat_label, avg(evaluer.eva_note) as moyenne
from evaluer
INNER JOIN etudiant ON evaluer.etu_num = etudiant.etu_num
INNER JOIN matiere ON evaluer.mat_code = matiere.mat_code
group by etudiant.etu_nom, matiere.mat_label;  

-- Quellessontlesmoyennesparmatière?EnutilisantlarequêteMGETUdelaquestion3[MOYETUMAT]?
select matiere.mat_label, avg(evaluer.eva_note) as moyenne_matiere
from evaluer
INNER JOIN matiere ON evaluer.mat_code = matiere.mat_code
group by matiere.mat_label;

-- Quelleestlamoyennegénéraledechaqueétudiant?EnutilisantlarequêteMGETUdelaquestion3(MOYETUMAT)?
select etudiant.etu_nom, avg(evaluer.eva_note) as moyenne_etudiant
from evaluer
INNER JOIN etudiant ON evaluer.etu_num = etudiant.etu_num
group by etudiant.etu_nom;

-- Quelleestlamoyennegénéraledelapromotion?EnutilisantlarequêteMGETUdelaquestion5?
select avg(evaluer.eva_note) as moyenne_promo
from evaluer;

-- Quelssontlesétudiantsquiontunemoyennegénéralesupérieureouégaleàlamoyennegénéraledelapromotion?AveclavueMGETUdelaquestion5?
select etudiant.etu_nom, avg(evaluer.eva_note) as moyenne_etudiant
from evaluer
INNER JOIN etudiant ON evaluer.etu_num = etudiant.etu_num
group by etudiant.etu_nom
HAVING AVG(evaluer.eva_note) >= (
    SELECT AVG(eva_note) 
    FROM evaluer
);