/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.commande.rest;

import com.exemple.commande.bean.Commande;
import com.exemple.commande.bean.CommandeItem;
import com.exemple.commande.service.CommandeItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ismail boulaanait
 */
@RestController()
@RequestMapping({"/commande/commandeitem"})
public class CommandeItemRest {
    @Autowired
    CommandeItemService commandeItemService;

    public CommandeItemService getCommandeItemService() {
        return commandeItemService;
    }

    public void setCommandeItemService(CommandeItemService commandeItemService) {
        this.commandeItemService = commandeItemService;
    }
    @PostMapping("/add")
    public int saveItem(@RequestBody Commande commande) {
        return commandeItemService.saveItem(commande);
    }
    @GetMapping("/getitems/{reference}")
    public List<CommandeItem> findByCommande(@PathVariable String reference) {
        return commandeItemService.findByCommande(reference);
    }
    
    
    
}
