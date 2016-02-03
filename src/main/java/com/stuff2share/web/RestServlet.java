package com.stuff2share.web;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.container.filter.GZIPContentEncodingFilter;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class RestServlet extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {

		return Guice.createInjector( new ServletModule() {
			@Override
			protected void configureServlets() {

                Map<String, String> params = new HashMap<>();
                params.put(PackagesResourceConfig.PROPERTY_PACKAGES, "com.stuff2share.web.resource");
                //you can create your own filters to handle request and response differently
                params.put(ResourceConfig.PROPERTY_CONTAINER_REQUEST_FILTERS, GZIPContentEncodingFilter.class.getName());
                params.put(ResourceConfig.PROPERTY_CONTAINER_RESPONSE_FILTERS, GZIPContentEncodingFilter.class.getName());
				serve( "/v1/*" ).with( CustomGuiceContainer.class, params );

			}
		} );
	}
}
