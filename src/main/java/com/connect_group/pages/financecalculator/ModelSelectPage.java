package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.logging.Logger;

public class ModelSelectPage extends BasePage {
  private static final Logger log = Logger.getLogger(ExpectedConditions.class.getName());
  public ModelSelectPage(WebDriver driver) {
    super(driver);
  }

  private WebElement getModelSelectNameplateContainer() {
    return until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='model-select-render']/div[3]")));
  }

  public List<WebElement> getAllNameplates() {
    return until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'fc-nameplate__title')]")));
  }

  public <exception extends Throwable> boolean isInitialized() {
      try {
        WebElement consent_Button = driver.findElement(By.xpath("//*[@id='truste-consent-button']"));
        if (consent_Button.isDisplayed()) {
          consent_Button.click();
        }

      return getModelSelectNameplateContainer().isDisplayed();
      }
      catch(StaleElementReferenceException e){
       return false;
      }
  }

  public Integer valiadateNumberOfVehicles() {
   // System.out.println("Inside 1st Task of Assignment :: ");
    List<WebElement> elements = driver.findElements(By.xpath("//*[contains(@class, 'fc-nameplate__nameplate fc-nameplate__nameplate--4-per-row')]"));
    log.info("Validate number of element as 8 ");
    return elements.size();
  }

  public boolean calculateMonthlyPaymentAndDeposit() {
   // System.out.println("Inside 2nd  Task of Assignment Monthly Payment :: ");
    driver.findElement(By.xpath("//*[contains(text(),'MONTHLY PAYMENT')]")).click();
    WebElement slider = driver.findElement(By.id("handle_max"));

    Actions moveSlider = new Actions(driver);
    Action action = moveSlider.dragAndDropBy(slider, 50, 0).build();
    action.perform();
    driver.findElement(By.xpath("//*[@id='deposit']")).clear();
    driver.findElement(By.xpath("//*[@id='deposit']")).sendKeys("value", "20,000");
    driver.findElement(By.xpath("//*[@id='fincalc-quickQuote']/div/div/div/div[3]/div/div[1]/div[2]/div/button/span")).click();

    return true;
  }

  public boolean modelSelectionAndValueChangeForEngineDropdown() {

    //driver.findElement(By.xpath("//*[@id='fincalc-quickQuote']/div/div/div/div[2]/div[2]/button[1]")).click();
   // driver.findElement(By.xpath("//*[@id='model-select-render']/div[3]/div[1]/div/div[1]/a/span/img")).click();

    driver.findElement(By.xpath("//*[@id='fincalc-quickQuote']/div/div/div/div[4]/div[1]/div/div[1]/button")).click();
    driver.findElement(By.xpath("//*[@id='fincalc-quickQuote']/div/div/div[2]/div[2]/button[1]")).click();
    driver.findElement(By.xpath("//*[@id='model-select-render']/div[3]/div[1]/div/div[1]/a")).click();
    driver.findElement(By.xpath("//*[@id='dropdown__button-engines']")).click();
    driver.findElement(By.xpath("//*[@id='dropdown__list-engines_P440e AWD AUTOMATIC PHEV']/a")).click();

    return true;
  }

  public boolean verificationOfTooltipIcon() {
    driver.findElement(By.xpath("//*[@id='product']")).click();
    return true;
  }

}