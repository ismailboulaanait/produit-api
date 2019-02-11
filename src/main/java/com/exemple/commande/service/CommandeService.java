/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.commande.service;

import com.exemple.commande.bean.Commande;

/**
 *
 * @author ismail boulaanait
 */
public interface CommandeService {
    
    public Commande findByReference(String reference);
    public int payer(String reference,double montant);
    public int creer(Commande c);
}
