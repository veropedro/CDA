db.getCollection("biblio").find(
  {
    "notation.notes.0": 1
  },
  {
    _id: 0,
    "fiche.adresse_ville": 1,
    "fiche.nom": 1,
    "notation.notes": 1
  }
)