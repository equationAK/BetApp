package com.eap.plh24;

import java.util.ArrayList;
import java.util.List;

public class BasketballBet extends Bet {

    //Η κλάση περιέχει τις διαθέσιμες εκβάσεις ενός αγώνα μπάσκετ σε static final list επιλογών
	//1:Νικήτρια η πρώτη ομάδα, 2:Νικήτρια η δεύτερη ομάδα
    private static final List<String> choices = List.of("1","2");

    // ο constructor της κλάσης καλεί τον constructor της υπέρ-κλάσης
    public BasketballBet(String game, double odd) {
        super(game, odd);
    }

    //Η μέθοδος επιστρέφει τη λίστα των διαθέσιμων επιλογών για έναν αγώνα μπάσκετ
	public static List<String> getChoices() {
        return choices;
    }
}
