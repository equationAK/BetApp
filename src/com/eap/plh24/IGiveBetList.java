package com.eap.plh24;

import java.util.List;

public interface IGiveBetList {

    // η μέθοδος που υλοποιείται στην κλάση customer και επιστρέφει λίστα με τα πονταρίσματα
    // των παιχτών (επιστρέφει λίστα με αντικείμενα τύπου customerBet
    List<CustomerBet> getCustomerBetList();
}
