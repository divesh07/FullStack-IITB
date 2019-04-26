package Examples;

import java.util.*;

public class EventNotifications {
    //emails need to be sent in the same order as the events were received, while the push notifications need to be sent in the opposite order
    static Stack<Event> pushNotificationStack = new Stack<Event>();
    static Queue<Event> emailQueue = new LinkedList<Event>();

    public static void storeEvent(Event event, String channel) {
        // Write code here
        if (channel.equalsIgnoreCase("push")){
            pushNotificationStack.add(event);
        }else if (channel.equalsIgnoreCase("email") ){
            emailQueue.add(event);
        }
    }

    public static void sendEmails() {
        // Write code here
        while(!emailQueue.isEmpty()){
            Event event = emailQueue.remove();
            event.sendAsEmail();
        }
    }

    public static void sendPushNotifications() {
        // Write code here
        while(!pushNotificationStack.isEmpty()){
            Event event = pushNotificationStack.pop();
            event.sendAsPushNotification();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String event_stream = scanner.nextLine();
        for (String event : event_stream.split(" ")) {
            String eventType = event.split("_")[0];
            switch (eventType) {
                case "sendMails":
                    sendEmails();
                    break;
                case "sendPushNotifications":
                    sendPushNotifications();
                    break;
                default:
                    String userId = event.split("_")[1];
                    String channel = event.split("_")[2];
                    storeEvent(new Event(userId, eventType), channel);
                    break;
            }
        }
    }
}

class Event {
    public String userId;
    public String eventType;

    public Event(String userId, String eventType) {
        this.userId = userId;
        this.eventType = eventType;
    }

    public void sendAsEmail() {
        System.out.println("Sent email to " + userId + " for event " + eventType);
    }

    public void sendAsPushNotification() {
        System.out.println("Sent push notification to " + userId + " for event " + eventType);
    }

}