import javax.xml.ws.Response;

public interface PersonService {
    public Response addPerson(Person p);

    public Response deletePerson(int id);

    public Person getPerson(int id);

    public Person[] getAllPersons();
}
