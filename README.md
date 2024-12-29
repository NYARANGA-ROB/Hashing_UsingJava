# Hashing_UsingJava
Hashing Program
The program is a Java implementation of hash table using the multiplication and division hashing methods. This program reads data from a file, inserts the data into a hash table using the multiplication, and the writes the resulting hash table to an output file.
 # Usage
To run the program, first compile the MultiplicationHash.java file using the javac command:
- javac MultiplicationHash.java (for multiplication method) or
- javac DivisionHash.java
- Then run the program using the java command:
- java MultiplicationHash
or
java DivisionHash When prompted, enter the modulo divisor, bucket size, and multiplier values. The program will then read data from the LabHashingInput.text file, insert the data into hash table using the multiplication hash function, and write the resulting hash table to the LabHashingOutput.text file.
 # Input Data
-The input data for the program should be stored in a text file named LabHashingInput.txt. the data should consist of integers separated by whitespace with each integer on separate line

# Output Data
The output data for the program is written to a text file named LabHashingOutput.txt
The file contains the following information:
-  The method used to create the hash table
- The runtime of the program in milliseconds.
- The size of the hash table
 - The bucket size used in the hash function
- The number of keys inserted into the hash table
- The load factor of the hash table
- The number of primary collisions(when a key is inserted into a bucket that is already occupied)
- The number of secondary collisions (when linear probing is used to find an empty bucket).
- The total number of collisions
- The number of keys that could not be inserted into the hash table due to bucket overflow.
- The resulting hash table, displayed in the format that depends on the bucket size
 # Requirements
The program requires a Java Development Kit (JDK) installed on the machine. The code was tested on JDK version 16.0.1
