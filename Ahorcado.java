import java.util.Random;
import java.util.Scanner;

class Palabra {
	String palabra;
	char[] letras = new char[0];
	int fallos = 0;

	Palabra (String s) {
		this.palabra = s;
	}

	void addLetra(char c) {
		char[] antLet = new char[this.letras.length+1];
		System.arraycopy(this.letras, 0, antLet, 0, this.letras.length);
		antLet[antLet.length-1] = c;
		this.letras = antLet;

		boolean contiene = false;
		for (int i = 0; i < this.palabra.length(); i++) {
			if (c == this.palabra.charAt(i)) {
				contiene = true;
				break;
			}
		}
		if (!contiene) {
			this.fallos++;
		}
	}

	String getSecreto() {
		String secreto = "";
		for (int i = 0; i < this.palabra.length(); i++) {
			boolean contiene = false;
			for (char c : this.letras) {
				if (c == this.palabra.charAt(i)) {
					contiene = true;
					break;
				}
			}
			secreto = secreto + (contiene ? this.palabra.charAt(i) : "*");
		}
		return secreto;
	}

	boolean estaCompleta() {
		for (int i = 0; i < this.palabra.length(); i++) {
			boolean contiene = false;
			for (char c : this.letras) {
				if (c == this.palabra.charAt(i)) {
					contiene = true;
					break;
				}
			}
			if (!contiene) {
				return false;
			}
		}
		return true;
	}
}

public class Ahorcado {
	final static int MAX_FALLOS = 7;
	final static  String[] FRUTAS = {
		"frutas", "manzana", "sandia", "kiwi", "platano", "papaya", "pera"

	};
	final static String[] DEPORTES = {
		"deportes", "jugger", "golf", "baloncesto", "futbol", "atletismo"
	};
	final static String[] CONTINENTES = {
		"continentes", "europa", "africa", "asia", "america", "oceania", "antartida"
	};
	final static String[][] TEMAS = {
		FRUTAS, DEPORTES, CONTINENTES
	};

	public static void dibujito(int n) {
		switch(n) {
			case 1:
				System.out.println(" ┏━━━━━━━━━━━━━━━━┯━━━━\n ┃\n ┃\n ┃\n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃\n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃\n ┃\n ┃\n ┃\n━┻━━━━━━━━━━━━━━━━━━━━━━━━\n");
				break;
			case 2:
				System.out.println(" ┏━━━━━━━━━━━━━━━━┯━━━━\n ┃                │\n ┃                │\n ┃           ╭────┴────╮\n ┃           │         │\n ┃           │  ╳   ╳  │\n ┃           │         │\n ┃           │  ╭───╮  │\n ┃           │  ╰───╯  │\n ┃           ╰────┬────╯\n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃ \n ┃\n ┃\n ┃\n ┃\n━┻━━━━━━━━━━━━━━━━━━━━━━━━\n");
				break;
			case 3:
				System.out.println(" ┏━━━━━━━━━━━━━━━━┯━━━━\n ┃                │\n ┃                │\n ┃           ╭────┴────╮\n ┃           │         │\n ┃           │  ╳   ╳  │\n ┃           │         │\n ┃           │  ╭───╮  │\n ┃           │  ╰───╯  │\n ┃           ╰────┬────╯\n ┃                │\n ┃                │ \n ┃                │  \n ┃                │  \n ┃                │    \n ┃                │     \n ┃                │\n ┃                  \n ┃                   \n ┃                    \n ┃                     \n ┃                      \n ┃\n ┃\n ┃\n ┃\n━┻━━━━━━━━━━━━━━━━━━━━━━━━\n");
				break;
			case 4:
				System.out.println(" ┏━━━━━━━━━━━━━━━━┯━━━━\n ┃                │\n ┃                │\n ┃           ╭────┴────╮\n ┃           │         │\n ┃           │  ╳   ╳  │\n ┃           │         │\n ┃           │  ╭───╮  │\n ┃           │  ╰───╯  │\n ┃           ╰────┬────╯\n ┃                │\n ┃               ╱│ \n ┃              ╱ │  \n ┃             ╱  │  \n ┃            ╱   │    \n ┃           ╱    │     \n ┃                │\n ┃  \n ┃  \n ┃ \n ┃  \n ┃  \n ┃\n ┃\n ┃\n ┃\n━┻━━━━━━━━━━━━━━━━━━━━━━━━\n");
				break;
			case 5:
				System.out.println(" ┏━━━━━━━━━━━━━━━━┯━━━━\n ┃                │\n ┃                │\n ┃           ╭────┴────╮\n ┃           │         │\n ┃           │  ╳   ╳  │\n ┃           │         │\n ┃           │  ╭───╮  │\n ┃           │  ╰───╯  │\n ┃           ╰────┬────╯\n ┃                │\n ┃               ╱│╲\n ┃              ╱ │ ╲\n ┃             ╱  │  ╲\n ┃            ╱   │   ╲\n ┃           ╱    │    ╲\n ┃                │\n ┃\n ┃\n ┃\n ┃\n ┃\n ┃\n ┃\n ┃\n ┃\n━┻━━━━━━━━━━━━━━━━━━━━━━━━\n");
				break;
			case 6:
				System.out.println(" ┏━━━━━━━━━━━━━━━━┯━━━━\n ┃                │\n ┃                │\n ┃           ╭────┴────╮\n ┃           │         │\n ┃           │  ╳   ╳  │\n ┃           │         │\n ┃           │  ╭───╮  │\n ┃           │  ╰───╯  │\n ┃           ╰────┬────╯\n ┃                │\n ┃               ╱│╲\n ┃              ╱ │ ╲\n ┃             ╱  │  ╲\n ┃            ╱   │   ╲\n ┃           ╱    │    ╲\n ┃                │\n ┃               ╱\n ┃              ╱ \n ┃             ╱  \n ┃            ╱   \n ┃           ╱    \n ┃\n ┃\n ┃\n ┃\n━┻━━━━━━━━━━━━━━━━━━━━━━━━\n");
				break;
			case 7:
				System.out.println(" ┏━━━━━━━━━━━━━━━━┯━━━━\n ┃                │\n ┃                │\n ┃           ╭────┴────╮\n ┃           │         │\n ┃           │  ╳   ╳  │\n ┃           │         │\n ┃           │  ╭───╮  │\n ┃           │  ╰───╯  │\n ┃           ╰────┬────╯\n ┃                │\n ┃               ╱│╲\n ┃              ╱ │ ╲\n ┃             ╱  │  ╲\n ┃            ╱   │   ╲\n ┃           ╱    │    ╲\n ┃                │\n ┃               ╱ ╲\n ┃              ╱   ╲\n ┃             ╱     ╲\n ┃            ╱       ╲\n ┃           ╱         ╲\n ┃\n ┃\n ┃\n ┃\n━┻━━━━━━━━━━━━━━━━━━━━━━━━\n");
				break;
			default:
				break;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();

		/*Establecer tema*/
		String[] tema = TEMAS[rnd.nextInt(TEMAS.length)];
		/*Como el primer elemento de cada String[] es el nombre del tema, tengo que usar un numero aleatorio a partir de 1*/
		Palabra palabra = new Palabra(tema[rnd.nextInt(tema.length-1)+1]);

		System.out.println("Adivina la palabra.");
		System.out.println("El tema es " + tema[0] + ": ");
		System.out.println("···················\n");
		do {
			System.out.println(palabra.getSecreto());
			if (palabra.estaCompleta()) {
				System.out.println("GANASTE :D\nToma un caramelo \u25b6\u25cd\u25c0");
				return;
			}
			dibujito(palabra.fallos);
			System.out.print("Fallos: " + palabra.fallos + " -> ");
			palabra.addLetra(sc.next().charAt(0));
			System.out.print("\n");
		} while (palabra.fallos < MAX_FALLOS);
		dibujito(MAX_FALLOS);
		System.out.println("Demasiados fallos. Perdiste :-\\");
	}
}
