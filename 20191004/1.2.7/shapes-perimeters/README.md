### Concrete, Abstract and Interface Class Implementations

#### Concrete Approach
The concrete approach does not allows for multiple inheritance. You can only `extend` one parent per class. By definition, a concrete class cannot have any unimplemented methods. This method is much less flexible than an interface implementation. In the concrete approach, the parent class can be instantiated as it's own standalone object, since it is just a standard class.

#### Abstract Approach
The abstract approach, much like a concrete approach, does not allow for multiple inheritance. Therefore, you cannot `extend` more than one abstract class. When implementing abstract classes, you must override all methods defined in the superclass. Non-abstract methods of the superclass are inherited just as they are defined. Abstract classes also cannot be instantiated on their own. 
 
#### Interface Approach
The interface approach is the most flexible of the three implementations. This is the only "blueprint" that can be combined with other interfaces in a single class. The concrete child class can `implement` multiple interfaces. Java interfaces can inherit from other interfaces, making them highly flexible/customizable. Interfaces, like abstract classes, cannot be instantiated as standalone objects, and all methods inherited from the parent must be declared.

#### Conclusion
The main benefit of any type of inheritance in Java is abstraction. Similar classes can abstract away certain recurring functionality to make code more readable and easier to navigate. After experimenting with various different forms of inheritance, interfaces appear to offer the the beneficial features of abstraction, without limiting a user by only allowing one class to be extended. Multiple inheritance is the most obvious benefit of interfaces, and the main reason why it seems to be the "best" option compared to concrete or abstract inheritance.