import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/");

        List<WebElement> elements = driver.findElements(By.tagName("a"));

        for(int i = 0; i < elements.size(); i++){
            String element = elements.get(i).getText();
            if(element.equalsIgnoreCase("Nested Frames")){
                elements.get(i).click();
                break;
            }
        }

        driver.switchTo().frame(driver.findElement(By.name("frame-top")));
        driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
        System.out.println(driver.findElement(By.cssSelector("div#content")).getText());
        driver.close();
    }
}
