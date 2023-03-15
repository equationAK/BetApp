package com.eap.plh24;

import java.util.List;

public class CustomerBet {
    //Λίστα που περιέχει τις δύο διαθέσιμες επιλογές αγώνα, ποδοσφαίρου και μπάσκετ αντίστοιχα
    private final List<String> availableBetTypes = List.of("Football", "Basketball");
    //Το μοναδικό όνομα του αγώνα
    //Κατά τη δημιουργία αντικειμένων της εν λόγω κλάσης, δεν ελέγχουμε αν το όνομα αγώνα που έδωσε το παίχτης είναι σωστό.
    //Αυτό θα ελεγχθεί αργότερα από την κλάση BetOrganization
    private String betName;
    //Το ποσό του πονταρίσματος σε ευρώ (χωρίς δεκαδικά)
    private int stake;
    //Η επιλογή πονταρίσματος του παίχτη. Όπως αναφέρθηκε και παραπάνω πρέπει να ελεγχθεί, ανάλογα με τον τύπο του αγώνα.
    //Οι διαθέσιμες εκβάσεις ενός αγώνα μπάσκετ είναι, 1:Νικήτρια η πρώτη ομάδα, 2:Νικήτρια η δεύτερη ομάδα
    //Οι διαθέσιμες εκβάσεις ενός αγώνα ποδοσφαίρου είναι, 1:Νικήτρια η πρώτη ομάδα, Χ:Ισοπαλία, 2:Νικήτρια η δεύτερη ομάδα
    private String choice;
    //Η παράμετρος "betType" είναι ο τύπος του αγώνα. Μπορεί να πάρει μόνο μια εκ των 2 τιμών: "Football" ή "Basketball"
    //Η δοθείσα τιμή του String betType που δίνεται κατά την προσομοίωση θα ελέγχεται στον constructor της κλάσης CustomerBet
    //και παράλληλα θα ελέγχεται αν η επιλογή, "choice", αφορά στις διαθέσιμες επιλογές του εκάστοτε τύπου αγώνα.

    /*
     ο κατασκευαστής της κλάσης κάνει έλεγχο του τύπου του αγώνα (String betType) συγκρίνοντας με
     τις διαθέσιμες επιλογές (λίστα availableBetTypes) σε περίπτωση που η επιλογή είναι εκτός των
     διαθέσιμων γίνεται exception. Αν όλα είναι εντάξει τότε δημιουργείται κανονικά το αντικείμενο
     customerBet
      */
    public CustomerBet(String betName, String betType, int stake, String choice) {
        this.betName = betName;
        this.stake = stake;
        if(availableBetTypes.contains(betType)) {
            switch (betType) {
                case "Football":
                    if (FootballBet.getChoices().contains(choice)) {
                        this.choice = choice;
                        break;
                    }
                case "Basketball":
                    if (BasketballBet.getChoices().contains(choice)) {
                        this.choice = choice;
                        break;
                    }
                default:
                    break;
            }
        } else
            throw new IllegalArgumentException("Η επιλογή τύπου " + betType + " δεν είναι διαθέσιμη");
    }

    public String getBetName() {
        return betName;
    }
    public int getStake() {
        return stake;
    }
    public String getChoice() {
        return choice;
    }
}
