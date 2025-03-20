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
		STFUNC=44, STRUCT=45, STTYPE=46, NUEVO=47, INT=48, FLOAT=49, STRING=50, 
		BOOL=51, RUNE=52, T_INT=53, T_FLOAT=54, T_STR=55, T_BOOL=56, T_RUNE=57, 
		ID=58, WS=59, COMENT=60, MCOMENT=61;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_funcionDcl = 3, 
		RULE_parametrosF = 4, RULE_structDcl = 5, RULE_atriBody = 6, RULE_statement = 7, 
		RULE_forInit = 8, RULE_caseStmt = 9, RULE_expr = 10, RULE_call = 11, RULE_parametros = 12, 
		RULE_initAttrList = 13, RULE_initAttr = 14, RULE_tiposD = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "funcionDcl", "parametrosF", "structDcl", 
			"atriBody", "statement", "forInit", "caseStmt", "expr", "call", "parametros", 
			"initAttrList", "initAttr", "tiposD"
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
			"'return'", "'func'", "'struct'", "'type'", "'new'", null, null, null, 
			null, null, "'int'", "'float64'", "'string'", "'bool'", "'rune'"
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
			"DEFAUL", "FOR", "STBREAK", "STCONTINUE", "STRETURN", "STFUNC", "STRUCT", 
			"STTYPE", "NUEVO", "INT", "FLOAT", "STRING", "BOOL", "RUNE", "T_INT", 
			"T_FLOAT", "T_STR", "T_BOOL", "T_RUNE", "ID", "WS", "COMENT", "MCOMENT"
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
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 297201477280075786L) != 0)) {
				{
				{
				setState(32);
				dcl();
				}
				}
				setState(37);
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
		public FuncionDclContext funcionDcl() {
			return getRuleContext(FuncionDclContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StructDclContext structDcl() {
			return getRuleContext(StructDclContext.class,0);
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
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				funcionDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				structDcl();
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
	public static class VarDclStructContext extends VarDclContext {
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public TerminalNode SEMICOLON() { return getToken(LanguageParser.SEMICOLON, 0); }
		public VarDclStructContext(VarDclContext ctx) { copyFrom(ctx); }
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
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new VarDclStructContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				match(VAR);
				setState(45);
				match(ID);
				setState(46);
				match(ID);
				setState(47);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new VarDcl1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				match(VAR);
				setState(49);
				match(ID);
				setState(50);
				tiposD();
				setState(51);
				match(IGUAL);
				setState(52);
				expr(0);
				setState(53);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new VarDcl2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				match(VAR);
				setState(56);
				match(ID);
				setState(57);
				tiposD();
				setState(58);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new VarDcl3Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(60);
				match(ID);
				setState(61);
				match(DCLIMPL);
				setState(62);
				expr(0);
				setState(63);
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
	public static class FuncionDclContext extends ParserRuleContext {
		public TerminalNode STFUNC() { return getToken(LanguageParser.STFUNC, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(LanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LanguageParser.RBRACE, 0); }
		public ParametrosFContext parametrosF() {
			return getRuleContext(ParametrosFContext.class,0);
		}
		public TiposDContext tiposD() {
			return getRuleContext(TiposDContext.class,0);
		}
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public FuncionDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcionDcl; }
	}

	public final FuncionDclContext funcionDcl() throws RecognitionException {
		FuncionDclContext _localctx = new FuncionDclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcionDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(STFUNC);
			setState(68);
			match(ID);
			setState(69);
			match(LPAREN);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(70);
				parametrosF();
				}
			}

			setState(73);
			match(RPAREN);
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 279223176896970752L) != 0)) {
				{
				setState(74);
				tiposD();
				}
			}

			setState(77);
			match(LBRACE);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 297201477280075786L) != 0)) {
				{
				{
				setState(78);
				dcl();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			match(RBRACE);
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
	public static class ParametrosFContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public List<TiposDContext> tiposD() {
			return getRuleContexts(TiposDContext.class);
		}
		public TiposDContext tiposD(int i) {
			return getRuleContext(TiposDContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LanguageParser.COMMA, i);
		}
		public ParametrosFContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametrosF; }
	}

	public final ParametrosFContext parametrosF() throws RecognitionException {
		ParametrosFContext _localctx = new ParametrosFContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_parametrosF);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(ID);
			setState(87);
			tiposD();
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(88);
				match(COMMA);
				setState(89);
				match(ID);
				setState(90);
				tiposD();
				}
				}
				setState(95);
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
	public static class StructDclContext extends ParserRuleContext {
		public TerminalNode STTYPE() { return getToken(LanguageParser.STTYPE, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode STRUCT() { return getToken(LanguageParser.STRUCT, 0); }
		public TerminalNode LBRACE() { return getToken(LanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LanguageParser.RBRACE, 0); }
		public List<AtriBodyContext> atriBody() {
			return getRuleContexts(AtriBodyContext.class);
		}
		public AtriBodyContext atriBody(int i) {
			return getRuleContext(AtriBodyContext.class,i);
		}
		public StructDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDcl; }
	}

	public final StructDclContext structDcl() throws RecognitionException {
		StructDclContext _localctx = new StructDclContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_structDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(STTYPE);
			setState(97);
			match(ID);
			setState(98);
			match(STRUCT);
			setState(99);
			match(LBRACE);
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(100);
				atriBody();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106);
			match(RBRACE);
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
	public static class AtriBodyContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public TiposDContext tiposD() {
			return getRuleContext(TiposDContext.class,0);
		}
		public AtriBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atriBody; }
	}

	public final AtriBodyContext atriBody() throws RecognitionException {
		AtriBodyContext _localctx = new AtriBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_atriBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(ID);
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T_INT:
			case T_FLOAT:
			case T_STR:
			case T_BOOL:
			case T_RUNE:
				{
				setState(109);
				tiposD();
				}
				break;
			case ID:
				{
				setState(110);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			setState(195);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				expr(0);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(114);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 2:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(FMT);
				setState(118);
				match(DOT);
				setState(119);
				match(PRINT);
				setState(120);
				match(LPAREN);
				setState(121);
				expr(0);
				setState(122);
				match(RPAREN);
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(123);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 3:
				_localctx = new BloqueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				match(LBRACE);
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 297201477280075786L) != 0)) {
					{
					{
					setState(127);
					dcl();
					}
					}
					setState(132);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(133);
				match(RBRACE);
				}
				break;
			case 4:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
				match(IF);
				setState(136);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(135);
					match(LPAREN);
					}
					break;
				}
				setState(138);
				expr(0);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(139);
					match(RPAREN);
					}
				}

				setState(142);
				statement();
				setState(145);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(143);
					match(ELSE);
					setState(144);
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
				setState(147);
				match(SWITCH);
				setState(148);
				expr(0);
				setState(149);
				match(LBRACE);
				setState(151); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(150);
					caseStmt();
					}
					}
					setState(153); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CASE || _la==DEFAUL );
				setState(155);
				match(RBRACE);
				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(157);
				match(FOR);
				setState(159);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(158);
					match(LPAREN);
					}
					break;
				}
				setState(161);
				expr(0);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(162);
					match(RPAREN);
					}
				}

				setState(165);
				statement();
				}
				break;
			case 7:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(167);
				match(FOR);
				setState(169);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(168);
					match(LPAREN);
					}
					break;
				}
				setState(171);
				forInit();
				setState(172);
				expr(0);
				setState(173);
				match(SEMICOLON);
				setState(174);
				expr(0);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(175);
					match(RPAREN);
					}
				}

				setState(178);
				statement();
				}
				break;
			case 8:
				_localctx = new ST_breakContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(180);
				match(STBREAK);
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(181);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 9:
				_localctx = new ST_continueContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(184);
				match(STCONTINUE);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(185);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 10:
				_localctx = new ST_returnContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(188);
				match(STRETURN);
				setState(190);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(189);
					expr(0);
					}
					break;
				}
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(192);
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
		enterRule(_localctx, 16, RULE_forInit);
		try {
			setState(201);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				expr(0);
				setState(199);
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
		enterRule(_localctx, 18, RULE_caseStmt);
		int _la;
		try {
			setState(220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				_localctx = new CaseNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(CASE);
				setState(204);
				expr(0);
				setState(205);
				match(COLON);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 297201477280075786L) != 0)) {
					{
					{
					setState(206);
					dcl();
					}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DEFAUL:
				_localctx = new CaseDefaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(212);
				match(DEFAUL);
				setState(213);
				match(COLON);
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 297201477280075786L) != 0)) {
					{
					{
					setState(214);
					dcl();
					}
					}
					setState(219);
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
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
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
	public static class NewStructInitContext extends ExprContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public TerminalNode DCLIMPL() { return getToken(LanguageParser.DCLIMPL, 0); }
		public TerminalNode LBRACE() { return getToken(LanguageParser.LBRACE, 0); }
		public InitAttrListContext initAttrList() {
			return getRuleContext(InitAttrListContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(LanguageParser.RBRACE, 0); }
		public NewStructInitContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class NewInstanContext extends ExprContext {
		public TerminalNode NUEVO() { return getToken(LanguageParser.NUEVO, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public NewInstanContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class UpdateVarContext extends ExprContext {
		public Token op;
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode INCREMENTO() { return getToken(LanguageParser.INCREMENTO, 0); }
		public TerminalNode DECREMENTO() { return getToken(LanguageParser.DECREMENTO, 0); }
		public UpdateVarContext(ExprContext ctx) { copyFrom(ctx); }
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new NegateUContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(223);
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
				setState(224);
				expr(19);
				}
				break;
			case 2:
				{
				_localctx = new UpdateVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				match(ID);
				setState(226);
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
			case 3:
				{
				_localctx = new NewStructInitContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(ID);
				setState(228);
				match(DCLIMPL);
				setState(229);
				match(ID);
				setState(230);
				match(LBRACE);
				setState(231);
				initAttrList();
				setState(232);
				match(RBRACE);
				}
				break;
			case 4:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234);
				match(INT);
				}
				break;
			case 5:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235);
				match(FLOAT);
				}
				break;
			case 6:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				match(BOOL);
				}
				break;
			case 8:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238);
				match(RUNE);
				}
				break;
			case 9:
				{
				_localctx = new NewInstanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				match(NUEVO);
				setState(240);
				match(ID);
				setState(241);
				match(LPAREN);
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 297096838991843330L) != 0)) {
					{
					setState(242);
					parametros();
					}
				}

				setState(245);
				match(RPAREN);
				}
				break;
			case 10:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(246);
				match(ID);
				}
				break;
			case 11:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(247);
				match(LPAREN);
				setState(248);
				expr(0);
				setState(249);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(280);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(254);
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
						setState(255);
						expr(18);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(257);
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
						setState(258);
						expr(17);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(260);
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
						setState(261);
						expr(16);
						}
						break;
					case 4:
						{
						_localctx = new ComparationContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(262);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(263);
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
						setState(264);
						expr(15);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(265);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(266);
						match(AND);
						setState(267);
						expr(14);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(268);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(269);
						match(OR);
						setState(270);
						expr(13);
						}
						break;
					case 7:
						{
						_localctx = new AssignVarContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(271);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(272);
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
						setState(273);
						expr(12);
						}
						break;
					case 8:
						{
						_localctx = new LlamadaContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(274);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(276); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(275);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(278); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	 
		public CallContext() { }
		public void copyFrom(CallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallContext extends CallContext {
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public FuncCallContext(CallContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GetAtrContext extends CallContext {
		public TerminalNode DOT() { return getToken(LanguageParser.DOT, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public GetAtrContext(CallContext ctx) { copyFrom(ctx); }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_call);
		int _la;
		try {
			setState(292);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(285);
				match(LPAREN);
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 297096838991843330L) != 0)) {
					{
					setState(286);
					parametros();
					}
				}

				setState(289);
				match(RPAREN);
				}
				break;
			case DOT:
				_localctx = new GetAtrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(290);
				match(DOT);
				setState(291);
				match(ID);
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
		enterRule(_localctx, 24, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			expr(0);
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(295);
				match(COMMA);
				setState(296);
				expr(0);
				}
				}
				setState(301);
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
	public static class InitAttrListContext extends ParserRuleContext {
		public List<InitAttrContext> initAttr() {
			return getRuleContexts(InitAttrContext.class);
		}
		public InitAttrContext initAttr(int i) {
			return getRuleContext(InitAttrContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(LanguageParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(LanguageParser.COMMA, i);
		}
		public InitAttrListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initAttrList; }
	}

	public final InitAttrListContext initAttrList() throws RecognitionException {
		InitAttrListContext _localctx = new InitAttrListContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_initAttrList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			initAttr();
			setState(303);
			match(COMMA);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(304);
				initAttr();
				setState(305);
				match(COMMA);
				}
				}
				setState(311);
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
	public static class InitAttrContext extends ParserRuleContext {
		public InitAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initAttr; }
	 
		public InitAttrContext() { }
		public void copyFrom(InitAttrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InitAttrExprContext extends InitAttrContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode COLON() { return getToken(LanguageParser.COLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public InitAttrExprContext(InitAttrContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InitAttrStructContext extends InitAttrContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public TerminalNode COLON() { return getToken(LanguageParser.COLON, 0); }
		public TerminalNode LBRACE() { return getToken(LanguageParser.LBRACE, 0); }
		public InitAttrListContext initAttrList() {
			return getRuleContext(InitAttrListContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(LanguageParser.RBRACE, 0); }
		public InitAttrStructContext(InitAttrContext ctx) { copyFrom(ctx); }
	}

	public final InitAttrContext initAttr() throws RecognitionException {
		InitAttrContext _localctx = new InitAttrContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_initAttr);
		try {
			setState(322);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				_localctx = new InitAttrExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				match(ID);
				setState(313);
				match(COLON);
				setState(314);
				expr(0);
				}
				break;
			case 2:
				_localctx = new InitAttrStructContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				match(ID);
				setState(316);
				match(COLON);
				setState(317);
				match(ID);
				setState(318);
				match(LBRACE);
				setState(319);
				initAttrList();
				setState(320);
				match(RBRACE);
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
		enterRule(_localctx, 30, RULE_tiposD);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 279223176896970752L) != 0)) ) {
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
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001=\u0147\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001+\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002B\b\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003H\b\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003L\b\u0003\u0001\u0003\u0001\u0003\u0005\u0003P\b\u0003\n\u0003"+
		"\f\u0003S\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004\\\b\u0004\n\u0004\f\u0004_"+
		"\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005f\b\u0005\n\u0005\f\u0005i\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006p\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0003\u0007t\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007}\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u0081\b\u0007\n\u0007\f\u0007\u0084\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0089\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u008d\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u0092\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0004\u0007\u0098\b\u0007\u000b\u0007\f\u0007\u0099\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a0\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00a4\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00aa\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00b1\b\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u00b7\b\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007\u00bb\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00bf\b\u0007"+
		"\u0001\u0007\u0003\u0007\u00c2\b\u0007\u0003\u0007\u00c4\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u00ca\b\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u00d0\b\t\n\t\f\t\u00d3\t\t\u0001\t\u0001\t\u0001\t\u0005\t"+
		"\u00d8\b\t\n\t\f\t\u00db\t\t\u0003\t\u00dd\b\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0003\n\u00f4\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u00fc\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u0115\b\n\u000b"+
		"\n\f\n\u0116\u0005\n\u0119\b\n\n\n\f\n\u011c\t\n\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u0120\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u0125\b\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u012a\b\f\n\f\f\f\u012d"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0134\b\r\n\r\f\r"+
		"\u0137\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e"+
		"\u0143\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0000\u0001\u0014\u0010"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e\u0000\b\u0002\u0000\f\f\u001e\u001e\u0001\u0000\u0013\u0014"+
		"\u0002\u0000\r\r\u000f\u0010\u0001\u0000\u000b\f\u0001\u0000\u0018\u001b"+
		"\u0001\u0000\u0016\u0017\u0002\u0000\u0011\u0012\u0015\u0015\u0001\u0000"+
		"59\u0178\u0000#\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000"+
		"\u0004A\u0001\u0000\u0000\u0000\u0006C\u0001\u0000\u0000\u0000\bV\u0001"+
		"\u0000\u0000\u0000\n`\u0001\u0000\u0000\u0000\fl\u0001\u0000\u0000\u0000"+
		"\u000e\u00c3\u0001\u0000\u0000\u0000\u0010\u00c9\u0001\u0000\u0000\u0000"+
		"\u0012\u00dc\u0001\u0000\u0000\u0000\u0014\u00fb\u0001\u0000\u0000\u0000"+
		"\u0016\u0124\u0001\u0000\u0000\u0000\u0018\u0126\u0001\u0000\u0000\u0000"+
		"\u001a\u012e\u0001\u0000\u0000\u0000\u001c\u0142\u0001\u0000\u0000\u0000"+
		"\u001e\u0144\u0001\u0000\u0000\u0000 \"\u0003\u0002\u0001\u0000! \u0001"+
		"\u0000\u0000\u0000\"%\u0001\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000"+
		"#$\u0001\u0000\u0000\u0000$\u0001\u0001\u0000\u0000\u0000%#\u0001\u0000"+
		"\u0000\u0000&+\u0003\u0004\u0002\u0000\'+\u0003\u0006\u0003\u0000(+\u0003"+
		"\u000e\u0007\u0000)+\u0003\n\u0005\u0000*&\u0001\u0000\u0000\u0000*\'"+
		"\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000*)\u0001\u0000\u0000"+
		"\u0000+\u0003\u0001\u0000\u0000\u0000,-\u0005!\u0000\u0000-.\u0005:\u0000"+
		"\u0000./\u0005:\u0000\u0000/B\u0005\u0007\u0000\u000001\u0005!\u0000\u0000"+
		"12\u0005:\u0000\u000023\u0003\u001e\u000f\u000034\u0005\u0015\u0000\u0000"+
		"45\u0003\u0014\n\u000056\u0005\u0007\u0000\u00006B\u0001\u0000\u0000\u0000"+
		"78\u0005!\u0000\u000089\u0005:\u0000\u00009:\u0003\u001e\u000f\u0000:"+
		";\u0005\u0007\u0000\u0000;B\u0001\u0000\u0000\u0000<=\u0005:\u0000\u0000"+
		"=>\u0005\"\u0000\u0000>?\u0003\u0014\n\u0000?@\u0005\u0007\u0000\u0000"+
		"@B\u0001\u0000\u0000\u0000A,\u0001\u0000\u0000\u0000A0\u0001\u0000\u0000"+
		"\u0000A7\u0001\u0000\u0000\u0000A<\u0001\u0000\u0000\u0000B\u0005\u0001"+
		"\u0000\u0000\u0000CD\u0005,\u0000\u0000DE\u0005:\u0000\u0000EG\u0005\u0001"+
		"\u0000\u0000FH\u0003\b\u0004\u0000GF\u0001\u0000\u0000\u0000GH\u0001\u0000"+
		"\u0000\u0000HI\u0001\u0000\u0000\u0000IK\u0005\u0002\u0000\u0000JL\u0003"+
		"\u001e\u000f\u0000KJ\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000"+
		"LM\u0001\u0000\u0000\u0000MQ\u0005\u0003\u0000\u0000NP\u0003\u0002\u0001"+
		"\u0000ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000TU\u0005\u0004\u0000\u0000U\u0007\u0001\u0000\u0000"+
		"\u0000VW\u0005:\u0000\u0000W]\u0003\u001e\u000f\u0000XY\u0005\n\u0000"+
		"\u0000YZ\u0005:\u0000\u0000Z\\\u0003\u001e\u000f\u0000[X\u0001\u0000\u0000"+
		"\u0000\\_\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^\t\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000`a\u0005"+
		".\u0000\u0000ab\u0005:\u0000\u0000bc\u0005-\u0000\u0000cg\u0005\u0003"+
		"\u0000\u0000df\u0003\f\u0006\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000"+
		"\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hj\u0001"+
		"\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jk\u0005\u0004\u0000\u0000"+
		"k\u000b\u0001\u0000\u0000\u0000lo\u0005:\u0000\u0000mp\u0003\u001e\u000f"+
		"\u0000np\u0005:\u0000\u0000om\u0001\u0000\u0000\u0000on\u0001\u0000\u0000"+
		"\u0000p\r\u0001\u0000\u0000\u0000qs\u0003\u0014\n\u0000rt\u0005\u0007"+
		"\u0000\u0000sr\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t\u00c4"+
		"\u0001\u0000\u0000\u0000uv\u0005 \u0000\u0000vw\u0005\b\u0000\u0000wx"+
		"\u0005\u001f\u0000\u0000xy\u0005\u0001\u0000\u0000yz\u0003\u0014\n\u0000"+
		"z|\u0005\u0002\u0000\u0000{}\u0005\u0007\u0000\u0000|{\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}\u00c4\u0001\u0000\u0000\u0000~\u0082"+
		"\u0005\u0003\u0000\u0000\u007f\u0081\u0003\u0002\u0001\u0000\u0080\u007f"+
		"\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0085"+
		"\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u00c4"+
		"\u0005\u0004\u0000\u0000\u0086\u0088\u0005#\u0000\u0000\u0087\u0089\u0005"+
		"\u0001\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0088\u0089\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008c\u0003"+
		"\u0014\n\u0000\u008b\u008d\u0005\u0002\u0000\u0000\u008c\u008b\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\u0091\u0003\u000e\u0007\u0000\u008f\u0090\u0005$\u0000"+
		"\u0000\u0090\u0092\u0003\u000e\u0007\u0000\u0091\u008f\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u00c4\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0005%\u0000\u0000\u0094\u0095\u0003\u0014\n\u0000"+
		"\u0095\u0097\u0005\u0003\u0000\u0000\u0096\u0098\u0003\u0012\t\u0000\u0097"+
		"\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099"+
		"\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u0004\u0000\u0000\u009c"+
		"\u00c4\u0001\u0000\u0000\u0000\u009d\u009f\u0005(\u0000\u0000\u009e\u00a0"+
		"\u0005\u0001\u0000\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u009f\u00a0"+
		"\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a3"+
		"\u0003\u0014\n\u0000\u00a2\u00a4\u0005\u0002\u0000\u0000\u00a3\u00a2\u0001"+
		"\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a5\u00a6\u0003\u000e\u0007\u0000\u00a6\u00c4\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a9\u0005(\u0000\u0000\u00a8\u00aa\u0005\u0001"+
		"\u0000\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001\u0000"+
		"\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00ac\u0003\u0010"+
		"\b\u0000\u00ac\u00ad\u0003\u0014\n\u0000\u00ad\u00ae\u0005\u0007\u0000"+
		"\u0000\u00ae\u00b0\u0003\u0014\n\u0000\u00af\u00b1\u0005\u0002\u0000\u0000"+
		"\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b3\u0003\u000e\u0007\u0000"+
		"\u00b3\u00c4\u0001\u0000\u0000\u0000\u00b4\u00b6\u0005)\u0000\u0000\u00b5"+
		"\u00b7\u0005\u0007\u0000\u0000\u00b6\u00b5\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b7\u00c4\u0001\u0000\u0000\u0000\u00b8"+
		"\u00ba\u0005*\u0000\u0000\u00b9\u00bb\u0005\u0007\u0000\u0000\u00ba\u00b9"+
		"\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000\u00bb\u00c4"+
		"\u0001\u0000\u0000\u0000\u00bc\u00be\u0005+\u0000\u0000\u00bd\u00bf\u0003"+
		"\u0014\n\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00c2\u0005\u0007"+
		"\u0000\u0000\u00c1\u00c0\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c4\u0001\u0000\u0000\u0000\u00c3q\u0001\u0000\u0000"+
		"\u0000\u00c3u\u0001\u0000\u0000\u0000\u00c3~\u0001\u0000\u0000\u0000\u00c3"+
		"\u0086\u0001\u0000\u0000\u0000\u00c3\u0093\u0001\u0000\u0000\u0000\u00c3"+
		"\u009d\u0001\u0000\u0000\u0000\u00c3\u00a7\u0001\u0000\u0000\u0000\u00c3"+
		"\u00b4\u0001\u0000\u0000\u0000\u00c3\u00b8\u0001\u0000\u0000\u0000\u00c3"+
		"\u00bc\u0001\u0000\u0000\u0000\u00c4\u000f\u0001\u0000\u0000\u0000\u00c5"+
		"\u00ca\u0003\u0004\u0002\u0000\u00c6\u00c7\u0003\u0014\n\u0000\u00c7\u00c8"+
		"\u0005\u0007\u0000\u0000\u00c8\u00ca\u0001\u0000\u0000\u0000\u00c9\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c9\u00c6\u0001\u0000\u0000\u0000\u00ca\u0011"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005&\u0000\u0000\u00cc\u00cd\u0003"+
		"\u0014\n\u0000\u00cd\u00d1\u0005\t\u0000\u0000\u00ce\u00d0\u0003\u0002"+
		"\u0001\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d2\u00dd\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d5\u0005\'\u0000\u0000\u00d5\u00d9\u0005\t\u0000"+
		"\u0000\u00d6\u00d8\u0003\u0002\u0001\u0000\u00d7\u00d6\u0001\u0000\u0000"+
		"\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000"+
		"\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00dd\u0001\u0000\u0000"+
		"\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00cb\u0001\u0000\u0000"+
		"\u0000\u00dc\u00d4\u0001\u0000\u0000\u0000\u00dd\u0013\u0001\u0000\u0000"+
		"\u0000\u00de\u00df\u0006\n\uffff\uffff\u0000\u00df\u00e0\u0007\u0000\u0000"+
		"\u0000\u00e0\u00fc\u0003\u0014\n\u0013\u00e1\u00e2\u0005:\u0000\u0000"+
		"\u00e2\u00fc\u0007\u0001\u0000\u0000\u00e3\u00e4\u0005:\u0000\u0000\u00e4"+
		"\u00e5\u0005\"\u0000\u0000\u00e5\u00e6\u0005:\u0000\u0000\u00e6\u00e7"+
		"\u0005\u0003\u0000\u0000\u00e7\u00e8\u0003\u001a\r\u0000\u00e8\u00e9\u0005"+
		"\u0004\u0000\u0000\u00e9\u00fc\u0001\u0000\u0000\u0000\u00ea\u00fc\u0005"+
		"0\u0000\u0000\u00eb\u00fc\u00051\u0000\u0000\u00ec\u00fc\u00052\u0000"+
		"\u0000\u00ed\u00fc\u00053\u0000\u0000\u00ee\u00fc\u00054\u0000\u0000\u00ef"+
		"\u00f0\u0005/\u0000\u0000\u00f0\u00f1\u0005:\u0000\u0000\u00f1\u00f3\u0005"+
		"\u0001\u0000\u0000\u00f2\u00f4\u0003\u0018\f\u0000\u00f3\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f5\u00fc\u0005\u0002\u0000\u0000\u00f6\u00fc\u0005:\u0000"+
		"\u0000\u00f7\u00f8\u0005\u0001\u0000\u0000\u00f8\u00f9\u0003\u0014\n\u0000"+
		"\u00f9\u00fa\u0005\u0002\u0000\u0000\u00fa\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fb\u00de\u0001\u0000\u0000\u0000\u00fb\u00e1\u0001\u0000\u0000\u0000"+
		"\u00fb\u00e3\u0001\u0000\u0000\u0000\u00fb\u00ea\u0001\u0000\u0000\u0000"+
		"\u00fb\u00eb\u0001\u0000\u0000\u0000\u00fb\u00ec\u0001\u0000\u0000\u0000"+
		"\u00fb\u00ed\u0001\u0000\u0000\u0000\u00fb\u00ee\u0001\u0000\u0000\u0000"+
		"\u00fb\u00ef\u0001\u0000\u0000\u0000\u00fb\u00f6\u0001\u0000\u0000\u0000"+
		"\u00fb\u00f7\u0001\u0000\u0000\u0000\u00fc\u011a\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fe\n\u0011\u0000\u0000\u00fe\u00ff\u0007\u0002\u0000\u0000\u00ff"+
		"\u0119\u0003\u0014\n\u0012\u0100\u0101\n\u0010\u0000\u0000\u0101\u0102"+
		"\u0007\u0003\u0000\u0000\u0102\u0119\u0003\u0014\n\u0011\u0103\u0104\n"+
		"\u000f\u0000\u0000\u0104\u0105\u0007\u0004\u0000\u0000\u0105\u0119\u0003"+
		"\u0014\n\u0010\u0106\u0107\n\u000e\u0000\u0000\u0107\u0108\u0007\u0005"+
		"\u0000\u0000\u0108\u0119\u0003\u0014\n\u000f\u0109\u010a\n\r\u0000\u0000"+
		"\u010a\u010b\u0005\u001d\u0000\u0000\u010b\u0119\u0003\u0014\n\u000e\u010c"+
		"\u010d\n\f\u0000\u0000\u010d\u010e\u0005\u001c\u0000\u0000\u010e\u0119"+
		"\u0003\u0014\n\r\u010f\u0110\n\u000b\u0000\u0000\u0110\u0111\u0007\u0006"+
		"\u0000\u0000\u0111\u0119\u0003\u0014\n\f\u0112\u0114\n\u0012\u0000\u0000"+
		"\u0113\u0115\u0003\u0016\u000b\u0000\u0114\u0113\u0001\u0000\u0000\u0000"+
		"\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000"+
		"\u0116\u0117\u0001\u0000\u0000\u0000\u0117\u0119\u0001\u0000\u0000\u0000"+
		"\u0118\u00fd\u0001\u0000\u0000\u0000\u0118\u0100\u0001\u0000\u0000\u0000"+
		"\u0118\u0103\u0001\u0000\u0000\u0000\u0118\u0106\u0001\u0000\u0000\u0000"+
		"\u0118\u0109\u0001\u0000\u0000\u0000\u0118\u010c\u0001\u0000\u0000\u0000"+
		"\u0118\u010f\u0001\u0000\u0000\u0000\u0118\u0112\u0001\u0000\u0000\u0000"+
		"\u0119\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000"+
		"\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u0015\u0001\u0000\u0000\u0000"+
		"\u011c\u011a\u0001\u0000\u0000\u0000\u011d\u011f\u0005\u0001\u0000\u0000"+
		"\u011e\u0120\u0003\u0018\f\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u011f"+
		"\u0120\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121"+
		"\u0125\u0005\u0002\u0000\u0000\u0122\u0123\u0005\b\u0000\u0000\u0123\u0125"+
		"\u0005:\u0000\u0000\u0124\u011d\u0001\u0000\u0000\u0000\u0124\u0122\u0001"+
		"\u0000\u0000\u0000\u0125\u0017\u0001\u0000\u0000\u0000\u0126\u012b\u0003"+
		"\u0014\n\u0000\u0127\u0128\u0005\n\u0000\u0000\u0128\u012a\u0003\u0014"+
		"\n\u0000\u0129\u0127\u0001\u0000\u0000\u0000\u012a\u012d\u0001\u0000\u0000"+
		"\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000"+
		"\u0000\u012c\u0019\u0001\u0000\u0000\u0000\u012d\u012b\u0001\u0000\u0000"+
		"\u0000\u012e\u012f\u0003\u001c\u000e\u0000\u012f\u0135\u0005\n\u0000\u0000"+
		"\u0130\u0131\u0003\u001c\u000e\u0000\u0131\u0132\u0005\n\u0000\u0000\u0132"+
		"\u0134\u0001\u0000\u0000\u0000\u0133\u0130\u0001\u0000\u0000\u0000\u0134"+
		"\u0137\u0001\u0000\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0135"+
		"\u0136\u0001\u0000\u0000\u0000\u0136\u001b\u0001\u0000\u0000\u0000\u0137"+
		"\u0135\u0001\u0000\u0000\u0000\u0138\u0139\u0005:\u0000\u0000\u0139\u013a"+
		"\u0005\t\u0000\u0000\u013a\u0143\u0003\u0014\n\u0000\u013b\u013c\u0005"+
		":\u0000\u0000\u013c\u013d\u0005\t\u0000\u0000\u013d\u013e\u0005:\u0000"+
		"\u0000\u013e\u013f\u0005\u0003\u0000\u0000\u013f\u0140\u0003\u001a\r\u0000"+
		"\u0140\u0141\u0005\u0004\u0000\u0000\u0141\u0143\u0001\u0000\u0000\u0000"+
		"\u0142\u0138\u0001\u0000\u0000\u0000\u0142\u013b\u0001\u0000\u0000\u0000"+
		"\u0143\u001d\u0001\u0000\u0000\u0000\u0144\u0145\u0007\u0007\u0000\u0000"+
		"\u0145\u001f\u0001\u0000\u0000\u0000\'#*AGKQ]gos|\u0082\u0088\u008c\u0091"+
		"\u0099\u009f\u00a3\u00a9\u00b0\u00b6\u00ba\u00be\u00c1\u00c3\u00c9\u00d1"+
		"\u00d9\u00dc\u00f3\u00fb\u0116\u0118\u011a\u011f\u0124\u012b\u0135\u0142";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}