/**
 * Code for MyAllTypesSecond is here.
 * It is extending Serializable Object
 * 
 *  
 */
package genericCheckpointing.util;


public class MyAllTypesSecond extends SerializableObject{
	private double myDoubleT;
	private float myFloatT;
	private short myShortT;
	private char myCharT;
	public MyAllTypesSecond() {
		// TODO Auto-generated constructor stub
	}
	public MyAllTypesSecond(double i, float d, short j, char chr) {
		myDoubleT=i;
		myFloatT=d;
		myShortT=j;
		myCharT=chr;
	}

	/**
	 * get and set methods for myDoubleT
	 * @return
	 */
	public double getmyDoubleT() {
		return myDoubleT;
	}

	public void setmyDoubleT(double val) {
		myDoubleT = val;
	}

	/**
	 * get and set methods for myFloatT
	 * @return
	 */
	public float getmyFloatT() {
		return myFloatT;
	}

	public void setmyFloatT(float val) {
		myFloatT = val;
	}

	/**
	 * get and set methods for myShortT
	 * @return
	 */
	public short getmyShortT() {
		return myShortT;
	}

	public void setmyShortT(short val) {
		myShortT = val;
	}

	/**
	 * get and set methods for myCharT
	 * @return
	 */
	public char getmyCharT() {
		return myCharT;
	}

	public void setmyCharT(char val) {
		myCharT = val;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		if(obj instanceof MyAllTypesSecond){
			MyAllTypesSecond b = (MyAllTypesSecond)obj;
			if (myDoubleT == b.getmyDoubleT() &&  
					myFloatT == b.getmyFloatT() && 
					myShortT == b.getmyShortT() && 
					myCharT == b.getmyCharT()) {
				return true;
			}
			return false;
		}

		return false;
	}

	@Override 
	public String toString(){
		String tostr;
		tostr = "Double: " + myDoubleT +" \n" + "Float: " + myFloatT + " \n" + "short: " + myShortT + " \n" + "Char: " + myCharT + " \n";
		return tostr;
	}


	@Override
	public int hashCode(){

		String hash=null;
		hash=String.valueOf(myDoubleT)+ String.valueOf(myFloatT) + String.valueOf(myShortT) + myCharT;

		int a=hash.hashCode();

		return a;
	}
}


