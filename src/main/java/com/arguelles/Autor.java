package com.arguelles;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Autor")
public class Autor implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "autorId", unique = true, nullable = false)
    private long autorId;

    @Column(name = "nom")
    private String nom;

    @OneToMany
    @JoinColumn(name = "autorId")
    private Set<Llibre> llibres;

    public Autor() {
    }

    public Autor(String nom) {
        this.nom = nom;
    }

    public long getAutorId() {
        return this.autorId;
    }

    public void setAutorId(long autorId) {
        this.autorId = autorId;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom= nom;
    }

    public Set<Llibre> getLlibres() {
        return this.llibres;
    }

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return "{" +
            " autorId='" + getAutorId() + "'" +
            ", nom='" + getNom() + "'" +
            ", llibres='" + getLlibres() + "'" +
            "}";
    }
}
