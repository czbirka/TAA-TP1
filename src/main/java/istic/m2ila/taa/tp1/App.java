package istic.m2ila.taa.tp1;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

//import io.swagger.jaxrs.config.BeanConfig;
import io.undertow.Undertow;
import istic.m2ila.taa.tp1.web.rest.LieuResource;
import istic.m2ila.taa.tp1.web.rest.PersonResource;
//import web.rest.DepartementResource;
//import web.rest.EmployeeResource;
//import web.rest.SwaggerResource;

/**
 * Hello world!
 *
 */
public class App extends Application 
{
    public static void main( String[] args )
    {
    	
    	UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.deploy(new App());

        server.start(Undertow.builder().addHttpListener(8080, "0.0.0.0"));
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<Class<?>>();

        // REST endpoints
        resources.add(PersonResource.class);
        resources.add(LieuResource.class);

        return resources;
    }
}
