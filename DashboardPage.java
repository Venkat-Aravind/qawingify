package PageObjects;

import Actions.PreDefinedActions;
import Base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DashboardPage extends BaseClass {
    public DashboardPage()
    {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css="#amount")
    private WebElement Amount;

    public void AmountClick() {
        PreDefinedActions.clickMethod(Amount, true);
    }
    @FindBy(xpath="//td[@class='text-right bolder nowrap']")
    List<WebElement> AmountList;
    public List<Double> getAmountList()
    {
        return PreDefinedActions.getListOfWebElementInDouble(AmountList);
    }
    public List<Double> getSortingAmountList()
    {

      List<Double> sortedAmountValues = new ArrayList<Double>(getAmountList());
        Collections.sort(sortedAmountValues);

       return sortedAmountValues;

    }
}





