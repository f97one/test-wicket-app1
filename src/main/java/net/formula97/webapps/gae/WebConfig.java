package net.formula97.webapps.gae;

import org.apache.wicket.protocol.http.WicketFilter;
import org.apache.wicket.spring.SpringWebApplicationFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class WebConfig implements ServletContextInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        FilterRegistration registration = servletContext.addFilter("wicket.test-wicket-app1", WicketFilter.class);
        registration.setInitParameter(WicketFilter.APP_FACT_PARAM, SpringWebApplicationFactory.class.getName());
        registration.setInitParameter("applicationBean", "wicketApplication");
        registration.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
        registration.addMappingForUrlPatterns(null, false, "/*");
        registration.setInitParameter("configuration", "development");
    }
}
