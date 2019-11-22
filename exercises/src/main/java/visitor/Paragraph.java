package visitor;

import java.util.Collections;
import java.util.List;

public class Paragraph implements Item {

    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public List<Item> getChildren() {
        return Collections.emptyList();
    }

    @Override
    public void visit(ItemVisitor itemVisitor) {
        itemVisitor.visit(this);
    }
}
