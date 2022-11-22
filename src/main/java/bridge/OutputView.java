package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static bridge.BridgeGame.count;
import static bridge.Constant.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    @Deprecated
    public void printAnswer(List<String> map) {
        StringBuilder AnswerUp = new StringBuilder();
        StringBuilder AnswerDown = new StringBuilder();
        for (String bridge : map) {
            if (bridge == "U") {
                AnswerUp.append("[ O ]");
                AnswerDown.append("[   ]");
            } else if (bridge == "D") {
                AnswerUp.append("[   ]");
                AnswerDown.append("[ O ]");
            }
        }
        System.out.println(AnswerUp);
        System.out.println(AnswerDown);
    }

    public static String[] print(List<String> bridge, List<String> map) {
        List<String> printUp = new ArrayList<>();
        List<String> printDown = new ArrayList<>();

        for (int i = 0; i < map.size(); i++) {
            if ((Objects.equals(bridge.get(i), map.get(i))) && (Objects.equals(map.get(i), "U"))) {
                printUp.add("O");
                printDown.add(" ");
            }
            if ((!Objects.equals(bridge.get(i), map.get(i))) && (Objects.equals(map.get(i), "U"))) {
                printUp.add("X");
                printDown.add(" ");
            }
            if ((Objects.equals(bridge.get(i), map.get(i))) && (Objects.equals(map.get(i), "D"))) {
                printUp.add(" ");
                printDown.add("O");
            }
            if ((!Objects.equals(bridge.get(i), map.get(i))) && (Objects.equals(map.get(i), "D"))) {
                printUp.add(" ");
                printDown.add("X");
            }
        }
        return printAsBridge(printUp, printDown);
    }

    public static void compareBridge(int loop, List<String> bridge, List<String> map) {
        if ((Objects.equals(bridge.get(loop), map.get(loop))) && (Objects.equals(map.get(loop), "U"))) {
            putUpO();
        }
        if ((!Objects.equals(bridge.get(loop), map.get(loop))) && (Objects.equals(map.get(loop), "U"))) {
            putUpX();
        }
        if ((Objects.equals(bridge.get(loop), map.get(loop))) && (Objects.equals(map.get(loop), "D"))) {
            putDownO();
        }
        if ((!Objects.equals(bridge.get(loop), map.get(loop))) && (Objects.equals(map.get(loop), "D"))) {
            putDownX();
        }
    }
    public static void putUpO(){

    }

    public static void putUpX(){

    }

    public static void putDownO(){

    }

    public static void putDownX(){

    }

    public static String[] printAsBridge(List<String> printUp, List<String> printDown) {
        String printUptoString = String.join(" | ", printUp);
        printUptoString = "[ " + printUptoString + " ]";
        String printDowntoString = String.join(" | ", printDown);
        printDowntoString = "[ " + printDowntoString + " ]";
        return new String[]{printDowntoString, printUptoString};
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printGame(String[] Result) {
        System.out.println(Result[1]);
        System.out.println(Result[0]);
    }

    public static void printResult(String[] Result, boolean success) {
        System.out.println(TOTAL_GAME_RESULT);
        System.out.println(Result[1]);
        System.out.println(Result[0]);
        System.out.println(SUCCESS_FAIL + SuccessFail(success));
        System.out.println(TOTAL_COUNT + count);
    }

    public static String SuccessFail(boolean success) {
        if (success) {
            return SUCCESS;
        }
        return FAIL;
    }
}
