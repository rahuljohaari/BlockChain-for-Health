package bch;

import java.util.ArrayList;
import java.util.*;
//import com.google.gson.GsonBuilder;

public class NoobChain {
	
	public static ArrayList<Block> blockchain = new ArrayList<Block>();
	public static int difficulty = 5;
    public static String str0,str1,str2,str3,str4,str5,str6,str7,str8,str9,str10,str11,str12,str13,str14,str15,str16;
    static int num1;
	public static void main(String[] args) {	
		long startTime = System.nanoTime();
		try
		{
		//add our blocks to the blockchain ArrayList:
		//Source of Dataset :- https://github.com/junioralive/Indian-Medicine-Dataset?utmsource
		str0=args[0];//record id: Unique record id.
		str1=args[1];//id: Unique identifier for each medicine. 
		str2=args[2];//name: Name of the medicine.
		str3=args[3];//price(₹): Price of the medicine in Indian Rupees.
		str4=args[4];//Is_discontinued: Indicates whether the medicine is discontinued (FALSE = available)
		str5=args[5];//manufacturer_name: Name of the manufacturer.
		str6=args[6];//type: Type of medicine (e.g., allopathy).
		str7=args[7];//pack_size_label: Information about the size of the packaging.
		str8=args[8];//short_composition1: Primary composition of the medicine.
		str9=args[9];//short_composition2: Secondary composition of the medicine (if applicable).
									

		System.out.println("Record Id is " + str0);
		System.out.println("Medicine Id is " + str1);
		System.out.println("Medicine Name is " + str2);
		System.out.println("Medicine price is " + str3);
		System.out.println("Is_discontinued " + str4);
		System.out.println("manufacturer_name is " + str5);
		System.out.println("type is " + str6);
		System.out.println("pack_size_label is " + str7);
		System.out.println("short_composition1 " + str8);
		System.out.println("short_composition2 " + str9);
				
		str12=str0+str1+str2+str3+str4+str5+str6+str7+str8+str9;
		num1=str12.length();
		System.out.println("The Length of input string is"+ num1);
		System.out.println("The total concatenated medical record of patient is "+ num1);
		str13=str12.substring(0, 25);
		str14=str12.substring(26, 51);
		str15=str12.substring(52, 78);
		str16=str12.substring(79, 105);
		System.out.println("Contents for the first block" + str13);
		System.out.println("Contents for the second block" + str14);
		System.out.println("Contents for the third block" + str15);
		System.out.println("Contents for the fourth block" + str16);
	
		System.out.println("Chaining, first block of medical record  ..... ");
		addBlock(new Block(str13, "0"));
		//For the first block,the previous hash block value is 0.
		System.out.println("Chaining, second block of medical record.... ");
		addBlock(new Block(str14,blockchain.get(blockchain.size()-1).hash));
		
		System.out.println("Chaining, third block of medical record.... ");
		addBlock(new Block(str15,blockchain.get(blockchain.size()-1).hash));	
		
		System.out.println("Chaining, fourth block of medical record.... ");
		addBlock(new Block(str16,blockchain.get(blockchain.size()-1).hash));	
		
		//System.out.println("Chaining, fifth block of Credit Card.... ");
		//addBlock(new Block(str9,blockchain.get(blockchain.size()-1).hash));	
		long endTime   = System.nanoTime();
		long totalTime = endTime - startTime;
		System.out.println("Total time in nanosecond consumed during programm execution is "+ totalTime);
		
		}catch(Exception e)
	{
		System.out.print(e);
	}
	}
	
	
	public static void addBlock(Block newBlock) {
			blockchain.add(newBlock);
	          System.out.println("Printing the contents of Block(Arraylist)\n ");
		      for (int i = 0; i < blockchain.size();i++) 
		      { 		      
		          System.out.println(blockchain.get(i)); 		
		      } 
	}


}


