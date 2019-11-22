package mediator;

public class InsertUpdateForm {

    private State state;

    private Component id = new Component(ComponentType.READONLY, false, "");

    private Component author = new Component(ComponentType.INPUT, true, "");

    private Component title = new Component(ComponentType.INPUT, true, "");

    private Component submit = new Component(ComponentType.BUTTON, true, "");

    public InsertUpdateForm() {
        toInsert();
    }

    public void toInsert() {
        state = State.INSERT;
        id.setValue("");
        id.setVisible(false);
        author.setValue("");
        title.setValue("");
        submit.setValue("Insert");
    }

    public void toUpdate(Book book) {
       state = State.UPDATE;
       id.setValue(Long.toString(book.getId()));
       id.setVisible(true);
       author.setValue(book.getAuthor());
       title.setValue(book.getTitle());
       submit.setValue("Update");
    }

    public Book submit() {
            Book book;
            if (state == State.INSERT) {
                book = new Book(author.getValue(), title.getValue());
            } else {
                book = new Book(Long.parseLong(id.getValue()), author.getValue(), title.getValue());
            }
        return book;
    }

    public Component getId() {
        return id;
    }

    public Component getAuthor() {
        return author;
    }

    public Component getTitle() {
        return title;
    }

    public Component getSubmit() {
        return submit;
    }
}
