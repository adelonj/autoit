package interfaces.comments;

/**
 * Created by delonj on 23/07/2019.
 */

/**
 * Выделим два абстрактных метода getKeywords и getLabel, один из которых будет возвращать набор ключевых слов, а второй метку, которой необходимо пометить положительные срабатывания. Нам незачем показывать эти методы потребителям классов, поэтому оставим доступ к ним только для наследников.
 */
abstract class KeywordAnalyzer implements TextAnalyzer{
    /**
     * @return  набор ключевых слов
     */
    protected abstract String[] getKeywords();

    /**
     * @return метку, которой необходимо пометить положительные срабатывания
     */
    protected abstract Label getLabel();


    @Override
    public Label processText(String text) {
        for(String k : getKeywords()) {
            if (text.contains(k)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

}
