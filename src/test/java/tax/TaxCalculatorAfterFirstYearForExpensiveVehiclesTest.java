package tax;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static java.time.Month.APRIL;
import static org.assertj.core.api.Assertions.assertThat;
import static tax.FuelType.*;

public class TaxCalculatorAfterFirstYearForExpensiveVehiclesTest {

    private static final LocalDate FIRST_OF_APRIL_2017 = LocalDate.of(2017, APRIL, 1);
    private TaxCalculator taxCalculator;

    @Before
    public void setUp() {
        taxCalculator = new TaxCalculator2019();
        Features.different_rate_for_expensive_vehicles = true;
    }

    @After
    public void tearDown() throws Exception {
        Features.different_rate_for_expensive_vehicles = false;
    }

    @Test
    public void subsequentYearsTaxForPetrolIfOver40K() {
        Vehicle vehicle = new Vehicle(206, PETROL, FIRST_OF_APRIL_2017, 50000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(450);
    }

    @Test
    public void subsequentYearsTaxForElectricIfOver40K() {
        Vehicle vehicle = new Vehicle(206, ELECTRIC, FIRST_OF_APRIL_2017, 50000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(310);
    }

    @Test
    public void subsequentYearsTaxForAlternativeFuelIfOver40K() {
        Vehicle vehicle = new Vehicle(206, ALTERNATIVE_FUEL, FIRST_OF_APRIL_2017, 50000);
        assertThat(taxCalculator.calculateTax(vehicle)).isEqualTo(440);
    }
}
