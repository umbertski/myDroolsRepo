/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.config;
import java.time.LocalDate;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.core.JsonGenerator;
import java.time.format.DateTimeFormatter;


public class LocalDateUXSerializer extends StdSerializer<LocalDate> {

    private static final long serialVersionUID = 1L;

    public LocalDateUXSerializer(){
        super(LocalDate.class);
    }

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider sp) throws IOException, JsonProcessingException {
        gen.writeString(value.format(DateTimeFormatter.ofPattern("d MMMM yyyy")));
    }
}