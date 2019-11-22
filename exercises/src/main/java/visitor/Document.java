package visitor;

import java.util.ArrayList;
import java.util.List;

public class Document implements Item {

    private List<Item> items = new ArrayList<>();

    @Override
    public List<Item> getChildren() {
        return items;
    }

    @Override
    public void visit(ItemVisitor itemVisitor) {
        itemVisitor.visit(this);
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
