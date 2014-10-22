/** PhotoFunc.java
 *
 * Author: Bradley Ezard
 * Info:
 */

public class PhotoFunc extends Function {
    //-- Constructor --//
    public PhotoFunc() {}

    //-- Instance Methods --//
    public void call(Tools target) {
	target.getCamera().takePhoto();
    }
}