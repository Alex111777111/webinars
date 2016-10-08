package edu.javacourse.customer.api.business;

import edu.javacourse.customer.impl.business.ManagerBuilderImpl;

public class ManagerDirector
{
    public ManagerFacade createManagerFacade() {
        ManagerBuilder mb = new ManagerBuilderImpl();
        
        mb.createManagerFacade();
        mb.createCustomerManager();
        mb.createProductManager();
        mb.createCustomerOrderManager();
        
        return mb.getResult();
    }
}
