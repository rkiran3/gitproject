# Table of Contents
1. [Create a List of Integers from Array of primitive integers](#example)
2. [Create a List of Integers](#example2)
3. [Filter a List](#filterList)
4. [Create a List of Objects](#listObjects)
5. [Process each entry using map](#map01)


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

# Create a List of Integers <a name="example2"></a>

We can create a List using:  **Arrays.asList(new Integer[]{11, 22, 33})**

    import java.util.Arrays;
    import java.util.stream.Stream;

    //Create a list of Integers
    contains = Arrays.asList(new Integer[]{11, 22, 33}).stream()
        .mapToInt(Integer::valueOf)
        .anyMatch(i -> i == 33);        
    assert(contains);

We can also create them like `new ArrayList<>(Arrays.asList(1, 2, 3, 4))`

    import java.util.List;
    import java.util.Arrays;
    import java.util.ArrayList;
    import java.util.stream.Stream;

    List <Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        
    // prints 1 2 3 4 on separate lines
    list.stream()
        .forEach(System.out::println);

# Filter a List <a name="filterList"></a>

To filter, we can use the `filter()` method and collect the entries that match a condition.
 
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;

    // return a new list that match a condition
    public static List <String> wordsWithoutList(String [] words, int len) {
        return (Arrays.asList(words)).stream()
                .filter(s -> (s.length() != len))
                .collect(Collectors.toList());
    }

    public static void main(String [] args) {
        String [] words = {"a", "bb", "b", "ccc"};
        assert(wordsWithoutList(words, 1)
            .equals(Arrays.asList("bb", "ccc"))) ; 
    }


# Create a List of Objects <a name="listObjects"></a>

Here we create a list of Month Objects using a stream. The Month object has a constructor that needs a String parameter, this parameter is passed when the List is created. 

    // Object that represents a Month
    class Month {
        public String name;
        public Month(String name) {this.name = name; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String toString() { return this.name; }
    }

    // Create a list of Strings
    String [] monthsArr = { "November", "December" };

    // Create a list of Month objects
    Stream <Month> stream = Arrays.asList(monthsArr).stream()
        .map(Month::new);

    // Invoke a method for each of the object, in this case - the method returns a String
    // which is then collected into a List.
    List <String> allMonthsList = stream
        .map(DemoClass::displayStr)
        .collect(Collectors.toList());

# Process each entry using map  <a name="map01"></a>
When we need to process each entry of a Stream of String (for example extract a specific word in a String), we can use `map` to retrieve the word and store the result.

<pre>
String result = Stream.of("jan,31", "feb,28")
    <b>.map(w->w.split(",")[1])</b>
    .collect(Collectors.joining(","));
    
// will print "31,28"    
</pre>