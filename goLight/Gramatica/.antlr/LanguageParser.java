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
		MODULO=16, ASIGSUM=17, ASIGMIN=18, INCREMENTO=19, DECREMENTO=20, IGUAL=21, 
		EQUALS=22, DIFF=23, MENOR=24, MENIGUAL=25, MAYOR=26, MAYIGUAL=27, OR=28, 
		AND=29, NOT=30, PRINT=31, FMT=32, VAR=33, DCLIMPL=34, IF=35, ELSE=36, 
		SWITCH=37, CASE=38, DEFAUL=39, FOR=40, STBREAK=41, STCONTINUE=42, STRETURN=43, 
		INT=44, FLOAT=45, STRING=46, BOOL=47, RUNE=48, T_INT=49, T_FLOAT=50, T_STR=51, 
		T_BOOL=52, T_RUNE=53, ID=54, WS=55, COMENT=56, MCOMENT=57;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_statement = 3, RULE_forInit = 4, 
		RULE_caseStmt = 5, RULE_expr = 6, RULE_call = 7, RULE_parametros = 8, 
		RULE_tiposD = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "statement", "forInit", "caseStmt", "expr", 
			"call", "parametros", "tiposD"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "'.'", "':'", 
			"','", "'+'", "'-'", "'*'", "'^'", "'/'", "'%'", "'+='", "'-='", "'++'", 
			"'--'", "'='", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'||'", 
			"'&&'", "'!'", "'Println'", "'fmt'", "'var'", "':='", "'if'", "'else'", 
			"'switch'", "'case'", "'default'", "'for'", "'break'", "'continue'", 
			"'return'", null, null, null, null, null, "'int'", "'float64'", "'string'", 
			"'bool'", "'rune'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACKET", "RBRACKET", 
			"SEMICOLON", "DOT", "COLON", "COMMA", "MAS", "MENOS", "MULTI", "POTENCIA", 
			"DIV", "MODULO", "ASIGSUM", "ASIGMIN", "INCREMENTO", "DECREMENTO", "IGUAL", 
			"EQUALS", "DIFF", "MENOR", "MENIGUAL", "MAYOR", "MAYIGUAL", "OR", "AND", 
			"NOT", "PRINT", "FMT", "VAR", "DCLIMPL", "IF", "ELSE", "SWITCH", "CASE", 
			"DEFAUL", "FOR", "STBREAK", "STCONTINUE", "STRETURN", "INT", "FLOAT", 
			"STRING", "BOOL", "RUNE", "T_INT", "T_FLOAT", "T_STR", "T_BOOL", "T_RUNE", 
			"ID", "WS", "COMENT", "MCOMENT"
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
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18576434708615178L) != 0)) {
				{
				{
				setState(20);
				dcl();
				}
				}
				setState(25);
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
			setState(28);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
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
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new VarDcl1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(30);
				match(VAR);
				setState(31);
				match(ID);
				setState(32);
				tiposD();
				setState(33);
				match(IGUAL);
				setState(34);
				expr(0);
				setState(35);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new VarDcl2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(37);
				match(VAR);
				setState(38);
				match(ID);
				setState(39);
				tiposD();
				setState(40);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new VarDcl3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				match(ID);
				setState(43);
				match(DCLIMPL);
				setState(44);
				expr(0);
				setState(45);
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
	public static class ST_continueContext extends StatementContext {
		public TerminalNode STCONTINUE() { return getToken(LanguageParser.STCONTINUE, 0); }
		public TerminalNode SEMICOLON() { return getToken(LanguageParser.SEMICOLON, 0); }
		public ST_continueContext(StatementContext ctx) { copyFrom(ctx); }
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(LanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LanguageParser.RBRACE, 0); }
		public List<CaseStmtContext> caseStmt() {
			return getRuleContexts(CaseStmtContext.class);
		}
		public CaseStmtContext caseStmt(int i) {
			return getRuleContext(CaseStmtContext.class,i);
		}
		public SwitchStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ST_breakContext extends StatementContext {
		public TerminalNode STBREAK() { return getToken(LanguageParser.STBREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(LanguageParser.SEMICOLON, 0); }
		public ST_breakContext(StatementContext ctx) { copyFrom(ctx); }
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
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
	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends StatementContext {
		public TerminalNode FOR() { return getToken(LanguageParser.FOR, 0); }
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(LanguageParser.SEMICOLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public ForStmtContext(StatementContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ST_returnContext extends StatementContext {
		public TerminalNode STRETURN() { return getToken(LanguageParser.STRETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(LanguageParser.SEMICOLON, 0); }
		public ST_returnContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(131);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				expr(0);
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(50);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 2:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(53);
				match(FMT);
				setState(54);
				match(DOT);
				setState(55);
				match(PRINT);
				setState(56);
				match(LPAREN);
				setState(57);
				expr(0);
				setState(58);
				match(RPAREN);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(59);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 3:
				_localctx = new BloqueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				match(LBRACE);
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18576434708615178L) != 0)) {
					{
					{
					setState(63);
					dcl();
					}
					}
					setState(68);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(69);
				match(RBRACE);
				}
				break;
			case 4:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				match(IF);
				setState(72);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(71);
					match(LPAREN);
					}
					break;
				}
				setState(74);
				expr(0);
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(75);
					match(RPAREN);
					}
				}

				setState(78);
				statement();
				setState(81);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(79);
					match(ELSE);
					setState(80);
					statement();
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new SwitchStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				match(SWITCH);
				setState(84);
				expr(0);
				setState(85);
				match(LBRACE);
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(86);
					caseStmt();
					}
					}
					setState(89); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CASE || _la==DEFAUL );
				setState(91);
				match(RBRACE);
				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(93);
				match(FOR);
				setState(95);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(94);
					match(LPAREN);
					}
					break;
				}
				setState(97);
				expr(0);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(98);
					match(RPAREN);
					}
				}

				setState(101);
				statement();
				}
				break;
			case 7:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(103);
				match(FOR);
				setState(105);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(104);
					match(LPAREN);
					}
					break;
				}
				setState(107);
				forInit();
				setState(108);
				expr(0);
				setState(109);
				match(SEMICOLON);
				setState(110);
				expr(0);
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(111);
					match(RPAREN);
					}
				}

				setState(114);
				statement();
				}
				break;
			case 8:
				_localctx = new ST_breakContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(116);
				match(STBREAK);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(117);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 9:
				_localctx = new ST_continueContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(120);
				match(STCONTINUE);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(121);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 10:
				_localctx = new ST_returnContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(124);
				match(STRETURN);
				setState(126);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(125);
					expr(0);
					}
					break;
				}
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(128);
					match(SEMICOLON);
					}
				}

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
	public static class ForInitContext extends ParserRuleContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(LanguageParser.SEMICOLON, 0); }
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_forInit);
		try {
			setState(137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				expr(0);
				setState(135);
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
	public static class CaseStmtContext extends ParserRuleContext {
		public CaseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseStmt; }
	 
		public CaseStmtContext() { }
		public void copyFrom(CaseStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaseDefaultContext extends CaseStmtContext {
		public TerminalNode DEFAUL() { return getToken(LanguageParser.DEFAUL, 0); }
		public TerminalNode COLON() { return getToken(LanguageParser.COLON, 0); }
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public CaseDefaultContext(CaseStmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaseNormalContext extends CaseStmtContext {
		public TerminalNode CASE() { return getToken(LanguageParser.CASE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(LanguageParser.COLON, 0); }
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public CaseNormalContext(CaseStmtContext ctx) { copyFrom(ctx); }
	}

	public final CaseStmtContext caseStmt() throws RecognitionException {
		CaseStmtContext _localctx = new CaseStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_caseStmt);
		int _la;
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				_localctx = new CaseNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(CASE);
				setState(140);
				expr(0);
				setState(141);
				match(COLON);
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18576434708615178L) != 0)) {
					{
					{
					setState(142);
					dcl();
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DEFAUL:
				_localctx = new CaseDefaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(DEFAUL);
				setState(149);
				match(COLON);
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18576434708615178L) != 0)) {
					{
					{
					setState(150);
					dcl();
					}
					}
					setState(155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
	public static class LlamadaContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<CallContext> call() {
			return getRuleContexts(CallContext.class);
		}
		public CallContext call(int i) {
			return getRuleContext(CallContext.class,i);
		}
		public LlamadaContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RuneContext extends ExprContext {
		public TerminalNode RUNE() { return getToken(LanguageParser.RUNE, 0); }
		public RuneContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UpdateVarContext extends ExprContext {
		public Token op;
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode INCREMENTO() { return getToken(LanguageParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(LanguageParser.DECREMENTO, 0); }
		public UpdateVarContext(ExprContext ctx) { copyFrom(ctx); }
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
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new NegateUContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(159);
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
				setState(160);
				expr(17);
				}
				break;
			case 2:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				match(INT);
				}
				break;
			case 3:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(FLOAT);
				}
				break;
			case 4:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(STRING);
				}
				break;
			case 5:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				match(BOOL);
				}
				break;
			case 6:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165);
				match(RUNE);
				}
				break;
			case 7:
				{
				_localctx = new AssignVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				match(ID);
				setState(167);
				((AssignVarContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2490368L) != 0)) ) {
					((AssignVarContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(168);
				expr(4);
				}
				break;
			case 8:
				{
				_localctx = new UpdateVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(ID);
				setState(170);
				((UpdateVarContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==INCREMENTO || _la==DECREMENTO) ) {
					((UpdateVarContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 9:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				match(ID);
				}
				break;
			case 10:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				match(LPAREN);
				setState(173);
				expr(0);
				setState(174);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(202);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(179);
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
						setState(180);
						expr(16);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(181);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(182);
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
						setState(183);
						expr(15);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(184);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(185);
						((RelacionalesContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 251658240L) != 0)) ) {
							((RelacionalesContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(186);
						expr(14);
						}
						break;
					case 4:
						{
						_localctx = new ComparationContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(187);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(188);
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
						setState(189);
						expr(13);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(190);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(191);
						match(AND);
						setState(192);
						expr(12);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(194);
						match(OR);
						setState(195);
						expr(11);
						}
						break;
					case 7:
						{
						_localctx = new LlamadaContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(198); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(197);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(200); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
	public static class CallContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(LPAREN);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18559757350604802L) != 0)) {
				{
				setState(208);
				parametros();
				}
			}

			setState(211);
			match(RPAREN);
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
	public static class ParametrosContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LanguageParser.COMMA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			expr(0);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(214);
				match(COMMA);
				setState(215);
				expr(0);
				}
				}
				setState(220);
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
		enterRule(_localctx, 18, RULE_tiposD);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 17451448556060672L) != 0)) ) {
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
		case 6:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 16);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00019\u00e0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0005\u0000\u0016\b\u0000\n\u0000"+
		"\f\u0000\u0019\t\u0000\u0001\u0001\u0001\u0001\u0003\u0001\u001d\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"0\b\u0002\u0001\u0003\u0001\u0003\u0003\u00034\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003=\b\u0003\u0001\u0003\u0001\u0003\u0005\u0003A\b\u0003\n\u0003\f"+
		"\u0003D\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003I\b\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003M\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003R\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0004\u0003X\b\u0003\u000b\u0003\f\u0003Y\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003`\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003d\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003j\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003q\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003w\b\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003{\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u007f\b\u0003\u0001"+
		"\u0003\u0003\u0003\u0082\b\u0003\u0003\u0003\u0084\b\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004\u008a\b\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0090\b\u0005\n\u0005"+
		"\f\u0005\u0093\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"\u0098\b\u0005\n\u0005\f\u0005\u009b\t\u0005\u0003\u0005\u009d\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006\u00b1\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006\u00c7\b\u0006"+
		"\u000b\u0006\f\u0006\u00c8\u0005\u0006\u00cb\b\u0006\n\u0006\f\u0006\u00ce"+
		"\t\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u00d2\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u00d9\b\b\n\b\f\b\u00dc\t"+
		"\b\u0001\t\u0001\t\u0001\t\u0000\u0001\f\n\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0000\b\u0002\u0000\f\f\u001e\u001e\u0002\u0000\u0011"+
		"\u0012\u0015\u0015\u0001\u0000\u0013\u0014\u0002\u0000\r\r\u000f\u0010"+
		"\u0001\u0000\u000b\f\u0001\u0000\u0018\u001b\u0001\u0000\u0016\u0017\u0001"+
		"\u000015\u0108\u0000\u0017\u0001\u0000\u0000\u0000\u0002\u001c\u0001\u0000"+
		"\u0000\u0000\u0004/\u0001\u0000\u0000\u0000\u0006\u0083\u0001\u0000\u0000"+
		"\u0000\b\u0089\u0001\u0000\u0000\u0000\n\u009c\u0001\u0000\u0000\u0000"+
		"\f\u00b0\u0001\u0000\u0000\u0000\u000e\u00cf\u0001\u0000\u0000\u0000\u0010"+
		"\u00d5\u0001\u0000\u0000\u0000\u0012\u00dd\u0001\u0000\u0000\u0000\u0014"+
		"\u0016\u0003\u0002\u0001\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0016"+
		"\u0019\u0001\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017"+
		"\u0018\u0001\u0000\u0000\u0000\u0018\u0001\u0001\u0000\u0000\u0000\u0019"+
		"\u0017\u0001\u0000\u0000\u0000\u001a\u001d\u0003\u0004\u0002\u0000\u001b"+
		"\u001d\u0003\u0006\u0003\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001c"+
		"\u001b\u0001\u0000\u0000\u0000\u001d\u0003\u0001\u0000\u0000\u0000\u001e"+
		"\u001f\u0005!\u0000\u0000\u001f \u00056\u0000\u0000 !\u0003\u0012\t\u0000"+
		"!\"\u0005\u0015\u0000\u0000\"#\u0003\f\u0006\u0000#$\u0005\u0007\u0000"+
		"\u0000$0\u0001\u0000\u0000\u0000%&\u0005!\u0000\u0000&\'\u00056\u0000"+
		"\u0000\'(\u0003\u0012\t\u0000()\u0005\u0007\u0000\u0000)0\u0001\u0000"+
		"\u0000\u0000*+\u00056\u0000\u0000+,\u0005\"\u0000\u0000,-\u0003\f\u0006"+
		"\u0000-.\u0005\u0007\u0000\u0000.0\u0001\u0000\u0000\u0000/\u001e\u0001"+
		"\u0000\u0000\u0000/%\u0001\u0000\u0000\u0000/*\u0001\u0000\u0000\u0000"+
		"0\u0005\u0001\u0000\u0000\u000013\u0003\f\u0006\u000024\u0005\u0007\u0000"+
		"\u000032\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u00004\u0084\u0001"+
		"\u0000\u0000\u000056\u0005 \u0000\u000067\u0005\b\u0000\u000078\u0005"+
		"\u001f\u0000\u000089\u0005\u0001\u0000\u00009:\u0003\f\u0006\u0000:<\u0005"+
		"\u0002\u0000\u0000;=\u0005\u0007\u0000\u0000<;\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=\u0084\u0001\u0000\u0000\u0000>B\u0005\u0003"+
		"\u0000\u0000?A\u0003\u0002\u0001\u0000@?\u0001\u0000\u0000\u0000AD\u0001"+
		"\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000"+
		"CE\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000E\u0084\u0005\u0004"+
		"\u0000\u0000FH\u0005#\u0000\u0000GI\u0005\u0001\u0000\u0000HG\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000JL\u0003"+
		"\f\u0006\u0000KM\u0005\u0002\u0000\u0000LK\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000NQ\u0003\u0006\u0003\u0000"+
		"OP\u0005$\u0000\u0000PR\u0003\u0006\u0003\u0000QO\u0001\u0000\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000R\u0084\u0001\u0000\u0000\u0000ST\u0005%\u0000"+
		"\u0000TU\u0003\f\u0006\u0000UW\u0005\u0003\u0000\u0000VX\u0003\n\u0005"+
		"\u0000WV\u0001\u0000\u0000\u0000XY\u0001\u0000\u0000\u0000YW\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0005"+
		"\u0004\u0000\u0000\\\u0084\u0001\u0000\u0000\u0000]_\u0005(\u0000\u0000"+
		"^`\u0005\u0001\u0000\u0000_^\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000"+
		"\u0000`a\u0001\u0000\u0000\u0000ac\u0003\f\u0006\u0000bd\u0005\u0002\u0000"+
		"\u0000cb\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000de\u0001\u0000"+
		"\u0000\u0000ef\u0003\u0006\u0003\u0000f\u0084\u0001\u0000\u0000\u0000"+
		"gi\u0005(\u0000\u0000hj\u0005\u0001\u0000\u0000ih\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000kl\u0003\b\u0004\u0000"+
		"lm\u0003\f\u0006\u0000mn\u0005\u0007\u0000\u0000np\u0003\f\u0006\u0000"+
		"oq\u0005\u0002\u0000\u0000po\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000"+
		"\u0000qr\u0001\u0000\u0000\u0000rs\u0003\u0006\u0003\u0000s\u0084\u0001"+
		"\u0000\u0000\u0000tv\u0005)\u0000\u0000uw\u0005\u0007\u0000\u0000vu\u0001"+
		"\u0000\u0000\u0000vw\u0001\u0000\u0000\u0000w\u0084\u0001\u0000\u0000"+
		"\u0000xz\u0005*\u0000\u0000y{\u0005\u0007\u0000\u0000zy\u0001\u0000\u0000"+
		"\u0000z{\u0001\u0000\u0000\u0000{\u0084\u0001\u0000\u0000\u0000|~\u0005"+
		"+\u0000\u0000}\u007f\u0003\f\u0006\u0000~}\u0001\u0000\u0000\u0000~\u007f"+
		"\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000\u0000\u0080\u0082"+
		"\u0005\u0007\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0001\u0000\u0000\u0000\u0082\u0084\u0001\u0000\u0000\u0000\u00831\u0001"+
		"\u0000\u0000\u0000\u00835\u0001\u0000\u0000\u0000\u0083>\u0001\u0000\u0000"+
		"\u0000\u0083F\u0001\u0000\u0000\u0000\u0083S\u0001\u0000\u0000\u0000\u0083"+
		"]\u0001\u0000\u0000\u0000\u0083g\u0001\u0000\u0000\u0000\u0083t\u0001"+
		"\u0000\u0000\u0000\u0083x\u0001\u0000\u0000\u0000\u0083|\u0001\u0000\u0000"+
		"\u0000\u0084\u0007\u0001\u0000\u0000\u0000\u0085\u008a\u0003\u0004\u0002"+
		"\u0000\u0086\u0087\u0003\f\u0006\u0000\u0087\u0088\u0005\u0007\u0000\u0000"+
		"\u0088\u008a\u0001\u0000\u0000\u0000\u0089\u0085\u0001\u0000\u0000\u0000"+
		"\u0089\u0086\u0001\u0000\u0000\u0000\u008a\t\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0005&\u0000\u0000\u008c\u008d\u0003\f\u0006\u0000\u008d\u0091"+
		"\u0005\t\u0000\u0000\u008e\u0090\u0003\u0002\u0001\u0000\u008f\u008e\u0001"+
		"\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u009d\u0001"+
		"\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0095\u0005"+
		"\'\u0000\u0000\u0095\u0099\u0005\t\u0000\u0000\u0096\u0098\u0003\u0002"+
		"\u0001\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u009b\u0001\u0000"+
		"\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000"+
		"\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000"+
		"\u0000\u0000\u009c\u008b\u0001\u0000\u0000\u0000\u009c\u0094\u0001\u0000"+
		"\u0000\u0000\u009d\u000b\u0001\u0000\u0000\u0000\u009e\u009f\u0006\u0006"+
		"\uffff\uffff\u0000\u009f\u00a0\u0007\u0000\u0000\u0000\u00a0\u00b1\u0003"+
		"\f\u0006\u0011\u00a1\u00b1\u0005,\u0000\u0000\u00a2\u00b1\u0005-\u0000"+
		"\u0000\u00a3\u00b1\u0005.\u0000\u0000\u00a4\u00b1\u0005/\u0000\u0000\u00a5"+
		"\u00b1\u00050\u0000\u0000\u00a6\u00a7\u00056\u0000\u0000\u00a7\u00a8\u0007"+
		"\u0001\u0000\u0000\u00a8\u00b1\u0003\f\u0006\u0004\u00a9\u00aa\u00056"+
		"\u0000\u0000\u00aa\u00b1\u0007\u0002\u0000\u0000\u00ab\u00b1\u00056\u0000"+
		"\u0000\u00ac\u00ad\u0005\u0001\u0000\u0000\u00ad\u00ae\u0003\f\u0006\u0000"+
		"\u00ae\u00af\u0005\u0002\u0000\u0000\u00af\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b0\u009e\u0001\u0000\u0000\u0000\u00b0\u00a1\u0001\u0000\u0000\u0000"+
		"\u00b0\u00a2\u0001\u0000\u0000\u0000\u00b0\u00a3\u0001\u0000\u0000\u0000"+
		"\u00b0\u00a4\u0001\u0000\u0000\u0000\u00b0\u00a5\u0001\u0000\u0000\u0000"+
		"\u00b0\u00a6\u0001\u0000\u0000\u0000\u00b0\u00a9\u0001\u0000\u0000\u0000"+
		"\u00b0\u00ab\u0001\u0000\u0000\u0000\u00b0\u00ac\u0001\u0000\u0000\u0000"+
		"\u00b1\u00cc\u0001\u0000\u0000\u0000\u00b2\u00b3\n\u000f\u0000\u0000\u00b3"+
		"\u00b4\u0007\u0003\u0000\u0000\u00b4\u00cb\u0003\f\u0006\u0010\u00b5\u00b6"+
		"\n\u000e\u0000\u0000\u00b6\u00b7\u0007\u0004\u0000\u0000\u00b7\u00cb\u0003"+
		"\f\u0006\u000f\u00b8\u00b9\n\r\u0000\u0000\u00b9\u00ba\u0007\u0005\u0000"+
		"\u0000\u00ba\u00cb\u0003\f\u0006\u000e\u00bb\u00bc\n\f\u0000\u0000\u00bc"+
		"\u00bd\u0007\u0006\u0000\u0000\u00bd\u00cb\u0003\f\u0006\r\u00be\u00bf"+
		"\n\u000b\u0000\u0000\u00bf\u00c0\u0005\u001d\u0000\u0000\u00c0\u00cb\u0003"+
		"\f\u0006\f\u00c1\u00c2\n\n\u0000\u0000\u00c2\u00c3\u0005\u001c\u0000\u0000"+
		"\u00c3\u00cb\u0003\f\u0006\u000b\u00c4\u00c6\n\u0010\u0000\u0000\u00c5"+
		"\u00c7\u0003\u000e\u0007\u0000\u00c6\u00c5\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c8\u0001\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0001\u0000\u0000\u0000\u00c9\u00cb\u0001\u0000\u0000\u0000\u00ca"+
		"\u00b2\u0001\u0000\u0000\u0000\u00ca\u00b5\u0001\u0000\u0000\u0000\u00ca"+
		"\u00b8\u0001\u0000\u0000\u0000\u00ca\u00bb\u0001\u0000\u0000\u0000\u00ca"+
		"\u00be\u0001\u0000\u0000\u0000\u00ca\u00c1\u0001\u0000\u0000\u0000\u00ca"+
		"\u00c4\u0001\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd"+
		"\r\u0001\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d1"+
		"\u0005\u0001\u0000\u0000\u00d0\u00d2\u0003\u0010\b\u0000\u00d1\u00d0\u0001"+
		"\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0005\u0002\u0000\u0000\u00d4\u000f\u0001"+
		"\u0000\u0000\u0000\u00d5\u00da\u0003\f\u0006\u0000\u00d6\u00d7\u0005\n"+
		"\u0000\u0000\u00d7\u00d9\u0003\f\u0006\u0000\u00d8\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d9\u00dc\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000"+
		"\u0000\u00da\u00db\u0001\u0000\u0000\u0000\u00db\u0011\u0001\u0000\u0000"+
		"\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dd\u00de\u0007\u0007\u0000"+
		"\u0000\u00de\u0013\u0001\u0000\u0000\u0000\u001d\u0017\u001c/3<BHLQY_"+
		"cipvz~\u0081\u0083\u0089\u0091\u0099\u009c\u00b0\u00c8\u00ca\u00cc\u00d1"+
		"\u00da";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}