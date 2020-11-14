### Use anyMatch to match any entry in list

To match any entry in a list, use `anymatch`

        import java.util.Arrays;
        import java.util.stream.Stream;
        
        // Create a list of Integers and use anymatch,
        // this returns true/false
        contains = Arrays.asList(new Integer [] {11, 22, 33}).stream()
            .mapToInt(Integer::valueOf)
            .anyMatch(i -> i == 33);
        assert(contains);

Without using streams, we can do a quick check using `contains`

```java
// will return true if it finds entry in the List
contains = Arrays.asList(new Integer [] {11, 22, 33})
    .contains(33);
assert(contains)
```

        