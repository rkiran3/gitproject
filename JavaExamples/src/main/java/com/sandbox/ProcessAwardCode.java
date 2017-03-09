package com.sandbox;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by ravikir
 */
public class ProcessAwardCode {

    public static void printAwardCodeMap(Map awardCodeMap) {
        Set<Map.Entry<String, Integer>> entrySet = awardCodeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry <String, Integer>entry = (Map.Entry)iterator.next();
            System.out.print(String.format("%s:%d    ", entry.getKey(), entry.getValue()));
        }
        System.out.println("");
        return;
    }

    public static void printSandboxItems(List <SandboxItem> items) {
        double totalDiscountApplied = 0.0;
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        for (SandboxItem item: items) {
            System.out.println(String.format("Discount:%6s   Price:%6s   PGCode: %4s   PE:%6s",
                    decimalFormat.format(item.getProratedDiscount()),
                    decimalFormat.format(item.getPrice()),
                    item.getPromoGroupCode(),
                    item.isProrationEligible()));
            totalDiscountApplied = totalDiscountApplied + item.getProratedDiscount();
        }
        System.out.println(
                String.format("Total:   %6s", decimalFormat.format(totalDiscountApplied)));
    }

    public static int getTotalAwardPromoCodes(Map <String, Integer> awardCodeMap){
        int totalPromoCodeItems = 0;
        Set<Map.Entry<String, Integer>> entrySet = awardCodeMap.entrySet();
        Iterator iterator = entrySet.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry) iterator.next();
            totalPromoCodeItems += entry.getValue();
        }

        return totalPromoCodeItems;
    }

    public static boolean markEligibleItems(List <SandboxItem> items, Map <String, Integer> awardCodeMap ) {
        boolean markSuccess = true;
        Set<Map.Entry<String, Integer>> entrySet = awardCodeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        //int totalAwardPromoCodes = getTotalAwardPromoCodes(awardCodeMap);
        Map<String, Integer> foundPromoCodes = new HashMap<String, Integer>();

        // printAwardCodeMap(awardCodeMap);
        // System.out.println("Printing items before Marking");
        // printSandboxItems(items);
        // Iterate through each PromoGroupCode found in AwardCode
        while (iterator.hasNext()) {
            Map.Entry <String, Integer>entry = (Map.Entry)iterator.next();
            int currOccur = 0; // running count of bracelets in items list
            int maxOccur = entry.getValue(); // max number of Bracelets to be prorated.
            String awardPromoCode = entry.getKey();

            for (SandboxItem item: items) {
                if (item.getPromoGroupCode().equals(awardPromoCode) &&
                        currOccur < maxOccur) {
                    item.setProrationEligible(true);
                    item.setProrateQualifiedQuantity(1);
                    currOccur++;
                }
            }

            foundPromoCodes.put(awardPromoCode, currOccur);
        }

        // if two hashmaps key-value don't match, no eligible items found
        for (String key: awardCodeMap.keySet()){
            if (!awardCodeMap.get(key).equals(foundPromoCodes.get(key))) {
                markSuccess = false;
            }
        }

        // if unsuccessful marking, reset their proration status to false.
        if (!markSuccess) {
            for (SandboxItem item: items) {
                String itemPromoGroupCode = item.getPromoGroupCode();
                if (awardCodeMap.containsKey(itemPromoGroupCode)) {
                    item.setProrationEligible(false);
                }
            }
        }
        System.out.println("Printing items after Marking");
        printSandboxItems(items);
        return markSuccess;
    }

    /**
     *
     */
    public static Map getAwardCodeMap(String awardCode) {
        Map awardCodeMap= new HashMap<String, Integer>();

        String [] awardTokens = awardCode.split("\\|");
        if (awardTokens != null) {

            for (String awardToken: awardTokens) {
                String [] promoGroupTokens = awardToken.split(":");

                if (promoGroupTokens != null && promoGroupTokens.length > 1) {
                    awardCodeMap.put(promoGroupTokens[0], new Integer(promoGroupTokens[1]));
                }
            }
        }

        return awardCodeMap;
    }

    public static void main(String [] args) {
        String awardCode = "BR29:1|CM:2";
        double discount = 49.00;

        Map<String, Integer> awardCodeMap = getAwardCodeMap(awardCode);
        //printAwardCodeMap(awardCodeMap);
        //System.out.println(awardCodeMap.containsKey("BR29"));
        int maxBraceletCount = 2;
        int maxCharmCount = 5;
        int currentBraceletCount = 0;
        int currentCharmCount = 0;
        List<SandboxItem> items = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            double randomPrice = new Random().nextDouble() * 100;
            SandboxItem item = new SandboxItem();
            item.setPrice(randomPrice);
            int randomInteger = (int) randomPrice;
            String promoGroupCode = randomInteger % 2 == 0 ? "CM" : "BR29";
            if (promoGroupCode.contains("CM") && currentCharmCount < maxCharmCount) {
                item.setPromoGroupCode("CM");
                currentCharmCount++;
            } else if (promoGroupCode.contains("BR") && currentBraceletCount < maxBraceletCount) {
                item.setPromoGroupCode("BR29");
                currentBraceletCount++;
            } else
                item.setPromoGroupCode("");
            items.add(item);
        }

        if (markEligibleItems(items, awardCodeMap)) {
            double output = ProrationDemo.prorateDiscounts(items, discount);
            //printSandboxItems(items);
            //BigDecimal discountBD = new BigDecimal(discount).setScale(2);
            System.out.println(discount == output);
        }
    }
}
