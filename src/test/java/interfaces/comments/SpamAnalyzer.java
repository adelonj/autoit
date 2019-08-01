package interfaces.comments;

/**
 * Created by delonj on 23/07/2019.
 */
class SpamAnalyzer extends KeywordAnalyzer  {
    private String[] keywordsArr;
    private Label currentLabel;

    public SpamAnalyzer(String[] keywords) {
        this.keywordsArr = keywords;
    }

    @Override
    protected String[] getKeywords() {
        return keywordsArr;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}
