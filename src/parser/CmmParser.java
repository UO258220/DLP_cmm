// Generated from C:/Users/UO258220/IdeaProjects/DLP_cmm/src/parser\Cmm.g4 by ANTLR 4.9.2
package parser;

    import program.*;
    import program.expression.*;
    import program.statements.*;
    import program.types.*;

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
		RULE_statement = 8, RULE_body = 9, RULE_expression = 10, RULE_arguments = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "definition", "main_definition", "var_definition", "type", 
			"func_type", "return_type", "built_in_type", "statement", "body", "expression", 
			"arguments"
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
		public TerminalNode EOF() { return getToken(CmmParser.EOF, 0); }
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
			setState(27);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(24);
					definition();
					}
					} 
				}
				setState(29);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			setState(30);
			main_definition();
			setState(31);
			match(EOF);
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
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				var_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				func_type();
				setState(35);
				match(T__0);
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) {
					{
					{
					setState(36);
					var_definition();
					}
					}
					setState(41);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << ID) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << REAL_CONSTANT))) != 0)) {
					{
					{
					setState(42);
					statement();
					}
					}
					setState(47);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(48);
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
			setState(52);
			match(T__2);
			setState(53);
			match(T__3);
			setState(54);
			match(T__4);
			setState(55);
			match(T__5);
			setState(56);
			match(T__0);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) {
				{
				{
				setState(57);
				var_definition();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << ID) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << REAL_CONSTANT))) != 0)) {
				{
				{
				setState(63);
				statement();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
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
			setState(71);
			type(0);
			setState(72);
			match(ID);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(73);
				match(T__6);
				setState(74);
				match(ID);
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
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
		public Type ast;
		public Token s;
		public TypeContext t;
		public Token ID;
		public Func_typeContext func_type;
		public Return_typeContext return_type;
		public List<TerminalNode> ID() { return getTokens(CmmParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(CmmParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
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
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(83);
				((TypeContext)_localctx).s = match(T__10);
				 ((TypeContext)_localctx).ast =  new RecordType(((TypeContext)_localctx).s.getLine(), ((TypeContext)_localctx).s.getCharPositionInLine() + 1,
				                        new ArrayList<RecordField>()); 
				setState(85);
				match(T__0);
				setState(91); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(86);
					((TypeContext)_localctx).t = type(0);
					setState(87);
					((TypeContext)_localctx).ID = match(ID);
					setState(88);
					match(T__7);
					 ((RecordType)_localctx.ast).addField(new RecordField(((TypeContext)_localctx).t.ast, (((TypeContext)_localctx).ID!=null?((TypeContext)_localctx).ID.getText():null))); 
					}
					}
					setState(93); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13))) != 0) );
				setState(95);
				match(T__1);
				}
				break;
			case 2:
				{
				setState(97);
				((TypeContext)_localctx).func_type = func_type();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).func_type.ast; 
				}
				break;
			case 3:
				{
				setState(100);
				((TypeContext)_localctx).return_type = return_type();
				 ((TypeContext)_localctx).ast =  ((TypeContext)_localctx).return_type.ast; 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(111);
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
					setState(105);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(106);
					match(T__8);
					setState(107);
					match(INT_CONSTANT);
					setState(108);
					match(T__9);
					}
					} 
				}
				setState(113);
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
		public Type ast;
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
			setState(114);
			return_type();
			setState(115);
			match(ID);
			setState(116);
			match(T__4);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) {
				{
				setState(117);
				built_in_type();
				setState(118);
				match(ID);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(119);
					match(T__6);
					setState(120);
					built_in_type();
					setState(121);
					match(ID);
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(130);
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
		public Type ast;
		public Built_in_typeContext built_in_type;
		public Token v;
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
			setState(137);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__12:
			case T__13:
				enterOuterAlt(_localctx, 1);
				{
				setState(132);
				((Return_typeContext)_localctx).built_in_type = built_in_type();
				 ((Return_typeContext)_localctx).ast =  ((Return_typeContext)_localctx).built_in_type.ast; 
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				((Return_typeContext)_localctx).v = match(T__2);
				 ((Return_typeContext)_localctx).ast =  new VoidType(((Return_typeContext)_localctx).v.getLine(), ((Return_typeContext)_localctx).v.getCharPositionInLine() + 1); 
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
		public Type ast;
		public Token d;
		public Token i;
		public Token c;
		public Built_in_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_built_in_type; }
	}

	public final Built_in_typeContext built_in_type() throws RecognitionException {
		Built_in_typeContext _localctx = new Built_in_typeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_built_in_type);
		try {
			setState(145);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				((Built_in_typeContext)_localctx).d = match(T__11);
				 ((Built_in_typeContext)_localctx).ast =  new DoubleType(((Built_in_typeContext)_localctx).d.getLine(), ((Built_in_typeContext)_localctx).d.getCharPositionInLine() + 1); 
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(141);
				((Built_in_typeContext)_localctx).i = match(T__12);
				 ((Built_in_typeContext)_localctx).ast =  new IntegerType(((Built_in_typeContext)_localctx).i.getLine(), ((Built_in_typeContext)_localctx).i.getCharPositionInLine() + 1); 
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				((Built_in_typeContext)_localctx).c = match(T__13);
				 ((Built_in_typeContext)_localctx).ast =  new CharType(((Built_in_typeContext)_localctx).c.getLine(), ((Built_in_typeContext)_localctx).c.getCharPositionInLine() + 1); 
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

	public static class StatementContext extends ParserRuleContext {
		public List<Statement> ast = new ArrayList<Statement>();
		public Token ID;
		public ArgumentsContext arguments;
		public Token w;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public Token r;
		public BodyContext body;
		public Token i;
		public BodyContext b1;
		public BodyContext b2;
		public TerminalNode ID() { return getToken(CmmParser.ID, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
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
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				((StatementContext)_localctx).ID = match(ID);
				setState(148);
				match(T__4);
				setState(149);
				((StatementContext)_localctx).arguments = arguments();
				setState(150);
				match(T__5);
				 _localctx.ast.add(new FuncInvocation(((StatementContext)_localctx).ID.getLine(), ((StatementContext)_localctx).ID.getCharPositionInLine() + 1,
				                        new Variable(((StatementContext)_localctx).ID.getLine(), ((StatementContext)_localctx).ID.getCharPositionInLine() + 1, (((StatementContext)_localctx).ID!=null?((StatementContext)_localctx).ID.getText():null)), ((StatementContext)_localctx).arguments.ast)); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				((StatementContext)_localctx).w = match(T__14);
				setState(154);
				((StatementContext)_localctx).e1 = expression(0);
				 _localctx.ast.add(new WriteStatement(((StatementContext)_localctx).w.getLine(), ((StatementContext)_localctx).w.getCharPositionInLine() + 1, ((StatementContext)_localctx).e1.ast)); 
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(156);
					match(T__6);
					setState(157);
					((StatementContext)_localctx).e2 = expression(0);
					 _localctx.ast.add(new WriteStatement(((StatementContext)_localctx).w.getLine(), ((StatementContext)_localctx).w.getCharPositionInLine() + 1, ((StatementContext)_localctx).e2.ast)); 
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(165);
				match(T__7);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				((StatementContext)_localctx).r = match(T__15);
				setState(168);
				((StatementContext)_localctx).e1 = expression(0);
				 _localctx.ast.add(new ReadStatement(((StatementContext)_localctx).r.getLine(), ((StatementContext)_localctx).r.getCharPositionInLine() + 1, ((StatementContext)_localctx).e1.ast)); 
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(170);
					match(T__6);
					setState(171);
					((StatementContext)_localctx).e2 = expression(0);
					 _localctx.ast.add(new ReadStatement(((StatementContext)_localctx).r.getLine(), ((StatementContext)_localctx).r.getCharPositionInLine() + 1, ((StatementContext)_localctx).e2.ast)); 
					}
					}
					setState(178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(179);
				match(T__7);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(181);
				((StatementContext)_localctx).e1 = expression(0);
				setState(182);
				match(T__16);
				setState(183);
				((StatementContext)_localctx).e2 = expression(0);
				setState(184);
				match(T__7);
				 _localctx.ast.add(new Assignment(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).e2.ast)); 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(187);
				((StatementContext)_localctx).w = match(T__17);
				setState(188);
				match(T__4);
				setState(189);
				((StatementContext)_localctx).e1 = expression(0);
				setState(190);
				match(T__5);
				setState(191);
				((StatementContext)_localctx).body = body();
				 _localctx.ast.add(new While(((StatementContext)_localctx).w.getLine(), ((StatementContext)_localctx).w.getCharPositionInLine() + 1, ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).body.ast)); 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(194);
				((StatementContext)_localctx).i = match(T__18);
				setState(195);
				match(T__4);
				setState(196);
				((StatementContext)_localctx).e1 = expression(0);
				setState(197);
				match(T__5);
				setState(198);
				((StatementContext)_localctx).b1 = body();
				 _localctx.ast.add(new IfElse(((StatementContext)_localctx).i.getLine(), ((StatementContext)_localctx).i.getCharPositionInLine() + 1, ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).b1.ast)); 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(201);
				((StatementContext)_localctx).i = match(T__18);
				setState(202);
				match(T__4);
				setState(203);
				((StatementContext)_localctx).e1 = expression(0);
				setState(204);
				match(T__5);
				setState(205);
				((StatementContext)_localctx).b1 = body();
				setState(206);
				match(T__19);
				setState(207);
				((StatementContext)_localctx).b2 = body();
				 _localctx.ast.add(new IfElse(((StatementContext)_localctx).i.getLine(),
				                        ((StatementContext)_localctx).i.getCharPositionInLine() + 1, ((StatementContext)_localctx).e1.ast, ((StatementContext)_localctx).b1.ast, ((StatementContext)_localctx).b2.ast)); 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(210);
				match(T__20);
				setState(211);
				((StatementContext)_localctx).e1 = expression(0);
				 _localctx.ast.add(new ReturnStatement(((StatementContext)_localctx).e1.ast.getLine(), ((StatementContext)_localctx).e1.ast.getColumn(), ((StatementContext)_localctx).e1.ast)); 
				setState(213);
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
		public List<Statement> ast = new ArrayList<Statement>();
		public StatementContext s1;
		public StatementContext s2;
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
			setState(230);
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
				setState(217);
				((BodyContext)_localctx).s1 = statement();
				 ((BodyContext)_localctx).s1.ast.forEach(s -> _localctx.ast.add(s)); 
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				match(T__0);
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__14) | (1L << T__15) | (1L << T__17) | (1L << T__18) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << ID) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << REAL_CONSTANT))) != 0)) {
					{
					{
					setState(221);
					((BodyContext)_localctx).s2 = statement();
					 ((BodyContext)_localctx).s2.ast.forEach(s -> _localctx.ast.add(s)); 
					}
					}
					setState(228);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(229);
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
		public Expression ast;
		public ExpressionContext e1;
		public Token ID;
		public ArgumentsContext arguments;
		public Token ic;
		public Token cc;
		public Token rc;
		public Token op;
		public ExpressionContext e2;
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
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
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
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(233);
				match(T__4);
				setState(234);
				((ExpressionContext)_localctx).e1 = expression(0);
				setState(235);
				match(T__5);
				 ((ExpressionContext)_localctx).ast =  ((ExpressionContext)_localctx).e1.ast; 
				}
				break;
			case 2:
				{
				setState(238);
				match(T__4);
				setState(239);
				built_in_type();
				setState(240);
				match(T__5);
				setState(241);
				expression(12);
				}
				break;
			case 3:
				{
				setState(243);
				match(T__22);
				setState(244);
				((ExpressionContext)_localctx).e1 = expression(11);
				 ((ExpressionContext)_localctx).ast =  new UnaryMinus(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast); 
				}
				break;
			case 4:
				{
				setState(247);
				match(T__23);
				setState(248);
				((ExpressionContext)_localctx).e1 = expression(10);
				 ((ExpressionContext)_localctx).ast =  new Negation(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast); 
				}
				break;
			case 5:
				{
				setState(251);
				((ExpressionContext)_localctx).ID = match(ID);
				setState(252);
				match(T__4);
				setState(253);
				((ExpressionContext)_localctx).arguments = arguments();
				setState(254);
				match(T__5);
				 ((ExpressionContext)_localctx).ast =  new FuncInvocation(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1,
				                        new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)), ((ExpressionContext)_localctx).arguments.ast); 
				}
				break;
			case 6:
				{
				setState(257);
				((ExpressionContext)_localctx).ID = match(ID);
				 ((ExpressionContext)_localctx).ast =  new Variable(((ExpressionContext)_localctx).ID.getLine(), ((ExpressionContext)_localctx).ID.getCharPositionInLine() + 1, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
				}
				break;
			case 7:
				{
				setState(259);
				((ExpressionContext)_localctx).ic = match(INT_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new IntLiteral(((ExpressionContext)_localctx).ic.getLine(), ((ExpressionContext)_localctx).ic.getCharPositionInLine() + 1,
				                        LexerHelper.lexemeToInt((((ExpressionContext)_localctx).ic!=null?((ExpressionContext)_localctx).ic.getText():null))); 
				}
				break;
			case 8:
				{
				setState(261);
				((ExpressionContext)_localctx).cc = match(CHAR_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new CharLiteral(((ExpressionContext)_localctx).cc.getLine(), ((ExpressionContext)_localctx).cc.getCharPositionInLine() + 1,
				                        LexerHelper.lexemeToChar((((ExpressionContext)_localctx).cc!=null?((ExpressionContext)_localctx).cc.getText():null))); 
				}
				break;
			case 9:
				{
				setState(263);
				((ExpressionContext)_localctx).rc = match(REAL_CONSTANT);
				 ((ExpressionContext)_localctx).ast =  new RealLiteral(((ExpressionContext)_localctx).rc.getLine(), ((ExpressionContext)_localctx).rc.getCharPositionInLine() + 1,
				                        LexerHelper.lexemeToReal((((ExpressionContext)_localctx).rc!=null?((ExpressionContext)_localctx).rc.getText():null))); 
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(297);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(267);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(268);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(269);
						((ExpressionContext)_localctx).e2 = expression(10);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(272);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(273);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__27) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(274);
						((ExpressionContext)_localctx).e2 = expression(9);
						 ((ExpressionContext)_localctx).ast =  new Arithmetic(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(277);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(278);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0)) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(279);
						((ExpressionContext)_localctx).e2 = expression(8);
						 ((ExpressionContext)_localctx).ast =  new Comparison(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(282);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(283);
						((ExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__35) ) {
							((ExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(284);
						((ExpressionContext)_localctx).e2 = expression(7);
						 ((ExpressionContext)_localctx).ast =  new Logical(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), (((ExpressionContext)_localctx).op!=null?((ExpressionContext)_localctx).op.getText():null), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(287);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(288);
						match(T__8);
						setState(289);
						((ExpressionContext)_localctx).e2 = expression(0);
						setState(290);
						match(T__9);
						 ((ExpressionContext)_localctx).ast =  new Indexing(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, ((ExpressionContext)_localctx).e2.ast); 
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						_localctx.e1 = _prevctx;
						_localctx.e1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(293);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(294);
						match(T__21);
						setState(295);
						((ExpressionContext)_localctx).ID = match(ID);
						 ((ExpressionContext)_localctx).ast =  new FieldAccess(((ExpressionContext)_localctx).e1.ast.getLine(), ((ExpressionContext)_localctx).e1.ast.getColumn(), ((ExpressionContext)_localctx).e1.ast, (((ExpressionContext)_localctx).ID!=null?((ExpressionContext)_localctx).ID.getText():null)); 
						}
						break;
					}
					} 
				}
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class ArgumentsContext extends ParserRuleContext {
		public List<Expression> ast = new ArrayList<Expression>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__22) | (1L << T__23) | (1L << ID) | (1L << INT_CONSTANT) | (1L << CHAR_CONSTANT) | (1L << REAL_CONSTANT))) != 0)) {
				{
				setState(302);
				((ArgumentsContext)_localctx).e1 = expression(0);
				 _localctx.ast.add(((ArgumentsContext)_localctx).e1.ast); 
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(304);
					match(T__6);
					setState(305);
					((ArgumentsContext)_localctx).e2 = expression(0);
					 _localctx.ast.add(((ArgumentsContext)_localctx).e2.ast); 
					}
					}
					setState(312);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u013e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\7\3(\n\3\f\3\16\3+\13\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3\3"+
		"\3\5\3\65\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\3\4\7\4"+
		"C\n\4\f\4\16\4F\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6^\n\6\r\6\16\6_\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\5\6j\n\6\3\6\3\6\3\6\3\6\7\6p\n\6\f\6\16\6s\13"+
		"\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7~\n\7\f\7\16\7\u0081\13\7\5"+
		"\7\u0083\n\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\b\u008c\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\5\t\u0094\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\7\n\u00a3\n\n\f\n\16\n\u00a6\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\7\n\u00b1\n\n\f\n\16\n\u00b4\13\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u00da\n\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\7\13\u00e3\n\13\f\13\16\13\u00e6\13\13\3\13\5\13"+
		"\u00e9\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u010c\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7"+
		"\f\u012c\n\f\f\f\16\f\u012f\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u0137\n\r"+
		"\f\r\16\r\u013a\13\r\5\r\u013c\n\r\3\r\2\4\n\26\16\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\2\6\3\2\33\35\4\2\31\31\36\36\3\2\37$\3\2%&\2\u015c\2\35\3\2"+
		"\2\2\4\64\3\2\2\2\6\66\3\2\2\2\bI\3\2\2\2\ni\3\2\2\2\ft\3\2\2\2\16\u008b"+
		"\3\2\2\2\20\u0093\3\2\2\2\22\u00d9\3\2\2\2\24\u00e8\3\2\2\2\26\u010b\3"+
		"\2\2\2\30\u013b\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33"+
		"\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\5\6\4\2!\"\7\2\2\3"+
		"\"\3\3\2\2\2#\65\5\b\5\2$%\5\f\7\2%)\7\3\2\2&(\5\b\5\2\'&\3\2\2\2(+\3"+
		"\2\2\2)\'\3\2\2\2)*\3\2\2\2*/\3\2\2\2+)\3\2\2\2,.\5\22\n\2-,\3\2\2\2."+
		"\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\4"+
		"\2\2\63\65\3\2\2\2\64#\3\2\2\2\64$\3\2\2\2\65\5\3\2\2\2\66\67\7\5\2\2"+
		"\678\7\6\2\289\7\7\2\29:\7\b\2\2:>\7\3\2\2;=\5\b\5\2<;\3\2\2\2=@\3\2\2"+
		"\2><\3\2\2\2>?\3\2\2\2?D\3\2\2\2@>\3\2\2\2AC\5\22\n\2BA\3\2\2\2CF\3\2"+
		"\2\2DB\3\2\2\2DE\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\4\2\2H\7\3\2\2\2IJ\5"+
		"\n\6\2JO\7\'\2\2KL\7\t\2\2LN\7\'\2\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3"+
		"\2\2\2PR\3\2\2\2QO\3\2\2\2RS\7\n\2\2S\t\3\2\2\2TU\b\6\1\2UV\7\r\2\2VW"+
		"\b\6\1\2W]\7\3\2\2XY\5\n\6\2YZ\7\'\2\2Z[\7\n\2\2[\\\b\6\1\2\\^\3\2\2\2"+
		"]X\3\2\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`a\3\2\2\2ab\7\4\2\2bj\3\2\2\2"+
		"cd\5\f\7\2de\b\6\1\2ej\3\2\2\2fg\5\16\b\2gh\b\6\1\2hj\3\2\2\2iT\3\2\2"+
		"\2ic\3\2\2\2if\3\2\2\2jq\3\2\2\2kl\f\6\2\2lm\7\13\2\2mn\7(\2\2np\7\f\2"+
		"\2ok\3\2\2\2ps\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\13\3\2\2\2sq\3\2\2\2tu\5\16"+
		"\b\2uv\7\'\2\2v\u0082\7\7\2\2wx\5\20\t\2x\177\7\'\2\2yz\7\t\2\2z{\5\20"+
		"\t\2{|\7\'\2\2|~\3\2\2\2}y\3\2\2\2~\u0081\3\2\2\2\177}\3\2\2\2\177\u0080"+
		"\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0082w\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\b\2\2\u0085\r\3\2\2\2\u0086"+
		"\u0087\5\20\t\2\u0087\u0088\b\b\1\2\u0088\u008c\3\2\2\2\u0089\u008a\7"+
		"\5\2\2\u008a\u008c\b\b\1\2\u008b\u0086\3\2\2\2\u008b\u0089\3\2\2\2\u008c"+
		"\17\3\2\2\2\u008d\u008e\7\16\2\2\u008e\u0094\b\t\1\2\u008f\u0090\7\17"+
		"\2\2\u0090\u0094\b\t\1\2\u0091\u0092\7\20\2\2\u0092\u0094\b\t\1\2\u0093"+
		"\u008d\3\2\2\2\u0093\u008f\3\2\2\2\u0093\u0091\3\2\2\2\u0094\21\3\2\2"+
		"\2\u0095\u0096\7\'\2\2\u0096\u0097\7\7\2\2\u0097\u0098\5\30\r\2\u0098"+
		"\u0099\7\b\2\2\u0099\u009a\b\n\1\2\u009a\u00da\3\2\2\2\u009b\u009c\7\21"+
		"\2\2\u009c\u009d\5\26\f\2\u009d\u00a4\b\n\1\2\u009e\u009f\7\t\2\2\u009f"+
		"\u00a0\5\26\f\2\u00a0\u00a1\b\n\1\2\u00a1\u00a3\3\2\2\2\u00a2\u009e\3"+
		"\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00a7\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7\n\2\2\u00a8\u00da\3\2"+
		"\2\2\u00a9\u00aa\7\22\2\2\u00aa\u00ab\5\26\f\2\u00ab\u00b2\b\n\1\2\u00ac"+
		"\u00ad\7\t\2\2\u00ad\u00ae\5\26\f\2\u00ae\u00af\b\n\1\2\u00af\u00b1\3"+
		"\2\2\2\u00b0\u00ac\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7\n"+
		"\2\2\u00b6\u00da\3\2\2\2\u00b7\u00b8\5\26\f\2\u00b8\u00b9\7\23\2\2\u00b9"+
		"\u00ba\5\26\f\2\u00ba\u00bb\7\n\2\2\u00bb\u00bc\b\n\1\2\u00bc\u00da\3"+
		"\2\2\2\u00bd\u00be\7\24\2\2\u00be\u00bf\7\7\2\2\u00bf\u00c0\5\26\f\2\u00c0"+
		"\u00c1\7\b\2\2\u00c1\u00c2\5\24\13\2\u00c2\u00c3\b\n\1\2\u00c3\u00da\3"+
		"\2\2\2\u00c4\u00c5\7\25\2\2\u00c5\u00c6\7\7\2\2\u00c6\u00c7\5\26\f\2\u00c7"+
		"\u00c8\7\b\2\2\u00c8\u00c9\5\24\13\2\u00c9\u00ca\b\n\1\2\u00ca\u00da\3"+
		"\2\2\2\u00cb\u00cc\7\25\2\2\u00cc\u00cd\7\7\2\2\u00cd\u00ce\5\26\f\2\u00ce"+
		"\u00cf\7\b\2\2\u00cf\u00d0\5\24\13\2\u00d0\u00d1\7\26\2\2\u00d1\u00d2"+
		"\5\24\13\2\u00d2\u00d3\b\n\1\2\u00d3\u00da\3\2\2\2\u00d4\u00d5\7\27\2"+
		"\2\u00d5\u00d6\5\26\f\2\u00d6\u00d7\b\n\1\2\u00d7\u00d8\7\n\2\2\u00d8"+
		"\u00da\3\2\2\2\u00d9\u0095\3\2\2\2\u00d9\u009b\3\2\2\2\u00d9\u00a9\3\2"+
		"\2\2\u00d9\u00b7\3\2\2\2\u00d9\u00bd\3\2\2\2\u00d9\u00c4\3\2\2\2\u00d9"+
		"\u00cb\3\2\2\2\u00d9\u00d4\3\2\2\2\u00da\23\3\2\2\2\u00db\u00dc\5\22\n"+
		"\2\u00dc\u00dd\b\13\1\2\u00dd\u00e9\3\2\2\2\u00de\u00e4\7\3\2\2\u00df"+
		"\u00e0\5\22\n\2\u00e0\u00e1\b\13\1\2\u00e1\u00e3\3\2\2\2\u00e2\u00df\3"+
		"\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e7\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e7\u00e9\7\4\2\2\u00e8\u00db\3\2"+
		"\2\2\u00e8\u00de\3\2\2\2\u00e9\25\3\2\2\2\u00ea\u00eb\b\f\1\2\u00eb\u00ec"+
		"\7\7\2\2\u00ec\u00ed\5\26\f\2\u00ed\u00ee\7\b\2\2\u00ee\u00ef\b\f\1\2"+
		"\u00ef\u010c\3\2\2\2\u00f0\u00f1\7\7\2\2\u00f1\u00f2\5\20\t\2\u00f2\u00f3"+
		"\7\b\2\2\u00f3\u00f4\5\26\f\16\u00f4\u010c\3\2\2\2\u00f5\u00f6\7\31\2"+
		"\2\u00f6\u00f7\5\26\f\r\u00f7\u00f8\b\f\1\2\u00f8\u010c\3\2\2\2\u00f9"+
		"\u00fa\7\32\2\2\u00fa\u00fb\5\26\f\f\u00fb\u00fc\b\f\1\2\u00fc\u010c\3"+
		"\2\2\2\u00fd\u00fe\7\'\2\2\u00fe\u00ff\7\7\2\2\u00ff\u0100\5\30\r\2\u0100"+
		"\u0101\7\b\2\2\u0101\u0102\b\f\1\2\u0102\u010c\3\2\2\2\u0103\u0104\7\'"+
		"\2\2\u0104\u010c\b\f\1\2\u0105\u0106\7(\2\2\u0106\u010c\b\f\1\2\u0107"+
		"\u0108\7)\2\2\u0108\u010c\b\f\1\2\u0109\u010a\7*\2\2\u010a\u010c\b\f\1"+
		"\2\u010b\u00ea\3\2\2\2\u010b\u00f0\3\2\2\2\u010b\u00f5\3\2\2\2\u010b\u00f9"+
		"\3\2\2\2\u010b\u00fd\3\2\2\2\u010b\u0103\3\2\2\2\u010b\u0105\3\2\2\2\u010b"+
		"\u0107\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u012d\3\2\2\2\u010d\u010e\f\13"+
		"\2\2\u010e\u010f\t\2\2\2\u010f\u0110\5\26\f\f\u0110\u0111\b\f\1\2\u0111"+
		"\u012c\3\2\2\2\u0112\u0113\f\n\2\2\u0113\u0114\t\3\2\2\u0114\u0115\5\26"+
		"\f\13\u0115\u0116\b\f\1\2\u0116\u012c\3\2\2\2\u0117\u0118\f\t\2\2\u0118"+
		"\u0119\t\4\2\2\u0119\u011a\5\26\f\n\u011a\u011b\b\f\1\2\u011b\u012c\3"+
		"\2\2\2\u011c\u011d\f\b\2\2\u011d\u011e\t\5\2\2\u011e\u011f\5\26\f\t\u011f"+
		"\u0120\b\f\1\2\u0120\u012c\3\2\2\2\u0121\u0122\f\20\2\2\u0122\u0123\7"+
		"\13\2\2\u0123\u0124\5\26\f\2\u0124\u0125\7\f\2\2\u0125\u0126\b\f\1\2\u0126"+
		"\u012c\3\2\2\2\u0127\u0128\f\17\2\2\u0128\u0129\7\30\2\2\u0129\u012a\7"+
		"\'\2\2\u012a\u012c\b\f\1\2\u012b\u010d\3\2\2\2\u012b\u0112\3\2\2\2\u012b"+
		"\u0117\3\2\2\2\u012b\u011c\3\2\2\2\u012b\u0121\3\2\2\2\u012b\u0127\3\2"+
		"\2\2\u012c\u012f\3\2\2\2\u012d\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\27\3\2\2\2\u012f\u012d\3\2\2\2\u0130\u0131\5\26\f\2\u0131\u0138\b\r\1"+
		"\2\u0132\u0133\7\t\2\2\u0133\u0134\5\26\f\2\u0134\u0135\b\r\1\2\u0135"+
		"\u0137\3\2\2\2\u0136\u0132\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2"+
		"\2\2\u0138\u0139\3\2\2\2\u0139\u013c\3\2\2\2\u013a\u0138\3\2\2\2\u013b"+
		"\u0130\3\2\2\2\u013b\u013c\3\2\2\2\u013c\31\3\2\2\2\32\35)/\64>DO_iq\177"+
		"\u0082\u008b\u0093\u00a4\u00b2\u00d9\u00e4\u00e8\u010b\u012b\u012d\u0138"+
		"\u013b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}