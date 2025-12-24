// Test pour vérifier que le JS fonctionne
alert("JavaScript chargé !");

// On récupère la div où on va mettre le contenu
const output = document.getElementById("output");

// 1️⃣ Crée la div principale
const divTP1 = document.createElement("div");
divTP1.id = "divTP1";

// 2️⃣ Ajoute le début du texte
divTP1.append("Le ");

// 3️⃣ <strong>World Wide Web Consortium</strong>
const strong1 = document.createElement("strong");
strong1.textContent = "World Wide Web Consortium";
divTP1.append(strong1);

// 4️⃣ Texte intermédiaire
divTP1.append(", abrégé par le sigle ");

// 5️⃣ <strong>W3C</strong>
const strong2 = document.createElement("strong");
strong2.textContent = "W3C";
divTP1.append(strong2);

// 6️⃣ Suite du texte
divTP1.append(", est un ");

// 7️⃣ Premier lien <a>
const link1 = document.createElement("a");
link1.href = "http://fr.wikipedia.org/wiki/Organisme_de_normalisation";
link1.title = "Organisme de normalisation";
link1.textContent = "organisme de standardisation";
link1.target = "_blank"; // ouvre le lien dans un nouvel onglet
divTP1.append(link1);

// 8️⃣ Texte après le premier lien
divTP1.append(" à but non-lucratif chargé de promouvoir la compatibilité des technologies du ");

// 9️⃣ Deuxième lien <a>
const link2 = document.createElement("a");
link2.href = "http://fr.wikipedia.org/wiki/World_Wide_Web";
link2.title = "World Wide Web";
link2.textContent = "World Wide Web";
link2.target = "_blank"; // ouvre le lien dans un nouvel onglet
divTP1.append(link2);

// 🔟 Point final
divTP1.append(".");

// 1️⃣1️⃣ On insère tout dans la page
output.append(divTP1);
