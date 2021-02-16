package com.example.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ArraysTest.class, StringHelperTest.class})
public class SuiteTest {}
