import model.Calculator;
import model.Human;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by delonj on 21/04/2017.
 */
public class Sequence extends Base {
    Calculator calculator = new Calculator(2, 18);
    Human human1 = new Human();
    Human human2 = new Human();

    private void setHumans () {
        human1.lastName = "Пушкин";
        human1.firstName = "Александр";
        human1.middleName = "Сергеевич";
        human1.profession = "писатель";

        human2.lastName = "Толстой";
        human2.firstName = "Лев";
        human2.middleName = "Николаевич";
        human2.profession = human1.profession;
    }

    @Test
    public void setUp(){
        setHumans();
    }


    @Test(groups = "case_1", dependsOnMethods = "setUp")
    public void step_1() {
        logger.info("Первый шаг "+ calculator.getMiltiply());
        logger.info(human2.birthday + " " + human2.firstName);


    }
    @Test(dependsOnMethods = {"step_1"})
    public void step_2() {
        logger.info("Второй шаг "+ calculator.getDivide());
        logger.info(human1.birthday + " " + human2.lastName);


    }

    @Test(dependsOnMethods = {"step_1"})
    public void step_2_1() {
        logger.info("Второй шаг "+ sum(2, 18));
    }

    @Test(groups = "case_2", dependsOnGroups = "case_1", dependsOnMethods = "setUp")
    public void step_3() {
        logger.info("Третий шаг "+ sum(15, 15));
        Assert.assertEquals("два", "2");

    }

    @DataProvider
    static public Object[][] names() {
        return new Object[][] {
                { "Антоха" },
                { "Колян" },
                { "Янчик" },
        };
    }

    @Test(dataProvider = "names", dependsOnMethods = {"step_3"})
    public void goodMorning(String name) {
        logger.info("Доброе утро, " + name + " !");
    }

    @Test(dependsOnGroups = "case_2", dependsOnMethods = "setUp")
    public void step_4() {
        logger.info("Четвертый шаг " + sum(27, 13));
    }


    @Test(dependsOnMethods = {"step_4"})
    public void step_5() {
        logger.info("Пятый шаг " + sum(27, 23));
    }


    @Test(dependsOnMethods = {"step_6"})
    public void step_6() {
        double i = 0x0bp3;
    }


    private int sum(int a, int b) {
        return a + b;
    }



}
