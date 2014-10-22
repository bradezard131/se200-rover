/** Antenna.java
 * 
 * Author: Bradley Ezard
 * Info: Controller for Mars Rover communication antenna.
 */

import java.util.*;
import java.io.*;

public class Antenna extends Comm {
    //-- Class Driver --//
    public static void main(String[] args) {
	Comm a = new Antenna(new Messagebox<FuncList>());
	a.send("TEST");
	
	FuncList fl = new FuncList(1);
	fl.add(new DriveFunc(1.0));

	try {
	    String s = Encoder.serialize(fl);
	    System.out.println(s);
	    System.out.println(Encoder.deserialize(s));
	} catch (Exception e) {
	    System.out.println("ERROR: " + e.getMessage());
	}
    }


    //-- Instance Fields --//
    private Messagebox<FuncList> inbox;

    //-- Constructor --//
    public Antenna(Messagebox<FuncList> inbox) {
	this.inbox = inbox;
    }

    //-- Instance Methods --//
    @Override
    public void receive(String message) {
	try {
	    inbox.add((FuncList)Encoder.deserialize(message));
	} catch (IOException ioe) {
	    this.send("Deserialization failed\n" +
		      "Error: " + ioe.getMessage() + "\n" +
		      "Message: " + message + "\n");
	} catch (ClassNotFoundException cnfe) {
	    this.send("Deserialization failed\n" +
		      "Error: " + cnfe.getMessage() + "\n" +
		      "Message: " + message + "\n");
	}
    }
}
