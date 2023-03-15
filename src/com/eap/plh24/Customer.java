package com.eap.plh24;

import java.util.ArrayList;
import java.util.List;

//Υπάρχουν 3 τύποι πελατών. Οι κανονικοί παίχτες (τρέχουσα κλάση), καθώς και οι παίχτες Gold και Platinum.
//Οι κανονικοί παίχτες μπορούν να ποντάρουν έως 100 ανά στοίχημα.
//Οι παίχτες Gold αντιστοιχούν στην κλάση GoldCustomer, υποκλάση της Customer, με μέγιστο επιτρεπτό όριο πονταρίσματος 1000.
//Οι παίχτες Platinum αντιστοιχούν στην κλάση PlatinumCustomer, υποκλάση της Customer, με μέγιστο επιτρεπτό όριο πονταρίσματος 2000.
//Η συγκεκριμένη κλάση θα πρέπει να υλοποιήσει τη διεπαφή IGiveBetList, η οποία επιστρέφει τη λίστα των στοιχημάτων του κάθε παίχτη.
public class Customer implements IGiveBetList {
	private final String name;
	private final List<CustomerBet> customerBetList = new ArrayList<>();
	public Customer(String n) {
		name = n;
	}
	// getter για το όνομα του Πελάτη
	public String getName() {
		return name;
	}
	//Για να εισάγουμε ένα νέο στοίχημα στη λίστα στοιχημάτων του πελάτη,
	//πρέπει να ελέγξουμε πρώτα αν το στοίχημα έχει ποσό εντός του επιτρεπτού ορίου
	//του κάθε πελάτη (μέθοδος getMaxStake), καθώς και αν το εν λόγω στοίχημα υπάρχει
	//στη λίστα στοιχημάτων του BetOrganization
	public void addCustomerBet(CustomerBet customerBet) {
		if (customerBet.getStake()<=getMaxStake()){
			BetOrganization betOrganization = BetOrganization.getInstance();
			if (betOrganization.checkCustomerBetInList(customerBet)){
				customerBetList.add(customerBet);
			}
		} else
			throw new IllegalArgumentException("Το πόσο " + customerBet.getStake() + " είναι εκτός όριων του παίχτη");
	}

	// η μέθοδος επαναληπτικά προσθέτει τα πονταρίσματα κάθε παίχτη και επιστρέφει το
	// συνολικό ποσό (η μέθοδος κληρονομείται στις υποκλάσεις)
	public int getMoneyPlayed(){
		int sum = 0;
		for (CustomerBet customerBet : customerBetList){
			sum+=customerBet.getStake();
		}
		return sum;
	}

	// η μέθοδος που επιστρέφει το μέγιστο όριο πονταρίσματος των απλών παιχτών (100)
	// για τις υπόλοιπες κατηγορίες παιχτών υλοποιείται αντίστοιχα στις υποκλάσεις
	public int getMaxStake(){
		return 100;
	}

	// η μέθοδος υλοποιεί την αντίστοιχη μέθοδο που ορίζεται στο interface IGiveBetList
	// και επιστρέφει λίστα με τα πονταρίσματα
	// των παιχτών (επιστρέφει λίστα με αντικείμενα τύπου customerBet)
	@Override
	public List<CustomerBet> getCustomerBetList() {
		return customerBetList;
	}
}
