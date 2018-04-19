package com.company.calculator;

import com.company.formula.Formula;
import com.company.vehicle.Vehicle;

public final class InsurancePolicyCalculator {
    public static final InsurancePolicyCalculator INSTANCE = new InsurancePolicyCalculator();

    private InsurancePolicyCalculator(){
    }
    public int calculate(Vehicle vehicle, Formula formula){
        return formula.calculate(vehicle);
    }
}
