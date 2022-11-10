package orm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {
	
	@Bean
	MyBean myBean() {
		MyBean myBean = new MyBean();
		myBean.setMyInt(0);
		myBean.setMyString("bean demo");
		myBean.setMyDouble(0);
		
		return myBean;
	}
}
