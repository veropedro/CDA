db.getCollection("biblio").countDocuments({ "notation.notes": { $exists: true } });

db.getCollection("biblio").countDocuments({ "notation.notes": { $exists: false } });