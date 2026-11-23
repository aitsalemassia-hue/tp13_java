package com.example.tp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		final String filePath = "listeEmployees.ser";
		// creation des employees 
		List<Employee> staff = new ArrayList<>();
		staff.add(new Employee(1,"Assiya",4000.0,"@aitsalem"));
		staff.add(new Employee(1,"Salma",4000.0,"salmapasswrd"));
		staff.add(new Employee(1,"Othman",4000.0,"Othmanpsswrd"));
		staff.add(new Employee(1,"Fatima",4000.0,"fatima@ps"));
		
		
		//  Sérialisation vers un fichier binaire
        try {
            SerializationUtil.serializeEmployees(filePath, staff);
            System.out.println("→ Sérialisation réussie dans " + filePath);
        } catch (IOException e) {
            System.err.println("Erreur de sérialisation : " + e.getMessage());
            return;
        }

        //  Désérialisation depuis le fichier
        List<Employee> loaded;
        try {
            loaded = SerializationUtil.deserializeEmployees(filePath);
            System.out.println("→ Désérialisation réussie, objets restaurés :");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur de désérialisation : " + e.getMessage());
            return;
        }

        //  Affichage des objets désérialisés
        for (Employee emp : loaded) {
            System.out.println("  " + emp);
        }

        //  Vérification du champ transient
        System.out.println("\nNote : le champ 'password' est transient, il n’a pas été enregistré → null.");
    }
	}


