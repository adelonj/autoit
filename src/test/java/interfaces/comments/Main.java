package interfaces.comments;

/**
 * Created by delonj on 23/07/2019.
 */
public class Main {
    public static void main(String[] args) {
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"спам", "bad"};
        int commentMaxLength = 40;
        TextAnalyzer[] textAnalyzers = {new SpamAnalyzer(spamKeywords), new NegativeTextAnalyzer(), new TooLongTextAnalyzer(20)};
//        for(TextAnalyzer t: textAnalyzers){
//            System.out.println(t.getClass());
//            System.out.println(t.processText("This comment is so good."));
//            System.out.println(t.processText("This comment is so bad."));
//            System.out.println(t.processText("This comment is so bad:("));
//            System.out.println(t.processText("This is spam =("));
//            System.out.println(t.processText("This is =("));
//        }


        System.out.println(checkLabels(textAnalyzers, "Привет, это точно не спам, я-то знаю :("));
        System.out.println(checkLabels(textAnalyzers, "Привет"));
    }

    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for(TextAnalyzer t: analyzers){
            if(!t.processText(text).equals(Label.OK))
                return t.processText(text);
        }
        return Label.OK;
    }
}
