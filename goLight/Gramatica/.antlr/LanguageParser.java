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
		AND=29, NOT=30, AMPERSAND=31, PRINT=32, FMT=33, VAR=34, DCLIMPL=35, IF=36, 
		ELSE=37, SWITCH=38, CASE=39, DEFAUL=40, FOR=41, STBREAK=42, STCONTINUE=43, 
		STRETURN=44, STFUNC=45, STRUCT=46, STTYPE=47, NUEVO=48, INT=49, FLOAT=50, 
		STRING=51, BOOL=52, RUNE=53, T_INT=54, T_FLOAT=55, T_STR=56, T_BOOL=57, 
		T_RUNE=58, V_NULO=59, ID=60, WS=61, COMENT=62, MCOMENT=63;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_funcionDcl = 3, 
		RULE_parametrosF = 4, RULE_structDcl = 5, RULE_atriBody = 6, RULE_structFunc = 7, 
		RULE_statement = 8, RULE_forInit = 9, RULE_caseStmt = 10, RULE_expr = 11, 
		RULE_call = 12, RULE_parametros = 13, RULE_initAttrList = 14, RULE_initAttr = 15, 
		RULE_tiposD = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "funcionDcl", "parametrosF", "structDcl", 
			"atriBody", "structFunc", "statement", "forInit", "caseStmt", "expr", 
			"call", "parametros", "initAttrList", "initAttr", "tiposD"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "'.'", "':'", 
			"','", "'+'", "'-'", "'*'", "'^'", "'/'", "'%'", "'+='", "'-='", "'++'", 
			"'--'", "'='", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'||'", 
			"'&&'", "'!'", "'&'", "'Println'", "'fmt'", "'var'", "':='", "'if'", 
			"'else'", "'switch'", "'case'", "'default'", "'for'", "'break'", "'continue'", 
			"'return'", "'func'", "'struct'", "'type'", "'new'", null, null, null, 
			null, null, "'int'", "'float64'", "'string'", "'bool'", "'rune'", "'nil'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACKET", "RBRACKET", 
			"SEMICOLON", "DOT", "COLON", "COMMA", "MAS", "MENOS", "MULTI", "POTENCIA", 
			"DIV", "MODULO", "ASIGSUM", "ASIGMIN", "INCREMENTO", "DECREMENTO", "IGUAL", 
			"EQUALS", "DIFF", "MENOR", "MENIGUAL", "MAYOR", "MAYIGUAL", "OR", "AND", 
			"NOT", "AMPERSAND", "PRINT", "FMT", "VAR", "DCLIMPL", "IF", "ELSE", "SWITCH", 
			"CASE", "DEFAUL", "FOR", "STBREAK", "STCONTINUE", "STRETURN", "STFUNC", 
			"STRUCT", "STTYPE", "NUEVO", "INT", "FLOAT", "STRING", "BOOL", "RUNE", 
			"T_INT", "T_FLOAT", "T_STR", "T_BOOL", "T_RUNE", "V_NULO", "ID", "WS", 
			"COMENT", "MCOMENT"
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
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747324458093252618L) != 0)) {
				{
				{
				setState(34);
				dcl();
				}
				}
				setState(39);
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
		public StructFuncContext structFunc() {
			return getRuleContext(StructFuncContext.class,0);
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
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				funcionDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				structDcl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				structFunc();
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
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new VarDclStructContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(VAR);
				setState(48);
				match(ID);
				setState(49);
				match(ID);
				setState(50);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new VarDcl1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(VAR);
				setState(52);
				match(ID);
				setState(53);
				tiposD();
				setState(54);
				match(IGUAL);
				setState(55);
				expr(0);
				setState(56);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new VarDcl2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(58);
				match(VAR);
				setState(59);
				match(ID);
				setState(60);
				tiposD();
				setState(61);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new VarDcl3Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				match(ID);
				setState(64);
				match(DCLIMPL);
				setState(65);
				expr(0);
				setState(66);
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
			setState(70);
			match(STFUNC);
			setState(71);
			match(ID);
			setState(72);
			match(LPAREN);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(73);
				parametrosF();
				}
			}

			setState(76);
			match(RPAREN);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 558446353793941504L) != 0)) {
				{
				setState(77);
				tiposD();
				}
			}

			setState(80);
			match(LBRACE);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747324458093252618L) != 0)) {
				{
				{
				setState(81);
				dcl();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
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
			setState(89);
			match(ID);
			setState(90);
			tiposD();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(91);
				match(COMMA);
				setState(92);
				match(ID);
				setState(93);
				tiposD();
				}
				}
				setState(98);
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
			setState(99);
			match(STTYPE);
			setState(100);
			match(ID);
			setState(101);
			match(STRUCT);
			setState(102);
			match(LBRACE);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(103);
				atriBody();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
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
			setState(111);
			match(ID);
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T_INT:
			case T_FLOAT:
			case T_STR:
			case T_BOOL:
			case T_RUNE:
				{
				setState(112);
				tiposD();
				}
				break;
			case ID:
				{
				setState(113);
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
	public static class StructFuncContext extends ParserRuleContext {
		public TerminalNode STFUNC() { return getToken(LanguageParser.STFUNC, 0); }
		public List<TerminalNode> LPAREN() { return getTokens(LanguageParser.LPAREN); }
		public TerminalNode LPAREN(int i) {
			return getToken(LanguageParser.LPAREN, i);
		}
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public List<TerminalNode> RPAREN() { return getTokens(LanguageParser.RPAREN); }
		public TerminalNode RPAREN(int i) {
			return getToken(LanguageParser.RPAREN, i);
		}
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
		public StructFuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structFunc; }
	}

	public final StructFuncContext structFunc() throws RecognitionException {
		StructFuncContext _localctx = new StructFuncContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_structFunc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(STFUNC);
			setState(117);
			match(LPAREN);
			setState(118);
			match(ID);
			setState(119);
			match(ID);
			setState(120);
			match(RPAREN);
			setState(121);
			match(ID);
			setState(122);
			match(LPAREN);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(123);
				parametrosF();
				}
			}

			setState(126);
			match(RPAREN);
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 558446353793941504L) != 0)) {
				{
				setState(127);
				tiposD();
				}
			}

			setState(130);
			match(LBRACE);
			setState(134);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747324458093252618L) != 0)) {
				{
				{
				setState(131);
				dcl();
				}
				}
				setState(136);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
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
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				expr(0);
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(140);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 2:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(143);
				match(FMT);
				setState(144);
				match(DOT);
				setState(145);
				match(PRINT);
				setState(146);
				match(LPAREN);
				setState(147);
				expr(0);
				setState(148);
				match(RPAREN);
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(149);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 3:
				_localctx = new BloqueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(152);
				match(LBRACE);
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747324458093252618L) != 0)) {
					{
					{
					setState(153);
					dcl();
					}
					}
					setState(158);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(159);
				match(RBRACE);
				}
				break;
			case 4:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(160);
				match(IF);
				setState(162);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(161);
					match(LPAREN);
					}
					break;
				}
				setState(164);
				expr(0);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(165);
					match(RPAREN);
					}
				}

				setState(168);
				statement();
				setState(171);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(169);
					match(ELSE);
					setState(170);
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
				setState(173);
				match(SWITCH);
				setState(174);
				expr(0);
				setState(175);
				match(LBRACE);
				setState(177); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(176);
					caseStmt();
					}
					}
					setState(179); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CASE || _la==DEFAUL );
				setState(181);
				match(RBRACE);
				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(183);
				match(FOR);
				setState(185);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(184);
					match(LPAREN);
					}
					break;
				}
				setState(187);
				expr(0);
				setState(189);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(188);
					match(RPAREN);
					}
				}

				setState(191);
				statement();
				}
				break;
			case 7:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(193);
				match(FOR);
				setState(195);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(194);
					match(LPAREN);
					}
					break;
				}
				setState(197);
				forInit();
				setState(198);
				expr(0);
				setState(199);
				match(SEMICOLON);
				setState(200);
				expr(0);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(201);
					match(RPAREN);
					}
				}

				setState(204);
				statement();
				}
				break;
			case 8:
				_localctx = new ST_breakContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(206);
				match(STBREAK);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(207);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 9:
				_localctx = new ST_continueContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(210);
				match(STCONTINUE);
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(211);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 10:
				_localctx = new ST_returnContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(214);
				match(STRETURN);
				setState(216);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(215);
					expr(0);
					}
					break;
				}
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(218);
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
		enterRule(_localctx, 18, RULE_forInit);
		try {
			setState(227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				expr(0);
				setState(225);
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
		enterRule(_localctx, 20, RULE_caseStmt);
		int _la;
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				_localctx = new CaseNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(CASE);
				setState(230);
				expr(0);
				setState(231);
				match(COLON);
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747324458093252618L) != 0)) {
					{
					{
					setState(232);
					dcl();
					}
					}
					setState(237);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DEFAUL:
				_localctx = new CaseDefaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				match(DEFAUL);
				setState(239);
				match(COLON);
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747324458093252618L) != 0)) {
					{
					{
					setState(240);
					dcl();
					}
					}
					setState(245);
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
	public static class ValorNuloContext extends ExprContext {
		public TerminalNode V_NULO() { return getToken(LanguageParser.V_NULO, 0); }
		public ValorNuloContext(ExprContext ctx) { copyFrom(ctx); }
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				_localctx = new NegateUContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(249);
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
				setState(250);
				expr(20);
				}
				break;
			case 2:
				{
				_localctx = new UpdateVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				match(ID);
				setState(252);
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
				setState(253);
				match(ID);
				setState(254);
				match(DCLIMPL);
				setState(255);
				match(ID);
				setState(256);
				match(LBRACE);
				setState(257);
				initAttrList();
				setState(258);
				match(RBRACE);
				}
				break;
			case 4:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(260);
				match(INT);
				}
				break;
			case 5:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(261);
				match(FLOAT);
				}
				break;
			case 6:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(262);
				match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263);
				match(BOOL);
				}
				break;
			case 8:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				match(RUNE);
				}
				break;
			case 9:
				{
				_localctx = new ValorNuloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				match(V_NULO);
				}
				break;
			case 10:
				{
				_localctx = new NewInstanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(266);
				match(NUEVO);
				setState(267);
				match(ID);
				setState(268);
				match(LPAREN);
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747115181516787714L) != 0)) {
					{
					setState(269);
					parametros();
					}
				}

				setState(272);
				match(RPAREN);
				}
				break;
			case 11:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273);
				match(ID);
				}
				break;
			case 12:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274);
				match(LPAREN);
				setState(275);
				expr(0);
				setState(276);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(307);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(280);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(281);
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
						setState(282);
						expr(19);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(283);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(284);
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
						setState(285);
						expr(18);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(286);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(287);
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
						setState(288);
						expr(17);
						}
						break;
					case 4:
						{
						_localctx = new ComparationContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(289);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(290);
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
						setState(291);
						expr(16);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(292);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(293);
						match(AND);
						setState(294);
						expr(15);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(295);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(296);
						match(OR);
						setState(297);
						expr(14);
						}
						break;
					case 7:
						{
						_localctx = new AssignVarContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(298);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(299);
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
						setState(300);
						expr(13);
						}
						break;
					case 8:
						{
						_localctx = new LlamadaContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(301);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(303); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(302);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(305); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
		enterRule(_localctx, 24, RULE_call);
		int _la;
		try {
			setState(319);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				match(LPAREN);
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747115181516787714L) != 0)) {
					{
					setState(313);
					parametros();
					}
				}

				setState(316);
				match(RPAREN);
				}
				break;
			case DOT:
				_localctx = new GetAtrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(317);
				match(DOT);
				setState(318);
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
		enterRule(_localctx, 26, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			expr(0);
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(322);
				match(COMMA);
				setState(323);
				expr(0);
				}
				}
				setState(328);
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
		enterRule(_localctx, 28, RULE_initAttrList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			initAttr();
			setState(330);
			match(COMMA);
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(331);
				initAttr();
				setState(332);
				match(COMMA);
				}
				}
				setState(338);
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
		enterRule(_localctx, 30, RULE_initAttr);
		try {
			setState(349);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				_localctx = new InitAttrExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				match(ID);
				setState(340);
				match(COLON);
				setState(341);
				expr(0);
				}
				break;
			case 2:
				_localctx = new InitAttrStructContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(342);
				match(ID);
				setState(343);
				match(COLON);
				setState(344);
				match(ID);
				setState(345);
				match(LBRACE);
				setState(346);
				initAttrList();
				setState(347);
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
		enterRule(_localctx, 32, RULE_tiposD);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 558446353793941504L) != 0)) ) {
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
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 18);
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 19);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001?\u0162\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000"+
		"\'\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001.\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"E\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"K\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003O\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003S\b\u0003\n\u0003\f\u0003V\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004_\b\u0004\n\u0004\f\u0004b\t\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0005\u0005i\b\u0005\n\u0005\f\u0005l\t"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006s\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007}\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u0081\b\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u0085\b\u0007\n\u0007\f\u0007\u0088\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0003\b\u008e\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u0097\b\b\u0001\b\u0001\b\u0005\b\u009b\b\b"+
		"\n\b\f\b\u009e\t\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a3\b\b\u0001\b\u0001"+
		"\b\u0003\b\u00a7\b\b\u0001\b\u0001\b\u0001\b\u0003\b\u00ac\b\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0004\b\u00b2\b\b\u000b\b\f\b\u00b3\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u00ba\b\b\u0001\b\u0001\b\u0003\b\u00be\b\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00c4\b\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u00cb\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003"+
		"\b\u00d1\b\b\u0001\b\u0001\b\u0003\b\u00d5\b\b\u0001\b\u0001\b\u0003\b"+
		"\u00d9\b\b\u0001\b\u0003\b\u00dc\b\b\u0003\b\u00de\b\b\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0003\t\u00e4\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\n\u00ea\b\n\n\n\f\n\u00ed\t\n\u0001\n\u0001\n\u0001\n\u0005\n\u00f2\b"+
		"\n\n\n\f\n\u00f5\t\n\u0003\n\u00f7\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u010f\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0117\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u0130\b\u000b"+
		"\u000b\u000b\f\u000b\u0131\u0005\u000b\u0134\b\u000b\n\u000b\f\u000b\u0137"+
		"\t\u000b\u0001\f\u0001\f\u0003\f\u013b\b\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u0140\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u0145\b\r\n\r\f\r\u0148\t"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u014f\b\u000e\n\u000e\f\u000e\u0152\t\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u015e\b\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0000\u0001\u0016\u0011\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \u0000\b\u0002\u0000\f\f\u001e"+
		"\u001e\u0001\u0000\u0013\u0014\u0002\u0000\r\r\u000f\u0010\u0001\u0000"+
		"\u000b\f\u0001\u0000\u0018\u001b\u0001\u0000\u0016\u0017\u0002\u0000\u0011"+
		"\u0012\u0015\u0015\u0001\u00006:\u0197\u0000%\u0001\u0000\u0000\u0000"+
		"\u0002-\u0001\u0000\u0000\u0000\u0004D\u0001\u0000\u0000\u0000\u0006F"+
		"\u0001\u0000\u0000\u0000\bY\u0001\u0000\u0000\u0000\nc\u0001\u0000\u0000"+
		"\u0000\fo\u0001\u0000\u0000\u0000\u000et\u0001\u0000\u0000\u0000\u0010"+
		"\u00dd\u0001\u0000\u0000\u0000\u0012\u00e3\u0001\u0000\u0000\u0000\u0014"+
		"\u00f6\u0001\u0000\u0000\u0000\u0016\u0116\u0001\u0000\u0000\u0000\u0018"+
		"\u013f\u0001\u0000\u0000\u0000\u001a\u0141\u0001\u0000\u0000\u0000\u001c"+
		"\u0149\u0001\u0000\u0000\u0000\u001e\u015d\u0001\u0000\u0000\u0000 \u015f"+
		"\u0001\u0000\u0000\u0000\"$\u0003\u0002\u0001\u0000#\"\u0001\u0000\u0000"+
		"\u0000$\'\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000"+
		"\u0000\u0000&\u0001\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000"+
		"(.\u0003\u0004\u0002\u0000).\u0003\u0006\u0003\u0000*.\u0003\u0010\b\u0000"+
		"+.\u0003\n\u0005\u0000,.\u0003\u000e\u0007\u0000-(\u0001\u0000\u0000\u0000"+
		"-)\u0001\u0000\u0000\u0000-*\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000"+
		"\u0000-,\u0001\u0000\u0000\u0000.\u0003\u0001\u0000\u0000\u0000/0\u0005"+
		"\"\u0000\u000001\u0005<\u0000\u000012\u0005<\u0000\u00002E\u0005\u0007"+
		"\u0000\u000034\u0005\"\u0000\u000045\u0005<\u0000\u000056\u0003 \u0010"+
		"\u000067\u0005\u0015\u0000\u000078\u0003\u0016\u000b\u000089\u0005\u0007"+
		"\u0000\u00009E\u0001\u0000\u0000\u0000:;\u0005\"\u0000\u0000;<\u0005<"+
		"\u0000\u0000<=\u0003 \u0010\u0000=>\u0005\u0007\u0000\u0000>E\u0001\u0000"+
		"\u0000\u0000?@\u0005<\u0000\u0000@A\u0005#\u0000\u0000AB\u0003\u0016\u000b"+
		"\u0000BC\u0005\u0007\u0000\u0000CE\u0001\u0000\u0000\u0000D/\u0001\u0000"+
		"\u0000\u0000D3\u0001\u0000\u0000\u0000D:\u0001\u0000\u0000\u0000D?\u0001"+
		"\u0000\u0000\u0000E\u0005\u0001\u0000\u0000\u0000FG\u0005-\u0000\u0000"+
		"GH\u0005<\u0000\u0000HJ\u0005\u0001\u0000\u0000IK\u0003\b\u0004\u0000"+
		"JI\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000"+
		"\u0000LN\u0005\u0002\u0000\u0000MO\u0003 \u0010\u0000NM\u0001\u0000\u0000"+
		"\u0000NO\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PT\u0005\u0003"+
		"\u0000\u0000QS\u0003\u0002\u0001\u0000RQ\u0001\u0000\u0000\u0000SV\u0001"+
		"\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000"+
		"UW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WX\u0005\u0004\u0000"+
		"\u0000X\u0007\u0001\u0000\u0000\u0000YZ\u0005<\u0000\u0000Z`\u0003 \u0010"+
		"\u0000[\\\u0005\n\u0000\u0000\\]\u0005<\u0000\u0000]_\u0003 \u0010\u0000"+
		"^[\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000"+
		"\u0000`a\u0001\u0000\u0000\u0000a\t\u0001\u0000\u0000\u0000b`\u0001\u0000"+
		"\u0000\u0000cd\u0005/\u0000\u0000de\u0005<\u0000\u0000ef\u0005.\u0000"+
		"\u0000fj\u0005\u0003\u0000\u0000gi\u0003\f\u0006\u0000hg\u0001\u0000\u0000"+
		"\u0000il\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000"+
		"\u0000\u0000km\u0001\u0000\u0000\u0000lj\u0001\u0000\u0000\u0000mn\u0005"+
		"\u0004\u0000\u0000n\u000b\u0001\u0000\u0000\u0000or\u0005<\u0000\u0000"+
		"ps\u0003 \u0010\u0000qs\u0005<\u0000\u0000rp\u0001\u0000\u0000\u0000r"+
		"q\u0001\u0000\u0000\u0000s\r\u0001\u0000\u0000\u0000tu\u0005-\u0000\u0000"+
		"uv\u0005\u0001\u0000\u0000vw\u0005<\u0000\u0000wx\u0005<\u0000\u0000x"+
		"y\u0005\u0002\u0000\u0000yz\u0005<\u0000\u0000z|\u0005\u0001\u0000\u0000"+
		"{}\u0003\b\u0004\u0000|{\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}~\u0001\u0000\u0000\u0000~\u0080\u0005\u0002\u0000\u0000\u007f\u0081"+
		"\u0003 \u0010\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0080\u0081\u0001"+
		"\u0000\u0000\u0000\u0081\u0082\u0001\u0000\u0000\u0000\u0082\u0086\u0005"+
		"\u0003\u0000\u0000\u0083\u0085\u0003\u0002\u0001\u0000\u0084\u0083\u0001"+
		"\u0000\u0000\u0000\u0085\u0088\u0001\u0000\u0000\u0000\u0086\u0084\u0001"+
		"\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0089\u0001"+
		"\u0000\u0000\u0000\u0088\u0086\u0001\u0000\u0000\u0000\u0089\u008a\u0005"+
		"\u0004\u0000\u0000\u008a\u000f\u0001\u0000\u0000\u0000\u008b\u008d\u0003"+
		"\u0016\u000b\u0000\u008c\u008e\u0005\u0007\u0000\u0000\u008d\u008c\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u00de\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0005!\u0000\u0000\u0090\u0091\u0005\b"+
		"\u0000\u0000\u0091\u0092\u0005 \u0000\u0000\u0092\u0093\u0005\u0001\u0000"+
		"\u0000\u0093\u0094\u0003\u0016\u000b\u0000\u0094\u0096\u0005\u0002\u0000"+
		"\u0000\u0095\u0097\u0005\u0007\u0000\u0000\u0096\u0095\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u00de\u0001\u0000\u0000"+
		"\u0000\u0098\u009c\u0005\u0003\u0000\u0000\u0099\u009b\u0003\u0002\u0001"+
		"\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009b\u009e\u0001\u0000\u0000"+
		"\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000"+
		"\u0000\u009d\u009f\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000"+
		"\u0000\u009f\u00de\u0005\u0004\u0000\u0000\u00a0\u00a2\u0005$\u0000\u0000"+
		"\u00a1\u00a3\u0005\u0001\u0000\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a6\u0003\u0016\u000b\u0000\u00a5\u00a7\u0005\u0002\u0000\u0000"+
		"\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00ab\u0003\u0010\b\u0000\u00a9"+
		"\u00aa\u0005%\u0000\u0000\u00aa\u00ac\u0003\u0010\b\u0000\u00ab\u00a9"+
		"\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u00de"+
		"\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005&\u0000\u0000\u00ae\u00af\u0003"+
		"\u0016\u000b\u0000\u00af\u00b1\u0005\u0003\u0000\u0000\u00b0\u00b2\u0003"+
		"\u0014\n\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000\u00b2\u00b3\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6\u0005\u0004"+
		"\u0000\u0000\u00b6\u00de\u0001\u0000\u0000\u0000\u00b7\u00b9\u0005)\u0000"+
		"\u0000\u00b8\u00ba\u0005\u0001\u0000\u0000\u00b9\u00b8\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bd\u0003\u0016\u000b\u0000\u00bc\u00be\u0005\u0002\u0000"+
		"\u0000\u00bd\u00bc\u0001\u0000\u0000\u0000\u00bd\u00be\u0001\u0000\u0000"+
		"\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0003\u0010\b\u0000"+
		"\u00c0\u00de\u0001\u0000\u0000\u0000\u00c1\u00c3\u0005)\u0000\u0000\u00c2"+
		"\u00c4\u0005\u0001\u0000\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0003\u0012\t\u0000\u00c6\u00c7\u0003\u0016\u000b\u0000\u00c7\u00c8"+
		"\u0005\u0007\u0000\u0000\u00c8\u00ca\u0003\u0016\u000b\u0000\u00c9\u00cb"+
		"\u0005\u0002\u0000\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00cd"+
		"\u0003\u0010\b\u0000\u00cd\u00de\u0001\u0000\u0000\u0000\u00ce\u00d0\u0005"+
		"*\u0000\u0000\u00cf\u00d1\u0005\u0007\u0000\u0000\u00d0\u00cf\u0001\u0000"+
		"\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00de\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d4\u0005+\u0000\u0000\u00d3\u00d5\u0005\u0007\u0000"+
		"\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000"+
		"\u0000\u00d5\u00de\u0001\u0000\u0000\u0000\u00d6\u00d8\u0005,\u0000\u0000"+
		"\u00d7\u00d9\u0003\u0016\u000b\u0000\u00d8\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u00db\u0001\u0000\u0000\u0000"+
		"\u00da\u00dc\u0005\u0007\u0000\u0000\u00db\u00da\u0001\u0000\u0000\u0000"+
		"\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00de\u0001\u0000\u0000\u0000"+
		"\u00dd\u008b\u0001\u0000\u0000\u0000\u00dd\u008f\u0001\u0000\u0000\u0000"+
		"\u00dd\u0098\u0001\u0000\u0000\u0000\u00dd\u00a0\u0001\u0000\u0000\u0000"+
		"\u00dd\u00ad\u0001\u0000\u0000\u0000\u00dd\u00b7\u0001\u0000\u0000\u0000"+
		"\u00dd\u00c1\u0001\u0000\u0000\u0000\u00dd\u00ce\u0001\u0000\u0000\u0000"+
		"\u00dd\u00d2\u0001\u0000\u0000\u0000\u00dd\u00d6\u0001\u0000\u0000\u0000"+
		"\u00de\u0011\u0001\u0000\u0000\u0000\u00df\u00e4\u0003\u0004\u0002\u0000"+
		"\u00e0\u00e1\u0003\u0016\u000b\u0000\u00e1\u00e2\u0005\u0007\u0000\u0000"+
		"\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00df\u0001\u0000\u0000\u0000"+
		"\u00e3\u00e0\u0001\u0000\u0000\u0000\u00e4\u0013\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e6\u0005\'\u0000\u0000\u00e6\u00e7\u0003\u0016\u000b\u0000\u00e7"+
		"\u00eb\u0005\t\u0000\u0000\u00e8\u00ea\u0003\u0002\u0001\u0000\u00e9\u00e8"+
		"\u0001\u0000\u0000\u0000\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00f7"+
		"\u0001\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0005(\u0000\u0000\u00ef\u00f3\u0005\t\u0000\u0000\u00f0\u00f2\u0003"+
		"\u0002\u0001\u0000\u00f1\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f5\u0001"+
		"\u0000\u0000\u0000\u00f3\u00f1\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f7\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001"+
		"\u0000\u0000\u0000\u00f6\u00e5\u0001\u0000\u0000\u0000\u00f6\u00ee\u0001"+
		"\u0000\u0000\u0000\u00f7\u0015\u0001\u0000\u0000\u0000\u00f8\u00f9\u0006"+
		"\u000b\uffff\uffff\u0000\u00f9\u00fa\u0007\u0000\u0000\u0000\u00fa\u0117"+
		"\u0003\u0016\u000b\u0014\u00fb\u00fc\u0005<\u0000\u0000\u00fc\u0117\u0007"+
		"\u0001\u0000\u0000\u00fd\u00fe\u0005<\u0000\u0000\u00fe\u00ff\u0005#\u0000"+
		"\u0000\u00ff\u0100\u0005<\u0000\u0000\u0100\u0101\u0005\u0003\u0000\u0000"+
		"\u0101\u0102\u0003\u001c\u000e\u0000\u0102\u0103\u0005\u0004\u0000\u0000"+
		"\u0103\u0117\u0001\u0000\u0000\u0000\u0104\u0117\u00051\u0000\u0000\u0105"+
		"\u0117\u00052\u0000\u0000\u0106\u0117\u00053\u0000\u0000\u0107\u0117\u0005"+
		"4\u0000\u0000\u0108\u0117\u00055\u0000\u0000\u0109\u0117\u0005;\u0000"+
		"\u0000\u010a\u010b\u00050\u0000\u0000\u010b\u010c\u0005<\u0000\u0000\u010c"+
		"\u010e\u0005\u0001\u0000\u0000\u010d\u010f\u0003\u001a\r\u0000\u010e\u010d"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000\u0000\u0000\u010f\u0110"+
		"\u0001\u0000\u0000\u0000\u0110\u0117\u0005\u0002\u0000\u0000\u0111\u0117"+
		"\u0005<\u0000\u0000\u0112\u0113\u0005\u0001\u0000\u0000\u0113\u0114\u0003"+
		"\u0016\u000b\u0000\u0114\u0115\u0005\u0002\u0000\u0000\u0115\u0117\u0001"+
		"\u0000\u0000\u0000\u0116\u00f8\u0001\u0000\u0000\u0000\u0116\u00fb\u0001"+
		"\u0000\u0000\u0000\u0116\u00fd\u0001\u0000\u0000\u0000\u0116\u0104\u0001"+
		"\u0000\u0000\u0000\u0116\u0105\u0001\u0000\u0000\u0000\u0116\u0106\u0001"+
		"\u0000\u0000\u0000\u0116\u0107\u0001\u0000\u0000\u0000\u0116\u0108\u0001"+
		"\u0000\u0000\u0000\u0116\u0109\u0001\u0000\u0000\u0000\u0116\u010a\u0001"+
		"\u0000\u0000\u0000\u0116\u0111\u0001\u0000\u0000\u0000\u0116\u0112\u0001"+
		"\u0000\u0000\u0000\u0117\u0135\u0001\u0000\u0000\u0000\u0118\u0119\n\u0012"+
		"\u0000\u0000\u0119\u011a\u0007\u0002\u0000\u0000\u011a\u0134\u0003\u0016"+
		"\u000b\u0013\u011b\u011c\n\u0011\u0000\u0000\u011c\u011d\u0007\u0003\u0000"+
		"\u0000\u011d\u0134\u0003\u0016\u000b\u0012\u011e\u011f\n\u0010\u0000\u0000"+
		"\u011f\u0120\u0007\u0004\u0000\u0000\u0120\u0134\u0003\u0016\u000b\u0011"+
		"\u0121\u0122\n\u000f\u0000\u0000\u0122\u0123\u0007\u0005\u0000\u0000\u0123"+
		"\u0134\u0003\u0016\u000b\u0010\u0124\u0125\n\u000e\u0000\u0000\u0125\u0126"+
		"\u0005\u001d\u0000\u0000\u0126\u0134\u0003\u0016\u000b\u000f\u0127\u0128"+
		"\n\r\u0000\u0000\u0128\u0129\u0005\u001c\u0000\u0000\u0129\u0134\u0003"+
		"\u0016\u000b\u000e\u012a\u012b\n\f\u0000\u0000\u012b\u012c\u0007\u0006"+
		"\u0000\u0000\u012c\u0134\u0003\u0016\u000b\r\u012d\u012f\n\u0013\u0000"+
		"\u0000\u012e\u0130\u0003\u0018\f\u0000\u012f\u012e\u0001\u0000\u0000\u0000"+
		"\u0130\u0131\u0001\u0000\u0000\u0000\u0131\u012f\u0001\u0000\u0000\u0000"+
		"\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0134\u0001\u0000\u0000\u0000"+
		"\u0133\u0118\u0001\u0000\u0000\u0000\u0133\u011b\u0001\u0000\u0000\u0000"+
		"\u0133\u011e\u0001\u0000\u0000\u0000\u0133\u0121\u0001\u0000\u0000\u0000"+
		"\u0133\u0124\u0001\u0000\u0000\u0000\u0133\u0127\u0001\u0000\u0000\u0000"+
		"\u0133\u012a\u0001\u0000\u0000\u0000\u0133\u012d\u0001\u0000\u0000\u0000"+
		"\u0134\u0137\u0001\u0000\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000"+
		"\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0017\u0001\u0000\u0000\u0000"+
		"\u0137\u0135\u0001\u0000\u0000\u0000\u0138\u013a\u0005\u0001\u0000\u0000"+
		"\u0139\u013b\u0003\u001a\r\u0000\u013a\u0139\u0001\u0000\u0000\u0000\u013a"+
		"\u013b\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000\u0000\u0000\u013c"+
		"\u0140\u0005\u0002\u0000\u0000\u013d\u013e\u0005\b\u0000\u0000\u013e\u0140"+
		"\u0005<\u0000\u0000\u013f\u0138\u0001\u0000\u0000\u0000\u013f\u013d\u0001"+
		"\u0000\u0000\u0000\u0140\u0019\u0001\u0000\u0000\u0000\u0141\u0146\u0003"+
		"\u0016\u000b\u0000\u0142\u0143\u0005\n\u0000\u0000\u0143\u0145\u0003\u0016"+
		"\u000b\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0145\u0148\u0001\u0000"+
		"\u0000\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000"+
		"\u0000\u0000\u0147\u001b\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000"+
		"\u0000\u0000\u0149\u014a\u0003\u001e\u000f\u0000\u014a\u0150\u0005\n\u0000"+
		"\u0000\u014b\u014c\u0003\u001e\u000f\u0000\u014c\u014d\u0005\n\u0000\u0000"+
		"\u014d\u014f\u0001\u0000\u0000\u0000\u014e\u014b\u0001\u0000\u0000\u0000"+
		"\u014f\u0152\u0001\u0000\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000"+
		"\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u001d\u0001\u0000\u0000\u0000"+
		"\u0152\u0150\u0001\u0000\u0000\u0000\u0153\u0154\u0005<\u0000\u0000\u0154"+
		"\u0155\u0005\t\u0000\u0000\u0155\u015e\u0003\u0016\u000b\u0000\u0156\u0157"+
		"\u0005<\u0000\u0000\u0157\u0158\u0005\t\u0000\u0000\u0158\u0159\u0005"+
		"<\u0000\u0000\u0159\u015a\u0005\u0003\u0000\u0000\u015a\u015b\u0003\u001c"+
		"\u000e\u0000\u015b\u015c\u0005\u0004\u0000\u0000\u015c\u015e\u0001\u0000"+
		"\u0000\u0000\u015d\u0153\u0001\u0000\u0000\u0000\u015d\u0156\u0001\u0000"+
		"\u0000\u0000\u015e\u001f\u0001\u0000\u0000\u0000\u015f\u0160\u0007\u0007"+
		"\u0000\u0000\u0160!\u0001\u0000\u0000\u0000*%-DJNT`jr|\u0080\u0086\u008d"+
		"\u0096\u009c\u00a2\u00a6\u00ab\u00b3\u00b9\u00bd\u00c3\u00ca\u00d0\u00d4"+
		"\u00d8\u00db\u00dd\u00e3\u00eb\u00f3\u00f6\u010e\u0116\u0131\u0133\u0135"+
		"\u013a\u013f\u0146\u0150\u015d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}