/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.model;

import org.drools.core.spi.KnowledgeHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Helper {
    static final long serialVersionUID = 1L;

	static Logger logger = LoggerFactory.getLogger(Helper.class);

	private static boolean debug = false;

	public static void log(final KnowledgeHelper drools, final String message){
//        if (Helper.debug) System.out.println("rule triggered: " + drools.getRule().getName() + " : " + message);
        if (Helper.debug) 
        	logger.info("rule triggered: " + drools.getRule().getName() + " : " + message);
    }

    public static void debug(final String message){
        if (Helper.debug) 
        	logger.info(message);
    }

    public static void log(final String message){
        if (Helper.debug) 
        	logger.info(message);
    }

    public static boolean isDebug() {
		return debug;
	}
	public static void setDebug(boolean debug) {
		Helper.debug = debug;
	}

}