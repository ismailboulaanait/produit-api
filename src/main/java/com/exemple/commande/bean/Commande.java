/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.commande.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author ismail boulaanait
 */
@Entity
public class Commande implements Serializable {

   

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private double tatal;
    private double totalPaiement;
    
    @OneToMany(mappedBy = "commande")
    private List<CommandeItem> commandeItems;

    public String getReference() {
        return reference;
    }

    public Commande() {
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
   
    
    

    public double getTatal() {
        return tatal;
    }

    public void setTatal(double tatal) {
        this.tatal = tatal;
    }

    public double getTotalPaiement() {
        return totalPaiement;
    }

    public void setTotalPaiement(double totalPaiement) {
        this.totalPaiement = totalPaiement;
    }
    @JsonIgnore
    public List<CommandeItem> getCommandeItems() {
        return commandeItems;
    }
    @JsonSetter
    public void setCommandeItems(List<CommandeItem> commandeItems) {
        this.commandeItems = commandeItems;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.exemple.commande.bean.Commande[ id=" + id + " ]";
    }
    
}
