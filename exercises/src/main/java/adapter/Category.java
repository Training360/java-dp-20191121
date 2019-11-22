package adapter;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;

    private List<Category> subcategories;

    public Category(String name) {
        this.name = name;
        this.subcategories = List.of();
    }

    public Category(String name, List<Category> subcategories) {
        this.name = name;
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }
}
