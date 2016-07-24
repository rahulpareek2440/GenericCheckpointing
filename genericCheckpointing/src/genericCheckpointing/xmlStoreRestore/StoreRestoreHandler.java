/**
 * This contains StoreRestoreHandler class
 * 
 * 
 * 
 *  
 */
package genericCheckpointing.xmlStoreRestore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.SerializableObject;

public class StoreRestoreHandler implements InvocationHandler {

	FileProcessor fp = null;

	public StoreRestoreHandler(FileProcessor fp1) {
		fp = fp1;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		args[0].getClass();
		String mName = method.getName();
		Object objD=null;

		if (mName.equals("writeObj")) {
			String stra =args[1].toString();
			if(stra.equals("XML")){
				serializeData( (SerializableObject)args[0], new XMLSerialization(fp));
			}


		} else if (mName.equals("readObj")) {

			String str = fp.readLineFromFile();
			String subType=null;
			Class<?> classNameD=null;
			Method methD = null;

			// get the xsi:type="generic .... " create the class instance use an empty constructor 
			//System.out.println(str);
			while(str!=null){
				//System.out.println("Line is: " + str);
				if(str.contains("<complexType")){

					subType=str.substring(23,str.length()-2);
					classNameD = Class.forName(subType);
					objD = classNameD.newInstance();
				}else if(str.equals("<DPSerialization>") || str.equals("</complexType>")){					

				}else if(str.contains("xsd:")){


					String prt=str.substring(1,str.length());
					String[] parts = prt.split(" ");
					String part1 = parts[0];
					String signature = "set"+ part1;
					String[] partVal = str.split("\">");
					String part2=partVal[1];
					String[] partVal1 = part2.split("</");
					String partVal2=partVal1[0];
					String[] partDtype = partVal[0].split("xsd:");

					//System.out.println(partDtype[1]);
					//System.out.println(part1);
					Object[] params;
					switch (partDtype[1]) {
					case "int":
						params = new Object[1];
						params[0] = new Integer(partVal2);
						methD = classNameD.getMethod(signature, int.class);
						methD.invoke(objD,params);
						break;
					case "long":
						params = new Object[1];
						params[0] = new Long(partVal2);
						methD = classNameD.getMethod(signature, long.class);
						methD.invoke(objD,params);
						break;
					case "string":
						params = new Object[1];
						params[0] = new String(partVal2);
						methD = classNameD.getMethod(signature, String.class);
						methD.invoke(objD,params);

						break;
					case "boolean":
						params = new Object[1];
						params[0] = new Boolean(partVal2);
						methD = classNameD.getMethod(signature, boolean.class);
						methD.invoke(objD,params);

						break;
					case "double":
						params = new Object[1];
						params[0] = new Double(partVal2);
						methD = classNameD.getMethod(signature, double.class);
						methD.invoke(objD,params);
						break;
					case "float":
						params = new Object[1];
						params[0] = new Float(partVal2);
						methD = classNameD.getMethod(signature, float.class);
						methD.invoke(objD,params);
						break;
					case "short":
						params = new Object[1];
						params[0] = new Short(partVal2);
						methD = classNameD.getMethod(signature, short.class);
						methD.invoke(objD,params);
						break;	
					case "char":
						params = new Object[1];
						params[0]=partVal2.charAt(0);
						methD = classNameD.getMethod(signature, char.class);
						methD.invoke(objD,params);
						break;

					default:
						break;
					}

				}
				else if(str.equals("</DPSerialization>")){
					return (SerializableObject)objD;
				}
				str = fp.readLineFromFile();
			}
		}

		return null;
	}

	public void serializeData(SerializableObject sObject, SerStrategy sStrategy) {
		sStrategy.processInput(sObject);
	}

}


