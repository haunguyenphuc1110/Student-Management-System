package control;

//This  class for read and get JNDI Java Naming Directory Interface 

import edu.tdt.service.SystemLogin;
import edu.tdt.service.SystemLoginRemote;
import java.io.*;
import java.util.*;
import javax.naming.*;

public class InitialStatelessLogin{

    private Properties props;
    private InitialContext ctx;

    public InitialStatelessLogin() {
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
        String sessionBeanName = SystemLogin.class.getSimpleName();
        String viewClassName = SystemLoginRemote.class.getName();

        return "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + sessionBeanName + "!" + viewClassName;
    }
}
