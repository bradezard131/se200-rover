/** Antenna.java
 * 
 * Author: Bradley Ezard
 * Info: Controller for Mars Rover communication antenna.
 */

import java.util.*;
import java.io.*;

public class Antenna extends Comm {
    //-- Driver --//
    public static void main(String[] args) {
	Comm a = new Antenna();
	a.send("TEST");
	
	FuncList fl = new FuncList(1);
	fl.add(new DriveFunc(1.0));

	try {
	    String s = ((Antenna)a).serialize(fl);
	    System.out.println(s);
	    System.out.println(((Antenna)a).deserialize(s));
	} catch (Exception e) {
	    System.out.println("ERROR: " + e.getMessage());
	}
    }


    //-- Instance Fields --//
    private Messagebox<FuncList> inbox;

    //-- Constructor --//
    public Antenna() {}

    //-- Instance Methods --//
    @Override
    public void receive(String message) {
	try {
	    inbox.add((FuncList)deserialize(message));
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

    public void send(Serializable s) {
	try {
	    super.send(serialize(s));
	} catch (IOException ioe) {
	    this.send("Serialization Failed\n" +
		      "Error: " + ioe.getMessage() + "\n");
	}
    }

    //(De)Serialization
    private Object deserialize(String s) throws IOException, ClassNotFoundException {
	byte[] data = s.getBytes("ISO-8859-1");

	ObjectInputStream ois = new ObjectInputStream(
				      new ByteArrayInputStream(data));
	Object o = ois.readObject();
	ois.close();

	return o;
    }

    private String serialize(Serializable s) throws IOException, UnsupportedEncodingException {
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	ObjectOutputStream oos = new ObjectOutputStream(baos);
	
	oos.writeObject(s);
	oos.close();

	return new String(baos.toByteArray(), "ISO-8859-1");
    }
}
