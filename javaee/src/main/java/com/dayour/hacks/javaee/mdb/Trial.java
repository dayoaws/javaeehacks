package com.dayour.hacks.javaee.mdb;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
				@ActivationConfigProperty(propertyName = "destination", propertyValue="testjms")
		})

@Resources ({
	  @Resource(name="jms/__defaultConnectionFactory",  mappedName="jms/__defaultConnectionFactory",  
	            type=javax.jms.ConnectionFactory.class),
	 
	  @Resource(name="testjms", mappedName="testjms", type=javax.jms.Destination.class)
	})
public class Trial implements MessageListener {
	static final Logger logger = LoggerFactory.getLogger(Trial.class);
	

	public void onMessage(Message message) {
		logger.info("My MDB got message: " + message);
	}
	

}
