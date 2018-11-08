package control;

//This  class for read and get JNDI Java Naming Directory Interface 
import edu.tdt.service.SystemStudentManagement;
import edu.tdt.service.SystemStudentManagementRemote;
import java.io.*;
import java.util.*;
import javax.naming.*;

public class InitialStatelessGuest {

    private Properties props;
    private InitialContext ctx;

    public InitialStatelessGuest() {
        readJNDI();
    }

    public Properties getProps() {
        return props;
    }

    public InitialContext getCtx() {
        return ctx;
    }
    
    

    /**
     *
     * Read the JNDI properties file
     */
    private void readJNDI() {
        props = new Properties();

        try {
            props.load(new FileInputStream("jndi.properties"));
        } catch (IOException e) {
            e.getMessage();
        }

        try {
            ctx = new InitialContext(props);
        } catch (NamingException ex) {
            ex.getMessage();
        }
    }

    /**
     * Construct and return the JNDI address of called class
     *
     * @return String
     */
    public String getJNDI() {
        String appName = "";
        String moduleName = "StudentEJB";
        String distinctName = "";
        String sessionBeanName = SystemStudentManagement.class.getSimpleName();
        String viewClassName = SystemStudentManagementRemote.class.getName();

        return "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + sessionBeanName + "!" + viewClassName;
    }
}
