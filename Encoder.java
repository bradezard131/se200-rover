/** Encoder.java
 *
 * Author: Bradley Ezard
 * Info:
 */

import java.util.*;
import java.io.*;

public class Encoder {
    public static Object deserialize(String s) throws IOException, ClassNotFoundException {
	byte[] data = s.getBytes("ISO-8859-1");

	ObjectInputStream ois = new ObjectInputStream(
				      new ByteArrayInputStream(data));
	Object o = ois.readObject();
	ois.close();

	return o;
    }

    public static String serialize(Serializable s) throws IOException, UnsupportedEncodingException {
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	ObjectOutputStream oos = new ObjectOutputStream(baos);
	
	oos.writeObject(s);
	oos.close();

	return new String(baos.toByteArray(), "ISO-8859-1");
    }
}
