package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.Since;

class Car {
    @Expose(serialize = false, deserialize = false)
    public String brand = "Honda";

    @Expose(serialize = true, deserialize = true)
    public int doors = 3;
    public transient String name = ""; // transient to exclude from being serialized
}

public class GsonExample {
    public static void main(String[] args) {

        String json = "{\"brand\":\"Jeep\", \"doors\": 3}";
        Gson gson = new Gson();
        Car car =  gson.fromJson(json,Car.class);
        System.out.println(car);


        Car car1 = new Car();
        GsonBuilder builder = new GsonBuilder();
        Gson gson1 = builder.setPrettyPrinting().create();
        String json1 = gson1.toJson(car1);
        System.out.println(json1);

        Car car2 = new Car();
        GsonBuilder builder2 = new GsonBuilder();
        builder.serializeNulls(); // include null values
        builder2.excludeFieldsWithoutExposeAnnotation(); // To include fields with Expose tag
        Gson gson2 = builder2.setPrettyPrinting().create();
        String json2 = gson2.toJson(car2);
        System.out.println(json2);

    }

}

class Person {
    // version support in GSON
    @Since(1.0)
    public String firstName = null;

    @Since(1.0)
    public String lastName = null;

    @Since(2.0)
    public String middleName = null;

    @Since(3.0)
    public String email = null;
}

class Newmain{
    public static void main(String[] args) {
        Person person = new Person();
        person.firstName  = "John";
        person.lastName   = "Doe";
        person.middleName = "Blocks";
        person.email      = "john@doe.com";

        GsonBuilder builder = new GsonBuilder();
        builder.setVersion(2.0); // field version 3.0 email wont be serialized
        Gson gson = builder.setPrettyPrinting().create();
        System.out.println(gson.toJson(person));
    }
}

