package visitor;

public interface ItemVisitor {
    void visit(Document document);

    void visit(Paragraph paragraph);

    void visit(Title title);
}
