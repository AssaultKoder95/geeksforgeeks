import java.util.*;
import java.io.*;
public class SerializationSample implements Serializable { 
    // These two attributes will be serialized; 
    private String aString = "The value of that string"; 
    private int someInteger = 0; 
    // But this won't since it is marked as transient. 
    private transient int aa = 0;    

    // Main method to test. 
    public static void main( String [] args ) throws IOException { 
         // Create a sample object, that contains the default values. 
        SerializationSample instance = new SerializationSample(); 
        ObjectOutputStream oos = new ObjectOutputStream( 
        // It could have been a Socket to another machine, a database, an in memory array, etc. 
            new FileOutputStream(new File("o.txt"))); 
        oos.writeObject( instance ); 
        oos.close(); 
    } 
}