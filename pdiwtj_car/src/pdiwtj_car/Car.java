package pdiwtj_car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.io.FileWriter;


public class Car {
	int _enginePower;
	double _price;
	String _color;
	
	//zadanie 2: klasa samochodu
	public Car(int enginePower, double price, String color) {
		_enginePower = enginePower;
		_price = price;
		_color = color;
	}
	
	Random rnd = new Random();
	public void totalCost(){
		int totalCost = rnd.nextInt(10000)+3000;
		System.out.println("Total cost on year: " + totalCost + "PLN");
	}
	public void fuelConsumption(){
		int fuelConsumption = rnd.nextInt(10)+5;
		System.out.println("Fuel consumption: " + fuelConsumption + " l/100km");
	}
	
	 public static void main(String[] args) {
		 BufferedReader br = null;
		 List<Integer> paramsEnginePower = new ArrayList<Integer>();
		 List<Integer> paramsPrice = new ArrayList<Integer>();
		 ArrayList<String> paramsColor = new ArrayList<String>();
		
		 try {
	           br = new BufferedReader(new InputStreamReader(System.in));
	           try{
	           System.out.print("Wprowadz liczbe samochodow: ");
	           int amountOfCars = Integer.parseInt(br.readLine());
	          
	        	   for(int i = 1; i<=amountOfCars; i++){
		        	   System.out.print("Podaj moc silnika "+ i + " samochodu:");
			           int enginePower = Integer.parseInt(br.readLine());
			           System.out.print("Podaj cene "+ i + " samochodu:");
			           int price = Integer.parseInt(br.readLine());
			           System.out.print("Podaj kolor "+ i + " samochodu:");
			           String color = br.readLine();
			           
		        	   Car car = new Car(enginePower, price, color);
		        	   car.totalCost();
		        	   car.fuelConsumption();
		        	   
		        	   paramsEnginePower.add(enginePower);
		        	   paramsPrice.add(price);
		        	   paramsColor.add(color);
		           };
		           
		           //zadanie 1: wspieranie bledow
	           }catch(Exception e){
	        	   System.out.print("Podano niewlasciwy parametr.");
	           }
	           
	           //zadanie 3: zapisywanie do pliku carParams.txt
	           FileWriter writer = new FileWriter("carParams.txt"); 
	  		 	for(Integer str: paramsEnginePower) {
	  			  writer.write(str.toString() + " ");
	  			}
	  		 	for(Integer str: paramsPrice) {
		  			  writer.write(str.toString() + " ");
		  			}
	  		 	for(String str: paramsColor) {
		  			  writer.write(str + " ");
		  			}
	  			writer.close();
	           
		 } catch (IOException e) {
	            e.printStackTrace();
	            e.getMessage();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                    e.getMessage();
	                    
	                }
	            }
	        }

    }
}
