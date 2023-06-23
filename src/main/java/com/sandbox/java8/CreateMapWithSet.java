package com.sandbox.java8;

public class CreateMapWithSet {

    public static void main(String[] args) {

        //Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        
        // from Java SE 8 for the Really Impatient
//        Map<String, Set<String>> countryLanguageSets = locales.collect(
//                Collectors.toMap(
//                l -> l.getDisplayCountry(),
//                l -> Collections.singleton(l.getDisplayLanguage()),
//                (a, b) -> { // Union of a and b
//                Set<String> r = new HashSet<>(a);
//                r.addAll(b);
//                return r; }));
    }

}
