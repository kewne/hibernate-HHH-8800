package io.github.kewne.hibernate_test;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Map;

@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 1)
    @ManyToMany
    private Map<@Size(min = 5) String, Child> children;

    public Parent() {
    }

    public Long getId() {
        return id;
    }

    public void addChild(String name, Child child) {
        this.children.put(name, child);
    }
}
