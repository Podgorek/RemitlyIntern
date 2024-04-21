package org.remitlyIntern;

public class Main {
    public static void main(String[] args) {
        JsonReader jr = new JsonReader("incompleteJson.json");
        jr.readJsonFromFile();
        System.out.println(jr.resourceAsterisk());
    }
}