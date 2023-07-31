package com.sandbox.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;

@AllArgsConstructor
@ToString
class Parent {
    private final String name;
    private final int age;
}
@Builder
@ToString
public class BuilderDemo extends Parent {
    private final String childName;
    private final int childAge;

    @Builder
    public BuilderDemo(String name, int age, String childName, int childAge) {
        super(name, age);
        this.childName = childName;
        this.childAge = childAge;
    }

    public static void main(String[] args) {
        BuilderDemo bd = new BuilderDemo("Parent", 46, "child", 19);

        BuilderDemo bd1 = BuilderDemo.builder()
            .name("PParent")
            .age(446)
            .childName("CChild")
            .childAge(19)
            .build();

        //System.out.println(bd);
        System.out.println(bd1);
    }
}
