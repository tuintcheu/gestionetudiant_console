package Inscription;
import java.util.ArrayList;
import Examen.Notes;
public class Etudiant {

    private String nom;
    private String prenom;
    private int age;
    private double moyenne; // Nouvelle propriété pour stocker la moyenne de l'étudiant

    public Etudiant(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.moyenne = 0.0; // Initialisation à 0
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }

    // Calcul de la moyenne à partir des notes et des coefficients
    public void calculerMoyenne(ArrayList<Notes> notes) {
        double sommeNotesPonderees = 0.0;
        int sommeCoefficients = 0;

        for (Notes note : notes) {
            if (note.getEtudiant().equals(this)) {
                sommeNotesPonderees += note.getValeur() * note.getMatiere().getCoefficient();
                sommeCoefficients += note.getMatiere().getCoefficient();
            }
        }

        if (sommeCoefficients > 0) {
            this.moyenne = sommeNotesPonderees / sommeCoefficients;
        } else {
            this.moyenne = 0.0;
        }
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", moyenne=" + moyenne +
                '}';
    }
}