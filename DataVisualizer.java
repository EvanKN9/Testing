import java.util.Scanner;
import java.util.ArrayList;

class DataVisualizer {
	public static void main(String[] args){

	Scanner scnr = new Scanner(System.in);
	ArrayList<String> stringList = new ArrayList<>();
	ArrayList<Integer> intList = new ArrayList<>();

	
	System.out.println("Enter a title for the data:");
	String title = scnr.nextLine();
	System.out.println("You entered: " + title);

	System.out.println();
	
	System.out.println("Enter the column 1 header:");
	String header1 = scnr.nextLine();
	System.out.println("You entered: " + header1);

	System.out.println();

	System.out.println("Enter the column 2 header:");
	String header2 = scnr.nextLine();
	System.out.println("You entered: " + header2);

	System.out.println();

	while(true){
	System.out.println("Enter a data point (-1 to stop input):");
	String userInput = scnr.nextLine();	

	if(userInput.equals("-1")){
		break;
	}

	if(!userInput.contains(",")){
		System.out.println("Error: No comma in string.");
		System.out.println();
		continue;
	}

	int commaCount = 0;
	for(int i = 0; i < userInput.length(); i++){
		if(userInput.charAt(i) == ','){
			commaCount++;
		}
	}
	
	if(commaCount > 1){
		System.out.println("Error: Too many commas in input.");
		System.out.println();
		continue;
	}

	int commaIndex = userInput.indexOf(",");
	String dataString = userInput.substring(0, commaIndex);
	String dataIntFromString = userInput.substring(commaIndex + 1).trim();

	boolean isNumber = true;
	for(int i = 0; i < dataIntFromString.length(); i++){
		if(!Character.isDigit(dataIntFromString.charAt(i))){
			isNumber = false;
			break;
		}
	}

	if(!isNumber){
		System.out.println("Error: Comma not followed by an integer.");
		System.out.println();
		continue;
	}

	int dataInt = Integer.parseInt(dataIntFromString);
	stringList.add(dataString);
	intList.add(dataInt);

	System.out.println("Data string: " + dataString);
	System.out.println("Data integer: " + dataInt);
	System.out.println();

	}
	
	System.out.println();
	System.out.printf("%33s\n", title);
	System.out.printf("%-19s | %22s\n", header1, header2); 
	System.out.printf("--------------------------------------------\n");
	
	for(int i = 0; i < stringList.size(); i++){
		System.out.printf("%-19s | %22d\n", stringList.get(i), intList.get(i));
	}

	System.out.println();
	
	for(int i = 0; i < stringList.size(); i++){
		System.out.printf("%20s ", stringList.get(i));
		for(int j = 0; j < intList.get(i); j++){
			System.out.print("*");
		}
		System.out.println();
	}
			
	
	
		
		
	}
}