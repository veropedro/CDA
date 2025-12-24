/****************************************************
 * MINI TP 1 - Création d'une structure HTML avec le DOM
 * Objectif : recréer une structure HTML uniquement
 * avec JavaScript et l'insérer dans <div id="output">
 ****************************************************/

alert("JavaScript chargé !");


/* 1️⃣ On récupère la div qui existe déjà dans le HTML */
const output = document.getElementById("output");
output.textContent = "Ça fonctionne !";

/* 2️⃣ On crée la div principale */
const divTP1 = document.createElement("div");
divTP1.id = "divTP1";

/* 3️⃣ On ajoute le début du texte */
divTP1.append("Le ");

/* 4️⃣ <strong>World Wide Web Consortium</strong> */
const strong1 = document.createElement("strong");
strong1.textContent = "World Wide Web Consortium";
divTP1.append(strong1);

/* 5️⃣ Texte intermédiaire */
divTP1.append(", abrégé par le sigle ");

/* 6️⃣ <strong>W3C</strong> */
const strong2 = document.createElement("strong");
strong2.textContent = "W3C";
divTP1.append(strong2);

/* 7️⃣ Suite du texte */
divTP1.append(", est un ");

/* 8️⃣ Premier lien <a> */
const link1 = document.createElement("a");
link1.href = "http://fr.wikipedia.org/wiki/Organisme_de_normalisation";
link1.title = "Organisme de normalisation";
link1.textContent = "organisme de standardisation";
divTP1.append(link1);

/* 9️⃣ Texte après le premier lien */
divTP1.append(
  " à but non-lucratif chargé de promouvoir la compatibilité des technologies du "
);

/* 🔟 Deuxième lien <a> */
const link2 = document.createElement("a");
link2.href = "http://fr.wikipedia.org/wiki/World_Wide_Web";
link2.title = "World Wide Web";
link2.textContent = "World Wide Web";
divTP1.append(link2);

/* 1️⃣1️⃣ Point final */
divTP1.append(".");

/* 1️⃣2️⃣ On insère tout dans la page */
output.append(divTP1);