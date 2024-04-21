package org.remitlyIntern;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class Statement {
    @JsonProperty("Sid")
    public String sid;
    @JsonProperty("Effect")
    public String effect;
    @JsonProperty("Action")
    public ArrayList<String> action;
    @JsonProperty("Resource")
    public String resource;
}