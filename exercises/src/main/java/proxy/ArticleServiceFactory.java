package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ArticleServiceFactory {

    public static ArticleService getArticleServiceProxy(ArticleService target, SecurityContext securityContext) {
        InvocationHandler handler =
                new SecurityInvocationHandler(target, securityContext);
        return (ArticleService) Proxy.newProxyInstance(ArticleService.class.getClassLoader(),
                new Class[] { ArticleService.class },
                handler);
    }
}
