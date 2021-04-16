import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Ejercicio14 {

    //Crear un método con un nombre a seleccionar
    //Acceder a Netflix: https://www.netflix.com/uy/
    //Mostrar los elementos h1 y h2 que hay en el sitio
    //Refrescar la página
    //Mostrar el texto de los botones que se encuentran en la página
    //Mostrar la cantidad de elementos div que contiene el sitio
    //Obtener y mostrar el título de la página
    //Mostrar la cantidad de elementos de tipos link

    WebDriver driver;

    @Test
    public void testNextflix() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.netflix.com/uy");

        List<WebElement> h1List = driver.findElements(By.tagName("h1"));
        for (WebElement h1Title : h1List) {
            System.out.println("h1: " + h1Title.getText());
        }

        List<WebElement> h2List = driver.findElements(By.tagName("h2"));
        for (WebElement h2Title : h2List) {
            System.out.println("h2: " + h2Title.getText());
        }

        driver.navigate().refresh();

        List<WebElement> buttonList = driver.findElements(By.tagName("button"));
        for (WebElement buttonsTitle : buttonList) {
            System.out.println("Texto del boton es: " + buttonsTitle.getText());
        }

        List<WebElement> divList = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de elementos div que contiene el sitio es: " + divList.size());

        System.out.println("El titulo de la pagina es: " + driver.getTitle());

        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        System.out.println("La cantidad de links que contiene el sitio es: " + linksList.size());

        driver.quit();
    }
}

