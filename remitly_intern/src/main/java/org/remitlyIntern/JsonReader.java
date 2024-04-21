package org.remitlyIntern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader {
    String url_or_json;
    Deserialized information;

    public JsonReader(String info){this.url_or_json = info;}

    public void readJsonFromFile(){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = new String(Files.readAllBytes(Paths.get(url_or_json)));
            information = mapper.readValue(json, Deserialized.class);
        }
        catch (JsonProcessingException e) {
            System.out.println("There was a problem with converting Json into object");
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            System.out.println("There was a problem with reading a file check whether it exists ");
            throw new RuntimeException(e);
        }
    }

    public void readJsonFromString(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            information = mapper.readValue(url_or_json, Deserialized.class);
        }
        catch (IOException e){
            System.out.println("Provided string is not in a good format");
            throw new RuntimeException(e);
        }
    }

    public boolean resourceAsterisk(){
        try
        {
            for (Statement statement : information.policyDocument.statement) {
                if (statement.resource.equals("*")) return false;
            }
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
            throw e;
        }
        return true;
    }
}