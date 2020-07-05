package tn.iit.jee.webDto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
public class UserRegistrationDto {
    @NotEmpty
    private String prenom;

    @NotEmpty
    private String nom;

    @NotEmpty
    private String mdp;


    @Email
    @NotEmpty
    private String email;

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
