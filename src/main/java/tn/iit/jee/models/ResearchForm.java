package tn.iit.jee.models;

public class ResearchForm {
    private long type;
    private String objet;

    public ResearchForm() {
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    @Override
    public String toString() {
        return "ResearchForm{" +
                "type=" + type +
                ", objet='" + objet + '\'' +
                '}';
    }
}
