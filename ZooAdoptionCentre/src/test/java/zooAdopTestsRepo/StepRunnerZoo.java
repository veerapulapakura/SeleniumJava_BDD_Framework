package zooAdopTestsRepo;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@Cucumber.Options( 
		   
		   format = {"pretty", "json:target/json/output.json", "html:target/Destination"},
		   features = "src/test/resouce",
		   glue ={"zooAdopTestsRepo"}
		   )
public class StepRunnerZoo {
	
}

