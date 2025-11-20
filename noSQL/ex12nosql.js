db.getCollection("biblio").find(
  {
    "notation.appreciation": "ok",
    "notation.notes": [5, 5, 4]
  },
  {
    _id: 0,
    "fiche.adresse_ville": 1,
    "fiche.nom": 1,
    "notation.notes": 1
  }
)
