//Kalkulator kredytów hipotecznych - Oblicza miesięczne płatności kredytu hipotecznego na czas określony w podanych warunkach przy danej stopie procentowej. Dowiemy się również, ile czasu zajmie użytkownikowi spłata pożyczki.

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		double pozyczka = 0;
		double oprocentowanie = 0;
		double miesieczna_platnosc = 0;
		double saldo = 0;
		int okres_zlozony = 0;
		int termin;
		
		System.out.printf("Wpisz kwotę kredytu: ");
		pozyczka = scan.nextDouble();
		
		System.out.printf("Wprowadź oprocentowanie pożyczki: ");
		oprocentowanie = scan.nextDouble();
		
		System.out.printf("Wprowadź termin (lata) spłaty kredytu: ");
		termin = scan.nextInt();
		
		System.out.printf("\n================================================================\n");
		scan.close();

		miesieczna_platnosc = miesiecznaWyplata (pozyczka, oprocentowanie, termin);
		saldo = - (miesieczna_platnosc * (termin * 12));
		System.out.format("%-30szł%-+10.2f%n", "Kwota należna bankowi:", saldo);
		System.out.format("%-30szł%-10.2f%n", "Minimalna miesięczna opłata:", miesieczna_platnosc);
	}

	public static double miesiecznaWyplata (double pozyczka, double oprocentowanie, double termin) {
		double rata = (oprocentowanie / 100) / 12;
		double podstawa = (rata + 1);
		double miesiac = termin * 12;
		double wynik = 0;
		wynik = pozyczka * (rata * (Math.pow(podstawa, miesiac)) / ((Math.pow(podstawa, miesiac)) - 1)); 
		
		return wynik;
	}
}