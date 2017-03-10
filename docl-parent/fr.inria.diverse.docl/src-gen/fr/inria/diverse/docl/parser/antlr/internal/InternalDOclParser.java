package fr.inria.diverse.docl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import fr.inria.diverse.docl.services.DOclGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDOclParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_SCHEME", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'module'", "'@@source'", "'@@input'", "'uri='", "'://'", "'/'", "'.'", "':'", "'imports'", "'query'", "';'", "'-'", "'not'", "'and'", "'or'", "'xor'", "'implies'", "'->'", "'size'", "'includes'", "'excludes'", "'count'", "'includesAll'", "'excludesAll'", "'isEmpty'", "'notEmpty'", "'sum'", "'asBag'", "'asSet'", "'asSequence'", "'union'", "'flatten'", "'append'", "'prepend'", "'insertAt'", "'subSequence'", "'at'", "'indexOf'", "'first'", "'last'", "'including'", "'excluding'", "'exists'", "'forAll'", "'isUnique'", "'any'", "'one'", "'collect'", "'select'", "'reject'", "'let'", "'in'", "'<>'", "'='", "'>'", "'<'", "'>='", "'<='", "'+'", "'*'", "'('", "','", "')'", "'iterate'", "'|'", "'::'", "'allInstances'", "'Lambda'", "'{'", "'}'", "'Tuple'", "'true'", "'false'", "'invalid'", "'null'", "'if'", "'then'", "'else'", "'endif'", "'elseif'", "'self'", "'Env'", "'Map'", "'TupleType'", "'OclAny'", "'Set'", "'Sequence'", "'OrderedSet'", "'BagType'", "'Real'", "'Integer'", "'Boolean'", "'String'"
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
    public static final int RULE_INT=6;
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
    public static final int RULE_SCHEME=5;
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

        public InternalDOclParser(TokenStream input, DOclGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Module";
       	}

       	@Override
       	protected DOclGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModule"
    // InternalDOcl.g:64:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // InternalDOcl.g:64:47: (iv_ruleModule= ruleModule EOF )
            // InternalDOcl.g:65:2: iv_ruleModule= ruleModule EOF
            {
             newCompositeNode(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // InternalDOcl.g:71:1: ruleModule returns [EObject current=null] : ( () otherlv_1= 'module' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '@@source' ( (lv_source_4_0= ruleOclModel ) ) otherlv_5= '@@input' ( (lv_input_6_0= ruleOclModel ) ) ( ( (lv_imports_7_0= ruleImport ) ) ( (lv_imports_8_0= ruleImport ) )* )? ( ( (lv_elements_9_0= ruleModuleElement ) ) ( (lv_elements_10_0= ruleModuleElement ) )* )? ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_source_4_0 = null;

        EObject lv_input_6_0 = null;

        EObject lv_imports_7_0 = null;

        EObject lv_imports_8_0 = null;

        EObject lv_elements_9_0 = null;

        EObject lv_elements_10_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:77:2: ( ( () otherlv_1= 'module' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '@@source' ( (lv_source_4_0= ruleOclModel ) ) otherlv_5= '@@input' ( (lv_input_6_0= ruleOclModel ) ) ( ( (lv_imports_7_0= ruleImport ) ) ( (lv_imports_8_0= ruleImport ) )* )? ( ( (lv_elements_9_0= ruleModuleElement ) ) ( (lv_elements_10_0= ruleModuleElement ) )* )? ) )
            // InternalDOcl.g:78:2: ( () otherlv_1= 'module' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '@@source' ( (lv_source_4_0= ruleOclModel ) ) otherlv_5= '@@input' ( (lv_input_6_0= ruleOclModel ) ) ( ( (lv_imports_7_0= ruleImport ) ) ( (lv_imports_8_0= ruleImport ) )* )? ( ( (lv_elements_9_0= ruleModuleElement ) ) ( (lv_elements_10_0= ruleModuleElement ) )* )? )
            {
            // InternalDOcl.g:78:2: ( () otherlv_1= 'module' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '@@source' ( (lv_source_4_0= ruleOclModel ) ) otherlv_5= '@@input' ( (lv_input_6_0= ruleOclModel ) ) ( ( (lv_imports_7_0= ruleImport ) ) ( (lv_imports_8_0= ruleImport ) )* )? ( ( (lv_elements_9_0= ruleModuleElement ) ) ( (lv_elements_10_0= ruleModuleElement ) )* )? )
            // InternalDOcl.g:79:3: () otherlv_1= 'module' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '@@source' ( (lv_source_4_0= ruleOclModel ) ) otherlv_5= '@@input' ( (lv_input_6_0= ruleOclModel ) ) ( ( (lv_imports_7_0= ruleImport ) ) ( (lv_imports_8_0= ruleImport ) )* )? ( ( (lv_elements_9_0= ruleModuleElement ) ) ( (lv_elements_10_0= ruleModuleElement ) )* )?
            {
            // InternalDOcl.g:79:3: ()
            // InternalDOcl.g:80:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getModuleAccess().getModuleAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,12,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getModuleAccess().getModuleKeyword_1());
            		
            // InternalDOcl.g:90:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalDOcl.g:91:4: (lv_name_2_0= RULE_ID )
            {
            // InternalDOcl.g:91:4: (lv_name_2_0= RULE_ID )
            // InternalDOcl.g:92:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_2_0, grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getSourceKeyword_3());
            		
            // InternalDOcl.g:112:3: ( (lv_source_4_0= ruleOclModel ) )
            // InternalDOcl.g:113:4: (lv_source_4_0= ruleOclModel )
            {
            // InternalDOcl.g:113:4: (lv_source_4_0= ruleOclModel )
            // InternalDOcl.g:114:5: lv_source_4_0= ruleOclModel
            {

            					newCompositeNode(grammarAccess.getModuleAccess().getSourceOclModelParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_5);
            lv_source_4_0=ruleOclModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModuleRule());
            					}
            					set(
            						current,
            						"source",
            						lv_source_4_0,
            						"fr.inria.diverse.docl.DOcl.OclModel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_5, grammarAccess.getModuleAccess().getInputKeyword_5());
            		
            // InternalDOcl.g:135:3: ( (lv_input_6_0= ruleOclModel ) )
            // InternalDOcl.g:136:4: (lv_input_6_0= ruleOclModel )
            {
            // InternalDOcl.g:136:4: (lv_input_6_0= ruleOclModel )
            // InternalDOcl.g:137:5: lv_input_6_0= ruleOclModel
            {

            					newCompositeNode(grammarAccess.getModuleAccess().getInputOclModelParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_6);
            lv_input_6_0=ruleOclModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getModuleRule());
            					}
            					set(
            						current,
            						"input",
            						lv_input_6_0,
            						"fr.inria.diverse.docl.DOcl.OclModel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDOcl.g:154:3: ( ( (lv_imports_7_0= ruleImport ) ) ( (lv_imports_8_0= ruleImport ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==20) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalDOcl.g:155:4: ( (lv_imports_7_0= ruleImport ) ) ( (lv_imports_8_0= ruleImport ) )*
                    {
                    // InternalDOcl.g:155:4: ( (lv_imports_7_0= ruleImport ) )
                    // InternalDOcl.g:156:5: (lv_imports_7_0= ruleImport )
                    {
                    // InternalDOcl.g:156:5: (lv_imports_7_0= ruleImport )
                    // InternalDOcl.g:157:6: lv_imports_7_0= ruleImport
                    {

                    						newCompositeNode(grammarAccess.getModuleAccess().getImportsImportParserRuleCall_7_0_0());
                    					
                    pushFollow(FOLLOW_6);
                    lv_imports_7_0=ruleImport();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModuleRule());
                    						}
                    						add(
                    							current,
                    							"imports",
                    							lv_imports_7_0,
                    							"fr.inria.diverse.docl.DOcl.Import");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalDOcl.g:174:4: ( (lv_imports_8_0= ruleImport ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==20) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalDOcl.g:175:5: (lv_imports_8_0= ruleImport )
                    	    {
                    	    // InternalDOcl.g:175:5: (lv_imports_8_0= ruleImport )
                    	    // InternalDOcl.g:176:6: lv_imports_8_0= ruleImport
                    	    {

                    	    						newCompositeNode(grammarAccess.getModuleAccess().getImportsImportParserRuleCall_7_1_0());
                    	    					
                    	    pushFollow(FOLLOW_6);
                    	    lv_imports_8_0=ruleImport();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getModuleRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"imports",
                    	    							lv_imports_8_0,
                    	    							"fr.inria.diverse.docl.DOcl.Import");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalDOcl.g:194:3: ( ( (lv_elements_9_0= ruleModuleElement ) ) ( (lv_elements_10_0= ruleModuleElement ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalDOcl.g:195:4: ( (lv_elements_9_0= ruleModuleElement ) ) ( (lv_elements_10_0= ruleModuleElement ) )*
                    {
                    // InternalDOcl.g:195:4: ( (lv_elements_9_0= ruleModuleElement ) )
                    // InternalDOcl.g:196:5: (lv_elements_9_0= ruleModuleElement )
                    {
                    // InternalDOcl.g:196:5: (lv_elements_9_0= ruleModuleElement )
                    // InternalDOcl.g:197:6: lv_elements_9_0= ruleModuleElement
                    {

                    						newCompositeNode(grammarAccess.getModuleAccess().getElementsModuleElementParserRuleCall_8_0_0());
                    					
                    pushFollow(FOLLOW_7);
                    lv_elements_9_0=ruleModuleElement();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModuleRule());
                    						}
                    						add(
                    							current,
                    							"elements",
                    							lv_elements_9_0,
                    							"fr.inria.diverse.docl.DOcl.ModuleElement");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalDOcl.g:214:4: ( (lv_elements_10_0= ruleModuleElement ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==21) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalDOcl.g:215:5: (lv_elements_10_0= ruleModuleElement )
                    	    {
                    	    // InternalDOcl.g:215:5: (lv_elements_10_0= ruleModuleElement )
                    	    // InternalDOcl.g:216:6: lv_elements_10_0= ruleModuleElement
                    	    {

                    	    						newCompositeNode(grammarAccess.getModuleAccess().getElementsModuleElementParserRuleCall_8_1_0());
                    	    					
                    	    pushFollow(FOLLOW_7);
                    	    lv_elements_10_0=ruleModuleElement();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getModuleRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"elements",
                    	    							lv_elements_10_0,
                    	    							"fr.inria.diverse.docl.DOcl.ModuleElement");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleOclModel"
    // InternalDOcl.g:238:1: entryRuleOclModel returns [EObject current=null] : iv_ruleOclModel= ruleOclModel EOF ;
    public final EObject entryRuleOclModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclModel = null;


        try {
            // InternalDOcl.g:238:49: (iv_ruleOclModel= ruleOclModel EOF )
            // InternalDOcl.g:239:2: iv_ruleOclModel= ruleOclModel EOF
            {
             newCompositeNode(grammarAccess.getOclModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOclModel=ruleOclModel();

            state._fsp--;

             current =iv_ruleOclModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOclModel"


    // $ANTLR start "ruleOclModel"
    // InternalDOcl.g:245:1: ruleOclModel returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI_ ) )? ) ;
    public final EObject ruleOclModel() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        EObject lv_uri_1_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:251:2: ( ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI_ ) )? ) )
            // InternalDOcl.g:252:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI_ ) )? )
            {
            // InternalDOcl.g:252:2: ( ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI_ ) )? )
            // InternalDOcl.g:253:3: ( (lv_name_0_0= RULE_ID ) ) ( (lv_uri_1_0= ruleURI_ ) )?
            {
            // InternalDOcl.g:253:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDOcl.g:254:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDOcl.g:254:4: (lv_name_0_0= RULE_ID )
            // InternalDOcl.g:255:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_8); 

            					newLeafNode(lv_name_0_0, grammarAccess.getOclModelAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOclModelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDOcl.g:271:3: ( (lv_uri_1_0= ruleURI_ ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalDOcl.g:272:4: (lv_uri_1_0= ruleURI_ )
                    {
                    // InternalDOcl.g:272:4: (lv_uri_1_0= ruleURI_ )
                    // InternalDOcl.g:273:5: lv_uri_1_0= ruleURI_
                    {

                    					newCompositeNode(grammarAccess.getOclModelAccess().getUriURI_ParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_uri_1_0=ruleURI_();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOclModelRule());
                    					}
                    					set(
                    						current,
                    						"uri",
                    						lv_uri_1_0,
                    						"fr.inria.diverse.docl.DOcl.URI_");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOclModel"


    // $ANTLR start "entryRuleURI_"
    // InternalDOcl.g:294:1: entryRuleURI_ returns [EObject current=null] : iv_ruleURI_= ruleURI_ EOF ;
    public final EObject entryRuleURI_() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURI_ = null;


        try {
            // InternalDOcl.g:294:45: (iv_ruleURI_= ruleURI_ EOF )
            // InternalDOcl.g:295:2: iv_ruleURI_= ruleURI_ EOF
            {
             newCompositeNode(grammarAccess.getURI_Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleURI_=ruleURI_();

            state._fsp--;

             current =iv_ruleURI_; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURI_"


    // $ANTLR start "ruleURI_"
    // InternalDOcl.g:301:1: ruleURI_ returns [EObject current=null] : (otherlv_0= 'uri=' ( (lv_scheme_1_0= RULE_SCHEME ) ) otherlv_2= '://' ( (lv_authority_3_0= ruleAUTHORITY ) ) otherlv_4= '/' ( (lv_fragment__5_0= ruleFRAGMENT ) ) ) ;
    public final EObject ruleURI_() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_scheme_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_authority_3_0 = null;

        AntlrDatatypeRuleToken lv_fragment__5_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:307:2: ( (otherlv_0= 'uri=' ( (lv_scheme_1_0= RULE_SCHEME ) ) otherlv_2= '://' ( (lv_authority_3_0= ruleAUTHORITY ) ) otherlv_4= '/' ( (lv_fragment__5_0= ruleFRAGMENT ) ) ) )
            // InternalDOcl.g:308:2: (otherlv_0= 'uri=' ( (lv_scheme_1_0= RULE_SCHEME ) ) otherlv_2= '://' ( (lv_authority_3_0= ruleAUTHORITY ) ) otherlv_4= '/' ( (lv_fragment__5_0= ruleFRAGMENT ) ) )
            {
            // InternalDOcl.g:308:2: (otherlv_0= 'uri=' ( (lv_scheme_1_0= RULE_SCHEME ) ) otherlv_2= '://' ( (lv_authority_3_0= ruleAUTHORITY ) ) otherlv_4= '/' ( (lv_fragment__5_0= ruleFRAGMENT ) ) )
            // InternalDOcl.g:309:3: otherlv_0= 'uri=' ( (lv_scheme_1_0= RULE_SCHEME ) ) otherlv_2= '://' ( (lv_authority_3_0= ruleAUTHORITY ) ) otherlv_4= '/' ( (lv_fragment__5_0= ruleFRAGMENT ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_9); 

            			newLeafNode(otherlv_0, grammarAccess.getURI_Access().getUriKeyword_0());
            		
            // InternalDOcl.g:313:3: ( (lv_scheme_1_0= RULE_SCHEME ) )
            // InternalDOcl.g:314:4: (lv_scheme_1_0= RULE_SCHEME )
            {
            // InternalDOcl.g:314:4: (lv_scheme_1_0= RULE_SCHEME )
            // InternalDOcl.g:315:5: lv_scheme_1_0= RULE_SCHEME
            {
            lv_scheme_1_0=(Token)match(input,RULE_SCHEME,FOLLOW_10); 

            					newLeafNode(lv_scheme_1_0, grammarAccess.getURI_Access().getSchemeSCHEMETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getURI_Rule());
            					}
            					setWithLastConsumed(
            						current,
            						"scheme",
            						lv_scheme_1_0,
            						"fr.inria.diverse.docl.DOcl.SCHEME");
            				

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getURI_Access().getColonSolidusSolidusKeyword_2());
            		
            // InternalDOcl.g:335:3: ( (lv_authority_3_0= ruleAUTHORITY ) )
            // InternalDOcl.g:336:4: (lv_authority_3_0= ruleAUTHORITY )
            {
            // InternalDOcl.g:336:4: (lv_authority_3_0= ruleAUTHORITY )
            // InternalDOcl.g:337:5: lv_authority_3_0= ruleAUTHORITY
            {

            					newCompositeNode(grammarAccess.getURI_Access().getAuthorityAUTHORITYParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_11);
            lv_authority_3_0=ruleAUTHORITY();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getURI_Rule());
            					}
            					set(
            						current,
            						"authority",
            						lv_authority_3_0,
            						"fr.inria.diverse.docl.DOcl.AUTHORITY");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_3); 

            			newLeafNode(otherlv_4, grammarAccess.getURI_Access().getSolidusKeyword_4());
            		
            // InternalDOcl.g:358:3: ( (lv_fragment__5_0= ruleFRAGMENT ) )
            // InternalDOcl.g:359:4: (lv_fragment__5_0= ruleFRAGMENT )
            {
            // InternalDOcl.g:359:4: (lv_fragment__5_0= ruleFRAGMENT )
            // InternalDOcl.g:360:5: lv_fragment__5_0= ruleFRAGMENT
            {

            					newCompositeNode(grammarAccess.getURI_Access().getFragment_FRAGMENTParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_2);
            lv_fragment__5_0=ruleFRAGMENT();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getURI_Rule());
            					}
            					set(
            						current,
            						"fragment_",
            						lv_fragment__5_0,
            						"fr.inria.diverse.docl.DOcl.FRAGMENT");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURI_"


    // $ANTLR start "entryRuleFRAGMENT"
    // InternalDOcl.g:381:1: entryRuleFRAGMENT returns [String current=null] : iv_ruleFRAGMENT= ruleFRAGMENT EOF ;
    public final String entryRuleFRAGMENT() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFRAGMENT = null;


        try {
            // InternalDOcl.g:381:48: (iv_ruleFRAGMENT= ruleFRAGMENT EOF )
            // InternalDOcl.g:382:2: iv_ruleFRAGMENT= ruleFRAGMENT EOF
            {
             newCompositeNode(grammarAccess.getFRAGMENTRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFRAGMENT=ruleFRAGMENT();

            state._fsp--;

             current =iv_ruleFRAGMENT.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFRAGMENT"


    // $ANTLR start "ruleFRAGMENT"
    // InternalDOcl.g:388:1: ruleFRAGMENT returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '/' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleFRAGMENT() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalDOcl.g:394:2: ( (this_ID_0= RULE_ID (kw= '/' this_ID_2= RULE_ID )* ) )
            // InternalDOcl.g:395:2: (this_ID_0= RULE_ID (kw= '/' this_ID_2= RULE_ID )* )
            {
            // InternalDOcl.g:395:2: (this_ID_0= RULE_ID (kw= '/' this_ID_2= RULE_ID )* )
            // InternalDOcl.g:396:3: this_ID_0= RULE_ID (kw= '/' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_12); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getFRAGMENTAccess().getIDTerminalRuleCall_0());
            		
            // InternalDOcl.g:403:3: (kw= '/' this_ID_2= RULE_ID )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalDOcl.g:404:4: kw= '/' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,17,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getFRAGMENTAccess().getSolidusKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_12); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getFRAGMENTAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFRAGMENT"


    // $ANTLR start "entryRuleAUTHORITY"
    // InternalDOcl.g:421:1: entryRuleAUTHORITY returns [String current=null] : iv_ruleAUTHORITY= ruleAUTHORITY EOF ;
    public final String entryRuleAUTHORITY() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAUTHORITY = null;


        try {
            // InternalDOcl.g:421:49: (iv_ruleAUTHORITY= ruleAUTHORITY EOF )
            // InternalDOcl.g:422:2: iv_ruleAUTHORITY= ruleAUTHORITY EOF
            {
             newCompositeNode(grammarAccess.getAUTHORITYRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAUTHORITY=ruleAUTHORITY();

            state._fsp--;

             current =iv_ruleAUTHORITY.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAUTHORITY"


    // $ANTLR start "ruleAUTHORITY"
    // InternalDOcl.g:428:1: ruleAUTHORITY returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= ':' this_INT_4= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleAUTHORITY() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_INT_4=null;


        	enterRule();

        try {
            // InternalDOcl.g:434:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= ':' this_INT_4= RULE_INT )? ) )
            // InternalDOcl.g:435:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= ':' this_INT_4= RULE_INT )? )
            {
            // InternalDOcl.g:435:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= ':' this_INT_4= RULE_INT )? )
            // InternalDOcl.g:436:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* (kw= ':' this_INT_4= RULE_INT )?
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_13); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getAUTHORITYAccess().getIDTerminalRuleCall_0());
            		
            // InternalDOcl.g:443:3: (kw= '.' this_ID_2= RULE_ID )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==18) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalDOcl.g:444:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,18,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getAUTHORITYAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_13); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getAUTHORITYAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // InternalDOcl.g:457:3: (kw= ':' this_INT_4= RULE_INT )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalDOcl.g:458:4: kw= ':' this_INT_4= RULE_INT
                    {
                    kw=(Token)match(input,19,FOLLOW_14); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getAUTHORITYAccess().getColonKeyword_2_0());
                    			
                    this_INT_4=(Token)match(input,RULE_INT,FOLLOW_2); 

                    				current.merge(this_INT_4);
                    			

                    				newLeafNode(this_INT_4, grammarAccess.getAUTHORITYAccess().getINTTerminalRuleCall_2_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAUTHORITY"


    // $ANTLR start "entryRuleImport"
    // InternalDOcl.g:475:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalDOcl.g:475:47: (iv_ruleImport= ruleImport EOF )
            // InternalDOcl.g:476:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalDOcl.g:482:1: ruleImport returns [EObject current=null] : ( () otherlv_1= 'imports' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:488:2: ( ( () otherlv_1= 'imports' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalDOcl.g:489:2: ( () otherlv_1= 'imports' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalDOcl.g:489:2: ( () otherlv_1= 'imports' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalDOcl.g:490:3: () otherlv_1= 'imports' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalDOcl.g:490:3: ()
            // InternalDOcl.g:491:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getImportAccess().getImportAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getImportAccess().getImportsKeyword_1());
            		
            // InternalDOcl.g:501:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalDOcl.g:502:4: (lv_name_2_0= RULE_ID )
            {
            // InternalDOcl.g:502:4: (lv_name_2_0= RULE_ID )
            // InternalDOcl.g:503:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getImportAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getImportRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleModuleElement"
    // InternalDOcl.g:523:1: entryRuleModuleElement returns [EObject current=null] : iv_ruleModuleElement= ruleModuleElement EOF ;
    public final EObject entryRuleModuleElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleElement = null;


        try {
            // InternalDOcl.g:523:54: (iv_ruleModuleElement= ruleModuleElement EOF )
            // InternalDOcl.g:524:2: iv_ruleModuleElement= ruleModuleElement EOF
            {
             newCompositeNode(grammarAccess.getModuleElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModuleElement=ruleModuleElement();

            state._fsp--;

             current =iv_ruleModuleElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModuleElement"


    // $ANTLR start "ruleModuleElement"
    // InternalDOcl.g:530:1: ruleModuleElement returns [EObject current=null] : this_Query_0= ruleQuery ;
    public final EObject ruleModuleElement() throws RecognitionException {
        EObject current = null;

        EObject this_Query_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:536:2: (this_Query_0= ruleQuery )
            // InternalDOcl.g:537:2: this_Query_0= ruleQuery
            {

            		newCompositeNode(grammarAccess.getModuleElementAccess().getQueryParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Query_0=ruleQuery();

            state._fsp--;


            		current = this_Query_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModuleElement"


    // $ANTLR start "entryRuleQuery"
    // InternalDOcl.g:548:1: entryRuleQuery returns [EObject current=null] : iv_ruleQuery= ruleQuery EOF ;
    public final EObject entryRuleQuery() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQuery = null;


        try {
            // InternalDOcl.g:548:46: (iv_ruleQuery= ruleQuery EOF )
            // InternalDOcl.g:549:2: iv_ruleQuery= ruleQuery EOF
            {
             newCompositeNode(grammarAccess.getQueryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuery=ruleQuery();

            state._fsp--;

             current =iv_ruleQuery; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuery"


    // $ANTLR start "ruleQuery"
    // InternalDOcl.g:555:1: ruleQuery returns [EObject current=null] : ( () otherlv_1= 'query' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_body_4_0= ruleOclExpression ) ) otherlv_5= ';' ) ;
    public final EObject ruleQuery() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_body_4_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:561:2: ( ( () otherlv_1= 'query' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_body_4_0= ruleOclExpression ) ) otherlv_5= ';' ) )
            // InternalDOcl.g:562:2: ( () otherlv_1= 'query' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_body_4_0= ruleOclExpression ) ) otherlv_5= ';' )
            {
            // InternalDOcl.g:562:2: ( () otherlv_1= 'query' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_body_4_0= ruleOclExpression ) ) otherlv_5= ';' )
            // InternalDOcl.g:563:3: () otherlv_1= 'query' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_body_4_0= ruleOclExpression ) ) otherlv_5= ';'
            {
            // InternalDOcl.g:563:3: ()
            // InternalDOcl.g:564:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getQueryAccess().getQueryAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getQueryAccess().getQueryKeyword_1());
            		
            // InternalDOcl.g:574:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalDOcl.g:575:4: (lv_name_2_0= RULE_ID )
            {
            // InternalDOcl.g:575:4: (lv_name_2_0= RULE_ID )
            // InternalDOcl.g:576:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_name_2_0, grammarAccess.getQueryAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQueryRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getQueryAccess().getColonKeyword_3());
            		
            // InternalDOcl.g:596:3: ( (lv_body_4_0= ruleOclExpression ) )
            // InternalDOcl.g:597:4: (lv_body_4_0= ruleOclExpression )
            {
            // InternalDOcl.g:597:4: (lv_body_4_0= ruleOclExpression )
            // InternalDOcl.g:598:5: lv_body_4_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getQueryAccess().getBodyOclExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_17);
            lv_body_4_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQueryRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_4_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getQueryAccess().getSemicolonKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuery"


    // $ANTLR start "entryRuleUnaryOperator"
    // InternalDOcl.g:623:1: entryRuleUnaryOperator returns [String current=null] : iv_ruleUnaryOperator= ruleUnaryOperator EOF ;
    public final String entryRuleUnaryOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOperator = null;


        try {
            // InternalDOcl.g:623:53: (iv_ruleUnaryOperator= ruleUnaryOperator EOF )
            // InternalDOcl.g:624:2: iv_ruleUnaryOperator= ruleUnaryOperator EOF
            {
             newCompositeNode(grammarAccess.getUnaryOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryOperator=ruleUnaryOperator();

            state._fsp--;

             current =iv_ruleUnaryOperator.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOperator"


    // $ANTLR start "ruleUnaryOperator"
    // InternalDOcl.g:630:1: ruleUnaryOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '-' | kw= 'not' ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDOcl.g:636:2: ( (kw= '-' | kw= 'not' ) )
            // InternalDOcl.g:637:2: (kw= '-' | kw= 'not' )
            {
            // InternalDOcl.g:637:2: (kw= '-' | kw= 'not' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==23) ) {
                alt9=1;
            }
            else if ( (LA9_0==24) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalDOcl.g:638:3: kw= '-'
                    {
                    kw=(Token)match(input,23,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getHyphenMinusKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalDOcl.g:644:3: kw= 'not'
                    {
                    kw=(Token)match(input,24,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getUnaryOperatorAccess().getNotKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOperator"


    // $ANTLR start "entryRuleAndOperator"
    // InternalDOcl.g:653:1: entryRuleAndOperator returns [String current=null] : iv_ruleAndOperator= ruleAndOperator EOF ;
    public final String entryRuleAndOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAndOperator = null;


        try {
            // InternalDOcl.g:653:51: (iv_ruleAndOperator= ruleAndOperator EOF )
            // InternalDOcl.g:654:2: iv_ruleAndOperator= ruleAndOperator EOF
            {
             newCompositeNode(grammarAccess.getAndOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndOperator=ruleAndOperator();

            state._fsp--;

             current =iv_ruleAndOperator.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndOperator"


    // $ANTLR start "ruleAndOperator"
    // InternalDOcl.g:660:1: ruleAndOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'and' ;
    public final AntlrDatatypeRuleToken ruleAndOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDOcl.g:666:2: (kw= 'and' )
            // InternalDOcl.g:667:2: kw= 'and'
            {
            kw=(Token)match(input,25,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getAndOperatorAccess().getAndKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndOperator"


    // $ANTLR start "entryRuleOrOperator"
    // InternalDOcl.g:675:1: entryRuleOrOperator returns [String current=null] : iv_ruleOrOperator= ruleOrOperator EOF ;
    public final String entryRuleOrOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOrOperator = null;


        try {
            // InternalDOcl.g:675:50: (iv_ruleOrOperator= ruleOrOperator EOF )
            // InternalDOcl.g:676:2: iv_ruleOrOperator= ruleOrOperator EOF
            {
             newCompositeNode(grammarAccess.getOrOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrOperator=ruleOrOperator();

            state._fsp--;

             current =iv_ruleOrOperator.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrOperator"


    // $ANTLR start "ruleOrOperator"
    // InternalDOcl.g:682:1: ruleOrOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'or' ;
    public final AntlrDatatypeRuleToken ruleOrOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDOcl.g:688:2: (kw= 'or' )
            // InternalDOcl.g:689:2: kw= 'or'
            {
            kw=(Token)match(input,26,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getOrOperatorAccess().getOrKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrOperator"


    // $ANTLR start "entryRuleXorOperator"
    // InternalDOcl.g:697:1: entryRuleXorOperator returns [String current=null] : iv_ruleXorOperator= ruleXorOperator EOF ;
    public final String entryRuleXorOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXorOperator = null;


        try {
            // InternalDOcl.g:697:51: (iv_ruleXorOperator= ruleXorOperator EOF )
            // InternalDOcl.g:698:2: iv_ruleXorOperator= ruleXorOperator EOF
            {
             newCompositeNode(grammarAccess.getXorOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXorOperator=ruleXorOperator();

            state._fsp--;

             current =iv_ruleXorOperator.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXorOperator"


    // $ANTLR start "ruleXorOperator"
    // InternalDOcl.g:704:1: ruleXorOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'xor' ;
    public final AntlrDatatypeRuleToken ruleXorOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDOcl.g:710:2: (kw= 'xor' )
            // InternalDOcl.g:711:2: kw= 'xor'
            {
            kw=(Token)match(input,27,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getXorOperatorAccess().getXorKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXorOperator"


    // $ANTLR start "entryRuleImpliesOperator"
    // InternalDOcl.g:719:1: entryRuleImpliesOperator returns [String current=null] : iv_ruleImpliesOperator= ruleImpliesOperator EOF ;
    public final String entryRuleImpliesOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleImpliesOperator = null;


        try {
            // InternalDOcl.g:719:55: (iv_ruleImpliesOperator= ruleImpliesOperator EOF )
            // InternalDOcl.g:720:2: iv_ruleImpliesOperator= ruleImpliesOperator EOF
            {
             newCompositeNode(grammarAccess.getImpliesOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImpliesOperator=ruleImpliesOperator();

            state._fsp--;

             current =iv_ruleImpliesOperator.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImpliesOperator"


    // $ANTLR start "ruleImpliesOperator"
    // InternalDOcl.g:726:1: ruleImpliesOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'implies' ;
    public final AntlrDatatypeRuleToken ruleImpliesOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDOcl.g:732:2: (kw= 'implies' )
            // InternalDOcl.g:733:2: kw= 'implies'
            {
            kw=(Token)match(input,28,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getImpliesOperatorAccess().getImpliesKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImpliesOperator"


    // $ANTLR start "entryRuleNavigationOperator"
    // InternalDOcl.g:741:1: entryRuleNavigationOperator returns [String current=null] : iv_ruleNavigationOperator= ruleNavigationOperator EOF ;
    public final String entryRuleNavigationOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNavigationOperator = null;


        try {
            // InternalDOcl.g:741:58: (iv_ruleNavigationOperator= ruleNavigationOperator EOF )
            // InternalDOcl.g:742:2: iv_ruleNavigationOperator= ruleNavigationOperator EOF
            {
             newCompositeNode(grammarAccess.getNavigationOperatorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNavigationOperator=ruleNavigationOperator();

            state._fsp--;

             current =iv_ruleNavigationOperator.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigationOperator"


    // $ANTLR start "ruleNavigationOperator"
    // InternalDOcl.g:748:1: ruleNavigationOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '.' | kw= '->' ) ;
    public final AntlrDatatypeRuleToken ruleNavigationOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDOcl.g:754:2: ( (kw= '.' | kw= '->' ) )
            // InternalDOcl.g:755:2: (kw= '.' | kw= '->' )
            {
            // InternalDOcl.g:755:2: (kw= '.' | kw= '->' )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==18) ) {
                alt10=1;
            }
            else if ( (LA10_0==29) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalDOcl.g:756:3: kw= '.'
                    {
                    kw=(Token)match(input,18,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getNavigationOperatorAccess().getFullStopKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalDOcl.g:762:3: kw= '->'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getNavigationOperatorAccess().getHyphenMinusGreaterThanSignKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigationOperator"


    // $ANTLR start "entryRuleCollectionOperationID"
    // InternalDOcl.g:771:1: entryRuleCollectionOperationID returns [String current=null] : iv_ruleCollectionOperationID= ruleCollectionOperationID EOF ;
    public final String entryRuleCollectionOperationID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionOperationID = null;


        try {
            // InternalDOcl.g:771:61: (iv_ruleCollectionOperationID= ruleCollectionOperationID EOF )
            // InternalDOcl.g:772:2: iv_ruleCollectionOperationID= ruleCollectionOperationID EOF
            {
             newCompositeNode(grammarAccess.getCollectionOperationIDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollectionOperationID=ruleCollectionOperationID();

            state._fsp--;

             current =iv_ruleCollectionOperationID.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionOperationID"


    // $ANTLR start "ruleCollectionOperationID"
    // InternalDOcl.g:778:1: ruleCollectionOperationID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'size' | kw= 'includes' | kw= 'excludes' | kw= 'count' | kw= 'includesAll' | kw= 'excludesAll' | kw= 'isEmpty' | kw= 'notEmpty' | kw= 'sum' | kw= 'asBag' | kw= 'asSet' | kw= 'asSequence' | kw= 'union' | kw= 'flatten' | kw= 'append' | kw= 'prepend' | kw= 'insertAt' | kw= 'subSequence' | kw= 'at' | kw= 'indexOf' | kw= 'first' | kw= 'last' | kw= 'including' | kw= 'excluding' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionOperationID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDOcl.g:784:2: ( (kw= 'size' | kw= 'includes' | kw= 'excludes' | kw= 'count' | kw= 'includesAll' | kw= 'excludesAll' | kw= 'isEmpty' | kw= 'notEmpty' | kw= 'sum' | kw= 'asBag' | kw= 'asSet' | kw= 'asSequence' | kw= 'union' | kw= 'flatten' | kw= 'append' | kw= 'prepend' | kw= 'insertAt' | kw= 'subSequence' | kw= 'at' | kw= 'indexOf' | kw= 'first' | kw= 'last' | kw= 'including' | kw= 'excluding' ) )
            // InternalDOcl.g:785:2: (kw= 'size' | kw= 'includes' | kw= 'excludes' | kw= 'count' | kw= 'includesAll' | kw= 'excludesAll' | kw= 'isEmpty' | kw= 'notEmpty' | kw= 'sum' | kw= 'asBag' | kw= 'asSet' | kw= 'asSequence' | kw= 'union' | kw= 'flatten' | kw= 'append' | kw= 'prepend' | kw= 'insertAt' | kw= 'subSequence' | kw= 'at' | kw= 'indexOf' | kw= 'first' | kw= 'last' | kw= 'including' | kw= 'excluding' )
            {
            // InternalDOcl.g:785:2: (kw= 'size' | kw= 'includes' | kw= 'excludes' | kw= 'count' | kw= 'includesAll' | kw= 'excludesAll' | kw= 'isEmpty' | kw= 'notEmpty' | kw= 'sum' | kw= 'asBag' | kw= 'asSet' | kw= 'asSequence' | kw= 'union' | kw= 'flatten' | kw= 'append' | kw= 'prepend' | kw= 'insertAt' | kw= 'subSequence' | kw= 'at' | kw= 'indexOf' | kw= 'first' | kw= 'last' | kw= 'including' | kw= 'excluding' )
            int alt11=24;
            switch ( input.LA(1) ) {
            case 30:
                {
                alt11=1;
                }
                break;
            case 31:
                {
                alt11=2;
                }
                break;
            case 32:
                {
                alt11=3;
                }
                break;
            case 33:
                {
                alt11=4;
                }
                break;
            case 34:
                {
                alt11=5;
                }
                break;
            case 35:
                {
                alt11=6;
                }
                break;
            case 36:
                {
                alt11=7;
                }
                break;
            case 37:
                {
                alt11=8;
                }
                break;
            case 38:
                {
                alt11=9;
                }
                break;
            case 39:
                {
                alt11=10;
                }
                break;
            case 40:
                {
                alt11=11;
                }
                break;
            case 41:
                {
                alt11=12;
                }
                break;
            case 42:
                {
                alt11=13;
                }
                break;
            case 43:
                {
                alt11=14;
                }
                break;
            case 44:
                {
                alt11=15;
                }
                break;
            case 45:
                {
                alt11=16;
                }
                break;
            case 46:
                {
                alt11=17;
                }
                break;
            case 47:
                {
                alt11=18;
                }
                break;
            case 48:
                {
                alt11=19;
                }
                break;
            case 49:
                {
                alt11=20;
                }
                break;
            case 50:
                {
                alt11=21;
                }
                break;
            case 51:
                {
                alt11=22;
                }
                break;
            case 52:
                {
                alt11=23;
                }
                break;
            case 53:
                {
                alt11=24;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalDOcl.g:786:3: kw= 'size'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getSizeKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalDOcl.g:792:3: kw= 'includes'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getIncludesKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalDOcl.g:798:3: kw= 'excludes'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getExcludesKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalDOcl.g:804:3: kw= 'count'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getCountKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalDOcl.g:810:3: kw= 'includesAll'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getIncludesAllKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalDOcl.g:816:3: kw= 'excludesAll'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getExcludesAllKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalDOcl.g:822:3: kw= 'isEmpty'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getIsEmptyKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalDOcl.g:828:3: kw= 'notEmpty'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getNotEmptyKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalDOcl.g:834:3: kw= 'sum'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getSumKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalDOcl.g:840:3: kw= 'asBag'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getAsBagKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalDOcl.g:846:3: kw= 'asSet'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getAsSetKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalDOcl.g:852:3: kw= 'asSequence'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getAsSequenceKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalDOcl.g:858:3: kw= 'union'
                    {
                    kw=(Token)match(input,42,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getUnionKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalDOcl.g:864:3: kw= 'flatten'
                    {
                    kw=(Token)match(input,43,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getFlattenKeyword_13());
                    		

                    }
                    break;
                case 15 :
                    // InternalDOcl.g:870:3: kw= 'append'
                    {
                    kw=(Token)match(input,44,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getAppendKeyword_14());
                    		

                    }
                    break;
                case 16 :
                    // InternalDOcl.g:876:3: kw= 'prepend'
                    {
                    kw=(Token)match(input,45,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getPrependKeyword_15());
                    		

                    }
                    break;
                case 17 :
                    // InternalDOcl.g:882:3: kw= 'insertAt'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getInsertAtKeyword_16());
                    		

                    }
                    break;
                case 18 :
                    // InternalDOcl.g:888:3: kw= 'subSequence'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getSubSequenceKeyword_17());
                    		

                    }
                    break;
                case 19 :
                    // InternalDOcl.g:894:3: kw= 'at'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getAtKeyword_18());
                    		

                    }
                    break;
                case 20 :
                    // InternalDOcl.g:900:3: kw= 'indexOf'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getIndexOfKeyword_19());
                    		

                    }
                    break;
                case 21 :
                    // InternalDOcl.g:906:3: kw= 'first'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getFirstKeyword_20());
                    		

                    }
                    break;
                case 22 :
                    // InternalDOcl.g:912:3: kw= 'last'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getLastKeyword_21());
                    		

                    }
                    break;
                case 23 :
                    // InternalDOcl.g:918:3: kw= 'including'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getIncludingKeyword_22());
                    		

                    }
                    break;
                case 24 :
                    // InternalDOcl.g:924:3: kw= 'excluding'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getCollectionOperationIDAccess().getExcludingKeyword_23());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionOperationID"


    // $ANTLR start "entryRuleIterativeOperationID"
    // InternalDOcl.g:933:1: entryRuleIterativeOperationID returns [String current=null] : iv_ruleIterativeOperationID= ruleIterativeOperationID EOF ;
    public final String entryRuleIterativeOperationID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIterativeOperationID = null;


        try {
            // InternalDOcl.g:933:60: (iv_ruleIterativeOperationID= ruleIterativeOperationID EOF )
            // InternalDOcl.g:934:2: iv_ruleIterativeOperationID= ruleIterativeOperationID EOF
            {
             newCompositeNode(grammarAccess.getIterativeOperationIDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIterativeOperationID=ruleIterativeOperationID();

            state._fsp--;

             current =iv_ruleIterativeOperationID.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIterativeOperationID"


    // $ANTLR start "ruleIterativeOperationID"
    // InternalDOcl.g:940:1: ruleIterativeOperationID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'any' | kw= 'one' | kw= 'collect' | kw= 'select' | kw= 'reject' ) ;
    public final AntlrDatatypeRuleToken ruleIterativeOperationID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalDOcl.g:946:2: ( (kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'any' | kw= 'one' | kw= 'collect' | kw= 'select' | kw= 'reject' ) )
            // InternalDOcl.g:947:2: (kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'any' | kw= 'one' | kw= 'collect' | kw= 'select' | kw= 'reject' )
            {
            // InternalDOcl.g:947:2: (kw= 'exists' | kw= 'forAll' | kw= 'isUnique' | kw= 'any' | kw= 'one' | kw= 'collect' | kw= 'select' | kw= 'reject' )
            int alt12=8;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt12=1;
                }
                break;
            case 55:
                {
                alt12=2;
                }
                break;
            case 56:
                {
                alt12=3;
                }
                break;
            case 57:
                {
                alt12=4;
                }
                break;
            case 58:
                {
                alt12=5;
                }
                break;
            case 59:
                {
                alt12=6;
                }
                break;
            case 60:
                {
                alt12=7;
                }
                break;
            case 61:
                {
                alt12=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalDOcl.g:948:3: kw= 'exists'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getIterativeOperationIDAccess().getExistsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalDOcl.g:954:3: kw= 'forAll'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getIterativeOperationIDAccess().getForAllKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalDOcl.g:960:3: kw= 'isUnique'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getIterativeOperationIDAccess().getIsUniqueKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalDOcl.g:966:3: kw= 'any'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getIterativeOperationIDAccess().getAnyKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalDOcl.g:972:3: kw= 'one'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getIterativeOperationIDAccess().getOneKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalDOcl.g:978:3: kw= 'collect'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getIterativeOperationIDAccess().getCollectKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalDOcl.g:984:3: kw= 'select'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getIterativeOperationIDAccess().getSelectKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalDOcl.g:990:3: kw= 'reject'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getIterativeOperationIDAccess().getRejectKeyword_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIterativeOperationID"


    // $ANTLR start "entryRuleOclExpression"
    // InternalDOcl.g:999:1: entryRuleOclExpression returns [EObject current=null] : iv_ruleOclExpression= ruleOclExpression EOF ;
    public final EObject entryRuleOclExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclExpression = null;


        try {
            // InternalDOcl.g:999:54: (iv_ruleOclExpression= ruleOclExpression EOF )
            // InternalDOcl.g:1000:2: iv_ruleOclExpression= ruleOclExpression EOF
            {
             newCompositeNode(grammarAccess.getOclExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOclExpression=ruleOclExpression();

            state._fsp--;

             current =iv_ruleOclExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOclExpression"


    // $ANTLR start "ruleOclExpression"
    // InternalDOcl.g:1006:1: ruleOclExpression returns [EObject current=null] : (this_ImpliesOpExp_0= ruleImpliesOpExp | this_LetExp_1= ruleLetExp | this_UnaryOpExp_2= ruleUnaryOpExp ) ;
    public final EObject ruleOclExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ImpliesOpExp_0 = null;

        EObject this_LetExp_1 = null;

        EObject this_UnaryOpExp_2 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1012:2: ( (this_ImpliesOpExp_0= ruleImpliesOpExp | this_LetExp_1= ruleLetExp | this_UnaryOpExp_2= ruleUnaryOpExp ) )
            // InternalDOcl.g:1013:2: (this_ImpliesOpExp_0= ruleImpliesOpExp | this_LetExp_1= ruleLetExp | this_UnaryOpExp_2= ruleUnaryOpExp )
            {
            // InternalDOcl.g:1013:2: (this_ImpliesOpExp_0= ruleImpliesOpExp | this_LetExp_1= ruleLetExp | this_UnaryOpExp_2= ruleUnaryOpExp )
            int alt13=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case RULE_INT:
            case RULE_STRING:
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
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 71:
            case 72:
            case 75:
            case 79:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 92:
                {
                alt13=1;
                }
                break;
            case 62:
                {
                alt13=2;
                }
                break;
            case 23:
            case 24:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // InternalDOcl.g:1014:3: this_ImpliesOpExp_0= ruleImpliesOpExp
                    {

                    			newCompositeNode(grammarAccess.getOclExpressionAccess().getImpliesOpExpParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ImpliesOpExp_0=ruleImpliesOpExp();

                    state._fsp--;


                    			current = this_ImpliesOpExp_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDOcl.g:1023:3: this_LetExp_1= ruleLetExp
                    {

                    			newCompositeNode(grammarAccess.getOclExpressionAccess().getLetExpParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LetExp_1=ruleLetExp();

                    state._fsp--;


                    			current = this_LetExp_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalDOcl.g:1032:3: this_UnaryOpExp_2= ruleUnaryOpExp
                    {

                    			newCompositeNode(grammarAccess.getOclExpressionAccess().getUnaryOpExpParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnaryOpExp_2=ruleUnaryOpExp();

                    state._fsp--;


                    			current = this_UnaryOpExp_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOclExpression"


    // $ANTLR start "entryRuleLetExp"
    // InternalDOcl.g:1044:1: entryRuleLetExp returns [EObject current=null] : iv_ruleLetExp= ruleLetExp EOF ;
    public final EObject entryRuleLetExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExp = null;


        try {
            // InternalDOcl.g:1044:47: (iv_ruleLetExp= ruleLetExp EOF )
            // InternalDOcl.g:1045:2: iv_ruleLetExp= ruleLetExp EOF
            {
             newCompositeNode(grammarAccess.getLetExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLetExp=ruleLetExp();

            state._fsp--;

             current =iv_ruleLetExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLetExp"


    // $ANTLR start "ruleLetExp"
    // InternalDOcl.g:1051:1: ruleLetExp returns [EObject current=null] : ( ( (lv_name_0_0= 'let' ) ) ( (lv_variable_1_0= ruleLocalVariable ) ) otherlv_2= 'in' ( (lv_in_3_0= ruleOclExpression ) ) ) ;
    public final EObject ruleLetExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        EObject lv_variable_1_0 = null;

        EObject lv_in_3_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1057:2: ( ( ( (lv_name_0_0= 'let' ) ) ( (lv_variable_1_0= ruleLocalVariable ) ) otherlv_2= 'in' ( (lv_in_3_0= ruleOclExpression ) ) ) )
            // InternalDOcl.g:1058:2: ( ( (lv_name_0_0= 'let' ) ) ( (lv_variable_1_0= ruleLocalVariable ) ) otherlv_2= 'in' ( (lv_in_3_0= ruleOclExpression ) ) )
            {
            // InternalDOcl.g:1058:2: ( ( (lv_name_0_0= 'let' ) ) ( (lv_variable_1_0= ruleLocalVariable ) ) otherlv_2= 'in' ( (lv_in_3_0= ruleOclExpression ) ) )
            // InternalDOcl.g:1059:3: ( (lv_name_0_0= 'let' ) ) ( (lv_variable_1_0= ruleLocalVariable ) ) otherlv_2= 'in' ( (lv_in_3_0= ruleOclExpression ) )
            {
            // InternalDOcl.g:1059:3: ( (lv_name_0_0= 'let' ) )
            // InternalDOcl.g:1060:4: (lv_name_0_0= 'let' )
            {
            // InternalDOcl.g:1060:4: (lv_name_0_0= 'let' )
            // InternalDOcl.g:1061:5: lv_name_0_0= 'let'
            {
            lv_name_0_0=(Token)match(input,62,FOLLOW_3); 

            					newLeafNode(lv_name_0_0, grammarAccess.getLetExpAccess().getNameLetKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLetExpRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "let");
            				

            }


            }

            // InternalDOcl.g:1073:3: ( (lv_variable_1_0= ruleLocalVariable ) )
            // InternalDOcl.g:1074:4: (lv_variable_1_0= ruleLocalVariable )
            {
            // InternalDOcl.g:1074:4: (lv_variable_1_0= ruleLocalVariable )
            // InternalDOcl.g:1075:5: lv_variable_1_0= ruleLocalVariable
            {

            					newCompositeNode(grammarAccess.getLetExpAccess().getVariableLocalVariableParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_18);
            lv_variable_1_0=ruleLocalVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLetExpRule());
            					}
            					set(
            						current,
            						"variable",
            						lv_variable_1_0,
            						"fr.inria.diverse.docl.DOcl.LocalVariable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,63,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getLetExpAccess().getInKeyword_2());
            		
            // InternalDOcl.g:1096:3: ( (lv_in_3_0= ruleOclExpression ) )
            // InternalDOcl.g:1097:4: (lv_in_3_0= ruleOclExpression )
            {
            // InternalDOcl.g:1097:4: (lv_in_3_0= ruleOclExpression )
            // InternalDOcl.g:1098:5: lv_in_3_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getLetExpAccess().getInOclExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_in_3_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLetExpRule());
            					}
            					set(
            						current,
            						"in",
            						lv_in_3_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLetExp"


    // $ANTLR start "entryRuleUnaryOpExp"
    // InternalDOcl.g:1119:1: entryRuleUnaryOpExp returns [EObject current=null] : iv_ruleUnaryOpExp= ruleUnaryOpExp EOF ;
    public final EObject entryRuleUnaryOpExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryOpExp = null;


        try {
            // InternalDOcl.g:1119:51: (iv_ruleUnaryOpExp= ruleUnaryOpExp EOF )
            // InternalDOcl.g:1120:2: iv_ruleUnaryOpExp= ruleUnaryOpExp EOF
            {
             newCompositeNode(grammarAccess.getUnaryOpExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnaryOpExp=ruleUnaryOpExp();

            state._fsp--;

             current =iv_ruleUnaryOpExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOpExp"


    // $ANTLR start "ruleUnaryOpExp"
    // InternalDOcl.g:1126:1: ruleUnaryOpExp returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnaryOperator ) ) ( (lv_target_1_0= ruleOclExpression ) ) ) ;
    public final EObject ruleUnaryOpExp() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_target_1_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1132:2: ( ( ( (lv_name_0_0= ruleUnaryOperator ) ) ( (lv_target_1_0= ruleOclExpression ) ) ) )
            // InternalDOcl.g:1133:2: ( ( (lv_name_0_0= ruleUnaryOperator ) ) ( (lv_target_1_0= ruleOclExpression ) ) )
            {
            // InternalDOcl.g:1133:2: ( ( (lv_name_0_0= ruleUnaryOperator ) ) ( (lv_target_1_0= ruleOclExpression ) ) )
            // InternalDOcl.g:1134:3: ( (lv_name_0_0= ruleUnaryOperator ) ) ( (lv_target_1_0= ruleOclExpression ) )
            {
            // InternalDOcl.g:1134:3: ( (lv_name_0_0= ruleUnaryOperator ) )
            // InternalDOcl.g:1135:4: (lv_name_0_0= ruleUnaryOperator )
            {
            // InternalDOcl.g:1135:4: (lv_name_0_0= ruleUnaryOperator )
            // InternalDOcl.g:1136:5: lv_name_0_0= ruleUnaryOperator
            {

            					newCompositeNode(grammarAccess.getUnaryOpExpAccess().getNameUnaryOperatorParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_16);
            lv_name_0_0=ruleUnaryOperator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryOpExpRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"fr.inria.diverse.docl.DOcl.UnaryOperator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDOcl.g:1153:3: ( (lv_target_1_0= ruleOclExpression ) )
            // InternalDOcl.g:1154:4: (lv_target_1_0= ruleOclExpression )
            {
            // InternalDOcl.g:1154:4: (lv_target_1_0= ruleOclExpression )
            // InternalDOcl.g:1155:5: lv_target_1_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getUnaryOpExpAccess().getTargetOclExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_target_1_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryOpExpRule());
            					}
            					set(
            						current,
            						"target",
            						lv_target_1_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOpExp"


    // $ANTLR start "entryRuleImpliesOpExp"
    // InternalDOcl.g:1176:1: entryRuleImpliesOpExp returns [EObject current=null] : iv_ruleImpliesOpExp= ruleImpliesOpExp EOF ;
    public final EObject entryRuleImpliesOpExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImpliesOpExp = null;


        try {
            // InternalDOcl.g:1176:53: (iv_ruleImpliesOpExp= ruleImpliesOpExp EOF )
            // InternalDOcl.g:1177:2: iv_ruleImpliesOpExp= ruleImpliesOpExp EOF
            {
             newCompositeNode(grammarAccess.getImpliesOpExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImpliesOpExp=ruleImpliesOpExp();

            state._fsp--;

             current =iv_ruleImpliesOpExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImpliesOpExp"


    // $ANTLR start "ruleImpliesOpExp"
    // InternalDOcl.g:1183:1: ruleImpliesOpExp returns [EObject current=null] : (this_XorOpExp_0= ruleXorOpExp ( () ( (lv_name_2_0= ruleImpliesOperator ) ) ( (lv_target_3_0= ruleXorOpExp ) ) )* ) ;
    public final EObject ruleImpliesOpExp() throws RecognitionException {
        EObject current = null;

        EObject this_XorOpExp_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_target_3_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1189:2: ( (this_XorOpExp_0= ruleXorOpExp ( () ( (lv_name_2_0= ruleImpliesOperator ) ) ( (lv_target_3_0= ruleXorOpExp ) ) )* ) )
            // InternalDOcl.g:1190:2: (this_XorOpExp_0= ruleXorOpExp ( () ( (lv_name_2_0= ruleImpliesOperator ) ) ( (lv_target_3_0= ruleXorOpExp ) ) )* )
            {
            // InternalDOcl.g:1190:2: (this_XorOpExp_0= ruleXorOpExp ( () ( (lv_name_2_0= ruleImpliesOperator ) ) ( (lv_target_3_0= ruleXorOpExp ) ) )* )
            // InternalDOcl.g:1191:3: this_XorOpExp_0= ruleXorOpExp ( () ( (lv_name_2_0= ruleImpliesOperator ) ) ( (lv_target_3_0= ruleXorOpExp ) ) )*
            {

            			newCompositeNode(grammarAccess.getImpliesOpExpAccess().getXorOpExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_19);
            this_XorOpExp_0=ruleXorOpExp();

            state._fsp--;


            			current = this_XorOpExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDOcl.g:1199:3: ( () ( (lv_name_2_0= ruleImpliesOperator ) ) ( (lv_target_3_0= ruleXorOpExp ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==28) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalDOcl.g:1200:4: () ( (lv_name_2_0= ruleImpliesOperator ) ) ( (lv_target_3_0= ruleXorOpExp ) )
            	    {
            	    // InternalDOcl.g:1200:4: ()
            	    // InternalDOcl.g:1201:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getImpliesOpExpAccess().getBoolOpCallExpSourceAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalDOcl.g:1207:4: ( (lv_name_2_0= ruleImpliesOperator ) )
            	    // InternalDOcl.g:1208:5: (lv_name_2_0= ruleImpliesOperator )
            	    {
            	    // InternalDOcl.g:1208:5: (lv_name_2_0= ruleImpliesOperator )
            	    // InternalDOcl.g:1209:6: lv_name_2_0= ruleImpliesOperator
            	    {

            	    						newCompositeNode(grammarAccess.getImpliesOpExpAccess().getNameImpliesOperatorParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_name_2_0=ruleImpliesOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getImpliesOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"name",
            	    							lv_name_2_0,
            	    							"fr.inria.diverse.docl.DOcl.ImpliesOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalDOcl.g:1226:4: ( (lv_target_3_0= ruleXorOpExp ) )
            	    // InternalDOcl.g:1227:5: (lv_target_3_0= ruleXorOpExp )
            	    {
            	    // InternalDOcl.g:1227:5: (lv_target_3_0= ruleXorOpExp )
            	    // InternalDOcl.g:1228:6: lv_target_3_0= ruleXorOpExp
            	    {

            	    						newCompositeNode(grammarAccess.getImpliesOpExpAccess().getTargetXorOpExpParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    lv_target_3_0=ruleXorOpExp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getImpliesOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"target",
            	    							lv_target_3_0,
            	    							"fr.inria.diverse.docl.DOcl.XorOpExp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImpliesOpExp"


    // $ANTLR start "entryRuleXorOpExp"
    // InternalDOcl.g:1250:1: entryRuleXorOpExp returns [EObject current=null] : iv_ruleXorOpExp= ruleXorOpExp EOF ;
    public final EObject entryRuleXorOpExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorOpExp = null;


        try {
            // InternalDOcl.g:1250:49: (iv_ruleXorOpExp= ruleXorOpExp EOF )
            // InternalDOcl.g:1251:2: iv_ruleXorOpExp= ruleXorOpExp EOF
            {
             newCompositeNode(grammarAccess.getXorOpExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleXorOpExp=ruleXorOpExp();

            state._fsp--;

             current =iv_ruleXorOpExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleXorOpExp"


    // $ANTLR start "ruleXorOpExp"
    // InternalDOcl.g:1257:1: ruleXorOpExp returns [EObject current=null] : (this_OrOpExp_0= ruleOrOpExp ( () ( (lv_name_2_0= ruleXorOperator ) ) ( (lv_target_3_0= ruleOrOpExp ) ) )* ) ;
    public final EObject ruleXorOpExp() throws RecognitionException {
        EObject current = null;

        EObject this_OrOpExp_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_target_3_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1263:2: ( (this_OrOpExp_0= ruleOrOpExp ( () ( (lv_name_2_0= ruleXorOperator ) ) ( (lv_target_3_0= ruleOrOpExp ) ) )* ) )
            // InternalDOcl.g:1264:2: (this_OrOpExp_0= ruleOrOpExp ( () ( (lv_name_2_0= ruleXorOperator ) ) ( (lv_target_3_0= ruleOrOpExp ) ) )* )
            {
            // InternalDOcl.g:1264:2: (this_OrOpExp_0= ruleOrOpExp ( () ( (lv_name_2_0= ruleXorOperator ) ) ( (lv_target_3_0= ruleOrOpExp ) ) )* )
            // InternalDOcl.g:1265:3: this_OrOpExp_0= ruleOrOpExp ( () ( (lv_name_2_0= ruleXorOperator ) ) ( (lv_target_3_0= ruleOrOpExp ) ) )*
            {

            			newCompositeNode(grammarAccess.getXorOpExpAccess().getOrOpExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_21);
            this_OrOpExp_0=ruleOrOpExp();

            state._fsp--;


            			current = this_OrOpExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDOcl.g:1273:3: ( () ( (lv_name_2_0= ruleXorOperator ) ) ( (lv_target_3_0= ruleOrOpExp ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==27) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalDOcl.g:1274:4: () ( (lv_name_2_0= ruleXorOperator ) ) ( (lv_target_3_0= ruleOrOpExp ) )
            	    {
            	    // InternalDOcl.g:1274:4: ()
            	    // InternalDOcl.g:1275:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getXorOpExpAccess().getBoolOpCallExpSourceAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalDOcl.g:1281:4: ( (lv_name_2_0= ruleXorOperator ) )
            	    // InternalDOcl.g:1282:5: (lv_name_2_0= ruleXorOperator )
            	    {
            	    // InternalDOcl.g:1282:5: (lv_name_2_0= ruleXorOperator )
            	    // InternalDOcl.g:1283:6: lv_name_2_0= ruleXorOperator
            	    {

            	    						newCompositeNode(grammarAccess.getXorOpExpAccess().getNameXorOperatorParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_name_2_0=ruleXorOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getXorOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"name",
            	    							lv_name_2_0,
            	    							"fr.inria.diverse.docl.DOcl.XorOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalDOcl.g:1300:4: ( (lv_target_3_0= ruleOrOpExp ) )
            	    // InternalDOcl.g:1301:5: (lv_target_3_0= ruleOrOpExp )
            	    {
            	    // InternalDOcl.g:1301:5: (lv_target_3_0= ruleOrOpExp )
            	    // InternalDOcl.g:1302:6: lv_target_3_0= ruleOrOpExp
            	    {

            	    						newCompositeNode(grammarAccess.getXorOpExpAccess().getTargetOrOpExpParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_21);
            	    lv_target_3_0=ruleOrOpExp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getXorOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"target",
            	    							lv_target_3_0,
            	    							"fr.inria.diverse.docl.DOcl.OrOpExp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleXorOpExp"


    // $ANTLR start "entryRuleOrOpExp"
    // InternalDOcl.g:1324:1: entryRuleOrOpExp returns [EObject current=null] : iv_ruleOrOpExp= ruleOrOpExp EOF ;
    public final EObject entryRuleOrOpExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrOpExp = null;


        try {
            // InternalDOcl.g:1324:48: (iv_ruleOrOpExp= ruleOrOpExp EOF )
            // InternalDOcl.g:1325:2: iv_ruleOrOpExp= ruleOrOpExp EOF
            {
             newCompositeNode(grammarAccess.getOrOpExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrOpExp=ruleOrOpExp();

            state._fsp--;

             current =iv_ruleOrOpExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrOpExp"


    // $ANTLR start "ruleOrOpExp"
    // InternalDOcl.g:1331:1: ruleOrOpExp returns [EObject current=null] : (this_AndOpExp_0= ruleAndOpExp ( () ( (lv_name_2_0= ruleOrOperator ) ) ( (lv_target_3_0= ruleAndOpExp ) ) )* ) ;
    public final EObject ruleOrOpExp() throws RecognitionException {
        EObject current = null;

        EObject this_AndOpExp_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_target_3_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1337:2: ( (this_AndOpExp_0= ruleAndOpExp ( () ( (lv_name_2_0= ruleOrOperator ) ) ( (lv_target_3_0= ruleAndOpExp ) ) )* ) )
            // InternalDOcl.g:1338:2: (this_AndOpExp_0= ruleAndOpExp ( () ( (lv_name_2_0= ruleOrOperator ) ) ( (lv_target_3_0= ruleAndOpExp ) ) )* )
            {
            // InternalDOcl.g:1338:2: (this_AndOpExp_0= ruleAndOpExp ( () ( (lv_name_2_0= ruleOrOperator ) ) ( (lv_target_3_0= ruleAndOpExp ) ) )* )
            // InternalDOcl.g:1339:3: this_AndOpExp_0= ruleAndOpExp ( () ( (lv_name_2_0= ruleOrOperator ) ) ( (lv_target_3_0= ruleAndOpExp ) ) )*
            {

            			newCompositeNode(grammarAccess.getOrOpExpAccess().getAndOpExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_22);
            this_AndOpExp_0=ruleAndOpExp();

            state._fsp--;


            			current = this_AndOpExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDOcl.g:1347:3: ( () ( (lv_name_2_0= ruleOrOperator ) ) ( (lv_target_3_0= ruleAndOpExp ) ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalDOcl.g:1348:4: () ( (lv_name_2_0= ruleOrOperator ) ) ( (lv_target_3_0= ruleAndOpExp ) )
            	    {
            	    // InternalDOcl.g:1348:4: ()
            	    // InternalDOcl.g:1349:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getOrOpExpAccess().getBoolOpCallExpSourceAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalDOcl.g:1355:4: ( (lv_name_2_0= ruleOrOperator ) )
            	    // InternalDOcl.g:1356:5: (lv_name_2_0= ruleOrOperator )
            	    {
            	    // InternalDOcl.g:1356:5: (lv_name_2_0= ruleOrOperator )
            	    // InternalDOcl.g:1357:6: lv_name_2_0= ruleOrOperator
            	    {

            	    						newCompositeNode(grammarAccess.getOrOpExpAccess().getNameOrOperatorParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_name_2_0=ruleOrOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"name",
            	    							lv_name_2_0,
            	    							"fr.inria.diverse.docl.DOcl.OrOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalDOcl.g:1374:4: ( (lv_target_3_0= ruleAndOpExp ) )
            	    // InternalDOcl.g:1375:5: (lv_target_3_0= ruleAndOpExp )
            	    {
            	    // InternalDOcl.g:1375:5: (lv_target_3_0= ruleAndOpExp )
            	    // InternalDOcl.g:1376:6: lv_target_3_0= ruleAndOpExp
            	    {

            	    						newCompositeNode(grammarAccess.getOrOpExpAccess().getTargetAndOpExpParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_22);
            	    lv_target_3_0=ruleAndOpExp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOrOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"target",
            	    							lv_target_3_0,
            	    							"fr.inria.diverse.docl.DOcl.AndOpExp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrOpExp"


    // $ANTLR start "entryRuleAndOpExp"
    // InternalDOcl.g:1398:1: entryRuleAndOpExp returns [EObject current=null] : iv_ruleAndOpExp= ruleAndOpExp EOF ;
    public final EObject entryRuleAndOpExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndOpExp = null;


        try {
            // InternalDOcl.g:1398:49: (iv_ruleAndOpExp= ruleAndOpExp EOF )
            // InternalDOcl.g:1399:2: iv_ruleAndOpExp= ruleAndOpExp EOF
            {
             newCompositeNode(grammarAccess.getAndOpExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndOpExp=ruleAndOpExp();

            state._fsp--;

             current =iv_ruleAndOpExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndOpExp"


    // $ANTLR start "ruleAndOpExp"
    // InternalDOcl.g:1405:1: ruleAndOpExp returns [EObject current=null] : (this_EqOpExp_0= ruleEqOpExp ( () ( (lv_name_2_0= ruleAndOperator ) ) ( (lv_target_3_0= ruleEqOpExp ) ) )* ) ;
    public final EObject ruleAndOpExp() throws RecognitionException {
        EObject current = null;

        EObject this_EqOpExp_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_target_3_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1411:2: ( (this_EqOpExp_0= ruleEqOpExp ( () ( (lv_name_2_0= ruleAndOperator ) ) ( (lv_target_3_0= ruleEqOpExp ) ) )* ) )
            // InternalDOcl.g:1412:2: (this_EqOpExp_0= ruleEqOpExp ( () ( (lv_name_2_0= ruleAndOperator ) ) ( (lv_target_3_0= ruleEqOpExp ) ) )* )
            {
            // InternalDOcl.g:1412:2: (this_EqOpExp_0= ruleEqOpExp ( () ( (lv_name_2_0= ruleAndOperator ) ) ( (lv_target_3_0= ruleEqOpExp ) ) )* )
            // InternalDOcl.g:1413:3: this_EqOpExp_0= ruleEqOpExp ( () ( (lv_name_2_0= ruleAndOperator ) ) ( (lv_target_3_0= ruleEqOpExp ) ) )*
            {

            			newCompositeNode(grammarAccess.getAndOpExpAccess().getEqOpExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_23);
            this_EqOpExp_0=ruleEqOpExp();

            state._fsp--;


            			current = this_EqOpExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDOcl.g:1421:3: ( () ( (lv_name_2_0= ruleAndOperator ) ) ( (lv_target_3_0= ruleEqOpExp ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==25) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalDOcl.g:1422:4: () ( (lv_name_2_0= ruleAndOperator ) ) ( (lv_target_3_0= ruleEqOpExp ) )
            	    {
            	    // InternalDOcl.g:1422:4: ()
            	    // InternalDOcl.g:1423:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAndOpExpAccess().getBoolOpCallExpSourceAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalDOcl.g:1429:4: ( (lv_name_2_0= ruleAndOperator ) )
            	    // InternalDOcl.g:1430:5: (lv_name_2_0= ruleAndOperator )
            	    {
            	    // InternalDOcl.g:1430:5: (lv_name_2_0= ruleAndOperator )
            	    // InternalDOcl.g:1431:6: lv_name_2_0= ruleAndOperator
            	    {

            	    						newCompositeNode(grammarAccess.getAndOpExpAccess().getNameAndOperatorParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_name_2_0=ruleAndOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"name",
            	    							lv_name_2_0,
            	    							"fr.inria.diverse.docl.DOcl.AndOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalDOcl.g:1448:4: ( (lv_target_3_0= ruleEqOpExp ) )
            	    // InternalDOcl.g:1449:5: (lv_target_3_0= ruleEqOpExp )
            	    {
            	    // InternalDOcl.g:1449:5: (lv_target_3_0= ruleEqOpExp )
            	    // InternalDOcl.g:1450:6: lv_target_3_0= ruleEqOpExp
            	    {

            	    						newCompositeNode(grammarAccess.getAndOpExpAccess().getTargetEqOpExpParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_23);
            	    lv_target_3_0=ruleEqOpExp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"target",
            	    							lv_target_3_0,
            	    							"fr.inria.diverse.docl.DOcl.EqOpExp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndOpExp"


    // $ANTLR start "entryRuleEqOpExp"
    // InternalDOcl.g:1472:1: entryRuleEqOpExp returns [EObject current=null] : iv_ruleEqOpExp= ruleEqOpExp EOF ;
    public final EObject entryRuleEqOpExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqOpExp = null;


        try {
            // InternalDOcl.g:1472:48: (iv_ruleEqOpExp= ruleEqOpExp EOF )
            // InternalDOcl.g:1473:2: iv_ruleEqOpExp= ruleEqOpExp EOF
            {
             newCompositeNode(grammarAccess.getEqOpExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEqOpExp=ruleEqOpExp();

            state._fsp--;

             current =iv_ruleEqOpExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqOpExp"


    // $ANTLR start "ruleEqOpExp"
    // InternalDOcl.g:1479:1: ruleEqOpExp returns [EObject current=null] : (this_ComparisonOpExp_0= ruleComparisonOpExp ( () ( ( (lv_name_2_1= '<>' | lv_name_2_2= '=' ) ) ) ( (lv_target_3_0= ruleComparisonOpExp ) ) )* ) ;
    public final EObject ruleEqOpExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_1=null;
        Token lv_name_2_2=null;
        EObject this_ComparisonOpExp_0 = null;

        EObject lv_target_3_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1485:2: ( (this_ComparisonOpExp_0= ruleComparisonOpExp ( () ( ( (lv_name_2_1= '<>' | lv_name_2_2= '=' ) ) ) ( (lv_target_3_0= ruleComparisonOpExp ) ) )* ) )
            // InternalDOcl.g:1486:2: (this_ComparisonOpExp_0= ruleComparisonOpExp ( () ( ( (lv_name_2_1= '<>' | lv_name_2_2= '=' ) ) ) ( (lv_target_3_0= ruleComparisonOpExp ) ) )* )
            {
            // InternalDOcl.g:1486:2: (this_ComparisonOpExp_0= ruleComparisonOpExp ( () ( ( (lv_name_2_1= '<>' | lv_name_2_2= '=' ) ) ) ( (lv_target_3_0= ruleComparisonOpExp ) ) )* )
            // InternalDOcl.g:1487:3: this_ComparisonOpExp_0= ruleComparisonOpExp ( () ( ( (lv_name_2_1= '<>' | lv_name_2_2= '=' ) ) ) ( (lv_target_3_0= ruleComparisonOpExp ) ) )*
            {

            			newCompositeNode(grammarAccess.getEqOpExpAccess().getComparisonOpExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_24);
            this_ComparisonOpExp_0=ruleComparisonOpExp();

            state._fsp--;


            			current = this_ComparisonOpExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDOcl.g:1495:3: ( () ( ( (lv_name_2_1= '<>' | lv_name_2_2= '=' ) ) ) ( (lv_target_3_0= ruleComparisonOpExp ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=64 && LA19_0<=65)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalDOcl.g:1496:4: () ( ( (lv_name_2_1= '<>' | lv_name_2_2= '=' ) ) ) ( (lv_target_3_0= ruleComparisonOpExp ) )
            	    {
            	    // InternalDOcl.g:1496:4: ()
            	    // InternalDOcl.g:1497:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getEqOpExpAccess().getEqOpCallExpSourceAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalDOcl.g:1503:4: ( ( (lv_name_2_1= '<>' | lv_name_2_2= '=' ) ) )
            	    // InternalDOcl.g:1504:5: ( (lv_name_2_1= '<>' | lv_name_2_2= '=' ) )
            	    {
            	    // InternalDOcl.g:1504:5: ( (lv_name_2_1= '<>' | lv_name_2_2= '=' ) )
            	    // InternalDOcl.g:1505:6: (lv_name_2_1= '<>' | lv_name_2_2= '=' )
            	    {
            	    // InternalDOcl.g:1505:6: (lv_name_2_1= '<>' | lv_name_2_2= '=' )
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==64) ) {
            	        alt18=1;
            	    }
            	    else if ( (LA18_0==65) ) {
            	        alt18=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // InternalDOcl.g:1506:7: lv_name_2_1= '<>'
            	            {
            	            lv_name_2_1=(Token)match(input,64,FOLLOW_20); 

            	            							newLeafNode(lv_name_2_1, grammarAccess.getEqOpExpAccess().getNameLessThanSignGreaterThanSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getEqOpExpRule());
            	            							}
            	            							setWithLastConsumed(current, "name", lv_name_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalDOcl.g:1517:7: lv_name_2_2= '='
            	            {
            	            lv_name_2_2=(Token)match(input,65,FOLLOW_20); 

            	            							newLeafNode(lv_name_2_2, grammarAccess.getEqOpExpAccess().getNameEqualsSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getEqOpExpRule());
            	            							}
            	            							setWithLastConsumed(current, "name", lv_name_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalDOcl.g:1530:4: ( (lv_target_3_0= ruleComparisonOpExp ) )
            	    // InternalDOcl.g:1531:5: (lv_target_3_0= ruleComparisonOpExp )
            	    {
            	    // InternalDOcl.g:1531:5: (lv_target_3_0= ruleComparisonOpExp )
            	    // InternalDOcl.g:1532:6: lv_target_3_0= ruleComparisonOpExp
            	    {

            	    						newCompositeNode(grammarAccess.getEqOpExpAccess().getTargetComparisonOpExpParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_target_3_0=ruleComparisonOpExp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEqOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"target",
            	    							lv_target_3_0,
            	    							"fr.inria.diverse.docl.DOcl.ComparisonOpExp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqOpExp"


    // $ANTLR start "entryRuleComparisonOpExp"
    // InternalDOcl.g:1554:1: entryRuleComparisonOpExp returns [EObject current=null] : iv_ruleComparisonOpExp= ruleComparisonOpExp EOF ;
    public final EObject entryRuleComparisonOpExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonOpExp = null;


        try {
            // InternalDOcl.g:1554:56: (iv_ruleComparisonOpExp= ruleComparisonOpExp EOF )
            // InternalDOcl.g:1555:2: iv_ruleComparisonOpExp= ruleComparisonOpExp EOF
            {
             newCompositeNode(grammarAccess.getComparisonOpExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComparisonOpExp=ruleComparisonOpExp();

            state._fsp--;

             current =iv_ruleComparisonOpExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparisonOpExp"


    // $ANTLR start "ruleComparisonOpExp"
    // InternalDOcl.g:1561:1: ruleComparisonOpExp returns [EObject current=null] : (this_AdditionOpExp_0= ruleAdditionOpExp ( () ( ( (lv_name_2_1= '>' | lv_name_2_2= '<' | lv_name_2_3= '>=' | lv_name_2_4= '<=' ) ) ) ( (lv_target_3_0= ruleAdditionOpExp ) ) )* ) ;
    public final EObject ruleComparisonOpExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_1=null;
        Token lv_name_2_2=null;
        Token lv_name_2_3=null;
        Token lv_name_2_4=null;
        EObject this_AdditionOpExp_0 = null;

        EObject lv_target_3_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1567:2: ( (this_AdditionOpExp_0= ruleAdditionOpExp ( () ( ( (lv_name_2_1= '>' | lv_name_2_2= '<' | lv_name_2_3= '>=' | lv_name_2_4= '<=' ) ) ) ( (lv_target_3_0= ruleAdditionOpExp ) ) )* ) )
            // InternalDOcl.g:1568:2: (this_AdditionOpExp_0= ruleAdditionOpExp ( () ( ( (lv_name_2_1= '>' | lv_name_2_2= '<' | lv_name_2_3= '>=' | lv_name_2_4= '<=' ) ) ) ( (lv_target_3_0= ruleAdditionOpExp ) ) )* )
            {
            // InternalDOcl.g:1568:2: (this_AdditionOpExp_0= ruleAdditionOpExp ( () ( ( (lv_name_2_1= '>' | lv_name_2_2= '<' | lv_name_2_3= '>=' | lv_name_2_4= '<=' ) ) ) ( (lv_target_3_0= ruleAdditionOpExp ) ) )* )
            // InternalDOcl.g:1569:3: this_AdditionOpExp_0= ruleAdditionOpExp ( () ( ( (lv_name_2_1= '>' | lv_name_2_2= '<' | lv_name_2_3= '>=' | lv_name_2_4= '<=' ) ) ) ( (lv_target_3_0= ruleAdditionOpExp ) ) )*
            {

            			newCompositeNode(grammarAccess.getComparisonOpExpAccess().getAdditionOpExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_25);
            this_AdditionOpExp_0=ruleAdditionOpExp();

            state._fsp--;


            			current = this_AdditionOpExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDOcl.g:1577:3: ( () ( ( (lv_name_2_1= '>' | lv_name_2_2= '<' | lv_name_2_3= '>=' | lv_name_2_4= '<=' ) ) ) ( (lv_target_3_0= ruleAdditionOpExp ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=66 && LA21_0<=69)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalDOcl.g:1578:4: () ( ( (lv_name_2_1= '>' | lv_name_2_2= '<' | lv_name_2_3= '>=' | lv_name_2_4= '<=' ) ) ) ( (lv_target_3_0= ruleAdditionOpExp ) )
            	    {
            	    // InternalDOcl.g:1578:4: ()
            	    // InternalDOcl.g:1579:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getComparisonOpExpAccess().getComOpCallExpSourceAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalDOcl.g:1585:4: ( ( (lv_name_2_1= '>' | lv_name_2_2= '<' | lv_name_2_3= '>=' | lv_name_2_4= '<=' ) ) )
            	    // InternalDOcl.g:1586:5: ( (lv_name_2_1= '>' | lv_name_2_2= '<' | lv_name_2_3= '>=' | lv_name_2_4= '<=' ) )
            	    {
            	    // InternalDOcl.g:1586:5: ( (lv_name_2_1= '>' | lv_name_2_2= '<' | lv_name_2_3= '>=' | lv_name_2_4= '<=' ) )
            	    // InternalDOcl.g:1587:6: (lv_name_2_1= '>' | lv_name_2_2= '<' | lv_name_2_3= '>=' | lv_name_2_4= '<=' )
            	    {
            	    // InternalDOcl.g:1587:6: (lv_name_2_1= '>' | lv_name_2_2= '<' | lv_name_2_3= '>=' | lv_name_2_4= '<=' )
            	    int alt20=4;
            	    switch ( input.LA(1) ) {
            	    case 66:
            	        {
            	        alt20=1;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt20=2;
            	        }
            	        break;
            	    case 68:
            	        {
            	        alt20=3;
            	        }
            	        break;
            	    case 69:
            	        {
            	        alt20=4;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 20, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt20) {
            	        case 1 :
            	            // InternalDOcl.g:1588:7: lv_name_2_1= '>'
            	            {
            	            lv_name_2_1=(Token)match(input,66,FOLLOW_20); 

            	            							newLeafNode(lv_name_2_1, grammarAccess.getComparisonOpExpAccess().getNameGreaterThanSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonOpExpRule());
            	            							}
            	            							setWithLastConsumed(current, "name", lv_name_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalDOcl.g:1599:7: lv_name_2_2= '<'
            	            {
            	            lv_name_2_2=(Token)match(input,67,FOLLOW_20); 

            	            							newLeafNode(lv_name_2_2, grammarAccess.getComparisonOpExpAccess().getNameLessThanSignKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonOpExpRule());
            	            							}
            	            							setWithLastConsumed(current, "name", lv_name_2_2, null);
            	            						

            	            }
            	            break;
            	        case 3 :
            	            // InternalDOcl.g:1610:7: lv_name_2_3= '>='
            	            {
            	            lv_name_2_3=(Token)match(input,68,FOLLOW_20); 

            	            							newLeafNode(lv_name_2_3, grammarAccess.getComparisonOpExpAccess().getNameGreaterThanSignEqualsSignKeyword_1_1_0_2());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonOpExpRule());
            	            							}
            	            							setWithLastConsumed(current, "name", lv_name_2_3, null);
            	            						

            	            }
            	            break;
            	        case 4 :
            	            // InternalDOcl.g:1621:7: lv_name_2_4= '<='
            	            {
            	            lv_name_2_4=(Token)match(input,69,FOLLOW_20); 

            	            							newLeafNode(lv_name_2_4, grammarAccess.getComparisonOpExpAccess().getNameLessThanSignEqualsSignKeyword_1_1_0_3());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getComparisonOpExpRule());
            	            							}
            	            							setWithLastConsumed(current, "name", lv_name_2_4, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalDOcl.g:1634:4: ( (lv_target_3_0= ruleAdditionOpExp ) )
            	    // InternalDOcl.g:1635:5: (lv_target_3_0= ruleAdditionOpExp )
            	    {
            	    // InternalDOcl.g:1635:5: (lv_target_3_0= ruleAdditionOpExp )
            	    // InternalDOcl.g:1636:6: lv_target_3_0= ruleAdditionOpExp
            	    {

            	    						newCompositeNode(grammarAccess.getComparisonOpExpAccess().getTargetAdditionOpExpParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    lv_target_3_0=ruleAdditionOpExp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getComparisonOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"target",
            	    							lv_target_3_0,
            	    							"fr.inria.diverse.docl.DOcl.AdditionOpExp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparisonOpExp"


    // $ANTLR start "entryRuleAdditionOpExp"
    // InternalDOcl.g:1658:1: entryRuleAdditionOpExp returns [EObject current=null] : iv_ruleAdditionOpExp= ruleAdditionOpExp EOF ;
    public final EObject entryRuleAdditionOpExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditionOpExp = null;


        try {
            // InternalDOcl.g:1658:54: (iv_ruleAdditionOpExp= ruleAdditionOpExp EOF )
            // InternalDOcl.g:1659:2: iv_ruleAdditionOpExp= ruleAdditionOpExp EOF
            {
             newCompositeNode(grammarAccess.getAdditionOpExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdditionOpExp=ruleAdditionOpExp();

            state._fsp--;

             current =iv_ruleAdditionOpExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditionOpExp"


    // $ANTLR start "ruleAdditionOpExp"
    // InternalDOcl.g:1665:1: ruleAdditionOpExp returns [EObject current=null] : (this_MultiOpExp_0= ruleMultiOpExp ( () ( ( (lv_name_2_1= '+' | lv_name_2_2= '-' ) ) ) ( (lv_target_3_0= ruleMultiOpExp ) ) )* ) ;
    public final EObject ruleAdditionOpExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_1=null;
        Token lv_name_2_2=null;
        EObject this_MultiOpExp_0 = null;

        EObject lv_target_3_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1671:2: ( (this_MultiOpExp_0= ruleMultiOpExp ( () ( ( (lv_name_2_1= '+' | lv_name_2_2= '-' ) ) ) ( (lv_target_3_0= ruleMultiOpExp ) ) )* ) )
            // InternalDOcl.g:1672:2: (this_MultiOpExp_0= ruleMultiOpExp ( () ( ( (lv_name_2_1= '+' | lv_name_2_2= '-' ) ) ) ( (lv_target_3_0= ruleMultiOpExp ) ) )* )
            {
            // InternalDOcl.g:1672:2: (this_MultiOpExp_0= ruleMultiOpExp ( () ( ( (lv_name_2_1= '+' | lv_name_2_2= '-' ) ) ) ( (lv_target_3_0= ruleMultiOpExp ) ) )* )
            // InternalDOcl.g:1673:3: this_MultiOpExp_0= ruleMultiOpExp ( () ( ( (lv_name_2_1= '+' | lv_name_2_2= '-' ) ) ) ( (lv_target_3_0= ruleMultiOpExp ) ) )*
            {

            			newCompositeNode(grammarAccess.getAdditionOpExpAccess().getMultiOpExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_26);
            this_MultiOpExp_0=ruleMultiOpExp();

            state._fsp--;


            			current = this_MultiOpExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDOcl.g:1681:3: ( () ( ( (lv_name_2_1= '+' | lv_name_2_2= '-' ) ) ) ( (lv_target_3_0= ruleMultiOpExp ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==23||LA23_0==70) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDOcl.g:1682:4: () ( ( (lv_name_2_1= '+' | lv_name_2_2= '-' ) ) ) ( (lv_target_3_0= ruleMultiOpExp ) )
            	    {
            	    // InternalDOcl.g:1682:4: ()
            	    // InternalDOcl.g:1683:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getAdditionOpExpAccess().getAddOpCallExpSourceAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalDOcl.g:1689:4: ( ( (lv_name_2_1= '+' | lv_name_2_2= '-' ) ) )
            	    // InternalDOcl.g:1690:5: ( (lv_name_2_1= '+' | lv_name_2_2= '-' ) )
            	    {
            	    // InternalDOcl.g:1690:5: ( (lv_name_2_1= '+' | lv_name_2_2= '-' ) )
            	    // InternalDOcl.g:1691:6: (lv_name_2_1= '+' | lv_name_2_2= '-' )
            	    {
            	    // InternalDOcl.g:1691:6: (lv_name_2_1= '+' | lv_name_2_2= '-' )
            	    int alt22=2;
            	    int LA22_0 = input.LA(1);

            	    if ( (LA22_0==70) ) {
            	        alt22=1;
            	    }
            	    else if ( (LA22_0==23) ) {
            	        alt22=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 22, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt22) {
            	        case 1 :
            	            // InternalDOcl.g:1692:7: lv_name_2_1= '+'
            	            {
            	            lv_name_2_1=(Token)match(input,70,FOLLOW_20); 

            	            							newLeafNode(lv_name_2_1, grammarAccess.getAdditionOpExpAccess().getNamePlusSignKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getAdditionOpExpRule());
            	            							}
            	            							setWithLastConsumed(current, "name", lv_name_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalDOcl.g:1703:7: lv_name_2_2= '-'
            	            {
            	            lv_name_2_2=(Token)match(input,23,FOLLOW_20); 

            	            							newLeafNode(lv_name_2_2, grammarAccess.getAdditionOpExpAccess().getNameHyphenMinusKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getAdditionOpExpRule());
            	            							}
            	            							setWithLastConsumed(current, "name", lv_name_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalDOcl.g:1716:4: ( (lv_target_3_0= ruleMultiOpExp ) )
            	    // InternalDOcl.g:1717:5: (lv_target_3_0= ruleMultiOpExp )
            	    {
            	    // InternalDOcl.g:1717:5: (lv_target_3_0= ruleMultiOpExp )
            	    // InternalDOcl.g:1718:6: lv_target_3_0= ruleMultiOpExp
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionOpExpAccess().getTargetMultiOpExpParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_26);
            	    lv_target_3_0=ruleMultiOpExp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditionOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"target",
            	    							lv_target_3_0,
            	    							"fr.inria.diverse.docl.DOcl.MultiOpExp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditionOpExp"


    // $ANTLR start "entryRuleMultiOpExp"
    // InternalDOcl.g:1740:1: entryRuleMultiOpExp returns [EObject current=null] : iv_ruleMultiOpExp= ruleMultiOpExp EOF ;
    public final EObject entryRuleMultiOpExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiOpExp = null;


        try {
            // InternalDOcl.g:1740:51: (iv_ruleMultiOpExp= ruleMultiOpExp EOF )
            // InternalDOcl.g:1741:2: iv_ruleMultiOpExp= ruleMultiOpExp EOF
            {
             newCompositeNode(grammarAccess.getMultiOpExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMultiOpExp=ruleMultiOpExp();

            state._fsp--;

             current =iv_ruleMultiOpExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiOpExp"


    // $ANTLR start "ruleMultiOpExp"
    // InternalDOcl.g:1747:1: ruleMultiOpExp returns [EObject current=null] : (this_NavOpExp_0= ruleNavOpExp ( () ( ( (lv_name_2_1= '*' | lv_name_2_2= '/' ) ) ) ( (lv_target_3_0= ruleNavOpExp ) ) )* ) ;
    public final EObject ruleMultiOpExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_2_1=null;
        Token lv_name_2_2=null;
        EObject this_NavOpExp_0 = null;

        EObject lv_target_3_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1753:2: ( (this_NavOpExp_0= ruleNavOpExp ( () ( ( (lv_name_2_1= '*' | lv_name_2_2= '/' ) ) ) ( (lv_target_3_0= ruleNavOpExp ) ) )* ) )
            // InternalDOcl.g:1754:2: (this_NavOpExp_0= ruleNavOpExp ( () ( ( (lv_name_2_1= '*' | lv_name_2_2= '/' ) ) ) ( (lv_target_3_0= ruleNavOpExp ) ) )* )
            {
            // InternalDOcl.g:1754:2: (this_NavOpExp_0= ruleNavOpExp ( () ( ( (lv_name_2_1= '*' | lv_name_2_2= '/' ) ) ) ( (lv_target_3_0= ruleNavOpExp ) ) )* )
            // InternalDOcl.g:1755:3: this_NavOpExp_0= ruleNavOpExp ( () ( ( (lv_name_2_1= '*' | lv_name_2_2= '/' ) ) ) ( (lv_target_3_0= ruleNavOpExp ) ) )*
            {

            			newCompositeNode(grammarAccess.getMultiOpExpAccess().getNavOpExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_27);
            this_NavOpExp_0=ruleNavOpExp();

            state._fsp--;


            			current = this_NavOpExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDOcl.g:1763:3: ( () ( ( (lv_name_2_1= '*' | lv_name_2_2= '/' ) ) ) ( (lv_target_3_0= ruleNavOpExp ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==17||LA25_0==71) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalDOcl.g:1764:4: () ( ( (lv_name_2_1= '*' | lv_name_2_2= '/' ) ) ) ( (lv_target_3_0= ruleNavOpExp ) )
            	    {
            	    // InternalDOcl.g:1764:4: ()
            	    // InternalDOcl.g:1765:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getMultiOpExpAccess().getMulOpCallExpSourceAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalDOcl.g:1771:4: ( ( (lv_name_2_1= '*' | lv_name_2_2= '/' ) ) )
            	    // InternalDOcl.g:1772:5: ( (lv_name_2_1= '*' | lv_name_2_2= '/' ) )
            	    {
            	    // InternalDOcl.g:1772:5: ( (lv_name_2_1= '*' | lv_name_2_2= '/' ) )
            	    // InternalDOcl.g:1773:6: (lv_name_2_1= '*' | lv_name_2_2= '/' )
            	    {
            	    // InternalDOcl.g:1773:6: (lv_name_2_1= '*' | lv_name_2_2= '/' )
            	    int alt24=2;
            	    int LA24_0 = input.LA(1);

            	    if ( (LA24_0==71) ) {
            	        alt24=1;
            	    }
            	    else if ( (LA24_0==17) ) {
            	        alt24=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 24, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt24) {
            	        case 1 :
            	            // InternalDOcl.g:1774:7: lv_name_2_1= '*'
            	            {
            	            lv_name_2_1=(Token)match(input,71,FOLLOW_20); 

            	            							newLeafNode(lv_name_2_1, grammarAccess.getMultiOpExpAccess().getNameAsteriskKeyword_1_1_0_0());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getMultiOpExpRule());
            	            							}
            	            							setWithLastConsumed(current, "name", lv_name_2_1, null);
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalDOcl.g:1785:7: lv_name_2_2= '/'
            	            {
            	            lv_name_2_2=(Token)match(input,17,FOLLOW_20); 

            	            							newLeafNode(lv_name_2_2, grammarAccess.getMultiOpExpAccess().getNameSolidusKeyword_1_1_0_1());
            	            						

            	            							if (current==null) {
            	            								current = createModelElement(grammarAccess.getMultiOpExpRule());
            	            							}
            	            							setWithLastConsumed(current, "name", lv_name_2_2, null);
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalDOcl.g:1798:4: ( (lv_target_3_0= ruleNavOpExp ) )
            	    // InternalDOcl.g:1799:5: (lv_target_3_0= ruleNavOpExp )
            	    {
            	    // InternalDOcl.g:1799:5: (lv_target_3_0= ruleNavOpExp )
            	    // InternalDOcl.g:1800:6: lv_target_3_0= ruleNavOpExp
            	    {

            	    						newCompositeNode(grammarAccess.getMultiOpExpAccess().getTargetNavOpExpParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_27);
            	    lv_target_3_0=ruleNavOpExp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMultiOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"target",
            	    							lv_target_3_0,
            	    							"fr.inria.diverse.docl.DOcl.NavOpExp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiOpExp"


    // $ANTLR start "entryRuleNavOpExp"
    // InternalDOcl.g:1822:1: entryRuleNavOpExp returns [EObject current=null] : iv_ruleNavOpExp= ruleNavOpExp EOF ;
    public final EObject entryRuleNavOpExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavOpExp = null;


        try {
            // InternalDOcl.g:1822:49: (iv_ruleNavOpExp= ruleNavOpExp EOF )
            // InternalDOcl.g:1823:2: iv_ruleNavOpExp= ruleNavOpExp EOF
            {
             newCompositeNode(grammarAccess.getNavOpExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNavOpExp=ruleNavOpExp();

            state._fsp--;

             current =iv_ruleNavOpExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavOpExp"


    // $ANTLR start "ruleNavOpExp"
    // InternalDOcl.g:1829:1: ruleNavOpExp returns [EObject current=null] : (this_NavigationOpCallExp_0= ruleNavigationOpCallExp ( () ( (lv_name_2_0= ruleNavigationOperator ) ) ( (lv_target_3_0= ruleNavigationOpCallExp ) ) )* ) ;
    public final EObject ruleNavOpExp() throws RecognitionException {
        EObject current = null;

        EObject this_NavigationOpCallExp_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_target_3_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1835:2: ( (this_NavigationOpCallExp_0= ruleNavigationOpCallExp ( () ( (lv_name_2_0= ruleNavigationOperator ) ) ( (lv_target_3_0= ruleNavigationOpCallExp ) ) )* ) )
            // InternalDOcl.g:1836:2: (this_NavigationOpCallExp_0= ruleNavigationOpCallExp ( () ( (lv_name_2_0= ruleNavigationOperator ) ) ( (lv_target_3_0= ruleNavigationOpCallExp ) ) )* )
            {
            // InternalDOcl.g:1836:2: (this_NavigationOpCallExp_0= ruleNavigationOpCallExp ( () ( (lv_name_2_0= ruleNavigationOperator ) ) ( (lv_target_3_0= ruleNavigationOpCallExp ) ) )* )
            // InternalDOcl.g:1837:3: this_NavigationOpCallExp_0= ruleNavigationOpCallExp ( () ( (lv_name_2_0= ruleNavigationOperator ) ) ( (lv_target_3_0= ruleNavigationOpCallExp ) ) )*
            {

            			newCompositeNode(grammarAccess.getNavOpExpAccess().getNavigationOpCallExpParserRuleCall_0());
            		
            pushFollow(FOLLOW_28);
            this_NavigationOpCallExp_0=ruleNavigationOpCallExp();

            state._fsp--;


            			current = this_NavigationOpCallExp_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalDOcl.g:1845:3: ( () ( (lv_name_2_0= ruleNavigationOperator ) ) ( (lv_target_3_0= ruleNavigationOpCallExp ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==18||LA26_0==29) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalDOcl.g:1846:4: () ( (lv_name_2_0= ruleNavigationOperator ) ) ( (lv_target_3_0= ruleNavigationOpCallExp ) )
            	    {
            	    // InternalDOcl.g:1846:4: ()
            	    // InternalDOcl.g:1847:5: 
            	    {

            	    					current = forceCreateModelElementAndSet(
            	    						grammarAccess.getNavOpExpAccess().getNavigationExpSourceAction_1_0(),
            	    						current);
            	    				

            	    }

            	    // InternalDOcl.g:1853:4: ( (lv_name_2_0= ruleNavigationOperator ) )
            	    // InternalDOcl.g:1854:5: (lv_name_2_0= ruleNavigationOperator )
            	    {
            	    // InternalDOcl.g:1854:5: (lv_name_2_0= ruleNavigationOperator )
            	    // InternalDOcl.g:1855:6: lv_name_2_0= ruleNavigationOperator
            	    {

            	    						newCompositeNode(grammarAccess.getNavOpExpAccess().getNameNavigationOperatorParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_20);
            	    lv_name_2_0=ruleNavigationOperator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getNavOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"name",
            	    							lv_name_2_0,
            	    							"fr.inria.diverse.docl.DOcl.NavigationOperator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    // InternalDOcl.g:1872:4: ( (lv_target_3_0= ruleNavigationOpCallExp ) )
            	    // InternalDOcl.g:1873:5: (lv_target_3_0= ruleNavigationOpCallExp )
            	    {
            	    // InternalDOcl.g:1873:5: (lv_target_3_0= ruleNavigationOpCallExp )
            	    // InternalDOcl.g:1874:6: lv_target_3_0= ruleNavigationOpCallExp
            	    {

            	    						newCompositeNode(grammarAccess.getNavOpExpAccess().getTargetNavigationOpCallExpParserRuleCall_1_2_0());
            	    					
            	    pushFollow(FOLLOW_28);
            	    lv_target_3_0=ruleNavigationOpCallExp();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getNavOpExpRule());
            	    						}
            	    						set(
            	    							current,
            	    							"target",
            	    							lv_target_3_0,
            	    							"fr.inria.diverse.docl.DOcl.NavigationOpCallExp");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavOpExp"


    // $ANTLR start "entryRuleNavigationOpCallExp"
    // InternalDOcl.g:1896:1: entryRuleNavigationOpCallExp returns [EObject current=null] : iv_ruleNavigationOpCallExp= ruleNavigationOpCallExp EOF ;
    public final EObject entryRuleNavigationOpCallExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOpCallExp = null;


        try {
            // InternalDOcl.g:1896:60: (iv_ruleNavigationOpCallExp= ruleNavigationOpCallExp EOF )
            // InternalDOcl.g:1897:2: iv_ruleNavigationOpCallExp= ruleNavigationOpCallExp EOF
            {
             newCompositeNode(grammarAccess.getNavigationOpCallExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNavigationOpCallExp=ruleNavigationOpCallExp();

            state._fsp--;

             current =iv_ruleNavigationOpCallExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigationOpCallExp"


    // $ANTLR start "ruleNavigationOpCallExp"
    // InternalDOcl.g:1903:1: ruleNavigationOpCallExp returns [EObject current=null] : (this_OperationCall_0= ruleOperationCall | this_NavigationOrAttributeCall_1= ruleNavigationOrAttributeCall | this_IterateExp_2= ruleIterateExp | this_IteratorExp_3= ruleIteratorExp | this_CollectionOpCall_4= ruleCollectionOpCall | this_PrimaryExp_5= rulePrimaryExp ) ;
    public final EObject ruleNavigationOpCallExp() throws RecognitionException {
        EObject current = null;

        EObject this_OperationCall_0 = null;

        EObject this_NavigationOrAttributeCall_1 = null;

        EObject this_IterateExp_2 = null;

        EObject this_IteratorExp_3 = null;

        EObject this_CollectionOpCall_4 = null;

        EObject this_PrimaryExp_5 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1909:2: ( (this_OperationCall_0= ruleOperationCall | this_NavigationOrAttributeCall_1= ruleNavigationOrAttributeCall | this_IterateExp_2= ruleIterateExp | this_IteratorExp_3= ruleIteratorExp | this_CollectionOpCall_4= ruleCollectionOpCall | this_PrimaryExp_5= rulePrimaryExp ) )
            // InternalDOcl.g:1910:2: (this_OperationCall_0= ruleOperationCall | this_NavigationOrAttributeCall_1= ruleNavigationOrAttributeCall | this_IterateExp_2= ruleIterateExp | this_IteratorExp_3= ruleIteratorExp | this_CollectionOpCall_4= ruleCollectionOpCall | this_PrimaryExp_5= rulePrimaryExp )
            {
            // InternalDOcl.g:1910:2: (this_OperationCall_0= ruleOperationCall | this_NavigationOrAttributeCall_1= ruleNavigationOrAttributeCall | this_IterateExp_2= ruleIterateExp | this_IteratorExp_3= ruleIteratorExp | this_CollectionOpCall_4= ruleCollectionOpCall | this_PrimaryExp_5= rulePrimaryExp )
            int alt27=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 15:
                case 77:
                    {
                    alt27=6;
                    }
                    break;
                case 72:
                    {
                    alt27=1;
                    }
                    break;
                case EOF:
                case 17:
                case 18:
                case 22:
                case 23:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 73:
                case 74:
                case 76:
                case 81:
                case 88:
                case 89:
                case 90:
                case 91:
                    {
                    alt27=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 27, 1, input);

                    throw nvae;
                }

                }
                break;
            case 75:
                {
                alt27=3;
                }
                break;
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
                {
                alt27=4;
                }
                break;
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
            case 53:
                {
                alt27=5;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 71:
            case 72:
            case 79:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 92:
                {
                alt27=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalDOcl.g:1911:3: this_OperationCall_0= ruleOperationCall
                    {

                    			newCompositeNode(grammarAccess.getNavigationOpCallExpAccess().getOperationCallParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_OperationCall_0=ruleOperationCall();

                    state._fsp--;


                    			current = this_OperationCall_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDOcl.g:1920:3: this_NavigationOrAttributeCall_1= ruleNavigationOrAttributeCall
                    {

                    			newCompositeNode(grammarAccess.getNavigationOpCallExpAccess().getNavigationOrAttributeCallParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NavigationOrAttributeCall_1=ruleNavigationOrAttributeCall();

                    state._fsp--;


                    			current = this_NavigationOrAttributeCall_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalDOcl.g:1929:3: this_IterateExp_2= ruleIterateExp
                    {

                    			newCompositeNode(grammarAccess.getNavigationOpCallExpAccess().getIterateExpParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_IterateExp_2=ruleIterateExp();

                    state._fsp--;


                    			current = this_IterateExp_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalDOcl.g:1938:3: this_IteratorExp_3= ruleIteratorExp
                    {

                    			newCompositeNode(grammarAccess.getNavigationOpCallExpAccess().getIteratorExpParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_IteratorExp_3=ruleIteratorExp();

                    state._fsp--;


                    			current = this_IteratorExp_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalDOcl.g:1947:3: this_CollectionOpCall_4= ruleCollectionOpCall
                    {

                    			newCompositeNode(grammarAccess.getNavigationOpCallExpAccess().getCollectionOpCallParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_CollectionOpCall_4=ruleCollectionOpCall();

                    state._fsp--;


                    			current = this_CollectionOpCall_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalDOcl.g:1956:3: this_PrimaryExp_5= rulePrimaryExp
                    {

                    			newCompositeNode(grammarAccess.getNavigationOpCallExpAccess().getPrimaryExpParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimaryExp_5=rulePrimaryExp();

                    state._fsp--;


                    			current = this_PrimaryExp_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigationOpCallExp"


    // $ANTLR start "entryRuleCollectionOpCall"
    // InternalDOcl.g:1968:1: entryRuleCollectionOpCall returns [EObject current=null] : iv_ruleCollectionOpCall= ruleCollectionOpCall EOF ;
    public final EObject entryRuleCollectionOpCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionOpCall = null;


        try {
            // InternalDOcl.g:1968:57: (iv_ruleCollectionOpCall= ruleCollectionOpCall EOF )
            // InternalDOcl.g:1969:2: iv_ruleCollectionOpCall= ruleCollectionOpCall EOF
            {
             newCompositeNode(grammarAccess.getCollectionOpCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCollectionOpCall=ruleCollectionOpCall();

            state._fsp--;

             current =iv_ruleCollectionOpCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionOpCall"


    // $ANTLR start "ruleCollectionOpCall"
    // InternalDOcl.g:1975:1: ruleCollectionOpCall returns [EObject current=null] : ( () ( (lv_name_1_0= ruleCollectionOperationID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleCollectionOpCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:1981:2: ( ( () ( (lv_name_1_0= ruleCollectionOperationID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalDOcl.g:1982:2: ( () ( (lv_name_1_0= ruleCollectionOperationID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalDOcl.g:1982:2: ( () ( (lv_name_1_0= ruleCollectionOperationID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )* )? otherlv_6= ')' )
            // InternalDOcl.g:1983:3: () ( (lv_name_1_0= ruleCollectionOperationID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )* )? otherlv_6= ')'
            {
            // InternalDOcl.g:1983:3: ()
            // InternalDOcl.g:1984:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getCollectionOpCallAccess().getCollectionOpCallExpAction_0(),
            					current);
            			

            }

            // InternalDOcl.g:1990:3: ( (lv_name_1_0= ruleCollectionOperationID ) )
            // InternalDOcl.g:1991:4: (lv_name_1_0= ruleCollectionOperationID )
            {
            // InternalDOcl.g:1991:4: (lv_name_1_0= ruleCollectionOperationID )
            // InternalDOcl.g:1992:5: lv_name_1_0= ruleCollectionOperationID
            {

            					newCompositeNode(grammarAccess.getCollectionOpCallAccess().getNameCollectionOperationIDParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_29);
            lv_name_1_0=ruleCollectionOperationID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCollectionOpCallRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"fr.inria.diverse.docl.DOcl.CollectionOperationID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,72,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getCollectionOpCallAccess().getLeftParenthesisKeyword_2());
            		
            // InternalDOcl.g:2013:3: ( ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID||(LA29_0>=RULE_INT && LA29_0<=RULE_STRING)||(LA29_0>=23 && LA29_0<=24)||(LA29_0>=30 && LA29_0<=62)||(LA29_0>=71 && LA29_0<=72)||LA29_0==75||LA29_0==79||(LA29_0>=82 && LA29_0<=87)||LA29_0==92) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalDOcl.g:2014:4: ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )*
                    {
                    // InternalDOcl.g:2014:4: ( (lv_arguments_3_0= ruleOclExpression ) )
                    // InternalDOcl.g:2015:5: (lv_arguments_3_0= ruleOclExpression )
                    {
                    // InternalDOcl.g:2015:5: (lv_arguments_3_0= ruleOclExpression )
                    // InternalDOcl.g:2016:6: lv_arguments_3_0= ruleOclExpression
                    {

                    						newCompositeNode(grammarAccess.getCollectionOpCallAccess().getArgumentsOclExpressionParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_31);
                    lv_arguments_3_0=ruleOclExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getCollectionOpCallRule());
                    						}
                    						add(
                    							current,
                    							"arguments",
                    							lv_arguments_3_0,
                    							"fr.inria.diverse.docl.DOcl.OclExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalDOcl.g:2033:4: (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==73) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalDOcl.g:2034:5: otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,73,FOLLOW_16); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getCollectionOpCallAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalDOcl.g:2038:5: ( (lv_arguments_5_0= ruleOclExpression ) )
                    	    // InternalDOcl.g:2039:6: (lv_arguments_5_0= ruleOclExpression )
                    	    {
                    	    // InternalDOcl.g:2039:6: (lv_arguments_5_0= ruleOclExpression )
                    	    // InternalDOcl.g:2040:7: lv_arguments_5_0= ruleOclExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getCollectionOpCallAccess().getArgumentsOclExpressionParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_31);
                    	    lv_arguments_5_0=ruleOclExpression();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getCollectionOpCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"arguments",
                    	    								lv_arguments_5_0,
                    	    								"fr.inria.diverse.docl.DOcl.OclExpression");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getCollectionOpCallAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionOpCall"


    // $ANTLR start "entryRuleIterateExp"
    // InternalDOcl.g:2067:1: entryRuleIterateExp returns [EObject current=null] : iv_ruleIterateExp= ruleIterateExp EOF ;
    public final EObject entryRuleIterateExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterateExp = null;


        try {
            // InternalDOcl.g:2067:51: (iv_ruleIterateExp= ruleIterateExp EOF )
            // InternalDOcl.g:2068:2: iv_ruleIterateExp= ruleIterateExp EOF
            {
             newCompositeNode(grammarAccess.getIterateExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIterateExp=ruleIterateExp();

            state._fsp--;

             current =iv_ruleIterateExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIterateExp"


    // $ANTLR start "ruleIterateExp"
    // InternalDOcl.g:2074:1: ruleIterateExp returns [EObject current=null] : ( () ( (lv_name_1_0= 'iterate' ) ) otherlv_2= '(' ( (lv_iterators_3_0= ruleIterator ) ) (otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) ) )* otherlv_6= ';' ( (lv_result_7_0= ruleLocalVariable ) ) otherlv_8= '|' ( (lv_body_9_0= ruleOclExpression ) ) otherlv_10= ')' ) ;
    public final EObject ruleIterateExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_iterators_3_0 = null;

        EObject lv_iterators_5_0 = null;

        EObject lv_result_7_0 = null;

        EObject lv_body_9_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:2080:2: ( ( () ( (lv_name_1_0= 'iterate' ) ) otherlv_2= '(' ( (lv_iterators_3_0= ruleIterator ) ) (otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) ) )* otherlv_6= ';' ( (lv_result_7_0= ruleLocalVariable ) ) otherlv_8= '|' ( (lv_body_9_0= ruleOclExpression ) ) otherlv_10= ')' ) )
            // InternalDOcl.g:2081:2: ( () ( (lv_name_1_0= 'iterate' ) ) otherlv_2= '(' ( (lv_iterators_3_0= ruleIterator ) ) (otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) ) )* otherlv_6= ';' ( (lv_result_7_0= ruleLocalVariable ) ) otherlv_8= '|' ( (lv_body_9_0= ruleOclExpression ) ) otherlv_10= ')' )
            {
            // InternalDOcl.g:2081:2: ( () ( (lv_name_1_0= 'iterate' ) ) otherlv_2= '(' ( (lv_iterators_3_0= ruleIterator ) ) (otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) ) )* otherlv_6= ';' ( (lv_result_7_0= ruleLocalVariable ) ) otherlv_8= '|' ( (lv_body_9_0= ruleOclExpression ) ) otherlv_10= ')' )
            // InternalDOcl.g:2082:3: () ( (lv_name_1_0= 'iterate' ) ) otherlv_2= '(' ( (lv_iterators_3_0= ruleIterator ) ) (otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) ) )* otherlv_6= ';' ( (lv_result_7_0= ruleLocalVariable ) ) otherlv_8= '|' ( (lv_body_9_0= ruleOclExpression ) ) otherlv_10= ')'
            {
            // InternalDOcl.g:2082:3: ()
            // InternalDOcl.g:2083:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIterateExpAccess().getIterateExpAction_0(),
            					current);
            			

            }

            // InternalDOcl.g:2089:3: ( (lv_name_1_0= 'iterate' ) )
            // InternalDOcl.g:2090:4: (lv_name_1_0= 'iterate' )
            {
            // InternalDOcl.g:2090:4: (lv_name_1_0= 'iterate' )
            // InternalDOcl.g:2091:5: lv_name_1_0= 'iterate'
            {
            lv_name_1_0=(Token)match(input,75,FOLLOW_29); 

            					newLeafNode(lv_name_1_0, grammarAccess.getIterateExpAccess().getNameIterateKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIterateExpRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_1_0, "iterate");
            				

            }


            }

            otherlv_2=(Token)match(input,72,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getIterateExpAccess().getLeftParenthesisKeyword_2());
            		
            // InternalDOcl.g:2107:3: ( (lv_iterators_3_0= ruleIterator ) )
            // InternalDOcl.g:2108:4: (lv_iterators_3_0= ruleIterator )
            {
            // InternalDOcl.g:2108:4: (lv_iterators_3_0= ruleIterator )
            // InternalDOcl.g:2109:5: lv_iterators_3_0= ruleIterator
            {

            					newCompositeNode(grammarAccess.getIterateExpAccess().getIteratorsIteratorParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_32);
            lv_iterators_3_0=ruleIterator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIterateExpRule());
            					}
            					add(
            						current,
            						"iterators",
            						lv_iterators_3_0,
            						"fr.inria.diverse.docl.DOcl.Iterator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDOcl.g:2126:3: (otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==73) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalDOcl.g:2127:4: otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) )
            	    {
            	    otherlv_4=(Token)match(input,73,FOLLOW_3); 

            	    				newLeafNode(otherlv_4, grammarAccess.getIterateExpAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalDOcl.g:2131:4: ( (lv_iterators_5_0= ruleIterator ) )
            	    // InternalDOcl.g:2132:5: (lv_iterators_5_0= ruleIterator )
            	    {
            	    // InternalDOcl.g:2132:5: (lv_iterators_5_0= ruleIterator )
            	    // InternalDOcl.g:2133:6: lv_iterators_5_0= ruleIterator
            	    {

            	    						newCompositeNode(grammarAccess.getIterateExpAccess().getIteratorsIteratorParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_32);
            	    lv_iterators_5_0=ruleIterator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIterateExpRule());
            	    						}
            	    						add(
            	    							current,
            	    							"iterators",
            	    							lv_iterators_5_0,
            	    							"fr.inria.diverse.docl.DOcl.Iterator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            otherlv_6=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getIterateExpAccess().getSemicolonKeyword_5());
            		
            // InternalDOcl.g:2155:3: ( (lv_result_7_0= ruleLocalVariable ) )
            // InternalDOcl.g:2156:4: (lv_result_7_0= ruleLocalVariable )
            {
            // InternalDOcl.g:2156:4: (lv_result_7_0= ruleLocalVariable )
            // InternalDOcl.g:2157:5: lv_result_7_0= ruleLocalVariable
            {

            					newCompositeNode(grammarAccess.getIterateExpAccess().getResultLocalVariableParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_33);
            lv_result_7_0=ruleLocalVariable();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIterateExpRule());
            					}
            					set(
            						current,
            						"result",
            						lv_result_7_0,
            						"fr.inria.diverse.docl.DOcl.LocalVariable");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,76,FOLLOW_16); 

            			newLeafNode(otherlv_8, grammarAccess.getIterateExpAccess().getVerticalLineKeyword_7());
            		
            // InternalDOcl.g:2178:3: ( (lv_body_9_0= ruleOclExpression ) )
            // InternalDOcl.g:2179:4: (lv_body_9_0= ruleOclExpression )
            {
            // InternalDOcl.g:2179:4: (lv_body_9_0= ruleOclExpression )
            // InternalDOcl.g:2180:5: lv_body_9_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getIterateExpAccess().getBodyOclExpressionParserRuleCall_8_0());
            				
            pushFollow(FOLLOW_34);
            lv_body_9_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIterateExpRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_9_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_10=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getIterateExpAccess().getRightParenthesisKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIterateExp"


    // $ANTLR start "entryRuleIterator"
    // InternalDOcl.g:2205:1: entryRuleIterator returns [EObject current=null] : iv_ruleIterator= ruleIterator EOF ;
    public final EObject entryRuleIterator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIterator = null;


        try {
            // InternalDOcl.g:2205:49: (iv_ruleIterator= ruleIterator EOF )
            // InternalDOcl.g:2206:2: iv_ruleIterator= ruleIterator EOF
            {
             newCompositeNode(grammarAccess.getIteratorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIterator=ruleIterator();

            state._fsp--;

             current =iv_ruleIterator; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIterator"


    // $ANTLR start "ruleIterator"
    // InternalDOcl.g:2212:1: ruleIterator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) )? ) ;
    public final EObject ruleIterator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:2218:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) )? ) )
            // InternalDOcl.g:2219:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) )? )
            {
            // InternalDOcl.g:2219:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) )? )
            // InternalDOcl.g:2220:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) )?
            {
            // InternalDOcl.g:2220:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDOcl.g:2221:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDOcl.g:2221:4: (lv_name_0_0= RULE_ID )
            // InternalDOcl.g:2222:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_35); 

            					newLeafNode(lv_name_0_0, grammarAccess.getIteratorAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIteratorRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDOcl.g:2238:3: (otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==19) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalDOcl.g:2239:4: otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_36); 

                    				newLeafNode(otherlv_1, grammarAccess.getIteratorAccess().getColonKeyword_1_0());
                    			
                    // InternalDOcl.g:2243:4: ( (lv_type_2_0= ruleOclType ) )
                    // InternalDOcl.g:2244:5: (lv_type_2_0= ruleOclType )
                    {
                    // InternalDOcl.g:2244:5: (lv_type_2_0= ruleOclType )
                    // InternalDOcl.g:2245:6: lv_type_2_0= ruleOclType
                    {

                    						newCompositeNode(grammarAccess.getIteratorAccess().getTypeOclTypeParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_type_2_0=ruleOclType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIteratorRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_2_0,
                    							"fr.inria.diverse.docl.DOcl.OclType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIterator"


    // $ANTLR start "entryRuleIteratorExp"
    // InternalDOcl.g:2267:1: entryRuleIteratorExp returns [EObject current=null] : iv_ruleIteratorExp= ruleIteratorExp EOF ;
    public final EObject entryRuleIteratorExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIteratorExp = null;


        try {
            // InternalDOcl.g:2267:52: (iv_ruleIteratorExp= ruleIteratorExp EOF )
            // InternalDOcl.g:2268:2: iv_ruleIteratorExp= ruleIteratorExp EOF
            {
             newCompositeNode(grammarAccess.getIteratorExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIteratorExp=ruleIteratorExp();

            state._fsp--;

             current =iv_ruleIteratorExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIteratorExp"


    // $ANTLR start "ruleIteratorExp"
    // InternalDOcl.g:2274:1: ruleIteratorExp returns [EObject current=null] : ( () ( (lv_name_1_0= ruleIterativeOperationID ) ) otherlv_2= '(' ( (lv_iterators_3_0= ruleIterator ) ) (otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) ) )* otherlv_6= '|' ( (lv_body_7_0= ruleOclExpression ) ) otherlv_8= ')' ) ;
    public final EObject ruleIteratorExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_iterators_3_0 = null;

        EObject lv_iterators_5_0 = null;

        EObject lv_body_7_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:2280:2: ( ( () ( (lv_name_1_0= ruleIterativeOperationID ) ) otherlv_2= '(' ( (lv_iterators_3_0= ruleIterator ) ) (otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) ) )* otherlv_6= '|' ( (lv_body_7_0= ruleOclExpression ) ) otherlv_8= ')' ) )
            // InternalDOcl.g:2281:2: ( () ( (lv_name_1_0= ruleIterativeOperationID ) ) otherlv_2= '(' ( (lv_iterators_3_0= ruleIterator ) ) (otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) ) )* otherlv_6= '|' ( (lv_body_7_0= ruleOclExpression ) ) otherlv_8= ')' )
            {
            // InternalDOcl.g:2281:2: ( () ( (lv_name_1_0= ruleIterativeOperationID ) ) otherlv_2= '(' ( (lv_iterators_3_0= ruleIterator ) ) (otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) ) )* otherlv_6= '|' ( (lv_body_7_0= ruleOclExpression ) ) otherlv_8= ')' )
            // InternalDOcl.g:2282:3: () ( (lv_name_1_0= ruleIterativeOperationID ) ) otherlv_2= '(' ( (lv_iterators_3_0= ruleIterator ) ) (otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) ) )* otherlv_6= '|' ( (lv_body_7_0= ruleOclExpression ) ) otherlv_8= ')'
            {
            // InternalDOcl.g:2282:3: ()
            // InternalDOcl.g:2283:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIteratorExpAccess().getIteratorExpAction_0(),
            					current);
            			

            }

            // InternalDOcl.g:2289:3: ( (lv_name_1_0= ruleIterativeOperationID ) )
            // InternalDOcl.g:2290:4: (lv_name_1_0= ruleIterativeOperationID )
            {
            // InternalDOcl.g:2290:4: (lv_name_1_0= ruleIterativeOperationID )
            // InternalDOcl.g:2291:5: lv_name_1_0= ruleIterativeOperationID
            {

            					newCompositeNode(grammarAccess.getIteratorExpAccess().getNameIterativeOperationIDParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_29);
            lv_name_1_0=ruleIterativeOperationID();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIteratorExpRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"fr.inria.diverse.docl.DOcl.IterativeOperationID");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,72,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getIteratorExpAccess().getLeftParenthesisKeyword_2());
            		
            // InternalDOcl.g:2312:3: ( (lv_iterators_3_0= ruleIterator ) )
            // InternalDOcl.g:2313:4: (lv_iterators_3_0= ruleIterator )
            {
            // InternalDOcl.g:2313:4: (lv_iterators_3_0= ruleIterator )
            // InternalDOcl.g:2314:5: lv_iterators_3_0= ruleIterator
            {

            					newCompositeNode(grammarAccess.getIteratorExpAccess().getIteratorsIteratorParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_37);
            lv_iterators_3_0=ruleIterator();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIteratorExpRule());
            					}
            					add(
            						current,
            						"iterators",
            						lv_iterators_3_0,
            						"fr.inria.diverse.docl.DOcl.Iterator");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDOcl.g:2331:3: (otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==73) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalDOcl.g:2332:4: otherlv_4= ',' ( (lv_iterators_5_0= ruleIterator ) )
            	    {
            	    otherlv_4=(Token)match(input,73,FOLLOW_3); 

            	    				newLeafNode(otherlv_4, grammarAccess.getIteratorExpAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalDOcl.g:2336:4: ( (lv_iterators_5_0= ruleIterator ) )
            	    // InternalDOcl.g:2337:5: (lv_iterators_5_0= ruleIterator )
            	    {
            	    // InternalDOcl.g:2337:5: (lv_iterators_5_0= ruleIterator )
            	    // InternalDOcl.g:2338:6: lv_iterators_5_0= ruleIterator
            	    {

            	    						newCompositeNode(grammarAccess.getIteratorExpAccess().getIteratorsIteratorParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_37);
            	    lv_iterators_5_0=ruleIterator();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getIteratorExpRule());
            	    						}
            	    						add(
            	    							current,
            	    							"iterators",
            	    							lv_iterators_5_0,
            	    							"fr.inria.diverse.docl.DOcl.Iterator");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_6=(Token)match(input,76,FOLLOW_16); 

            			newLeafNode(otherlv_6, grammarAccess.getIteratorExpAccess().getVerticalLineKeyword_5());
            		
            // InternalDOcl.g:2360:3: ( (lv_body_7_0= ruleOclExpression ) )
            // InternalDOcl.g:2361:4: (lv_body_7_0= ruleOclExpression )
            {
            // InternalDOcl.g:2361:4: (lv_body_7_0= ruleOclExpression )
            // InternalDOcl.g:2362:5: lv_body_7_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getIteratorExpAccess().getBodyOclExpressionParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_34);
            lv_body_7_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIteratorExpRule());
            					}
            					set(
            						current,
            						"body",
            						lv_body_7_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getIteratorExpAccess().getRightParenthesisKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIteratorExp"


    // $ANTLR start "entryRuleNavigationOrAttributeCall"
    // InternalDOcl.g:2387:1: entryRuleNavigationOrAttributeCall returns [EObject current=null] : iv_ruleNavigationOrAttributeCall= ruleNavigationOrAttributeCall EOF ;
    public final EObject entryRuleNavigationOrAttributeCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOrAttributeCall = null;


        try {
            // InternalDOcl.g:2387:66: (iv_ruleNavigationOrAttributeCall= ruleNavigationOrAttributeCall EOF )
            // InternalDOcl.g:2388:2: iv_ruleNavigationOrAttributeCall= ruleNavigationOrAttributeCall EOF
            {
             newCompositeNode(grammarAccess.getNavigationOrAttributeCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNavigationOrAttributeCall=ruleNavigationOrAttributeCall();

            state._fsp--;

             current =iv_ruleNavigationOrAttributeCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNavigationOrAttributeCall"


    // $ANTLR start "ruleNavigationOrAttributeCall"
    // InternalDOcl.g:2394:1: ruleNavigationOrAttributeCall returns [EObject current=null] : ( () ( (lv_feature_1_0= RULE_ID ) ) ) ;
    public final EObject ruleNavigationOrAttributeCall() throws RecognitionException {
        EObject current = null;

        Token lv_feature_1_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:2400:2: ( ( () ( (lv_feature_1_0= RULE_ID ) ) ) )
            // InternalDOcl.g:2401:2: ( () ( (lv_feature_1_0= RULE_ID ) ) )
            {
            // InternalDOcl.g:2401:2: ( () ( (lv_feature_1_0= RULE_ID ) ) )
            // InternalDOcl.g:2402:3: () ( (lv_feature_1_0= RULE_ID ) )
            {
            // InternalDOcl.g:2402:3: ()
            // InternalDOcl.g:2403:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNavigationOrAttributeCallAccess().getNavigationOrAttributeCallAction_0(),
            					current);
            			

            }

            // InternalDOcl.g:2409:3: ( (lv_feature_1_0= RULE_ID ) )
            // InternalDOcl.g:2410:4: (lv_feature_1_0= RULE_ID )
            {
            // InternalDOcl.g:2410:4: (lv_feature_1_0= RULE_ID )
            // InternalDOcl.g:2411:5: lv_feature_1_0= RULE_ID
            {
            lv_feature_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_feature_1_0, grammarAccess.getNavigationOrAttributeCallAccess().getFeatureIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getNavigationOrAttributeCallRule());
            					}
            					setWithLastConsumed(
            						current,
            						"feature",
            						lv_feature_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNavigationOrAttributeCall"


    // $ANTLR start "entryRuleOperationCall"
    // InternalDOcl.g:2431:1: entryRuleOperationCall returns [EObject current=null] : iv_ruleOperationCall= ruleOperationCall EOF ;
    public final EObject entryRuleOperationCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCall = null;


        try {
            // InternalDOcl.g:2431:54: (iv_ruleOperationCall= ruleOperationCall EOF )
            // InternalDOcl.g:2432:2: iv_ruleOperationCall= ruleOperationCall EOF
            {
             newCompositeNode(grammarAccess.getOperationCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationCall=ruleOperationCall();

            state._fsp--;

             current =iv_ruleOperationCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationCall"


    // $ANTLR start "ruleOperationCall"
    // InternalDOcl.g:2438:1: ruleOperationCall returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )* )? otherlv_6= ')' ) ;
    public final EObject ruleOperationCall() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_arguments_3_0 = null;

        EObject lv_arguments_5_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:2444:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )* )? otherlv_6= ')' ) )
            // InternalDOcl.g:2445:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )* )? otherlv_6= ')' )
            {
            // InternalDOcl.g:2445:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )* )? otherlv_6= ')' )
            // InternalDOcl.g:2446:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )* )? otherlv_6= ')'
            {
            // InternalDOcl.g:2446:3: ()
            // InternalDOcl.g:2447:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOperationCallAccess().getOperationCallAction_0(),
            					current);
            			

            }

            // InternalDOcl.g:2453:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalDOcl.g:2454:4: (lv_name_1_0= RULE_ID )
            {
            // InternalDOcl.g:2454:4: (lv_name_1_0= RULE_ID )
            // InternalDOcl.g:2455:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_29); 

            					newLeafNode(lv_name_1_0, grammarAccess.getOperationCallAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperationCallRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,72,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getOperationCallAccess().getLeftParenthesisKeyword_2());
            		
            // InternalDOcl.g:2475:3: ( ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )* )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID||(LA34_0>=RULE_INT && LA34_0<=RULE_STRING)||(LA34_0>=23 && LA34_0<=24)||(LA34_0>=30 && LA34_0<=62)||(LA34_0>=71 && LA34_0<=72)||LA34_0==75||LA34_0==79||(LA34_0>=82 && LA34_0<=87)||LA34_0==92) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalDOcl.g:2476:4: ( (lv_arguments_3_0= ruleOclExpression ) ) (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )*
                    {
                    // InternalDOcl.g:2476:4: ( (lv_arguments_3_0= ruleOclExpression ) )
                    // InternalDOcl.g:2477:5: (lv_arguments_3_0= ruleOclExpression )
                    {
                    // InternalDOcl.g:2477:5: (lv_arguments_3_0= ruleOclExpression )
                    // InternalDOcl.g:2478:6: lv_arguments_3_0= ruleOclExpression
                    {

                    						newCompositeNode(grammarAccess.getOperationCallAccess().getArgumentsOclExpressionParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_31);
                    lv_arguments_3_0=ruleOclExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOperationCallRule());
                    						}
                    						add(
                    							current,
                    							"arguments",
                    							lv_arguments_3_0,
                    							"fr.inria.diverse.docl.DOcl.OclExpression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalDOcl.g:2495:4: (otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) ) )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==73) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // InternalDOcl.g:2496:5: otherlv_4= ',' ( (lv_arguments_5_0= ruleOclExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,73,FOLLOW_16); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getOperationCallAccess().getCommaKeyword_3_1_0());
                    	    				
                    	    // InternalDOcl.g:2500:5: ( (lv_arguments_5_0= ruleOclExpression ) )
                    	    // InternalDOcl.g:2501:6: (lv_arguments_5_0= ruleOclExpression )
                    	    {
                    	    // InternalDOcl.g:2501:6: (lv_arguments_5_0= ruleOclExpression )
                    	    // InternalDOcl.g:2502:7: lv_arguments_5_0= ruleOclExpression
                    	    {

                    	    							newCompositeNode(grammarAccess.getOperationCallAccess().getArgumentsOclExpressionParserRuleCall_3_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_31);
                    	    lv_arguments_5_0=ruleOclExpression();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getOperationCallRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"arguments",
                    	    								lv_arguments_5_0,
                    	    								"fr.inria.diverse.docl.DOcl.OclExpression");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getOperationCallAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationCall"


    // $ANTLR start "entryRuleOclModelElementExp"
    // InternalDOcl.g:2529:1: entryRuleOclModelElementExp returns [EObject current=null] : iv_ruleOclModelElementExp= ruleOclModelElementExp EOF ;
    public final EObject entryRuleOclModelElementExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclModelElementExp = null;


        try {
            // InternalDOcl.g:2529:59: (iv_ruleOclModelElementExp= ruleOclModelElementExp EOF )
            // InternalDOcl.g:2530:2: iv_ruleOclModelElementExp= ruleOclModelElementExp EOF
            {
             newCompositeNode(grammarAccess.getOclModelElementExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOclModelElementExp=ruleOclModelElementExp();

            state._fsp--;

             current =iv_ruleOclModelElementExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOclModelElementExp"


    // $ANTLR start "ruleOclModelElementExp"
    // InternalDOcl.g:2536:1: ruleOclModelElementExp returns [EObject current=null] : ( ( (lv_model_0_0= ruleOclModel ) ) ( (lv_name_1_0= '::' ) ) ( (lv_elements_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_elements_4_0= RULE_ID ) ) )* ( (lv_target_5_0= ruleAllInstancesOpCall ) )? ) ;
    public final EObject ruleOclModelElementExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_elements_2_0=null;
        Token otherlv_3=null;
        Token lv_elements_4_0=null;
        EObject lv_model_0_0 = null;

        EObject lv_target_5_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:2542:2: ( ( ( (lv_model_0_0= ruleOclModel ) ) ( (lv_name_1_0= '::' ) ) ( (lv_elements_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_elements_4_0= RULE_ID ) ) )* ( (lv_target_5_0= ruleAllInstancesOpCall ) )? ) )
            // InternalDOcl.g:2543:2: ( ( (lv_model_0_0= ruleOclModel ) ) ( (lv_name_1_0= '::' ) ) ( (lv_elements_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_elements_4_0= RULE_ID ) ) )* ( (lv_target_5_0= ruleAllInstancesOpCall ) )? )
            {
            // InternalDOcl.g:2543:2: ( ( (lv_model_0_0= ruleOclModel ) ) ( (lv_name_1_0= '::' ) ) ( (lv_elements_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_elements_4_0= RULE_ID ) ) )* ( (lv_target_5_0= ruleAllInstancesOpCall ) )? )
            // InternalDOcl.g:2544:3: ( (lv_model_0_0= ruleOclModel ) ) ( (lv_name_1_0= '::' ) ) ( (lv_elements_2_0= RULE_ID ) ) (otherlv_3= '::' ( (lv_elements_4_0= RULE_ID ) ) )* ( (lv_target_5_0= ruleAllInstancesOpCall ) )?
            {
            // InternalDOcl.g:2544:3: ( (lv_model_0_0= ruleOclModel ) )
            // InternalDOcl.g:2545:4: (lv_model_0_0= ruleOclModel )
            {
            // InternalDOcl.g:2545:4: (lv_model_0_0= ruleOclModel )
            // InternalDOcl.g:2546:5: lv_model_0_0= ruleOclModel
            {

            					newCompositeNode(grammarAccess.getOclModelElementExpAccess().getModelOclModelParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_38);
            lv_model_0_0=ruleOclModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOclModelElementExpRule());
            					}
            					set(
            						current,
            						"model",
            						lv_model_0_0,
            						"fr.inria.diverse.docl.DOcl.OclModel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDOcl.g:2563:3: ( (lv_name_1_0= '::' ) )
            // InternalDOcl.g:2564:4: (lv_name_1_0= '::' )
            {
            // InternalDOcl.g:2564:4: (lv_name_1_0= '::' )
            // InternalDOcl.g:2565:5: lv_name_1_0= '::'
            {
            lv_name_1_0=(Token)match(input,77,FOLLOW_3); 

            					newLeafNode(lv_name_1_0, grammarAccess.getOclModelElementExpAccess().getNameColonColonKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOclModelElementExpRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_1_0, "::");
            				

            }


            }

            // InternalDOcl.g:2577:3: ( (lv_elements_2_0= RULE_ID ) )
            // InternalDOcl.g:2578:4: (lv_elements_2_0= RULE_ID )
            {
            // InternalDOcl.g:2578:4: (lv_elements_2_0= RULE_ID )
            // InternalDOcl.g:2579:5: lv_elements_2_0= RULE_ID
            {
            lv_elements_2_0=(Token)match(input,RULE_ID,FOLLOW_39); 

            					newLeafNode(lv_elements_2_0, grammarAccess.getOclModelElementExpAccess().getElementsIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOclModelElementExpRule());
            					}
            					addWithLastConsumed(
            						current,
            						"elements",
            						lv_elements_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalDOcl.g:2595:3: (otherlv_3= '::' ( (lv_elements_4_0= RULE_ID ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==77) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalDOcl.g:2596:4: otherlv_3= '::' ( (lv_elements_4_0= RULE_ID ) )
            	    {
            	    otherlv_3=(Token)match(input,77,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOclModelElementExpAccess().getColonColonKeyword_3_0());
            	    			
            	    // InternalDOcl.g:2600:4: ( (lv_elements_4_0= RULE_ID ) )
            	    // InternalDOcl.g:2601:5: (lv_elements_4_0= RULE_ID )
            	    {
            	    // InternalDOcl.g:2601:5: (lv_elements_4_0= RULE_ID )
            	    // InternalDOcl.g:2602:6: lv_elements_4_0= RULE_ID
            	    {
            	    lv_elements_4_0=(Token)match(input,RULE_ID,FOLLOW_39); 

            	    						newLeafNode(lv_elements_4_0, grammarAccess.getOclModelElementExpAccess().getElementsIDTerminalRuleCall_3_1_0());
            	    					

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getOclModelElementExpRule());
            	    						}
            	    						addWithLastConsumed(
            	    							current,
            	    							"elements",
            	    							lv_elements_4_0,
            	    							"org.eclipse.xtext.common.Terminals.ID");
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            // InternalDOcl.g:2619:3: ( (lv_target_5_0= ruleAllInstancesOpCall ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==18) ) {
                int LA36_1 = input.LA(2);

                if ( (LA36_1==78) ) {
                    alt36=1;
                }
            }
            switch (alt36) {
                case 1 :
                    // InternalDOcl.g:2620:4: (lv_target_5_0= ruleAllInstancesOpCall )
                    {
                    // InternalDOcl.g:2620:4: (lv_target_5_0= ruleAllInstancesOpCall )
                    // InternalDOcl.g:2621:5: lv_target_5_0= ruleAllInstancesOpCall
                    {

                    					newCompositeNode(grammarAccess.getOclModelElementExpAccess().getTargetAllInstancesOpCallParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_target_5_0=ruleAllInstancesOpCall();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOclModelElementExpRule());
                    					}
                    					set(
                    						current,
                    						"target",
                    						lv_target_5_0,
                    						"fr.inria.diverse.docl.DOcl.AllInstancesOpCall");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOclModelElementExp"


    // $ANTLR start "entryRuleAllInstancesOpCall"
    // InternalDOcl.g:2642:1: entryRuleAllInstancesOpCall returns [EObject current=null] : iv_ruleAllInstancesOpCall= ruleAllInstancesOpCall EOF ;
    public final EObject entryRuleAllInstancesOpCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAllInstancesOpCall = null;


        try {
            // InternalDOcl.g:2642:59: (iv_ruleAllInstancesOpCall= ruleAllInstancesOpCall EOF )
            // InternalDOcl.g:2643:2: iv_ruleAllInstancesOpCall= ruleAllInstancesOpCall EOF
            {
             newCompositeNode(grammarAccess.getAllInstancesOpCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAllInstancesOpCall=ruleAllInstancesOpCall();

            state._fsp--;

             current =iv_ruleAllInstancesOpCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAllInstancesOpCall"


    // $ANTLR start "ruleAllInstancesOpCall"
    // InternalDOcl.g:2649:1: ruleAllInstancesOpCall returns [EObject current=null] : ( () otherlv_1= '.' ( (lv_name_2_0= 'allInstances' ) ) otherlv_3= '(' otherlv_4= ')' ) ;
    public final EObject ruleAllInstancesOpCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalDOcl.g:2655:2: ( ( () otherlv_1= '.' ( (lv_name_2_0= 'allInstances' ) ) otherlv_3= '(' otherlv_4= ')' ) )
            // InternalDOcl.g:2656:2: ( () otherlv_1= '.' ( (lv_name_2_0= 'allInstances' ) ) otherlv_3= '(' otherlv_4= ')' )
            {
            // InternalDOcl.g:2656:2: ( () otherlv_1= '.' ( (lv_name_2_0= 'allInstances' ) ) otherlv_3= '(' otherlv_4= ')' )
            // InternalDOcl.g:2657:3: () otherlv_1= '.' ( (lv_name_2_0= 'allInstances' ) ) otherlv_3= '(' otherlv_4= ')'
            {
            // InternalDOcl.g:2657:3: ()
            // InternalDOcl.g:2658:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getAllInstancesOpCallAccess().getOperationCallAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getAllInstancesOpCallAccess().getFullStopKeyword_1());
            		
            // InternalDOcl.g:2668:3: ( (lv_name_2_0= 'allInstances' ) )
            // InternalDOcl.g:2669:4: (lv_name_2_0= 'allInstances' )
            {
            // InternalDOcl.g:2669:4: (lv_name_2_0= 'allInstances' )
            // InternalDOcl.g:2670:5: lv_name_2_0= 'allInstances'
            {
            lv_name_2_0=(Token)match(input,78,FOLLOW_29); 

            					newLeafNode(lv_name_2_0, grammarAccess.getAllInstancesOpCallAccess().getNameAllInstancesKeyword_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAllInstancesOpCallRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_2_0, "allInstances");
            				

            }


            }

            otherlv_3=(Token)match(input,72,FOLLOW_34); 

            			newLeafNode(otherlv_3, grammarAccess.getAllInstancesOpCallAccess().getLeftParenthesisKeyword_3());
            		
            otherlv_4=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getAllInstancesOpCallAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAllInstancesOpCall"


    // $ANTLR start "entryRuleLocalVariable"
    // InternalDOcl.g:2694:1: entryRuleLocalVariable returns [EObject current=null] : iv_ruleLocalVariable= ruleLocalVariable EOF ;
    public final EObject entryRuleLocalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLocalVariable = null;


        try {
            // InternalDOcl.g:2694:54: (iv_ruleLocalVariable= ruleLocalVariable EOF )
            // InternalDOcl.g:2695:2: iv_ruleLocalVariable= ruleLocalVariable EOF
            {
             newCompositeNode(grammarAccess.getLocalVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLocalVariable=ruleLocalVariable();

            state._fsp--;

             current =iv_ruleLocalVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLocalVariable"


    // $ANTLR start "ruleLocalVariable"
    // InternalDOcl.g:2701:1: ruleLocalVariable returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) otherlv_3= '=' ( (lv_initExp_4_0= ruleOclExpression ) ) ) ;
    public final EObject ruleLocalVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_initExp_4_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:2707:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) otherlv_3= '=' ( (lv_initExp_4_0= ruleOclExpression ) ) ) )
            // InternalDOcl.g:2708:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) otherlv_3= '=' ( (lv_initExp_4_0= ruleOclExpression ) ) )
            {
            // InternalDOcl.g:2708:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) otherlv_3= '=' ( (lv_initExp_4_0= ruleOclExpression ) ) )
            // InternalDOcl.g:2709:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) otherlv_3= '=' ( (lv_initExp_4_0= ruleOclExpression ) )
            {
            // InternalDOcl.g:2709:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalDOcl.g:2710:4: (lv_name_0_0= RULE_ID )
            {
            // InternalDOcl.g:2710:4: (lv_name_0_0= RULE_ID )
            // InternalDOcl.g:2711:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_name_0_0, grammarAccess.getLocalVariableAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLocalVariableRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,19,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getLocalVariableAccess().getColonKeyword_1());
            		
            // InternalDOcl.g:2731:3: ( (lv_type_2_0= ruleOclType ) )
            // InternalDOcl.g:2732:4: (lv_type_2_0= ruleOclType )
            {
            // InternalDOcl.g:2732:4: (lv_type_2_0= ruleOclType )
            // InternalDOcl.g:2733:5: lv_type_2_0= ruleOclType
            {

            					newCompositeNode(grammarAccess.getLocalVariableAccess().getTypeOclTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_41);
            lv_type_2_0=ruleOclType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocalVariableRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_2_0,
            						"fr.inria.diverse.docl.DOcl.OclType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,65,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getLocalVariableAccess().getEqualsSignKeyword_3());
            		
            // InternalDOcl.g:2754:3: ( (lv_initExp_4_0= ruleOclExpression ) )
            // InternalDOcl.g:2755:4: (lv_initExp_4_0= ruleOclExpression )
            {
            // InternalDOcl.g:2755:4: (lv_initExp_4_0= ruleOclExpression )
            // InternalDOcl.g:2756:5: lv_initExp_4_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getLocalVariableAccess().getInitExpOclExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_initExp_4_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLocalVariableRule());
            					}
            					set(
            						current,
            						"initExp",
            						lv_initExp_4_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLocalVariable"


    // $ANTLR start "entryRulePrimaryExp"
    // InternalDOcl.g:2777:1: entryRulePrimaryExp returns [EObject current=null] : iv_rulePrimaryExp= rulePrimaryExp EOF ;
    public final EObject entryRulePrimaryExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExp = null;


        try {
            // InternalDOcl.g:2777:51: (iv_rulePrimaryExp= rulePrimaryExp EOF )
            // InternalDOcl.g:2778:2: iv_rulePrimaryExp= rulePrimaryExp EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExp=rulePrimaryExp();

            state._fsp--;

             current =iv_rulePrimaryExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExp"


    // $ANTLR start "rulePrimaryExp"
    // InternalDOcl.g:2784:1: rulePrimaryExp returns [EObject current=null] : (this_SeflExp_0= ruleSeflExp | this_NestedExp_1= ruleNestedExp | this_IfExp_2= ruleIfExp | this_PrimitiveExp_3= rulePrimitiveExp | this_TupleExp_4= ruleTupleExp | this_LambdaExp_5= ruleLambdaExp | this_OclModelElementExp_6= ruleOclModelElementExp ) ;
    public final EObject rulePrimaryExp() throws RecognitionException {
        EObject current = null;

        EObject this_SeflExp_0 = null;

        EObject this_NestedExp_1 = null;

        EObject this_IfExp_2 = null;

        EObject this_PrimitiveExp_3 = null;

        EObject this_TupleExp_4 = null;

        EObject this_LambdaExp_5 = null;

        EObject this_OclModelElementExp_6 = null;



        	enterRule();

        try {
            // InternalDOcl.g:2790:2: ( (this_SeflExp_0= ruleSeflExp | this_NestedExp_1= ruleNestedExp | this_IfExp_2= ruleIfExp | this_PrimitiveExp_3= rulePrimitiveExp | this_TupleExp_4= ruleTupleExp | this_LambdaExp_5= ruleLambdaExp | this_OclModelElementExp_6= ruleOclModelElementExp ) )
            // InternalDOcl.g:2791:2: (this_SeflExp_0= ruleSeflExp | this_NestedExp_1= ruleNestedExp | this_IfExp_2= ruleIfExp | this_PrimitiveExp_3= rulePrimitiveExp | this_TupleExp_4= ruleTupleExp | this_LambdaExp_5= ruleLambdaExp | this_OclModelElementExp_6= ruleOclModelElementExp )
            {
            // InternalDOcl.g:2791:2: (this_SeflExp_0= ruleSeflExp | this_NestedExp_1= ruleNestedExp | this_IfExp_2= ruleIfExp | this_PrimitiveExp_3= rulePrimitiveExp | this_TupleExp_4= ruleTupleExp | this_LambdaExp_5= ruleLambdaExp | this_OclModelElementExp_6= ruleOclModelElementExp )
            int alt37=7;
            switch ( input.LA(1) ) {
            case 92:
                {
                alt37=1;
                }
                break;
            case 72:
                {
                alt37=2;
                }
                break;
            case 87:
                {
                alt37=3;
                }
                break;
            case RULE_INT:
            case RULE_STRING:
            case 71:
            case 83:
            case 84:
            case 85:
            case 86:
                {
                alt37=4;
                }
                break;
            case 82:
                {
                alt37=5;
                }
                break;
            case 79:
                {
                alt37=6;
                }
                break;
            case RULE_ID:
                {
                alt37=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalDOcl.g:2792:3: this_SeflExp_0= ruleSeflExp
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpAccess().getSeflExpParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_SeflExp_0=ruleSeflExp();

                    state._fsp--;


                    			current = this_SeflExp_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDOcl.g:2801:3: this_NestedExp_1= ruleNestedExp
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpAccess().getNestedExpParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_NestedExp_1=ruleNestedExp();

                    state._fsp--;


                    			current = this_NestedExp_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalDOcl.g:2810:3: this_IfExp_2= ruleIfExp
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpAccess().getIfExpParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_IfExp_2=ruleIfExp();

                    state._fsp--;


                    			current = this_IfExp_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalDOcl.g:2819:3: this_PrimitiveExp_3= rulePrimitiveExp
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpAccess().getPrimitiveExpParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_PrimitiveExp_3=rulePrimitiveExp();

                    state._fsp--;


                    			current = this_PrimitiveExp_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalDOcl.g:2828:3: this_TupleExp_4= ruleTupleExp
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpAccess().getTupleExpParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_TupleExp_4=ruleTupleExp();

                    state._fsp--;


                    			current = this_TupleExp_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalDOcl.g:2837:3: this_LambdaExp_5= ruleLambdaExp
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpAccess().getLambdaExpParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_LambdaExp_5=ruleLambdaExp();

                    state._fsp--;


                    			current = this_LambdaExp_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalDOcl.g:2846:3: this_OclModelElementExp_6= ruleOclModelElementExp
                    {

                    			newCompositeNode(grammarAccess.getPrimaryExpAccess().getOclModelElementExpParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_OclModelElementExp_6=ruleOclModelElementExp();

                    state._fsp--;


                    			current = this_OclModelElementExp_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExp"


    // $ANTLR start "entryRuleLambdaExp"
    // InternalDOcl.g:2858:1: entryRuleLambdaExp returns [EObject current=null] : iv_ruleLambdaExp= ruleLambdaExp EOF ;
    public final EObject entryRuleLambdaExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambdaExp = null;


        try {
            // InternalDOcl.g:2858:50: (iv_ruleLambdaExp= ruleLambdaExp EOF )
            // InternalDOcl.g:2859:2: iv_ruleLambdaExp= ruleLambdaExp EOF
            {
             newCompositeNode(grammarAccess.getLambdaExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLambdaExp=ruleLambdaExp();

            state._fsp--;

             current =iv_ruleLambdaExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLambdaExp"


    // $ANTLR start "ruleLambdaExp"
    // InternalDOcl.g:2865:1: ruleLambdaExp returns [EObject current=null] : ( () ( (lv_name_1_0= 'Lambda' ) ) otherlv_2= '{' ( (lv_expression_3_0= ruleOclExpression ) ) otherlv_4= '}' ) ;
    public final EObject ruleLambdaExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:2871:2: ( ( () ( (lv_name_1_0= 'Lambda' ) ) otherlv_2= '{' ( (lv_expression_3_0= ruleOclExpression ) ) otherlv_4= '}' ) )
            // InternalDOcl.g:2872:2: ( () ( (lv_name_1_0= 'Lambda' ) ) otherlv_2= '{' ( (lv_expression_3_0= ruleOclExpression ) ) otherlv_4= '}' )
            {
            // InternalDOcl.g:2872:2: ( () ( (lv_name_1_0= 'Lambda' ) ) otherlv_2= '{' ( (lv_expression_3_0= ruleOclExpression ) ) otherlv_4= '}' )
            // InternalDOcl.g:2873:3: () ( (lv_name_1_0= 'Lambda' ) ) otherlv_2= '{' ( (lv_expression_3_0= ruleOclExpression ) ) otherlv_4= '}'
            {
            // InternalDOcl.g:2873:3: ()
            // InternalDOcl.g:2874:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLambdaExpAccess().getLambdaExpAction_0(),
            					current);
            			

            }

            // InternalDOcl.g:2880:3: ( (lv_name_1_0= 'Lambda' ) )
            // InternalDOcl.g:2881:4: (lv_name_1_0= 'Lambda' )
            {
            // InternalDOcl.g:2881:4: (lv_name_1_0= 'Lambda' )
            // InternalDOcl.g:2882:5: lv_name_1_0= 'Lambda'
            {
            lv_name_1_0=(Token)match(input,79,FOLLOW_42); 

            					newLeafNode(lv_name_1_0, grammarAccess.getLambdaExpAccess().getNameLambdaKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLambdaExpRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_1_0, "Lambda");
            				

            }


            }

            otherlv_2=(Token)match(input,80,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getLambdaExpAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalDOcl.g:2898:3: ( (lv_expression_3_0= ruleOclExpression ) )
            // InternalDOcl.g:2899:4: (lv_expression_3_0= ruleOclExpression )
            {
            // InternalDOcl.g:2899:4: (lv_expression_3_0= ruleOclExpression )
            // InternalDOcl.g:2900:5: lv_expression_3_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getLambdaExpAccess().getExpressionOclExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_43);
            lv_expression_3_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLambdaExpRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,81,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getLambdaExpAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLambdaExp"


    // $ANTLR start "entryRuleTupleExp"
    // InternalDOcl.g:2925:1: entryRuleTupleExp returns [EObject current=null] : iv_ruleTupleExp= ruleTupleExp EOF ;
    public final EObject entryRuleTupleExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleExp = null;


        try {
            // InternalDOcl.g:2925:49: (iv_ruleTupleExp= ruleTupleExp EOF )
            // InternalDOcl.g:2926:2: iv_ruleTupleExp= ruleTupleExp EOF
            {
             newCompositeNode(grammarAccess.getTupleExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTupleExp=ruleTupleExp();

            state._fsp--;

             current =iv_ruleTupleExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleExp"


    // $ANTLR start "ruleTupleExp"
    // InternalDOcl.g:2932:1: ruleTupleExp returns [EObject current=null] : ( () ( (lv_name_1_0= 'Tuple' ) ) otherlv_2= '{' ( (lv_parts_3_0= ruleTuplePart ) ) (otherlv_4= ',' ( (lv_parts_5_0= ruleTuplePart ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleTupleExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_parts_3_0 = null;

        EObject lv_parts_5_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:2938:2: ( ( () ( (lv_name_1_0= 'Tuple' ) ) otherlv_2= '{' ( (lv_parts_3_0= ruleTuplePart ) ) (otherlv_4= ',' ( (lv_parts_5_0= ruleTuplePart ) ) )* otherlv_6= '}' ) )
            // InternalDOcl.g:2939:2: ( () ( (lv_name_1_0= 'Tuple' ) ) otherlv_2= '{' ( (lv_parts_3_0= ruleTuplePart ) ) (otherlv_4= ',' ( (lv_parts_5_0= ruleTuplePart ) ) )* otherlv_6= '}' )
            {
            // InternalDOcl.g:2939:2: ( () ( (lv_name_1_0= 'Tuple' ) ) otherlv_2= '{' ( (lv_parts_3_0= ruleTuplePart ) ) (otherlv_4= ',' ( (lv_parts_5_0= ruleTuplePart ) ) )* otherlv_6= '}' )
            // InternalDOcl.g:2940:3: () ( (lv_name_1_0= 'Tuple' ) ) otherlv_2= '{' ( (lv_parts_3_0= ruleTuplePart ) ) (otherlv_4= ',' ( (lv_parts_5_0= ruleTuplePart ) ) )* otherlv_6= '}'
            {
            // InternalDOcl.g:2940:3: ()
            // InternalDOcl.g:2941:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTupleExpAccess().getTupleExpAction_0(),
            					current);
            			

            }

            // InternalDOcl.g:2947:3: ( (lv_name_1_0= 'Tuple' ) )
            // InternalDOcl.g:2948:4: (lv_name_1_0= 'Tuple' )
            {
            // InternalDOcl.g:2948:4: (lv_name_1_0= 'Tuple' )
            // InternalDOcl.g:2949:5: lv_name_1_0= 'Tuple'
            {
            lv_name_1_0=(Token)match(input,82,FOLLOW_42); 

            					newLeafNode(lv_name_1_0, grammarAccess.getTupleExpAccess().getNameTupleKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTupleExpRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_1_0, "Tuple");
            				

            }


            }

            otherlv_2=(Token)match(input,80,FOLLOW_44); 

            			newLeafNode(otherlv_2, grammarAccess.getTupleExpAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalDOcl.g:2965:3: ( (lv_parts_3_0= ruleTuplePart ) )
            // InternalDOcl.g:2966:4: (lv_parts_3_0= ruleTuplePart )
            {
            // InternalDOcl.g:2966:4: (lv_parts_3_0= ruleTuplePart )
            // InternalDOcl.g:2967:5: lv_parts_3_0= ruleTuplePart
            {

            					newCompositeNode(grammarAccess.getTupleExpAccess().getPartsTuplePartParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_45);
            lv_parts_3_0=ruleTuplePart();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTupleExpRule());
            					}
            					add(
            						current,
            						"parts",
            						lv_parts_3_0,
            						"fr.inria.diverse.docl.DOcl.TuplePart");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDOcl.g:2984:3: (otherlv_4= ',' ( (lv_parts_5_0= ruleTuplePart ) ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==73) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalDOcl.g:2985:4: otherlv_4= ',' ( (lv_parts_5_0= ruleTuplePart ) )
            	    {
            	    otherlv_4=(Token)match(input,73,FOLLOW_44); 

            	    				newLeafNode(otherlv_4, grammarAccess.getTupleExpAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalDOcl.g:2989:4: ( (lv_parts_5_0= ruleTuplePart ) )
            	    // InternalDOcl.g:2990:5: (lv_parts_5_0= ruleTuplePart )
            	    {
            	    // InternalDOcl.g:2990:5: (lv_parts_5_0= ruleTuplePart )
            	    // InternalDOcl.g:2991:6: lv_parts_5_0= ruleTuplePart
            	    {

            	    						newCompositeNode(grammarAccess.getTupleExpAccess().getPartsTuplePartParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_45);
            	    lv_parts_5_0=ruleTuplePart();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getTupleExpRule());
            	    						}
            	    						add(
            	    							current,
            	    							"parts",
            	    							lv_parts_5_0,
            	    							"fr.inria.diverse.docl.DOcl.TuplePart");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            otherlv_6=(Token)match(input,81,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getTupleExpAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleExp"


    // $ANTLR start "entryRuleTuplePart"
    // InternalDOcl.g:3017:1: entryRuleTuplePart returns [EObject current=null] : iv_ruleTuplePart= ruleTuplePart EOF ;
    public final EObject entryRuleTuplePart() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePart = null;


        try {
            // InternalDOcl.g:3017:50: (iv_ruleTuplePart= ruleTuplePart EOF )
            // InternalDOcl.g:3018:2: iv_ruleTuplePart= ruleTuplePart EOF
            {
             newCompositeNode(grammarAccess.getTuplePartRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTuplePart=ruleTuplePart();

            state._fsp--;

             current =iv_ruleTuplePart; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTuplePart"


    // $ANTLR start "ruleTuplePart"
    // InternalDOcl.g:3024:1: ruleTuplePart returns [EObject current=null] : ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) )? otherlv_3= '=' ( (lv_init_4_0= ruleOclExpression ) ) ) ;
    public final EObject ruleTuplePart() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;

        EObject lv_init_4_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:3030:2: ( ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) )? otherlv_3= '=' ( (lv_init_4_0= ruleOclExpression ) ) ) )
            // InternalDOcl.g:3031:2: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) )? otherlv_3= '=' ( (lv_init_4_0= ruleOclExpression ) ) )
            {
            // InternalDOcl.g:3031:2: ( ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) )? otherlv_3= '=' ( (lv_init_4_0= ruleOclExpression ) ) )
            // InternalDOcl.g:3032:3: ( (lv_name_0_0= RULE_STRING ) ) (otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) )? otherlv_3= '=' ( (lv_init_4_0= ruleOclExpression ) )
            {
            // InternalDOcl.g:3032:3: ( (lv_name_0_0= RULE_STRING ) )
            // InternalDOcl.g:3033:4: (lv_name_0_0= RULE_STRING )
            {
            // InternalDOcl.g:3033:4: (lv_name_0_0= RULE_STRING )
            // InternalDOcl.g:3034:5: lv_name_0_0= RULE_STRING
            {
            lv_name_0_0=(Token)match(input,RULE_STRING,FOLLOW_46); 

            					newLeafNode(lv_name_0_0, grammarAccess.getTuplePartAccess().getNameSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTuplePartRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalDOcl.g:3050:3: (otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==19) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalDOcl.g:3051:4: otherlv_1= ':' ( (lv_type_2_0= ruleOclType ) )
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_36); 

                    				newLeafNode(otherlv_1, grammarAccess.getTuplePartAccess().getColonKeyword_1_0());
                    			
                    // InternalDOcl.g:3055:4: ( (lv_type_2_0= ruleOclType ) )
                    // InternalDOcl.g:3056:5: (lv_type_2_0= ruleOclType )
                    {
                    // InternalDOcl.g:3056:5: (lv_type_2_0= ruleOclType )
                    // InternalDOcl.g:3057:6: lv_type_2_0= ruleOclType
                    {

                    						newCompositeNode(grammarAccess.getTuplePartAccess().getTypeOclTypeParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_type_2_0=ruleOclType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTuplePartRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_2_0,
                    							"fr.inria.diverse.docl.DOcl.OclType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,65,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getTuplePartAccess().getEqualsSignKeyword_2());
            		
            // InternalDOcl.g:3079:3: ( (lv_init_4_0= ruleOclExpression ) )
            // InternalDOcl.g:3080:4: (lv_init_4_0= ruleOclExpression )
            {
            // InternalDOcl.g:3080:4: (lv_init_4_0= ruleOclExpression )
            // InternalDOcl.g:3081:5: lv_init_4_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getTuplePartAccess().getInitOclExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_init_4_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTuplePartRule());
            					}
            					set(
            						current,
            						"init",
            						lv_init_4_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTuplePart"


    // $ANTLR start "entryRulePrimitiveExp"
    // InternalDOcl.g:3102:1: entryRulePrimitiveExp returns [EObject current=null] : iv_rulePrimitiveExp= rulePrimitiveExp EOF ;
    public final EObject entryRulePrimitiveExp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveExp = null;


        try {
            // InternalDOcl.g:3102:53: (iv_rulePrimitiveExp= rulePrimitiveExp EOF )
            // InternalDOcl.g:3103:2: iv_rulePrimitiveExp= rulePrimitiveExp EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveExpRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePrimitiveExp=rulePrimitiveExp();

            state._fsp--;

             current =iv_rulePrimitiveExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveExp"


    // $ANTLR start "rulePrimitiveExp"
    // InternalDOcl.g:3109:1: rulePrimitiveExp returns [EObject current=null] : (this_NumberExp_0= ruleNumberExp | this_StringExp_1= ruleStringExp | this_BooleanExp_2= ruleBooleanExp | this_UnlimitedNaturalExp_3= ruleUnlimitedNaturalExp | this_InvalidExp_4= ruleInvalidExp | this_NullExp_5= ruleNullExp ) ;
    public final EObject rulePrimitiveExp() throws RecognitionException {
        EObject current = null;

        EObject this_NumberExp_0 = null;

        EObject this_StringExp_1 = null;

        EObject this_BooleanExp_2 = null;

        EObject this_UnlimitedNaturalExp_3 = null;

        EObject this_InvalidExp_4 = null;

        EObject this_NullExp_5 = null;



        	enterRule();

        try {
            // InternalDOcl.g:3115:2: ( (this_NumberExp_0= ruleNumberExp | this_StringExp_1= ruleStringExp | this_BooleanExp_2= ruleBooleanExp | this_UnlimitedNaturalExp_3= ruleUnlimitedNaturalExp | this_InvalidExp_4= ruleInvalidExp | this_NullExp_5= ruleNullExp ) )
            // InternalDOcl.g:3116:2: (this_NumberExp_0= ruleNumberExp | this_StringExp_1= ruleStringExp | this_BooleanExp_2= ruleBooleanExp | this_UnlimitedNaturalExp_3= ruleUnlimitedNaturalExp | this_InvalidExp_4= ruleInvalidExp | this_NullExp_5= ruleNullExp )
            {
            // InternalDOcl.g:3116:2: (this_NumberExp_0= ruleNumberExp | this_StringExp_1= ruleStringExp | this_BooleanExp_2= ruleBooleanExp | this_UnlimitedNaturalExp_3= ruleUnlimitedNaturalExp | this_InvalidExp_4= ruleInvalidExp | this_NullExp_5= ruleNullExp )
            int alt40=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt40=1;
                }
                break;
            case RULE_STRING:
                {
                alt40=2;
                }
                break;
            case 83:
            case 84:
                {
                alt40=3;
                }
                break;
            case 71:
                {
                alt40=4;
                }
                break;
            case 85:
                {
                alt40=5;
                }
                break;
            case 86:
                {
                alt40=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalDOcl.g:3117:3: this_NumberExp_0= ruleNumberExp
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveExpAccess().getNumberExpParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_NumberExp_0=ruleNumberExp();

                    state._fsp--;


                    			current = this_NumberExp_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDOcl.g:3126:3: this_StringExp_1= ruleStringExp
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveExpAccess().getStringExpParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringExp_1=ruleStringExp();

                    state._fsp--;


                    			current = this_StringExp_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalDOcl.g:3135:3: this_BooleanExp_2= ruleBooleanExp
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveExpAccess().getBooleanExpParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanExp_2=ruleBooleanExp();

                    state._fsp--;


                    			current = this_BooleanExp_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalDOcl.g:3144:3: this_UnlimitedNaturalExp_3= ruleUnlimitedNaturalExp
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveExpAccess().getUnlimitedNaturalExpParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_UnlimitedNaturalExp_3=ruleUnlimitedNaturalExp();

                    state._fsp--;


                    			current = this_UnlimitedNaturalExp_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalDOcl.g:3153:3: this_InvalidExp_4= ruleInvalidExp
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveExpAccess().getInvalidExpParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_InvalidExp_4=ruleInvalidExp();

                    state._fsp--;


                    			current = this_InvalidExp_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalDOcl.g:3162:3: this_NullExp_5= ruleNullExp
                    {

                    			newCompositeNode(grammarAccess.getPrimitiveExpAccess().getNullExpParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_NullExp_5=ruleNullExp();

                    state._fsp--;


                    			current = this_NullExp_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveExp"


    // $ANTLR start "entryRuleNumberExp"
    // InternalDOcl.g:3174:1: entryRuleNumberExp returns [EObject current=null] : iv_ruleNumberExp= ruleNumberExp EOF ;
    public final EObject entryRuleNumberExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberExp = null;


        try {
            // InternalDOcl.g:3174:50: (iv_ruleNumberExp= ruleNumberExp EOF )
            // InternalDOcl.g:3175:2: iv_ruleNumberExp= ruleNumberExp EOF
            {
             newCompositeNode(grammarAccess.getNumberExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNumberExp=ruleNumberExp();

            state._fsp--;

             current =iv_ruleNumberExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberExp"


    // $ANTLR start "ruleNumberExp"
    // InternalDOcl.g:3181:1: ruleNumberExp returns [EObject current=null] : ( (lv_symbol_0_0= RULE_INT ) ) ;
    public final EObject ruleNumberExp() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_0_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:3187:2: ( ( (lv_symbol_0_0= RULE_INT ) ) )
            // InternalDOcl.g:3188:2: ( (lv_symbol_0_0= RULE_INT ) )
            {
            // InternalDOcl.g:3188:2: ( (lv_symbol_0_0= RULE_INT ) )
            // InternalDOcl.g:3189:3: (lv_symbol_0_0= RULE_INT )
            {
            // InternalDOcl.g:3189:3: (lv_symbol_0_0= RULE_INT )
            // InternalDOcl.g:3190:4: lv_symbol_0_0= RULE_INT
            {
            lv_symbol_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_symbol_0_0, grammarAccess.getNumberExpAccess().getSymbolINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNumberExpRule());
            				}
            				setWithLastConsumed(
            					current,
            					"symbol",
            					lv_symbol_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberExp"


    // $ANTLR start "entryRuleStringExp"
    // InternalDOcl.g:3209:1: entryRuleStringExp returns [EObject current=null] : iv_ruleStringExp= ruleStringExp EOF ;
    public final EObject entryRuleStringExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringExp = null;


        try {
            // InternalDOcl.g:3209:50: (iv_ruleStringExp= ruleStringExp EOF )
            // InternalDOcl.g:3210:2: iv_ruleStringExp= ruleStringExp EOF
            {
             newCompositeNode(grammarAccess.getStringExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringExp=ruleStringExp();

            state._fsp--;

             current =iv_ruleStringExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringExp"


    // $ANTLR start "ruleStringExp"
    // InternalDOcl.g:3216:1: ruleStringExp returns [EObject current=null] : ( (lv_segments_0_0= RULE_STRING ) )+ ;
    public final EObject ruleStringExp() throws RecognitionException {
        EObject current = null;

        Token lv_segments_0_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:3222:2: ( ( (lv_segments_0_0= RULE_STRING ) )+ )
            // InternalDOcl.g:3223:2: ( (lv_segments_0_0= RULE_STRING ) )+
            {
            // InternalDOcl.g:3223:2: ( (lv_segments_0_0= RULE_STRING ) )+
            int cnt41=0;
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_STRING) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalDOcl.g:3224:3: (lv_segments_0_0= RULE_STRING )
            	    {
            	    // InternalDOcl.g:3224:3: (lv_segments_0_0= RULE_STRING )
            	    // InternalDOcl.g:3225:4: lv_segments_0_0= RULE_STRING
            	    {
            	    lv_segments_0_0=(Token)match(input,RULE_STRING,FOLLOW_47); 

            	    				newLeafNode(lv_segments_0_0, grammarAccess.getStringExpAccess().getSegmentsSTRINGTerminalRuleCall_0());
            	    			

            	    				if (current==null) {
            	    					current = createModelElement(grammarAccess.getStringExpRule());
            	    				}
            	    				addWithLastConsumed(
            	    					current,
            	    					"segments",
            	    					lv_segments_0_0,
            	    					"org.eclipse.xtext.common.Terminals.STRING");
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt41 >= 1 ) break loop41;
                        EarlyExitException eee =
                            new EarlyExitException(41, input);
                        throw eee;
                }
                cnt41++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringExp"


    // $ANTLR start "entryRuleBooleanExp"
    // InternalDOcl.g:3244:1: entryRuleBooleanExp returns [EObject current=null] : iv_ruleBooleanExp= ruleBooleanExp EOF ;
    public final EObject entryRuleBooleanExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExp = null;


        try {
            // InternalDOcl.g:3244:51: (iv_ruleBooleanExp= ruleBooleanExp EOF )
            // InternalDOcl.g:3245:2: iv_ruleBooleanExp= ruleBooleanExp EOF
            {
             newCompositeNode(grammarAccess.getBooleanExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanExp=ruleBooleanExp();

            state._fsp--;

             current =iv_ruleBooleanExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanExp"


    // $ANTLR start "ruleBooleanExp"
    // InternalDOcl.g:3251:1: ruleBooleanExp returns [EObject current=null] : ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanExp() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_0_0=null;
        Token lv_symbol_1_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:3257:2: ( ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) ) )
            // InternalDOcl.g:3258:2: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            {
            // InternalDOcl.g:3258:2: ( ( (lv_symbol_0_0= 'true' ) ) | ( (lv_symbol_1_0= 'false' ) ) )
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==83) ) {
                alt42=1;
            }
            else if ( (LA42_0==84) ) {
                alt42=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }
            switch (alt42) {
                case 1 :
                    // InternalDOcl.g:3259:3: ( (lv_symbol_0_0= 'true' ) )
                    {
                    // InternalDOcl.g:3259:3: ( (lv_symbol_0_0= 'true' ) )
                    // InternalDOcl.g:3260:4: (lv_symbol_0_0= 'true' )
                    {
                    // InternalDOcl.g:3260:4: (lv_symbol_0_0= 'true' )
                    // InternalDOcl.g:3261:5: lv_symbol_0_0= 'true'
                    {
                    lv_symbol_0_0=(Token)match(input,83,FOLLOW_2); 

                    					newLeafNode(lv_symbol_0_0, grammarAccess.getBooleanExpAccess().getSymbolTrueKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanExpRule());
                    					}
                    					setWithLastConsumed(current, "symbol", lv_symbol_0_0, "true");
                    				

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDOcl.g:3274:3: ( (lv_symbol_1_0= 'false' ) )
                    {
                    // InternalDOcl.g:3274:3: ( (lv_symbol_1_0= 'false' ) )
                    // InternalDOcl.g:3275:4: (lv_symbol_1_0= 'false' )
                    {
                    // InternalDOcl.g:3275:4: (lv_symbol_1_0= 'false' )
                    // InternalDOcl.g:3276:5: lv_symbol_1_0= 'false'
                    {
                    lv_symbol_1_0=(Token)match(input,84,FOLLOW_2); 

                    					newLeafNode(lv_symbol_1_0, grammarAccess.getBooleanExpAccess().getSymbolFalseKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getBooleanExpRule());
                    					}
                    					setWithLastConsumed(current, "symbol", lv_symbol_1_0, "false");
                    				

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanExp"


    // $ANTLR start "entryRuleUnlimitedNaturalExp"
    // InternalDOcl.g:3292:1: entryRuleUnlimitedNaturalExp returns [EObject current=null] : iv_ruleUnlimitedNaturalExp= ruleUnlimitedNaturalExp EOF ;
    public final EObject entryRuleUnlimitedNaturalExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalExp = null;


        try {
            // InternalDOcl.g:3292:60: (iv_ruleUnlimitedNaturalExp= ruleUnlimitedNaturalExp EOF )
            // InternalDOcl.g:3293:2: iv_ruleUnlimitedNaturalExp= ruleUnlimitedNaturalExp EOF
            {
             newCompositeNode(grammarAccess.getUnlimitedNaturalExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnlimitedNaturalExp=ruleUnlimitedNaturalExp();

            state._fsp--;

             current =iv_ruleUnlimitedNaturalExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnlimitedNaturalExp"


    // $ANTLR start "ruleUnlimitedNaturalExp"
    // InternalDOcl.g:3299:1: ruleUnlimitedNaturalExp returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDOcl.g:3305:2: ( ( () otherlv_1= '*' ) )
            // InternalDOcl.g:3306:2: ( () otherlv_1= '*' )
            {
            // InternalDOcl.g:3306:2: ( () otherlv_1= '*' )
            // InternalDOcl.g:3307:3: () otherlv_1= '*'
            {
            // InternalDOcl.g:3307:3: ()
            // InternalDOcl.g:3308:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getUnlimitedNaturalExpAccess().getUnlimitedNaturalLiteralExpAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,71,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getUnlimitedNaturalExpAccess().getAsteriskKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnlimitedNaturalExp"


    // $ANTLR start "entryRuleInvalidExp"
    // InternalDOcl.g:3322:1: entryRuleInvalidExp returns [EObject current=null] : iv_ruleInvalidExp= ruleInvalidExp EOF ;
    public final EObject entryRuleInvalidExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidExp = null;


        try {
            // InternalDOcl.g:3322:51: (iv_ruleInvalidExp= ruleInvalidExp EOF )
            // InternalDOcl.g:3323:2: iv_ruleInvalidExp= ruleInvalidExp EOF
            {
             newCompositeNode(grammarAccess.getInvalidExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInvalidExp=ruleInvalidExp();

            state._fsp--;

             current =iv_ruleInvalidExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInvalidExp"


    // $ANTLR start "ruleInvalidExp"
    // InternalDOcl.g:3329:1: ruleInvalidExp returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDOcl.g:3335:2: ( ( () otherlv_1= 'invalid' ) )
            // InternalDOcl.g:3336:2: ( () otherlv_1= 'invalid' )
            {
            // InternalDOcl.g:3336:2: ( () otherlv_1= 'invalid' )
            // InternalDOcl.g:3337:3: () otherlv_1= 'invalid'
            {
            // InternalDOcl.g:3337:3: ()
            // InternalDOcl.g:3338:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInvalidExpAccess().getInvalidLiteralExpAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,85,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getInvalidExpAccess().getInvalidKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInvalidExp"


    // $ANTLR start "entryRuleNullExp"
    // InternalDOcl.g:3352:1: entryRuleNullExp returns [EObject current=null] : iv_ruleNullExp= ruleNullExp EOF ;
    public final EObject entryRuleNullExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullExp = null;


        try {
            // InternalDOcl.g:3352:48: (iv_ruleNullExp= ruleNullExp EOF )
            // InternalDOcl.g:3353:2: iv_ruleNullExp= ruleNullExp EOF
            {
             newCompositeNode(grammarAccess.getNullExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNullExp=ruleNullExp();

            state._fsp--;

             current =iv_ruleNullExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNullExp"


    // $ANTLR start "ruleNullExp"
    // InternalDOcl.g:3359:1: ruleNullExp returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalDOcl.g:3365:2: ( ( () otherlv_1= 'null' ) )
            // InternalDOcl.g:3366:2: ( () otherlv_1= 'null' )
            {
            // InternalDOcl.g:3366:2: ( () otherlv_1= 'null' )
            // InternalDOcl.g:3367:3: () otherlv_1= 'null'
            {
            // InternalDOcl.g:3367:3: ()
            // InternalDOcl.g:3368:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNullExpAccess().getNullLiteralExpAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,86,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getNullExpAccess().getNullKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullExp"


    // $ANTLR start "entryRuleIfExp"
    // InternalDOcl.g:3382:1: entryRuleIfExp returns [EObject current=null] : iv_ruleIfExp= ruleIfExp EOF ;
    public final EObject entryRuleIfExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExp = null;


        try {
            // InternalDOcl.g:3382:46: (iv_ruleIfExp= ruleIfExp EOF )
            // InternalDOcl.g:3383:2: iv_ruleIfExp= ruleIfExp EOF
            {
             newCompositeNode(grammarAccess.getIfExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIfExp=ruleIfExp();

            state._fsp--;

             current =iv_ruleIfExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfExp"


    // $ANTLR start "ruleIfExp"
    // InternalDOcl.g:3389:1: ruleIfExp returns [EObject current=null] : ( ( (lv_name_0_0= 'if' ) ) ( (lv_condition_1_0= ruleOclExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleOclExpression ) ) ( (lv_ifThen_4_0= ruleElseIfThenExp ) )* otherlv_5= 'else' ( (lv_else_6_0= ruleOclExpression ) ) otherlv_7= 'endif' ) ;
    public final EObject ruleIfExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_condition_1_0 = null;

        EObject lv_then_3_0 = null;

        EObject lv_ifThen_4_0 = null;

        EObject lv_else_6_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:3395:2: ( ( ( (lv_name_0_0= 'if' ) ) ( (lv_condition_1_0= ruleOclExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleOclExpression ) ) ( (lv_ifThen_4_0= ruleElseIfThenExp ) )* otherlv_5= 'else' ( (lv_else_6_0= ruleOclExpression ) ) otherlv_7= 'endif' ) )
            // InternalDOcl.g:3396:2: ( ( (lv_name_0_0= 'if' ) ) ( (lv_condition_1_0= ruleOclExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleOclExpression ) ) ( (lv_ifThen_4_0= ruleElseIfThenExp ) )* otherlv_5= 'else' ( (lv_else_6_0= ruleOclExpression ) ) otherlv_7= 'endif' )
            {
            // InternalDOcl.g:3396:2: ( ( (lv_name_0_0= 'if' ) ) ( (lv_condition_1_0= ruleOclExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleOclExpression ) ) ( (lv_ifThen_4_0= ruleElseIfThenExp ) )* otherlv_5= 'else' ( (lv_else_6_0= ruleOclExpression ) ) otherlv_7= 'endif' )
            // InternalDOcl.g:3397:3: ( (lv_name_0_0= 'if' ) ) ( (lv_condition_1_0= ruleOclExpression ) ) otherlv_2= 'then' ( (lv_then_3_0= ruleOclExpression ) ) ( (lv_ifThen_4_0= ruleElseIfThenExp ) )* otherlv_5= 'else' ( (lv_else_6_0= ruleOclExpression ) ) otherlv_7= 'endif'
            {
            // InternalDOcl.g:3397:3: ( (lv_name_0_0= 'if' ) )
            // InternalDOcl.g:3398:4: (lv_name_0_0= 'if' )
            {
            // InternalDOcl.g:3398:4: (lv_name_0_0= 'if' )
            // InternalDOcl.g:3399:5: lv_name_0_0= 'if'
            {
            lv_name_0_0=(Token)match(input,87,FOLLOW_16); 

            					newLeafNode(lv_name_0_0, grammarAccess.getIfExpAccess().getNameIfKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIfExpRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "if");
            				

            }


            }

            // InternalDOcl.g:3411:3: ( (lv_condition_1_0= ruleOclExpression ) )
            // InternalDOcl.g:3412:4: (lv_condition_1_0= ruleOclExpression )
            {
            // InternalDOcl.g:3412:4: (lv_condition_1_0= ruleOclExpression )
            // InternalDOcl.g:3413:5: lv_condition_1_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getIfExpAccess().getConditionOclExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_48);
            lv_condition_1_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfExpRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,88,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getIfExpAccess().getThenKeyword_2());
            		
            // InternalDOcl.g:3434:3: ( (lv_then_3_0= ruleOclExpression ) )
            // InternalDOcl.g:3435:4: (lv_then_3_0= ruleOclExpression )
            {
            // InternalDOcl.g:3435:4: (lv_then_3_0= ruleOclExpression )
            // InternalDOcl.g:3436:5: lv_then_3_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getIfExpAccess().getThenOclExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_49);
            lv_then_3_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfExpRule());
            					}
            					set(
            						current,
            						"then",
            						lv_then_3_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDOcl.g:3453:3: ( (lv_ifThen_4_0= ruleElseIfThenExp ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==91) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalDOcl.g:3454:4: (lv_ifThen_4_0= ruleElseIfThenExp )
            	    {
            	    // InternalDOcl.g:3454:4: (lv_ifThen_4_0= ruleElseIfThenExp )
            	    // InternalDOcl.g:3455:5: lv_ifThen_4_0= ruleElseIfThenExp
            	    {

            	    					newCompositeNode(grammarAccess.getIfExpAccess().getIfThenElseIfThenExpParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_49);
            	    lv_ifThen_4_0=ruleElseIfThenExp();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIfExpRule());
            	    					}
            	    					add(
            	    						current,
            	    						"ifThen",
            	    						lv_ifThen_4_0,
            	    						"fr.inria.diverse.docl.DOcl.ElseIfThenExp");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            otherlv_5=(Token)match(input,89,FOLLOW_16); 

            			newLeafNode(otherlv_5, grammarAccess.getIfExpAccess().getElseKeyword_5());
            		
            // InternalDOcl.g:3476:3: ( (lv_else_6_0= ruleOclExpression ) )
            // InternalDOcl.g:3477:4: (lv_else_6_0= ruleOclExpression )
            {
            // InternalDOcl.g:3477:4: (lv_else_6_0= ruleOclExpression )
            // InternalDOcl.g:3478:5: lv_else_6_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getIfExpAccess().getElseOclExpressionParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_50);
            lv_else_6_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIfExpRule());
            					}
            					set(
            						current,
            						"else",
            						lv_else_6_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,90,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getIfExpAccess().getEndifKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfExp"


    // $ANTLR start "entryRuleElseIfThenExp"
    // InternalDOcl.g:3503:1: entryRuleElseIfThenExp returns [EObject current=null] : iv_ruleElseIfThenExp= ruleElseIfThenExp EOF ;
    public final EObject entryRuleElseIfThenExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIfThenExp = null;


        try {
            // InternalDOcl.g:3503:54: (iv_ruleElseIfThenExp= ruleElseIfThenExp EOF )
            // InternalDOcl.g:3504:2: iv_ruleElseIfThenExp= ruleElseIfThenExp EOF
            {
             newCompositeNode(grammarAccess.getElseIfThenExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElseIfThenExp=ruleElseIfThenExp();

            state._fsp--;

             current =iv_ruleElseIfThenExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElseIfThenExp"


    // $ANTLR start "ruleElseIfThenExp"
    // InternalDOcl.g:3510:1: ruleElseIfThenExp returns [EObject current=null] : ( () ( (lv_name_1_0= 'elseif' ) ) ( (lv_condition_2_0= ruleOclExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleOclExpression ) ) ) ;
    public final EObject ruleElseIfThenExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_3=null;
        EObject lv_condition_2_0 = null;

        EObject lv_then_4_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:3516:2: ( ( () ( (lv_name_1_0= 'elseif' ) ) ( (lv_condition_2_0= ruleOclExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleOclExpression ) ) ) )
            // InternalDOcl.g:3517:2: ( () ( (lv_name_1_0= 'elseif' ) ) ( (lv_condition_2_0= ruleOclExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleOclExpression ) ) )
            {
            // InternalDOcl.g:3517:2: ( () ( (lv_name_1_0= 'elseif' ) ) ( (lv_condition_2_0= ruleOclExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleOclExpression ) ) )
            // InternalDOcl.g:3518:3: () ( (lv_name_1_0= 'elseif' ) ) ( (lv_condition_2_0= ruleOclExpression ) ) otherlv_3= 'then' ( (lv_then_4_0= ruleOclExpression ) )
            {
            // InternalDOcl.g:3518:3: ()
            // InternalDOcl.g:3519:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getElseIfThenExpAccess().getElseIfThenExpAction_0(),
            					current);
            			

            }

            // InternalDOcl.g:3525:3: ( (lv_name_1_0= 'elseif' ) )
            // InternalDOcl.g:3526:4: (lv_name_1_0= 'elseif' )
            {
            // InternalDOcl.g:3526:4: (lv_name_1_0= 'elseif' )
            // InternalDOcl.g:3527:5: lv_name_1_0= 'elseif'
            {
            lv_name_1_0=(Token)match(input,91,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getElseIfThenExpAccess().getNameElseifKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getElseIfThenExpRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_1_0, "elseif");
            				

            }


            }

            // InternalDOcl.g:3539:3: ( (lv_condition_2_0= ruleOclExpression ) )
            // InternalDOcl.g:3540:4: (lv_condition_2_0= ruleOclExpression )
            {
            // InternalDOcl.g:3540:4: (lv_condition_2_0= ruleOclExpression )
            // InternalDOcl.g:3541:5: lv_condition_2_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getElseIfThenExpAccess().getConditionOclExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_48);
            lv_condition_2_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getElseIfThenExpRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_2_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,88,FOLLOW_16); 

            			newLeafNode(otherlv_3, grammarAccess.getElseIfThenExpAccess().getThenKeyword_3());
            		
            // InternalDOcl.g:3562:3: ( (lv_then_4_0= ruleOclExpression ) )
            // InternalDOcl.g:3563:4: (lv_then_4_0= ruleOclExpression )
            {
            // InternalDOcl.g:3563:4: (lv_then_4_0= ruleOclExpression )
            // InternalDOcl.g:3564:5: lv_then_4_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getElseIfThenExpAccess().getThenOclExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_then_4_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getElseIfThenExpRule());
            					}
            					set(
            						current,
            						"then",
            						lv_then_4_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElseIfThenExp"


    // $ANTLR start "entryRuleSeflExp"
    // InternalDOcl.g:3585:1: entryRuleSeflExp returns [EObject current=null] : iv_ruleSeflExp= ruleSeflExp EOF ;
    public final EObject entryRuleSeflExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSeflExp = null;


        try {
            // InternalDOcl.g:3585:48: (iv_ruleSeflExp= ruleSeflExp EOF )
            // InternalDOcl.g:3586:2: iv_ruleSeflExp= ruleSeflExp EOF
            {
             newCompositeNode(grammarAccess.getSeflExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSeflExp=ruleSeflExp();

            state._fsp--;

             current =iv_ruleSeflExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSeflExp"


    // $ANTLR start "ruleSeflExp"
    // InternalDOcl.g:3592:1: ruleSeflExp returns [EObject current=null] : ( () ( (lv_name_1_0= 'self' ) ) ) ;
    public final EObject ruleSeflExp() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:3598:2: ( ( () ( (lv_name_1_0= 'self' ) ) ) )
            // InternalDOcl.g:3599:2: ( () ( (lv_name_1_0= 'self' ) ) )
            {
            // InternalDOcl.g:3599:2: ( () ( (lv_name_1_0= 'self' ) ) )
            // InternalDOcl.g:3600:3: () ( (lv_name_1_0= 'self' ) )
            {
            // InternalDOcl.g:3600:3: ()
            // InternalDOcl.g:3601:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getSeflExpAccess().getSelfExpAction_0(),
            					current);
            			

            }

            // InternalDOcl.g:3607:3: ( (lv_name_1_0= 'self' ) )
            // InternalDOcl.g:3608:4: (lv_name_1_0= 'self' )
            {
            // InternalDOcl.g:3608:4: (lv_name_1_0= 'self' )
            // InternalDOcl.g:3609:5: lv_name_1_0= 'self'
            {
            lv_name_1_0=(Token)match(input,92,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSeflExpAccess().getNameSelfKeyword_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSeflExpRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_1_0, "self");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSeflExp"


    // $ANTLR start "entryRuleNestedExp"
    // InternalDOcl.g:3625:1: entryRuleNestedExp returns [EObject current=null] : iv_ruleNestedExp= ruleNestedExp EOF ;
    public final EObject entryRuleNestedExp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExp = null;


        try {
            // InternalDOcl.g:3625:50: (iv_ruleNestedExp= ruleNestedExp EOF )
            // InternalDOcl.g:3626:2: iv_ruleNestedExp= ruleNestedExp EOF
            {
             newCompositeNode(grammarAccess.getNestedExpRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNestedExp=ruleNestedExp();

            state._fsp--;

             current =iv_ruleNestedExp; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNestedExp"


    // $ANTLR start "ruleNestedExp"
    // InternalDOcl.g:3632:1: ruleNestedExp returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_exp_2_0= ruleOclExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleNestedExp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_exp_2_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:3638:2: ( ( () otherlv_1= '(' ( (lv_exp_2_0= ruleOclExpression ) ) otherlv_3= ')' ) )
            // InternalDOcl.g:3639:2: ( () otherlv_1= '(' ( (lv_exp_2_0= ruleOclExpression ) ) otherlv_3= ')' )
            {
            // InternalDOcl.g:3639:2: ( () otherlv_1= '(' ( (lv_exp_2_0= ruleOclExpression ) ) otherlv_3= ')' )
            // InternalDOcl.g:3640:3: () otherlv_1= '(' ( (lv_exp_2_0= ruleOclExpression ) ) otherlv_3= ')'
            {
            // InternalDOcl.g:3640:3: ()
            // InternalDOcl.g:3641:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getNestedExpAccess().getNestedExpAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,72,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getNestedExpAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDOcl.g:3651:3: ( (lv_exp_2_0= ruleOclExpression ) )
            // InternalDOcl.g:3652:4: (lv_exp_2_0= ruleOclExpression )
            {
            // InternalDOcl.g:3652:4: (lv_exp_2_0= ruleOclExpression )
            // InternalDOcl.g:3653:5: lv_exp_2_0= ruleOclExpression
            {

            					newCompositeNode(grammarAccess.getNestedExpAccess().getExpOclExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_34);
            lv_exp_2_0=ruleOclExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getNestedExpRule());
            					}
            					set(
            						current,
            						"exp",
            						lv_exp_2_0,
            						"fr.inria.diverse.docl.DOcl.OclExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getNestedExpAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNestedExp"


    // $ANTLR start "entryRuleOclType"
    // InternalDOcl.g:3678:1: entryRuleOclType returns [EObject current=null] : iv_ruleOclType= ruleOclType EOF ;
    public final EObject entryRuleOclType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclType = null;


        try {
            // InternalDOcl.g:3678:48: (iv_ruleOclType= ruleOclType EOF )
            // InternalDOcl.g:3679:2: iv_ruleOclType= ruleOclType EOF
            {
             newCompositeNode(grammarAccess.getOclTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOclType=ruleOclType();

            state._fsp--;

             current =iv_ruleOclType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOclType"


    // $ANTLR start "ruleOclType"
    // InternalDOcl.g:3685:1: ruleOclType returns [EObject current=null] : (this_StringType_0= ruleStringType | this_BooleanType_1= ruleBooleanType | this_IntegerType_2= ruleIntegerType | this_RealType_3= ruleRealType | this_BagType_4= ruleBagType | this_OrderedSetType_5= ruleOrderedSetType | this_SequenceType_6= ruleSequenceType | this_SetType_7= ruleSetType | this_OclAnyType_8= ruleOclAnyType | this_TupleType_9= ruleTupleType | this_OclModelElement_10= ruleOclModelElement | this_MapType_11= ruleMapType | this_LambdaType_12= ruleLambdaType | this_EnvType_13= ruleEnvType ) ;
    public final EObject ruleOclType() throws RecognitionException {
        EObject current = null;

        EObject this_StringType_0 = null;

        EObject this_BooleanType_1 = null;

        EObject this_IntegerType_2 = null;

        EObject this_RealType_3 = null;

        EObject this_BagType_4 = null;

        EObject this_OrderedSetType_5 = null;

        EObject this_SequenceType_6 = null;

        EObject this_SetType_7 = null;

        EObject this_OclAnyType_8 = null;

        EObject this_TupleType_9 = null;

        EObject this_OclModelElement_10 = null;

        EObject this_MapType_11 = null;

        EObject this_LambdaType_12 = null;

        EObject this_EnvType_13 = null;



        	enterRule();

        try {
            // InternalDOcl.g:3691:2: ( (this_StringType_0= ruleStringType | this_BooleanType_1= ruleBooleanType | this_IntegerType_2= ruleIntegerType | this_RealType_3= ruleRealType | this_BagType_4= ruleBagType | this_OrderedSetType_5= ruleOrderedSetType | this_SequenceType_6= ruleSequenceType | this_SetType_7= ruleSetType | this_OclAnyType_8= ruleOclAnyType | this_TupleType_9= ruleTupleType | this_OclModelElement_10= ruleOclModelElement | this_MapType_11= ruleMapType | this_LambdaType_12= ruleLambdaType | this_EnvType_13= ruleEnvType ) )
            // InternalDOcl.g:3692:2: (this_StringType_0= ruleStringType | this_BooleanType_1= ruleBooleanType | this_IntegerType_2= ruleIntegerType | this_RealType_3= ruleRealType | this_BagType_4= ruleBagType | this_OrderedSetType_5= ruleOrderedSetType | this_SequenceType_6= ruleSequenceType | this_SetType_7= ruleSetType | this_OclAnyType_8= ruleOclAnyType | this_TupleType_9= ruleTupleType | this_OclModelElement_10= ruleOclModelElement | this_MapType_11= ruleMapType | this_LambdaType_12= ruleLambdaType | this_EnvType_13= ruleEnvType )
            {
            // InternalDOcl.g:3692:2: (this_StringType_0= ruleStringType | this_BooleanType_1= ruleBooleanType | this_IntegerType_2= ruleIntegerType | this_RealType_3= ruleRealType | this_BagType_4= ruleBagType | this_OrderedSetType_5= ruleOrderedSetType | this_SequenceType_6= ruleSequenceType | this_SetType_7= ruleSetType | this_OclAnyType_8= ruleOclAnyType | this_TupleType_9= ruleTupleType | this_OclModelElement_10= ruleOclModelElement | this_MapType_11= ruleMapType | this_LambdaType_12= ruleLambdaType | this_EnvType_13= ruleEnvType )
            int alt44=14;
            switch ( input.LA(1) ) {
            case 104:
                {
                alt44=1;
                }
                break;
            case 103:
                {
                alt44=2;
                }
                break;
            case 102:
                {
                alt44=3;
                }
                break;
            case 101:
                {
                alt44=4;
                }
                break;
            case 100:
                {
                alt44=5;
                }
                break;
            case 99:
                {
                alt44=6;
                }
                break;
            case 98:
                {
                alt44=7;
                }
                break;
            case 97:
                {
                alt44=8;
                }
                break;
            case 96:
                {
                alt44=9;
                }
                break;
            case 95:
                {
                alt44=10;
                }
                break;
            case RULE_ID:
                {
                alt44=11;
                }
                break;
            case 94:
                {
                alt44=12;
                }
                break;
            case 79:
                {
                alt44=13;
                }
                break;
            case 93:
                {
                alt44=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // InternalDOcl.g:3693:3: this_StringType_0= ruleStringType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getStringTypeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringType_0=ruleStringType();

                    state._fsp--;


                    			current = this_StringType_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalDOcl.g:3702:3: this_BooleanType_1= ruleBooleanType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getBooleanTypeParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BooleanType_1=ruleBooleanType();

                    state._fsp--;


                    			current = this_BooleanType_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalDOcl.g:3711:3: this_IntegerType_2= ruleIntegerType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getIntegerTypeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_IntegerType_2=ruleIntegerType();

                    state._fsp--;


                    			current = this_IntegerType_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalDOcl.g:3720:3: this_RealType_3= ruleRealType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getRealTypeParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_RealType_3=ruleRealType();

                    state._fsp--;


                    			current = this_RealType_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalDOcl.g:3729:3: this_BagType_4= ruleBagType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getBagTypeParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_BagType_4=ruleBagType();

                    state._fsp--;


                    			current = this_BagType_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalDOcl.g:3738:3: this_OrderedSetType_5= ruleOrderedSetType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getOrderedSetTypeParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_OrderedSetType_5=ruleOrderedSetType();

                    state._fsp--;


                    			current = this_OrderedSetType_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalDOcl.g:3747:3: this_SequenceType_6= ruleSequenceType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getSequenceTypeParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_SequenceType_6=ruleSequenceType();

                    state._fsp--;


                    			current = this_SequenceType_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalDOcl.g:3756:3: this_SetType_7= ruleSetType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getSetTypeParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_SetType_7=ruleSetType();

                    state._fsp--;


                    			current = this_SetType_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalDOcl.g:3765:3: this_OclAnyType_8= ruleOclAnyType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getOclAnyTypeParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_OclAnyType_8=ruleOclAnyType();

                    state._fsp--;


                    			current = this_OclAnyType_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalDOcl.g:3774:3: this_TupleType_9= ruleTupleType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getTupleTypeParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_TupleType_9=ruleTupleType();

                    state._fsp--;


                    			current = this_TupleType_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalDOcl.g:3783:3: this_OclModelElement_10= ruleOclModelElement
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getOclModelElementParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_OclModelElement_10=ruleOclModelElement();

                    state._fsp--;


                    			current = this_OclModelElement_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalDOcl.g:3792:3: this_MapType_11= ruleMapType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getMapTypeParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_MapType_11=ruleMapType();

                    state._fsp--;


                    			current = this_MapType_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalDOcl.g:3801:3: this_LambdaType_12= ruleLambdaType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getLambdaTypeParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_LambdaType_12=ruleLambdaType();

                    state._fsp--;


                    			current = this_LambdaType_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 14 :
                    // InternalDOcl.g:3810:3: this_EnvType_13= ruleEnvType
                    {

                    			newCompositeNode(grammarAccess.getOclTypeAccess().getEnvTypeParserRuleCall_13());
                    		
                    pushFollow(FOLLOW_2);
                    this_EnvType_13=ruleEnvType();

                    state._fsp--;


                    			current = this_EnvType_13;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOclType"


    // $ANTLR start "entryRuleOclModelElement"
    // InternalDOcl.g:3822:1: entryRuleOclModelElement returns [EObject current=null] : iv_ruleOclModelElement= ruleOclModelElement EOF ;
    public final EObject entryRuleOclModelElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclModelElement = null;


        try {
            // InternalDOcl.g:3822:56: (iv_ruleOclModelElement= ruleOclModelElement EOF )
            // InternalDOcl.g:3823:2: iv_ruleOclModelElement= ruleOclModelElement EOF
            {
             newCompositeNode(grammarAccess.getOclModelElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOclModelElement=ruleOclModelElement();

            state._fsp--;

             current =iv_ruleOclModelElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOclModelElement"


    // $ANTLR start "ruleOclModelElement"
    // InternalDOcl.g:3829:1: ruleOclModelElement returns [EObject current=null] : ( ( (lv_model_0_0= ruleOclModel ) ) otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleOclModelElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        EObject lv_model_0_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:3835:2: ( ( ( (lv_model_0_0= ruleOclModel ) ) otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalDOcl.g:3836:2: ( ( (lv_model_0_0= ruleOclModel ) ) otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalDOcl.g:3836:2: ( ( (lv_model_0_0= ruleOclModel ) ) otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) ) )
            // InternalDOcl.g:3837:3: ( (lv_model_0_0= ruleOclModel ) ) otherlv_1= '::' ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalDOcl.g:3837:3: ( (lv_model_0_0= ruleOclModel ) )
            // InternalDOcl.g:3838:4: (lv_model_0_0= ruleOclModel )
            {
            // InternalDOcl.g:3838:4: (lv_model_0_0= ruleOclModel )
            // InternalDOcl.g:3839:5: lv_model_0_0= ruleOclModel
            {

            					newCompositeNode(grammarAccess.getOclModelElementAccess().getModelOclModelParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_38);
            lv_model_0_0=ruleOclModel();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOclModelElementRule());
            					}
            					set(
            						current,
            						"model",
            						lv_model_0_0,
            						"fr.inria.diverse.docl.DOcl.OclModel");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,77,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOclModelElementAccess().getColonColonKeyword_1());
            		
            // InternalDOcl.g:3860:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalDOcl.g:3861:4: (lv_name_2_0= RULE_ID )
            {
            // InternalDOcl.g:3861:4: (lv_name_2_0= RULE_ID )
            // InternalDOcl.g:3862:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_2_0, grammarAccess.getOclModelElementAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOclModelElementRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOclModelElement"


    // $ANTLR start "entryRuleEnvType"
    // InternalDOcl.g:3882:1: entryRuleEnvType returns [EObject current=null] : iv_ruleEnvType= ruleEnvType EOF ;
    public final EObject entryRuleEnvType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnvType = null;


        try {
            // InternalDOcl.g:3882:48: (iv_ruleEnvType= ruleEnvType EOF )
            // InternalDOcl.g:3883:2: iv_ruleEnvType= ruleEnvType EOF
            {
             newCompositeNode(grammarAccess.getEnvTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnvType=ruleEnvType();

            state._fsp--;

             current =iv_ruleEnvType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnvType"


    // $ANTLR start "ruleEnvType"
    // InternalDOcl.g:3889:1: ruleEnvType returns [EObject current=null] : ( (lv_name_0_0= 'Env' ) ) ;
    public final EObject ruleEnvType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:3895:2: ( ( (lv_name_0_0= 'Env' ) ) )
            // InternalDOcl.g:3896:2: ( (lv_name_0_0= 'Env' ) )
            {
            // InternalDOcl.g:3896:2: ( (lv_name_0_0= 'Env' ) )
            // InternalDOcl.g:3897:3: (lv_name_0_0= 'Env' )
            {
            // InternalDOcl.g:3897:3: (lv_name_0_0= 'Env' )
            // InternalDOcl.g:3898:4: lv_name_0_0= 'Env'
            {
            lv_name_0_0=(Token)match(input,93,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getEnvTypeAccess().getNameEnvKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getEnvTypeRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "Env");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnvType"


    // $ANTLR start "entryRuleLambdaType"
    // InternalDOcl.g:3913:1: entryRuleLambdaType returns [EObject current=null] : iv_ruleLambdaType= ruleLambdaType EOF ;
    public final EObject entryRuleLambdaType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambdaType = null;


        try {
            // InternalDOcl.g:3913:51: (iv_ruleLambdaType= ruleLambdaType EOF )
            // InternalDOcl.g:3914:2: iv_ruleLambdaType= ruleLambdaType EOF
            {
             newCompositeNode(grammarAccess.getLambdaTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLambdaType=ruleLambdaType();

            state._fsp--;

             current =iv_ruleLambdaType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLambdaType"


    // $ANTLR start "ruleLambdaType"
    // InternalDOcl.g:3920:1: ruleLambdaType returns [EObject current=null] : ( ( (lv_name_0_0= 'Lambda' ) ) otherlv_1= '(' ( (lv_argsTypes_2_0= ruleOclType ) ) (otherlv_3= ',' ( (lv_argsTypes_4_0= ruleOclType ) ) )* otherlv_5= ')' otherlv_6= ':' ( (lv_returnType_7_0= ruleOclType ) ) ) ;
    public final EObject ruleLambdaType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_argsTypes_2_0 = null;

        EObject lv_argsTypes_4_0 = null;

        EObject lv_returnType_7_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:3926:2: ( ( ( (lv_name_0_0= 'Lambda' ) ) otherlv_1= '(' ( (lv_argsTypes_2_0= ruleOclType ) ) (otherlv_3= ',' ( (lv_argsTypes_4_0= ruleOclType ) ) )* otherlv_5= ')' otherlv_6= ':' ( (lv_returnType_7_0= ruleOclType ) ) ) )
            // InternalDOcl.g:3927:2: ( ( (lv_name_0_0= 'Lambda' ) ) otherlv_1= '(' ( (lv_argsTypes_2_0= ruleOclType ) ) (otherlv_3= ',' ( (lv_argsTypes_4_0= ruleOclType ) ) )* otherlv_5= ')' otherlv_6= ':' ( (lv_returnType_7_0= ruleOclType ) ) )
            {
            // InternalDOcl.g:3927:2: ( ( (lv_name_0_0= 'Lambda' ) ) otherlv_1= '(' ( (lv_argsTypes_2_0= ruleOclType ) ) (otherlv_3= ',' ( (lv_argsTypes_4_0= ruleOclType ) ) )* otherlv_5= ')' otherlv_6= ':' ( (lv_returnType_7_0= ruleOclType ) ) )
            // InternalDOcl.g:3928:3: ( (lv_name_0_0= 'Lambda' ) ) otherlv_1= '(' ( (lv_argsTypes_2_0= ruleOclType ) ) (otherlv_3= ',' ( (lv_argsTypes_4_0= ruleOclType ) ) )* otherlv_5= ')' otherlv_6= ':' ( (lv_returnType_7_0= ruleOclType ) )
            {
            // InternalDOcl.g:3928:3: ( (lv_name_0_0= 'Lambda' ) )
            // InternalDOcl.g:3929:4: (lv_name_0_0= 'Lambda' )
            {
            // InternalDOcl.g:3929:4: (lv_name_0_0= 'Lambda' )
            // InternalDOcl.g:3930:5: lv_name_0_0= 'Lambda'
            {
            lv_name_0_0=(Token)match(input,79,FOLLOW_29); 

            					newLeafNode(lv_name_0_0, grammarAccess.getLambdaTypeAccess().getNameLambdaKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLambdaTypeRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "Lambda");
            				

            }


            }

            otherlv_1=(Token)match(input,72,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getLambdaTypeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDOcl.g:3946:3: ( (lv_argsTypes_2_0= ruleOclType ) )
            // InternalDOcl.g:3947:4: (lv_argsTypes_2_0= ruleOclType )
            {
            // InternalDOcl.g:3947:4: (lv_argsTypes_2_0= ruleOclType )
            // InternalDOcl.g:3948:5: lv_argsTypes_2_0= ruleOclType
            {

            					newCompositeNode(grammarAccess.getLambdaTypeAccess().getArgsTypesOclTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_31);
            lv_argsTypes_2_0=ruleOclType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLambdaTypeRule());
            					}
            					add(
            						current,
            						"argsTypes",
            						lv_argsTypes_2_0,
            						"fr.inria.diverse.docl.DOcl.OclType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalDOcl.g:3965:3: (otherlv_3= ',' ( (lv_argsTypes_4_0= ruleOclType ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==73) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalDOcl.g:3966:4: otherlv_3= ',' ( (lv_argsTypes_4_0= ruleOclType ) )
            	    {
            	    otherlv_3=(Token)match(input,73,FOLLOW_36); 

            	    				newLeafNode(otherlv_3, grammarAccess.getLambdaTypeAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalDOcl.g:3970:4: ( (lv_argsTypes_4_0= ruleOclType ) )
            	    // InternalDOcl.g:3971:5: (lv_argsTypes_4_0= ruleOclType )
            	    {
            	    // InternalDOcl.g:3971:5: (lv_argsTypes_4_0= ruleOclType )
            	    // InternalDOcl.g:3972:6: lv_argsTypes_4_0= ruleOclType
            	    {

            	    						newCompositeNode(grammarAccess.getLambdaTypeAccess().getArgsTypesOclTypeParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_argsTypes_4_0=ruleOclType();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getLambdaTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"argsTypes",
            	    							lv_argsTypes_4_0,
            	    							"fr.inria.diverse.docl.DOcl.OclType");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            otherlv_5=(Token)match(input,74,FOLLOW_15); 

            			newLeafNode(otherlv_5, grammarAccess.getLambdaTypeAccess().getRightParenthesisKeyword_4());
            		
            otherlv_6=(Token)match(input,19,FOLLOW_36); 

            			newLeafNode(otherlv_6, grammarAccess.getLambdaTypeAccess().getColonKeyword_5());
            		
            // InternalDOcl.g:3998:3: ( (lv_returnType_7_0= ruleOclType ) )
            // InternalDOcl.g:3999:4: (lv_returnType_7_0= ruleOclType )
            {
            // InternalDOcl.g:3999:4: (lv_returnType_7_0= ruleOclType )
            // InternalDOcl.g:4000:5: lv_returnType_7_0= ruleOclType
            {

            					newCompositeNode(grammarAccess.getLambdaTypeAccess().getReturnTypeOclTypeParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_2);
            lv_returnType_7_0=ruleOclType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLambdaTypeRule());
            					}
            					set(
            						current,
            						"returnType",
            						lv_returnType_7_0,
            						"fr.inria.diverse.docl.DOcl.OclType");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLambdaType"


    // $ANTLR start "entryRuleMapType"
    // InternalDOcl.g:4021:1: entryRuleMapType returns [EObject current=null] : iv_ruleMapType= ruleMapType EOF ;
    public final EObject entryRuleMapType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMapType = null;


        try {
            // InternalDOcl.g:4021:48: (iv_ruleMapType= ruleMapType EOF )
            // InternalDOcl.g:4022:2: iv_ruleMapType= ruleMapType EOF
            {
             newCompositeNode(grammarAccess.getMapTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMapType=ruleMapType();

            state._fsp--;

             current =iv_ruleMapType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMapType"


    // $ANTLR start "ruleMapType"
    // InternalDOcl.g:4028:1: ruleMapType returns [EObject current=null] : ( ( (lv_name_0_0= 'Map' ) ) otherlv_1= '(' ( (lv_keyType_2_0= ruleOclType ) ) otherlv_3= ',' ( (lv_valueType_4_0= ruleOclType ) ) otherlv_5= ')' ) ;
    public final EObject ruleMapType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_keyType_2_0 = null;

        EObject lv_valueType_4_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:4034:2: ( ( ( (lv_name_0_0= 'Map' ) ) otherlv_1= '(' ( (lv_keyType_2_0= ruleOclType ) ) otherlv_3= ',' ( (lv_valueType_4_0= ruleOclType ) ) otherlv_5= ')' ) )
            // InternalDOcl.g:4035:2: ( ( (lv_name_0_0= 'Map' ) ) otherlv_1= '(' ( (lv_keyType_2_0= ruleOclType ) ) otherlv_3= ',' ( (lv_valueType_4_0= ruleOclType ) ) otherlv_5= ')' )
            {
            // InternalDOcl.g:4035:2: ( ( (lv_name_0_0= 'Map' ) ) otherlv_1= '(' ( (lv_keyType_2_0= ruleOclType ) ) otherlv_3= ',' ( (lv_valueType_4_0= ruleOclType ) ) otherlv_5= ')' )
            // InternalDOcl.g:4036:3: ( (lv_name_0_0= 'Map' ) ) otherlv_1= '(' ( (lv_keyType_2_0= ruleOclType ) ) otherlv_3= ',' ( (lv_valueType_4_0= ruleOclType ) ) otherlv_5= ')'
            {
            // InternalDOcl.g:4036:3: ( (lv_name_0_0= 'Map' ) )
            // InternalDOcl.g:4037:4: (lv_name_0_0= 'Map' )
            {
            // InternalDOcl.g:4037:4: (lv_name_0_0= 'Map' )
            // InternalDOcl.g:4038:5: lv_name_0_0= 'Map'
            {
            lv_name_0_0=(Token)match(input,94,FOLLOW_29); 

            					newLeafNode(lv_name_0_0, grammarAccess.getMapTypeAccess().getNameMapKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMapTypeRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "Map");
            				

            }


            }

            otherlv_1=(Token)match(input,72,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getMapTypeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDOcl.g:4054:3: ( (lv_keyType_2_0= ruleOclType ) )
            // InternalDOcl.g:4055:4: (lv_keyType_2_0= ruleOclType )
            {
            // InternalDOcl.g:4055:4: (lv_keyType_2_0= ruleOclType )
            // InternalDOcl.g:4056:5: lv_keyType_2_0= ruleOclType
            {

            					newCompositeNode(grammarAccess.getMapTypeAccess().getKeyTypeOclTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_51);
            lv_keyType_2_0=ruleOclType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMapTypeRule());
            					}
            					set(
            						current,
            						"keyType",
            						lv_keyType_2_0,
            						"fr.inria.diverse.docl.DOcl.OclType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,73,FOLLOW_36); 

            			newLeafNode(otherlv_3, grammarAccess.getMapTypeAccess().getCommaKeyword_3());
            		
            // InternalDOcl.g:4077:3: ( (lv_valueType_4_0= ruleOclType ) )
            // InternalDOcl.g:4078:4: (lv_valueType_4_0= ruleOclType )
            {
            // InternalDOcl.g:4078:4: (lv_valueType_4_0= ruleOclType )
            // InternalDOcl.g:4079:5: lv_valueType_4_0= ruleOclType
            {

            					newCompositeNode(grammarAccess.getMapTypeAccess().getValueTypeOclTypeParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_34);
            lv_valueType_4_0=ruleOclType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMapTypeRule());
            					}
            					set(
            						current,
            						"valueType",
            						lv_valueType_4_0,
            						"fr.inria.diverse.docl.DOcl.OclType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getMapTypeAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMapType"


    // $ANTLR start "entryRuleTupleType"
    // InternalDOcl.g:4104:1: entryRuleTupleType returns [EObject current=null] : iv_ruleTupleType= ruleTupleType EOF ;
    public final EObject entryRuleTupleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleType = null;


        try {
            // InternalDOcl.g:4104:50: (iv_ruleTupleType= ruleTupleType EOF )
            // InternalDOcl.g:4105:2: iv_ruleTupleType= ruleTupleType EOF
            {
             newCompositeNode(grammarAccess.getTupleTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTupleType=ruleTupleType();

            state._fsp--;

             current =iv_ruleTupleType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTupleType"


    // $ANTLR start "ruleTupleType"
    // InternalDOcl.g:4111:1: ruleTupleType returns [EObject current=null] : otherlv_0= 'TupleType' ;
    public final EObject ruleTupleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:4117:2: (otherlv_0= 'TupleType' )
            // InternalDOcl.g:4118:2: otherlv_0= 'TupleType'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_2); 

            		newLeafNode(otherlv_0, grammarAccess.getTupleTypeAccess().getTupleTypeKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTupleType"


    // $ANTLR start "entryRuleOclAnyType"
    // InternalDOcl.g:4125:1: entryRuleOclAnyType returns [EObject current=null] : iv_ruleOclAnyType= ruleOclAnyType EOF ;
    public final EObject entryRuleOclAnyType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOclAnyType = null;


        try {
            // InternalDOcl.g:4125:51: (iv_ruleOclAnyType= ruleOclAnyType EOF )
            // InternalDOcl.g:4126:2: iv_ruleOclAnyType= ruleOclAnyType EOF
            {
             newCompositeNode(grammarAccess.getOclAnyTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOclAnyType=ruleOclAnyType();

            state._fsp--;

             current =iv_ruleOclAnyType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOclAnyType"


    // $ANTLR start "ruleOclAnyType"
    // InternalDOcl.g:4132:1: ruleOclAnyType returns [EObject current=null] : ( (lv_name_0_0= 'OclAny' ) ) ;
    public final EObject ruleOclAnyType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:4138:2: ( ( (lv_name_0_0= 'OclAny' ) ) )
            // InternalDOcl.g:4139:2: ( (lv_name_0_0= 'OclAny' ) )
            {
            // InternalDOcl.g:4139:2: ( (lv_name_0_0= 'OclAny' ) )
            // InternalDOcl.g:4140:3: (lv_name_0_0= 'OclAny' )
            {
            // InternalDOcl.g:4140:3: (lv_name_0_0= 'OclAny' )
            // InternalDOcl.g:4141:4: lv_name_0_0= 'OclAny'
            {
            lv_name_0_0=(Token)match(input,96,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getOclAnyTypeAccess().getNameOclAnyKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getOclAnyTypeRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "OclAny");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOclAnyType"


    // $ANTLR start "entryRuleSetType"
    // InternalDOcl.g:4156:1: entryRuleSetType returns [EObject current=null] : iv_ruleSetType= ruleSetType EOF ;
    public final EObject entryRuleSetType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetType = null;


        try {
            // InternalDOcl.g:4156:48: (iv_ruleSetType= ruleSetType EOF )
            // InternalDOcl.g:4157:2: iv_ruleSetType= ruleSetType EOF
            {
             newCompositeNode(grammarAccess.getSetTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSetType=ruleSetType();

            state._fsp--;

             current =iv_ruleSetType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetType"


    // $ANTLR start "ruleSetType"
    // InternalDOcl.g:4163:1: ruleSetType returns [EObject current=null] : ( ( (lv_name_0_0= 'Set' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' ) ;
    public final EObject ruleSetType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elementType_2_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:4169:2: ( ( ( (lv_name_0_0= 'Set' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' ) )
            // InternalDOcl.g:4170:2: ( ( (lv_name_0_0= 'Set' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' )
            {
            // InternalDOcl.g:4170:2: ( ( (lv_name_0_0= 'Set' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' )
            // InternalDOcl.g:4171:3: ( (lv_name_0_0= 'Set' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')'
            {
            // InternalDOcl.g:4171:3: ( (lv_name_0_0= 'Set' ) )
            // InternalDOcl.g:4172:4: (lv_name_0_0= 'Set' )
            {
            // InternalDOcl.g:4172:4: (lv_name_0_0= 'Set' )
            // InternalDOcl.g:4173:5: lv_name_0_0= 'Set'
            {
            lv_name_0_0=(Token)match(input,97,FOLLOW_29); 

            					newLeafNode(lv_name_0_0, grammarAccess.getSetTypeAccess().getNameSetKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSetTypeRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "Set");
            				

            }


            }

            otherlv_1=(Token)match(input,72,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getSetTypeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDOcl.g:4189:3: ( (lv_elementType_2_0= ruleOclType ) )
            // InternalDOcl.g:4190:4: (lv_elementType_2_0= ruleOclType )
            {
            // InternalDOcl.g:4190:4: (lv_elementType_2_0= ruleOclType )
            // InternalDOcl.g:4191:5: lv_elementType_2_0= ruleOclType
            {

            					newCompositeNode(grammarAccess.getSetTypeAccess().getElementTypeOclTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_34);
            lv_elementType_2_0=ruleOclType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSetTypeRule());
            					}
            					set(
            						current,
            						"elementType",
            						lv_elementType_2_0,
            						"fr.inria.diverse.docl.DOcl.OclType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getSetTypeAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetType"


    // $ANTLR start "entryRuleSequenceType"
    // InternalDOcl.g:4216:1: entryRuleSequenceType returns [EObject current=null] : iv_ruleSequenceType= ruleSequenceType EOF ;
    public final EObject entryRuleSequenceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSequenceType = null;


        try {
            // InternalDOcl.g:4216:53: (iv_ruleSequenceType= ruleSequenceType EOF )
            // InternalDOcl.g:4217:2: iv_ruleSequenceType= ruleSequenceType EOF
            {
             newCompositeNode(grammarAccess.getSequenceTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSequenceType=ruleSequenceType();

            state._fsp--;

             current =iv_ruleSequenceType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSequenceType"


    // $ANTLR start "ruleSequenceType"
    // InternalDOcl.g:4223:1: ruleSequenceType returns [EObject current=null] : ( ( (lv_name_0_0= 'Sequence' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' ) ;
    public final EObject ruleSequenceType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elementType_2_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:4229:2: ( ( ( (lv_name_0_0= 'Sequence' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' ) )
            // InternalDOcl.g:4230:2: ( ( (lv_name_0_0= 'Sequence' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' )
            {
            // InternalDOcl.g:4230:2: ( ( (lv_name_0_0= 'Sequence' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' )
            // InternalDOcl.g:4231:3: ( (lv_name_0_0= 'Sequence' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')'
            {
            // InternalDOcl.g:4231:3: ( (lv_name_0_0= 'Sequence' ) )
            // InternalDOcl.g:4232:4: (lv_name_0_0= 'Sequence' )
            {
            // InternalDOcl.g:4232:4: (lv_name_0_0= 'Sequence' )
            // InternalDOcl.g:4233:5: lv_name_0_0= 'Sequence'
            {
            lv_name_0_0=(Token)match(input,98,FOLLOW_29); 

            					newLeafNode(lv_name_0_0, grammarAccess.getSequenceTypeAccess().getNameSequenceKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSequenceTypeRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "Sequence");
            				

            }


            }

            otherlv_1=(Token)match(input,72,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getSequenceTypeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDOcl.g:4249:3: ( (lv_elementType_2_0= ruleOclType ) )
            // InternalDOcl.g:4250:4: (lv_elementType_2_0= ruleOclType )
            {
            // InternalDOcl.g:4250:4: (lv_elementType_2_0= ruleOclType )
            // InternalDOcl.g:4251:5: lv_elementType_2_0= ruleOclType
            {

            					newCompositeNode(grammarAccess.getSequenceTypeAccess().getElementTypeOclTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_34);
            lv_elementType_2_0=ruleOclType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSequenceTypeRule());
            					}
            					set(
            						current,
            						"elementType",
            						lv_elementType_2_0,
            						"fr.inria.diverse.docl.DOcl.OclType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getSequenceTypeAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSequenceType"


    // $ANTLR start "entryRuleOrderedSetType"
    // InternalDOcl.g:4276:1: entryRuleOrderedSetType returns [EObject current=null] : iv_ruleOrderedSetType= ruleOrderedSetType EOF ;
    public final EObject entryRuleOrderedSetType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrderedSetType = null;


        try {
            // InternalDOcl.g:4276:55: (iv_ruleOrderedSetType= ruleOrderedSetType EOF )
            // InternalDOcl.g:4277:2: iv_ruleOrderedSetType= ruleOrderedSetType EOF
            {
             newCompositeNode(grammarAccess.getOrderedSetTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrderedSetType=ruleOrderedSetType();

            state._fsp--;

             current =iv_ruleOrderedSetType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrderedSetType"


    // $ANTLR start "ruleOrderedSetType"
    // InternalDOcl.g:4283:1: ruleOrderedSetType returns [EObject current=null] : ( ( (lv_name_0_0= 'OrderedSet' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' ) ;
    public final EObject ruleOrderedSetType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elementType_2_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:4289:2: ( ( ( (lv_name_0_0= 'OrderedSet' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' ) )
            // InternalDOcl.g:4290:2: ( ( (lv_name_0_0= 'OrderedSet' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' )
            {
            // InternalDOcl.g:4290:2: ( ( (lv_name_0_0= 'OrderedSet' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' )
            // InternalDOcl.g:4291:3: ( (lv_name_0_0= 'OrderedSet' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')'
            {
            // InternalDOcl.g:4291:3: ( (lv_name_0_0= 'OrderedSet' ) )
            // InternalDOcl.g:4292:4: (lv_name_0_0= 'OrderedSet' )
            {
            // InternalDOcl.g:4292:4: (lv_name_0_0= 'OrderedSet' )
            // InternalDOcl.g:4293:5: lv_name_0_0= 'OrderedSet'
            {
            lv_name_0_0=(Token)match(input,99,FOLLOW_29); 

            					newLeafNode(lv_name_0_0, grammarAccess.getOrderedSetTypeAccess().getNameOrderedSetKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOrderedSetTypeRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "OrderedSet");
            				

            }


            }

            otherlv_1=(Token)match(input,72,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getOrderedSetTypeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDOcl.g:4309:3: ( (lv_elementType_2_0= ruleOclType ) )
            // InternalDOcl.g:4310:4: (lv_elementType_2_0= ruleOclType )
            {
            // InternalDOcl.g:4310:4: (lv_elementType_2_0= ruleOclType )
            // InternalDOcl.g:4311:5: lv_elementType_2_0= ruleOclType
            {

            					newCompositeNode(grammarAccess.getOrderedSetTypeAccess().getElementTypeOclTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_34);
            lv_elementType_2_0=ruleOclType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrderedSetTypeRule());
            					}
            					set(
            						current,
            						"elementType",
            						lv_elementType_2_0,
            						"fr.inria.diverse.docl.DOcl.OclType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getOrderedSetTypeAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrderedSetType"


    // $ANTLR start "entryRuleBagType"
    // InternalDOcl.g:4336:1: entryRuleBagType returns [EObject current=null] : iv_ruleBagType= ruleBagType EOF ;
    public final EObject entryRuleBagType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBagType = null;


        try {
            // InternalDOcl.g:4336:48: (iv_ruleBagType= ruleBagType EOF )
            // InternalDOcl.g:4337:2: iv_ruleBagType= ruleBagType EOF
            {
             newCompositeNode(grammarAccess.getBagTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBagType=ruleBagType();

            state._fsp--;

             current =iv_ruleBagType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBagType"


    // $ANTLR start "ruleBagType"
    // InternalDOcl.g:4343:1: ruleBagType returns [EObject current=null] : ( ( (lv_name_0_0= 'BagType' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' ) ;
    public final EObject ruleBagType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_elementType_2_0 = null;



        	enterRule();

        try {
            // InternalDOcl.g:4349:2: ( ( ( (lv_name_0_0= 'BagType' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' ) )
            // InternalDOcl.g:4350:2: ( ( (lv_name_0_0= 'BagType' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' )
            {
            // InternalDOcl.g:4350:2: ( ( (lv_name_0_0= 'BagType' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')' )
            // InternalDOcl.g:4351:3: ( (lv_name_0_0= 'BagType' ) ) otherlv_1= '(' ( (lv_elementType_2_0= ruleOclType ) ) otherlv_3= ')'
            {
            // InternalDOcl.g:4351:3: ( (lv_name_0_0= 'BagType' ) )
            // InternalDOcl.g:4352:4: (lv_name_0_0= 'BagType' )
            {
            // InternalDOcl.g:4352:4: (lv_name_0_0= 'BagType' )
            // InternalDOcl.g:4353:5: lv_name_0_0= 'BagType'
            {
            lv_name_0_0=(Token)match(input,100,FOLLOW_29); 

            					newLeafNode(lv_name_0_0, grammarAccess.getBagTypeAccess().getNameBagTypeKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getBagTypeRule());
            					}
            					setWithLastConsumed(current, "name", lv_name_0_0, "BagType");
            				

            }


            }

            otherlv_1=(Token)match(input,72,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getBagTypeAccess().getLeftParenthesisKeyword_1());
            		
            // InternalDOcl.g:4369:3: ( (lv_elementType_2_0= ruleOclType ) )
            // InternalDOcl.g:4370:4: (lv_elementType_2_0= ruleOclType )
            {
            // InternalDOcl.g:4370:4: (lv_elementType_2_0= ruleOclType )
            // InternalDOcl.g:4371:5: lv_elementType_2_0= ruleOclType
            {

            					newCompositeNode(grammarAccess.getBagTypeAccess().getElementTypeOclTypeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_34);
            lv_elementType_2_0=ruleOclType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBagTypeRule());
            					}
            					set(
            						current,
            						"elementType",
            						lv_elementType_2_0,
            						"fr.inria.diverse.docl.DOcl.OclType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,74,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getBagTypeAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBagType"


    // $ANTLR start "entryRuleRealType"
    // InternalDOcl.g:4396:1: entryRuleRealType returns [EObject current=null] : iv_ruleRealType= ruleRealType EOF ;
    public final EObject entryRuleRealType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRealType = null;


        try {
            // InternalDOcl.g:4396:49: (iv_ruleRealType= ruleRealType EOF )
            // InternalDOcl.g:4397:2: iv_ruleRealType= ruleRealType EOF
            {
             newCompositeNode(grammarAccess.getRealTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRealType=ruleRealType();

            state._fsp--;

             current =iv_ruleRealType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRealType"


    // $ANTLR start "ruleRealType"
    // InternalDOcl.g:4403:1: ruleRealType returns [EObject current=null] : ( (lv_name_0_0= 'Real' ) ) ;
    public final EObject ruleRealType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:4409:2: ( ( (lv_name_0_0= 'Real' ) ) )
            // InternalDOcl.g:4410:2: ( (lv_name_0_0= 'Real' ) )
            {
            // InternalDOcl.g:4410:2: ( (lv_name_0_0= 'Real' ) )
            // InternalDOcl.g:4411:3: (lv_name_0_0= 'Real' )
            {
            // InternalDOcl.g:4411:3: (lv_name_0_0= 'Real' )
            // InternalDOcl.g:4412:4: lv_name_0_0= 'Real'
            {
            lv_name_0_0=(Token)match(input,101,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getRealTypeAccess().getNameRealKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getRealTypeRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "Real");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRealType"


    // $ANTLR start "entryRuleIntegerType"
    // InternalDOcl.g:4427:1: entryRuleIntegerType returns [EObject current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final EObject entryRuleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerType = null;


        try {
            // InternalDOcl.g:4427:52: (iv_ruleIntegerType= ruleIntegerType EOF )
            // InternalDOcl.g:4428:2: iv_ruleIntegerType= ruleIntegerType EOF
            {
             newCompositeNode(grammarAccess.getIntegerTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerType=ruleIntegerType();

            state._fsp--;

             current =iv_ruleIntegerType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerType"


    // $ANTLR start "ruleIntegerType"
    // InternalDOcl.g:4434:1: ruleIntegerType returns [EObject current=null] : ( (lv_name_0_0= 'Integer' ) ) ;
    public final EObject ruleIntegerType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:4440:2: ( ( (lv_name_0_0= 'Integer' ) ) )
            // InternalDOcl.g:4441:2: ( (lv_name_0_0= 'Integer' ) )
            {
            // InternalDOcl.g:4441:2: ( (lv_name_0_0= 'Integer' ) )
            // InternalDOcl.g:4442:3: (lv_name_0_0= 'Integer' )
            {
            // InternalDOcl.g:4442:3: (lv_name_0_0= 'Integer' )
            // InternalDOcl.g:4443:4: lv_name_0_0= 'Integer'
            {
            lv_name_0_0=(Token)match(input,102,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getIntegerTypeAccess().getNameIntegerKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getIntegerTypeRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "Integer");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerType"


    // $ANTLR start "entryRuleBooleanType"
    // InternalDOcl.g:4458:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // InternalDOcl.g:4458:52: (iv_ruleBooleanType= ruleBooleanType EOF )
            // InternalDOcl.g:4459:2: iv_ruleBooleanType= ruleBooleanType EOF
            {
             newCompositeNode(grammarAccess.getBooleanTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanType=ruleBooleanType();

            state._fsp--;

             current =iv_ruleBooleanType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanType"


    // $ANTLR start "ruleBooleanType"
    // InternalDOcl.g:4465:1: ruleBooleanType returns [EObject current=null] : ( (lv_name_0_0= 'Boolean' ) ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:4471:2: ( ( (lv_name_0_0= 'Boolean' ) ) )
            // InternalDOcl.g:4472:2: ( (lv_name_0_0= 'Boolean' ) )
            {
            // InternalDOcl.g:4472:2: ( (lv_name_0_0= 'Boolean' ) )
            // InternalDOcl.g:4473:3: (lv_name_0_0= 'Boolean' )
            {
            // InternalDOcl.g:4473:3: (lv_name_0_0= 'Boolean' )
            // InternalDOcl.g:4474:4: lv_name_0_0= 'Boolean'
            {
            lv_name_0_0=(Token)match(input,103,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getBooleanTypeAccess().getNameBooleanKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getBooleanTypeRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "Boolean");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanType"


    // $ANTLR start "entryRuleStringType"
    // InternalDOcl.g:4489:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // InternalDOcl.g:4489:51: (iv_ruleStringType= ruleStringType EOF )
            // InternalDOcl.g:4490:2: iv_ruleStringType= ruleStringType EOF
            {
             newCompositeNode(grammarAccess.getStringTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringType=ruleStringType();

            state._fsp--;

             current =iv_ruleStringType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringType"


    // $ANTLR start "ruleStringType"
    // InternalDOcl.g:4496:1: ruleStringType returns [EObject current=null] : ( (lv_name_0_0= 'String' ) ) ;
    public final EObject ruleStringType() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalDOcl.g:4502:2: ( ( (lv_name_0_0= 'String' ) ) )
            // InternalDOcl.g:4503:2: ( (lv_name_0_0= 'String' ) )
            {
            // InternalDOcl.g:4503:2: ( (lv_name_0_0= 'String' ) )
            // InternalDOcl.g:4504:3: (lv_name_0_0= 'String' )
            {
            // InternalDOcl.g:4504:3: (lv_name_0_0= 'String' )
            // InternalDOcl.g:4505:4: lv_name_0_0= 'String'
            {
            lv_name_0_0=(Token)match(input,104,FOLLOW_2); 

            				newLeafNode(lv_name_0_0, grammarAccess.getStringTypeAccess().getNameStringKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getStringTypeRule());
            				}
            				setWithLastConsumed(current, "name", lv_name_0_0, "String");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringType"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x00000000000C0002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x7FFFFFFFC18000D0L,0x0000000010FC8980L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x3FFFFFFFC00000D0L,0x0000000010FC8980L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000003L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000002L,0x000000000000003CL});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000800002L,0x0000000000000040L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000020002L,0x0000000000000080L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000020040002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x7FFFFFFFC18000D0L,0x0000000010FC8D80L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000600L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000200L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000010L,0x000001FFE0008000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001200L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000040002L,0x0000000000002000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020200L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000002L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000000L,0x000000000A000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000004000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});

}