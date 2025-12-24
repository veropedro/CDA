// On récupère le div où on va ajouter le contenu
const output = document.getElementById("output");

// Crée la div principale
const divTP2 = document.createElement("div");
divTP2.id = "divTP2";

// Crée le paragraphe
const p = document.createElement("p");
p.textContent = "Langages basés sur ECMAScript :";
divTP2.append(p);

// Crée la liste
const ul = document.createElement("ul");

// Crée les éléments de la liste
const langages = ["JavaScript", "JScript", "ActionScript", "EX4"];
langages.forEach(lang => {
  const li = document.createElement("li");
  li.textContent = lang;
  ul.append(li);
});

// Ajoute la liste à la div
divTP2.append(ul);

// Insère la div dans la page
output.append(divTP2);
