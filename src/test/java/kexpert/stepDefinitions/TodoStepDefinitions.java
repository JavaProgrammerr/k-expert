package kexpert.stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import kexpert.steps.TodoSteps;
import net.thucydides.core.annotations.Steps;

public class TodoStepDefinitions {

    @Steps
    private TodoSteps todoSteps;

    @Given("^Create todo '(.*)'$")
    public void createTodoSimpleTestingTodo(String todoName) {
        todoSteps.createTodo(todoName);
    }

    @Given("^Open todos site$")
    public void openTodosSite()  {
        todoSteps.openTodoSite();
    }

    @And("^Edit todo '(.*)' with name '(.*)'$")
    public void editTodoSimpleEditedTestingTodo(String todoName, String newTodoName) {
        todoSteps.editTodo(todoName, newTodoName);
    }

    @And("^Complete todo '(.*)'$")
    public void completeTodoSimpleEditedTestingTodo(String todoName) {
        todoSteps.completeTodo(todoName);
    }

    @Then("^Delete todo '(.*)'$")
    public void deleteTodoSimpleEditedTestingTodo(String todoName) throws Throwable {
        todoSteps.deleteTodo(todoName);
        todoSteps.verifyThatTodoDoesntExist(todoName);
    }
}