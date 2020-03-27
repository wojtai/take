package put.take.components;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class CurrencyConverter {

    public static final double EUR_PLN = 4.3;

    public double plnToEur(double pln) {
        return pln/EUR_PLN;
    }

    public double eurToPln(double eur) {
        return eur*EUR_PLN;
    }
}
