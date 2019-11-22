package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SecurityInvocationHandler implements InvocationHandler {

    private SecurityContext securityContext;

    private ArticleService target;

    public SecurityInvocationHandler(ArticleService target, SecurityContext securityContext) {
        this.target = target;
        this.securityContext = securityContext;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Secured secured = method.getDeclaredAnnotation(Secured.class);
        if (secured == null || secured.anyRole().equals(securityContext.getRole())) {
            return method.invoke(target, args);
        }
        else {
            throw new SecurityException("No role");
        }
    }
}
