// Generated from calculator.g4 by ANTLR 4.7.1

package back.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link calculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface calculatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link calculatorParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(calculatorParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link calculatorParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(calculatorParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ModulusInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulusInfix(calculatorParser.ModulusInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivInfix(calculatorParser.MulDivInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParensInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensInfix(calculatorParser.ParensInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImaginaryInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImaginaryInfix(calculatorParser.ImaginaryInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomInfix(calculatorParser.AtomInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubInfix(calculatorParser.AddSubInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ModulusPrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulusPrefix(calculatorParser.ModulusPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivPrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivPrefix(calculatorParser.MulDivPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubPrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubPrefix(calculatorParser.AddSubPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParensPrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensPrefix(calculatorParser.ParensPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImaginaryPrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImaginaryPrefix(calculatorParser.ImaginaryPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomPrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomPrefix(calculatorParser.AtomPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ModulusPostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulusPostfix(calculatorParser.ModulusPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivPostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivPostfix(calculatorParser.MulDivPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubPostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubPostfix(calculatorParser.AddSubPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParensPostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParensPostfix(calculatorParser.ParensPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImaginaryPostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImaginaryPostfix(calculatorParser.ImaginaryPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomPostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomPostfix(calculatorParser.AtomPostfixContext ctx);
	/**
	 * Visit a parse tree produced by {@link calculatorParser#imaginaryAndReal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImaginaryAndReal(calculatorParser.ImaginaryAndRealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImaginaryAtom}
	 * labeled alternative in {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImaginaryAtom(calculatorParser.ImaginaryAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RealAtom}
	 * labeled alternative in {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealAtom(calculatorParser.RealAtomContext ctx);
}