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
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class VehicleInfoPlainFileDao implements VehicleInfoDao {

    private static final String SEPARATOR = ";";

    private static final int VEHICLE_TYPE = 1;
    private static final int VEHICLE_AGE = 3;
    private static final int VEHICLE_MILES = 4;
    private static final int VEHICLE_IS_DIESEL = 5;
    private static final int VEHICLE_ID = 0;
    private static final int VEHICLE_FORMULA = 2;

    private final String filePath;

    public VehicleInfoPlainFileDao(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<VehicleInfo> getAllVehicles() {
        final List<VehicleInfo> vehicles = new ArrayList<>();

        final File inputFile = new File(this.filePath);

        try {
            final InputStream inputStream = new FileInputStream(inputFile);
            final Scanner scanner = new Scanner(inputStream);

            while (scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                final String[] tokens = line.split(SEPARATOR);

                final VehicleInfo.Builder builder = VehicleInfo.builder();
                final VehicleInfo info = builder.withId(tokens[VEHICLE_ID])
                        .withVehicleTypeName(tokens[VEHICLE_TYPE])
                        .withVehicleTypeFormula(tokens[VEHICLE_FORMULA])
                        .withAge(Integer.parseInt(tokens[VEHICLE_AGE]))
                        .withNumberOfMiles(Long.parseLong(tokens[VEHICLE_MILES]))
                        .withIsDiesel(Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]))
                        .build();
                /*final VehicleInfo info = new VehicleInfo(tokens[VEHICLE_ID], tokens[VEHICLE_TYPE],
                        tokens[VEHICLE_FORMULA], Integer.parseInt(tokens[VEHICLE_AGE]),
                        Long.parseLong(tokens[VEHICLE_MILES]), Boolean.parseBoolean(tokens[VEHICLE_IS_DIESEL]));*/

                vehicles.add(info);
            }

            scanner.close();

        } catch (FileNotFoundException noFileFound) {
            return Collections.emptyList();
        }

        return vehicles;
    }
}

