/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.config;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import java.text.DecimalFormat;


public class LocalDoubleSerializer extends StdSerializer<Double> {

    private static final long serialVersionUID = 1L;

    public LocalDoubleSerializer(){
        super(Double.class);
    }

    @Override
    public void serialize(Double value, JsonGenerator gen, SerializerProvider sp) throws IOException, JsonProcessingException {
        if (null == value) {
            //write the word 'null' if there's no value available
            gen.writeNull();
        } else {
        	final String pattern = "0.00";
            //final String pattern = "###,###,##0.00";
            final DecimalFormat myFormatter = new DecimalFormat(pattern);
            final String output = myFormatter.format(value);
        	gen.writeNumber(output);
        }
    }
}