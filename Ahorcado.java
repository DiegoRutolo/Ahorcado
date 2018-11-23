import java.util.Random;
import java.util.Scanner;

class Palabra {
	String palabra;
	char[] letras;

	Palabra (String s) {
		this.palabra = s;
	}

	void addLetra(char c) {
		char[] antLet = new char[this.letras.length+1];
		System.arraycopy(this.letras, 0, antLet, 0, this.letras.length);
		antLet[antLet.length-1] = c;
		this.letras = antLet;
	}

	String getSecreto() {
		String secreto = "";
		for (int i = 0; i < this.palabra.length(); i++) {
			if () {
				secreto = secreto + this.palabra[i];
			} else {
				secreto = secreto + "*";
			}
		}
		return secreto;
	}
}

public class Ahorcado {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();	
		String[] frutas = {
			"manzana", "naranja", "melon", "platano","sandia", "kiwi"
		};
		Palabra palabra = new Palabra(frutas[rnd.nextInt(frutas.length)]);
		System.out.println("Adivina la palabra.");
		System.out.println("El tema es frutas: ");
		System.out.println(palabra.getSecreto());
	}
}