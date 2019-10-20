package net.formula97.webapps.gae;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.crypt.CharEncoding;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 *
 * @see net.formula97.webapps.gae.Start#main(String[])
 */
@SpringBootApplication
public class WicketApplication extends WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WicketApplication.class, args);
    }

    /**
     * @see org.apache.wicket.Application#getHomePage()
     */
    @Override
    public Class<? extends WebPage> getHomePage() {
        return HomePage.class;
    }

    /**
     * @see org.apache.wicket.Application#init()
     */
    @Override
    public void init() {
        super.init();

        // Spring Injection
        getRequestCycleSettings().setResponseRequestEncoding(CharEncoding.UTF_8);
        getMarkupSettings().setDefaultMarkupEncoding(CharEncoding.UTF_8);

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        //Scan package for annotated beans
        ctx.scan("net.formula97.webapps.gae.ejbBean");
        ctx.refresh();

        getComponentInstantiationListeners().add(new SpringComponentInjector(this, ctx));
    }
}
