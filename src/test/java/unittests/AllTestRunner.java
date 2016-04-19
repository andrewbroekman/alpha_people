package unittests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AllTestRunner
{

	public static void main(String[] args)
	{
		Result results = JUnitCore.runClasses(PersonImplementationTest.class);
		if (results.getFailureCount() != 0)
		{
			System.out.println("(" + results.getFailureCount()+ ") Tests Failed:\n ===========================");
			for (Failure resultFailure : results.getFailures())
			{
				System.out.println(resultFailure.toString());
				System.out.println("------------------------\n");
			}
		}
		else
		{
			System.out.println("All Tests Succeeded. \n ==========================");
		}
		
	}

}
