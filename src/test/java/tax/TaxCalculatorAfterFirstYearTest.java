package tax;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static java.time.Month.APRIL;
import static org.assertj.core.api.Assertions.assertThat;
import static tax.FuelType.*;

public class TaxCalculatorAfterFirstYearTest {

    private static final LocalDate FIRST_OF_APRIL_2017 = LocalDate.of(2017, APRIL, 1);
    private TaxCalculator taxCalculator;

    @Before
    public void setUp() {
        taxCalculator = new TaxCalculator2019();
        Features.different_rates_after_first_year = true;
    }

    @After
    public void tearDown(){
        Features.different_rates_after_first_year = false;
    }

    @Test
    public void subsequentYearsTaxForPetrol() {
        Vehicle vehicle = new Vehicle(206, PETROL, FIRST_OF_APRIL_2017, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(140);
    }

    @Test
    public void subsequentYearsTaxForElectric() {
        Vehicle vehicle = new Vehicle(206, ELECTRIC, FIRST_OF_APRIL_2017, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(0);
    }

    @Test
    public void subsequentYearsTaxForAlternativeFuel() {
        Vehicle vehicle = new Vehicle(206, ALTERNATIVE_FUEL, FIRST_OF_APRIL_2017, 20000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(130);
    }
}
