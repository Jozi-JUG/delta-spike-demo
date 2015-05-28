package com.bbd.test;

import com.bbd.test.data.StudentDAOTest;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestSuiteRunner;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(CdiTestSuiteRunner.class)
@Suite.SuiteClasses({StudentDAOTest.class})
public class CdiSuiteLevelTest {
}