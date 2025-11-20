db.getCollection("biblio").find(
    {  "notation.notes": { $exists: true },"notation.notes":{ $not: { $elemMatch: { $gt: 3 } } }}, 
    {"fiche.nom":1,"fiche.adresse_ville":1, "notation.notes":1, "_id":0}
);