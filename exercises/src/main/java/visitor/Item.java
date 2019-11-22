package visitor;

import java.util.List;

public interface Item {

    List<Item> getChildren();

    void visit(ItemVisitor itemVisitor);
}
