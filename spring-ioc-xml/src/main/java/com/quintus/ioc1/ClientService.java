package com.quintus.ioc1;

public class ClientService {
    private static ClientService clientService = new ClientService();

    private ClientService(){}

    private static ClientService createInstance(){ return clientService;}
}
