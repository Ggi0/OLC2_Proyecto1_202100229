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
		ELSE=37, SWITCH=38, CASE=39, DEFAUL=40, FOR=41, RANGE=42, STBREAK=43, 
		STCONTINUE=44, STRETURN=45, STFUNC=46, STRUCT=47, STTYPE=48, NUEVO=49, 
		INT=50, FLOAT=51, STRING=52, BOOL=53, RUNE=54, T_INT=55, T_FLOAT=56, T_STR=57, 
		T_BOOL=58, T_RUNE=59, V_NULO=60, ID=61, WS=62, COMENT=63, MCOMENT=64;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_funcionDcl = 3, 
		RULE_parametrosF = 4, RULE_structDcl = 5, RULE_atriBody = 6, RULE_structFunc = 7, 
		RULE_sliceDcl = 8, RULE_dimension = 9, RULE_slcParam = 10, RULE_statement = 11, 
		RULE_exprList = 12, RULE_forInit = 13, RULE_rangeStmt = 14, RULE_caseStmt = 15, 
		RULE_expr = 16, RULE_call = 17, RULE_parametros = 18, RULE_initAttrList = 19, 
		RULE_initAttr = 20, RULE_tiposD = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "funcionDcl", "parametrosF", "structDcl", 
			"atriBody", "structFunc", "sliceDcl", "dimension", "slcParam", "statement", 
			"exprList", "forInit", "rangeStmt", "caseStmt", "expr", "call", "parametros", 
			"initAttrList", "initAttr", "tiposD"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "'.'", "':'", 
			"','", "'+'", "'-'", "'*'", "'^'", "'/'", "'%'", "'+='", "'-='", "'++'", 
			"'--'", "'='", "'=='", "'!='", "'<'", "'<='", "'>'", "'>='", "'||'", 
			"'&&'", "'!'", "'&'", "'Println'", "'fmt'", "'var'", "':='", "'if'", 
			"'else'", "'switch'", "'case'", "'default'", "'for'", "'range'", "'break'", 
			"'continue'", "'return'", "'func'", "'struct'", "'type'", "'new'", null, 
			null, null, null, null, "'int'", "'float64'", "'string'", "'bool'", "'rune'", 
			"'nil'"
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
			"CASE", "DEFAUL", "FOR", "RANGE", "STBREAK", "STCONTINUE", "STRETURN", 
			"STFUNC", "STRUCT", "STTYPE", "NUEVO", "INT", "FLOAT", "STRING", "BOOL", 
			"RUNE", "T_INT", "T_FLOAT", "T_STR", "T_BOOL", "T_RUNE", "V_NULO", "ID", 
			"WS", "COMENT", "MCOMENT"
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
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494646346722316298L) != 0)) {
				{
				{
				setState(44);
				dcl();
				}
				}
				setState(49);
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
			setState(56);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				funcionDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(52);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(53);
				structDcl();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(54);
				structFunc();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(55);
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
		int _la;
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new VarDclStructContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				match(VAR);
				setState(59);
				match(ID);
				setState(60);
				match(ID);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(61);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 2:
				_localctx = new VarDcl1Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(VAR);
				setState(65);
				match(ID);
				setState(66);
				tiposD();
				setState(67);
				match(IGUAL);
				setState(68);
				expr(0);
				setState(70);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(69);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 3:
				_localctx = new VarDcl2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				match(VAR);
				setState(73);
				match(ID);
				setState(74);
				tiposD();
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(75);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 4:
				_localctx = new VarDcl3Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				match(ID);
				setState(79);
				match(DCLIMPL);
				setState(80);
				expr(0);
				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(81);
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
			setState(86);
			match(STFUNC);
			setState(87);
			match(ID);
			setState(88);
			match(LPAREN);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(89);
				parametrosF();
				}
			}

			setState(92);
			match(RPAREN);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1116892707587883008L) != 0)) {
				{
				setState(93);
				tiposD();
				}
			}

			setState(96);
			match(LBRACE);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494646346722316298L) != 0)) {
				{
				{
				setState(97);
				dcl();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
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
			setState(105);
			match(ID);
			setState(106);
			tiposD();
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(107);
				match(COMMA);
				setState(108);
				match(ID);
				setState(109);
				tiposD();
				}
				}
				setState(114);
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
			setState(115);
			match(STTYPE);
			setState(116);
			match(ID);
			setState(117);
			match(STRUCT);
			setState(118);
			match(LBRACE);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(119);
				atriBody();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
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
			setState(127);
			match(ID);
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T_INT:
			case T_FLOAT:
			case T_STR:
			case T_BOOL:
			case T_RUNE:
				{
				setState(128);
				tiposD();
				}
				break;
			case ID:
				{
				setState(129);
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
			setState(132);
			match(STFUNC);
			setState(133);
			match(LPAREN);
			setState(134);
			match(ID);
			setState(135);
			match(ID);
			setState(136);
			match(RPAREN);
			setState(137);
			match(ID);
			setState(138);
			match(LPAREN);
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(139);
				parametrosF();
				}
			}

			setState(142);
			match(RPAREN);
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1116892707587883008L) != 0)) {
				{
				setState(143);
				tiposD();
				}
			}

			setState(146);
			match(LBRACE);
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494646346722316298L) != 0)) {
				{
				{
				setState(147);
				dcl();
				}
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(153);
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
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				_localctx = new SlcDcl1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(VAR);
				setState(156);
				match(ID);
				setState(157);
				dimension();
				setState(158);
				tiposD();
				}
				break;
			case ID:
				_localctx = new SlcDcl2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				match(ID);
				setState(161);
				match(DCLIMPL);
				setState(162);
				dimension();
				setState(163);
				tiposD();
				setState(164);
				match(LBRACE);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494230361959829514L) != 0)) {
					{
					{
					setState(165);
					slcParam();
					}
					}
					setState(170);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(171);
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
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175);
				match(LBRACKET);
				setState(176);
				match(RBRACKET);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(LBRACKET);
				setState(178);
				match(RBRACKET);
				setState(179);
				match(LBRACKET);
				setState(180);
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
			setState(193);
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
				setState(183);
				parametros();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				match(LBRACE);
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494230361959829506L) != 0)) {
					{
					{
					setState(185);
					parametros();
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(191);
				match(RBRACE);
				setState(192);
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
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public ExprListContext exprList() {
			return getRuleContext(ExprListContext.class,0);
		}
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
	public static class ForRangeStmtContext extends StatementContext {
		public TerminalNode FOR() { return getToken(LanguageParser.FOR, 0); }
		public RangeStmtContext rangeStmt() {
			return getRuleContext(RangeStmtContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(LanguageParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(LanguageParser.RPAREN, 0); }
		public ForRangeStmtContext(StatementContext ctx) { copyFrom(ctx); }
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
			setState(289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				expr(0);
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
			case 2:
				_localctx = new PrintStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(FMT);
				setState(200);
				match(DOT);
				setState(201);
				match(PRINT);
				setState(202);
				match(LPAREN);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494230361959829506L) != 0)) {
					{
					setState(203);
					exprList();
					}
				}

				setState(206);
				match(RPAREN);
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
			case 3:
				_localctx = new BloqueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				match(LBRACE);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494646346722316298L) != 0)) {
					{
					{
					setState(211);
					dcl();
					}
					}
					setState(216);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(217);
				match(RBRACE);
				}
				break;
			case 4:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				match(IF);
				setState(220);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(219);
					match(LPAREN);
					}
					break;
				}
				setState(222);
				expr(0);
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(223);
					match(RPAREN);
					}
				}

				setState(226);
				statement();
				setState(229);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(227);
					match(ELSE);
					setState(228);
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
				setState(231);
				match(SWITCH);
				setState(232);
				expr(0);
				setState(233);
				match(LBRACE);
				setState(235); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(234);
					caseStmt();
					}
					}
					setState(237); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CASE || _la==DEFAUL );
				setState(239);
				match(RBRACE);
				}
				break;
			case 6:
				_localctx = new WhileStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(241);
				match(FOR);
				setState(243);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(242);
					match(LPAREN);
					}
					break;
				}
				setState(245);
				expr(0);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(246);
					match(RPAREN);
					}
				}

				setState(249);
				statement();
				}
				break;
			case 7:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(251);
				match(FOR);
				setState(253);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
				case 1:
					{
					setState(252);
					match(LPAREN);
					}
					break;
				}
				setState(255);
				forInit();
				setState(256);
				expr(0);
				setState(257);
				match(SEMICOLON);
				setState(258);
				expr(0);
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(259);
					match(RPAREN);
					}
				}

				setState(262);
				statement();
				}
				break;
			case 8:
				_localctx = new ForRangeStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(264);
				match(FOR);
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(265);
					match(LPAREN);
					}
				}

				setState(268);
				rangeStmt();
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RPAREN) {
					{
					setState(269);
					match(RPAREN);
					}
				}

				setState(272);
				statement();
				}
				break;
			case 9:
				_localctx = new ST_breakContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(274);
				match(STBREAK);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(275);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 10:
				_localctx = new ST_continueContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(278);
				match(STCONTINUE);
				setState(280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(279);
					match(SEMICOLON);
					}
				}

				}
				break;
			case 11:
				_localctx = new ST_returnContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(282);
				match(STRETURN);
				setState(284);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
				case 1:
					{
					setState(283);
					expr(0);
					}
					break;
				}
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(286);
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
	public static class ExprListContext extends ParserRuleContext {
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
		public ExprListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprList; }
	}

	public final ExprListContext exprList() throws RecognitionException {
		ExprListContext _localctx = new ExprListContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_exprList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			expr(0);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(292);
				match(COMMA);
				setState(293);
				expr(0);
				}
				}
				setState(298);
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
		enterRule(_localctx, 26, RULE_forInit);
		try {
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(299);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(300);
				expr(0);
				setState(301);
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
	public static class RangeStmtContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public TerminalNode COMMA() { return getToken(LanguageParser.COMMA, 0); }
		public TerminalNode DCLIMPL() { return getToken(LanguageParser.DCLIMPL, 0); }
		public TerminalNode RANGE() { return getToken(LanguageParser.RANGE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public RangeStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeStmt; }
	}

	public final RangeStmtContext rangeStmt() throws RecognitionException {
		RangeStmtContext _localctx = new RangeStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_rangeStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(ID);
			setState(306);
			match(COMMA);
			setState(307);
			match(ID);
			setState(308);
			match(DCLIMPL);
			setState(309);
			match(RANGE);
			setState(310);
			expr(0);
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
		enterRule(_localctx, 30, RULE_caseStmt);
		int _la;
		try {
			setState(329);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				_localctx = new CaseNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(312);
				match(CASE);
				setState(313);
				expr(0);
				setState(314);
				match(COLON);
				setState(318);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494646346722316298L) != 0)) {
					{
					{
					setState(315);
					dcl();
					}
					}
					setState(320);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DEFAUL:
				_localctx = new CaseDefaultContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				match(DEFAUL);
				setState(322);
				match(COLON);
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494646346722316298L) != 0)) {
					{
					{
					setState(323);
					dcl();
					}
					}
					setState(328);
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				{
				_localctx = new NegateUContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(332);
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
				setState(333);
				expr(21);
				}
				break;
			case 2:
				{
				_localctx = new UpdateVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(334);
				match(ID);
				setState(335);
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
				setState(336);
				match(ID);
				setState(337);
				match(DCLIMPL);
				setState(338);
				match(ID);
				setState(339);
				match(LBRACE);
				setState(340);
				initAttrList();
				setState(341);
				match(RBRACE);
				}
				break;
			case 4:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(343);
				match(INT);
				}
				break;
			case 5:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(344);
				match(FLOAT);
				}
				break;
			case 6:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(345);
				match(STRING);
				}
				break;
			case 7:
				{
				_localctx = new BoolContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(346);
				match(BOOL);
				}
				break;
			case 8:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(347);
				match(RUNE);
				}
				break;
			case 9:
				{
				_localctx = new ValorNuloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(348);
				match(V_NULO);
				}
				break;
			case 10:
				{
				_localctx = new SliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(349);
				match(ID);
				setState(350);
				match(IGUAL);
				setState(351);
				dimension();
				setState(352);
				tiposD();
				setState(353);
				match(LBRACE);
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494230361959829506L) != 0)) {
					{
					setState(354);
					parametros();
					}
				}

				setState(357);
				match(LBRACE);
				}
				break;
			case 11:
				{
				_localctx = new NewInstanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(359);
				match(NUEVO);
				setState(360);
				match(ID);
				setState(361);
				match(LPAREN);
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494230361959829506L) != 0)) {
					{
					setState(362);
					parametros();
					}
				}

				setState(365);
				match(RPAREN);
				}
				break;
			case 12:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(366);
				match(ID);
				}
				break;
			case 13:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(367);
				match(LPAREN);
				setState(368);
				expr(0);
				setState(369);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(402);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(400);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(373);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(374);
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
						setState(375);
						expr(20);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(376);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(377);
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
						setState(378);
						expr(19);
						}
						break;
					case 3:
						{
						_localctx = new RelacionalesContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(379);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(380);
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
						setState(381);
						expr(18);
						}
						break;
					case 4:
						{
						_localctx = new ComparationContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(382);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(383);
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
						setState(384);
						expr(17);
						}
						break;
					case 5:
						{
						_localctx = new AndContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(385);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(386);
						match(AND);
						setState(387);
						expr(16);
						}
						break;
					case 6:
						{
						_localctx = new OrContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(388);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(389);
						match(OR);
						setState(390);
						expr(15);
						}
						break;
					case 7:
						{
						_localctx = new AssignVarContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(391);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(392);
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
						setState(393);
						expr(14);
						}
						break;
					case 8:
						{
						_localctx = new LlamadaContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(394);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(396); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(395);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(398); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					}
					} 
				}
				setState(404);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
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
		enterRule(_localctx, 34, RULE_call);
		int _la;
		try {
			setState(416);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(405);
				match(LPAREN);
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3494230361959829506L) != 0)) {
					{
					setState(406);
					parametros();
					}
				}

				setState(409);
				match(RPAREN);
				}
				break;
			case DOT:
				_localctx = new GetAtrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(410);
				match(DOT);
				setState(411);
				match(ID);
				}
				break;
			case LBRACKET:
				_localctx = new AccesoSliceContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(412);
				match(LBRACKET);
				setState(413);
				expr(0);
				setState(414);
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
		enterRule(_localctx, 36, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			expr(0);
			setState(423);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(419);
				match(COMMA);
				setState(420);
				expr(0);
				}
				}
				setState(425);
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
		enterRule(_localctx, 38, RULE_initAttrList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			initAttr();
			setState(427);
			match(COMMA);
			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(428);
				initAttr();
				setState(429);
				match(COMMA);
				}
				}
				setState(435);
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
		enterRule(_localctx, 40, RULE_initAttr);
		try {
			setState(446);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				_localctx = new InitAttrExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				match(ID);
				setState(437);
				match(COLON);
				setState(438);
				expr(0);
				}
				break;
			case 2:
				_localctx = new InitAttrStructContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(439);
				match(ID);
				setState(440);
				match(COLON);
				setState(441);
				match(ID);
				setState(442);
				match(LBRACE);
				setState(443);
				initAttrList();
				setState(444);
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
		enterRule(_localctx, 42, RULE_tiposD);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1116892707587883008L) != 0)) ) {
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
		case 16:
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
		"\u0004\u0001@\u01c3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0005\u0000.\b\u0000\n\u0000\f\u00001\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"9\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"?\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002G\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002M\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0003\u0002S\b\u0002\u0003\u0002U\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003[\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003_\b\u0003\u0001\u0003\u0001\u0003\u0005\u0003c\b\u0003"+
		"\n\u0003\f\u0003f\t\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004o\b\u0004\n\u0004\f\u0004"+
		"r\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005y\b\u0005\n\u0005\f\u0005|\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0083\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0003\u0007\u008d\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u0091\b\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0095\b\u0007\n\u0007"+
		"\f\u0007\u0098\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u00a7\b\b\n\b\f\b\u00aa\t\b\u0001\b\u0001\b\u0003\b\u00ae\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00b6\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u00bb\b\n\n\n\f\n\u00be\t\n\u0001\n\u0001\n\u0003\n"+
		"\u00c2\b\n\u0001\u000b\u0001\u000b\u0003\u000b\u00c6\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00cd\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u00d1\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u00d5\b\u000b\n\u000b\f\u000b\u00d8\t\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u00dd\b\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u00e1\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00e6"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0004\u000b\u00ec"+
		"\b\u000b\u000b\u000b\f\u000b\u00ed\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00f4\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00f8\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u00fe\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u0105\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u010b\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u010f\b"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0115"+
		"\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0119\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u011d\b\u000b\u0001\u000b\u0003\u000b\u0120\b"+
		"\u000b\u0003\u000b\u0122\b\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u0127"+
		"\b\f\n\f\f\f\u012a\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0130\b"+
		"\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u013d\b\u000f\n\u000f\f\u000f\u0140\t\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0005\u000f\u0145\b\u000f\n\u000f\f\u000f\u0148\t\u000f\u0003\u000f"+
		"\u014a\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u0164\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u016c\b\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u0174\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0004\u0010\u018d\b\u0010\u000b\u0010\f\u0010\u018e\u0005\u0010\u0191"+
		"\b\u0010\n\u0010\f\u0010\u0194\t\u0010\u0001\u0011\u0001\u0011\u0003\u0011"+
		"\u0198\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u01a1\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u01a6\b\u0012\n\u0012\f\u0012\u01a9\t\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u01b0"+
		"\b\u0013\n\u0013\f\u0013\u01b3\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0003\u0014\u01bf\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0000\u0001 \u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*\u0000\b\u0002\u0000\f\f\u001e\u001e"+
		"\u0001\u0000\u0013\u0014\u0002\u0000\r\r\u000f\u0010\u0001\u0000\u000b"+
		"\f\u0001\u0000\u0018\u001b\u0001\u0000\u0016\u0017\u0002\u0000\u0011\u0012"+
		"\u0015\u0015\u0001\u00007;\u0205\u0000/\u0001\u0000\u0000\u0000\u0002"+
		"8\u0001\u0000\u0000\u0000\u0004T\u0001\u0000\u0000\u0000\u0006V\u0001"+
		"\u0000\u0000\u0000\bi\u0001\u0000\u0000\u0000\ns\u0001\u0000\u0000\u0000"+
		"\f\u007f\u0001\u0000\u0000\u0000\u000e\u0084\u0001\u0000\u0000\u0000\u0010"+
		"\u00ad\u0001\u0000\u0000\u0000\u0012\u00b5\u0001\u0000\u0000\u0000\u0014"+
		"\u00c1\u0001\u0000\u0000\u0000\u0016\u0121\u0001\u0000\u0000\u0000\u0018"+
		"\u0123\u0001\u0000\u0000\u0000\u001a\u012f\u0001\u0000\u0000\u0000\u001c"+
		"\u0131\u0001\u0000\u0000\u0000\u001e\u0149\u0001\u0000\u0000\u0000 \u0173"+
		"\u0001\u0000\u0000\u0000\"\u01a0\u0001\u0000\u0000\u0000$\u01a2\u0001"+
		"\u0000\u0000\u0000&\u01aa\u0001\u0000\u0000\u0000(\u01be\u0001\u0000\u0000"+
		"\u0000*\u01c0\u0001\u0000\u0000\u0000,.\u0003\u0002\u0001\u0000-,\u0001"+
		"\u0000\u0000\u0000.1\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000"+
		"/0\u0001\u0000\u0000\u00000\u0001\u0001\u0000\u0000\u00001/\u0001\u0000"+
		"\u0000\u000029\u0003\u0004\u0002\u000039\u0003\u0006\u0003\u000049\u0003"+
		"\u0016\u000b\u000059\u0003\n\u0005\u000069\u0003\u000e\u0007\u000079\u0003"+
		"\u0010\b\u000082\u0001\u0000\u0000\u000083\u0001\u0000\u0000\u000084\u0001"+
		"\u0000\u0000\u000085\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u0000"+
		"87\u0001\u0000\u0000\u00009\u0003\u0001\u0000\u0000\u0000:;\u0005\"\u0000"+
		"\u0000;<\u0005=\u0000\u0000<>\u0005=\u0000\u0000=?\u0005\u0007\u0000\u0000"+
		">=\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?U\u0001\u0000\u0000"+
		"\u0000@A\u0005\"\u0000\u0000AB\u0005=\u0000\u0000BC\u0003*\u0015\u0000"+
		"CD\u0005\u0015\u0000\u0000DF\u0003 \u0010\u0000EG\u0005\u0007\u0000\u0000"+
		"FE\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GU\u0001\u0000\u0000"+
		"\u0000HI\u0005\"\u0000\u0000IJ\u0005=\u0000\u0000JL\u0003*\u0015\u0000"+
		"KM\u0005\u0007\u0000\u0000LK\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000"+
		"\u0000MU\u0001\u0000\u0000\u0000NO\u0005=\u0000\u0000OP\u0005#\u0000\u0000"+
		"PR\u0003 \u0010\u0000QS\u0005\u0007\u0000\u0000RQ\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000SU\u0001\u0000\u0000\u0000T:\u0001\u0000\u0000"+
		"\u0000T@\u0001\u0000\u0000\u0000TH\u0001\u0000\u0000\u0000TN\u0001\u0000"+
		"\u0000\u0000U\u0005\u0001\u0000\u0000\u0000VW\u0005.\u0000\u0000WX\u0005"+
		"=\u0000\u0000XZ\u0005\u0001\u0000\u0000Y[\u0003\b\u0004\u0000ZY\u0001"+
		"\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\^\u0005\u0002\u0000\u0000]_\u0003*\u0015\u0000^]\u0001\u0000\u0000\u0000"+
		"^_\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`d\u0005\u0003\u0000"+
		"\u0000ac\u0003\u0002\u0001\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000"+
		"\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0001"+
		"\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gh\u0005\u0004\u0000\u0000"+
		"h\u0007\u0001\u0000\u0000\u0000ij\u0005=\u0000\u0000jp\u0003*\u0015\u0000"+
		"kl\u0005\n\u0000\u0000lm\u0005=\u0000\u0000mo\u0003*\u0015\u0000nk\u0001"+
		"\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000q\t\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000"+
		"\u0000st\u00050\u0000\u0000tu\u0005=\u0000\u0000uv\u0005/\u0000\u0000"+
		"vz\u0005\u0003\u0000\u0000wy\u0003\f\u0006\u0000xw\u0001\u0000\u0000\u0000"+
		"y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{}\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0005\u0004"+
		"\u0000\u0000~\u000b\u0001\u0000\u0000\u0000\u007f\u0082\u0005=\u0000\u0000"+
		"\u0080\u0083\u0003*\u0015\u0000\u0081\u0083\u0005=\u0000\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083\r\u0001"+
		"\u0000\u0000\u0000\u0084\u0085\u0005.\u0000\u0000\u0085\u0086\u0005\u0001"+
		"\u0000\u0000\u0086\u0087\u0005=\u0000\u0000\u0087\u0088\u0005=\u0000\u0000"+
		"\u0088\u0089\u0005\u0002\u0000\u0000\u0089\u008a\u0005=\u0000\u0000\u008a"+
		"\u008c\u0005\u0001\u0000\u0000\u008b\u008d\u0003\b\u0004\u0000\u008c\u008b"+
		"\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0001\u0000\u0000\u0000\u008e\u0090\u0005\u0002\u0000\u0000\u008f\u0091"+
		"\u0003*\u0015\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0090\u0091\u0001"+
		"\u0000\u0000\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0096\u0005"+
		"\u0003\u0000\u0000\u0093\u0095\u0003\u0002\u0001\u0000\u0094\u0093\u0001"+
		"\u0000\u0000\u0000\u0095\u0098\u0001\u0000\u0000\u0000\u0096\u0094\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0099\u0001"+
		"\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0099\u009a\u0005"+
		"\u0004\u0000\u0000\u009a\u000f\u0001\u0000\u0000\u0000\u009b\u009c\u0005"+
		"\"\u0000\u0000\u009c\u009d\u0005=\u0000\u0000\u009d\u009e\u0003\u0012"+
		"\t\u0000\u009e\u009f\u0003*\u0015\u0000\u009f\u00ae\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0005=\u0000\u0000\u00a1\u00a2\u0005#\u0000\u0000\u00a2"+
		"\u00a3\u0003\u0012\t\u0000\u00a3\u00a4\u0003*\u0015\u0000\u00a4\u00a8"+
		"\u0005\u0003\u0000\u0000\u00a5\u00a7\u0003\u0014\n\u0000\u00a6\u00a5\u0001"+
		"\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001"+
		"\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u00ab\u0001"+
		"\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005"+
		"\u0004\u0000\u0000\u00ac\u00ae\u0001\u0000\u0000\u0000\u00ad\u009b\u0001"+
		"\u0000\u0000\u0000\u00ad\u00a0\u0001\u0000\u0000\u0000\u00ae\u0011\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0005\u0005\u0000\u0000\u00b0\u00b6\u0005"+
		"\u0006\u0000\u0000\u00b1\u00b2\u0005\u0005\u0000\u0000\u00b2\u00b3\u0005"+
		"\u0006\u0000\u0000\u00b3\u00b4\u0005\u0005\u0000\u0000\u00b4\u00b6\u0005"+
		"\u0006\u0000\u0000\u00b5\u00af\u0001\u0000\u0000\u0000\u00b5\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b6\u0013\u0001\u0000\u0000\u0000\u00b7\u00c2\u0003"+
		"$\u0012\u0000\u00b8\u00bc\u0005\u0003\u0000\u0000\u00b9\u00bb\u0003$\u0012"+
		"\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb\u00be\u0001\u0000\u0000"+
		"\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000"+
		"\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be\u00bc\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c0\u0005\u0004\u0000\u0000\u00c0\u00c2\u0005\n\u0000\u0000"+
		"\u00c1\u00b7\u0001\u0000\u0000\u0000\u00c1\u00b8\u0001\u0000\u0000\u0000"+
		"\u00c2\u0015\u0001\u0000\u0000\u0000\u00c3\u00c5\u0003 \u0010\u0000\u00c4"+
		"\u00c6\u0005\u0007\u0000\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c6\u0122\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c8\u0005!\u0000\u0000\u00c8\u00c9\u0005\b\u0000\u0000\u00c9\u00ca"+
		"\u0005 \u0000\u0000\u00ca\u00cc\u0005\u0001\u0000\u0000\u00cb\u00cd\u0003"+
		"\u0018\f\u0000\u00cc\u00cb\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00d0\u0005\u0002"+
		"\u0000\u0000\u00cf\u00d1\u0005\u0007\u0000\u0000\u00d0\u00cf\u0001\u0000"+
		"\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u0122\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d6\u0005\u0003\u0000\u0000\u00d3\u00d5\u0003\u0002"+
		"\u0001\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d8\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d4\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d9\u0001\u0000\u0000\u0000\u00d8\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d9\u0122\u0005\u0004\u0000\u0000\u00da\u00dc\u0005$\u0000"+
		"\u0000\u00db\u00dd\u0005\u0001\u0000\u0000\u00dc\u00db\u0001\u0000\u0000"+
		"\u0000\u00dc\u00dd\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000"+
		"\u0000\u00de\u00e0\u0003 \u0010\u0000\u00df\u00e1\u0005\u0002\u0000\u0000"+
		"\u00e0\u00df\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e5\u0003\u0016\u000b\u0000"+
		"\u00e3\u00e4\u0005%\u0000\u0000\u00e4\u00e6\u0003\u0016\u000b\u0000\u00e5"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6"+
		"\u0122\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005&\u0000\u0000\u00e8\u00e9"+
		"\u0003 \u0010\u0000\u00e9\u00eb\u0005\u0003\u0000\u0000\u00ea\u00ec\u0003"+
		"\u001e\u000f\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00ec\u00ed\u0001"+
		"\u0000\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001"+
		"\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f0\u0005"+
		"\u0004\u0000\u0000\u00f0\u0122\u0001\u0000\u0000\u0000\u00f1\u00f3\u0005"+
		")\u0000\u0000\u00f2\u00f4\u0005\u0001\u0000\u0000\u00f3\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f5\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f7\u0003 \u0010\u0000\u00f6\u00f8\u0005\u0002\u0000"+
		"\u0000\u00f7\u00f6\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fa\u0003\u0016\u000b"+
		"\u0000\u00fa\u0122\u0001\u0000\u0000\u0000\u00fb\u00fd\u0005)\u0000\u0000"+
		"\u00fc\u00fe\u0005\u0001\u0000\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000"+
		"\u00ff\u0100\u0003\u001a\r\u0000\u0100\u0101\u0003 \u0010\u0000\u0101"+
		"\u0102\u0005\u0007\u0000\u0000\u0102\u0104\u0003 \u0010\u0000\u0103\u0105"+
		"\u0005\u0002\u0000\u0000\u0104\u0103\u0001\u0000\u0000\u0000\u0104\u0105"+
		"\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u0107"+
		"\u0003\u0016\u000b\u0000\u0107\u0122\u0001\u0000\u0000\u0000\u0108\u010a"+
		"\u0005)\u0000\u0000\u0109\u010b\u0005\u0001\u0000\u0000\u010a\u0109\u0001"+
		"\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u010c\u0001"+
		"\u0000\u0000\u0000\u010c\u010e\u0003\u001c\u000e\u0000\u010d\u010f\u0005"+
		"\u0002\u0000\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010e\u010f\u0001"+
		"\u0000\u0000\u0000\u010f\u0110\u0001\u0000\u0000\u0000\u0110\u0111\u0003"+
		"\u0016\u000b\u0000\u0111\u0122\u0001\u0000\u0000\u0000\u0112\u0114\u0005"+
		"+\u0000\u0000\u0113\u0115\u0005\u0007\u0000\u0000\u0114\u0113\u0001\u0000"+
		"\u0000\u0000\u0114\u0115\u0001\u0000\u0000\u0000\u0115\u0122\u0001\u0000"+
		"\u0000\u0000\u0116\u0118\u0005,\u0000\u0000\u0117\u0119\u0005\u0007\u0000"+
		"\u0000\u0118\u0117\u0001\u0000\u0000\u0000\u0118\u0119\u0001\u0000\u0000"+
		"\u0000\u0119\u0122\u0001\u0000\u0000\u0000\u011a\u011c\u0005-\u0000\u0000"+
		"\u011b\u011d\u0003 \u0010\u0000\u011c\u011b\u0001\u0000\u0000\u0000\u011c"+
		"\u011d\u0001\u0000\u0000\u0000\u011d\u011f\u0001\u0000\u0000\u0000\u011e"+
		"\u0120\u0005\u0007\u0000\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u011f"+
		"\u0120\u0001\u0000\u0000\u0000\u0120\u0122\u0001\u0000\u0000\u0000\u0121"+
		"\u00c3\u0001\u0000\u0000\u0000\u0121\u00c7\u0001\u0000\u0000\u0000\u0121"+
		"\u00d2\u0001\u0000\u0000\u0000\u0121\u00da\u0001\u0000\u0000\u0000\u0121"+
		"\u00e7\u0001\u0000\u0000\u0000\u0121\u00f1\u0001\u0000\u0000\u0000\u0121"+
		"\u00fb\u0001\u0000\u0000\u0000\u0121\u0108\u0001\u0000\u0000\u0000\u0121"+
		"\u0112\u0001\u0000\u0000\u0000\u0121\u0116\u0001\u0000\u0000\u0000\u0121"+
		"\u011a\u0001\u0000\u0000\u0000\u0122\u0017\u0001\u0000\u0000\u0000\u0123"+
		"\u0128\u0003 \u0010\u0000\u0124\u0125\u0005\n\u0000\u0000\u0125\u0127"+
		"\u0003 \u0010\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0127\u012a\u0001"+
		"\u0000\u0000\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0129\u0001"+
		"\u0000\u0000\u0000\u0129\u0019\u0001\u0000\u0000\u0000\u012a\u0128\u0001"+
		"\u0000\u0000\u0000\u012b\u0130\u0003\u0004\u0002\u0000\u012c\u012d\u0003"+
		" \u0010\u0000\u012d\u012e\u0005\u0007\u0000\u0000\u012e\u0130\u0001\u0000"+
		"\u0000\u0000\u012f\u012b\u0001\u0000\u0000\u0000\u012f\u012c\u0001\u0000"+
		"\u0000\u0000\u0130\u001b\u0001\u0000\u0000\u0000\u0131\u0132\u0005=\u0000"+
		"\u0000\u0132\u0133\u0005\n\u0000\u0000\u0133\u0134\u0005=\u0000\u0000"+
		"\u0134\u0135\u0005#\u0000\u0000\u0135\u0136\u0005*\u0000\u0000\u0136\u0137"+
		"\u0003 \u0010\u0000\u0137\u001d\u0001\u0000\u0000\u0000\u0138\u0139\u0005"+
		"\'\u0000\u0000\u0139\u013a\u0003 \u0010\u0000\u013a\u013e\u0005\t\u0000"+
		"\u0000\u013b\u013d\u0003\u0002\u0001\u0000\u013c\u013b\u0001\u0000\u0000"+
		"\u0000\u013d\u0140\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000"+
		"\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u014a\u0001\u0000\u0000"+
		"\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0141\u0142\u0005(\u0000\u0000"+
		"\u0142\u0146\u0005\t\u0000\u0000\u0143\u0145\u0003\u0002\u0001\u0000\u0144"+
		"\u0143\u0001\u0000\u0000\u0000\u0145\u0148\u0001\u0000\u0000\u0000\u0146"+
		"\u0144\u0001\u0000\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u0147"+
		"\u014a\u0001\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0149"+
		"\u0138\u0001\u0000\u0000\u0000\u0149\u0141\u0001\u0000\u0000\u0000\u014a"+
		"\u001f\u0001\u0000\u0000\u0000\u014b\u014c\u0006\u0010\uffff\uffff\u0000"+
		"\u014c\u014d\u0007\u0000\u0000\u0000\u014d\u0174\u0003 \u0010\u0015\u014e"+
		"\u014f\u0005=\u0000\u0000\u014f\u0174\u0007\u0001\u0000\u0000\u0150\u0151"+
		"\u0005=\u0000\u0000\u0151\u0152\u0005#\u0000\u0000\u0152\u0153\u0005="+
		"\u0000\u0000\u0153\u0154\u0005\u0003\u0000\u0000\u0154\u0155\u0003&\u0013"+
		"\u0000\u0155\u0156\u0005\u0004\u0000\u0000\u0156\u0174\u0001\u0000\u0000"+
		"\u0000\u0157\u0174\u00052\u0000\u0000\u0158\u0174\u00053\u0000\u0000\u0159"+
		"\u0174\u00054\u0000\u0000\u015a\u0174\u00055\u0000\u0000\u015b\u0174\u0005"+
		"6\u0000\u0000\u015c\u0174\u0005<\u0000\u0000\u015d\u015e\u0005=\u0000"+
		"\u0000\u015e\u015f\u0005\u0015\u0000\u0000\u015f\u0160\u0003\u0012\t\u0000"+
		"\u0160\u0161\u0003*\u0015\u0000\u0161\u0163\u0005\u0003\u0000\u0000\u0162"+
		"\u0164\u0003$\u0012\u0000\u0163\u0162\u0001\u0000\u0000\u0000\u0163\u0164"+
		"\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u0166"+
		"\u0005\u0003\u0000\u0000\u0166\u0174\u0001\u0000\u0000\u0000\u0167\u0168"+
		"\u00051\u0000\u0000\u0168\u0169\u0005=\u0000\u0000\u0169\u016b\u0005\u0001"+
		"\u0000\u0000\u016a\u016c\u0003$\u0012\u0000\u016b\u016a\u0001\u0000\u0000"+
		"\u0000\u016b\u016c\u0001\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000"+
		"\u0000\u016d\u0174\u0005\u0002\u0000\u0000\u016e\u0174\u0005=\u0000\u0000"+
		"\u016f\u0170\u0005\u0001\u0000\u0000\u0170\u0171\u0003 \u0010\u0000\u0171"+
		"\u0172\u0005\u0002\u0000\u0000\u0172\u0174\u0001\u0000\u0000\u0000\u0173"+
		"\u014b\u0001\u0000\u0000\u0000\u0173\u014e\u0001\u0000\u0000\u0000\u0173"+
		"\u0150\u0001\u0000\u0000\u0000\u0173\u0157\u0001\u0000\u0000\u0000\u0173"+
		"\u0158\u0001\u0000\u0000\u0000\u0173\u0159\u0001\u0000\u0000\u0000\u0173"+
		"\u015a\u0001\u0000\u0000\u0000\u0173\u015b\u0001\u0000\u0000\u0000\u0173"+
		"\u015c\u0001\u0000\u0000\u0000\u0173\u015d\u0001\u0000\u0000\u0000\u0173"+
		"\u0167\u0001\u0000\u0000\u0000\u0173\u016e\u0001\u0000\u0000\u0000\u0173"+
		"\u016f\u0001\u0000\u0000\u0000\u0174\u0192\u0001\u0000\u0000\u0000\u0175"+
		"\u0176\n\u0013\u0000\u0000\u0176\u0177\u0007\u0002\u0000\u0000\u0177\u0191"+
		"\u0003 \u0010\u0014\u0178\u0179\n\u0012\u0000\u0000\u0179\u017a\u0007"+
		"\u0003\u0000\u0000\u017a\u0191\u0003 \u0010\u0013\u017b\u017c\n\u0011"+
		"\u0000\u0000\u017c\u017d\u0007\u0004\u0000\u0000\u017d\u0191\u0003 \u0010"+
		"\u0012\u017e\u017f\n\u0010\u0000\u0000\u017f\u0180\u0007\u0005\u0000\u0000"+
		"\u0180\u0191\u0003 \u0010\u0011\u0181\u0182\n\u000f\u0000\u0000\u0182"+
		"\u0183\u0005\u001d\u0000\u0000\u0183\u0191\u0003 \u0010\u0010\u0184\u0185"+
		"\n\u000e\u0000\u0000\u0185\u0186\u0005\u001c\u0000\u0000\u0186\u0191\u0003"+
		" \u0010\u000f\u0187\u0188\n\r\u0000\u0000\u0188\u0189\u0007\u0006\u0000"+
		"\u0000\u0189\u0191\u0003 \u0010\u000e\u018a\u018c\n\u0014\u0000\u0000"+
		"\u018b\u018d\u0003\"\u0011\u0000\u018c\u018b\u0001\u0000\u0000\u0000\u018d"+
		"\u018e\u0001\u0000\u0000\u0000\u018e\u018c\u0001\u0000\u0000\u0000\u018e"+
		"\u018f\u0001\u0000\u0000\u0000\u018f\u0191\u0001\u0000\u0000\u0000\u0190"+
		"\u0175\u0001\u0000\u0000\u0000\u0190\u0178\u0001\u0000\u0000\u0000\u0190"+
		"\u017b\u0001\u0000\u0000\u0000\u0190\u017e\u0001\u0000\u0000\u0000\u0190"+
		"\u0181\u0001\u0000\u0000\u0000\u0190\u0184\u0001\u0000\u0000\u0000\u0190"+
		"\u0187\u0001\u0000\u0000\u0000\u0190\u018a\u0001\u0000\u0000\u0000\u0191"+
		"\u0194\u0001\u0000\u0000\u0000\u0192\u0190\u0001\u0000\u0000\u0000\u0192"+
		"\u0193\u0001\u0000\u0000\u0000\u0193!\u0001\u0000\u0000\u0000\u0194\u0192"+
		"\u0001\u0000\u0000\u0000\u0195\u0197\u0005\u0001\u0000\u0000\u0196\u0198"+
		"\u0003$\u0012\u0000\u0197\u0196\u0001\u0000\u0000\u0000\u0197\u0198\u0001"+
		"\u0000\u0000\u0000\u0198\u0199\u0001\u0000\u0000\u0000\u0199\u01a1\u0005"+
		"\u0002\u0000\u0000\u019a\u019b\u0005\b\u0000\u0000\u019b\u01a1\u0005="+
		"\u0000\u0000\u019c\u019d\u0005\u0005\u0000\u0000\u019d\u019e\u0003 \u0010"+
		"\u0000\u019e\u019f\u0005\u0006\u0000\u0000\u019f\u01a1\u0001\u0000\u0000"+
		"\u0000\u01a0\u0195\u0001\u0000\u0000\u0000\u01a0\u019a\u0001\u0000\u0000"+
		"\u0000\u01a0\u019c\u0001\u0000\u0000\u0000\u01a1#\u0001\u0000\u0000\u0000"+
		"\u01a2\u01a7\u0003 \u0010\u0000\u01a3\u01a4\u0005\n\u0000\u0000\u01a4"+
		"\u01a6\u0003 \u0010\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a6\u01a9"+
		"\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a7\u01a8"+
		"\u0001\u0000\u0000\u0000\u01a8%\u0001\u0000\u0000\u0000\u01a9\u01a7\u0001"+
		"\u0000\u0000\u0000\u01aa\u01ab\u0003(\u0014\u0000\u01ab\u01b1\u0005\n"+
		"\u0000\u0000\u01ac\u01ad\u0003(\u0014\u0000\u01ad\u01ae\u0005\n\u0000"+
		"\u0000\u01ae\u01b0\u0001\u0000\u0000\u0000\u01af\u01ac\u0001\u0000\u0000"+
		"\u0000\u01b0\u01b3\u0001\u0000\u0000\u0000\u01b1\u01af\u0001\u0000\u0000"+
		"\u0000\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2\'\u0001\u0000\u0000\u0000"+
		"\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b4\u01b5\u0005=\u0000\u0000\u01b5"+
		"\u01b6\u0005\t\u0000\u0000\u01b6\u01bf\u0003 \u0010\u0000\u01b7\u01b8"+
		"\u0005=\u0000\u0000\u01b8\u01b9\u0005\t\u0000\u0000\u01b9\u01ba\u0005"+
		"=\u0000\u0000\u01ba\u01bb\u0005\u0003\u0000\u0000\u01bb\u01bc\u0003&\u0013"+
		"\u0000\u01bc\u01bd\u0005\u0004\u0000\u0000\u01bd\u01bf\u0001\u0000\u0000"+
		"\u0000\u01be\u01b4\u0001\u0000\u0000\u0000\u01be\u01b7\u0001\u0000\u0000"+
		"\u0000\u01bf)\u0001\u0000\u0000\u0000\u01c0\u01c1\u0007\u0007\u0000\u0000"+
		"\u01c1+\u0001\u0000\u0000\u00008/8>FLRTZ^dpz\u0082\u008c\u0090\u0096\u00a8"+
		"\u00ad\u00b5\u00bc\u00c1\u00c5\u00cc\u00d0\u00d6\u00dc\u00e0\u00e5\u00ed"+
		"\u00f3\u00f7\u00fd\u0104\u010a\u010e\u0114\u0118\u011c\u011f\u0121\u0128"+
		"\u012f\u013e\u0146\u0149\u0163\u016b\u0173\u018e\u0190\u0192\u0197\u01a0"+
		"\u01a7\u01b1\u01be";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}