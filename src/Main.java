import java.util.Scanner;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        openIntro();
    }

    //Сканер
    public static Scanner sc = new Scanner(System.in);

    //Ожидание ввода Enter
    private static void waitEnter(){
        System.out.print("\nДля продолжения нажмите Enter...\n");
        sc.nextLine();
    }

    //Вступление
    private static void openIntro() {
        System.out.print("Добро пожаловать, падшая душа, в тест, где ты узнаешь, сможешь ли ты получить 44 миллиарда вон!\n\n");
        openMainMenu();
    }
    //Главное меню
    private static void openMainMenu() {
        while (true) {
            ////Ошибка с не целым числом
            System.out.print("1) Сбежать, как нормальный человек\n2) Продолжить, вы готовы убивать неввинных людей и детей\nВаш выбор: ");
                int answer_chose = Integer.parseInt(sc.nextLine().replaceAll("\\s", ""));
            switch (answer_chose) {
                case 1:
                    exitProgramm();
                    break;
                case 2:
                    System.out.println("\nУхты, от тебя такого и не ожидал.");
                    openTest();
                    break;
                default:
                    System.out.println("\nТакого пункта нету, прекрати ломать программу!");
                    waitEnter();
            }
        }
    }

    //Создание массивов ответов, вопросов и вывод ответа
    private static void openTest(){
        //Стоит вынести
        HashMap<Integer, String> phraseIfResult = new HashMap<>();
        phraseIfResult.put(10, "Ёмаё, да ты морально разложившийся человек!\nТы определенно выиграешь!");
        phraseIfResult.put(9, "Долги так сильно на тебя давят, что ты готов убивать невинных?\nПарень до тебя был получше.");
        phraseIfResult.put(8, "Тяжелая ситуация в жизни?\nМожешь попробовать, но я бы не рассчитывал на что то.");
        phraseIfResult.put(7, "Отбираешь у детей конфетки?\nУмрешь в предпоследней игре.");
        phraseIfResult.put(6, "А ты немного садист.\nЛучше откажись, целее будешь.");
        phraseIfResult.put(5, "Ни рыба ни мясо.\nПросто уйди, такой серости здесь не место.");
        phraseIfResult.put(4, "Думаешь то, что ты называешь в себе волей, это воля?\nСмотри, чтобы тебя школьник не задавил.");
        phraseIfResult.put(3, "Пытаешься найти в себе волю? Её нет.\nСмотри, чтобы тебя не подавила маленькая девочка.");
        phraseIfResult.put(2, "Еще немного и ты на дне.\nА чего тебе еще терять, определенно иди!");
        phraseIfResult.put(1, "Червяк, вот, что я о тебе думаю.\nНо попробовать стоит, может сможешь незаметно проползти к финишу.");
        String[] questions = arrayQuestions();
        String[][] answers = arrayAnswers();
        int countSuccess = getAnswers(questions, answers);
        System.out.println();
        System.out.println(phraseIfResult.get(countSuccess));
        System.out.println();

    }

    //Вывод вопроса и подсчет ответов
    private static int getAnswers(String[] questions, String[][] answers) {
        int resultInNum = 0;
        for (int ques_num = 0; ques_num < questions.length; ques_num++) {
            boolean correctInput = false;
            do {
                System.out.println(ques_num + 1 + ") " + questions[ques_num]);
                for (int i = 0; i < answers[ques_num].length; i++) {
                    System.out.println("\t" + (i+1) + ") " + answers[ques_num][i]);
                }
                System.out.print("Ваш выбор: ");
                int inputAnswerUser = Integer.parseInt(sc.nextLine().replaceAll("\\s", ""));
                if (inputAnswerUser == 1) {
                } else if (inputAnswerUser == 2) {
                    resultInNum++;
                } else {
                    System.out.println("\nТакого пункта нету, прекрати ломать программу!");
                    waitEnter();
                    continue;
                }
                correctInput = true;

            } while (!correctInput);
            System.out.println();
        }
        return resultInNum;

    }

    //Выход
    private static void exitProgramm() {
        System.out.println("\nХаха, что еще от тебя можно было ожидать, проваливай!");
        System.exit(0);
    }

    private static String[] arrayQuestions() {
        return new String[]{
                "Ты легко доверяешь людям?", "А часто бывает, что в стрессовых ситуациях ты начинаешь паниковать?",
                "Представь, ты попадаешь в игру, и один из участников забирает твой обед. Что будешь делать?",
                "А теперь честно! Представь, вы играете с другом «на смерть». Смог бы предать его, чтобы выжить?",
                "Ты узнаешь, что ночью игроки планируют устроить бойню. Твои действия?",
                "Если бы ты узнал, какой будет следующий раунд игры, сказал бы своим друзьям?",
                "А как у тебя обстоят дела с физической подготовкой?",
                "Представь, один из пожилых участников нуждается в помощи. Что будешь делать?",
                "Тебе вообще часто везет в жизни?",
                "Представь, ты увидел огромную куклу,которая следит за каждым твоим шагом. Твои действия?"
        };

    }

    private static String[][] arrayAnswers() {
        return new String[][]{
                {"Да, с этим у меня проблем нет", "Я никому не доверяю"},
                {"Паника - мое второе имя", "Я всегда веду себя спокойно"},
                {"Еда - самое важное! Устрою скандал или драку!", "Лучше не создавать лишних проблем... протяну без еды"},
                {"Нет, не смогу", "Не хочу признавать, но да..."},
                {"Найду место, где меня никто не заметит и спрячусь", "Найду, чем защищаться и нападать"},
                {"Конечно!", "Пожалуй, нет"},
                {"Через минуту бега уже колит в боку... Стоит продолжать?", "Отлично!"},
                {"Конечно, помогу", "Это не моя проблема"},
                {"Ой, это вообще не про меня", "Да, я везунчик"},
                {"Замру от ужаса", "Сфотографирую ее в Instagram"}
        };
    }
}
