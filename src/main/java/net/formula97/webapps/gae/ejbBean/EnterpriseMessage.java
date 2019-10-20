package net.formula97.webapps.gae.ejbBean;

import javax.annotation.ManagedBean;

@ManagedBean
public class EnterpriseMessage {

    public String message = "Welcome to the Spring-Integrated world!";
    public String versionCode = System.getProperty("java.version");
}
