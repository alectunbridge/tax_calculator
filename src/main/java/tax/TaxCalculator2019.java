package tax;

public class TaxCalculator2019 extends TaxCalculator {
    @Override
    public int calculateTax(Vehicle vehicle) {
        int cost;
        int co2Emissions = vehicle.getCo2Emissions();

        switch (vehicle.getFuelType()) {
            case PETROL:
                cost = calculateTaxForPetrol(co2Emissions);
                break;
            case DIESEL:
                cost = calculateTaxForDiesel(co2Emissions);
                break;
            case ALTERNATIVE_FUEL:
                cost = calculateTaxForAlternativeFuel(co2Emissions);
                break;
            case ELECTRIC:
                cost = calculateTaxForElectric(co2Emissions);
                break;
            default:
                throw new IllegalStateException("The supplied fuel type: " + vehicle.getFuelType() + " was not recognised.");
        }

        return cost;
    }

    private int calculateTaxForPetrol(int co2Emissions) {
        int cost;
        if (co2Emissions == 0) {
            cost = 0;
        } else if (co2Emissions <= 50) {
            cost = 10;
        } else if (co2Emissions <= 75) {
            cost = 25;
        } else if (co2Emissions <= 90) {
            cost = 105;
        } else if (co2Emissions <= 100) {
            cost = 125;
        } else if (co2Emissions <= 110) {
            cost = 145;
        } else if (co2Emissions <= 130) {
            cost = 165;
        } else if (co2Emissions <= 150) {
            cost = 205;
        } else if (co2Emissions <= 170) {
            cost = 515;
        } else if (co2Emissions <= 190) {
            cost = 830;
        } else if (co2Emissions <= 225) {
            cost = 1240;
        } else if (co2Emissions <= 255) {
            cost = 1760;
        } else {
            cost = 2070;
        }
        return cost;
    }

    private int calculateTaxForDiesel(int co2Emissions) {
        int cost;
        if (co2Emissions == 0) {
            cost = 0;
        } else if (co2Emissions <= 50) {
            cost = 25;
        } else if (co2Emissions <= 75) {
            cost = 105;
        } else if (co2Emissions <= 90) {
            cost = 125;
        } else if (co2Emissions <= 100) {
            cost = 145;
        } else if (co2Emissions <= 110) {
            cost = 165;
        } else if (co2Emissions <= 130) {
            cost = 205;
        } else if (co2Emissions <= 150) {
            cost = 515;
        } else if (co2Emissions <= 170) {
            cost = 830;
        } else if (co2Emissions <= 190) {
            cost = 1240;
        } else if (co2Emissions <= 225) {
            cost = 1760;
        } else if (co2Emissions <= 255) {
            cost = 2070;
        } else {
            cost = 2070;
        }
        return cost;
    }

    private int calculateTaxForAlternativeFuel(int co2Emissions) {
        int cost;
        if (co2Emissions == 0) {
            cost = 0;
        } else if (co2Emissions <= 50) {
            cost = 0;
        } else if (co2Emissions <= 75) {
            cost = 15;
        } else if (co2Emissions <= 90) {
            cost = 95;
        } else if (co2Emissions <= 100) {
            cost = 115;
        } else if (co2Emissions <= 110) {
            cost = 135;
        } else if (co2Emissions <= 130) {
            cost = 155;
        } else if (co2Emissions <= 150) {
            cost = 195;
        } else if (co2Emissions <= 170) {
            cost = 505;
        } else if (co2Emissions <= 190) {
            cost = 820;
        } else if (co2Emissions <= 225) {
            cost = 1230;
        } else if (co2Emissions <= 255) {
            cost = 1750;
        } else {
            cost = 2060;
        }
        return cost;
    }

    private int calculateTaxForElectric(int co2Emissions) {
        return 0;
    }
}