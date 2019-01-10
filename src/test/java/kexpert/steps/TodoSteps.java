package kexpert.steps;

import kexpert.ui.TodoPage;
import net.thucydides.core.annotations.Step;

public class TodoSteps {

    private TodoPage todoPage;

    @Step("Open todos site")
    public void openTodoSite() {
        todoPage.open();
    }
    @Step("Create new todo")
    public void createTodo(String todoName) {
        todoPage.createTodo(todoName);
    }
    @Step("Edit todo")
    public void editTodo(String todoName, String newTodoName) {
        todoPage.editTodo(todoName, newTodoName);
    }
    @Step("Complete todo")
    public void completeTodo(String todoName) {
        todoPage.completeTodo(todoName);
    }
    @Step("Delete todo")
    public void deleteTodo(String todoName) {
        todoPage.deleteTodo(todoName);
    }
    @Step("Verify that todo doesnt exist")
    public void verifyThatTodoDoesntExist(String todoName){
        todoPage.verifyThatTodoDoesntExist(todoName);
    }
}
