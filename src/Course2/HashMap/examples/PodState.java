package examples;

public enum PodState {

    DISCOVERED, // Not yet connected to Hydra, but is identifiable via CPA. Possible only after atleast 1 pod is in Managed state
    SUBSCRIBED,// Connected to Hydra without domain configuration or domains are not visible to pod
    MONITORED, // All domains are visible to pod
    MANAGED   // Pod is cloud managed, can perform operations via Admin console (workspace etc management)


}


class ex3{

    public static PodState fromString(final String s) {
        return PodState.valueOf(s);
    }

    public static void main(String[] args) {
        try {
            String s = "MANAGED";
            System.out.println(fromString(s));
        }catch (Exception ex){
            System.out.println("Invalid enum type");
        }
    }
}