/**
 * 
 */
package com.softserve.edu.library2.config;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author Назік
 *
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { HibernateConfig.class, AppConfig.class, SpringDataConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppSpringConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {

		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] { characterEncodingFilter };
	}

	/**
	 * Add handling 404 Exception
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");
	}

}
