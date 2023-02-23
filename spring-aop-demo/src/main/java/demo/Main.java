package demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext context
				= new AnnotationConfigApplicationContext(BeanConfig.class);
		ShoppingCart cart= context.getBean(ShoppingCart.class);
		cart.checkout("CANCELLED");
		
		
//		This will print out the list of all beans that are available in the application context,
//		which may help you identify any issues with the bean registration.
		
//		String[] beanNames = context.getBeanDefinitionNames();
//		for (String beanName : beanNames) {
//		    System.out.println(beanName);
//		}

				
	}
}