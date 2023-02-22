package Lab8;

    import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import java.util.List;
import static org.junit.Assert.assertEquals;

    public class CalculationSteps {

        private List<Integer> numbers;
        private int result;

        @Given("a list of numbers")
        public void a_list_of_numbers(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @When("I multiply them")
        public void i_multiply_them() {
            result = 1;
            for (int num : numbers) {
                result *= num;
            }
        }

        @Then("should I get {int}")
        public void should_i_get(Integer expectedValue) {
            assertEquals(expectedValue.intValue(), result);
        }
    }


