package org.remitlyIntern;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest {

    @org.junit.jupiter.api.Test
    void correctlyReadsJsonFromFile() {
        JsonReader jr = new JsonReader("test.json");
        jr.readJsonFromFile();
        assertEquals("root",jr.information.policyName);
        assertEquals("2012-10-17",jr.information.policyDocument.version);
        assertEquals("IamListAccess",jr.information.policyDocument.statement.get(0).sid);
        assertEquals("Allow",jr.information.policyDocument.statement.get(0).effect);
        assertEquals("iam:ListRoles",jr.information.policyDocument.statement.get(0).action.get(0));
        assertEquals("iam:ListUsers",jr.information.policyDocument.statement.get(0).action.get(1));
        assertEquals("c",jr.information.policyDocument.statement.get(0).resource);
    }

    @org.junit.jupiter.api.Test
    void correctlyReadsJsonFromText(){
        JsonReader jr = new JsonReader("{ \"PolicyName\": \"root\", \"PolicyDocument\": {\"Version\": \"2012-10-17\", \"Statement\": [{\"Sid\": \"IamListAccess\", \"Effect\": \"Allow\", \"Action\": [\"iam:ListRoles\", \"iam:ListUsers\"],\"Resource\": \"c\"}]}}");
        jr.readJsonFromString();
        assertEquals("root",jr.information.policyName);
        assertEquals("2012-10-17",jr.information.policyDocument.version);
        assertEquals("IamListAccess",jr.information.policyDocument.statement.get(0).sid);
        assertEquals("Allow",jr.information.policyDocument.statement.get(0).effect);
        assertEquals("iam:ListRoles",jr.information.policyDocument.statement.get(0).action.get(0));
        assertEquals("iam:ListUsers",jr.information.policyDocument.statement.get(0).action.get(1));
        assertEquals("c",jr.information.policyDocument.statement.get(0).resource);
    }

    @org.junit.jupiter.api.Test
    void returnsFalseIfExistsSingleAsterisk(){
        JsonReader jr = new JsonReader("jsonWithAsterisk.json");
        jr.readJsonFromFile();
        assertFalse(jr.resourceAsterisk());
    }

    @org.junit.jupiter.api.Test
    void returnsTrueIfAsteriskDoesntExistOrThereAreMultipleOfThem(){
        JsonReader jr = new JsonReader("jsonWithoutAsterisk.json");
        jr.readJsonFromFile();
        assertTrue(jr.resourceAsterisk());
    }

    @org.junit.jupiter.api.Test
    void throwsNullPointerExceptionWhileCheckingAsterisk(){
        JsonReader jr = new JsonReader("incompleteJson.json");
        jr.readJsonFromFile();
        assertThrows(NullPointerException.class, jr::resourceAsterisk);
    }

    @org.junit.jupiter.api.Test
    void throwsExceptionForNonexistentFile(){
        JsonReader jr = new JsonReader("123");
        assertThrows(RuntimeException.class, jr::readJsonFromFile);
    }

    @org.junit.jupiter.api.Test
    void throwsExceptionForWrongFormatOfJsonFile(){
        JsonReader jr = new JsonReader("invalidJson.json");
        assertThrows(RuntimeException.class, jr::readJsonFromFile);
    }

    @org.junit.jupiter.api.Test
    void throwsExceptionForWrongFormatOfJsonString(){
        JsonReader jr = new JsonReader("{\"sdff\",}");
        assertThrows(RuntimeException.class, jr::readJsonFromString);
    }
}