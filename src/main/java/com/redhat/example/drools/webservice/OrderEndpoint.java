package com.redhat.example.drools.webservice;

import javax.jws.WebService;

@WebService
public interface OrderEndpoint {
	
    public OrderOutput order(OrderBean orderBean);
}
