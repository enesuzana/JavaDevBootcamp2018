package com.company;

import com.company.calculator.InsurancePolicyCalculator;
import com.company.formula.BusBasicFormula;
import com.company.formula.CarBasicFormula;
import com.company.Formula;
import com.company.formula.TipperBasicFormula;
import com.company.vehicle.Bus;
import com.company.vehicle.Car;
import com.company.vehicle.Tipper;
import com.company.vehicle.Vehicle;

public class MainApp {

    public static void main(String[] args) {
        final Vehicle joesCar = new Car(5, 200000, true, "auto");

        final Vehicle stevesBus = new Bus(3,100000,true, 31);

        final Vehicle petersTipper = new Tipper(6, 80000, false, 15);

        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        final Formula carBasicFormula = new CarBasicFormula();
        final Formula busBasicFormula = new BusBasicFormula();
        final Formula tipperBasicFormula = new TipperBasicFormula();

        final int joesInsurancePolicyCost = calculator.calculate(joesCar, Formula.CAR_BASIC_FORMULA);

        final int stevesInsurancePolicyCost = calculator.calculate(stevesBus, Formula.BUS_BASIC_FORMULA);

        final int petersInsurancePolicyCost = calculator.calculate(petersTipper, Formula.TIPPER_BASIC_FORMULA);


        System.out.println("Joe's policy cost is:" + joesInsurancePolicyCost);

        System.out.println("Steve's policy cost is:" + stevesInsurancePolicyCost);

        System.out.println("Peter's policy cost is:" + petersInsurancePolicyCost);
    }
}
