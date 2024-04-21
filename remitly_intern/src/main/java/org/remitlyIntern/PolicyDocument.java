package org.remitlyIntern;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;

public class PolicyDocument {
    @JsonProperty("Version")
    public String version;
    @JsonProperty("Statement")
    public ArrayList<Statement> statement;
}