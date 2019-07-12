import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeMap;

class Model {

    public String TeamName;
    public String FirstName;
    public String LastName;
    public Integer Time;
    public Integer ExtraTime;
    public String Event;
    public String SubstituteName;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getTime() {
        return Time;
    }

    public void setTime(Integer time) {
        Time = time;
    }

    public Integer getExtraTime() {
        return ExtraTime;
    }

    public void setExtraTime(Integer extraTime) {
        ExtraTime = extraTime;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getSubstituteName() {
        return SubstituteName;
    }

    public void setSubstituteName(String substituteName) {
        SubstituteName = substituteName;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(FirstName, model.FirstName) &&
                Objects.equals(LastName, model.LastName) &&
                Objects.equals(Time, model.Time) &&
                Objects.equals(ExtraTime, model.ExtraTime) &&
                Objects.equals(Event, model.Event) &&
                Objects.equals(SubstituteName, model.SubstituteName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FirstName, LastName, Time, ExtraTime, Event, SubstituteName);
    }
}

public class Main {

    public static void main(String[] args) {

        List<String> str2;
        String team1="A";
        String team2 = "B";

        System.out.println("Hello World!");
        List<String> str = new ArrayList<>();
        str.add("Name1 12 G");
        str.add("FirstName LastName 43 Y");
        str.add("Name3 45+1 S SubName");
        str.add("Name4 46 G");



        List<Model> objArray = new ArrayList<>();
        Model m1 = new Model();
        objArray.add(constructObject(m1,str,team1));

    }


    }
}


