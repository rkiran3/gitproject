### Use anyMatch to match any entry in list

To match any entry in a list, use `anymatch`

<pre>
import java.util.Arrays;
import java.util.stream.Stream;

// Create a list of Integers and use anymatch,
// this returns a boolean true/false which can then be checked using assert
contains = Arrays.asList(new Integer [] {11, 22, 33}).stream()            
    .mapToInt(Integer::valueOf)
    <b>.anyMatch(i -> i == 33);</b>
    
assert(contains);
</pre>


Without using streams, we can do a quick check using `contains`

<pre>
// will return true if it finds entry in the List
contains = Arrays.asList(new Integer [] {11, 22, 33}).<b>contains(33);</b>
        
assert(contains)
</pre>