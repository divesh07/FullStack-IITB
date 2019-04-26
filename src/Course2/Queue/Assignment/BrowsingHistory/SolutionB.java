package Assignment.BrowsingHistory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


class SiteStats {
    private String url;
    private int numVisits;

    /**
     * Constructor for the SiteStats class
     *
     * @param url       String that represents an URL that the user has visited
     * @param numVisits An int that represents the number of times that the user has
     *                  visited the url
     */
    public SiteStats(String url, int numVisits) {
        this.url = url;
        this.numVisits = numVisits;
    }

    /**
     * This method returns the number of times that the user has visited the url.
     *
     * @return An int that represents the number of times that the user has visited
     * the url
     */
    public int getNumVisits() {
        return this.numVisits;
    }

    /**
     * This method returns the url that we are currently tracking
     *
     * @return A String that represents the url that we are currently tracking
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * This method updates the number of times that we have visited the url
     *
     * @param an int that represents the number that we want to set numVisits to
     */
    public void setNumVisits(int updatedNumVisits) {
        this.numVisits = updatedNumVisits;
    }

    public String toString() {
        return this.url + " | " + this.numVisits;
    }

}

public class SolutionB {

    private static Queue<SiteStats> sites = new LinkedList<SiteStats>();

    // Main method to list top n visited sites
    public static void listTopVisitedSites(Queue<SiteStats> sites, int n) {
        // WRITE CODE HERE
        if (!sites.isEmpty()) {
            if (sites.size() >= n){
                int max =0 ;
                Stack<String> stack = new Stack<>();

                for ( int i =1 ; i<=n ; i++){
                    SiteStats site = sites.remove();
                    if ( site.getNumVisits() == sites.peek().getNumVisits()){
                        stack.add(site.getUrl());
                    }else {
                        System.out.println(site.getUrl());
                        if (!stack.isEmpty()) {
                            while(!stack.isEmpty()) {
                                System.out.println(stack.pop());
                            }
                        }
                    }

                    // print in correct order , the element last in the queue are more recent
                    // if the count is same : print the last first
                    //System.out.println(sites.remove().getUrl());

                }

            }else{
                // print all the elements
                while(!sites.isEmpty()){
                    SiteStats site = sites.remove();
                    System.out.println(site.getUrl());
                }
            }
        }
    }

    public static void removeLastElement(SiteStats lastElement){
        int count = 1;
        while(!sites.isEmpty() || count < sites.size()){
            if ( sites.peek().getUrl().equalsIgnoreCase(lastElement.getUrl())){
                sites.remove();
            }else{
                sites.add(sites.remove());
            }
            count++;
        }
    }

    public static void correctOrder( SiteStats lastElement , int n){
        // last element is the latest updated element
        // iterate ver queuelength -1
        System.out.println("Current queue length" + sites.size());
        Queue<SiteStats> tmp = new LinkedList<>();
        if( sites.size() <= 1 ){
            return;
        }
        for ( int i= 1; i< sites.size() ; i++){
            SiteStats site = sites.peek();
            if( site.getNumVisits() < lastElement.getNumVisits()){
                sites.add(sites.remove());
            }else{

                // A bigger element is found
                // This is leading to incorrect order
                System.out.println("Inside Max Min correction");
                System.out.println("Comparing against" + n);

                Queue<SiteStats> maxElement = new LinkedList<SiteStats>();
                Queue<SiteStats> minElement = new LinkedList<SiteStats>();

                while(!sites.isEmpty()){
                    site = sites.peek();
                    if (site.getNumVisits() >= lastElement.getNumVisits()) {
                        maxElement.add(sites.remove());
                    }else{
                        minElement.add(sites.remove());
                    }
                }
                //sites.clear();
                System.out.println("Print both max and min");
                System.out.println(maxElement);
                System.out.println(minElement);

                if (maxElement.size() > 0){
                    while(!maxElement.isEmpty()){
                        sites.add(maxElement.remove());
                    }
                }

                if (minElement.size() > 0){
                    while(!minElement.isEmpty()){
                        sites.add(minElement.remove());
                    }
                }

                return;
            }
        }
    }

    // Method to find the website in the queue and increment the visited count by 1, adding new node in case website is not found
    public static void updateCount(String url) {
        // WRITE CODE HERE
        if (sites.isEmpty()) {
            // This is the first element in the queue and hence add this node to the queue
            SiteStats site = new SiteStats(url, 1);
            sites.add(site);
        }else{
            boolean siteFound = false;
            for ( int i =1 ; i<= sites.size(); i++) {
                // Check if the site object with the given url exists in the queue
                SiteStats site = sites.remove();
                if (site.getUrl().equalsIgnoreCase(url)){
                    site.setNumVisits(site.getNumVisits()+1);
                    siteFound = true;
                    sites.add(site);
                    System.out.println("Before order correction");
                    System.out.println(sites);
                    // call update function here
                    correctOrder(site,site.getNumVisits());
                    System.out.println("Post order correction");
                    System.out.println(sites);
                    break;
                }else {
                    sites.add(site);
                }
            }
            if(!siteFound){
                // add the site
                SiteStats site = new SiteStats(url, 1);
                sites.add(site);
                //correctOrder(site.getNumVisits());
            }
        }
        //System.out.println(sites);
    }

    public static void main(String[] args) {
        String[] visitedSites = {"www.google.co.in", "www.google.co.in", "www.facebook.com", "www.upgrad.com", "www.google.co.in", "www.youtube.com",
                "www.facebook.com", "www.upgrad.com", "www.facebook.com", "www.google.co.in", "www.microsoft.com", "www.9gag.com", "www.netflix.com",
                "www.netflix.com", "www.9gag.com", "www.microsoft.com", "www.amazon.com", "www.amazon.com", "www.uber.com", "www.amazon.com",
                "www.microsoft.com", "www.upgrad.com"};

        for (String url : visitedSites) {
            updateCount(url);
        }
        listTopVisitedSites(sites, 5);

    }

}

