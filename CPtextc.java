import java.util.*;

public class CPtext {
	//static String tword;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
	String alphabet="abcdefghijklmnopqrstuvwxyz";
		Random cases = new Random();
		
		String tword="";
			int let= cases.nextInt(6)+4;
		for( int i=0; i<let;i++) {
			int d= cases.nextInt(25);
		tword=tword+(alphabet.charAt(d));
		}
		System.out.println(tword);}

	}

