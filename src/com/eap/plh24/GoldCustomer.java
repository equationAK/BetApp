package com.eap.plh24;

public class GoldCustomer extends Customer {

    /* Οι παίχτες Gold αντιστοιχούν στην κλάση GoldCustomer,
       υποκλάση της Customer, με μέγιστο επιτρεπτό όριο πονταρίσματος 1000.
     */

    // ο constructor της κλάσης καλεί τον constructor της υπέρ-κλάσης
    public GoldCustomer(String n) {
        super(n);
    }

    // η μέθοδος διαφοροποιείται για τα αντικείμενα της κλάσης επιστρέφοντας διαφορετικό ύψος
    // στο μέγιστο ποσό πονταρίσματος (1000 για τους Gold αντί του 100 που έχουν οι απλοί)
    @Override
    public int getMaxStake() {
        return 1000;
    }
}
