package com.company;
import com.company.calculator.InsurancePolicyCalculator;
import com.company.dao.VehicleDao;
import com.company.dao.VehicleInfoDao;
import com.company.dao.VehicleInfoPlainFileDao;
import com.company.formula.Formula;
import com.company.model.VehicleInfo;
import com.company.vehicle.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
public class MainApp {
    private static final String SEPARATOR = ";";
    private static final int VEHICLE_ID = 0;
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;
    private static final int VEHICLE_FORMULA = 2;
    private static final String OUTPUT_FORMAT = "Vehicle with id %s has total cost %d";

    public static void main(String[] args) {
        final InsurancePolicyCalculator calculator = InsurancePolicyCalculator.INSTANCE;
        if ( args.length >= 1){
            VehicleInfoDao vehicleInfoPlainFileDao = new VehicleInfoPlainFileDao();
            List<VehicleInfo> list = vehicleInfoPlainFileDao.getAllVehicles();
    for (VehicleInfo vehicleInfo:list ){



                    final Formula formula = Formula.valueOf(vehicleInfo.getVehicleTypeFormula());
        Vehicle vehicle= getVehicle(vehicleInfo);
                    final int totalCost = calculator.calculate(vehicle, formula);

                    final String output = String.format(OUTPUT_FORMAT, vehicleInfo.getId(), totalCost);

                    System.out.println(output);

                }

        } else{
            System.out.println("No Arguments!");
        }
    }
    private static Vehicle getVehicle(VehicleInfo vehicleInfo){
        final String carClassName = Car.class.getSimpleName().toUpperCase();
        final String busClassName = Bus.class.getSimpleName().toUpperCase();
        final String tipperClassName = Tipper.class.getSimpleName().toUpperCase();
        if (vehicleInfo.getVehicleTypeName().equals(carClassName)){
            return new Car(vehicleInfo.getAge(), vehicleInfo.getNumberOfMiles(), vehicleInfo.isDiesel());
        }
        if (vehicleInfo.getVehicleTypeName().equals(busClassName)){
            return new Bus(vehicleInfo.getAge(), vehicleInfo.getNumberOfMiles(), vehicleInfo.isDiesel());
        }
        if (vehicleInfo.getVehicleTypeName().equals(tipperClassName)){
            return new Bus(vehicleInfo.getAge(), vehicleInfo.getNumberOfMiles(), vehicleInfo.isDiesel());
        }
        return null;
    }
}
