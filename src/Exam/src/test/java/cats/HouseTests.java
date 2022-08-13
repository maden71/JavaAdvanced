package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private static final Cat cat33 = new Cat("Pooh");

    private House house;

    @Before
    public void setup(){
        house = new House("pesho",4);
    }

    @Test
    public void testIsNotHungry(){
        house.addCat(cat33);
        house.catForSale(cat33.getName());
        Assert.assertFalse(cat33.isHungry());
    }
    @Test
    public void getNameTest(){

        Assert.assertEquals("pesho",house.getName());
    }

    @Test(expected = NullPointerException.class)
    public void setNameException() {
        House house = new House("   ", 5);
    }


    @Test
    public void getCapacityTest() {
        House housec = new House("hope",6);
        Assert.assertEquals(6, housec.getCapacity());
    }

    @Test
    public void getCountTest() {
        house.addCat(new Cat("joro"));
        Assert.assertEquals(1,house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatExeption(){
        House house1 = new House("sdsdsd", 2);
        house1.addCat(new Cat("kjlasdjklasd"));
        house1.addCat(new Cat("Sdsd"));
        house1.addCat(new Cat("kjsd"));
        house1.addCat(new Cat("ksbc"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityException(){
        House house1 = new House("mhm",-1);
    }

    @Test
    public void removeCatTest(){
        house.addCat(new Cat("pesho3"));
        house.removeCat("pesho3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCatException(){
        house.addCat(new Cat("ginka"));
        house.removeCat("mariq");
    }

    @Test
    public void catForSaleTest() {
        Cat cat1 = new Cat("ginka2");
        house.addCat(cat1);
        Cat catTest = house.catForSale("ginka2");
        boolean bool = cat1.isHungry();
        Assert.assertEquals(cat1, catTest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void catForSaleException() {
        Cat cat1 = new Cat("capo");
        Cat catResult = house.catForSale("cap");
    }

    @Test
    public void statisticsTest() {
        House house2 = new House("ginka",5);
        house2.addCat(new Cat("ginka"));
        String result = house2.statistics();
        Assert.assertEquals("The cat ginka is in the house ginka!",result);
    }

    @Test
    public void testStatisticsMoreThanOneCat(){
        house.addCat(cat33);
        house.addCat(new Cat("Pep"));
        String result =  house.statistics();
        Assert.assertEquals(String.format("The cat Pooh, Pep is in the house %s!", house.getName()), result);
    }




}
