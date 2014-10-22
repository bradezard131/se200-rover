/** RoverCamera.java
 * 
 * Author: Bradley Ezard
 * Info:
 */

public class RoverCamera extends Camera {
    //-- Class Driver --//
    public static void main(String[] args) {
	Camera c = new RoverCamera();

	c.photoReady("TEST SUCCESS".toCharArray());

	c.takePhoto();
	try { Thread.sleep(1100); } catch (Exception e) {}
       
	System.out.println(((RoverCamera)c).msgs.remove());
	System.out.println(((RoverCamera)c).msgs.remove());
    }

    //-- Instance Fields --//
    private Messagebox<String> msgs;

    //-- Constructor --//
    public RoverCamera() {
	msgs = new Messagebox<String>();
    }

    //-- Instance Methods --//
    public void photoReady(char[] photoData) {
	msgs.add(new String(photoData));
    }
}