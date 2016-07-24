package genericCheckpointing.xmlStoreRestore;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;



public class XMLSerialization implements SerStrategy {
	
	private FileProcessor fp;
	public XMLSerialization(FileProcessor fpIn) {
		fp = fpIn;
	}
 
	public void processInput(SerializableObject sObject) {

	  Class<? extends Object> className = sObject.getClass();
		
		String Signature = null;
		Method meth = null;
   // all the code to create the output file with XML snippets for
   // an object
	  	try {
			fp.writeToFile("<DPSerialization>\n");
			fp.writeToFile(" <complexType xsi:type=\"" + className.getCanonicalName().toString() + "\">\n");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		//System.out.println("<DPSerialization>");
		//System.out.println(" <complexType xsi:type=\"" + className.getCanonicalName().toString() + ">");
		Field[] field = className.getDeclaredFields();
		for (int i = 0; i < field.length; i++) {
			Class fieldClass = field[i].getType();
			String fieldName = field[i].getName();
			Signature = "get" + fieldName;
			try {
				meth = className.getMethod(Signature);
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			// ready getmyInt and
			// store in meth
			Object obj=null;
			try {
				obj = meth.invoke(sObject);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			} 
			// arg[0]->myAllTyeFirst
			// object myFirst.getmyInt()

			try{
				if (fieldClass.toString().equals("class java.lang.String")) {
					fp.writeToFile("  <" + fieldName + " xsi:type=\"xsd:" + "string" + "\">" + obj.toString() + "</"+ fieldName + ">\n");
					//System.out.println("  <" + fieldName + "xsi:type=\"xsd:" + "string" + ">" + obj.toString() + "</"+ fieldName + ">");
				} else {
					fp.writeToFile("  <" + fieldName + " xsi:type=\"xsd:" + fieldClass.toString() + "\">"
							+ obj.toString() + "</" + fieldName + ">\n");
					/*System.out.println("  <" + fieldName + " xsi:type=\"xsd:" + fieldClass.toString() + ">"
							+ obj.toString() + "</" + fieldName + ">");*/
				}
			}catch(IOException e){
				e.printStackTrace();
			}
			

		}

		try {
			fp.writeToFile(" </complexType>\n");
			fp.writeToFile("</DPSerialization>\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

  }

}