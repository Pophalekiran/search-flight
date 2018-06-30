package com.example.flightnetwork.searchflights.util;

import com.example.flightnetwork.searchflights.model.Flight;
import com.opencsv.CSVReader;
import org.springframework.util.ResourceUtils;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

public class ReadFileUtil {
    private ReadFileUtil() {
    }

    private static Set<Flight> flightSet = null;

    static {
        flightSet = new HashSet<Flight>();
        Integer i = 1;
        while (i <= 2) {
            try {
                //CSVReader reader = new CSVReader(new FileReader("F:\\WorkSpace\\JavaWorkSpace\\Intellij_WorkSpace\\search-flights\\src\\main\\resources\\data\\Provider" + i + ".csv"), );
                // CSVReader reader = new CSVReader(new FileReader("F:\\WorkSpace\\JavaWorkSpace\\Intellij_WorkSpace\\search-flights\\src\\main\\resources\\data\\TestData.csv"),'\t'x );
                CSVReader reader = new CSVReader(new FileReader(ResourceUtils.getFile("classpath:data/Provider" + i + ".csv")));
                String[] nextLine;
                reader.readNext();
                while ((nextLine = reader.readNext()) != null) {
                    if (nextLine[0].contains("|")) {
                        nextLine = StringUtil.parseString(nextLine[0]);
                    }
                    Flight flight = new Flight(nextLine);
                    flightSet.add(flight);
                }
                i++;
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static Set<Flight> getFlights() {
        return flightSet;
    }
}
