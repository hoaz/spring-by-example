package com.spring.by.example.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;


@Component("loggerListener")
public class LoggerListener extends MessageListenerAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggerListener.class);

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				logger.info(((TextMessage) message).getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	

}
