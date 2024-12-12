/**
 * Author : Katlego Semela
 * Date : 02/03/2020
**/
package com.sts.testautomation.utilities;

import java.util.Random;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataGenerator {
	
	public static String GenerateEmail() {

		char[] GmailString = null;
		StringBuilder Email = new StringBuilder();

		// Set up the alphabets and the special characters
		char[] Alphabets = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		char[] alphabets = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
				's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		char[] Special = { '!', '@', '#', '$', '%', '^', '&', '*', '1', '2', '3', '4', '5', '6', '7' };

		// Set the random number generator
		Random random1 = new Random();
		Random random2 = new Random();
		Random random3 = new Random();
		GmailString = new char[7];

		// Initialize the bound values
		int value1 = random1.nextInt(26);
		int value2 = 0;
		int value3 = random3.nextInt(8);

		// Assign the first value as a cap letter
		GmailString[0] = Alphabets[value1];

		// Assign the next four small letters
		for (int x = 1; x <= 4; x++) {
			value2 = random2.nextInt(26);
			GmailString[x] = alphabets[value2];
		}

		// Assign a special character to the email
		GmailString[5] = Special[value3];

		// Assign the last small letter
		GmailString[6] = alphabets[random2.nextInt(26)];

		// Use a string builder to append the array of characters to form a string
		Email.append(GmailString);

		// lastly append the @gmail.com that follows the google mail convention

		Email.append("@gmail.com");

		return Email.toString();
	}
	
	public static String generateID() 
	{
		String genderBit = "";
		String randomString="";
		int randomDOBYear = getRandomNumber(60,99);
		String randomDOBMonth ;
		String randomDOBDay;
		int randomDOBMonthSub = getRandomNumber(1,12);
		int randomDOBDaySub = getRandomNumber(1,28);
		
		if (randomDOBMonthSub<10)
		{
			randomDOBMonth = "0" + randomDOBMonthSub;
		}
		else
		{
			randomDOBMonth = ""+randomDOBMonthSub;
		}
		
		if (randomDOBDaySub<10)
		{
			randomDOBDay = "0" + randomDOBDaySub;
		}
		else
		{
			randomDOBDay = ""+randomDOBDaySub;
		}
		
		String DOBString = ""+randomDOBYear + randomDOBMonth + randomDOBDay;
		
		int gender = getRandomNumber(9);
		
		if(gender<=4)
		{
			genderBit = "0";
		}
		else 
		{
			genderBit = "5";
		}
		
	    int random = getRandomNumber(100);
	 
	    if (random < 10) 
	    {
	    	randomString = "00" + random;
	    }
	    else if (random>=10) 
	    {
	    	randomString = "0" + random;
	    }
	 
	    String total = DOBString + genderBit + randomString + "08";
	    total = total + generateLuhnDigit(total);
	    
	    return total;
	}

	public static String generateID(String gender, int dayOfBirth, int monthOfBirth, int yearOfBirth) 
	{
		String genderBit = "";
		String randomString="";
		int randomDOBYear = yearOfBirth;
		String randomDOBMonth ;
		String randomDOBDay;
		int randomDOBMonthSub = monthOfBirth;
		int randomDOBDaySub = dayOfBirth;
		
		if (randomDOBMonthSub<10)
		{
			randomDOBMonth = "0" + randomDOBMonthSub;
		}
		else
		{
			randomDOBMonth = ""+randomDOBMonthSub;
		}
		
		if (randomDOBDaySub<10)
		{
			randomDOBDay = "0" + randomDOBDaySub;
		}
		else
		{
			randomDOBDay = ""+randomDOBDaySub;
		}
		
		String DOBString = ""+randomDOBYear + randomDOBMonth + randomDOBDay;
		
		
		if (gender.equalsIgnoreCase("M")==true) 
		{
			genderBit = "5";
			
		}
		else if (gender.equalsIgnoreCase("F")==true) 
		{
			genderBit = "0";
		}
		
		
	    int random = getRandomNumber(100);
	 
	    if (random < 10) 
	    {
	    	randomString = "00" + random;
	    }
	    else if (random>=10) 
	    {
	    	randomString = "0" + random;
	    }
	 
	    String total = DOBString + genderBit + randomString + "08";
	    total = total + generateLuhnDigit(total);
	    
	    return total;
	}
	

	public static String generateID(String gender,String DOB) 
	{
		String genderBit = "";
		String randomString="";
		int randomDOBYear = Integer.parseInt(DOB.split("/")[0].substring(2,4));
		System.out.println("[INFO] YEAR : " + randomDOBYear);
		System.out.println("[INFO] CLIENT DOB ARR: " + Arrays.toString(DOB.split("/")));
		String randomDOBMonth ;
		String randomDOBDay;
		int randomDOBMonthSub = Integer.parseInt(DOB.split("/")[1]);
		int randomDOBDaySub = Integer.parseInt(DOB.split("/")[2]);
		
		if (randomDOBMonthSub<10)
		{
			randomDOBMonth = "0" + randomDOBMonthSub;
		}
		else
		{
			randomDOBMonth = ""+randomDOBMonthSub;
		}
		
		if (randomDOBDaySub<10)
		{
			randomDOBDay = "0" + randomDOBDaySub;
		}
		else
		{
			randomDOBDay = ""+randomDOBDaySub;
		}
		
		String DOBString = ""+randomDOBYear + randomDOBMonth + randomDOBDay;
		
		
		if (gender.equalsIgnoreCase("M"))
		{
			genderBit = "5";
			
		}
		else if (gender.equalsIgnoreCase("F"))
		{
			genderBit = "0";
		}
		
		
	     int random = getRandomNumber(100);
	    
	    if (random < 10) 
	    {
	    	randomString = "00" + random;
	    }
	    else {
	    	randomString = "0" + random;
	    }
	 
	    String total = DOBString + genderBit + randomString + "08";
	    total = total + generateLuhnDigit(total);
	    
	    
	    
	    return total;
	}
	
	public static int getRandomNumber(int range) 
	{
	    return (int) (Math.random() * range);
	}

	public static int getRandomNumber(int min, int max) 
	{
	    return (int) ((Math.random() * (max - min)) + min);
	}
	
	private static int generateLuhnDigit(String input) 
	{
	    int total = 0;
	    int count = 0;
	    for (int i = 0; i < input.length(); i++) {
	        int multiple = (count % 2) + 1;
	        count++;
	        int temp = multiple * Integer.parseInt(String.valueOf(input.charAt(i)));
	        temp = (int) Math.floor(temp / 10) + (temp % 10);
	        total += temp;
	    }

	    total = (total * 9) % 10;

	    return total;
	}
}
