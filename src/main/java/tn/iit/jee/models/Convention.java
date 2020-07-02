package tn.iit.jee.models;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

@Entity

public class Convention {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NonNull
    private long type;
    @NonNull
    private long participant1;
    @NonNull
    private long participant2;
    private long participant3;
    private long participant4;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NonNull
    private Date dateEdition;
    @DateTimeFormat(pattern="yyyy-MM-dd")

    private Date dateSignature1;
    @DateTimeFormat(pattern="yyyy-MM-dd")

    private Date dateSignature2;
    @DateTimeFormat(pattern="yyyy-MM-dd")

    private Date dateSignature3;
    @DateTimeFormat(pattern="yyyy-MM-dd")

    private Date dateSignature4;
    @NonNull
    private String objet;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @NonNull
    @Column(name = "date_entree_vigueur")
    private Date dateEntreevigueur;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date dateExpiration;

    public Convention() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    public long getParticipant1() {
        return participant1;
    }

    public void setParticipant1(long participant1) {
        this.participant1 = participant1;
    }

    public long getParticipant2() {
        return participant2;
    }

    public void setParticipant2(long participant2) {
        this.participant2 = participant2;
    }

    public long getParticipant3() {
        return participant3;
    }

    public void setParticipant3(long participant3) {
        this.participant3 = participant3;
    }

    public long getParticipant4() {
        return participant4;
    }

    public void setParticipant4(long participant4) {
        this.participant4 = participant4;
    }

    public Date getDateEdition() {
        return dateEdition;
    }

    public void setDateEdition(Date dateEdition) {
        this.dateEdition = dateEdition;
    }

    public Date getDateSignature1() {
        return dateSignature1;
    }

    public void setDateSignature1(Date dateSignature1) {
        this.dateSignature1 = dateSignature1;
    }

    public Date getDateSignature2() {
        return dateSignature2;
    }

    public void setDateSignature2(Date dateSignature2) {
        this.dateSignature2 = dateSignature2;
    }

    public Date getDateSignature3() {
        return dateSignature3;
    }

    public void setDateSignature3(Date dateSignature3) {
        this.dateSignature3 = dateSignature3;
    }

    public Date getDateSignature4() {
        return dateSignature4;
    }

    public void setDateSignature4(Date dateSignature4) {
        this.dateSignature4 = dateSignature4;
    }

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public Date getDateEntreevigueur() {
        return dateEntreevigueur;
    }

    public void setDateEntreevigueur(Date dateEntrevigueur) {
        this.dateEntreevigueur = dateEntrevigueur;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }
}
