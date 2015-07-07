package com.example;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.agilecoders.wicket.webjars.request.resource.WebjarsCssResourceReference;
import de.agilecoders.wicket.webjars.request.resource.WebjarsJavaScriptResourceReference;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);
		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(JavaScriptHeaderItem.forReference(
				new WebjarsJavaScriptResourceReference("jquery/current/jquery.js")));
		response.render(CssHeaderItem.forReference(
				new WebjarsCssResourceReference("bootstrap/current/css/bootstrap.min.css")));
		response.render(CssHeaderItem.forReference(
				new WebjarsCssResourceReference("bootstrap/current/css/bootstrap-theme.min.css")));
		response.render(JavaScriptHeaderItem.forReference(
				new WebjarsJavaScriptResourceReference("bootstrap/current/js/bootstrap.min.js")));
	}

}
