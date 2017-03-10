package fr.inria.diverse.docl.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import fr.inria.diverse.docl.services.DOclGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDOclParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_SCHEME", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'and'", "'or'", "'xor'", "'implies'", "'TupleType'", "'-'", "'not'", "'.'", "'->'", "'size'", "'includes'", "'excludes'", "'count'", "'includesAll'", "'excludesAll'", "'isEmpty'", "'notEmpty'", "'sum'", "'asBag'", "'asSet'", "'asSequence'", "'union'", "'flatten'", "'append'", "'prepend'", "'insertAt'", "'subSequence'", "'at'", "'indexOf'", "'first'", "'last'", "'including'", "'excluding'", "'exists'", "'forAll'", "'isUnique'", "'any'", "'one'", "'collect'", "'select'", "'reject'", "'<>'", "'='", "'>'", "'<'", "'>='", "'<='", "'+'", "'*'", "'/'", "'module'", "'@@source'", "'@@input'", "'uri='", "'://'", "':'", "'imports'", "'query'", "';'", "'in'", "'('", "')'", "','", "'|'", "'::'", "'{'", "'}'", "'invalid'", "'null'", "'then'", "'else'", "'endif'", "'let'", "'iterate'", "'allInstances'", "'Lambda'", "'Tuple'", "'true'", "'false'", "'if'", "'elseif'", "'self'", "'Env'", "'Map'", "'OclAny'", "'Set'", "'Sequence'", "'OrderedSet'", "'BagType'", "'Real'", "'Integer'", "'Boolean'", "'String'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int RULE_SCHEME=6;
    public static final int T__72=72;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=9;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__88=88;
    public static final int T__89=89;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalDOclParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDOclParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDOclParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDOcl.g"; }


    	private DOclGrammarAccess grammarAccess;

    	public void setGrammarAccess(DOclGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModule"
    // InternalDOcl.g:53:1: entryRuleModule : ruleModule EOF ;
    public final void entryRuleModule() throws RecognitionException {
        try {
            // InternalDOcl.g:54:1: ( ruleModule EOF )
            // InternalDOcl.g:55:1: ruleModule EOF
            {
             before(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_1);
            ruleModule();

            state._fsp--;

             after(grammarAccess.getModuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // InternalDOcl.g:62:1: ruleModule : ( ( rule__Module__Group__0 ) ) ;
    public final void ruleModule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:66:2: ( ( ( rule__Module__Group__0 ) ) )
            // InternalDOcl.g:67:2: ( ( rule__Module__Group__0 ) )
            {
            // InternalDOcl.g:67:2: ( ( rule__Module__Group__0 ) )
            // InternalDOcl.g:68:3: ( rule__Module__Group__0 )
            {
             before(grammarAccess.getModuleAccess().getGroup()); 
            // InternalDOcl.g:69:3: ( rule__Module__Group__0 )
            // InternalDOcl.g:69:4: rule__Module__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Module__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleOclModel"
    // InternalDOcl.g:78:1: entryRuleOclModel : ruleOclModel EOF ;
    public final void entryRuleOclModel() throws RecognitionException {
        try {
            // InternalDOcl.g:79:1: ( ruleOclModel EOF )
            // InternalDOcl.g:80:1: ruleOclModel EOF
            {
             before(grammarAccess.getOclModelRule()); 
            pushFollow(FOLLOW_1);
            ruleOclModel();

            state._fsp--;

             after(grammarAccess.getOclModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOclModel"


    // $ANTLR start "ruleOclModel"
    // InternalDOcl.g:87:1: ruleOclModel : ( ( rule__OclModel__Group__0 ) ) ;
    public final void ruleOclModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:91:2: ( ( ( rule__OclModel__Group__0 ) ) )
            // InternalDOcl.g:92:2: ( ( rule__OclModel__Group__0 ) )
            {
            // InternalDOcl.g:92:2: ( ( rule__OclModel__Group__0 ) )
            // InternalDOcl.g:93:3: ( rule__OclModel__Group__0 )
            {
             before(grammarAccess.getOclModelAccess().getGroup()); 
            // InternalDOcl.g:94:3: ( rule__OclModel__Group__0 )
            // InternalDOcl.g:94:4: rule__OclModel__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OclModel__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOclModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOclModel"


    // $ANTLR start "entryRuleURI_"
    // InternalDOcl.g:103:1: entryRuleURI_ : ruleURI_ EOF ;
    public final void entryRuleURI_() throws RecognitionException {
        try {
            // InternalDOcl.g:104:1: ( ruleURI_ EOF )
            // InternalDOcl.g:105:1: ruleURI_ EOF
            {
             before(grammarAccess.getURI_Rule()); 
            pushFollow(FOLLOW_1);
            ruleURI_();

            state._fsp--;

             after(grammarAccess.getURI_Rule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleURI_"


    // $ANTLR start "ruleURI_"
    // InternalDOcl.g:112:1: ruleURI_ : ( ( rule__URI___Group__0 ) ) ;
    public final void ruleURI_() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:116:2: ( ( ( rule__URI___Group__0 ) ) )
            // InternalDOcl.g:117:2: ( ( rule__URI___Group__0 ) )
            {
            // InternalDOcl.g:117:2: ( ( rule__URI___Group__0 ) )
            // InternalDOcl.g:118:3: ( rule__URI___Group__0 )
            {
             before(grammarAccess.getURI_Access().getGroup()); 
            // InternalDOcl.g:119:3: ( rule__URI___Group__0 )
            // InternalDOcl.g:119:4: rule__URI___Group__0
            {
            pushFollow(FOLLOW_2);
            rule__URI___Group__0();

            state._fsp--;


            }

             after(grammarAccess.getURI_Access().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleURI_"


    // $ANTLR start "entryRuleFRAGMENT"
    // InternalDOcl.g:128:1: entryRuleFRAGMENT : ruleFRAGMENT EOF ;
    public final void entryRuleFRAGMENT() throws RecognitionException {
        try {
            // InternalDOcl.g:129:1: ( ruleFRAGMENT EOF )
            // InternalDOcl.g:130:1: ruleFRAGMENT EOF
            {
             before(grammarAccess.getFRAGMENTRule()); 
            pushFollow(FOLLOW_1);
            ruleFRAGMENT();

            state._fsp--;

             after(grammarAccess.getFRAGMENTRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFRAGMENT"


    // $ANTLR start "ruleFRAGMENT"
    // InternalDOcl.g:137:1: ruleFRAGMENT : ( ( rule__FRAGMENT__Group__0 ) ) ;
    public final void ruleFRAGMENT() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:141:2: ( ( ( rule__FRAGMENT__Group__0 ) ) )
            // InternalDOcl.g:142:2: ( ( rule__FRAGMENT__Group__0 ) )
            {
            // InternalDOcl.g:142:2: ( ( rule__FRAGMENT__Group__0 ) )
            // InternalDOcl.g:143:3: ( rule__FRAGMENT__Group__0 )
            {
             before(grammarAccess.getFRAGMENTAccess().getGroup()); 
            // InternalDOcl.g:144:3: ( rule__FRAGMENT__Group__0 )
            // InternalDOcl.g:144:4: rule__FRAGMENT__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FRAGMENT__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFRAGMENTAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFRAGMENT"


    // $ANTLR start "entryRuleAUTHORITY"
    // InternalDOcl.g:153:1: entryRuleAUTHORITY : ruleAUTHORITY EOF ;
    public final void entryRuleAUTHORITY() throws RecognitionException {
        try {
            // InternalDOcl.g:154:1: ( ruleAUTHORITY EOF )
            // InternalDOcl.g:155:1: ruleAUTHORITY EOF
            {
             before(grammarAccess.getAUTHORITYRule()); 
            pushFollow(FOLLOW_1);
            ruleAUTHORITY();

            state._fsp--;

             after(grammarAccess.getAUTHORITYRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAUTHORITY"


    // $ANTLR start "ruleAUTHORITY"
    // InternalDOcl.g:162:1: ruleAUTHORITY : ( ( rule__AUTHORITY__Group__0 ) ) ;
    public final void ruleAUTHORITY() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:166:2: ( ( ( rule__AUTHORITY__Group__0 ) ) )
            // InternalDOcl.g:167:2: ( ( rule__AUTHORITY__Group__0 ) )
            {
            // InternalDOcl.g:167:2: ( ( rule__AUTHORITY__Group__0 ) )
            // InternalDOcl.g:168:3: ( rule__AUTHORITY__Group__0 )
            {
             before(grammarAccess.getAUTHORITYAccess().getGroup()); 
            // InternalDOcl.g:169:3: ( rule__AUTHORITY__Group__0 )
            // InternalDOcl.g:169:4: rule__AUTHORITY__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AUTHORITY__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAUTHORITYAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAUTHORITY"


    // $ANTLR start "entryRuleImport"
    // InternalDOcl.g:178:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // InternalDOcl.g:179:1: ( ruleImport EOF )
            // InternalDOcl.g:180:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalDOcl.g:187:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:191:2: ( ( ( rule__Import__Group__0 ) ) )
            // InternalDOcl.g:192:2: ( ( rule__Import__Group__0 ) )
            {
            // InternalDOcl.g:192:2: ( ( rule__Import__Group__0 ) )
            // InternalDOcl.g:193:3: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // InternalDOcl.g:194:3: ( rule__Import__Group__0 )
            // InternalDOcl.g:194:4: rule__Import__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleModuleElement"
    // InternalDOcl.g:203:1: entryRuleModuleElement : ruleModuleElement EOF ;
    public final void entryRuleModuleElement() throws RecognitionException {
        try {
            // InternalDOcl.g:204:1: ( ruleModuleElement EOF )
            // InternalDOcl.g:205:1: ruleModuleElement EOF
            {
             before(grammarAccess.getModuleElementRule()); 
            pushFollow(FOLLOW_1);
            ruleModuleElement();

            state._fsp--;

             after(grammarAccess.getModuleElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModuleElement"


    // $ANTLR start "ruleModuleElement"
    // InternalDOcl.g:212:1: ruleModuleElement : ( ruleQuery ) ;
    public final void ruleModuleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:216:2: ( ( ruleQuery ) )
            // InternalDOcl.g:217:2: ( ruleQuery )
            {
            // InternalDOcl.g:217:2: ( ruleQuery )
            // InternalDOcl.g:218:3: ruleQuery
            {
             before(grammarAccess.getModuleElementAccess().getQueryParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleQuery();

            state._fsp--;

             after(grammarAccess.getModuleElementAccess().getQueryParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModuleElement"


    // $ANTLR start "entryRuleQuery"
    // InternalDOcl.g:228:1: entryRuleQuery : ruleQuery EOF ;
    public final void entryRuleQuery() throws RecognitionException {
        try {
            // InternalDOcl.g:229:1: ( ruleQuery EOF )
            // InternalDOcl.g:230:1: ruleQuery EOF
            {
             before(grammarAccess.getQueryRule()); 
            pushFollow(FOLLOW_1);
            ruleQuery();

            state._fsp--;

             after(grammarAccess.getQueryRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQuery"


    // $ANTLR start "ruleQuery"
    // InternalDOcl.g:237:1: ruleQuery : ( ( rule__Query__Group__0 ) ) ;
    public final void ruleQuery() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:241:2: ( ( ( rule__Query__Group__0 ) ) )
            // InternalDOcl.g:242:2: ( ( rule__Query__Group__0 ) )
            {
            // InternalDOcl.g:242:2: ( ( rule__Query__Group__0 ) )
            // InternalDOcl.g:243:3: ( rule__Query__Group__0 )
            {
             before(grammarAccess.getQueryAccess().getGroup()); 
            // InternalDOcl.g:244:3: ( rule__Query__Group__0 )
            // InternalDOcl.g:244:4: rule__Query__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Query__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQueryAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQuery"


    // $ANTLR start "entryRuleUnaryOperator"
    // InternalDOcl.g:253:1: entryRuleUnaryOperator : ruleUnaryOperator EOF ;
    public final void entryRuleUnaryOperator() throws RecognitionException {
        try {
            // InternalDOcl.g:254:1: ( ruleUnaryOperator EOF )
            // InternalDOcl.g:255:1: ruleUnaryOperator EOF
            {
             before(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryOperator();

            state._fsp--;

             after(grammarAccess.getUnaryOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // InternalDOcl.g:262:1: ruleUnaryOperator : ( ( rule__UnaryOperator__Alternatives ) ) ;
    public final void ruleUnaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:266:2: ( ( ( rule__UnaryOperator__Alternatives ) ) )
            // InternalDOcl.g:267:2: ( ( rule__UnaryOperator__Alternatives ) )
            {
            // InternalDOcl.g:267:2: ( ( rule__UnaryOperator__Alternatives ) )
            // InternalDOcl.g:268:3: ( rule__UnaryOperator__Alternatives )
            {
             before(grammarAccess.getUnaryOperatorAccess().getAlternatives()); 
            // InternalDOcl.g:269:3: ( rule__UnaryOperator__Alternatives )
            // InternalDOcl.g:269:4: rule__UnaryOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getUnaryOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRuleAndOperator"
    // InternalDOcl.g:278:1: entryRuleAndOperator : ruleAndOperator EOF ;
    public final void entryRuleAndOperator() throws RecognitionException {
        try {
            // InternalDOcl.g:279:1: ( ruleAndOperator EOF )
            // InternalDOcl.g:280:1: ruleAndOperator EOF
            {
             before(grammarAccess.getAndOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleAndOperator();

            state._fsp--;

             after(grammarAccess.getAndOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAndOperator"


    // $ANTLR start "ruleAndOperator"
    // InternalDOcl.g:287:1: ruleAndOperator : ( 'and' ) ;
    public final void ruleAndOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:291:2: ( ( 'and' ) )
            // InternalDOcl.g:292:2: ( 'and' )
            {
            // InternalDOcl.g:292:2: ( 'and' )
            // InternalDOcl.g:293:3: 'and'
            {
             before(grammarAccess.getAndOperatorAccess().getAndKeyword()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getAndOperatorAccess().getAndKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAndOperator"


    // $ANTLR start "entryRuleOrOperator"
    // InternalDOcl.g:303:1: entryRuleOrOperator : ruleOrOperator EOF ;
    public final void entryRuleOrOperator() throws RecognitionException {
        try {
            // InternalDOcl.g:304:1: ( ruleOrOperator EOF )
            // InternalDOcl.g:305:1: ruleOrOperator EOF
            {
             before(grammarAccess.getOrOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleOrOperator();

            state._fsp--;

             after(grammarAccess.getOrOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrOperator"


    // $ANTLR start "ruleOrOperator"
    // InternalDOcl.g:312:1: ruleOrOperator : ( 'or' ) ;
    public final void ruleOrOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:316:2: ( ( 'or' ) )
            // InternalDOcl.g:317:2: ( 'or' )
            {
            // InternalDOcl.g:317:2: ( 'or' )
            // InternalDOcl.g:318:3: 'or'
            {
             before(grammarAccess.getOrOperatorAccess().getOrKeyword()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getOrOperatorAccess().getOrKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrOperator"


    // $ANTLR start "entryRuleXorOperator"
    // InternalDOcl.g:328:1: entryRuleXorOperator : ruleXorOperator EOF ;
    public final void entryRuleXorOperator() throws RecognitionException {
        try {
            // InternalDOcl.g:329:1: ( ruleXorOperator EOF )
            // InternalDOcl.g:330:1: ruleXorOperator EOF
            {
             before(grammarAccess.getXorOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleXorOperator();

            state._fsp--;

             after(grammarAccess.getXorOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXorOperator"


    // $ANTLR start "ruleXorOperator"
    // InternalDOcl.g:337:1: ruleXorOperator : ( 'xor' ) ;
    public final void ruleXorOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:341:2: ( ( 'xor' ) )
            // InternalDOcl.g:342:2: ( 'xor' )
            {
            // InternalDOcl.g:342:2: ( 'xor' )
            // InternalDOcl.g:343:3: 'xor'
            {
             before(grammarAccess.getXorOperatorAccess().getXorKeyword()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getXorOperatorAccess().getXorKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXorOperator"


    // $ANTLR start "entryRuleImpliesOperator"
    // InternalDOcl.g:353:1: entryRuleImpliesOperator : ruleImpliesOperator EOF ;
    public final void entryRuleImpliesOperator() throws RecognitionException {
        try {
            // InternalDOcl.g:354:1: ( ruleImpliesOperator EOF )
            // InternalDOcl.g:355:1: ruleImpliesOperator EOF
            {
             before(grammarAccess.getImpliesOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleImpliesOperator();

            state._fsp--;

             after(grammarAccess.getImpliesOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImpliesOperator"


    // $ANTLR start "ruleImpliesOperator"
    // InternalDOcl.g:362:1: ruleImpliesOperator : ( 'implies' ) ;
    public final void ruleImpliesOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:366:2: ( ( 'implies' ) )
            // InternalDOcl.g:367:2: ( 'implies' )
            {
            // InternalDOcl.g:367:2: ( 'implies' )
            // InternalDOcl.g:368:3: 'implies'
            {
             before(grammarAccess.getImpliesOperatorAccess().getImpliesKeyword()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getImpliesOperatorAccess().getImpliesKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImpliesOperator"


    // $ANTLR start "entryRuleNavigationOperator"
    // InternalDOcl.g:378:1: entryRuleNavigationOperator : ruleNavigationOperator EOF ;
    public final void entryRuleNavigationOperator() throws RecognitionException {
        try {
            // InternalDOcl.g:379:1: ( ruleNavigationOperator EOF )
            // InternalDOcl.g:380:1: ruleNavigationOperator EOF
            {
             before(grammarAccess.getNavigationOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleNavigationOperator();

            state._fsp--;

             after(grammarAccess.getNavigationOperatorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNavigationOperator"


    // $ANTLR start "ruleNavigationOperator"
    // InternalDOcl.g:387:1: ruleNavigationOperator : ( ( rule__NavigationOperator__Alternatives ) ) ;
    public final void ruleNavigationOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:391:2: ( ( ( rule__NavigationOperator__Alternatives ) ) )
            // InternalDOcl.g:392:2: ( ( rule__NavigationOperator__Alternatives ) )
            {
            // InternalDOcl.g:392:2: ( ( rule__NavigationOperator__Alternatives ) )
            // InternalDOcl.g:393:3: ( rule__NavigationOperator__Alternatives )
            {
             before(grammarAccess.getNavigationOperatorAccess().getAlternatives()); 
            // InternalDOcl.g:394:3: ( rule__NavigationOperator__Alternatives )
            // InternalDOcl.g:394:4: rule__NavigationOperator__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NavigationOperator__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNavigationOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNavigationOperator"


    // $ANTLR start "entryRuleCollectionOperationID"
    // InternalDOcl.g:403:1: entryRuleCollectionOperationID : ruleCollectionOperationID EOF ;
    public final void entryRuleCollectionOperationID() throws RecognitionException {
        try {
            // InternalDOcl.g:404:1: ( ruleCollectionOperationID EOF )
            // InternalDOcl.g:405:1: ruleCollectionOperationID EOF
            {
             before(grammarAccess.getCollectionOperationIDRule()); 
            pushFollow(FOLLOW_1);
            ruleCollectionOperationID();

            state._fsp--;

             after(grammarAccess.getCollectionOperationIDRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCollectionOperationID"


    // $ANTLR start "ruleCollectionOperationID"
    // InternalDOcl.g:412:1: ruleCollectionOperationID : ( ( rule__CollectionOperationID__Alternatives ) ) ;
    public final void ruleCollectionOperationID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:416:2: ( ( ( rule__CollectionOperationID__Alternatives ) ) )
            // InternalDOcl.g:417:2: ( ( rule__CollectionOperationID__Alternatives ) )
            {
            // InternalDOcl.g:417:2: ( ( rule__CollectionOperationID__Alternatives ) )
            // InternalDOcl.g:418:3: ( rule__CollectionOperationID__Alternatives )
            {
             before(grammarAccess.getCollectionOperationIDAccess().getAlternatives()); 
            // InternalDOcl.g:419:3: ( rule__CollectionOperationID__Alternatives )
            // InternalDOcl.g:419:4: rule__CollectionOperationID__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__CollectionOperationID__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getCollectionOperationIDAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCollectionOperationID"


    // $ANTLR start "entryRuleIterativeOperationID"
    // InternalDOcl.g:428:1: entryRuleIterativeOperationID : ruleIterativeOperationID EOF ;
    public final void entryRuleIterativeOperationID() throws RecognitionException {
        try {
            // InternalDOcl.g:429:1: ( ruleIterativeOperationID EOF )
            // InternalDOcl.g:430:1: ruleIterativeOperationID EOF
            {
             before(grammarAccess.getIterativeOperationIDRule()); 
            pushFollow(FOLLOW_1);
            ruleIterativeOperationID();

            state._fsp--;

             after(grammarAccess.getIterativeOperationIDRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIterativeOperationID"


    // $ANTLR start "ruleIterativeOperationID"
    // InternalDOcl.g:437:1: ruleIterativeOperationID : ( ( rule__IterativeOperationID__Alternatives ) ) ;
    public final void ruleIterativeOperationID() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:441:2: ( ( ( rule__IterativeOperationID__Alternatives ) ) )
            // InternalDOcl.g:442:2: ( ( rule__IterativeOperationID__Alternatives ) )
            {
            // InternalDOcl.g:442:2: ( ( rule__IterativeOperationID__Alternatives ) )
            // InternalDOcl.g:443:3: ( rule__IterativeOperationID__Alternatives )
            {
             before(grammarAccess.getIterativeOperationIDAccess().getAlternatives()); 
            // InternalDOcl.g:444:3: ( rule__IterativeOperationID__Alternatives )
            // InternalDOcl.g:444:4: rule__IterativeOperationID__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__IterativeOperationID__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getIterativeOperationIDAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIterativeOperationID"


    // $ANTLR start "entryRuleOclExpression"
    // InternalDOcl.g:453:1: entryRuleOclExpression : ruleOclExpression EOF ;
    public final void entryRuleOclExpression() throws RecognitionException {
        try {
            // InternalDOcl.g:454:1: ( ruleOclExpression EOF )
            // InternalDOcl.g:455:1: ruleOclExpression EOF
            {
             before(grammarAccess.getOclExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getOclExpressionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOclExpression"


    // $ANTLR start "ruleOclExpression"
    // InternalDOcl.g:462:1: ruleOclExpression : ( ( rule__OclExpression__Alternatives ) ) ;
    public final void ruleOclExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:466:2: ( ( ( rule__OclExpression__Alternatives ) ) )
            // InternalDOcl.g:467:2: ( ( rule__OclExpression__Alternatives ) )
            {
            // InternalDOcl.g:467:2: ( ( rule__OclExpression__Alternatives ) )
            // InternalDOcl.g:468:3: ( rule__OclExpression__Alternatives )
            {
             before(grammarAccess.getOclExpressionAccess().getAlternatives()); 
            // InternalDOcl.g:469:3: ( rule__OclExpression__Alternatives )
            // InternalDOcl.g:469:4: rule__OclExpression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OclExpression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOclExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOclExpression"


    // $ANTLR start "entryRuleLetExp"
    // InternalDOcl.g:478:1: entryRuleLetExp : ruleLetExp EOF ;
    public final void entryRuleLetExp() throws RecognitionException {
        try {
            // InternalDOcl.g:479:1: ( ruleLetExp EOF )
            // InternalDOcl.g:480:1: ruleLetExp EOF
            {
             before(grammarAccess.getLetExpRule()); 
            pushFollow(FOLLOW_1);
            ruleLetExp();

            state._fsp--;

             after(grammarAccess.getLetExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLetExp"


    // $ANTLR start "ruleLetExp"
    // InternalDOcl.g:487:1: ruleLetExp : ( ( rule__LetExp__Group__0 ) ) ;
    public final void ruleLetExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:491:2: ( ( ( rule__LetExp__Group__0 ) ) )
            // InternalDOcl.g:492:2: ( ( rule__LetExp__Group__0 ) )
            {
            // InternalDOcl.g:492:2: ( ( rule__LetExp__Group__0 ) )
            // InternalDOcl.g:493:3: ( rule__LetExp__Group__0 )
            {
             before(grammarAccess.getLetExpAccess().getGroup()); 
            // InternalDOcl.g:494:3: ( rule__LetExp__Group__0 )
            // InternalDOcl.g:494:4: rule__LetExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LetExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLetExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLetExp"


    // $ANTLR start "entryRuleUnaryOpExp"
    // InternalDOcl.g:503:1: entryRuleUnaryOpExp : ruleUnaryOpExp EOF ;
    public final void entryRuleUnaryOpExp() throws RecognitionException {
        try {
            // InternalDOcl.g:504:1: ( ruleUnaryOpExp EOF )
            // InternalDOcl.g:505:1: ruleUnaryOpExp EOF
            {
             before(grammarAccess.getUnaryOpExpRule()); 
            pushFollow(FOLLOW_1);
            ruleUnaryOpExp();

            state._fsp--;

             after(grammarAccess.getUnaryOpExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnaryOpExp"


    // $ANTLR start "ruleUnaryOpExp"
    // InternalDOcl.g:512:1: ruleUnaryOpExp : ( ( rule__UnaryOpExp__Group__0 ) ) ;
    public final void ruleUnaryOpExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:516:2: ( ( ( rule__UnaryOpExp__Group__0 ) ) )
            // InternalDOcl.g:517:2: ( ( rule__UnaryOpExp__Group__0 ) )
            {
            // InternalDOcl.g:517:2: ( ( rule__UnaryOpExp__Group__0 ) )
            // InternalDOcl.g:518:3: ( rule__UnaryOpExp__Group__0 )
            {
             before(grammarAccess.getUnaryOpExpAccess().getGroup()); 
            // InternalDOcl.g:519:3: ( rule__UnaryOpExp__Group__0 )
            // InternalDOcl.g:519:4: rule__UnaryOpExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOpExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnaryOpExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnaryOpExp"


    // $ANTLR start "entryRuleImpliesOpExp"
    // InternalDOcl.g:528:1: entryRuleImpliesOpExp : ruleImpliesOpExp EOF ;
    public final void entryRuleImpliesOpExp() throws RecognitionException {
        try {
            // InternalDOcl.g:529:1: ( ruleImpliesOpExp EOF )
            // InternalDOcl.g:530:1: ruleImpliesOpExp EOF
            {
             before(grammarAccess.getImpliesOpExpRule()); 
            pushFollow(FOLLOW_1);
            ruleImpliesOpExp();

            state._fsp--;

             after(grammarAccess.getImpliesOpExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImpliesOpExp"


    // $ANTLR start "ruleImpliesOpExp"
    // InternalDOcl.g:537:1: ruleImpliesOpExp : ( ( rule__ImpliesOpExp__Group__0 ) ) ;
    public final void ruleImpliesOpExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:541:2: ( ( ( rule__ImpliesOpExp__Group__0 ) ) )
            // InternalDOcl.g:542:2: ( ( rule__ImpliesOpExp__Group__0 ) )
            {
            // InternalDOcl.g:542:2: ( ( rule__ImpliesOpExp__Group__0 ) )
            // InternalDOcl.g:543:3: ( rule__ImpliesOpExp__Group__0 )
            {
             before(grammarAccess.getImpliesOpExpAccess().getGroup()); 
            // InternalDOcl.g:544:3: ( rule__ImpliesOpExp__Group__0 )
            // InternalDOcl.g:544:4: rule__ImpliesOpExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ImpliesOpExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImpliesOpExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImpliesOpExp"


    // $ANTLR start "entryRuleXorOpExp"
    // InternalDOcl.g:553:1: entryRuleXorOpExp : ruleXorOpExp EOF ;
    public final void entryRuleXorOpExp() throws RecognitionException {
        try {
            // InternalDOcl.g:554:1: ( ruleXorOpExp EOF )
            // InternalDOcl.g:555:1: ruleXorOpExp EOF
            {
             before(grammarAccess.getXorOpExpRule()); 
            pushFollow(FOLLOW_1);
            ruleXorOpExp();

            state._fsp--;

             after(grammarAccess.getXorOpExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXorOpExp"


    // $ANTLR start "ruleXorOpExp"
    // InternalDOcl.g:562:1: ruleXorOpExp : ( ( rule__XorOpExp__Group__0 ) ) ;
    public final void ruleXorOpExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:566:2: ( ( ( rule__XorOpExp__Group__0 ) ) )
            // InternalDOcl.g:567:2: ( ( rule__XorOpExp__Group__0 ) )
            {
            // InternalDOcl.g:567:2: ( ( rule__XorOpExp__Group__0 ) )
            // InternalDOcl.g:568:3: ( rule__XorOpExp__Group__0 )
            {
             before(grammarAccess.getXorOpExpAccess().getGroup()); 
            // InternalDOcl.g:569:3: ( rule__XorOpExp__Group__0 )
            // InternalDOcl.g:569:4: rule__XorOpExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__XorOpExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getXorOpExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXorOpExp"


    // $ANTLR start "entryRuleOrOpExp"
    // InternalDOcl.g:578:1: entryRuleOrOpExp : ruleOrOpExp EOF ;
    public final void entryRuleOrOpExp() throws RecognitionException {
        try {
            // InternalDOcl.g:579:1: ( ruleOrOpExp EOF )
            // InternalDOcl.g:580:1: ruleOrOpExp EOF
            {
             before(grammarAccess.getOrOpExpRule()); 
            pushFollow(FOLLOW_1);
            ruleOrOpExp();

            state._fsp--;

             after(grammarAccess.getOrOpExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrOpExp"


    // $ANTLR start "ruleOrOpExp"
    // InternalDOcl.g:587:1: ruleOrOpExp : ( ( rule__OrOpExp__Group__0 ) ) ;
    public final void ruleOrOpExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:591:2: ( ( ( rule__OrOpExp__Group__0 ) ) )
            // InternalDOcl.g:592:2: ( ( rule__OrOpExp__Group__0 ) )
            {
            // InternalDOcl.g:592:2: ( ( rule__OrOpExp__Group__0 ) )
            // InternalDOcl.g:593:3: ( rule__OrOpExp__Group__0 )
            {
             before(grammarAccess.getOrOpExpAccess().getGroup()); 
            // InternalDOcl.g:594:3: ( rule__OrOpExp__Group__0 )
            // InternalDOcl.g:594:4: rule__OrOpExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OrOpExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrOpExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrOpExp"


    // $ANTLR start "entryRuleAndOpExp"
    // InternalDOcl.g:603:1: entryRuleAndOpExp : ruleAndOpExp EOF ;
    public final void entryRuleAndOpExp() throws RecognitionException {
        try {
            // InternalDOcl.g:604:1: ( ruleAndOpExp EOF )
            // InternalDOcl.g:605:1: ruleAndOpExp EOF
            {
             before(grammarAccess.getAndOpExpRule()); 
            pushFollow(FOLLOW_1);
            ruleAndOpExp();

            state._fsp--;

             after(grammarAccess.getAndOpExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAndOpExp"


    // $ANTLR start "ruleAndOpExp"
    // InternalDOcl.g:612:1: ruleAndOpExp : ( ( rule__AndOpExp__Group__0 ) ) ;
    public final void ruleAndOpExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:616:2: ( ( ( rule__AndOpExp__Group__0 ) ) )
            // InternalDOcl.g:617:2: ( ( rule__AndOpExp__Group__0 ) )
            {
            // InternalDOcl.g:617:2: ( ( rule__AndOpExp__Group__0 ) )
            // InternalDOcl.g:618:3: ( rule__AndOpExp__Group__0 )
            {
             before(grammarAccess.getAndOpExpAccess().getGroup()); 
            // InternalDOcl.g:619:3: ( rule__AndOpExp__Group__0 )
            // InternalDOcl.g:619:4: rule__AndOpExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AndOpExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAndOpExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAndOpExp"


    // $ANTLR start "entryRuleEqOpExp"
    // InternalDOcl.g:628:1: entryRuleEqOpExp : ruleEqOpExp EOF ;
    public final void entryRuleEqOpExp() throws RecognitionException {
        try {
            // InternalDOcl.g:629:1: ( ruleEqOpExp EOF )
            // InternalDOcl.g:630:1: ruleEqOpExp EOF
            {
             before(grammarAccess.getEqOpExpRule()); 
            pushFollow(FOLLOW_1);
            ruleEqOpExp();

            state._fsp--;

             after(grammarAccess.getEqOpExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEqOpExp"


    // $ANTLR start "ruleEqOpExp"
    // InternalDOcl.g:637:1: ruleEqOpExp : ( ( rule__EqOpExp__Group__0 ) ) ;
    public final void ruleEqOpExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:641:2: ( ( ( rule__EqOpExp__Group__0 ) ) )
            // InternalDOcl.g:642:2: ( ( rule__EqOpExp__Group__0 ) )
            {
            // InternalDOcl.g:642:2: ( ( rule__EqOpExp__Group__0 ) )
            // InternalDOcl.g:643:3: ( rule__EqOpExp__Group__0 )
            {
             before(grammarAccess.getEqOpExpAccess().getGroup()); 
            // InternalDOcl.g:644:3: ( rule__EqOpExp__Group__0 )
            // InternalDOcl.g:644:4: rule__EqOpExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EqOpExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEqOpExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEqOpExp"


    // $ANTLR start "entryRuleComparisonOpExp"
    // InternalDOcl.g:653:1: entryRuleComparisonOpExp : ruleComparisonOpExp EOF ;
    public final void entryRuleComparisonOpExp() throws RecognitionException {
        try {
            // InternalDOcl.g:654:1: ( ruleComparisonOpExp EOF )
            // InternalDOcl.g:655:1: ruleComparisonOpExp EOF
            {
             before(grammarAccess.getComparisonOpExpRule()); 
            pushFollow(FOLLOW_1);
            ruleComparisonOpExp();

            state._fsp--;

             after(grammarAccess.getComparisonOpExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleComparisonOpExp"


    // $ANTLR start "ruleComparisonOpExp"
    // InternalDOcl.g:662:1: ruleComparisonOpExp : ( ( rule__ComparisonOpExp__Group__0 ) ) ;
    public final void ruleComparisonOpExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:666:2: ( ( ( rule__ComparisonOpExp__Group__0 ) ) )
            // InternalDOcl.g:667:2: ( ( rule__ComparisonOpExp__Group__0 ) )
            {
            // InternalDOcl.g:667:2: ( ( rule__ComparisonOpExp__Group__0 ) )
            // InternalDOcl.g:668:3: ( rule__ComparisonOpExp__Group__0 )
            {
             before(grammarAccess.getComparisonOpExpAccess().getGroup()); 
            // InternalDOcl.g:669:3: ( rule__ComparisonOpExp__Group__0 )
            // InternalDOcl.g:669:4: rule__ComparisonOpExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonOpExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonOpExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleComparisonOpExp"


    // $ANTLR start "entryRuleAdditionOpExp"
    // InternalDOcl.g:678:1: entryRuleAdditionOpExp : ruleAdditionOpExp EOF ;
    public final void entryRuleAdditionOpExp() throws RecognitionException {
        try {
            // InternalDOcl.g:679:1: ( ruleAdditionOpExp EOF )
            // InternalDOcl.g:680:1: ruleAdditionOpExp EOF
            {
             before(grammarAccess.getAdditionOpExpRule()); 
            pushFollow(FOLLOW_1);
            ruleAdditionOpExp();

            state._fsp--;

             after(grammarAccess.getAdditionOpExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAdditionOpExp"


    // $ANTLR start "ruleAdditionOpExp"
    // InternalDOcl.g:687:1: ruleAdditionOpExp : ( ( rule__AdditionOpExp__Group__0 ) ) ;
    public final void ruleAdditionOpExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:691:2: ( ( ( rule__AdditionOpExp__Group__0 ) ) )
            // InternalDOcl.g:692:2: ( ( rule__AdditionOpExp__Group__0 ) )
            {
            // InternalDOcl.g:692:2: ( ( rule__AdditionOpExp__Group__0 ) )
            // InternalDOcl.g:693:3: ( rule__AdditionOpExp__Group__0 )
            {
             before(grammarAccess.getAdditionOpExpAccess().getGroup()); 
            // InternalDOcl.g:694:3: ( rule__AdditionOpExp__Group__0 )
            // InternalDOcl.g:694:4: rule__AdditionOpExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AdditionOpExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAdditionOpExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAdditionOpExp"


    // $ANTLR start "entryRuleMultiOpExp"
    // InternalDOcl.g:703:1: entryRuleMultiOpExp : ruleMultiOpExp EOF ;
    public final void entryRuleMultiOpExp() throws RecognitionException {
        try {
            // InternalDOcl.g:704:1: ( ruleMultiOpExp EOF )
            // InternalDOcl.g:705:1: ruleMultiOpExp EOF
            {
             before(grammarAccess.getMultiOpExpRule()); 
            pushFollow(FOLLOW_1);
            ruleMultiOpExp();

            state._fsp--;

             after(grammarAccess.getMultiOpExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMultiOpExp"


    // $ANTLR start "ruleMultiOpExp"
    // InternalDOcl.g:712:1: ruleMultiOpExp : ( ( rule__MultiOpExp__Group__0 ) ) ;
    public final void ruleMultiOpExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:716:2: ( ( ( rule__MultiOpExp__Group__0 ) ) )
            // InternalDOcl.g:717:2: ( ( rule__MultiOpExp__Group__0 ) )
            {
            // InternalDOcl.g:717:2: ( ( rule__MultiOpExp__Group__0 ) )
            // InternalDOcl.g:718:3: ( rule__MultiOpExp__Group__0 )
            {
             before(grammarAccess.getMultiOpExpAccess().getGroup()); 
            // InternalDOcl.g:719:3: ( rule__MultiOpExp__Group__0 )
            // InternalDOcl.g:719:4: rule__MultiOpExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MultiOpExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiOpExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiOpExp"


    // $ANTLR start "entryRuleNavOpExp"
    // InternalDOcl.g:728:1: entryRuleNavOpExp : ruleNavOpExp EOF ;
    public final void entryRuleNavOpExp() throws RecognitionException {
        try {
            // InternalDOcl.g:729:1: ( ruleNavOpExp EOF )
            // InternalDOcl.g:730:1: ruleNavOpExp EOF
            {
             before(grammarAccess.getNavOpExpRule()); 
            pushFollow(FOLLOW_1);
            ruleNavOpExp();

            state._fsp--;

             after(grammarAccess.getNavOpExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNavOpExp"


    // $ANTLR start "ruleNavOpExp"
    // InternalDOcl.g:737:1: ruleNavOpExp : ( ( rule__NavOpExp__Group__0 ) ) ;
    public final void ruleNavOpExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:741:2: ( ( ( rule__NavOpExp__Group__0 ) ) )
            // InternalDOcl.g:742:2: ( ( rule__NavOpExp__Group__0 ) )
            {
            // InternalDOcl.g:742:2: ( ( rule__NavOpExp__Group__0 ) )
            // InternalDOcl.g:743:3: ( rule__NavOpExp__Group__0 )
            {
             before(grammarAccess.getNavOpExpAccess().getGroup()); 
            // InternalDOcl.g:744:3: ( rule__NavOpExp__Group__0 )
            // InternalDOcl.g:744:4: rule__NavOpExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NavOpExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNavOpExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNavOpExp"


    // $ANTLR start "entryRuleNavigationOpCallExp"
    // InternalDOcl.g:753:1: entryRuleNavigationOpCallExp : ruleNavigationOpCallExp EOF ;
    public final void entryRuleNavigationOpCallExp() throws RecognitionException {
        try {
            // InternalDOcl.g:754:1: ( ruleNavigationOpCallExp EOF )
            // InternalDOcl.g:755:1: ruleNavigationOpCallExp EOF
            {
             before(grammarAccess.getNavigationOpCallExpRule()); 
            pushFollow(FOLLOW_1);
            ruleNavigationOpCallExp();

            state._fsp--;

             after(grammarAccess.getNavigationOpCallExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNavigationOpCallExp"


    // $ANTLR start "ruleNavigationOpCallExp"
    // InternalDOcl.g:762:1: ruleNavigationOpCallExp : ( ( rule__NavigationOpCallExp__Alternatives ) ) ;
    public final void ruleNavigationOpCallExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:766:2: ( ( ( rule__NavigationOpCallExp__Alternatives ) ) )
            // InternalDOcl.g:767:2: ( ( rule__NavigationOpCallExp__Alternatives ) )
            {
            // InternalDOcl.g:767:2: ( ( rule__NavigationOpCallExp__Alternatives ) )
            // InternalDOcl.g:768:3: ( rule__NavigationOpCallExp__Alternatives )
            {
             before(grammarAccess.getNavigationOpCallExpAccess().getAlternatives()); 
            // InternalDOcl.g:769:3: ( rule__NavigationOpCallExp__Alternatives )
            // InternalDOcl.g:769:4: rule__NavigationOpCallExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NavigationOpCallExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNavigationOpCallExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNavigationOpCallExp"


    // $ANTLR start "entryRuleCollectionOpCall"
    // InternalDOcl.g:778:1: entryRuleCollectionOpCall : ruleCollectionOpCall EOF ;
    public final void entryRuleCollectionOpCall() throws RecognitionException {
        try {
            // InternalDOcl.g:779:1: ( ruleCollectionOpCall EOF )
            // InternalDOcl.g:780:1: ruleCollectionOpCall EOF
            {
             before(grammarAccess.getCollectionOpCallRule()); 
            pushFollow(FOLLOW_1);
            ruleCollectionOpCall();

            state._fsp--;

             after(grammarAccess.getCollectionOpCallRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCollectionOpCall"


    // $ANTLR start "ruleCollectionOpCall"
    // InternalDOcl.g:787:1: ruleCollectionOpCall : ( ( rule__CollectionOpCall__Group__0 ) ) ;
    public final void ruleCollectionOpCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:791:2: ( ( ( rule__CollectionOpCall__Group__0 ) ) )
            // InternalDOcl.g:792:2: ( ( rule__CollectionOpCall__Group__0 ) )
            {
            // InternalDOcl.g:792:2: ( ( rule__CollectionOpCall__Group__0 ) )
            // InternalDOcl.g:793:3: ( rule__CollectionOpCall__Group__0 )
            {
             before(grammarAccess.getCollectionOpCallAccess().getGroup()); 
            // InternalDOcl.g:794:3: ( rule__CollectionOpCall__Group__0 )
            // InternalDOcl.g:794:4: rule__CollectionOpCall__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCollectionOpCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCollectionOpCall"


    // $ANTLR start "entryRuleIterateExp"
    // InternalDOcl.g:803:1: entryRuleIterateExp : ruleIterateExp EOF ;
    public final void entryRuleIterateExp() throws RecognitionException {
        try {
            // InternalDOcl.g:804:1: ( ruleIterateExp EOF )
            // InternalDOcl.g:805:1: ruleIterateExp EOF
            {
             before(grammarAccess.getIterateExpRule()); 
            pushFollow(FOLLOW_1);
            ruleIterateExp();

            state._fsp--;

             after(grammarAccess.getIterateExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIterateExp"


    // $ANTLR start "ruleIterateExp"
    // InternalDOcl.g:812:1: ruleIterateExp : ( ( rule__IterateExp__Group__0 ) ) ;
    public final void ruleIterateExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:816:2: ( ( ( rule__IterateExp__Group__0 ) ) )
            // InternalDOcl.g:817:2: ( ( rule__IterateExp__Group__0 ) )
            {
            // InternalDOcl.g:817:2: ( ( rule__IterateExp__Group__0 ) )
            // InternalDOcl.g:818:3: ( rule__IterateExp__Group__0 )
            {
             before(grammarAccess.getIterateExpAccess().getGroup()); 
            // InternalDOcl.g:819:3: ( rule__IterateExp__Group__0 )
            // InternalDOcl.g:819:4: rule__IterateExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IterateExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIterateExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIterateExp"


    // $ANTLR start "entryRuleIterator"
    // InternalDOcl.g:828:1: entryRuleIterator : ruleIterator EOF ;
    public final void entryRuleIterator() throws RecognitionException {
        try {
            // InternalDOcl.g:829:1: ( ruleIterator EOF )
            // InternalDOcl.g:830:1: ruleIterator EOF
            {
             before(grammarAccess.getIteratorRule()); 
            pushFollow(FOLLOW_1);
            ruleIterator();

            state._fsp--;

             after(grammarAccess.getIteratorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIterator"


    // $ANTLR start "ruleIterator"
    // InternalDOcl.g:837:1: ruleIterator : ( ( rule__Iterator__Group__0 ) ) ;
    public final void ruleIterator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:841:2: ( ( ( rule__Iterator__Group__0 ) ) )
            // InternalDOcl.g:842:2: ( ( rule__Iterator__Group__0 ) )
            {
            // InternalDOcl.g:842:2: ( ( rule__Iterator__Group__0 ) )
            // InternalDOcl.g:843:3: ( rule__Iterator__Group__0 )
            {
             before(grammarAccess.getIteratorAccess().getGroup()); 
            // InternalDOcl.g:844:3: ( rule__Iterator__Group__0 )
            // InternalDOcl.g:844:4: rule__Iterator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Iterator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIteratorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIterator"


    // $ANTLR start "entryRuleIteratorExp"
    // InternalDOcl.g:853:1: entryRuleIteratorExp : ruleIteratorExp EOF ;
    public final void entryRuleIteratorExp() throws RecognitionException {
        try {
            // InternalDOcl.g:854:1: ( ruleIteratorExp EOF )
            // InternalDOcl.g:855:1: ruleIteratorExp EOF
            {
             before(grammarAccess.getIteratorExpRule()); 
            pushFollow(FOLLOW_1);
            ruleIteratorExp();

            state._fsp--;

             after(grammarAccess.getIteratorExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIteratorExp"


    // $ANTLR start "ruleIteratorExp"
    // InternalDOcl.g:862:1: ruleIteratorExp : ( ( rule__IteratorExp__Group__0 ) ) ;
    public final void ruleIteratorExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:866:2: ( ( ( rule__IteratorExp__Group__0 ) ) )
            // InternalDOcl.g:867:2: ( ( rule__IteratorExp__Group__0 ) )
            {
            // InternalDOcl.g:867:2: ( ( rule__IteratorExp__Group__0 ) )
            // InternalDOcl.g:868:3: ( rule__IteratorExp__Group__0 )
            {
             before(grammarAccess.getIteratorExpAccess().getGroup()); 
            // InternalDOcl.g:869:3: ( rule__IteratorExp__Group__0 )
            // InternalDOcl.g:869:4: rule__IteratorExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IteratorExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIteratorExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIteratorExp"


    // $ANTLR start "entryRuleNavigationOrAttributeCall"
    // InternalDOcl.g:878:1: entryRuleNavigationOrAttributeCall : ruleNavigationOrAttributeCall EOF ;
    public final void entryRuleNavigationOrAttributeCall() throws RecognitionException {
        try {
            // InternalDOcl.g:879:1: ( ruleNavigationOrAttributeCall EOF )
            // InternalDOcl.g:880:1: ruleNavigationOrAttributeCall EOF
            {
             before(grammarAccess.getNavigationOrAttributeCallRule()); 
            pushFollow(FOLLOW_1);
            ruleNavigationOrAttributeCall();

            state._fsp--;

             after(grammarAccess.getNavigationOrAttributeCallRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNavigationOrAttributeCall"


    // $ANTLR start "ruleNavigationOrAttributeCall"
    // InternalDOcl.g:887:1: ruleNavigationOrAttributeCall : ( ( rule__NavigationOrAttributeCall__Group__0 ) ) ;
    public final void ruleNavigationOrAttributeCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:891:2: ( ( ( rule__NavigationOrAttributeCall__Group__0 ) ) )
            // InternalDOcl.g:892:2: ( ( rule__NavigationOrAttributeCall__Group__0 ) )
            {
            // InternalDOcl.g:892:2: ( ( rule__NavigationOrAttributeCall__Group__0 ) )
            // InternalDOcl.g:893:3: ( rule__NavigationOrAttributeCall__Group__0 )
            {
             before(grammarAccess.getNavigationOrAttributeCallAccess().getGroup()); 
            // InternalDOcl.g:894:3: ( rule__NavigationOrAttributeCall__Group__0 )
            // InternalDOcl.g:894:4: rule__NavigationOrAttributeCall__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NavigationOrAttributeCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNavigationOrAttributeCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNavigationOrAttributeCall"


    // $ANTLR start "entryRuleOperationCall"
    // InternalDOcl.g:903:1: entryRuleOperationCall : ruleOperationCall EOF ;
    public final void entryRuleOperationCall() throws RecognitionException {
        try {
            // InternalDOcl.g:904:1: ( ruleOperationCall EOF )
            // InternalDOcl.g:905:1: ruleOperationCall EOF
            {
             before(grammarAccess.getOperationCallRule()); 
            pushFollow(FOLLOW_1);
            ruleOperationCall();

            state._fsp--;

             after(grammarAccess.getOperationCallRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOperationCall"


    // $ANTLR start "ruleOperationCall"
    // InternalDOcl.g:912:1: ruleOperationCall : ( ( rule__OperationCall__Group__0 ) ) ;
    public final void ruleOperationCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:916:2: ( ( ( rule__OperationCall__Group__0 ) ) )
            // InternalDOcl.g:917:2: ( ( rule__OperationCall__Group__0 ) )
            {
            // InternalDOcl.g:917:2: ( ( rule__OperationCall__Group__0 ) )
            // InternalDOcl.g:918:3: ( rule__OperationCall__Group__0 )
            {
             before(grammarAccess.getOperationCallAccess().getGroup()); 
            // InternalDOcl.g:919:3: ( rule__OperationCall__Group__0 )
            // InternalDOcl.g:919:4: rule__OperationCall__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOperationCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOperationCall"


    // $ANTLR start "entryRuleOclModelElementExp"
    // InternalDOcl.g:928:1: entryRuleOclModelElementExp : ruleOclModelElementExp EOF ;
    public final void entryRuleOclModelElementExp() throws RecognitionException {
        try {
            // InternalDOcl.g:929:1: ( ruleOclModelElementExp EOF )
            // InternalDOcl.g:930:1: ruleOclModelElementExp EOF
            {
             before(grammarAccess.getOclModelElementExpRule()); 
            pushFollow(FOLLOW_1);
            ruleOclModelElementExp();

            state._fsp--;

             after(grammarAccess.getOclModelElementExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOclModelElementExp"


    // $ANTLR start "ruleOclModelElementExp"
    // InternalDOcl.g:937:1: ruleOclModelElementExp : ( ( rule__OclModelElementExp__Group__0 ) ) ;
    public final void ruleOclModelElementExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:941:2: ( ( ( rule__OclModelElementExp__Group__0 ) ) )
            // InternalDOcl.g:942:2: ( ( rule__OclModelElementExp__Group__0 ) )
            {
            // InternalDOcl.g:942:2: ( ( rule__OclModelElementExp__Group__0 ) )
            // InternalDOcl.g:943:3: ( rule__OclModelElementExp__Group__0 )
            {
             before(grammarAccess.getOclModelElementExpAccess().getGroup()); 
            // InternalDOcl.g:944:3: ( rule__OclModelElementExp__Group__0 )
            // InternalDOcl.g:944:4: rule__OclModelElementExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OclModelElementExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOclModelElementExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOclModelElementExp"


    // $ANTLR start "entryRuleAllInstancesOpCall"
    // InternalDOcl.g:953:1: entryRuleAllInstancesOpCall : ruleAllInstancesOpCall EOF ;
    public final void entryRuleAllInstancesOpCall() throws RecognitionException {
        try {
            // InternalDOcl.g:954:1: ( ruleAllInstancesOpCall EOF )
            // InternalDOcl.g:955:1: ruleAllInstancesOpCall EOF
            {
             before(grammarAccess.getAllInstancesOpCallRule()); 
            pushFollow(FOLLOW_1);
            ruleAllInstancesOpCall();

            state._fsp--;

             after(grammarAccess.getAllInstancesOpCallRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAllInstancesOpCall"


    // $ANTLR start "ruleAllInstancesOpCall"
    // InternalDOcl.g:962:1: ruleAllInstancesOpCall : ( ( rule__AllInstancesOpCall__Group__0 ) ) ;
    public final void ruleAllInstancesOpCall() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:966:2: ( ( ( rule__AllInstancesOpCall__Group__0 ) ) )
            // InternalDOcl.g:967:2: ( ( rule__AllInstancesOpCall__Group__0 ) )
            {
            // InternalDOcl.g:967:2: ( ( rule__AllInstancesOpCall__Group__0 ) )
            // InternalDOcl.g:968:3: ( rule__AllInstancesOpCall__Group__0 )
            {
             before(grammarAccess.getAllInstancesOpCallAccess().getGroup()); 
            // InternalDOcl.g:969:3: ( rule__AllInstancesOpCall__Group__0 )
            // InternalDOcl.g:969:4: rule__AllInstancesOpCall__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AllInstancesOpCall__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAllInstancesOpCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAllInstancesOpCall"


    // $ANTLR start "entryRuleLocalVariable"
    // InternalDOcl.g:978:1: entryRuleLocalVariable : ruleLocalVariable EOF ;
    public final void entryRuleLocalVariable() throws RecognitionException {
        try {
            // InternalDOcl.g:979:1: ( ruleLocalVariable EOF )
            // InternalDOcl.g:980:1: ruleLocalVariable EOF
            {
             before(grammarAccess.getLocalVariableRule()); 
            pushFollow(FOLLOW_1);
            ruleLocalVariable();

            state._fsp--;

             after(grammarAccess.getLocalVariableRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLocalVariable"


    // $ANTLR start "ruleLocalVariable"
    // InternalDOcl.g:987:1: ruleLocalVariable : ( ( rule__LocalVariable__Group__0 ) ) ;
    public final void ruleLocalVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:991:2: ( ( ( rule__LocalVariable__Group__0 ) ) )
            // InternalDOcl.g:992:2: ( ( rule__LocalVariable__Group__0 ) )
            {
            // InternalDOcl.g:992:2: ( ( rule__LocalVariable__Group__0 ) )
            // InternalDOcl.g:993:3: ( rule__LocalVariable__Group__0 )
            {
             before(grammarAccess.getLocalVariableAccess().getGroup()); 
            // InternalDOcl.g:994:3: ( rule__LocalVariable__Group__0 )
            // InternalDOcl.g:994:4: rule__LocalVariable__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LocalVariable__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLocalVariableAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLocalVariable"


    // $ANTLR start "entryRulePrimaryExp"
    // InternalDOcl.g:1003:1: entryRulePrimaryExp : rulePrimaryExp EOF ;
    public final void entryRulePrimaryExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1004:1: ( rulePrimaryExp EOF )
            // InternalDOcl.g:1005:1: rulePrimaryExp EOF
            {
             before(grammarAccess.getPrimaryExpRule()); 
            pushFollow(FOLLOW_1);
            rulePrimaryExp();

            state._fsp--;

             after(grammarAccess.getPrimaryExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimaryExp"


    // $ANTLR start "rulePrimaryExp"
    // InternalDOcl.g:1012:1: rulePrimaryExp : ( ( rule__PrimaryExp__Alternatives ) ) ;
    public final void rulePrimaryExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1016:2: ( ( ( rule__PrimaryExp__Alternatives ) ) )
            // InternalDOcl.g:1017:2: ( ( rule__PrimaryExp__Alternatives ) )
            {
            // InternalDOcl.g:1017:2: ( ( rule__PrimaryExp__Alternatives ) )
            // InternalDOcl.g:1018:3: ( rule__PrimaryExp__Alternatives )
            {
             before(grammarAccess.getPrimaryExpAccess().getAlternatives()); 
            // InternalDOcl.g:1019:3: ( rule__PrimaryExp__Alternatives )
            // InternalDOcl.g:1019:4: rule__PrimaryExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimaryExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimaryExp"


    // $ANTLR start "entryRuleLambdaExp"
    // InternalDOcl.g:1028:1: entryRuleLambdaExp : ruleLambdaExp EOF ;
    public final void entryRuleLambdaExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1029:1: ( ruleLambdaExp EOF )
            // InternalDOcl.g:1030:1: ruleLambdaExp EOF
            {
             before(grammarAccess.getLambdaExpRule()); 
            pushFollow(FOLLOW_1);
            ruleLambdaExp();

            state._fsp--;

             after(grammarAccess.getLambdaExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLambdaExp"


    // $ANTLR start "ruleLambdaExp"
    // InternalDOcl.g:1037:1: ruleLambdaExp : ( ( rule__LambdaExp__Group__0 ) ) ;
    public final void ruleLambdaExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1041:2: ( ( ( rule__LambdaExp__Group__0 ) ) )
            // InternalDOcl.g:1042:2: ( ( rule__LambdaExp__Group__0 ) )
            {
            // InternalDOcl.g:1042:2: ( ( rule__LambdaExp__Group__0 ) )
            // InternalDOcl.g:1043:3: ( rule__LambdaExp__Group__0 )
            {
             before(grammarAccess.getLambdaExpAccess().getGroup()); 
            // InternalDOcl.g:1044:3: ( rule__LambdaExp__Group__0 )
            // InternalDOcl.g:1044:4: rule__LambdaExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LambdaExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLambdaExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLambdaExp"


    // $ANTLR start "entryRuleTupleExp"
    // InternalDOcl.g:1053:1: entryRuleTupleExp : ruleTupleExp EOF ;
    public final void entryRuleTupleExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1054:1: ( ruleTupleExp EOF )
            // InternalDOcl.g:1055:1: ruleTupleExp EOF
            {
             before(grammarAccess.getTupleExpRule()); 
            pushFollow(FOLLOW_1);
            ruleTupleExp();

            state._fsp--;

             after(grammarAccess.getTupleExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTupleExp"


    // $ANTLR start "ruleTupleExp"
    // InternalDOcl.g:1062:1: ruleTupleExp : ( ( rule__TupleExp__Group__0 ) ) ;
    public final void ruleTupleExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1066:2: ( ( ( rule__TupleExp__Group__0 ) ) )
            // InternalDOcl.g:1067:2: ( ( rule__TupleExp__Group__0 ) )
            {
            // InternalDOcl.g:1067:2: ( ( rule__TupleExp__Group__0 ) )
            // InternalDOcl.g:1068:3: ( rule__TupleExp__Group__0 )
            {
             before(grammarAccess.getTupleExpAccess().getGroup()); 
            // InternalDOcl.g:1069:3: ( rule__TupleExp__Group__0 )
            // InternalDOcl.g:1069:4: rule__TupleExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TupleExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTupleExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTupleExp"


    // $ANTLR start "entryRuleTuplePart"
    // InternalDOcl.g:1078:1: entryRuleTuplePart : ruleTuplePart EOF ;
    public final void entryRuleTuplePart() throws RecognitionException {
        try {
            // InternalDOcl.g:1079:1: ( ruleTuplePart EOF )
            // InternalDOcl.g:1080:1: ruleTuplePart EOF
            {
             before(grammarAccess.getTuplePartRule()); 
            pushFollow(FOLLOW_1);
            ruleTuplePart();

            state._fsp--;

             after(grammarAccess.getTuplePartRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTuplePart"


    // $ANTLR start "ruleTuplePart"
    // InternalDOcl.g:1087:1: ruleTuplePart : ( ( rule__TuplePart__Group__0 ) ) ;
    public final void ruleTuplePart() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1091:2: ( ( ( rule__TuplePart__Group__0 ) ) )
            // InternalDOcl.g:1092:2: ( ( rule__TuplePart__Group__0 ) )
            {
            // InternalDOcl.g:1092:2: ( ( rule__TuplePart__Group__0 ) )
            // InternalDOcl.g:1093:3: ( rule__TuplePart__Group__0 )
            {
             before(grammarAccess.getTuplePartAccess().getGroup()); 
            // InternalDOcl.g:1094:3: ( rule__TuplePart__Group__0 )
            // InternalDOcl.g:1094:4: rule__TuplePart__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TuplePart__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTuplePartAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTuplePart"


    // $ANTLR start "entryRulePrimitiveExp"
    // InternalDOcl.g:1103:1: entryRulePrimitiveExp : rulePrimitiveExp EOF ;
    public final void entryRulePrimitiveExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1104:1: ( rulePrimitiveExp EOF )
            // InternalDOcl.g:1105:1: rulePrimitiveExp EOF
            {
             before(grammarAccess.getPrimitiveExpRule()); 
            pushFollow(FOLLOW_1);
            rulePrimitiveExp();

            state._fsp--;

             after(grammarAccess.getPrimitiveExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimitiveExp"


    // $ANTLR start "rulePrimitiveExp"
    // InternalDOcl.g:1112:1: rulePrimitiveExp : ( ( rule__PrimitiveExp__Alternatives ) ) ;
    public final void rulePrimitiveExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1116:2: ( ( ( rule__PrimitiveExp__Alternatives ) ) )
            // InternalDOcl.g:1117:2: ( ( rule__PrimitiveExp__Alternatives ) )
            {
            // InternalDOcl.g:1117:2: ( ( rule__PrimitiveExp__Alternatives ) )
            // InternalDOcl.g:1118:3: ( rule__PrimitiveExp__Alternatives )
            {
             before(grammarAccess.getPrimitiveExpAccess().getAlternatives()); 
            // InternalDOcl.g:1119:3: ( rule__PrimitiveExp__Alternatives )
            // InternalDOcl.g:1119:4: rule__PrimitiveExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__PrimitiveExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimitiveExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimitiveExp"


    // $ANTLR start "entryRuleNumberExp"
    // InternalDOcl.g:1128:1: entryRuleNumberExp : ruleNumberExp EOF ;
    public final void entryRuleNumberExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1129:1: ( ruleNumberExp EOF )
            // InternalDOcl.g:1130:1: ruleNumberExp EOF
            {
             before(grammarAccess.getNumberExpRule()); 
            pushFollow(FOLLOW_1);
            ruleNumberExp();

            state._fsp--;

             after(grammarAccess.getNumberExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNumberExp"


    // $ANTLR start "ruleNumberExp"
    // InternalDOcl.g:1137:1: ruleNumberExp : ( ( rule__NumberExp__SymbolAssignment ) ) ;
    public final void ruleNumberExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1141:2: ( ( ( rule__NumberExp__SymbolAssignment ) ) )
            // InternalDOcl.g:1142:2: ( ( rule__NumberExp__SymbolAssignment ) )
            {
            // InternalDOcl.g:1142:2: ( ( rule__NumberExp__SymbolAssignment ) )
            // InternalDOcl.g:1143:3: ( rule__NumberExp__SymbolAssignment )
            {
             before(grammarAccess.getNumberExpAccess().getSymbolAssignment()); 
            // InternalDOcl.g:1144:3: ( rule__NumberExp__SymbolAssignment )
            // InternalDOcl.g:1144:4: rule__NumberExp__SymbolAssignment
            {
            pushFollow(FOLLOW_2);
            rule__NumberExp__SymbolAssignment();

            state._fsp--;


            }

             after(grammarAccess.getNumberExpAccess().getSymbolAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNumberExp"


    // $ANTLR start "entryRuleStringExp"
    // InternalDOcl.g:1153:1: entryRuleStringExp : ruleStringExp EOF ;
    public final void entryRuleStringExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1154:1: ( ruleStringExp EOF )
            // InternalDOcl.g:1155:1: ruleStringExp EOF
            {
             before(grammarAccess.getStringExpRule()); 
            pushFollow(FOLLOW_1);
            ruleStringExp();

            state._fsp--;

             after(grammarAccess.getStringExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringExp"


    // $ANTLR start "ruleStringExp"
    // InternalDOcl.g:1162:1: ruleStringExp : ( ( ( rule__StringExp__SegmentsAssignment ) ) ( ( rule__StringExp__SegmentsAssignment )* ) ) ;
    public final void ruleStringExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1166:2: ( ( ( ( rule__StringExp__SegmentsAssignment ) ) ( ( rule__StringExp__SegmentsAssignment )* ) ) )
            // InternalDOcl.g:1167:2: ( ( ( rule__StringExp__SegmentsAssignment ) ) ( ( rule__StringExp__SegmentsAssignment )* ) )
            {
            // InternalDOcl.g:1167:2: ( ( ( rule__StringExp__SegmentsAssignment ) ) ( ( rule__StringExp__SegmentsAssignment )* ) )
            // InternalDOcl.g:1168:3: ( ( rule__StringExp__SegmentsAssignment ) ) ( ( rule__StringExp__SegmentsAssignment )* )
            {
            // InternalDOcl.g:1168:3: ( ( rule__StringExp__SegmentsAssignment ) )
            // InternalDOcl.g:1169:4: ( rule__StringExp__SegmentsAssignment )
            {
             before(grammarAccess.getStringExpAccess().getSegmentsAssignment()); 
            // InternalDOcl.g:1170:4: ( rule__StringExp__SegmentsAssignment )
            // InternalDOcl.g:1170:5: rule__StringExp__SegmentsAssignment
            {
            pushFollow(FOLLOW_3);
            rule__StringExp__SegmentsAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStringExpAccess().getSegmentsAssignment()); 

            }

            // InternalDOcl.g:1173:3: ( ( rule__StringExp__SegmentsAssignment )* )
            // InternalDOcl.g:1174:4: ( rule__StringExp__SegmentsAssignment )*
            {
             before(grammarAccess.getStringExpAccess().getSegmentsAssignment()); 
            // InternalDOcl.g:1175:4: ( rule__StringExp__SegmentsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_STRING) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDOcl.g:1175:5: rule__StringExp__SegmentsAssignment
            	    {
            	    pushFollow(FOLLOW_3);
            	    rule__StringExp__SegmentsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getStringExpAccess().getSegmentsAssignment()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringExp"


    // $ANTLR start "entryRuleBooleanExp"
    // InternalDOcl.g:1185:1: entryRuleBooleanExp : ruleBooleanExp EOF ;
    public final void entryRuleBooleanExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1186:1: ( ruleBooleanExp EOF )
            // InternalDOcl.g:1187:1: ruleBooleanExp EOF
            {
             before(grammarAccess.getBooleanExpRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanExp();

            state._fsp--;

             after(grammarAccess.getBooleanExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanExp"


    // $ANTLR start "ruleBooleanExp"
    // InternalDOcl.g:1194:1: ruleBooleanExp : ( ( rule__BooleanExp__Alternatives ) ) ;
    public final void ruleBooleanExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1198:2: ( ( ( rule__BooleanExp__Alternatives ) ) )
            // InternalDOcl.g:1199:2: ( ( rule__BooleanExp__Alternatives ) )
            {
            // InternalDOcl.g:1199:2: ( ( rule__BooleanExp__Alternatives ) )
            // InternalDOcl.g:1200:3: ( rule__BooleanExp__Alternatives )
            {
             before(grammarAccess.getBooleanExpAccess().getAlternatives()); 
            // InternalDOcl.g:1201:3: ( rule__BooleanExp__Alternatives )
            // InternalDOcl.g:1201:4: rule__BooleanExp__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__BooleanExp__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getBooleanExpAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanExp"


    // $ANTLR start "entryRuleUnlimitedNaturalExp"
    // InternalDOcl.g:1210:1: entryRuleUnlimitedNaturalExp : ruleUnlimitedNaturalExp EOF ;
    public final void entryRuleUnlimitedNaturalExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1211:1: ( ruleUnlimitedNaturalExp EOF )
            // InternalDOcl.g:1212:1: ruleUnlimitedNaturalExp EOF
            {
             before(grammarAccess.getUnlimitedNaturalExpRule()); 
            pushFollow(FOLLOW_1);
            ruleUnlimitedNaturalExp();

            state._fsp--;

             after(grammarAccess.getUnlimitedNaturalExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnlimitedNaturalExp"


    // $ANTLR start "ruleUnlimitedNaturalExp"
    // InternalDOcl.g:1219:1: ruleUnlimitedNaturalExp : ( ( rule__UnlimitedNaturalExp__Group__0 ) ) ;
    public final void ruleUnlimitedNaturalExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1223:2: ( ( ( rule__UnlimitedNaturalExp__Group__0 ) ) )
            // InternalDOcl.g:1224:2: ( ( rule__UnlimitedNaturalExp__Group__0 ) )
            {
            // InternalDOcl.g:1224:2: ( ( rule__UnlimitedNaturalExp__Group__0 ) )
            // InternalDOcl.g:1225:3: ( rule__UnlimitedNaturalExp__Group__0 )
            {
             before(grammarAccess.getUnlimitedNaturalExpAccess().getGroup()); 
            // InternalDOcl.g:1226:3: ( rule__UnlimitedNaturalExp__Group__0 )
            // InternalDOcl.g:1226:4: rule__UnlimitedNaturalExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__UnlimitedNaturalExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getUnlimitedNaturalExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnlimitedNaturalExp"


    // $ANTLR start "entryRuleInvalidExp"
    // InternalDOcl.g:1235:1: entryRuleInvalidExp : ruleInvalidExp EOF ;
    public final void entryRuleInvalidExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1236:1: ( ruleInvalidExp EOF )
            // InternalDOcl.g:1237:1: ruleInvalidExp EOF
            {
             before(grammarAccess.getInvalidExpRule()); 
            pushFollow(FOLLOW_1);
            ruleInvalidExp();

            state._fsp--;

             after(grammarAccess.getInvalidExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInvalidExp"


    // $ANTLR start "ruleInvalidExp"
    // InternalDOcl.g:1244:1: ruleInvalidExp : ( ( rule__InvalidExp__Group__0 ) ) ;
    public final void ruleInvalidExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1248:2: ( ( ( rule__InvalidExp__Group__0 ) ) )
            // InternalDOcl.g:1249:2: ( ( rule__InvalidExp__Group__0 ) )
            {
            // InternalDOcl.g:1249:2: ( ( rule__InvalidExp__Group__0 ) )
            // InternalDOcl.g:1250:3: ( rule__InvalidExp__Group__0 )
            {
             before(grammarAccess.getInvalidExpAccess().getGroup()); 
            // InternalDOcl.g:1251:3: ( rule__InvalidExp__Group__0 )
            // InternalDOcl.g:1251:4: rule__InvalidExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__InvalidExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInvalidExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInvalidExp"


    // $ANTLR start "entryRuleNullExp"
    // InternalDOcl.g:1260:1: entryRuleNullExp : ruleNullExp EOF ;
    public final void entryRuleNullExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1261:1: ( ruleNullExp EOF )
            // InternalDOcl.g:1262:1: ruleNullExp EOF
            {
             before(grammarAccess.getNullExpRule()); 
            pushFollow(FOLLOW_1);
            ruleNullExp();

            state._fsp--;

             after(grammarAccess.getNullExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNullExp"


    // $ANTLR start "ruleNullExp"
    // InternalDOcl.g:1269:1: ruleNullExp : ( ( rule__NullExp__Group__0 ) ) ;
    public final void ruleNullExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1273:2: ( ( ( rule__NullExp__Group__0 ) ) )
            // InternalDOcl.g:1274:2: ( ( rule__NullExp__Group__0 ) )
            {
            // InternalDOcl.g:1274:2: ( ( rule__NullExp__Group__0 ) )
            // InternalDOcl.g:1275:3: ( rule__NullExp__Group__0 )
            {
             before(grammarAccess.getNullExpAccess().getGroup()); 
            // InternalDOcl.g:1276:3: ( rule__NullExp__Group__0 )
            // InternalDOcl.g:1276:4: rule__NullExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NullExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNullExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNullExp"


    // $ANTLR start "entryRuleIfExp"
    // InternalDOcl.g:1285:1: entryRuleIfExp : ruleIfExp EOF ;
    public final void entryRuleIfExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1286:1: ( ruleIfExp EOF )
            // InternalDOcl.g:1287:1: ruleIfExp EOF
            {
             before(grammarAccess.getIfExpRule()); 
            pushFollow(FOLLOW_1);
            ruleIfExp();

            state._fsp--;

             after(grammarAccess.getIfExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIfExp"


    // $ANTLR start "ruleIfExp"
    // InternalDOcl.g:1294:1: ruleIfExp : ( ( rule__IfExp__Group__0 ) ) ;
    public final void ruleIfExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1298:2: ( ( ( rule__IfExp__Group__0 ) ) )
            // InternalDOcl.g:1299:2: ( ( rule__IfExp__Group__0 ) )
            {
            // InternalDOcl.g:1299:2: ( ( rule__IfExp__Group__0 ) )
            // InternalDOcl.g:1300:3: ( rule__IfExp__Group__0 )
            {
             before(grammarAccess.getIfExpAccess().getGroup()); 
            // InternalDOcl.g:1301:3: ( rule__IfExp__Group__0 )
            // InternalDOcl.g:1301:4: rule__IfExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IfExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIfExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIfExp"


    // $ANTLR start "entryRuleElseIfThenExp"
    // InternalDOcl.g:1310:1: entryRuleElseIfThenExp : ruleElseIfThenExp EOF ;
    public final void entryRuleElseIfThenExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1311:1: ( ruleElseIfThenExp EOF )
            // InternalDOcl.g:1312:1: ruleElseIfThenExp EOF
            {
             before(grammarAccess.getElseIfThenExpRule()); 
            pushFollow(FOLLOW_1);
            ruleElseIfThenExp();

            state._fsp--;

             after(grammarAccess.getElseIfThenExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleElseIfThenExp"


    // $ANTLR start "ruleElseIfThenExp"
    // InternalDOcl.g:1319:1: ruleElseIfThenExp : ( ( rule__ElseIfThenExp__Group__0 ) ) ;
    public final void ruleElseIfThenExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1323:2: ( ( ( rule__ElseIfThenExp__Group__0 ) ) )
            // InternalDOcl.g:1324:2: ( ( rule__ElseIfThenExp__Group__0 ) )
            {
            // InternalDOcl.g:1324:2: ( ( rule__ElseIfThenExp__Group__0 ) )
            // InternalDOcl.g:1325:3: ( rule__ElseIfThenExp__Group__0 )
            {
             before(grammarAccess.getElseIfThenExpAccess().getGroup()); 
            // InternalDOcl.g:1326:3: ( rule__ElseIfThenExp__Group__0 )
            // InternalDOcl.g:1326:4: rule__ElseIfThenExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ElseIfThenExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getElseIfThenExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElseIfThenExp"


    // $ANTLR start "entryRuleSeflExp"
    // InternalDOcl.g:1335:1: entryRuleSeflExp : ruleSeflExp EOF ;
    public final void entryRuleSeflExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1336:1: ( ruleSeflExp EOF )
            // InternalDOcl.g:1337:1: ruleSeflExp EOF
            {
             before(grammarAccess.getSeflExpRule()); 
            pushFollow(FOLLOW_1);
            ruleSeflExp();

            state._fsp--;

             after(grammarAccess.getSeflExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSeflExp"


    // $ANTLR start "ruleSeflExp"
    // InternalDOcl.g:1344:1: ruleSeflExp : ( ( rule__SeflExp__Group__0 ) ) ;
    public final void ruleSeflExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1348:2: ( ( ( rule__SeflExp__Group__0 ) ) )
            // InternalDOcl.g:1349:2: ( ( rule__SeflExp__Group__0 ) )
            {
            // InternalDOcl.g:1349:2: ( ( rule__SeflExp__Group__0 ) )
            // InternalDOcl.g:1350:3: ( rule__SeflExp__Group__0 )
            {
             before(grammarAccess.getSeflExpAccess().getGroup()); 
            // InternalDOcl.g:1351:3: ( rule__SeflExp__Group__0 )
            // InternalDOcl.g:1351:4: rule__SeflExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SeflExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSeflExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSeflExp"


    // $ANTLR start "entryRuleNestedExp"
    // InternalDOcl.g:1360:1: entryRuleNestedExp : ruleNestedExp EOF ;
    public final void entryRuleNestedExp() throws RecognitionException {
        try {
            // InternalDOcl.g:1361:1: ( ruleNestedExp EOF )
            // InternalDOcl.g:1362:1: ruleNestedExp EOF
            {
             before(grammarAccess.getNestedExpRule()); 
            pushFollow(FOLLOW_1);
            ruleNestedExp();

            state._fsp--;

             after(grammarAccess.getNestedExpRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNestedExp"


    // $ANTLR start "ruleNestedExp"
    // InternalDOcl.g:1369:1: ruleNestedExp : ( ( rule__NestedExp__Group__0 ) ) ;
    public final void ruleNestedExp() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1373:2: ( ( ( rule__NestedExp__Group__0 ) ) )
            // InternalDOcl.g:1374:2: ( ( rule__NestedExp__Group__0 ) )
            {
            // InternalDOcl.g:1374:2: ( ( rule__NestedExp__Group__0 ) )
            // InternalDOcl.g:1375:3: ( rule__NestedExp__Group__0 )
            {
             before(grammarAccess.getNestedExpAccess().getGroup()); 
            // InternalDOcl.g:1376:3: ( rule__NestedExp__Group__0 )
            // InternalDOcl.g:1376:4: rule__NestedExp__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NestedExp__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNestedExpAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNestedExp"


    // $ANTLR start "entryRuleOclType"
    // InternalDOcl.g:1385:1: entryRuleOclType : ruleOclType EOF ;
    public final void entryRuleOclType() throws RecognitionException {
        try {
            // InternalDOcl.g:1386:1: ( ruleOclType EOF )
            // InternalDOcl.g:1387:1: ruleOclType EOF
            {
             before(grammarAccess.getOclTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getOclTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOclType"


    // $ANTLR start "ruleOclType"
    // InternalDOcl.g:1394:1: ruleOclType : ( ( rule__OclType__Alternatives ) ) ;
    public final void ruleOclType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1398:2: ( ( ( rule__OclType__Alternatives ) ) )
            // InternalDOcl.g:1399:2: ( ( rule__OclType__Alternatives ) )
            {
            // InternalDOcl.g:1399:2: ( ( rule__OclType__Alternatives ) )
            // InternalDOcl.g:1400:3: ( rule__OclType__Alternatives )
            {
             before(grammarAccess.getOclTypeAccess().getAlternatives()); 
            // InternalDOcl.g:1401:3: ( rule__OclType__Alternatives )
            // InternalDOcl.g:1401:4: rule__OclType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__OclType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOclTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOclType"


    // $ANTLR start "entryRuleOclModelElement"
    // InternalDOcl.g:1410:1: entryRuleOclModelElement : ruleOclModelElement EOF ;
    public final void entryRuleOclModelElement() throws RecognitionException {
        try {
            // InternalDOcl.g:1411:1: ( ruleOclModelElement EOF )
            // InternalDOcl.g:1412:1: ruleOclModelElement EOF
            {
             before(grammarAccess.getOclModelElementRule()); 
            pushFollow(FOLLOW_1);
            ruleOclModelElement();

            state._fsp--;

             after(grammarAccess.getOclModelElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOclModelElement"


    // $ANTLR start "ruleOclModelElement"
    // InternalDOcl.g:1419:1: ruleOclModelElement : ( ( rule__OclModelElement__Group__0 ) ) ;
    public final void ruleOclModelElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1423:2: ( ( ( rule__OclModelElement__Group__0 ) ) )
            // InternalDOcl.g:1424:2: ( ( rule__OclModelElement__Group__0 ) )
            {
            // InternalDOcl.g:1424:2: ( ( rule__OclModelElement__Group__0 ) )
            // InternalDOcl.g:1425:3: ( rule__OclModelElement__Group__0 )
            {
             before(grammarAccess.getOclModelElementAccess().getGroup()); 
            // InternalDOcl.g:1426:3: ( rule__OclModelElement__Group__0 )
            // InternalDOcl.g:1426:4: rule__OclModelElement__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OclModelElement__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOclModelElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOclModelElement"


    // $ANTLR start "entryRuleEnvType"
    // InternalDOcl.g:1435:1: entryRuleEnvType : ruleEnvType EOF ;
    public final void entryRuleEnvType() throws RecognitionException {
        try {
            // InternalDOcl.g:1436:1: ( ruleEnvType EOF )
            // InternalDOcl.g:1437:1: ruleEnvType EOF
            {
             before(grammarAccess.getEnvTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleEnvType();

            state._fsp--;

             after(grammarAccess.getEnvTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnvType"


    // $ANTLR start "ruleEnvType"
    // InternalDOcl.g:1444:1: ruleEnvType : ( ( rule__EnvType__NameAssignment ) ) ;
    public final void ruleEnvType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1448:2: ( ( ( rule__EnvType__NameAssignment ) ) )
            // InternalDOcl.g:1449:2: ( ( rule__EnvType__NameAssignment ) )
            {
            // InternalDOcl.g:1449:2: ( ( rule__EnvType__NameAssignment ) )
            // InternalDOcl.g:1450:3: ( rule__EnvType__NameAssignment )
            {
             before(grammarAccess.getEnvTypeAccess().getNameAssignment()); 
            // InternalDOcl.g:1451:3: ( rule__EnvType__NameAssignment )
            // InternalDOcl.g:1451:4: rule__EnvType__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__EnvType__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getEnvTypeAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnvType"


    // $ANTLR start "entryRuleLambdaType"
    // InternalDOcl.g:1460:1: entryRuleLambdaType : ruleLambdaType EOF ;
    public final void entryRuleLambdaType() throws RecognitionException {
        try {
            // InternalDOcl.g:1461:1: ( ruleLambdaType EOF )
            // InternalDOcl.g:1462:1: ruleLambdaType EOF
            {
             before(grammarAccess.getLambdaTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleLambdaType();

            state._fsp--;

             after(grammarAccess.getLambdaTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleLambdaType"


    // $ANTLR start "ruleLambdaType"
    // InternalDOcl.g:1469:1: ruleLambdaType : ( ( rule__LambdaType__Group__0 ) ) ;
    public final void ruleLambdaType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1473:2: ( ( ( rule__LambdaType__Group__0 ) ) )
            // InternalDOcl.g:1474:2: ( ( rule__LambdaType__Group__0 ) )
            {
            // InternalDOcl.g:1474:2: ( ( rule__LambdaType__Group__0 ) )
            // InternalDOcl.g:1475:3: ( rule__LambdaType__Group__0 )
            {
             before(grammarAccess.getLambdaTypeAccess().getGroup()); 
            // InternalDOcl.g:1476:3: ( rule__LambdaType__Group__0 )
            // InternalDOcl.g:1476:4: rule__LambdaType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__LambdaType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLambdaTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLambdaType"


    // $ANTLR start "entryRuleMapType"
    // InternalDOcl.g:1485:1: entryRuleMapType : ruleMapType EOF ;
    public final void entryRuleMapType() throws RecognitionException {
        try {
            // InternalDOcl.g:1486:1: ( ruleMapType EOF )
            // InternalDOcl.g:1487:1: ruleMapType EOF
            {
             before(grammarAccess.getMapTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleMapType();

            state._fsp--;

             after(grammarAccess.getMapTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMapType"


    // $ANTLR start "ruleMapType"
    // InternalDOcl.g:1494:1: ruleMapType : ( ( rule__MapType__Group__0 ) ) ;
    public final void ruleMapType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1498:2: ( ( ( rule__MapType__Group__0 ) ) )
            // InternalDOcl.g:1499:2: ( ( rule__MapType__Group__0 ) )
            {
            // InternalDOcl.g:1499:2: ( ( rule__MapType__Group__0 ) )
            // InternalDOcl.g:1500:3: ( rule__MapType__Group__0 )
            {
             before(grammarAccess.getMapTypeAccess().getGroup()); 
            // InternalDOcl.g:1501:3: ( rule__MapType__Group__0 )
            // InternalDOcl.g:1501:4: rule__MapType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MapType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMapTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMapType"


    // $ANTLR start "entryRuleTupleType"
    // InternalDOcl.g:1510:1: entryRuleTupleType : ruleTupleType EOF ;
    public final void entryRuleTupleType() throws RecognitionException {
        try {
            // InternalDOcl.g:1511:1: ( ruleTupleType EOF )
            // InternalDOcl.g:1512:1: ruleTupleType EOF
            {
             before(grammarAccess.getTupleTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleTupleType();

            state._fsp--;

             after(grammarAccess.getTupleTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTupleType"


    // $ANTLR start "ruleTupleType"
    // InternalDOcl.g:1519:1: ruleTupleType : ( 'TupleType' ) ;
    public final void ruleTupleType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1523:2: ( ( 'TupleType' ) )
            // InternalDOcl.g:1524:2: ( 'TupleType' )
            {
            // InternalDOcl.g:1524:2: ( 'TupleType' )
            // InternalDOcl.g:1525:3: 'TupleType'
            {
             before(grammarAccess.getTupleTypeAccess().getTupleTypeKeyword()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getTupleTypeAccess().getTupleTypeKeyword()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTupleType"


    // $ANTLR start "entryRuleOclAnyType"
    // InternalDOcl.g:1535:1: entryRuleOclAnyType : ruleOclAnyType EOF ;
    public final void entryRuleOclAnyType() throws RecognitionException {
        try {
            // InternalDOcl.g:1536:1: ( ruleOclAnyType EOF )
            // InternalDOcl.g:1537:1: ruleOclAnyType EOF
            {
             before(grammarAccess.getOclAnyTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleOclAnyType();

            state._fsp--;

             after(grammarAccess.getOclAnyTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOclAnyType"


    // $ANTLR start "ruleOclAnyType"
    // InternalDOcl.g:1544:1: ruleOclAnyType : ( ( rule__OclAnyType__NameAssignment ) ) ;
    public final void ruleOclAnyType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1548:2: ( ( ( rule__OclAnyType__NameAssignment ) ) )
            // InternalDOcl.g:1549:2: ( ( rule__OclAnyType__NameAssignment ) )
            {
            // InternalDOcl.g:1549:2: ( ( rule__OclAnyType__NameAssignment ) )
            // InternalDOcl.g:1550:3: ( rule__OclAnyType__NameAssignment )
            {
             before(grammarAccess.getOclAnyTypeAccess().getNameAssignment()); 
            // InternalDOcl.g:1551:3: ( rule__OclAnyType__NameAssignment )
            // InternalDOcl.g:1551:4: rule__OclAnyType__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__OclAnyType__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getOclAnyTypeAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOclAnyType"


    // $ANTLR start "entryRuleSetType"
    // InternalDOcl.g:1560:1: entryRuleSetType : ruleSetType EOF ;
    public final void entryRuleSetType() throws RecognitionException {
        try {
            // InternalDOcl.g:1561:1: ( ruleSetType EOF )
            // InternalDOcl.g:1562:1: ruleSetType EOF
            {
             before(grammarAccess.getSetTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleSetType();

            state._fsp--;

             after(grammarAccess.getSetTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSetType"


    // $ANTLR start "ruleSetType"
    // InternalDOcl.g:1569:1: ruleSetType : ( ( rule__SetType__Group__0 ) ) ;
    public final void ruleSetType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1573:2: ( ( ( rule__SetType__Group__0 ) ) )
            // InternalDOcl.g:1574:2: ( ( rule__SetType__Group__0 ) )
            {
            // InternalDOcl.g:1574:2: ( ( rule__SetType__Group__0 ) )
            // InternalDOcl.g:1575:3: ( rule__SetType__Group__0 )
            {
             before(grammarAccess.getSetTypeAccess().getGroup()); 
            // InternalDOcl.g:1576:3: ( rule__SetType__Group__0 )
            // InternalDOcl.g:1576:4: rule__SetType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SetType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSetTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSetType"


    // $ANTLR start "entryRuleSequenceType"
    // InternalDOcl.g:1585:1: entryRuleSequenceType : ruleSequenceType EOF ;
    public final void entryRuleSequenceType() throws RecognitionException {
        try {
            // InternalDOcl.g:1586:1: ( ruleSequenceType EOF )
            // InternalDOcl.g:1587:1: ruleSequenceType EOF
            {
             before(grammarAccess.getSequenceTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleSequenceType();

            state._fsp--;

             after(grammarAccess.getSequenceTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSequenceType"


    // $ANTLR start "ruleSequenceType"
    // InternalDOcl.g:1594:1: ruleSequenceType : ( ( rule__SequenceType__Group__0 ) ) ;
    public final void ruleSequenceType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1598:2: ( ( ( rule__SequenceType__Group__0 ) ) )
            // InternalDOcl.g:1599:2: ( ( rule__SequenceType__Group__0 ) )
            {
            // InternalDOcl.g:1599:2: ( ( rule__SequenceType__Group__0 ) )
            // InternalDOcl.g:1600:3: ( rule__SequenceType__Group__0 )
            {
             before(grammarAccess.getSequenceTypeAccess().getGroup()); 
            // InternalDOcl.g:1601:3: ( rule__SequenceType__Group__0 )
            // InternalDOcl.g:1601:4: rule__SequenceType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__SequenceType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSequenceTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSequenceType"


    // $ANTLR start "entryRuleOrderedSetType"
    // InternalDOcl.g:1610:1: entryRuleOrderedSetType : ruleOrderedSetType EOF ;
    public final void entryRuleOrderedSetType() throws RecognitionException {
        try {
            // InternalDOcl.g:1611:1: ( ruleOrderedSetType EOF )
            // InternalDOcl.g:1612:1: ruleOrderedSetType EOF
            {
             before(grammarAccess.getOrderedSetTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleOrderedSetType();

            state._fsp--;

             after(grammarAccess.getOrderedSetTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleOrderedSetType"


    // $ANTLR start "ruleOrderedSetType"
    // InternalDOcl.g:1619:1: ruleOrderedSetType : ( ( rule__OrderedSetType__Group__0 ) ) ;
    public final void ruleOrderedSetType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1623:2: ( ( ( rule__OrderedSetType__Group__0 ) ) )
            // InternalDOcl.g:1624:2: ( ( rule__OrderedSetType__Group__0 ) )
            {
            // InternalDOcl.g:1624:2: ( ( rule__OrderedSetType__Group__0 ) )
            // InternalDOcl.g:1625:3: ( rule__OrderedSetType__Group__0 )
            {
             before(grammarAccess.getOrderedSetTypeAccess().getGroup()); 
            // InternalDOcl.g:1626:3: ( rule__OrderedSetType__Group__0 )
            // InternalDOcl.g:1626:4: rule__OrderedSetType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__OrderedSetType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOrderedSetTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrderedSetType"


    // $ANTLR start "entryRuleBagType"
    // InternalDOcl.g:1635:1: entryRuleBagType : ruleBagType EOF ;
    public final void entryRuleBagType() throws RecognitionException {
        try {
            // InternalDOcl.g:1636:1: ( ruleBagType EOF )
            // InternalDOcl.g:1637:1: ruleBagType EOF
            {
             before(grammarAccess.getBagTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleBagType();

            state._fsp--;

             after(grammarAccess.getBagTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBagType"


    // $ANTLR start "ruleBagType"
    // InternalDOcl.g:1644:1: ruleBagType : ( ( rule__BagType__Group__0 ) ) ;
    public final void ruleBagType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1648:2: ( ( ( rule__BagType__Group__0 ) ) )
            // InternalDOcl.g:1649:2: ( ( rule__BagType__Group__0 ) )
            {
            // InternalDOcl.g:1649:2: ( ( rule__BagType__Group__0 ) )
            // InternalDOcl.g:1650:3: ( rule__BagType__Group__0 )
            {
             before(grammarAccess.getBagTypeAccess().getGroup()); 
            // InternalDOcl.g:1651:3: ( rule__BagType__Group__0 )
            // InternalDOcl.g:1651:4: rule__BagType__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BagType__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBagTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBagType"


    // $ANTLR start "entryRuleRealType"
    // InternalDOcl.g:1660:1: entryRuleRealType : ruleRealType EOF ;
    public final void entryRuleRealType() throws RecognitionException {
        try {
            // InternalDOcl.g:1661:1: ( ruleRealType EOF )
            // InternalDOcl.g:1662:1: ruleRealType EOF
            {
             before(grammarAccess.getRealTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleRealType();

            state._fsp--;

             after(grammarAccess.getRealTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRealType"


    // $ANTLR start "ruleRealType"
    // InternalDOcl.g:1669:1: ruleRealType : ( ( rule__RealType__NameAssignment ) ) ;
    public final void ruleRealType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1673:2: ( ( ( rule__RealType__NameAssignment ) ) )
            // InternalDOcl.g:1674:2: ( ( rule__RealType__NameAssignment ) )
            {
            // InternalDOcl.g:1674:2: ( ( rule__RealType__NameAssignment ) )
            // InternalDOcl.g:1675:3: ( rule__RealType__NameAssignment )
            {
             before(grammarAccess.getRealTypeAccess().getNameAssignment()); 
            // InternalDOcl.g:1676:3: ( rule__RealType__NameAssignment )
            // InternalDOcl.g:1676:4: rule__RealType__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__RealType__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getRealTypeAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRealType"


    // $ANTLR start "entryRuleIntegerType"
    // InternalDOcl.g:1685:1: entryRuleIntegerType : ruleIntegerType EOF ;
    public final void entryRuleIntegerType() throws RecognitionException {
        try {
            // InternalDOcl.g:1686:1: ( ruleIntegerType EOF )
            // InternalDOcl.g:1687:1: ruleIntegerType EOF
            {
             before(grammarAccess.getIntegerTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleIntegerType();

            state._fsp--;

             after(grammarAccess.getIntegerTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntegerType"


    // $ANTLR start "ruleIntegerType"
    // InternalDOcl.g:1694:1: ruleIntegerType : ( ( rule__IntegerType__NameAssignment ) ) ;
    public final void ruleIntegerType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1698:2: ( ( ( rule__IntegerType__NameAssignment ) ) )
            // InternalDOcl.g:1699:2: ( ( rule__IntegerType__NameAssignment ) )
            {
            // InternalDOcl.g:1699:2: ( ( rule__IntegerType__NameAssignment ) )
            // InternalDOcl.g:1700:3: ( rule__IntegerType__NameAssignment )
            {
             before(grammarAccess.getIntegerTypeAccess().getNameAssignment()); 
            // InternalDOcl.g:1701:3: ( rule__IntegerType__NameAssignment )
            // InternalDOcl.g:1701:4: rule__IntegerType__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__IntegerType__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIntegerTypeAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntegerType"


    // $ANTLR start "entryRuleBooleanType"
    // InternalDOcl.g:1710:1: entryRuleBooleanType : ruleBooleanType EOF ;
    public final void entryRuleBooleanType() throws RecognitionException {
        try {
            // InternalDOcl.g:1711:1: ( ruleBooleanType EOF )
            // InternalDOcl.g:1712:1: ruleBooleanType EOF
            {
             before(grammarAccess.getBooleanTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanType();

            state._fsp--;

             after(grammarAccess.getBooleanTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanType"


    // $ANTLR start "ruleBooleanType"
    // InternalDOcl.g:1719:1: ruleBooleanType : ( ( rule__BooleanType__NameAssignment ) ) ;
    public final void ruleBooleanType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1723:2: ( ( ( rule__BooleanType__NameAssignment ) ) )
            // InternalDOcl.g:1724:2: ( ( rule__BooleanType__NameAssignment ) )
            {
            // InternalDOcl.g:1724:2: ( ( rule__BooleanType__NameAssignment ) )
            // InternalDOcl.g:1725:3: ( rule__BooleanType__NameAssignment )
            {
             before(grammarAccess.getBooleanTypeAccess().getNameAssignment()); 
            // InternalDOcl.g:1726:3: ( rule__BooleanType__NameAssignment )
            // InternalDOcl.g:1726:4: rule__BooleanType__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__BooleanType__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getBooleanTypeAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanType"


    // $ANTLR start "entryRuleStringType"
    // InternalDOcl.g:1735:1: entryRuleStringType : ruleStringType EOF ;
    public final void entryRuleStringType() throws RecognitionException {
        try {
            // InternalDOcl.g:1736:1: ( ruleStringType EOF )
            // InternalDOcl.g:1737:1: ruleStringType EOF
            {
             before(grammarAccess.getStringTypeRule()); 
            pushFollow(FOLLOW_1);
            ruleStringType();

            state._fsp--;

             after(grammarAccess.getStringTypeRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringType"


    // $ANTLR start "ruleStringType"
    // InternalDOcl.g:1744:1: ruleStringType : ( ( rule__StringType__NameAssignment ) ) ;
    public final void ruleStringType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1748:2: ( ( ( rule__StringType__NameAssignment ) ) )
            // InternalDOcl.g:1749:2: ( ( rule__StringType__NameAssignment ) )
            {
            // InternalDOcl.g:1749:2: ( ( rule__StringType__NameAssignment ) )
            // InternalDOcl.g:1750:3: ( rule__StringType__NameAssignment )
            {
             before(grammarAccess.getStringTypeAccess().getNameAssignment()); 
            // InternalDOcl.g:1751:3: ( rule__StringType__NameAssignment )
            // InternalDOcl.g:1751:4: rule__StringType__NameAssignment
            {
            pushFollow(FOLLOW_2);
            rule__StringType__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStringTypeAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringType"


    // $ANTLR start "rule__UnaryOperator__Alternatives"
    // InternalDOcl.g:1759:1: rule__UnaryOperator__Alternatives : ( ( '-' ) | ( 'not' ) );
    public final void rule__UnaryOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1763:1: ( ( '-' ) | ( 'not' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalDOcl.g:1764:2: ( '-' )
                    {
                    // InternalDOcl.g:1764:2: ( '-' )
                    // InternalDOcl.g:1765:3: '-'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:1770:2: ( 'not' )
                    {
                    // InternalDOcl.g:1770:2: ( 'not' )
                    // InternalDOcl.g:1771:3: 'not'
                    {
                     before(grammarAccess.getUnaryOperatorAccess().getNotKeyword_1()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getUnaryOperatorAccess().getNotKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOperator__Alternatives"


    // $ANTLR start "rule__NavigationOperator__Alternatives"
    // InternalDOcl.g:1780:1: rule__NavigationOperator__Alternatives : ( ( '.' ) | ( '->' ) );
    public final void rule__NavigationOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1784:1: ( ( '.' ) | ( '->' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            else if ( (LA3_0==20) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalDOcl.g:1785:2: ( '.' )
                    {
                    // InternalDOcl.g:1785:2: ( '.' )
                    // InternalDOcl.g:1786:3: '.'
                    {
                     before(grammarAccess.getNavigationOperatorAccess().getFullStopKeyword_0()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getNavigationOperatorAccess().getFullStopKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:1791:2: ( '->' )
                    {
                    // InternalDOcl.g:1791:2: ( '->' )
                    // InternalDOcl.g:1792:3: '->'
                    {
                     before(grammarAccess.getNavigationOperatorAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getNavigationOperatorAccess().getHyphenMinusGreaterThanSignKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationOperator__Alternatives"


    // $ANTLR start "rule__CollectionOperationID__Alternatives"
    // InternalDOcl.g:1801:1: rule__CollectionOperationID__Alternatives : ( ( 'size' ) | ( 'includes' ) | ( 'excludes' ) | ( 'count' ) | ( 'includesAll' ) | ( 'excludesAll' ) | ( 'isEmpty' ) | ( 'notEmpty' ) | ( 'sum' ) | ( 'asBag' ) | ( 'asSet' ) | ( 'asSequence' ) | ( 'union' ) | ( 'flatten' ) | ( 'append' ) | ( 'prepend' ) | ( 'insertAt' ) | ( 'subSequence' ) | ( 'at' ) | ( 'indexOf' ) | ( 'first' ) | ( 'last' ) | ( 'including' ) | ( 'excluding' ) );
    public final void rule__CollectionOperationID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1805:1: ( ( 'size' ) | ( 'includes' ) | ( 'excludes' ) | ( 'count' ) | ( 'includesAll' ) | ( 'excludesAll' ) | ( 'isEmpty' ) | ( 'notEmpty' ) | ( 'sum' ) | ( 'asBag' ) | ( 'asSet' ) | ( 'asSequence' ) | ( 'union' ) | ( 'flatten' ) | ( 'append' ) | ( 'prepend' ) | ( 'insertAt' ) | ( 'subSequence' ) | ( 'at' ) | ( 'indexOf' ) | ( 'first' ) | ( 'last' ) | ( 'including' ) | ( 'excluding' ) )
            int alt4=24;
            switch ( input.LA(1) ) {
            case 21:
                {
                alt4=1;
                }
                break;
            case 22:
                {
                alt4=2;
                }
                break;
            case 23:
                {
                alt4=3;
                }
                break;
            case 24:
                {
                alt4=4;
                }
                break;
            case 25:
                {
                alt4=5;
                }
                break;
            case 26:
                {
                alt4=6;
                }
                break;
            case 27:
                {
                alt4=7;
                }
                break;
            case 28:
                {
                alt4=8;
                }
                break;
            case 29:
                {
                alt4=9;
                }
                break;
            case 30:
                {
                alt4=10;
                }
                break;
            case 31:
                {
                alt4=11;
                }
                break;
            case 32:
                {
                alt4=12;
                }
                break;
            case 33:
                {
                alt4=13;
                }
                break;
            case 34:
                {
                alt4=14;
                }
                break;
            case 35:
                {
                alt4=15;
                }
                break;
            case 36:
                {
                alt4=16;
                }
                break;
            case 37:
                {
                alt4=17;
                }
                break;
            case 38:
                {
                alt4=18;
                }
                break;
            case 39:
                {
                alt4=19;
                }
                break;
            case 40:
                {
                alt4=20;
                }
                break;
            case 41:
                {
                alt4=21;
                }
                break;
            case 42:
                {
                alt4=22;
                }
                break;
            case 43:
                {
                alt4=23;
                }
                break;
            case 44:
                {
                alt4=24;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalDOcl.g:1806:2: ( 'size' )
                    {
                    // InternalDOcl.g:1806:2: ( 'size' )
                    // InternalDOcl.g:1807:3: 'size'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getSizeKeyword_0()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getSizeKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:1812:2: ( 'includes' )
                    {
                    // InternalDOcl.g:1812:2: ( 'includes' )
                    // InternalDOcl.g:1813:3: 'includes'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getIncludesKeyword_1()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getIncludesKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDOcl.g:1818:2: ( 'excludes' )
                    {
                    // InternalDOcl.g:1818:2: ( 'excludes' )
                    // InternalDOcl.g:1819:3: 'excludes'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getExcludesKeyword_2()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getExcludesKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDOcl.g:1824:2: ( 'count' )
                    {
                    // InternalDOcl.g:1824:2: ( 'count' )
                    // InternalDOcl.g:1825:3: 'count'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getCountKeyword_3()); 
                    match(input,24,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getCountKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDOcl.g:1830:2: ( 'includesAll' )
                    {
                    // InternalDOcl.g:1830:2: ( 'includesAll' )
                    // InternalDOcl.g:1831:3: 'includesAll'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getIncludesAllKeyword_4()); 
                    match(input,25,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getIncludesAllKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDOcl.g:1836:2: ( 'excludesAll' )
                    {
                    // InternalDOcl.g:1836:2: ( 'excludesAll' )
                    // InternalDOcl.g:1837:3: 'excludesAll'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getExcludesAllKeyword_5()); 
                    match(input,26,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getExcludesAllKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDOcl.g:1842:2: ( 'isEmpty' )
                    {
                    // InternalDOcl.g:1842:2: ( 'isEmpty' )
                    // InternalDOcl.g:1843:3: 'isEmpty'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getIsEmptyKeyword_6()); 
                    match(input,27,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getIsEmptyKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDOcl.g:1848:2: ( 'notEmpty' )
                    {
                    // InternalDOcl.g:1848:2: ( 'notEmpty' )
                    // InternalDOcl.g:1849:3: 'notEmpty'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getNotEmptyKeyword_7()); 
                    match(input,28,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getNotEmptyKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDOcl.g:1854:2: ( 'sum' )
                    {
                    // InternalDOcl.g:1854:2: ( 'sum' )
                    // InternalDOcl.g:1855:3: 'sum'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getSumKeyword_8()); 
                    match(input,29,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getSumKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDOcl.g:1860:2: ( 'asBag' )
                    {
                    // InternalDOcl.g:1860:2: ( 'asBag' )
                    // InternalDOcl.g:1861:3: 'asBag'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getAsBagKeyword_9()); 
                    match(input,30,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getAsBagKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDOcl.g:1866:2: ( 'asSet' )
                    {
                    // InternalDOcl.g:1866:2: ( 'asSet' )
                    // InternalDOcl.g:1867:3: 'asSet'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getAsSetKeyword_10()); 
                    match(input,31,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getAsSetKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDOcl.g:1872:2: ( 'asSequence' )
                    {
                    // InternalDOcl.g:1872:2: ( 'asSequence' )
                    // InternalDOcl.g:1873:3: 'asSequence'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getAsSequenceKeyword_11()); 
                    match(input,32,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getAsSequenceKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDOcl.g:1878:2: ( 'union' )
                    {
                    // InternalDOcl.g:1878:2: ( 'union' )
                    // InternalDOcl.g:1879:3: 'union'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getUnionKeyword_12()); 
                    match(input,33,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getUnionKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDOcl.g:1884:2: ( 'flatten' )
                    {
                    // InternalDOcl.g:1884:2: ( 'flatten' )
                    // InternalDOcl.g:1885:3: 'flatten'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getFlattenKeyword_13()); 
                    match(input,34,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getFlattenKeyword_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalDOcl.g:1890:2: ( 'append' )
                    {
                    // InternalDOcl.g:1890:2: ( 'append' )
                    // InternalDOcl.g:1891:3: 'append'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getAppendKeyword_14()); 
                    match(input,35,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getAppendKeyword_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalDOcl.g:1896:2: ( 'prepend' )
                    {
                    // InternalDOcl.g:1896:2: ( 'prepend' )
                    // InternalDOcl.g:1897:3: 'prepend'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getPrependKeyword_15()); 
                    match(input,36,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getPrependKeyword_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalDOcl.g:1902:2: ( 'insertAt' )
                    {
                    // InternalDOcl.g:1902:2: ( 'insertAt' )
                    // InternalDOcl.g:1903:3: 'insertAt'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getInsertAtKeyword_16()); 
                    match(input,37,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getInsertAtKeyword_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalDOcl.g:1908:2: ( 'subSequence' )
                    {
                    // InternalDOcl.g:1908:2: ( 'subSequence' )
                    // InternalDOcl.g:1909:3: 'subSequence'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getSubSequenceKeyword_17()); 
                    match(input,38,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getSubSequenceKeyword_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalDOcl.g:1914:2: ( 'at' )
                    {
                    // InternalDOcl.g:1914:2: ( 'at' )
                    // InternalDOcl.g:1915:3: 'at'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getAtKeyword_18()); 
                    match(input,39,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getAtKeyword_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalDOcl.g:1920:2: ( 'indexOf' )
                    {
                    // InternalDOcl.g:1920:2: ( 'indexOf' )
                    // InternalDOcl.g:1921:3: 'indexOf'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getIndexOfKeyword_19()); 
                    match(input,40,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getIndexOfKeyword_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalDOcl.g:1926:2: ( 'first' )
                    {
                    // InternalDOcl.g:1926:2: ( 'first' )
                    // InternalDOcl.g:1927:3: 'first'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getFirstKeyword_20()); 
                    match(input,41,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getFirstKeyword_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalDOcl.g:1932:2: ( 'last' )
                    {
                    // InternalDOcl.g:1932:2: ( 'last' )
                    // InternalDOcl.g:1933:3: 'last'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getLastKeyword_21()); 
                    match(input,42,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getLastKeyword_21()); 

                    }


                    }
                    break;
                case 23 :
                    // InternalDOcl.g:1938:2: ( 'including' )
                    {
                    // InternalDOcl.g:1938:2: ( 'including' )
                    // InternalDOcl.g:1939:3: 'including'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getIncludingKeyword_22()); 
                    match(input,43,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getIncludingKeyword_22()); 

                    }


                    }
                    break;
                case 24 :
                    // InternalDOcl.g:1944:2: ( 'excluding' )
                    {
                    // InternalDOcl.g:1944:2: ( 'excluding' )
                    // InternalDOcl.g:1945:3: 'excluding'
                    {
                     before(grammarAccess.getCollectionOperationIDAccess().getExcludingKeyword_23()); 
                    match(input,44,FOLLOW_2); 
                     after(grammarAccess.getCollectionOperationIDAccess().getExcludingKeyword_23()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOperationID__Alternatives"


    // $ANTLR start "rule__IterativeOperationID__Alternatives"
    // InternalDOcl.g:1954:1: rule__IterativeOperationID__Alternatives : ( ( 'exists' ) | ( 'forAll' ) | ( 'isUnique' ) | ( 'any' ) | ( 'one' ) | ( 'collect' ) | ( 'select' ) | ( 'reject' ) );
    public final void rule__IterativeOperationID__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:1958:1: ( ( 'exists' ) | ( 'forAll' ) | ( 'isUnique' ) | ( 'any' ) | ( 'one' ) | ( 'collect' ) | ( 'select' ) | ( 'reject' ) )
            int alt5=8;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt5=1;
                }
                break;
            case 46:
                {
                alt5=2;
                }
                break;
            case 47:
                {
                alt5=3;
                }
                break;
            case 48:
                {
                alt5=4;
                }
                break;
            case 49:
                {
                alt5=5;
                }
                break;
            case 50:
                {
                alt5=6;
                }
                break;
            case 51:
                {
                alt5=7;
                }
                break;
            case 52:
                {
                alt5=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalDOcl.g:1959:2: ( 'exists' )
                    {
                    // InternalDOcl.g:1959:2: ( 'exists' )
                    // InternalDOcl.g:1960:3: 'exists'
                    {
                     before(grammarAccess.getIterativeOperationIDAccess().getExistsKeyword_0()); 
                    match(input,45,FOLLOW_2); 
                     after(grammarAccess.getIterativeOperationIDAccess().getExistsKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:1965:2: ( 'forAll' )
                    {
                    // InternalDOcl.g:1965:2: ( 'forAll' )
                    // InternalDOcl.g:1966:3: 'forAll'
                    {
                     before(grammarAccess.getIterativeOperationIDAccess().getForAllKeyword_1()); 
                    match(input,46,FOLLOW_2); 
                     after(grammarAccess.getIterativeOperationIDAccess().getForAllKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDOcl.g:1971:2: ( 'isUnique' )
                    {
                    // InternalDOcl.g:1971:2: ( 'isUnique' )
                    // InternalDOcl.g:1972:3: 'isUnique'
                    {
                     before(grammarAccess.getIterativeOperationIDAccess().getIsUniqueKeyword_2()); 
                    match(input,47,FOLLOW_2); 
                     after(grammarAccess.getIterativeOperationIDAccess().getIsUniqueKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDOcl.g:1977:2: ( 'any' )
                    {
                    // InternalDOcl.g:1977:2: ( 'any' )
                    // InternalDOcl.g:1978:3: 'any'
                    {
                     before(grammarAccess.getIterativeOperationIDAccess().getAnyKeyword_3()); 
                    match(input,48,FOLLOW_2); 
                     after(grammarAccess.getIterativeOperationIDAccess().getAnyKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDOcl.g:1983:2: ( 'one' )
                    {
                    // InternalDOcl.g:1983:2: ( 'one' )
                    // InternalDOcl.g:1984:3: 'one'
                    {
                     before(grammarAccess.getIterativeOperationIDAccess().getOneKeyword_4()); 
                    match(input,49,FOLLOW_2); 
                     after(grammarAccess.getIterativeOperationIDAccess().getOneKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDOcl.g:1989:2: ( 'collect' )
                    {
                    // InternalDOcl.g:1989:2: ( 'collect' )
                    // InternalDOcl.g:1990:3: 'collect'
                    {
                     before(grammarAccess.getIterativeOperationIDAccess().getCollectKeyword_5()); 
                    match(input,50,FOLLOW_2); 
                     after(grammarAccess.getIterativeOperationIDAccess().getCollectKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDOcl.g:1995:2: ( 'select' )
                    {
                    // InternalDOcl.g:1995:2: ( 'select' )
                    // InternalDOcl.g:1996:3: 'select'
                    {
                     before(grammarAccess.getIterativeOperationIDAccess().getSelectKeyword_6()); 
                    match(input,51,FOLLOW_2); 
                     after(grammarAccess.getIterativeOperationIDAccess().getSelectKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDOcl.g:2001:2: ( 'reject' )
                    {
                    // InternalDOcl.g:2001:2: ( 'reject' )
                    // InternalDOcl.g:2002:3: 'reject'
                    {
                     before(grammarAccess.getIterativeOperationIDAccess().getRejectKeyword_7()); 
                    match(input,52,FOLLOW_2); 
                     after(grammarAccess.getIterativeOperationIDAccess().getRejectKeyword_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterativeOperationID__Alternatives"


    // $ANTLR start "rule__OclExpression__Alternatives"
    // InternalDOcl.g:2011:1: rule__OclExpression__Alternatives : ( ( ruleImpliesOpExp ) | ( ruleLetExp ) | ( ruleUnaryOpExp ) );
    public final void rule__OclExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2015:1: ( ( ruleImpliesOpExp ) | ( ruleLetExp ) | ( ruleUnaryOpExp ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 60:
            case 72:
            case 79:
            case 80:
            case 85:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 93:
                {
                alt6=1;
                }
                break;
            case 84:
                {
                alt6=2;
                }
                break;
            case 17:
            case 18:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalDOcl.g:2016:2: ( ruleImpliesOpExp )
                    {
                    // InternalDOcl.g:2016:2: ( ruleImpliesOpExp )
                    // InternalDOcl.g:2017:3: ruleImpliesOpExp
                    {
                     before(grammarAccess.getOclExpressionAccess().getImpliesOpExpParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleImpliesOpExp();

                    state._fsp--;

                     after(grammarAccess.getOclExpressionAccess().getImpliesOpExpParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:2022:2: ( ruleLetExp )
                    {
                    // InternalDOcl.g:2022:2: ( ruleLetExp )
                    // InternalDOcl.g:2023:3: ruleLetExp
                    {
                     before(grammarAccess.getOclExpressionAccess().getLetExpParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleLetExp();

                    state._fsp--;

                     after(grammarAccess.getOclExpressionAccess().getLetExpParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDOcl.g:2028:2: ( ruleUnaryOpExp )
                    {
                    // InternalDOcl.g:2028:2: ( ruleUnaryOpExp )
                    // InternalDOcl.g:2029:3: ruleUnaryOpExp
                    {
                     before(grammarAccess.getOclExpressionAccess().getUnaryOpExpParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleUnaryOpExp();

                    state._fsp--;

                     after(grammarAccess.getOclExpressionAccess().getUnaryOpExpParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclExpression__Alternatives"


    // $ANTLR start "rule__EqOpExp__NameAlternatives_1_1_0"
    // InternalDOcl.g:2038:1: rule__EqOpExp__NameAlternatives_1_1_0 : ( ( '<>' ) | ( '=' ) );
    public final void rule__EqOpExp__NameAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2042:1: ( ( '<>' ) | ( '=' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==53) ) {
                alt7=1;
            }
            else if ( (LA7_0==54) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalDOcl.g:2043:2: ( '<>' )
                    {
                    // InternalDOcl.g:2043:2: ( '<>' )
                    // InternalDOcl.g:2044:3: '<>'
                    {
                     before(grammarAccess.getEqOpExpAccess().getNameLessThanSignGreaterThanSignKeyword_1_1_0_0()); 
                    match(input,53,FOLLOW_2); 
                     after(grammarAccess.getEqOpExpAccess().getNameLessThanSignGreaterThanSignKeyword_1_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:2049:2: ( '=' )
                    {
                    // InternalDOcl.g:2049:2: ( '=' )
                    // InternalDOcl.g:2050:3: '='
                    {
                     before(grammarAccess.getEqOpExpAccess().getNameEqualsSignKeyword_1_1_0_1()); 
                    match(input,54,FOLLOW_2); 
                     after(grammarAccess.getEqOpExpAccess().getNameEqualsSignKeyword_1_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__NameAlternatives_1_1_0"


    // $ANTLR start "rule__ComparisonOpExp__NameAlternatives_1_1_0"
    // InternalDOcl.g:2059:1: rule__ComparisonOpExp__NameAlternatives_1_1_0 : ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) );
    public final void rule__ComparisonOpExp__NameAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2063:1: ( ( '>' ) | ( '<' ) | ( '>=' ) | ( '<=' ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt8=1;
                }
                break;
            case 56:
                {
                alt8=2;
                }
                break;
            case 57:
                {
                alt8=3;
                }
                break;
            case 58:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalDOcl.g:2064:2: ( '>' )
                    {
                    // InternalDOcl.g:2064:2: ( '>' )
                    // InternalDOcl.g:2065:3: '>'
                    {
                     before(grammarAccess.getComparisonOpExpAccess().getNameGreaterThanSignKeyword_1_1_0_0()); 
                    match(input,55,FOLLOW_2); 
                     after(grammarAccess.getComparisonOpExpAccess().getNameGreaterThanSignKeyword_1_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:2070:2: ( '<' )
                    {
                    // InternalDOcl.g:2070:2: ( '<' )
                    // InternalDOcl.g:2071:3: '<'
                    {
                     before(grammarAccess.getComparisonOpExpAccess().getNameLessThanSignKeyword_1_1_0_1()); 
                    match(input,56,FOLLOW_2); 
                     after(grammarAccess.getComparisonOpExpAccess().getNameLessThanSignKeyword_1_1_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDOcl.g:2076:2: ( '>=' )
                    {
                    // InternalDOcl.g:2076:2: ( '>=' )
                    // InternalDOcl.g:2077:3: '>='
                    {
                     before(grammarAccess.getComparisonOpExpAccess().getNameGreaterThanSignEqualsSignKeyword_1_1_0_2()); 
                    match(input,57,FOLLOW_2); 
                     after(grammarAccess.getComparisonOpExpAccess().getNameGreaterThanSignEqualsSignKeyword_1_1_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDOcl.g:2082:2: ( '<=' )
                    {
                    // InternalDOcl.g:2082:2: ( '<=' )
                    // InternalDOcl.g:2083:3: '<='
                    {
                     before(grammarAccess.getComparisonOpExpAccess().getNameLessThanSignEqualsSignKeyword_1_1_0_3()); 
                    match(input,58,FOLLOW_2); 
                     after(grammarAccess.getComparisonOpExpAccess().getNameLessThanSignEqualsSignKeyword_1_1_0_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__NameAlternatives_1_1_0"


    // $ANTLR start "rule__AdditionOpExp__NameAlternatives_1_1_0"
    // InternalDOcl.g:2092:1: rule__AdditionOpExp__NameAlternatives_1_1_0 : ( ( '+' ) | ( '-' ) );
    public final void rule__AdditionOpExp__NameAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2096:1: ( ( '+' ) | ( '-' ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==59) ) {
                alt9=1;
            }
            else if ( (LA9_0==17) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalDOcl.g:2097:2: ( '+' )
                    {
                    // InternalDOcl.g:2097:2: ( '+' )
                    // InternalDOcl.g:2098:3: '+'
                    {
                     before(grammarAccess.getAdditionOpExpAccess().getNamePlusSignKeyword_1_1_0_0()); 
                    match(input,59,FOLLOW_2); 
                     after(grammarAccess.getAdditionOpExpAccess().getNamePlusSignKeyword_1_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:2103:2: ( '-' )
                    {
                    // InternalDOcl.g:2103:2: ( '-' )
                    // InternalDOcl.g:2104:3: '-'
                    {
                     before(grammarAccess.getAdditionOpExpAccess().getNameHyphenMinusKeyword_1_1_0_1()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getAdditionOpExpAccess().getNameHyphenMinusKeyword_1_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__NameAlternatives_1_1_0"


    // $ANTLR start "rule__MultiOpExp__NameAlternatives_1_1_0"
    // InternalDOcl.g:2113:1: rule__MultiOpExp__NameAlternatives_1_1_0 : ( ( '*' ) | ( '/' ) );
    public final void rule__MultiOpExp__NameAlternatives_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2117:1: ( ( '*' ) | ( '/' ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==60) ) {
                alt10=1;
            }
            else if ( (LA10_0==61) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalDOcl.g:2118:2: ( '*' )
                    {
                    // InternalDOcl.g:2118:2: ( '*' )
                    // InternalDOcl.g:2119:3: '*'
                    {
                     before(grammarAccess.getMultiOpExpAccess().getNameAsteriskKeyword_1_1_0_0()); 
                    match(input,60,FOLLOW_2); 
                     after(grammarAccess.getMultiOpExpAccess().getNameAsteriskKeyword_1_1_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:2124:2: ( '/' )
                    {
                    // InternalDOcl.g:2124:2: ( '/' )
                    // InternalDOcl.g:2125:3: '/'
                    {
                     before(grammarAccess.getMultiOpExpAccess().getNameSolidusKeyword_1_1_0_1()); 
                    match(input,61,FOLLOW_2); 
                     after(grammarAccess.getMultiOpExpAccess().getNameSolidusKeyword_1_1_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__NameAlternatives_1_1_0"


    // $ANTLR start "rule__NavigationOpCallExp__Alternatives"
    // InternalDOcl.g:2134:1: rule__NavigationOpCallExp__Alternatives : ( ( ruleOperationCall ) | ( ruleNavigationOrAttributeCall ) | ( ruleIterateExp ) | ( ruleIteratorExp ) | ( ruleCollectionOpCall ) | ( rulePrimaryExp ) );
    public final void rule__NavigationOpCallExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2138:1: ( ( ruleOperationCall ) | ( ruleNavigationOrAttributeCall ) | ( ruleIterateExp ) | ( ruleIteratorExp ) | ( ruleCollectionOpCall ) | ( rulePrimaryExp ) )
            int alt11=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 65:
                case 76:
                    {
                    alt11=6;
                    }
                    break;
                case EOF:
                case 12:
                case 13:
                case 14:
                case 15:
                case 17:
                case 19:
                case 20:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 70:
                case 71:
                case 73:
                case 74:
                case 75:
                case 78:
                case 81:
                case 82:
                case 83:
                case 92:
                    {
                    alt11=2;
                    }
                    break;
                case 72:
                    {
                    alt11=1;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }

                }
                break;
            case 85:
                {
                alt11=3;
                }
                break;
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
                {
                alt11=4;
                }
                break;
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                {
                alt11=5;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 60:
            case 72:
            case 79:
            case 80:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 93:
                {
                alt11=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalDOcl.g:2139:2: ( ruleOperationCall )
                    {
                    // InternalDOcl.g:2139:2: ( ruleOperationCall )
                    // InternalDOcl.g:2140:3: ruleOperationCall
                    {
                     before(grammarAccess.getNavigationOpCallExpAccess().getOperationCallParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleOperationCall();

                    state._fsp--;

                     after(grammarAccess.getNavigationOpCallExpAccess().getOperationCallParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:2145:2: ( ruleNavigationOrAttributeCall )
                    {
                    // InternalDOcl.g:2145:2: ( ruleNavigationOrAttributeCall )
                    // InternalDOcl.g:2146:3: ruleNavigationOrAttributeCall
                    {
                     before(grammarAccess.getNavigationOpCallExpAccess().getNavigationOrAttributeCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleNavigationOrAttributeCall();

                    state._fsp--;

                     after(grammarAccess.getNavigationOpCallExpAccess().getNavigationOrAttributeCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDOcl.g:2151:2: ( ruleIterateExp )
                    {
                    // InternalDOcl.g:2151:2: ( ruleIterateExp )
                    // InternalDOcl.g:2152:3: ruleIterateExp
                    {
                     before(grammarAccess.getNavigationOpCallExpAccess().getIterateExpParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleIterateExp();

                    state._fsp--;

                     after(grammarAccess.getNavigationOpCallExpAccess().getIterateExpParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDOcl.g:2157:2: ( ruleIteratorExp )
                    {
                    // InternalDOcl.g:2157:2: ( ruleIteratorExp )
                    // InternalDOcl.g:2158:3: ruleIteratorExp
                    {
                     before(grammarAccess.getNavigationOpCallExpAccess().getIteratorExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleIteratorExp();

                    state._fsp--;

                     after(grammarAccess.getNavigationOpCallExpAccess().getIteratorExpParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDOcl.g:2163:2: ( ruleCollectionOpCall )
                    {
                    // InternalDOcl.g:2163:2: ( ruleCollectionOpCall )
                    // InternalDOcl.g:2164:3: ruleCollectionOpCall
                    {
                     before(grammarAccess.getNavigationOpCallExpAccess().getCollectionOpCallParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleCollectionOpCall();

                    state._fsp--;

                     after(grammarAccess.getNavigationOpCallExpAccess().getCollectionOpCallParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDOcl.g:2169:2: ( rulePrimaryExp )
                    {
                    // InternalDOcl.g:2169:2: ( rulePrimaryExp )
                    // InternalDOcl.g:2170:3: rulePrimaryExp
                    {
                     before(grammarAccess.getNavigationOpCallExpAccess().getPrimaryExpParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    rulePrimaryExp();

                    state._fsp--;

                     after(grammarAccess.getNavigationOpCallExpAccess().getPrimaryExpParserRuleCall_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationOpCallExp__Alternatives"


    // $ANTLR start "rule__PrimaryExp__Alternatives"
    // InternalDOcl.g:2179:1: rule__PrimaryExp__Alternatives : ( ( ruleSeflExp ) | ( ruleNestedExp ) | ( ruleIfExp ) | ( rulePrimitiveExp ) | ( ruleTupleExp ) | ( ruleLambdaExp ) | ( ruleOclModelElementExp ) );
    public final void rule__PrimaryExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2183:1: ( ( ruleSeflExp ) | ( ruleNestedExp ) | ( ruleIfExp ) | ( rulePrimitiveExp ) | ( ruleTupleExp ) | ( ruleLambdaExp ) | ( ruleOclModelElementExp ) )
            int alt12=7;
            switch ( input.LA(1) ) {
            case 93:
                {
                alt12=1;
                }
                break;
            case 72:
                {
                alt12=2;
                }
                break;
            case 91:
                {
                alt12=3;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 60:
            case 79:
            case 80:
            case 89:
            case 90:
                {
                alt12=4;
                }
                break;
            case 88:
                {
                alt12=5;
                }
                break;
            case 87:
                {
                alt12=6;
                }
                break;
            case RULE_ID:
                {
                alt12=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalDOcl.g:2184:2: ( ruleSeflExp )
                    {
                    // InternalDOcl.g:2184:2: ( ruleSeflExp )
                    // InternalDOcl.g:2185:3: ruleSeflExp
                    {
                     before(grammarAccess.getPrimaryExpAccess().getSeflExpParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleSeflExp();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpAccess().getSeflExpParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:2190:2: ( ruleNestedExp )
                    {
                    // InternalDOcl.g:2190:2: ( ruleNestedExp )
                    // InternalDOcl.g:2191:3: ruleNestedExp
                    {
                     before(grammarAccess.getPrimaryExpAccess().getNestedExpParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleNestedExp();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpAccess().getNestedExpParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDOcl.g:2196:2: ( ruleIfExp )
                    {
                    // InternalDOcl.g:2196:2: ( ruleIfExp )
                    // InternalDOcl.g:2197:3: ruleIfExp
                    {
                     before(grammarAccess.getPrimaryExpAccess().getIfExpParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleIfExp();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpAccess().getIfExpParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDOcl.g:2202:2: ( rulePrimitiveExp )
                    {
                    // InternalDOcl.g:2202:2: ( rulePrimitiveExp )
                    // InternalDOcl.g:2203:3: rulePrimitiveExp
                    {
                     before(grammarAccess.getPrimaryExpAccess().getPrimitiveExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    rulePrimitiveExp();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpAccess().getPrimitiveExpParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDOcl.g:2208:2: ( ruleTupleExp )
                    {
                    // InternalDOcl.g:2208:2: ( ruleTupleExp )
                    // InternalDOcl.g:2209:3: ruleTupleExp
                    {
                     before(grammarAccess.getPrimaryExpAccess().getTupleExpParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleTupleExp();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpAccess().getTupleExpParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDOcl.g:2214:2: ( ruleLambdaExp )
                    {
                    // InternalDOcl.g:2214:2: ( ruleLambdaExp )
                    // InternalDOcl.g:2215:3: ruleLambdaExp
                    {
                     before(grammarAccess.getPrimaryExpAccess().getLambdaExpParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleLambdaExp();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpAccess().getLambdaExpParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDOcl.g:2220:2: ( ruleOclModelElementExp )
                    {
                    // InternalDOcl.g:2220:2: ( ruleOclModelElementExp )
                    // InternalDOcl.g:2221:3: ruleOclModelElementExp
                    {
                     before(grammarAccess.getPrimaryExpAccess().getOclModelElementExpParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleOclModelElementExp();

                    state._fsp--;

                     after(grammarAccess.getPrimaryExpAccess().getOclModelElementExpParserRuleCall_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimaryExp__Alternatives"


    // $ANTLR start "rule__PrimitiveExp__Alternatives"
    // InternalDOcl.g:2230:1: rule__PrimitiveExp__Alternatives : ( ( ruleNumberExp ) | ( ruleStringExp ) | ( ruleBooleanExp ) | ( ruleUnlimitedNaturalExp ) | ( ruleInvalidExp ) | ( ruleNullExp ) );
    public final void rule__PrimitiveExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2234:1: ( ( ruleNumberExp ) | ( ruleStringExp ) | ( ruleBooleanExp ) | ( ruleUnlimitedNaturalExp ) | ( ruleInvalidExp ) | ( ruleNullExp ) )
            int alt13=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt13=1;
                }
                break;
            case RULE_STRING:
                {
                alt13=2;
                }
                break;
            case 89:
            case 90:
                {
                alt13=3;
                }
                break;
            case 60:
                {
                alt13=4;
                }
                break;
            case 79:
                {
                alt13=5;
                }
                break;
            case 80:
                {
                alt13=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalDOcl.g:2235:2: ( ruleNumberExp )
                    {
                    // InternalDOcl.g:2235:2: ( ruleNumberExp )
                    // InternalDOcl.g:2236:3: ruleNumberExp
                    {
                     before(grammarAccess.getPrimitiveExpAccess().getNumberExpParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleNumberExp();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveExpAccess().getNumberExpParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:2241:2: ( ruleStringExp )
                    {
                    // InternalDOcl.g:2241:2: ( ruleStringExp )
                    // InternalDOcl.g:2242:3: ruleStringExp
                    {
                     before(grammarAccess.getPrimitiveExpAccess().getStringExpParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleStringExp();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveExpAccess().getStringExpParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDOcl.g:2247:2: ( ruleBooleanExp )
                    {
                    // InternalDOcl.g:2247:2: ( ruleBooleanExp )
                    // InternalDOcl.g:2248:3: ruleBooleanExp
                    {
                     before(grammarAccess.getPrimitiveExpAccess().getBooleanExpParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanExp();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveExpAccess().getBooleanExpParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDOcl.g:2253:2: ( ruleUnlimitedNaturalExp )
                    {
                    // InternalDOcl.g:2253:2: ( ruleUnlimitedNaturalExp )
                    // InternalDOcl.g:2254:3: ruleUnlimitedNaturalExp
                    {
                     before(grammarAccess.getPrimitiveExpAccess().getUnlimitedNaturalExpParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleUnlimitedNaturalExp();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveExpAccess().getUnlimitedNaturalExpParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDOcl.g:2259:2: ( ruleInvalidExp )
                    {
                    // InternalDOcl.g:2259:2: ( ruleInvalidExp )
                    // InternalDOcl.g:2260:3: ruleInvalidExp
                    {
                     before(grammarAccess.getPrimitiveExpAccess().getInvalidExpParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleInvalidExp();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveExpAccess().getInvalidExpParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDOcl.g:2265:2: ( ruleNullExp )
                    {
                    // InternalDOcl.g:2265:2: ( ruleNullExp )
                    // InternalDOcl.g:2266:3: ruleNullExp
                    {
                     before(grammarAccess.getPrimitiveExpAccess().getNullExpParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleNullExp();

                    state._fsp--;

                     after(grammarAccess.getPrimitiveExpAccess().getNullExpParserRuleCall_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveExp__Alternatives"


    // $ANTLR start "rule__BooleanExp__Alternatives"
    // InternalDOcl.g:2275:1: rule__BooleanExp__Alternatives : ( ( ( rule__BooleanExp__SymbolAssignment_0 ) ) | ( ( rule__BooleanExp__SymbolAssignment_1 ) ) );
    public final void rule__BooleanExp__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2279:1: ( ( ( rule__BooleanExp__SymbolAssignment_0 ) ) | ( ( rule__BooleanExp__SymbolAssignment_1 ) ) )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==89) ) {
                alt14=1;
            }
            else if ( (LA14_0==90) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalDOcl.g:2280:2: ( ( rule__BooleanExp__SymbolAssignment_0 ) )
                    {
                    // InternalDOcl.g:2280:2: ( ( rule__BooleanExp__SymbolAssignment_0 ) )
                    // InternalDOcl.g:2281:3: ( rule__BooleanExp__SymbolAssignment_0 )
                    {
                     before(grammarAccess.getBooleanExpAccess().getSymbolAssignment_0()); 
                    // InternalDOcl.g:2282:3: ( rule__BooleanExp__SymbolAssignment_0 )
                    // InternalDOcl.g:2282:4: rule__BooleanExp__SymbolAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanExp__SymbolAssignment_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getBooleanExpAccess().getSymbolAssignment_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:2286:2: ( ( rule__BooleanExp__SymbolAssignment_1 ) )
                    {
                    // InternalDOcl.g:2286:2: ( ( rule__BooleanExp__SymbolAssignment_1 ) )
                    // InternalDOcl.g:2287:3: ( rule__BooleanExp__SymbolAssignment_1 )
                    {
                     before(grammarAccess.getBooleanExpAccess().getSymbolAssignment_1()); 
                    // InternalDOcl.g:2288:3: ( rule__BooleanExp__SymbolAssignment_1 )
                    // InternalDOcl.g:2288:4: rule__BooleanExp__SymbolAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanExp__SymbolAssignment_1();

                    state._fsp--;


                    }

                     after(grammarAccess.getBooleanExpAccess().getSymbolAssignment_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExp__Alternatives"


    // $ANTLR start "rule__OclType__Alternatives"
    // InternalDOcl.g:2296:1: rule__OclType__Alternatives : ( ( ruleStringType ) | ( ruleBooleanType ) | ( ruleIntegerType ) | ( ruleRealType ) | ( ruleBagType ) | ( ruleOrderedSetType ) | ( ruleSequenceType ) | ( ruleSetType ) | ( ruleOclAnyType ) | ( ruleTupleType ) | ( ruleOclModelElement ) | ( ruleMapType ) | ( ruleLambdaType ) | ( ruleEnvType ) );
    public final void rule__OclType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2300:1: ( ( ruleStringType ) | ( ruleBooleanType ) | ( ruleIntegerType ) | ( ruleRealType ) | ( ruleBagType ) | ( ruleOrderedSetType ) | ( ruleSequenceType ) | ( ruleSetType ) | ( ruleOclAnyType ) | ( ruleTupleType ) | ( ruleOclModelElement ) | ( ruleMapType ) | ( ruleLambdaType ) | ( ruleEnvType ) )
            int alt15=14;
            switch ( input.LA(1) ) {
            case 104:
                {
                alt15=1;
                }
                break;
            case 103:
                {
                alt15=2;
                }
                break;
            case 102:
                {
                alt15=3;
                }
                break;
            case 101:
                {
                alt15=4;
                }
                break;
            case 100:
                {
                alt15=5;
                }
                break;
            case 99:
                {
                alt15=6;
                }
                break;
            case 98:
                {
                alt15=7;
                }
                break;
            case 97:
                {
                alt15=8;
                }
                break;
            case 96:
                {
                alt15=9;
                }
                break;
            case 16:
                {
                alt15=10;
                }
                break;
            case RULE_ID:
                {
                alt15=11;
                }
                break;
            case 95:
                {
                alt15=12;
                }
                break;
            case 87:
                {
                alt15=13;
                }
                break;
            case 94:
                {
                alt15=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalDOcl.g:2301:2: ( ruleStringType )
                    {
                    // InternalDOcl.g:2301:2: ( ruleStringType )
                    // InternalDOcl.g:2302:3: ruleStringType
                    {
                     before(grammarAccess.getOclTypeAccess().getStringTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleStringType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getStringTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:2307:2: ( ruleBooleanType )
                    {
                    // InternalDOcl.g:2307:2: ( ruleBooleanType )
                    // InternalDOcl.g:2308:3: ruleBooleanType
                    {
                     before(grammarAccess.getOclTypeAccess().getBooleanTypeParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleBooleanType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getBooleanTypeParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalDOcl.g:2313:2: ( ruleIntegerType )
                    {
                    // InternalDOcl.g:2313:2: ( ruleIntegerType )
                    // InternalDOcl.g:2314:3: ruleIntegerType
                    {
                     before(grammarAccess.getOclTypeAccess().getIntegerTypeParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleIntegerType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getIntegerTypeParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalDOcl.g:2319:2: ( ruleRealType )
                    {
                    // InternalDOcl.g:2319:2: ( ruleRealType )
                    // InternalDOcl.g:2320:3: ruleRealType
                    {
                     before(grammarAccess.getOclTypeAccess().getRealTypeParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleRealType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getRealTypeParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalDOcl.g:2325:2: ( ruleBagType )
                    {
                    // InternalDOcl.g:2325:2: ( ruleBagType )
                    // InternalDOcl.g:2326:3: ruleBagType
                    {
                     before(grammarAccess.getOclTypeAccess().getBagTypeParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleBagType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getBagTypeParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalDOcl.g:2331:2: ( ruleOrderedSetType )
                    {
                    // InternalDOcl.g:2331:2: ( ruleOrderedSetType )
                    // InternalDOcl.g:2332:3: ruleOrderedSetType
                    {
                     before(grammarAccess.getOclTypeAccess().getOrderedSetTypeParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleOrderedSetType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getOrderedSetTypeParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalDOcl.g:2337:2: ( ruleSequenceType )
                    {
                    // InternalDOcl.g:2337:2: ( ruleSequenceType )
                    // InternalDOcl.g:2338:3: ruleSequenceType
                    {
                     before(grammarAccess.getOclTypeAccess().getSequenceTypeParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleSequenceType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getSequenceTypeParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalDOcl.g:2343:2: ( ruleSetType )
                    {
                    // InternalDOcl.g:2343:2: ( ruleSetType )
                    // InternalDOcl.g:2344:3: ruleSetType
                    {
                     before(grammarAccess.getOclTypeAccess().getSetTypeParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleSetType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getSetTypeParserRuleCall_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalDOcl.g:2349:2: ( ruleOclAnyType )
                    {
                    // InternalDOcl.g:2349:2: ( ruleOclAnyType )
                    // InternalDOcl.g:2350:3: ruleOclAnyType
                    {
                     before(grammarAccess.getOclTypeAccess().getOclAnyTypeParserRuleCall_8()); 
                    pushFollow(FOLLOW_2);
                    ruleOclAnyType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getOclAnyTypeParserRuleCall_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalDOcl.g:2355:2: ( ruleTupleType )
                    {
                    // InternalDOcl.g:2355:2: ( ruleTupleType )
                    // InternalDOcl.g:2356:3: ruleTupleType
                    {
                     before(grammarAccess.getOclTypeAccess().getTupleTypeParserRuleCall_9()); 
                    pushFollow(FOLLOW_2);
                    ruleTupleType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getTupleTypeParserRuleCall_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalDOcl.g:2361:2: ( ruleOclModelElement )
                    {
                    // InternalDOcl.g:2361:2: ( ruleOclModelElement )
                    // InternalDOcl.g:2362:3: ruleOclModelElement
                    {
                     before(grammarAccess.getOclTypeAccess().getOclModelElementParserRuleCall_10()); 
                    pushFollow(FOLLOW_2);
                    ruleOclModelElement();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getOclModelElementParserRuleCall_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalDOcl.g:2367:2: ( ruleMapType )
                    {
                    // InternalDOcl.g:2367:2: ( ruleMapType )
                    // InternalDOcl.g:2368:3: ruleMapType
                    {
                     before(grammarAccess.getOclTypeAccess().getMapTypeParserRuleCall_11()); 
                    pushFollow(FOLLOW_2);
                    ruleMapType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getMapTypeParserRuleCall_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalDOcl.g:2373:2: ( ruleLambdaType )
                    {
                    // InternalDOcl.g:2373:2: ( ruleLambdaType )
                    // InternalDOcl.g:2374:3: ruleLambdaType
                    {
                     before(grammarAccess.getOclTypeAccess().getLambdaTypeParserRuleCall_12()); 
                    pushFollow(FOLLOW_2);
                    ruleLambdaType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getLambdaTypeParserRuleCall_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalDOcl.g:2379:2: ( ruleEnvType )
                    {
                    // InternalDOcl.g:2379:2: ( ruleEnvType )
                    // InternalDOcl.g:2380:3: ruleEnvType
                    {
                     before(grammarAccess.getOclTypeAccess().getEnvTypeParserRuleCall_13()); 
                    pushFollow(FOLLOW_2);
                    ruleEnvType();

                    state._fsp--;

                     after(grammarAccess.getOclTypeAccess().getEnvTypeParserRuleCall_13()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclType__Alternatives"


    // $ANTLR start "rule__Module__Group__0"
    // InternalDOcl.g:2389:1: rule__Module__Group__0 : rule__Module__Group__0__Impl rule__Module__Group__1 ;
    public final void rule__Module__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2393:1: ( rule__Module__Group__0__Impl rule__Module__Group__1 )
            // InternalDOcl.g:2394:2: rule__Module__Group__0__Impl rule__Module__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Module__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__0"


    // $ANTLR start "rule__Module__Group__0__Impl"
    // InternalDOcl.g:2401:1: rule__Module__Group__0__Impl : ( () ) ;
    public final void rule__Module__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2405:1: ( ( () ) )
            // InternalDOcl.g:2406:1: ( () )
            {
            // InternalDOcl.g:2406:1: ( () )
            // InternalDOcl.g:2407:2: ()
            {
             before(grammarAccess.getModuleAccess().getModuleAction_0()); 
            // InternalDOcl.g:2408:2: ()
            // InternalDOcl.g:2408:3: 
            {
            }

             after(grammarAccess.getModuleAccess().getModuleAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__0__Impl"


    // $ANTLR start "rule__Module__Group__1"
    // InternalDOcl.g:2416:1: rule__Module__Group__1 : rule__Module__Group__1__Impl rule__Module__Group__2 ;
    public final void rule__Module__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2420:1: ( rule__Module__Group__1__Impl rule__Module__Group__2 )
            // InternalDOcl.g:2421:2: rule__Module__Group__1__Impl rule__Module__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Module__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__1"


    // $ANTLR start "rule__Module__Group__1__Impl"
    // InternalDOcl.g:2428:1: rule__Module__Group__1__Impl : ( 'module' ) ;
    public final void rule__Module__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2432:1: ( ( 'module' ) )
            // InternalDOcl.g:2433:1: ( 'module' )
            {
            // InternalDOcl.g:2433:1: ( 'module' )
            // InternalDOcl.g:2434:2: 'module'
            {
             before(grammarAccess.getModuleAccess().getModuleKeyword_1()); 
            match(input,62,FOLLOW_2); 
             after(grammarAccess.getModuleAccess().getModuleKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__1__Impl"


    // $ANTLR start "rule__Module__Group__2"
    // InternalDOcl.g:2443:1: rule__Module__Group__2 : rule__Module__Group__2__Impl rule__Module__Group__3 ;
    public final void rule__Module__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2447:1: ( rule__Module__Group__2__Impl rule__Module__Group__3 )
            // InternalDOcl.g:2448:2: rule__Module__Group__2__Impl rule__Module__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Module__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__2"


    // $ANTLR start "rule__Module__Group__2__Impl"
    // InternalDOcl.g:2455:1: rule__Module__Group__2__Impl : ( ( rule__Module__NameAssignment_2 ) ) ;
    public final void rule__Module__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2459:1: ( ( ( rule__Module__NameAssignment_2 ) ) )
            // InternalDOcl.g:2460:1: ( ( rule__Module__NameAssignment_2 ) )
            {
            // InternalDOcl.g:2460:1: ( ( rule__Module__NameAssignment_2 ) )
            // InternalDOcl.g:2461:2: ( rule__Module__NameAssignment_2 )
            {
             before(grammarAccess.getModuleAccess().getNameAssignment_2()); 
            // InternalDOcl.g:2462:2: ( rule__Module__NameAssignment_2 )
            // InternalDOcl.g:2462:3: rule__Module__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Module__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__2__Impl"


    // $ANTLR start "rule__Module__Group__3"
    // InternalDOcl.g:2470:1: rule__Module__Group__3 : rule__Module__Group__3__Impl rule__Module__Group__4 ;
    public final void rule__Module__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2474:1: ( rule__Module__Group__3__Impl rule__Module__Group__4 )
            // InternalDOcl.g:2475:2: rule__Module__Group__3__Impl rule__Module__Group__4
            {
            pushFollow(FOLLOW_5);
            rule__Module__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__3"


    // $ANTLR start "rule__Module__Group__3__Impl"
    // InternalDOcl.g:2482:1: rule__Module__Group__3__Impl : ( '@@source' ) ;
    public final void rule__Module__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2486:1: ( ( '@@source' ) )
            // InternalDOcl.g:2487:1: ( '@@source' )
            {
            // InternalDOcl.g:2487:1: ( '@@source' )
            // InternalDOcl.g:2488:2: '@@source'
            {
             before(grammarAccess.getModuleAccess().getSourceKeyword_3()); 
            match(input,63,FOLLOW_2); 
             after(grammarAccess.getModuleAccess().getSourceKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__3__Impl"


    // $ANTLR start "rule__Module__Group__4"
    // InternalDOcl.g:2497:1: rule__Module__Group__4 : rule__Module__Group__4__Impl rule__Module__Group__5 ;
    public final void rule__Module__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2501:1: ( rule__Module__Group__4__Impl rule__Module__Group__5 )
            // InternalDOcl.g:2502:2: rule__Module__Group__4__Impl rule__Module__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__Module__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__4"


    // $ANTLR start "rule__Module__Group__4__Impl"
    // InternalDOcl.g:2509:1: rule__Module__Group__4__Impl : ( ( rule__Module__SourceAssignment_4 ) ) ;
    public final void rule__Module__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2513:1: ( ( ( rule__Module__SourceAssignment_4 ) ) )
            // InternalDOcl.g:2514:1: ( ( rule__Module__SourceAssignment_4 ) )
            {
            // InternalDOcl.g:2514:1: ( ( rule__Module__SourceAssignment_4 ) )
            // InternalDOcl.g:2515:2: ( rule__Module__SourceAssignment_4 )
            {
             before(grammarAccess.getModuleAccess().getSourceAssignment_4()); 
            // InternalDOcl.g:2516:2: ( rule__Module__SourceAssignment_4 )
            // InternalDOcl.g:2516:3: rule__Module__SourceAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Module__SourceAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getSourceAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__4__Impl"


    // $ANTLR start "rule__Module__Group__5"
    // InternalDOcl.g:2524:1: rule__Module__Group__5 : rule__Module__Group__5__Impl rule__Module__Group__6 ;
    public final void rule__Module__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2528:1: ( rule__Module__Group__5__Impl rule__Module__Group__6 )
            // InternalDOcl.g:2529:2: rule__Module__Group__5__Impl rule__Module__Group__6
            {
            pushFollow(FOLLOW_5);
            rule__Module__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__5"


    // $ANTLR start "rule__Module__Group__5__Impl"
    // InternalDOcl.g:2536:1: rule__Module__Group__5__Impl : ( '@@input' ) ;
    public final void rule__Module__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2540:1: ( ( '@@input' ) )
            // InternalDOcl.g:2541:1: ( '@@input' )
            {
            // InternalDOcl.g:2541:1: ( '@@input' )
            // InternalDOcl.g:2542:2: '@@input'
            {
             before(grammarAccess.getModuleAccess().getInputKeyword_5()); 
            match(input,64,FOLLOW_2); 
             after(grammarAccess.getModuleAccess().getInputKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__5__Impl"


    // $ANTLR start "rule__Module__Group__6"
    // InternalDOcl.g:2551:1: rule__Module__Group__6 : rule__Module__Group__6__Impl rule__Module__Group__7 ;
    public final void rule__Module__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2555:1: ( rule__Module__Group__6__Impl rule__Module__Group__7 )
            // InternalDOcl.g:2556:2: rule__Module__Group__6__Impl rule__Module__Group__7
            {
            pushFollow(FOLLOW_8);
            rule__Module__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__6"


    // $ANTLR start "rule__Module__Group__6__Impl"
    // InternalDOcl.g:2563:1: rule__Module__Group__6__Impl : ( ( rule__Module__InputAssignment_6 ) ) ;
    public final void rule__Module__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2567:1: ( ( ( rule__Module__InputAssignment_6 ) ) )
            // InternalDOcl.g:2568:1: ( ( rule__Module__InputAssignment_6 ) )
            {
            // InternalDOcl.g:2568:1: ( ( rule__Module__InputAssignment_6 ) )
            // InternalDOcl.g:2569:2: ( rule__Module__InputAssignment_6 )
            {
             before(grammarAccess.getModuleAccess().getInputAssignment_6()); 
            // InternalDOcl.g:2570:2: ( rule__Module__InputAssignment_6 )
            // InternalDOcl.g:2570:3: rule__Module__InputAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__Module__InputAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getInputAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__6__Impl"


    // $ANTLR start "rule__Module__Group__7"
    // InternalDOcl.g:2578:1: rule__Module__Group__7 : rule__Module__Group__7__Impl rule__Module__Group__8 ;
    public final void rule__Module__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2582:1: ( rule__Module__Group__7__Impl rule__Module__Group__8 )
            // InternalDOcl.g:2583:2: rule__Module__Group__7__Impl rule__Module__Group__8
            {
            pushFollow(FOLLOW_8);
            rule__Module__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__7"


    // $ANTLR start "rule__Module__Group__7__Impl"
    // InternalDOcl.g:2590:1: rule__Module__Group__7__Impl : ( ( rule__Module__Group_7__0 )? ) ;
    public final void rule__Module__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2594:1: ( ( ( rule__Module__Group_7__0 )? ) )
            // InternalDOcl.g:2595:1: ( ( rule__Module__Group_7__0 )? )
            {
            // InternalDOcl.g:2595:1: ( ( rule__Module__Group_7__0 )? )
            // InternalDOcl.g:2596:2: ( rule__Module__Group_7__0 )?
            {
             before(grammarAccess.getModuleAccess().getGroup_7()); 
            // InternalDOcl.g:2597:2: ( rule__Module__Group_7__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==68) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDOcl.g:2597:3: rule__Module__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Module__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModuleAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__7__Impl"


    // $ANTLR start "rule__Module__Group__8"
    // InternalDOcl.g:2605:1: rule__Module__Group__8 : rule__Module__Group__8__Impl ;
    public final void rule__Module__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2609:1: ( rule__Module__Group__8__Impl )
            // InternalDOcl.g:2610:2: rule__Module__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Module__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__8"


    // $ANTLR start "rule__Module__Group__8__Impl"
    // InternalDOcl.g:2616:1: rule__Module__Group__8__Impl : ( ( rule__Module__Group_8__0 )? ) ;
    public final void rule__Module__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2620:1: ( ( ( rule__Module__Group_8__0 )? ) )
            // InternalDOcl.g:2621:1: ( ( rule__Module__Group_8__0 )? )
            {
            // InternalDOcl.g:2621:1: ( ( rule__Module__Group_8__0 )? )
            // InternalDOcl.g:2622:2: ( rule__Module__Group_8__0 )?
            {
             before(grammarAccess.getModuleAccess().getGroup_8()); 
            // InternalDOcl.g:2623:2: ( rule__Module__Group_8__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==69) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDOcl.g:2623:3: rule__Module__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Module__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModuleAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__8__Impl"


    // $ANTLR start "rule__Module__Group_7__0"
    // InternalDOcl.g:2632:1: rule__Module__Group_7__0 : rule__Module__Group_7__0__Impl rule__Module__Group_7__1 ;
    public final void rule__Module__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2636:1: ( rule__Module__Group_7__0__Impl rule__Module__Group_7__1 )
            // InternalDOcl.g:2637:2: rule__Module__Group_7__0__Impl rule__Module__Group_7__1
            {
            pushFollow(FOLLOW_9);
            rule__Module__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_7__0"


    // $ANTLR start "rule__Module__Group_7__0__Impl"
    // InternalDOcl.g:2644:1: rule__Module__Group_7__0__Impl : ( ( rule__Module__ImportsAssignment_7_0 ) ) ;
    public final void rule__Module__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2648:1: ( ( ( rule__Module__ImportsAssignment_7_0 ) ) )
            // InternalDOcl.g:2649:1: ( ( rule__Module__ImportsAssignment_7_0 ) )
            {
            // InternalDOcl.g:2649:1: ( ( rule__Module__ImportsAssignment_7_0 ) )
            // InternalDOcl.g:2650:2: ( rule__Module__ImportsAssignment_7_0 )
            {
             before(grammarAccess.getModuleAccess().getImportsAssignment_7_0()); 
            // InternalDOcl.g:2651:2: ( rule__Module__ImportsAssignment_7_0 )
            // InternalDOcl.g:2651:3: rule__Module__ImportsAssignment_7_0
            {
            pushFollow(FOLLOW_2);
            rule__Module__ImportsAssignment_7_0();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getImportsAssignment_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_7__0__Impl"


    // $ANTLR start "rule__Module__Group_7__1"
    // InternalDOcl.g:2659:1: rule__Module__Group_7__1 : rule__Module__Group_7__1__Impl ;
    public final void rule__Module__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2663:1: ( rule__Module__Group_7__1__Impl )
            // InternalDOcl.g:2664:2: rule__Module__Group_7__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Module__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_7__1"


    // $ANTLR start "rule__Module__Group_7__1__Impl"
    // InternalDOcl.g:2670:1: rule__Module__Group_7__1__Impl : ( ( rule__Module__ImportsAssignment_7_1 )* ) ;
    public final void rule__Module__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2674:1: ( ( ( rule__Module__ImportsAssignment_7_1 )* ) )
            // InternalDOcl.g:2675:1: ( ( rule__Module__ImportsAssignment_7_1 )* )
            {
            // InternalDOcl.g:2675:1: ( ( rule__Module__ImportsAssignment_7_1 )* )
            // InternalDOcl.g:2676:2: ( rule__Module__ImportsAssignment_7_1 )*
            {
             before(grammarAccess.getModuleAccess().getImportsAssignment_7_1()); 
            // InternalDOcl.g:2677:2: ( rule__Module__ImportsAssignment_7_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==68) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalDOcl.g:2677:3: rule__Module__ImportsAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Module__ImportsAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getModuleAccess().getImportsAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_7__1__Impl"


    // $ANTLR start "rule__Module__Group_8__0"
    // InternalDOcl.g:2686:1: rule__Module__Group_8__0 : rule__Module__Group_8__0__Impl rule__Module__Group_8__1 ;
    public final void rule__Module__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2690:1: ( rule__Module__Group_8__0__Impl rule__Module__Group_8__1 )
            // InternalDOcl.g:2691:2: rule__Module__Group_8__0__Impl rule__Module__Group_8__1
            {
            pushFollow(FOLLOW_11);
            rule__Module__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_8__0"


    // $ANTLR start "rule__Module__Group_8__0__Impl"
    // InternalDOcl.g:2698:1: rule__Module__Group_8__0__Impl : ( ( rule__Module__ElementsAssignment_8_0 ) ) ;
    public final void rule__Module__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2702:1: ( ( ( rule__Module__ElementsAssignment_8_0 ) ) )
            // InternalDOcl.g:2703:1: ( ( rule__Module__ElementsAssignment_8_0 ) )
            {
            // InternalDOcl.g:2703:1: ( ( rule__Module__ElementsAssignment_8_0 ) )
            // InternalDOcl.g:2704:2: ( rule__Module__ElementsAssignment_8_0 )
            {
             before(grammarAccess.getModuleAccess().getElementsAssignment_8_0()); 
            // InternalDOcl.g:2705:2: ( rule__Module__ElementsAssignment_8_0 )
            // InternalDOcl.g:2705:3: rule__Module__ElementsAssignment_8_0
            {
            pushFollow(FOLLOW_2);
            rule__Module__ElementsAssignment_8_0();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getElementsAssignment_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_8__0__Impl"


    // $ANTLR start "rule__Module__Group_8__1"
    // InternalDOcl.g:2713:1: rule__Module__Group_8__1 : rule__Module__Group_8__1__Impl ;
    public final void rule__Module__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2717:1: ( rule__Module__Group_8__1__Impl )
            // InternalDOcl.g:2718:2: rule__Module__Group_8__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Module__Group_8__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_8__1"


    // $ANTLR start "rule__Module__Group_8__1__Impl"
    // InternalDOcl.g:2724:1: rule__Module__Group_8__1__Impl : ( ( rule__Module__ElementsAssignment_8_1 )* ) ;
    public final void rule__Module__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2728:1: ( ( ( rule__Module__ElementsAssignment_8_1 )* ) )
            // InternalDOcl.g:2729:1: ( ( rule__Module__ElementsAssignment_8_1 )* )
            {
            // InternalDOcl.g:2729:1: ( ( rule__Module__ElementsAssignment_8_1 )* )
            // InternalDOcl.g:2730:2: ( rule__Module__ElementsAssignment_8_1 )*
            {
             before(grammarAccess.getModuleAccess().getElementsAssignment_8_1()); 
            // InternalDOcl.g:2731:2: ( rule__Module__ElementsAssignment_8_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==69) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDOcl.g:2731:3: rule__Module__ElementsAssignment_8_1
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Module__ElementsAssignment_8_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getModuleAccess().getElementsAssignment_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_8__1__Impl"


    // $ANTLR start "rule__OclModel__Group__0"
    // InternalDOcl.g:2740:1: rule__OclModel__Group__0 : rule__OclModel__Group__0__Impl rule__OclModel__Group__1 ;
    public final void rule__OclModel__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2744:1: ( rule__OclModel__Group__0__Impl rule__OclModel__Group__1 )
            // InternalDOcl.g:2745:2: rule__OclModel__Group__0__Impl rule__OclModel__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__OclModel__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OclModel__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModel__Group__0"


    // $ANTLR start "rule__OclModel__Group__0__Impl"
    // InternalDOcl.g:2752:1: rule__OclModel__Group__0__Impl : ( ( rule__OclModel__NameAssignment_0 ) ) ;
    public final void rule__OclModel__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2756:1: ( ( ( rule__OclModel__NameAssignment_0 ) ) )
            // InternalDOcl.g:2757:1: ( ( rule__OclModel__NameAssignment_0 ) )
            {
            // InternalDOcl.g:2757:1: ( ( rule__OclModel__NameAssignment_0 ) )
            // InternalDOcl.g:2758:2: ( rule__OclModel__NameAssignment_0 )
            {
             before(grammarAccess.getOclModelAccess().getNameAssignment_0()); 
            // InternalDOcl.g:2759:2: ( rule__OclModel__NameAssignment_0 )
            // InternalDOcl.g:2759:3: rule__OclModel__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OclModel__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOclModelAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModel__Group__0__Impl"


    // $ANTLR start "rule__OclModel__Group__1"
    // InternalDOcl.g:2767:1: rule__OclModel__Group__1 : rule__OclModel__Group__1__Impl ;
    public final void rule__OclModel__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2771:1: ( rule__OclModel__Group__1__Impl )
            // InternalDOcl.g:2772:2: rule__OclModel__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OclModel__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModel__Group__1"


    // $ANTLR start "rule__OclModel__Group__1__Impl"
    // InternalDOcl.g:2778:1: rule__OclModel__Group__1__Impl : ( ( rule__OclModel__UriAssignment_1 )? ) ;
    public final void rule__OclModel__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2782:1: ( ( ( rule__OclModel__UriAssignment_1 )? ) )
            // InternalDOcl.g:2783:1: ( ( rule__OclModel__UriAssignment_1 )? )
            {
            // InternalDOcl.g:2783:1: ( ( rule__OclModel__UriAssignment_1 )? )
            // InternalDOcl.g:2784:2: ( rule__OclModel__UriAssignment_1 )?
            {
             before(grammarAccess.getOclModelAccess().getUriAssignment_1()); 
            // InternalDOcl.g:2785:2: ( rule__OclModel__UriAssignment_1 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==65) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalDOcl.g:2785:3: rule__OclModel__UriAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__OclModel__UriAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOclModelAccess().getUriAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModel__Group__1__Impl"


    // $ANTLR start "rule__URI___Group__0"
    // InternalDOcl.g:2794:1: rule__URI___Group__0 : rule__URI___Group__0__Impl rule__URI___Group__1 ;
    public final void rule__URI___Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2798:1: ( rule__URI___Group__0__Impl rule__URI___Group__1 )
            // InternalDOcl.g:2799:2: rule__URI___Group__0__Impl rule__URI___Group__1
            {
            pushFollow(FOLLOW_14);
            rule__URI___Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__URI___Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Group__0"


    // $ANTLR start "rule__URI___Group__0__Impl"
    // InternalDOcl.g:2806:1: rule__URI___Group__0__Impl : ( 'uri=' ) ;
    public final void rule__URI___Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2810:1: ( ( 'uri=' ) )
            // InternalDOcl.g:2811:1: ( 'uri=' )
            {
            // InternalDOcl.g:2811:1: ( 'uri=' )
            // InternalDOcl.g:2812:2: 'uri='
            {
             before(grammarAccess.getURI_Access().getUriKeyword_0()); 
            match(input,65,FOLLOW_2); 
             after(grammarAccess.getURI_Access().getUriKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Group__0__Impl"


    // $ANTLR start "rule__URI___Group__1"
    // InternalDOcl.g:2821:1: rule__URI___Group__1 : rule__URI___Group__1__Impl rule__URI___Group__2 ;
    public final void rule__URI___Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2825:1: ( rule__URI___Group__1__Impl rule__URI___Group__2 )
            // InternalDOcl.g:2826:2: rule__URI___Group__1__Impl rule__URI___Group__2
            {
            pushFollow(FOLLOW_15);
            rule__URI___Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__URI___Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Group__1"


    // $ANTLR start "rule__URI___Group__1__Impl"
    // InternalDOcl.g:2833:1: rule__URI___Group__1__Impl : ( ( rule__URI___SchemeAssignment_1 ) ) ;
    public final void rule__URI___Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2837:1: ( ( ( rule__URI___SchemeAssignment_1 ) ) )
            // InternalDOcl.g:2838:1: ( ( rule__URI___SchemeAssignment_1 ) )
            {
            // InternalDOcl.g:2838:1: ( ( rule__URI___SchemeAssignment_1 ) )
            // InternalDOcl.g:2839:2: ( rule__URI___SchemeAssignment_1 )
            {
             before(grammarAccess.getURI_Access().getSchemeAssignment_1()); 
            // InternalDOcl.g:2840:2: ( rule__URI___SchemeAssignment_1 )
            // InternalDOcl.g:2840:3: rule__URI___SchemeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__URI___SchemeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getURI_Access().getSchemeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Group__1__Impl"


    // $ANTLR start "rule__URI___Group__2"
    // InternalDOcl.g:2848:1: rule__URI___Group__2 : rule__URI___Group__2__Impl rule__URI___Group__3 ;
    public final void rule__URI___Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2852:1: ( rule__URI___Group__2__Impl rule__URI___Group__3 )
            // InternalDOcl.g:2853:2: rule__URI___Group__2__Impl rule__URI___Group__3
            {
            pushFollow(FOLLOW_5);
            rule__URI___Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__URI___Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Group__2"


    // $ANTLR start "rule__URI___Group__2__Impl"
    // InternalDOcl.g:2860:1: rule__URI___Group__2__Impl : ( '://' ) ;
    public final void rule__URI___Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2864:1: ( ( '://' ) )
            // InternalDOcl.g:2865:1: ( '://' )
            {
            // InternalDOcl.g:2865:1: ( '://' )
            // InternalDOcl.g:2866:2: '://'
            {
             before(grammarAccess.getURI_Access().getColonSolidusSolidusKeyword_2()); 
            match(input,66,FOLLOW_2); 
             after(grammarAccess.getURI_Access().getColonSolidusSolidusKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Group__2__Impl"


    // $ANTLR start "rule__URI___Group__3"
    // InternalDOcl.g:2875:1: rule__URI___Group__3 : rule__URI___Group__3__Impl rule__URI___Group__4 ;
    public final void rule__URI___Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2879:1: ( rule__URI___Group__3__Impl rule__URI___Group__4 )
            // InternalDOcl.g:2880:2: rule__URI___Group__3__Impl rule__URI___Group__4
            {
            pushFollow(FOLLOW_16);
            rule__URI___Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__URI___Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Group__3"


    // $ANTLR start "rule__URI___Group__3__Impl"
    // InternalDOcl.g:2887:1: rule__URI___Group__3__Impl : ( ( rule__URI___AuthorityAssignment_3 ) ) ;
    public final void rule__URI___Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2891:1: ( ( ( rule__URI___AuthorityAssignment_3 ) ) )
            // InternalDOcl.g:2892:1: ( ( rule__URI___AuthorityAssignment_3 ) )
            {
            // InternalDOcl.g:2892:1: ( ( rule__URI___AuthorityAssignment_3 ) )
            // InternalDOcl.g:2893:2: ( rule__URI___AuthorityAssignment_3 )
            {
             before(grammarAccess.getURI_Access().getAuthorityAssignment_3()); 
            // InternalDOcl.g:2894:2: ( rule__URI___AuthorityAssignment_3 )
            // InternalDOcl.g:2894:3: rule__URI___AuthorityAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__URI___AuthorityAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getURI_Access().getAuthorityAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Group__3__Impl"


    // $ANTLR start "rule__URI___Group__4"
    // InternalDOcl.g:2902:1: rule__URI___Group__4 : rule__URI___Group__4__Impl rule__URI___Group__5 ;
    public final void rule__URI___Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2906:1: ( rule__URI___Group__4__Impl rule__URI___Group__5 )
            // InternalDOcl.g:2907:2: rule__URI___Group__4__Impl rule__URI___Group__5
            {
            pushFollow(FOLLOW_5);
            rule__URI___Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__URI___Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Group__4"


    // $ANTLR start "rule__URI___Group__4__Impl"
    // InternalDOcl.g:2914:1: rule__URI___Group__4__Impl : ( '/' ) ;
    public final void rule__URI___Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2918:1: ( ( '/' ) )
            // InternalDOcl.g:2919:1: ( '/' )
            {
            // InternalDOcl.g:2919:1: ( '/' )
            // InternalDOcl.g:2920:2: '/'
            {
             before(grammarAccess.getURI_Access().getSolidusKeyword_4()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getURI_Access().getSolidusKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Group__4__Impl"


    // $ANTLR start "rule__URI___Group__5"
    // InternalDOcl.g:2929:1: rule__URI___Group__5 : rule__URI___Group__5__Impl ;
    public final void rule__URI___Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2933:1: ( rule__URI___Group__5__Impl )
            // InternalDOcl.g:2934:2: rule__URI___Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__URI___Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Group__5"


    // $ANTLR start "rule__URI___Group__5__Impl"
    // InternalDOcl.g:2940:1: rule__URI___Group__5__Impl : ( ( rule__URI___Fragment_Assignment_5 ) ) ;
    public final void rule__URI___Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2944:1: ( ( ( rule__URI___Fragment_Assignment_5 ) ) )
            // InternalDOcl.g:2945:1: ( ( rule__URI___Fragment_Assignment_5 ) )
            {
            // InternalDOcl.g:2945:1: ( ( rule__URI___Fragment_Assignment_5 ) )
            // InternalDOcl.g:2946:2: ( rule__URI___Fragment_Assignment_5 )
            {
             before(grammarAccess.getURI_Access().getFragment_Assignment_5()); 
            // InternalDOcl.g:2947:2: ( rule__URI___Fragment_Assignment_5 )
            // InternalDOcl.g:2947:3: rule__URI___Fragment_Assignment_5
            {
            pushFollow(FOLLOW_2);
            rule__URI___Fragment_Assignment_5();

            state._fsp--;


            }

             after(grammarAccess.getURI_Access().getFragment_Assignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Group__5__Impl"


    // $ANTLR start "rule__FRAGMENT__Group__0"
    // InternalDOcl.g:2956:1: rule__FRAGMENT__Group__0 : rule__FRAGMENT__Group__0__Impl rule__FRAGMENT__Group__1 ;
    public final void rule__FRAGMENT__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2960:1: ( rule__FRAGMENT__Group__0__Impl rule__FRAGMENT__Group__1 )
            // InternalDOcl.g:2961:2: rule__FRAGMENT__Group__0__Impl rule__FRAGMENT__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__FRAGMENT__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FRAGMENT__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FRAGMENT__Group__0"


    // $ANTLR start "rule__FRAGMENT__Group__0__Impl"
    // InternalDOcl.g:2968:1: rule__FRAGMENT__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__FRAGMENT__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2972:1: ( ( RULE_ID ) )
            // InternalDOcl.g:2973:1: ( RULE_ID )
            {
            // InternalDOcl.g:2973:1: ( RULE_ID )
            // InternalDOcl.g:2974:2: RULE_ID
            {
             before(grammarAccess.getFRAGMENTAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFRAGMENTAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FRAGMENT__Group__0__Impl"


    // $ANTLR start "rule__FRAGMENT__Group__1"
    // InternalDOcl.g:2983:1: rule__FRAGMENT__Group__1 : rule__FRAGMENT__Group__1__Impl ;
    public final void rule__FRAGMENT__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2987:1: ( rule__FRAGMENT__Group__1__Impl )
            // InternalDOcl.g:2988:2: rule__FRAGMENT__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FRAGMENT__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FRAGMENT__Group__1"


    // $ANTLR start "rule__FRAGMENT__Group__1__Impl"
    // InternalDOcl.g:2994:1: rule__FRAGMENT__Group__1__Impl : ( ( rule__FRAGMENT__Group_1__0 )* ) ;
    public final void rule__FRAGMENT__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:2998:1: ( ( ( rule__FRAGMENT__Group_1__0 )* ) )
            // InternalDOcl.g:2999:1: ( ( rule__FRAGMENT__Group_1__0 )* )
            {
            // InternalDOcl.g:2999:1: ( ( rule__FRAGMENT__Group_1__0 )* )
            // InternalDOcl.g:3000:2: ( rule__FRAGMENT__Group_1__0 )*
            {
             before(grammarAccess.getFRAGMENTAccess().getGroup_1()); 
            // InternalDOcl.g:3001:2: ( rule__FRAGMENT__Group_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==61) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalDOcl.g:3001:3: rule__FRAGMENT__Group_1__0
            	    {
            	    pushFollow(FOLLOW_17);
            	    rule__FRAGMENT__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getFRAGMENTAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FRAGMENT__Group__1__Impl"


    // $ANTLR start "rule__FRAGMENT__Group_1__0"
    // InternalDOcl.g:3010:1: rule__FRAGMENT__Group_1__0 : rule__FRAGMENT__Group_1__0__Impl rule__FRAGMENT__Group_1__1 ;
    public final void rule__FRAGMENT__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3014:1: ( rule__FRAGMENT__Group_1__0__Impl rule__FRAGMENT__Group_1__1 )
            // InternalDOcl.g:3015:2: rule__FRAGMENT__Group_1__0__Impl rule__FRAGMENT__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__FRAGMENT__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FRAGMENT__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FRAGMENT__Group_1__0"


    // $ANTLR start "rule__FRAGMENT__Group_1__0__Impl"
    // InternalDOcl.g:3022:1: rule__FRAGMENT__Group_1__0__Impl : ( '/' ) ;
    public final void rule__FRAGMENT__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3026:1: ( ( '/' ) )
            // InternalDOcl.g:3027:1: ( '/' )
            {
            // InternalDOcl.g:3027:1: ( '/' )
            // InternalDOcl.g:3028:2: '/'
            {
             before(grammarAccess.getFRAGMENTAccess().getSolidusKeyword_1_0()); 
            match(input,61,FOLLOW_2); 
             after(grammarAccess.getFRAGMENTAccess().getSolidusKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FRAGMENT__Group_1__0__Impl"


    // $ANTLR start "rule__FRAGMENT__Group_1__1"
    // InternalDOcl.g:3037:1: rule__FRAGMENT__Group_1__1 : rule__FRAGMENT__Group_1__1__Impl ;
    public final void rule__FRAGMENT__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3041:1: ( rule__FRAGMENT__Group_1__1__Impl )
            // InternalDOcl.g:3042:2: rule__FRAGMENT__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FRAGMENT__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FRAGMENT__Group_1__1"


    // $ANTLR start "rule__FRAGMENT__Group_1__1__Impl"
    // InternalDOcl.g:3048:1: rule__FRAGMENT__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__FRAGMENT__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3052:1: ( ( RULE_ID ) )
            // InternalDOcl.g:3053:1: ( RULE_ID )
            {
            // InternalDOcl.g:3053:1: ( RULE_ID )
            // InternalDOcl.g:3054:2: RULE_ID
            {
             before(grammarAccess.getFRAGMENTAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFRAGMENTAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FRAGMENT__Group_1__1__Impl"


    // $ANTLR start "rule__AUTHORITY__Group__0"
    // InternalDOcl.g:3064:1: rule__AUTHORITY__Group__0 : rule__AUTHORITY__Group__0__Impl rule__AUTHORITY__Group__1 ;
    public final void rule__AUTHORITY__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3068:1: ( rule__AUTHORITY__Group__0__Impl rule__AUTHORITY__Group__1 )
            // InternalDOcl.g:3069:2: rule__AUTHORITY__Group__0__Impl rule__AUTHORITY__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__AUTHORITY__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AUTHORITY__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group__0"


    // $ANTLR start "rule__AUTHORITY__Group__0__Impl"
    // InternalDOcl.g:3076:1: rule__AUTHORITY__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__AUTHORITY__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3080:1: ( ( RULE_ID ) )
            // InternalDOcl.g:3081:1: ( RULE_ID )
            {
            // InternalDOcl.g:3081:1: ( RULE_ID )
            // InternalDOcl.g:3082:2: RULE_ID
            {
             before(grammarAccess.getAUTHORITYAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAUTHORITYAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group__0__Impl"


    // $ANTLR start "rule__AUTHORITY__Group__1"
    // InternalDOcl.g:3091:1: rule__AUTHORITY__Group__1 : rule__AUTHORITY__Group__1__Impl rule__AUTHORITY__Group__2 ;
    public final void rule__AUTHORITY__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3095:1: ( rule__AUTHORITY__Group__1__Impl rule__AUTHORITY__Group__2 )
            // InternalDOcl.g:3096:2: rule__AUTHORITY__Group__1__Impl rule__AUTHORITY__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__AUTHORITY__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AUTHORITY__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group__1"


    // $ANTLR start "rule__AUTHORITY__Group__1__Impl"
    // InternalDOcl.g:3103:1: rule__AUTHORITY__Group__1__Impl : ( ( rule__AUTHORITY__Group_1__0 )* ) ;
    public final void rule__AUTHORITY__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3107:1: ( ( ( rule__AUTHORITY__Group_1__0 )* ) )
            // InternalDOcl.g:3108:1: ( ( rule__AUTHORITY__Group_1__0 )* )
            {
            // InternalDOcl.g:3108:1: ( ( rule__AUTHORITY__Group_1__0 )* )
            // InternalDOcl.g:3109:2: ( rule__AUTHORITY__Group_1__0 )*
            {
             before(grammarAccess.getAUTHORITYAccess().getGroup_1()); 
            // InternalDOcl.g:3110:2: ( rule__AUTHORITY__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==19) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalDOcl.g:3110:3: rule__AUTHORITY__Group_1__0
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__AUTHORITY__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getAUTHORITYAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group__1__Impl"


    // $ANTLR start "rule__AUTHORITY__Group__2"
    // InternalDOcl.g:3118:1: rule__AUTHORITY__Group__2 : rule__AUTHORITY__Group__2__Impl ;
    public final void rule__AUTHORITY__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3122:1: ( rule__AUTHORITY__Group__2__Impl )
            // InternalDOcl.g:3123:2: rule__AUTHORITY__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AUTHORITY__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group__2"


    // $ANTLR start "rule__AUTHORITY__Group__2__Impl"
    // InternalDOcl.g:3129:1: rule__AUTHORITY__Group__2__Impl : ( ( rule__AUTHORITY__Group_2__0 )? ) ;
    public final void rule__AUTHORITY__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3133:1: ( ( ( rule__AUTHORITY__Group_2__0 )? ) )
            // InternalDOcl.g:3134:1: ( ( rule__AUTHORITY__Group_2__0 )? )
            {
            // InternalDOcl.g:3134:1: ( ( rule__AUTHORITY__Group_2__0 )? )
            // InternalDOcl.g:3135:2: ( rule__AUTHORITY__Group_2__0 )?
            {
             before(grammarAccess.getAUTHORITYAccess().getGroup_2()); 
            // InternalDOcl.g:3136:2: ( rule__AUTHORITY__Group_2__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==67) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalDOcl.g:3136:3: rule__AUTHORITY__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AUTHORITY__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAUTHORITYAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group__2__Impl"


    // $ANTLR start "rule__AUTHORITY__Group_1__0"
    // InternalDOcl.g:3145:1: rule__AUTHORITY__Group_1__0 : rule__AUTHORITY__Group_1__0__Impl rule__AUTHORITY__Group_1__1 ;
    public final void rule__AUTHORITY__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3149:1: ( rule__AUTHORITY__Group_1__0__Impl rule__AUTHORITY__Group_1__1 )
            // InternalDOcl.g:3150:2: rule__AUTHORITY__Group_1__0__Impl rule__AUTHORITY__Group_1__1
            {
            pushFollow(FOLLOW_5);
            rule__AUTHORITY__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AUTHORITY__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group_1__0"


    // $ANTLR start "rule__AUTHORITY__Group_1__0__Impl"
    // InternalDOcl.g:3157:1: rule__AUTHORITY__Group_1__0__Impl : ( '.' ) ;
    public final void rule__AUTHORITY__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3161:1: ( ( '.' ) )
            // InternalDOcl.g:3162:1: ( '.' )
            {
            // InternalDOcl.g:3162:1: ( '.' )
            // InternalDOcl.g:3163:2: '.'
            {
             before(grammarAccess.getAUTHORITYAccess().getFullStopKeyword_1_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getAUTHORITYAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group_1__0__Impl"


    // $ANTLR start "rule__AUTHORITY__Group_1__1"
    // InternalDOcl.g:3172:1: rule__AUTHORITY__Group_1__1 : rule__AUTHORITY__Group_1__1__Impl ;
    public final void rule__AUTHORITY__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3176:1: ( rule__AUTHORITY__Group_1__1__Impl )
            // InternalDOcl.g:3177:2: rule__AUTHORITY__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AUTHORITY__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group_1__1"


    // $ANTLR start "rule__AUTHORITY__Group_1__1__Impl"
    // InternalDOcl.g:3183:1: rule__AUTHORITY__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__AUTHORITY__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3187:1: ( ( RULE_ID ) )
            // InternalDOcl.g:3188:1: ( RULE_ID )
            {
            // InternalDOcl.g:3188:1: ( RULE_ID )
            // InternalDOcl.g:3189:2: RULE_ID
            {
             before(grammarAccess.getAUTHORITYAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAUTHORITYAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group_1__1__Impl"


    // $ANTLR start "rule__AUTHORITY__Group_2__0"
    // InternalDOcl.g:3199:1: rule__AUTHORITY__Group_2__0 : rule__AUTHORITY__Group_2__0__Impl rule__AUTHORITY__Group_2__1 ;
    public final void rule__AUTHORITY__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3203:1: ( rule__AUTHORITY__Group_2__0__Impl rule__AUTHORITY__Group_2__1 )
            // InternalDOcl.g:3204:2: rule__AUTHORITY__Group_2__0__Impl rule__AUTHORITY__Group_2__1
            {
            pushFollow(FOLLOW_20);
            rule__AUTHORITY__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AUTHORITY__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group_2__0"


    // $ANTLR start "rule__AUTHORITY__Group_2__0__Impl"
    // InternalDOcl.g:3211:1: rule__AUTHORITY__Group_2__0__Impl : ( ':' ) ;
    public final void rule__AUTHORITY__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3215:1: ( ( ':' ) )
            // InternalDOcl.g:3216:1: ( ':' )
            {
            // InternalDOcl.g:3216:1: ( ':' )
            // InternalDOcl.g:3217:2: ':'
            {
             before(grammarAccess.getAUTHORITYAccess().getColonKeyword_2_0()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getAUTHORITYAccess().getColonKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group_2__0__Impl"


    // $ANTLR start "rule__AUTHORITY__Group_2__1"
    // InternalDOcl.g:3226:1: rule__AUTHORITY__Group_2__1 : rule__AUTHORITY__Group_2__1__Impl ;
    public final void rule__AUTHORITY__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3230:1: ( rule__AUTHORITY__Group_2__1__Impl )
            // InternalDOcl.g:3231:2: rule__AUTHORITY__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AUTHORITY__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group_2__1"


    // $ANTLR start "rule__AUTHORITY__Group_2__1__Impl"
    // InternalDOcl.g:3237:1: rule__AUTHORITY__Group_2__1__Impl : ( RULE_INT ) ;
    public final void rule__AUTHORITY__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3241:1: ( ( RULE_INT ) )
            // InternalDOcl.g:3242:1: ( RULE_INT )
            {
            // InternalDOcl.g:3242:1: ( RULE_INT )
            // InternalDOcl.g:3243:2: RULE_INT
            {
             before(grammarAccess.getAUTHORITYAccess().getINTTerminalRuleCall_2_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getAUTHORITYAccess().getINTTerminalRuleCall_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AUTHORITY__Group_2__1__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // InternalDOcl.g:3253:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3257:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // InternalDOcl.g:3258:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // InternalDOcl.g:3265:1: rule__Import__Group__0__Impl : ( () ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3269:1: ( ( () ) )
            // InternalDOcl.g:3270:1: ( () )
            {
            // InternalDOcl.g:3270:1: ( () )
            // InternalDOcl.g:3271:2: ()
            {
             before(grammarAccess.getImportAccess().getImportAction_0()); 
            // InternalDOcl.g:3272:2: ()
            // InternalDOcl.g:3272:3: 
            {
            }

             after(grammarAccess.getImportAccess().getImportAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // InternalDOcl.g:3280:1: rule__Import__Group__1 : rule__Import__Group__1__Impl rule__Import__Group__2 ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3284:1: ( rule__Import__Group__1__Impl rule__Import__Group__2 )
            // InternalDOcl.g:3285:2: rule__Import__Group__1__Impl rule__Import__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Import__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Import__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // InternalDOcl.g:3292:1: rule__Import__Group__1__Impl : ( 'imports' ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3296:1: ( ( 'imports' ) )
            // InternalDOcl.g:3297:1: ( 'imports' )
            {
            // InternalDOcl.g:3297:1: ( 'imports' )
            // InternalDOcl.g:3298:2: 'imports'
            {
             before(grammarAccess.getImportAccess().getImportsKeyword_1()); 
            match(input,68,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getImportsKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__Import__Group__2"
    // InternalDOcl.g:3307:1: rule__Import__Group__2 : rule__Import__Group__2__Impl ;
    public final void rule__Import__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3311:1: ( rule__Import__Group__2__Impl )
            // InternalDOcl.g:3312:2: rule__Import__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Import__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__2"


    // $ANTLR start "rule__Import__Group__2__Impl"
    // InternalDOcl.g:3318:1: rule__Import__Group__2__Impl : ( ( rule__Import__NameAssignment_2 ) ) ;
    public final void rule__Import__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3322:1: ( ( ( rule__Import__NameAssignment_2 ) ) )
            // InternalDOcl.g:3323:1: ( ( rule__Import__NameAssignment_2 ) )
            {
            // InternalDOcl.g:3323:1: ( ( rule__Import__NameAssignment_2 ) )
            // InternalDOcl.g:3324:2: ( rule__Import__NameAssignment_2 )
            {
             before(grammarAccess.getImportAccess().getNameAssignment_2()); 
            // InternalDOcl.g:3325:2: ( rule__Import__NameAssignment_2 )
            // InternalDOcl.g:3325:3: rule__Import__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Import__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__2__Impl"


    // $ANTLR start "rule__Query__Group__0"
    // InternalDOcl.g:3334:1: rule__Query__Group__0 : rule__Query__Group__0__Impl rule__Query__Group__1 ;
    public final void rule__Query__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3338:1: ( rule__Query__Group__0__Impl rule__Query__Group__1 )
            // InternalDOcl.g:3339:2: rule__Query__Group__0__Impl rule__Query__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__Query__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Query__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__0"


    // $ANTLR start "rule__Query__Group__0__Impl"
    // InternalDOcl.g:3346:1: rule__Query__Group__0__Impl : ( () ) ;
    public final void rule__Query__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3350:1: ( ( () ) )
            // InternalDOcl.g:3351:1: ( () )
            {
            // InternalDOcl.g:3351:1: ( () )
            // InternalDOcl.g:3352:2: ()
            {
             before(grammarAccess.getQueryAccess().getQueryAction_0()); 
            // InternalDOcl.g:3353:2: ()
            // InternalDOcl.g:3353:3: 
            {
            }

             after(grammarAccess.getQueryAccess().getQueryAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__0__Impl"


    // $ANTLR start "rule__Query__Group__1"
    // InternalDOcl.g:3361:1: rule__Query__Group__1 : rule__Query__Group__1__Impl rule__Query__Group__2 ;
    public final void rule__Query__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3365:1: ( rule__Query__Group__1__Impl rule__Query__Group__2 )
            // InternalDOcl.g:3366:2: rule__Query__Group__1__Impl rule__Query__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Query__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Query__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__1"


    // $ANTLR start "rule__Query__Group__1__Impl"
    // InternalDOcl.g:3373:1: rule__Query__Group__1__Impl : ( 'query' ) ;
    public final void rule__Query__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3377:1: ( ( 'query' ) )
            // InternalDOcl.g:3378:1: ( 'query' )
            {
            // InternalDOcl.g:3378:1: ( 'query' )
            // InternalDOcl.g:3379:2: 'query'
            {
             before(grammarAccess.getQueryAccess().getQueryKeyword_1()); 
            match(input,69,FOLLOW_2); 
             after(grammarAccess.getQueryAccess().getQueryKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__1__Impl"


    // $ANTLR start "rule__Query__Group__2"
    // InternalDOcl.g:3388:1: rule__Query__Group__2 : rule__Query__Group__2__Impl rule__Query__Group__3 ;
    public final void rule__Query__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3392:1: ( rule__Query__Group__2__Impl rule__Query__Group__3 )
            // InternalDOcl.g:3393:2: rule__Query__Group__2__Impl rule__Query__Group__3
            {
            pushFollow(FOLLOW_21);
            rule__Query__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Query__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__2"


    // $ANTLR start "rule__Query__Group__2__Impl"
    // InternalDOcl.g:3400:1: rule__Query__Group__2__Impl : ( ( rule__Query__NameAssignment_2 ) ) ;
    public final void rule__Query__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3404:1: ( ( ( rule__Query__NameAssignment_2 ) ) )
            // InternalDOcl.g:3405:1: ( ( rule__Query__NameAssignment_2 ) )
            {
            // InternalDOcl.g:3405:1: ( ( rule__Query__NameAssignment_2 ) )
            // InternalDOcl.g:3406:2: ( rule__Query__NameAssignment_2 )
            {
             before(grammarAccess.getQueryAccess().getNameAssignment_2()); 
            // InternalDOcl.g:3407:2: ( rule__Query__NameAssignment_2 )
            // InternalDOcl.g:3407:3: rule__Query__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Query__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getQueryAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__2__Impl"


    // $ANTLR start "rule__Query__Group__3"
    // InternalDOcl.g:3415:1: rule__Query__Group__3 : rule__Query__Group__3__Impl rule__Query__Group__4 ;
    public final void rule__Query__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3419:1: ( rule__Query__Group__3__Impl rule__Query__Group__4 )
            // InternalDOcl.g:3420:2: rule__Query__Group__3__Impl rule__Query__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__Query__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Query__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__3"


    // $ANTLR start "rule__Query__Group__3__Impl"
    // InternalDOcl.g:3427:1: rule__Query__Group__3__Impl : ( ':' ) ;
    public final void rule__Query__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3431:1: ( ( ':' ) )
            // InternalDOcl.g:3432:1: ( ':' )
            {
            // InternalDOcl.g:3432:1: ( ':' )
            // InternalDOcl.g:3433:2: ':'
            {
             before(grammarAccess.getQueryAccess().getColonKeyword_3()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getQueryAccess().getColonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__3__Impl"


    // $ANTLR start "rule__Query__Group__4"
    // InternalDOcl.g:3442:1: rule__Query__Group__4 : rule__Query__Group__4__Impl rule__Query__Group__5 ;
    public final void rule__Query__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3446:1: ( rule__Query__Group__4__Impl rule__Query__Group__5 )
            // InternalDOcl.g:3447:2: rule__Query__Group__4__Impl rule__Query__Group__5
            {
            pushFollow(FOLLOW_23);
            rule__Query__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Query__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__4"


    // $ANTLR start "rule__Query__Group__4__Impl"
    // InternalDOcl.g:3454:1: rule__Query__Group__4__Impl : ( ( rule__Query__BodyAssignment_4 ) ) ;
    public final void rule__Query__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3458:1: ( ( ( rule__Query__BodyAssignment_4 ) ) )
            // InternalDOcl.g:3459:1: ( ( rule__Query__BodyAssignment_4 ) )
            {
            // InternalDOcl.g:3459:1: ( ( rule__Query__BodyAssignment_4 ) )
            // InternalDOcl.g:3460:2: ( rule__Query__BodyAssignment_4 )
            {
             before(grammarAccess.getQueryAccess().getBodyAssignment_4()); 
            // InternalDOcl.g:3461:2: ( rule__Query__BodyAssignment_4 )
            // InternalDOcl.g:3461:3: rule__Query__BodyAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Query__BodyAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getQueryAccess().getBodyAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__4__Impl"


    // $ANTLR start "rule__Query__Group__5"
    // InternalDOcl.g:3469:1: rule__Query__Group__5 : rule__Query__Group__5__Impl ;
    public final void rule__Query__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3473:1: ( rule__Query__Group__5__Impl )
            // InternalDOcl.g:3474:2: rule__Query__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Query__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__5"


    // $ANTLR start "rule__Query__Group__5__Impl"
    // InternalDOcl.g:3480:1: rule__Query__Group__5__Impl : ( ';' ) ;
    public final void rule__Query__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3484:1: ( ( ';' ) )
            // InternalDOcl.g:3485:1: ( ';' )
            {
            // InternalDOcl.g:3485:1: ( ';' )
            // InternalDOcl.g:3486:2: ';'
            {
             before(grammarAccess.getQueryAccess().getSemicolonKeyword_5()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getQueryAccess().getSemicolonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__Group__5__Impl"


    // $ANTLR start "rule__LetExp__Group__0"
    // InternalDOcl.g:3496:1: rule__LetExp__Group__0 : rule__LetExp__Group__0__Impl rule__LetExp__Group__1 ;
    public final void rule__LetExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3500:1: ( rule__LetExp__Group__0__Impl rule__LetExp__Group__1 )
            // InternalDOcl.g:3501:2: rule__LetExp__Group__0__Impl rule__LetExp__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__LetExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LetExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LetExp__Group__0"


    // $ANTLR start "rule__LetExp__Group__0__Impl"
    // InternalDOcl.g:3508:1: rule__LetExp__Group__0__Impl : ( ( rule__LetExp__NameAssignment_0 ) ) ;
    public final void rule__LetExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3512:1: ( ( ( rule__LetExp__NameAssignment_0 ) ) )
            // InternalDOcl.g:3513:1: ( ( rule__LetExp__NameAssignment_0 ) )
            {
            // InternalDOcl.g:3513:1: ( ( rule__LetExp__NameAssignment_0 ) )
            // InternalDOcl.g:3514:2: ( rule__LetExp__NameAssignment_0 )
            {
             before(grammarAccess.getLetExpAccess().getNameAssignment_0()); 
            // InternalDOcl.g:3515:2: ( rule__LetExp__NameAssignment_0 )
            // InternalDOcl.g:3515:3: rule__LetExp__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__LetExp__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLetExpAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LetExp__Group__0__Impl"


    // $ANTLR start "rule__LetExp__Group__1"
    // InternalDOcl.g:3523:1: rule__LetExp__Group__1 : rule__LetExp__Group__1__Impl rule__LetExp__Group__2 ;
    public final void rule__LetExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3527:1: ( rule__LetExp__Group__1__Impl rule__LetExp__Group__2 )
            // InternalDOcl.g:3528:2: rule__LetExp__Group__1__Impl rule__LetExp__Group__2
            {
            pushFollow(FOLLOW_24);
            rule__LetExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LetExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LetExp__Group__1"


    // $ANTLR start "rule__LetExp__Group__1__Impl"
    // InternalDOcl.g:3535:1: rule__LetExp__Group__1__Impl : ( ( rule__LetExp__VariableAssignment_1 ) ) ;
    public final void rule__LetExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3539:1: ( ( ( rule__LetExp__VariableAssignment_1 ) ) )
            // InternalDOcl.g:3540:1: ( ( rule__LetExp__VariableAssignment_1 ) )
            {
            // InternalDOcl.g:3540:1: ( ( rule__LetExp__VariableAssignment_1 ) )
            // InternalDOcl.g:3541:2: ( rule__LetExp__VariableAssignment_1 )
            {
             before(grammarAccess.getLetExpAccess().getVariableAssignment_1()); 
            // InternalDOcl.g:3542:2: ( rule__LetExp__VariableAssignment_1 )
            // InternalDOcl.g:3542:3: rule__LetExp__VariableAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__LetExp__VariableAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLetExpAccess().getVariableAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LetExp__Group__1__Impl"


    // $ANTLR start "rule__LetExp__Group__2"
    // InternalDOcl.g:3550:1: rule__LetExp__Group__2 : rule__LetExp__Group__2__Impl rule__LetExp__Group__3 ;
    public final void rule__LetExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3554:1: ( rule__LetExp__Group__2__Impl rule__LetExp__Group__3 )
            // InternalDOcl.g:3555:2: rule__LetExp__Group__2__Impl rule__LetExp__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__LetExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LetExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LetExp__Group__2"


    // $ANTLR start "rule__LetExp__Group__2__Impl"
    // InternalDOcl.g:3562:1: rule__LetExp__Group__2__Impl : ( 'in' ) ;
    public final void rule__LetExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3566:1: ( ( 'in' ) )
            // InternalDOcl.g:3567:1: ( 'in' )
            {
            // InternalDOcl.g:3567:1: ( 'in' )
            // InternalDOcl.g:3568:2: 'in'
            {
             before(grammarAccess.getLetExpAccess().getInKeyword_2()); 
            match(input,71,FOLLOW_2); 
             after(grammarAccess.getLetExpAccess().getInKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LetExp__Group__2__Impl"


    // $ANTLR start "rule__LetExp__Group__3"
    // InternalDOcl.g:3577:1: rule__LetExp__Group__3 : rule__LetExp__Group__3__Impl ;
    public final void rule__LetExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3581:1: ( rule__LetExp__Group__3__Impl )
            // InternalDOcl.g:3582:2: rule__LetExp__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LetExp__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LetExp__Group__3"


    // $ANTLR start "rule__LetExp__Group__3__Impl"
    // InternalDOcl.g:3588:1: rule__LetExp__Group__3__Impl : ( ( rule__LetExp__InAssignment_3 ) ) ;
    public final void rule__LetExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3592:1: ( ( ( rule__LetExp__InAssignment_3 ) ) )
            // InternalDOcl.g:3593:1: ( ( rule__LetExp__InAssignment_3 ) )
            {
            // InternalDOcl.g:3593:1: ( ( rule__LetExp__InAssignment_3 ) )
            // InternalDOcl.g:3594:2: ( rule__LetExp__InAssignment_3 )
            {
             before(grammarAccess.getLetExpAccess().getInAssignment_3()); 
            // InternalDOcl.g:3595:2: ( rule__LetExp__InAssignment_3 )
            // InternalDOcl.g:3595:3: rule__LetExp__InAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__LetExp__InAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getLetExpAccess().getInAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LetExp__Group__3__Impl"


    // $ANTLR start "rule__UnaryOpExp__Group__0"
    // InternalDOcl.g:3604:1: rule__UnaryOpExp__Group__0 : rule__UnaryOpExp__Group__0__Impl rule__UnaryOpExp__Group__1 ;
    public final void rule__UnaryOpExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3608:1: ( rule__UnaryOpExp__Group__0__Impl rule__UnaryOpExp__Group__1 )
            // InternalDOcl.g:3609:2: rule__UnaryOpExp__Group__0__Impl rule__UnaryOpExp__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__UnaryOpExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnaryOpExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOpExp__Group__0"


    // $ANTLR start "rule__UnaryOpExp__Group__0__Impl"
    // InternalDOcl.g:3616:1: rule__UnaryOpExp__Group__0__Impl : ( ( rule__UnaryOpExp__NameAssignment_0 ) ) ;
    public final void rule__UnaryOpExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3620:1: ( ( ( rule__UnaryOpExp__NameAssignment_0 ) ) )
            // InternalDOcl.g:3621:1: ( ( rule__UnaryOpExp__NameAssignment_0 ) )
            {
            // InternalDOcl.g:3621:1: ( ( rule__UnaryOpExp__NameAssignment_0 ) )
            // InternalDOcl.g:3622:2: ( rule__UnaryOpExp__NameAssignment_0 )
            {
             before(grammarAccess.getUnaryOpExpAccess().getNameAssignment_0()); 
            // InternalDOcl.g:3623:2: ( rule__UnaryOpExp__NameAssignment_0 )
            // InternalDOcl.g:3623:3: rule__UnaryOpExp__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOpExp__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getUnaryOpExpAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOpExp__Group__0__Impl"


    // $ANTLR start "rule__UnaryOpExp__Group__1"
    // InternalDOcl.g:3631:1: rule__UnaryOpExp__Group__1 : rule__UnaryOpExp__Group__1__Impl ;
    public final void rule__UnaryOpExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3635:1: ( rule__UnaryOpExp__Group__1__Impl )
            // InternalDOcl.g:3636:2: rule__UnaryOpExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOpExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOpExp__Group__1"


    // $ANTLR start "rule__UnaryOpExp__Group__1__Impl"
    // InternalDOcl.g:3642:1: rule__UnaryOpExp__Group__1__Impl : ( ( rule__UnaryOpExp__TargetAssignment_1 ) ) ;
    public final void rule__UnaryOpExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3646:1: ( ( ( rule__UnaryOpExp__TargetAssignment_1 ) ) )
            // InternalDOcl.g:3647:1: ( ( rule__UnaryOpExp__TargetAssignment_1 ) )
            {
            // InternalDOcl.g:3647:1: ( ( rule__UnaryOpExp__TargetAssignment_1 ) )
            // InternalDOcl.g:3648:2: ( rule__UnaryOpExp__TargetAssignment_1 )
            {
             before(grammarAccess.getUnaryOpExpAccess().getTargetAssignment_1()); 
            // InternalDOcl.g:3649:2: ( rule__UnaryOpExp__TargetAssignment_1 )
            // InternalDOcl.g:3649:3: rule__UnaryOpExp__TargetAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__UnaryOpExp__TargetAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getUnaryOpExpAccess().getTargetAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOpExp__Group__1__Impl"


    // $ANTLR start "rule__ImpliesOpExp__Group__0"
    // InternalDOcl.g:3658:1: rule__ImpliesOpExp__Group__0 : rule__ImpliesOpExp__Group__0__Impl rule__ImpliesOpExp__Group__1 ;
    public final void rule__ImpliesOpExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3662:1: ( rule__ImpliesOpExp__Group__0__Impl rule__ImpliesOpExp__Group__1 )
            // InternalDOcl.g:3663:2: rule__ImpliesOpExp__Group__0__Impl rule__ImpliesOpExp__Group__1
            {
            pushFollow(FOLLOW_25);
            rule__ImpliesOpExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImpliesOpExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImpliesOpExp__Group__0"


    // $ANTLR start "rule__ImpliesOpExp__Group__0__Impl"
    // InternalDOcl.g:3670:1: rule__ImpliesOpExp__Group__0__Impl : ( ruleXorOpExp ) ;
    public final void rule__ImpliesOpExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3674:1: ( ( ruleXorOpExp ) )
            // InternalDOcl.g:3675:1: ( ruleXorOpExp )
            {
            // InternalDOcl.g:3675:1: ( ruleXorOpExp )
            // InternalDOcl.g:3676:2: ruleXorOpExp
            {
             before(grammarAccess.getImpliesOpExpAccess().getXorOpExpParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleXorOpExp();

            state._fsp--;

             after(grammarAccess.getImpliesOpExpAccess().getXorOpExpParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImpliesOpExp__Group__0__Impl"


    // $ANTLR start "rule__ImpliesOpExp__Group__1"
    // InternalDOcl.g:3685:1: rule__ImpliesOpExp__Group__1 : rule__ImpliesOpExp__Group__1__Impl ;
    public final void rule__ImpliesOpExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3689:1: ( rule__ImpliesOpExp__Group__1__Impl )
            // InternalDOcl.g:3690:2: rule__ImpliesOpExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImpliesOpExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImpliesOpExp__Group__1"


    // $ANTLR start "rule__ImpliesOpExp__Group__1__Impl"
    // InternalDOcl.g:3696:1: rule__ImpliesOpExp__Group__1__Impl : ( ( rule__ImpliesOpExp__Group_1__0 )* ) ;
    public final void rule__ImpliesOpExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3700:1: ( ( ( rule__ImpliesOpExp__Group_1__0 )* ) )
            // InternalDOcl.g:3701:1: ( ( rule__ImpliesOpExp__Group_1__0 )* )
            {
            // InternalDOcl.g:3701:1: ( ( rule__ImpliesOpExp__Group_1__0 )* )
            // InternalDOcl.g:3702:2: ( rule__ImpliesOpExp__Group_1__0 )*
            {
             before(grammarAccess.getImpliesOpExpAccess().getGroup_1()); 
            // InternalDOcl.g:3703:2: ( rule__ImpliesOpExp__Group_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==15) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalDOcl.g:3703:3: rule__ImpliesOpExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_26);
            	    rule__ImpliesOpExp__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getImpliesOpExpAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImpliesOpExp__Group__1__Impl"


    // $ANTLR start "rule__ImpliesOpExp__Group_1__0"
    // InternalDOcl.g:3712:1: rule__ImpliesOpExp__Group_1__0 : rule__ImpliesOpExp__Group_1__0__Impl rule__ImpliesOpExp__Group_1__1 ;
    public final void rule__ImpliesOpExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3716:1: ( rule__ImpliesOpExp__Group_1__0__Impl rule__ImpliesOpExp__Group_1__1 )
            // InternalDOcl.g:3717:2: rule__ImpliesOpExp__Group_1__0__Impl rule__ImpliesOpExp__Group_1__1
            {
            pushFollow(FOLLOW_25);
            rule__ImpliesOpExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImpliesOpExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImpliesOpExp__Group_1__0"


    // $ANTLR start "rule__ImpliesOpExp__Group_1__0__Impl"
    // InternalDOcl.g:3724:1: rule__ImpliesOpExp__Group_1__0__Impl : ( () ) ;
    public final void rule__ImpliesOpExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3728:1: ( ( () ) )
            // InternalDOcl.g:3729:1: ( () )
            {
            // InternalDOcl.g:3729:1: ( () )
            // InternalDOcl.g:3730:2: ()
            {
             before(grammarAccess.getImpliesOpExpAccess().getBoolOpCallExpSourceAction_1_0()); 
            // InternalDOcl.g:3731:2: ()
            // InternalDOcl.g:3731:3: 
            {
            }

             after(grammarAccess.getImpliesOpExpAccess().getBoolOpCallExpSourceAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImpliesOpExp__Group_1__0__Impl"


    // $ANTLR start "rule__ImpliesOpExp__Group_1__1"
    // InternalDOcl.g:3739:1: rule__ImpliesOpExp__Group_1__1 : rule__ImpliesOpExp__Group_1__1__Impl rule__ImpliesOpExp__Group_1__2 ;
    public final void rule__ImpliesOpExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3743:1: ( rule__ImpliesOpExp__Group_1__1__Impl rule__ImpliesOpExp__Group_1__2 )
            // InternalDOcl.g:3744:2: rule__ImpliesOpExp__Group_1__1__Impl rule__ImpliesOpExp__Group_1__2
            {
            pushFollow(FOLLOW_27);
            rule__ImpliesOpExp__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ImpliesOpExp__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImpliesOpExp__Group_1__1"


    // $ANTLR start "rule__ImpliesOpExp__Group_1__1__Impl"
    // InternalDOcl.g:3751:1: rule__ImpliesOpExp__Group_1__1__Impl : ( ( rule__ImpliesOpExp__NameAssignment_1_1 ) ) ;
    public final void rule__ImpliesOpExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3755:1: ( ( ( rule__ImpliesOpExp__NameAssignment_1_1 ) ) )
            // InternalDOcl.g:3756:1: ( ( rule__ImpliesOpExp__NameAssignment_1_1 ) )
            {
            // InternalDOcl.g:3756:1: ( ( rule__ImpliesOpExp__NameAssignment_1_1 ) )
            // InternalDOcl.g:3757:2: ( rule__ImpliesOpExp__NameAssignment_1_1 )
            {
             before(grammarAccess.getImpliesOpExpAccess().getNameAssignment_1_1()); 
            // InternalDOcl.g:3758:2: ( rule__ImpliesOpExp__NameAssignment_1_1 )
            // InternalDOcl.g:3758:3: rule__ImpliesOpExp__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ImpliesOpExp__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getImpliesOpExpAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImpliesOpExp__Group_1__1__Impl"


    // $ANTLR start "rule__ImpliesOpExp__Group_1__2"
    // InternalDOcl.g:3766:1: rule__ImpliesOpExp__Group_1__2 : rule__ImpliesOpExp__Group_1__2__Impl ;
    public final void rule__ImpliesOpExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3770:1: ( rule__ImpliesOpExp__Group_1__2__Impl )
            // InternalDOcl.g:3771:2: rule__ImpliesOpExp__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ImpliesOpExp__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImpliesOpExp__Group_1__2"


    // $ANTLR start "rule__ImpliesOpExp__Group_1__2__Impl"
    // InternalDOcl.g:3777:1: rule__ImpliesOpExp__Group_1__2__Impl : ( ( rule__ImpliesOpExp__TargetAssignment_1_2 ) ) ;
    public final void rule__ImpliesOpExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3781:1: ( ( ( rule__ImpliesOpExp__TargetAssignment_1_2 ) ) )
            // InternalDOcl.g:3782:1: ( ( rule__ImpliesOpExp__TargetAssignment_1_2 ) )
            {
            // InternalDOcl.g:3782:1: ( ( rule__ImpliesOpExp__TargetAssignment_1_2 ) )
            // InternalDOcl.g:3783:2: ( rule__ImpliesOpExp__TargetAssignment_1_2 )
            {
             before(grammarAccess.getImpliesOpExpAccess().getTargetAssignment_1_2()); 
            // InternalDOcl.g:3784:2: ( rule__ImpliesOpExp__TargetAssignment_1_2 )
            // InternalDOcl.g:3784:3: rule__ImpliesOpExp__TargetAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__ImpliesOpExp__TargetAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getImpliesOpExpAccess().getTargetAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImpliesOpExp__Group_1__2__Impl"


    // $ANTLR start "rule__XorOpExp__Group__0"
    // InternalDOcl.g:3793:1: rule__XorOpExp__Group__0 : rule__XorOpExp__Group__0__Impl rule__XorOpExp__Group__1 ;
    public final void rule__XorOpExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3797:1: ( rule__XorOpExp__Group__0__Impl rule__XorOpExp__Group__1 )
            // InternalDOcl.g:3798:2: rule__XorOpExp__Group__0__Impl rule__XorOpExp__Group__1
            {
            pushFollow(FOLLOW_28);
            rule__XorOpExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XorOpExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorOpExp__Group__0"


    // $ANTLR start "rule__XorOpExp__Group__0__Impl"
    // InternalDOcl.g:3805:1: rule__XorOpExp__Group__0__Impl : ( ruleOrOpExp ) ;
    public final void rule__XorOpExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3809:1: ( ( ruleOrOpExp ) )
            // InternalDOcl.g:3810:1: ( ruleOrOpExp )
            {
            // InternalDOcl.g:3810:1: ( ruleOrOpExp )
            // InternalDOcl.g:3811:2: ruleOrOpExp
            {
             before(grammarAccess.getXorOpExpAccess().getOrOpExpParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleOrOpExp();

            state._fsp--;

             after(grammarAccess.getXorOpExpAccess().getOrOpExpParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorOpExp__Group__0__Impl"


    // $ANTLR start "rule__XorOpExp__Group__1"
    // InternalDOcl.g:3820:1: rule__XorOpExp__Group__1 : rule__XorOpExp__Group__1__Impl ;
    public final void rule__XorOpExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3824:1: ( rule__XorOpExp__Group__1__Impl )
            // InternalDOcl.g:3825:2: rule__XorOpExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XorOpExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorOpExp__Group__1"


    // $ANTLR start "rule__XorOpExp__Group__1__Impl"
    // InternalDOcl.g:3831:1: rule__XorOpExp__Group__1__Impl : ( ( rule__XorOpExp__Group_1__0 )* ) ;
    public final void rule__XorOpExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3835:1: ( ( ( rule__XorOpExp__Group_1__0 )* ) )
            // InternalDOcl.g:3836:1: ( ( rule__XorOpExp__Group_1__0 )* )
            {
            // InternalDOcl.g:3836:1: ( ( rule__XorOpExp__Group_1__0 )* )
            // InternalDOcl.g:3837:2: ( rule__XorOpExp__Group_1__0 )*
            {
             before(grammarAccess.getXorOpExpAccess().getGroup_1()); 
            // InternalDOcl.g:3838:2: ( rule__XorOpExp__Group_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==14) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalDOcl.g:3838:3: rule__XorOpExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_29);
            	    rule__XorOpExp__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getXorOpExpAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorOpExp__Group__1__Impl"


    // $ANTLR start "rule__XorOpExp__Group_1__0"
    // InternalDOcl.g:3847:1: rule__XorOpExp__Group_1__0 : rule__XorOpExp__Group_1__0__Impl rule__XorOpExp__Group_1__1 ;
    public final void rule__XorOpExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3851:1: ( rule__XorOpExp__Group_1__0__Impl rule__XorOpExp__Group_1__1 )
            // InternalDOcl.g:3852:2: rule__XorOpExp__Group_1__0__Impl rule__XorOpExp__Group_1__1
            {
            pushFollow(FOLLOW_28);
            rule__XorOpExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XorOpExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorOpExp__Group_1__0"


    // $ANTLR start "rule__XorOpExp__Group_1__0__Impl"
    // InternalDOcl.g:3859:1: rule__XorOpExp__Group_1__0__Impl : ( () ) ;
    public final void rule__XorOpExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3863:1: ( ( () ) )
            // InternalDOcl.g:3864:1: ( () )
            {
            // InternalDOcl.g:3864:1: ( () )
            // InternalDOcl.g:3865:2: ()
            {
             before(grammarAccess.getXorOpExpAccess().getBoolOpCallExpSourceAction_1_0()); 
            // InternalDOcl.g:3866:2: ()
            // InternalDOcl.g:3866:3: 
            {
            }

             after(grammarAccess.getXorOpExpAccess().getBoolOpCallExpSourceAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorOpExp__Group_1__0__Impl"


    // $ANTLR start "rule__XorOpExp__Group_1__1"
    // InternalDOcl.g:3874:1: rule__XorOpExp__Group_1__1 : rule__XorOpExp__Group_1__1__Impl rule__XorOpExp__Group_1__2 ;
    public final void rule__XorOpExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3878:1: ( rule__XorOpExp__Group_1__1__Impl rule__XorOpExp__Group_1__2 )
            // InternalDOcl.g:3879:2: rule__XorOpExp__Group_1__1__Impl rule__XorOpExp__Group_1__2
            {
            pushFollow(FOLLOW_27);
            rule__XorOpExp__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__XorOpExp__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorOpExp__Group_1__1"


    // $ANTLR start "rule__XorOpExp__Group_1__1__Impl"
    // InternalDOcl.g:3886:1: rule__XorOpExp__Group_1__1__Impl : ( ( rule__XorOpExp__NameAssignment_1_1 ) ) ;
    public final void rule__XorOpExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3890:1: ( ( ( rule__XorOpExp__NameAssignment_1_1 ) ) )
            // InternalDOcl.g:3891:1: ( ( rule__XorOpExp__NameAssignment_1_1 ) )
            {
            // InternalDOcl.g:3891:1: ( ( rule__XorOpExp__NameAssignment_1_1 ) )
            // InternalDOcl.g:3892:2: ( rule__XorOpExp__NameAssignment_1_1 )
            {
             before(grammarAccess.getXorOpExpAccess().getNameAssignment_1_1()); 
            // InternalDOcl.g:3893:2: ( rule__XorOpExp__NameAssignment_1_1 )
            // InternalDOcl.g:3893:3: rule__XorOpExp__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__XorOpExp__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getXorOpExpAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorOpExp__Group_1__1__Impl"


    // $ANTLR start "rule__XorOpExp__Group_1__2"
    // InternalDOcl.g:3901:1: rule__XorOpExp__Group_1__2 : rule__XorOpExp__Group_1__2__Impl ;
    public final void rule__XorOpExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3905:1: ( rule__XorOpExp__Group_1__2__Impl )
            // InternalDOcl.g:3906:2: rule__XorOpExp__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__XorOpExp__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorOpExp__Group_1__2"


    // $ANTLR start "rule__XorOpExp__Group_1__2__Impl"
    // InternalDOcl.g:3912:1: rule__XorOpExp__Group_1__2__Impl : ( ( rule__XorOpExp__TargetAssignment_1_2 ) ) ;
    public final void rule__XorOpExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3916:1: ( ( ( rule__XorOpExp__TargetAssignment_1_2 ) ) )
            // InternalDOcl.g:3917:1: ( ( rule__XorOpExp__TargetAssignment_1_2 ) )
            {
            // InternalDOcl.g:3917:1: ( ( rule__XorOpExp__TargetAssignment_1_2 ) )
            // InternalDOcl.g:3918:2: ( rule__XorOpExp__TargetAssignment_1_2 )
            {
             before(grammarAccess.getXorOpExpAccess().getTargetAssignment_1_2()); 
            // InternalDOcl.g:3919:2: ( rule__XorOpExp__TargetAssignment_1_2 )
            // InternalDOcl.g:3919:3: rule__XorOpExp__TargetAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__XorOpExp__TargetAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getXorOpExpAccess().getTargetAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorOpExp__Group_1__2__Impl"


    // $ANTLR start "rule__OrOpExp__Group__0"
    // InternalDOcl.g:3928:1: rule__OrOpExp__Group__0 : rule__OrOpExp__Group__0__Impl rule__OrOpExp__Group__1 ;
    public final void rule__OrOpExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3932:1: ( rule__OrOpExp__Group__0__Impl rule__OrOpExp__Group__1 )
            // InternalDOcl.g:3933:2: rule__OrOpExp__Group__0__Impl rule__OrOpExp__Group__1
            {
            pushFollow(FOLLOW_30);
            rule__OrOpExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrOpExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrOpExp__Group__0"


    // $ANTLR start "rule__OrOpExp__Group__0__Impl"
    // InternalDOcl.g:3940:1: rule__OrOpExp__Group__0__Impl : ( ruleAndOpExp ) ;
    public final void rule__OrOpExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3944:1: ( ( ruleAndOpExp ) )
            // InternalDOcl.g:3945:1: ( ruleAndOpExp )
            {
            // InternalDOcl.g:3945:1: ( ruleAndOpExp )
            // InternalDOcl.g:3946:2: ruleAndOpExp
            {
             before(grammarAccess.getOrOpExpAccess().getAndOpExpParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAndOpExp();

            state._fsp--;

             after(grammarAccess.getOrOpExpAccess().getAndOpExpParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrOpExp__Group__0__Impl"


    // $ANTLR start "rule__OrOpExp__Group__1"
    // InternalDOcl.g:3955:1: rule__OrOpExp__Group__1 : rule__OrOpExp__Group__1__Impl ;
    public final void rule__OrOpExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3959:1: ( rule__OrOpExp__Group__1__Impl )
            // InternalDOcl.g:3960:2: rule__OrOpExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrOpExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrOpExp__Group__1"


    // $ANTLR start "rule__OrOpExp__Group__1__Impl"
    // InternalDOcl.g:3966:1: rule__OrOpExp__Group__1__Impl : ( ( rule__OrOpExp__Group_1__0 )* ) ;
    public final void rule__OrOpExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3970:1: ( ( ( rule__OrOpExp__Group_1__0 )* ) )
            // InternalDOcl.g:3971:1: ( ( rule__OrOpExp__Group_1__0 )* )
            {
            // InternalDOcl.g:3971:1: ( ( rule__OrOpExp__Group_1__0 )* )
            // InternalDOcl.g:3972:2: ( rule__OrOpExp__Group_1__0 )*
            {
             before(grammarAccess.getOrOpExpAccess().getGroup_1()); 
            // InternalDOcl.g:3973:2: ( rule__OrOpExp__Group_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==13) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalDOcl.g:3973:3: rule__OrOpExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_31);
            	    rule__OrOpExp__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getOrOpExpAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrOpExp__Group__1__Impl"


    // $ANTLR start "rule__OrOpExp__Group_1__0"
    // InternalDOcl.g:3982:1: rule__OrOpExp__Group_1__0 : rule__OrOpExp__Group_1__0__Impl rule__OrOpExp__Group_1__1 ;
    public final void rule__OrOpExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3986:1: ( rule__OrOpExp__Group_1__0__Impl rule__OrOpExp__Group_1__1 )
            // InternalDOcl.g:3987:2: rule__OrOpExp__Group_1__0__Impl rule__OrOpExp__Group_1__1
            {
            pushFollow(FOLLOW_30);
            rule__OrOpExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrOpExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrOpExp__Group_1__0"


    // $ANTLR start "rule__OrOpExp__Group_1__0__Impl"
    // InternalDOcl.g:3994:1: rule__OrOpExp__Group_1__0__Impl : ( () ) ;
    public final void rule__OrOpExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:3998:1: ( ( () ) )
            // InternalDOcl.g:3999:1: ( () )
            {
            // InternalDOcl.g:3999:1: ( () )
            // InternalDOcl.g:4000:2: ()
            {
             before(grammarAccess.getOrOpExpAccess().getBoolOpCallExpSourceAction_1_0()); 
            // InternalDOcl.g:4001:2: ()
            // InternalDOcl.g:4001:3: 
            {
            }

             after(grammarAccess.getOrOpExpAccess().getBoolOpCallExpSourceAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrOpExp__Group_1__0__Impl"


    // $ANTLR start "rule__OrOpExp__Group_1__1"
    // InternalDOcl.g:4009:1: rule__OrOpExp__Group_1__1 : rule__OrOpExp__Group_1__1__Impl rule__OrOpExp__Group_1__2 ;
    public final void rule__OrOpExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4013:1: ( rule__OrOpExp__Group_1__1__Impl rule__OrOpExp__Group_1__2 )
            // InternalDOcl.g:4014:2: rule__OrOpExp__Group_1__1__Impl rule__OrOpExp__Group_1__2
            {
            pushFollow(FOLLOW_27);
            rule__OrOpExp__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrOpExp__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrOpExp__Group_1__1"


    // $ANTLR start "rule__OrOpExp__Group_1__1__Impl"
    // InternalDOcl.g:4021:1: rule__OrOpExp__Group_1__1__Impl : ( ( rule__OrOpExp__NameAssignment_1_1 ) ) ;
    public final void rule__OrOpExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4025:1: ( ( ( rule__OrOpExp__NameAssignment_1_1 ) ) )
            // InternalDOcl.g:4026:1: ( ( rule__OrOpExp__NameAssignment_1_1 ) )
            {
            // InternalDOcl.g:4026:1: ( ( rule__OrOpExp__NameAssignment_1_1 ) )
            // InternalDOcl.g:4027:2: ( rule__OrOpExp__NameAssignment_1_1 )
            {
             before(grammarAccess.getOrOpExpAccess().getNameAssignment_1_1()); 
            // InternalDOcl.g:4028:2: ( rule__OrOpExp__NameAssignment_1_1 )
            // InternalDOcl.g:4028:3: rule__OrOpExp__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__OrOpExp__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getOrOpExpAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrOpExp__Group_1__1__Impl"


    // $ANTLR start "rule__OrOpExp__Group_1__2"
    // InternalDOcl.g:4036:1: rule__OrOpExp__Group_1__2 : rule__OrOpExp__Group_1__2__Impl ;
    public final void rule__OrOpExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4040:1: ( rule__OrOpExp__Group_1__2__Impl )
            // InternalDOcl.g:4041:2: rule__OrOpExp__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrOpExp__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrOpExp__Group_1__2"


    // $ANTLR start "rule__OrOpExp__Group_1__2__Impl"
    // InternalDOcl.g:4047:1: rule__OrOpExp__Group_1__2__Impl : ( ( rule__OrOpExp__TargetAssignment_1_2 ) ) ;
    public final void rule__OrOpExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4051:1: ( ( ( rule__OrOpExp__TargetAssignment_1_2 ) ) )
            // InternalDOcl.g:4052:1: ( ( rule__OrOpExp__TargetAssignment_1_2 ) )
            {
            // InternalDOcl.g:4052:1: ( ( rule__OrOpExp__TargetAssignment_1_2 ) )
            // InternalDOcl.g:4053:2: ( rule__OrOpExp__TargetAssignment_1_2 )
            {
             before(grammarAccess.getOrOpExpAccess().getTargetAssignment_1_2()); 
            // InternalDOcl.g:4054:2: ( rule__OrOpExp__TargetAssignment_1_2 )
            // InternalDOcl.g:4054:3: rule__OrOpExp__TargetAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__OrOpExp__TargetAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getOrOpExpAccess().getTargetAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrOpExp__Group_1__2__Impl"


    // $ANTLR start "rule__AndOpExp__Group__0"
    // InternalDOcl.g:4063:1: rule__AndOpExp__Group__0 : rule__AndOpExp__Group__0__Impl rule__AndOpExp__Group__1 ;
    public final void rule__AndOpExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4067:1: ( rule__AndOpExp__Group__0__Impl rule__AndOpExp__Group__1 )
            // InternalDOcl.g:4068:2: rule__AndOpExp__Group__0__Impl rule__AndOpExp__Group__1
            {
            pushFollow(FOLLOW_32);
            rule__AndOpExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndOpExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOpExp__Group__0"


    // $ANTLR start "rule__AndOpExp__Group__0__Impl"
    // InternalDOcl.g:4075:1: rule__AndOpExp__Group__0__Impl : ( ruleEqOpExp ) ;
    public final void rule__AndOpExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4079:1: ( ( ruleEqOpExp ) )
            // InternalDOcl.g:4080:1: ( ruleEqOpExp )
            {
            // InternalDOcl.g:4080:1: ( ruleEqOpExp )
            // InternalDOcl.g:4081:2: ruleEqOpExp
            {
             before(grammarAccess.getAndOpExpAccess().getEqOpExpParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleEqOpExp();

            state._fsp--;

             after(grammarAccess.getAndOpExpAccess().getEqOpExpParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOpExp__Group__0__Impl"


    // $ANTLR start "rule__AndOpExp__Group__1"
    // InternalDOcl.g:4090:1: rule__AndOpExp__Group__1 : rule__AndOpExp__Group__1__Impl ;
    public final void rule__AndOpExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4094:1: ( rule__AndOpExp__Group__1__Impl )
            // InternalDOcl.g:4095:2: rule__AndOpExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndOpExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOpExp__Group__1"


    // $ANTLR start "rule__AndOpExp__Group__1__Impl"
    // InternalDOcl.g:4101:1: rule__AndOpExp__Group__1__Impl : ( ( rule__AndOpExp__Group_1__0 )* ) ;
    public final void rule__AndOpExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4105:1: ( ( ( rule__AndOpExp__Group_1__0 )* ) )
            // InternalDOcl.g:4106:1: ( ( rule__AndOpExp__Group_1__0 )* )
            {
            // InternalDOcl.g:4106:1: ( ( rule__AndOpExp__Group_1__0 )* )
            // InternalDOcl.g:4107:2: ( rule__AndOpExp__Group_1__0 )*
            {
             before(grammarAccess.getAndOpExpAccess().getGroup_1()); 
            // InternalDOcl.g:4108:2: ( rule__AndOpExp__Group_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==12) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalDOcl.g:4108:3: rule__AndOpExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_33);
            	    rule__AndOpExp__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getAndOpExpAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOpExp__Group__1__Impl"


    // $ANTLR start "rule__AndOpExp__Group_1__0"
    // InternalDOcl.g:4117:1: rule__AndOpExp__Group_1__0 : rule__AndOpExp__Group_1__0__Impl rule__AndOpExp__Group_1__1 ;
    public final void rule__AndOpExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4121:1: ( rule__AndOpExp__Group_1__0__Impl rule__AndOpExp__Group_1__1 )
            // InternalDOcl.g:4122:2: rule__AndOpExp__Group_1__0__Impl rule__AndOpExp__Group_1__1
            {
            pushFollow(FOLLOW_32);
            rule__AndOpExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndOpExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOpExp__Group_1__0"


    // $ANTLR start "rule__AndOpExp__Group_1__0__Impl"
    // InternalDOcl.g:4129:1: rule__AndOpExp__Group_1__0__Impl : ( () ) ;
    public final void rule__AndOpExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4133:1: ( ( () ) )
            // InternalDOcl.g:4134:1: ( () )
            {
            // InternalDOcl.g:4134:1: ( () )
            // InternalDOcl.g:4135:2: ()
            {
             before(grammarAccess.getAndOpExpAccess().getBoolOpCallExpSourceAction_1_0()); 
            // InternalDOcl.g:4136:2: ()
            // InternalDOcl.g:4136:3: 
            {
            }

             after(grammarAccess.getAndOpExpAccess().getBoolOpCallExpSourceAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOpExp__Group_1__0__Impl"


    // $ANTLR start "rule__AndOpExp__Group_1__1"
    // InternalDOcl.g:4144:1: rule__AndOpExp__Group_1__1 : rule__AndOpExp__Group_1__1__Impl rule__AndOpExp__Group_1__2 ;
    public final void rule__AndOpExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4148:1: ( rule__AndOpExp__Group_1__1__Impl rule__AndOpExp__Group_1__2 )
            // InternalDOcl.g:4149:2: rule__AndOpExp__Group_1__1__Impl rule__AndOpExp__Group_1__2
            {
            pushFollow(FOLLOW_27);
            rule__AndOpExp__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AndOpExp__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOpExp__Group_1__1"


    // $ANTLR start "rule__AndOpExp__Group_1__1__Impl"
    // InternalDOcl.g:4156:1: rule__AndOpExp__Group_1__1__Impl : ( ( rule__AndOpExp__NameAssignment_1_1 ) ) ;
    public final void rule__AndOpExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4160:1: ( ( ( rule__AndOpExp__NameAssignment_1_1 ) ) )
            // InternalDOcl.g:4161:1: ( ( rule__AndOpExp__NameAssignment_1_1 ) )
            {
            // InternalDOcl.g:4161:1: ( ( rule__AndOpExp__NameAssignment_1_1 ) )
            // InternalDOcl.g:4162:2: ( rule__AndOpExp__NameAssignment_1_1 )
            {
             before(grammarAccess.getAndOpExpAccess().getNameAssignment_1_1()); 
            // InternalDOcl.g:4163:2: ( rule__AndOpExp__NameAssignment_1_1 )
            // InternalDOcl.g:4163:3: rule__AndOpExp__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AndOpExp__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAndOpExpAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOpExp__Group_1__1__Impl"


    // $ANTLR start "rule__AndOpExp__Group_1__2"
    // InternalDOcl.g:4171:1: rule__AndOpExp__Group_1__2 : rule__AndOpExp__Group_1__2__Impl ;
    public final void rule__AndOpExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4175:1: ( rule__AndOpExp__Group_1__2__Impl )
            // InternalDOcl.g:4176:2: rule__AndOpExp__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AndOpExp__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOpExp__Group_1__2"


    // $ANTLR start "rule__AndOpExp__Group_1__2__Impl"
    // InternalDOcl.g:4182:1: rule__AndOpExp__Group_1__2__Impl : ( ( rule__AndOpExp__TargetAssignment_1_2 ) ) ;
    public final void rule__AndOpExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4186:1: ( ( ( rule__AndOpExp__TargetAssignment_1_2 ) ) )
            // InternalDOcl.g:4187:1: ( ( rule__AndOpExp__TargetAssignment_1_2 ) )
            {
            // InternalDOcl.g:4187:1: ( ( rule__AndOpExp__TargetAssignment_1_2 ) )
            // InternalDOcl.g:4188:2: ( rule__AndOpExp__TargetAssignment_1_2 )
            {
             before(grammarAccess.getAndOpExpAccess().getTargetAssignment_1_2()); 
            // InternalDOcl.g:4189:2: ( rule__AndOpExp__TargetAssignment_1_2 )
            // InternalDOcl.g:4189:3: rule__AndOpExp__TargetAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__AndOpExp__TargetAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAndOpExpAccess().getTargetAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOpExp__Group_1__2__Impl"


    // $ANTLR start "rule__EqOpExp__Group__0"
    // InternalDOcl.g:4198:1: rule__EqOpExp__Group__0 : rule__EqOpExp__Group__0__Impl rule__EqOpExp__Group__1 ;
    public final void rule__EqOpExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4202:1: ( rule__EqOpExp__Group__0__Impl rule__EqOpExp__Group__1 )
            // InternalDOcl.g:4203:2: rule__EqOpExp__Group__0__Impl rule__EqOpExp__Group__1
            {
            pushFollow(FOLLOW_34);
            rule__EqOpExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EqOpExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__Group__0"


    // $ANTLR start "rule__EqOpExp__Group__0__Impl"
    // InternalDOcl.g:4210:1: rule__EqOpExp__Group__0__Impl : ( ruleComparisonOpExp ) ;
    public final void rule__EqOpExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4214:1: ( ( ruleComparisonOpExp ) )
            // InternalDOcl.g:4215:1: ( ruleComparisonOpExp )
            {
            // InternalDOcl.g:4215:1: ( ruleComparisonOpExp )
            // InternalDOcl.g:4216:2: ruleComparisonOpExp
            {
             before(grammarAccess.getEqOpExpAccess().getComparisonOpExpParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleComparisonOpExp();

            state._fsp--;

             after(grammarAccess.getEqOpExpAccess().getComparisonOpExpParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__Group__0__Impl"


    // $ANTLR start "rule__EqOpExp__Group__1"
    // InternalDOcl.g:4225:1: rule__EqOpExp__Group__1 : rule__EqOpExp__Group__1__Impl ;
    public final void rule__EqOpExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4229:1: ( rule__EqOpExp__Group__1__Impl )
            // InternalDOcl.g:4230:2: rule__EqOpExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EqOpExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__Group__1"


    // $ANTLR start "rule__EqOpExp__Group__1__Impl"
    // InternalDOcl.g:4236:1: rule__EqOpExp__Group__1__Impl : ( ( rule__EqOpExp__Group_1__0 )* ) ;
    public final void rule__EqOpExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4240:1: ( ( ( rule__EqOpExp__Group_1__0 )* ) )
            // InternalDOcl.g:4241:1: ( ( rule__EqOpExp__Group_1__0 )* )
            {
            // InternalDOcl.g:4241:1: ( ( rule__EqOpExp__Group_1__0 )* )
            // InternalDOcl.g:4242:2: ( rule__EqOpExp__Group_1__0 )*
            {
             before(grammarAccess.getEqOpExpAccess().getGroup_1()); 
            // InternalDOcl.g:4243:2: ( rule__EqOpExp__Group_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=53 && LA28_0<=54)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalDOcl.g:4243:3: rule__EqOpExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_35);
            	    rule__EqOpExp__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getEqOpExpAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__Group__1__Impl"


    // $ANTLR start "rule__EqOpExp__Group_1__0"
    // InternalDOcl.g:4252:1: rule__EqOpExp__Group_1__0 : rule__EqOpExp__Group_1__0__Impl rule__EqOpExp__Group_1__1 ;
    public final void rule__EqOpExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4256:1: ( rule__EqOpExp__Group_1__0__Impl rule__EqOpExp__Group_1__1 )
            // InternalDOcl.g:4257:2: rule__EqOpExp__Group_1__0__Impl rule__EqOpExp__Group_1__1
            {
            pushFollow(FOLLOW_34);
            rule__EqOpExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EqOpExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__Group_1__0"


    // $ANTLR start "rule__EqOpExp__Group_1__0__Impl"
    // InternalDOcl.g:4264:1: rule__EqOpExp__Group_1__0__Impl : ( () ) ;
    public final void rule__EqOpExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4268:1: ( ( () ) )
            // InternalDOcl.g:4269:1: ( () )
            {
            // InternalDOcl.g:4269:1: ( () )
            // InternalDOcl.g:4270:2: ()
            {
             before(grammarAccess.getEqOpExpAccess().getEqOpCallExpSourceAction_1_0()); 
            // InternalDOcl.g:4271:2: ()
            // InternalDOcl.g:4271:3: 
            {
            }

             after(grammarAccess.getEqOpExpAccess().getEqOpCallExpSourceAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__Group_1__0__Impl"


    // $ANTLR start "rule__EqOpExp__Group_1__1"
    // InternalDOcl.g:4279:1: rule__EqOpExp__Group_1__1 : rule__EqOpExp__Group_1__1__Impl rule__EqOpExp__Group_1__2 ;
    public final void rule__EqOpExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4283:1: ( rule__EqOpExp__Group_1__1__Impl rule__EqOpExp__Group_1__2 )
            // InternalDOcl.g:4284:2: rule__EqOpExp__Group_1__1__Impl rule__EqOpExp__Group_1__2
            {
            pushFollow(FOLLOW_27);
            rule__EqOpExp__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EqOpExp__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__Group_1__1"


    // $ANTLR start "rule__EqOpExp__Group_1__1__Impl"
    // InternalDOcl.g:4291:1: rule__EqOpExp__Group_1__1__Impl : ( ( rule__EqOpExp__NameAssignment_1_1 ) ) ;
    public final void rule__EqOpExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4295:1: ( ( ( rule__EqOpExp__NameAssignment_1_1 ) ) )
            // InternalDOcl.g:4296:1: ( ( rule__EqOpExp__NameAssignment_1_1 ) )
            {
            // InternalDOcl.g:4296:1: ( ( rule__EqOpExp__NameAssignment_1_1 ) )
            // InternalDOcl.g:4297:2: ( rule__EqOpExp__NameAssignment_1_1 )
            {
             before(grammarAccess.getEqOpExpAccess().getNameAssignment_1_1()); 
            // InternalDOcl.g:4298:2: ( rule__EqOpExp__NameAssignment_1_1 )
            // InternalDOcl.g:4298:3: rule__EqOpExp__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__EqOpExp__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEqOpExpAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__Group_1__1__Impl"


    // $ANTLR start "rule__EqOpExp__Group_1__2"
    // InternalDOcl.g:4306:1: rule__EqOpExp__Group_1__2 : rule__EqOpExp__Group_1__2__Impl ;
    public final void rule__EqOpExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4310:1: ( rule__EqOpExp__Group_1__2__Impl )
            // InternalDOcl.g:4311:2: rule__EqOpExp__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EqOpExp__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__Group_1__2"


    // $ANTLR start "rule__EqOpExp__Group_1__2__Impl"
    // InternalDOcl.g:4317:1: rule__EqOpExp__Group_1__2__Impl : ( ( rule__EqOpExp__TargetAssignment_1_2 ) ) ;
    public final void rule__EqOpExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4321:1: ( ( ( rule__EqOpExp__TargetAssignment_1_2 ) ) )
            // InternalDOcl.g:4322:1: ( ( rule__EqOpExp__TargetAssignment_1_2 ) )
            {
            // InternalDOcl.g:4322:1: ( ( rule__EqOpExp__TargetAssignment_1_2 ) )
            // InternalDOcl.g:4323:2: ( rule__EqOpExp__TargetAssignment_1_2 )
            {
             before(grammarAccess.getEqOpExpAccess().getTargetAssignment_1_2()); 
            // InternalDOcl.g:4324:2: ( rule__EqOpExp__TargetAssignment_1_2 )
            // InternalDOcl.g:4324:3: rule__EqOpExp__TargetAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__EqOpExp__TargetAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getEqOpExpAccess().getTargetAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__Group_1__2__Impl"


    // $ANTLR start "rule__ComparisonOpExp__Group__0"
    // InternalDOcl.g:4333:1: rule__ComparisonOpExp__Group__0 : rule__ComparisonOpExp__Group__0__Impl rule__ComparisonOpExp__Group__1 ;
    public final void rule__ComparisonOpExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4337:1: ( rule__ComparisonOpExp__Group__0__Impl rule__ComparisonOpExp__Group__1 )
            // InternalDOcl.g:4338:2: rule__ComparisonOpExp__Group__0__Impl rule__ComparisonOpExp__Group__1
            {
            pushFollow(FOLLOW_36);
            rule__ComparisonOpExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComparisonOpExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__Group__0"


    // $ANTLR start "rule__ComparisonOpExp__Group__0__Impl"
    // InternalDOcl.g:4345:1: rule__ComparisonOpExp__Group__0__Impl : ( ruleAdditionOpExp ) ;
    public final void rule__ComparisonOpExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4349:1: ( ( ruleAdditionOpExp ) )
            // InternalDOcl.g:4350:1: ( ruleAdditionOpExp )
            {
            // InternalDOcl.g:4350:1: ( ruleAdditionOpExp )
            // InternalDOcl.g:4351:2: ruleAdditionOpExp
            {
             before(grammarAccess.getComparisonOpExpAccess().getAdditionOpExpParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleAdditionOpExp();

            state._fsp--;

             after(grammarAccess.getComparisonOpExpAccess().getAdditionOpExpParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__Group__0__Impl"


    // $ANTLR start "rule__ComparisonOpExp__Group__1"
    // InternalDOcl.g:4360:1: rule__ComparisonOpExp__Group__1 : rule__ComparisonOpExp__Group__1__Impl ;
    public final void rule__ComparisonOpExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4364:1: ( rule__ComparisonOpExp__Group__1__Impl )
            // InternalDOcl.g:4365:2: rule__ComparisonOpExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonOpExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__Group__1"


    // $ANTLR start "rule__ComparisonOpExp__Group__1__Impl"
    // InternalDOcl.g:4371:1: rule__ComparisonOpExp__Group__1__Impl : ( ( rule__ComparisonOpExp__Group_1__0 )* ) ;
    public final void rule__ComparisonOpExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4375:1: ( ( ( rule__ComparisonOpExp__Group_1__0 )* ) )
            // InternalDOcl.g:4376:1: ( ( rule__ComparisonOpExp__Group_1__0 )* )
            {
            // InternalDOcl.g:4376:1: ( ( rule__ComparisonOpExp__Group_1__0 )* )
            // InternalDOcl.g:4377:2: ( rule__ComparisonOpExp__Group_1__0 )*
            {
             before(grammarAccess.getComparisonOpExpAccess().getGroup_1()); 
            // InternalDOcl.g:4378:2: ( rule__ComparisonOpExp__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=55 && LA29_0<=58)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalDOcl.g:4378:3: rule__ComparisonOpExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_37);
            	    rule__ComparisonOpExp__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getComparisonOpExpAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__Group__1__Impl"


    // $ANTLR start "rule__ComparisonOpExp__Group_1__0"
    // InternalDOcl.g:4387:1: rule__ComparisonOpExp__Group_1__0 : rule__ComparisonOpExp__Group_1__0__Impl rule__ComparisonOpExp__Group_1__1 ;
    public final void rule__ComparisonOpExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4391:1: ( rule__ComparisonOpExp__Group_1__0__Impl rule__ComparisonOpExp__Group_1__1 )
            // InternalDOcl.g:4392:2: rule__ComparisonOpExp__Group_1__0__Impl rule__ComparisonOpExp__Group_1__1
            {
            pushFollow(FOLLOW_36);
            rule__ComparisonOpExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComparisonOpExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__Group_1__0"


    // $ANTLR start "rule__ComparisonOpExp__Group_1__0__Impl"
    // InternalDOcl.g:4399:1: rule__ComparisonOpExp__Group_1__0__Impl : ( () ) ;
    public final void rule__ComparisonOpExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4403:1: ( ( () ) )
            // InternalDOcl.g:4404:1: ( () )
            {
            // InternalDOcl.g:4404:1: ( () )
            // InternalDOcl.g:4405:2: ()
            {
             before(grammarAccess.getComparisonOpExpAccess().getComOpCallExpSourceAction_1_0()); 
            // InternalDOcl.g:4406:2: ()
            // InternalDOcl.g:4406:3: 
            {
            }

             after(grammarAccess.getComparisonOpExpAccess().getComOpCallExpSourceAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__Group_1__0__Impl"


    // $ANTLR start "rule__ComparisonOpExp__Group_1__1"
    // InternalDOcl.g:4414:1: rule__ComparisonOpExp__Group_1__1 : rule__ComparisonOpExp__Group_1__1__Impl rule__ComparisonOpExp__Group_1__2 ;
    public final void rule__ComparisonOpExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4418:1: ( rule__ComparisonOpExp__Group_1__1__Impl rule__ComparisonOpExp__Group_1__2 )
            // InternalDOcl.g:4419:2: rule__ComparisonOpExp__Group_1__1__Impl rule__ComparisonOpExp__Group_1__2
            {
            pushFollow(FOLLOW_27);
            rule__ComparisonOpExp__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ComparisonOpExp__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__Group_1__1"


    // $ANTLR start "rule__ComparisonOpExp__Group_1__1__Impl"
    // InternalDOcl.g:4426:1: rule__ComparisonOpExp__Group_1__1__Impl : ( ( rule__ComparisonOpExp__NameAssignment_1_1 ) ) ;
    public final void rule__ComparisonOpExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4430:1: ( ( ( rule__ComparisonOpExp__NameAssignment_1_1 ) ) )
            // InternalDOcl.g:4431:1: ( ( rule__ComparisonOpExp__NameAssignment_1_1 ) )
            {
            // InternalDOcl.g:4431:1: ( ( rule__ComparisonOpExp__NameAssignment_1_1 ) )
            // InternalDOcl.g:4432:2: ( rule__ComparisonOpExp__NameAssignment_1_1 )
            {
             before(grammarAccess.getComparisonOpExpAccess().getNameAssignment_1_1()); 
            // InternalDOcl.g:4433:2: ( rule__ComparisonOpExp__NameAssignment_1_1 )
            // InternalDOcl.g:4433:3: rule__ComparisonOpExp__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonOpExp__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getComparisonOpExpAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__Group_1__1__Impl"


    // $ANTLR start "rule__ComparisonOpExp__Group_1__2"
    // InternalDOcl.g:4441:1: rule__ComparisonOpExp__Group_1__2 : rule__ComparisonOpExp__Group_1__2__Impl ;
    public final void rule__ComparisonOpExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4445:1: ( rule__ComparisonOpExp__Group_1__2__Impl )
            // InternalDOcl.g:4446:2: rule__ComparisonOpExp__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonOpExp__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__Group_1__2"


    // $ANTLR start "rule__ComparisonOpExp__Group_1__2__Impl"
    // InternalDOcl.g:4452:1: rule__ComparisonOpExp__Group_1__2__Impl : ( ( rule__ComparisonOpExp__TargetAssignment_1_2 ) ) ;
    public final void rule__ComparisonOpExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4456:1: ( ( ( rule__ComparisonOpExp__TargetAssignment_1_2 ) ) )
            // InternalDOcl.g:4457:1: ( ( rule__ComparisonOpExp__TargetAssignment_1_2 ) )
            {
            // InternalDOcl.g:4457:1: ( ( rule__ComparisonOpExp__TargetAssignment_1_2 ) )
            // InternalDOcl.g:4458:2: ( rule__ComparisonOpExp__TargetAssignment_1_2 )
            {
             before(grammarAccess.getComparisonOpExpAccess().getTargetAssignment_1_2()); 
            // InternalDOcl.g:4459:2: ( rule__ComparisonOpExp__TargetAssignment_1_2 )
            // InternalDOcl.g:4459:3: rule__ComparisonOpExp__TargetAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonOpExp__TargetAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getComparisonOpExpAccess().getTargetAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__Group_1__2__Impl"


    // $ANTLR start "rule__AdditionOpExp__Group__0"
    // InternalDOcl.g:4468:1: rule__AdditionOpExp__Group__0 : rule__AdditionOpExp__Group__0__Impl rule__AdditionOpExp__Group__1 ;
    public final void rule__AdditionOpExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4472:1: ( rule__AdditionOpExp__Group__0__Impl rule__AdditionOpExp__Group__1 )
            // InternalDOcl.g:4473:2: rule__AdditionOpExp__Group__0__Impl rule__AdditionOpExp__Group__1
            {
            pushFollow(FOLLOW_38);
            rule__AdditionOpExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AdditionOpExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__Group__0"


    // $ANTLR start "rule__AdditionOpExp__Group__0__Impl"
    // InternalDOcl.g:4480:1: rule__AdditionOpExp__Group__0__Impl : ( ruleMultiOpExp ) ;
    public final void rule__AdditionOpExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4484:1: ( ( ruleMultiOpExp ) )
            // InternalDOcl.g:4485:1: ( ruleMultiOpExp )
            {
            // InternalDOcl.g:4485:1: ( ruleMultiOpExp )
            // InternalDOcl.g:4486:2: ruleMultiOpExp
            {
             before(grammarAccess.getAdditionOpExpAccess().getMultiOpExpParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiOpExp();

            state._fsp--;

             after(grammarAccess.getAdditionOpExpAccess().getMultiOpExpParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__Group__0__Impl"


    // $ANTLR start "rule__AdditionOpExp__Group__1"
    // InternalDOcl.g:4495:1: rule__AdditionOpExp__Group__1 : rule__AdditionOpExp__Group__1__Impl ;
    public final void rule__AdditionOpExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4499:1: ( rule__AdditionOpExp__Group__1__Impl )
            // InternalDOcl.g:4500:2: rule__AdditionOpExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AdditionOpExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__Group__1"


    // $ANTLR start "rule__AdditionOpExp__Group__1__Impl"
    // InternalDOcl.g:4506:1: rule__AdditionOpExp__Group__1__Impl : ( ( rule__AdditionOpExp__Group_1__0 )* ) ;
    public final void rule__AdditionOpExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4510:1: ( ( ( rule__AdditionOpExp__Group_1__0 )* ) )
            // InternalDOcl.g:4511:1: ( ( rule__AdditionOpExp__Group_1__0 )* )
            {
            // InternalDOcl.g:4511:1: ( ( rule__AdditionOpExp__Group_1__0 )* )
            // InternalDOcl.g:4512:2: ( rule__AdditionOpExp__Group_1__0 )*
            {
             before(grammarAccess.getAdditionOpExpAccess().getGroup_1()); 
            // InternalDOcl.g:4513:2: ( rule__AdditionOpExp__Group_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==17||LA30_0==59) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalDOcl.g:4513:3: rule__AdditionOpExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_39);
            	    rule__AdditionOpExp__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getAdditionOpExpAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__Group__1__Impl"


    // $ANTLR start "rule__AdditionOpExp__Group_1__0"
    // InternalDOcl.g:4522:1: rule__AdditionOpExp__Group_1__0 : rule__AdditionOpExp__Group_1__0__Impl rule__AdditionOpExp__Group_1__1 ;
    public final void rule__AdditionOpExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4526:1: ( rule__AdditionOpExp__Group_1__0__Impl rule__AdditionOpExp__Group_1__1 )
            // InternalDOcl.g:4527:2: rule__AdditionOpExp__Group_1__0__Impl rule__AdditionOpExp__Group_1__1
            {
            pushFollow(FOLLOW_38);
            rule__AdditionOpExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AdditionOpExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__Group_1__0"


    // $ANTLR start "rule__AdditionOpExp__Group_1__0__Impl"
    // InternalDOcl.g:4534:1: rule__AdditionOpExp__Group_1__0__Impl : ( () ) ;
    public final void rule__AdditionOpExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4538:1: ( ( () ) )
            // InternalDOcl.g:4539:1: ( () )
            {
            // InternalDOcl.g:4539:1: ( () )
            // InternalDOcl.g:4540:2: ()
            {
             before(grammarAccess.getAdditionOpExpAccess().getAddOpCallExpSourceAction_1_0()); 
            // InternalDOcl.g:4541:2: ()
            // InternalDOcl.g:4541:3: 
            {
            }

             after(grammarAccess.getAdditionOpExpAccess().getAddOpCallExpSourceAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__Group_1__0__Impl"


    // $ANTLR start "rule__AdditionOpExp__Group_1__1"
    // InternalDOcl.g:4549:1: rule__AdditionOpExp__Group_1__1 : rule__AdditionOpExp__Group_1__1__Impl rule__AdditionOpExp__Group_1__2 ;
    public final void rule__AdditionOpExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4553:1: ( rule__AdditionOpExp__Group_1__1__Impl rule__AdditionOpExp__Group_1__2 )
            // InternalDOcl.g:4554:2: rule__AdditionOpExp__Group_1__1__Impl rule__AdditionOpExp__Group_1__2
            {
            pushFollow(FOLLOW_27);
            rule__AdditionOpExp__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AdditionOpExp__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__Group_1__1"


    // $ANTLR start "rule__AdditionOpExp__Group_1__1__Impl"
    // InternalDOcl.g:4561:1: rule__AdditionOpExp__Group_1__1__Impl : ( ( rule__AdditionOpExp__NameAssignment_1_1 ) ) ;
    public final void rule__AdditionOpExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4565:1: ( ( ( rule__AdditionOpExp__NameAssignment_1_1 ) ) )
            // InternalDOcl.g:4566:1: ( ( rule__AdditionOpExp__NameAssignment_1_1 ) )
            {
            // InternalDOcl.g:4566:1: ( ( rule__AdditionOpExp__NameAssignment_1_1 ) )
            // InternalDOcl.g:4567:2: ( rule__AdditionOpExp__NameAssignment_1_1 )
            {
             before(grammarAccess.getAdditionOpExpAccess().getNameAssignment_1_1()); 
            // InternalDOcl.g:4568:2: ( rule__AdditionOpExp__NameAssignment_1_1 )
            // InternalDOcl.g:4568:3: rule__AdditionOpExp__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AdditionOpExp__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAdditionOpExpAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__Group_1__1__Impl"


    // $ANTLR start "rule__AdditionOpExp__Group_1__2"
    // InternalDOcl.g:4576:1: rule__AdditionOpExp__Group_1__2 : rule__AdditionOpExp__Group_1__2__Impl ;
    public final void rule__AdditionOpExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4580:1: ( rule__AdditionOpExp__Group_1__2__Impl )
            // InternalDOcl.g:4581:2: rule__AdditionOpExp__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AdditionOpExp__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__Group_1__2"


    // $ANTLR start "rule__AdditionOpExp__Group_1__2__Impl"
    // InternalDOcl.g:4587:1: rule__AdditionOpExp__Group_1__2__Impl : ( ( rule__AdditionOpExp__TargetAssignment_1_2 ) ) ;
    public final void rule__AdditionOpExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4591:1: ( ( ( rule__AdditionOpExp__TargetAssignment_1_2 ) ) )
            // InternalDOcl.g:4592:1: ( ( rule__AdditionOpExp__TargetAssignment_1_2 ) )
            {
            // InternalDOcl.g:4592:1: ( ( rule__AdditionOpExp__TargetAssignment_1_2 ) )
            // InternalDOcl.g:4593:2: ( rule__AdditionOpExp__TargetAssignment_1_2 )
            {
             before(grammarAccess.getAdditionOpExpAccess().getTargetAssignment_1_2()); 
            // InternalDOcl.g:4594:2: ( rule__AdditionOpExp__TargetAssignment_1_2 )
            // InternalDOcl.g:4594:3: rule__AdditionOpExp__TargetAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__AdditionOpExp__TargetAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getAdditionOpExpAccess().getTargetAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__Group_1__2__Impl"


    // $ANTLR start "rule__MultiOpExp__Group__0"
    // InternalDOcl.g:4603:1: rule__MultiOpExp__Group__0 : rule__MultiOpExp__Group__0__Impl rule__MultiOpExp__Group__1 ;
    public final void rule__MultiOpExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4607:1: ( rule__MultiOpExp__Group__0__Impl rule__MultiOpExp__Group__1 )
            // InternalDOcl.g:4608:2: rule__MultiOpExp__Group__0__Impl rule__MultiOpExp__Group__1
            {
            pushFollow(FOLLOW_40);
            rule__MultiOpExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiOpExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__Group__0"


    // $ANTLR start "rule__MultiOpExp__Group__0__Impl"
    // InternalDOcl.g:4615:1: rule__MultiOpExp__Group__0__Impl : ( ruleNavOpExp ) ;
    public final void rule__MultiOpExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4619:1: ( ( ruleNavOpExp ) )
            // InternalDOcl.g:4620:1: ( ruleNavOpExp )
            {
            // InternalDOcl.g:4620:1: ( ruleNavOpExp )
            // InternalDOcl.g:4621:2: ruleNavOpExp
            {
             before(grammarAccess.getMultiOpExpAccess().getNavOpExpParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleNavOpExp();

            state._fsp--;

             after(grammarAccess.getMultiOpExpAccess().getNavOpExpParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__Group__0__Impl"


    // $ANTLR start "rule__MultiOpExp__Group__1"
    // InternalDOcl.g:4630:1: rule__MultiOpExp__Group__1 : rule__MultiOpExp__Group__1__Impl ;
    public final void rule__MultiOpExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4634:1: ( rule__MultiOpExp__Group__1__Impl )
            // InternalDOcl.g:4635:2: rule__MultiOpExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiOpExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__Group__1"


    // $ANTLR start "rule__MultiOpExp__Group__1__Impl"
    // InternalDOcl.g:4641:1: rule__MultiOpExp__Group__1__Impl : ( ( rule__MultiOpExp__Group_1__0 )* ) ;
    public final void rule__MultiOpExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4645:1: ( ( ( rule__MultiOpExp__Group_1__0 )* ) )
            // InternalDOcl.g:4646:1: ( ( rule__MultiOpExp__Group_1__0 )* )
            {
            // InternalDOcl.g:4646:1: ( ( rule__MultiOpExp__Group_1__0 )* )
            // InternalDOcl.g:4647:2: ( rule__MultiOpExp__Group_1__0 )*
            {
             before(grammarAccess.getMultiOpExpAccess().getGroup_1()); 
            // InternalDOcl.g:4648:2: ( rule__MultiOpExp__Group_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=60 && LA31_0<=61)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalDOcl.g:4648:3: rule__MultiOpExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_41);
            	    rule__MultiOpExp__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getMultiOpExpAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__Group__1__Impl"


    // $ANTLR start "rule__MultiOpExp__Group_1__0"
    // InternalDOcl.g:4657:1: rule__MultiOpExp__Group_1__0 : rule__MultiOpExp__Group_1__0__Impl rule__MultiOpExp__Group_1__1 ;
    public final void rule__MultiOpExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4661:1: ( rule__MultiOpExp__Group_1__0__Impl rule__MultiOpExp__Group_1__1 )
            // InternalDOcl.g:4662:2: rule__MultiOpExp__Group_1__0__Impl rule__MultiOpExp__Group_1__1
            {
            pushFollow(FOLLOW_40);
            rule__MultiOpExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiOpExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__Group_1__0"


    // $ANTLR start "rule__MultiOpExp__Group_1__0__Impl"
    // InternalDOcl.g:4669:1: rule__MultiOpExp__Group_1__0__Impl : ( () ) ;
    public final void rule__MultiOpExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4673:1: ( ( () ) )
            // InternalDOcl.g:4674:1: ( () )
            {
            // InternalDOcl.g:4674:1: ( () )
            // InternalDOcl.g:4675:2: ()
            {
             before(grammarAccess.getMultiOpExpAccess().getMulOpCallExpSourceAction_1_0()); 
            // InternalDOcl.g:4676:2: ()
            // InternalDOcl.g:4676:3: 
            {
            }

             after(grammarAccess.getMultiOpExpAccess().getMulOpCallExpSourceAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__Group_1__0__Impl"


    // $ANTLR start "rule__MultiOpExp__Group_1__1"
    // InternalDOcl.g:4684:1: rule__MultiOpExp__Group_1__1 : rule__MultiOpExp__Group_1__1__Impl rule__MultiOpExp__Group_1__2 ;
    public final void rule__MultiOpExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4688:1: ( rule__MultiOpExp__Group_1__1__Impl rule__MultiOpExp__Group_1__2 )
            // InternalDOcl.g:4689:2: rule__MultiOpExp__Group_1__1__Impl rule__MultiOpExp__Group_1__2
            {
            pushFollow(FOLLOW_27);
            rule__MultiOpExp__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiOpExp__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__Group_1__1"


    // $ANTLR start "rule__MultiOpExp__Group_1__1__Impl"
    // InternalDOcl.g:4696:1: rule__MultiOpExp__Group_1__1__Impl : ( ( rule__MultiOpExp__NameAssignment_1_1 ) ) ;
    public final void rule__MultiOpExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4700:1: ( ( ( rule__MultiOpExp__NameAssignment_1_1 ) ) )
            // InternalDOcl.g:4701:1: ( ( rule__MultiOpExp__NameAssignment_1_1 ) )
            {
            // InternalDOcl.g:4701:1: ( ( rule__MultiOpExp__NameAssignment_1_1 ) )
            // InternalDOcl.g:4702:2: ( rule__MultiOpExp__NameAssignment_1_1 )
            {
             before(grammarAccess.getMultiOpExpAccess().getNameAssignment_1_1()); 
            // InternalDOcl.g:4703:2: ( rule__MultiOpExp__NameAssignment_1_1 )
            // InternalDOcl.g:4703:3: rule__MultiOpExp__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiOpExp__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiOpExpAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__Group_1__1__Impl"


    // $ANTLR start "rule__MultiOpExp__Group_1__2"
    // InternalDOcl.g:4711:1: rule__MultiOpExp__Group_1__2 : rule__MultiOpExp__Group_1__2__Impl ;
    public final void rule__MultiOpExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4715:1: ( rule__MultiOpExp__Group_1__2__Impl )
            // InternalDOcl.g:4716:2: rule__MultiOpExp__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiOpExp__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__Group_1__2"


    // $ANTLR start "rule__MultiOpExp__Group_1__2__Impl"
    // InternalDOcl.g:4722:1: rule__MultiOpExp__Group_1__2__Impl : ( ( rule__MultiOpExp__TargetAssignment_1_2 ) ) ;
    public final void rule__MultiOpExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4726:1: ( ( ( rule__MultiOpExp__TargetAssignment_1_2 ) ) )
            // InternalDOcl.g:4727:1: ( ( rule__MultiOpExp__TargetAssignment_1_2 ) )
            {
            // InternalDOcl.g:4727:1: ( ( rule__MultiOpExp__TargetAssignment_1_2 ) )
            // InternalDOcl.g:4728:2: ( rule__MultiOpExp__TargetAssignment_1_2 )
            {
             before(grammarAccess.getMultiOpExpAccess().getTargetAssignment_1_2()); 
            // InternalDOcl.g:4729:2: ( rule__MultiOpExp__TargetAssignment_1_2 )
            // InternalDOcl.g:4729:3: rule__MultiOpExp__TargetAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__MultiOpExp__TargetAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getMultiOpExpAccess().getTargetAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__Group_1__2__Impl"


    // $ANTLR start "rule__NavOpExp__Group__0"
    // InternalDOcl.g:4738:1: rule__NavOpExp__Group__0 : rule__NavOpExp__Group__0__Impl rule__NavOpExp__Group__1 ;
    public final void rule__NavOpExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4742:1: ( rule__NavOpExp__Group__0__Impl rule__NavOpExp__Group__1 )
            // InternalDOcl.g:4743:2: rule__NavOpExp__Group__0__Impl rule__NavOpExp__Group__1
            {
            pushFollow(FOLLOW_42);
            rule__NavOpExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NavOpExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavOpExp__Group__0"


    // $ANTLR start "rule__NavOpExp__Group__0__Impl"
    // InternalDOcl.g:4750:1: rule__NavOpExp__Group__0__Impl : ( ruleNavigationOpCallExp ) ;
    public final void rule__NavOpExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4754:1: ( ( ruleNavigationOpCallExp ) )
            // InternalDOcl.g:4755:1: ( ruleNavigationOpCallExp )
            {
            // InternalDOcl.g:4755:1: ( ruleNavigationOpCallExp )
            // InternalDOcl.g:4756:2: ruleNavigationOpCallExp
            {
             before(grammarAccess.getNavOpExpAccess().getNavigationOpCallExpParserRuleCall_0()); 
            pushFollow(FOLLOW_2);
            ruleNavigationOpCallExp();

            state._fsp--;

             after(grammarAccess.getNavOpExpAccess().getNavigationOpCallExpParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavOpExp__Group__0__Impl"


    // $ANTLR start "rule__NavOpExp__Group__1"
    // InternalDOcl.g:4765:1: rule__NavOpExp__Group__1 : rule__NavOpExp__Group__1__Impl ;
    public final void rule__NavOpExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4769:1: ( rule__NavOpExp__Group__1__Impl )
            // InternalDOcl.g:4770:2: rule__NavOpExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NavOpExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavOpExp__Group__1"


    // $ANTLR start "rule__NavOpExp__Group__1__Impl"
    // InternalDOcl.g:4776:1: rule__NavOpExp__Group__1__Impl : ( ( rule__NavOpExp__Group_1__0 )* ) ;
    public final void rule__NavOpExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4780:1: ( ( ( rule__NavOpExp__Group_1__0 )* ) )
            // InternalDOcl.g:4781:1: ( ( rule__NavOpExp__Group_1__0 )* )
            {
            // InternalDOcl.g:4781:1: ( ( rule__NavOpExp__Group_1__0 )* )
            // InternalDOcl.g:4782:2: ( rule__NavOpExp__Group_1__0 )*
            {
             before(grammarAccess.getNavOpExpAccess().getGroup_1()); 
            // InternalDOcl.g:4783:2: ( rule__NavOpExp__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=19 && LA32_0<=20)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalDOcl.g:4783:3: rule__NavOpExp__Group_1__0
            	    {
            	    pushFollow(FOLLOW_43);
            	    rule__NavOpExp__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getNavOpExpAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavOpExp__Group__1__Impl"


    // $ANTLR start "rule__NavOpExp__Group_1__0"
    // InternalDOcl.g:4792:1: rule__NavOpExp__Group_1__0 : rule__NavOpExp__Group_1__0__Impl rule__NavOpExp__Group_1__1 ;
    public final void rule__NavOpExp__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4796:1: ( rule__NavOpExp__Group_1__0__Impl rule__NavOpExp__Group_1__1 )
            // InternalDOcl.g:4797:2: rule__NavOpExp__Group_1__0__Impl rule__NavOpExp__Group_1__1
            {
            pushFollow(FOLLOW_42);
            rule__NavOpExp__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NavOpExp__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavOpExp__Group_1__0"


    // $ANTLR start "rule__NavOpExp__Group_1__0__Impl"
    // InternalDOcl.g:4804:1: rule__NavOpExp__Group_1__0__Impl : ( () ) ;
    public final void rule__NavOpExp__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4808:1: ( ( () ) )
            // InternalDOcl.g:4809:1: ( () )
            {
            // InternalDOcl.g:4809:1: ( () )
            // InternalDOcl.g:4810:2: ()
            {
             before(grammarAccess.getNavOpExpAccess().getNavigationExpSourceAction_1_0()); 
            // InternalDOcl.g:4811:2: ()
            // InternalDOcl.g:4811:3: 
            {
            }

             after(grammarAccess.getNavOpExpAccess().getNavigationExpSourceAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavOpExp__Group_1__0__Impl"


    // $ANTLR start "rule__NavOpExp__Group_1__1"
    // InternalDOcl.g:4819:1: rule__NavOpExp__Group_1__1 : rule__NavOpExp__Group_1__1__Impl rule__NavOpExp__Group_1__2 ;
    public final void rule__NavOpExp__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4823:1: ( rule__NavOpExp__Group_1__1__Impl rule__NavOpExp__Group_1__2 )
            // InternalDOcl.g:4824:2: rule__NavOpExp__Group_1__1__Impl rule__NavOpExp__Group_1__2
            {
            pushFollow(FOLLOW_27);
            rule__NavOpExp__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NavOpExp__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavOpExp__Group_1__1"


    // $ANTLR start "rule__NavOpExp__Group_1__1__Impl"
    // InternalDOcl.g:4831:1: rule__NavOpExp__Group_1__1__Impl : ( ( rule__NavOpExp__NameAssignment_1_1 ) ) ;
    public final void rule__NavOpExp__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4835:1: ( ( ( rule__NavOpExp__NameAssignment_1_1 ) ) )
            // InternalDOcl.g:4836:1: ( ( rule__NavOpExp__NameAssignment_1_1 ) )
            {
            // InternalDOcl.g:4836:1: ( ( rule__NavOpExp__NameAssignment_1_1 ) )
            // InternalDOcl.g:4837:2: ( rule__NavOpExp__NameAssignment_1_1 )
            {
             before(grammarAccess.getNavOpExpAccess().getNameAssignment_1_1()); 
            // InternalDOcl.g:4838:2: ( rule__NavOpExp__NameAssignment_1_1 )
            // InternalDOcl.g:4838:3: rule__NavOpExp__NameAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__NavOpExp__NameAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getNavOpExpAccess().getNameAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavOpExp__Group_1__1__Impl"


    // $ANTLR start "rule__NavOpExp__Group_1__2"
    // InternalDOcl.g:4846:1: rule__NavOpExp__Group_1__2 : rule__NavOpExp__Group_1__2__Impl ;
    public final void rule__NavOpExp__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4850:1: ( rule__NavOpExp__Group_1__2__Impl )
            // InternalDOcl.g:4851:2: rule__NavOpExp__Group_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NavOpExp__Group_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavOpExp__Group_1__2"


    // $ANTLR start "rule__NavOpExp__Group_1__2__Impl"
    // InternalDOcl.g:4857:1: rule__NavOpExp__Group_1__2__Impl : ( ( rule__NavOpExp__TargetAssignment_1_2 ) ) ;
    public final void rule__NavOpExp__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4861:1: ( ( ( rule__NavOpExp__TargetAssignment_1_2 ) ) )
            // InternalDOcl.g:4862:1: ( ( rule__NavOpExp__TargetAssignment_1_2 ) )
            {
            // InternalDOcl.g:4862:1: ( ( rule__NavOpExp__TargetAssignment_1_2 ) )
            // InternalDOcl.g:4863:2: ( rule__NavOpExp__TargetAssignment_1_2 )
            {
             before(grammarAccess.getNavOpExpAccess().getTargetAssignment_1_2()); 
            // InternalDOcl.g:4864:2: ( rule__NavOpExp__TargetAssignment_1_2 )
            // InternalDOcl.g:4864:3: rule__NavOpExp__TargetAssignment_1_2
            {
            pushFollow(FOLLOW_2);
            rule__NavOpExp__TargetAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getNavOpExpAccess().getTargetAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavOpExp__Group_1__2__Impl"


    // $ANTLR start "rule__CollectionOpCall__Group__0"
    // InternalDOcl.g:4873:1: rule__CollectionOpCall__Group__0 : rule__CollectionOpCall__Group__0__Impl rule__CollectionOpCall__Group__1 ;
    public final void rule__CollectionOpCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4877:1: ( rule__CollectionOpCall__Group__0__Impl rule__CollectionOpCall__Group__1 )
            // InternalDOcl.g:4878:2: rule__CollectionOpCall__Group__0__Impl rule__CollectionOpCall__Group__1
            {
            pushFollow(FOLLOW_44);
            rule__CollectionOpCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group__0"


    // $ANTLR start "rule__CollectionOpCall__Group__0__Impl"
    // InternalDOcl.g:4885:1: rule__CollectionOpCall__Group__0__Impl : ( () ) ;
    public final void rule__CollectionOpCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4889:1: ( ( () ) )
            // InternalDOcl.g:4890:1: ( () )
            {
            // InternalDOcl.g:4890:1: ( () )
            // InternalDOcl.g:4891:2: ()
            {
             before(grammarAccess.getCollectionOpCallAccess().getCollectionOpCallExpAction_0()); 
            // InternalDOcl.g:4892:2: ()
            // InternalDOcl.g:4892:3: 
            {
            }

             after(grammarAccess.getCollectionOpCallAccess().getCollectionOpCallExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group__0__Impl"


    // $ANTLR start "rule__CollectionOpCall__Group__1"
    // InternalDOcl.g:4900:1: rule__CollectionOpCall__Group__1 : rule__CollectionOpCall__Group__1__Impl rule__CollectionOpCall__Group__2 ;
    public final void rule__CollectionOpCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4904:1: ( rule__CollectionOpCall__Group__1__Impl rule__CollectionOpCall__Group__2 )
            // InternalDOcl.g:4905:2: rule__CollectionOpCall__Group__1__Impl rule__CollectionOpCall__Group__2
            {
            pushFollow(FOLLOW_45);
            rule__CollectionOpCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group__1"


    // $ANTLR start "rule__CollectionOpCall__Group__1__Impl"
    // InternalDOcl.g:4912:1: rule__CollectionOpCall__Group__1__Impl : ( ( rule__CollectionOpCall__NameAssignment_1 ) ) ;
    public final void rule__CollectionOpCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4916:1: ( ( ( rule__CollectionOpCall__NameAssignment_1 ) ) )
            // InternalDOcl.g:4917:1: ( ( rule__CollectionOpCall__NameAssignment_1 ) )
            {
            // InternalDOcl.g:4917:1: ( ( rule__CollectionOpCall__NameAssignment_1 ) )
            // InternalDOcl.g:4918:2: ( rule__CollectionOpCall__NameAssignment_1 )
            {
             before(grammarAccess.getCollectionOpCallAccess().getNameAssignment_1()); 
            // InternalDOcl.g:4919:2: ( rule__CollectionOpCall__NameAssignment_1 )
            // InternalDOcl.g:4919:3: rule__CollectionOpCall__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCollectionOpCallAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group__1__Impl"


    // $ANTLR start "rule__CollectionOpCall__Group__2"
    // InternalDOcl.g:4927:1: rule__CollectionOpCall__Group__2 : rule__CollectionOpCall__Group__2__Impl rule__CollectionOpCall__Group__3 ;
    public final void rule__CollectionOpCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4931:1: ( rule__CollectionOpCall__Group__2__Impl rule__CollectionOpCall__Group__3 )
            // InternalDOcl.g:4932:2: rule__CollectionOpCall__Group__2__Impl rule__CollectionOpCall__Group__3
            {
            pushFollow(FOLLOW_46);
            rule__CollectionOpCall__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group__2"


    // $ANTLR start "rule__CollectionOpCall__Group__2__Impl"
    // InternalDOcl.g:4939:1: rule__CollectionOpCall__Group__2__Impl : ( '(' ) ;
    public final void rule__CollectionOpCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4943:1: ( ( '(' ) )
            // InternalDOcl.g:4944:1: ( '(' )
            {
            // InternalDOcl.g:4944:1: ( '(' )
            // InternalDOcl.g:4945:2: '('
            {
             before(grammarAccess.getCollectionOpCallAccess().getLeftParenthesisKeyword_2()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getCollectionOpCallAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group__2__Impl"


    // $ANTLR start "rule__CollectionOpCall__Group__3"
    // InternalDOcl.g:4954:1: rule__CollectionOpCall__Group__3 : rule__CollectionOpCall__Group__3__Impl rule__CollectionOpCall__Group__4 ;
    public final void rule__CollectionOpCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4958:1: ( rule__CollectionOpCall__Group__3__Impl rule__CollectionOpCall__Group__4 )
            // InternalDOcl.g:4959:2: rule__CollectionOpCall__Group__3__Impl rule__CollectionOpCall__Group__4
            {
            pushFollow(FOLLOW_46);
            rule__CollectionOpCall__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group__3"


    // $ANTLR start "rule__CollectionOpCall__Group__3__Impl"
    // InternalDOcl.g:4966:1: rule__CollectionOpCall__Group__3__Impl : ( ( rule__CollectionOpCall__Group_3__0 )? ) ;
    public final void rule__CollectionOpCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4970:1: ( ( ( rule__CollectionOpCall__Group_3__0 )? ) )
            // InternalDOcl.g:4971:1: ( ( rule__CollectionOpCall__Group_3__0 )? )
            {
            // InternalDOcl.g:4971:1: ( ( rule__CollectionOpCall__Group_3__0 )? )
            // InternalDOcl.g:4972:2: ( rule__CollectionOpCall__Group_3__0 )?
            {
             before(grammarAccess.getCollectionOpCallAccess().getGroup_3()); 
            // InternalDOcl.g:4973:2: ( rule__CollectionOpCall__Group_3__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_ID && LA33_0<=RULE_INT)||LA33_0==RULE_STRING||(LA33_0>=17 && LA33_0<=18)||(LA33_0>=21 && LA33_0<=52)||LA33_0==60||LA33_0==72||(LA33_0>=79 && LA33_0<=80)||(LA33_0>=84 && LA33_0<=85)||(LA33_0>=87 && LA33_0<=91)||LA33_0==93) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalDOcl.g:4973:3: rule__CollectionOpCall__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__CollectionOpCall__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCollectionOpCallAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group__3__Impl"


    // $ANTLR start "rule__CollectionOpCall__Group__4"
    // InternalDOcl.g:4981:1: rule__CollectionOpCall__Group__4 : rule__CollectionOpCall__Group__4__Impl ;
    public final void rule__CollectionOpCall__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4985:1: ( rule__CollectionOpCall__Group__4__Impl )
            // InternalDOcl.g:4986:2: rule__CollectionOpCall__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group__4"


    // $ANTLR start "rule__CollectionOpCall__Group__4__Impl"
    // InternalDOcl.g:4992:1: rule__CollectionOpCall__Group__4__Impl : ( ')' ) ;
    public final void rule__CollectionOpCall__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:4996:1: ( ( ')' ) )
            // InternalDOcl.g:4997:1: ( ')' )
            {
            // InternalDOcl.g:4997:1: ( ')' )
            // InternalDOcl.g:4998:2: ')'
            {
             before(grammarAccess.getCollectionOpCallAccess().getRightParenthesisKeyword_4()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getCollectionOpCallAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group__4__Impl"


    // $ANTLR start "rule__CollectionOpCall__Group_3__0"
    // InternalDOcl.g:5008:1: rule__CollectionOpCall__Group_3__0 : rule__CollectionOpCall__Group_3__0__Impl rule__CollectionOpCall__Group_3__1 ;
    public final void rule__CollectionOpCall__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5012:1: ( rule__CollectionOpCall__Group_3__0__Impl rule__CollectionOpCall__Group_3__1 )
            // InternalDOcl.g:5013:2: rule__CollectionOpCall__Group_3__0__Impl rule__CollectionOpCall__Group_3__1
            {
            pushFollow(FOLLOW_47);
            rule__CollectionOpCall__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group_3__0"


    // $ANTLR start "rule__CollectionOpCall__Group_3__0__Impl"
    // InternalDOcl.g:5020:1: rule__CollectionOpCall__Group_3__0__Impl : ( ( rule__CollectionOpCall__ArgumentsAssignment_3_0 ) ) ;
    public final void rule__CollectionOpCall__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5024:1: ( ( ( rule__CollectionOpCall__ArgumentsAssignment_3_0 ) ) )
            // InternalDOcl.g:5025:1: ( ( rule__CollectionOpCall__ArgumentsAssignment_3_0 ) )
            {
            // InternalDOcl.g:5025:1: ( ( rule__CollectionOpCall__ArgumentsAssignment_3_0 ) )
            // InternalDOcl.g:5026:2: ( rule__CollectionOpCall__ArgumentsAssignment_3_0 )
            {
             before(grammarAccess.getCollectionOpCallAccess().getArgumentsAssignment_3_0()); 
            // InternalDOcl.g:5027:2: ( rule__CollectionOpCall__ArgumentsAssignment_3_0 )
            // InternalDOcl.g:5027:3: rule__CollectionOpCall__ArgumentsAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__ArgumentsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getCollectionOpCallAccess().getArgumentsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group_3__0__Impl"


    // $ANTLR start "rule__CollectionOpCall__Group_3__1"
    // InternalDOcl.g:5035:1: rule__CollectionOpCall__Group_3__1 : rule__CollectionOpCall__Group_3__1__Impl ;
    public final void rule__CollectionOpCall__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5039:1: ( rule__CollectionOpCall__Group_3__1__Impl )
            // InternalDOcl.g:5040:2: rule__CollectionOpCall__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group_3__1"


    // $ANTLR start "rule__CollectionOpCall__Group_3__1__Impl"
    // InternalDOcl.g:5046:1: rule__CollectionOpCall__Group_3__1__Impl : ( ( rule__CollectionOpCall__Group_3_1__0 )* ) ;
    public final void rule__CollectionOpCall__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5050:1: ( ( ( rule__CollectionOpCall__Group_3_1__0 )* ) )
            // InternalDOcl.g:5051:1: ( ( rule__CollectionOpCall__Group_3_1__0 )* )
            {
            // InternalDOcl.g:5051:1: ( ( rule__CollectionOpCall__Group_3_1__0 )* )
            // InternalDOcl.g:5052:2: ( rule__CollectionOpCall__Group_3_1__0 )*
            {
             before(grammarAccess.getCollectionOpCallAccess().getGroup_3_1()); 
            // InternalDOcl.g:5053:2: ( rule__CollectionOpCall__Group_3_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==74) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalDOcl.g:5053:3: rule__CollectionOpCall__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_48);
            	    rule__CollectionOpCall__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getCollectionOpCallAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group_3__1__Impl"


    // $ANTLR start "rule__CollectionOpCall__Group_3_1__0"
    // InternalDOcl.g:5062:1: rule__CollectionOpCall__Group_3_1__0 : rule__CollectionOpCall__Group_3_1__0__Impl rule__CollectionOpCall__Group_3_1__1 ;
    public final void rule__CollectionOpCall__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5066:1: ( rule__CollectionOpCall__Group_3_1__0__Impl rule__CollectionOpCall__Group_3_1__1 )
            // InternalDOcl.g:5067:2: rule__CollectionOpCall__Group_3_1__0__Impl rule__CollectionOpCall__Group_3_1__1
            {
            pushFollow(FOLLOW_22);
            rule__CollectionOpCall__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group_3_1__0"


    // $ANTLR start "rule__CollectionOpCall__Group_3_1__0__Impl"
    // InternalDOcl.g:5074:1: rule__CollectionOpCall__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__CollectionOpCall__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5078:1: ( ( ',' ) )
            // InternalDOcl.g:5079:1: ( ',' )
            {
            // InternalDOcl.g:5079:1: ( ',' )
            // InternalDOcl.g:5080:2: ','
            {
             before(grammarAccess.getCollectionOpCallAccess().getCommaKeyword_3_1_0()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getCollectionOpCallAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group_3_1__0__Impl"


    // $ANTLR start "rule__CollectionOpCall__Group_3_1__1"
    // InternalDOcl.g:5089:1: rule__CollectionOpCall__Group_3_1__1 : rule__CollectionOpCall__Group_3_1__1__Impl ;
    public final void rule__CollectionOpCall__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5093:1: ( rule__CollectionOpCall__Group_3_1__1__Impl )
            // InternalDOcl.g:5094:2: rule__CollectionOpCall__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group_3_1__1"


    // $ANTLR start "rule__CollectionOpCall__Group_3_1__1__Impl"
    // InternalDOcl.g:5100:1: rule__CollectionOpCall__Group_3_1__1__Impl : ( ( rule__CollectionOpCall__ArgumentsAssignment_3_1_1 ) ) ;
    public final void rule__CollectionOpCall__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5104:1: ( ( ( rule__CollectionOpCall__ArgumentsAssignment_3_1_1 ) ) )
            // InternalDOcl.g:5105:1: ( ( rule__CollectionOpCall__ArgumentsAssignment_3_1_1 ) )
            {
            // InternalDOcl.g:5105:1: ( ( rule__CollectionOpCall__ArgumentsAssignment_3_1_1 ) )
            // InternalDOcl.g:5106:2: ( rule__CollectionOpCall__ArgumentsAssignment_3_1_1 )
            {
             before(grammarAccess.getCollectionOpCallAccess().getArgumentsAssignment_3_1_1()); 
            // InternalDOcl.g:5107:2: ( rule__CollectionOpCall__ArgumentsAssignment_3_1_1 )
            // InternalDOcl.g:5107:3: rule__CollectionOpCall__ArgumentsAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__CollectionOpCall__ArgumentsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getCollectionOpCallAccess().getArgumentsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__Group_3_1__1__Impl"


    // $ANTLR start "rule__IterateExp__Group__0"
    // InternalDOcl.g:5116:1: rule__IterateExp__Group__0 : rule__IterateExp__Group__0__Impl rule__IterateExp__Group__1 ;
    public final void rule__IterateExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5120:1: ( rule__IterateExp__Group__0__Impl rule__IterateExp__Group__1 )
            // InternalDOcl.g:5121:2: rule__IterateExp__Group__0__Impl rule__IterateExp__Group__1
            {
            pushFollow(FOLLOW_49);
            rule__IterateExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IterateExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__0"


    // $ANTLR start "rule__IterateExp__Group__0__Impl"
    // InternalDOcl.g:5128:1: rule__IterateExp__Group__0__Impl : ( () ) ;
    public final void rule__IterateExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5132:1: ( ( () ) )
            // InternalDOcl.g:5133:1: ( () )
            {
            // InternalDOcl.g:5133:1: ( () )
            // InternalDOcl.g:5134:2: ()
            {
             before(grammarAccess.getIterateExpAccess().getIterateExpAction_0()); 
            // InternalDOcl.g:5135:2: ()
            // InternalDOcl.g:5135:3: 
            {
            }

             after(grammarAccess.getIterateExpAccess().getIterateExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__0__Impl"


    // $ANTLR start "rule__IterateExp__Group__1"
    // InternalDOcl.g:5143:1: rule__IterateExp__Group__1 : rule__IterateExp__Group__1__Impl rule__IterateExp__Group__2 ;
    public final void rule__IterateExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5147:1: ( rule__IterateExp__Group__1__Impl rule__IterateExp__Group__2 )
            // InternalDOcl.g:5148:2: rule__IterateExp__Group__1__Impl rule__IterateExp__Group__2
            {
            pushFollow(FOLLOW_45);
            rule__IterateExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IterateExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__1"


    // $ANTLR start "rule__IterateExp__Group__1__Impl"
    // InternalDOcl.g:5155:1: rule__IterateExp__Group__1__Impl : ( ( rule__IterateExp__NameAssignment_1 ) ) ;
    public final void rule__IterateExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5159:1: ( ( ( rule__IterateExp__NameAssignment_1 ) ) )
            // InternalDOcl.g:5160:1: ( ( rule__IterateExp__NameAssignment_1 ) )
            {
            // InternalDOcl.g:5160:1: ( ( rule__IterateExp__NameAssignment_1 ) )
            // InternalDOcl.g:5161:2: ( rule__IterateExp__NameAssignment_1 )
            {
             before(grammarAccess.getIterateExpAccess().getNameAssignment_1()); 
            // InternalDOcl.g:5162:2: ( rule__IterateExp__NameAssignment_1 )
            // InternalDOcl.g:5162:3: rule__IterateExp__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IterateExp__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIterateExpAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__1__Impl"


    // $ANTLR start "rule__IterateExp__Group__2"
    // InternalDOcl.g:5170:1: rule__IterateExp__Group__2 : rule__IterateExp__Group__2__Impl rule__IterateExp__Group__3 ;
    public final void rule__IterateExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5174:1: ( rule__IterateExp__Group__2__Impl rule__IterateExp__Group__3 )
            // InternalDOcl.g:5175:2: rule__IterateExp__Group__2__Impl rule__IterateExp__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__IterateExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IterateExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__2"


    // $ANTLR start "rule__IterateExp__Group__2__Impl"
    // InternalDOcl.g:5182:1: rule__IterateExp__Group__2__Impl : ( '(' ) ;
    public final void rule__IterateExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5186:1: ( ( '(' ) )
            // InternalDOcl.g:5187:1: ( '(' )
            {
            // InternalDOcl.g:5187:1: ( '(' )
            // InternalDOcl.g:5188:2: '('
            {
             before(grammarAccess.getIterateExpAccess().getLeftParenthesisKeyword_2()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getIterateExpAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__2__Impl"


    // $ANTLR start "rule__IterateExp__Group__3"
    // InternalDOcl.g:5197:1: rule__IterateExp__Group__3 : rule__IterateExp__Group__3__Impl rule__IterateExp__Group__4 ;
    public final void rule__IterateExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5201:1: ( rule__IterateExp__Group__3__Impl rule__IterateExp__Group__4 )
            // InternalDOcl.g:5202:2: rule__IterateExp__Group__3__Impl rule__IterateExp__Group__4
            {
            pushFollow(FOLLOW_50);
            rule__IterateExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IterateExp__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__3"


    // $ANTLR start "rule__IterateExp__Group__3__Impl"
    // InternalDOcl.g:5209:1: rule__IterateExp__Group__3__Impl : ( ( rule__IterateExp__IteratorsAssignment_3 ) ) ;
    public final void rule__IterateExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5213:1: ( ( ( rule__IterateExp__IteratorsAssignment_3 ) ) )
            // InternalDOcl.g:5214:1: ( ( rule__IterateExp__IteratorsAssignment_3 ) )
            {
            // InternalDOcl.g:5214:1: ( ( rule__IterateExp__IteratorsAssignment_3 ) )
            // InternalDOcl.g:5215:2: ( rule__IterateExp__IteratorsAssignment_3 )
            {
             before(grammarAccess.getIterateExpAccess().getIteratorsAssignment_3()); 
            // InternalDOcl.g:5216:2: ( rule__IterateExp__IteratorsAssignment_3 )
            // InternalDOcl.g:5216:3: rule__IterateExp__IteratorsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__IterateExp__IteratorsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIterateExpAccess().getIteratorsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__3__Impl"


    // $ANTLR start "rule__IterateExp__Group__4"
    // InternalDOcl.g:5224:1: rule__IterateExp__Group__4 : rule__IterateExp__Group__4__Impl rule__IterateExp__Group__5 ;
    public final void rule__IterateExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5228:1: ( rule__IterateExp__Group__4__Impl rule__IterateExp__Group__5 )
            // InternalDOcl.g:5229:2: rule__IterateExp__Group__4__Impl rule__IterateExp__Group__5
            {
            pushFollow(FOLLOW_50);
            rule__IterateExp__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IterateExp__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__4"


    // $ANTLR start "rule__IterateExp__Group__4__Impl"
    // InternalDOcl.g:5236:1: rule__IterateExp__Group__4__Impl : ( ( rule__IterateExp__Group_4__0 )* ) ;
    public final void rule__IterateExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5240:1: ( ( ( rule__IterateExp__Group_4__0 )* ) )
            // InternalDOcl.g:5241:1: ( ( rule__IterateExp__Group_4__0 )* )
            {
            // InternalDOcl.g:5241:1: ( ( rule__IterateExp__Group_4__0 )* )
            // InternalDOcl.g:5242:2: ( rule__IterateExp__Group_4__0 )*
            {
             before(grammarAccess.getIterateExpAccess().getGroup_4()); 
            // InternalDOcl.g:5243:2: ( rule__IterateExp__Group_4__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==74) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDOcl.g:5243:3: rule__IterateExp__Group_4__0
            	    {
            	    pushFollow(FOLLOW_48);
            	    rule__IterateExp__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getIterateExpAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__4__Impl"


    // $ANTLR start "rule__IterateExp__Group__5"
    // InternalDOcl.g:5251:1: rule__IterateExp__Group__5 : rule__IterateExp__Group__5__Impl rule__IterateExp__Group__6 ;
    public final void rule__IterateExp__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5255:1: ( rule__IterateExp__Group__5__Impl rule__IterateExp__Group__6 )
            // InternalDOcl.g:5256:2: rule__IterateExp__Group__5__Impl rule__IterateExp__Group__6
            {
            pushFollow(FOLLOW_5);
            rule__IterateExp__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IterateExp__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__5"


    // $ANTLR start "rule__IterateExp__Group__5__Impl"
    // InternalDOcl.g:5263:1: rule__IterateExp__Group__5__Impl : ( ';' ) ;
    public final void rule__IterateExp__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5267:1: ( ( ';' ) )
            // InternalDOcl.g:5268:1: ( ';' )
            {
            // InternalDOcl.g:5268:1: ( ';' )
            // InternalDOcl.g:5269:2: ';'
            {
             before(grammarAccess.getIterateExpAccess().getSemicolonKeyword_5()); 
            match(input,70,FOLLOW_2); 
             after(grammarAccess.getIterateExpAccess().getSemicolonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__5__Impl"


    // $ANTLR start "rule__IterateExp__Group__6"
    // InternalDOcl.g:5278:1: rule__IterateExp__Group__6 : rule__IterateExp__Group__6__Impl rule__IterateExp__Group__7 ;
    public final void rule__IterateExp__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5282:1: ( rule__IterateExp__Group__6__Impl rule__IterateExp__Group__7 )
            // InternalDOcl.g:5283:2: rule__IterateExp__Group__6__Impl rule__IterateExp__Group__7
            {
            pushFollow(FOLLOW_51);
            rule__IterateExp__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IterateExp__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__6"


    // $ANTLR start "rule__IterateExp__Group__6__Impl"
    // InternalDOcl.g:5290:1: rule__IterateExp__Group__6__Impl : ( ( rule__IterateExp__ResultAssignment_6 ) ) ;
    public final void rule__IterateExp__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5294:1: ( ( ( rule__IterateExp__ResultAssignment_6 ) ) )
            // InternalDOcl.g:5295:1: ( ( rule__IterateExp__ResultAssignment_6 ) )
            {
            // InternalDOcl.g:5295:1: ( ( rule__IterateExp__ResultAssignment_6 ) )
            // InternalDOcl.g:5296:2: ( rule__IterateExp__ResultAssignment_6 )
            {
             before(grammarAccess.getIterateExpAccess().getResultAssignment_6()); 
            // InternalDOcl.g:5297:2: ( rule__IterateExp__ResultAssignment_6 )
            // InternalDOcl.g:5297:3: rule__IterateExp__ResultAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__IterateExp__ResultAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getIterateExpAccess().getResultAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__6__Impl"


    // $ANTLR start "rule__IterateExp__Group__7"
    // InternalDOcl.g:5305:1: rule__IterateExp__Group__7 : rule__IterateExp__Group__7__Impl rule__IterateExp__Group__8 ;
    public final void rule__IterateExp__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5309:1: ( rule__IterateExp__Group__7__Impl rule__IterateExp__Group__8 )
            // InternalDOcl.g:5310:2: rule__IterateExp__Group__7__Impl rule__IterateExp__Group__8
            {
            pushFollow(FOLLOW_22);
            rule__IterateExp__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IterateExp__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__7"


    // $ANTLR start "rule__IterateExp__Group__7__Impl"
    // InternalDOcl.g:5317:1: rule__IterateExp__Group__7__Impl : ( '|' ) ;
    public final void rule__IterateExp__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5321:1: ( ( '|' ) )
            // InternalDOcl.g:5322:1: ( '|' )
            {
            // InternalDOcl.g:5322:1: ( '|' )
            // InternalDOcl.g:5323:2: '|'
            {
             before(grammarAccess.getIterateExpAccess().getVerticalLineKeyword_7()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getIterateExpAccess().getVerticalLineKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__7__Impl"


    // $ANTLR start "rule__IterateExp__Group__8"
    // InternalDOcl.g:5332:1: rule__IterateExp__Group__8 : rule__IterateExp__Group__8__Impl rule__IterateExp__Group__9 ;
    public final void rule__IterateExp__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5336:1: ( rule__IterateExp__Group__8__Impl rule__IterateExp__Group__9 )
            // InternalDOcl.g:5337:2: rule__IterateExp__Group__8__Impl rule__IterateExp__Group__9
            {
            pushFollow(FOLLOW_52);
            rule__IterateExp__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IterateExp__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__8"


    // $ANTLR start "rule__IterateExp__Group__8__Impl"
    // InternalDOcl.g:5344:1: rule__IterateExp__Group__8__Impl : ( ( rule__IterateExp__BodyAssignment_8 ) ) ;
    public final void rule__IterateExp__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5348:1: ( ( ( rule__IterateExp__BodyAssignment_8 ) ) )
            // InternalDOcl.g:5349:1: ( ( rule__IterateExp__BodyAssignment_8 ) )
            {
            // InternalDOcl.g:5349:1: ( ( rule__IterateExp__BodyAssignment_8 ) )
            // InternalDOcl.g:5350:2: ( rule__IterateExp__BodyAssignment_8 )
            {
             before(grammarAccess.getIterateExpAccess().getBodyAssignment_8()); 
            // InternalDOcl.g:5351:2: ( rule__IterateExp__BodyAssignment_8 )
            // InternalDOcl.g:5351:3: rule__IterateExp__BodyAssignment_8
            {
            pushFollow(FOLLOW_2);
            rule__IterateExp__BodyAssignment_8();

            state._fsp--;


            }

             after(grammarAccess.getIterateExpAccess().getBodyAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__8__Impl"


    // $ANTLR start "rule__IterateExp__Group__9"
    // InternalDOcl.g:5359:1: rule__IterateExp__Group__9 : rule__IterateExp__Group__9__Impl ;
    public final void rule__IterateExp__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5363:1: ( rule__IterateExp__Group__9__Impl )
            // InternalDOcl.g:5364:2: rule__IterateExp__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IterateExp__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__9"


    // $ANTLR start "rule__IterateExp__Group__9__Impl"
    // InternalDOcl.g:5370:1: rule__IterateExp__Group__9__Impl : ( ')' ) ;
    public final void rule__IterateExp__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5374:1: ( ( ')' ) )
            // InternalDOcl.g:5375:1: ( ')' )
            {
            // InternalDOcl.g:5375:1: ( ')' )
            // InternalDOcl.g:5376:2: ')'
            {
             before(grammarAccess.getIterateExpAccess().getRightParenthesisKeyword_9()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getIterateExpAccess().getRightParenthesisKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group__9__Impl"


    // $ANTLR start "rule__IterateExp__Group_4__0"
    // InternalDOcl.g:5386:1: rule__IterateExp__Group_4__0 : rule__IterateExp__Group_4__0__Impl rule__IterateExp__Group_4__1 ;
    public final void rule__IterateExp__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5390:1: ( rule__IterateExp__Group_4__0__Impl rule__IterateExp__Group_4__1 )
            // InternalDOcl.g:5391:2: rule__IterateExp__Group_4__0__Impl rule__IterateExp__Group_4__1
            {
            pushFollow(FOLLOW_5);
            rule__IterateExp__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IterateExp__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group_4__0"


    // $ANTLR start "rule__IterateExp__Group_4__0__Impl"
    // InternalDOcl.g:5398:1: rule__IterateExp__Group_4__0__Impl : ( ',' ) ;
    public final void rule__IterateExp__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5402:1: ( ( ',' ) )
            // InternalDOcl.g:5403:1: ( ',' )
            {
            // InternalDOcl.g:5403:1: ( ',' )
            // InternalDOcl.g:5404:2: ','
            {
             before(grammarAccess.getIterateExpAccess().getCommaKeyword_4_0()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getIterateExpAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group_4__0__Impl"


    // $ANTLR start "rule__IterateExp__Group_4__1"
    // InternalDOcl.g:5413:1: rule__IterateExp__Group_4__1 : rule__IterateExp__Group_4__1__Impl ;
    public final void rule__IterateExp__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5417:1: ( rule__IterateExp__Group_4__1__Impl )
            // InternalDOcl.g:5418:2: rule__IterateExp__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IterateExp__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group_4__1"


    // $ANTLR start "rule__IterateExp__Group_4__1__Impl"
    // InternalDOcl.g:5424:1: rule__IterateExp__Group_4__1__Impl : ( ( rule__IterateExp__IteratorsAssignment_4_1 ) ) ;
    public final void rule__IterateExp__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5428:1: ( ( ( rule__IterateExp__IteratorsAssignment_4_1 ) ) )
            // InternalDOcl.g:5429:1: ( ( rule__IterateExp__IteratorsAssignment_4_1 ) )
            {
            // InternalDOcl.g:5429:1: ( ( rule__IterateExp__IteratorsAssignment_4_1 ) )
            // InternalDOcl.g:5430:2: ( rule__IterateExp__IteratorsAssignment_4_1 )
            {
             before(grammarAccess.getIterateExpAccess().getIteratorsAssignment_4_1()); 
            // InternalDOcl.g:5431:2: ( rule__IterateExp__IteratorsAssignment_4_1 )
            // InternalDOcl.g:5431:3: rule__IterateExp__IteratorsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__IterateExp__IteratorsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getIterateExpAccess().getIteratorsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__Group_4__1__Impl"


    // $ANTLR start "rule__Iterator__Group__0"
    // InternalDOcl.g:5440:1: rule__Iterator__Group__0 : rule__Iterator__Group__0__Impl rule__Iterator__Group__1 ;
    public final void rule__Iterator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5444:1: ( rule__Iterator__Group__0__Impl rule__Iterator__Group__1 )
            // InternalDOcl.g:5445:2: rule__Iterator__Group__0__Impl rule__Iterator__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__Iterator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Iterator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iterator__Group__0"


    // $ANTLR start "rule__Iterator__Group__0__Impl"
    // InternalDOcl.g:5452:1: rule__Iterator__Group__0__Impl : ( ( rule__Iterator__NameAssignment_0 ) ) ;
    public final void rule__Iterator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5456:1: ( ( ( rule__Iterator__NameAssignment_0 ) ) )
            // InternalDOcl.g:5457:1: ( ( rule__Iterator__NameAssignment_0 ) )
            {
            // InternalDOcl.g:5457:1: ( ( rule__Iterator__NameAssignment_0 ) )
            // InternalDOcl.g:5458:2: ( rule__Iterator__NameAssignment_0 )
            {
             before(grammarAccess.getIteratorAccess().getNameAssignment_0()); 
            // InternalDOcl.g:5459:2: ( rule__Iterator__NameAssignment_0 )
            // InternalDOcl.g:5459:3: rule__Iterator__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Iterator__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getIteratorAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iterator__Group__0__Impl"


    // $ANTLR start "rule__Iterator__Group__1"
    // InternalDOcl.g:5467:1: rule__Iterator__Group__1 : rule__Iterator__Group__1__Impl ;
    public final void rule__Iterator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5471:1: ( rule__Iterator__Group__1__Impl )
            // InternalDOcl.g:5472:2: rule__Iterator__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Iterator__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iterator__Group__1"


    // $ANTLR start "rule__Iterator__Group__1__Impl"
    // InternalDOcl.g:5478:1: rule__Iterator__Group__1__Impl : ( ( rule__Iterator__Group_1__0 )? ) ;
    public final void rule__Iterator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5482:1: ( ( ( rule__Iterator__Group_1__0 )? ) )
            // InternalDOcl.g:5483:1: ( ( rule__Iterator__Group_1__0 )? )
            {
            // InternalDOcl.g:5483:1: ( ( rule__Iterator__Group_1__0 )? )
            // InternalDOcl.g:5484:2: ( rule__Iterator__Group_1__0 )?
            {
             before(grammarAccess.getIteratorAccess().getGroup_1()); 
            // InternalDOcl.g:5485:2: ( rule__Iterator__Group_1__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==67) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDOcl.g:5485:3: rule__Iterator__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Iterator__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIteratorAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iterator__Group__1__Impl"


    // $ANTLR start "rule__Iterator__Group_1__0"
    // InternalDOcl.g:5494:1: rule__Iterator__Group_1__0 : rule__Iterator__Group_1__0__Impl rule__Iterator__Group_1__1 ;
    public final void rule__Iterator__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5498:1: ( rule__Iterator__Group_1__0__Impl rule__Iterator__Group_1__1 )
            // InternalDOcl.g:5499:2: rule__Iterator__Group_1__0__Impl rule__Iterator__Group_1__1
            {
            pushFollow(FOLLOW_53);
            rule__Iterator__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Iterator__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iterator__Group_1__0"


    // $ANTLR start "rule__Iterator__Group_1__0__Impl"
    // InternalDOcl.g:5506:1: rule__Iterator__Group_1__0__Impl : ( ':' ) ;
    public final void rule__Iterator__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5510:1: ( ( ':' ) )
            // InternalDOcl.g:5511:1: ( ':' )
            {
            // InternalDOcl.g:5511:1: ( ':' )
            // InternalDOcl.g:5512:2: ':'
            {
             before(grammarAccess.getIteratorAccess().getColonKeyword_1_0()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getIteratorAccess().getColonKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iterator__Group_1__0__Impl"


    // $ANTLR start "rule__Iterator__Group_1__1"
    // InternalDOcl.g:5521:1: rule__Iterator__Group_1__1 : rule__Iterator__Group_1__1__Impl ;
    public final void rule__Iterator__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5525:1: ( rule__Iterator__Group_1__1__Impl )
            // InternalDOcl.g:5526:2: rule__Iterator__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Iterator__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iterator__Group_1__1"


    // $ANTLR start "rule__Iterator__Group_1__1__Impl"
    // InternalDOcl.g:5532:1: rule__Iterator__Group_1__1__Impl : ( ( rule__Iterator__TypeAssignment_1_1 ) ) ;
    public final void rule__Iterator__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5536:1: ( ( ( rule__Iterator__TypeAssignment_1_1 ) ) )
            // InternalDOcl.g:5537:1: ( ( rule__Iterator__TypeAssignment_1_1 ) )
            {
            // InternalDOcl.g:5537:1: ( ( rule__Iterator__TypeAssignment_1_1 ) )
            // InternalDOcl.g:5538:2: ( rule__Iterator__TypeAssignment_1_1 )
            {
             before(grammarAccess.getIteratorAccess().getTypeAssignment_1_1()); 
            // InternalDOcl.g:5539:2: ( rule__Iterator__TypeAssignment_1_1 )
            // InternalDOcl.g:5539:3: rule__Iterator__TypeAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Iterator__TypeAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getIteratorAccess().getTypeAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iterator__Group_1__1__Impl"


    // $ANTLR start "rule__IteratorExp__Group__0"
    // InternalDOcl.g:5548:1: rule__IteratorExp__Group__0 : rule__IteratorExp__Group__0__Impl rule__IteratorExp__Group__1 ;
    public final void rule__IteratorExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5552:1: ( rule__IteratorExp__Group__0__Impl rule__IteratorExp__Group__1 )
            // InternalDOcl.g:5553:2: rule__IteratorExp__Group__0__Impl rule__IteratorExp__Group__1
            {
            pushFollow(FOLLOW_54);
            rule__IteratorExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IteratorExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__0"


    // $ANTLR start "rule__IteratorExp__Group__0__Impl"
    // InternalDOcl.g:5560:1: rule__IteratorExp__Group__0__Impl : ( () ) ;
    public final void rule__IteratorExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5564:1: ( ( () ) )
            // InternalDOcl.g:5565:1: ( () )
            {
            // InternalDOcl.g:5565:1: ( () )
            // InternalDOcl.g:5566:2: ()
            {
             before(grammarAccess.getIteratorExpAccess().getIteratorExpAction_0()); 
            // InternalDOcl.g:5567:2: ()
            // InternalDOcl.g:5567:3: 
            {
            }

             after(grammarAccess.getIteratorExpAccess().getIteratorExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__0__Impl"


    // $ANTLR start "rule__IteratorExp__Group__1"
    // InternalDOcl.g:5575:1: rule__IteratorExp__Group__1 : rule__IteratorExp__Group__1__Impl rule__IteratorExp__Group__2 ;
    public final void rule__IteratorExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5579:1: ( rule__IteratorExp__Group__1__Impl rule__IteratorExp__Group__2 )
            // InternalDOcl.g:5580:2: rule__IteratorExp__Group__1__Impl rule__IteratorExp__Group__2
            {
            pushFollow(FOLLOW_45);
            rule__IteratorExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IteratorExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__1"


    // $ANTLR start "rule__IteratorExp__Group__1__Impl"
    // InternalDOcl.g:5587:1: rule__IteratorExp__Group__1__Impl : ( ( rule__IteratorExp__NameAssignment_1 ) ) ;
    public final void rule__IteratorExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5591:1: ( ( ( rule__IteratorExp__NameAssignment_1 ) ) )
            // InternalDOcl.g:5592:1: ( ( rule__IteratorExp__NameAssignment_1 ) )
            {
            // InternalDOcl.g:5592:1: ( ( rule__IteratorExp__NameAssignment_1 ) )
            // InternalDOcl.g:5593:2: ( rule__IteratorExp__NameAssignment_1 )
            {
             before(grammarAccess.getIteratorExpAccess().getNameAssignment_1()); 
            // InternalDOcl.g:5594:2: ( rule__IteratorExp__NameAssignment_1 )
            // InternalDOcl.g:5594:3: rule__IteratorExp__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IteratorExp__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIteratorExpAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__1__Impl"


    // $ANTLR start "rule__IteratorExp__Group__2"
    // InternalDOcl.g:5602:1: rule__IteratorExp__Group__2 : rule__IteratorExp__Group__2__Impl rule__IteratorExp__Group__3 ;
    public final void rule__IteratorExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5606:1: ( rule__IteratorExp__Group__2__Impl rule__IteratorExp__Group__3 )
            // InternalDOcl.g:5607:2: rule__IteratorExp__Group__2__Impl rule__IteratorExp__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__IteratorExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IteratorExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__2"


    // $ANTLR start "rule__IteratorExp__Group__2__Impl"
    // InternalDOcl.g:5614:1: rule__IteratorExp__Group__2__Impl : ( '(' ) ;
    public final void rule__IteratorExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5618:1: ( ( '(' ) )
            // InternalDOcl.g:5619:1: ( '(' )
            {
            // InternalDOcl.g:5619:1: ( '(' )
            // InternalDOcl.g:5620:2: '('
            {
             before(grammarAccess.getIteratorExpAccess().getLeftParenthesisKeyword_2()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getIteratorExpAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__2__Impl"


    // $ANTLR start "rule__IteratorExp__Group__3"
    // InternalDOcl.g:5629:1: rule__IteratorExp__Group__3 : rule__IteratorExp__Group__3__Impl rule__IteratorExp__Group__4 ;
    public final void rule__IteratorExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5633:1: ( rule__IteratorExp__Group__3__Impl rule__IteratorExp__Group__4 )
            // InternalDOcl.g:5634:2: rule__IteratorExp__Group__3__Impl rule__IteratorExp__Group__4
            {
            pushFollow(FOLLOW_55);
            rule__IteratorExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IteratorExp__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__3"


    // $ANTLR start "rule__IteratorExp__Group__3__Impl"
    // InternalDOcl.g:5641:1: rule__IteratorExp__Group__3__Impl : ( ( rule__IteratorExp__IteratorsAssignment_3 ) ) ;
    public final void rule__IteratorExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5645:1: ( ( ( rule__IteratorExp__IteratorsAssignment_3 ) ) )
            // InternalDOcl.g:5646:1: ( ( rule__IteratorExp__IteratorsAssignment_3 ) )
            {
            // InternalDOcl.g:5646:1: ( ( rule__IteratorExp__IteratorsAssignment_3 ) )
            // InternalDOcl.g:5647:2: ( rule__IteratorExp__IteratorsAssignment_3 )
            {
             before(grammarAccess.getIteratorExpAccess().getIteratorsAssignment_3()); 
            // InternalDOcl.g:5648:2: ( rule__IteratorExp__IteratorsAssignment_3 )
            // InternalDOcl.g:5648:3: rule__IteratorExp__IteratorsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__IteratorExp__IteratorsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIteratorExpAccess().getIteratorsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__3__Impl"


    // $ANTLR start "rule__IteratorExp__Group__4"
    // InternalDOcl.g:5656:1: rule__IteratorExp__Group__4 : rule__IteratorExp__Group__4__Impl rule__IteratorExp__Group__5 ;
    public final void rule__IteratorExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5660:1: ( rule__IteratorExp__Group__4__Impl rule__IteratorExp__Group__5 )
            // InternalDOcl.g:5661:2: rule__IteratorExp__Group__4__Impl rule__IteratorExp__Group__5
            {
            pushFollow(FOLLOW_55);
            rule__IteratorExp__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IteratorExp__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__4"


    // $ANTLR start "rule__IteratorExp__Group__4__Impl"
    // InternalDOcl.g:5668:1: rule__IteratorExp__Group__4__Impl : ( ( rule__IteratorExp__Group_4__0 )* ) ;
    public final void rule__IteratorExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5672:1: ( ( ( rule__IteratorExp__Group_4__0 )* ) )
            // InternalDOcl.g:5673:1: ( ( rule__IteratorExp__Group_4__0 )* )
            {
            // InternalDOcl.g:5673:1: ( ( rule__IteratorExp__Group_4__0 )* )
            // InternalDOcl.g:5674:2: ( rule__IteratorExp__Group_4__0 )*
            {
             before(grammarAccess.getIteratorExpAccess().getGroup_4()); 
            // InternalDOcl.g:5675:2: ( rule__IteratorExp__Group_4__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==74) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalDOcl.g:5675:3: rule__IteratorExp__Group_4__0
            	    {
            	    pushFollow(FOLLOW_48);
            	    rule__IteratorExp__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getIteratorExpAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__4__Impl"


    // $ANTLR start "rule__IteratorExp__Group__5"
    // InternalDOcl.g:5683:1: rule__IteratorExp__Group__5 : rule__IteratorExp__Group__5__Impl rule__IteratorExp__Group__6 ;
    public final void rule__IteratorExp__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5687:1: ( rule__IteratorExp__Group__5__Impl rule__IteratorExp__Group__6 )
            // InternalDOcl.g:5688:2: rule__IteratorExp__Group__5__Impl rule__IteratorExp__Group__6
            {
            pushFollow(FOLLOW_22);
            rule__IteratorExp__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IteratorExp__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__5"


    // $ANTLR start "rule__IteratorExp__Group__5__Impl"
    // InternalDOcl.g:5695:1: rule__IteratorExp__Group__5__Impl : ( '|' ) ;
    public final void rule__IteratorExp__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5699:1: ( ( '|' ) )
            // InternalDOcl.g:5700:1: ( '|' )
            {
            // InternalDOcl.g:5700:1: ( '|' )
            // InternalDOcl.g:5701:2: '|'
            {
             before(grammarAccess.getIteratorExpAccess().getVerticalLineKeyword_5()); 
            match(input,75,FOLLOW_2); 
             after(grammarAccess.getIteratorExpAccess().getVerticalLineKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__5__Impl"


    // $ANTLR start "rule__IteratorExp__Group__6"
    // InternalDOcl.g:5710:1: rule__IteratorExp__Group__6 : rule__IteratorExp__Group__6__Impl rule__IteratorExp__Group__7 ;
    public final void rule__IteratorExp__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5714:1: ( rule__IteratorExp__Group__6__Impl rule__IteratorExp__Group__7 )
            // InternalDOcl.g:5715:2: rule__IteratorExp__Group__6__Impl rule__IteratorExp__Group__7
            {
            pushFollow(FOLLOW_52);
            rule__IteratorExp__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IteratorExp__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__6"


    // $ANTLR start "rule__IteratorExp__Group__6__Impl"
    // InternalDOcl.g:5722:1: rule__IteratorExp__Group__6__Impl : ( ( rule__IteratorExp__BodyAssignment_6 ) ) ;
    public final void rule__IteratorExp__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5726:1: ( ( ( rule__IteratorExp__BodyAssignment_6 ) ) )
            // InternalDOcl.g:5727:1: ( ( rule__IteratorExp__BodyAssignment_6 ) )
            {
            // InternalDOcl.g:5727:1: ( ( rule__IteratorExp__BodyAssignment_6 ) )
            // InternalDOcl.g:5728:2: ( rule__IteratorExp__BodyAssignment_6 )
            {
             before(grammarAccess.getIteratorExpAccess().getBodyAssignment_6()); 
            // InternalDOcl.g:5729:2: ( rule__IteratorExp__BodyAssignment_6 )
            // InternalDOcl.g:5729:3: rule__IteratorExp__BodyAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__IteratorExp__BodyAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getIteratorExpAccess().getBodyAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__6__Impl"


    // $ANTLR start "rule__IteratorExp__Group__7"
    // InternalDOcl.g:5737:1: rule__IteratorExp__Group__7 : rule__IteratorExp__Group__7__Impl ;
    public final void rule__IteratorExp__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5741:1: ( rule__IteratorExp__Group__7__Impl )
            // InternalDOcl.g:5742:2: rule__IteratorExp__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IteratorExp__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__7"


    // $ANTLR start "rule__IteratorExp__Group__7__Impl"
    // InternalDOcl.g:5748:1: rule__IteratorExp__Group__7__Impl : ( ')' ) ;
    public final void rule__IteratorExp__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5752:1: ( ( ')' ) )
            // InternalDOcl.g:5753:1: ( ')' )
            {
            // InternalDOcl.g:5753:1: ( ')' )
            // InternalDOcl.g:5754:2: ')'
            {
             before(grammarAccess.getIteratorExpAccess().getRightParenthesisKeyword_7()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getIteratorExpAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group__7__Impl"


    // $ANTLR start "rule__IteratorExp__Group_4__0"
    // InternalDOcl.g:5764:1: rule__IteratorExp__Group_4__0 : rule__IteratorExp__Group_4__0__Impl rule__IteratorExp__Group_4__1 ;
    public final void rule__IteratorExp__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5768:1: ( rule__IteratorExp__Group_4__0__Impl rule__IteratorExp__Group_4__1 )
            // InternalDOcl.g:5769:2: rule__IteratorExp__Group_4__0__Impl rule__IteratorExp__Group_4__1
            {
            pushFollow(FOLLOW_5);
            rule__IteratorExp__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IteratorExp__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group_4__0"


    // $ANTLR start "rule__IteratorExp__Group_4__0__Impl"
    // InternalDOcl.g:5776:1: rule__IteratorExp__Group_4__0__Impl : ( ',' ) ;
    public final void rule__IteratorExp__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5780:1: ( ( ',' ) )
            // InternalDOcl.g:5781:1: ( ',' )
            {
            // InternalDOcl.g:5781:1: ( ',' )
            // InternalDOcl.g:5782:2: ','
            {
             before(grammarAccess.getIteratorExpAccess().getCommaKeyword_4_0()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getIteratorExpAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group_4__0__Impl"


    // $ANTLR start "rule__IteratorExp__Group_4__1"
    // InternalDOcl.g:5791:1: rule__IteratorExp__Group_4__1 : rule__IteratorExp__Group_4__1__Impl ;
    public final void rule__IteratorExp__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5795:1: ( rule__IteratorExp__Group_4__1__Impl )
            // InternalDOcl.g:5796:2: rule__IteratorExp__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IteratorExp__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group_4__1"


    // $ANTLR start "rule__IteratorExp__Group_4__1__Impl"
    // InternalDOcl.g:5802:1: rule__IteratorExp__Group_4__1__Impl : ( ( rule__IteratorExp__IteratorsAssignment_4_1 ) ) ;
    public final void rule__IteratorExp__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5806:1: ( ( ( rule__IteratorExp__IteratorsAssignment_4_1 ) ) )
            // InternalDOcl.g:5807:1: ( ( rule__IteratorExp__IteratorsAssignment_4_1 ) )
            {
            // InternalDOcl.g:5807:1: ( ( rule__IteratorExp__IteratorsAssignment_4_1 ) )
            // InternalDOcl.g:5808:2: ( rule__IteratorExp__IteratorsAssignment_4_1 )
            {
             before(grammarAccess.getIteratorExpAccess().getIteratorsAssignment_4_1()); 
            // InternalDOcl.g:5809:2: ( rule__IteratorExp__IteratorsAssignment_4_1 )
            // InternalDOcl.g:5809:3: rule__IteratorExp__IteratorsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__IteratorExp__IteratorsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getIteratorExpAccess().getIteratorsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__Group_4__1__Impl"


    // $ANTLR start "rule__NavigationOrAttributeCall__Group__0"
    // InternalDOcl.g:5818:1: rule__NavigationOrAttributeCall__Group__0 : rule__NavigationOrAttributeCall__Group__0__Impl rule__NavigationOrAttributeCall__Group__1 ;
    public final void rule__NavigationOrAttributeCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5822:1: ( rule__NavigationOrAttributeCall__Group__0__Impl rule__NavigationOrAttributeCall__Group__1 )
            // InternalDOcl.g:5823:2: rule__NavigationOrAttributeCall__Group__0__Impl rule__NavigationOrAttributeCall__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__NavigationOrAttributeCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NavigationOrAttributeCall__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationOrAttributeCall__Group__0"


    // $ANTLR start "rule__NavigationOrAttributeCall__Group__0__Impl"
    // InternalDOcl.g:5830:1: rule__NavigationOrAttributeCall__Group__0__Impl : ( () ) ;
    public final void rule__NavigationOrAttributeCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5834:1: ( ( () ) )
            // InternalDOcl.g:5835:1: ( () )
            {
            // InternalDOcl.g:5835:1: ( () )
            // InternalDOcl.g:5836:2: ()
            {
             before(grammarAccess.getNavigationOrAttributeCallAccess().getNavigationOrAttributeCallAction_0()); 
            // InternalDOcl.g:5837:2: ()
            // InternalDOcl.g:5837:3: 
            {
            }

             after(grammarAccess.getNavigationOrAttributeCallAccess().getNavigationOrAttributeCallAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationOrAttributeCall__Group__0__Impl"


    // $ANTLR start "rule__NavigationOrAttributeCall__Group__1"
    // InternalDOcl.g:5845:1: rule__NavigationOrAttributeCall__Group__1 : rule__NavigationOrAttributeCall__Group__1__Impl ;
    public final void rule__NavigationOrAttributeCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5849:1: ( rule__NavigationOrAttributeCall__Group__1__Impl )
            // InternalDOcl.g:5850:2: rule__NavigationOrAttributeCall__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NavigationOrAttributeCall__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationOrAttributeCall__Group__1"


    // $ANTLR start "rule__NavigationOrAttributeCall__Group__1__Impl"
    // InternalDOcl.g:5856:1: rule__NavigationOrAttributeCall__Group__1__Impl : ( ( rule__NavigationOrAttributeCall__FeatureAssignment_1 ) ) ;
    public final void rule__NavigationOrAttributeCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5860:1: ( ( ( rule__NavigationOrAttributeCall__FeatureAssignment_1 ) ) )
            // InternalDOcl.g:5861:1: ( ( rule__NavigationOrAttributeCall__FeatureAssignment_1 ) )
            {
            // InternalDOcl.g:5861:1: ( ( rule__NavigationOrAttributeCall__FeatureAssignment_1 ) )
            // InternalDOcl.g:5862:2: ( rule__NavigationOrAttributeCall__FeatureAssignment_1 )
            {
             before(grammarAccess.getNavigationOrAttributeCallAccess().getFeatureAssignment_1()); 
            // InternalDOcl.g:5863:2: ( rule__NavigationOrAttributeCall__FeatureAssignment_1 )
            // InternalDOcl.g:5863:3: rule__NavigationOrAttributeCall__FeatureAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__NavigationOrAttributeCall__FeatureAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNavigationOrAttributeCallAccess().getFeatureAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationOrAttributeCall__Group__1__Impl"


    // $ANTLR start "rule__OperationCall__Group__0"
    // InternalDOcl.g:5872:1: rule__OperationCall__Group__0 : rule__OperationCall__Group__0__Impl rule__OperationCall__Group__1 ;
    public final void rule__OperationCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5876:1: ( rule__OperationCall__Group__0__Impl rule__OperationCall__Group__1 )
            // InternalDOcl.g:5877:2: rule__OperationCall__Group__0__Impl rule__OperationCall__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__OperationCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationCall__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group__0"


    // $ANTLR start "rule__OperationCall__Group__0__Impl"
    // InternalDOcl.g:5884:1: rule__OperationCall__Group__0__Impl : ( () ) ;
    public final void rule__OperationCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5888:1: ( ( () ) )
            // InternalDOcl.g:5889:1: ( () )
            {
            // InternalDOcl.g:5889:1: ( () )
            // InternalDOcl.g:5890:2: ()
            {
             before(grammarAccess.getOperationCallAccess().getOperationCallAction_0()); 
            // InternalDOcl.g:5891:2: ()
            // InternalDOcl.g:5891:3: 
            {
            }

             after(grammarAccess.getOperationCallAccess().getOperationCallAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group__0__Impl"


    // $ANTLR start "rule__OperationCall__Group__1"
    // InternalDOcl.g:5899:1: rule__OperationCall__Group__1 : rule__OperationCall__Group__1__Impl rule__OperationCall__Group__2 ;
    public final void rule__OperationCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5903:1: ( rule__OperationCall__Group__1__Impl rule__OperationCall__Group__2 )
            // InternalDOcl.g:5904:2: rule__OperationCall__Group__1__Impl rule__OperationCall__Group__2
            {
            pushFollow(FOLLOW_45);
            rule__OperationCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationCall__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group__1"


    // $ANTLR start "rule__OperationCall__Group__1__Impl"
    // InternalDOcl.g:5911:1: rule__OperationCall__Group__1__Impl : ( ( rule__OperationCall__NameAssignment_1 ) ) ;
    public final void rule__OperationCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5915:1: ( ( ( rule__OperationCall__NameAssignment_1 ) ) )
            // InternalDOcl.g:5916:1: ( ( rule__OperationCall__NameAssignment_1 ) )
            {
            // InternalDOcl.g:5916:1: ( ( rule__OperationCall__NameAssignment_1 ) )
            // InternalDOcl.g:5917:2: ( rule__OperationCall__NameAssignment_1 )
            {
             before(grammarAccess.getOperationCallAccess().getNameAssignment_1()); 
            // InternalDOcl.g:5918:2: ( rule__OperationCall__NameAssignment_1 )
            // InternalDOcl.g:5918:3: rule__OperationCall__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOperationCallAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group__1__Impl"


    // $ANTLR start "rule__OperationCall__Group__2"
    // InternalDOcl.g:5926:1: rule__OperationCall__Group__2 : rule__OperationCall__Group__2__Impl rule__OperationCall__Group__3 ;
    public final void rule__OperationCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5930:1: ( rule__OperationCall__Group__2__Impl rule__OperationCall__Group__3 )
            // InternalDOcl.g:5931:2: rule__OperationCall__Group__2__Impl rule__OperationCall__Group__3
            {
            pushFollow(FOLLOW_46);
            rule__OperationCall__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationCall__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group__2"


    // $ANTLR start "rule__OperationCall__Group__2__Impl"
    // InternalDOcl.g:5938:1: rule__OperationCall__Group__2__Impl : ( '(' ) ;
    public final void rule__OperationCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5942:1: ( ( '(' ) )
            // InternalDOcl.g:5943:1: ( '(' )
            {
            // InternalDOcl.g:5943:1: ( '(' )
            // InternalDOcl.g:5944:2: '('
            {
             before(grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_2()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group__2__Impl"


    // $ANTLR start "rule__OperationCall__Group__3"
    // InternalDOcl.g:5953:1: rule__OperationCall__Group__3 : rule__OperationCall__Group__3__Impl rule__OperationCall__Group__4 ;
    public final void rule__OperationCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5957:1: ( rule__OperationCall__Group__3__Impl rule__OperationCall__Group__4 )
            // InternalDOcl.g:5958:2: rule__OperationCall__Group__3__Impl rule__OperationCall__Group__4
            {
            pushFollow(FOLLOW_46);
            rule__OperationCall__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationCall__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group__3"


    // $ANTLR start "rule__OperationCall__Group__3__Impl"
    // InternalDOcl.g:5965:1: rule__OperationCall__Group__3__Impl : ( ( rule__OperationCall__Group_3__0 )? ) ;
    public final void rule__OperationCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5969:1: ( ( ( rule__OperationCall__Group_3__0 )? ) )
            // InternalDOcl.g:5970:1: ( ( rule__OperationCall__Group_3__0 )? )
            {
            // InternalDOcl.g:5970:1: ( ( rule__OperationCall__Group_3__0 )? )
            // InternalDOcl.g:5971:2: ( rule__OperationCall__Group_3__0 )?
            {
             before(grammarAccess.getOperationCallAccess().getGroup_3()); 
            // InternalDOcl.g:5972:2: ( rule__OperationCall__Group_3__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_INT)||LA38_0==RULE_STRING||(LA38_0>=17 && LA38_0<=18)||(LA38_0>=21 && LA38_0<=52)||LA38_0==60||LA38_0==72||(LA38_0>=79 && LA38_0<=80)||(LA38_0>=84 && LA38_0<=85)||(LA38_0>=87 && LA38_0<=91)||LA38_0==93) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalDOcl.g:5972:3: rule__OperationCall__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__OperationCall__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOperationCallAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group__3__Impl"


    // $ANTLR start "rule__OperationCall__Group__4"
    // InternalDOcl.g:5980:1: rule__OperationCall__Group__4 : rule__OperationCall__Group__4__Impl ;
    public final void rule__OperationCall__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5984:1: ( rule__OperationCall__Group__4__Impl )
            // InternalDOcl.g:5985:2: rule__OperationCall__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group__4"


    // $ANTLR start "rule__OperationCall__Group__4__Impl"
    // InternalDOcl.g:5991:1: rule__OperationCall__Group__4__Impl : ( ')' ) ;
    public final void rule__OperationCall__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:5995:1: ( ( ')' ) )
            // InternalDOcl.g:5996:1: ( ')' )
            {
            // InternalDOcl.g:5996:1: ( ')' )
            // InternalDOcl.g:5997:2: ')'
            {
             before(grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_4()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group__4__Impl"


    // $ANTLR start "rule__OperationCall__Group_3__0"
    // InternalDOcl.g:6007:1: rule__OperationCall__Group_3__0 : rule__OperationCall__Group_3__0__Impl rule__OperationCall__Group_3__1 ;
    public final void rule__OperationCall__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6011:1: ( rule__OperationCall__Group_3__0__Impl rule__OperationCall__Group_3__1 )
            // InternalDOcl.g:6012:2: rule__OperationCall__Group_3__0__Impl rule__OperationCall__Group_3__1
            {
            pushFollow(FOLLOW_47);
            rule__OperationCall__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationCall__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group_3__0"


    // $ANTLR start "rule__OperationCall__Group_3__0__Impl"
    // InternalDOcl.g:6019:1: rule__OperationCall__Group_3__0__Impl : ( ( rule__OperationCall__ArgumentsAssignment_3_0 ) ) ;
    public final void rule__OperationCall__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6023:1: ( ( ( rule__OperationCall__ArgumentsAssignment_3_0 ) ) )
            // InternalDOcl.g:6024:1: ( ( rule__OperationCall__ArgumentsAssignment_3_0 ) )
            {
            // InternalDOcl.g:6024:1: ( ( rule__OperationCall__ArgumentsAssignment_3_0 ) )
            // InternalDOcl.g:6025:2: ( rule__OperationCall__ArgumentsAssignment_3_0 )
            {
             before(grammarAccess.getOperationCallAccess().getArgumentsAssignment_3_0()); 
            // InternalDOcl.g:6026:2: ( rule__OperationCall__ArgumentsAssignment_3_0 )
            // InternalDOcl.g:6026:3: rule__OperationCall__ArgumentsAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__ArgumentsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getOperationCallAccess().getArgumentsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group_3__0__Impl"


    // $ANTLR start "rule__OperationCall__Group_3__1"
    // InternalDOcl.g:6034:1: rule__OperationCall__Group_3__1 : rule__OperationCall__Group_3__1__Impl ;
    public final void rule__OperationCall__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6038:1: ( rule__OperationCall__Group_3__1__Impl )
            // InternalDOcl.g:6039:2: rule__OperationCall__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group_3__1"


    // $ANTLR start "rule__OperationCall__Group_3__1__Impl"
    // InternalDOcl.g:6045:1: rule__OperationCall__Group_3__1__Impl : ( ( rule__OperationCall__Group_3_1__0 )* ) ;
    public final void rule__OperationCall__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6049:1: ( ( ( rule__OperationCall__Group_3_1__0 )* ) )
            // InternalDOcl.g:6050:1: ( ( rule__OperationCall__Group_3_1__0 )* )
            {
            // InternalDOcl.g:6050:1: ( ( rule__OperationCall__Group_3_1__0 )* )
            // InternalDOcl.g:6051:2: ( rule__OperationCall__Group_3_1__0 )*
            {
             before(grammarAccess.getOperationCallAccess().getGroup_3_1()); 
            // InternalDOcl.g:6052:2: ( rule__OperationCall__Group_3_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==74) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalDOcl.g:6052:3: rule__OperationCall__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_48);
            	    rule__OperationCall__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getOperationCallAccess().getGroup_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group_3__1__Impl"


    // $ANTLR start "rule__OperationCall__Group_3_1__0"
    // InternalDOcl.g:6061:1: rule__OperationCall__Group_3_1__0 : rule__OperationCall__Group_3_1__0__Impl rule__OperationCall__Group_3_1__1 ;
    public final void rule__OperationCall__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6065:1: ( rule__OperationCall__Group_3_1__0__Impl rule__OperationCall__Group_3_1__1 )
            // InternalDOcl.g:6066:2: rule__OperationCall__Group_3_1__0__Impl rule__OperationCall__Group_3_1__1
            {
            pushFollow(FOLLOW_22);
            rule__OperationCall__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OperationCall__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group_3_1__0"


    // $ANTLR start "rule__OperationCall__Group_3_1__0__Impl"
    // InternalDOcl.g:6073:1: rule__OperationCall__Group_3_1__0__Impl : ( ',' ) ;
    public final void rule__OperationCall__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6077:1: ( ( ',' ) )
            // InternalDOcl.g:6078:1: ( ',' )
            {
            // InternalDOcl.g:6078:1: ( ',' )
            // InternalDOcl.g:6079:2: ','
            {
             before(grammarAccess.getOperationCallAccess().getCommaKeyword_3_1_0()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getOperationCallAccess().getCommaKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group_3_1__0__Impl"


    // $ANTLR start "rule__OperationCall__Group_3_1__1"
    // InternalDOcl.g:6088:1: rule__OperationCall__Group_3_1__1 : rule__OperationCall__Group_3_1__1__Impl ;
    public final void rule__OperationCall__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6092:1: ( rule__OperationCall__Group_3_1__1__Impl )
            // InternalDOcl.g:6093:2: rule__OperationCall__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group_3_1__1"


    // $ANTLR start "rule__OperationCall__Group_3_1__1__Impl"
    // InternalDOcl.g:6099:1: rule__OperationCall__Group_3_1__1__Impl : ( ( rule__OperationCall__ArgumentsAssignment_3_1_1 ) ) ;
    public final void rule__OperationCall__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6103:1: ( ( ( rule__OperationCall__ArgumentsAssignment_3_1_1 ) ) )
            // InternalDOcl.g:6104:1: ( ( rule__OperationCall__ArgumentsAssignment_3_1_1 ) )
            {
            // InternalDOcl.g:6104:1: ( ( rule__OperationCall__ArgumentsAssignment_3_1_1 ) )
            // InternalDOcl.g:6105:2: ( rule__OperationCall__ArgumentsAssignment_3_1_1 )
            {
             before(grammarAccess.getOperationCallAccess().getArgumentsAssignment_3_1_1()); 
            // InternalDOcl.g:6106:2: ( rule__OperationCall__ArgumentsAssignment_3_1_1 )
            // InternalDOcl.g:6106:3: rule__OperationCall__ArgumentsAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__OperationCall__ArgumentsAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getOperationCallAccess().getArgumentsAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__Group_3_1__1__Impl"


    // $ANTLR start "rule__OclModelElementExp__Group__0"
    // InternalDOcl.g:6115:1: rule__OclModelElementExp__Group__0 : rule__OclModelElementExp__Group__0__Impl rule__OclModelElementExp__Group__1 ;
    public final void rule__OclModelElementExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6119:1: ( rule__OclModelElementExp__Group__0__Impl rule__OclModelElementExp__Group__1 )
            // InternalDOcl.g:6120:2: rule__OclModelElementExp__Group__0__Impl rule__OclModelElementExp__Group__1
            {
            pushFollow(FOLLOW_56);
            rule__OclModelElementExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OclModelElementExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group__0"


    // $ANTLR start "rule__OclModelElementExp__Group__0__Impl"
    // InternalDOcl.g:6127:1: rule__OclModelElementExp__Group__0__Impl : ( ( rule__OclModelElementExp__ModelAssignment_0 ) ) ;
    public final void rule__OclModelElementExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6131:1: ( ( ( rule__OclModelElementExp__ModelAssignment_0 ) ) )
            // InternalDOcl.g:6132:1: ( ( rule__OclModelElementExp__ModelAssignment_0 ) )
            {
            // InternalDOcl.g:6132:1: ( ( rule__OclModelElementExp__ModelAssignment_0 ) )
            // InternalDOcl.g:6133:2: ( rule__OclModelElementExp__ModelAssignment_0 )
            {
             before(grammarAccess.getOclModelElementExpAccess().getModelAssignment_0()); 
            // InternalDOcl.g:6134:2: ( rule__OclModelElementExp__ModelAssignment_0 )
            // InternalDOcl.g:6134:3: rule__OclModelElementExp__ModelAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OclModelElementExp__ModelAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOclModelElementExpAccess().getModelAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group__0__Impl"


    // $ANTLR start "rule__OclModelElementExp__Group__1"
    // InternalDOcl.g:6142:1: rule__OclModelElementExp__Group__1 : rule__OclModelElementExp__Group__1__Impl rule__OclModelElementExp__Group__2 ;
    public final void rule__OclModelElementExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6146:1: ( rule__OclModelElementExp__Group__1__Impl rule__OclModelElementExp__Group__2 )
            // InternalDOcl.g:6147:2: rule__OclModelElementExp__Group__1__Impl rule__OclModelElementExp__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__OclModelElementExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OclModelElementExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group__1"


    // $ANTLR start "rule__OclModelElementExp__Group__1__Impl"
    // InternalDOcl.g:6154:1: rule__OclModelElementExp__Group__1__Impl : ( ( rule__OclModelElementExp__NameAssignment_1 ) ) ;
    public final void rule__OclModelElementExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6158:1: ( ( ( rule__OclModelElementExp__NameAssignment_1 ) ) )
            // InternalDOcl.g:6159:1: ( ( rule__OclModelElementExp__NameAssignment_1 ) )
            {
            // InternalDOcl.g:6159:1: ( ( rule__OclModelElementExp__NameAssignment_1 ) )
            // InternalDOcl.g:6160:2: ( rule__OclModelElementExp__NameAssignment_1 )
            {
             before(grammarAccess.getOclModelElementExpAccess().getNameAssignment_1()); 
            // InternalDOcl.g:6161:2: ( rule__OclModelElementExp__NameAssignment_1 )
            // InternalDOcl.g:6161:3: rule__OclModelElementExp__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__OclModelElementExp__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getOclModelElementExpAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group__1__Impl"


    // $ANTLR start "rule__OclModelElementExp__Group__2"
    // InternalDOcl.g:6169:1: rule__OclModelElementExp__Group__2 : rule__OclModelElementExp__Group__2__Impl rule__OclModelElementExp__Group__3 ;
    public final void rule__OclModelElementExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6173:1: ( rule__OclModelElementExp__Group__2__Impl rule__OclModelElementExp__Group__3 )
            // InternalDOcl.g:6174:2: rule__OclModelElementExp__Group__2__Impl rule__OclModelElementExp__Group__3
            {
            pushFollow(FOLLOW_57);
            rule__OclModelElementExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OclModelElementExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group__2"


    // $ANTLR start "rule__OclModelElementExp__Group__2__Impl"
    // InternalDOcl.g:6181:1: rule__OclModelElementExp__Group__2__Impl : ( ( rule__OclModelElementExp__ElementsAssignment_2 ) ) ;
    public final void rule__OclModelElementExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6185:1: ( ( ( rule__OclModelElementExp__ElementsAssignment_2 ) ) )
            // InternalDOcl.g:6186:1: ( ( rule__OclModelElementExp__ElementsAssignment_2 ) )
            {
            // InternalDOcl.g:6186:1: ( ( rule__OclModelElementExp__ElementsAssignment_2 ) )
            // InternalDOcl.g:6187:2: ( rule__OclModelElementExp__ElementsAssignment_2 )
            {
             before(grammarAccess.getOclModelElementExpAccess().getElementsAssignment_2()); 
            // InternalDOcl.g:6188:2: ( rule__OclModelElementExp__ElementsAssignment_2 )
            // InternalDOcl.g:6188:3: rule__OclModelElementExp__ElementsAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__OclModelElementExp__ElementsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOclModelElementExpAccess().getElementsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group__2__Impl"


    // $ANTLR start "rule__OclModelElementExp__Group__3"
    // InternalDOcl.g:6196:1: rule__OclModelElementExp__Group__3 : rule__OclModelElementExp__Group__3__Impl rule__OclModelElementExp__Group__4 ;
    public final void rule__OclModelElementExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6200:1: ( rule__OclModelElementExp__Group__3__Impl rule__OclModelElementExp__Group__4 )
            // InternalDOcl.g:6201:2: rule__OclModelElementExp__Group__3__Impl rule__OclModelElementExp__Group__4
            {
            pushFollow(FOLLOW_57);
            rule__OclModelElementExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OclModelElementExp__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group__3"


    // $ANTLR start "rule__OclModelElementExp__Group__3__Impl"
    // InternalDOcl.g:6208:1: rule__OclModelElementExp__Group__3__Impl : ( ( rule__OclModelElementExp__Group_3__0 )* ) ;
    public final void rule__OclModelElementExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6212:1: ( ( ( rule__OclModelElementExp__Group_3__0 )* ) )
            // InternalDOcl.g:6213:1: ( ( rule__OclModelElementExp__Group_3__0 )* )
            {
            // InternalDOcl.g:6213:1: ( ( rule__OclModelElementExp__Group_3__0 )* )
            // InternalDOcl.g:6214:2: ( rule__OclModelElementExp__Group_3__0 )*
            {
             before(grammarAccess.getOclModelElementExpAccess().getGroup_3()); 
            // InternalDOcl.g:6215:2: ( rule__OclModelElementExp__Group_3__0 )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==76) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalDOcl.g:6215:3: rule__OclModelElementExp__Group_3__0
            	    {
            	    pushFollow(FOLLOW_58);
            	    rule__OclModelElementExp__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

             after(grammarAccess.getOclModelElementExpAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group__3__Impl"


    // $ANTLR start "rule__OclModelElementExp__Group__4"
    // InternalDOcl.g:6223:1: rule__OclModelElementExp__Group__4 : rule__OclModelElementExp__Group__4__Impl ;
    public final void rule__OclModelElementExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6227:1: ( rule__OclModelElementExp__Group__4__Impl )
            // InternalDOcl.g:6228:2: rule__OclModelElementExp__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OclModelElementExp__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group__4"


    // $ANTLR start "rule__OclModelElementExp__Group__4__Impl"
    // InternalDOcl.g:6234:1: rule__OclModelElementExp__Group__4__Impl : ( ( rule__OclModelElementExp__TargetAssignment_4 )? ) ;
    public final void rule__OclModelElementExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6238:1: ( ( ( rule__OclModelElementExp__TargetAssignment_4 )? ) )
            // InternalDOcl.g:6239:1: ( ( rule__OclModelElementExp__TargetAssignment_4 )? )
            {
            // InternalDOcl.g:6239:1: ( ( rule__OclModelElementExp__TargetAssignment_4 )? )
            // InternalDOcl.g:6240:2: ( rule__OclModelElementExp__TargetAssignment_4 )?
            {
             before(grammarAccess.getOclModelElementExpAccess().getTargetAssignment_4()); 
            // InternalDOcl.g:6241:2: ( rule__OclModelElementExp__TargetAssignment_4 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==19) ) {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==86) ) {
                    alt41=1;
                }
            }
            switch (alt41) {
                case 1 :
                    // InternalDOcl.g:6241:3: rule__OclModelElementExp__TargetAssignment_4
                    {
                    pushFollow(FOLLOW_2);
                    rule__OclModelElementExp__TargetAssignment_4();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOclModelElementExpAccess().getTargetAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group__4__Impl"


    // $ANTLR start "rule__OclModelElementExp__Group_3__0"
    // InternalDOcl.g:6250:1: rule__OclModelElementExp__Group_3__0 : rule__OclModelElementExp__Group_3__0__Impl rule__OclModelElementExp__Group_3__1 ;
    public final void rule__OclModelElementExp__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6254:1: ( rule__OclModelElementExp__Group_3__0__Impl rule__OclModelElementExp__Group_3__1 )
            // InternalDOcl.g:6255:2: rule__OclModelElementExp__Group_3__0__Impl rule__OclModelElementExp__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__OclModelElementExp__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OclModelElementExp__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group_3__0"


    // $ANTLR start "rule__OclModelElementExp__Group_3__0__Impl"
    // InternalDOcl.g:6262:1: rule__OclModelElementExp__Group_3__0__Impl : ( '::' ) ;
    public final void rule__OclModelElementExp__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6266:1: ( ( '::' ) )
            // InternalDOcl.g:6267:1: ( '::' )
            {
            // InternalDOcl.g:6267:1: ( '::' )
            // InternalDOcl.g:6268:2: '::'
            {
             before(grammarAccess.getOclModelElementExpAccess().getColonColonKeyword_3_0()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getOclModelElementExpAccess().getColonColonKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group_3__0__Impl"


    // $ANTLR start "rule__OclModelElementExp__Group_3__1"
    // InternalDOcl.g:6277:1: rule__OclModelElementExp__Group_3__1 : rule__OclModelElementExp__Group_3__1__Impl ;
    public final void rule__OclModelElementExp__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6281:1: ( rule__OclModelElementExp__Group_3__1__Impl )
            // InternalDOcl.g:6282:2: rule__OclModelElementExp__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OclModelElementExp__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group_3__1"


    // $ANTLR start "rule__OclModelElementExp__Group_3__1__Impl"
    // InternalDOcl.g:6288:1: rule__OclModelElementExp__Group_3__1__Impl : ( ( rule__OclModelElementExp__ElementsAssignment_3_1 ) ) ;
    public final void rule__OclModelElementExp__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6292:1: ( ( ( rule__OclModelElementExp__ElementsAssignment_3_1 ) ) )
            // InternalDOcl.g:6293:1: ( ( rule__OclModelElementExp__ElementsAssignment_3_1 ) )
            {
            // InternalDOcl.g:6293:1: ( ( rule__OclModelElementExp__ElementsAssignment_3_1 ) )
            // InternalDOcl.g:6294:2: ( rule__OclModelElementExp__ElementsAssignment_3_1 )
            {
             before(grammarAccess.getOclModelElementExpAccess().getElementsAssignment_3_1()); 
            // InternalDOcl.g:6295:2: ( rule__OclModelElementExp__ElementsAssignment_3_1 )
            // InternalDOcl.g:6295:3: rule__OclModelElementExp__ElementsAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__OclModelElementExp__ElementsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getOclModelElementExpAccess().getElementsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__Group_3__1__Impl"


    // $ANTLR start "rule__AllInstancesOpCall__Group__0"
    // InternalDOcl.g:6304:1: rule__AllInstancesOpCall__Group__0 : rule__AllInstancesOpCall__Group__0__Impl rule__AllInstancesOpCall__Group__1 ;
    public final void rule__AllInstancesOpCall__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6308:1: ( rule__AllInstancesOpCall__Group__0__Impl rule__AllInstancesOpCall__Group__1 )
            // InternalDOcl.g:6309:2: rule__AllInstancesOpCall__Group__0__Impl rule__AllInstancesOpCall__Group__1
            {
            pushFollow(FOLLOW_59);
            rule__AllInstancesOpCall__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllInstancesOpCall__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstancesOpCall__Group__0"


    // $ANTLR start "rule__AllInstancesOpCall__Group__0__Impl"
    // InternalDOcl.g:6316:1: rule__AllInstancesOpCall__Group__0__Impl : ( () ) ;
    public final void rule__AllInstancesOpCall__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6320:1: ( ( () ) )
            // InternalDOcl.g:6321:1: ( () )
            {
            // InternalDOcl.g:6321:1: ( () )
            // InternalDOcl.g:6322:2: ()
            {
             before(grammarAccess.getAllInstancesOpCallAccess().getOperationCallAction_0()); 
            // InternalDOcl.g:6323:2: ()
            // InternalDOcl.g:6323:3: 
            {
            }

             after(grammarAccess.getAllInstancesOpCallAccess().getOperationCallAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstancesOpCall__Group__0__Impl"


    // $ANTLR start "rule__AllInstancesOpCall__Group__1"
    // InternalDOcl.g:6331:1: rule__AllInstancesOpCall__Group__1 : rule__AllInstancesOpCall__Group__1__Impl rule__AllInstancesOpCall__Group__2 ;
    public final void rule__AllInstancesOpCall__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6335:1: ( rule__AllInstancesOpCall__Group__1__Impl rule__AllInstancesOpCall__Group__2 )
            // InternalDOcl.g:6336:2: rule__AllInstancesOpCall__Group__1__Impl rule__AllInstancesOpCall__Group__2
            {
            pushFollow(FOLLOW_60);
            rule__AllInstancesOpCall__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllInstancesOpCall__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstancesOpCall__Group__1"


    // $ANTLR start "rule__AllInstancesOpCall__Group__1__Impl"
    // InternalDOcl.g:6343:1: rule__AllInstancesOpCall__Group__1__Impl : ( '.' ) ;
    public final void rule__AllInstancesOpCall__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6347:1: ( ( '.' ) )
            // InternalDOcl.g:6348:1: ( '.' )
            {
            // InternalDOcl.g:6348:1: ( '.' )
            // InternalDOcl.g:6349:2: '.'
            {
             before(grammarAccess.getAllInstancesOpCallAccess().getFullStopKeyword_1()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getAllInstancesOpCallAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstancesOpCall__Group__1__Impl"


    // $ANTLR start "rule__AllInstancesOpCall__Group__2"
    // InternalDOcl.g:6358:1: rule__AllInstancesOpCall__Group__2 : rule__AllInstancesOpCall__Group__2__Impl rule__AllInstancesOpCall__Group__3 ;
    public final void rule__AllInstancesOpCall__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6362:1: ( rule__AllInstancesOpCall__Group__2__Impl rule__AllInstancesOpCall__Group__3 )
            // InternalDOcl.g:6363:2: rule__AllInstancesOpCall__Group__2__Impl rule__AllInstancesOpCall__Group__3
            {
            pushFollow(FOLLOW_45);
            rule__AllInstancesOpCall__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllInstancesOpCall__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstancesOpCall__Group__2"


    // $ANTLR start "rule__AllInstancesOpCall__Group__2__Impl"
    // InternalDOcl.g:6370:1: rule__AllInstancesOpCall__Group__2__Impl : ( ( rule__AllInstancesOpCall__NameAssignment_2 ) ) ;
    public final void rule__AllInstancesOpCall__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6374:1: ( ( ( rule__AllInstancesOpCall__NameAssignment_2 ) ) )
            // InternalDOcl.g:6375:1: ( ( rule__AllInstancesOpCall__NameAssignment_2 ) )
            {
            // InternalDOcl.g:6375:1: ( ( rule__AllInstancesOpCall__NameAssignment_2 ) )
            // InternalDOcl.g:6376:2: ( rule__AllInstancesOpCall__NameAssignment_2 )
            {
             before(grammarAccess.getAllInstancesOpCallAccess().getNameAssignment_2()); 
            // InternalDOcl.g:6377:2: ( rule__AllInstancesOpCall__NameAssignment_2 )
            // InternalDOcl.g:6377:3: rule__AllInstancesOpCall__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__AllInstancesOpCall__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAllInstancesOpCallAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstancesOpCall__Group__2__Impl"


    // $ANTLR start "rule__AllInstancesOpCall__Group__3"
    // InternalDOcl.g:6385:1: rule__AllInstancesOpCall__Group__3 : rule__AllInstancesOpCall__Group__3__Impl rule__AllInstancesOpCall__Group__4 ;
    public final void rule__AllInstancesOpCall__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6389:1: ( rule__AllInstancesOpCall__Group__3__Impl rule__AllInstancesOpCall__Group__4 )
            // InternalDOcl.g:6390:2: rule__AllInstancesOpCall__Group__3__Impl rule__AllInstancesOpCall__Group__4
            {
            pushFollow(FOLLOW_52);
            rule__AllInstancesOpCall__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AllInstancesOpCall__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstancesOpCall__Group__3"


    // $ANTLR start "rule__AllInstancesOpCall__Group__3__Impl"
    // InternalDOcl.g:6397:1: rule__AllInstancesOpCall__Group__3__Impl : ( '(' ) ;
    public final void rule__AllInstancesOpCall__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6401:1: ( ( '(' ) )
            // InternalDOcl.g:6402:1: ( '(' )
            {
            // InternalDOcl.g:6402:1: ( '(' )
            // InternalDOcl.g:6403:2: '('
            {
             before(grammarAccess.getAllInstancesOpCallAccess().getLeftParenthesisKeyword_3()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getAllInstancesOpCallAccess().getLeftParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstancesOpCall__Group__3__Impl"


    // $ANTLR start "rule__AllInstancesOpCall__Group__4"
    // InternalDOcl.g:6412:1: rule__AllInstancesOpCall__Group__4 : rule__AllInstancesOpCall__Group__4__Impl ;
    public final void rule__AllInstancesOpCall__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6416:1: ( rule__AllInstancesOpCall__Group__4__Impl )
            // InternalDOcl.g:6417:2: rule__AllInstancesOpCall__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AllInstancesOpCall__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstancesOpCall__Group__4"


    // $ANTLR start "rule__AllInstancesOpCall__Group__4__Impl"
    // InternalDOcl.g:6423:1: rule__AllInstancesOpCall__Group__4__Impl : ( ')' ) ;
    public final void rule__AllInstancesOpCall__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6427:1: ( ( ')' ) )
            // InternalDOcl.g:6428:1: ( ')' )
            {
            // InternalDOcl.g:6428:1: ( ')' )
            // InternalDOcl.g:6429:2: ')'
            {
             before(grammarAccess.getAllInstancesOpCallAccess().getRightParenthesisKeyword_4()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getAllInstancesOpCallAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstancesOpCall__Group__4__Impl"


    // $ANTLR start "rule__LocalVariable__Group__0"
    // InternalDOcl.g:6439:1: rule__LocalVariable__Group__0 : rule__LocalVariable__Group__0__Impl rule__LocalVariable__Group__1 ;
    public final void rule__LocalVariable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6443:1: ( rule__LocalVariable__Group__0__Impl rule__LocalVariable__Group__1 )
            // InternalDOcl.g:6444:2: rule__LocalVariable__Group__0__Impl rule__LocalVariable__Group__1
            {
            pushFollow(FOLLOW_21);
            rule__LocalVariable__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LocalVariable__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__Group__0"


    // $ANTLR start "rule__LocalVariable__Group__0__Impl"
    // InternalDOcl.g:6451:1: rule__LocalVariable__Group__0__Impl : ( ( rule__LocalVariable__NameAssignment_0 ) ) ;
    public final void rule__LocalVariable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6455:1: ( ( ( rule__LocalVariable__NameAssignment_0 ) ) )
            // InternalDOcl.g:6456:1: ( ( rule__LocalVariable__NameAssignment_0 ) )
            {
            // InternalDOcl.g:6456:1: ( ( rule__LocalVariable__NameAssignment_0 ) )
            // InternalDOcl.g:6457:2: ( rule__LocalVariable__NameAssignment_0 )
            {
             before(grammarAccess.getLocalVariableAccess().getNameAssignment_0()); 
            // InternalDOcl.g:6458:2: ( rule__LocalVariable__NameAssignment_0 )
            // InternalDOcl.g:6458:3: rule__LocalVariable__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__LocalVariable__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLocalVariableAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__Group__0__Impl"


    // $ANTLR start "rule__LocalVariable__Group__1"
    // InternalDOcl.g:6466:1: rule__LocalVariable__Group__1 : rule__LocalVariable__Group__1__Impl rule__LocalVariable__Group__2 ;
    public final void rule__LocalVariable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6470:1: ( rule__LocalVariable__Group__1__Impl rule__LocalVariable__Group__2 )
            // InternalDOcl.g:6471:2: rule__LocalVariable__Group__1__Impl rule__LocalVariable__Group__2
            {
            pushFollow(FOLLOW_53);
            rule__LocalVariable__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LocalVariable__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__Group__1"


    // $ANTLR start "rule__LocalVariable__Group__1__Impl"
    // InternalDOcl.g:6478:1: rule__LocalVariable__Group__1__Impl : ( ':' ) ;
    public final void rule__LocalVariable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6482:1: ( ( ':' ) )
            // InternalDOcl.g:6483:1: ( ':' )
            {
            // InternalDOcl.g:6483:1: ( ':' )
            // InternalDOcl.g:6484:2: ':'
            {
             before(grammarAccess.getLocalVariableAccess().getColonKeyword_1()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getLocalVariableAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__Group__1__Impl"


    // $ANTLR start "rule__LocalVariable__Group__2"
    // InternalDOcl.g:6493:1: rule__LocalVariable__Group__2 : rule__LocalVariable__Group__2__Impl rule__LocalVariable__Group__3 ;
    public final void rule__LocalVariable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6497:1: ( rule__LocalVariable__Group__2__Impl rule__LocalVariable__Group__3 )
            // InternalDOcl.g:6498:2: rule__LocalVariable__Group__2__Impl rule__LocalVariable__Group__3
            {
            pushFollow(FOLLOW_61);
            rule__LocalVariable__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LocalVariable__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__Group__2"


    // $ANTLR start "rule__LocalVariable__Group__2__Impl"
    // InternalDOcl.g:6505:1: rule__LocalVariable__Group__2__Impl : ( ( rule__LocalVariable__TypeAssignment_2 ) ) ;
    public final void rule__LocalVariable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6509:1: ( ( ( rule__LocalVariable__TypeAssignment_2 ) ) )
            // InternalDOcl.g:6510:1: ( ( rule__LocalVariable__TypeAssignment_2 ) )
            {
            // InternalDOcl.g:6510:1: ( ( rule__LocalVariable__TypeAssignment_2 ) )
            // InternalDOcl.g:6511:2: ( rule__LocalVariable__TypeAssignment_2 )
            {
             before(grammarAccess.getLocalVariableAccess().getTypeAssignment_2()); 
            // InternalDOcl.g:6512:2: ( rule__LocalVariable__TypeAssignment_2 )
            // InternalDOcl.g:6512:3: rule__LocalVariable__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__LocalVariable__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLocalVariableAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__Group__2__Impl"


    // $ANTLR start "rule__LocalVariable__Group__3"
    // InternalDOcl.g:6520:1: rule__LocalVariable__Group__3 : rule__LocalVariable__Group__3__Impl rule__LocalVariable__Group__4 ;
    public final void rule__LocalVariable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6524:1: ( rule__LocalVariable__Group__3__Impl rule__LocalVariable__Group__4 )
            // InternalDOcl.g:6525:2: rule__LocalVariable__Group__3__Impl rule__LocalVariable__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__LocalVariable__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LocalVariable__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__Group__3"


    // $ANTLR start "rule__LocalVariable__Group__3__Impl"
    // InternalDOcl.g:6532:1: rule__LocalVariable__Group__3__Impl : ( '=' ) ;
    public final void rule__LocalVariable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6536:1: ( ( '=' ) )
            // InternalDOcl.g:6537:1: ( '=' )
            {
            // InternalDOcl.g:6537:1: ( '=' )
            // InternalDOcl.g:6538:2: '='
            {
             before(grammarAccess.getLocalVariableAccess().getEqualsSignKeyword_3()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getLocalVariableAccess().getEqualsSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__Group__3__Impl"


    // $ANTLR start "rule__LocalVariable__Group__4"
    // InternalDOcl.g:6547:1: rule__LocalVariable__Group__4 : rule__LocalVariable__Group__4__Impl ;
    public final void rule__LocalVariable__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6551:1: ( rule__LocalVariable__Group__4__Impl )
            // InternalDOcl.g:6552:2: rule__LocalVariable__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LocalVariable__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__Group__4"


    // $ANTLR start "rule__LocalVariable__Group__4__Impl"
    // InternalDOcl.g:6558:1: rule__LocalVariable__Group__4__Impl : ( ( rule__LocalVariable__InitExpAssignment_4 ) ) ;
    public final void rule__LocalVariable__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6562:1: ( ( ( rule__LocalVariable__InitExpAssignment_4 ) ) )
            // InternalDOcl.g:6563:1: ( ( rule__LocalVariable__InitExpAssignment_4 ) )
            {
            // InternalDOcl.g:6563:1: ( ( rule__LocalVariable__InitExpAssignment_4 ) )
            // InternalDOcl.g:6564:2: ( rule__LocalVariable__InitExpAssignment_4 )
            {
             before(grammarAccess.getLocalVariableAccess().getInitExpAssignment_4()); 
            // InternalDOcl.g:6565:2: ( rule__LocalVariable__InitExpAssignment_4 )
            // InternalDOcl.g:6565:3: rule__LocalVariable__InitExpAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__LocalVariable__InitExpAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getLocalVariableAccess().getInitExpAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__Group__4__Impl"


    // $ANTLR start "rule__LambdaExp__Group__0"
    // InternalDOcl.g:6574:1: rule__LambdaExp__Group__0 : rule__LambdaExp__Group__0__Impl rule__LambdaExp__Group__1 ;
    public final void rule__LambdaExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6578:1: ( rule__LambdaExp__Group__0__Impl rule__LambdaExp__Group__1 )
            // InternalDOcl.g:6579:2: rule__LambdaExp__Group__0__Impl rule__LambdaExp__Group__1
            {
            pushFollow(FOLLOW_62);
            rule__LambdaExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LambdaExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaExp__Group__0"


    // $ANTLR start "rule__LambdaExp__Group__0__Impl"
    // InternalDOcl.g:6586:1: rule__LambdaExp__Group__0__Impl : ( () ) ;
    public final void rule__LambdaExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6590:1: ( ( () ) )
            // InternalDOcl.g:6591:1: ( () )
            {
            // InternalDOcl.g:6591:1: ( () )
            // InternalDOcl.g:6592:2: ()
            {
             before(grammarAccess.getLambdaExpAccess().getLambdaExpAction_0()); 
            // InternalDOcl.g:6593:2: ()
            // InternalDOcl.g:6593:3: 
            {
            }

             after(grammarAccess.getLambdaExpAccess().getLambdaExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaExp__Group__0__Impl"


    // $ANTLR start "rule__LambdaExp__Group__1"
    // InternalDOcl.g:6601:1: rule__LambdaExp__Group__1 : rule__LambdaExp__Group__1__Impl rule__LambdaExp__Group__2 ;
    public final void rule__LambdaExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6605:1: ( rule__LambdaExp__Group__1__Impl rule__LambdaExp__Group__2 )
            // InternalDOcl.g:6606:2: rule__LambdaExp__Group__1__Impl rule__LambdaExp__Group__2
            {
            pushFollow(FOLLOW_63);
            rule__LambdaExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LambdaExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaExp__Group__1"


    // $ANTLR start "rule__LambdaExp__Group__1__Impl"
    // InternalDOcl.g:6613:1: rule__LambdaExp__Group__1__Impl : ( ( rule__LambdaExp__NameAssignment_1 ) ) ;
    public final void rule__LambdaExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6617:1: ( ( ( rule__LambdaExp__NameAssignment_1 ) ) )
            // InternalDOcl.g:6618:1: ( ( rule__LambdaExp__NameAssignment_1 ) )
            {
            // InternalDOcl.g:6618:1: ( ( rule__LambdaExp__NameAssignment_1 ) )
            // InternalDOcl.g:6619:2: ( rule__LambdaExp__NameAssignment_1 )
            {
             before(grammarAccess.getLambdaExpAccess().getNameAssignment_1()); 
            // InternalDOcl.g:6620:2: ( rule__LambdaExp__NameAssignment_1 )
            // InternalDOcl.g:6620:3: rule__LambdaExp__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__LambdaExp__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLambdaExpAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaExp__Group__1__Impl"


    // $ANTLR start "rule__LambdaExp__Group__2"
    // InternalDOcl.g:6628:1: rule__LambdaExp__Group__2 : rule__LambdaExp__Group__2__Impl rule__LambdaExp__Group__3 ;
    public final void rule__LambdaExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6632:1: ( rule__LambdaExp__Group__2__Impl rule__LambdaExp__Group__3 )
            // InternalDOcl.g:6633:2: rule__LambdaExp__Group__2__Impl rule__LambdaExp__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__LambdaExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LambdaExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaExp__Group__2"


    // $ANTLR start "rule__LambdaExp__Group__2__Impl"
    // InternalDOcl.g:6640:1: rule__LambdaExp__Group__2__Impl : ( '{' ) ;
    public final void rule__LambdaExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6644:1: ( ( '{' ) )
            // InternalDOcl.g:6645:1: ( '{' )
            {
            // InternalDOcl.g:6645:1: ( '{' )
            // InternalDOcl.g:6646:2: '{'
            {
             before(grammarAccess.getLambdaExpAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getLambdaExpAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaExp__Group__2__Impl"


    // $ANTLR start "rule__LambdaExp__Group__3"
    // InternalDOcl.g:6655:1: rule__LambdaExp__Group__3 : rule__LambdaExp__Group__3__Impl rule__LambdaExp__Group__4 ;
    public final void rule__LambdaExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6659:1: ( rule__LambdaExp__Group__3__Impl rule__LambdaExp__Group__4 )
            // InternalDOcl.g:6660:2: rule__LambdaExp__Group__3__Impl rule__LambdaExp__Group__4
            {
            pushFollow(FOLLOW_64);
            rule__LambdaExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LambdaExp__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaExp__Group__3"


    // $ANTLR start "rule__LambdaExp__Group__3__Impl"
    // InternalDOcl.g:6667:1: rule__LambdaExp__Group__3__Impl : ( ( rule__LambdaExp__ExpressionAssignment_3 ) ) ;
    public final void rule__LambdaExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6671:1: ( ( ( rule__LambdaExp__ExpressionAssignment_3 ) ) )
            // InternalDOcl.g:6672:1: ( ( rule__LambdaExp__ExpressionAssignment_3 ) )
            {
            // InternalDOcl.g:6672:1: ( ( rule__LambdaExp__ExpressionAssignment_3 ) )
            // InternalDOcl.g:6673:2: ( rule__LambdaExp__ExpressionAssignment_3 )
            {
             before(grammarAccess.getLambdaExpAccess().getExpressionAssignment_3()); 
            // InternalDOcl.g:6674:2: ( rule__LambdaExp__ExpressionAssignment_3 )
            // InternalDOcl.g:6674:3: rule__LambdaExp__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__LambdaExp__ExpressionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getLambdaExpAccess().getExpressionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaExp__Group__3__Impl"


    // $ANTLR start "rule__LambdaExp__Group__4"
    // InternalDOcl.g:6682:1: rule__LambdaExp__Group__4 : rule__LambdaExp__Group__4__Impl ;
    public final void rule__LambdaExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6686:1: ( rule__LambdaExp__Group__4__Impl )
            // InternalDOcl.g:6687:2: rule__LambdaExp__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LambdaExp__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaExp__Group__4"


    // $ANTLR start "rule__LambdaExp__Group__4__Impl"
    // InternalDOcl.g:6693:1: rule__LambdaExp__Group__4__Impl : ( '}' ) ;
    public final void rule__LambdaExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6697:1: ( ( '}' ) )
            // InternalDOcl.g:6698:1: ( '}' )
            {
            // InternalDOcl.g:6698:1: ( '}' )
            // InternalDOcl.g:6699:2: '}'
            {
             before(grammarAccess.getLambdaExpAccess().getRightCurlyBracketKeyword_4()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getLambdaExpAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaExp__Group__4__Impl"


    // $ANTLR start "rule__TupleExp__Group__0"
    // InternalDOcl.g:6709:1: rule__TupleExp__Group__0 : rule__TupleExp__Group__0__Impl rule__TupleExp__Group__1 ;
    public final void rule__TupleExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6713:1: ( rule__TupleExp__Group__0__Impl rule__TupleExp__Group__1 )
            // InternalDOcl.g:6714:2: rule__TupleExp__Group__0__Impl rule__TupleExp__Group__1
            {
            pushFollow(FOLLOW_65);
            rule__TupleExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TupleExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group__0"


    // $ANTLR start "rule__TupleExp__Group__0__Impl"
    // InternalDOcl.g:6721:1: rule__TupleExp__Group__0__Impl : ( () ) ;
    public final void rule__TupleExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6725:1: ( ( () ) )
            // InternalDOcl.g:6726:1: ( () )
            {
            // InternalDOcl.g:6726:1: ( () )
            // InternalDOcl.g:6727:2: ()
            {
             before(grammarAccess.getTupleExpAccess().getTupleExpAction_0()); 
            // InternalDOcl.g:6728:2: ()
            // InternalDOcl.g:6728:3: 
            {
            }

             after(grammarAccess.getTupleExpAccess().getTupleExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group__0__Impl"


    // $ANTLR start "rule__TupleExp__Group__1"
    // InternalDOcl.g:6736:1: rule__TupleExp__Group__1 : rule__TupleExp__Group__1__Impl rule__TupleExp__Group__2 ;
    public final void rule__TupleExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6740:1: ( rule__TupleExp__Group__1__Impl rule__TupleExp__Group__2 )
            // InternalDOcl.g:6741:2: rule__TupleExp__Group__1__Impl rule__TupleExp__Group__2
            {
            pushFollow(FOLLOW_63);
            rule__TupleExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TupleExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group__1"


    // $ANTLR start "rule__TupleExp__Group__1__Impl"
    // InternalDOcl.g:6748:1: rule__TupleExp__Group__1__Impl : ( ( rule__TupleExp__NameAssignment_1 ) ) ;
    public final void rule__TupleExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6752:1: ( ( ( rule__TupleExp__NameAssignment_1 ) ) )
            // InternalDOcl.g:6753:1: ( ( rule__TupleExp__NameAssignment_1 ) )
            {
            // InternalDOcl.g:6753:1: ( ( rule__TupleExp__NameAssignment_1 ) )
            // InternalDOcl.g:6754:2: ( rule__TupleExp__NameAssignment_1 )
            {
             before(grammarAccess.getTupleExpAccess().getNameAssignment_1()); 
            // InternalDOcl.g:6755:2: ( rule__TupleExp__NameAssignment_1 )
            // InternalDOcl.g:6755:3: rule__TupleExp__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__TupleExp__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTupleExpAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group__1__Impl"


    // $ANTLR start "rule__TupleExp__Group__2"
    // InternalDOcl.g:6763:1: rule__TupleExp__Group__2 : rule__TupleExp__Group__2__Impl rule__TupleExp__Group__3 ;
    public final void rule__TupleExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6767:1: ( rule__TupleExp__Group__2__Impl rule__TupleExp__Group__3 )
            // InternalDOcl.g:6768:2: rule__TupleExp__Group__2__Impl rule__TupleExp__Group__3
            {
            pushFollow(FOLLOW_66);
            rule__TupleExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TupleExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group__2"


    // $ANTLR start "rule__TupleExp__Group__2__Impl"
    // InternalDOcl.g:6775:1: rule__TupleExp__Group__2__Impl : ( '{' ) ;
    public final void rule__TupleExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6779:1: ( ( '{' ) )
            // InternalDOcl.g:6780:1: ( '{' )
            {
            // InternalDOcl.g:6780:1: ( '{' )
            // InternalDOcl.g:6781:2: '{'
            {
             before(grammarAccess.getTupleExpAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,77,FOLLOW_2); 
             after(grammarAccess.getTupleExpAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group__2__Impl"


    // $ANTLR start "rule__TupleExp__Group__3"
    // InternalDOcl.g:6790:1: rule__TupleExp__Group__3 : rule__TupleExp__Group__3__Impl rule__TupleExp__Group__4 ;
    public final void rule__TupleExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6794:1: ( rule__TupleExp__Group__3__Impl rule__TupleExp__Group__4 )
            // InternalDOcl.g:6795:2: rule__TupleExp__Group__3__Impl rule__TupleExp__Group__4
            {
            pushFollow(FOLLOW_67);
            rule__TupleExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TupleExp__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group__3"


    // $ANTLR start "rule__TupleExp__Group__3__Impl"
    // InternalDOcl.g:6802:1: rule__TupleExp__Group__3__Impl : ( ( rule__TupleExp__PartsAssignment_3 ) ) ;
    public final void rule__TupleExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6806:1: ( ( ( rule__TupleExp__PartsAssignment_3 ) ) )
            // InternalDOcl.g:6807:1: ( ( rule__TupleExp__PartsAssignment_3 ) )
            {
            // InternalDOcl.g:6807:1: ( ( rule__TupleExp__PartsAssignment_3 ) )
            // InternalDOcl.g:6808:2: ( rule__TupleExp__PartsAssignment_3 )
            {
             before(grammarAccess.getTupleExpAccess().getPartsAssignment_3()); 
            // InternalDOcl.g:6809:2: ( rule__TupleExp__PartsAssignment_3 )
            // InternalDOcl.g:6809:3: rule__TupleExp__PartsAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TupleExp__PartsAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTupleExpAccess().getPartsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group__3__Impl"


    // $ANTLR start "rule__TupleExp__Group__4"
    // InternalDOcl.g:6817:1: rule__TupleExp__Group__4 : rule__TupleExp__Group__4__Impl rule__TupleExp__Group__5 ;
    public final void rule__TupleExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6821:1: ( rule__TupleExp__Group__4__Impl rule__TupleExp__Group__5 )
            // InternalDOcl.g:6822:2: rule__TupleExp__Group__4__Impl rule__TupleExp__Group__5
            {
            pushFollow(FOLLOW_67);
            rule__TupleExp__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TupleExp__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group__4"


    // $ANTLR start "rule__TupleExp__Group__4__Impl"
    // InternalDOcl.g:6829:1: rule__TupleExp__Group__4__Impl : ( ( rule__TupleExp__Group_4__0 )* ) ;
    public final void rule__TupleExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6833:1: ( ( ( rule__TupleExp__Group_4__0 )* ) )
            // InternalDOcl.g:6834:1: ( ( rule__TupleExp__Group_4__0 )* )
            {
            // InternalDOcl.g:6834:1: ( ( rule__TupleExp__Group_4__0 )* )
            // InternalDOcl.g:6835:2: ( rule__TupleExp__Group_4__0 )*
            {
             before(grammarAccess.getTupleExpAccess().getGroup_4()); 
            // InternalDOcl.g:6836:2: ( rule__TupleExp__Group_4__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==74) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalDOcl.g:6836:3: rule__TupleExp__Group_4__0
            	    {
            	    pushFollow(FOLLOW_48);
            	    rule__TupleExp__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getTupleExpAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group__4__Impl"


    // $ANTLR start "rule__TupleExp__Group__5"
    // InternalDOcl.g:6844:1: rule__TupleExp__Group__5 : rule__TupleExp__Group__5__Impl ;
    public final void rule__TupleExp__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6848:1: ( rule__TupleExp__Group__5__Impl )
            // InternalDOcl.g:6849:2: rule__TupleExp__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TupleExp__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group__5"


    // $ANTLR start "rule__TupleExp__Group__5__Impl"
    // InternalDOcl.g:6855:1: rule__TupleExp__Group__5__Impl : ( '}' ) ;
    public final void rule__TupleExp__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6859:1: ( ( '}' ) )
            // InternalDOcl.g:6860:1: ( '}' )
            {
            // InternalDOcl.g:6860:1: ( '}' )
            // InternalDOcl.g:6861:2: '}'
            {
             before(grammarAccess.getTupleExpAccess().getRightCurlyBracketKeyword_5()); 
            match(input,78,FOLLOW_2); 
             after(grammarAccess.getTupleExpAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group__5__Impl"


    // $ANTLR start "rule__TupleExp__Group_4__0"
    // InternalDOcl.g:6871:1: rule__TupleExp__Group_4__0 : rule__TupleExp__Group_4__0__Impl rule__TupleExp__Group_4__1 ;
    public final void rule__TupleExp__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6875:1: ( rule__TupleExp__Group_4__0__Impl rule__TupleExp__Group_4__1 )
            // InternalDOcl.g:6876:2: rule__TupleExp__Group_4__0__Impl rule__TupleExp__Group_4__1
            {
            pushFollow(FOLLOW_66);
            rule__TupleExp__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TupleExp__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group_4__0"


    // $ANTLR start "rule__TupleExp__Group_4__0__Impl"
    // InternalDOcl.g:6883:1: rule__TupleExp__Group_4__0__Impl : ( ',' ) ;
    public final void rule__TupleExp__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6887:1: ( ( ',' ) )
            // InternalDOcl.g:6888:1: ( ',' )
            {
            // InternalDOcl.g:6888:1: ( ',' )
            // InternalDOcl.g:6889:2: ','
            {
             before(grammarAccess.getTupleExpAccess().getCommaKeyword_4_0()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getTupleExpAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group_4__0__Impl"


    // $ANTLR start "rule__TupleExp__Group_4__1"
    // InternalDOcl.g:6898:1: rule__TupleExp__Group_4__1 : rule__TupleExp__Group_4__1__Impl ;
    public final void rule__TupleExp__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6902:1: ( rule__TupleExp__Group_4__1__Impl )
            // InternalDOcl.g:6903:2: rule__TupleExp__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TupleExp__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group_4__1"


    // $ANTLR start "rule__TupleExp__Group_4__1__Impl"
    // InternalDOcl.g:6909:1: rule__TupleExp__Group_4__1__Impl : ( ( rule__TupleExp__PartsAssignment_4_1 ) ) ;
    public final void rule__TupleExp__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6913:1: ( ( ( rule__TupleExp__PartsAssignment_4_1 ) ) )
            // InternalDOcl.g:6914:1: ( ( rule__TupleExp__PartsAssignment_4_1 ) )
            {
            // InternalDOcl.g:6914:1: ( ( rule__TupleExp__PartsAssignment_4_1 ) )
            // InternalDOcl.g:6915:2: ( rule__TupleExp__PartsAssignment_4_1 )
            {
             before(grammarAccess.getTupleExpAccess().getPartsAssignment_4_1()); 
            // InternalDOcl.g:6916:2: ( rule__TupleExp__PartsAssignment_4_1 )
            // InternalDOcl.g:6916:3: rule__TupleExp__PartsAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__TupleExp__PartsAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getTupleExpAccess().getPartsAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__Group_4__1__Impl"


    // $ANTLR start "rule__TuplePart__Group__0"
    // InternalDOcl.g:6925:1: rule__TuplePart__Group__0 : rule__TuplePart__Group__0__Impl rule__TuplePart__Group__1 ;
    public final void rule__TuplePart__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6929:1: ( rule__TuplePart__Group__0__Impl rule__TuplePart__Group__1 )
            // InternalDOcl.g:6930:2: rule__TuplePart__Group__0__Impl rule__TuplePart__Group__1
            {
            pushFollow(FOLLOW_68);
            rule__TuplePart__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TuplePart__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__Group__0"


    // $ANTLR start "rule__TuplePart__Group__0__Impl"
    // InternalDOcl.g:6937:1: rule__TuplePart__Group__0__Impl : ( ( rule__TuplePart__NameAssignment_0 ) ) ;
    public final void rule__TuplePart__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6941:1: ( ( ( rule__TuplePart__NameAssignment_0 ) ) )
            // InternalDOcl.g:6942:1: ( ( rule__TuplePart__NameAssignment_0 ) )
            {
            // InternalDOcl.g:6942:1: ( ( rule__TuplePart__NameAssignment_0 ) )
            // InternalDOcl.g:6943:2: ( rule__TuplePart__NameAssignment_0 )
            {
             before(grammarAccess.getTuplePartAccess().getNameAssignment_0()); 
            // InternalDOcl.g:6944:2: ( rule__TuplePart__NameAssignment_0 )
            // InternalDOcl.g:6944:3: rule__TuplePart__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__TuplePart__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTuplePartAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__Group__0__Impl"


    // $ANTLR start "rule__TuplePart__Group__1"
    // InternalDOcl.g:6952:1: rule__TuplePart__Group__1 : rule__TuplePart__Group__1__Impl rule__TuplePart__Group__2 ;
    public final void rule__TuplePart__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6956:1: ( rule__TuplePart__Group__1__Impl rule__TuplePart__Group__2 )
            // InternalDOcl.g:6957:2: rule__TuplePart__Group__1__Impl rule__TuplePart__Group__2
            {
            pushFollow(FOLLOW_68);
            rule__TuplePart__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TuplePart__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__Group__1"


    // $ANTLR start "rule__TuplePart__Group__1__Impl"
    // InternalDOcl.g:6964:1: rule__TuplePart__Group__1__Impl : ( ( rule__TuplePart__Group_1__0 )? ) ;
    public final void rule__TuplePart__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6968:1: ( ( ( rule__TuplePart__Group_1__0 )? ) )
            // InternalDOcl.g:6969:1: ( ( rule__TuplePart__Group_1__0 )? )
            {
            // InternalDOcl.g:6969:1: ( ( rule__TuplePart__Group_1__0 )? )
            // InternalDOcl.g:6970:2: ( rule__TuplePart__Group_1__0 )?
            {
             before(grammarAccess.getTuplePartAccess().getGroup_1()); 
            // InternalDOcl.g:6971:2: ( rule__TuplePart__Group_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==67) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalDOcl.g:6971:3: rule__TuplePart__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TuplePart__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTuplePartAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__Group__1__Impl"


    // $ANTLR start "rule__TuplePart__Group__2"
    // InternalDOcl.g:6979:1: rule__TuplePart__Group__2 : rule__TuplePart__Group__2__Impl rule__TuplePart__Group__3 ;
    public final void rule__TuplePart__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6983:1: ( rule__TuplePart__Group__2__Impl rule__TuplePart__Group__3 )
            // InternalDOcl.g:6984:2: rule__TuplePart__Group__2__Impl rule__TuplePart__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__TuplePart__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TuplePart__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__Group__2"


    // $ANTLR start "rule__TuplePart__Group__2__Impl"
    // InternalDOcl.g:6991:1: rule__TuplePart__Group__2__Impl : ( '=' ) ;
    public final void rule__TuplePart__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:6995:1: ( ( '=' ) )
            // InternalDOcl.g:6996:1: ( '=' )
            {
            // InternalDOcl.g:6996:1: ( '=' )
            // InternalDOcl.g:6997:2: '='
            {
             before(grammarAccess.getTuplePartAccess().getEqualsSignKeyword_2()); 
            match(input,54,FOLLOW_2); 
             after(grammarAccess.getTuplePartAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__Group__2__Impl"


    // $ANTLR start "rule__TuplePart__Group__3"
    // InternalDOcl.g:7006:1: rule__TuplePart__Group__3 : rule__TuplePart__Group__3__Impl ;
    public final void rule__TuplePart__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7010:1: ( rule__TuplePart__Group__3__Impl )
            // InternalDOcl.g:7011:2: rule__TuplePart__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TuplePart__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__Group__3"


    // $ANTLR start "rule__TuplePart__Group__3__Impl"
    // InternalDOcl.g:7017:1: rule__TuplePart__Group__3__Impl : ( ( rule__TuplePart__InitAssignment_3 ) ) ;
    public final void rule__TuplePart__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7021:1: ( ( ( rule__TuplePart__InitAssignment_3 ) ) )
            // InternalDOcl.g:7022:1: ( ( rule__TuplePart__InitAssignment_3 ) )
            {
            // InternalDOcl.g:7022:1: ( ( rule__TuplePart__InitAssignment_3 ) )
            // InternalDOcl.g:7023:2: ( rule__TuplePart__InitAssignment_3 )
            {
             before(grammarAccess.getTuplePartAccess().getInitAssignment_3()); 
            // InternalDOcl.g:7024:2: ( rule__TuplePart__InitAssignment_3 )
            // InternalDOcl.g:7024:3: rule__TuplePart__InitAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TuplePart__InitAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTuplePartAccess().getInitAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__Group__3__Impl"


    // $ANTLR start "rule__TuplePart__Group_1__0"
    // InternalDOcl.g:7033:1: rule__TuplePart__Group_1__0 : rule__TuplePart__Group_1__0__Impl rule__TuplePart__Group_1__1 ;
    public final void rule__TuplePart__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7037:1: ( rule__TuplePart__Group_1__0__Impl rule__TuplePart__Group_1__1 )
            // InternalDOcl.g:7038:2: rule__TuplePart__Group_1__0__Impl rule__TuplePart__Group_1__1
            {
            pushFollow(FOLLOW_53);
            rule__TuplePart__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TuplePart__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__Group_1__0"


    // $ANTLR start "rule__TuplePart__Group_1__0__Impl"
    // InternalDOcl.g:7045:1: rule__TuplePart__Group_1__0__Impl : ( ':' ) ;
    public final void rule__TuplePart__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7049:1: ( ( ':' ) )
            // InternalDOcl.g:7050:1: ( ':' )
            {
            // InternalDOcl.g:7050:1: ( ':' )
            // InternalDOcl.g:7051:2: ':'
            {
             before(grammarAccess.getTuplePartAccess().getColonKeyword_1_0()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getTuplePartAccess().getColonKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__Group_1__0__Impl"


    // $ANTLR start "rule__TuplePart__Group_1__1"
    // InternalDOcl.g:7060:1: rule__TuplePart__Group_1__1 : rule__TuplePart__Group_1__1__Impl ;
    public final void rule__TuplePart__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7064:1: ( rule__TuplePart__Group_1__1__Impl )
            // InternalDOcl.g:7065:2: rule__TuplePart__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TuplePart__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__Group_1__1"


    // $ANTLR start "rule__TuplePart__Group_1__1__Impl"
    // InternalDOcl.g:7071:1: rule__TuplePart__Group_1__1__Impl : ( ( rule__TuplePart__TypeAssignment_1_1 ) ) ;
    public final void rule__TuplePart__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7075:1: ( ( ( rule__TuplePart__TypeAssignment_1_1 ) ) )
            // InternalDOcl.g:7076:1: ( ( rule__TuplePart__TypeAssignment_1_1 ) )
            {
            // InternalDOcl.g:7076:1: ( ( rule__TuplePart__TypeAssignment_1_1 ) )
            // InternalDOcl.g:7077:2: ( rule__TuplePart__TypeAssignment_1_1 )
            {
             before(grammarAccess.getTuplePartAccess().getTypeAssignment_1_1()); 
            // InternalDOcl.g:7078:2: ( rule__TuplePart__TypeAssignment_1_1 )
            // InternalDOcl.g:7078:3: rule__TuplePart__TypeAssignment_1_1
            {
            pushFollow(FOLLOW_2);
            rule__TuplePart__TypeAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTuplePartAccess().getTypeAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__Group_1__1__Impl"


    // $ANTLR start "rule__UnlimitedNaturalExp__Group__0"
    // InternalDOcl.g:7087:1: rule__UnlimitedNaturalExp__Group__0 : rule__UnlimitedNaturalExp__Group__0__Impl rule__UnlimitedNaturalExp__Group__1 ;
    public final void rule__UnlimitedNaturalExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7091:1: ( rule__UnlimitedNaturalExp__Group__0__Impl rule__UnlimitedNaturalExp__Group__1 )
            // InternalDOcl.g:7092:2: rule__UnlimitedNaturalExp__Group__0__Impl rule__UnlimitedNaturalExp__Group__1
            {
            pushFollow(FOLLOW_69);
            rule__UnlimitedNaturalExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__UnlimitedNaturalExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnlimitedNaturalExp__Group__0"


    // $ANTLR start "rule__UnlimitedNaturalExp__Group__0__Impl"
    // InternalDOcl.g:7099:1: rule__UnlimitedNaturalExp__Group__0__Impl : ( () ) ;
    public final void rule__UnlimitedNaturalExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7103:1: ( ( () ) )
            // InternalDOcl.g:7104:1: ( () )
            {
            // InternalDOcl.g:7104:1: ( () )
            // InternalDOcl.g:7105:2: ()
            {
             before(grammarAccess.getUnlimitedNaturalExpAccess().getUnlimitedNaturalLiteralExpAction_0()); 
            // InternalDOcl.g:7106:2: ()
            // InternalDOcl.g:7106:3: 
            {
            }

             after(grammarAccess.getUnlimitedNaturalExpAccess().getUnlimitedNaturalLiteralExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnlimitedNaturalExp__Group__0__Impl"


    // $ANTLR start "rule__UnlimitedNaturalExp__Group__1"
    // InternalDOcl.g:7114:1: rule__UnlimitedNaturalExp__Group__1 : rule__UnlimitedNaturalExp__Group__1__Impl ;
    public final void rule__UnlimitedNaturalExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7118:1: ( rule__UnlimitedNaturalExp__Group__1__Impl )
            // InternalDOcl.g:7119:2: rule__UnlimitedNaturalExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__UnlimitedNaturalExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnlimitedNaturalExp__Group__1"


    // $ANTLR start "rule__UnlimitedNaturalExp__Group__1__Impl"
    // InternalDOcl.g:7125:1: rule__UnlimitedNaturalExp__Group__1__Impl : ( '*' ) ;
    public final void rule__UnlimitedNaturalExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7129:1: ( ( '*' ) )
            // InternalDOcl.g:7130:1: ( '*' )
            {
            // InternalDOcl.g:7130:1: ( '*' )
            // InternalDOcl.g:7131:2: '*'
            {
             before(grammarAccess.getUnlimitedNaturalExpAccess().getAsteriskKeyword_1()); 
            match(input,60,FOLLOW_2); 
             after(grammarAccess.getUnlimitedNaturalExpAccess().getAsteriskKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnlimitedNaturalExp__Group__1__Impl"


    // $ANTLR start "rule__InvalidExp__Group__0"
    // InternalDOcl.g:7141:1: rule__InvalidExp__Group__0 : rule__InvalidExp__Group__0__Impl rule__InvalidExp__Group__1 ;
    public final void rule__InvalidExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7145:1: ( rule__InvalidExp__Group__0__Impl rule__InvalidExp__Group__1 )
            // InternalDOcl.g:7146:2: rule__InvalidExp__Group__0__Impl rule__InvalidExp__Group__1
            {
            pushFollow(FOLLOW_70);
            rule__InvalidExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__InvalidExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvalidExp__Group__0"


    // $ANTLR start "rule__InvalidExp__Group__0__Impl"
    // InternalDOcl.g:7153:1: rule__InvalidExp__Group__0__Impl : ( () ) ;
    public final void rule__InvalidExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7157:1: ( ( () ) )
            // InternalDOcl.g:7158:1: ( () )
            {
            // InternalDOcl.g:7158:1: ( () )
            // InternalDOcl.g:7159:2: ()
            {
             before(grammarAccess.getInvalidExpAccess().getInvalidLiteralExpAction_0()); 
            // InternalDOcl.g:7160:2: ()
            // InternalDOcl.g:7160:3: 
            {
            }

             after(grammarAccess.getInvalidExpAccess().getInvalidLiteralExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvalidExp__Group__0__Impl"


    // $ANTLR start "rule__InvalidExp__Group__1"
    // InternalDOcl.g:7168:1: rule__InvalidExp__Group__1 : rule__InvalidExp__Group__1__Impl ;
    public final void rule__InvalidExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7172:1: ( rule__InvalidExp__Group__1__Impl )
            // InternalDOcl.g:7173:2: rule__InvalidExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__InvalidExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvalidExp__Group__1"


    // $ANTLR start "rule__InvalidExp__Group__1__Impl"
    // InternalDOcl.g:7179:1: rule__InvalidExp__Group__1__Impl : ( 'invalid' ) ;
    public final void rule__InvalidExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7183:1: ( ( 'invalid' ) )
            // InternalDOcl.g:7184:1: ( 'invalid' )
            {
            // InternalDOcl.g:7184:1: ( 'invalid' )
            // InternalDOcl.g:7185:2: 'invalid'
            {
             before(grammarAccess.getInvalidExpAccess().getInvalidKeyword_1()); 
            match(input,79,FOLLOW_2); 
             after(grammarAccess.getInvalidExpAccess().getInvalidKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__InvalidExp__Group__1__Impl"


    // $ANTLR start "rule__NullExp__Group__0"
    // InternalDOcl.g:7195:1: rule__NullExp__Group__0 : rule__NullExp__Group__0__Impl rule__NullExp__Group__1 ;
    public final void rule__NullExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7199:1: ( rule__NullExp__Group__0__Impl rule__NullExp__Group__1 )
            // InternalDOcl.g:7200:2: rule__NullExp__Group__0__Impl rule__NullExp__Group__1
            {
            pushFollow(FOLLOW_71);
            rule__NullExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NullExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullExp__Group__0"


    // $ANTLR start "rule__NullExp__Group__0__Impl"
    // InternalDOcl.g:7207:1: rule__NullExp__Group__0__Impl : ( () ) ;
    public final void rule__NullExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7211:1: ( ( () ) )
            // InternalDOcl.g:7212:1: ( () )
            {
            // InternalDOcl.g:7212:1: ( () )
            // InternalDOcl.g:7213:2: ()
            {
             before(grammarAccess.getNullExpAccess().getNullLiteralExpAction_0()); 
            // InternalDOcl.g:7214:2: ()
            // InternalDOcl.g:7214:3: 
            {
            }

             after(grammarAccess.getNullExpAccess().getNullLiteralExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullExp__Group__0__Impl"


    // $ANTLR start "rule__NullExp__Group__1"
    // InternalDOcl.g:7222:1: rule__NullExp__Group__1 : rule__NullExp__Group__1__Impl ;
    public final void rule__NullExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7226:1: ( rule__NullExp__Group__1__Impl )
            // InternalDOcl.g:7227:2: rule__NullExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NullExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullExp__Group__1"


    // $ANTLR start "rule__NullExp__Group__1__Impl"
    // InternalDOcl.g:7233:1: rule__NullExp__Group__1__Impl : ( 'null' ) ;
    public final void rule__NullExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7237:1: ( ( 'null' ) )
            // InternalDOcl.g:7238:1: ( 'null' )
            {
            // InternalDOcl.g:7238:1: ( 'null' )
            // InternalDOcl.g:7239:2: 'null'
            {
             before(grammarAccess.getNullExpAccess().getNullKeyword_1()); 
            match(input,80,FOLLOW_2); 
             after(grammarAccess.getNullExpAccess().getNullKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullExp__Group__1__Impl"


    // $ANTLR start "rule__IfExp__Group__0"
    // InternalDOcl.g:7249:1: rule__IfExp__Group__0 : rule__IfExp__Group__0__Impl rule__IfExp__Group__1 ;
    public final void rule__IfExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7253:1: ( rule__IfExp__Group__0__Impl rule__IfExp__Group__1 )
            // InternalDOcl.g:7254:2: rule__IfExp__Group__0__Impl rule__IfExp__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__IfExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__0"


    // $ANTLR start "rule__IfExp__Group__0__Impl"
    // InternalDOcl.g:7261:1: rule__IfExp__Group__0__Impl : ( ( rule__IfExp__NameAssignment_0 ) ) ;
    public final void rule__IfExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7265:1: ( ( ( rule__IfExp__NameAssignment_0 ) ) )
            // InternalDOcl.g:7266:1: ( ( rule__IfExp__NameAssignment_0 ) )
            {
            // InternalDOcl.g:7266:1: ( ( rule__IfExp__NameAssignment_0 ) )
            // InternalDOcl.g:7267:2: ( rule__IfExp__NameAssignment_0 )
            {
             before(grammarAccess.getIfExpAccess().getNameAssignment_0()); 
            // InternalDOcl.g:7268:2: ( rule__IfExp__NameAssignment_0 )
            // InternalDOcl.g:7268:3: rule__IfExp__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__IfExp__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getIfExpAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__0__Impl"


    // $ANTLR start "rule__IfExp__Group__1"
    // InternalDOcl.g:7276:1: rule__IfExp__Group__1 : rule__IfExp__Group__1__Impl rule__IfExp__Group__2 ;
    public final void rule__IfExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7280:1: ( rule__IfExp__Group__1__Impl rule__IfExp__Group__2 )
            // InternalDOcl.g:7281:2: rule__IfExp__Group__1__Impl rule__IfExp__Group__2
            {
            pushFollow(FOLLOW_72);
            rule__IfExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__1"


    // $ANTLR start "rule__IfExp__Group__1__Impl"
    // InternalDOcl.g:7288:1: rule__IfExp__Group__1__Impl : ( ( rule__IfExp__ConditionAssignment_1 ) ) ;
    public final void rule__IfExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7292:1: ( ( ( rule__IfExp__ConditionAssignment_1 ) ) )
            // InternalDOcl.g:7293:1: ( ( rule__IfExp__ConditionAssignment_1 ) )
            {
            // InternalDOcl.g:7293:1: ( ( rule__IfExp__ConditionAssignment_1 ) )
            // InternalDOcl.g:7294:2: ( rule__IfExp__ConditionAssignment_1 )
            {
             before(grammarAccess.getIfExpAccess().getConditionAssignment_1()); 
            // InternalDOcl.g:7295:2: ( rule__IfExp__ConditionAssignment_1 )
            // InternalDOcl.g:7295:3: rule__IfExp__ConditionAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__IfExp__ConditionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIfExpAccess().getConditionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__1__Impl"


    // $ANTLR start "rule__IfExp__Group__2"
    // InternalDOcl.g:7303:1: rule__IfExp__Group__2 : rule__IfExp__Group__2__Impl rule__IfExp__Group__3 ;
    public final void rule__IfExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7307:1: ( rule__IfExp__Group__2__Impl rule__IfExp__Group__3 )
            // InternalDOcl.g:7308:2: rule__IfExp__Group__2__Impl rule__IfExp__Group__3
            {
            pushFollow(FOLLOW_22);
            rule__IfExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__2"


    // $ANTLR start "rule__IfExp__Group__2__Impl"
    // InternalDOcl.g:7315:1: rule__IfExp__Group__2__Impl : ( 'then' ) ;
    public final void rule__IfExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7319:1: ( ( 'then' ) )
            // InternalDOcl.g:7320:1: ( 'then' )
            {
            // InternalDOcl.g:7320:1: ( 'then' )
            // InternalDOcl.g:7321:2: 'then'
            {
             before(grammarAccess.getIfExpAccess().getThenKeyword_2()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getIfExpAccess().getThenKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__2__Impl"


    // $ANTLR start "rule__IfExp__Group__3"
    // InternalDOcl.g:7330:1: rule__IfExp__Group__3 : rule__IfExp__Group__3__Impl rule__IfExp__Group__4 ;
    public final void rule__IfExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7334:1: ( rule__IfExp__Group__3__Impl rule__IfExp__Group__4 )
            // InternalDOcl.g:7335:2: rule__IfExp__Group__3__Impl rule__IfExp__Group__4
            {
            pushFollow(FOLLOW_73);
            rule__IfExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExp__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__3"


    // $ANTLR start "rule__IfExp__Group__3__Impl"
    // InternalDOcl.g:7342:1: rule__IfExp__Group__3__Impl : ( ( rule__IfExp__ThenAssignment_3 ) ) ;
    public final void rule__IfExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7346:1: ( ( ( rule__IfExp__ThenAssignment_3 ) ) )
            // InternalDOcl.g:7347:1: ( ( rule__IfExp__ThenAssignment_3 ) )
            {
            // InternalDOcl.g:7347:1: ( ( rule__IfExp__ThenAssignment_3 ) )
            // InternalDOcl.g:7348:2: ( rule__IfExp__ThenAssignment_3 )
            {
             before(grammarAccess.getIfExpAccess().getThenAssignment_3()); 
            // InternalDOcl.g:7349:2: ( rule__IfExp__ThenAssignment_3 )
            // InternalDOcl.g:7349:3: rule__IfExp__ThenAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__IfExp__ThenAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIfExpAccess().getThenAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__3__Impl"


    // $ANTLR start "rule__IfExp__Group__4"
    // InternalDOcl.g:7357:1: rule__IfExp__Group__4 : rule__IfExp__Group__4__Impl rule__IfExp__Group__5 ;
    public final void rule__IfExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7361:1: ( rule__IfExp__Group__4__Impl rule__IfExp__Group__5 )
            // InternalDOcl.g:7362:2: rule__IfExp__Group__4__Impl rule__IfExp__Group__5
            {
            pushFollow(FOLLOW_73);
            rule__IfExp__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExp__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__4"


    // $ANTLR start "rule__IfExp__Group__4__Impl"
    // InternalDOcl.g:7369:1: rule__IfExp__Group__4__Impl : ( ( rule__IfExp__IfThenAssignment_4 )* ) ;
    public final void rule__IfExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7373:1: ( ( ( rule__IfExp__IfThenAssignment_4 )* ) )
            // InternalDOcl.g:7374:1: ( ( rule__IfExp__IfThenAssignment_4 )* )
            {
            // InternalDOcl.g:7374:1: ( ( rule__IfExp__IfThenAssignment_4 )* )
            // InternalDOcl.g:7375:2: ( rule__IfExp__IfThenAssignment_4 )*
            {
             before(grammarAccess.getIfExpAccess().getIfThenAssignment_4()); 
            // InternalDOcl.g:7376:2: ( rule__IfExp__IfThenAssignment_4 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==92) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalDOcl.g:7376:3: rule__IfExp__IfThenAssignment_4
            	    {
            	    pushFollow(FOLLOW_74);
            	    rule__IfExp__IfThenAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

             after(grammarAccess.getIfExpAccess().getIfThenAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__4__Impl"


    // $ANTLR start "rule__IfExp__Group__5"
    // InternalDOcl.g:7384:1: rule__IfExp__Group__5 : rule__IfExp__Group__5__Impl rule__IfExp__Group__6 ;
    public final void rule__IfExp__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7388:1: ( rule__IfExp__Group__5__Impl rule__IfExp__Group__6 )
            // InternalDOcl.g:7389:2: rule__IfExp__Group__5__Impl rule__IfExp__Group__6
            {
            pushFollow(FOLLOW_22);
            rule__IfExp__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExp__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__5"


    // $ANTLR start "rule__IfExp__Group__5__Impl"
    // InternalDOcl.g:7396:1: rule__IfExp__Group__5__Impl : ( 'else' ) ;
    public final void rule__IfExp__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7400:1: ( ( 'else' ) )
            // InternalDOcl.g:7401:1: ( 'else' )
            {
            // InternalDOcl.g:7401:1: ( 'else' )
            // InternalDOcl.g:7402:2: 'else'
            {
             before(grammarAccess.getIfExpAccess().getElseKeyword_5()); 
            match(input,82,FOLLOW_2); 
             after(grammarAccess.getIfExpAccess().getElseKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__5__Impl"


    // $ANTLR start "rule__IfExp__Group__6"
    // InternalDOcl.g:7411:1: rule__IfExp__Group__6 : rule__IfExp__Group__6__Impl rule__IfExp__Group__7 ;
    public final void rule__IfExp__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7415:1: ( rule__IfExp__Group__6__Impl rule__IfExp__Group__7 )
            // InternalDOcl.g:7416:2: rule__IfExp__Group__6__Impl rule__IfExp__Group__7
            {
            pushFollow(FOLLOW_75);
            rule__IfExp__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IfExp__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__6"


    // $ANTLR start "rule__IfExp__Group__6__Impl"
    // InternalDOcl.g:7423:1: rule__IfExp__Group__6__Impl : ( ( rule__IfExp__ElseAssignment_6 ) ) ;
    public final void rule__IfExp__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7427:1: ( ( ( rule__IfExp__ElseAssignment_6 ) ) )
            // InternalDOcl.g:7428:1: ( ( rule__IfExp__ElseAssignment_6 ) )
            {
            // InternalDOcl.g:7428:1: ( ( rule__IfExp__ElseAssignment_6 ) )
            // InternalDOcl.g:7429:2: ( rule__IfExp__ElseAssignment_6 )
            {
             before(grammarAccess.getIfExpAccess().getElseAssignment_6()); 
            // InternalDOcl.g:7430:2: ( rule__IfExp__ElseAssignment_6 )
            // InternalDOcl.g:7430:3: rule__IfExp__ElseAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__IfExp__ElseAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getIfExpAccess().getElseAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__6__Impl"


    // $ANTLR start "rule__IfExp__Group__7"
    // InternalDOcl.g:7438:1: rule__IfExp__Group__7 : rule__IfExp__Group__7__Impl ;
    public final void rule__IfExp__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7442:1: ( rule__IfExp__Group__7__Impl )
            // InternalDOcl.g:7443:2: rule__IfExp__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IfExp__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__7"


    // $ANTLR start "rule__IfExp__Group__7__Impl"
    // InternalDOcl.g:7449:1: rule__IfExp__Group__7__Impl : ( 'endif' ) ;
    public final void rule__IfExp__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7453:1: ( ( 'endif' ) )
            // InternalDOcl.g:7454:1: ( 'endif' )
            {
            // InternalDOcl.g:7454:1: ( 'endif' )
            // InternalDOcl.g:7455:2: 'endif'
            {
             before(grammarAccess.getIfExpAccess().getEndifKeyword_7()); 
            match(input,83,FOLLOW_2); 
             after(grammarAccess.getIfExpAccess().getEndifKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__Group__7__Impl"


    // $ANTLR start "rule__ElseIfThenExp__Group__0"
    // InternalDOcl.g:7465:1: rule__ElseIfThenExp__Group__0 : rule__ElseIfThenExp__Group__0__Impl rule__ElseIfThenExp__Group__1 ;
    public final void rule__ElseIfThenExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7469:1: ( rule__ElseIfThenExp__Group__0__Impl rule__ElseIfThenExp__Group__1 )
            // InternalDOcl.g:7470:2: rule__ElseIfThenExp__Group__0__Impl rule__ElseIfThenExp__Group__1
            {
            pushFollow(FOLLOW_76);
            rule__ElseIfThenExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ElseIfThenExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__Group__0"


    // $ANTLR start "rule__ElseIfThenExp__Group__0__Impl"
    // InternalDOcl.g:7477:1: rule__ElseIfThenExp__Group__0__Impl : ( () ) ;
    public final void rule__ElseIfThenExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7481:1: ( ( () ) )
            // InternalDOcl.g:7482:1: ( () )
            {
            // InternalDOcl.g:7482:1: ( () )
            // InternalDOcl.g:7483:2: ()
            {
             before(grammarAccess.getElseIfThenExpAccess().getElseIfThenExpAction_0()); 
            // InternalDOcl.g:7484:2: ()
            // InternalDOcl.g:7484:3: 
            {
            }

             after(grammarAccess.getElseIfThenExpAccess().getElseIfThenExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__Group__0__Impl"


    // $ANTLR start "rule__ElseIfThenExp__Group__1"
    // InternalDOcl.g:7492:1: rule__ElseIfThenExp__Group__1 : rule__ElseIfThenExp__Group__1__Impl rule__ElseIfThenExp__Group__2 ;
    public final void rule__ElseIfThenExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7496:1: ( rule__ElseIfThenExp__Group__1__Impl rule__ElseIfThenExp__Group__2 )
            // InternalDOcl.g:7497:2: rule__ElseIfThenExp__Group__1__Impl rule__ElseIfThenExp__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__ElseIfThenExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ElseIfThenExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__Group__1"


    // $ANTLR start "rule__ElseIfThenExp__Group__1__Impl"
    // InternalDOcl.g:7504:1: rule__ElseIfThenExp__Group__1__Impl : ( ( rule__ElseIfThenExp__NameAssignment_1 ) ) ;
    public final void rule__ElseIfThenExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7508:1: ( ( ( rule__ElseIfThenExp__NameAssignment_1 ) ) )
            // InternalDOcl.g:7509:1: ( ( rule__ElseIfThenExp__NameAssignment_1 ) )
            {
            // InternalDOcl.g:7509:1: ( ( rule__ElseIfThenExp__NameAssignment_1 ) )
            // InternalDOcl.g:7510:2: ( rule__ElseIfThenExp__NameAssignment_1 )
            {
             before(grammarAccess.getElseIfThenExpAccess().getNameAssignment_1()); 
            // InternalDOcl.g:7511:2: ( rule__ElseIfThenExp__NameAssignment_1 )
            // InternalDOcl.g:7511:3: rule__ElseIfThenExp__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__ElseIfThenExp__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getElseIfThenExpAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__Group__1__Impl"


    // $ANTLR start "rule__ElseIfThenExp__Group__2"
    // InternalDOcl.g:7519:1: rule__ElseIfThenExp__Group__2 : rule__ElseIfThenExp__Group__2__Impl rule__ElseIfThenExp__Group__3 ;
    public final void rule__ElseIfThenExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7523:1: ( rule__ElseIfThenExp__Group__2__Impl rule__ElseIfThenExp__Group__3 )
            // InternalDOcl.g:7524:2: rule__ElseIfThenExp__Group__2__Impl rule__ElseIfThenExp__Group__3
            {
            pushFollow(FOLLOW_72);
            rule__ElseIfThenExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ElseIfThenExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__Group__2"


    // $ANTLR start "rule__ElseIfThenExp__Group__2__Impl"
    // InternalDOcl.g:7531:1: rule__ElseIfThenExp__Group__2__Impl : ( ( rule__ElseIfThenExp__ConditionAssignment_2 ) ) ;
    public final void rule__ElseIfThenExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7535:1: ( ( ( rule__ElseIfThenExp__ConditionAssignment_2 ) ) )
            // InternalDOcl.g:7536:1: ( ( rule__ElseIfThenExp__ConditionAssignment_2 ) )
            {
            // InternalDOcl.g:7536:1: ( ( rule__ElseIfThenExp__ConditionAssignment_2 ) )
            // InternalDOcl.g:7537:2: ( rule__ElseIfThenExp__ConditionAssignment_2 )
            {
             before(grammarAccess.getElseIfThenExpAccess().getConditionAssignment_2()); 
            // InternalDOcl.g:7538:2: ( rule__ElseIfThenExp__ConditionAssignment_2 )
            // InternalDOcl.g:7538:3: rule__ElseIfThenExp__ConditionAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ElseIfThenExp__ConditionAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getElseIfThenExpAccess().getConditionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__Group__2__Impl"


    // $ANTLR start "rule__ElseIfThenExp__Group__3"
    // InternalDOcl.g:7546:1: rule__ElseIfThenExp__Group__3 : rule__ElseIfThenExp__Group__3__Impl rule__ElseIfThenExp__Group__4 ;
    public final void rule__ElseIfThenExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7550:1: ( rule__ElseIfThenExp__Group__3__Impl rule__ElseIfThenExp__Group__4 )
            // InternalDOcl.g:7551:2: rule__ElseIfThenExp__Group__3__Impl rule__ElseIfThenExp__Group__4
            {
            pushFollow(FOLLOW_22);
            rule__ElseIfThenExp__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ElseIfThenExp__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__Group__3"


    // $ANTLR start "rule__ElseIfThenExp__Group__3__Impl"
    // InternalDOcl.g:7558:1: rule__ElseIfThenExp__Group__3__Impl : ( 'then' ) ;
    public final void rule__ElseIfThenExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7562:1: ( ( 'then' ) )
            // InternalDOcl.g:7563:1: ( 'then' )
            {
            // InternalDOcl.g:7563:1: ( 'then' )
            // InternalDOcl.g:7564:2: 'then'
            {
             before(grammarAccess.getElseIfThenExpAccess().getThenKeyword_3()); 
            match(input,81,FOLLOW_2); 
             after(grammarAccess.getElseIfThenExpAccess().getThenKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__Group__3__Impl"


    // $ANTLR start "rule__ElseIfThenExp__Group__4"
    // InternalDOcl.g:7573:1: rule__ElseIfThenExp__Group__4 : rule__ElseIfThenExp__Group__4__Impl ;
    public final void rule__ElseIfThenExp__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7577:1: ( rule__ElseIfThenExp__Group__4__Impl )
            // InternalDOcl.g:7578:2: rule__ElseIfThenExp__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ElseIfThenExp__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__Group__4"


    // $ANTLR start "rule__ElseIfThenExp__Group__4__Impl"
    // InternalDOcl.g:7584:1: rule__ElseIfThenExp__Group__4__Impl : ( ( rule__ElseIfThenExp__ThenAssignment_4 ) ) ;
    public final void rule__ElseIfThenExp__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7588:1: ( ( ( rule__ElseIfThenExp__ThenAssignment_4 ) ) )
            // InternalDOcl.g:7589:1: ( ( rule__ElseIfThenExp__ThenAssignment_4 ) )
            {
            // InternalDOcl.g:7589:1: ( ( rule__ElseIfThenExp__ThenAssignment_4 ) )
            // InternalDOcl.g:7590:2: ( rule__ElseIfThenExp__ThenAssignment_4 )
            {
             before(grammarAccess.getElseIfThenExpAccess().getThenAssignment_4()); 
            // InternalDOcl.g:7591:2: ( rule__ElseIfThenExp__ThenAssignment_4 )
            // InternalDOcl.g:7591:3: rule__ElseIfThenExp__ThenAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__ElseIfThenExp__ThenAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getElseIfThenExpAccess().getThenAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__Group__4__Impl"


    // $ANTLR start "rule__SeflExp__Group__0"
    // InternalDOcl.g:7600:1: rule__SeflExp__Group__0 : rule__SeflExp__Group__0__Impl rule__SeflExp__Group__1 ;
    public final void rule__SeflExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7604:1: ( rule__SeflExp__Group__0__Impl rule__SeflExp__Group__1 )
            // InternalDOcl.g:7605:2: rule__SeflExp__Group__0__Impl rule__SeflExp__Group__1
            {
            pushFollow(FOLLOW_77);
            rule__SeflExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SeflExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SeflExp__Group__0"


    // $ANTLR start "rule__SeflExp__Group__0__Impl"
    // InternalDOcl.g:7612:1: rule__SeflExp__Group__0__Impl : ( () ) ;
    public final void rule__SeflExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7616:1: ( ( () ) )
            // InternalDOcl.g:7617:1: ( () )
            {
            // InternalDOcl.g:7617:1: ( () )
            // InternalDOcl.g:7618:2: ()
            {
             before(grammarAccess.getSeflExpAccess().getSelfExpAction_0()); 
            // InternalDOcl.g:7619:2: ()
            // InternalDOcl.g:7619:3: 
            {
            }

             after(grammarAccess.getSeflExpAccess().getSelfExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SeflExp__Group__0__Impl"


    // $ANTLR start "rule__SeflExp__Group__1"
    // InternalDOcl.g:7627:1: rule__SeflExp__Group__1 : rule__SeflExp__Group__1__Impl ;
    public final void rule__SeflExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7631:1: ( rule__SeflExp__Group__1__Impl )
            // InternalDOcl.g:7632:2: rule__SeflExp__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SeflExp__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SeflExp__Group__1"


    // $ANTLR start "rule__SeflExp__Group__1__Impl"
    // InternalDOcl.g:7638:1: rule__SeflExp__Group__1__Impl : ( ( rule__SeflExp__NameAssignment_1 ) ) ;
    public final void rule__SeflExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7642:1: ( ( ( rule__SeflExp__NameAssignment_1 ) ) )
            // InternalDOcl.g:7643:1: ( ( rule__SeflExp__NameAssignment_1 ) )
            {
            // InternalDOcl.g:7643:1: ( ( rule__SeflExp__NameAssignment_1 ) )
            // InternalDOcl.g:7644:2: ( rule__SeflExp__NameAssignment_1 )
            {
             before(grammarAccess.getSeflExpAccess().getNameAssignment_1()); 
            // InternalDOcl.g:7645:2: ( rule__SeflExp__NameAssignment_1 )
            // InternalDOcl.g:7645:3: rule__SeflExp__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__SeflExp__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSeflExpAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SeflExp__Group__1__Impl"


    // $ANTLR start "rule__NestedExp__Group__0"
    // InternalDOcl.g:7654:1: rule__NestedExp__Group__0 : rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1 ;
    public final void rule__NestedExp__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7658:1: ( rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1 )
            // InternalDOcl.g:7659:2: rule__NestedExp__Group__0__Impl rule__NestedExp__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__NestedExp__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NestedExp__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__0"


    // $ANTLR start "rule__NestedExp__Group__0__Impl"
    // InternalDOcl.g:7666:1: rule__NestedExp__Group__0__Impl : ( () ) ;
    public final void rule__NestedExp__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7670:1: ( ( () ) )
            // InternalDOcl.g:7671:1: ( () )
            {
            // InternalDOcl.g:7671:1: ( () )
            // InternalDOcl.g:7672:2: ()
            {
             before(grammarAccess.getNestedExpAccess().getNestedExpAction_0()); 
            // InternalDOcl.g:7673:2: ()
            // InternalDOcl.g:7673:3: 
            {
            }

             after(grammarAccess.getNestedExpAccess().getNestedExpAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__0__Impl"


    // $ANTLR start "rule__NestedExp__Group__1"
    // InternalDOcl.g:7681:1: rule__NestedExp__Group__1 : rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2 ;
    public final void rule__NestedExp__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7685:1: ( rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2 )
            // InternalDOcl.g:7686:2: rule__NestedExp__Group__1__Impl rule__NestedExp__Group__2
            {
            pushFollow(FOLLOW_22);
            rule__NestedExp__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NestedExp__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__1"


    // $ANTLR start "rule__NestedExp__Group__1__Impl"
    // InternalDOcl.g:7693:1: rule__NestedExp__Group__1__Impl : ( '(' ) ;
    public final void rule__NestedExp__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7697:1: ( ( '(' ) )
            // InternalDOcl.g:7698:1: ( '(' )
            {
            // InternalDOcl.g:7698:1: ( '(' )
            // InternalDOcl.g:7699:2: '('
            {
             before(grammarAccess.getNestedExpAccess().getLeftParenthesisKeyword_1()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getNestedExpAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__1__Impl"


    // $ANTLR start "rule__NestedExp__Group__2"
    // InternalDOcl.g:7708:1: rule__NestedExp__Group__2 : rule__NestedExp__Group__2__Impl rule__NestedExp__Group__3 ;
    public final void rule__NestedExp__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7712:1: ( rule__NestedExp__Group__2__Impl rule__NestedExp__Group__3 )
            // InternalDOcl.g:7713:2: rule__NestedExp__Group__2__Impl rule__NestedExp__Group__3
            {
            pushFollow(FOLLOW_52);
            rule__NestedExp__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NestedExp__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__2"


    // $ANTLR start "rule__NestedExp__Group__2__Impl"
    // InternalDOcl.g:7720:1: rule__NestedExp__Group__2__Impl : ( ( rule__NestedExp__ExpAssignment_2 ) ) ;
    public final void rule__NestedExp__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7724:1: ( ( ( rule__NestedExp__ExpAssignment_2 ) ) )
            // InternalDOcl.g:7725:1: ( ( rule__NestedExp__ExpAssignment_2 ) )
            {
            // InternalDOcl.g:7725:1: ( ( rule__NestedExp__ExpAssignment_2 ) )
            // InternalDOcl.g:7726:2: ( rule__NestedExp__ExpAssignment_2 )
            {
             before(grammarAccess.getNestedExpAccess().getExpAssignment_2()); 
            // InternalDOcl.g:7727:2: ( rule__NestedExp__ExpAssignment_2 )
            // InternalDOcl.g:7727:3: rule__NestedExp__ExpAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__NestedExp__ExpAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getNestedExpAccess().getExpAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__2__Impl"


    // $ANTLR start "rule__NestedExp__Group__3"
    // InternalDOcl.g:7735:1: rule__NestedExp__Group__3 : rule__NestedExp__Group__3__Impl ;
    public final void rule__NestedExp__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7739:1: ( rule__NestedExp__Group__3__Impl )
            // InternalDOcl.g:7740:2: rule__NestedExp__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NestedExp__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__3"


    // $ANTLR start "rule__NestedExp__Group__3__Impl"
    // InternalDOcl.g:7746:1: rule__NestedExp__Group__3__Impl : ( ')' ) ;
    public final void rule__NestedExp__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7750:1: ( ( ')' ) )
            // InternalDOcl.g:7751:1: ( ')' )
            {
            // InternalDOcl.g:7751:1: ( ')' )
            // InternalDOcl.g:7752:2: ')'
            {
             before(grammarAccess.getNestedExpAccess().getRightParenthesisKeyword_3()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getNestedExpAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__Group__3__Impl"


    // $ANTLR start "rule__OclModelElement__Group__0"
    // InternalDOcl.g:7762:1: rule__OclModelElement__Group__0 : rule__OclModelElement__Group__0__Impl rule__OclModelElement__Group__1 ;
    public final void rule__OclModelElement__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7766:1: ( rule__OclModelElement__Group__0__Impl rule__OclModelElement__Group__1 )
            // InternalDOcl.g:7767:2: rule__OclModelElement__Group__0__Impl rule__OclModelElement__Group__1
            {
            pushFollow(FOLLOW_56);
            rule__OclModelElement__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OclModelElement__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElement__Group__0"


    // $ANTLR start "rule__OclModelElement__Group__0__Impl"
    // InternalDOcl.g:7774:1: rule__OclModelElement__Group__0__Impl : ( ( rule__OclModelElement__ModelAssignment_0 ) ) ;
    public final void rule__OclModelElement__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7778:1: ( ( ( rule__OclModelElement__ModelAssignment_0 ) ) )
            // InternalDOcl.g:7779:1: ( ( rule__OclModelElement__ModelAssignment_0 ) )
            {
            // InternalDOcl.g:7779:1: ( ( rule__OclModelElement__ModelAssignment_0 ) )
            // InternalDOcl.g:7780:2: ( rule__OclModelElement__ModelAssignment_0 )
            {
             before(grammarAccess.getOclModelElementAccess().getModelAssignment_0()); 
            // InternalDOcl.g:7781:2: ( rule__OclModelElement__ModelAssignment_0 )
            // InternalDOcl.g:7781:3: rule__OclModelElement__ModelAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OclModelElement__ModelAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOclModelElementAccess().getModelAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElement__Group__0__Impl"


    // $ANTLR start "rule__OclModelElement__Group__1"
    // InternalDOcl.g:7789:1: rule__OclModelElement__Group__1 : rule__OclModelElement__Group__1__Impl rule__OclModelElement__Group__2 ;
    public final void rule__OclModelElement__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7793:1: ( rule__OclModelElement__Group__1__Impl rule__OclModelElement__Group__2 )
            // InternalDOcl.g:7794:2: rule__OclModelElement__Group__1__Impl rule__OclModelElement__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__OclModelElement__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OclModelElement__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElement__Group__1"


    // $ANTLR start "rule__OclModelElement__Group__1__Impl"
    // InternalDOcl.g:7801:1: rule__OclModelElement__Group__1__Impl : ( '::' ) ;
    public final void rule__OclModelElement__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7805:1: ( ( '::' ) )
            // InternalDOcl.g:7806:1: ( '::' )
            {
            // InternalDOcl.g:7806:1: ( '::' )
            // InternalDOcl.g:7807:2: '::'
            {
             before(grammarAccess.getOclModelElementAccess().getColonColonKeyword_1()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getOclModelElementAccess().getColonColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElement__Group__1__Impl"


    // $ANTLR start "rule__OclModelElement__Group__2"
    // InternalDOcl.g:7816:1: rule__OclModelElement__Group__2 : rule__OclModelElement__Group__2__Impl ;
    public final void rule__OclModelElement__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7820:1: ( rule__OclModelElement__Group__2__Impl )
            // InternalDOcl.g:7821:2: rule__OclModelElement__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OclModelElement__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElement__Group__2"


    // $ANTLR start "rule__OclModelElement__Group__2__Impl"
    // InternalDOcl.g:7827:1: rule__OclModelElement__Group__2__Impl : ( ( rule__OclModelElement__NameAssignment_2 ) ) ;
    public final void rule__OclModelElement__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7831:1: ( ( ( rule__OclModelElement__NameAssignment_2 ) ) )
            // InternalDOcl.g:7832:1: ( ( rule__OclModelElement__NameAssignment_2 ) )
            {
            // InternalDOcl.g:7832:1: ( ( rule__OclModelElement__NameAssignment_2 ) )
            // InternalDOcl.g:7833:2: ( rule__OclModelElement__NameAssignment_2 )
            {
             before(grammarAccess.getOclModelElementAccess().getNameAssignment_2()); 
            // InternalDOcl.g:7834:2: ( rule__OclModelElement__NameAssignment_2 )
            // InternalDOcl.g:7834:3: rule__OclModelElement__NameAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__OclModelElement__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOclModelElementAccess().getNameAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElement__Group__2__Impl"


    // $ANTLR start "rule__LambdaType__Group__0"
    // InternalDOcl.g:7843:1: rule__LambdaType__Group__0 : rule__LambdaType__Group__0__Impl rule__LambdaType__Group__1 ;
    public final void rule__LambdaType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7847:1: ( rule__LambdaType__Group__0__Impl rule__LambdaType__Group__1 )
            // InternalDOcl.g:7848:2: rule__LambdaType__Group__0__Impl rule__LambdaType__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__LambdaType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LambdaType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__0"


    // $ANTLR start "rule__LambdaType__Group__0__Impl"
    // InternalDOcl.g:7855:1: rule__LambdaType__Group__0__Impl : ( ( rule__LambdaType__NameAssignment_0 ) ) ;
    public final void rule__LambdaType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7859:1: ( ( ( rule__LambdaType__NameAssignment_0 ) ) )
            // InternalDOcl.g:7860:1: ( ( rule__LambdaType__NameAssignment_0 ) )
            {
            // InternalDOcl.g:7860:1: ( ( rule__LambdaType__NameAssignment_0 ) )
            // InternalDOcl.g:7861:2: ( rule__LambdaType__NameAssignment_0 )
            {
             before(grammarAccess.getLambdaTypeAccess().getNameAssignment_0()); 
            // InternalDOcl.g:7862:2: ( rule__LambdaType__NameAssignment_0 )
            // InternalDOcl.g:7862:3: rule__LambdaType__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__LambdaType__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getLambdaTypeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__0__Impl"


    // $ANTLR start "rule__LambdaType__Group__1"
    // InternalDOcl.g:7870:1: rule__LambdaType__Group__1 : rule__LambdaType__Group__1__Impl rule__LambdaType__Group__2 ;
    public final void rule__LambdaType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7874:1: ( rule__LambdaType__Group__1__Impl rule__LambdaType__Group__2 )
            // InternalDOcl.g:7875:2: rule__LambdaType__Group__1__Impl rule__LambdaType__Group__2
            {
            pushFollow(FOLLOW_53);
            rule__LambdaType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LambdaType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__1"


    // $ANTLR start "rule__LambdaType__Group__1__Impl"
    // InternalDOcl.g:7882:1: rule__LambdaType__Group__1__Impl : ( '(' ) ;
    public final void rule__LambdaType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7886:1: ( ( '(' ) )
            // InternalDOcl.g:7887:1: ( '(' )
            {
            // InternalDOcl.g:7887:1: ( '(' )
            // InternalDOcl.g:7888:2: '('
            {
             before(grammarAccess.getLambdaTypeAccess().getLeftParenthesisKeyword_1()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getLambdaTypeAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__1__Impl"


    // $ANTLR start "rule__LambdaType__Group__2"
    // InternalDOcl.g:7897:1: rule__LambdaType__Group__2 : rule__LambdaType__Group__2__Impl rule__LambdaType__Group__3 ;
    public final void rule__LambdaType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7901:1: ( rule__LambdaType__Group__2__Impl rule__LambdaType__Group__3 )
            // InternalDOcl.g:7902:2: rule__LambdaType__Group__2__Impl rule__LambdaType__Group__3
            {
            pushFollow(FOLLOW_78);
            rule__LambdaType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LambdaType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__2"


    // $ANTLR start "rule__LambdaType__Group__2__Impl"
    // InternalDOcl.g:7909:1: rule__LambdaType__Group__2__Impl : ( ( rule__LambdaType__ArgsTypesAssignment_2 ) ) ;
    public final void rule__LambdaType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7913:1: ( ( ( rule__LambdaType__ArgsTypesAssignment_2 ) ) )
            // InternalDOcl.g:7914:1: ( ( rule__LambdaType__ArgsTypesAssignment_2 ) )
            {
            // InternalDOcl.g:7914:1: ( ( rule__LambdaType__ArgsTypesAssignment_2 ) )
            // InternalDOcl.g:7915:2: ( rule__LambdaType__ArgsTypesAssignment_2 )
            {
             before(grammarAccess.getLambdaTypeAccess().getArgsTypesAssignment_2()); 
            // InternalDOcl.g:7916:2: ( rule__LambdaType__ArgsTypesAssignment_2 )
            // InternalDOcl.g:7916:3: rule__LambdaType__ArgsTypesAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__LambdaType__ArgsTypesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getLambdaTypeAccess().getArgsTypesAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__2__Impl"


    // $ANTLR start "rule__LambdaType__Group__3"
    // InternalDOcl.g:7924:1: rule__LambdaType__Group__3 : rule__LambdaType__Group__3__Impl rule__LambdaType__Group__4 ;
    public final void rule__LambdaType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7928:1: ( rule__LambdaType__Group__3__Impl rule__LambdaType__Group__4 )
            // InternalDOcl.g:7929:2: rule__LambdaType__Group__3__Impl rule__LambdaType__Group__4
            {
            pushFollow(FOLLOW_78);
            rule__LambdaType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LambdaType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__3"


    // $ANTLR start "rule__LambdaType__Group__3__Impl"
    // InternalDOcl.g:7936:1: rule__LambdaType__Group__3__Impl : ( ( rule__LambdaType__Group_3__0 )* ) ;
    public final void rule__LambdaType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7940:1: ( ( ( rule__LambdaType__Group_3__0 )* ) )
            // InternalDOcl.g:7941:1: ( ( rule__LambdaType__Group_3__0 )* )
            {
            // InternalDOcl.g:7941:1: ( ( rule__LambdaType__Group_3__0 )* )
            // InternalDOcl.g:7942:2: ( rule__LambdaType__Group_3__0 )*
            {
             before(grammarAccess.getLambdaTypeAccess().getGroup_3()); 
            // InternalDOcl.g:7943:2: ( rule__LambdaType__Group_3__0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==74) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalDOcl.g:7943:3: rule__LambdaType__Group_3__0
            	    {
            	    pushFollow(FOLLOW_48);
            	    rule__LambdaType__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

             after(grammarAccess.getLambdaTypeAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__3__Impl"


    // $ANTLR start "rule__LambdaType__Group__4"
    // InternalDOcl.g:7951:1: rule__LambdaType__Group__4 : rule__LambdaType__Group__4__Impl rule__LambdaType__Group__5 ;
    public final void rule__LambdaType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7955:1: ( rule__LambdaType__Group__4__Impl rule__LambdaType__Group__5 )
            // InternalDOcl.g:7956:2: rule__LambdaType__Group__4__Impl rule__LambdaType__Group__5
            {
            pushFollow(FOLLOW_21);
            rule__LambdaType__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LambdaType__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__4"


    // $ANTLR start "rule__LambdaType__Group__4__Impl"
    // InternalDOcl.g:7963:1: rule__LambdaType__Group__4__Impl : ( ')' ) ;
    public final void rule__LambdaType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7967:1: ( ( ')' ) )
            // InternalDOcl.g:7968:1: ( ')' )
            {
            // InternalDOcl.g:7968:1: ( ')' )
            // InternalDOcl.g:7969:2: ')'
            {
             before(grammarAccess.getLambdaTypeAccess().getRightParenthesisKeyword_4()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getLambdaTypeAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__4__Impl"


    // $ANTLR start "rule__LambdaType__Group__5"
    // InternalDOcl.g:7978:1: rule__LambdaType__Group__5 : rule__LambdaType__Group__5__Impl rule__LambdaType__Group__6 ;
    public final void rule__LambdaType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7982:1: ( rule__LambdaType__Group__5__Impl rule__LambdaType__Group__6 )
            // InternalDOcl.g:7983:2: rule__LambdaType__Group__5__Impl rule__LambdaType__Group__6
            {
            pushFollow(FOLLOW_53);
            rule__LambdaType__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LambdaType__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__5"


    // $ANTLR start "rule__LambdaType__Group__5__Impl"
    // InternalDOcl.g:7990:1: rule__LambdaType__Group__5__Impl : ( ':' ) ;
    public final void rule__LambdaType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:7994:1: ( ( ':' ) )
            // InternalDOcl.g:7995:1: ( ':' )
            {
            // InternalDOcl.g:7995:1: ( ':' )
            // InternalDOcl.g:7996:2: ':'
            {
             before(grammarAccess.getLambdaTypeAccess().getColonKeyword_5()); 
            match(input,67,FOLLOW_2); 
             after(grammarAccess.getLambdaTypeAccess().getColonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__5__Impl"


    // $ANTLR start "rule__LambdaType__Group__6"
    // InternalDOcl.g:8005:1: rule__LambdaType__Group__6 : rule__LambdaType__Group__6__Impl ;
    public final void rule__LambdaType__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8009:1: ( rule__LambdaType__Group__6__Impl )
            // InternalDOcl.g:8010:2: rule__LambdaType__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LambdaType__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__6"


    // $ANTLR start "rule__LambdaType__Group__6__Impl"
    // InternalDOcl.g:8016:1: rule__LambdaType__Group__6__Impl : ( ( rule__LambdaType__ReturnTypeAssignment_6 ) ) ;
    public final void rule__LambdaType__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8020:1: ( ( ( rule__LambdaType__ReturnTypeAssignment_6 ) ) )
            // InternalDOcl.g:8021:1: ( ( rule__LambdaType__ReturnTypeAssignment_6 ) )
            {
            // InternalDOcl.g:8021:1: ( ( rule__LambdaType__ReturnTypeAssignment_6 ) )
            // InternalDOcl.g:8022:2: ( rule__LambdaType__ReturnTypeAssignment_6 )
            {
             before(grammarAccess.getLambdaTypeAccess().getReturnTypeAssignment_6()); 
            // InternalDOcl.g:8023:2: ( rule__LambdaType__ReturnTypeAssignment_6 )
            // InternalDOcl.g:8023:3: rule__LambdaType__ReturnTypeAssignment_6
            {
            pushFollow(FOLLOW_2);
            rule__LambdaType__ReturnTypeAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getLambdaTypeAccess().getReturnTypeAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group__6__Impl"


    // $ANTLR start "rule__LambdaType__Group_3__0"
    // InternalDOcl.g:8032:1: rule__LambdaType__Group_3__0 : rule__LambdaType__Group_3__0__Impl rule__LambdaType__Group_3__1 ;
    public final void rule__LambdaType__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8036:1: ( rule__LambdaType__Group_3__0__Impl rule__LambdaType__Group_3__1 )
            // InternalDOcl.g:8037:2: rule__LambdaType__Group_3__0__Impl rule__LambdaType__Group_3__1
            {
            pushFollow(FOLLOW_53);
            rule__LambdaType__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__LambdaType__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group_3__0"


    // $ANTLR start "rule__LambdaType__Group_3__0__Impl"
    // InternalDOcl.g:8044:1: rule__LambdaType__Group_3__0__Impl : ( ',' ) ;
    public final void rule__LambdaType__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8048:1: ( ( ',' ) )
            // InternalDOcl.g:8049:1: ( ',' )
            {
            // InternalDOcl.g:8049:1: ( ',' )
            // InternalDOcl.g:8050:2: ','
            {
             before(grammarAccess.getLambdaTypeAccess().getCommaKeyword_3_0()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getLambdaTypeAccess().getCommaKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group_3__0__Impl"


    // $ANTLR start "rule__LambdaType__Group_3__1"
    // InternalDOcl.g:8059:1: rule__LambdaType__Group_3__1 : rule__LambdaType__Group_3__1__Impl ;
    public final void rule__LambdaType__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8063:1: ( rule__LambdaType__Group_3__1__Impl )
            // InternalDOcl.g:8064:2: rule__LambdaType__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__LambdaType__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group_3__1"


    // $ANTLR start "rule__LambdaType__Group_3__1__Impl"
    // InternalDOcl.g:8070:1: rule__LambdaType__Group_3__1__Impl : ( ( rule__LambdaType__ArgsTypesAssignment_3_1 ) ) ;
    public final void rule__LambdaType__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8074:1: ( ( ( rule__LambdaType__ArgsTypesAssignment_3_1 ) ) )
            // InternalDOcl.g:8075:1: ( ( rule__LambdaType__ArgsTypesAssignment_3_1 ) )
            {
            // InternalDOcl.g:8075:1: ( ( rule__LambdaType__ArgsTypesAssignment_3_1 ) )
            // InternalDOcl.g:8076:2: ( rule__LambdaType__ArgsTypesAssignment_3_1 )
            {
             before(grammarAccess.getLambdaTypeAccess().getArgsTypesAssignment_3_1()); 
            // InternalDOcl.g:8077:2: ( rule__LambdaType__ArgsTypesAssignment_3_1 )
            // InternalDOcl.g:8077:3: rule__LambdaType__ArgsTypesAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__LambdaType__ArgsTypesAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getLambdaTypeAccess().getArgsTypesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__Group_3__1__Impl"


    // $ANTLR start "rule__MapType__Group__0"
    // InternalDOcl.g:8086:1: rule__MapType__Group__0 : rule__MapType__Group__0__Impl rule__MapType__Group__1 ;
    public final void rule__MapType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8090:1: ( rule__MapType__Group__0__Impl rule__MapType__Group__1 )
            // InternalDOcl.g:8091:2: rule__MapType__Group__0__Impl rule__MapType__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__MapType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MapType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__0"


    // $ANTLR start "rule__MapType__Group__0__Impl"
    // InternalDOcl.g:8098:1: rule__MapType__Group__0__Impl : ( ( rule__MapType__NameAssignment_0 ) ) ;
    public final void rule__MapType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8102:1: ( ( ( rule__MapType__NameAssignment_0 ) ) )
            // InternalDOcl.g:8103:1: ( ( rule__MapType__NameAssignment_0 ) )
            {
            // InternalDOcl.g:8103:1: ( ( rule__MapType__NameAssignment_0 ) )
            // InternalDOcl.g:8104:2: ( rule__MapType__NameAssignment_0 )
            {
             before(grammarAccess.getMapTypeAccess().getNameAssignment_0()); 
            // InternalDOcl.g:8105:2: ( rule__MapType__NameAssignment_0 )
            // InternalDOcl.g:8105:3: rule__MapType__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__MapType__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMapTypeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__0__Impl"


    // $ANTLR start "rule__MapType__Group__1"
    // InternalDOcl.g:8113:1: rule__MapType__Group__1 : rule__MapType__Group__1__Impl rule__MapType__Group__2 ;
    public final void rule__MapType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8117:1: ( rule__MapType__Group__1__Impl rule__MapType__Group__2 )
            // InternalDOcl.g:8118:2: rule__MapType__Group__1__Impl rule__MapType__Group__2
            {
            pushFollow(FOLLOW_53);
            rule__MapType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MapType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__1"


    // $ANTLR start "rule__MapType__Group__1__Impl"
    // InternalDOcl.g:8125:1: rule__MapType__Group__1__Impl : ( '(' ) ;
    public final void rule__MapType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8129:1: ( ( '(' ) )
            // InternalDOcl.g:8130:1: ( '(' )
            {
            // InternalDOcl.g:8130:1: ( '(' )
            // InternalDOcl.g:8131:2: '('
            {
             before(grammarAccess.getMapTypeAccess().getLeftParenthesisKeyword_1()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getMapTypeAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__1__Impl"


    // $ANTLR start "rule__MapType__Group__2"
    // InternalDOcl.g:8140:1: rule__MapType__Group__2 : rule__MapType__Group__2__Impl rule__MapType__Group__3 ;
    public final void rule__MapType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8144:1: ( rule__MapType__Group__2__Impl rule__MapType__Group__3 )
            // InternalDOcl.g:8145:2: rule__MapType__Group__2__Impl rule__MapType__Group__3
            {
            pushFollow(FOLLOW_47);
            rule__MapType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MapType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__2"


    // $ANTLR start "rule__MapType__Group__2__Impl"
    // InternalDOcl.g:8152:1: rule__MapType__Group__2__Impl : ( ( rule__MapType__KeyTypeAssignment_2 ) ) ;
    public final void rule__MapType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8156:1: ( ( ( rule__MapType__KeyTypeAssignment_2 ) ) )
            // InternalDOcl.g:8157:1: ( ( rule__MapType__KeyTypeAssignment_2 ) )
            {
            // InternalDOcl.g:8157:1: ( ( rule__MapType__KeyTypeAssignment_2 ) )
            // InternalDOcl.g:8158:2: ( rule__MapType__KeyTypeAssignment_2 )
            {
             before(grammarAccess.getMapTypeAccess().getKeyTypeAssignment_2()); 
            // InternalDOcl.g:8159:2: ( rule__MapType__KeyTypeAssignment_2 )
            // InternalDOcl.g:8159:3: rule__MapType__KeyTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__MapType__KeyTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMapTypeAccess().getKeyTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__2__Impl"


    // $ANTLR start "rule__MapType__Group__3"
    // InternalDOcl.g:8167:1: rule__MapType__Group__3 : rule__MapType__Group__3__Impl rule__MapType__Group__4 ;
    public final void rule__MapType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8171:1: ( rule__MapType__Group__3__Impl rule__MapType__Group__4 )
            // InternalDOcl.g:8172:2: rule__MapType__Group__3__Impl rule__MapType__Group__4
            {
            pushFollow(FOLLOW_53);
            rule__MapType__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MapType__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__3"


    // $ANTLR start "rule__MapType__Group__3__Impl"
    // InternalDOcl.g:8179:1: rule__MapType__Group__3__Impl : ( ',' ) ;
    public final void rule__MapType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8183:1: ( ( ',' ) )
            // InternalDOcl.g:8184:1: ( ',' )
            {
            // InternalDOcl.g:8184:1: ( ',' )
            // InternalDOcl.g:8185:2: ','
            {
             before(grammarAccess.getMapTypeAccess().getCommaKeyword_3()); 
            match(input,74,FOLLOW_2); 
             after(grammarAccess.getMapTypeAccess().getCommaKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__3__Impl"


    // $ANTLR start "rule__MapType__Group__4"
    // InternalDOcl.g:8194:1: rule__MapType__Group__4 : rule__MapType__Group__4__Impl rule__MapType__Group__5 ;
    public final void rule__MapType__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8198:1: ( rule__MapType__Group__4__Impl rule__MapType__Group__5 )
            // InternalDOcl.g:8199:2: rule__MapType__Group__4__Impl rule__MapType__Group__5
            {
            pushFollow(FOLLOW_52);
            rule__MapType__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MapType__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__4"


    // $ANTLR start "rule__MapType__Group__4__Impl"
    // InternalDOcl.g:8206:1: rule__MapType__Group__4__Impl : ( ( rule__MapType__ValueTypeAssignment_4 ) ) ;
    public final void rule__MapType__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8210:1: ( ( ( rule__MapType__ValueTypeAssignment_4 ) ) )
            // InternalDOcl.g:8211:1: ( ( rule__MapType__ValueTypeAssignment_4 ) )
            {
            // InternalDOcl.g:8211:1: ( ( rule__MapType__ValueTypeAssignment_4 ) )
            // InternalDOcl.g:8212:2: ( rule__MapType__ValueTypeAssignment_4 )
            {
             before(grammarAccess.getMapTypeAccess().getValueTypeAssignment_4()); 
            // InternalDOcl.g:8213:2: ( rule__MapType__ValueTypeAssignment_4 )
            // InternalDOcl.g:8213:3: rule__MapType__ValueTypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__MapType__ValueTypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getMapTypeAccess().getValueTypeAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__4__Impl"


    // $ANTLR start "rule__MapType__Group__5"
    // InternalDOcl.g:8221:1: rule__MapType__Group__5 : rule__MapType__Group__5__Impl ;
    public final void rule__MapType__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8225:1: ( rule__MapType__Group__5__Impl )
            // InternalDOcl.g:8226:2: rule__MapType__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MapType__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__5"


    // $ANTLR start "rule__MapType__Group__5__Impl"
    // InternalDOcl.g:8232:1: rule__MapType__Group__5__Impl : ( ')' ) ;
    public final void rule__MapType__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8236:1: ( ( ')' ) )
            // InternalDOcl.g:8237:1: ( ')' )
            {
            // InternalDOcl.g:8237:1: ( ')' )
            // InternalDOcl.g:8238:2: ')'
            {
             before(grammarAccess.getMapTypeAccess().getRightParenthesisKeyword_5()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getMapTypeAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__Group__5__Impl"


    // $ANTLR start "rule__SetType__Group__0"
    // InternalDOcl.g:8248:1: rule__SetType__Group__0 : rule__SetType__Group__0__Impl rule__SetType__Group__1 ;
    public final void rule__SetType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8252:1: ( rule__SetType__Group__0__Impl rule__SetType__Group__1 )
            // InternalDOcl.g:8253:2: rule__SetType__Group__0__Impl rule__SetType__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__SetType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SetType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__0"


    // $ANTLR start "rule__SetType__Group__0__Impl"
    // InternalDOcl.g:8260:1: rule__SetType__Group__0__Impl : ( ( rule__SetType__NameAssignment_0 ) ) ;
    public final void rule__SetType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8264:1: ( ( ( rule__SetType__NameAssignment_0 ) ) )
            // InternalDOcl.g:8265:1: ( ( rule__SetType__NameAssignment_0 ) )
            {
            // InternalDOcl.g:8265:1: ( ( rule__SetType__NameAssignment_0 ) )
            // InternalDOcl.g:8266:2: ( rule__SetType__NameAssignment_0 )
            {
             before(grammarAccess.getSetTypeAccess().getNameAssignment_0()); 
            // InternalDOcl.g:8267:2: ( rule__SetType__NameAssignment_0 )
            // InternalDOcl.g:8267:3: rule__SetType__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__SetType__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSetTypeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__0__Impl"


    // $ANTLR start "rule__SetType__Group__1"
    // InternalDOcl.g:8275:1: rule__SetType__Group__1 : rule__SetType__Group__1__Impl rule__SetType__Group__2 ;
    public final void rule__SetType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8279:1: ( rule__SetType__Group__1__Impl rule__SetType__Group__2 )
            // InternalDOcl.g:8280:2: rule__SetType__Group__1__Impl rule__SetType__Group__2
            {
            pushFollow(FOLLOW_53);
            rule__SetType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SetType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__1"


    // $ANTLR start "rule__SetType__Group__1__Impl"
    // InternalDOcl.g:8287:1: rule__SetType__Group__1__Impl : ( '(' ) ;
    public final void rule__SetType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8291:1: ( ( '(' ) )
            // InternalDOcl.g:8292:1: ( '(' )
            {
            // InternalDOcl.g:8292:1: ( '(' )
            // InternalDOcl.g:8293:2: '('
            {
             before(grammarAccess.getSetTypeAccess().getLeftParenthesisKeyword_1()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getSetTypeAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__1__Impl"


    // $ANTLR start "rule__SetType__Group__2"
    // InternalDOcl.g:8302:1: rule__SetType__Group__2 : rule__SetType__Group__2__Impl rule__SetType__Group__3 ;
    public final void rule__SetType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8306:1: ( rule__SetType__Group__2__Impl rule__SetType__Group__3 )
            // InternalDOcl.g:8307:2: rule__SetType__Group__2__Impl rule__SetType__Group__3
            {
            pushFollow(FOLLOW_52);
            rule__SetType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SetType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__2"


    // $ANTLR start "rule__SetType__Group__2__Impl"
    // InternalDOcl.g:8314:1: rule__SetType__Group__2__Impl : ( ( rule__SetType__ElementTypeAssignment_2 ) ) ;
    public final void rule__SetType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8318:1: ( ( ( rule__SetType__ElementTypeAssignment_2 ) ) )
            // InternalDOcl.g:8319:1: ( ( rule__SetType__ElementTypeAssignment_2 ) )
            {
            // InternalDOcl.g:8319:1: ( ( rule__SetType__ElementTypeAssignment_2 ) )
            // InternalDOcl.g:8320:2: ( rule__SetType__ElementTypeAssignment_2 )
            {
             before(grammarAccess.getSetTypeAccess().getElementTypeAssignment_2()); 
            // InternalDOcl.g:8321:2: ( rule__SetType__ElementTypeAssignment_2 )
            // InternalDOcl.g:8321:3: rule__SetType__ElementTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SetType__ElementTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSetTypeAccess().getElementTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__2__Impl"


    // $ANTLR start "rule__SetType__Group__3"
    // InternalDOcl.g:8329:1: rule__SetType__Group__3 : rule__SetType__Group__3__Impl ;
    public final void rule__SetType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8333:1: ( rule__SetType__Group__3__Impl )
            // InternalDOcl.g:8334:2: rule__SetType__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SetType__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__3"


    // $ANTLR start "rule__SetType__Group__3__Impl"
    // InternalDOcl.g:8340:1: rule__SetType__Group__3__Impl : ( ')' ) ;
    public final void rule__SetType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8344:1: ( ( ')' ) )
            // InternalDOcl.g:8345:1: ( ')' )
            {
            // InternalDOcl.g:8345:1: ( ')' )
            // InternalDOcl.g:8346:2: ')'
            {
             before(grammarAccess.getSetTypeAccess().getRightParenthesisKeyword_3()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getSetTypeAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__Group__3__Impl"


    // $ANTLR start "rule__SequenceType__Group__0"
    // InternalDOcl.g:8356:1: rule__SequenceType__Group__0 : rule__SequenceType__Group__0__Impl rule__SequenceType__Group__1 ;
    public final void rule__SequenceType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8360:1: ( rule__SequenceType__Group__0__Impl rule__SequenceType__Group__1 )
            // InternalDOcl.g:8361:2: rule__SequenceType__Group__0__Impl rule__SequenceType__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__SequenceType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SequenceType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceType__Group__0"


    // $ANTLR start "rule__SequenceType__Group__0__Impl"
    // InternalDOcl.g:8368:1: rule__SequenceType__Group__0__Impl : ( ( rule__SequenceType__NameAssignment_0 ) ) ;
    public final void rule__SequenceType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8372:1: ( ( ( rule__SequenceType__NameAssignment_0 ) ) )
            // InternalDOcl.g:8373:1: ( ( rule__SequenceType__NameAssignment_0 ) )
            {
            // InternalDOcl.g:8373:1: ( ( rule__SequenceType__NameAssignment_0 ) )
            // InternalDOcl.g:8374:2: ( rule__SequenceType__NameAssignment_0 )
            {
             before(grammarAccess.getSequenceTypeAccess().getNameAssignment_0()); 
            // InternalDOcl.g:8375:2: ( rule__SequenceType__NameAssignment_0 )
            // InternalDOcl.g:8375:3: rule__SequenceType__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__SequenceType__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSequenceTypeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceType__Group__0__Impl"


    // $ANTLR start "rule__SequenceType__Group__1"
    // InternalDOcl.g:8383:1: rule__SequenceType__Group__1 : rule__SequenceType__Group__1__Impl rule__SequenceType__Group__2 ;
    public final void rule__SequenceType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8387:1: ( rule__SequenceType__Group__1__Impl rule__SequenceType__Group__2 )
            // InternalDOcl.g:8388:2: rule__SequenceType__Group__1__Impl rule__SequenceType__Group__2
            {
            pushFollow(FOLLOW_53);
            rule__SequenceType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SequenceType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceType__Group__1"


    // $ANTLR start "rule__SequenceType__Group__1__Impl"
    // InternalDOcl.g:8395:1: rule__SequenceType__Group__1__Impl : ( '(' ) ;
    public final void rule__SequenceType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8399:1: ( ( '(' ) )
            // InternalDOcl.g:8400:1: ( '(' )
            {
            // InternalDOcl.g:8400:1: ( '(' )
            // InternalDOcl.g:8401:2: '('
            {
             before(grammarAccess.getSequenceTypeAccess().getLeftParenthesisKeyword_1()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getSequenceTypeAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceType__Group__1__Impl"


    // $ANTLR start "rule__SequenceType__Group__2"
    // InternalDOcl.g:8410:1: rule__SequenceType__Group__2 : rule__SequenceType__Group__2__Impl rule__SequenceType__Group__3 ;
    public final void rule__SequenceType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8414:1: ( rule__SequenceType__Group__2__Impl rule__SequenceType__Group__3 )
            // InternalDOcl.g:8415:2: rule__SequenceType__Group__2__Impl rule__SequenceType__Group__3
            {
            pushFollow(FOLLOW_52);
            rule__SequenceType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SequenceType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceType__Group__2"


    // $ANTLR start "rule__SequenceType__Group__2__Impl"
    // InternalDOcl.g:8422:1: rule__SequenceType__Group__2__Impl : ( ( rule__SequenceType__ElementTypeAssignment_2 ) ) ;
    public final void rule__SequenceType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8426:1: ( ( ( rule__SequenceType__ElementTypeAssignment_2 ) ) )
            // InternalDOcl.g:8427:1: ( ( rule__SequenceType__ElementTypeAssignment_2 ) )
            {
            // InternalDOcl.g:8427:1: ( ( rule__SequenceType__ElementTypeAssignment_2 ) )
            // InternalDOcl.g:8428:2: ( rule__SequenceType__ElementTypeAssignment_2 )
            {
             before(grammarAccess.getSequenceTypeAccess().getElementTypeAssignment_2()); 
            // InternalDOcl.g:8429:2: ( rule__SequenceType__ElementTypeAssignment_2 )
            // InternalDOcl.g:8429:3: rule__SequenceType__ElementTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__SequenceType__ElementTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSequenceTypeAccess().getElementTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceType__Group__2__Impl"


    // $ANTLR start "rule__SequenceType__Group__3"
    // InternalDOcl.g:8437:1: rule__SequenceType__Group__3 : rule__SequenceType__Group__3__Impl ;
    public final void rule__SequenceType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8441:1: ( rule__SequenceType__Group__3__Impl )
            // InternalDOcl.g:8442:2: rule__SequenceType__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SequenceType__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceType__Group__3"


    // $ANTLR start "rule__SequenceType__Group__3__Impl"
    // InternalDOcl.g:8448:1: rule__SequenceType__Group__3__Impl : ( ')' ) ;
    public final void rule__SequenceType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8452:1: ( ( ')' ) )
            // InternalDOcl.g:8453:1: ( ')' )
            {
            // InternalDOcl.g:8453:1: ( ')' )
            // InternalDOcl.g:8454:2: ')'
            {
             before(grammarAccess.getSequenceTypeAccess().getRightParenthesisKeyword_3()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getSequenceTypeAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceType__Group__3__Impl"


    // $ANTLR start "rule__OrderedSetType__Group__0"
    // InternalDOcl.g:8464:1: rule__OrderedSetType__Group__0 : rule__OrderedSetType__Group__0__Impl rule__OrderedSetType__Group__1 ;
    public final void rule__OrderedSetType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8468:1: ( rule__OrderedSetType__Group__0__Impl rule__OrderedSetType__Group__1 )
            // InternalDOcl.g:8469:2: rule__OrderedSetType__Group__0__Impl rule__OrderedSetType__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__OrderedSetType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrderedSetType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderedSetType__Group__0"


    // $ANTLR start "rule__OrderedSetType__Group__0__Impl"
    // InternalDOcl.g:8476:1: rule__OrderedSetType__Group__0__Impl : ( ( rule__OrderedSetType__NameAssignment_0 ) ) ;
    public final void rule__OrderedSetType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8480:1: ( ( ( rule__OrderedSetType__NameAssignment_0 ) ) )
            // InternalDOcl.g:8481:1: ( ( rule__OrderedSetType__NameAssignment_0 ) )
            {
            // InternalDOcl.g:8481:1: ( ( rule__OrderedSetType__NameAssignment_0 ) )
            // InternalDOcl.g:8482:2: ( rule__OrderedSetType__NameAssignment_0 )
            {
             before(grammarAccess.getOrderedSetTypeAccess().getNameAssignment_0()); 
            // InternalDOcl.g:8483:2: ( rule__OrderedSetType__NameAssignment_0 )
            // InternalDOcl.g:8483:3: rule__OrderedSetType__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__OrderedSetType__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getOrderedSetTypeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderedSetType__Group__0__Impl"


    // $ANTLR start "rule__OrderedSetType__Group__1"
    // InternalDOcl.g:8491:1: rule__OrderedSetType__Group__1 : rule__OrderedSetType__Group__1__Impl rule__OrderedSetType__Group__2 ;
    public final void rule__OrderedSetType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8495:1: ( rule__OrderedSetType__Group__1__Impl rule__OrderedSetType__Group__2 )
            // InternalDOcl.g:8496:2: rule__OrderedSetType__Group__1__Impl rule__OrderedSetType__Group__2
            {
            pushFollow(FOLLOW_53);
            rule__OrderedSetType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrderedSetType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderedSetType__Group__1"


    // $ANTLR start "rule__OrderedSetType__Group__1__Impl"
    // InternalDOcl.g:8503:1: rule__OrderedSetType__Group__1__Impl : ( '(' ) ;
    public final void rule__OrderedSetType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8507:1: ( ( '(' ) )
            // InternalDOcl.g:8508:1: ( '(' )
            {
            // InternalDOcl.g:8508:1: ( '(' )
            // InternalDOcl.g:8509:2: '('
            {
             before(grammarAccess.getOrderedSetTypeAccess().getLeftParenthesisKeyword_1()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getOrderedSetTypeAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderedSetType__Group__1__Impl"


    // $ANTLR start "rule__OrderedSetType__Group__2"
    // InternalDOcl.g:8518:1: rule__OrderedSetType__Group__2 : rule__OrderedSetType__Group__2__Impl rule__OrderedSetType__Group__3 ;
    public final void rule__OrderedSetType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8522:1: ( rule__OrderedSetType__Group__2__Impl rule__OrderedSetType__Group__3 )
            // InternalDOcl.g:8523:2: rule__OrderedSetType__Group__2__Impl rule__OrderedSetType__Group__3
            {
            pushFollow(FOLLOW_52);
            rule__OrderedSetType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__OrderedSetType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderedSetType__Group__2"


    // $ANTLR start "rule__OrderedSetType__Group__2__Impl"
    // InternalDOcl.g:8530:1: rule__OrderedSetType__Group__2__Impl : ( ( rule__OrderedSetType__ElementTypeAssignment_2 ) ) ;
    public final void rule__OrderedSetType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8534:1: ( ( ( rule__OrderedSetType__ElementTypeAssignment_2 ) ) )
            // InternalDOcl.g:8535:1: ( ( rule__OrderedSetType__ElementTypeAssignment_2 ) )
            {
            // InternalDOcl.g:8535:1: ( ( rule__OrderedSetType__ElementTypeAssignment_2 ) )
            // InternalDOcl.g:8536:2: ( rule__OrderedSetType__ElementTypeAssignment_2 )
            {
             before(grammarAccess.getOrderedSetTypeAccess().getElementTypeAssignment_2()); 
            // InternalDOcl.g:8537:2: ( rule__OrderedSetType__ElementTypeAssignment_2 )
            // InternalDOcl.g:8537:3: rule__OrderedSetType__ElementTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__OrderedSetType__ElementTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOrderedSetTypeAccess().getElementTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderedSetType__Group__2__Impl"


    // $ANTLR start "rule__OrderedSetType__Group__3"
    // InternalDOcl.g:8545:1: rule__OrderedSetType__Group__3 : rule__OrderedSetType__Group__3__Impl ;
    public final void rule__OrderedSetType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8549:1: ( rule__OrderedSetType__Group__3__Impl )
            // InternalDOcl.g:8550:2: rule__OrderedSetType__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__OrderedSetType__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderedSetType__Group__3"


    // $ANTLR start "rule__OrderedSetType__Group__3__Impl"
    // InternalDOcl.g:8556:1: rule__OrderedSetType__Group__3__Impl : ( ')' ) ;
    public final void rule__OrderedSetType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8560:1: ( ( ')' ) )
            // InternalDOcl.g:8561:1: ( ')' )
            {
            // InternalDOcl.g:8561:1: ( ')' )
            // InternalDOcl.g:8562:2: ')'
            {
             before(grammarAccess.getOrderedSetTypeAccess().getRightParenthesisKeyword_3()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getOrderedSetTypeAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderedSetType__Group__3__Impl"


    // $ANTLR start "rule__BagType__Group__0"
    // InternalDOcl.g:8572:1: rule__BagType__Group__0 : rule__BagType__Group__0__Impl rule__BagType__Group__1 ;
    public final void rule__BagType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8576:1: ( rule__BagType__Group__0__Impl rule__BagType__Group__1 )
            // InternalDOcl.g:8577:2: rule__BagType__Group__0__Impl rule__BagType__Group__1
            {
            pushFollow(FOLLOW_45);
            rule__BagType__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BagType__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__0"


    // $ANTLR start "rule__BagType__Group__0__Impl"
    // InternalDOcl.g:8584:1: rule__BagType__Group__0__Impl : ( ( rule__BagType__NameAssignment_0 ) ) ;
    public final void rule__BagType__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8588:1: ( ( ( rule__BagType__NameAssignment_0 ) ) )
            // InternalDOcl.g:8589:1: ( ( rule__BagType__NameAssignment_0 ) )
            {
            // InternalDOcl.g:8589:1: ( ( rule__BagType__NameAssignment_0 ) )
            // InternalDOcl.g:8590:2: ( rule__BagType__NameAssignment_0 )
            {
             before(grammarAccess.getBagTypeAccess().getNameAssignment_0()); 
            // InternalDOcl.g:8591:2: ( rule__BagType__NameAssignment_0 )
            // InternalDOcl.g:8591:3: rule__BagType__NameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__BagType__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getBagTypeAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__0__Impl"


    // $ANTLR start "rule__BagType__Group__1"
    // InternalDOcl.g:8599:1: rule__BagType__Group__1 : rule__BagType__Group__1__Impl rule__BagType__Group__2 ;
    public final void rule__BagType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8603:1: ( rule__BagType__Group__1__Impl rule__BagType__Group__2 )
            // InternalDOcl.g:8604:2: rule__BagType__Group__1__Impl rule__BagType__Group__2
            {
            pushFollow(FOLLOW_53);
            rule__BagType__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BagType__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__1"


    // $ANTLR start "rule__BagType__Group__1__Impl"
    // InternalDOcl.g:8611:1: rule__BagType__Group__1__Impl : ( '(' ) ;
    public final void rule__BagType__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8615:1: ( ( '(' ) )
            // InternalDOcl.g:8616:1: ( '(' )
            {
            // InternalDOcl.g:8616:1: ( '(' )
            // InternalDOcl.g:8617:2: '('
            {
             before(grammarAccess.getBagTypeAccess().getLeftParenthesisKeyword_1()); 
            match(input,72,FOLLOW_2); 
             after(grammarAccess.getBagTypeAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__1__Impl"


    // $ANTLR start "rule__BagType__Group__2"
    // InternalDOcl.g:8626:1: rule__BagType__Group__2 : rule__BagType__Group__2__Impl rule__BagType__Group__3 ;
    public final void rule__BagType__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8630:1: ( rule__BagType__Group__2__Impl rule__BagType__Group__3 )
            // InternalDOcl.g:8631:2: rule__BagType__Group__2__Impl rule__BagType__Group__3
            {
            pushFollow(FOLLOW_52);
            rule__BagType__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BagType__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__2"


    // $ANTLR start "rule__BagType__Group__2__Impl"
    // InternalDOcl.g:8638:1: rule__BagType__Group__2__Impl : ( ( rule__BagType__ElementTypeAssignment_2 ) ) ;
    public final void rule__BagType__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8642:1: ( ( ( rule__BagType__ElementTypeAssignment_2 ) ) )
            // InternalDOcl.g:8643:1: ( ( rule__BagType__ElementTypeAssignment_2 ) )
            {
            // InternalDOcl.g:8643:1: ( ( rule__BagType__ElementTypeAssignment_2 ) )
            // InternalDOcl.g:8644:2: ( rule__BagType__ElementTypeAssignment_2 )
            {
             before(grammarAccess.getBagTypeAccess().getElementTypeAssignment_2()); 
            // InternalDOcl.g:8645:2: ( rule__BagType__ElementTypeAssignment_2 )
            // InternalDOcl.g:8645:3: rule__BagType__ElementTypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__BagType__ElementTypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBagTypeAccess().getElementTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__2__Impl"


    // $ANTLR start "rule__BagType__Group__3"
    // InternalDOcl.g:8653:1: rule__BagType__Group__3 : rule__BagType__Group__3__Impl ;
    public final void rule__BagType__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8657:1: ( rule__BagType__Group__3__Impl )
            // InternalDOcl.g:8658:2: rule__BagType__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BagType__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__3"


    // $ANTLR start "rule__BagType__Group__3__Impl"
    // InternalDOcl.g:8664:1: rule__BagType__Group__3__Impl : ( ')' ) ;
    public final void rule__BagType__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8668:1: ( ( ')' ) )
            // InternalDOcl.g:8669:1: ( ')' )
            {
            // InternalDOcl.g:8669:1: ( ')' )
            // InternalDOcl.g:8670:2: ')'
            {
             before(grammarAccess.getBagTypeAccess().getRightParenthesisKeyword_3()); 
            match(input,73,FOLLOW_2); 
             after(grammarAccess.getBagTypeAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__Group__3__Impl"


    // $ANTLR start "rule__Module__NameAssignment_2"
    // InternalDOcl.g:8680:1: rule__Module__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Module__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8684:1: ( ( RULE_ID ) )
            // InternalDOcl.g:8685:2: ( RULE_ID )
            {
            // InternalDOcl.g:8685:2: ( RULE_ID )
            // InternalDOcl.g:8686:3: RULE_ID
            {
             before(grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__NameAssignment_2"


    // $ANTLR start "rule__Module__SourceAssignment_4"
    // InternalDOcl.g:8695:1: rule__Module__SourceAssignment_4 : ( ruleOclModel ) ;
    public final void rule__Module__SourceAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8699:1: ( ( ruleOclModel ) )
            // InternalDOcl.g:8700:2: ( ruleOclModel )
            {
            // InternalDOcl.g:8700:2: ( ruleOclModel )
            // InternalDOcl.g:8701:3: ruleOclModel
            {
             before(grammarAccess.getModuleAccess().getSourceOclModelParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleOclModel();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getSourceOclModelParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__SourceAssignment_4"


    // $ANTLR start "rule__Module__InputAssignment_6"
    // InternalDOcl.g:8710:1: rule__Module__InputAssignment_6 : ( ruleOclModel ) ;
    public final void rule__Module__InputAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8714:1: ( ( ruleOclModel ) )
            // InternalDOcl.g:8715:2: ( ruleOclModel )
            {
            // InternalDOcl.g:8715:2: ( ruleOclModel )
            // InternalDOcl.g:8716:3: ruleOclModel
            {
             before(grammarAccess.getModuleAccess().getInputOclModelParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleOclModel();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getInputOclModelParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__InputAssignment_6"


    // $ANTLR start "rule__Module__ImportsAssignment_7_0"
    // InternalDOcl.g:8725:1: rule__Module__ImportsAssignment_7_0 : ( ruleImport ) ;
    public final void rule__Module__ImportsAssignment_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8729:1: ( ( ruleImport ) )
            // InternalDOcl.g:8730:2: ( ruleImport )
            {
            // InternalDOcl.g:8730:2: ( ruleImport )
            // InternalDOcl.g:8731:3: ruleImport
            {
             before(grammarAccess.getModuleAccess().getImportsImportParserRuleCall_7_0_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getImportsImportParserRuleCall_7_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__ImportsAssignment_7_0"


    // $ANTLR start "rule__Module__ImportsAssignment_7_1"
    // InternalDOcl.g:8740:1: rule__Module__ImportsAssignment_7_1 : ( ruleImport ) ;
    public final void rule__Module__ImportsAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8744:1: ( ( ruleImport ) )
            // InternalDOcl.g:8745:2: ( ruleImport )
            {
            // InternalDOcl.g:8745:2: ( ruleImport )
            // InternalDOcl.g:8746:3: ruleImport
            {
             before(grammarAccess.getModuleAccess().getImportsImportParserRuleCall_7_1_0()); 
            pushFollow(FOLLOW_2);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getImportsImportParserRuleCall_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__ImportsAssignment_7_1"


    // $ANTLR start "rule__Module__ElementsAssignment_8_0"
    // InternalDOcl.g:8755:1: rule__Module__ElementsAssignment_8_0 : ( ruleModuleElement ) ;
    public final void rule__Module__ElementsAssignment_8_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8759:1: ( ( ruleModuleElement ) )
            // InternalDOcl.g:8760:2: ( ruleModuleElement )
            {
            // InternalDOcl.g:8760:2: ( ruleModuleElement )
            // InternalDOcl.g:8761:3: ruleModuleElement
            {
             before(grammarAccess.getModuleAccess().getElementsModuleElementParserRuleCall_8_0_0()); 
            pushFollow(FOLLOW_2);
            ruleModuleElement();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getElementsModuleElementParserRuleCall_8_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__ElementsAssignment_8_0"


    // $ANTLR start "rule__Module__ElementsAssignment_8_1"
    // InternalDOcl.g:8770:1: rule__Module__ElementsAssignment_8_1 : ( ruleModuleElement ) ;
    public final void rule__Module__ElementsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8774:1: ( ( ruleModuleElement ) )
            // InternalDOcl.g:8775:2: ( ruleModuleElement )
            {
            // InternalDOcl.g:8775:2: ( ruleModuleElement )
            // InternalDOcl.g:8776:3: ruleModuleElement
            {
             before(grammarAccess.getModuleAccess().getElementsModuleElementParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_2);
            ruleModuleElement();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getElementsModuleElementParserRuleCall_8_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__ElementsAssignment_8_1"


    // $ANTLR start "rule__OclModel__NameAssignment_0"
    // InternalDOcl.g:8785:1: rule__OclModel__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__OclModel__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8789:1: ( ( RULE_ID ) )
            // InternalDOcl.g:8790:2: ( RULE_ID )
            {
            // InternalDOcl.g:8790:2: ( RULE_ID )
            // InternalDOcl.g:8791:3: RULE_ID
            {
             before(grammarAccess.getOclModelAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOclModelAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModel__NameAssignment_0"


    // $ANTLR start "rule__OclModel__UriAssignment_1"
    // InternalDOcl.g:8800:1: rule__OclModel__UriAssignment_1 : ( ruleURI_ ) ;
    public final void rule__OclModel__UriAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8804:1: ( ( ruleURI_ ) )
            // InternalDOcl.g:8805:2: ( ruleURI_ )
            {
            // InternalDOcl.g:8805:2: ( ruleURI_ )
            // InternalDOcl.g:8806:3: ruleURI_
            {
             before(grammarAccess.getOclModelAccess().getUriURI_ParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleURI_();

            state._fsp--;

             after(grammarAccess.getOclModelAccess().getUriURI_ParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModel__UriAssignment_1"


    // $ANTLR start "rule__URI___SchemeAssignment_1"
    // InternalDOcl.g:8815:1: rule__URI___SchemeAssignment_1 : ( RULE_SCHEME ) ;
    public final void rule__URI___SchemeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8819:1: ( ( RULE_SCHEME ) )
            // InternalDOcl.g:8820:2: ( RULE_SCHEME )
            {
            // InternalDOcl.g:8820:2: ( RULE_SCHEME )
            // InternalDOcl.g:8821:3: RULE_SCHEME
            {
             before(grammarAccess.getURI_Access().getSchemeSCHEMETerminalRuleCall_1_0()); 
            match(input,RULE_SCHEME,FOLLOW_2); 
             after(grammarAccess.getURI_Access().getSchemeSCHEMETerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___SchemeAssignment_1"


    // $ANTLR start "rule__URI___AuthorityAssignment_3"
    // InternalDOcl.g:8830:1: rule__URI___AuthorityAssignment_3 : ( ruleAUTHORITY ) ;
    public final void rule__URI___AuthorityAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8834:1: ( ( ruleAUTHORITY ) )
            // InternalDOcl.g:8835:2: ( ruleAUTHORITY )
            {
            // InternalDOcl.g:8835:2: ( ruleAUTHORITY )
            // InternalDOcl.g:8836:3: ruleAUTHORITY
            {
             before(grammarAccess.getURI_Access().getAuthorityAUTHORITYParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleAUTHORITY();

            state._fsp--;

             after(grammarAccess.getURI_Access().getAuthorityAUTHORITYParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___AuthorityAssignment_3"


    // $ANTLR start "rule__URI___Fragment_Assignment_5"
    // InternalDOcl.g:8845:1: rule__URI___Fragment_Assignment_5 : ( ruleFRAGMENT ) ;
    public final void rule__URI___Fragment_Assignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8849:1: ( ( ruleFRAGMENT ) )
            // InternalDOcl.g:8850:2: ( ruleFRAGMENT )
            {
            // InternalDOcl.g:8850:2: ( ruleFRAGMENT )
            // InternalDOcl.g:8851:3: ruleFRAGMENT
            {
             before(grammarAccess.getURI_Access().getFragment_FRAGMENTParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleFRAGMENT();

            state._fsp--;

             after(grammarAccess.getURI_Access().getFragment_FRAGMENTParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__URI___Fragment_Assignment_5"


    // $ANTLR start "rule__Import__NameAssignment_2"
    // InternalDOcl.g:8860:1: rule__Import__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Import__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8864:1: ( ( RULE_ID ) )
            // InternalDOcl.g:8865:2: ( RULE_ID )
            {
            // InternalDOcl.g:8865:2: ( RULE_ID )
            // InternalDOcl.g:8866:3: RULE_ID
            {
             before(grammarAccess.getImportAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getImportAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__NameAssignment_2"


    // $ANTLR start "rule__Query__NameAssignment_2"
    // InternalDOcl.g:8875:1: rule__Query__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__Query__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8879:1: ( ( RULE_ID ) )
            // InternalDOcl.g:8880:2: ( RULE_ID )
            {
            // InternalDOcl.g:8880:2: ( RULE_ID )
            // InternalDOcl.g:8881:3: RULE_ID
            {
             before(grammarAccess.getQueryAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getQueryAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__NameAssignment_2"


    // $ANTLR start "rule__Query__BodyAssignment_4"
    // InternalDOcl.g:8890:1: rule__Query__BodyAssignment_4 : ( ruleOclExpression ) ;
    public final void rule__Query__BodyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8894:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:8895:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:8895:2: ( ruleOclExpression )
            // InternalDOcl.g:8896:3: ruleOclExpression
            {
             before(grammarAccess.getQueryAccess().getBodyOclExpressionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getQueryAccess().getBodyOclExpressionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Query__BodyAssignment_4"


    // $ANTLR start "rule__LetExp__NameAssignment_0"
    // InternalDOcl.g:8905:1: rule__LetExp__NameAssignment_0 : ( ( 'let' ) ) ;
    public final void rule__LetExp__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8909:1: ( ( ( 'let' ) ) )
            // InternalDOcl.g:8910:2: ( ( 'let' ) )
            {
            // InternalDOcl.g:8910:2: ( ( 'let' ) )
            // InternalDOcl.g:8911:3: ( 'let' )
            {
             before(grammarAccess.getLetExpAccess().getNameLetKeyword_0_0()); 
            // InternalDOcl.g:8912:3: ( 'let' )
            // InternalDOcl.g:8913:4: 'let'
            {
             before(grammarAccess.getLetExpAccess().getNameLetKeyword_0_0()); 
            match(input,84,FOLLOW_2); 
             after(grammarAccess.getLetExpAccess().getNameLetKeyword_0_0()); 

            }

             after(grammarAccess.getLetExpAccess().getNameLetKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LetExp__NameAssignment_0"


    // $ANTLR start "rule__LetExp__VariableAssignment_1"
    // InternalDOcl.g:8924:1: rule__LetExp__VariableAssignment_1 : ( ruleLocalVariable ) ;
    public final void rule__LetExp__VariableAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8928:1: ( ( ruleLocalVariable ) )
            // InternalDOcl.g:8929:2: ( ruleLocalVariable )
            {
            // InternalDOcl.g:8929:2: ( ruleLocalVariable )
            // InternalDOcl.g:8930:3: ruleLocalVariable
            {
             before(grammarAccess.getLetExpAccess().getVariableLocalVariableParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleLocalVariable();

            state._fsp--;

             after(grammarAccess.getLetExpAccess().getVariableLocalVariableParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LetExp__VariableAssignment_1"


    // $ANTLR start "rule__LetExp__InAssignment_3"
    // InternalDOcl.g:8939:1: rule__LetExp__InAssignment_3 : ( ruleOclExpression ) ;
    public final void rule__LetExp__InAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8943:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:8944:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:8944:2: ( ruleOclExpression )
            // InternalDOcl.g:8945:3: ruleOclExpression
            {
             before(grammarAccess.getLetExpAccess().getInOclExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getLetExpAccess().getInOclExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LetExp__InAssignment_3"


    // $ANTLR start "rule__UnaryOpExp__NameAssignment_0"
    // InternalDOcl.g:8954:1: rule__UnaryOpExp__NameAssignment_0 : ( ruleUnaryOperator ) ;
    public final void rule__UnaryOpExp__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8958:1: ( ( ruleUnaryOperator ) )
            // InternalDOcl.g:8959:2: ( ruleUnaryOperator )
            {
            // InternalDOcl.g:8959:2: ( ruleUnaryOperator )
            // InternalDOcl.g:8960:3: ruleUnaryOperator
            {
             before(grammarAccess.getUnaryOpExpAccess().getNameUnaryOperatorParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleUnaryOperator();

            state._fsp--;

             after(grammarAccess.getUnaryOpExpAccess().getNameUnaryOperatorParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOpExp__NameAssignment_0"


    // $ANTLR start "rule__UnaryOpExp__TargetAssignment_1"
    // InternalDOcl.g:8969:1: rule__UnaryOpExp__TargetAssignment_1 : ( ruleOclExpression ) ;
    public final void rule__UnaryOpExp__TargetAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8973:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:8974:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:8974:2: ( ruleOclExpression )
            // InternalDOcl.g:8975:3: ruleOclExpression
            {
             before(grammarAccess.getUnaryOpExpAccess().getTargetOclExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getUnaryOpExpAccess().getTargetOclExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__UnaryOpExp__TargetAssignment_1"


    // $ANTLR start "rule__ImpliesOpExp__NameAssignment_1_1"
    // InternalDOcl.g:8984:1: rule__ImpliesOpExp__NameAssignment_1_1 : ( ruleImpliesOperator ) ;
    public final void rule__ImpliesOpExp__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:8988:1: ( ( ruleImpliesOperator ) )
            // InternalDOcl.g:8989:2: ( ruleImpliesOperator )
            {
            // InternalDOcl.g:8989:2: ( ruleImpliesOperator )
            // InternalDOcl.g:8990:3: ruleImpliesOperator
            {
             before(grammarAccess.getImpliesOpExpAccess().getNameImpliesOperatorParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleImpliesOperator();

            state._fsp--;

             after(grammarAccess.getImpliesOpExpAccess().getNameImpliesOperatorParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImpliesOpExp__NameAssignment_1_1"


    // $ANTLR start "rule__ImpliesOpExp__TargetAssignment_1_2"
    // InternalDOcl.g:8999:1: rule__ImpliesOpExp__TargetAssignment_1_2 : ( ruleXorOpExp ) ;
    public final void rule__ImpliesOpExp__TargetAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9003:1: ( ( ruleXorOpExp ) )
            // InternalDOcl.g:9004:2: ( ruleXorOpExp )
            {
            // InternalDOcl.g:9004:2: ( ruleXorOpExp )
            // InternalDOcl.g:9005:3: ruleXorOpExp
            {
             before(grammarAccess.getImpliesOpExpAccess().getTargetXorOpExpParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleXorOpExp();

            state._fsp--;

             after(grammarAccess.getImpliesOpExpAccess().getTargetXorOpExpParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ImpliesOpExp__TargetAssignment_1_2"


    // $ANTLR start "rule__XorOpExp__NameAssignment_1_1"
    // InternalDOcl.g:9014:1: rule__XorOpExp__NameAssignment_1_1 : ( ruleXorOperator ) ;
    public final void rule__XorOpExp__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9018:1: ( ( ruleXorOperator ) )
            // InternalDOcl.g:9019:2: ( ruleXorOperator )
            {
            // InternalDOcl.g:9019:2: ( ruleXorOperator )
            // InternalDOcl.g:9020:3: ruleXorOperator
            {
             before(grammarAccess.getXorOpExpAccess().getNameXorOperatorParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleXorOperator();

            state._fsp--;

             after(grammarAccess.getXorOpExpAccess().getNameXorOperatorParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorOpExp__NameAssignment_1_1"


    // $ANTLR start "rule__XorOpExp__TargetAssignment_1_2"
    // InternalDOcl.g:9029:1: rule__XorOpExp__TargetAssignment_1_2 : ( ruleOrOpExp ) ;
    public final void rule__XorOpExp__TargetAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9033:1: ( ( ruleOrOpExp ) )
            // InternalDOcl.g:9034:2: ( ruleOrOpExp )
            {
            // InternalDOcl.g:9034:2: ( ruleOrOpExp )
            // InternalDOcl.g:9035:3: ruleOrOpExp
            {
             before(grammarAccess.getXorOpExpAccess().getTargetOrOpExpParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOrOpExp();

            state._fsp--;

             after(grammarAccess.getXorOpExpAccess().getTargetOrOpExpParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XorOpExp__TargetAssignment_1_2"


    // $ANTLR start "rule__OrOpExp__NameAssignment_1_1"
    // InternalDOcl.g:9044:1: rule__OrOpExp__NameAssignment_1_1 : ( ruleOrOperator ) ;
    public final void rule__OrOpExp__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9048:1: ( ( ruleOrOperator ) )
            // InternalDOcl.g:9049:2: ( ruleOrOperator )
            {
            // InternalDOcl.g:9049:2: ( ruleOrOperator )
            // InternalDOcl.g:9050:3: ruleOrOperator
            {
             before(grammarAccess.getOrOpExpAccess().getNameOrOperatorParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOrOperator();

            state._fsp--;

             after(grammarAccess.getOrOpExpAccess().getNameOrOperatorParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrOpExp__NameAssignment_1_1"


    // $ANTLR start "rule__OrOpExp__TargetAssignment_1_2"
    // InternalDOcl.g:9059:1: rule__OrOpExp__TargetAssignment_1_2 : ( ruleAndOpExp ) ;
    public final void rule__OrOpExp__TargetAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9063:1: ( ( ruleAndOpExp ) )
            // InternalDOcl.g:9064:2: ( ruleAndOpExp )
            {
            // InternalDOcl.g:9064:2: ( ruleAndOpExp )
            // InternalDOcl.g:9065:3: ruleAndOpExp
            {
             before(grammarAccess.getOrOpExpAccess().getTargetAndOpExpParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAndOpExp();

            state._fsp--;

             after(grammarAccess.getOrOpExpAccess().getTargetAndOpExpParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrOpExp__TargetAssignment_1_2"


    // $ANTLR start "rule__AndOpExp__NameAssignment_1_1"
    // InternalDOcl.g:9074:1: rule__AndOpExp__NameAssignment_1_1 : ( ruleAndOperator ) ;
    public final void rule__AndOpExp__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9078:1: ( ( ruleAndOperator ) )
            // InternalDOcl.g:9079:2: ( ruleAndOperator )
            {
            // InternalDOcl.g:9079:2: ( ruleAndOperator )
            // InternalDOcl.g:9080:3: ruleAndOperator
            {
             before(grammarAccess.getAndOpExpAccess().getNameAndOperatorParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAndOperator();

            state._fsp--;

             after(grammarAccess.getAndOpExpAccess().getNameAndOperatorParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOpExp__NameAssignment_1_1"


    // $ANTLR start "rule__AndOpExp__TargetAssignment_1_2"
    // InternalDOcl.g:9089:1: rule__AndOpExp__TargetAssignment_1_2 : ( ruleEqOpExp ) ;
    public final void rule__AndOpExp__TargetAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9093:1: ( ( ruleEqOpExp ) )
            // InternalDOcl.g:9094:2: ( ruleEqOpExp )
            {
            // InternalDOcl.g:9094:2: ( ruleEqOpExp )
            // InternalDOcl.g:9095:3: ruleEqOpExp
            {
             before(grammarAccess.getAndOpExpAccess().getTargetEqOpExpParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEqOpExp();

            state._fsp--;

             after(grammarAccess.getAndOpExpAccess().getTargetEqOpExpParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AndOpExp__TargetAssignment_1_2"


    // $ANTLR start "rule__EqOpExp__NameAssignment_1_1"
    // InternalDOcl.g:9104:1: rule__EqOpExp__NameAssignment_1_1 : ( ( rule__EqOpExp__NameAlternatives_1_1_0 ) ) ;
    public final void rule__EqOpExp__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9108:1: ( ( ( rule__EqOpExp__NameAlternatives_1_1_0 ) ) )
            // InternalDOcl.g:9109:2: ( ( rule__EqOpExp__NameAlternatives_1_1_0 ) )
            {
            // InternalDOcl.g:9109:2: ( ( rule__EqOpExp__NameAlternatives_1_1_0 ) )
            // InternalDOcl.g:9110:3: ( rule__EqOpExp__NameAlternatives_1_1_0 )
            {
             before(grammarAccess.getEqOpExpAccess().getNameAlternatives_1_1_0()); 
            // InternalDOcl.g:9111:3: ( rule__EqOpExp__NameAlternatives_1_1_0 )
            // InternalDOcl.g:9111:4: rule__EqOpExp__NameAlternatives_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__EqOpExp__NameAlternatives_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getEqOpExpAccess().getNameAlternatives_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__NameAssignment_1_1"


    // $ANTLR start "rule__EqOpExp__TargetAssignment_1_2"
    // InternalDOcl.g:9119:1: rule__EqOpExp__TargetAssignment_1_2 : ( ruleComparisonOpExp ) ;
    public final void rule__EqOpExp__TargetAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9123:1: ( ( ruleComparisonOpExp ) )
            // InternalDOcl.g:9124:2: ( ruleComparisonOpExp )
            {
            // InternalDOcl.g:9124:2: ( ruleComparisonOpExp )
            // InternalDOcl.g:9125:3: ruleComparisonOpExp
            {
             before(grammarAccess.getEqOpExpAccess().getTargetComparisonOpExpParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleComparisonOpExp();

            state._fsp--;

             after(grammarAccess.getEqOpExpAccess().getTargetComparisonOpExpParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EqOpExp__TargetAssignment_1_2"


    // $ANTLR start "rule__ComparisonOpExp__NameAssignment_1_1"
    // InternalDOcl.g:9134:1: rule__ComparisonOpExp__NameAssignment_1_1 : ( ( rule__ComparisonOpExp__NameAlternatives_1_1_0 ) ) ;
    public final void rule__ComparisonOpExp__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9138:1: ( ( ( rule__ComparisonOpExp__NameAlternatives_1_1_0 ) ) )
            // InternalDOcl.g:9139:2: ( ( rule__ComparisonOpExp__NameAlternatives_1_1_0 ) )
            {
            // InternalDOcl.g:9139:2: ( ( rule__ComparisonOpExp__NameAlternatives_1_1_0 ) )
            // InternalDOcl.g:9140:3: ( rule__ComparisonOpExp__NameAlternatives_1_1_0 )
            {
             before(grammarAccess.getComparisonOpExpAccess().getNameAlternatives_1_1_0()); 
            // InternalDOcl.g:9141:3: ( rule__ComparisonOpExp__NameAlternatives_1_1_0 )
            // InternalDOcl.g:9141:4: rule__ComparisonOpExp__NameAlternatives_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__ComparisonOpExp__NameAlternatives_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getComparisonOpExpAccess().getNameAlternatives_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__NameAssignment_1_1"


    // $ANTLR start "rule__ComparisonOpExp__TargetAssignment_1_2"
    // InternalDOcl.g:9149:1: rule__ComparisonOpExp__TargetAssignment_1_2 : ( ruleAdditionOpExp ) ;
    public final void rule__ComparisonOpExp__TargetAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9153:1: ( ( ruleAdditionOpExp ) )
            // InternalDOcl.g:9154:2: ( ruleAdditionOpExp )
            {
            // InternalDOcl.g:9154:2: ( ruleAdditionOpExp )
            // InternalDOcl.g:9155:3: ruleAdditionOpExp
            {
             before(grammarAccess.getComparisonOpExpAccess().getTargetAdditionOpExpParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleAdditionOpExp();

            state._fsp--;

             after(grammarAccess.getComparisonOpExpAccess().getTargetAdditionOpExpParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ComparisonOpExp__TargetAssignment_1_2"


    // $ANTLR start "rule__AdditionOpExp__NameAssignment_1_1"
    // InternalDOcl.g:9164:1: rule__AdditionOpExp__NameAssignment_1_1 : ( ( rule__AdditionOpExp__NameAlternatives_1_1_0 ) ) ;
    public final void rule__AdditionOpExp__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9168:1: ( ( ( rule__AdditionOpExp__NameAlternatives_1_1_0 ) ) )
            // InternalDOcl.g:9169:2: ( ( rule__AdditionOpExp__NameAlternatives_1_1_0 ) )
            {
            // InternalDOcl.g:9169:2: ( ( rule__AdditionOpExp__NameAlternatives_1_1_0 ) )
            // InternalDOcl.g:9170:3: ( rule__AdditionOpExp__NameAlternatives_1_1_0 )
            {
             before(grammarAccess.getAdditionOpExpAccess().getNameAlternatives_1_1_0()); 
            // InternalDOcl.g:9171:3: ( rule__AdditionOpExp__NameAlternatives_1_1_0 )
            // InternalDOcl.g:9171:4: rule__AdditionOpExp__NameAlternatives_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__AdditionOpExp__NameAlternatives_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAdditionOpExpAccess().getNameAlternatives_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__NameAssignment_1_1"


    // $ANTLR start "rule__AdditionOpExp__TargetAssignment_1_2"
    // InternalDOcl.g:9179:1: rule__AdditionOpExp__TargetAssignment_1_2 : ( ruleMultiOpExp ) ;
    public final void rule__AdditionOpExp__TargetAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9183:1: ( ( ruleMultiOpExp ) )
            // InternalDOcl.g:9184:2: ( ruleMultiOpExp )
            {
            // InternalDOcl.g:9184:2: ( ruleMultiOpExp )
            // InternalDOcl.g:9185:3: ruleMultiOpExp
            {
             before(grammarAccess.getAdditionOpExpAccess().getTargetMultiOpExpParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiOpExp();

            state._fsp--;

             after(grammarAccess.getAdditionOpExpAccess().getTargetMultiOpExpParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AdditionOpExp__TargetAssignment_1_2"


    // $ANTLR start "rule__MultiOpExp__NameAssignment_1_1"
    // InternalDOcl.g:9194:1: rule__MultiOpExp__NameAssignment_1_1 : ( ( rule__MultiOpExp__NameAlternatives_1_1_0 ) ) ;
    public final void rule__MultiOpExp__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9198:1: ( ( ( rule__MultiOpExp__NameAlternatives_1_1_0 ) ) )
            // InternalDOcl.g:9199:2: ( ( rule__MultiOpExp__NameAlternatives_1_1_0 ) )
            {
            // InternalDOcl.g:9199:2: ( ( rule__MultiOpExp__NameAlternatives_1_1_0 ) )
            // InternalDOcl.g:9200:3: ( rule__MultiOpExp__NameAlternatives_1_1_0 )
            {
             before(grammarAccess.getMultiOpExpAccess().getNameAlternatives_1_1_0()); 
            // InternalDOcl.g:9201:3: ( rule__MultiOpExp__NameAlternatives_1_1_0 )
            // InternalDOcl.g:9201:4: rule__MultiOpExp__NameAlternatives_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiOpExp__NameAlternatives_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiOpExpAccess().getNameAlternatives_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__NameAssignment_1_1"


    // $ANTLR start "rule__MultiOpExp__TargetAssignment_1_2"
    // InternalDOcl.g:9209:1: rule__MultiOpExp__TargetAssignment_1_2 : ( ruleNavOpExp ) ;
    public final void rule__MultiOpExp__TargetAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9213:1: ( ( ruleNavOpExp ) )
            // InternalDOcl.g:9214:2: ( ruleNavOpExp )
            {
            // InternalDOcl.g:9214:2: ( ruleNavOpExp )
            // InternalDOcl.g:9215:3: ruleNavOpExp
            {
             before(grammarAccess.getMultiOpExpAccess().getTargetNavOpExpParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNavOpExp();

            state._fsp--;

             after(grammarAccess.getMultiOpExpAccess().getTargetNavOpExpParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiOpExp__TargetAssignment_1_2"


    // $ANTLR start "rule__NavOpExp__NameAssignment_1_1"
    // InternalDOcl.g:9224:1: rule__NavOpExp__NameAssignment_1_1 : ( ruleNavigationOperator ) ;
    public final void rule__NavOpExp__NameAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9228:1: ( ( ruleNavigationOperator ) )
            // InternalDOcl.g:9229:2: ( ruleNavigationOperator )
            {
            // InternalDOcl.g:9229:2: ( ruleNavigationOperator )
            // InternalDOcl.g:9230:3: ruleNavigationOperator
            {
             before(grammarAccess.getNavOpExpAccess().getNameNavigationOperatorParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleNavigationOperator();

            state._fsp--;

             after(grammarAccess.getNavOpExpAccess().getNameNavigationOperatorParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavOpExp__NameAssignment_1_1"


    // $ANTLR start "rule__NavOpExp__TargetAssignment_1_2"
    // InternalDOcl.g:9239:1: rule__NavOpExp__TargetAssignment_1_2 : ( ruleNavigationOpCallExp ) ;
    public final void rule__NavOpExp__TargetAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9243:1: ( ( ruleNavigationOpCallExp ) )
            // InternalDOcl.g:9244:2: ( ruleNavigationOpCallExp )
            {
            // InternalDOcl.g:9244:2: ( ruleNavigationOpCallExp )
            // InternalDOcl.g:9245:3: ruleNavigationOpCallExp
            {
             before(grammarAccess.getNavOpExpAccess().getTargetNavigationOpCallExpParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNavigationOpCallExp();

            state._fsp--;

             after(grammarAccess.getNavOpExpAccess().getTargetNavigationOpCallExpParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavOpExp__TargetAssignment_1_2"


    // $ANTLR start "rule__CollectionOpCall__NameAssignment_1"
    // InternalDOcl.g:9254:1: rule__CollectionOpCall__NameAssignment_1 : ( ruleCollectionOperationID ) ;
    public final void rule__CollectionOpCall__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9258:1: ( ( ruleCollectionOperationID ) )
            // InternalDOcl.g:9259:2: ( ruleCollectionOperationID )
            {
            // InternalDOcl.g:9259:2: ( ruleCollectionOperationID )
            // InternalDOcl.g:9260:3: ruleCollectionOperationID
            {
             before(grammarAccess.getCollectionOpCallAccess().getNameCollectionOperationIDParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleCollectionOperationID();

            state._fsp--;

             after(grammarAccess.getCollectionOpCallAccess().getNameCollectionOperationIDParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__NameAssignment_1"


    // $ANTLR start "rule__CollectionOpCall__ArgumentsAssignment_3_0"
    // InternalDOcl.g:9269:1: rule__CollectionOpCall__ArgumentsAssignment_3_0 : ( ruleOclExpression ) ;
    public final void rule__CollectionOpCall__ArgumentsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9273:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9274:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9274:2: ( ruleOclExpression )
            // InternalDOcl.g:9275:3: ruleOclExpression
            {
             before(grammarAccess.getCollectionOpCallAccess().getArgumentsOclExpressionParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getCollectionOpCallAccess().getArgumentsOclExpressionParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__ArgumentsAssignment_3_0"


    // $ANTLR start "rule__CollectionOpCall__ArgumentsAssignment_3_1_1"
    // InternalDOcl.g:9284:1: rule__CollectionOpCall__ArgumentsAssignment_3_1_1 : ( ruleOclExpression ) ;
    public final void rule__CollectionOpCall__ArgumentsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9288:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9289:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9289:2: ( ruleOclExpression )
            // InternalDOcl.g:9290:3: ruleOclExpression
            {
             before(grammarAccess.getCollectionOpCallAccess().getArgumentsOclExpressionParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getCollectionOpCallAccess().getArgumentsOclExpressionParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionOpCall__ArgumentsAssignment_3_1_1"


    // $ANTLR start "rule__IterateExp__NameAssignment_1"
    // InternalDOcl.g:9299:1: rule__IterateExp__NameAssignment_1 : ( ( 'iterate' ) ) ;
    public final void rule__IterateExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9303:1: ( ( ( 'iterate' ) ) )
            // InternalDOcl.g:9304:2: ( ( 'iterate' ) )
            {
            // InternalDOcl.g:9304:2: ( ( 'iterate' ) )
            // InternalDOcl.g:9305:3: ( 'iterate' )
            {
             before(grammarAccess.getIterateExpAccess().getNameIterateKeyword_1_0()); 
            // InternalDOcl.g:9306:3: ( 'iterate' )
            // InternalDOcl.g:9307:4: 'iterate'
            {
             before(grammarAccess.getIterateExpAccess().getNameIterateKeyword_1_0()); 
            match(input,85,FOLLOW_2); 
             after(grammarAccess.getIterateExpAccess().getNameIterateKeyword_1_0()); 

            }

             after(grammarAccess.getIterateExpAccess().getNameIterateKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__NameAssignment_1"


    // $ANTLR start "rule__IterateExp__IteratorsAssignment_3"
    // InternalDOcl.g:9318:1: rule__IterateExp__IteratorsAssignment_3 : ( ruleIterator ) ;
    public final void rule__IterateExp__IteratorsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9322:1: ( ( ruleIterator ) )
            // InternalDOcl.g:9323:2: ( ruleIterator )
            {
            // InternalDOcl.g:9323:2: ( ruleIterator )
            // InternalDOcl.g:9324:3: ruleIterator
            {
             before(grammarAccess.getIterateExpAccess().getIteratorsIteratorParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleIterator();

            state._fsp--;

             after(grammarAccess.getIterateExpAccess().getIteratorsIteratorParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__IteratorsAssignment_3"


    // $ANTLR start "rule__IterateExp__IteratorsAssignment_4_1"
    // InternalDOcl.g:9333:1: rule__IterateExp__IteratorsAssignment_4_1 : ( ruleIterator ) ;
    public final void rule__IterateExp__IteratorsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9337:1: ( ( ruleIterator ) )
            // InternalDOcl.g:9338:2: ( ruleIterator )
            {
            // InternalDOcl.g:9338:2: ( ruleIterator )
            // InternalDOcl.g:9339:3: ruleIterator
            {
             before(grammarAccess.getIterateExpAccess().getIteratorsIteratorParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleIterator();

            state._fsp--;

             after(grammarAccess.getIterateExpAccess().getIteratorsIteratorParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__IteratorsAssignment_4_1"


    // $ANTLR start "rule__IterateExp__ResultAssignment_6"
    // InternalDOcl.g:9348:1: rule__IterateExp__ResultAssignment_6 : ( ruleLocalVariable ) ;
    public final void rule__IterateExp__ResultAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9352:1: ( ( ruleLocalVariable ) )
            // InternalDOcl.g:9353:2: ( ruleLocalVariable )
            {
            // InternalDOcl.g:9353:2: ( ruleLocalVariable )
            // InternalDOcl.g:9354:3: ruleLocalVariable
            {
             before(grammarAccess.getIterateExpAccess().getResultLocalVariableParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleLocalVariable();

            state._fsp--;

             after(grammarAccess.getIterateExpAccess().getResultLocalVariableParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__ResultAssignment_6"


    // $ANTLR start "rule__IterateExp__BodyAssignment_8"
    // InternalDOcl.g:9363:1: rule__IterateExp__BodyAssignment_8 : ( ruleOclExpression ) ;
    public final void rule__IterateExp__BodyAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9367:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9368:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9368:2: ( ruleOclExpression )
            // InternalDOcl.g:9369:3: ruleOclExpression
            {
             before(grammarAccess.getIterateExpAccess().getBodyOclExpressionParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getIterateExpAccess().getBodyOclExpressionParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IterateExp__BodyAssignment_8"


    // $ANTLR start "rule__Iterator__NameAssignment_0"
    // InternalDOcl.g:9378:1: rule__Iterator__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__Iterator__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9382:1: ( ( RULE_ID ) )
            // InternalDOcl.g:9383:2: ( RULE_ID )
            {
            // InternalDOcl.g:9383:2: ( RULE_ID )
            // InternalDOcl.g:9384:3: RULE_ID
            {
             before(grammarAccess.getIteratorAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getIteratorAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iterator__NameAssignment_0"


    // $ANTLR start "rule__Iterator__TypeAssignment_1_1"
    // InternalDOcl.g:9393:1: rule__Iterator__TypeAssignment_1_1 : ( ruleOclType ) ;
    public final void rule__Iterator__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9397:1: ( ( ruleOclType ) )
            // InternalDOcl.g:9398:2: ( ruleOclType )
            {
            // InternalDOcl.g:9398:2: ( ruleOclType )
            // InternalDOcl.g:9399:3: ruleOclType
            {
             before(grammarAccess.getIteratorAccess().getTypeOclTypeParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getIteratorAccess().getTypeOclTypeParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Iterator__TypeAssignment_1_1"


    // $ANTLR start "rule__IteratorExp__NameAssignment_1"
    // InternalDOcl.g:9408:1: rule__IteratorExp__NameAssignment_1 : ( ruleIterativeOperationID ) ;
    public final void rule__IteratorExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9412:1: ( ( ruleIterativeOperationID ) )
            // InternalDOcl.g:9413:2: ( ruleIterativeOperationID )
            {
            // InternalDOcl.g:9413:2: ( ruleIterativeOperationID )
            // InternalDOcl.g:9414:3: ruleIterativeOperationID
            {
             before(grammarAccess.getIteratorExpAccess().getNameIterativeOperationIDParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleIterativeOperationID();

            state._fsp--;

             after(grammarAccess.getIteratorExpAccess().getNameIterativeOperationIDParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__NameAssignment_1"


    // $ANTLR start "rule__IteratorExp__IteratorsAssignment_3"
    // InternalDOcl.g:9423:1: rule__IteratorExp__IteratorsAssignment_3 : ( ruleIterator ) ;
    public final void rule__IteratorExp__IteratorsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9427:1: ( ( ruleIterator ) )
            // InternalDOcl.g:9428:2: ( ruleIterator )
            {
            // InternalDOcl.g:9428:2: ( ruleIterator )
            // InternalDOcl.g:9429:3: ruleIterator
            {
             before(grammarAccess.getIteratorExpAccess().getIteratorsIteratorParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleIterator();

            state._fsp--;

             after(grammarAccess.getIteratorExpAccess().getIteratorsIteratorParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__IteratorsAssignment_3"


    // $ANTLR start "rule__IteratorExp__IteratorsAssignment_4_1"
    // InternalDOcl.g:9438:1: rule__IteratorExp__IteratorsAssignment_4_1 : ( ruleIterator ) ;
    public final void rule__IteratorExp__IteratorsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9442:1: ( ( ruleIterator ) )
            // InternalDOcl.g:9443:2: ( ruleIterator )
            {
            // InternalDOcl.g:9443:2: ( ruleIterator )
            // InternalDOcl.g:9444:3: ruleIterator
            {
             before(grammarAccess.getIteratorExpAccess().getIteratorsIteratorParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleIterator();

            state._fsp--;

             after(grammarAccess.getIteratorExpAccess().getIteratorsIteratorParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__IteratorsAssignment_4_1"


    // $ANTLR start "rule__IteratorExp__BodyAssignment_6"
    // InternalDOcl.g:9453:1: rule__IteratorExp__BodyAssignment_6 : ( ruleOclExpression ) ;
    public final void rule__IteratorExp__BodyAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9457:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9458:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9458:2: ( ruleOclExpression )
            // InternalDOcl.g:9459:3: ruleOclExpression
            {
             before(grammarAccess.getIteratorExpAccess().getBodyOclExpressionParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getIteratorExpAccess().getBodyOclExpressionParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IteratorExp__BodyAssignment_6"


    // $ANTLR start "rule__NavigationOrAttributeCall__FeatureAssignment_1"
    // InternalDOcl.g:9468:1: rule__NavigationOrAttributeCall__FeatureAssignment_1 : ( RULE_ID ) ;
    public final void rule__NavigationOrAttributeCall__FeatureAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9472:1: ( ( RULE_ID ) )
            // InternalDOcl.g:9473:2: ( RULE_ID )
            {
            // InternalDOcl.g:9473:2: ( RULE_ID )
            // InternalDOcl.g:9474:3: RULE_ID
            {
             before(grammarAccess.getNavigationOrAttributeCallAccess().getFeatureIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNavigationOrAttributeCallAccess().getFeatureIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NavigationOrAttributeCall__FeatureAssignment_1"


    // $ANTLR start "rule__OperationCall__NameAssignment_1"
    // InternalDOcl.g:9483:1: rule__OperationCall__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__OperationCall__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9487:1: ( ( RULE_ID ) )
            // InternalDOcl.g:9488:2: ( RULE_ID )
            {
            // InternalDOcl.g:9488:2: ( RULE_ID )
            // InternalDOcl.g:9489:3: RULE_ID
            {
             before(grammarAccess.getOperationCallAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOperationCallAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__NameAssignment_1"


    // $ANTLR start "rule__OperationCall__ArgumentsAssignment_3_0"
    // InternalDOcl.g:9498:1: rule__OperationCall__ArgumentsAssignment_3_0 : ( ruleOclExpression ) ;
    public final void rule__OperationCall__ArgumentsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9502:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9503:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9503:2: ( ruleOclExpression )
            // InternalDOcl.g:9504:3: ruleOclExpression
            {
             before(grammarAccess.getOperationCallAccess().getArgumentsOclExpressionParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getOperationCallAccess().getArgumentsOclExpressionParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__ArgumentsAssignment_3_0"


    // $ANTLR start "rule__OperationCall__ArgumentsAssignment_3_1_1"
    // InternalDOcl.g:9513:1: rule__OperationCall__ArgumentsAssignment_3_1_1 : ( ruleOclExpression ) ;
    public final void rule__OperationCall__ArgumentsAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9517:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9518:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9518:2: ( ruleOclExpression )
            // InternalDOcl.g:9519:3: ruleOclExpression
            {
             before(grammarAccess.getOperationCallAccess().getArgumentsOclExpressionParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getOperationCallAccess().getArgumentsOclExpressionParserRuleCall_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OperationCall__ArgumentsAssignment_3_1_1"


    // $ANTLR start "rule__OclModelElementExp__ModelAssignment_0"
    // InternalDOcl.g:9528:1: rule__OclModelElementExp__ModelAssignment_0 : ( ruleOclModel ) ;
    public final void rule__OclModelElementExp__ModelAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9532:1: ( ( ruleOclModel ) )
            // InternalDOcl.g:9533:2: ( ruleOclModel )
            {
            // InternalDOcl.g:9533:2: ( ruleOclModel )
            // InternalDOcl.g:9534:3: ruleOclModel
            {
             before(grammarAccess.getOclModelElementExpAccess().getModelOclModelParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleOclModel();

            state._fsp--;

             after(grammarAccess.getOclModelElementExpAccess().getModelOclModelParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__ModelAssignment_0"


    // $ANTLR start "rule__OclModelElementExp__NameAssignment_1"
    // InternalDOcl.g:9543:1: rule__OclModelElementExp__NameAssignment_1 : ( ( '::' ) ) ;
    public final void rule__OclModelElementExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9547:1: ( ( ( '::' ) ) )
            // InternalDOcl.g:9548:2: ( ( '::' ) )
            {
            // InternalDOcl.g:9548:2: ( ( '::' ) )
            // InternalDOcl.g:9549:3: ( '::' )
            {
             before(grammarAccess.getOclModelElementExpAccess().getNameColonColonKeyword_1_0()); 
            // InternalDOcl.g:9550:3: ( '::' )
            // InternalDOcl.g:9551:4: '::'
            {
             before(grammarAccess.getOclModelElementExpAccess().getNameColonColonKeyword_1_0()); 
            match(input,76,FOLLOW_2); 
             after(grammarAccess.getOclModelElementExpAccess().getNameColonColonKeyword_1_0()); 

            }

             after(grammarAccess.getOclModelElementExpAccess().getNameColonColonKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__NameAssignment_1"


    // $ANTLR start "rule__OclModelElementExp__ElementsAssignment_2"
    // InternalDOcl.g:9562:1: rule__OclModelElementExp__ElementsAssignment_2 : ( RULE_ID ) ;
    public final void rule__OclModelElementExp__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9566:1: ( ( RULE_ID ) )
            // InternalDOcl.g:9567:2: ( RULE_ID )
            {
            // InternalDOcl.g:9567:2: ( RULE_ID )
            // InternalDOcl.g:9568:3: RULE_ID
            {
             before(grammarAccess.getOclModelElementExpAccess().getElementsIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOclModelElementExpAccess().getElementsIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__ElementsAssignment_2"


    // $ANTLR start "rule__OclModelElementExp__ElementsAssignment_3_1"
    // InternalDOcl.g:9577:1: rule__OclModelElementExp__ElementsAssignment_3_1 : ( RULE_ID ) ;
    public final void rule__OclModelElementExp__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9581:1: ( ( RULE_ID ) )
            // InternalDOcl.g:9582:2: ( RULE_ID )
            {
            // InternalDOcl.g:9582:2: ( RULE_ID )
            // InternalDOcl.g:9583:3: RULE_ID
            {
             before(grammarAccess.getOclModelElementExpAccess().getElementsIDTerminalRuleCall_3_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOclModelElementExpAccess().getElementsIDTerminalRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__ElementsAssignment_3_1"


    // $ANTLR start "rule__OclModelElementExp__TargetAssignment_4"
    // InternalDOcl.g:9592:1: rule__OclModelElementExp__TargetAssignment_4 : ( ruleAllInstancesOpCall ) ;
    public final void rule__OclModelElementExp__TargetAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9596:1: ( ( ruleAllInstancesOpCall ) )
            // InternalDOcl.g:9597:2: ( ruleAllInstancesOpCall )
            {
            // InternalDOcl.g:9597:2: ( ruleAllInstancesOpCall )
            // InternalDOcl.g:9598:3: ruleAllInstancesOpCall
            {
             before(grammarAccess.getOclModelElementExpAccess().getTargetAllInstancesOpCallParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleAllInstancesOpCall();

            state._fsp--;

             after(grammarAccess.getOclModelElementExpAccess().getTargetAllInstancesOpCallParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElementExp__TargetAssignment_4"


    // $ANTLR start "rule__AllInstancesOpCall__NameAssignment_2"
    // InternalDOcl.g:9607:1: rule__AllInstancesOpCall__NameAssignment_2 : ( ( 'allInstances' ) ) ;
    public final void rule__AllInstancesOpCall__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9611:1: ( ( ( 'allInstances' ) ) )
            // InternalDOcl.g:9612:2: ( ( 'allInstances' ) )
            {
            // InternalDOcl.g:9612:2: ( ( 'allInstances' ) )
            // InternalDOcl.g:9613:3: ( 'allInstances' )
            {
             before(grammarAccess.getAllInstancesOpCallAccess().getNameAllInstancesKeyword_2_0()); 
            // InternalDOcl.g:9614:3: ( 'allInstances' )
            // InternalDOcl.g:9615:4: 'allInstances'
            {
             before(grammarAccess.getAllInstancesOpCallAccess().getNameAllInstancesKeyword_2_0()); 
            match(input,86,FOLLOW_2); 
             after(grammarAccess.getAllInstancesOpCallAccess().getNameAllInstancesKeyword_2_0()); 

            }

             after(grammarAccess.getAllInstancesOpCallAccess().getNameAllInstancesKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AllInstancesOpCall__NameAssignment_2"


    // $ANTLR start "rule__LocalVariable__NameAssignment_0"
    // InternalDOcl.g:9626:1: rule__LocalVariable__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__LocalVariable__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9630:1: ( ( RULE_ID ) )
            // InternalDOcl.g:9631:2: ( RULE_ID )
            {
            // InternalDOcl.g:9631:2: ( RULE_ID )
            // InternalDOcl.g:9632:3: RULE_ID
            {
             before(grammarAccess.getLocalVariableAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLocalVariableAccess().getNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__NameAssignment_0"


    // $ANTLR start "rule__LocalVariable__TypeAssignment_2"
    // InternalDOcl.g:9641:1: rule__LocalVariable__TypeAssignment_2 : ( ruleOclType ) ;
    public final void rule__LocalVariable__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9645:1: ( ( ruleOclType ) )
            // InternalDOcl.g:9646:2: ( ruleOclType )
            {
            // InternalDOcl.g:9646:2: ( ruleOclType )
            // InternalDOcl.g:9647:3: ruleOclType
            {
             before(grammarAccess.getLocalVariableAccess().getTypeOclTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getLocalVariableAccess().getTypeOclTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__TypeAssignment_2"


    // $ANTLR start "rule__LocalVariable__InitExpAssignment_4"
    // InternalDOcl.g:9656:1: rule__LocalVariable__InitExpAssignment_4 : ( ruleOclExpression ) ;
    public final void rule__LocalVariable__InitExpAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9660:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9661:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9661:2: ( ruleOclExpression )
            // InternalDOcl.g:9662:3: ruleOclExpression
            {
             before(grammarAccess.getLocalVariableAccess().getInitExpOclExpressionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getLocalVariableAccess().getInitExpOclExpressionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LocalVariable__InitExpAssignment_4"


    // $ANTLR start "rule__LambdaExp__NameAssignment_1"
    // InternalDOcl.g:9671:1: rule__LambdaExp__NameAssignment_1 : ( ( 'Lambda' ) ) ;
    public final void rule__LambdaExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9675:1: ( ( ( 'Lambda' ) ) )
            // InternalDOcl.g:9676:2: ( ( 'Lambda' ) )
            {
            // InternalDOcl.g:9676:2: ( ( 'Lambda' ) )
            // InternalDOcl.g:9677:3: ( 'Lambda' )
            {
             before(grammarAccess.getLambdaExpAccess().getNameLambdaKeyword_1_0()); 
            // InternalDOcl.g:9678:3: ( 'Lambda' )
            // InternalDOcl.g:9679:4: 'Lambda'
            {
             before(grammarAccess.getLambdaExpAccess().getNameLambdaKeyword_1_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getLambdaExpAccess().getNameLambdaKeyword_1_0()); 

            }

             after(grammarAccess.getLambdaExpAccess().getNameLambdaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaExp__NameAssignment_1"


    // $ANTLR start "rule__LambdaExp__ExpressionAssignment_3"
    // InternalDOcl.g:9690:1: rule__LambdaExp__ExpressionAssignment_3 : ( ruleOclExpression ) ;
    public final void rule__LambdaExp__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9694:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9695:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9695:2: ( ruleOclExpression )
            // InternalDOcl.g:9696:3: ruleOclExpression
            {
             before(grammarAccess.getLambdaExpAccess().getExpressionOclExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getLambdaExpAccess().getExpressionOclExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaExp__ExpressionAssignment_3"


    // $ANTLR start "rule__TupleExp__NameAssignment_1"
    // InternalDOcl.g:9705:1: rule__TupleExp__NameAssignment_1 : ( ( 'Tuple' ) ) ;
    public final void rule__TupleExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9709:1: ( ( ( 'Tuple' ) ) )
            // InternalDOcl.g:9710:2: ( ( 'Tuple' ) )
            {
            // InternalDOcl.g:9710:2: ( ( 'Tuple' ) )
            // InternalDOcl.g:9711:3: ( 'Tuple' )
            {
             before(grammarAccess.getTupleExpAccess().getNameTupleKeyword_1_0()); 
            // InternalDOcl.g:9712:3: ( 'Tuple' )
            // InternalDOcl.g:9713:4: 'Tuple'
            {
             before(grammarAccess.getTupleExpAccess().getNameTupleKeyword_1_0()); 
            match(input,88,FOLLOW_2); 
             after(grammarAccess.getTupleExpAccess().getNameTupleKeyword_1_0()); 

            }

             after(grammarAccess.getTupleExpAccess().getNameTupleKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__NameAssignment_1"


    // $ANTLR start "rule__TupleExp__PartsAssignment_3"
    // InternalDOcl.g:9724:1: rule__TupleExp__PartsAssignment_3 : ( ruleTuplePart ) ;
    public final void rule__TupleExp__PartsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9728:1: ( ( ruleTuplePart ) )
            // InternalDOcl.g:9729:2: ( ruleTuplePart )
            {
            // InternalDOcl.g:9729:2: ( ruleTuplePart )
            // InternalDOcl.g:9730:3: ruleTuplePart
            {
             before(grammarAccess.getTupleExpAccess().getPartsTuplePartParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTuplePart();

            state._fsp--;

             after(grammarAccess.getTupleExpAccess().getPartsTuplePartParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__PartsAssignment_3"


    // $ANTLR start "rule__TupleExp__PartsAssignment_4_1"
    // InternalDOcl.g:9739:1: rule__TupleExp__PartsAssignment_4_1 : ( ruleTuplePart ) ;
    public final void rule__TupleExp__PartsAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9743:1: ( ( ruleTuplePart ) )
            // InternalDOcl.g:9744:2: ( ruleTuplePart )
            {
            // InternalDOcl.g:9744:2: ( ruleTuplePart )
            // InternalDOcl.g:9745:3: ruleTuplePart
            {
             before(grammarAccess.getTupleExpAccess().getPartsTuplePartParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleTuplePart();

            state._fsp--;

             after(grammarAccess.getTupleExpAccess().getPartsTuplePartParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TupleExp__PartsAssignment_4_1"


    // $ANTLR start "rule__TuplePart__NameAssignment_0"
    // InternalDOcl.g:9754:1: rule__TuplePart__NameAssignment_0 : ( RULE_STRING ) ;
    public final void rule__TuplePart__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9758:1: ( ( RULE_STRING ) )
            // InternalDOcl.g:9759:2: ( RULE_STRING )
            {
            // InternalDOcl.g:9759:2: ( RULE_STRING )
            // InternalDOcl.g:9760:3: RULE_STRING
            {
             before(grammarAccess.getTuplePartAccess().getNameSTRINGTerminalRuleCall_0_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getTuplePartAccess().getNameSTRINGTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__NameAssignment_0"


    // $ANTLR start "rule__TuplePart__TypeAssignment_1_1"
    // InternalDOcl.g:9769:1: rule__TuplePart__TypeAssignment_1_1 : ( ruleOclType ) ;
    public final void rule__TuplePart__TypeAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9773:1: ( ( ruleOclType ) )
            // InternalDOcl.g:9774:2: ( ruleOclType )
            {
            // InternalDOcl.g:9774:2: ( ruleOclType )
            // InternalDOcl.g:9775:3: ruleOclType
            {
             before(grammarAccess.getTuplePartAccess().getTypeOclTypeParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getTuplePartAccess().getTypeOclTypeParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__TypeAssignment_1_1"


    // $ANTLR start "rule__TuplePart__InitAssignment_3"
    // InternalDOcl.g:9784:1: rule__TuplePart__InitAssignment_3 : ( ruleOclExpression ) ;
    public final void rule__TuplePart__InitAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9788:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9789:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9789:2: ( ruleOclExpression )
            // InternalDOcl.g:9790:3: ruleOclExpression
            {
             before(grammarAccess.getTuplePartAccess().getInitOclExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getTuplePartAccess().getInitOclExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TuplePart__InitAssignment_3"


    // $ANTLR start "rule__NumberExp__SymbolAssignment"
    // InternalDOcl.g:9799:1: rule__NumberExp__SymbolAssignment : ( RULE_INT ) ;
    public final void rule__NumberExp__SymbolAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9803:1: ( ( RULE_INT ) )
            // InternalDOcl.g:9804:2: ( RULE_INT )
            {
            // InternalDOcl.g:9804:2: ( RULE_INT )
            // InternalDOcl.g:9805:3: RULE_INT
            {
             before(grammarAccess.getNumberExpAccess().getSymbolINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getNumberExpAccess().getSymbolINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NumberExp__SymbolAssignment"


    // $ANTLR start "rule__StringExp__SegmentsAssignment"
    // InternalDOcl.g:9814:1: rule__StringExp__SegmentsAssignment : ( RULE_STRING ) ;
    public final void rule__StringExp__SegmentsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9818:1: ( ( RULE_STRING ) )
            // InternalDOcl.g:9819:2: ( RULE_STRING )
            {
            // InternalDOcl.g:9819:2: ( RULE_STRING )
            // InternalDOcl.g:9820:3: RULE_STRING
            {
             before(grammarAccess.getStringExpAccess().getSegmentsSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_2); 
             after(grammarAccess.getStringExpAccess().getSegmentsSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringExp__SegmentsAssignment"


    // $ANTLR start "rule__BooleanExp__SymbolAssignment_0"
    // InternalDOcl.g:9829:1: rule__BooleanExp__SymbolAssignment_0 : ( ( 'true' ) ) ;
    public final void rule__BooleanExp__SymbolAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9833:1: ( ( ( 'true' ) ) )
            // InternalDOcl.g:9834:2: ( ( 'true' ) )
            {
            // InternalDOcl.g:9834:2: ( ( 'true' ) )
            // InternalDOcl.g:9835:3: ( 'true' )
            {
             before(grammarAccess.getBooleanExpAccess().getSymbolTrueKeyword_0_0()); 
            // InternalDOcl.g:9836:3: ( 'true' )
            // InternalDOcl.g:9837:4: 'true'
            {
             before(grammarAccess.getBooleanExpAccess().getSymbolTrueKeyword_0_0()); 
            match(input,89,FOLLOW_2); 
             after(grammarAccess.getBooleanExpAccess().getSymbolTrueKeyword_0_0()); 

            }

             after(grammarAccess.getBooleanExpAccess().getSymbolTrueKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExp__SymbolAssignment_0"


    // $ANTLR start "rule__BooleanExp__SymbolAssignment_1"
    // InternalDOcl.g:9848:1: rule__BooleanExp__SymbolAssignment_1 : ( ( 'false' ) ) ;
    public final void rule__BooleanExp__SymbolAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9852:1: ( ( ( 'false' ) ) )
            // InternalDOcl.g:9853:2: ( ( 'false' ) )
            {
            // InternalDOcl.g:9853:2: ( ( 'false' ) )
            // InternalDOcl.g:9854:3: ( 'false' )
            {
             before(grammarAccess.getBooleanExpAccess().getSymbolFalseKeyword_1_0()); 
            // InternalDOcl.g:9855:3: ( 'false' )
            // InternalDOcl.g:9856:4: 'false'
            {
             before(grammarAccess.getBooleanExpAccess().getSymbolFalseKeyword_1_0()); 
            match(input,90,FOLLOW_2); 
             after(grammarAccess.getBooleanExpAccess().getSymbolFalseKeyword_1_0()); 

            }

             after(grammarAccess.getBooleanExpAccess().getSymbolFalseKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanExp__SymbolAssignment_1"


    // $ANTLR start "rule__IfExp__NameAssignment_0"
    // InternalDOcl.g:9867:1: rule__IfExp__NameAssignment_0 : ( ( 'if' ) ) ;
    public final void rule__IfExp__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9871:1: ( ( ( 'if' ) ) )
            // InternalDOcl.g:9872:2: ( ( 'if' ) )
            {
            // InternalDOcl.g:9872:2: ( ( 'if' ) )
            // InternalDOcl.g:9873:3: ( 'if' )
            {
             before(grammarAccess.getIfExpAccess().getNameIfKeyword_0_0()); 
            // InternalDOcl.g:9874:3: ( 'if' )
            // InternalDOcl.g:9875:4: 'if'
            {
             before(grammarAccess.getIfExpAccess().getNameIfKeyword_0_0()); 
            match(input,91,FOLLOW_2); 
             after(grammarAccess.getIfExpAccess().getNameIfKeyword_0_0()); 

            }

             after(grammarAccess.getIfExpAccess().getNameIfKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__NameAssignment_0"


    // $ANTLR start "rule__IfExp__ConditionAssignment_1"
    // InternalDOcl.g:9886:1: rule__IfExp__ConditionAssignment_1 : ( ruleOclExpression ) ;
    public final void rule__IfExp__ConditionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9890:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9891:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9891:2: ( ruleOclExpression )
            // InternalDOcl.g:9892:3: ruleOclExpression
            {
             before(grammarAccess.getIfExpAccess().getConditionOclExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getIfExpAccess().getConditionOclExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__ConditionAssignment_1"


    // $ANTLR start "rule__IfExp__ThenAssignment_3"
    // InternalDOcl.g:9901:1: rule__IfExp__ThenAssignment_3 : ( ruleOclExpression ) ;
    public final void rule__IfExp__ThenAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9905:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9906:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9906:2: ( ruleOclExpression )
            // InternalDOcl.g:9907:3: ruleOclExpression
            {
             before(grammarAccess.getIfExpAccess().getThenOclExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getIfExpAccess().getThenOclExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__ThenAssignment_3"


    // $ANTLR start "rule__IfExp__IfThenAssignment_4"
    // InternalDOcl.g:9916:1: rule__IfExp__IfThenAssignment_4 : ( ruleElseIfThenExp ) ;
    public final void rule__IfExp__IfThenAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9920:1: ( ( ruleElseIfThenExp ) )
            // InternalDOcl.g:9921:2: ( ruleElseIfThenExp )
            {
            // InternalDOcl.g:9921:2: ( ruleElseIfThenExp )
            // InternalDOcl.g:9922:3: ruleElseIfThenExp
            {
             before(grammarAccess.getIfExpAccess().getIfThenElseIfThenExpParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleElseIfThenExp();

            state._fsp--;

             after(grammarAccess.getIfExpAccess().getIfThenElseIfThenExpParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__IfThenAssignment_4"


    // $ANTLR start "rule__IfExp__ElseAssignment_6"
    // InternalDOcl.g:9931:1: rule__IfExp__ElseAssignment_6 : ( ruleOclExpression ) ;
    public final void rule__IfExp__ElseAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9935:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9936:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9936:2: ( ruleOclExpression )
            // InternalDOcl.g:9937:3: ruleOclExpression
            {
             before(grammarAccess.getIfExpAccess().getElseOclExpressionParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getIfExpAccess().getElseOclExpressionParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IfExp__ElseAssignment_6"


    // $ANTLR start "rule__ElseIfThenExp__NameAssignment_1"
    // InternalDOcl.g:9946:1: rule__ElseIfThenExp__NameAssignment_1 : ( ( 'elseif' ) ) ;
    public final void rule__ElseIfThenExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9950:1: ( ( ( 'elseif' ) ) )
            // InternalDOcl.g:9951:2: ( ( 'elseif' ) )
            {
            // InternalDOcl.g:9951:2: ( ( 'elseif' ) )
            // InternalDOcl.g:9952:3: ( 'elseif' )
            {
             before(grammarAccess.getElseIfThenExpAccess().getNameElseifKeyword_1_0()); 
            // InternalDOcl.g:9953:3: ( 'elseif' )
            // InternalDOcl.g:9954:4: 'elseif'
            {
             before(grammarAccess.getElseIfThenExpAccess().getNameElseifKeyword_1_0()); 
            match(input,92,FOLLOW_2); 
             after(grammarAccess.getElseIfThenExpAccess().getNameElseifKeyword_1_0()); 

            }

             after(grammarAccess.getElseIfThenExpAccess().getNameElseifKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__NameAssignment_1"


    // $ANTLR start "rule__ElseIfThenExp__ConditionAssignment_2"
    // InternalDOcl.g:9965:1: rule__ElseIfThenExp__ConditionAssignment_2 : ( ruleOclExpression ) ;
    public final void rule__ElseIfThenExp__ConditionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9969:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9970:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9970:2: ( ruleOclExpression )
            // InternalDOcl.g:9971:3: ruleOclExpression
            {
             before(grammarAccess.getElseIfThenExpAccess().getConditionOclExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getElseIfThenExpAccess().getConditionOclExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__ConditionAssignment_2"


    // $ANTLR start "rule__ElseIfThenExp__ThenAssignment_4"
    // InternalDOcl.g:9980:1: rule__ElseIfThenExp__ThenAssignment_4 : ( ruleOclExpression ) ;
    public final void rule__ElseIfThenExp__ThenAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9984:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:9985:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:9985:2: ( ruleOclExpression )
            // InternalDOcl.g:9986:3: ruleOclExpression
            {
             before(grammarAccess.getElseIfThenExpAccess().getThenOclExpressionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getElseIfThenExpAccess().getThenOclExpressionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ElseIfThenExp__ThenAssignment_4"


    // $ANTLR start "rule__SeflExp__NameAssignment_1"
    // InternalDOcl.g:9995:1: rule__SeflExp__NameAssignment_1 : ( ( 'self' ) ) ;
    public final void rule__SeflExp__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:9999:1: ( ( ( 'self' ) ) )
            // InternalDOcl.g:10000:2: ( ( 'self' ) )
            {
            // InternalDOcl.g:10000:2: ( ( 'self' ) )
            // InternalDOcl.g:10001:3: ( 'self' )
            {
             before(grammarAccess.getSeflExpAccess().getNameSelfKeyword_1_0()); 
            // InternalDOcl.g:10002:3: ( 'self' )
            // InternalDOcl.g:10003:4: 'self'
            {
             before(grammarAccess.getSeflExpAccess().getNameSelfKeyword_1_0()); 
            match(input,93,FOLLOW_2); 
             after(grammarAccess.getSeflExpAccess().getNameSelfKeyword_1_0()); 

            }

             after(grammarAccess.getSeflExpAccess().getNameSelfKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SeflExp__NameAssignment_1"


    // $ANTLR start "rule__NestedExp__ExpAssignment_2"
    // InternalDOcl.g:10014:1: rule__NestedExp__ExpAssignment_2 : ( ruleOclExpression ) ;
    public final void rule__NestedExp__ExpAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10018:1: ( ( ruleOclExpression ) )
            // InternalDOcl.g:10019:2: ( ruleOclExpression )
            {
            // InternalDOcl.g:10019:2: ( ruleOclExpression )
            // InternalDOcl.g:10020:3: ruleOclExpression
            {
             before(grammarAccess.getNestedExpAccess().getExpOclExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOclExpression();

            state._fsp--;

             after(grammarAccess.getNestedExpAccess().getExpOclExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NestedExp__ExpAssignment_2"


    // $ANTLR start "rule__OclModelElement__ModelAssignment_0"
    // InternalDOcl.g:10029:1: rule__OclModelElement__ModelAssignment_0 : ( ruleOclModel ) ;
    public final void rule__OclModelElement__ModelAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10033:1: ( ( ruleOclModel ) )
            // InternalDOcl.g:10034:2: ( ruleOclModel )
            {
            // InternalDOcl.g:10034:2: ( ruleOclModel )
            // InternalDOcl.g:10035:3: ruleOclModel
            {
             before(grammarAccess.getOclModelElementAccess().getModelOclModelParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleOclModel();

            state._fsp--;

             after(grammarAccess.getOclModelElementAccess().getModelOclModelParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElement__ModelAssignment_0"


    // $ANTLR start "rule__OclModelElement__NameAssignment_2"
    // InternalDOcl.g:10044:1: rule__OclModelElement__NameAssignment_2 : ( RULE_ID ) ;
    public final void rule__OclModelElement__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10048:1: ( ( RULE_ID ) )
            // InternalDOcl.g:10049:2: ( RULE_ID )
            {
            // InternalDOcl.g:10049:2: ( RULE_ID )
            // InternalDOcl.g:10050:3: RULE_ID
            {
             before(grammarAccess.getOclModelElementAccess().getNameIDTerminalRuleCall_2_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getOclModelElementAccess().getNameIDTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclModelElement__NameAssignment_2"


    // $ANTLR start "rule__EnvType__NameAssignment"
    // InternalDOcl.g:10059:1: rule__EnvType__NameAssignment : ( ( 'Env' ) ) ;
    public final void rule__EnvType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10063:1: ( ( ( 'Env' ) ) )
            // InternalDOcl.g:10064:2: ( ( 'Env' ) )
            {
            // InternalDOcl.g:10064:2: ( ( 'Env' ) )
            // InternalDOcl.g:10065:3: ( 'Env' )
            {
             before(grammarAccess.getEnvTypeAccess().getNameEnvKeyword_0()); 
            // InternalDOcl.g:10066:3: ( 'Env' )
            // InternalDOcl.g:10067:4: 'Env'
            {
             before(grammarAccess.getEnvTypeAccess().getNameEnvKeyword_0()); 
            match(input,94,FOLLOW_2); 
             after(grammarAccess.getEnvTypeAccess().getNameEnvKeyword_0()); 

            }

             after(grammarAccess.getEnvTypeAccess().getNameEnvKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnvType__NameAssignment"


    // $ANTLR start "rule__LambdaType__NameAssignment_0"
    // InternalDOcl.g:10078:1: rule__LambdaType__NameAssignment_0 : ( ( 'Lambda' ) ) ;
    public final void rule__LambdaType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10082:1: ( ( ( 'Lambda' ) ) )
            // InternalDOcl.g:10083:2: ( ( 'Lambda' ) )
            {
            // InternalDOcl.g:10083:2: ( ( 'Lambda' ) )
            // InternalDOcl.g:10084:3: ( 'Lambda' )
            {
             before(grammarAccess.getLambdaTypeAccess().getNameLambdaKeyword_0_0()); 
            // InternalDOcl.g:10085:3: ( 'Lambda' )
            // InternalDOcl.g:10086:4: 'Lambda'
            {
             before(grammarAccess.getLambdaTypeAccess().getNameLambdaKeyword_0_0()); 
            match(input,87,FOLLOW_2); 
             after(grammarAccess.getLambdaTypeAccess().getNameLambdaKeyword_0_0()); 

            }

             after(grammarAccess.getLambdaTypeAccess().getNameLambdaKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__NameAssignment_0"


    // $ANTLR start "rule__LambdaType__ArgsTypesAssignment_2"
    // InternalDOcl.g:10097:1: rule__LambdaType__ArgsTypesAssignment_2 : ( ruleOclType ) ;
    public final void rule__LambdaType__ArgsTypesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10101:1: ( ( ruleOclType ) )
            // InternalDOcl.g:10102:2: ( ruleOclType )
            {
            // InternalDOcl.g:10102:2: ( ruleOclType )
            // InternalDOcl.g:10103:3: ruleOclType
            {
             before(grammarAccess.getLambdaTypeAccess().getArgsTypesOclTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getLambdaTypeAccess().getArgsTypesOclTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__ArgsTypesAssignment_2"


    // $ANTLR start "rule__LambdaType__ArgsTypesAssignment_3_1"
    // InternalDOcl.g:10112:1: rule__LambdaType__ArgsTypesAssignment_3_1 : ( ruleOclType ) ;
    public final void rule__LambdaType__ArgsTypesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10116:1: ( ( ruleOclType ) )
            // InternalDOcl.g:10117:2: ( ruleOclType )
            {
            // InternalDOcl.g:10117:2: ( ruleOclType )
            // InternalDOcl.g:10118:3: ruleOclType
            {
             before(grammarAccess.getLambdaTypeAccess().getArgsTypesOclTypeParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getLambdaTypeAccess().getArgsTypesOclTypeParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__ArgsTypesAssignment_3_1"


    // $ANTLR start "rule__LambdaType__ReturnTypeAssignment_6"
    // InternalDOcl.g:10127:1: rule__LambdaType__ReturnTypeAssignment_6 : ( ruleOclType ) ;
    public final void rule__LambdaType__ReturnTypeAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10131:1: ( ( ruleOclType ) )
            // InternalDOcl.g:10132:2: ( ruleOclType )
            {
            // InternalDOcl.g:10132:2: ( ruleOclType )
            // InternalDOcl.g:10133:3: ruleOclType
            {
             before(grammarAccess.getLambdaTypeAccess().getReturnTypeOclTypeParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getLambdaTypeAccess().getReturnTypeOclTypeParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__LambdaType__ReturnTypeAssignment_6"


    // $ANTLR start "rule__MapType__NameAssignment_0"
    // InternalDOcl.g:10142:1: rule__MapType__NameAssignment_0 : ( ( 'Map' ) ) ;
    public final void rule__MapType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10146:1: ( ( ( 'Map' ) ) )
            // InternalDOcl.g:10147:2: ( ( 'Map' ) )
            {
            // InternalDOcl.g:10147:2: ( ( 'Map' ) )
            // InternalDOcl.g:10148:3: ( 'Map' )
            {
             before(grammarAccess.getMapTypeAccess().getNameMapKeyword_0_0()); 
            // InternalDOcl.g:10149:3: ( 'Map' )
            // InternalDOcl.g:10150:4: 'Map'
            {
             before(grammarAccess.getMapTypeAccess().getNameMapKeyword_0_0()); 
            match(input,95,FOLLOW_2); 
             after(grammarAccess.getMapTypeAccess().getNameMapKeyword_0_0()); 

            }

             after(grammarAccess.getMapTypeAccess().getNameMapKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__NameAssignment_0"


    // $ANTLR start "rule__MapType__KeyTypeAssignment_2"
    // InternalDOcl.g:10161:1: rule__MapType__KeyTypeAssignment_2 : ( ruleOclType ) ;
    public final void rule__MapType__KeyTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10165:1: ( ( ruleOclType ) )
            // InternalDOcl.g:10166:2: ( ruleOclType )
            {
            // InternalDOcl.g:10166:2: ( ruleOclType )
            // InternalDOcl.g:10167:3: ruleOclType
            {
             before(grammarAccess.getMapTypeAccess().getKeyTypeOclTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getMapTypeAccess().getKeyTypeOclTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__KeyTypeAssignment_2"


    // $ANTLR start "rule__MapType__ValueTypeAssignment_4"
    // InternalDOcl.g:10176:1: rule__MapType__ValueTypeAssignment_4 : ( ruleOclType ) ;
    public final void rule__MapType__ValueTypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10180:1: ( ( ruleOclType ) )
            // InternalDOcl.g:10181:2: ( ruleOclType )
            {
            // InternalDOcl.g:10181:2: ( ruleOclType )
            // InternalDOcl.g:10182:3: ruleOclType
            {
             before(grammarAccess.getMapTypeAccess().getValueTypeOclTypeParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getMapTypeAccess().getValueTypeOclTypeParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MapType__ValueTypeAssignment_4"


    // $ANTLR start "rule__OclAnyType__NameAssignment"
    // InternalDOcl.g:10191:1: rule__OclAnyType__NameAssignment : ( ( 'OclAny' ) ) ;
    public final void rule__OclAnyType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10195:1: ( ( ( 'OclAny' ) ) )
            // InternalDOcl.g:10196:2: ( ( 'OclAny' ) )
            {
            // InternalDOcl.g:10196:2: ( ( 'OclAny' ) )
            // InternalDOcl.g:10197:3: ( 'OclAny' )
            {
             before(grammarAccess.getOclAnyTypeAccess().getNameOclAnyKeyword_0()); 
            // InternalDOcl.g:10198:3: ( 'OclAny' )
            // InternalDOcl.g:10199:4: 'OclAny'
            {
             before(grammarAccess.getOclAnyTypeAccess().getNameOclAnyKeyword_0()); 
            match(input,96,FOLLOW_2); 
             after(grammarAccess.getOclAnyTypeAccess().getNameOclAnyKeyword_0()); 

            }

             after(grammarAccess.getOclAnyTypeAccess().getNameOclAnyKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OclAnyType__NameAssignment"


    // $ANTLR start "rule__SetType__NameAssignment_0"
    // InternalDOcl.g:10210:1: rule__SetType__NameAssignment_0 : ( ( 'Set' ) ) ;
    public final void rule__SetType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10214:1: ( ( ( 'Set' ) ) )
            // InternalDOcl.g:10215:2: ( ( 'Set' ) )
            {
            // InternalDOcl.g:10215:2: ( ( 'Set' ) )
            // InternalDOcl.g:10216:3: ( 'Set' )
            {
             before(grammarAccess.getSetTypeAccess().getNameSetKeyword_0_0()); 
            // InternalDOcl.g:10217:3: ( 'Set' )
            // InternalDOcl.g:10218:4: 'Set'
            {
             before(grammarAccess.getSetTypeAccess().getNameSetKeyword_0_0()); 
            match(input,97,FOLLOW_2); 
             after(grammarAccess.getSetTypeAccess().getNameSetKeyword_0_0()); 

            }

             after(grammarAccess.getSetTypeAccess().getNameSetKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__NameAssignment_0"


    // $ANTLR start "rule__SetType__ElementTypeAssignment_2"
    // InternalDOcl.g:10229:1: rule__SetType__ElementTypeAssignment_2 : ( ruleOclType ) ;
    public final void rule__SetType__ElementTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10233:1: ( ( ruleOclType ) )
            // InternalDOcl.g:10234:2: ( ruleOclType )
            {
            // InternalDOcl.g:10234:2: ( ruleOclType )
            // InternalDOcl.g:10235:3: ruleOclType
            {
             before(grammarAccess.getSetTypeAccess().getElementTypeOclTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getSetTypeAccess().getElementTypeOclTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SetType__ElementTypeAssignment_2"


    // $ANTLR start "rule__SequenceType__NameAssignment_0"
    // InternalDOcl.g:10244:1: rule__SequenceType__NameAssignment_0 : ( ( 'Sequence' ) ) ;
    public final void rule__SequenceType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10248:1: ( ( ( 'Sequence' ) ) )
            // InternalDOcl.g:10249:2: ( ( 'Sequence' ) )
            {
            // InternalDOcl.g:10249:2: ( ( 'Sequence' ) )
            // InternalDOcl.g:10250:3: ( 'Sequence' )
            {
             before(grammarAccess.getSequenceTypeAccess().getNameSequenceKeyword_0_0()); 
            // InternalDOcl.g:10251:3: ( 'Sequence' )
            // InternalDOcl.g:10252:4: 'Sequence'
            {
             before(grammarAccess.getSequenceTypeAccess().getNameSequenceKeyword_0_0()); 
            match(input,98,FOLLOW_2); 
             after(grammarAccess.getSequenceTypeAccess().getNameSequenceKeyword_0_0()); 

            }

             after(grammarAccess.getSequenceTypeAccess().getNameSequenceKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceType__NameAssignment_0"


    // $ANTLR start "rule__SequenceType__ElementTypeAssignment_2"
    // InternalDOcl.g:10263:1: rule__SequenceType__ElementTypeAssignment_2 : ( ruleOclType ) ;
    public final void rule__SequenceType__ElementTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10267:1: ( ( ruleOclType ) )
            // InternalDOcl.g:10268:2: ( ruleOclType )
            {
            // InternalDOcl.g:10268:2: ( ruleOclType )
            // InternalDOcl.g:10269:3: ruleOclType
            {
             before(grammarAccess.getSequenceTypeAccess().getElementTypeOclTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getSequenceTypeAccess().getElementTypeOclTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SequenceType__ElementTypeAssignment_2"


    // $ANTLR start "rule__OrderedSetType__NameAssignment_0"
    // InternalDOcl.g:10278:1: rule__OrderedSetType__NameAssignment_0 : ( ( 'OrderedSet' ) ) ;
    public final void rule__OrderedSetType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10282:1: ( ( ( 'OrderedSet' ) ) )
            // InternalDOcl.g:10283:2: ( ( 'OrderedSet' ) )
            {
            // InternalDOcl.g:10283:2: ( ( 'OrderedSet' ) )
            // InternalDOcl.g:10284:3: ( 'OrderedSet' )
            {
             before(grammarAccess.getOrderedSetTypeAccess().getNameOrderedSetKeyword_0_0()); 
            // InternalDOcl.g:10285:3: ( 'OrderedSet' )
            // InternalDOcl.g:10286:4: 'OrderedSet'
            {
             before(grammarAccess.getOrderedSetTypeAccess().getNameOrderedSetKeyword_0_0()); 
            match(input,99,FOLLOW_2); 
             after(grammarAccess.getOrderedSetTypeAccess().getNameOrderedSetKeyword_0_0()); 

            }

             after(grammarAccess.getOrderedSetTypeAccess().getNameOrderedSetKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderedSetType__NameAssignment_0"


    // $ANTLR start "rule__OrderedSetType__ElementTypeAssignment_2"
    // InternalDOcl.g:10297:1: rule__OrderedSetType__ElementTypeAssignment_2 : ( ruleOclType ) ;
    public final void rule__OrderedSetType__ElementTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10301:1: ( ( ruleOclType ) )
            // InternalDOcl.g:10302:2: ( ruleOclType )
            {
            // InternalDOcl.g:10302:2: ( ruleOclType )
            // InternalDOcl.g:10303:3: ruleOclType
            {
             before(grammarAccess.getOrderedSetTypeAccess().getElementTypeOclTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getOrderedSetTypeAccess().getElementTypeOclTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__OrderedSetType__ElementTypeAssignment_2"


    // $ANTLR start "rule__BagType__NameAssignment_0"
    // InternalDOcl.g:10312:1: rule__BagType__NameAssignment_0 : ( ( 'BagType' ) ) ;
    public final void rule__BagType__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10316:1: ( ( ( 'BagType' ) ) )
            // InternalDOcl.g:10317:2: ( ( 'BagType' ) )
            {
            // InternalDOcl.g:10317:2: ( ( 'BagType' ) )
            // InternalDOcl.g:10318:3: ( 'BagType' )
            {
             before(grammarAccess.getBagTypeAccess().getNameBagTypeKeyword_0_0()); 
            // InternalDOcl.g:10319:3: ( 'BagType' )
            // InternalDOcl.g:10320:4: 'BagType'
            {
             before(grammarAccess.getBagTypeAccess().getNameBagTypeKeyword_0_0()); 
            match(input,100,FOLLOW_2); 
             after(grammarAccess.getBagTypeAccess().getNameBagTypeKeyword_0_0()); 

            }

             after(grammarAccess.getBagTypeAccess().getNameBagTypeKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__NameAssignment_0"


    // $ANTLR start "rule__BagType__ElementTypeAssignment_2"
    // InternalDOcl.g:10331:1: rule__BagType__ElementTypeAssignment_2 : ( ruleOclType ) ;
    public final void rule__BagType__ElementTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10335:1: ( ( ruleOclType ) )
            // InternalDOcl.g:10336:2: ( ruleOclType )
            {
            // InternalDOcl.g:10336:2: ( ruleOclType )
            // InternalDOcl.g:10337:3: ruleOclType
            {
             before(grammarAccess.getBagTypeAccess().getElementTypeOclTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleOclType();

            state._fsp--;

             after(grammarAccess.getBagTypeAccess().getElementTypeOclTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BagType__ElementTypeAssignment_2"


    // $ANTLR start "rule__RealType__NameAssignment"
    // InternalDOcl.g:10346:1: rule__RealType__NameAssignment : ( ( 'Real' ) ) ;
    public final void rule__RealType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10350:1: ( ( ( 'Real' ) ) )
            // InternalDOcl.g:10351:2: ( ( 'Real' ) )
            {
            // InternalDOcl.g:10351:2: ( ( 'Real' ) )
            // InternalDOcl.g:10352:3: ( 'Real' )
            {
             before(grammarAccess.getRealTypeAccess().getNameRealKeyword_0()); 
            // InternalDOcl.g:10353:3: ( 'Real' )
            // InternalDOcl.g:10354:4: 'Real'
            {
             before(grammarAccess.getRealTypeAccess().getNameRealKeyword_0()); 
            match(input,101,FOLLOW_2); 
             after(grammarAccess.getRealTypeAccess().getNameRealKeyword_0()); 

            }

             after(grammarAccess.getRealTypeAccess().getNameRealKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RealType__NameAssignment"


    // $ANTLR start "rule__IntegerType__NameAssignment"
    // InternalDOcl.g:10365:1: rule__IntegerType__NameAssignment : ( ( 'Integer' ) ) ;
    public final void rule__IntegerType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10369:1: ( ( ( 'Integer' ) ) )
            // InternalDOcl.g:10370:2: ( ( 'Integer' ) )
            {
            // InternalDOcl.g:10370:2: ( ( 'Integer' ) )
            // InternalDOcl.g:10371:3: ( 'Integer' )
            {
             before(grammarAccess.getIntegerTypeAccess().getNameIntegerKeyword_0()); 
            // InternalDOcl.g:10372:3: ( 'Integer' )
            // InternalDOcl.g:10373:4: 'Integer'
            {
             before(grammarAccess.getIntegerTypeAccess().getNameIntegerKeyword_0()); 
            match(input,102,FOLLOW_2); 
             after(grammarAccess.getIntegerTypeAccess().getNameIntegerKeyword_0()); 

            }

             after(grammarAccess.getIntegerTypeAccess().getNameIntegerKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerType__NameAssignment"


    // $ANTLR start "rule__BooleanType__NameAssignment"
    // InternalDOcl.g:10384:1: rule__BooleanType__NameAssignment : ( ( 'Boolean' ) ) ;
    public final void rule__BooleanType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10388:1: ( ( ( 'Boolean' ) ) )
            // InternalDOcl.g:10389:2: ( ( 'Boolean' ) )
            {
            // InternalDOcl.g:10389:2: ( ( 'Boolean' ) )
            // InternalDOcl.g:10390:3: ( 'Boolean' )
            {
             before(grammarAccess.getBooleanTypeAccess().getNameBooleanKeyword_0()); 
            // InternalDOcl.g:10391:3: ( 'Boolean' )
            // InternalDOcl.g:10392:4: 'Boolean'
            {
             before(grammarAccess.getBooleanTypeAccess().getNameBooleanKeyword_0()); 
            match(input,103,FOLLOW_2); 
             after(grammarAccess.getBooleanTypeAccess().getNameBooleanKeyword_0()); 

            }

             after(grammarAccess.getBooleanTypeAccess().getNameBooleanKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanType__NameAssignment"


    // $ANTLR start "rule__StringType__NameAssignment"
    // InternalDOcl.g:10403:1: rule__StringType__NameAssignment : ( ( 'String' ) ) ;
    public final void rule__StringType__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalDOcl.g:10407:1: ( ( ( 'String' ) ) )
            // InternalDOcl.g:10408:2: ( ( 'String' ) )
            {
            // InternalDOcl.g:10408:2: ( ( 'String' ) )
            // InternalDOcl.g:10409:3: ( 'String' )
            {
             before(grammarAccess.getStringTypeAccess().getNameStringKeyword_0()); 
            // InternalDOcl.g:10410:3: ( 'String' )
            // InternalDOcl.g:10411:4: 'String'
            {
             before(grammarAccess.getStringTypeAccess().getNameStringKeyword_0()); 
            match(input,104,FOLLOW_2); 
             after(grammarAccess.getStringTypeAccess().getNameStringKeyword_0()); 

            }

             after(grammarAccess.getStringTypeAccess().getNameStringKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringType__NameAssignment"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000008L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x101FFFFFFFE600B0L,0x000000002FB18100L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x101FFFFFFFE000B0L,0x000000002FA18100L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0060000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0060000000000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0780000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0780000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0800000000020000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0800000000020002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x3000000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x3000000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x00001FFFFFE00000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x101FFFFFFFE600B0L,0x000000002FB18300L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x0000000000200000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000440L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000010010L,0x000001FFC0800000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x001FE00000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000C00L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000080000L,0x0000000000001000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000000L,0x0000000000800000L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004400L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x10000000000000A0L,0x0000000006018000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000000L,0x0000000010040000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000000010000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000020000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000600L});

}