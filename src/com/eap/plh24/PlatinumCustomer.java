package com.eap.plh24;

public class PlatinumCustomer extends Customer{

    /*Οι παίχτες Platinum αντιστοιχούν στην κλάση PlatinumCustomer,
      υποκλάση της Customer, με μέγιστο επιτρεπτό όριο πονταρίσματος 2000.*/

    // ο constructor της κλάσης καλεί τον constructor της υπέρ-κλάσης
    public PlatinumCustomer(String n) {
        super(n);
    }

    // η μέθοδος διαφοροποιείται για τα αντικείμενα της κλάσης επιστρέφοντας διαφορετικό ύψος
    // στο μέγιστο ποσό πονταρίσματος (2000 για τους Platinum αντί του 100 που έχουν οι απλοί)
    @Override
    public int getMaxStake() {
        return 2000;
    }
}


