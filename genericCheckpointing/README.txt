CS542 Design Patterns
Spring 2016
ASSIGNMENT 5 README FILE

Due Date: MONDAY, May 8, 2016
Submission Date: MONDAY, May 9, 2016
Grace Period Used This Project: 1 Days
Grace Period Remaining: 0 Days
Author(s): RAHUL PAREEK
e-mail(s): rpareek1@binghamton.edu
B# Number : B00614340


PURPOSE:

  Project to implement mutliple pattern.
  In this assignment we need to apply design principles which we have learned as well as Reflection and proxy pattern concept of java.
  In purpose of this assignment is to design and build a generic Checkpointing system.
  As the output, we are displaying the "Total no of mismatch Objects”, and we are performing Serialization and deserialization of Objects.


PERCENT COMPLETE:

  "I believe I have completed 100% of this project."

PARTS THAT ARE NOT COMPLETE:

NONE

BUGS:

NONE
  
PACKAGES & FILES:

-Rahul_Pareek_assign5
 ---genericCheckpointing
  ----build.xml
  ----README.txt
  ----src
	---genericCheckpointing
		 ------driver
			 ---------Driver.java
		 ------server
			 ---------StoreRestoreI.java
			 ---------StoreI.java 
			 ---------RestoreI.java 
		 ------util
			 ---------MyAllTypesFirst.java 
			 ---------MyAllTypesSecond.java 
			 ---------ProxyCreator.java 
			 ---------SerializableObject.java
			 ---------FileProcessor.java
			 ---------DeserializableObject.java
		 ------xmlStoreRestore
			---------StoreRestoreHandler.java  (implements InvocationHandler)
			 ---------XMLSerialization.java
			 ---------XMLDeserialization.java
			 ---------SerStrategy.java
			 ---------DSerStrategy.java
			 ---------SerializeTypes.java
			 ---------DeserializeTypes.java

			 ------Any other Class/file you need
  
  
DATA STRUCTURE:
  
  Vector data structure is used for this assignment problem.
  Used for storing objects using proxy’s. Complexity depends on no. of items added so i.e O(1) / O(n).

SAMPLE OUTPUT:

/BUspring2016/DP/Assignment/Rahul_Pareek_assign5/genericCheckpointing/src> ant -buildfile build.xml run -Darg0=deser -Darg1=1 -Darg2=output.txt
Buildfile: /import/linux/home/rpareek1/BUspring2016/DP/Assignment/Rahul_Pareek_assign5/genericCheckpointing/src/build.xml

jar:

run:
     [java] Object1
     [java] Int: -555645299 
     [java] Long: -6288518058773146 
     [java] String: Rahul 
     [java] Boolean: false 
     [java] 
     [java] Object2
     [java] Double: 0.008674062598560628 
     [java] Float: 0.20399225 
     [java] short: -19782 
     [java] Char: M 
     [java] 

BUILD SUCCESSFUL

  
TO CLEAN:

ant -buildfile build.xml clean

TO COMPILE:

-Untar the tar file
-Go to directory /Rahul_Pareek_assign5/genericCheckpointing/
-Run the following command :
ant -buildfile build.xml all


TO RUN:
ant -buildfile build.xml run -Darg0=<mode> -Darg1=<No_of_Objects> -Darg2=<file_name>
  
BIBLIOGRAPHY:

www.stackoverflow.com
https://docs.oracle.com/javase/7/docs/api/


This serves as evidence that we are in no way intending Academic Dishonesty.
RAHUL PAREEK