Feature: Integer Arithmetic Expressions
  This feature provides a range of scenarios corresponding to the
  intended external behaviour of arithmetic expressions on integers.

  # This is just a comment.
  # You can start with a Background: that will be run before executing each scenario.

  Background:
    Given I initialise a calculator

  # Each scenario can be seen as a test that can be executed with JUnit,
  # provided that each of the steps (Given, When, And and Then) are
  # implemented in a Java mapping file (CalculatorSteps.Java)


  ##################################### Evaluation of simple expression tests #####################################

  Scenario: Adding two integer numbers
    Given an integer operation '+'
    When I provide a first number 4
    And I provide a second number 5
    Then the operation evaluates to 9

  Scenario: Subtracting two integer numbers
    Given an integer operation '-'
    When I provide a first number 7
    And I provide a second number 5
    Then the operation evaluates to 2

  Scenario: Multiplying two integer numbers
    Given an integer operation '*'
    When I provide a first number 7
    And I provide a second number 5
    Then the operation evaluates to 35

  Scenario: Dividing two integer numbers
    Given an integer operation '/'
    When I provide a first number 7
    And I provide a second number 5
    Then the operation evaluates to 1

      # A scenario outline (or template) is a scenario that is parameterised
  # with different values. The outline comes with a set of examples.
  # The scenario will be executed with each of the provided inputs.
  Scenario Outline: Adding two integer numbers
    Given an integer operation '+'
    When I provide a first number <n1>
    And I provide a second number <n2>
    Then the operation evaluates to <result>

    Examples:
      | n1 | n2 | result |
      | 4  | 5  | 9      |
      | 5  | 3  | 8      |

  Scenario Outline: Dividing two integer numbers
    Given an integer operation '/'
    When I provide a first number <n1>
    And I provide a second number <n2>
    Then the operation evaluates to <result>

    Examples:
      | n1 | n2 | result |
      | 35 | 5  | 7      |
      | 7  | 5  | 1      |
      | 5  | 7  | 0      |


  ##################################### Evaluation of nested expression tests #####################################

    # This is an example of a scenario in which we provide a list of numbers as input.
  # (In fact, this is not entirely true, since what is given as input is a table of
  # strings. In this case, the table is of dimension 1 * 3 (1 line and three columns).
  Scenario: Evaluation arithmetic operations over a list of integer numbers
    Given the following list of integer numbers
      | 8 | 2 | 2 |
    Then the sum is 12
    And the product is 32
    And the difference is 4
    And the quotient is 2

  Scenario Outline: Evaluating arithmetic operations with two integer parameters
    Given an integer operation <op>
    When I provide a first number <n1>
    And I provide a second number <n2>
    Then the operation evaluates to <result>

    Examples:
      | op  | n1 | n2 | result |
      | "+" | 4  | 5  | 9      |
      | "-" | 8  | 5  | 3      |
      | "*" | 7  | 2  | 14     |
      | "/" | 6  | 2  | 3      |

  ##################################### NaN tests #####################################
  Scenario: Dividing an integer by zero
    Given an integer operation '/'
    When I provide a first number 7
    And I provide a second number 0
    Then the operation evaluates to "NaN"

  Scenario: Evaluation arithmetic operations with a NaN member
    Given the following list of integer numbers
      | 8 | 2 | 2 |
    Then the sum with NaN member evaluates to NaN
    And the product with NaN member evaluates to NaN
    And the difference with NaN member evaluates to NaN
    And the quotient with NaN member evaluates to NaN

  ##################################### Printing tests #####################################

  Scenario: Printing the sum of two integer numbers
    Given the sum of two numbers 8 and 6
    Then its INFIX notation is ( 8 + 6 )
    And its PREFIX notation is + (8, 6)
    And its POSTFIX notation is (8, 6) +

  # In this scenario we provide a list of numbers as input.
  # The goal is to check if the code represents nested operations correctly.
  # We only check for the sum as it is the same method that is used for the other operations.
  Scenario: Printing the nested sum of three integer numbers
    Given the sum of the following list of numbers
      | 8 | 6 | 2 |
    Then its PREFIX notation is + (8, + (6, 2))
    And its INFIX notation is ( 8 + ( 6 + 2 ) )
    And its POSTFIX notation is (8, (6, 2) +) +

    # BDD Scenario covering the TestNotation.java JUnit test class
  # This evaluates the notation INFIX, PREFIX and POSTFIX for each operation
  Scenario Outline: Evaluating the notations for each operation
    Given an integer operation <op>
    When I provide a first number <n1>
    And I provide a second number <n2>
    Then its INFIX notation is ( <n1> <op2> <n2> )
    And its PREFIX notation is <op2> (<n1>, <n2>)
    And its POSTFIX notation is (<n1>, <n2>) <op2>

    Examples:
      | op  | n1 | n2 | op2 |
      | '+' | 8  | 6  | +   |
      | '-' | 8  | 6  | -   |
      | '*' | 8  | 6  | *   |
      | '/' | 8  | 6  | /   |

  ##################################### Parsing tests #####################################
  Scenario: Parsing the nested sum of three integers numbers
    Given the sum of the following list of numbers
      | 8 | 6 | 2 |
    Then its PREFIX parsing is + (8, + (6, 2))
    And its INFIX parsing is ( 8 + ( 6 + 2 ) )
    And its POSTFIX parsing is (8, (6, 2) +) +

  Scenario: Parsing the nested difference of three integers numbers
    Given the difference of the following list of numbers
      | 8 | 6 | 2 |
    Then its PREFIX parsing is - (8, - (6, 2))
    And its INFIX parsing is ( 8 - ( 6 - 2 ) )
    And its POSTFIX parsing is (8, (6, 2) -) -

  Scenario: Parsing the nested product of three integers numbers
    Given the product of the following list of numbers
      | 8 | 6 | 2 |
    Then its PREFIX parsing is * (8, * (6, 2))
    And its INFIX parsing is ( 8 * ( 6 * 2 ) )
    And its POSTFIX parsing is (8, (6, 2) *) *

  Scenario: Parsing the nested quotient of three integers numbers
    Given the quotient of the following list of numbers
      | 8 | 6 | 2 |
    Then its PREFIX parsing is / (8, / (6, 2))
    And its INFIX parsing is ( 8 / ( 6 / 2 ) )
    And its POSTFIX parsing is (8, (6, 2) /) /

  Scenario: Parsing an expression with respect to the order of operations
    Given the following expression "8 + 6 * 2"
    Then its parsing is "( 8 + ( 6 * 2 ) )"

  Scenario: Parsing an expression with parentheses
    Given the following expression "( 8 + 6 ) * 2"
    Then its parsing is "( ( 8 + 6 ) * 2 )"

  Scenario: Parsing an expression with syntax errors
    Given the following expression "8 + 6 * 2 +"
    Then its parsing is "NaN"

  Scenario: Parsing an Infix expression with negative numbers
    Given the following expression "8 + -6 * 2"
    Then its parsing is "( 8 + ( -6 * 2 ) )"

  Scenario: Parsing an Prefix expression with negative numbers
    Given the following expression "+ (8, -2, 4)"
    Then its parsing is "+ (8, -2, 4)"

  Scenario: Parsing an Postfix expression with negative numbers
    Given the following expression "(8, -2, 4) +"
    Then its parsing is "(8, -2, 4) +"
