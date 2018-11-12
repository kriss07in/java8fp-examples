# java8fp-examples
Java8 Functional Programming Examples - Self reference only!

JDK 8 has following (some) functional interfaces: <br>
1. Function<T, R> <br>
A transformational interface that represents an operation intended to take in an argument and return an appropriate result <br>
2. Supplier<T> <br>
A factory that’s expected to return either a new instance or a precreated instance <br>
3. Consumer<T> <br>
Represents an operation that will accept an input and returns nothing. For this to be useful, it will have to cause side effects. <br>
4. Predicate<T> <br>
Useful for checking if an input argument satisfies some condition <br>
<br>

Defining a Functional Interface<br>
@FunctionalInterface<br>
public interface TailCall<T> {<br>
  TailCall<T> apply();<br>
  default boolean isComplete() { return false; }<br>
}<br>
A functional interface must have one abstract—unimplemented—method. It may have zero or more default or implemented methods. It may also have static methods.<br>

Defining a Functional Interface<br>
@FunctionalInterface<br>
public interface TailCall<T> {<br>
TailCall<T> apply();<br>
default boolean isComplete() { return false; }<br>
}<br>
A functional interface must have one abstract—unimplemented—method. It may have zero or more default or implemented methods. It may also have static methods.<br>
  
Creating a Single-Parameter Lambda Expression<br>
list.forEach((final String name) -> System.out.println(name)); <br>

Inferring a Lambda Expression’s Parameter Type<br>
list.forEach((name) -> System.out.println(name));<br>

Dropping Parentheses for a Single-Parameter Inferred Type <br>
list.forEach(name -> System.out.println(name)); <br>

Creating a Multi-Parameter Lambda Expression <br>
list.stream().reduce((name1, name2) -> name1.length() >= name2.length() ? name1 : name2); <br>

Calling a Method with Mixed Parameters <br>
list.stream().reduce("Steve", (name1, name2) -> name1.length() >= name2.length() ? name1 : name2);  <br>

Storing a Lambda Expression <br>
final Predicate<String> startsWithN = name -> name.startsWith("N"); <br>
  
Creating a Multiline Lambda Expression <br>
FileWriterEAM.use("eam2.txt", writerEAM -> { <br>
  writerEAM.writeStuff("how"); <br>
  writerEAM.writeStuff("sweet"); <br>
}); <br>

Returning a Lambda Expression <br>
public static Predicate<String> checkIfStartsWith(final String letter) { <br>
  return name -> name.startsWith(letter); <br>
} <br>
  
Returning a Lambda Expression from a Lambda Expression <br>
final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter); <br>

Lexical Scoping in Closures <br>
public static Predicate<String> checkIfStartsWith(final String letter) { <br>
  return name -> name.startsWith(letter); <br>
} <br>

Passing a Method Reference of an Instance Method <br>
list.stream().map(String::toUpperCase); <br>
list.stream().map(name -> name.toUpperCase()); <br>

Passing a Method Reference to a static Method <br>
str.chars().filter(Character::isDigit); <br>
str.chars().filter(ch -> Character.isDigit(ch)); <br>

Passing a Method Reference to a Method on Another Instance <br>
str.chars().forEach(System.out::println); <br>
str.chars().forEach(ch -> System.out.println(ch)); <br>

Passing a Reference of a Method That Takes Parameters <br>
list.stream().sorted(Person::ageDifference) <br>
list.stream().sorted((person1, person2) -> person1.ageDifference(person2)) <br>

Using a Constructor Reference <br>
Supplier<Heavy> supplier = Heavy::new; <br>
Supplier<Heavy> supplier = () -> new Heavy(); <br>
  
Function Composition <br>
symbols.map(StockUtil::getPrice).filter(StockUtil.isPriceLessThan(500)).reduce(StockUtil::pickHigh).get(); <br>

Lambda expressons:<br>
A lambda expression can receive zero, one or more parameters.<br>
The type of the parameters can be explicitly declared or it can be inferred from the context.<br>
Parameters are enclosed in parentheses and separated by commas.<br>
Empty parentheses are used to represent an empty set of parameters.<br>
When there is a single parameter, if its type is inferred, it is not mandatory to use parentheses.<br>
The body of the lambda expression can contain zero, one or more statements.<br>
When there is a single statement curly brackets are not mandatory and the return type of the anonymous function is the same as that of the body expression.<br>
When there is more than one statement then these must be enclosed in curly brackets (a code block) and the return type of the anonymous function is the same as the type of the value returned within the code block, or void if nothing is returned.<br>

 - Ref Examples on Web/Java8 Docs/Other docs on the internet...!
