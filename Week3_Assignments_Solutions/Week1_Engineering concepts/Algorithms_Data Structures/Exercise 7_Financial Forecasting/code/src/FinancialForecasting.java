import java.util.HashMap;
import java.util.Map;

/**
 * A tool for financial forecasting using recursive algorithms.
 */
public class FinancialForecasting {

    /**
     * Calculates the future value of an investment using a simple recursive approach.
     *
     * @param presentValue The initial amount of money.
     * @param growthRate   The annual growth rate (e.g., 0.05 for 5%).
     * @param years        The number of years to forecast into the future.
     * @return The calculated future value.
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        // Base Case: If there are no years left to forecast, the future value is the present value.
        if (years == 0) {
            return presentValue;
        }

        // Recursive Step: Calculate the value for the previous year and apply this year's growth.
        double previousYearValue = calculateFutureValue(presentValue, growthRate, years - 1);
        return previousYearValue * (1 + growthRate);
    }

    /**
     * Calculates the future value using an optimized recursive approach with memoization.
     * This avoids re-computation in more complex models with overlapping subproblems.
     *
     * @param presentValue The initial amount of money.
     * @param growthRate   The annual growth rate.
     * @param years        The number of years to forecast.
     * @param memo         A map to store (cache) results of previously computed years.
     * @return The calculated future value.
     */
    public static double calculateFutureValueOptimized(double presentValue, double growthRate, int years, Map<Integer, Double> memo) {
        // Base Case: The value at year 0 is the present value.
        if (years == 0) {
            return presentValue;
        }

        // Check if the value for this year has already been computed and cached.
        if (memo.containsKey(years)) {
            return memo.get(years);
        }

        // Recursive Step: Calculate, cache, and return the value.
        double previousYearValue = calculateFutureValueOptimized(presentValue, growthRate, years - 1, memo);
        double currentValue = previousYearValue * (1 + growthRate);

        // Store the result in the memoization table before returning.
        memo.put(years, currentValue);

        return currentValue;
    }


    public static void main(String[] args) {
        double presentValue = 100000.0; // Initial investment of ₹1,00,000
        double growthRate = 0.08;       // 8% annual growth
        int years = 15;                 // Forecast for 15 years

        System.out.println("### Financial Forecasting Tool (INR) ###");
        System.out.printf("Initial Investment: Rs.%.2f%n", presentValue);
        System.out.printf("Annual Growth Rate: %.2f%%%n", growthRate * 100);
        System.out.printf("Forecasting Period: %d years%n", years);
        System.out.println("----------------------------------------");

        // --- Using the simple recursive method ---
        System.out.println("\n1. Simple Recursive Calculation:");
        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Predicted Future Value: Rs.%.2f%n", futureValue);

        // --- Using the optimized recursive method with memoization ---
        System.out.println("\n2. Optimized Recursive Calculation (with Memoization):");
        double futureValueOptimized = calculateFutureValueOptimized(presentValue, growthRate, years, new HashMap<>());
        System.out.printf("Predicted Future Value: Rs.%.2f%n", futureValueOptimized);
    }
}