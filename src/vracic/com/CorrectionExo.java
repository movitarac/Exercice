package vracic.com;

import java.util.Scanner;

/**
 * Premiere class program

 * @author Activ'Consult'ing
 *
 */

//correction Exo Utilisateur
public class CorrectionExo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Tableau 2D respresantant mes Users
		Object[][] infoUser = new Object [2][4]; //4 est ligne 2 est colonne pour nombre d'user
		
		//je cree mon clavier
		Scanner clavier = new Scanner(System.in);
		
		//je declare sans initialiser 3 variables du meme type
		String nom,prenom,dateNaissance;
		
		//je fais une boucle pour creer les 2 users.
		//on connait les bornes de la boucle [0;2[
		
		for (int userCree = 0; userCree < 2 ; userCree++) {
			prenom = recupererPrenom(clavier);
			nom = recupererNom(clavier);
			dateNaissance = recupererDate(clavier);
			String dateToday = "15/03/2018";
			
			//on calcule l'age
			byte age = calculerAge(dateToday, dateNaissance);
			System.out.println(age);
			
			//on affiche la majorite de la personne
			verifierMajorite(age);
			
			//on affiche la majorite de la personne avec leur nom
			affichagePersonalise(prenom, nom, age); //menu - refactor - extract method - method name
			//on fait une nouvelle fonction automatiquement apres avoir saisi les lignes de code en aval
			
			//on va stocker les infos saisies - initialisation le tableau en fonction de l'user
			infoUser[userCree][0] = nom;
			infoUser[userCree][1] = prenom;
			infoUser[userCree][2] = dateNaissance;
			infoUser[userCree][3] = age;
			
			
			//pour afficher le tableau
			afficherTableau2d(infoUser);
		}
	}

	private static void afficherTableau2d(Object[][] infoUser) {
		for (int index = 0 ; index <infoUser.length; index++) {
		
			for (Object info : infoUser[index]) {
			System.out.println(info); // on met entre le parenthese le celule pas le nom de tableau
			}
		}
	}

	//on cree des fonctions qui demande pour saisir chaque info.
	//une fonction pour une info
	/** 
	 * 
	 *Fonction est Recuperer le prenom d'une personne
	 * @param clavierCopy c'est l'objet de type Scanner
	 * @return prenom de l'utilisateur
	 */
	
	
	static String recupererPrenom(Scanner clavierCopy) {
		//ici on prend la copie de scanner
		//on cree un boolean pour verifier le saisi
		//verifier qu'un prenom est au bon format (que lettre)
		boolean verificateur = false; //par defaut c'est Faux
		
		//on cree une nouvelle variable de prenom, car 'prenom' est dans l'autre bloc
		String firstName;
				
		//on doit au moins rentrer une fois dans la boucle
		//on boucle tant que le verificateur est faux
		do {
			System.out.print("Entrez votre prenom: ");
			firstName = clavierCopy.nextLine();
			
			//si le prenom est composé d'au moins 3 lettres
			if (firstName.length()>=3) {
			
			//on verifie que le prenom ne contient que des lettres
				
			verificateur = firstName.chars().allMatch(Character::isLetter);
			/* on peut ne pas utiliser le code en bas pour etre plus direct.
			// si le prenom contient que des lettres...
			
				if (verificateur == true) {	
					//tout est ok
					System.out.println("OK");
				}
			}
			*/
			}
		} while (verificateur != true); // != est different, si le prenom est  moins de 3 lettres et contient autre que lettre
		//donc on reste dans la boucle
		
		
		//return null; //au debut on met return null on va retourner/renvoyer qqch mais on ne sait pas encore le type.
		return firstName;
	}

	
	/**
	 * Permet de recuperer le nom
	 * @param clavierCopy objet de type scanner
	 * @return nom
	 */
	private static String recupererNom(Scanner clavierCopy) {
		// TODO Auto-generated method stub
		
		boolean verificateur = false;
		String lastName;
		do {
			System.out.print("Entrez votre nom: ");
			lastName = clavierCopy.nextLine();
			
			if (lastName.length()>=3) {
				verificateur = lastName.chars().allMatch(Character::isLetter);
			}
		} while (verificateur != true);
		return lastName;
	}

	private static String recupererDate(Scanner clavierCopy) {
		// TODO Auto-generated method stub
		//simplifier
			
		String dateBirth;
		System.out.print("Entrez votre date de naissance (xx/xx/xx): ");
		dateBirth = clavierCopy.nextLine();
		return dateBirth;
	}
	
	
	/**
	 * Calcule la difference entre 2 dates (année aujourd'hui - année naissance)
	 * @param dateTodayCopy date d'aujourd'hui
	 * @param dateNaissanceCopy date d'anniversaire
	 * @return age calculé
	 */
	private static byte calculerAge(String dateTodayCopy, String dateNaissanceCopy) {
		// TODO Auto-generated method stub
	//on recuperer avec split ca donne tableau
	// '/' est un champ de separateur.
	//le debut c'est string anneNaissance = ....
	//mais apres il faut convertir le string à short. avec le parse
	//on utilise short car annee n'est pas un byte.
	
		short anneNaissance = Short.parseShort(dateNaissanceCopy.split("/")[2]); //car ca va separer, donc ca donne tableau
		short anneToday = Short.parseShort(dateTodayCopy.split("/")[2]);
		//return 0; //parce que c'est une fonction byte _ au debut
		return (byte) (anneToday - anneNaissance ); //On le force pour se mettre en byte
	}
	
	
	/**
	 * Pour verifier si user est majeur ou pas avec un affichage personalisé
	 * @param nom Nom utilisateur
	 * @param prenom Prenom utilisateur
	 * @param age 
	 */
	private static void affichagePersonalise(String nom, String prenom, byte age) {
		if (age < 18) {
			System.out.println(prenom + " " + nom + " n'est pas majeur");
		} else {
			System.out.println(prenom + " " + nom + " est majeur");
		}
	}
	
	private static void verifierMajorite(byte age) {
		if (age < 18) {
			System.out.println("Cette persone n'est pas majeur");
		} else {
			System.out.println("Cette persone est majeur");
		}
	}
	
}
