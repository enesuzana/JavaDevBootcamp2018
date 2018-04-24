package com.company.service;

import com.company.calculator.InsurancePolicyCalculator;
import com.company.dao.VehicleInfoDao;
import com.company.dao.VehicleInfoPlainFileDao;
import com.company.formula.Formula;
import com.company.model.VehicleInfo;
import com.company.vehicle.Vehicle;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static com.company.service.ConversionUtils.getVehicle;

public final class InsuranceCalculatorService {
    private String filePath;

    public InsuranceCalculatorService(String filePath) {
        this.filePath = "C:\\Users\\Cafedona\\java bootcamp\\examples\\VehiclesDatabase.txt";

    }

    public List<InsuranceCalculationResult> calculateAll() {
        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;

        final VehicleInfoDao vehicleInfoDao = new VehicleInfoPlainFileDao(this.filePath);

        final List<VehicleInfo> vehicleInfos = vehicleInfoDao.getAllVehicles();

        final List<InsuranceCalculationResult> resultList = new LinkedList<>();

        if (vehicleInfos.isEmpty()) {
            return Collections.emptyList();
        } else {
            for (VehicleInfo info : vehicleInfos) {

                final Vehicle vehicle = getVehicle(info.getVehicleTypeName(), info.getAge(),
                        info.getNumberOfMiles(), info.isDiesel());

                final Formula formula = Formula.valueOf(info.getVehicleTypeFormula());

                final int totalCost = calculator.calculate(vehicle, formula);

                final InsuranceCalculationResult result = new InsuranceCalculationResult(info.getVehicleTypeName(), info.getId(), totalCost);

                resultList.add(result);

            }

            return resultList;
        }

    }

}