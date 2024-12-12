package Examen;
public class Matiere {
    private String code;
    private String nomMatiere;
    private int coefficient;

    public Matiere(String code, String nomMatiere, int coefficient) {
        this.code = code;
        this.nomMatiere = nomMatiere;
        this.coefficient = coefficient;
    }

    public Matiere() {
        //TODO Auto-generated constructor stub
    }

    // Getters et setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "code='" + code + '\'' +
                ", nomMatiere='" + nomMatiere + '\'' +
                ", coefficient=" + coefficient +
                '}';
    }
}