package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {

    private House house;

    @Before
    public void setup(){
        house = new House("pesho",1);
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
        Assert.assertEquals(1, house.getCapacity());
    }

    @Test
    public void getCountTest() {
        house.addCat(new Cat("joro"));
        Assert.assertEquals(1,house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCatExeption(){
        house.addCat(new Cat("penka"));
        house.addCat(new Cat("chorap"));
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




}
