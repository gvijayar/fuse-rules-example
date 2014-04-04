package com.acme.rules;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import com.redhat.example.drools.webservice.OrderBean;
import com.redhat.example.drools.webservice.OrderOutput;

public class RulesCamelProcessor implements Processor {
	
	ProducerTemplate producer;

	public void setProducer(ProducerTemplate producer) {
		this.producer = producer;
	}
	
	public void process(Exchange inExchange) {
		String incomingmessage = inExchange.getIn().getBody().toString();
		System.out.println("Guna da man ******** " + incomingmessage);

		KnowledgeBase knowledgeBase = createKnowledgeBase();
		StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
		
		session.insert(inExchange.getIn().getBody(OrderBean.class));	
		session.fireAllRules();
			
		OrderOutput output = new OrderOutput();
		output.setEffectiveDate("1-17-2013");
		output.setResult("Success");

		inExchange.getOut().setBody(output);
	}

	/**
	 * Create new knowledge base
	 */
	private static KnowledgeBase createKnowledgeBase() {
		KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		File drl = new File("/home/gvijayar/workspace/camel-cxf-code-first/src/main/resources/BasicRules.drl");
		builder.add(ResourceFactory.newFileResource(drl), ResourceType.DRL);
		if (builder.hasErrors()) {
			throw new RuntimeException(builder.getErrors().toString());
		}

		KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
		knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
		return knowledgeBase;
	}

}
