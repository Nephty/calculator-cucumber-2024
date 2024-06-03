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
	 * Visit a parse tree produced by {@link calculatorParser#imNumber}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImNumber(calculatorParser.ImNumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link calculatorParser#angle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAngle(calculatorParser.AngleContext ctx);
	/**
	 * Visit a parse tree produced by {@link calculatorParser#cartesian}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCartesian(calculatorParser.CartesianContext ctx);
	/**
	 * Visit a parse tree produced by {@link calculatorParser#polar}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPolar(calculatorParser.PolarContext ctx);
	/**
	 * Visit a parse tree produced by {@link calculatorParser#exponential}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExponential(calculatorParser.ExponentialContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpInfix(calculatorParser.ExpInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ModulusInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModulusInfix(calculatorParser.ModulusInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SqrtInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqrtInfix(calculatorParser.SqrtInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SinInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinInfix(calculatorParser.SinInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LnInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLnInfix(calculatorParser.LnInfixContext ctx);
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
	 * Visit a parse tree produced by the {@code AtomReInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomReInfix(calculatorParser.AtomReInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImaginaryInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImaginaryInfix(calculatorParser.ImaginaryInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubInfix(calculatorParser.AddSubInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CosInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCosInfix(calculatorParser.CosInfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomImInfix}
	 * labeled alternative in {@link calculatorParser#infix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomImInfix(calculatorParser.AtomImInfixContext ctx);
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
	 * Visit a parse tree produced by the {@code AtomImPrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomImPrefix(calculatorParser.AtomImPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomRePrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomRePrefix(calculatorParser.AtomRePrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SqrtPrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqrtPrefix(calculatorParser.SqrtPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpPrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPrefix(calculatorParser.ExpPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CosPrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCosPrefix(calculatorParser.CosPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SinPrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinPrefix(calculatorParser.SinPrefixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LnPrefix}
	 * labeled alternative in {@link calculatorParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLnPrefix(calculatorParser.LnPrefixContext ctx);
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
	 * Visit a parse tree produced by the {@code AtomImPostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomImPostfix(calculatorParser.AtomImPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AtomRePostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomRePostfix(calculatorParser.AtomRePostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SqrtPostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSqrtPostfix(calculatorParser.SqrtPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpPostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpPostfix(calculatorParser.ExpPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CosPostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCosPostfix(calculatorParser.CosPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SinPostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSinPostfix(calculatorParser.SinPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LnPostfix}
	 * labeled alternative in {@link calculatorParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLnPostfix(calculatorParser.LnPostfixContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ENotationAtom}
	 * labeled alternative in {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitENotationAtom(calculatorParser.ENotationAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FloatAtom}
	 * labeled alternative in {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatAtom(calculatorParser.FloatAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PiAtom}
	 * labeled alternative in {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPiAtom(calculatorParser.PiAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntAtom}
	 * labeled alternative in {@link calculatorParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntAtom(calculatorParser.IntAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link calculatorParser#imAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImAtom(calculatorParser.ImAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link calculatorParser#reAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReAtom(calculatorParser.ReAtomContext ctx);
}