import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Communication
{

	public static void main(String[] args) 
	{
		Scanner in  = new Scanner(System.in);
		int runs = in.nextInt();
		in.nextLine();
		
		for (int i = 0; i < runs; i++) {
			String key = in.nextLine();
			int lines = in.nextInt();
			in.nextLine();
			String text = in.nextLine();
			for (int j = 0; j < lines; j++) {
				System.out.println(cipher(text, key, false));
				if (in.hasNextLine())
					text = in.nextLine();
			}
			System.out.println();
		}
	}
	

	public static String cipher(String text, String key_input, boolean encrypt) {
		String ret = "";
	                
	    String alpha = "abcdefghijklmnopqrstuvwxyz";
	    String alpha_upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	             
	    int key_length = key_input.length();
	    for (int i = 0; i < key_length - 1; i ++) {
	    	key_input += key_input.substring(i + 1, key_length) + key_input.substring(0, i + 1);
	    }
	    
	    ArrayList<Integer> key = new ArrayList<Integer>();
	                
	    for (int i = 0; i < key_input.length(); i++) {
	    	String c = key_input.charAt(i) + "";
	        c = c.toLowerCase();
            if (alpha.contains(c)) {
            	key.add((alpha.indexOf(c)));
	        }
	                
	        try {
	         	key.add(Integer.parseInt(c));
	        } catch (Exception e) {
						
	        }
	                
	        if (!encrypt) {
	        	key.set(key.size() - 1, key.get(key.size() - 1) * -1);
	        } 
	    }
	                
	    int skips = 0;
	                
	    for (int i = 0; i < text.length(); i++) {
	     	String c = text.charAt(i) + "";
	                    
	     	if (!c.matches("[a-zA-Z]")) {
	     		skips++;
	            ret += c;
	            continue;
            }
	                    
	        int c_index = -1;
	                    
	        if (alpha.contains(c)) {
	        	c_index = alpha.indexOf(c);
	            ret += alpha.charAt(shift(c_index, key.get((i - skips) % key.size())));
	        } else if (alpha_upper.contains(c)) {
	        	c_index = alpha_upper.indexOf(c);
	            ret += alpha_upper.charAt(shift(c_index, key.get((i - skips) % key.size())));
	        }
		}
	                
	    return ret;
	}
	            
	public static int shift(int a, int b) {
		a += b;
	    if (a >= 26) {
	     	a -= 26;
	    } else if (a < 0) {	
	    	a += 26;
	    }
	    return a;
	}
}