## What Is Inversion of Control?

Inversion of Control is a principle in software engineering which transfers the control of objects or portions of a
program to a container or framework. We most often use it in the context of object-oriented programming.

### Advantages of IoC:

* decoupling the execution of a task from its implementation
* making it easier to switch between different implementations
* greater modularity of a program
* greater ease in testing a program by isolating a component or mocking its dependencies, and allowing components to
  communicate through contracts

## What is DI?

Dependency injection is a pattern we can use to implement IoC, where the control being inverted is setting an object's
dependencies. Connecting objects with other objects, or “injecting” objects into other objects, is done by an assembler
rather than by the objects themselves.

## The Spring IoC Container

The Spring framework provides several implementations of the ApplicationContext interface:

* AnnotationConfigApplicationContext
* ClassPathXmlApplicationContext
* FileSystemXmlApplicationContext
* WebApplicationContext
* AnnotationConfigApplicationContext

## Spring Stereotype Annotations

* @Component: generic stereotype for any Spring-managed component
* @Repository: stereotype for persistence layer, provided exception translation
* @Service: stereotype for service layer
* @Controller: provides methods annotated with @RequestMapping
* @RestController: makes it easy to create RESTful services that return JSON objects.

## Spring Annotations covered
* @Autowired
* @Bean
* @Component
* @ComponentScan
* @Configuration
* @PostConstruct
* @PreDestroy
* @Primary
* @Qualifier
* @Repository
* @Scope
* @Service
* @Order


