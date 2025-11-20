db.getCollection("biblio").find(
    {"notation.appreciation":{ $in: ["moyen","tres moyen"]}},
    {"fiche.nom":1,"fiche.adresse_ville":1, "notation.appreciation":1, "notation.notes":1, "_id":0}
);