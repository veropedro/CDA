db.getCollection("biblio").find(
    {"fiche.categorie":"Bibliothèque municipale", "notation.appreciation":{ $exists:1} }, 
    {"fiche.nom":1,"fiche.adresse_ville":1, "notation.appreciation":1, "notation.notes":1, "_id":0}
);