package learning.spring.helloworld;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public class Application {
    private BeanFactory beanFactory;

    public static void main(String[] args) {
        Application application = new Application();
        application.sayHello();
    }

    public Application() {
        beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader =
                new XmlBeanDefinitionReader((DefaultListableBeanFactory) beanFactory);
        reader.loadBeanDefinitions("beans.xml");
    }

    public void sayHello() {
        Hello hello = (Hello) beanFactory.getBean("hello");
        System.out.println(hello.hello());
    }
}
