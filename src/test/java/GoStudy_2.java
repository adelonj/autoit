
import java.util.Arrays;

/**
 * Created by delonj on 11/07/2019.
 */
public class GoStudy_2 {

    public static void main(String[] args) {
        String[] roles = {"Городничий", "Аммос Федорович", "Артемий Филиппович", "Анна", "Лука Лукич"};
        String[] textLines = {"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
        };

        System.out.println(printTextPerRole(roles, textLines));
    }


    private static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder text = new StringBuilder();


        for (String role : roles) {
            boolean printName = true;

            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role + ":")) {
                    if (printName) {
                        text.append(role).append(":\n");
                        printName = false;
                    }
                    int num = i + 1;
                    text.append(num).append(")").append(textLines[i].replaceFirst(role +":",""))
                            .append("\n");
                }
                if (i == textLines.length - 1) {
                    if (printName) {
                        text.append(role);
                        text.append(":\n");
                    }
                    text.append("\n");
                }
            }
        }
        return text.toString();
    }
}

