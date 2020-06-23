# Table of Contents

1. [Print each entry in a HashMap](#phm)
2. [Print filtered entries in a HashMap](#pfem)
3. [Process each entry in a Map](#pem)
4. [Filter a List of Maps](#flm)

# Print each entry in a HashMap <a name="phm"></a>
To print key value pairs in a HashMap use the entrySet and print each entry.

<pre>

Map<String, Integer> testMap = new HashMap<String, Integer>();
testMap.put("January", 31);
testMap.put("February", 28);

testMap.entrySet()
    .forEach(entry -> System.out.printf("%s:%d\n", entry.getKey(), entry.getValue()));

</pre>

Example [Code](../JavaExamples/src/main/java/com/sandbox/java8/HashMapExercise.java)

# Print filtered entries in a HashMap <a name="pfem"></a>
To print key value pairs in a HashMap use the entrySet and print each entry.

<pre>

Map<String, Integer> testMap = new HashMap<String, Integer>();
testMap.put("January", 31);
testMap.put("February", 28);

// print only months that have value > 28
testMap.entrySet().stream()
    <b> .filter(entry -> entry.getValue() > 28)  </b>
    .forEach(entry -> System.out.printf("%s:%d\n", entry.getKey(), entry.getValue()));

</pre>

Another example is to filter only entries that have String values
<pre>

testMap.entrySet().stream()
    <b>.filter(entry -> entry.getValue() instanceof String) </b>
    .forEach(entry -> System.out.printf("%s %s\n", entry.getKey(), (String)entry.getValue()));
    
</pre>

Example [Code](../JavaExamples/src/main/java/com/sandbox/java8/HashMapExercise.java)



# Process each entry in a List of Maps <a name="pem"></a>

When we have a list where each entry is a Map, we can process them by converting the List into a stream and processing each entry.

In this example, we will create two Maps with key value pairs, then add the Maps to a List.

<pre>
List <Map<String, Integer>> listOfMaps = new ArrayList<Map<String, Integer>>();

<b>Map <String, Integer> tmpMap = new HashMap<String, Integer>();</b>
tmpMap.put("revenue", 21);
tmpMap.put("loss", 3);

// Add the map to List
<b>listOfMaps.add(tmpMap);</b>
</pre>

Example showing processing of each element in List: [Code](../JavaExamples/src/main/java/com/Scratch.java)

    List <Map<String, Integer>> listOfMaps = new ArrayList<Map<String, Integer>>();
    
    Map <String, Integer> tmpMap = new HashMap<String, Integer>();
    tmpMap.put("revenue", 21);
    tmpMap.put("loss", 3);
    // Add the map to List
    listOfMaps.add(tmpMap);
    
    Map <String, Integer> tmpMap2 = new HashMap<String, Integer>();
    tmpMap2.put("revenue", 00);
    tmpMap2.put("loss", 20);
    // Add the map to List
    listOfMaps.add(tmpMap2);
    
    // Process List of Maps
    List <Integer> revenueList = listOfMaps.stream()
        .map(x -> x.get("revenue"))     // process each entry, get desired attribute
        .collect(Collectors.toList());  //
    revenueList.stream()
        .forEach(System.out::println);
    
    // total revenue
    Integer sum = revenueList.stream()
        .reduce(0, Integer::sum);       // total all the revenue amounts
    System.out.println("Sum: " + sum);

    
# Filter a List of Maps <a name="flm"></a>

We can filter a list of Maps and get only the interested entries, for example to get a subset of entries that match a criteria - we can convert the list to a Stream and then apply the filter method to each entry.  
[Code](../JavaExamples/src/main/java/com/sandbox/ListOfMapsFilterDemo.java)




	// Now filter the List of Maps and get only the "valid" entries
	List <Map<String, Object>> resultList = listOfMaps.stream()
    <b>.filter(m -> (Boolean)m.get("valid")) </b>
    .collect(Collectors.toList());

	// Verify results
	if (resultList.size() > 0) {
		System.out.println("Found values: ");
		resultList.stream()
			.forEach(m -> System.out.println((Integer)m.get("revenue")));
	}
