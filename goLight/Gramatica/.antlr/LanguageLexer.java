// Generated from /Users/gio/Desktop/compi2_1s25/LAB_compi2/proyecto1/OLC2_Proyecto1_202100229/goLight/Gramatica/LanguageLexer.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		VAR=1, PRINT=2, LPAREN=3, RPAREN=4, SEMICOLON=5, ASSIGN=6, PLUS=7, MINUS=8, 
		MULTI=9, DIV=10, ID=11, INT=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"VAR", "PRINT", "LPAREN", "RPAREN", "SEMICOLON", "ASSIGN", "PLUS", "MINUS", 
			"MULTI", "DIV", "ID", "INT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'print'", "'('", "')'", "';'", "'='", "'+'", "'-'", "'*'", 
			"'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "VAR", "PRINT", "LPAREN", "RPAREN", "SEMICOLON", "ASSIGN", "PLUS", 
			"MINUS", "MULTI", "DIV", "ID", "INT", "WS"
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


	public LanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LanguageLexer.g4"; }

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
		"\u0004\u0000\rF\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0004\n7\b\n\u000b\n\f"+
		"\n8\u0001\u000b\u0004\u000b<\b\u000b\u000b\u000b\f\u000b=\u0001\f\u0004"+
		"\fA\b\f\u000b\f\f\fB\u0001\f\u0001\f\u0000\u0000\r\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u0001\u0000\u0003\u0002\u0000AZaz\u0001"+
		"\u000009\u0003\u0000\t\n\r\r  H\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001"+
		"\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001"+
		"\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0001\u001b\u0001"+
		"\u0000\u0000\u0000\u0003\u001f\u0001\u0000\u0000\u0000\u0005%\u0001\u0000"+
		"\u0000\u0000\u0007\'\u0001\u0000\u0000\u0000\t)\u0001\u0000\u0000\u0000"+
		"\u000b+\u0001\u0000\u0000\u0000\r-\u0001\u0000\u0000\u0000\u000f/\u0001"+
		"\u0000\u0000\u0000\u00111\u0001\u0000\u0000\u0000\u00133\u0001\u0000\u0000"+
		"\u0000\u00156\u0001\u0000\u0000\u0000\u0017;\u0001\u0000\u0000\u0000\u0019"+
		"@\u0001\u0000\u0000\u0000\u001b\u001c\u0005v\u0000\u0000\u001c\u001d\u0005"+
		"a\u0000\u0000\u001d\u001e\u0005r\u0000\u0000\u001e\u0002\u0001\u0000\u0000"+
		"\u0000\u001f \u0005p\u0000\u0000 !\u0005r\u0000\u0000!\"\u0005i\u0000"+
		"\u0000\"#\u0005n\u0000\u0000#$\u0005t\u0000\u0000$\u0004\u0001\u0000\u0000"+
		"\u0000%&\u0005(\u0000\u0000&\u0006\u0001\u0000\u0000\u0000\'(\u0005)\u0000"+
		"\u0000(\b\u0001\u0000\u0000\u0000)*\u0005;\u0000\u0000*\n\u0001\u0000"+
		"\u0000\u0000+,\u0005=\u0000\u0000,\f\u0001\u0000\u0000\u0000-.\u0005+"+
		"\u0000\u0000.\u000e\u0001\u0000\u0000\u0000/0\u0005-\u0000\u00000\u0010"+
		"\u0001\u0000\u0000\u000012\u0005*\u0000\u00002\u0012\u0001\u0000\u0000"+
		"\u000034\u0005/\u0000\u00004\u0014\u0001\u0000\u0000\u000057\u0007\u0000"+
		"\u0000\u000065\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u000086\u0001"+
		"\u0000\u0000\u000089\u0001\u0000\u0000\u00009\u0016\u0001\u0000\u0000"+
		"\u0000:<\u0007\u0001\u0000\u0000;:\u0001\u0000\u0000\u0000<=\u0001\u0000"+
		"\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>\u0018"+
		"\u0001\u0000\u0000\u0000?A\u0007\u0002\u0000\u0000@?\u0001\u0000\u0000"+
		"\u0000AB\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000"+
		"\u0000\u0000CD\u0001\u0000\u0000\u0000DE\u0006\f\u0000\u0000E\u001a\u0001"+
		"\u0000\u0000\u0000\u0004\u00008=B\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}