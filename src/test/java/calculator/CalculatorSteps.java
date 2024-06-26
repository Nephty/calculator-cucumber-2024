package calculator;

import back.calculator.*;
import back.calculator.operators.*;
import back.calculator.types.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CalculatorSteps {

//	static final Logger log = getLogger(lookup().lookupClass());

    private ArrayList<Expression> params;
    private Operation op;
    private Calculator c;
    private MathContext precision = App.getPrecision();

    @Before
    public void resetMemoryBeforeEachScenario() {
        params = null;
        op = null;
    }

// ############################### Givens ###############################

    @Given("I initialise a calculator")
    public void givenIInitialiseACalculator() {
        c = new Calculator();
    }

    // ############################### Simple operations ###############################

    @Given("an integer operation {string}")
    public void givenAnIntegerOperation(String s) {
        // Write code here that turns the phrase above into concrete actions
        params = new ArrayList<>(); // create an empty set of parameters to be filled in
        try {
            switch (s) {
                case "+" -> op = new Plus(params);
                case "-" -> op = new Minus(params);
                case "*" -> op = new Times(params);
                case "/" -> op = new Divides(params);
                case "|" -> op = new Modulus(params);
                case "sqrt" -> op = new Sqrt(params);
                case "ln" -> op = new Logarithm(params);
                case "exp" -> op = new Exponential(params);
                case "sin" -> op = new Sinus(params);
                case "cos" -> op = new Cosine(params);
                default -> fail("Unknown operation!");
            }
        } catch (IllegalConstruction e) {
            fail("Illegal construction!");
        }
    }

    @Given("a real operation {string}")
    public void givenARealOperation(String s) {
        params = new ArrayList<>();
        try {
            switch (s) {
                case "+" -> op = new Plus(params);
                case "-" -> op = new Minus(params);
                case "*" -> op = new Times(params);
                case "/" -> op = new Divides(params);
                case "sqrt" -> op = new Sqrt(params);
                case "ln" -> op = new Logarithm(params);
                case "exp" -> op = new Exponential(params);
                case "sin" -> op = new Sinus(params);
                case "cos" -> op = new Cosine(params);
                default -> throw new IllegalArgumentException("Unknown operation!");
            }
        } catch (back.calculator.IllegalConstruction e) {
            throw new IllegalArgumentException("Illegal construction!");
        }
    }

    // The string in the Given annotation shows how to use regular expressions...
    // In this example, the notation d+ is used to represent numbers, i.e. nonempty sequences of digits
    @Given("^the sum of two numbers (\\d+) and (\\d+)$")
    // The alternative, and in this case simpler, notation would be:
    // @Given("the sum of two numbers {int} and {int}")
    public void givenTheSum(int n1, int n2) {
        try {
            params = new ArrayList<>();
            params.add(new MyNumber(n1));
            params.add(new MyNumber(n2));
            op = new Plus(params);
        } catch (IllegalConstruction e) {
            fail("Error in construction of the operation!");
        }
    }

    @Given("a complex operation {string}")
    public void givenAComplexOperation(String s) {
        // Write code here that turns the phrase above into concrete actions
        params = new ArrayList<>(); // create an empty set of parameters to be filled in
        try {
            switch (s) {
                case "+" -> op = new Plus(params);
                case "-" -> op = new Minus(params);
                case "*" -> op = new Times(params);
                case "/" -> op = new Divides(params);
                case "|" -> op = new Modulus(params);
                case "sin" -> op = new Sinus(params);
                case "cos" -> op = new Cosine(params);
                case "exp" -> op = new Exponential(params);
                case "sqrt" -> op = new Sqrt(params);
                case "ln" -> op = new Logarithm(params);
                default -> throw new IllegalArgumentException("Unknown operation!");
            }
        } catch (back.calculator.IllegalConstruction e) {
            throw new IllegalArgumentException("Illegal construction!");
        }
    }

    // ############################### Nested operations ###############################

    // The following example shows how to use a DataTable provided as input.
    // The example looks slightly complex, since DataTables can take as input
    //  tables in two dimensions, i.e. rows and lines. This is why the input
    //  is a list of lists.
    @Given("the following list of integer numbers")
    public void givenTheFollowingListOfNumbers(List<List<String>> numbers) {
        params = new ArrayList<>();
        // Since we only use one line of input, we use get(0) to take the first line of the list,
        // which is a list of strings, that we will manually convert to integers:
        numbers.get(0).forEach(n -> params.add(new MyNumber(Integer.parseInt(n))));
        op = null;
    }

    // The list of numbers is intended to be used as a list of parameters for the operation
    // The goal is to test if a nested operation is correctly represented in a given notation
    @Given("the sum of the following list of numbers")
    public void theSumOfTheFollowingListOfNumbers(List<List<String>> numbers) {
        params = new ArrayList<>();
        numbers.get(0).forEach(n -> params.add(new MyNumber(Integer.parseInt(n))));
        try {
            op = new Plus(params);
        } catch (IllegalConstruction e) {
            fail("Error in construction of the sum");
        }
    }

    @Given("the difference of the following list of numbers")
    public void theDifferenceOfTheFollowingListOfNumbers(List<List<String>> numbers) {
        params = new ArrayList<>();
        numbers.get(0).forEach(n -> params.add(new MyNumber(Integer.parseInt(n))));
        try {
            op = new Minus(params);
        } catch (IllegalConstruction e) {
            fail("Error in construction of the difference");
        }
    }

    @Given("the product of the following list of numbers")
    public void theProductOfTheFollowingListOfNumbers(List<List<String>> numbers) {
        params = new ArrayList<>();
        numbers.get(0).forEach(n -> params.add(new MyNumber(Integer.parseInt(n))));
        try {
            op = new Times(params);
        } catch (IllegalConstruction e) {
            fail("Error in construction of the product");
        }
    }

    @Given("the quotient of the following list of numbers")
    public void theQuotientOfTheFollowingListOfNumbers(List<List<String>> numbers) {
        params = new ArrayList<>();
        numbers.get(0).forEach(n -> params.add(new MyNumber(Integer.parseInt(n))));
        try {
            op = new Divides(params);
        } catch (IllegalConstruction e) {
            fail("Error in construction of the quotient");
        }
    }

    // ############################### Given an expression ###############################

    @Given("the following expression {string}")
    public void givenTheExpression(String s) {
        c = new Calculator();
        params = new ArrayList<>();
        params.add(c.read(s));
    }

// ############################### Then ###############################

    // ########################### Evaluation of the operation ###############################

    @Then("^the (.*) is (\\d+)$")
    public void thenTheOperationIs(String s, int val) {
        try {
            switch (s) {
                case "sum" -> op = new Plus(params);
                case "product" -> op = new Times(params);
                case "quotient" -> op = new Divides(params);
                case "difference" -> op = new Minus(params);
                default -> fail("Unknown operation!");
            }
            assertEquals(new MyNumber(val), c.eval(op));
        } catch (IllegalConstruction e) {
            fail("Error in construction of the operation");
        }
    }

    @Then("the operation evaluates to {int}")
    public void thenTheOperationEvaluatesTo(int val) {
        assertEquals(new MyNumber(val), c.eval(op));
    }

    @Then("the operation evaluates to {string}")
    public void thenTheOperationEvaluatesTo(String val) {
        assertEquals(val, c.eval(op).toString());
    }

    @Then("^the operation evaluates to (-?\\d+)(.)(\\d+)$")
    public void thenTheOperationWithRealValueEvaluatesTo(int part1, char dot, int decimal) {
        assertEquals(new MyNumber(new RealValue(new BigDecimal(part1 + "." + decimal, precision))), c.eval(op));
    }

    @Then("the (.*) with NaN member evaluates to (.*)$")
    public void thenTheOperationWithNaNMemberEvaluatesTo(String s, String val) {
        try {
            // Add a NaN member to the list of parameters
            params.add(new NotANumber());
            switch (s) {
                case "sum" -> op = new Plus(params);
                case "product" -> op = new Times(params);
                case "quotient" -> op = new Divides(params);
                case "difference" -> op = new Minus(params);
                default -> fail("Unknown operation!");
            }
            assertEquals(val, c.eval(op).toString());
        } catch (IllegalConstruction e) {
            fail("Error in construction of the operation");
        }
    }

    // ########################### Printing of the operation ###############################

    @Then("^its (.*) notation is (.*)$")
    public void thenItsNotationIs(String notation, String s) {
        if (notation.equals("PREFIX") || notation.equals("POSTFIX") || notation.equals("INFIX")) {
            c = new Calculator();
            assertEquals(s, c.format(op, Notation.valueOf(notation)));
        } else fail(notation + " is not a correct notation! ");
    }

    @Then("^its (.*) form is (.*)$")
    public void thenItsFormIs(String notation, String s) {
        if (notation.equals("CARTESIAN") || notation.equals("POLAR") || notation.equals("EXPONENTIAL")) {
            // Check if the number printed in the given notation is the same as the expected one
            if (params.get(0) instanceof MyNumber number) {
                number.setForm(ComplexForm.valueOf(notation));
                assertEquals(s, number.toString());
            } else fail("The parameter is not a number! ");
        } else fail(notation + " is not a correct form! ");
    }

    // ########################### Parsing of the operation ###############################

    @Then("^its (.*) parsing is (.*)$")
    public void additionParsing(String notation, String s) {
        if (notation.equals("PREFIX") || notation.equals("POSTFIX") || notation.equals("INFIX")) {
            c = new Calculator();
            assertEquals(s, c.format(c.read(op.toString()), Notation.valueOf(notation)));
        } else fail(notation + " is not a correct notation! ");
    }

    @Then("its parsing is {string}")
    public void thenItsParsingIs(String s) {
        assertEquals(s, params.get(0).toString());
    }


// ############################### When ###############################

    @When("^I provide a (.*) number (-?\\d+)$")
    public void whenIProvideANumber(String s, int val) {
        try {
            //add extra parameter to the operation
            params = new ArrayList<>();
            params.add(new MyNumber(val));
            op.addMoreParams(params);
        } catch (IllegalConstruction e) {
            fail("Illegal construction!");
        }
    }

    @When("^I provide a (.*) real number (-?\\d+)(.)(\\d+)$")
    public void whenIProvideARealNumber(String s, int part1, char dot, int decimal) {
        try {
            params = new ArrayList<>();
            params.add(new MyNumber(new RealValue(new BigDecimal(part1 + "." + decimal, precision))));
            op.addMoreParams(params);
        } catch (IllegalConstruction e) {
            fail("Illegal construction!");
        }
    }

    @When("I provide a NaN number")
    public void whenIProvideANaNNumber() {
        try {
            params = new ArrayList<>(); // create an empty set of parameters to be filled in
            params.add(new NotANumber());
            op.addMoreParams(params);
        } catch (IllegalConstruction e) {
            fail("Illegal construction!");
        }
    }

    @When("^I provide a (.*) complex number (-?\\d+)([+-])(\\d+)i$")
    public void whenIProvideAComplexNumber(String s, int real, char sign2, int imaginary) {
        try {
            // Write code here that turns the phrase above into concrete actions
            params = new ArrayList<>(); // create an empty set of parameters to be filled in
            params.add(new MyNumber(real, sign2 == '-' ? -imaginary : imaginary));
            op.addMoreParams(params);
        } catch (IllegalConstruction e) {
            fail("Illegal construction!");
        }
    }

    @When("I provide a (.*) complex number (-?\\d+)i$")
    public void whenIProvideAComplexNumber(String s, int imaginary) {
        try {
            // Write code here that turns the phrase above into concrete actions
            params = new ArrayList<>(); // create an empty set of parameters to be filled in
            params.add(new MyNumber(0, imaginary));
            op.addMoreParams(params);
        } catch (IllegalConstruction e) {
            fail("Illegal construction!");
        }
    }
    @When("I provide a (.*) rational number (-?\\d+)(/)(\\d+)$")
    public void whenIProvideARationalNumber(String s, int num, char slash, int den){
        try{
            params = new ArrayList<>();
            params.add(new MyNumber(new RationalValue(new IntValue(num), new IntValue(den))));
            op.addMoreParams(params);
        }catch (IllegalConstruction e){
            fail("Illegal construction!");
        }
    }

    @When("I provide the following expression {string}")
    public void whenIProvideAnExpression(String s) {
        try {
            params = new ArrayList<>();
            params.add(c.read(s));
            op.addMoreParams(params);
        } catch (IllegalConstruction e) {
            fail("Illegal construction!");
        }
    }
}
