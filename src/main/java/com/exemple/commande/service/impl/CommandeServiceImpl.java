/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.commande.service.impl;

import com.exemple.commande.bean.Commande;
import com.exemple.commande.bean.CommandeItem;
import com.exemple.commande.dao.CommandeDao;
import com.exemple.commande.service.CommandeItemService;
import com.exemple.commande.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ismail boulaanait
 */
@Service
public class CommandeServiceImpl implements CommandeService{
    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private CommandeItemService commandeItemService;
    
    @Override
    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    @Override
    public int payer(String reference, double montant) {
        Commande c = findByReference(reference);
        if (c == null) {
            return -1;
        }else if (c.getTotalPaiement()+montant>c.getTatal()) {
            return -2;
        }else{
            double nv = c.getTotalPaiement()+montant;
            c.setTotalPaiement(nv);
            commandeDao.save(c);
            return 1;
        }
    }

    public CommandeDao getCommandeDao() {
        return commandeDao;
    }

    public void setCommandeDao(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    @Override
    public int creer(Commande commande) {
        Commande c = findByReference(commande.getReference());
        if (c!=null) {
            return -1;
        }else{
            double total = 0;
             for (CommandeItem commandeItem : commande.getCommandeItems()) {
               total += commandeItem.getPrix()*commandeItem.getQuantite();
            }
            commande.setTotalPaiement(0);
            commande.setTatal(total);
            commandeDao.save(commande);
            commandeItemService.saveItem(commande);
            return 1;
        }
    }
    
   
}
