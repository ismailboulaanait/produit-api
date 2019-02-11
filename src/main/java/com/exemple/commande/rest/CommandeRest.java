/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.commande.rest;

import com.exemple.commande.bean.Commande;

import com.exemple.commande.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ismail boulaanait
 */
@RestController()
@RequestMapping({"/commande/commandes"})
public class CommandeRest {
    
    @Autowired
    private CommandeService commandeService;
  
    
    
    @GetMapping("/reference/{reference}")
    public Commande findByReference(@PathVariable String reference) {
        return commandeService.findByReference(reference);
    }
    @PutMapping("/reference/{reference}/montant/{montant}")
    public int payer(@PathVariable String reference,@PathVariable long montant) {
        return commandeService.payer(reference, montant);
    }
    @PostMapping("/")
    public int creer(@RequestBody Commande c) {
        return commandeService.creer(c);
    }

    public int payer(String reference, double montant) {
        return commandeService.payer(reference, montant);
    }

    
    

    public void setCommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }
    
    
    
    
    
    
}
