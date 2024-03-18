package com.quintus.ioc1;

public class DefaultServiceLocator {
    private static ClientServiceImp1 clientService = new ClientServiceImp1();

    public ClientServiceImp1 createClientServiceInstance() { return clientService;}
}
