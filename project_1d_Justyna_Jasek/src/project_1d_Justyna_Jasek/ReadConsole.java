package project_1d_Justyna_Jasek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class ReadConsole {

    public static void main(String[] args) {

        BufferedReader br = null;

        try {

            br = new BufferedReader(new InputStreamReader(System.in));


            System.out.print("Wprowadz liczbe prob: ");
            String tries = br.readLine();
            System.out.print("Wprowadz poczatek przedzialu: ");
            String minRange = br.readLine();
            System.out.print("Wprowadz koniec przedzialu: ");
            String maxRange = br.readLine();
            
            int counter = 0;
            
			Random generator = new Random(); 
			
			if(tries.matches("\\d+") && minRange.matches("\\d+") && maxRange.matches("\\d+")){
				int amountOfTries = Integer.parseInt(tries);
				int min = Integer.parseInt(minRange);
				int max = Integer.parseInt(maxRange);
				
				System.out.println("Liczba prob: " + amountOfTries);
	            System.out.println("Poczatek przedzialu: " + min);
	            System.out.println("Koniec przedzialu: " + max);
	            
		          for(int i=0; i<amountOfTries; i++){
		        	  
		        	int randomNum = generator.nextInt((max*10 - min) + 1) + min;
		  			System.out.println("Wylosowana liczba: " + randomNum);
		  			if (randomNum >= min && randomNum <= max)
		  			{
		  				counter++;
		  			}
		          }
				
	          System.out.println("Wylosowana liczba zmiescila sie w przedziale: " + counter + " razy."); 

			}else{
				System.out.println("Podano zle wartosci, musza byc liczby!"); 

			}
		    
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}