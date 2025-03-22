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
		RULE_sliceDcl = 8, RULE_dimension = 9, RULE_slcParam = 10, RULE_statement = 11, 
		RULE_forInit = 12, RULE_caseStmt = 13, RULE_expr = 14, RULE_call = 15, 
		RULE_parametros = 16, RULE_initAttrList = 17, RULE_initAttr = 18, RULE_tiposD = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "funcionDcl", "parametrosF", "structDcl", 
			"atriBody", "structFunc", "sliceDcl", "dimension", "slcParam", "statement", 
			"forInit", "caseStmt", "expr", "call", "parametros", "initAttrList", 
			"initAttr", "tiposD"
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
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747324458093252618L) != 0)) {
				{
				{
				setState(40);
				dcl();
				}
				}
				setState(45);
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
		public SliceDclContext sliceDcl() {
			return getRuleContext(SliceDclContext.class,0);
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
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				funcionDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(48);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(49);
				structDcl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				structFunc();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(51);
				sliceDcl();
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
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new VarDclStructContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				match(VAR);
				setState(55);
				match(ID);
				setState(56);
				match(ID);
				setState(57);
				match(SEMICOLON);
				}
				break;
			case 2:
				_localctx = new VarDcl1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(VAR);
				setState(59);
				match(ID);
				setState(60);
				tiposD();
				setState(61);
				match(IGUAL);
				setState(62);
				expr(0);
				setState(63);
				match(SEMICOLON);
				}
				break;
			case 3:
				_localctx = new VarDcl2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
				match(VAR);
				setState(66);
				match(ID);
				setState(67);
				tiposD();
				setState(68);
				match(SEMICOLON);
				}
				break;
			case 4:
				_localctx = new VarDcl3Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				match(ID);
				setState(71);
				match(DCLIMPL);
				setState(72);
				expr(0);
				setState(73);
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
			setState(77);
			match(STFUNC);
			setState(78);
			match(ID);
			setState(79);
			match(LPAREN);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(80);
				parametrosF();
				}
			}

			setState(83);
			match(RPAREN);
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 558446353793941504L) != 0)) {
				{
				setState(84);
				tiposD();
				}
			}

			setState(87);
			match(LBRACE);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747324458093252618L) != 0)) {
				{
				{
				setState(88);
				dcl();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
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
			setState(96);
			match(ID);
			setState(97);
			tiposD();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(98);
				match(COMMA);
				setState(99);
				match(ID);
				setState(100);
				tiposD();
				}
				}
				setState(105);
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
			setState(106);
			match(STTYPE);
			setState(107);
			match(ID);
			setState(108);
			match(STRUCT);
			setState(109);
			match(LBRACE);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(110);
				atriBody();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
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
			setState(118);
			match(ID);
			setState(121);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T_INT:
			case T_FLOAT:
			case T_STR:
			case T_BOOL:
			case T_RUNE:
				{
				setState(119);
				tiposD();
				}
				break;
			case ID:
				{
				setState(120);
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
			setState(123);
			match(STFUNC);
			setState(124);
			match(LPAREN);
			setState(125);
			match(ID);
			setState(126);
			match(ID);
			setState(127);
			match(RPAREN);
			setState(128);
			match(ID);
			setState(129);
			match(LPAREN);
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(130);
				parametrosF();
				}
			}

			setState(133);
			match(RPAREN);
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 558446353793941504L) != 0)) {
				{
				setState(134);
				tiposD();
				}
			}

			setState(137);
			match(LBRACE);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747324458093252618L) != 0)) {
				{
				{
				setState(138);
				dcl();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
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
	public static class SliceDclContext extends ParserRuleContext {
		public SliceDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceDcl; }
	 
		public SliceDclContext() { }
		public void copyFrom(SliceDclContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SlcDcl2Context extends SliceDclContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode DCLIMPL() { return getToken(LanguageParser.DCLIMPL, 0); }
		public DimensionContext dimension() {
			return getRuleContext(DimensionContext.class,0);
		}
		public TiposDContext tiposD() {
			return getRuleContext(TiposDContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(LanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LanguageParser.RBRACE, 0); }
		public List<SlcParamContext> slcParam() {
			return getRuleContexts(SlcParamContext.class);
		}
		public SlcParamContext slcParam(int i) {
			return getRuleContext(SlcParamContext.class,i);
		}
		public SlcDcl2Context(SliceDclContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SlcDcl1Context extends SliceDclContext {
		public TerminalNode VAR() { return getToken(LanguageParser.VAR, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public DimensionContext dimension() {
			return getRuleContext(DimensionContext.class,0);
		}
		public TiposDContext tiposD() {
			return getRuleContext(TiposDContext.class,0);
		}
		public SlcDcl1Context(SliceDclContext ctx) { copyFrom(ctx); }
	}

	public final SliceDclContext sliceDcl() throws RecognitionException {
		SliceDclContext _localctx = new SliceDclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sliceDcl);
		int _la;
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new SlcDcl1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				match(VAR);
				setState(147);
				match(ID);
				setState(148);
				dimension();
				setState(149);
				tiposD();
				}
				break;
			case ID:
				_localctx = new SlcDcl2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(151);
				match(ID);
				setState(152);
				match(DCLIMPL);
				setState(153);
				dimension();
				setState(154);
				tiposD();
				setState(155);
				match(LBRACE);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747115181516787722L) != 0)) {
					{
					{
					setState(156);
					slcParam();
					}
					}
					setState(161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(162);
				match(RBRACE);
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
	public static class DimensionContext extends ParserRuleContext {
		public List<TerminalNode> LBRACKET() { return getTokens(LanguageParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(LanguageParser.LBRACKET, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(LanguageParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(LanguageParser.RBRACKET, i);
		}
		public DimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimension; }
	}

	public final DimensionContext dimension() throws RecognitionException {
		DimensionContext _localctx = new DimensionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dimension);
		try {
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				match(LBRACKET);
				setState(167);
				match(RBRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(LBRACKET);
				setState(169);
				match(RBRACKET);
				setState(170);
				match(LBRACKET);
				setState(171);
				match(RBRACKET);
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
	public static class SlcParamContext extends ParserRuleContext {
		public List<ParametrosContext> parametros() {
			return getRuleContexts(ParametrosContext.class);
		}
		public ParametrosContext parametros(int i) {
			return getRuleContext(ParametrosContext.class,i);
		}
		public TerminalNode LBRACE() { return getToken(LanguageParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(LanguageParser.RBRACE, 0); }
		public TerminalNode COMMA() { return getToken(LanguageParser.COMMA, 0); }
		public SlcParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slcParam; }
	}

	public final SlcParamContext slcParam() throws RecognitionException {
		SlcParamContext _localctx = new SlcParamContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_slcParam);
		int _la;
		try {
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case MENOS:
			case NOT:
			case NUEVO:
			case INT:
			case FLOAT:
			case STRING:
			case BOOL:
			case RUNE:
			case V_NULO:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				parametros();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(175);
				match(LBRACE);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747115181516787714L) != 0)) {
					{
					{
					setState(176);
					parametros();
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(182);
				match(RBRACE);
				setState(183);
				match(COMMA);
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
		enterRule(_localctx, 22, RULE_statement);
		int _la;
		try {
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				expr(0);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(187);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 2:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(FMT);
				setState(191);
				match(DOT);
				setState(192);
				match(PRINT);
				setState(193);
				match(LPAREN);
				setState(194);
				expr(0);
				setState(195);
				match(RPAREN);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(196);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 3:
				_localctx = new BloqueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				match(LBRACE);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747324458093252618L) != 0)) {
					{
					{
					setState(200);
					dcl();
					}
					}
					setState(205);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(206);
				match(RBRACE);
				}
				break;
			case 4:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(207);
				match(IF);
				setState(209);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(208);
					match(LPAREN);
					}
					break;
				}
				setState(211);
				expr(0);
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(212);
					match(RPAREN);
					}
				}

				setState(215);
				statement();
				setState(218);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(216);
					match(ELSE);
					setState(217);
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
				setState(220);
				match(SWITCH);
				setState(221);
				expr(0);
				setState(222);
				match(LBRACE);
				setState(224); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(223);
					caseStmt();
					}
					}
					setState(226); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CASE || _la==DEFAUL );
				setState(228);
				match(RBRACE);
				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(230);
				match(FOR);
				setState(232);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(231);
					match(LPAREN);
					}
					break;
				}
				setState(234);
				expr(0);
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(235);
					match(RPAREN);
					}
				}

				setState(238);
				statement();
				}
				break;
			case 7:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(240);
				match(FOR);
				setState(242);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(241);
					match(LPAREN);
					}
					break;
				}
				setState(244);
				forInit();
				setState(245);
				expr(0);
				setState(246);
				match(SEMICOLON);
				setState(247);
				expr(0);
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(248);
					match(RPAREN);
					}
				}

				setState(251);
				statement();
				}
				break;
			case 8:
				_localctx = new ST_breakContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(253);
				match(STBREAK);
				setState(255);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(254);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 9:
				_localctx = new ST_continueContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(257);
				match(STCONTINUE);
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(258);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 10:
				_localctx = new ST_returnContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(261);
				match(STRETURN);
				setState(263);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(262);
					expr(0);
					}
					break;
				}
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(265);
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
		enterRule(_localctx, 24, RULE_forInit);
		try {
			setState(274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(270);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(271);
				expr(0);
				setState(272);
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
		enterRule(_localctx, 26, RULE_caseStmt);
		int _la;
		try {
			setState(293);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				_localctx = new CaseNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(276);
				match(CASE);
				setState(277);
				expr(0);
				setState(278);
				match(COLON);
				setState(282);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747324458093252618L) != 0)) {
					{
					{
					setState(279);
					dcl();
					}
					}
					setState(284);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DEFAUL:
				_localctx = new CaseDefaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(DEFAUL);
				setState(286);
				match(COLON);
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747324458093252618L) != 0)) {
					{
					{
					setState(287);
					dcl();
					}
					}
					setState(292);
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
	public static class SliceContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TerminalNode IGUAL() { return getToken(LanguageParser.IGUAL, 0); }
		public DimensionContext dimension() {
			return getRuleContext(DimensionContext.class,0);
		}
		public TiposDContext tiposD() {
			return getRuleContext(TiposDContext.class,0);
		}
		public List<TerminalNode> LBRACE() { return getTokens(LanguageParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(LanguageParser.LBRACE, i);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public SliceContext(ExprContext ctx) { copyFrom(ctx); }
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				_localctx = new NegateUContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(296);
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
				setState(297);
				expr(21);
				}
				break;
			case 2:
				{
				_localctx = new UpdateVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298);
				match(ID);
				setState(299);
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
				setState(300);
				match(ID);
				setState(301);
				match(DCLIMPL);
				setState(302);
				match(ID);
				setState(303);
				match(LBRACE);
				setState(304);
				initAttrList();
				setState(305);
				match(RBRACE);
				}
				break;
			case 4:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(307);
				match(INT);
				}
				break;
			case 5:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(308);
				match(FLOAT);
				}
				break;
			case 6:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(309);
				match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(310);
				match(BOOL);
				}
				break;
			case 8:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(311);
				match(RUNE);
				}
				break;
			case 9:
				{
				_localctx = new ValorNuloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(312);
				match(V_NULO);
				}
				break;
			case 10:
				{
				_localctx = new SliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(313);
				match(ID);
				setState(314);
				match(IGUAL);
				setState(315);
				dimension();
				setState(316);
				tiposD();
				setState(317);
				match(LBRACE);
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747115181516787714L) != 0)) {
					{
					setState(318);
					parametros();
					}
				}

				setState(321);
				match(LBRACE);
				}
				break;
			case 11:
				{
				_localctx = new NewInstanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(323);
				match(NUEVO);
				setState(324);
				match(ID);
				setState(325);
				match(LPAREN);
				setState(327);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747115181516787714L) != 0)) {
					{
					setState(326);
					parametros();
					}
				}

				setState(329);
				match(RPAREN);
				}
				break;
			case 12:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(330);
				match(ID);
				}
				break;
			case 13:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(331);
				match(LPAREN);
				setState(332);
				expr(0);
				setState(333);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(366);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(364);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(337);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(338);
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
						setState(339);
						expr(20);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(340);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(341);
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
						setState(342);
						expr(19);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(343);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(344);
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
						setState(345);
						expr(18);
						}
						break;
					case 4:
						{
						_localctx = new ComparationContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(346);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(347);
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
						setState(348);
						expr(17);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(349);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(350);
						match(AND);
						setState(351);
						expr(16);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(352);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(353);
						match(OR);
						setState(354);
						expr(15);
						}
						break;
					case 7:
						{
						_localctx = new AssignVarContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(355);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(356);
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
						setState(357);
						expr(14);
						}
						break;
					case 8:
						{
						_localctx = new LlamadaContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(358);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(360); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(359);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(362); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(368);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
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
	public static class AccesoSliceContext extends CallContext {
		public TerminalNode LBRACKET() { return getToken(LanguageParser.LBRACKET, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACKET() { return getToken(LanguageParser.RBRACKET, 0); }
		public AccesoSliceContext(CallContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GetAtrContext extends CallContext {
		public TerminalNode DOT() { return getToken(LanguageParser.DOT, 0); }
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public GetAtrContext(CallContext ctx) { copyFrom(ctx); }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_call);
		int _la;
		try {
			setState(380);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(369);
				match(LPAREN);
				setState(371);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1747115181516787714L) != 0)) {
					{
					setState(370);
					parametros();
					}
				}

				setState(373);
				match(RPAREN);
				}
				break;
			case DOT:
				_localctx = new GetAtrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(374);
				match(DOT);
				setState(375);
				match(ID);
				}
				break;
			case LBRACKET:
				_localctx = new AccesoSliceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(376);
				match(LBRACKET);
				setState(377);
				expr(0);
				setState(378);
				match(RBRACKET);
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
		enterRule(_localctx, 32, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			expr(0);
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(383);
				match(COMMA);
				setState(384);
				expr(0);
				}
				}
				setState(389);
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
		enterRule(_localctx, 34, RULE_initAttrList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			initAttr();
			setState(391);
			match(COMMA);
			setState(397);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(392);
				initAttr();
				setState(393);
				match(COMMA);
				}
				}
				setState(399);
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
		enterRule(_localctx, 36, RULE_initAttr);
		try {
			setState(410);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				_localctx = new InitAttrExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				match(ID);
				setState(401);
				match(COLON);
				setState(402);
				expr(0);
				}
				break;
			case 2:
				_localctx = new InitAttrStructContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(403);
				match(ID);
				setState(404);
				match(COLON);
				setState(405);
				match(ID);
				setState(406);
				match(LBRACE);
				setState(407);
				initAttrList();
				setState(408);
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
		enterRule(_localctx, 38, RULE_tiposD);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
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
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		case 7:
			return precpred(_ctx, 20);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001?\u019f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u00015\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0003\u0002L\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003R\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003V\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003Z\b\u0003\n\u0003\f\u0003]\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004f\b\u0004\n\u0004\f\u0004i\t\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005p\b\u0005\n\u0005"+
		"\f\u0005s\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006z\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0084"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0088\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007\u008c\b\u0007\n\u0007\f\u0007\u008f\t\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u009e\b\b\n\b\f\b\u00a1\t\b"+
		"\u0001\b\u0001\b\u0003\b\u00a5\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u00ad\b\t\u0001\n\u0001\n\u0001\n\u0005\n\u00b2\b\n"+
		"\n\n\f\n\u00b5\t\n\u0001\n\u0001\n\u0003\n\u00b9\b\n\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00bd\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00c6\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u00ca\b\u000b\n\u000b\f\u000b\u00cd\t\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00d2\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00d6\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u00db\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0004\u000b\u00e1\b\u000b\u000b\u000b\f\u000b\u00e2\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00e9\b\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00ed\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u00f3\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00fa\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u0100\b\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u0104\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0108\b\u000b"+
		"\u0001\u000b\u0003\u000b\u010b\b\u000b\u0003\u000b\u010d\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0003\f\u0113\b\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u0119\b\r\n\r\f\r\u011c\t\r\u0001\r\u0001\r\u0001\r\u0005\r"+
		"\u0121\b\r\n\r\f\r\u0124\t\r\u0003\r\u0126\b\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0140\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u0148\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u0150\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0004\u000e\u0169\b\u000e\u000b\u000e"+
		"\f\u000e\u016a\u0005\u000e\u016d\b\u000e\n\u000e\f\u000e\u0170\t\u000e"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u0174\b\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u017d\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0182\b"+
		"\u0010\n\u0010\f\u0010\u0185\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u018c\b\u0011\n\u0011\f\u0011\u018f"+
		"\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u019b"+
		"\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0000\u0001\u001c\u0014\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&\u0000\b\u0002\u0000\f\f\u001e\u001e\u0001\u0000\u0013\u0014"+
		"\u0002\u0000\r\r\u000f\u0010\u0001\u0000\u000b\f\u0001\u0000\u0018\u001b"+
		"\u0001\u0000\u0016\u0017\u0002\u0000\u0011\u0012\u0015\u0015\u0001\u0000"+
		"6:\u01da\u0000+\u0001\u0000\u0000\u0000\u00024\u0001\u0000\u0000\u0000"+
		"\u0004K\u0001\u0000\u0000\u0000\u0006M\u0001\u0000\u0000\u0000\b`\u0001"+
		"\u0000\u0000\u0000\nj\u0001\u0000\u0000\u0000\fv\u0001\u0000\u0000\u0000"+
		"\u000e{\u0001\u0000\u0000\u0000\u0010\u00a4\u0001\u0000\u0000\u0000\u0012"+
		"\u00ac\u0001\u0000\u0000\u0000\u0014\u00b8\u0001\u0000\u0000\u0000\u0016"+
		"\u010c\u0001\u0000\u0000\u0000\u0018\u0112\u0001\u0000\u0000\u0000\u001a"+
		"\u0125\u0001\u0000\u0000\u0000\u001c\u014f\u0001\u0000\u0000\u0000\u001e"+
		"\u017c\u0001\u0000\u0000\u0000 \u017e\u0001\u0000\u0000\u0000\"\u0186"+
		"\u0001\u0000\u0000\u0000$\u019a\u0001\u0000\u0000\u0000&\u019c\u0001\u0000"+
		"\u0000\u0000(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000*-\u0001"+
		"\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000"+
		",\u0001\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000.5\u0003\u0004"+
		"\u0002\u0000/5\u0003\u0006\u0003\u000005\u0003\u0016\u000b\u000015\u0003"+
		"\n\u0005\u000025\u0003\u000e\u0007\u000035\u0003\u0010\b\u00004.\u0001"+
		"\u0000\u0000\u00004/\u0001\u0000\u0000\u000040\u0001\u0000\u0000\u0000"+
		"41\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000043\u0001\u0000\u0000"+
		"\u00005\u0003\u0001\u0000\u0000\u000067\u0005\"\u0000\u000078\u0005<\u0000"+
		"\u000089\u0005<\u0000\u00009L\u0005\u0007\u0000\u0000:;\u0005\"\u0000"+
		"\u0000;<\u0005<\u0000\u0000<=\u0003&\u0013\u0000=>\u0005\u0015\u0000\u0000"+
		">?\u0003\u001c\u000e\u0000?@\u0005\u0007\u0000\u0000@L\u0001\u0000\u0000"+
		"\u0000AB\u0005\"\u0000\u0000BC\u0005<\u0000\u0000CD\u0003&\u0013\u0000"+
		"DE\u0005\u0007\u0000\u0000EL\u0001\u0000\u0000\u0000FG\u0005<\u0000\u0000"+
		"GH\u0005#\u0000\u0000HI\u0003\u001c\u000e\u0000IJ\u0005\u0007\u0000\u0000"+
		"JL\u0001\u0000\u0000\u0000K6\u0001\u0000\u0000\u0000K:\u0001\u0000\u0000"+
		"\u0000KA\u0001\u0000\u0000\u0000KF\u0001\u0000\u0000\u0000L\u0005\u0001"+
		"\u0000\u0000\u0000MN\u0005-\u0000\u0000NO\u0005<\u0000\u0000OQ\u0005\u0001"+
		"\u0000\u0000PR\u0003\b\u0004\u0000QP\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000SU\u0005\u0002\u0000\u0000TV\u0003"+
		"&\u0013\u0000UT\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000VW\u0001"+
		"\u0000\u0000\u0000W[\u0005\u0003\u0000\u0000XZ\u0003\u0002\u0001\u0000"+
		"YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000[\\\u0001\u0000\u0000\u0000\\^\u0001\u0000\u0000\u0000][\u0001\u0000"+
		"\u0000\u0000^_\u0005\u0004\u0000\u0000_\u0007\u0001\u0000\u0000\u0000"+
		"`a\u0005<\u0000\u0000ag\u0003&\u0013\u0000bc\u0005\n\u0000\u0000cd\u0005"+
		"<\u0000\u0000df\u0003&\u0013\u0000eb\u0001\u0000\u0000\u0000fi\u0001\u0000"+
		"\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\t\u0001"+
		"\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jk\u0005/\u0000\u0000kl\u0005"+
		"<\u0000\u0000lm\u0005.\u0000\u0000mq\u0005\u0003\u0000\u0000np\u0003\f"+
		"\u0006\u0000on\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000\u0000qo\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rt\u0001\u0000\u0000\u0000"+
		"sq\u0001\u0000\u0000\u0000tu\u0005\u0004\u0000\u0000u\u000b\u0001\u0000"+
		"\u0000\u0000vy\u0005<\u0000\u0000wz\u0003&\u0013\u0000xz\u0005<\u0000"+
		"\u0000yw\u0001\u0000\u0000\u0000yx\u0001\u0000\u0000\u0000z\r\u0001\u0000"+
		"\u0000\u0000{|\u0005-\u0000\u0000|}\u0005\u0001\u0000\u0000}~\u0005<\u0000"+
		"\u0000~\u007f\u0005<\u0000\u0000\u007f\u0080\u0005\u0002\u0000\u0000\u0080"+
		"\u0081\u0005<\u0000\u0000\u0081\u0083\u0005\u0001\u0000\u0000\u0082\u0084"+
		"\u0003\b\u0004\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0083\u0084\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0001\u0000\u0000\u0000\u0085\u0087\u0005"+
		"\u0002\u0000\u0000\u0086\u0088\u0003&\u0013\u0000\u0087\u0086\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000"+
		"\u0000\u0000\u0089\u008d\u0005\u0003\u0000\u0000\u008a\u008c\u0003\u0002"+
		"\u0001\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000"+
		"\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\u0090\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0005\u0004\u0000\u0000\u0091\u000f\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0005\"\u0000\u0000\u0093\u0094\u0005<\u0000"+
		"\u0000\u0094\u0095\u0003\u0012\t\u0000\u0095\u0096\u0003&\u0013\u0000"+
		"\u0096\u00a5\u0001\u0000\u0000\u0000\u0097\u0098\u0005<\u0000\u0000\u0098"+
		"\u0099\u0005#\u0000\u0000\u0099\u009a\u0003\u0012\t\u0000\u009a\u009b"+
		"\u0003&\u0013\u0000\u009b\u009f\u0005\u0003\u0000\u0000\u009c\u009e\u0003"+
		"\u0014\n\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u00a1\u0001\u0000"+
		"\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a2\u0001\u0000\u0000\u0000\u00a1\u009f\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0005\u0004\u0000\u0000\u00a3\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a4\u0092\u0001\u0000\u0000\u0000\u00a4\u0097\u0001\u0000"+
		"\u0000\u0000\u00a5\u0011\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u0005"+
		"\u0000\u0000\u00a7\u00ad\u0005\u0006\u0000\u0000\u00a8\u00a9\u0005\u0005"+
		"\u0000\u0000\u00a9\u00aa\u0005\u0006\u0000\u0000\u00aa\u00ab\u0005\u0005"+
		"\u0000\u0000\u00ab\u00ad\u0005\u0006\u0000\u0000\u00ac\u00a6\u0001\u0000"+
		"\u0000\u0000\u00ac\u00a8\u0001\u0000\u0000\u0000\u00ad\u0013\u0001\u0000"+
		"\u0000\u0000\u00ae\u00b9\u0003 \u0010\u0000\u00af\u00b3\u0005\u0003\u0000"+
		"\u0000\u00b0\u00b2\u0003 \u0010\u0000\u00b1\u00b0\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u0004\u0000\u0000"+
		"\u00b7\u00b9\u0005\n\u0000\u0000\u00b8\u00ae\u0001\u0000\u0000\u0000\u00b8"+
		"\u00af\u0001\u0000\u0000\u0000\u00b9\u0015\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bc\u0003\u001c\u000e\u0000\u00bb\u00bd\u0005\u0007\u0000\u0000\u00bc"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd"+
		"\u010d\u0001\u0000\u0000\u0000\u00be\u00bf\u0005!\u0000\u0000\u00bf\u00c0"+
		"\u0005\b\u0000\u0000\u00c0\u00c1\u0005 \u0000\u0000\u00c1\u00c2\u0005"+
		"\u0001\u0000\u0000\u00c2\u00c3\u0003\u001c\u000e\u0000\u00c3\u00c5\u0005"+
		"\u0002\u0000\u0000\u00c4\u00c6\u0005\u0007\u0000\u0000\u00c5\u00c4\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u010d\u0001"+
		"\u0000\u0000\u0000\u00c7\u00cb\u0005\u0003\u0000\u0000\u00c8\u00ca\u0003"+
		"\u0002\u0001\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001"+
		"\u0000\u0000\u0000\u00cc\u00ce\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001"+
		"\u0000\u0000\u0000\u00ce\u010d\u0005\u0004\u0000\u0000\u00cf\u00d1\u0005"+
		"$\u0000\u0000\u00d0\u00d2\u0005\u0001\u0000\u0000\u00d1\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000"+
		"\u0000\u0000\u00d3\u00d5\u0003\u001c\u000e\u0000\u00d4\u00d6\u0005\u0002"+
		"\u0000\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00da\u0003\u0016"+
		"\u000b\u0000\u00d8\u00d9\u0005%\u0000\u0000\u00d9\u00db\u0003\u0016\u000b"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00da\u00db\u0001\u0000\u0000"+
		"\u0000\u00db\u010d\u0001\u0000\u0000\u0000\u00dc\u00dd\u0005&\u0000\u0000"+
		"\u00dd\u00de\u0003\u001c\u000e\u0000\u00de\u00e0\u0005\u0003\u0000\u0000"+
		"\u00df\u00e1\u0003\u001a\r\u0000\u00e0\u00df\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e5\u0005\u0004\u0000\u0000\u00e5\u010d\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e8\u0005)\u0000\u0000\u00e7\u00e9\u0005\u0001\u0000\u0000\u00e8\u00e7"+
		"\u0001\u0000\u0000\u0000\u00e8\u00e9\u0001\u0000\u0000\u0000\u00e9\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ea\u00ec\u0003\u001c\u000e\u0000\u00eb\u00ed"+
		"\u0005\u0002\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ec\u00ed"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0003\u0016\u000b\u0000\u00ef\u010d\u0001\u0000\u0000\u0000\u00f0\u00f2"+
		"\u0005)\u0000\u0000\u00f1\u00f3\u0005\u0001\u0000\u0000\u00f2\u00f1\u0001"+
		"\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001"+
		"\u0000\u0000\u0000\u00f4\u00f5\u0003\u0018\f\u0000\u00f5\u00f6\u0003\u001c"+
		"\u000e\u0000\u00f6\u00f7\u0005\u0007\u0000\u0000\u00f7\u00f9\u0003\u001c"+
		"\u000e\u0000\u00f8\u00fa\u0005\u0002\u0000\u0000\u00f9\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fb\u00fc\u0003\u0016\u000b\u0000\u00fc\u010d\u0001\u0000"+
		"\u0000\u0000\u00fd\u00ff\u0005*\u0000\u0000\u00fe\u0100\u0005\u0007\u0000"+
		"\u0000\u00ff\u00fe\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000"+
		"\u0000\u0100\u010d\u0001\u0000\u0000\u0000\u0101\u0103\u0005+\u0000\u0000"+
		"\u0102\u0104\u0005\u0007\u0000\u0000\u0103\u0102\u0001\u0000\u0000\u0000"+
		"\u0103\u0104\u0001\u0000\u0000\u0000\u0104\u010d\u0001\u0000\u0000\u0000"+
		"\u0105\u0107\u0005,\u0000\u0000\u0106\u0108\u0003\u001c\u000e\u0000\u0107"+
		"\u0106\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000\u0000\u0108"+
		"\u010a\u0001\u0000\u0000\u0000\u0109\u010b\u0005\u0007\u0000\u0000\u010a"+
		"\u0109\u0001\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b"+
		"\u010d\u0001\u0000\u0000\u0000\u010c\u00ba\u0001\u0000\u0000\u0000\u010c"+
		"\u00be\u0001\u0000\u0000\u0000\u010c\u00c7\u0001\u0000\u0000\u0000\u010c"+
		"\u00cf\u0001\u0000\u0000\u0000\u010c\u00dc\u0001\u0000\u0000\u0000\u010c"+
		"\u00e6\u0001\u0000\u0000\u0000\u010c\u00f0\u0001\u0000\u0000\u0000\u010c"+
		"\u00fd\u0001\u0000\u0000\u0000\u010c\u0101\u0001\u0000\u0000\u0000\u010c"+
		"\u0105\u0001\u0000\u0000\u0000\u010d\u0017\u0001\u0000\u0000\u0000\u010e"+
		"\u0113\u0003\u0004\u0002\u0000\u010f\u0110\u0003\u001c\u000e\u0000\u0110"+
		"\u0111\u0005\u0007\u0000\u0000\u0111\u0113\u0001\u0000\u0000\u0000\u0112"+
		"\u010e\u0001\u0000\u0000\u0000\u0112\u010f\u0001\u0000\u0000\u0000\u0113"+
		"\u0019\u0001\u0000\u0000\u0000\u0114\u0115\u0005\'\u0000\u0000\u0115\u0116"+
		"\u0003\u001c\u000e\u0000\u0116\u011a\u0005\t\u0000\u0000\u0117\u0119\u0003"+
		"\u0002\u0001\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0119\u011c\u0001"+
		"\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001"+
		"\u0000\u0000\u0000\u011b\u0126\u0001\u0000\u0000\u0000\u011c\u011a\u0001"+
		"\u0000\u0000\u0000\u011d\u011e\u0005(\u0000\u0000\u011e\u0122\u0005\t"+
		"\u0000\u0000\u011f\u0121\u0003\u0002\u0001\u0000\u0120\u011f\u0001\u0000"+
		"\u0000\u0000\u0121\u0124\u0001\u0000\u0000\u0000\u0122\u0120\u0001\u0000"+
		"\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0126\u0001\u0000"+
		"\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0125\u0114\u0001\u0000"+
		"\u0000\u0000\u0125\u011d\u0001\u0000\u0000\u0000\u0126\u001b\u0001\u0000"+
		"\u0000\u0000\u0127\u0128\u0006\u000e\uffff\uffff\u0000\u0128\u0129\u0007"+
		"\u0000\u0000\u0000\u0129\u0150\u0003\u001c\u000e\u0015\u012a\u012b\u0005"+
		"<\u0000\u0000\u012b\u0150\u0007\u0001\u0000\u0000\u012c\u012d\u0005<\u0000"+
		"\u0000\u012d\u012e\u0005#\u0000\u0000\u012e\u012f\u0005<\u0000\u0000\u012f"+
		"\u0130\u0005\u0003\u0000\u0000\u0130\u0131\u0003\"\u0011\u0000\u0131\u0132"+
		"\u0005\u0004\u0000\u0000\u0132\u0150\u0001\u0000\u0000\u0000\u0133\u0150"+
		"\u00051\u0000\u0000\u0134\u0150\u00052\u0000\u0000\u0135\u0150\u00053"+
		"\u0000\u0000\u0136\u0150\u00054\u0000\u0000\u0137\u0150\u00055\u0000\u0000"+
		"\u0138\u0150\u0005;\u0000\u0000\u0139\u013a\u0005<\u0000\u0000\u013a\u013b"+
		"\u0005\u0015\u0000\u0000\u013b\u013c\u0003\u0012\t\u0000\u013c\u013d\u0003"+
		"&\u0013\u0000\u013d\u013f\u0005\u0003\u0000\u0000\u013e\u0140\u0003 \u0010"+
		"\u0000\u013f\u013e\u0001\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000"+
		"\u0000\u0140\u0141\u0001\u0000\u0000\u0000\u0141\u0142\u0005\u0003\u0000"+
		"\u0000\u0142\u0150\u0001\u0000\u0000\u0000\u0143\u0144\u00050\u0000\u0000"+
		"\u0144\u0145\u0005<\u0000\u0000\u0145\u0147\u0005\u0001\u0000\u0000\u0146"+
		"\u0148\u0003 \u0010\u0000\u0147\u0146\u0001\u0000\u0000\u0000\u0147\u0148"+
		"\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149\u0150"+
		"\u0005\u0002\u0000\u0000\u014a\u0150\u0005<\u0000\u0000\u014b\u014c\u0005"+
		"\u0001\u0000\u0000\u014c\u014d\u0003\u001c\u000e\u0000\u014d\u014e\u0005"+
		"\u0002\u0000\u0000\u014e\u0150\u0001\u0000\u0000\u0000\u014f\u0127\u0001"+
		"\u0000\u0000\u0000\u014f\u012a\u0001\u0000\u0000\u0000\u014f\u012c\u0001"+
		"\u0000\u0000\u0000\u014f\u0133\u0001\u0000\u0000\u0000\u014f\u0134\u0001"+
		"\u0000\u0000\u0000\u014f\u0135\u0001\u0000\u0000\u0000\u014f\u0136\u0001"+
		"\u0000\u0000\u0000\u014f\u0137\u0001\u0000\u0000\u0000\u014f\u0138\u0001"+
		"\u0000\u0000\u0000\u014f\u0139\u0001\u0000\u0000\u0000\u014f\u0143\u0001"+
		"\u0000\u0000\u0000\u014f\u014a\u0001\u0000\u0000\u0000\u014f\u014b\u0001"+
		"\u0000\u0000\u0000\u0150\u016e\u0001\u0000\u0000\u0000\u0151\u0152\n\u0013"+
		"\u0000\u0000\u0152\u0153\u0007\u0002\u0000\u0000\u0153\u016d\u0003\u001c"+
		"\u000e\u0014\u0154\u0155\n\u0012\u0000\u0000\u0155\u0156\u0007\u0003\u0000"+
		"\u0000\u0156\u016d\u0003\u001c\u000e\u0013\u0157\u0158\n\u0011\u0000\u0000"+
		"\u0158\u0159\u0007\u0004\u0000\u0000\u0159\u016d\u0003\u001c\u000e\u0012"+
		"\u015a\u015b\n\u0010\u0000\u0000\u015b\u015c\u0007\u0005\u0000\u0000\u015c"+
		"\u016d\u0003\u001c\u000e\u0011\u015d\u015e\n\u000f\u0000\u0000\u015e\u015f"+
		"\u0005\u001d\u0000\u0000\u015f\u016d\u0003\u001c\u000e\u0010\u0160\u0161"+
		"\n\u000e\u0000\u0000\u0161\u0162\u0005\u001c\u0000\u0000\u0162\u016d\u0003"+
		"\u001c\u000e\u000f\u0163\u0164\n\r\u0000\u0000\u0164\u0165\u0007\u0006"+
		"\u0000\u0000\u0165\u016d\u0003\u001c\u000e\u000e\u0166\u0168\n\u0014\u0000"+
		"\u0000\u0167\u0169\u0003\u001e\u000f\u0000\u0168\u0167\u0001\u0000\u0000"+
		"\u0000\u0169\u016a\u0001\u0000\u0000\u0000\u016a\u0168\u0001\u0000\u0000"+
		"\u0000\u016a\u016b\u0001\u0000\u0000\u0000\u016b\u016d\u0001\u0000\u0000"+
		"\u0000\u016c\u0151\u0001\u0000\u0000\u0000\u016c\u0154\u0001\u0000\u0000"+
		"\u0000\u016c\u0157\u0001\u0000\u0000\u0000\u016c\u015a\u0001\u0000\u0000"+
		"\u0000\u016c\u015d\u0001\u0000\u0000\u0000\u016c\u0160\u0001\u0000\u0000"+
		"\u0000\u016c\u0163\u0001\u0000\u0000\u0000\u016c\u0166\u0001\u0000\u0000"+
		"\u0000\u016d\u0170\u0001\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000"+
		"\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u001d\u0001\u0000\u0000"+
		"\u0000\u0170\u016e\u0001\u0000\u0000\u0000\u0171\u0173\u0005\u0001\u0000"+
		"\u0000\u0172\u0174\u0003 \u0010\u0000\u0173\u0172\u0001\u0000\u0000\u0000"+
		"\u0173\u0174\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000"+
		"\u0175\u017d\u0005\u0002\u0000\u0000\u0176\u0177\u0005\b\u0000\u0000\u0177"+
		"\u017d\u0005<\u0000\u0000\u0178\u0179\u0005\u0005\u0000\u0000\u0179\u017a"+
		"\u0003\u001c\u000e\u0000\u017a\u017b\u0005\u0006\u0000\u0000\u017b\u017d"+
		"\u0001\u0000\u0000\u0000\u017c\u0171\u0001\u0000\u0000\u0000\u017c\u0176"+
		"\u0001\u0000\u0000\u0000\u017c\u0178\u0001\u0000\u0000\u0000\u017d\u001f"+
		"\u0001\u0000\u0000\u0000\u017e\u0183\u0003\u001c\u000e\u0000\u017f\u0180"+
		"\u0005\n\u0000\u0000\u0180\u0182\u0003\u001c\u000e\u0000\u0181\u017f\u0001"+
		"\u0000\u0000\u0000\u0182\u0185\u0001\u0000\u0000\u0000\u0183\u0181\u0001"+
		"\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184!\u0001\u0000"+
		"\u0000\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0186\u0187\u0003$\u0012"+
		"\u0000\u0187\u018d\u0005\n\u0000\u0000\u0188\u0189\u0003$\u0012\u0000"+
		"\u0189\u018a\u0005\n\u0000\u0000\u018a\u018c\u0001\u0000\u0000\u0000\u018b"+
		"\u0188\u0001\u0000\u0000\u0000\u018c\u018f\u0001\u0000\u0000\u0000\u018d"+
		"\u018b\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018e"+
		"#\u0001\u0000\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u0190\u0191"+
		"\u0005<\u0000\u0000\u0191\u0192\u0005\t\u0000\u0000\u0192\u019b\u0003"+
		"\u001c\u000e\u0000\u0193\u0194\u0005<\u0000\u0000\u0194\u0195\u0005\t"+
		"\u0000\u0000\u0195\u0196\u0005<\u0000\u0000\u0196\u0197\u0005\u0003\u0000"+
		"\u0000\u0197\u0198\u0003\"\u0011\u0000\u0198\u0199\u0005\u0004\u0000\u0000"+
		"\u0199\u019b\u0001\u0000\u0000\u0000\u019a\u0190\u0001\u0000\u0000\u0000"+
		"\u019a\u0193\u0001\u0000\u0000\u0000\u019b%\u0001\u0000\u0000\u0000\u019c"+
		"\u019d\u0007\u0007\u0000\u0000\u019d\'\u0001\u0000\u0000\u00000+4KQU["+
		"gqy\u0083\u0087\u008d\u009f\u00a4\u00ac\u00b3\u00b8\u00bc\u00c5\u00cb"+
		"\u00d1\u00d5\u00da\u00e2\u00e8\u00ec\u00f2\u00f9\u00ff\u0103\u0107\u010a"+
		"\u010c\u0112\u011a\u0122\u0125\u013f\u0147\u014f\u016a\u016c\u016e\u0173"+
		"\u017c\u0183\u018d\u019a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}