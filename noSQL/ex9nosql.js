db.getCollection("biblio").find(
    { 
        $and: [
        { "notation.notes":{ $lt:2} } ,{"notation.notes":{ $not: { $gt: 3 } }}
        ]
    }, 
    {"fiche.nom":1,"fiche.adresse_ville":1, "notation.notes":1, "_id":0}
);