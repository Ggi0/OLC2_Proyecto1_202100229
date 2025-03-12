// Generated from /Users/gio/Desktop/compi2_1s25/LAB_compi2/proyecto1/OLC2_Proyecto1_202100229/goLight/Gramatica/LanguageParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LBRACE=3, RBRACE=4, LBRACKET=5, RBRACKET=6, SEMICOLON=7, 
		DOT=8, COLON=9, COMMA=10, MAS=11, MENOS=12, MULTI=13, POTENCIA=14, DIV=15, 
		MODULO=16, ASIGSUM=17, ASIGMIN=18, IGUAL=19, EQUALS=20, DIFF=21, MENOR=22, 
		MENIGUAL=23, MAYOR=24, MAYIGUAL=25, OR=26, AND=27, NOT=28, PRINT=29, FMT=30, 
		VAR=31, DCLIMPL=32, IF=33, ELSE=34, SWITCH=35, CASE=36, DEFAUL=37, FOR=38, 
		INT=39, FLOAT=40, STRING=41, BOOL=42, RUNE=43, T_INT=44, T_FLOAT=45, T_STR=46, 
		T_BOOL=47, T_RUNE=48, ID=49, WS=50, COMENT=51, MCOMENT=52;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_statement = 3, RULE_expr = 4, 
		RULE_tiposD = 5;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "statement", "expr", "tiposD"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "'.'", "':'", 
			"','", "'+'", "'-'", "'*'", "'^'", "'/'", "'%'", "'+='", "'-='", "'='", 
			"'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'||'", "'&&'", "'!'", 
			"'Println'", "'fmt'", "'var'", "':='", "'if'", "'else'", "'switch'", 
			"'case'", "'default'", "'for'", null, null, null, null, null, "'int'", 
			"'float64'", "'string'", "'bool'", "'rune'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACKET", "RBRACKET", 
			"SEMICOLON", "DOT", "COLON", "COMMA", "MAS", "MENOS", "MULTI", "POTENCIA", 
			"DIV", "MODULO", "ASIGSUM", "ASIGMIN", "IGUAL", "EQUALS", "DIFF", "MENOR", 
			"MENIGUAL", "MAYOR", "MAYIGUAL", "OR", "AND", "NOT", "PRINT", "FMT", 
			"VAR", "DCLIMPL", "IF", "ELSE", "SWITCH", "CASE", "DEFAUL", "FOR", "INT", 
			"FLOAT", "STRING", "BOOL", "RUNE", "T_INT", "T_FLOAT", "T_STR", "T_BOOL", 
			"T_RUNE", "ID", "WS", "COMENT", "MCOMENT"
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
	public String getGrammarFileName() { return "LanguageParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 580313700896778L) != 0)) {
				{
				{
				setState(12);
				dcl();
				}
				}
				setState(17);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DclContext extends ParserRuleContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcl);
		try {
			setState(20);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(18);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(19);
				statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarDclContext extends ParserRuleContext {
		public VarDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDcl; }
	 
		public VarDclContext() { }
		public void copyFrom(VarDclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDcl2Context extends VarDclContext {
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TiposDContext tiposD() {
			return getRuleContext(TiposDContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(LanguageParser.SEMICOLON, 0); }
		public VarDcl2Context(VarDclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDcl3Context extends VarDclContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode DCLIMPL() { return getToken(LanguageParser.DCLIMPL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(LanguageParser.SEMICOLON, 0); }
		public VarDcl3Context(VarDclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDcl1Context extends VarDclContext {
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TiposDContext tiposD() {
			return getRuleContext(TiposDContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(LanguageParser.IGUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(LanguageParser.SEMICOLON, 0); }
		public VarDcl1Context(VarDclContext ctx) { copyFrom(ctx); }
	}

	public final VarDclContext varDcl() throws RecognitionException {
		VarDclContext _localctx = new VarDclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDcl);
		try {
			setState(39);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new VarDcl1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(22);
				match(VAR);
				setState(23);
				match(ID);
				setState(24);
				tiposD();
				setState(25);
				match(IGUAL);
				setState(26);
				expr(0);
				setState(27);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new VarDcl2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				match(VAR);
				setState(30);
				match(ID);
				setState(31);
				tiposD();
				setState(32);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new VarDcl3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				match(ID);
				setState(35);
				match(DCLIMPL);
				setState(36);
				expr(0);
				setState(37);
				match(SEMICOLON);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends StatementContext {
		public TerminalNode IF() { return getToken(LanguageParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public TerminalNode ELSE() { return getToken(LanguageParser.ELSE, 0); }
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStmtContext extends StatementContext {
		public TerminalNode SWITCH() { return getToken(LanguageParser.SWITCH, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(LanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LanguageParser.RBRACE, 0); }
		public List<TerminalNode> CASE() { return getTokens(LanguageParser.CASE); }
		public TerminalNode CASE(int i) {
			return getToken(LanguageParser.CASE, i);
		}
		public List<TerminalNode> COLON() { return getTokens(LanguageParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(LanguageParser.COLON, i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode DEFAUL() { return getToken(LanguageParser.DEFAUL, 0); }
		public SwitchStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStmtContext extends StatementContext {
		public TerminalNode FMT() { return getToken(LanguageParser.FMT, 0); }
		public TerminalNode DOT() { return getToken(LanguageParser.DOT, 0); }
		public TerminalNode PRINT() { return getToken(LanguageParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(LanguageParser.SEMICOLON, 0); }
		public PrintStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(LanguageParser.SEMICOLON, 0); }
		public ExprStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends StatementContext {
		public TerminalNode FOR() { return getToken(LanguageParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BloqueContext extends StatementContext {
		public TerminalNode LBRACE() { return getToken(LanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LanguageParser.RBRACE, 0); }
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public BloqueContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(100);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case MENOS:
			case NOT:
			case INT:
			case FLOAT:
			case STRING:
			case BOOL:
			case RUNE:
			case ID:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				expr(0);
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(42);
					match(SEMICOLON);
					}
				}

				}
				break;
			case FMT:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(FMT);
				setState(46);
				match(DOT);
				setState(47);
				match(PRINT);
				setState(48);
				match(LPAREN);
				setState(49);
				expr(0);
				setState(50);
				match(RPAREN);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(51);
					match(SEMICOLON);
					}
				}

				}
				break;
			case LBRACE:
				_localctx = new BloqueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				match(LBRACE);
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 580313700896778L) != 0)) {
					{
					{
					setState(55);
					dcl();
					}
					}
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(61);
				match(RBRACE);
				}
				break;
			case IF:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				match(IF);
				setState(64);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(63);
					match(LPAREN);
					}
					break;
				}
				setState(66);
				expr(0);
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(67);
					match(RPAREN);
					}
				}

				setState(70);
				statement();
				setState(73);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(71);
					match(ELSE);
					setState(72);
					statement();
					}
					break;
				}
				}
				break;
			case SWITCH:
				_localctx = new SwitchStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(75);
				match(SWITCH);
				setState(76);
				expr(0);
				setState(77);
				match(LBRACE);
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(78);
					match(CASE);
					setState(79);
					expr(0);
					setState(80);
					match(COLON);
					setState(81);
					statement();
					}
					}
					setState(85); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CASE );
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DEFAUL) {
					{
					setState(87);
					match(DEFAUL);
					setState(88);
					match(COLON);
					setState(89);
					statement();
					}
				}

				setState(92);
				match(RBRACE);
				}
				break;
			case FOR:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(94);
				match(FOR);
				setState(95);
				match(LPAREN);
				setState(96);
				expr(0);
				setState(97);
				match(RPAREN);
				setState(98);
				statement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OR() { return getToken(LanguageParser.OR, 0); }
		public OrContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MULTI() { return getToken(LanguageParser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(LanguageParser.DIV, 0); }
		public TerminalNode MODULO() { return getToken(LanguageParser.MODULO, 0); }
		public MulDivContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MAS() { return getToken(LanguageParser.MAS, 0); }
		public TerminalNode MENOS() { return getToken(LanguageParser.MENOS, 0); }
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignVarContext extends ExprContext {
		public Token op;
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(LanguageParser.IGUAL, 0); }
		public TerminalNode ASIGSUM() { return getToken(LanguageParser.ASIGSUM, 0); }
		public TerminalNode ASIGMIN() { return getToken(LanguageParser.ASIGMIN, 0); }
		public AssignVarContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegateUContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode MENOS() { return getToken(LanguageParser.MENOS, 0); }
		public TerminalNode NOT() { return getToken(LanguageParser.NOT, 0); }
		public NegateUContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(LanguageParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(LanguageParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(LanguageParser.FLOAT, 0); }
		public FloatContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public IdentifierContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(LanguageParser.BOOL, 0); }
		public BoolContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelacionalesContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode MAYOR() { return getToken(LanguageParser.MAYOR, 0); }
		public TerminalNode MAYIGUAL() { return getToken(LanguageParser.MAYIGUAL, 0); }
		public TerminalNode MENOR() { return getToken(LanguageParser.MENOR, 0); }
		public TerminalNode MENIGUAL() { return getToken(LanguageParser.MENIGUAL, 0); }
		public RelacionalesContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode AND() { return getToken(LanguageParser.AND, 0); }
		public AndContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RuneContext extends ExprContext {
		public TerminalNode RUNE() { return getToken(LanguageParser.RUNE, 0); }
		public RuneContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparationContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(LanguageParser.EQUALS, 0); }
		public TerminalNode DIFF() { return getToken(LanguageParser.DIFF, 0); }
		public ComparationContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new NegateUContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(103);
				((NegateUContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==MENOS || _la==NOT) ) {
					((NegateUContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(104);
				expr(15);
				}
				break;
			case 2:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(105);
				match(INT);
				}
				break;
			case 3:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(106);
				match(FLOAT);
				}
				break;
			case 4:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107);
				match(STRING);
				}
				break;
			case 5:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(108);
				match(BOOL);
				}
				break;
			case 6:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(109);
				match(RUNE);
				}
				break;
			case 7:
				{
				_localctx = new AssignVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(110);
				match(ID);
				setState(111);
				((AssignVarContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 917504L) != 0)) ) {
					((AssignVarContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(112);
				expr(3);
				}
				break;
			case 8:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(113);
				match(ID);
				}
				break;
			case 9:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				match(LPAREN);
				setState(115);
				expr(0);
				setState(116);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(138);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(120);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(121);
						((MulDivContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 106496L) != 0)) ) {
							((MulDivContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(122);
						expr(15);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(123);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(124);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==MAS || _la==MENOS) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(125);
						expr(14);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(126);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(127);
						((RelacionalesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 62914560L) != 0)) ) {
							((RelacionalesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(128);
						expr(13);
						}
						break;
					case 4:
						{
						_localctx = new ComparationContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(129);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(130);
						((ComparationContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUALS || _la==DIFF) ) {
							((ComparationContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(131);
						expr(12);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(132);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(133);
						match(AND);
						setState(134);
						expr(11);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(135);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(136);
						match(OR);
						setState(137);
						expr(10);
						}
						break;
					}
					} 
				}
				setState(142);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TiposDContext extends ParserRuleContext {
		public TerminalNode T_INT() { return getToken(LanguageParser.T_INT, 0); }
		public TerminalNode T_FLOAT() { return getToken(LanguageParser.T_FLOAT, 0); }
		public TerminalNode T_STR() { return getToken(LanguageParser.T_STR, 0); }
		public TerminalNode T_BOOL() { return getToken(LanguageParser.T_BOOL, 0); }
		public TerminalNode T_RUNE() { return getToken(LanguageParser.T_RUNE, 0); }
		public TiposDContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tiposD; }
	}

	public final TiposDContext tiposD() throws RecognitionException {
		TiposDContext _localctx = new TiposDContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tiposD);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 545357767376896L) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00014\u0092\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0001\u0000\u0005\u0000\u000e\b\u0000\n\u0000\f\u0000"+
		"\u0011\t\u0000\u0001\u0001\u0001\u0001\u0003\u0001\u0015\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002(\b"+
		"\u0002\u0001\u0003\u0001\u0003\u0003\u0003,\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u00035\b\u0003\u0001\u0003\u0001\u0003\u0005\u00039\b\u0003\n\u0003\f"+
		"\u0003<\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003A\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003E\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003J\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004\u0003"+
		"T\b\u0003\u000b\u0003\f\u0003U\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003[\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003e\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004w\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004\u008b\b\u0004\n\u0004\f\u0004\u008e\t\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0000\u0001\b\u0006\u0000\u0002\u0004\u0006\b\n\u0000\u0007"+
		"\u0002\u0000\f\f\u001c\u001c\u0001\u0000\u0011\u0013\u0002\u0000\r\r\u000f"+
		"\u0010\u0001\u0000\u000b\f\u0001\u0000\u0016\u0019\u0001\u0000\u0014\u0015"+
		"\u0001\u0000,0\u00aa\u0000\u000f\u0001\u0000\u0000\u0000\u0002\u0014\u0001"+
		"\u0000\u0000\u0000\u0004\'\u0001\u0000\u0000\u0000\u0006d\u0001\u0000"+
		"\u0000\u0000\bv\u0001\u0000\u0000\u0000\n\u008f\u0001\u0000\u0000\u0000"+
		"\f\u000e\u0003\u0002\u0001\u0000\r\f\u0001\u0000\u0000\u0000\u000e\u0011"+
		"\u0001\u0000\u0000\u0000\u000f\r\u0001\u0000\u0000\u0000\u000f\u0010\u0001"+
		"\u0000\u0000\u0000\u0010\u0001\u0001\u0000\u0000\u0000\u0011\u000f\u0001"+
		"\u0000\u0000\u0000\u0012\u0015\u0003\u0004\u0002\u0000\u0013\u0015\u0003"+
		"\u0006\u0003\u0000\u0014\u0012\u0001\u0000\u0000\u0000\u0014\u0013\u0001"+
		"\u0000\u0000\u0000\u0015\u0003\u0001\u0000\u0000\u0000\u0016\u0017\u0005"+
		"\u001f\u0000\u0000\u0017\u0018\u00051\u0000\u0000\u0018\u0019\u0003\n"+
		"\u0005\u0000\u0019\u001a\u0005\u0013\u0000\u0000\u001a\u001b\u0003\b\u0004"+
		"\u0000\u001b\u001c\u0005\u0007\u0000\u0000\u001c(\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0005\u001f\u0000\u0000\u001e\u001f\u00051\u0000\u0000\u001f"+
		" \u0003\n\u0005\u0000 !\u0005\u0007\u0000\u0000!(\u0001\u0000\u0000\u0000"+
		"\"#\u00051\u0000\u0000#$\u0005 \u0000\u0000$%\u0003\b\u0004\u0000%&\u0005"+
		"\u0007\u0000\u0000&(\u0001\u0000\u0000\u0000\'\u0016\u0001\u0000\u0000"+
		"\u0000\'\u001d\u0001\u0000\u0000\u0000\'\"\u0001\u0000\u0000\u0000(\u0005"+
		"\u0001\u0000\u0000\u0000)+\u0003\b\u0004\u0000*,\u0005\u0007\u0000\u0000"+
		"+*\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,e\u0001\u0000\u0000"+
		"\u0000-.\u0005\u001e\u0000\u0000./\u0005\b\u0000\u0000/0\u0005\u001d\u0000"+
		"\u000001\u0005\u0001\u0000\u000012\u0003\b\u0004\u000024\u0005\u0002\u0000"+
		"\u000035\u0005\u0007\u0000\u000043\u0001\u0000\u0000\u000045\u0001\u0000"+
		"\u0000\u00005e\u0001\u0000\u0000\u00006:\u0005\u0003\u0000\u000079\u0003"+
		"\u0002\u0001\u000087\u0001\u0000\u0000\u00009<\u0001\u0000\u0000\u0000"+
		":8\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000"+
		"\u0000<:\u0001\u0000\u0000\u0000=e\u0005\u0004\u0000\u0000>@\u0005!\u0000"+
		"\u0000?A\u0005\u0001\u0000\u0000@?\u0001\u0000\u0000\u0000@A\u0001\u0000"+
		"\u0000\u0000AB\u0001\u0000\u0000\u0000BD\u0003\b\u0004\u0000CE\u0005\u0002"+
		"\u0000\u0000DC\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EF\u0001"+
		"\u0000\u0000\u0000FI\u0003\u0006\u0003\u0000GH\u0005\"\u0000\u0000HJ\u0003"+
		"\u0006\u0003\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"Je\u0001\u0000\u0000\u0000KL\u0005#\u0000\u0000LM\u0003\b\u0004\u0000"+
		"MS\u0005\u0003\u0000\u0000NO\u0005$\u0000\u0000OP\u0003\b\u0004\u0000"+
		"PQ\u0005\t\u0000\u0000QR\u0003\u0006\u0003\u0000RT\u0001\u0000\u0000\u0000"+
		"SN\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000US\u0001\u0000\u0000"+
		"\u0000UV\u0001\u0000\u0000\u0000VZ\u0001\u0000\u0000\u0000WX\u0005%\u0000"+
		"\u0000XY\u0005\t\u0000\u0000Y[\u0003\u0006\u0003\u0000ZW\u0001\u0000\u0000"+
		"\u0000Z[\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0005\u0004"+
		"\u0000\u0000]e\u0001\u0000\u0000\u0000^_\u0005&\u0000\u0000_`\u0005\u0001"+
		"\u0000\u0000`a\u0003\b\u0004\u0000ab\u0005\u0002\u0000\u0000bc\u0003\u0006"+
		"\u0003\u0000ce\u0001\u0000\u0000\u0000d)\u0001\u0000\u0000\u0000d-\u0001"+
		"\u0000\u0000\u0000d6\u0001\u0000\u0000\u0000d>\u0001\u0000\u0000\u0000"+
		"dK\u0001\u0000\u0000\u0000d^\u0001\u0000\u0000\u0000e\u0007\u0001\u0000"+
		"\u0000\u0000fg\u0006\u0004\uffff\uffff\u0000gh\u0007\u0000\u0000\u0000"+
		"hw\u0003\b\u0004\u000fiw\u0005\'\u0000\u0000jw\u0005(\u0000\u0000kw\u0005"+
		")\u0000\u0000lw\u0005*\u0000\u0000mw\u0005+\u0000\u0000no\u00051\u0000"+
		"\u0000op\u0007\u0001\u0000\u0000pw\u0003\b\u0004\u0003qw\u00051\u0000"+
		"\u0000rs\u0005\u0001\u0000\u0000st\u0003\b\u0004\u0000tu\u0005\u0002\u0000"+
		"\u0000uw\u0001\u0000\u0000\u0000vf\u0001\u0000\u0000\u0000vi\u0001\u0000"+
		"\u0000\u0000vj\u0001\u0000\u0000\u0000vk\u0001\u0000\u0000\u0000vl\u0001"+
		"\u0000\u0000\u0000vm\u0001\u0000\u0000\u0000vn\u0001\u0000\u0000\u0000"+
		"vq\u0001\u0000\u0000\u0000vr\u0001\u0000\u0000\u0000w\u008c\u0001\u0000"+
		"\u0000\u0000xy\n\u000e\u0000\u0000yz\u0007\u0002\u0000\u0000z\u008b\u0003"+
		"\b\u0004\u000f{|\n\r\u0000\u0000|}\u0007\u0003\u0000\u0000}\u008b\u0003"+
		"\b\u0004\u000e~\u007f\n\f\u0000\u0000\u007f\u0080\u0007\u0004\u0000\u0000"+
		"\u0080\u008b\u0003\b\u0004\r\u0081\u0082\n\u000b\u0000\u0000\u0082\u0083"+
		"\u0007\u0005\u0000\u0000\u0083\u008b\u0003\b\u0004\f\u0084\u0085\n\n\u0000"+
		"\u0000\u0085\u0086\u0005\u001b\u0000\u0000\u0086\u008b\u0003\b\u0004\u000b"+
		"\u0087\u0088\n\t\u0000\u0000\u0088\u0089\u0005\u001a\u0000\u0000\u0089"+
		"\u008b\u0003\b\u0004\n\u008ax\u0001\u0000\u0000\u0000\u008a{\u0001\u0000"+
		"\u0000\u0000\u008a~\u0001\u0000\u0000\u0000\u008a\u0081\u0001\u0000\u0000"+
		"\u0000\u008a\u0084\u0001\u0000\u0000\u0000\u008a\u0087\u0001\u0000\u0000"+
		"\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\t\u0001\u0000\u0000\u0000"+
		"\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0090\u0007\u0006\u0000\u0000"+
		"\u0090\u000b\u0001\u0000\u0000\u0000\u000f\u000f\u0014\'+4:@DIUZdv\u008a"+
		"\u008c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}