package com.bd.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
/*
 * 이 클래스는 Database 에 대한 접속 정보를 나타내고, 일반 Bean 이 나닌 Configuration으로 설정되어 있어야 한다.
 */
@MapperScan(basePackages = "com.bd.dao")
/*
 * 최신 Spring Boot 에서는 dao를 dao라고 명시하지 않고, mapper 라는 이름으로 별도 정의하고 있다. 따라서 어떤
 * 패키지에서 mapper들을 scan할 것인가를 최상위에 annotation으로 정의하여 주고 있다. 다중 Database에 접근해야 하는
 * 경우, 이 클래스를 두 개를 만들어 두고 scan할 대상 mapper 들을 패키지 구조상에서 분리해 두는 것도 하나의 방법이라고 할 수
 * 있다.
 */

@PropertySource("classpath:/application.properties")
public class MyBatisConfig {
	
	@Autowired
	private ApplicationContext applicationContext;

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}

	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new HikariDataSource(hikariConfig());
		return dataSource;
	}
	
    @Bean
	/*
	 * DataSource 를 parameter로 받아, sqlSessionFactory를 생성하는 Bean 이다. 아래 있는
	 * SqlSessionTemplate Bean 생성 시 인자로 넘겨주기 위해서 사용된다. 즉, 여기서 만들어진 기본정보, 설정값 등을 이용해서
	 * SqlSessionTemplate를 만들게 되는 것이다
	 */
    public SqlSessionFactory sqlSessionFactory (DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.setTypeAliasesPackage("com.bd.model");
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
        sqlSessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
		/*
		 * 실제 Query 문이 존재하는 xml파일들의 위치를 지정해 준다. 여기서는 /mapper 폴더 하위에 있는 모든 xml을 명시했다. 이
		 * 경로는 실제로는 src/main/resource 하위에 존재한다. ①이 폴더 구조 자체가 생성되어 있지 않거나, ②그 폴더에 mapper
		 * xml 이 하나도 없으면, ③혹은 그 xml 의 문법에 오류가 있으면 초기 구동 시점에 에러가 발생한다. 즉, 초기에 mapper들의 위치
		 * 정보만을 지정하는 것이 아니라, 해당 mapper xml 들에 오류가 있는지 문법 체크까지 모두 한 뒤에 Factory가 생성되게 되는
		 * 것이므로, 이 부분을 다룰 때에는 중간중간 실행하여 오류가 발생하지는 않는지 꼭 확인하면서 지나가야 한다
		 */
        return sqlSessionFactory.getObject();
    }
    
    @Bean
	/* 실제 DB접속에 이용되는 SqlSessionTemplate를 생성하여 반환하는 Bean 이다. 실제 코드상에서 이용된다고 보면 된다. */
    public SqlSessionTemplate sqlSession (SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
