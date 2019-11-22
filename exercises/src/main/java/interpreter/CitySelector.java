package interpreter;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;

public class CitySelector {

    private List<City> cities;

    public CitySelector(List<City> cities) {
        this.cities = cities;
    }

    public List<String> selectNames(String expression) {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(expression);

        EvaluationContext context = new StandardEvaluationContext(cities);
        return (List<String>) exp.getValue(context);

    }
}
