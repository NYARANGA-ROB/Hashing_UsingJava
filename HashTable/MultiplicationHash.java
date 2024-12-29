package hashTable;

import java.util.*;
import java.io.*;

public class MultiplicationHash {
	 public static void main(String[] args) {
		  // prompt user for input
		 Long runtime=(long) 0.00;
		 long start = System.currentTimeMillis();
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter modulo divisor: ");
	        int divisor = scanner.nextInt();
	        System.out.print("Enter bucket size: ");
	        int bucketSize = scanner.nextInt();
	        System.out.print("Enter multiplier (must be between 0 and 1): ");
	        double multiplier = scanner.nextDouble();

	        // create hash table as ArrayList of ArrayLists
	        ArrayList<ArrayList<Integer>> hashTable = new ArrayList<>();
	        for (int i = 0; i < divisor; i++) {
	            hashTable.add(new ArrayList<Integer>());
	        }

	        // read data from file and insert into hash table using multiplication hash function
	        int totalCollisions = 0;
	        int primaryCollisions = 0;
	        int secondaryCollisions = 0;
	        int keysNotInserted = 0;
	        try {
	            Scanner fileScanner = new Scanner(new File("LabHashingInput.txt"));
	          //  long start = System.currentTimeMillis();
	            while (fileScanner.hasNext()) {
	                int value = fileScanner.nextInt();
	                int index = (int) Math.floor(divisor * ((value * multiplier) % 1));
	                int bucket = index / bucketSize;
	                if (hashTable.get(index).size() == bucketSize) {
	                    // bucket is full, use linear probing to find next available bucket
	                    int probeCount = 0;
	                    while (hashTable.get(index).size() == bucketSize) {
	                        index = (index + 1) % divisor;
	                        probeCount++;
	                    }
	                    if (probeCount == 1) {
	                        primaryCollisions++;
	                    } else if (probeCount > 1) {
	                        secondaryCollisions++;
	                    }
	                }
	                if (hashTable.get(index).size() < bucketSize) {
	                    hashTable.get(index).add(value);
	                } else {
	                    keysNotInserted++;
	                }
	            }
	            long end = System.currentTimeMillis();
	            runtime= end-start;
	            System.out.println("Runtime: " + (end - start) + " milliseconds");
	        } catch (FileNotFoundException e) {
	            System.out.println("Input file not found");
	            System.exit(0);
	        }

	        // write hash table to output file
	        try {
	            PrintWriter writer = new PrintWriter("LabHashingOutput.txt");
	            writer.println("Method: Multiplication");
	           
	            writer.println("Runtime: " + runtime + " milliseconds ");
	            writer.println("================================");
	            writer.println("Hash Table Size: " + divisor);
	            writer.println("Bucket Size: " + bucketSize);
	            writer.println("Multiplier: " + multiplier);
	            writer.println("Input Key Size: " + (divisor * bucketSize - keysNotInserted));
	            double loadFactor = (double) (divisor * bucketSize - keysNotInserted) / (double) (divisor * bucketSize);
	            writer.println("Load Factor: " + loadFactor);
	            writer.println("Primary Collisions: " + primaryCollisions);
	            writer.println("Secondary Collisions: " + secondaryCollisions);
	            writer.println("Total Collisions: " + (primaryCollisions + secondaryCollisions));
	            writer.println("Keys Not Inserted: " + keysNotInserted);
	            writer.println("\n Resulting Hash table \n");
	            if (bucketSize == 1) {
	                for (int i = 0; i < divisor; i++) {
	                    for (int j = 0; j < hashTable.get(i).size(); j++) {
	                        writer.print("X");
	                    }
	                    for (int j = hashTable.get(i).size(); j < bucketSize; j++) {
	                        writer.print("-");
	                    }
	                    writer.print(" ");
	                    if ((i + 1) % 5 == 0) {
	                        writer.println();
	                    }
	                }
	            } else if (bucketSize == 3) {
	                for (int i = 0; i < divisor; i++) {
	                    int bucketNumber = i / bucketSize + 1;
	                    writer.print(bucketNumber + " ");
	                    if (hashTable.get(i).size() > 0) {
	                        for (int j = 0; j < hashTable.get(i).size(); j++) {
	                            writer.print(hashTable.get(i).get(j) + " ");
	                        }
	                    } else {
	                        writer.print("---");
	                    }
	                    writer.print(" ");
	                    if (i % bucketSize == bucketSize - 1) {
	                        writer.println();
	                    }
	                }
	            }
	            writer.close();
	            System.out.println("Output written to file: LabHashingOutput.txt");
	        } catch (FileNotFoundException e) {
	            System.out.println("Output file not found");
	        }
	    }

}
