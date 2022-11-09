package ders09_actionsClass;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C08_FakerClass {
    @Test
    public void test01(){

        Faker faker=new Faker(); // fake element uretir

        System.out.println(faker.name().firstName());// kac kere calıstırırsak o kadar fake isim uretir
        System.out.println(faker.name().fullName());

        System.out.println(faker.address().fullAddress());

        System.out.println(faker.internet().password());
    }
}
