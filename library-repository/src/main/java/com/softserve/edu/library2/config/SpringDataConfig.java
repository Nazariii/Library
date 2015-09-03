/**
 * 
 */
package com.softserve.edu.library2.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Hibernate configuration using java-style spring
 * 
 * @author Назік
 * 
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.softserve.edu.library2.repository")
@ComponentScan({ "com.softserve.edu.library2.config" })
@PropertySource(value = "classpath:hibernate.properties")
public class SpringDataConfig {

	@Autowired
	private Environment environment;

	/**
	 * Configure jdbc for spring data data source
	 * 
	 * @return
	 */
	@Bean
	public DataSource springDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
		dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
		dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	/**
	 * Configure Hibernate
	 * 
	 * @return
	 */
	private Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
		return properties;
	}

	/**
	 * Entity manager configuration
	 * 
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emBean = new LocalContainerEntityManagerFactoryBean();
		emBean.setDataSource(springDataSource());
		emBean.setPackagesToScan(new String[] { "com.softserve.edu.library2.dao.entities" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emBean.setJpaVendorAdapter(vendorAdapter);
		emBean.setJpaProperties(hibernateProperties());
		emBean.afterPropertiesSet();

		return emBean;
	}

	/**
	 * 
	 * Create JPA transaction manager
	 * 
	 * @param factory
	 * @return
	 */
	@Bean(name = "JPAtx")
	//@Autowired
	public PlatformTransactionManager EntitytransactionManager(EntityManagerFactory factory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(factory);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}