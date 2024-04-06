package back.visitor;

import back.calculator.*;
import back.calculator.operators.Divides;
import back.calculator.operators.Minus;
import back.calculator.operators.Plus;
import back.calculator.operators.Times;
import back.calculator.types.MyNumber;
import back.calculator.types.NotANumber;
import org.antlr.v4.runtime.Token;
import back.parser.calculatorBaseVisitor;
import back.parser.calculatorParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static back.parser.calculatorLexer.*;

/**
 * Visitor class that extends the calculatorBaseVisitor class to visit the nodes of the parse tree.
 *
 * <p>
 *     It is used to visit each type of node in the parse tree and create the corresponding Expression object.
 * </p>
 */
public class CalculatorParserVisitor extends calculatorBaseVisitor<Expression> {

    private Expression getExpression(List<Expression> params, Token op, Notation notation) {
        try {
            return switch (op.getType()) {
                case MUL -> new Times(params, notation);
                case DIV -> new Divides(params, notation);
                case ADD -> new Plus(params, notation);
                case SUB -> new Minus(params, notation);
                default -> throw new IllegalConstruction();
            };
        } catch (IllegalConstruction e) {
            // Shouldn't happen since it would be detected by the parser as a syntax error before.
            return new NotANumber();
        }
    }

    private List<Expression> getInfixParams(calculatorParser.InfixContext ctx) {
        List<Expression> params = new ArrayList<>();
        Collections.addAll(params, visit(ctx.getChild(0)), visit(ctx.getChild(2)));
        return params;
    }

    private List<Expression> getPrefixParams(List<calculatorParser.PrefixContext> prefixContextList) {
        List<Expression> params = new ArrayList<>();
        for (calculatorParser.PrefixContext prefix : prefixContextList)
            params.add(visit(prefix));
        return params;
    }

    private List<Expression> getPostfixParams(List<calculatorParser.PostfixContext> postfixContextList) {
        List<Expression> params = new ArrayList<>();
        for (calculatorParser.PostfixContext postfix : postfixContextList)
            params.add(visit(postfix));
        return params;
    }


    @Override
    public Expression visitMulDivInfix(calculatorParser.MulDivInfixContext ctx) {
        // Infix ( '*' | '/' ) Infix
        return getExpression(
                getInfixParams(ctx),
                ctx.op,
                Notation.INFIX);
    }

    @Override
    public Expression visitAddSubInfix(calculatorParser.AddSubInfixContext ctx) {
        // Infix ( '+' | '-' ) Infix
        return getExpression(
                getInfixParams(ctx),
                ctx.op,
                Notation.INFIX);
    }

    @Override
    public Expression visitParensInfix(calculatorParser.ParensInfixContext ctx) {
        // '(' Infix ')'
        return visit(ctx.infix());
    }

    @Override
    public Expression visitNumberInfix(calculatorParser.NumberInfixContext ctx) {
        if (ctx.SUB() != null)
            // '-' Infix
            return new MyNumber(-Integer.parseInt(ctx.NUMBER().getText()));
        // NUMBER
        return new MyNumber(Integer.parseInt(ctx.NUMBER().getText()));
    }

    @Override
    public Expression visitMulDivPrefix(calculatorParser.MulDivPrefixContext ctx) {
        // ( '*' | '/' ) Prefix Prefix
        return getExpression(
                getPrefixParams(ctx.prefix()),
                ctx.op,
                Notation.PREFIX);
    }

    @Override
    public Expression visitAddSubPrefix(calculatorParser.AddSubPrefixContext ctx) {
        // ( '+' | '-' ) Prefix Prefix
        return getExpression(
                getPrefixParams(ctx.prefix()),
                ctx.op,
                Notation.PREFIX);
    }

    @Override
    public Expression visitParensPrefix(calculatorParser.ParensPrefixContext ctx) {
        // '(' Prefix ')'
        return visit(ctx.prefix());
    }

    @Override
    public Expression visitNumberPrefix(calculatorParser.NumberPrefixContext ctx) {
        if (ctx.SUB() != null)
            // '-' Prefix
            return new MyNumber(-Integer.parseInt(ctx.NUMBER().getText()));
        // NUMBER
        return new MyNumber(Integer.parseInt(ctx.NUMBER().getText()));
    }

    @Override
    public Expression visitMulDivPostfix(calculatorParser.MulDivPostfixContext ctx) {
        // Postfix Postfix ( '*' | '/' )
        return getExpression(
                getPostfixParams(ctx.postfix()),
                ctx.op,
                Notation.POSTFIX);
    }

    @Override
    public Expression visitAddSubPostfix(calculatorParser.AddSubPostfixContext ctx) {
        // Postfix Postfix ( '+' | '-' )
        return getExpression(
                getPostfixParams(ctx.postfix()),
                ctx.op,
                Notation.POSTFIX);
    }

    @Override
    public Expression visitParensPostfix(calculatorParser.ParensPostfixContext ctx) {
        // Postfix '(' Postfix ')'
        return visit(ctx.postfix());
    }

    @Override
    public Expression visitNumberPostfix(calculatorParser.NumberPostfixContext ctx) {
        if (ctx.SUB() != null)
            // Postfix '-'
            return new MyNumber(-Integer.parseInt(ctx.NUMBER().getText()));
        // NUMBER
        return new MyNumber(Integer.parseInt(ctx.NUMBER().getText()));
    }

}
