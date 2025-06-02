package com.sts.testautomation.nimbisutilities;

import com.sts.testautomation.pages.web.NIMBIS_Prestige_Contents;
import com.sts.testautomation.steps.BaseTest;
import com.sts.testautomation.utilities.ElementFunctionality;
import com.sts.testautomation.utilities.ExcelHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class common_functions1 extends BaseTest {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;
    public NIMBIS_Prestige_Contents contents;

    public common_functions1(WebDriver browserDriver, String Device) {
        this.BrowserDriver = browserDriver;
        this.Device = Device;
        this.verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }




    /**
     * Gets dropdown options by clicking a dropdown WebElement and finding its options
     * @param dropdownElement The dropdown WebElement from page object
     * @param optionsXpath XPath to find dropdown options after clicking
     * @param fieldName Name of the field for logging
     * @return List of dropdown option texts
     */
    public List<String> getDropdownOptions(WebElement dropdownElement, String optionsXpath, String fieldName) {
        List<String> uiDropdownOptions = new ArrayList<>();

        try {
            System.out.println("Getting dropdown options for: " + fieldName);

            // Click the dropdown to open it
            if (verifyElement.verifyBrowserElementValue(dropdownElement, fieldName) == 0) {
                verifyElement.clickElement(dropdownElement, fieldName + " dropdown");
                Thread.sleep(1000); // Wait for dropdown to open

                // Find dropdown options
                List<WebElement> optionElements = BrowserDriver.findElements(By.xpath(optionsXpath));

                if (!optionElements.isEmpty()) {
                    System.out.println("Found " + optionElements.size() + " options for " + fieldName);

                    for (WebElement option : optionElements) {
                        String optionText = option.getText().trim();
                        if (!optionText.isEmpty()) {
                            uiDropdownOptions.add(optionText);
                        }
                    }
                } else {
                    System.out.println("No options found for " + fieldName + " using xpath: " + optionsXpath);
                }
            } else {
                System.err.println("Dropdown element not found or not visible: " + fieldName);
            }

            System.out.println("Available options for " + fieldName + ": " + uiDropdownOptions);

        } catch (Exception e) {
            System.err.println("Error getting dropdown options for " + fieldName + ": " + e.getMessage());
            e.printStackTrace();
        }

        return uiDropdownOptions;
    }

    /**
     * Gets dropdown options using Select element approach (for standard HTML select dropdowns)
     * @param dropdownElement The dropdown WebElement from page object
     * @param fieldName Name of the field for logging
     * @return List of dropdown option texts
     */
    public List<String> getSelectDropdownOptions(WebElement dropdownElement, String fieldName) {
        List<String> uiDropdownOptions = new ArrayList<>();

        try {
            System.out.println("Getting select dropdown options for: " + fieldName);

            if (verifyElement.verifyBrowserElementValue(dropdownElement, fieldName) == 0) {
                Select select = new Select(dropdownElement);
                List<WebElement> options = select.getOptions();

                for (WebElement option : options) {
                    String optionText = option.getText().trim();
                    if (!optionText.isEmpty() && !optionText.equalsIgnoreCase("Select") && !optionText.equalsIgnoreCase("Choose")) {
                        uiDropdownOptions.add(optionText);
                    }
                }

                System.out.println("Found " + uiDropdownOptions.size() + " options for " + fieldName);
            } else {
                System.err.println("Dropdown element not found or not visible: " + fieldName);
            }

            System.out.println("Available options for " + fieldName + ": " + uiDropdownOptions);

        } catch (Exception e) {
            System.err.println("Error getting select dropdown options for " + fieldName + ": " + e.getMessage());
            e.printStackTrace();
        }

        return uiDropdownOptions;
    }
    /**
     * Validates dropdown using pre-found option elements
     * @param expectedValues List of expected values from Excel
     * @param optionElements List of WebElements representing dropdown options
     * @param fieldName Name of the field being validated
     * @return DropdownValidationResult
     */
    public DropdownValidationResult validateDropdownWithElements(List<String> expectedValues, List<WebElement> optionElements, String fieldName) {
        System.out.println("\n=== VALIDATING " + fieldName.toUpperCase() + " DROPDOWN WITH ELEMENTS ===");

        // Extract text from WebElements
        List<String> uiOptions = extractTextFromElements(optionElements, fieldName);

        // Validate options
        DropdownValidationResult result = validateDropdownOptions(expectedValues, uiOptions);

        // Generate report
        generateValidationReport(result, fieldName);

        return result;
    }

    /**
     * Extracts text content from List of WebElements
     * @param elements List of WebElements
     * @param fieldName Field name for logging
     * @return List of text values
     */
    public List<String> extractTextFromElements(List<WebElement> elements, String fieldName) {
        List<String> textValues = new ArrayList<>();

        try {
            if (elements == null || elements.isEmpty()) {
                System.err.println("No elements found for " + fieldName);
                return textValues;
            }

            System.out.println("Extracting text from " + elements.size() + " elements for " + fieldName);

            for (WebElement element : elements) {
                if (element != null && element.isDisplayed()) {
                    String text = element.getText();
                    if (!text.isEmpty()) {
                        textValues.add(text);
                    }
                }
            }

            System.out.println("Extracted values: " + textValues);

        } catch (Exception e) {
            System.err.println("Error extracting text from elements for " + fieldName + ": " + e.getMessage());
            e.printStackTrace();
        }

        return textValues;
    }
    /**
     * Gets dropdown options from a dropdown element using provided locators.
     *
     * @param dropdownElement The parent WebElement for the dropdown
     * @param fieldName A name for logging/debugging
     * @param optionLocators A list of By locators to find option elements inside the dropdown
     * @return A list of dropdown option texts
     */
    public List<String> getDropdownOptionsWithPatterns(WebElement dropdownElement, String fieldName, List<By> optionLocators) {
        List<String> uiDropdownOptions = new ArrayList<>();

        try {
            System.out.println("Getting dropdown options for: " + fieldName);

            for (By optionLocator : optionLocators) {
                List<WebElement> optionElements = dropdownElement.findElements(optionLocator);

                if (!optionElements.isEmpty()) {
                    System.out.println("Found " + optionElements.size() + " options using locator: " + optionLocator);

                    for (WebElement option : optionElements) {
                        String optionText = option.getText().trim();
                        if (!optionText.isEmpty() && !uiDropdownOptions.contains(optionText)) {
                            uiDropdownOptions.add(optionText);
                        }
                    }

                    // Stop once we find options
                    if (!uiDropdownOptions.isEmpty()) {
                        break;
                    }
                }
            }

            System.out.println("Available options for " + fieldName + ": " + uiDropdownOptions);

        } catch (Exception e) {
            System.err.println("Error getting dropdown options for " + fieldName + ": " + e.getMessage());
            e.printStackTrace();
        }

        return uiDropdownOptions;
    }


    /**
     * Gets dropdown options by clicking dropdown and using common option patterns
     * @param dropdownElement The dropdown WebElement from page object
     * @param fieldName Name of the field for logging
     * @return List of dropdown option texts
     */
    public List<String> getDropdownOptionsWithCommonPattern1(WebElement dropdownElement, String fieldName) {
        List<String> uiDropdownOptions = new ArrayList<>();

        // Common dropdown option xpath patterns based on your project structure
        String[] commonPatterns = {
                  //dropdownElement
        };

        try {
            System.out.println("Getting dropdown options for: " + fieldName);

            // Click the dropdown to open it
           // if (verifyElement.verifyBrowserElementValue(dropdownElement, fieldName) == 0) {
               // verifyElement.clickElement(dropdownElement, fieldName + " dropdown");
                // Thread.sleep(1500); // Wait for dropdown to open

                // Try common patterns
              for (String pattern : commonPatterns) {
                    List<WebElement> optionElements = BrowserDriver.findElements((By) dropdownElement);

                    if (!optionElements.isEmpty()) {
                        System.out.println("Found " + optionElements.size() + " options using pattern: " + pattern);

                        for (WebElement option : optionElements) {
                            String optionText = option.getText().trim();
                            if (!optionText.isEmpty() && !uiDropdownOptions.contains(optionText)) {
                                uiDropdownOptions.add(optionText);
                            }
                        }

                        // If we found options, break
                        if (!uiDropdownOptions.isEmpty()) {
                            break;
                        }
                    }
                }
           // } else {
             //   System.err.println("Dropdown element not found or not visible: " + fieldName);
          //  }

            System.out.println("Available options for " + fieldName + ": " + uiDropdownOptions);

        } catch (Exception e) {
            System.err.println("Error getting dropdown options for " + fieldName + ": " + e.getMessage());
            e.printStackTrace();
        }

        return uiDropdownOptions;
    }

    /**
     * Validates expected values against UI dropdown options
     * @param expectedValues List of expected values from Excel/data source
     * @param uiDropdownOptions List of actual options from UI dropdown
     * @return DropdownValidationResult containing validation results
     */
    public DropdownValidationResult validateDropdownOptions(List<String> expectedValues, List<String> uiDropdownOptions) {
        List<String> missingOptions = new ArrayList<>();
        List<String> validatedOptions = new ArrayList<>();

        System.out.println("\n=== DROPDOWN VALIDATION ===");
        System.out.println("Expected values: " + expectedValues);
        System.out.println("UI dropdown options: " + uiDropdownOptions);

        for (String expectedValue : expectedValues) {
            boolean optionExists = uiDropdownOptions.stream()
                    .anyMatch(uiOption -> uiOption.equalsIgnoreCase(expectedValue.trim()));

            if (optionExists) {
                validatedOptions.add(expectedValue);
                System.out.println("✓ PASS: '" + expectedValue + "' found in UI dropdown");
            } else {
                missingOptions.add(expectedValue);
                System.err.println("✗ FAIL: '" + expectedValue + "' NOT found in UI dropdown");
            }
        }

        return new DropdownValidationResult(expectedValues, uiDropdownOptions, validatedOptions, missingOptions);
    }

    /**
     * Complete dropdown validation using WebElement with custom options xpath
     * @param expectedValues List of expected values
     * @param dropdownElement The dropdown WebElement from page object
     * @param optionsXpath XPath to find dropdown options
     * @param fieldName Name of the field being validated
     * @return DropdownValidationResult
     */
    public DropdownValidationResult validateDropdown(List<String> expectedValues, WebElement dropdownElement,
                                                     String optionsXpath, String fieldName) {
        System.out.println("\n=== VALIDATING " + fieldName.toUpperCase() + " DROPDOWN ===");

        // Get UI dropdown options using WebElement and options xpath
        List<String> uiOptions = getDropdownOptions(dropdownElement, optionsXpath, fieldName);

        // Validate options
        DropdownValidationResult result = validateDropdownOptions(expectedValues, uiOptions);

        // Generate report
        generateValidationReport(result, fieldName);

        return result;
    }

    /**
     * Complete dropdown validation using WebElement with common patterns
     * @param expectedValues List of expected values
     * @param dropdownElement The dropdown WebElement from page object
     * @param fieldName Name of the field being validated
     * @return DropdownValidationResult
     */
    public DropdownValidationResult validateDropdown(List<String> expectedValues, WebElement dropdownElement, String fieldName ,List<By> optionLocators) {
        System.out.println("\n=== VALIDATING " + fieldName.toUpperCase() + " DROPDOWN ===");

        // Get UI dropdown options using WebElement and common patterns
        List<String> uiOptions = getDropdownOptionsWithPatterns(dropdownElement, fieldName,optionLocators);

        // Validate options
        DropdownValidationResult result = validateDropdownOptions(expectedValues, uiOptions);

        // Generate report
        generateValidationReport(result, fieldName);

        return result;
    }

    /**
     * Complete dropdown validation for standard HTML select elements
     * @param expectedValues List of expected values
     * @param dropdownElement The dropdown WebElement from page object
     * @param fieldName Name of the field being validated
     * @return DropdownValidationResult
     */
    public DropdownValidationResult validateSelectDropdown(List<String> expectedValues, WebElement dropdownElement, String fieldName) {
        System.out.println("\n=== VALIDATING " + fieldName.toUpperCase() + " SELECT DROPDOWN ===");

        // Get UI dropdown options using Select approach
        List<String> uiOptions = getSelectDropdownOptions(dropdownElement, fieldName);

        // Validate options
        DropdownValidationResult result = validateDropdownOptions(expectedValues, uiOptions);

        // Generate report
        generateValidationReport(result, fieldName);

        return result;
    }

    /**
     * Generates a detailed validation report
     * @param result DropdownValidationResult
     * @param fieldName Name of the field
     */
    public void generateValidationReport(DropdownValidationResult result, String fieldName) {
        System.out.println("\n=== " + fieldName.toUpperCase() + " VALIDATION RESULTS ===");
        System.out.println("Total expected values: " + result.getExpectedValues().size());
        System.out.println("Total UI options: " + result.getUiOptions().size());
        System.out.println("Successfully validated: " + result.getValidatedOptions().size());
        System.out.println("Missing from UI: " + result.getMissingOptions().size());

        if (result.isAllOptionsValid()) {
            System.out.println("✓ ALL " + fieldName + " values are available in UI dropdown");
            verifyElement.passTest(fieldName + " dropdown validation - ALL OPTIONS VALIDATED");
        } else {
            System.err.println("✗ Missing options in UI dropdown: " + result.getMissingOptions());
            verifyElement.failTest(fieldName + " dropdown validation FAILED - Missing options: " + result.getMissingOptions());
        }

        // Capture screenshot
        verifyElement.captureScreenshotOnDevice(fieldName + " Dropdown Validation - Results");
    }

    /**
     * Gets expected dropdown values from Excel column
     * @param excelHandler The Excel handler instance
     * @param testObjectiveValue The value to search for in Test objective column
     * @param targetColumnName The column name to extract values from
     * @return List of expected values from Excel
     */
    public List<String> getExpectedValuesFromExcel(ExcelHandler excelHandler, String testObjectiveValue, String targetColumnName) {
        List<String> expectedValues = new ArrayList<>();
        try {
            System.out.println("=== READING VALUES FROM EXCEL ===");
            System.out.println("Looking for rows where Test objective = '" + testObjectiveValue + "'");
            System.out.println("Will get values from column: '" + targetColumnName + "'");

            // Find column indices
            int testObjectiveColIndex = -1;
            int targetColIndex = -1;

            // Find the column indices from headers (row 0)
            for (int col = 0; col < excelHandler.NumberColumns(); col++) {
                String headerValue = excelHandler.tabArray[0][col];
                if (headerValue != null) {
                    if (headerValue.trim().equalsIgnoreCase("Test objective")) {
                        testObjectiveColIndex = col;
                    }
                    if (headerValue.trim().equalsIgnoreCase(targetColumnName)) {
                        targetColIndex = col;
                    }
                }
            }

            if (testObjectiveColIndex == -1) {
                System.out.println("❌ ERROR: 'Test objective' column not found!");
                return expectedValues;
            }

            if (targetColIndex == -1) {
                System.out.println("❌ ERROR: '" + targetColumnName + "' column not found!");
                return expectedValues;
            }

            System.out.println("Found 'Test objective' at column index: " + testObjectiveColIndex);
            System.out.println("Found '" + targetColumnName + "' at column index: " + targetColIndex);

            // Find rows where Test objective contains the search value
            Set<String> uniqueValues = new LinkedHashSet<>();

            for (int row = 1; row < excelHandler.NumberRows(); row++) {
                String testObjValue = excelHandler.tabArray[row][testObjectiveColIndex];

                if (testObjValue != null && testObjValue.trim().toLowerCase().contains(testObjectiveValue.toLowerCase())) {
                    String targetValue = excelHandler.tabArray[row][targetColIndex];

                    if (targetValue != null && !targetValue.trim().isEmpty()) {
                        String coverType = targetValue.trim();
                        uniqueValues.add(coverType);
                        System.out.println("Row " + row + ": Test objective = '" + testObjValue + "', " + targetColumnName + " = '" + coverType + "'");
                    }
                }
            }

            expectedValues.addAll(uniqueValues);
            System.out.println("\nUnique values found: " + expectedValues);
            System.out.println("Total unique values: " + expectedValues.size());

        } catch (Exception e) {
            System.out.println("❌ ERROR reading Excel data: " + e.getMessage());
            e.printStackTrace();
        }

        return expectedValues;
    }

    /**
     * Inner class to hold validation results
     */
    public static class DropdownValidationResult {
        private List<String> expectedValues;
        private List<String> uiOptions;
        private List<String> validatedOptions;
        private List<String> missingOptions;

        public DropdownValidationResult(List<String> expectedValues, List<String> uiOptions,
                                        List<String> validatedOptions, List<String> missingOptions) {
            this.expectedValues = expectedValues;
            this.uiOptions = uiOptions;
            this.validatedOptions = validatedOptions;
            this.missingOptions = missingOptions;
        }

        public boolean isAllOptionsValid() {
            return missingOptions.isEmpty();
        }

        public double getValidationPercentage() {
            if (expectedValues.isEmpty()) return 0.0;
            return (double) validatedOptions.size() / expectedValues.size() * 100;
        }

        // Getters
        public List<String> getExpectedValues() { return expectedValues; }
        public List<String> getUiOptions() { return uiOptions; }
        public List<String> getValidatedOptions() { return validatedOptions; }
        public List<String> getMissingOptions() { return missingOptions; }

        @Override
        public String toString() {
            return String.format("DropdownValidationResult{validated=%d/%d (%.1f%%), missing=%s}",
                    validatedOptions.size(), expectedValues.size(), getValidationPercentage(), missingOptions);
        }
    }
}
