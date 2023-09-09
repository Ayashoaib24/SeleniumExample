package org.example;

import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class WebElementUtils {

    public static List<WebElement> filterElementsByValueBelow(List<WebElement> elements) {
        List<WebElement> filteredElements = new ArrayList<>();

        for (WebElement element : elements) {
            String text = element.getText().trim();
            // Remove any commas if present and parse the text as a numeric value
            text = text.replaceAll(",", "");
            try {
                double numericValue = Double.parseDouble(text);
                if (numericValue < 15000.0) {
                    filteredElements.add(element);
                }
            } catch (NumberFormatException e) {
                // Handle the case where the text is not a valid numeric value
                // You can log an error message or perform other actions as needed
            }
        }

        return filteredElements;
    }
}
