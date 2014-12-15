package com.hexor.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/** 
 */
public class CodeUtil {
	  private static String codeChars = "0123456789abcdefghkmnpqrstuvwxyzABCDEFGHKLMNPQRSTUVWXYZ";
	  private static String head="insert into accode (code,type) values('";
	  private static String bottom=",'1');";

      public static String getCode(){
          Random random = new Random();
          int charsLength=codeChars.length();
          StringBuilder validationCode = new StringBuilder();
          for (int j = 0; j < 6; j++) {
              char codeChar = codeChars.charAt(random.nextInt(charsLength));
              validationCode.append(codeChar);
          }
          return validationCode.toString();
      }


	  public static void main(String[] args) {
	      Random random = new Random(); 
	      int charsLength=codeChars.length();
	      Set<String> set = new HashSet<String>();
	      for(int i=0;i<1000;i++){
	  		StringBuilder validationCode = new StringBuilder();
			for (int j = 0; j < 6; j++) {
				char codeChar = codeChars.charAt(random.nextInt(charsLength));
				validationCode.append(codeChar);
			}
			set.add(validationCode.toString());
	      }
	      for (String str : set) {  
	          System.out.println(head+str+"'"+bottom);  
	    }  

	}
}
