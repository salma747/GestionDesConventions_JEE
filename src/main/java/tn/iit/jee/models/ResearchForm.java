package tn.iit.jee.models;

public class ResearchForm {
    private long type;
    private String date_expiration;

    public ResearchForm() {
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public String getDate_expiration() {
        return date_expiration;
    }

    public void setDate_expiration(String date_expiration) {
        this.date_expiration = date_expiration;
    }
}
