// Generated from calculator.g4 by ANTLR 4.7.1

package back.parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class calculatorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ADD=4, SUB=5, MUL=6, DIV=7, COMMA=8, MODULUS=9, 
		DECIMAL=10, I=11, E=12, COS=13, SQRT=14, SIN=15, EXP=16, PI=17, LN=18, 
		NUMBER=19, FLOAT=20, WS=21;
	public static final int
		RULE_prog = 0, RULE_expression = 1, RULE_imNumber = 2, RULE_angle = 3, 
		RULE_cartesian = 4, RULE_polar = 5, RULE_exponential = 6, RULE_infix = 7, 
		RULE_prefix = 8, RULE_postfix = 9, RULE_atom = 10, RULE_imAtom = 11, RULE_reAtom = 12;
	public static final String[] ruleNames = {
		"prog", "expression", "imNumber", "angle", "cartesian", "polar", "exponential", 
		"infix", "prefix", "postfix", "atom", "imAtom", "reAtom"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'modulus'", "'+'", "'-'", "'*'", "'/'", "','", "'|'", 
		"'.'", "'i'", "'E'", "'cos'", "'sqrt'", "'sin'", "'exp'", "'pi'", "'ln'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "ADD", "SUB", "MUL", "DIV", "COMMA", "MODULUS", 
		"DECIMAL", "I", "E", "COS", "SQRT", "SIN", "EXP", "PI", "LN", "NUMBER", 
		"FLOAT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "calculator.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public calculatorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public InfixContext infix() {
			return getRuleContext(InfixContext.class,0);
		}
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_expression);
		try {
			setState(31);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				infix(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				postfix();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				prefix();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImNumberContext extends ParserRuleContext {
		public CartesianContext cartesian() {
			return getRuleContext(CartesianContext.class,0);
		}
		public PolarContext polar() {
			return getRuleContext(PolarContext.class,0);
		}
		public ExponentialContext exponential() {
			return getRuleContext(ExponentialContext.class,0);
		}
		public ImNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imNumber; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitImNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImNumberContext imNumber() throws RecognitionException {
		ImNumberContext _localctx = new ImNumberContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_imNumber);
		try {
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				cartesian();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				polar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(35);
				exponential();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AngleContext extends ParserRuleContext {
		public Token op;
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public AngleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_angle; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitAngle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AngleContext angle() throws RecognitionException {
		AngleContext _localctx = new AngleContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_angle);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				atom();
				setState(40);
				((AngleContext)_localctx).op = match(DIV);
				setState(41);
				atom();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CartesianContext extends ParserRuleContext {
		public AtomContext real;
		public Token op;
		public AtomContext im;
		public TerminalNode I() { return getToken(calculatorParser.I, 0); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public CartesianContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cartesian; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitCartesian(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CartesianContext cartesian() throws RecognitionException {
		CartesianContext _localctx = new CartesianContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cartesian);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			((CartesianContext)_localctx).real = atom();
			setState(46);
			((CartesianContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
				((CartesianContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUB) | (1L << PI) | (1L << NUMBER) | (1L << FLOAT))) != 0)) {
				{
				setState(47);
				((CartesianContext)_localctx).im = atom();
				}
			}

			setState(50);
			match(I);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PolarContext extends ParserRuleContext {
		public AtomContext r;
		public AngleContext theta1;
		public AngleContext theta2;
		public TerminalNode COS() { return getToken(calculatorParser.COS, 0); }
		public TerminalNode I() { return getToken(calculatorParser.I, 0); }
		public TerminalNode SIN() { return getToken(calculatorParser.SIN, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<AngleContext> angle() {
			return getRuleContexts(AngleContext.class);
		}
		public AngleContext angle(int i) {
			return getRuleContext(AngleContext.class,i);
		}
		public PolarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_polar; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitPolar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolarContext polar() throws RecognitionException {
		PolarContext _localctx = new PolarContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_polar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			((PolarContext)_localctx).r = atom();
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUL) {
				{
				setState(53);
				match(MUL);
				}
			}

			setState(56);
			match(T__0);
			setState(57);
			match(COS);
			setState(58);
			match(T__0);
			setState(59);
			((PolarContext)_localctx).theta1 = angle();
			setState(60);
			match(T__1);
			setState(61);
			match(ADD);
			setState(62);
			match(I);
			setState(63);
			match(SIN);
			setState(64);
			match(T__0);
			setState(65);
			((PolarContext)_localctx).theta2 = angle();
			setState(66);
			match(T__1);
			setState(67);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExponentialContext extends ParserRuleContext {
		public AtomContext r;
		public AngleContext theta;
		public TerminalNode EXP() { return getToken(calculatorParser.EXP, 0); }
		public TerminalNode I() { return getToken(calculatorParser.I, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public AngleContext angle() {
			return getRuleContext(AngleContext.class,0);
		}
		public ExponentialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exponential; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitExponential(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExponentialContext exponential() throws RecognitionException {
		ExponentialContext _localctx = new ExponentialContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exponential);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			((ExponentialContext)_localctx).r = atom();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MUL) {
				{
				setState(70);
				match(MUL);
				}
			}

			setState(73);
			match(EXP);
			setState(74);
			match(T__0);
			setState(75);
			((ExponentialContext)_localctx).theta = angle();
			setState(76);
			match(I);
			setState(77);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InfixContext extends ParserRuleContext {
		public InfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infix; }
	 
		public InfixContext() { }
		public void copyFrom(InfixContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpInfixContext extends InfixContext {
		public TerminalNode EXP() { return getToken(calculatorParser.EXP, 0); }
		public InfixContext infix() {
			return getRuleContext(InfixContext.class,0);
		}
		public ExpInfixContext(InfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitExpInfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModulusInfixContext extends InfixContext {
		public List<TerminalNode> MODULUS() { return getTokens(calculatorParser.MODULUS); }
		public TerminalNode MODULUS(int i) {
			return getToken(calculatorParser.MODULUS, i);
		}
		public InfixContext infix() {
			return getRuleContext(InfixContext.class,0);
		}
		public ModulusInfixContext(InfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitModulusInfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SqrtInfixContext extends InfixContext {
		public TerminalNode SQRT() { return getToken(calculatorParser.SQRT, 0); }
		public InfixContext infix() {
			return getRuleContext(InfixContext.class,0);
		}
		public SqrtInfixContext(InfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitSqrtInfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SinInfixContext extends InfixContext {
		public TerminalNode SIN() { return getToken(calculatorParser.SIN, 0); }
		public InfixContext infix() {
			return getRuleContext(InfixContext.class,0);
		}
		public SinInfixContext(InfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitSinInfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LnInfixContext extends InfixContext {
		public TerminalNode LN() { return getToken(calculatorParser.LN, 0); }
		public InfixContext infix() {
			return getRuleContext(InfixContext.class,0);
		}
		public LnInfixContext(InfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitLnInfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivInfixContext extends InfixContext {
		public Token op;
		public List<InfixContext> infix() {
			return getRuleContexts(InfixContext.class);
		}
		public InfixContext infix(int i) {
			return getRuleContext(InfixContext.class,i);
		}
		public MulDivInfixContext(InfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitMulDivInfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensInfixContext extends InfixContext {
		public InfixContext infix() {
			return getRuleContext(InfixContext.class,0);
		}
		public ParensInfixContext(InfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitParensInfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomReInfixContext extends InfixContext {
		public ReAtomContext reAtom() {
			return getRuleContext(ReAtomContext.class,0);
		}
		public AtomReInfixContext(InfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitAtomReInfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImaginaryInfixContext extends InfixContext {
		public ImNumberContext imNumber() {
			return getRuleContext(ImNumberContext.class,0);
		}
		public ImaginaryInfixContext(InfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitImaginaryInfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubInfixContext extends InfixContext {
		public Token op;
		public List<InfixContext> infix() {
			return getRuleContexts(InfixContext.class);
		}
		public InfixContext infix(int i) {
			return getRuleContext(InfixContext.class,i);
		}
		public AddSubInfixContext(InfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitAddSubInfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CosInfixContext extends InfixContext {
		public TerminalNode COS() { return getToken(calculatorParser.COS, 0); }
		public InfixContext infix() {
			return getRuleContext(InfixContext.class,0);
		}
		public CosInfixContext(InfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitCosInfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomImInfixContext extends InfixContext {
		public ImAtomContext imAtom() {
			return getRuleContext(ImAtomContext.class,0);
		}
		public AtomImInfixContext(InfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitAtomImInfix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InfixContext infix() throws RecognitionException {
		return infix(0);
	}

	private InfixContext infix(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		InfixContext _localctx = new InfixContext(_ctx, _parentState);
		InfixContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_infix, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				_localctx = new ModulusInfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(89);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MODULUS:
					{
					{
					setState(80);
					match(MODULUS);
					setState(81);
					infix(0);
					setState(82);
					match(MODULUS);
					}
					}
					break;
				case T__2:
					{
					{
					setState(84);
					match(T__2);
					setState(85);
					match(T__0);
					setState(86);
					infix(0);
					setState(87);
					match(T__1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				{
				_localctx = new ImaginaryInfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				imNumber();
				}
				break;
			case 3:
				{
				_localctx = new ParensInfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				match(T__0);
				setState(93);
				infix(0);
				setState(94);
				match(T__1);
				}
				break;
			case 4:
				{
				_localctx = new AtomImInfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(96);
				imAtom();
				}
				break;
			case 5:
				{
				_localctx = new AtomReInfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				reAtom();
				}
				break;
			case 6:
				{
				_localctx = new SqrtInfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(98);
				match(SQRT);
				setState(99);
				match(T__0);
				setState(100);
				infix(0);
				setState(101);
				match(T__1);
				}
				break;
			case 7:
				{
				_localctx = new ExpInfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(103);
				match(EXP);
				setState(104);
				match(T__0);
				setState(105);
				infix(0);
				setState(106);
				match(T__1);
				}
				break;
			case 8:
				{
				_localctx = new CosInfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				match(COS);
				setState(109);
				match(T__0);
				setState(110);
				infix(0);
				setState(111);
				match(T__1);
				}
				break;
			case 9:
				{
				_localctx = new SinInfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113);
				match(SIN);
				setState(114);
				match(T__0);
				setState(115);
				infix(0);
				setState(116);
				match(T__1);
				}
				break;
			case 10:
				{
				_localctx = new LnInfixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(118);
				match(LN);
				setState(119);
				match(T__0);
				setState(120);
				infix(0);
				setState(121);
				match(T__1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(131);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivInfixContext(new InfixContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_infix);
						setState(125);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(126);
						((MulDivInfixContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MUL || _la==DIV) ) {
							((MulDivInfixContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(127);
						infix(11);
						}
						break;
					case 2:
						{
						_localctx = new AddSubInfixContext(new InfixContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_infix);
						setState(128);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(129);
						((AddSubInfixContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((AddSubInfixContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(130);
						infix(10);
						}
						break;
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrefixContext extends ParserRuleContext {
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
	 
		public PrefixContext() { }
		public void copyFrom(PrefixContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AtomRePrefixContext extends PrefixContext {
		public ReAtomContext reAtom() {
			return getRuleContext(ReAtomContext.class,0);
		}
		public AtomRePrefixContext(PrefixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitAtomRePrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImaginaryPrefixContext extends PrefixContext {
		public ImNumberContext imNumber() {
			return getRuleContext(ImNumberContext.class,0);
		}
		public ImaginaryPrefixContext(PrefixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitImaginaryPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LnPrefixContext extends PrefixContext {
		public TerminalNode LN() { return getToken(calculatorParser.LN, 0); }
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public LnPrefixContext(PrefixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitLnPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SqrtPrefixContext extends PrefixContext {
		public TerminalNode SQRT() { return getToken(calculatorParser.SQRT, 0); }
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public SqrtPrefixContext(PrefixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitSqrtPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubPrefixContext extends PrefixContext {
		public Token op;
		public List<PrefixContext> prefix() {
			return getRuleContexts(PrefixContext.class);
		}
		public PrefixContext prefix(int i) {
			return getRuleContext(PrefixContext.class,i);
		}
		public AddSubPrefixContext(PrefixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitAddSubPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CosPrefixContext extends PrefixContext {
		public TerminalNode COS() { return getToken(calculatorParser.COS, 0); }
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public CosPrefixContext(PrefixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitCosPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SinPrefixContext extends PrefixContext {
		public TerminalNode SIN() { return getToken(calculatorParser.SIN, 0); }
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public SinPrefixContext(PrefixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitSinPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomImPrefixContext extends PrefixContext {
		public ImAtomContext imAtom() {
			return getRuleContext(ImAtomContext.class,0);
		}
		public AtomImPrefixContext(PrefixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitAtomImPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensPrefixContext extends PrefixContext {
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public ParensPrefixContext(PrefixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitParensPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModulusPrefixContext extends PrefixContext {
		public List<TerminalNode> MODULUS() { return getTokens(calculatorParser.MODULUS); }
		public TerminalNode MODULUS(int i) {
			return getToken(calculatorParser.MODULUS, i);
		}
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public ModulusPrefixContext(PrefixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitModulusPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpPrefixContext extends PrefixContext {
		public TerminalNode EXP() { return getToken(calculatorParser.EXP, 0); }
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public ExpPrefixContext(PrefixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitExpPrefix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MulDivPrefixContext extends PrefixContext {
		public Token op;
		public List<PrefixContext> prefix() {
			return getRuleContexts(PrefixContext.class);
		}
		public PrefixContext prefix(int i) {
			return getRuleContext(PrefixContext.class,i);
		}
		public MulDivPrefixContext(PrefixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitMulDivPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_prefix);
		int _la;
		try {
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new ModulusPrefixContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MODULUS:
					{
					{
					setState(136);
					match(MODULUS);
					setState(137);
					prefix();
					setState(138);
					match(MODULUS);
					}
					}
					break;
				case T__2:
					{
					{
					setState(140);
					match(T__2);
					setState(141);
					match(T__0);
					setState(142);
					prefix();
					setState(143);
					match(T__1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				_localctx = new MulDivPrefixContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				((MulDivPrefixContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
					((MulDivPrefixContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(148);
				match(T__0);
				setState(149);
				prefix();
				setState(161);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMA:
					{
					setState(152); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(150);
						match(COMMA);
						setState(151);
						prefix();
						}
						}
						setState(154); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==COMMA );
					}
					break;
				case T__0:
				case T__2:
				case ADD:
				case SUB:
				case MUL:
				case DIV:
				case MODULUS:
				case I:
				case COS:
				case SQRT:
				case SIN:
				case EXP:
				case PI:
				case LN:
				case NUMBER:
				case FLOAT:
					{
					setState(157); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(156);
						prefix();
						}
						}
						setState(159); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MODULUS) | (1L << I) | (1L << COS) | (1L << SQRT) | (1L << SIN) | (1L << EXP) | (1L << PI) | (1L << LN) | (1L << NUMBER) | (1L << FLOAT))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(163);
				match(T__1);
				}
				break;
			case 3:
				_localctx = new AddSubPrefixContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				((AddSubPrefixContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((AddSubPrefixContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(166);
				match(T__0);
				setState(167);
				prefix();
				setState(179);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMA:
					{
					setState(170); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(168);
						match(COMMA);
						setState(169);
						prefix();
						}
						}
						setState(172); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==COMMA );
					}
					break;
				case T__0:
				case T__2:
				case ADD:
				case SUB:
				case MUL:
				case DIV:
				case MODULUS:
				case I:
				case COS:
				case SQRT:
				case SIN:
				case EXP:
				case PI:
				case LN:
				case NUMBER:
				case FLOAT:
					{
					setState(175); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(174);
						prefix();
						}
						}
						setState(177); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << ADD) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << MODULUS) | (1L << I) | (1L << COS) | (1L << SQRT) | (1L << SIN) | (1L << EXP) | (1L << PI) | (1L << LN) | (1L << NUMBER) | (1L << FLOAT))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(181);
				match(T__1);
				}
				break;
			case 4:
				_localctx = new ParensPrefixContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(183);
				match(T__0);
				setState(184);
				prefix();
				setState(185);
				match(T__1);
				}
				break;
			case 5:
				_localctx = new ImaginaryPrefixContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(187);
				imNumber();
				}
				break;
			case 6:
				_localctx = new AtomImPrefixContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(188);
				imAtom();
				}
				break;
			case 7:
				_localctx = new AtomRePrefixContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(189);
				reAtom();
				}
				break;
			case 8:
				_localctx = new SqrtPrefixContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(190);
				match(SQRT);
				setState(191);
				match(T__0);
				setState(192);
				prefix();
				setState(193);
				match(T__1);
				}
				break;
			case 9:
				_localctx = new ExpPrefixContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(195);
				match(EXP);
				setState(196);
				match(T__0);
				setState(197);
				prefix();
				setState(198);
				match(T__1);
				}
				break;
			case 10:
				_localctx = new CosPrefixContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(200);
				match(COS);
				setState(201);
				match(T__0);
				setState(202);
				prefix();
				setState(203);
				match(T__1);
				}
				break;
			case 11:
				_localctx = new SinPrefixContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(205);
				match(SIN);
				setState(206);
				match(T__0);
				setState(207);
				prefix();
				setState(208);
				match(T__1);
				}
				break;
			case 12:
				_localctx = new LnPrefixContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(210);
				match(LN);
				setState(211);
				match(T__0);
				setState(212);
				prefix();
				setState(213);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PostfixContext extends ParserRuleContext {
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
	 
		public PostfixContext() { }
		public void copyFrom(PostfixContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MulDivPostfixContext extends PostfixContext {
		public Token op;
		public List<PostfixContext> postfix() {
			return getRuleContexts(PostfixContext.class);
		}
		public PostfixContext postfix(int i) {
			return getRuleContext(PostfixContext.class,i);
		}
		public MulDivPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitMulDivPostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpPostfixContext extends PostfixContext {
		public TerminalNode EXP() { return getToken(calculatorParser.EXP, 0); }
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public ExpPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitExpPostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SinPostfixContext extends PostfixContext {
		public TerminalNode SIN() { return getToken(calculatorParser.SIN, 0); }
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public SinPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitSinPostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParensPostfixContext extends PostfixContext {
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public ParensPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitParensPostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImaginaryPostfixContext extends PostfixContext {
		public ImNumberContext imNumber() {
			return getRuleContext(ImNumberContext.class,0);
		}
		public ImaginaryPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitImaginaryPostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddSubPostfixContext extends PostfixContext {
		public Token op;
		public List<PostfixContext> postfix() {
			return getRuleContexts(PostfixContext.class);
		}
		public PostfixContext postfix(int i) {
			return getRuleContext(PostfixContext.class,i);
		}
		public AddSubPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitAddSubPostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomRePostfixContext extends PostfixContext {
		public ReAtomContext reAtom() {
			return getRuleContext(ReAtomContext.class,0);
		}
		public AtomRePostfixContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitAtomRePostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LnPostfixContext extends PostfixContext {
		public TerminalNode LN() { return getToken(calculatorParser.LN, 0); }
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public LnPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitLnPostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SqrtPostfixContext extends PostfixContext {
		public TerminalNode SQRT() { return getToken(calculatorParser.SQRT, 0); }
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public SqrtPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitSqrtPostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomImPostfixContext extends PostfixContext {
		public ImAtomContext imAtom() {
			return getRuleContext(ImAtomContext.class,0);
		}
		public AtomImPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitAtomImPostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CosPostfixContext extends PostfixContext {
		public TerminalNode COS() { return getToken(calculatorParser.COS, 0); }
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public CosPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitCosPostfix(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ModulusPostfixContext extends PostfixContext {
		public List<TerminalNode> MODULUS() { return getTokens(calculatorParser.MODULUS); }
		public TerminalNode MODULUS(int i) {
			return getToken(calculatorParser.MODULUS, i);
		}
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public ModulusPostfixContext(PostfixContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitModulusPostfix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_postfix);
		int _la;
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new ModulusPostfixContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MODULUS:
					{
					{
					setState(217);
					match(MODULUS);
					setState(218);
					postfix();
					setState(219);
					match(MODULUS);
					}
					}
					break;
				case T__2:
					{
					{
					setState(221);
					match(T__2);
					setState(222);
					match(T__0);
					setState(223);
					postfix();
					setState(224);
					match(T__1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				_localctx = new MulDivPostfixContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(228);
				match(T__0);
				setState(229);
				postfix();
				setState(241);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMA:
					{
					setState(232); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(230);
						match(COMMA);
						setState(231);
						postfix();
						}
						}
						setState(234); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==COMMA );
					}
					break;
				case T__0:
				case T__2:
				case SUB:
				case MODULUS:
				case I:
				case COS:
				case SQRT:
				case SIN:
				case EXP:
				case PI:
				case LN:
				case NUMBER:
				case FLOAT:
					{
					setState(237); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(236);
						postfix();
						}
						}
						setState(239); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << SUB) | (1L << MODULUS) | (1L << I) | (1L << COS) | (1L << SQRT) | (1L << SIN) | (1L << EXP) | (1L << PI) | (1L << LN) | (1L << NUMBER) | (1L << FLOAT))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(243);
				match(T__1);
				setState(244);
				((MulDivPostfixContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MUL || _la==DIV) ) {
					((MulDivPostfixContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 3:
				_localctx = new AddSubPostfixContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				match(T__0);
				setState(247);
				postfix();
				setState(259);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case COMMA:
					{
					setState(250); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(248);
						match(COMMA);
						setState(249);
						postfix();
						}
						}
						setState(252); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==COMMA );
					}
					break;
				case T__0:
				case T__2:
				case SUB:
				case MODULUS:
				case I:
				case COS:
				case SQRT:
				case SIN:
				case EXP:
				case PI:
				case LN:
				case NUMBER:
				case FLOAT:
					{
					setState(255); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(254);
						postfix();
						}
						}
						setState(257); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << SUB) | (1L << MODULUS) | (1L << I) | (1L << COS) | (1L << SQRT) | (1L << SIN) | (1L << EXP) | (1L << PI) | (1L << LN) | (1L << NUMBER) | (1L << FLOAT))) != 0) );
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(261);
				match(T__1);
				setState(262);
				((AddSubPostfixContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((AddSubPostfixContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 4:
				_localctx = new ParensPostfixContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(264);
				match(T__0);
				setState(265);
				postfix();
				setState(266);
				match(T__1);
				}
				break;
			case 5:
				_localctx = new ImaginaryPostfixContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(268);
				imNumber();
				}
				break;
			case 6:
				_localctx = new AtomImPostfixContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(269);
				imAtom();
				}
				break;
			case 7:
				_localctx = new AtomRePostfixContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(270);
				reAtom();
				}
				break;
			case 8:
				_localctx = new SqrtPostfixContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(271);
				match(SQRT);
				setState(272);
				match(T__0);
				setState(273);
				postfix();
				setState(274);
				match(T__1);
				}
				break;
			case 9:
				_localctx = new ExpPostfixContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(276);
				match(EXP);
				setState(277);
				match(T__0);
				setState(278);
				postfix();
				setState(279);
				match(T__1);
				}
				break;
			case 10:
				_localctx = new CosPostfixContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(281);
				match(COS);
				setState(282);
				match(T__0);
				setState(283);
				postfix();
				setState(284);
				match(T__1);
				}
				break;
			case 11:
				_localctx = new SinPostfixContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(286);
				match(SIN);
				setState(287);
				match(T__0);
				setState(288);
				postfix();
				setState(289);
				match(T__1);
				}
				break;
			case 12:
				_localctx = new LnPostfixContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(291);
				match(LN);
				setState(292);
				match(T__0);
				setState(293);
				postfix();
				setState(294);
				match(T__1);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PiAtomContext extends AtomContext {
		public TerminalNode PI() { return getToken(calculatorParser.PI, 0); }
		public TerminalNode SUB() { return getToken(calculatorParser.SUB, 0); }
		public PiAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitPiAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ENotationAtomContext extends AtomContext {
		public Token val;
		public TerminalNode E() { return getToken(calculatorParser.E, 0); }
		public List<TerminalNode> NUMBER() { return getTokens(calculatorParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(calculatorParser.NUMBER, i);
		}
		public TerminalNode FLOAT() { return getToken(calculatorParser.FLOAT, 0); }
		public List<TerminalNode> SUB() { return getTokens(calculatorParser.SUB); }
		public TerminalNode SUB(int i) {
			return getToken(calculatorParser.SUB, i);
		}
		public TerminalNode ADD() { return getToken(calculatorParser.ADD, 0); }
		public ENotationAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitENotationAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FloatAtomContext extends AtomContext {
		public Token val;
		public TerminalNode FLOAT() { return getToken(calculatorParser.FLOAT, 0); }
		public TerminalNode SUB() { return getToken(calculatorParser.SUB, 0); }
		public FloatAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitFloatAtom(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntAtomContext extends AtomContext {
		public TerminalNode NUMBER() { return getToken(calculatorParser.NUMBER, 0); }
		public TerminalNode SUB() { return getToken(calculatorParser.SUB, 0); }
		public IntAtomContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitIntAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_atom);
		int _la;
		try {
			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				_localctx = new ENotationAtomContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SUB) {
					{
					setState(298);
					match(SUB);
					}
				}

				setState(301);
				((ENotationAtomContext)_localctx).val = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==NUMBER || _la==FLOAT) ) {
					((ENotationAtomContext)_localctx).val = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(302);
				match(E);
				setState(309);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(304);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==SUB) {
						{
						setState(303);
						match(SUB);
						}
					}

					}
					break;
				case 2:
					{
					setState(307);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ADD) {
						{
						setState(306);
						match(ADD);
						}
					}

					}
					break;
				}
				setState(311);
				match(NUMBER);
				}
				break;
			case 2:
				_localctx = new FloatAtomContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SUB) {
					{
					setState(312);
					match(SUB);
					}
				}

				setState(315);
				((FloatAtomContext)_localctx).val = match(FLOAT);
				}
				break;
			case 3:
				_localctx = new PiAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SUB) {
					{
					setState(316);
					match(SUB);
					}
				}

				setState(319);
				match(PI);
				}
				break;
			case 4:
				_localctx = new IntAtomContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SUB) {
					{
					setState(320);
					match(SUB);
					}
				}

				setState(323);
				match(NUMBER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImAtomContext extends ParserRuleContext {
		public TerminalNode I() { return getToken(calculatorParser.I, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ImAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitImAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImAtomContext imAtom() throws RecognitionException {
		ImAtomContext _localctx = new ImAtomContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_imAtom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUB) | (1L << PI) | (1L << NUMBER) | (1L << FLOAT))) != 0)) {
				{
				setState(326);
				atom();
				}
			}

			setState(329);
			match(I);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReAtomContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ReAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reAtom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof calculatorVisitor ) return ((calculatorVisitor<? extends T>)visitor).visitReAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReAtomContext reAtom() throws RecognitionException {
		ReAtomContext _localctx = new ReAtomContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_reAtom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			atom();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 7:
			return infix_sempred((InfixContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean infix_sempred(InfixContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 10);
		case 1:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\27\u0150\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4"+
		"\3\4\5\4\'\n\4\3\5\3\5\3\5\3\5\3\5\5\5.\n\5\3\6\3\6\3\6\5\6\63\n\6\3\6"+
		"\3\6\3\7\3\7\5\79\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\5\bJ\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\5\t\\\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\5\t~\n\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0086\n\t\f\t\16\t"+
		"\u0089\13\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0094\n\n\3\n\3\n"+
		"\3\n\3\n\3\n\6\n\u009b\n\n\r\n\16\n\u009c\3\n\6\n\u00a0\n\n\r\n\16\n\u00a1"+
		"\5\n\u00a4\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\6\n\u00ad\n\n\r\n\16\n\u00ae"+
		"\3\n\6\n\u00b2\n\n\r\n\16\n\u00b3\5\n\u00b6\n\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00da\n\n\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00e5\n\13\3\13\3\13\3\13\3\13"+
		"\6\13\u00eb\n\13\r\13\16\13\u00ec\3\13\6\13\u00f0\n\13\r\13\16\13\u00f1"+
		"\5\13\u00f4\n\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u00fd\n\13\r"+
		"\13\16\13\u00fe\3\13\6\13\u0102\n\13\r\13\16\13\u0103\5\13\u0106\n\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u012b\n\13\3\f\5\f\u012e\n\f"+
		"\3\f\3\f\3\f\5\f\u0133\n\f\3\f\5\f\u0136\n\f\5\f\u0138\n\f\3\f\3\f\5\f"+
		"\u013c\n\f\3\f\3\f\5\f\u0140\n\f\3\f\3\f\5\f\u0144\n\f\3\f\5\f\u0147\n"+
		"\f\3\r\5\r\u014a\n\r\3\r\3\r\3\16\3\16\3\16\2\3\20\17\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\2\5\3\2\6\7\3\2\b\t\3\2\25\26\2\u0185\2\34\3\2\2\2\4!"+
		"\3\2\2\2\6&\3\2\2\2\b-\3\2\2\2\n/\3\2\2\2\f\66\3\2\2\2\16G\3\2\2\2\20"+
		"}\3\2\2\2\22\u00d9\3\2\2\2\24\u012a\3\2\2\2\26\u0146\3\2\2\2\30\u0149"+
		"\3\2\2\2\32\u014d\3\2\2\2\34\35\5\4\3\2\35\3\3\2\2\2\36\"\5\20\t\2\37"+
		"\"\5\24\13\2 \"\5\22\n\2!\36\3\2\2\2!\37\3\2\2\2! \3\2\2\2\"\5\3\2\2\2"+
		"#\'\5\n\6\2$\'\5\f\7\2%\'\5\16\b\2&#\3\2\2\2&$\3\2\2\2&%\3\2\2\2\'\7\3"+
		"\2\2\2(.\5\26\f\2)*\5\26\f\2*+\7\t\2\2+,\5\26\f\2,.\3\2\2\2-(\3\2\2\2"+
		"-)\3\2\2\2.\t\3\2\2\2/\60\5\26\f\2\60\62\t\2\2\2\61\63\5\26\f\2\62\61"+
		"\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\7\r\2\2\65\13\3\2\2\2\668\5"+
		"\26\f\2\679\7\b\2\28\67\3\2\2\289\3\2\2\29:\3\2\2\2:;\7\3\2\2;<\7\17\2"+
		"\2<=\7\3\2\2=>\5\b\5\2>?\7\4\2\2?@\7\6\2\2@A\7\r\2\2AB\7\21\2\2BC\7\3"+
		"\2\2CD\5\b\5\2DE\7\4\2\2EF\7\4\2\2F\r\3\2\2\2GI\5\26\f\2HJ\7\b\2\2IH\3"+
		"\2\2\2IJ\3\2\2\2JK\3\2\2\2KL\7\22\2\2LM\7\3\2\2MN\5\b\5\2NO\7\r\2\2OP"+
		"\7\4\2\2P\17\3\2\2\2Q[\b\t\1\2RS\7\13\2\2ST\5\20\t\2TU\7\13\2\2U\\\3\2"+
		"\2\2VW\7\5\2\2WX\7\3\2\2XY\5\20\t\2YZ\7\4\2\2Z\\\3\2\2\2[R\3\2\2\2[V\3"+
		"\2\2\2\\~\3\2\2\2]~\5\6\4\2^_\7\3\2\2_`\5\20\t\2`a\7\4\2\2a~\3\2\2\2b"+
		"~\5\30\r\2c~\5\32\16\2de\7\20\2\2ef\7\3\2\2fg\5\20\t\2gh\7\4\2\2h~\3\2"+
		"\2\2ij\7\22\2\2jk\7\3\2\2kl\5\20\t\2lm\7\4\2\2m~\3\2\2\2no\7\17\2\2op"+
		"\7\3\2\2pq\5\20\t\2qr\7\4\2\2r~\3\2\2\2st\7\21\2\2tu\7\3\2\2uv\5\20\t"+
		"\2vw\7\4\2\2w~\3\2\2\2xy\7\24\2\2yz\7\3\2\2z{\5\20\t\2{|\7\4\2\2|~\3\2"+
		"\2\2}Q\3\2\2\2}]\3\2\2\2}^\3\2\2\2}b\3\2\2\2}c\3\2\2\2}d\3\2\2\2}i\3\2"+
		"\2\2}n\3\2\2\2}s\3\2\2\2}x\3\2\2\2~\u0087\3\2\2\2\177\u0080\f\f\2\2\u0080"+
		"\u0081\t\3\2\2\u0081\u0086\5\20\t\r\u0082\u0083\f\13\2\2\u0083\u0084\t"+
		"\2\2\2\u0084\u0086\5\20\t\f\u0085\177\3\2\2\2\u0085\u0082\3\2\2\2\u0086"+
		"\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\21\3\2\2"+
		"\2\u0089\u0087\3\2\2\2\u008a\u008b\7\13\2\2\u008b\u008c\5\22\n\2\u008c"+
		"\u008d\7\13\2\2\u008d\u0094\3\2\2\2\u008e\u008f\7\5\2\2\u008f\u0090\7"+
		"\3\2\2\u0090\u0091\5\22\n\2\u0091\u0092\7\4\2\2\u0092\u0094\3\2\2\2\u0093"+
		"\u008a\3\2\2\2\u0093\u008e\3\2\2\2\u0094\u00da\3\2\2\2\u0095\u0096\t\3"+
		"\2\2\u0096\u0097\7\3\2\2\u0097\u00a3\5\22\n\2\u0098\u0099\7\n\2\2\u0099"+
		"\u009b\5\22\n\2\u009a\u0098\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3"+
		"\2\2\2\u009c\u009d\3\2\2\2\u009d\u00a4\3\2\2\2\u009e\u00a0\5\22\n\2\u009f"+
		"\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2"+
		"\2\2\u00a2\u00a4\3\2\2\2\u00a3\u009a\3\2\2\2\u00a3\u009f\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\u00a6\7\4\2\2\u00a6\u00da\3\2\2\2\u00a7\u00a8\t\2"+
		"\2\2\u00a8\u00a9\7\3\2\2\u00a9\u00b5\5\22\n\2\u00aa\u00ab\7\n\2\2\u00ab"+
		"\u00ad\5\22\n\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3"+
		"\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b6\3\2\2\2\u00b0\u00b2\5\22\n\2\u00b1"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00ac\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00b8\7\4\2\2\u00b8\u00da\3\2\2\2\u00b9\u00ba\7\3"+
		"\2\2\u00ba\u00bb\5\22\n\2\u00bb\u00bc\7\4\2\2\u00bc\u00da\3\2\2\2\u00bd"+
		"\u00da\5\6\4\2\u00be\u00da\5\30\r\2\u00bf\u00da\5\32\16\2\u00c0\u00c1"+
		"\7\20\2\2\u00c1\u00c2\7\3\2\2\u00c2\u00c3\5\22\n\2\u00c3\u00c4\7\4\2\2"+
		"\u00c4\u00da\3\2\2\2\u00c5\u00c6\7\22\2\2\u00c6\u00c7\7\3\2\2\u00c7\u00c8"+
		"\5\22\n\2\u00c8\u00c9\7\4\2\2\u00c9\u00da\3\2\2\2\u00ca\u00cb\7\17\2\2"+
		"\u00cb\u00cc\7\3\2\2\u00cc\u00cd\5\22\n\2\u00cd\u00ce\7\4\2\2\u00ce\u00da"+
		"\3\2\2\2\u00cf\u00d0\7\21\2\2\u00d0\u00d1\7\3\2\2\u00d1\u00d2\5\22\n\2"+
		"\u00d2\u00d3\7\4\2\2\u00d3\u00da\3\2\2\2\u00d4\u00d5\7\24\2\2\u00d5\u00d6"+
		"\7\3\2\2\u00d6\u00d7\5\22\n\2\u00d7\u00d8\7\4\2\2\u00d8\u00da\3\2\2\2"+
		"\u00d9\u0093\3\2\2\2\u00d9\u0095\3\2\2\2\u00d9\u00a7\3\2\2\2\u00d9\u00b9"+
		"\3\2\2\2\u00d9\u00bd\3\2\2\2\u00d9\u00be\3\2\2\2\u00d9\u00bf\3\2\2\2\u00d9"+
		"\u00c0\3\2\2\2\u00d9\u00c5\3\2\2\2\u00d9\u00ca\3\2\2\2\u00d9\u00cf\3\2"+
		"\2\2\u00d9\u00d4\3\2\2\2\u00da\23\3\2\2\2\u00db\u00dc\7\13\2\2\u00dc\u00dd"+
		"\5\24\13\2\u00dd\u00de\7\13\2\2\u00de\u00e5\3\2\2\2\u00df\u00e0\7\5\2"+
		"\2\u00e0\u00e1\7\3\2\2\u00e1\u00e2\5\24\13\2\u00e2\u00e3\7\4\2\2\u00e3"+
		"\u00e5\3\2\2\2\u00e4\u00db\3\2\2\2\u00e4\u00df\3\2\2\2\u00e5\u012b\3\2"+
		"\2\2\u00e6\u00e7\7\3\2\2\u00e7\u00f3\5\24\13\2\u00e8\u00e9\7\n\2\2\u00e9"+
		"\u00eb\5\24\13\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec\u00ea\3"+
		"\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f4\3\2\2\2\u00ee\u00f0\5\24\13\2\u00ef"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\u00f4\3\2\2\2\u00f3\u00ea\3\2\2\2\u00f3\u00ef\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f6\7\4\2\2\u00f6\u00f7\t\3\2\2\u00f7\u012b\3\2"+
		"\2\2\u00f8\u00f9\7\3\2\2\u00f9\u0105\5\24\13\2\u00fa\u00fb\7\n\2\2\u00fb"+
		"\u00fd\5\24\13\2\u00fc\u00fa\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00fc\3"+
		"\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0106\3\2\2\2\u0100\u0102\5\24\13\2\u0101"+
		"\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2"+
		"\2\2\u0104\u0106\3\2\2\2\u0105\u00fc\3\2\2\2\u0105\u0101\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107\u0108\7\4\2\2\u0108\u0109\t\2\2\2\u0109\u012b\3\2"+
		"\2\2\u010a\u010b\7\3\2\2\u010b\u010c\5\24\13\2\u010c\u010d\7\4\2\2\u010d"+
		"\u012b\3\2\2\2\u010e\u012b\5\6\4\2\u010f\u012b\5\30\r\2\u0110\u012b\5"+
		"\32\16\2\u0111\u0112\7\20\2\2\u0112\u0113\7\3\2\2\u0113\u0114\5\24\13"+
		"\2\u0114\u0115\7\4\2\2\u0115\u012b\3\2\2\2\u0116\u0117\7\22\2\2\u0117"+
		"\u0118\7\3\2\2\u0118\u0119\5\24\13\2\u0119\u011a\7\4\2\2\u011a\u012b\3"+
		"\2\2\2\u011b\u011c\7\17\2\2\u011c\u011d\7\3\2\2\u011d\u011e\5\24\13\2"+
		"\u011e\u011f\7\4\2\2\u011f\u012b\3\2\2\2\u0120\u0121\7\21\2\2\u0121\u0122"+
		"\7\3\2\2\u0122\u0123\5\24\13\2\u0123\u0124\7\4\2\2\u0124\u012b\3\2\2\2"+
		"\u0125\u0126\7\24\2\2\u0126\u0127\7\3\2\2\u0127\u0128\5\24\13\2\u0128"+
		"\u0129\7\4\2\2\u0129\u012b\3\2\2\2\u012a\u00e4\3\2\2\2\u012a\u00e6\3\2"+
		"\2\2\u012a\u00f8\3\2\2\2\u012a\u010a\3\2\2\2\u012a\u010e\3\2\2\2\u012a"+
		"\u010f\3\2\2\2\u012a\u0110\3\2\2\2\u012a\u0111\3\2\2\2\u012a\u0116\3\2"+
		"\2\2\u012a\u011b\3\2\2\2\u012a\u0120\3\2\2\2\u012a\u0125\3\2\2\2\u012b"+
		"\25\3\2\2\2\u012c\u012e\7\7\2\2\u012d\u012c\3\2\2\2\u012d\u012e\3\2\2"+
		"\2\u012e\u012f\3\2\2\2\u012f\u0130\t\4\2\2\u0130\u0137\7\16\2\2\u0131"+
		"\u0133\7\7\2\2\u0132\u0131\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0138\3\2"+
		"\2\2\u0134\u0136\7\6\2\2\u0135\u0134\3\2\2\2\u0135\u0136\3\2\2\2\u0136"+
		"\u0138\3\2\2\2\u0137\u0132\3\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139\u0147\7\25\2\2\u013a\u013c\7\7\2\2\u013b\u013a\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u0147\7\26\2\2\u013e\u0140\7"+
		"\7\2\2\u013f\u013e\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0141\3\2\2\2\u0141"+
		"\u0147\7\23\2\2\u0142\u0144\7\7\2\2\u0143\u0142\3\2\2\2\u0143\u0144\3"+
		"\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\7\25\2\2\u0146\u012d\3\2\2\2\u0146"+
		"\u013b\3\2\2\2\u0146\u013f\3\2\2\2\u0146\u0143\3\2\2\2\u0147\27\3\2\2"+
		"\2\u0148\u014a\5\26\f\2\u0149\u0148\3\2\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u014b\3\2\2\2\u014b\u014c\7\r\2\2\u014c\31\3\2\2\2\u014d\u014e\5\26\f"+
		"\2\u014e\33\3\2\2\2%!&-\628I[}\u0085\u0087\u0093\u009c\u00a1\u00a3\u00ae"+
		"\u00b3\u00b5\u00d9\u00e4\u00ec\u00f1\u00f3\u00fe\u0103\u0105\u012a\u012d"+
		"\u0132\u0135\u0137\u013b\u013f\u0143\u0146\u0149";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}