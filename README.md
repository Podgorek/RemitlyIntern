# ReadMe
Code for the Remitly internship.

## Usages
Program was created for reading json files of AWS::IAM::Role Policy type and checking if in resource field there is single asterisk.
## How to install

#### Running by cloning repository
To use program clone it to your environment and install two packages:  
1) fasterxml.jackson.core  
2) fasterxml.jackson.databind  

When u installed them u can run the program and see how it works.

#### Running in your own project

Download remitlyIntern.jar and add it to your dependencies. After that
import package as follow:  
```java
import org.remitlyIntern.*;
```

## How to use in program

Firstly in constructor you should pass the name of the existing 
file in your project or the entire Json as string.

```java
JsonReader jr = new JsonReader("JsonFile.json");
jr.readJsonFromFile();
```

or

```java
JsonReader jr = new JsonReader("entireJsonfile");
jr.readJsonFromString();
```

And in the end u just have to use the resourceAsterisk method
to check if it contains a single asterisk (if contains then returns false otherwise true).

```java
jr.resourceAsterisk();
