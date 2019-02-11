/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.commande.service;

import com.exemple.commande.bean.Commande;
import com.exemple.commande.bean.CommandeItem;
import java.util.List;

/**
 *
 * @author ismail boulaanait
 */
public interface CommandeItemService {

    public int saveItem(Commande commande);

    public List<CommandeItem> findByCommande(String reference);

}
