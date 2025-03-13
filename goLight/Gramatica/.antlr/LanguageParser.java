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
		SWITCH=37, CASE=38, DEFAUL=39, FOR=40, INT=41, FLOAT=42, STRING=43, BOOL=44, 
		RUNE=45, T_INT=46, T_FLOAT=47, T_STR=48, T_BOOL=49, T_RUNE=50, ID=51, 
		WS=52, COMENT=53, MCOMENT=54;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_statement = 3, RULE_caseStmt = 4, 
		RULE_expr = 5, RULE_tiposD = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "statement", "caseStmt", "expr", "tiposD"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "'.'", "':'", 
			"','", "'+'", "'-'", "'*'", "'^'", "'/'", "'%'", "'+='", "'-='", "'++'", 
			"'--'", "'='", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'||'", 
			"'&&'", "'!'", "'Println'", "'fmt'", "'var'", "':='", "'if'", "'else'", 
			"'switch'", "'case'", "'default'", "'for'", null, null, null, null, null, 
			"'int'", "'float64'", "'string'", "'bool'", "'rune'"
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
			"DEFAUL", "FOR", "INT", "FLOAT", "STRING", "BOOL", "RUNE", "T_INT", "T_FLOAT", 
			"T_STR", "T_BOOL", "T_RUNE", "ID", "WS", "COMENT", "MCOMENT"
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
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2321254803574794L) != 0)) {
				{
				{
				setState(14);
				dcl();
				}
				}
				setState(19);
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
			setState(22);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(21);
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
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new VarDcl1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				match(VAR);
				setState(25);
				match(ID);
				setState(26);
				tiposD();
				setState(27);
				match(IGUAL);
				setState(28);
				expr(0);
				setState(29);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new VarDcl2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(VAR);
				setState(32);
				match(ID);
				setState(33);
				tiposD();
				setState(34);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new VarDcl3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(36);
				match(ID);
				setState(37);
				match(DCLIMPL);
				setState(38);
				expr(0);
				setState(39);
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

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(97);
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
				setState(43);
				expr(0);
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(44);
					match(SEMICOLON);
					}
				}

				}
				break;
			case FMT:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(FMT);
				setState(48);
				match(DOT);
				setState(49);
				match(PRINT);
				setState(50);
				match(LPAREN);
				setState(51);
				expr(0);
				setState(52);
				match(RPAREN);
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(53);
					match(SEMICOLON);
					}
				}

				}
				break;
			case LBRACE:
				_localctx = new BloqueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				match(LBRACE);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2321254803574794L) != 0)) {
					{
					{
					setState(57);
					dcl();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(63);
				match(RBRACE);
				}
				break;
			case IF:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(64);
				match(IF);
				setState(66);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(65);
					match(LPAREN);
					}
					break;
				}
				setState(68);
				expr(0);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(69);
					match(RPAREN);
					}
				}

				setState(72);
				statement();
				setState(75);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(73);
					match(ELSE);
					setState(74);
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
				setState(77);
				match(SWITCH);
				setState(78);
				expr(0);
				setState(79);
				match(LBRACE);
				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(80);
					caseStmt();
					}
					}
					setState(83); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CASE || _la==DEFAUL );
				setState(85);
				match(RBRACE);
				}
				break;
			case FOR:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(87);
				match(FOR);
				setState(89);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(88);
					match(LPAREN);
					}
					break;
				}
				setState(91);
				expr(0);
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(92);
					match(RPAREN);
					}
				}

				setState(95);
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
		enterRule(_localctx, 8, RULE_caseStmt);
		int _la;
		try {
			setState(116);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				_localctx = new CaseNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				match(CASE);
				setState(100);
				expr(0);
				setState(101);
				match(COLON);
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2321254803574794L) != 0)) {
					{
					{
					setState(102);
					dcl();
					}
					}
					setState(107);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DEFAUL:
				_localctx = new CaseDefaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(DEFAUL);
				setState(109);
				match(COLON);
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2321254803574794L) != 0)) {
					{
					{
					setState(110);
					dcl();
					}
					}
					setState(115);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				_localctx = new NegateUContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(119);
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
				setState(120);
				expr(16);
				}
				break;
			case 2:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(121);
				match(INT);
				}
				break;
			case 3:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				match(FLOAT);
				}
				break;
			case 4:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(STRING);
				}
				break;
			case 5:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(BOOL);
				}
				break;
			case 6:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(RUNE);
				}
				break;
			case 7:
				{
				_localctx = new AssignVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				match(ID);
				setState(127);
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
				setState(128);
				expr(4);
				}
				break;
			case 8:
				{
				_localctx = new UpdateVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				match(ID);
				setState(130);
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
				setState(131);
				match(ID);
				}
				break;
			case 10:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132);
				match(LPAREN);
				setState(133);
				expr(0);
				setState(134);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(156);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(138);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(139);
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
						setState(140);
						expr(16);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(141);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(142);
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
						setState(143);
						expr(15);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(144);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(145);
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
						setState(146);
						expr(14);
						}
						break;
					case 4:
						{
						_localctx = new ComparationContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(147);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(148);
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
						setState(149);
						expr(13);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(150);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(151);
						match(AND);
						setState(152);
						expr(12);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(153);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(154);
						match(OR);
						setState(155);
						expr(11);
						}
						break;
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		enterRule(_localctx, 12, RULE_tiposD);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2181431069507584L) != 0)) ) {
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
		case 5:
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
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00016\u00a4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0005\u0000\u0010"+
		"\b\u0000\n\u0000\f\u0000\u0013\t\u0000\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u0017\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002*\b\u0002\u0001\u0003\u0001\u0003\u0003\u0003.\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u00037\b\u0003\u0001\u0003\u0001\u0003\u0005\u0003;\b\u0003"+
		"\n\u0003\f\u0003>\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"C\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003G\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003L\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0004\u0003R\b\u0003\u000b\u0003\f\u0003S\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003Z\b\u0003\u0001\u0003"+
		"\u0001\u0003\u0003\u0003^\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"b\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"h\b\u0004\n\u0004\f\u0004k\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004p\b\u0004\n\u0004\f\u0004s\t\u0004\u0003\u0004u\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u0089\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005\u009d\b\u0005\n\u0005\f\u0005\u00a0\t\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0000\u0001\n\u0007\u0000\u0002\u0004"+
		"\u0006\b\n\f\u0000\b\u0002\u0000\f\f\u001e\u001e\u0002\u0000\u0011\u0012"+
		"\u0015\u0015\u0001\u0000\u0013\u0014\u0002\u0000\r\r\u000f\u0010\u0001"+
		"\u0000\u000b\f\u0001\u0000\u0018\u001b\u0001\u0000\u0016\u0017\u0001\u0000"+
		".2\u00c0\u0000\u0011\u0001\u0000\u0000\u0000\u0002\u0016\u0001\u0000\u0000"+
		"\u0000\u0004)\u0001\u0000\u0000\u0000\u0006a\u0001\u0000\u0000\u0000\b"+
		"t\u0001\u0000\u0000\u0000\n\u0088\u0001\u0000\u0000\u0000\f\u00a1\u0001"+
		"\u0000\u0000\u0000\u000e\u0010\u0003\u0002\u0001\u0000\u000f\u000e\u0001"+
		"\u0000\u0000\u0000\u0010\u0013\u0001\u0000\u0000\u0000\u0011\u000f\u0001"+
		"\u0000\u0000\u0000\u0011\u0012\u0001\u0000\u0000\u0000\u0012\u0001\u0001"+
		"\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0014\u0017\u0003"+
		"\u0004\u0002\u0000\u0015\u0017\u0003\u0006\u0003\u0000\u0016\u0014\u0001"+
		"\u0000\u0000\u0000\u0016\u0015\u0001\u0000\u0000\u0000\u0017\u0003\u0001"+
		"\u0000\u0000\u0000\u0018\u0019\u0005!\u0000\u0000\u0019\u001a\u00053\u0000"+
		"\u0000\u001a\u001b\u0003\f\u0006\u0000\u001b\u001c\u0005\u0015\u0000\u0000"+
		"\u001c\u001d\u0003\n\u0005\u0000\u001d\u001e\u0005\u0007\u0000\u0000\u001e"+
		"*\u0001\u0000\u0000\u0000\u001f \u0005!\u0000\u0000 !\u00053\u0000\u0000"+
		"!\"\u0003\f\u0006\u0000\"#\u0005\u0007\u0000\u0000#*\u0001\u0000\u0000"+
		"\u0000$%\u00053\u0000\u0000%&\u0005\"\u0000\u0000&\'\u0003\n\u0005\u0000"+
		"\'(\u0005\u0007\u0000\u0000(*\u0001\u0000\u0000\u0000)\u0018\u0001\u0000"+
		"\u0000\u0000)\u001f\u0001\u0000\u0000\u0000)$\u0001\u0000\u0000\u0000"+
		"*\u0005\u0001\u0000\u0000\u0000+-\u0003\n\u0005\u0000,.\u0005\u0007\u0000"+
		"\u0000-,\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.b\u0001\u0000"+
		"\u0000\u0000/0\u0005 \u0000\u000001\u0005\b\u0000\u000012\u0005\u001f"+
		"\u0000\u000023\u0005\u0001\u0000\u000034\u0003\n\u0005\u000046\u0005\u0002"+
		"\u0000\u000057\u0005\u0007\u0000\u000065\u0001\u0000\u0000\u000067\u0001"+
		"\u0000\u0000\u00007b\u0001\u0000\u0000\u00008<\u0005\u0003\u0000\u0000"+
		"9;\u0003\u0002\u0001\u0000:9\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000"+
		"\u0000<:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000"+
		"\u0000\u0000><\u0001\u0000\u0000\u0000?b\u0005\u0004\u0000\u0000@B\u0005"+
		"#\u0000\u0000AC\u0005\u0001\u0000\u0000BA\u0001\u0000\u0000\u0000BC\u0001"+
		"\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DF\u0003\n\u0005\u0000EG\u0005"+
		"\u0002\u0000\u0000FE\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000"+
		"GH\u0001\u0000\u0000\u0000HK\u0003\u0006\u0003\u0000IJ\u0005$\u0000\u0000"+
		"JL\u0003\u0006\u0003\u0000KI\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000"+
		"\u0000Lb\u0001\u0000\u0000\u0000MN\u0005%\u0000\u0000NO\u0003\n\u0005"+
		"\u0000OQ\u0005\u0003\u0000\u0000PR\u0003\b\u0004\u0000QP\u0001\u0000\u0000"+
		"\u0000RS\u0001\u0000\u0000\u0000SQ\u0001\u0000\u0000\u0000ST\u0001\u0000"+
		"\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0005\u0004\u0000\u0000Vb\u0001"+
		"\u0000\u0000\u0000WY\u0005(\u0000\u0000XZ\u0005\u0001\u0000\u0000YX\u0001"+
		"\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000"+
		"[]\u0003\n\u0005\u0000\\^\u0005\u0002\u0000\u0000]\\\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_`\u0003\u0006"+
		"\u0003\u0000`b\u0001\u0000\u0000\u0000a+\u0001\u0000\u0000\u0000a/\u0001"+
		"\u0000\u0000\u0000a8\u0001\u0000\u0000\u0000a@\u0001\u0000\u0000\u0000"+
		"aM\u0001\u0000\u0000\u0000aW\u0001\u0000\u0000\u0000b\u0007\u0001\u0000"+
		"\u0000\u0000cd\u0005&\u0000\u0000de\u0003\n\u0005\u0000ei\u0005\t\u0000"+
		"\u0000fh\u0003\u0002\u0001\u0000gf\u0001\u0000\u0000\u0000hk\u0001\u0000"+
		"\u0000\u0000ig\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000ju\u0001"+
		"\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000lm\u0005\'\u0000\u0000mq\u0005"+
		"\t\u0000\u0000np\u0003\u0002\u0001\u0000on\u0001\u0000\u0000\u0000ps\u0001"+
		"\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000"+
		"ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tc\u0001\u0000\u0000"+
		"\u0000tl\u0001\u0000\u0000\u0000u\t\u0001\u0000\u0000\u0000vw\u0006\u0005"+
		"\uffff\uffff\u0000wx\u0007\u0000\u0000\u0000x\u0089\u0003\n\u0005\u0010"+
		"y\u0089\u0005)\u0000\u0000z\u0089\u0005*\u0000\u0000{\u0089\u0005+\u0000"+
		"\u0000|\u0089\u0005,\u0000\u0000}\u0089\u0005-\u0000\u0000~\u007f\u0005"+
		"3\u0000\u0000\u007f\u0080\u0007\u0001\u0000\u0000\u0080\u0089\u0003\n"+
		"\u0005\u0004\u0081\u0082\u00053\u0000\u0000\u0082\u0089\u0007\u0002\u0000"+
		"\u0000\u0083\u0089\u00053\u0000\u0000\u0084\u0085\u0005\u0001\u0000\u0000"+
		"\u0085\u0086\u0003\n\u0005\u0000\u0086\u0087\u0005\u0002\u0000\u0000\u0087"+
		"\u0089\u0001\u0000\u0000\u0000\u0088v\u0001\u0000\u0000\u0000\u0088y\u0001"+
		"\u0000\u0000\u0000\u0088z\u0001\u0000\u0000\u0000\u0088{\u0001\u0000\u0000"+
		"\u0000\u0088|\u0001\u0000\u0000\u0000\u0088}\u0001\u0000\u0000\u0000\u0088"+
		"~\u0001\u0000\u0000\u0000\u0088\u0081\u0001\u0000\u0000\u0000\u0088\u0083"+
		"\u0001\u0000\u0000\u0000\u0088\u0084\u0001\u0000\u0000\u0000\u0089\u009e"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\n\u000f\u0000\u0000\u008b\u008c\u0007"+
		"\u0003\u0000\u0000\u008c\u009d\u0003\n\u0005\u0010\u008d\u008e\n\u000e"+
		"\u0000\u0000\u008e\u008f\u0007\u0004\u0000\u0000\u008f\u009d\u0003\n\u0005"+
		"\u000f\u0090\u0091\n\r\u0000\u0000\u0091\u0092\u0007\u0005\u0000\u0000"+
		"\u0092\u009d\u0003\n\u0005\u000e\u0093\u0094\n\f\u0000\u0000\u0094\u0095"+
		"\u0007\u0006\u0000\u0000\u0095\u009d\u0003\n\u0005\r\u0096\u0097\n\u000b"+
		"\u0000\u0000\u0097\u0098\u0005\u001d\u0000\u0000\u0098\u009d\u0003\n\u0005"+
		"\f\u0099\u009a\n\n\u0000\u0000\u009a\u009b\u0005\u001c\u0000\u0000\u009b"+
		"\u009d\u0003\n\u0005\u000b\u009c\u008a\u0001\u0000\u0000\u0000\u009c\u008d"+
		"\u0001\u0000\u0000\u0000\u009c\u0090\u0001\u0000\u0000\u0000\u009c\u0093"+
		"\u0001\u0000\u0000\u0000\u009c\u0096\u0001\u0000\u0000\u0000\u009c\u0099"+
		"\u0001\u0000\u0000\u0000\u009d\u00a0\u0001\u0000\u0000\u0000\u009e\u009c"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u000b"+
		"\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0007\u0007\u0000\u0000\u00a2\r\u0001\u0000\u0000\u0000\u0013\u0011\u0016"+
		")-6<BFKSY]aiqt\u0088\u009c\u009e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}