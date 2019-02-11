/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.commande.service.impl;

import com.exemple.commande.bean.Commande;
import com.exemple.commande.bean.CommandeItem;
import com.exemple.commande.dao.CommandeDao;
import com.exemple.commande.dao.CommandeItemDao;
import com.exemple.commande.service.CommandeItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author ismail boulaanait
 */
@Service
public class CommandeItemServiceImpl implements CommandeItemService {
    
    @Autowired
    CommandeItemDao commandeItemDao;
    
   
    
    

    @Override
    public int saveItem(Commande commande) {
        
        for (CommandeItem commandeItem : commande.getCommandeItems()) {
               
                commandeItem.setCommande(commande);
                commandeItemDao.save(commandeItem);  
            }
        
       return 1;
      
    }
    
    @Override
    public List<CommandeItem> findByCommande(String reference)
    {
        
        return commandeItemDao.findByCommandeReference(reference);
        
    }

   

}
