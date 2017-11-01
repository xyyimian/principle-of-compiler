// Generated from C1Lexer.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class C1Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Comma=1, SemiColon=2, Assign=3, LeftBracket=4, RightBracket=5, LeftBrace=6, 
		RightBrace=7, LeftParen=8, RightParen=9, If=10, Else=11, While=12, Const=13, 
		Equal=14, NonEqual=15, Less=16, Greater=17, LessEqual=18, GreaterEqual=19, 
		Plus=20, Minus=21, Multiply=22, Divide=23, Modulo=24, Int=25, Void=26, 
		Identifier=27, Number=28, WhiteSpace=29, Newline=30, Comment=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Comma", "SemiColon", "Assign", "LeftBracket", "RightBracket", "LeftBrace", 
		"RightBrace", "LeftParen", "RightParen", "If", "Else", "While", "Const", 
		"Equal", "NonEqual", "Less", "Greater", "LessEqual", "GreaterEqual", "Plus", 
		"Minus", "Multiply", "Divide", "Modulo", "Int", "Void", "Number", "Identifier", 
		"WhiteSpace", "Newline", "Comment"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "';'", "'='", "'['", "']'", "'{'", "'}'", "'('", "')'", "'if'", 
		"'else'", "'while'", "'const'", "'=='", "'!='", "'<'", "'>'", "'<='", 
		"'>='", "'+'", "'-'", "'*'", "'/'", "'%'", "'int'", "'void'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Comma", "SemiColon", "Assign", "LeftBracket", "RightBracket", "LeftBrace", 
		"RightBrace", "LeftParen", "RightParen", "If", "Else", "While", "Const", 
		"Equal", "NonEqual", "Less", "Greater", "LessEqual", "GreaterEqual", "Plus", 
		"Minus", "Multiply", "Divide", "Modulo", "Int", "Void", "Identifier", 
		"Number", "WhiteSpace", "Newline", "Comment"
	};
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


	public C1Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "C1Lexer.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u00d5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\5\34\u008c"+
		"\n\34\3\34\6\34\u008f\n\34\r\34\16\34\u0090\3\34\3\34\3\34\3\34\6\34\u0097"+
		"\n\34\r\34\16\34\u0098\5\34\u009b\n\34\3\35\3\35\7\35\u009f\n\35\f\35"+
		"\16\35\u00a2\13\35\3\36\6\36\u00a5\n\36\r\36\16\36\u00a6\3\36\3\36\3\37"+
		"\3\37\3\37\5\37\u00ae\n\37\3 \3 \3 \3 \7 \u00b4\n \f \16 \u00b7\13 \3"+
		" \3 \3 \7 \u00bc\n \f \16 \u00bf\13 \7 \u00c1\n \f \16 \u00c4\13 \3 \3"+
		" \3 \3 \3 \7 \u00cb\n \f \16 \u00ce\13 \3 \3 \5 \u00d2\n \3 \3 \5\u00b5"+
		"\u00bd\u00cc\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31"+
		"\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65"+
		"\34\67\369\35;\37= ?!\3\2\t\4\2--//\3\2\62;\5\2\62;CHch\5\2C\\aac|\6\2"+
		"\62;C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f\17\17\2\u00e0\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"+
		"\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"+
		"\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"+
		"?\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3"+
		"\2\2\2\17M\3\2\2\2\21O\3\2\2\2\23Q\3\2\2\2\25S\3\2\2\2\27V\3\2\2\2\31"+
		"[\3\2\2\2\33a\3\2\2\2\35g\3\2\2\2\37j\3\2\2\2!m\3\2\2\2#o\3\2\2\2%q\3"+
		"\2\2\2\'t\3\2\2\2)w\3\2\2\2+y\3\2\2\2-{\3\2\2\2/}\3\2\2\2\61\177\3\2\2"+
		"\2\63\u0081\3\2\2\2\65\u0085\3\2\2\2\67\u009a\3\2\2\29\u009c\3\2\2\2;"+
		"\u00a4\3\2\2\2=\u00ad\3\2\2\2?\u00d1\3\2\2\2AB\7.\2\2B\4\3\2\2\2CD\7="+
		"\2\2D\6\3\2\2\2EF\7?\2\2F\b\3\2\2\2GH\7]\2\2H\n\3\2\2\2IJ\7_\2\2J\f\3"+
		"\2\2\2KL\7}\2\2L\16\3\2\2\2MN\7\177\2\2N\20\3\2\2\2OP\7*\2\2P\22\3\2\2"+
		"\2QR\7+\2\2R\24\3\2\2\2ST\7k\2\2TU\7h\2\2U\26\3\2\2\2VW\7g\2\2WX\7n\2"+
		"\2XY\7u\2\2YZ\7g\2\2Z\30\3\2\2\2[\\\7y\2\2\\]\7j\2\2]^\7k\2\2^_\7n\2\2"+
		"_`\7g\2\2`\32\3\2\2\2ab\7e\2\2bc\7q\2\2cd\7p\2\2de\7u\2\2ef\7v\2\2f\34"+
		"\3\2\2\2gh\7?\2\2hi\7?\2\2i\36\3\2\2\2jk\7#\2\2kl\7?\2\2l \3\2\2\2mn\7"+
		">\2\2n\"\3\2\2\2op\7@\2\2p$\3\2\2\2qr\7>\2\2rs\7?\2\2s&\3\2\2\2tu\7@\2"+
		"\2uv\7?\2\2v(\3\2\2\2wx\7-\2\2x*\3\2\2\2yz\7/\2\2z,\3\2\2\2{|\7,\2\2|"+
		".\3\2\2\2}~\7\61\2\2~\60\3\2\2\2\177\u0080\7\'\2\2\u0080\62\3\2\2\2\u0081"+
		"\u0082\7k\2\2\u0082\u0083\7p\2\2\u0083\u0084\7v\2\2\u0084\64\3\2\2\2\u0085"+
		"\u0086\7x\2\2\u0086\u0087\7q\2\2\u0087\u0088\7k\2\2\u0088\u0089\7f\2\2"+
		"\u0089\66\3\2\2\2\u008a\u008c\t\2\2\2\u008b\u008a\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008f\t\3\2\2\u008e\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u009b\3\2"+
		"\2\2\u0092\u0093\7\62\2\2\u0093\u0094\7z\2\2\u0094\u0096\3\2\2\2\u0095"+
		"\u0097\t\4\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0096\3\2"+
		"\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u008b\3\2\2\2\u009a"+
		"\u0092\3\2\2\2\u009b8\3\2\2\2\u009c\u00a0\t\5\2\2\u009d\u009f\t\6\2\2"+
		"\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1"+
		"\3\2\2\2\u00a1:\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\t\7\2\2\u00a4"+
		"\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\b\36\2\2\u00a9<\3\2\2\2\u00aa\u00ab"+
		"\7\17\2\2\u00ab\u00ae\7\f\2\2\u00ac\u00ae\t\b\2\2\u00ad\u00aa\3\2\2\2"+
		"\u00ad\u00ac\3\2\2\2\u00ae>\3\2\2\2\u00af\u00b0\7\61\2\2\u00b0\u00b1\7"+
		"\61\2\2\u00b1\u00b5\3\2\2\2\u00b2\u00b4\13\2\2\2\u00b3\u00b2\3\2\2\2\u00b4"+
		"\u00b7\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00c2\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7^\2\2\u00b9\u00bd\5=\37\2\u00ba"+
		"\u00bc\13\2\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00be\3"+
		"\2\2\2\u00bd\u00bb\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0"+
		"\u00b8\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00c5\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00d2\5=\37\2\u00c6"+
		"\u00c7\7\61\2\2\u00c7\u00c8\7,\2\2\u00c8\u00cc\3\2\2\2\u00c9\u00cb\13"+
		"\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cc"+
		"\u00ca\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\7,"+
		"\2\2\u00d0\u00d2\7\61\2\2\u00d1\u00af\3\2\2\2\u00d1\u00c6\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d4\b \2\2\u00d4@\3\2\2\2\20\2\u008b\u0090\u0098"+
		"\u009a\u009e\u00a0\u00a6\u00ad\u00b5\u00bd\u00c2\u00cc\u00d1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}