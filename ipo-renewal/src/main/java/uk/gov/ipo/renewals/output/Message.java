/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.output;
public class Message {
    static final long serialVersionUID = 1L;

    
    String message;
    
    public Message(String message) {
                    this.message = message;
    }
    
    public String getMessage() {
                    return message;
    }

    public void setMessage(String message) {
                    this.message = message;
    }

}
