package visitor;

public class UpperCaseItemVisitor implements ItemVisitor {

    @Override
    public void visit(Document document) {
        document.getChildren().forEach(i -> i.visit(this));
    }

    @Override
    public void visit(Paragraph paragraph) {
        paragraph.setText(paragraph.getText().toUpperCase());
    }

    @Override
    public void visit(Title title) {
        title.setText(title.getText().toUpperCase());
    }
}
