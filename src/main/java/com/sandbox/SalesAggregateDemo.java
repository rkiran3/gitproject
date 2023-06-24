package com.sandbox;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Convert Array of primitive integers to List of Integer Objects
 */

@AllArgsConstructor
@Getter
@Setter
class SalesItem {
    private Integer id;
    public String salesYr;  // Sales-0, Sales-1, Sales-2
    public String status;  // "Open" or "Closed"
    public Integer amount;  // Sales amount

    public String toString() {
        return this.id + " " + this.salesYr + " " + this.status + " " + this.amount;
    }
}

public class SalesAggregateDemo {

    private static final Logger logger = Logger.getLogger(SalesAggregateDemo.class.getName());

    public static void main(String[] args) {
        logger.info("Starting program");
        List<String> statuses = Arrays.asList("Open", "Closed");
        List<Integer> years = IntStream.range(2010, 2015)
            .boxed()
            .collect(Collectors.toList());
            
        SalesAggregateDemo sad = new SalesAggregateDemo();
        Random random = new Random();

        String randYr = String.valueOf(years.get(random.nextInt(years.size())));

        // Create a list of SalesItem
        List<SalesItem> salesItemList = IntStream.rangeClosed(0, 10)
                .mapToObj(i -> new SalesItem(i, 
                    "Sales-" + String.valueOf(years.get(random.nextInt(years.size()))),
                    statuses.get(random.nextInt(statuses.size())),
                    random.nextInt(1000)
                    ))
                .collect(Collectors.toList());

        logger.info("Size: " + salesItemList.size());


        Map<String, List<SalesItem>> sm = salesItemList.stream() 
            .collect(Collectors.groupingBy(SalesItem::getSalesYr));

        logger.info("Printing grouping by Sales Year ");
        for (Map.Entry<String, List<SalesItem>> entry : sm.entrySet()) {
            System.out.println(entry.getKey());
            List<SalesItem> siList = entry.getValue();
            siList.forEach(System.out::println);
        }
    }
}
