db.getCollection("biblio").find(
    {"fiche.categorie":"Bibliothèque départementale", "notation.appreciation":{ $exists:1} }, 
    {"fiche.nom":1,"fiche.adresse_ville":1, "notation.appreciation":"ok", "_id":0}
);