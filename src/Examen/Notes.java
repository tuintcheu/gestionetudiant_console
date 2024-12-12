package Examen;
import Inscription.Etudiant;
public class Notes {
    
    private Matiere matiere;
    private Etudiant etudiant;
    private double valeur;

    public Notes(Matiere matiere, Etudiant etudiant, double valeur) {
        this.matiere = matiere;
        this.etudiant = etudiant;
        this.valeur = valeur;
    }

    // Getters et setters
    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    @Override
    public String toString() {
        return "Note{" +
                "matiere=" + matiere.getNomMatiere() +
                ", etudiant=" + etudiant.getNom() + " " + etudiant.getPrenom() +
                ", valeur=" + valeur +
                '}';
    }
}
