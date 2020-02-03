package com.example.droneapp.APIClient;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlightHelper {
    //    public static final String BASE_URL = "http://10.0.3.2/api/";
    public static final String BASE_URL = "https://391b5808-8024-4864-bda1-992db1ce4e6a.mock.pstmn.io/";

    public static List<FlightPOJO> getFinishedFlights(List<FlightPOJO> flights) {
        List<FlightPOJO> completed = filterByState(flights, "COMPLETE");
        List<FlightPOJO> errored = filterByState(flights, "ERROR");
        return Stream.concat(completed.stream(), errored.stream()).collect(Collectors.toList());
    }

    public static List<FlightPOJO> getProcessingFlights(List<FlightPOJO> flights) {
        return filterByState(flights, "PROCESSING");
    }

    public static List<FlightPOJO> getPendingFlights(List<FlightPOJO> flights) {
        return filterByState(flights, "WAITING");
    }

    private static List<FlightPOJO> filterByState(List<FlightPOJO> flights, String state) {
        return flights.stream().filter(flight -> flight.getState().equals(state)).collect(Collectors.toList());
    }
}
