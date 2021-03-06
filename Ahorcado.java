import java.util.Random;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

class ReproductorMidi{

	public ReproductorMidi(String ficheroMidi) throws Exception{
		//simplificamos el throws con Exception para hacer código limpio (aunque de peor calidad)
		// lo más fácil pillar el secuenciador por defecto.
		Sequencer sequencer = MidiSystem.getSequencer();
		//antes de usar el secuenciaador hay que abrirlo.
		sequencer.open();
		// la secuencia midi es un InputStream. Puede ser un fichero, un stream de internet, ...en este caso es un fichero
		InputStream is = new BufferedInputStream(new FileInputStream(new File(ficheroMidi)));
		sequencer.setSequence(is);
		//cuando nos interesa arrancamos la reproducción.
		sequencer.start();
		//repetimos indefinidadmente la cancion indicando que se repita LOPP_CONTINUOSLY
		sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
	}
}

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
	final static String[] ANIMALES = {
		"animales", "gato", "perro", "urogallo", "avestruz", "ornitorrinco", "kiwi",
		"tigre", "elefane", "agaporni", "carpincho", "conejo", "oso"
	};
	final static String[][] TEMAS = {
		FRUTAS, DEPORTES, CONTINENTES, ANIMALES
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

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		File dir = new File("midi");
		File[] pistas = dir.listFiles();
		new ReproductorMidi("midi/" + pistas[rnd.nextInt(pistas.length)].getName());

		/*Establecer tema*/
		String[] tema = TEMAS[rnd.nextInt(TEMAS.length)];
		/*Como el primer elemento de cada String[] es el nombre del tema, tengo que usar un magia negra para ocnseguir el aleatorio entre 1 y length*/
		Palabra palabra = new Palabra(tema[rnd.nextInt(tema.length-1)+1]);

		System.out.println("Adivina la palabra.");
		System.out.println("El tema es " + tema[0] + ": ");
		System.out.println("-------------------\n");
		do {
			System.out.println(palabra.getSecreto());
			dibujito(palabra.fallos);
			System.out.print("Fallos: " + palabra.fallos + " -> ");
			String entrada = sc.next();
			palabra.addLetra(entrada.charAt(0));
			System.out.print("\n");
			if (palabra.estaCompleta() || entrada.equals(palabra.palabra)) {
				System.out.println(palabra.palabra);
				System.out.println("GANASTE :D\nToma un caramelo \u25b6\u25cd\u25c0");
				System.exit(0);
				// return;
			}
		} while (palabra.fallos < MAX_FALLOS);
		dibujito(MAX_FALLOS);
		System.out.println("Demasiados fallos. Perdiste :-\\");

		System.exit(0);
	}
}
