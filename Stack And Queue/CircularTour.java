package com.day2;
public class CircularTour {

    // Function to find the starting petrol pump
    public static int findStartingPump(int[] petrol, int[] distance) {
        int totalPetrol = 0;
        int totalDistance = 0;
        int currentPetrol = 0;
        int startIndex = 0;

        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];

            currentPetrol += petrol[i] - distance[i];

            // If at any point current petrol is less than 0, reset the start index
            // and start from the next pump
            if (currentPetrol < 0) {
                startIndex = i + 1;
                currentPetrol = 0; // reset the current petrol
            }
        }

        // If the total petrol is greater than or equal to the total distance, a tour is possible
        return totalPetrol >= totalDistance ? startIndex : -1;
    }

    public static void main(String[] args) {
        // Example petrol pumps with petrol available and distance to next pump
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {7, 5, 3, 5};

        // Find the starting petrol pump
        int startPump = findStartingPump(petrol, distance);

        if (startPump == -1) {
            System.out.println("No tour is possible.");
        } else {
            System.out.println("The tour can start at pump index: " + startPump);
        }
    }
}
