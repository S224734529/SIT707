package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class WeatherAndMathUtilsTest {
	
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
	public void testFalseNumberIsEven() {
		Assert.assertFalse(WeatherAndMathUtils.isEven(3));
	}

	@Test
	public void testTrueNumberIsEven() {
		Assert.assertTrue(WeatherAndMathUtils.isEven(4));
	}

	@Test
	public void testCancelWeatherAdviceByDangerousWind() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(70.1, 0.0));
	}

	@Test
	public void testCancelWeatherAdviceByDangerousRain() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(10.0, 6.1));
	}

	@Test
	public void testCancelWeatherAdviceByCombinedConcerningConditions() {
		Assert.assertEquals("CANCEL", WeatherAndMathUtils.weatherAdvice(46.0, 4.1));
	}

	@Test
	public void testWarnWeatherAdviceByWindOnly() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(46.0, 1.0));
	}

	@Test
	public void testWarnWeatherAdviceByRainOnly() {
		Assert.assertEquals("WARN", WeatherAndMathUtils.weatherAdvice(10.0, 4.1));
	}

	@Test
	public void testAllClearWeatherAdvice() {
		Assert.assertEquals("ALL CLEAR", WeatherAndMathUtils.weatherAdvice(20.0, 2.0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWeatherAdviceNegativeWindThrowsException() {
		WeatherAndMathUtils.weatherAdvice(-1.0, 2.0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWeatherAdviceNegativeRainThrowsException() {
		WeatherAndMathUtils.weatherAdvice(10.0, -1.0);
	}

	@Test
	public void testIsPrimeForPrimeNumber() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(7));
	}

	@Test
	public void testIsPrimeForCompositeNumber() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(8));
	}

	@Test
	public void testIsPrimeForOne() {
		Assert.assertFalse(WeatherAndMathUtils.isPrime(1));
	}

	@Test
	public void testIsPrimeForTwo() {
		Assert.assertTrue(WeatherAndMathUtils.isPrime(2));
	}
}