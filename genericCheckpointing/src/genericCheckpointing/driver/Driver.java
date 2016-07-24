/**
 * This is the main Driver class file. Execution of the program start from this class main method.
 * In the main method error checking for arguments taken from input are handled. This class also checks for valid input file i.e. the file is there or not.
 * 
 * @author  Rahul Pareek
 * @version 1.0
 * @since   04-26-2016
 *   
 */
package genericCheckpointing.driver;

import java.io.File;
import java.util.Random;
import java.util.Vector;

import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.StoreRestoreI;
import genericCheckpointing.util.FileProcessor;
import genericCheckpointing.util.MyAllTypesFirst;
import genericCheckpointing.util.MyAllTypesSecond;
import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.util.SerializableObject;
import genericCheckpointing.xmlStoreRestore.StoreRestoreHandler;

public class Driver {

	public static void main(String[] args) {

		if (args.length > 0 && args[0] != null) {
            System.err.println("Please give arguments.");
            System.err.println("Arguments are: <mode> <Num of Objects of one kind> <output file name>");
		}
		if (args.length > 3) {
			System.err.println("Please don't give more than 3 arguments.");
			System.err.println("Arguments are: <mode> <Num of Objects of one kind> <output file name>");
			System.exit(0);
		}
        if (args.length == 2) {
			System.err.println("Need 1 more arguments");
			System.err.println("Arguments are: <mode> <Num of Objects of one kind> <output file name>");
			System.exit(0);
		}
        if (args.length == 1) {
			System.err.println("Need 2 more arguments");
			System.err.println("Arguments are: <mode> <Num of Objects of one kind> <output file name>");
			System.exit(0);
		}
		
			
			String mode = null;
			int numObj = 0;
			File file_Output = null;
			// try start
			mode = args[0]; // mode i.e. serdeser or deser
			numObj = Integer.parseInt(args[1]); // no of objects of
												// 1 kind
			file_Output = new File(args[2]); // output file
			Random rgen = new Random();

			// start
			Vector<SerializableObject> SerV = new Vector();
			Vector<SerializableObject> DesV = new Vector();

			ProxyCreator pc = new ProxyCreator();
			FileProcessor fp1 = new FileProcessor(file_Output, file_Output, mode);
			StoreRestoreHandler srhand = new StoreRestoreHandler(fp1);

			// create a proxy
			StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(new Class[] { StoreI.class, RestoreI.class },
					srhand);

			MyAllTypesFirst myFirst;
			MyAllTypesSecond mySecond;
			SerializableObject myRecordRet;

			if (mode.equals("serdeser")) {
				for (int i = 0; i < numObj; i++) {

					myFirst = new MyAllTypesFirst(rgen.nextInt(), rgen.nextLong(), "Rahul", rgen.nextBoolean());
					mySecond = new MyAllTypesSecond(rgen.nextDouble(), rgen.nextFloat(), (short) rgen.nextInt(), 'M');

					SerV.addElement(myFirst);
					SerV.addElement(mySecond);

					((StoreI) cpointRef).writeObj(myFirst, "XML");
					((StoreI) cpointRef).writeObj(mySecond, "XML");

				}

			}

			if (mode.equals("serdeser") || mode.equals("deser")) {

				for (int j = 0; j < 2 * numObj; j++) {
					// System.out.println("Times: " + j);
					myRecordRet = ((RestoreI) cpointRef).readObj("XML");
					if (SerV != null) {
						DesV.addElement(myRecordRet);
					}

					// System.out.println("Inserted time: " + j);
				}

			}

			if (mode.equals("deser")) {

				int objectNo = 1;
				for (SerializableObject deserializableObject : DesV) {
					 System.out.println("Object" + (objectNo++) + "\n" +
					 deserializableObject.toString());
				}

			}

			if (mode.equals("serdeser")) {
				int compareNo = 0;
				for (int i = 0; i < DesV.size(); i++) {
					Object obj1 = DesV.get(i);
					Object obj2 = SerV.get(i);
					if (obj1.equals(obj2)) {
						compareNo++;
//						System.out.println("Matched Object is\n Deserialied Object " + DesV.get(i).toString()
//								+ "\n Serialized Object" + SerV.get(i).toString());

					} else {
						System.out.println("Mismatched Object is\n Deserialied Object " + DesV.get(i).toString()
								+ "\n Serialized Object" + SerV.get(i).toString());
					}
				}
				System.out.println("No of mismatched Object is:" + (DesV.size() - compareNo));

			}
		

	}

}
