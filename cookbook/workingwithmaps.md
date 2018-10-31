# Table of Contents
1. [Process each entry in a Map](#pem)


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
