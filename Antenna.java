/** Antenna.java
 * 
 * Author: Bradley Ezard
 * Info: Controller for Mars Rover communication antenna.
 */

import java.util.*;
import java.io.*;

public class Antenna extends Comm {
    //-- Constructor --//
    public Antenna() {}

    //-- Instance Methods --//
    @Override
    public void receive(String message) {
	deserialize(message);

	//Store
    }

    @Override
    public void send(Serializable s) {
	this.send(serialize(s));
    }

    //(De)Serialization
    private Object deserialize(String s) {
	byte[] data = s.toByteArray();

	ObjectInputStream ois = new ObjectInputStream(
				      new ByteArrayInputStream(data));
	Object o = ois.readObject();
	ois.close();

	return o;
    }

    private String serialize(Serializable s) {
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	ObjectOutputStream oos = new ObjectOutputStream(baos);
	
	oos.writeObject(s);
	oos.close();

	return new String(baos.toByteArray(), "UTF-8");
    }
}
