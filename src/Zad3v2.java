import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;

public class Zad3v2 {
	public static Scanner scanner;
	public static void main(String[] args) throws ArithmeticException, IOException{
		float a= 0,b = 0,c =0;
		boolean ifSquare = true;
		
	do{
		try{
			System.out.println("Podaj wspó³czynnik a: ");a=ScannerFloat();
			System.out.println("Podaj wspó³czynnik b: ");b=ScannerFloat();
			System.out.println("Podaj wspó³czynnik c: ");c=ScannerFloat();
			
			if (a==0)
				throw new ArithmeticException("B³¹d!");
			else
				ifSquare=false;
			
		}catch(ArithmeticException e){
			ifSquare=true;
			System.out.println("To nie jest funkcja kwadratowa.\nPodaj jeszcze raz wspó³czynniki");
		}
	}while(ifSquare);	
		PushToFile(a,b,c,args[0]);
	}
	
	public static void PushToFile(float a, float b, float c,String argz) throws IOException {
		FileWriter fw = new FileWriter(argz,true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter out =new PrintWriter(bw);	
		float[] result = {0,0};
		
				
		if (Delta(a,b,c)>=0)
		{
			result[0] = (-Delta(a,b,c)-b)/(2*a); result[1] = (Delta(a,b,c)-b)/(2*a);
			
			if (Delta(a,b,c)==0){
				//out.println();
		        out.println("Podwójne miejsce zerowe to: "+result[0]+"\r\n");
			}else {
				//out.println();
				out.println("Pierwsze miejsce zerowe to: "+result[0]);
				out.println("Drugie miejsce zerowe to: "+result[1]+"\r\n");
			}
		}else  {
				out.println("Nie ma miejsc zerowych w tej funkji\r\n");
		}
		out.close();
		System.out.print("Wynik zapisano w pliku: " + argz);
		
	};
	
	public static float Delta(float a,float b,float c){
		return (float)Math.sqrt((b*b)-(4*a*c));
	};
	
	public static float ScannerFloat(){
		scanner = new Scanner(System.in);	
		do{	
			try{
				return scanner.nextFloat();
			}catch(InputMismatchException e){
				System.out.println("Podany argument nie jest liczb¹.\nPodaj jeszcze raz.");
				scanner.next();
			}
		}while(true);		
	};	
}
