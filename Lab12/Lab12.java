import java.util.ArrayList;
import java.io.*;
import java.util.*;

public class Lab12 
{

	public static void main(String[] args)
	{
		// ArrayIndexOutOfBoundsException
		try{
			int[] arr = { 1, 2, 3 };
			System.out.println(arr[3]);
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.toString());
		}

		// NullPointerException
		try{
			ArrayList<String> arr = null;
			String str = arr.get(0);
		}catch(NullPointerException e){
			System.out.println(e.toString());
		}

		// ClassCastException
		try{
			Object obj = new String();
			System.out.println((Integer)obj);
		}catch(ClassCastException e){
			System.out.println(e.toString());
		}

		// ArithmeticException
		try{
			int num = 5;
			int num2 = num / 0;
		}catch(ArithmeticException e){
			System.out.println(e.toString());
		}

		// NegativeArraySizeException
		try{
			int[] arr = new int[-1];
		}catch(NegativeArraySizeException e){
			System.out.println(e.toString());
		}

		// StringIndexOutOfBoundsException
		try{
			String str = "Hello";
			char c = str.charAt(5);
		}catch(StringIndexOutOfBoundsException e){
			System.out.println(e.toString());
		}

		// NumberFormatException
		try{
			String num = "3.9";
			System.out.println(Integer.parseInt(num));
		}catch(NumberFormatException e){
			System.out.println(e.toString());
		}

		// ArrayStoreException
		try{
			Object[] str = new String[5];
			str[0] = new Integer(1);
		}catch(ArrayStoreException e){
			System.out.println(e.toString());
		}

		// FileNotFoundException
		try{
			InputStream lol = new FileInputStream("lol.txt");
		}catch(FileNotFoundException e){
			System.out.println(e.toString());
		}

		// NoSuchElementException
		try{
			Scanner scan = new Scanner("lol");
			scan.nextLine();
			String str = scan.nextLine();
		}catch(NoSuchElementException e){
			System.out.println(e.toString());
		}

		try{
			throw(new NoogieException());
		}catch(NoogieException e){
			System.out.println(e.toString());
		}

		try{
			throw(new CoogieException(5));
		}catch(CoogieException e){
			System.out.println(e.toString());
		}

	}

}