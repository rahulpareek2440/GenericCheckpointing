/**
 * Code for MyAllTypesFirst is here.
 * It is extending Serializable Object
 * 
 *  
 */
package genericCheckpointing.util;


public class MyAllTypesFirst extends SerializableObject{
	private int myInt;
	private long myLong;
	private String myString;
	private boolean myBool;
	public MyAllTypesFirst() {
		// TODO Auto-generated constructor stub
	}
	public MyAllTypesFirst(int i, long j, String string, boolean b) {
		myInt=i;
		myLong=j;
		myString=string;
		myBool=b;
	}

	/**
	 * get and set methods for myInt
	 * @return
	 */
	public int getmyInt() {
		return myInt;
	}

	public void setmyInt(int val) {
		myInt = val;
	}

	/**
	 * get and set methods for myLong
	 * @return
	 */
	public long getmyLong() {
		return myLong;
	}

	public void setmyLong(long val) {
		myLong = val;
	}

	/**
	 * get and set methods for myString
	 * @return
	 */
	public String getmyString() {
		return myString;
	}

	public void setmyString(String val) {
		myString = val;
	}

	/**
	 * get and set methods for myBoolean
	 * @return
	 */
	public boolean getmyBool() {
		return myBool;
	}

	public void setmyBool(boolean val) {
		myBool = val;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		if(obj instanceof MyAllTypesFirst){

			MyAllTypesFirst a = (MyAllTypesFirst)obj;
			if (myInt == a.getmyInt() &&  
					myLong == a.getmyLong() && 
					myString.equals(a.getmyString()) && 
					myBool == a.getmyBool()) {
				return true;
			}
			return false;
		}else{
			return false;
		}
	}

	@Override 
	public String toString(){
		String tostr;
		tostr = "Int: " + myInt +" \n" + "Long: " + myLong + " \n" + "String: " + myString + " \n" + "Boolean: " + myBool + " \n";
		return tostr;
	}


	@Override
	public int hashCode(){

		String hash=null;
		hash = String.valueOf(myInt) + String.valueOf(myLong) +  myString + String.valueOf(myBool);

		int a=hash.hashCode();

		return a;
	}


}



