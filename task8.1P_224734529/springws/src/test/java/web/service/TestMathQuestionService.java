package web.service;

import org.junit.Assert;


import org.junit.Test;

import web.service.MathQuestionService;

public class TestMathQuestionService {

	@Test
	public void testTrueAdd() {
		Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
	}

	@Test
	public void testAddNumber1Empty() {
		Assert.assertNull(MathQuestionService.q1Addition("", "2"));
	}	
	@Test
	public void testQ1AdditionSecondNumberEmpty() {
		Assert.assertNull(MathQuestionService.q1Addition("1", ""));
	}

	@Test
	public void testQ1AdditionInvalidTextInput() {
		Assert.assertNull(MathQuestionService.q1Addition("abc", "2"));
	}

	@Test
	public void testQ2SubtractionValidNumbers() {
		Assert.assertEquals(Double.valueOf(3.0), MathQuestionService.q2Subtraction("5", "2"));
	}

	@Test
	public void testQ2SubtractionFirstNumberEmpty() {
		Assert.assertNull(MathQuestionService.q2Subtraction("", "2"));
	}

	@Test
	public void testQ2SubtractionSecondNumberEmpty() {
		Assert.assertNull(MathQuestionService.q2Subtraction("5", ""));
	}

	@Test
	public void testQ2SubtractionInvalidTextInput() {
		Assert.assertNull(MathQuestionService.q2Subtraction("five", "2"));
	}

	@Test
	public void testQ3MultiplicationValidNumbers() {
		Assert.assertEquals(Double.valueOf(12.0), MathQuestionService.q3Multiplication("3", "4"));
	}

	@Test
	public void testQ3MultiplicationEmptyInput() {
		Assert.assertNull(MathQuestionService.q3Multiplication("", "4"));
	}
}
