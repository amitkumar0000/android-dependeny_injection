# android-dependeny_injection

Dagger 2 DI

Dependency Injection
  It is mechanism to inject object to another object. Internally it uses Factory Patter to create Object.
  
  Constructor Injection, Field Injection and method Injection
  
  It is good to avoid injection on static methods and fields.
  
  Order in which Dependency injection is performed on a class:-
      Construction Injection
      Field Injection
      Method Injection
      
 Private field is not allowed for field injection     

Dagger 2 uses the following annotations:

@Module and @Provides: define classes and methods which provide dependencies

@Inject: request dependencies. Can be used on a constructor, a field, or a method

@Component: enable selected modules and used for performing dependency injection


