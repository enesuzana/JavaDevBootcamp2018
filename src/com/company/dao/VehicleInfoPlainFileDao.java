package com.company.dao;

import com.company.model.VehicleInfo;
import com.company.vehicle.Bus;
import com.company.vehicle.Car;
import com.company.vehicle.Tipper;
import com.company.vehicle.Vehicle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleInfoPlainFileDao implements VehicleInfoDao {
    private final String filePath = "VehiclesDatabase.txt";
    private static final String SEPARATOR = ";";
    private static final int VEHICLE_ID = 0;
    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;

    private static final int VEHICLE_FORMULA = 2;

    @Override
    public List<VehicleInfo> getAllVehicles() {
        List<VehicleInfo> vehicleInfos = new ArrayList<>();


        final File inputFile = new File("C:\\Users\\Cafedona\\java bootcamp\\examples\\VehiclesDatabase.txt");

        try {
            final InputStream inputStream = new FileInputStream(inputFile);
            final Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                final String[] tokens = line.split(SEPARATOR);


                final VehicleInfo vehicle = new VehicleInfo(tokens[VEHICLE_ID],tokens[VEHICLE_TYPE], tokens[VEHICLE_FORMULA],
                        Integer.parseInt(tokens[VEHICLE_AGE]),
                        Long.parseLong(tokens[VEHICLE_MILES]), Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]));
                vehicleInfos.add(vehicle);
            }
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }

        return vehicleInfos;
    }


   /* private static VehicleInfo getVehicle(String vehicleName, int age, long numberOfMiles, boolean isDiesel){
        final String carClassName = Car.class.getSimpleName().toUpperCase();
        final String busClassName = Bus.class.getSimpleName().toUpperCase();
        final String tipperClassName = Tipper.class.getSimpleName().toUpperCase();
       return new Vehicle( age, numberOfMiles, isDiesel);
    }*/


}

