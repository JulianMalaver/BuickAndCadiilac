package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class ValidadorEnlacesSelenium {

    public static void main(String[] args) {
        // Establecer la ubicación del controlador (ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        // Inicializar el WebDriver (Chrome)
        WebDriver driver = new ChromeDriver();

        // Abrir la página web
        String url = "https://www.Buick.com";
        driver.get(url);

        // Esperar un tiempo (puedes mejorar esto usando WebDriverWait)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Encontrar todos los elementos <a> (enlaces) en la página
        List<WebElement> enlaces = driver.findElements(By.tagName("a"));

        // Validar cada enlace
        for (WebElement enlace : enlaces) {
            String href = enlace.getAttribute("href");
            if (href != null && !href.isEmpty()) {
                int codigoRespuesta = obtenerCodigoRespuesta(href);
                if (codigoRespuesta == 404) {
                    System.out.println("Enlace roto: " + href);
                } else {
                    System.out.println("Enlace válido: " + href);
                }
            }
        }

        // Cerrar el navegador
        //driver.quit(); 
    }

    private static int obtenerCodigoRespuesta(String enlace) {
        // Puedes usar HttpURLConnection o cualquier otra técnica para obtener el código de respuesta
        // Similar al método obtenerCodigoRespuesta en el ejemplo sin Selenium
        // ...

        return -1;
    }
}

