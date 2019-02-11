/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.commande.dao;

import com.exemple.commande.bean.Commande;
import com.exemple.commande.bean.CommandeItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ismail boulaanait
 */
@Repository
public interface CommandeItemDao extends JpaRepository<CommandeItem, Long>{
    
       public List<CommandeItem> findByCommandeReference(String reference);

}
