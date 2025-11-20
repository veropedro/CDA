db.getCollection("biblio").find(
    {"fiche.adresse_ville": {$regex : /^b.*o.*le$/i}},
    {"fiche.adresse_ville":1,"_id":0}
);
