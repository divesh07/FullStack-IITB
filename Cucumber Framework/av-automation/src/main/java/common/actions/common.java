package common.actions;

import AVMConfiguration.cucumber.tests.ui.Storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import common.actions.constants;
import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.mo.ClusterComputeResource;
import com.vmware.vim25.mo.Datacenter;
import com.vmware.vim25.mo.Datastore;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.VirtualMachine;


public class common extends BaseClass{
    public static final Logger log = Logger.getLogger(common.class);
    static WebDriver FFDriver = GetFFDriver();

    public common() throws MalformedURLException, RemoteException {
    }

    public static boolean WaitForObjectEnabled(String Object_Id, int WAITTIME){
        WebDriverWait wait = new WebDriverWait(FFDriver, WAITTIME);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(Object_Id)));// instead of id u can use cssSelector or xpath of ur element.
        return true;
    }

    public static boolean WaitForObjectEnabled(String Object_Id){
        log.info("Wait till the page or object is loaded");
        WebDriverWait wait = new WebDriverWait(FFDriver, constants.WAITDEFAULTTIME);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(Object_Id)));
        return true;
    }

    //public static String RunClurl(String UploadArgs, String cookieParams) throws IOException {
    public static String RunClurl() throws IOException {
        String curlPath = constants.PathToCurl;
        String response = "";
        String cookieParams = "";
        String passCookie = "-b c:\\Test_Root\\SvService\\cookie.txt";
        String startCookie = "-c c:\\Test_Root\\SvService\\cookie.txt";

        Process CurlProc = new ProcessBuilder(curlPath, cookieParams).start();

        Runtime rt = Runtime.getRuntime();
        String[] commandAndArguments = {"ipconfig","/all"};
        try {
            Process p = rt.exec(commandAndArguments);
            //response = readProcessOutput(p);
            log.info(response);


        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

//    public static String readProcessOutput(Process p) throws Exception{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
//        String response = "";
//        String line;
//        while ((line = reader.readLine()) != null) {
//            response += line+"\r\n";
//        }
//        reader.close();
//        return response;
//    }

    public static void ConnectToVC() throws MalformedURLException, RemoteException {
        ServiceInstance si = new ServiceInstance(new URL("https://10.112.19.9/sdk"), "root", "ca$hc0w", true);
        //System.out.println(si);

        Folder rootFolder = si.getRootFolder();

        //Note: It is expected to pass all the parameters as per your environment

        //Getting hold of a datacenter in vCenter server
        String dcName = "IND-BLR";
        Datacenter datacenter = null;
        datacenter = (Datacenter) new InventoryNavigator(rootFolder).searchManagedEntity("Datacenter", dcName);
        System.out.println("Data center Name::" + datacenter.getName());

        //Getting hold of All datacenters in vCenter server
        ManagedEntity[] dcenters = new InventoryNavigator(rootFolder).searchManagedEntities("Datacenter");
        System.out.println("Number of Datacenters in vCenter::" + dcenters.length);

        //Getting hold of a host in vCenter server
        String hostName = "10.192.34.2";
        HostSystem host = null;
        host = (HostSystem) new InventoryNavigator(rootFolder).searchManagedEntity("HostSystem", hostName);
        System.out.println("Host Name::" + host.getName());

        //Getting hold of  All hosts in vCenter server
        ManagedEntity[] hosts = new InventoryNavigator(rootFolder).searchManagedEntities("HostSystem");
        System.out.println("Number of hosts in vCenter ::" + hosts.length);


        //Getting hold of a cluster in vCenter server
        String clusterName = "My-Cluster";
        ClusterComputeResource cluster = null;
        cluster = (ClusterComputeResource) new InventoryNavigator(rootFolder)
                .searchManagedEntity("ClusterComputeResource", hostName);
        System.out.println("Cluster Name::" + cluster.getName());

        //Getting hold of All clusters in vCenter server
        ManagedEntity[] clusters = new InventoryNavigator(rootFolder)
                .searchManagedEntities("ClusterComputeResource");
        System.out.println("Number of clusters in vCenter ::" + clusters.length);

        //Getting hold of a datastore in vCenter server

        String DSName = "VMFS_3";
        Datastore datastore = null;
        datastore = (Datastore) new InventoryNavigator(rootFolder).searchManagedEntity("Datastore", DSName);
        System.out.println("Datastore Name::" + datastore.getName());

        //Getting hold of All datastores in vCenter server
        ManagedEntity[] datastores = new InventoryNavigator(rootFolder).searchManagedEntities("Datastore");
        System.out.println("Number of datastores in vCenter ::" + datastores.length);


        //Getting hold of a VM in vCenter server
        String VMName = "My-VM";
        VirtualMachine vm = null;
        vm = (VirtualMachine) new InventoryNavigator(rootFolder).searchManagedEntity("VirtualMachine", VMName);
        System.out.println("VM Name::" + vm.getName());

        //Getting hold of  All VMs in vCenter server
        ManagedEntity[] vms = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
        System.out.println("Number of VMs in vCenter ::" + vms.length);

        //Getting hold of a Resource pool in vCenter server
        String ResourcePoolName = "My-RP";
        VirtualMachine rpool = null;
        rpool = (VirtualMachine) new InventoryNavigator(rootFolder).searchManagedEntity("ResourcePool", ResourcePoolName);
        System.out.println("VM Name::" + rpool.getName());

        //Getting hold of All resource pool in vCenter server
        ManagedEntity[] rpools = new InventoryNavigator(rootFolder).searchManagedEntities("ResourcePool");
        System.out.println("Number of VMs in vCenter ::" + rpools.length);

        si.getServerConnection().logout();
    }

}
