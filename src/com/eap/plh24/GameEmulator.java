package com.eap.plh24;

import java.util.*;

//Η συγκεκριμένη κλάση χρησιμοποιείται κατά την εκτέλεση του προγράμματος, για την τυχαία παραγωγή των αποτελεσμάτων των αγώνων.
public class GameEmulator {
	//Αντικείμενο που μπορεί να χρησιμοποιηθεί για την παραγωγή τυχαίων αριθμών
    Random r = new Random();
	//Η συγκεκριμένη δομή HashMap θα μας βοηθήσει να αντιστοιχήσουμε κάθε αγώνα με ένα αποτέλεσμα.
	//Συγκεκριμένα, για κάθε μοναδικό όνομα αγώνα (πρώτη παράμετρος String),
	//θα αντιστοιχούμε ένα μονάδικο αποτέλεσμα (1-Χ-2) ή (1-2), ανάλογα με το είδος του αγώνα (ποδόσφαιρο ή μπάσκετ)
    private final Map<String,String> emulatedGamesResults = new HashMap<>();
    //Διαθέσιμες επιλογές για ποδόσφαιρο
    private final String[] footballChoices = FootballBet.getChoices().toArray(new String[0]);
    //Διαθέσιμες επιλογές για μπάσκετ
    private final String[] basketballChoices = BasketballBet.getChoices().toArray(new String[0]);

    //Η μέθοδος αυτή παράγει τα δεδομένα του HashMap "emulatedGamesResults"
	//π.χ. ότι στον αγώνα ποδοσφαίρου "Βραζιλία-Ν.Κορέα" αντιστοιχεί το αποτέλεσμα "1"
    /* συγκεκριμένα η μέθοδος επαναληπτικά για κάθε ποντάρισμα (αντικείμενο τύπου Bet) από
       τη λίστα των στοιχημάτων (η λίστα καλείται από τη μέθοδο getBetList) ελέγχει αν τα πονταρίσματα
       είναι ποδοσφαίρου ή μπάσκετ (μέσω της instanceOf) και ανάλογα τα των τύπο τους μέσω της μεθόδου nextInt
       με τυχαίο τρόπο (από το αντικείμενο r - random) επιλέγει από της δυνατές επιλογές για το αποτέλεσμα του
       αγώνα. Το ζευγάρι τιμών (όνομα αγώνα και τυχαίο αποτέλεσμα) τα εισάγει σε ένα HashMap το οποίο αποτελεί
       την εικονική έκβαση των αγώνων για να γίνει η σύγκριση με τα πονταρίσματα των παιχτών.
    */
    public void doGameEmulation(){
        for(Bet bet : BetOrganization.getInstance().getBetList()) {
            if (bet instanceof FootballBet)
                emulatedGamesResults.put(bet.getGame(), footballChoices[(r.nextInt(footballChoices.length))]);
            else if (bet instanceof BasketballBet)
                emulatedGamesResults.put(bet.getGame(), basketballChoices[(r.nextInt(basketballChoices.length))]);
        }
    }

    public Map<String, String> getEmulatedGamesResults() {
        return emulatedGamesResults;
    }

    private static GameEmulator gameInstance = new GameEmulator();

    // ο constructor είναι private για να μην μπορεί η κλάση να γίνει instantiated
    private GameEmulator(){}

    // μέθοδος λήψης του μοναδικού αντικειμένου της GameEmulator
    public static GameEmulator getGameInstance(){
        if (gameInstance == null)
            gameInstance = new GameEmulator();
        return gameInstance;
    }


}
