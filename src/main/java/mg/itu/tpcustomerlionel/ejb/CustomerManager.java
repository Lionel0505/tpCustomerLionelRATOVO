/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.itu.tpcustomerlionel.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import mg.itu.tpcustomerlionel.entities.Customer;

/**
 *
 * @author Lionel
 */
@Stateless
public class CustomerManager {
    //Injection de l'EntityManager pour envoyer des requêtes en utilisant l'instance Customer
    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    //creation customer
    public void persist(Customer customer) {
    em.persist(customer);
    }
    
    //Liste customer
    public List<Customer> getAllCustomers() {  
      Query query = em.createNamedQuery("Customer.findAll");
       return query.getResultList();  
    }  
    
    //Modifier customer
    public Customer update(Customer customer) {
       return em.merge(customer); 
    }         
}
