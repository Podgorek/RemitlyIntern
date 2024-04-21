package org.remitlyIntern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Deserialized {
    @JsonProperty("PolicyName")
    public String policyName;
    @JsonProperty("PolicyDocument")
    public PolicyDocument policyDocument;


}