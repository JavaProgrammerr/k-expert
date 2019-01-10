package kexpert.ui;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

@DefaultUrl("https://todomvc4tasj.herokuapp.com")
public class TodoPage extends PageObject{

    @FindBy(id = "new-todo")
    private WebElement todoInputField;
    @FindBy(xpath = "//ul[@id='todo-list']/descendant::label")
    private List<WebElement> todosList;

    public void createTodo(String todoName) {
        todoInputField.click();
        todoInputField.sendKeys(todoName);
        todoInputField.sendKeys(Keys.ENTER);
    }

    public void editTodo(String todoName, String newTodoName) {
        Actions action = new Actions(getDriver());
        WebElement todo = getDriver().findElement(By.xpath("//ul[@id='todo-list']/descendant::label[text()='"+todoName+"']"));
        WebElement todoInputField = getDriver().findElement(By.xpath("//ul[@id='todo-list']/descendant::label[text()='"+todoName+"']/ancestor::div[@class='view']/following-sibling::input"));
        action.doubleClick(todo).perform();
        todoInputField.sendKeys(Keys.CONTROL + "a");
        todoInputField.sendKeys(Keys.BACK_SPACE);
        todoInputField.sendKeys(newTodoName);
        todoInputField.sendKeys(Keys.ENTER);
    }

    public void completeTodo(String todoName) {
        getDriver().findElement(By.xpath("//ul[@id='todo-list']/descendant::label[text()='"+todoName+"']/preceding-sibling::input")).click();
    }

    public void deleteTodo(String todoName) {
        getDriver().findElement(By.xpath("//ul[@id='todo-list']/descendant::label[text()='"+todoName+"']/following-sibling::button")).click();
    }
    public void verifyThatTodoDoesntExist(String todoName){
        for (WebElement element : todosList){
            assertThat(element.getText(), not(containsString(todoName)));
        }
    }
}
