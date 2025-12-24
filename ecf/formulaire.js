const motifs = {
  "Code 01 : Retard absence non rémunérée": [
    "Retard"
  ],
  "Code 04 : Grève Afpa": [
    "Grève Afpa"
  ],
  "Code 05 : Maladie": [
    "Maladie"
  ],
  "Code 06 : Absence légale": [
    "Naissance ou adoption (3 jours)",
    "Mariage (4 jours)",
    "Mariage d’un enfant (1 jour)",
    "Décès du conjoint ou partenaire PACS",
    "Décès du père, de la mère, du beau-père, de la belle-mère",
    "Décès d’un frère ou d’une sœur (1 jour)",
    "Visite médicale obligatoire de la grossesse",
    "Stagiaire membre du CA d’une caisse de sécurité sociale"
  ],
  "Code 20 – 21 – 30 – 31 – 40 – 41 : Accident": [
    "Accident travail sans arrêt",
    "Accident travail avec arrêt",
    "Accident trajet sans arrêt",
    "Accident trajet avec arrêt",
    "Accident travail hors Afpa sans arrêt",
    "Accident travail hors Afpa avec arrêt"
  ],
  "Code 98 : Absence autorisée non rémunérée": [
    "Recherche PE",
    "Recherche d’un emploi",
    "Visite d’un salon",
    "Enquête en entreprise",
    "Visite d’un autre centre",
    "RDV psychologue du travail",
    "RDV PÔLE EMPLOI",
    "Absence pour fêtes religieuses hors jours fériés légaux",
    "Grèves des transports",
    "Intempéries",
    "RDV avec le conseiller militaire",
    "RDV avocat, Convocation tribunal ou commissariat",
    "Recherche de logement, RDV organismes divers"
  ],
  "Code 99 : Absence non autorisée non rémunérée": []
};

const container = document.getElementById("motifsAbsence");

for (const code in motifs) {

  // bloc pour un code
  const bloc = document.createElement("div");
  bloc.className = "bloc-motif";

  // titre
  const title = document.createElement("h6");
  title.textContent = code;
  bloc.appendChild(title);

  // checkboxes
  motifs[code].forEach((motif) => {
    const label = document.createElement("label");
    label.style.display = "block";

    const checkbox = document.createElement("input");
    checkbox.type = "checkbox";

    label.appendChild(checkbox);
    label.append(" " + motif);

    bloc.appendChild(label);
  });

  // ajouter le bloc complet
  container.appendChild(bloc);
}

