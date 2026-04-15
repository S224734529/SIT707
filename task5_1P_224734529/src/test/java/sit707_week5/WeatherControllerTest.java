package sit707_week5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] hourlyTemperatures;
    private static int totalHours;

    @BeforeClass
    public static void setUpClass() {
        // Arrange common setup once
        wController = WeatherController.getInstance();
        totalHours = wController.getTotalHours();
        hourlyTemperatures = new double[totalHours];

        for (int i = 0; i < totalHours; i++) {
            hourlyTemperatures[i] = wController.getTemperatureForHour(i + 1);
        }
    }

    @AfterClass
    public static void tearDownClass() {
        if (wController != null) {
            wController.close();
        }
    }

    @Test
    public void testStudentIdentity() {
        String studentId = "224734529";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Senadeera Arachchige Pamuditha Rasanjana Senadeera";
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        // Arrange
        double minTemperature = Double.MAX_VALUE;
        for (double temp : hourlyTemperatures) {
            if (temp < minTemperature) {
                minTemperature = temp;
            }
        }

        // Act
        double cachedMin = wController.getTemperatureMinFromCache();

        // Assert
        Assert.assertEquals(minTemperature, cachedMin, 0.0001);
    }

    @Test
    public void testTemperatureMax() {
        // Arrange
        double maxTemperature = Double.MIN_VALUE;
        for (double temp : hourlyTemperatures) {
            if (temp > maxTemperature) {
                maxTemperature = temp;
            }
        }

        // Act
        double cachedMax = wController.getTemperatureMaxFromCache();

        // Assert
        Assert.assertEquals(maxTemperature, cachedMax, 0.0001);
    }

    @Test
    public void testTemperatureAverage() {
        // Arrange
        double sum = 0;
        for (double temp : hourlyTemperatures) {
            sum += temp;
        }
        double averageTemperature = sum / totalHours;

        // Act
        double cachedAverage = wController.getTemperatureAverageFromCache();

        // Assert
        Assert.assertEquals(averageTemperature, cachedAverage, 0.0001);
    }

    @Test
    public void testTemperaturePersist() {
        
    }
}