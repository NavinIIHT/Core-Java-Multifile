package com.iiht.evaluation.yaksha.odd;

import static com.iiht.evaluation.yaksha.testutils.TestUtils.boundaryTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.businessTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.currentTest;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.exceptionTestFile;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.testReport;
import static com.iiht.evaluation.yaksha.testutils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class FindOddNumbersTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}
	
	@Test
	public void testMaxOdd() throws Exception {
		MyApp obj = new MyApp();
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(45);
		numbers.add(21);
		numbers.add(32);
		numbers.add(18);
		numbers.add(4);
		int odd =obj.findOdd(numbers);
		yakshaAssert(currentTest(), odd == 2? "true":"false", businessTestFile);
	}
	
	@Test
	public void testMaxOddForMinimal() throws Exception {
		MyApp obj = new MyApp();
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(0);
		numbers.add(0);
		numbers.add(0);
		numbers.add(0);
		numbers.add(0);
		int odd =obj.findOdd(numbers);
		yakshaAssert(currentTest(), odd == 0? "true":"false", boundaryTestFile);
	}
	
	@Test
	public void testMaxOddForNoValue() throws Exception {
		MyApp obj = new MyApp();
		List<Integer> numbers = new ArrayList<Integer>();
		int odd =obj.findOdd(numbers);
		
		yakshaAssert(currentTest(), odd == 0? "true":"false", exceptionTestFile);
	}
	
	@Test
	public void testMaxOddIfStreamIsUsed() throws Exception {
		final int count[] = new int[1];
		MyApp obj = new MyApp();
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(45);
		numbers.add(21);
		numbers.add(32);
		numbers.add(18);
		numbers.add(4);
		
		List<Integer> list = mock(List.class);
		when(list.stream()).then(new Answer<Stream<Integer>>() {

			@Override
			public Stream<Integer> answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				count[0]++;
				return numbers.stream();
			}
			
		});
		try {
			int odd =obj.findOdd(list);
		}catch(Exception ex) {
			yakshaAssert(currentTest(), 
					false,	
					businessTestFile);
			return;

		}
		yakshaAssert(currentTest(), 
				count[0] == 1? true : false,	
				businessTestFile);
	}
}
