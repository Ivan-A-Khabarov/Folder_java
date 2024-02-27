package DZ2.dz1;

class Answer {

    public static StringBuilder answer(String QUERY, String PARAMS) {
        StringBuilder result = new StringBuilder();

        // Проверка, что параметры не пусты
        if (PARAMS != null && !PARAMS.isEmpty()) {
            // Удаляем фигурные скобки из переданных параметров
            PARAMS = PARAMS.replaceAll("\\{", "").replaceAll("\\}", "");

            // Разбиваем параметры на отдельные пары ключ-значение
            String[] paramsArray = PARAMS.split(",");

            // Перебираем все пары ключ-значение и проверяем, подходят ли они под запрос
            for (String param : paramsArray) {
                // Разбиваем каждую пару на ключ и значение
                String[] keyValue = param.trim().split(":");
                String key = keyValue[0].replaceAll("\"", "").trim();
                String value = keyValue[1].replaceAll("\"", "").trim();

                // Если ключ не пустой и значение не пустое и не равно "null", добавляем условие к запросу
                if (!key.isEmpty() && !value.isEmpty() && !value.equals("null")) {
                    result.append(key).append("='").append(value).append("' and ");
                }
            }

            // Удаляем последний "AND " из запроса
            if (result.length() > 5) {
                result.delete(result.length() - 5, result.length());
            }
        }

        // Добавляем запрос в начало результата
        result.insert(0, QUERY);

        return result;
    }

    // Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
    public static class Printer {
        public static void main(String[] args) {
            String QUERY = "";
            String PARAMS = "";

            if (args.length == 0) {
                // При отправке кода на Выполнение, вы можете варьировать эти параметры
                QUERY = "select * from students where ";
                PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
            } else {
                QUERY = args[0];
                PARAMS = args[1];
            }

            Answer ans = new Answer();
            System.out.println(ans.answer(QUERY, PARAMS));
        }
    }
}



public class Printer{
    public static void main(String[] args) {
        String QUERY = "";
        String PARAMS = "";

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            QUERY = "select * from students where ";
            PARAMS = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"} ";
        }
        else{
            QUERY = args[0];
            PARAMS = args[1];
        }

        Answer ans = new Answer();
        System.out.println(ans.answer(QUERY, PARAMS));
    }
}