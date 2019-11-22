package adapter;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMenuItemAdapter implements MenuItem {

    private Category category;

    private List<MenuItem> children;

    private int numberOfAllChildren = -1;

    public CategoryMenuItemAdapter(Category category) {
        this.category = category;
    }

    @Override
    public List<MenuItem> getChildren() {
        if (children == null) {
            children = category.getSubcategories().stream().map(CategoryMenuItemAdapter::new).collect(Collectors.toList());
        }
        return children;
    }

    @Override
    public String getName() {
        return category.getName();
    }

    @Override
    public int numberOfAllChildren() {
        if (numberOfAllChildren == -1) {
            numberOfAllChildren = getChildren().size() + getChildren().stream().mapToInt(MenuItem::numberOfAllChildren)
                    .sum();
        }
        return numberOfAllChildren;
    }
}
