package com.acme.rules;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;

import com.redhat.example.drools.webservice.OrderBean;

public class DroolsHelperProcessor implements Processor {
	
	ProducerTemplate producer;

	public void setProducer(ProducerTemplate producer) {
		this.producer = producer;
	}
	
	public void process(Exchange inExchange) {
		OrderBean entryOrderBean = inExchange.getIn().getBody(OrderBean.class);
		inExchange.getOut().setBody(entryOrderBean);
	}

}
