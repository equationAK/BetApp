package com.eap.plh24;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BetOrganization {
	//Λίστα με τους διαθέσιμους παίχτες
	private final List<Customer> cList = new ArrayList<>();
	//Λίστα με τα διαθέσιμα στοιχήματα για αγώνες ποδοσφαίρου και μπάσκετ
	private final List<Bet> betList = new ArrayList<>();



	// δημιουργία αντικειμένου betOrganization με το πρότυπο Singleton
	private static BetOrganization instance = new BetOrganization();

	// ο constructor είναι private για να μην μπορεί η κλάση να γίνει instantiated
	private BetOrganization(){}

	// μέθοδος λήψης του μοναδικού αντικειμένου της BetOrganization
	public static BetOrganization getInstance(){
		if (instance == null)
			instance = new BetOrganization();
		return instance;
	}

	public boolean checkCustomerBetInList(CustomerBet customerBet){
		for (Bet bet : betList){
			if (bet.getGame().equals(customerBet.getBetName()))
				return true;
		}
		return false;
	}
	public List<Bet> getBetList() {
		return betList;
	}
	public void addCustomer(Customer customer) {
		cList.add(customer);
	}
	public void addBet(Bet bet) {
		betList.add(bet);
	}
	//Η μέθοδος υπολογίζει τα κέρδη του παίχτη που δίδεται ως παράμετρος της.
	//Πιο συγκεκριμένα, η παράμετρος αφορά στη λίστα στοιχημάτων του εκάστοτε παίχτη
	//Για κάθε ένα στοίχημα που έχει κάνει ο παίχτης
	//Ψάχνουμε να το αντιστοιχήσουμε με τη λίστα των στοιχημάτων του BetOrganization
	//Στη συνέχεια, εφόσον το βρούμε, κοιτάζουμε αν έχει κερδίσει η επιλογή του παίχτη
	//και αν ναι, προσθέτουμε το ποσό στα κέρδη (επιστρεφόμενη τιμή της μεθόδου)

	/*
		Η μέθοδος επαναληπτικά για κάθε αγώνα που έχει ο παίχτης ελέγχει από τη λίστα όλων των αγώνων
		αν η επιλογή που έκανε ο παίχτης είναι ίδια με το αποτέλεσμα από την εκτέλεση της προσομοίωσης
		(στην κλάση GameEmulator) τότε το ποντάρισμα του αγώνα πολλαπλασιάζεται με την αντίστοιχη απόδοση
		και η μέθοδος επιστρέφει το συνολικό ποσό για τον παίχτη
	*/

	private double calculateGainsPerCustomer(IGiveBetList customer) {
		double gain = 0;

		for(CustomerBet customerBet : customer.getCustomerBetList()) {
			for (Bet bet : betList) {
				if (customerBet.getBetName().equals(bet.getGame()) &&
						GameEmulator.getGameInstance().getEmulatedGamesResults().get(customerBet.
								getBetName()).equals(customerBet.getChoice())) {
					gain += bet.getOdd() * customerBet.getStake();
				}
			}
		}
		return gain;
	}

	public void showCustomersResults(){
		System.out.println("------------------Results-------------------");
		for (Customer customer : cList){
			System.out.println("####################################");
			System.out.println("Customer name: "+customer.getName());
			System.out.println("Customer money paid: "+customer.getMoneyPlayed());
			System.out.println("Customer gains: "+String.valueOf(calculateGainsPerCustomer(customer)));
		}
		System.out.println("--------------End-of-Results----------------");
	}
	//Εγγραφή των αποτελεσμάτων των παιχτών στο αρχείο κειμένου "bet-results.txt"
	//Το αρχείο αυτό θα αντικαθίσταται από νέο αρχείο, κάθε φορά που εκτελείται το πρόγραμμα (δεν κρατάμε τα προηγούμενα δεδομένα)
	//Το format του αρχείου να είναι ίδιο με την εκτύπωση των αποτελεσμάτων (showCustomersResults)
	public void printCustomersResultsToTextFile() throws IOException {
		FileWriter fileWriter = new FileWriter("bet-results.txt");
		fileWriter.write("------------------Results-------------------\n");

		for (Customer customer : cList){
			fileWriter.write("####################################\n");
			fileWriter.write("Customer name: " + customer.getName()+"\n");
			fileWriter.write("Customer money paid: " + customer.getMoneyPlayed()+"\n");
			fileWriter.write("Customer gains: " + String.valueOf(calculateGainsPerCustomer(customer))+"\n");
		}
		fileWriter.write("--------------End-of-Results----------------");
		fileWriter.close();
	}
}
