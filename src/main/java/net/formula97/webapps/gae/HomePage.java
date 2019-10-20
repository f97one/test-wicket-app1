package net.formula97.webapps.gae;

import javax.ejb.EJB;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.formula97.webapps.gae.ejbBean.EnterpriseMessage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	@EJB
	private EnterpriseMessage enterpriseMessage;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Label("message", Model.of(enterpriseMessage.message)));
		add(new Label("versionCode", Model.of(enterpriseMessage.versionCode)));
	}

}
