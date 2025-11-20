USE `exo5`;
-- Lesinformationsrelativesauxétudiants(Code,NometDatedenaissance)selonl’ordrealphabétiquecroisantdunom?
select NomEt, CodeEt, DatnEt
from etudiant
order by etudiant.NomEt ASC;

-- Lesnomsetlesgradesdesenseignantsdelamatièredontlenomest‘BD’?
select enseignant.NomEns , enseignant.GradeEns
from enseignant
inner join matiere on matiere.CodeMat = enseignant.CodeMat
where matiere.NomMat = "BD";

-- Lalistedistincteforméedesnomsetlescoefficientsdesdifférentesmatièresquisontenseignéespardesenseignantsdegrade‘Grd3’?
select matiere.NomMat , matiere.CoefMat
from matiere
inner join enseignant on enseignant.CodeMat = matiere.CodeMat
where enseignant.GradeEns = "Grd3";

-- Lalistedesmatières(NometCoefficient)quisontsuiviesparl’étudiantdecode‘23’?
select distinct matiere.NomMat , matiere.CoefMat
from matiere
inner join note on note.CodeMat = matiere.CodeMat
inner join etudiant on etudiant.CodeEt = note.CodeEt
where etudiant.CodeEt = 23;

-- Lenombred’enseignantsdelamatièredontlenomest‘physique’?
select count(enseignant.NomEns) as "nbr d'enseignant"
from enseignant
inner join matiere on matiere.CodeMat = enseignant.CodeMat
where matiere.NomMat = "physique";
