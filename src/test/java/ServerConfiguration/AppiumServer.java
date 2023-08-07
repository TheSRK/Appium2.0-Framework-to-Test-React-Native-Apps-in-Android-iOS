package ServerConfiguration;

import com.google.common.net.InetAddresses;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.HashMap;

public class AppiumServer {
    private static AppiumDriverLocalService server;

    private static AppiumDriverLocalService setInstance(){
        String nodePath = "/opt/homebrew/bin/node";
        String appiumPath = "/opt/homebrew/lib/node_modules/appium/build/lib/main.js";

        HashMap<String, String> environment = new HashMap<>();
        //path to carthage
        environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder
                .withAppiumJS(new File(appiumPath))
                .usingDriverExecutable(new File(nodePath))
                .usingPort(4723)
                .withEnvironment(environment)
                .withArgument (GeneralServerFlag.USE_PLUGINS, "element-wait")
                .withLogFile(new File("AppiumLog.txt"))
                .withIPAddress("127.0.0.1");
        server = AppiumDriverLocalService.buildService(builder);
        return server;
    }

    public static boolean isPortAvailable(int port) {
        //applicable for tcp ports
        try (ServerSocket serverSocket = new ServerSocket()) {
            // setReuseAddress(false) is required only on OSX,
            // otherwise the code will not work correctly on that platform
            serverSocket.setReuseAddress(false);
            serverSocket.bind(new InetSocketAddress(InetAddress.getByName("localhost"), port), 1);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private static AppiumDriverLocalService getInstance(){
        if (server ==null){
            return setInstance();
        }
         else {
             return server;
        }
    }
    //start Appium server
    public static boolean start(){
        if (isPortAvailable(4723)){
            getInstance().start();
            server.clearOutPutStreams();
            System.out.println("*****Appium server started*****");
            System.out.println("*****Appium server URL: "+server.getUrl()+"*****");
            return true;
        }else {
            return false;
        }
    }
    //Stop Appium server
    public static boolean stop(){
        if (server != null){
            getInstance().stop();
            System.out.println("*****Appium server stopped*****");
            return true;
        }
        else {
            return false;
        }
    }

//    public static void main(String[] args) throws InterruptedException {
//        System.out.println(start());
//        Thread.sleep(1000);
//        System.out.println(stop());
//
//    }
}
