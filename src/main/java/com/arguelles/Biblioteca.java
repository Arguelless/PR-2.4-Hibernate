package com.arguelles;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Biblioteca", uniqueConstraints = { @UniqueConstraint(columnNames = "bibliotecaId") })
public class Biblioteca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bibliotecaId", unique = true, nullable = false)
    private long bibliotecaId;

    @Column(name = "nom")
    private String nom;

    @Column(name = "ciutat")
    private String ciutat;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.EAGER)
    @JoinTable(name = "Llibre_Biblioteca", joinColumns = {
            @JoinColumn(referencedColumnName = "bibliotecaId") }, inverseJoinColumns = {
                    @JoinColumn(referencedColumnName = "llibreId") })
    private Set<Llibre> llibres;

    public Biblioteca() {
    }

    public Biblioteca(String nom, String ciutat) {
        this.nom = nom;
        this.ciutat = ciutat;
    }

    public long getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(long bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCiutat() {
        return ciutat;
    }

    public void setCiutat(String ciutat) {
        this.ciutat = ciutat;
    }

    public Set<Llibre> getLlibres() {
        return llibres;
    }

    public void setLlibres(Set<Llibre> llibres) {
        this.llibres = llibres;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "bibliotecaId=" + bibliotecaId +
                ", nom='" + nom + '\'' +
                ", ciutat='" + ciutat + '\'' +
                ", llibres='" + llibres + '\'' +
                '}';
    }
}
