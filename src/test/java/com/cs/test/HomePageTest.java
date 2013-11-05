package com.cs.test;

import org.testng.annotations.Test;

public class HomePageTest extends BaseTest
{
	@Test
	public void login()
	{
		webDriver.get("http://www.google.com");
	}
	

}
