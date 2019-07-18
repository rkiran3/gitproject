# Table of Contents
1. [Create a List of Integers from Array of primitive integers](#example)
2. [Create a List of Integers](#example2)
3. [Filter a List](#filterList)
4. [Create a List of Objects](#listObjects)
5. [Process each entry using map](#map01)
6. [Iterate a list and create a new LinkedList](#linked01)
7. [Iterate a List and create a Map](#listOfMaps01)
8. [Iterate a List and change value](#list01)

# Create a List of Integers from Array of primitive integers  <a name="example"></a>

Frequently, we need to create a list of Integers to test. In that case, we can use an array of primitive ints and use Arrays.stream() to create that stream.

Once we have a stream, we can then box each of those entries which will create an Integer Object. Finally, we can create a list of Integers.

Arrays.stream(array_of_ints).`boxed()`

<pre>
import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;

int [] priceArray = { 0, 100, 200, 300 };

// Convert from Array of primitive ints to List of Integers
List <Integer> intList = Arrays.stream(priceArray)
    <b>.boxed()</b>
    .collect(Collectors.toList());

assert(Arrays.asList(new Integer[]{0, 100, 200, 300})
    .equals(intList));
</pre>

# Create a List of Integers <a name  ="example2"></a>

We can create a List using:  **Arrays.asList(new Integer[]{11, 22, 33})**  


<pre>
import java.util.Arrays;
import java.util.stream.Stream;

//Create a list of Integers
contains  = <b>Arrays.asList(new Integer[]{11, 22, 33})</b>.stream()
    .mapToInt(Integer::valueOf)
    .anyMatch(i -> i                 == 33);        
assert(contains);
</pre>
We can also create them like `new ArrayList<>(Arrays.asList(1, 2, 3, 4))`
[Code](../JavaExamples/src/main/java/com/sandbox/ConstructListDemo.java)

    import java.util.List;
    import java.util.Arrays;
    import java.util.ArrayList;
    import java.util.stream.Stream;

    List <Integer> list              = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        
    // prints 1 2 3 4 on separate lines
    list.stream()
        .forEach(System.out::println);

# Filter a List <a name              ="filterList"></a>

To filter, we can use the `filter()` method and collect the entries that match a condition.
[Code](../JavaExamples/src/main/java/com/codingbat/ap1/WordsWithoutList.java)

<pre>
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// return a new list that match a condition
public static List <String> wordsWithoutList(String [] words, int len) {
    return (Arrays.asList(words)).stream()
            <b>.filter(s -> (s.length() != len))</b>
            .collect(Collectors.toList());
}

public static void main(String [] args) {
    String [] words                  = {"a", "bb", "b", "ccc"};
    assert(wordsWithoutList(words, 1)
        .equals(Arrays.asList("bb", "ccc"))) ; 
}
</pre>

# Create a List of Objects <a name   ="listObjects"></a>

Here we create a list of Month Objects using a stream. The Month object has a constructor that needs a String parameter, this parameter is passed when the List is created. 
[Code](../JavaExamples/src/main/java/com/sandbox/ExecMethodForEachDemo.java)

<pre>
// Object that represents a Month
class Month {
    public String name;
    public Month(String name) {this.name   = name; }
    public String getName() { return name; }
    public void setName(String name) { this.name                      = name; }
    public String toString() { return this.name; }
}

// Create a list of Strings
String [] monthsArr = { "November", "December" };

// Create a list of Month objects
Stream <Month> stream = Arrays.asList(monthsArr).stream()
    <b>.map(Month::new);</b>

// Invoke a method for each of the object, in this case - the method returns a String
// which is then collected into a List.
List <String> allMonthsList = stream
    .map(DemoClass::displayStr)
    .collect(Collectors.toList());
</pre>
        
# Process each entry using map  <a name="map01"></a>
When we need to process each entry of a Stream of String (for example extract a specific word in a String), we can use `map` to retrieve the word and store the result.

<pre>
String result  = Stream.of("jan,31", "feb,28")
    <b>.map(w->w.split(",")[1])</b>
    .collect(Collectors.joining(","));
    
// will print "31,28"    
</pre>

# Iterate a list and create a new LinkedList <a name="linked01"></a>
Using an existing list, we can iterate to create another List with a different type. For example, we could create a Linked List of objects. Notice in below example - a new LinkedList is created by going over objects in a list.
[Code](../JavaExamples/src/main/java/com/sandbox/java8/CollectorExercise07.java)
<pre>
Person john = new Person("John", 20);
Person sara = new Person("Sara", 21);
Person jane = new Person("Jane", 21);
Person greg = new Person("Greg", 35);
final List<Person> personList = Arrays.asList(
        john, sara, jane, greg
);

// Get ArrayList
List <Person> personArrayList = personList.stream()
    .filter(p -> p.getAge() < 30)
    .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);        
assertTrue(personArrayList.size() == 3);

// Get Linkedlist
List <Person> personLinkedList = personList.stream()
        .filter(p -> p.getAge() < 30)
        .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
assertTrue(personLinkedList.size() == 3);
</pre>

# Iterate a List and create a Map <a name="listOfMaps01"></a>
Using an existing list, we can iterate to create a map that consists of key corresponding to name, and value representing the Object.
<pre>
class Item {
    private String name;
    public Item(String name) {
        this.setName(name);
    }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
</pre>

<pre>
String names [] = { "Bob", "Greg" };
List <Item> itemList = Arrays.asList(names).stream()
    .map(Item::new)
    .collect(Collectors.toList());

// Create a Map with key=name,  value=Item Object
Map<String, Item> itemMap = itemList.stream()
    .collect(Collectors.toMap(Item::getName, i->i));
</pre>

# Iterate a List and change value <a name="list01"></a>
When we have a list of objects and need to change one of the objects attributes, we can use a `forEach` terminal option to change the value using its setter method.

In this example, we will create a list of Process Objects with "Inactive" status, later we change status of all objects to "Active" using `forEach()`.

<pre>
List <Process> processList = new ArrayList<Process>();
Process process1 = new Process("Inactive");
Process process2 = new Process("Inactive");
processList.add(process1);
processList.add(process2);

processList
    .forEach(System.out::println);  // prints "Active"

// use the forEach() since this is an terminal option
processList
    .forEach(p -> p.setStatus("Active"));   
    
processList
    .forEach(System.out::println);  // prints "InActive"

</pre>
