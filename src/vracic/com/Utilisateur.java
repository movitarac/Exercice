package vracic.com;

import java.util.Scanner;

public class Utilisateur {
	static Scanner clavier = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// tableau car contient des chiffres et des chaines caracteres..on met Object[]
		String prenom;
		String nom;
		short age;
		String dateNaissance; // ex 01/01/2001
		// String dateNaissance = "1993";
		// int anne = Integer.parseInt(dateNaissance); //pour convertir string en int

		Object[][] user = new Object[4][2]; // tableau
		// on saisi
		//
		for (int i = 0; i < 2; i++) {
			prenom = clavier.nextLine(); // on saisi sur la prochaine ligne de code
			System.out.println(prenom);
			user[0][i] = prenom;

			nom = clavier.nextLine();
			System.out.println(nom);
			user[1][i] = nom;

			dateNaissance = clavier.nextLine();
			System.out.println(dateNaissance);
			user[2][i] = dateNaissance;
			// on recupere l'anne de naissance
			// String dateNaissance
			// anne=Integer.parseInt(dateNaissance)
			age = Short.parseShort(clavier.nextLine());
			// ici on convert
			System.out.println(age);
			user[3][i] = age;
		}
		// je veux qu'on calcule l'age automatiquement
		// pour afficher le tableau 2d; il faut mettre dans 1 boucle
		/*for (int x = 0; x < user.length; x++) {
			System.out.println(user[x]);
			for (int y = 0; y < user[x].length; y++) {
				System.out.println(user[x][y]);
			}
*/
		}

		// if (age < 18) && (dateNaissance) {

		// } else {

	}

} 


