/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.gov.ipo.renewals.config;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.time.LocalDate;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonProcessingException;

public class LocalDateDeserializer extends StdDeserializer<LocalDate> {

    private static final long serialVersionUID = 1L;

    protected LocalDateDeserializer() {
        super(LocalDate.class);
    }


    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        return LocalDate.parse(jp.readValueAs(String.class));
    }

}