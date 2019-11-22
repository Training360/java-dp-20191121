package proxy;

public interface ArticleService {

    void readArticle();

    @Secured(anyRole = "admin")
    void saveArticle();

}
