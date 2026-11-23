package assign_6_2.controller;

import assign_6_2.model.Currency;
import java.util.ArrayList;

public class CurrencyController {
    private ArrayList<Currency> currencies;

    public CurrencyController() {
        currencies = new ArrayList<>();

        currencies.add(new Currency("USD", "US Dollar", 1.0));
        currencies.add(new Currency("EUR", "Euro", 0.92));
        currencies.add(new Currency("GBP", "British Pound", 0.79));
        currencies.add(new Currency("NPR", "Nepalese Rupee", 135.0));
    }

    public ArrayList<Currency> getCurrencies() {
        return currencies;
    }

    public double convert(double amount, Currency from, Currency to) {
        return amount / from.getRate() * to.getRate();
    }
}
