package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


public class DateUtilTest {
	
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
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        int oldDay = date.getDay();
        date.increment();
        System.out.println(date);
        if (oldDay < 31) {
        	Assert.assertEquals(oldDay + 1, date.getDay());
        	Assert.assertEquals(1, date.getMonth());
        } else {
        	Assert.assertEquals(1, date.getDay());
        	Assert.assertEquals(2, date.getMonth());
        }
	}
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("testMinJanuary1ShouldIncrementToJanuary2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("testMinJanuary1ShouldDecrementToDecember31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}
	
	@Test
	public void testApril30ShouldIncrementToMay1() {
		DateUtil date = new DateUtil(30, 4, 2024);
		System.out.println("testApril30ShouldIncrementToMay1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(5, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMay31ShouldIncrementToJune1() {
		DateUtil date = new DateUtil(31, 5, 2024);
		System.out.println("testMay31ShouldIncrementToJune1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(6, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testFebruary28NonLeapYearShouldIncrementToMarch1() {
		DateUtil date = new DateUtil(28, 2, 2023);
		System.out.println("testFebruary28NonLeapYearShouldIncrementToMarch1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}
	
	@Test
	public void testFebruary28LeapYearShouldIncrementToFebruary29() {
		DateUtil date = new DateUtil(28, 2, 2024);
		System.out.println("testFebruary28LeapYearShouldIncrementToFebruary29 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testFebruary29LeapYearShouldIncrementToMarch1() {
		DateUtil date = new DateUtil(29, 2, 2024);
		System.out.println("testFebruary29LeapYearShouldIncrementToMarch1 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test(expected = RuntimeException.class)
	public void testFebruary29NonLeapYearShouldBeInvalid() {
		new DateUtil(29, 2, 2023);
	}
	
	@Test(expected = RuntimeException.class)
	public void testApril31ShouldBeInvalid() {
		new DateUtil(31, 4, 2024);
	}
	
	@Test
	public void testDecember31ShouldIncrementToJanuary1NextYear() {
		DateUtil date = new DateUtil(31, 12, 2024);
		System.out.println("testDecember31ShouldIncrementToJanuary1NextYear > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2025, date.getYear());
	}
	
	@Test
	public void testMarch1LeapYearShouldDecrementToFebruary29() {
		DateUtil date = new DateUtil(1, 3, 2024);
		System.out.println("testMarch1LeapYearShouldDecrementToFebruary29 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2024, date.getYear());
	}
	
	@Test
	public void testMarch1NonLeapYearShouldDecrementToFebruary28() {
		DateUtil date = new DateUtil(1, 3, 2023);
		System.out.println("testMarch1NonLeapYearShouldDecrementToFebruary28 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(28, date.getDay());
		Assert.assertEquals(2, date.getMonth());
		Assert.assertEquals(2023, date.getYear());
	}
}