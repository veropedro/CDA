// Sélectionner le div où l'on va insérer le contenu
const output = document.getElementById("output");

// Créer le conteneur principal
const divTP3 = document.createElement("div");
divTP3.id = "divTP3";

// Créer le paragraphe
const p = document.createElement("p");
p.textContent = "Langages basés sur ECMAScript :";
divTP3.appendChild(p);

// Créer la liste de définitions
const dl = document.createElement("dl");

// Fonction pour créer un élément <dt> et <dd>
function addDefinition(term, description) {
    const dt = document.createElement("dt");
    dt.textContent = term;

    const dd = document.createElement("dd");
    dd.textContent = description;

    dl.appendChild(dt);
    dl.appendChild(dd);
}

// Ajouter chaque définition
addDefinition("JavaScript", "JavaScript est un langage de programmation de scripts principalement utilisé dans les pages web interactives mais aussi coté serveur.");
addDefinition("JScript", "JScript est le nom générique de plusieurs implémentations d'ECMAScript 3 créées par Microsoft.");
addDefinition("ActionScript", "ActionScript est le langage de programmation utilisé au sein d'applications clientes (Adobe Flash, Adobe Flex) et serveur (Flash media server, JRun, Macromedia Generator).");
addDefinition("EX4", "ECMAScript for XML (E4X) est une extension XML au langage ECMAScript.");

// Ajouter la liste à notre div
divTP3.appendChild(dl);

// Ajouter le tout dans le div output
output.appendChild(divTP3);
