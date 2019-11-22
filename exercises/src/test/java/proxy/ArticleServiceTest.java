package proxy;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

public class ArticleServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void hasRole() {
        ArticleService articleService = ArticleServiceFactory
                .getArticleServiceProxy(new DefaultArticleService(), new SecurityContext("John Doe", "admin"));
        articleService.saveArticle();

    }

    @Test
    public void hasNoRole() {
        expectedException.expect(SecurityException.class);
        expectedException.expectMessage("No role");
        ArticleService articleService = ArticleServiceFactory
                .getArticleServiceProxy(new DefaultArticleService(), new SecurityContext("John Doe", "anonymous"));
        articleService.saveArticle();

    }

    @Test
    public void acceptAnyRoleForRead() {
        ArticleService articleService = ArticleServiceFactory
                .getArticleServiceProxy(new DefaultArticleService(), new SecurityContext("John Doe", "anonymous"));
        articleService.readArticle();

    }
}
