package bch;

import java.security.MessageDigest;
import java.util.Date;

public class Block {
	
	public String hash;
	public String previousHash; 
	private String data; 
	private long timeStamp; //as number of milliseconds since 1/1/1970.
	private int num1;
	public String blockdata;
	//Block Constructor.  
	public Block(String data,String previousHash ) {
		System.out.println("Inside constructor");
		this.data = data;
		this.previousHash = previousHash;
		this.timeStamp = new Date().getTime();
		
		this.hash = calculateHash(); //Making sure we do this after we set the other values.
		blockdata=this.data + this.previousHash + this.timeStamp + this.hash;
		System.out.println("Contents of Block are "+blockdata);
	}
	
	//Calculate new hash based on blocks contents
	public String calculateHash() {
		System.out.println("Inside calculateHash");
		String calculatedhash = Block.applySha256( 
				previousHash +
				Long.toString(timeStamp) +
				Integer.toString(num1) + 
				data 
				);
		int num1=calculatedhash.length();
		System.out.println("Hashed Contents are "+calculatedhash);
		System.out.println("The length of Hashed value is"+num1+"bit");
		return calculatedhash;
	}
	
        public static String applySha256(String input){
		
		try {
			System.out.println("Inside SHA256 function");
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        
			//Applies sha256 to our input, 
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
		//	int num1=hash.length();
			System.out.println("Hashed SHA256 value is"+hash);
		//	System.out.println("The length of MD 5 Hashed value is"+num1+"bit");
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) 
				hexString.append('0');
				hexString.append(hex);
			}
			
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
		
}
