// Generated from C:/Users/UO258220/IdeaProjects/DLP_cmm/src/parser\Cmm.g4 by ANTLR 4.9.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ID=1, INT_CONSTANT=2, CHAR_CONSTANT=3, REAL_CONSTANT=4, COMMENT=5, EOL=6, 
		WS=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"ID", "INT_CONSTANT", "CHAR_CONSTANT", "REAL_CONSTANT", "EXPONENT", "LETTER", 
			"COMMENT", "EOL", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
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


	public CmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Cmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\t\u0086\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2"+
		"\3\2\5\2\30\n\2\3\2\3\2\3\2\7\2\35\n\2\f\2\16\2 \13\2\3\3\3\3\7\3$\n\3"+
		"\f\3\16\3\'\13\3\3\3\5\3*\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\64\n"+
		"\4\3\4\3\4\3\5\5\59\n\5\3\5\3\5\6\5=\n\5\r\5\16\5>\3\5\5\5B\n\5\3\5\3"+
		"\5\3\5\7\5G\n\5\f\5\16\5J\13\5\3\5\5\5M\n\5\3\5\3\5\5\5Q\n\5\5\5S\n\5"+
		"\3\6\3\6\5\6W\n\6\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\7\ba\n\b\f\b\16\bd\13"+
		"\b\3\b\3\b\5\bh\n\b\3\b\3\b\3\b\3\b\7\bn\n\b\f\b\16\bq\13\b\3\b\3\b\5"+
		"\bu\n\b\3\b\3\b\3\t\5\tz\n\t\3\t\3\t\3\t\3\t\3\n\6\n\u0081\n\n\r\n\16"+
		"\n\u0082\3\n\3\n\4bo\2\13\3\3\5\4\7\5\t\6\13\2\r\2\17\7\21\b\23\t\3\2"+
		"\b\3\2\62;\3\2\63;\4\2GGgg\4\2--//\4\2C\\c|\5\2\13\f\17\17\"\"\2\u009b"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\3\27\3\2\2\2\5)\3\2\2\2\7+\3\2\2\2\tR\3\2\2\2\13T\3"+
		"\2\2\2\rZ\3\2\2\2\17t\3\2\2\2\21y\3\2\2\2\23\u0080\3\2\2\2\25\30\7a\2"+
		"\2\26\30\5\r\7\2\27\25\3\2\2\2\27\26\3\2\2\2\30\36\3\2\2\2\31\35\7a\2"+
		"\2\32\35\5\r\7\2\33\35\t\2\2\2\34\31\3\2\2\2\34\32\3\2\2\2\34\33\3\2\2"+
		"\2\35 \3\2\2\2\36\34\3\2\2\2\36\37\3\2\2\2\37\4\3\2\2\2 \36\3\2\2\2!%"+
		"\t\3\2\2\"$\t\2\2\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&*\3\2\2"+
		"\2\'%\3\2\2\2(*\7\62\2\2)!\3\2\2\2)(\3\2\2\2*\6\3\2\2\2+\63\7)\2\2,\64"+
		"\13\2\2\2-.\7^\2\2.\64\5\5\3\2/\60\7^\2\2\60\64\7p\2\2\61\62\7^\2\2\62"+
		"\64\7v\2\2\63,\3\2\2\2\63-\3\2\2\2\63/\3\2\2\2\63\61\3\2\2\2\64\65\3\2"+
		"\2\2\65\66\7)\2\2\66\b\3\2\2\2\679\5\5\3\28\67\3\2\2\289\3\2\2\29:\3\2"+
		"\2\2:<\7\60\2\2;=\t\2\2\2<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3"+
		"\2\2\2@B\5\13\6\2A@\3\2\2\2AB\3\2\2\2BS\3\2\2\2CD\5\5\3\2DH\7\60\2\2E"+
		"G\t\2\2\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IL\3\2\2\2JH\3\2\2\2"+
		"KM\5\13\6\2LK\3\2\2\2LM\3\2\2\2MS\3\2\2\2NP\5\5\3\2OQ\5\13\6\2PO\3\2\2"+
		"\2PQ\3\2\2\2QS\3\2\2\2R8\3\2\2\2RC\3\2\2\2RN\3\2\2\2S\n\3\2\2\2TV\t\4"+
		"\2\2UW\t\5\2\2VU\3\2\2\2VW\3\2\2\2WX\3\2\2\2XY\5\5\3\2Y\f\3\2\2\2Z[\t"+
		"\6\2\2[\16\3\2\2\2\\]\7\61\2\2]^\7\61\2\2^b\3\2\2\2_a\13\2\2\2`_\3\2\2"+
		"\2ad\3\2\2\2bc\3\2\2\2b`\3\2\2\2cg\3\2\2\2db\3\2\2\2eh\5\21\t\2fh\7\2"+
		"\2\3ge\3\2\2\2gf\3\2\2\2hu\3\2\2\2ij\7\61\2\2jk\7,\2\2ko\3\2\2\2ln\13"+
		"\2\2\2ml\3\2\2\2nq\3\2\2\2op\3\2\2\2om\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7"+
		",\2\2su\7\61\2\2t\\\3\2\2\2ti\3\2\2\2uv\3\2\2\2vw\b\b\2\2w\20\3\2\2\2"+
		"xz\7\17\2\2yx\3\2\2\2yz\3\2\2\2z{\3\2\2\2{|\7\f\2\2|}\3\2\2\2}~\b\t\2"+
		"\2~\22\3\2\2\2\177\u0081\t\7\2\2\u0080\177\3\2\2\2\u0081\u0082\3\2\2\2"+
		"\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085"+
		"\b\n\2\2\u0085\24\3\2\2\2\27\2\27\34\36%)\638>AHLPRVbgoty\u0082\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}