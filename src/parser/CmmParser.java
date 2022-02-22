// Generated from C:/Users/UO258220/IdeaProjects/DLP_cmm/src/parser\Cmm.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, ID=37, INT_CONSTANT=38, 
		CHAR_CONSTANT=39, REAL_CONSTANT=40, COMMENT=41, EOL=42, WS=43;
	public static final int
		RULE_program = 0, RULE_definition = 1, RULE_main_definition = 2, RULE_var_definition = 3, 
		RULE_type = 4, RULE_func_type = 5, RULE_return_type = 6, RULE_built_in_type = 7, 
		RULE_statement = 8, RULE_body = 9, RULE_expression = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definition", "main_definition", "var_definition", "type", 
			"func_type", "return_type", "built_in_type", "statement", "body", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'void'", "'main'", "'('", "')'", "','", "';'", "'['", 
			"']'", "'struct'", "'double'", "'int'", "'char'", "'write'", "'read'", 
			"'='", "'while'", "'if'", "'else'", "'return'", "'.'", "'-'", "'!'", 
			"'*'", "'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", "'=='", 
			"'&&'", "'||'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ID", "INT_CONSTANT", "CHAR_CONSTANT", "REAL_CONSTANT", "COMMENT", 
			"EOL", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public Main_definitionContext main_definition() {
			return getRuleContext(Main_definitionContext.class,0);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(22);
					definition();
					}
					} 
				}
				setState(27);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(28);
			main_definition();
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

	public static class DefinitionContext extends ParserRuleContext {
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public Func_typeContext func_type() {
			return getRuleContext(Func_typeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		int _la;
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				var_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				func_type();
				setState(32);
				match(T__0);
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) {
					{
					{
					setState(33);
					var_definition();
					}
					}
					setState(38);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << ID) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << REAL_CONSTANT))) != 0)) {
					{
					{
					setState(39);
					statement();
					}
					}
					setState(44);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(45);
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

	public static class Main_definitionContext extends ParserRuleContext {
		public List<Var_definitionContext> var_definition() {
			return getRuleContexts(Var_definitionContext.class);
		}
		public Var_definitionContext var_definition(int i) {
			return getRuleContext(Var_definitionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Main_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_definition; }
	}

	public final Main_definitionContext main_definition() throws RecognitionException {
		Main_definitionContext _localctx = new Main_definitionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__2);
			setState(50);
			match(T__3);
			setState(51);
			match(T__4);
			setState(52);
			match(T__5);
			setState(53);
			match(T__0);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) {
				{
				{
				setState(54);
				var_definition();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << ID) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << REAL_CONSTANT))) != 0)) {
				{
				{
				setState(60);
				statement();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
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

	public static class Var_definitionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public Var_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_definition; }
	}

	public final Var_definitionContext var_definition() throws RecognitionException {
		Var_definitionContext _localctx = new Var_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			type(0);
			setState(69);
			match(ID);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(70);
				match(T__6);
				setState(71);
				match(ID);
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			match(T__7);
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

	public static class TypeContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public Func_typeContext func_type() {
			return getRuleContext(Func_typeContext.class,0);
		}
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(80);
				match(T__10);
				setState(81);
				match(T__0);
				setState(86); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(82);
					type(0);
					setState(83);
					match(ID);
					setState(84);
					match(T__7);
					}
					}
					setState(88); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0) );
				setState(90);
				match(T__1);
				}
				break;
			case 2:
				{
				setState(92);
				func_type();
				}
				break;
			case 3:
				{
				setState(93);
				return_type();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(96);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(97);
					match(T__8);
					setState(98);
					match(INT_CONSTANT);
					setState(99);
					match(T__9);
					}
					} 
				}
				setState(104);
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

	public static class Func_typeContext extends ParserRuleContext {
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<Built_in_typeContext> built_in_type() {
			return getRuleContexts(Built_in_typeContext.class);
		}
		public Built_in_typeContext built_in_type(int i) {
			return getRuleContext(Built_in_typeContext.class,i);
		}
		public Func_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_type; }
	}

	public final Func_typeContext func_type() throws RecognitionException {
		Func_typeContext _localctx = new Func_typeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_func_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			return_type();
			setState(106);
			match(ID);
			setState(107);
			match(T__4);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) {
				{
				setState(108);
				built_in_type();
				setState(109);
				match(ID);
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(110);
					match(T__6);
					setState(111);
					built_in_type();
					setState(112);
					match(ID);
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(121);
			match(T__5);
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

	public static class Return_typeContext extends ParserRuleContext {
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_return_type);
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				built_in_type();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(T__2);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Built_in_typeContext extends ParserRuleContext {
		public Built_in_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_built_in_type; }
	}

	public final Built_in_typeContext built_in_type() throws RecognitionException {
		Built_in_typeContext _localctx = new Built_in_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_built_in_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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

	public static class StatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(ID);
				setState(130);
				match(T__4);
				setState(139);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__22) | (1L << T__23) | (1L << ID) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << REAL_CONSTANT))) != 0)) {
					{
					setState(131);
					expression(0);
					setState(136);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__6) {
						{
						{
						setState(132);
						match(T__6);
						setState(133);
						expression(0);
						}
						}
						setState(138);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(141);
				match(T__5);
				setState(142);
				match(T__7);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(T__14);
				setState(144);
				expression(0);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(145);
					match(T__6);
					setState(146);
					expression(0);
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(152);
				match(T__7);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(154);
				match(T__15);
				setState(155);
				expression(0);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(156);
					match(T__6);
					setState(157);
					expression(0);
					}
					}
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(163);
				match(T__7);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(165);
				expression(0);
				setState(166);
				match(T__16);
				setState(167);
				expression(0);
				setState(168);
				match(T__7);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(170);
				match(T__17);
				setState(171);
				match(T__4);
				setState(172);
				expression(0);
				setState(173);
				match(T__5);
				setState(174);
				body();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				match(T__18);
				setState(177);
				match(T__4);
				setState(178);
				expression(0);
				setState(179);
				match(T__5);
				setState(180);
				body();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(182);
				match(T__18);
				setState(183);
				match(T__4);
				setState(184);
				expression(0);
				setState(185);
				match(T__5);
				setState(186);
				body();
				setState(187);
				match(T__19);
				setState(188);
				body();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(190);
				match(T__20);
				setState(191);
				expression(0);
				setState(192);
				match(T__7);
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

	public static class BodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_body);
		int _la;
		try {
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__14:
			case T__15:
			case T__17:
			case T__18:
			case T__20:
			case T__22:
			case T__23:
			case ID:
			case INT_CONSTANT:
			case CHAR_CONSTANT:
			case REAL_CONSTANT:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				statement();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(T__0);
				setState(201);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << ID) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << REAL_CONSTANT))) != 0)) {
					{
					{
					setState(198);
					statement();
					}
					}
					setState(203);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(204);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Built_in_typeContext built_in_type() {
			return getRuleContext(Built_in_typeContext.class,0);
		}
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public TerminalNode INT_CONSTANT() { return getToken(CmmParser.INT_CONSTANT, 0); }
		public TerminalNode CHAR_CONSTANT() { return getToken(CmmParser.CHAR_CONSTANT, 0); }
		public TerminalNode REAL_CONSTANT() { return getToken(CmmParser.REAL_CONSTANT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(208);
				match(T__4);
				setState(209);
				expression(0);
				setState(210);
				match(T__5);
				}
				break;
			case 2:
				{
				setState(212);
				match(T__4);
				setState(213);
				built_in_type();
				setState(214);
				match(T__5);
				setState(215);
				expression(12);
				}
				break;
			case 3:
				{
				setState(217);
				match(T__22);
				setState(218);
				expression(11);
				}
				break;
			case 4:
				{
				setState(219);
				match(T__23);
				setState(220);
				expression(10);
				}
				break;
			case 5:
				{
				setState(221);
				match(ID);
				setState(222);
				match(T__4);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__22) | (1L << T__23) | (1L << ID) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << REAL_CONSTANT))) != 0)) {
					{
					setState(223);
					expression(0);
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__6) {
						{
						{
						setState(224);
						match(T__6);
						setState(225);
						expression(0);
						}
						}
						setState(230);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(233);
				match(T__5);
				}
				break;
			case 6:
				{
				setState(234);
				match(ID);
				}
				break;
			case 7:
				{
				setState(235);
				match(INT_CONSTANT);
				}
				break;
			case 8:
				{
				setState(236);
				match(CHAR_CONSTANT);
				}
				break;
			case 9:
				{
				setState(237);
				match(REAL_CONSTANT);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(262);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(260);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(240);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(241);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(242);
						expression(10);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(243);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(244);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__27) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(245);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(246);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(247);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(248);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(249);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(250);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__35) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(251);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(253);
						match(T__8);
						setState(254);
						expression(0);
						setState(255);
						match(T__9);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(257);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(258);
						match(T__21);
						setState(259);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(264);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 10:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 9);
		case 2:
			return precpred(_ctx, 8);
		case 3:
			return precpred(_ctx, 7);
		case 4:
			return precpred(_ctx, 6);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u010c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\3\3\3\3\3\3\3\3\7"+
		"\3%\n\3\f\3\16\3(\13\3\3\3\7\3+\n\3\f\3\16\3.\13\3\3\3\3\3\5\3\62\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\7\4:\n\4\f\4\16\4=\13\4\3\4\7\4@\n\4\f\4\16\4"+
		"C\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5K\n\5\f\5\16\5N\13\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\6\6Y\n\6\r\6\16\6Z\3\6\3\6\3\6\3\6\5\6a\n\6\3\6\3"+
		"\6\3\6\3\6\7\6g\n\6\f\6\16\6j\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\7\7u\n\7\f\7\16\7x\13\7\5\7z\n\7\3\7\3\7\3\b\3\b\5\b\u0080\n\b\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\7\n\u0089\n\n\f\n\16\n\u008c\13\n\5\n\u008e\n\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u0096\n\n\f\n\16\n\u0099\13\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\7\n\u00a1\n\n\f\n\16\n\u00a4\13\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00c5\n\n\3\13\3\13\3\13\7\13\u00ca"+
		"\n\13\f\13\16\13\u00cd\13\13\3\13\5\13\u00d0\n\13\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00e5\n\f"+
		"\f\f\16\f\u00e8\13\f\5\f\u00ea\n\f\3\f\3\f\3\f\3\f\3\f\5\f\u00f1\n\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\7\f\u0107\n\f\f\f\16\f\u010a\13\f\3\f\2\4\n\26\r\2\4\6\b\n\f"+
		"\16\20\22\24\26\2\7\3\2\16\20\3\2\33\35\4\2\31\31\36\36\3\2\37$\3\2%&"+
		"\2\u012b\2\33\3\2\2\2\4\61\3\2\2\2\6\63\3\2\2\2\bF\3\2\2\2\n`\3\2\2\2"+
		"\fk\3\2\2\2\16\177\3\2\2\2\20\u0081\3\2\2\2\22\u00c4\3\2\2\2\24\u00cf"+
		"\3\2\2\2\26\u00f0\3\2\2\2\30\32\5\4\3\2\31\30\3\2\2\2\32\35\3\2\2\2\33"+
		"\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2\36\37\5\6\4\2\37"+
		"\3\3\2\2\2 \62\5\b\5\2!\"\5\f\7\2\"&\7\3\2\2#%\5\b\5\2$#\3\2\2\2%(\3\2"+
		"\2\2&$\3\2\2\2&\'\3\2\2\2\',\3\2\2\2(&\3\2\2\2)+\5\22\n\2*)\3\2\2\2+."+
		"\3\2\2\2,*\3\2\2\2,-\3\2\2\2-/\3\2\2\2.,\3\2\2\2/\60\7\4\2\2\60\62\3\2"+
		"\2\2\61 \3\2\2\2\61!\3\2\2\2\62\5\3\2\2\2\63\64\7\5\2\2\64\65\7\6\2\2"+
		"\65\66\7\7\2\2\66\67\7\b\2\2\67;\7\3\2\28:\5\b\5\298\3\2\2\2:=\3\2\2\2"+
		";9\3\2\2\2;<\3\2\2\2<A\3\2\2\2=;\3\2\2\2>@\5\22\n\2?>\3\2\2\2@C\3\2\2"+
		"\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\4\2\2E\7\3\2\2\2FG\5\n"+
		"\6\2GL\7\'\2\2HI\7\t\2\2IK\7\'\2\2JH\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2"+
		"\2\2MO\3\2\2\2NL\3\2\2\2OP\7\n\2\2P\t\3\2\2\2QR\b\6\1\2RS\7\r\2\2SX\7"+
		"\3\2\2TU\5\n\6\2UV\7\'\2\2VW\7\n\2\2WY\3\2\2\2XT\3\2\2\2YZ\3\2\2\2ZX\3"+
		"\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\4\2\2]a\3\2\2\2^a\5\f\7\2_a\5\16\b\2"+
		"`Q\3\2\2\2`^\3\2\2\2`_\3\2\2\2ah\3\2\2\2bc\f\6\2\2cd\7\13\2\2de\7(\2\2"+
		"eg\7\f\2\2fb\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\13\3\2\2\2jh\3\2\2"+
		"\2kl\5\16\b\2lm\7\'\2\2my\7\7\2\2no\5\20\t\2ov\7\'\2\2pq\7\t\2\2qr\5\20"+
		"\t\2rs\7\'\2\2su\3\2\2\2tp\3\2\2\2ux\3\2\2\2vt\3\2\2\2vw\3\2\2\2wz\3\2"+
		"\2\2xv\3\2\2\2yn\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7\b\2\2|\r\3\2\2\2}\u0080"+
		"\5\20\t\2~\u0080\7\5\2\2\177}\3\2\2\2\177~\3\2\2\2\u0080\17\3\2\2\2\u0081"+
		"\u0082\t\2\2\2\u0082\21\3\2\2\2\u0083\u0084\7\'\2\2\u0084\u008d\7\7\2"+
		"\2\u0085\u008a\5\26\f\2\u0086\u0087\7\t\2\2\u0087\u0089\5\26\f\2\u0088"+
		"\u0086\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2"+
		"\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u0085\3\2\2\2\u008d"+
		"\u008e\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7\b\2\2\u0090\u00c5\7\n"+
		"\2\2\u0091\u0092\7\21\2\2\u0092\u0097\5\26\f\2\u0093\u0094\7\t\2\2\u0094"+
		"\u0096\5\26\f\2\u0095\u0093\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3"+
		"\2\2\2\u0097\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a"+
		"\u009b\7\n\2\2\u009b\u00c5\3\2\2\2\u009c\u009d\7\22\2\2\u009d\u00a2\5"+
		"\26\f\2\u009e\u009f\7\t\2\2\u009f\u00a1\5\26\f\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2"+
		"\2\2\u00a4\u00a2\3\2\2\2\u00a5\u00a6\7\n\2\2\u00a6\u00c5\3\2\2\2\u00a7"+
		"\u00a8\5\26\f\2\u00a8\u00a9\7\23\2\2\u00a9\u00aa\5\26\f\2\u00aa\u00ab"+
		"\7\n\2\2\u00ab\u00c5\3\2\2\2\u00ac\u00ad\7\24\2\2\u00ad\u00ae\7\7\2\2"+
		"\u00ae\u00af\5\26\f\2\u00af\u00b0\7\b\2\2\u00b0\u00b1\5\24\13\2\u00b1"+
		"\u00c5\3\2\2\2\u00b2\u00b3\7\25\2\2\u00b3\u00b4\7\7\2\2\u00b4\u00b5\5"+
		"\26\f\2\u00b5\u00b6\7\b\2\2\u00b6\u00b7\5\24\13\2\u00b7\u00c5\3\2\2\2"+
		"\u00b8\u00b9\7\25\2\2\u00b9\u00ba\7\7\2\2\u00ba\u00bb\5\26\f\2\u00bb\u00bc"+
		"\7\b\2\2\u00bc\u00bd\5\24\13\2\u00bd\u00be\7\26\2\2\u00be\u00bf\5\24\13"+
		"\2\u00bf\u00c5\3\2\2\2\u00c0\u00c1\7\27\2\2\u00c1\u00c2\5\26\f\2\u00c2"+
		"\u00c3\7\n\2\2\u00c3\u00c5\3\2\2\2\u00c4\u0083\3\2\2\2\u00c4\u0091\3\2"+
		"\2\2\u00c4\u009c\3\2\2\2\u00c4\u00a7\3\2\2\2\u00c4\u00ac\3\2\2\2\u00c4"+
		"\u00b2\3\2\2\2\u00c4\u00b8\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c5\23\3\2\2"+
		"\2\u00c6\u00d0\5\22\n\2\u00c7\u00cb\7\3\2\2\u00c8\u00ca\5\22\n\2\u00c9"+
		"\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00ce\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d0\7\4\2\2\u00cf"+
		"\u00c6\3\2\2\2\u00cf\u00c7\3\2\2\2\u00d0\25\3\2\2\2\u00d1\u00d2\b\f\1"+
		"\2\u00d2\u00d3\7\7\2\2\u00d3\u00d4\5\26\f\2\u00d4\u00d5\7\b\2\2\u00d5"+
		"\u00f1\3\2\2\2\u00d6\u00d7\7\7\2\2\u00d7\u00d8\5\20\t\2\u00d8\u00d9\7"+
		"\b\2\2\u00d9\u00da\5\26\f\16\u00da\u00f1\3\2\2\2\u00db\u00dc\7\31\2\2"+
		"\u00dc\u00f1\5\26\f\r\u00dd\u00de\7\32\2\2\u00de\u00f1\5\26\f\f\u00df"+
		"\u00e0\7\'\2\2\u00e0\u00e9\7\7\2\2\u00e1\u00e6\5\26\f\2\u00e2\u00e3\7"+
		"\t\2\2\u00e3\u00e5\5\26\f\2\u00e4\u00e2\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2"+
		"\2\2\u00e9\u00e1\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb"+
		"\u00f1\7\b\2\2\u00ec\u00f1\7\'\2\2\u00ed\u00f1\7(\2\2\u00ee\u00f1\7)\2"+
		"\2\u00ef\u00f1\7*\2\2\u00f0\u00d1\3\2\2\2\u00f0\u00d6\3\2\2\2\u00f0\u00db"+
		"\3\2\2\2\u00f0\u00dd\3\2\2\2\u00f0\u00df\3\2\2\2\u00f0\u00ec\3\2\2\2\u00f0"+
		"\u00ed\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\u0108\3\2"+
		"\2\2\u00f2\u00f3\f\13\2\2\u00f3\u00f4\t\3\2\2\u00f4\u0107\5\26\f\f\u00f5"+
		"\u00f6\f\n\2\2\u00f6\u00f7\t\4\2\2\u00f7\u0107\5\26\f\13\u00f8\u00f9\f"+
		"\t\2\2\u00f9\u00fa\t\5\2\2\u00fa\u0107\5\26\f\n\u00fb\u00fc\f\b\2\2\u00fc"+
		"\u00fd\t\6\2\2\u00fd\u0107\5\26\f\t\u00fe\u00ff\f\20\2\2\u00ff\u0100\7"+
		"\13\2\2\u0100\u0101\5\26\f\2\u0101\u0102\7\f\2\2\u0102\u0107\3\2\2\2\u0103"+
		"\u0104\f\17\2\2\u0104\u0105\7\30\2\2\u0105\u0107\7\'\2\2\u0106\u00f2\3"+
		"\2\2\2\u0106\u00f5\3\2\2\2\u0106\u00f8\3\2\2\2\u0106\u00fb\3\2\2\2\u0106"+
		"\u00fe\3\2\2\2\u0106\u0103\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2"+
		"\2\2\u0108\u0109\3\2\2\2\u0109\27\3\2\2\2\u010a\u0108\3\2\2\2\33\33&,"+
		"\61;ALZ`hvy\177\u008a\u008d\u0097\u00a2\u00c4\u00cb\u00cf\u00e6\u00e9"+
		"\u00f0\u0106\u0108";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}