/** RoverCamera.java
 * 
 * Author: Bradley Ezard
 * Info:
 */

public class RoverCamera extends Camera {
    //-- Class Driver --//
    public static void main(String[] args) {
	Camera c = new RoverCamera(new Antenna(new Messagebox<FuncList>()));

	c.photoReady("TEST SUCCESS".toCharArray());

	c.takePhoto();
    }

    //-- Instance Fields --//
    private Comm comm;

    //-- Constructor --//
    public RoverCamera(Comm comm) {
	this.comm = comm;
    }

    //-- Instance Methods --//
    public void photoReady(char[] photoData) {
	comm.send(new String(photoData));
    }
}
