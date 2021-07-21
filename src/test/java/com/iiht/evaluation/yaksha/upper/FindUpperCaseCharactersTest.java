package com.iiht.evaluation.yaksha.upper;

import static com.iiht.evaluation.yaksha.testutils.TestUtils.boundaryTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.businessTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.currentTest;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.exceptionTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.testReport;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.yakshaAssert;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
public class FindUpperCaseCharactersTest {
	@AfterAll
	public static void afterAll() {
		testReport();
	}
	
	@Test
	public void testFindUpper() throws Exception {
		MyApp obj = new MyApp();
		String str = "HeLlO AlL";
		int upper = obj.findUpper(str);
		yakshaAssert(currentTest(), upper == 5? true:false, businessTestFile);
	}
	
	@Test
	public void testFindUpperForMinimalValue() throws Exception {
		MyApp obj = new MyApp();
		String str = "hello all";
		int upper = obj.findUpper(str);
		yakshaAssert(currentTest(), upper == 0? true:false, boundaryTestFile);
	}
	
	@Test
	public void testFindUpperForMaximumValue() throws Exception {
		MyApp obj = new MyApp();
		String str = "HELLO ALL";
		int upper = obj.findUpper(str);
		yakshaAssert(currentTest(), upper == 8? true:false, boundaryTestFile);
	}
	
	@Test
	public void testFindUpperForNoValue() throws Exception {
		MyApp obj = new MyApp();
		String str = "";
		int upper = obj.findUpper(str);
		yakshaAssert(currentTest(), upper == 0? true:false, exceptionTestFile);
	}
	
	
}
