package com.example.junit;

import org.junit.*;
import static org.junit.Assert.*;

public class StringHelperTest {

  StringHelper helper;

  @BeforeClass
  public static void beforeClass() {
    System.out.println("Before all test methods");
  }

  @Before
  public void before() {
    System.out.println("Before each test method");
    helper = new StringHelper();
  }

  @Test
  public void truncateAInFirst2Positions() {
    assertEquals("CD", helper.truncateAInFirst2Positions("AACD"));
    assertEquals("CD", helper.truncateAInFirst2Positions("ACD"));
  }

  @Test
  public void testAreFirstAndLastTwoCharactersTheSame_BasicNegativeScenario() {
    assertFalse(helper.areFirstAndLastTwoCharactersTheSame("ABCD"));
    assertTrue(helper.areFirstAndLastTwoCharactersTheSame("ABAB"));
  }

  @After
  public void after() {
    System.out.println("After each test method");
  }

  @AfterClass
  public static void afterClass() {
    System.out.println("After all test methods");
  }
}
