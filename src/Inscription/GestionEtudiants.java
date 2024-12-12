package Inscription;

import Examen.Matiere;
import Examen.Notes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GestionEtudiants {
    private ArrayList<Etudiant> listeEtudiants;

    public GestionEtudiants() {
        listeEtudiants = new ArrayList<>();
    }

    // Méthode pour ajouter des étudiants
    public void inscrireEtudiants() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Combien d'étudiants souhaitez-vous inscrire ? ");
        int nombre = sc.nextInt();
        sc.nextLine(); // Consommer la fin de ligne

        for (int i = 0; i < nombre; i++) {
            System.out.println("\n\t\t\t ###Inscription de l'étudiant " + (i + 1) + "###\n");
            
            System.out.print("Nom : ");
            String nom = sc.nextLine();
            System.out.print("Prénom : ");
            String prenom = sc.nextLine();
            System.out.print("Âge : ");
            int age = sc.nextInt();
            sc.nextLine(); // Consommer la fin de ligne

            Etudiant etudiant = new Etudiant(nom, prenom, age);
            listeEtudiants.add(etudiant);
        }
    }

    // Méthode pour afficher les étudiants
    public void afficherListeEtudiants() {
        System.out.println("\n\t\t\t###Liste des Étudiants### ");
        System.out.printf(" %-15s %-15s %-5s %-10s%n", "Nom", "Prénom", "Âge", "Moyenne");
        for (Etudiant etudiant : listeEtudiants) {
            System.out.printf("%-15s %-15s %-5d %-10.2f%n", 
                              etudiant.getNom(), 
                              etudiant.getPrenom(), 
                              etudiant.getAge(), 
                              etudiant.getMoyenne());
        }
    }

    public ArrayList<Etudiant> getListeEtudiants() {
        return listeEtudiants;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Gestion des étudiants et des matières
        GestionEtudiants gestion = new GestionEtudiants();
        gestion.inscrireEtudiants();
        ArrayList<Etudiant> etudiants = gestion.getListeEtudiants();

        ArrayList<Matiere> matieres = new ArrayList<>();
        System.out.print("\nCombien de matières ? ");
        int nombreMatieres = sc.nextInt();
        sc.nextLine(); // Consommer la fin de ligne

        for (int i = 0; i < nombreMatieres; i++) {
            System.out.println("\n \t\t\t###Matière " + (i + 1) + "### \n");
            System.out.print("Code de la matière : ");
            String code = sc.nextLine();
            System.out.print("Nom de la matière : ");
            String nomMatiere = sc.nextLine();
            System.out.print("Coefficient : ");
            int coef = sc.nextInt();
            sc.nextLine(); // Consommer la fin de ligne

            Matiere matiere = new Matiere(code, nomMatiere, coef);
            matieres.add(matiere);
        }

        // Saisie des notes
        ArrayList<Notes> notes = new ArrayList<>();
        for (Etudiant etudiant : etudiants) {
            System.out.println("\nEntrez les notes pour " + etudiant.getNom() + ": ");
            for (Matiere matiere : matieres) {
                System.out.print("Note pour " + matiere.getNomMatiere() + " : ");
                double noteValeur = sc.nextDouble();
                sc.nextLine(); // Consommer la fin de ligne

                Notes note = new Notes(matiere, etudiant, noteValeur);
                notes.add(note);
            }
        }

        // Calcul de la moyenne de chaque étudiant
        for (Etudiant etudiant : etudiants) {
            etudiant.calculerMoyenne(notes);
        }

        // Menu interactif
        int choix;
        do {
            System.out.println("\n\t\t\t\t###Menu###\n");
            System.out.println("1 - Afficher par ordre de mérite");
            System.out.println("2 - Premier et dernier de la classe");
            System.out.println("3 - Moyenne de la classe");
            System.out.println("4 - Étudiants avec moyenne >= moyenne de la classe");
            System.out.println("5 - Liste des admis");
            System.out.println("0 - Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();

            switch (choix) {
                case 1:
                    // Trier et afficher les étudiants par moyenne décroissante
                    Collections.sort(etudiants, Comparator.comparingDouble(Etudiant::getMoyenne).reversed());
                    System.out.println("\nRésultats par ordre de mérite :");
                    System.out.printf(" %-15s %-15s %-5s %-10s%n",  "Nom", "Prénom", "Âge", "Moyenne");
                    for (Etudiant etudiant : etudiants) {
                        System.out.printf(" %-15s %-15s %-5d %-10.2f%n", 
                                          etudiant.getNom(), 
                                          etudiant.getPrenom(), 
                                          etudiant.getAge(), 
                                          etudiant.getMoyenne());
                    }
                    break;

                case 2:
                    // Afficher le premier et le dernier
                    Collections.sort(etudiants, Comparator.comparingDouble(Etudiant::getMoyenne).reversed());
                    if (!etudiants.isEmpty()) {
                        Etudiant first = etudiants.get(0);
                        Etudiant last = etudiants.get(etudiants.size() - 1);
                        System.out.printf(" %-15s %-15s %-5s %-10s%n",  "Nom", "Prénom", "Âge", "Moyenne");
                
                        System.out.println("\nPremier de la classe : ");
                        System.out.printf("%-15s %-15s %-5d %-10.2f%n", 
                                          first.getNom(), 
                                          first.getPrenom(), 
                                          first.getAge(), 
                                          first.getMoyenne());
                        
                        System.out.println("Dernier de la classe : ");
                        System.out.printf(" %-15s %-15s %-5d %-10.2f%n", 
                                          last.getNom(), 
                                          last.getPrenom(), 
                                          last.getAge(), 
                                          last.getMoyenne());
                    } else {
                        System.out.println("Aucun étudiant enregistré.");
                    }
                    break;

                case 3:
                    // Calculer et afficher la moyenne de la classe
                    double s = 0;
                    for (Etudiant etudiant : etudiants) {
                        s += etudiant.getMoyenne();
                    }
                    double moy = s / etudiants.size();
                    System.out.println("\nla Moyenne générale est : " + moy);
                    break;

                case 4:
                    // Afficher les étudiants ayant une moyenne >= moyenne de la classe
                    s = 0; 
                    for (Etudiant etudiant : etudiants) {
                        s += etudiant.getMoyenne();
                    }
                    moy = s / etudiants.size();
                    System.out.println("\nÉtudiants avec moyenne supérieure ou égale à la moyenne de la classe :");
                    System.out.printf(" %-15s %-15s %-5s %-10s%n",  "Nom", "Prénom", "Âge", "Moyenne");
                    for (Etudiant etudiant : etudiants) {
                        if (etudiant.getMoyenne() >= moy) {
                            System.out.printf(" %-15s %-15s %-5d %-10.2f%n", 
                                              etudiant.getNom(), 
                                              etudiant.getPrenom(), 
                                              etudiant.getAge(), 
                                              etudiant.getMoyenne());
                        }
                    }
                    break;

                case 5:
                    // Afficher les étudiants admis (moyenne >= 10)
                    System.out.println("\nÉtudiants admis :");
                    System.out.printf(" %-15s %-15s %-5s %-10s%n",  "Nom", "Prénom", "Âge", "Moyenne");
                    boolean aucunAdmis = true;
                    for (Etudiant etudiant : etudiants) {
                        if (etudiant.getMoyenne() >= 10) {
                            System.out.printf(" %-15s %-15s %-5d %-10.2f%n", 
                                              etudiant.getNom(), 
                                              etudiant.getPrenom(), 
                                              etudiant.getAge(), 
                                              etudiant.getMoyenne());
                            aucunAdmis = false;
                        }
                    }
                    if (aucunAdmis) {
                        System.out.println("AUCUN Étudiant Admis !!!! (*NEANT*)");
                    }
                    break;

                case 0:
                    System.out.println("Merci et à bientôt  *|*");
                    break;

                default:
                    System.out.println("\n\n\t\tVeuillez consulter le menu svp !!\n\nEntrer un nouveau choix  ");
            }
        } while (choix != 0);

        sc.close();
    }
}