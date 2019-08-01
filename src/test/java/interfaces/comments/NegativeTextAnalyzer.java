package interfaces.comments;

/**
 * Created by delonj on 23/07/2019.
 */
class NegativeTextAnalyzer extends KeywordAnalyzer {

    @Override
    protected String[] getKeywords() {
        return new String[]{":(", "=(", ":|"};
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}
