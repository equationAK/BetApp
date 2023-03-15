package com.eap.plh24;

import java.io.IOException;

public class BetMain {

	public static void main(String[] args) throws IOException {
		BetOrganization bo = BetOrganization.getInstance();
		//Κατά την προσομοίωση ΔΕΝ ζητούνται δεδομένα εισόδου στο πρόγραμμα
		//Όλα τα δεδομένα είναι hardcoded μέσα στον κώδικά σας
		//1.Δημιουργία διαθέσιμων στοιχημάτων για το ποδόσφαιρο

		bo.addBet(new FootballBet("Italy - France", 1.5));
		bo.addBet(new FootballBet("Greece - Germany", 2.5));
		//2.Δημιουργία διαθέσιμων στοιχημάτων για το μπάσκετ
		bo.addBet(new BasketballBet("Greece - Turkey", 3.5));
		bo.addBet(new BasketballBet("Spain - CSKA Moscow", 4.1));
		bo.addBet(new BasketballBet("AEK - PAOK", 3.1));
		bo.addBet(new BasketballBet("Apollon - PAO", 5.9));


		//3.Δημιουργία παιχτών
		Customer customer1 = new Customer("Aris");
		Customer customer2 = new GoldCustomer("Bill");
		Customer customer3 = new PlatinumCustomer("Nick");
		Customer customer4 = new Customer("Chara");

		//4.Δημιουργία στοιχημάτων των παιχτών
		customer1.addCustomerBet(new CustomerBet("Apollon - PAO", "Football", 100, "1"));
		customer1.addCustomerBet(new CustomerBet("Italy - France", "Football", 50, "2"));
		customer1.addCustomerBet(new CustomerBet("AEK - PAOK", "Football", 50, "X"));
		customer2.addCustomerBet(new CustomerBet("Greece - Germany", "Football", 200, "1"));
		customer2.addCustomerBet(new CustomerBet("Apollon - PAO", "Football", 200, "2"));
		customer2.addCustomerBet(new CustomerBet("AEK - PAOK", "Football", 200, "X"));
		customer3.addCustomerBet(new CustomerBet("Apollon - PAO", "Football", 500, "1"));
		customer3.addCustomerBet(new CustomerBet("Spain - CSKA Moscow", "Basketball", 500, "2"));
		customer4.addCustomerBet(new CustomerBet("Italy - France","Football",100,"X"));
		//5.Προσθήκη παιχτών στο σύστημα
		bo.addCustomer(customer1);
		bo.addCustomer(customer2);
		bo.addCustomer(customer3);
		bo.addCustomer(customer4);

		//6.Προσομοίωση αγώνων
		GameEmulator gameEmulator = GameEmulator.getGameInstance();
		gameEmulator.doGameEmulation();

		//7.Προβολή συνολικών αποτελεσμάτων παιχτών
		bo.showCustomersResults();
		//8.Και εγγραφή αυτών σε αρχείο κειμένου
		bo.printCustomersResultsToTextFile();
	}
}
