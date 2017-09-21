package istic.m2ila.taa.tp1b;

import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

//import io.swagger.jaxrs.config.BeanConfig;
import io.undertow.Undertow;

/**
 * Hello world!
 *
 */
public class App extends Application 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	
    	
    	UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.deploy(new App());

//        BeanConfig beanConfig = new BeanConfig();
//        beanConfig.setVersion("0.0.0-alpha");
//        beanConfig.setSchemes(new String[]{"http"});
//        beanConfig.setHost("localhost:8080");
//        beanConfig.setBasePath("/");
//        beanConfig.setResourcePackage("web.rest");
//        beanConfig.setScan(true);
//        beanConfig.setPrettyPrint(true);

        server.start(Undertow.builder().addHttpListener(8080, "0.0.0.0"));
    }
}
