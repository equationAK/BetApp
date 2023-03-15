package com.eap.plh24;

import java.util.ArrayList;
import java.util.List;

public class FootballBet extends Bet {

    //Η κλάση περιέχει τις διαθέσιμες εκβάσεις ενός αγώνα ποδοσφαίρου σε static final list επιλογών
    //1:Νικήτρια η πρώτη ομάδα, Χ:Ισοπαλία, 2:Νικήτρια η δεύτερη ομάδα
    private static final List<String> choices = List.of("1","2","X");

    // ο constructor της κλάσης καλεί τον constructor της υπέρ-κλάσης
    public FootballBet(String game, double odd) {
        super(game, odd);
    }

    //Η μέθοδος επιστρέφει τη λίστα των διαθέσιμων επιλογών για έναν αγώνα ποδοσφαίρου
	public static List<String> getChoices() {
        return choices;
    }
}
