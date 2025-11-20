db.getCollection("biblio").find(
    {"fiche.dept":"95", "fiche.adresse_ville":/^Arr/i }, 
    {"fiche.nom":1,"fiche.dept":1, "fiche.adresse_ville":1,"_id":0}
);