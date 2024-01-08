package machine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Actions {

    BUY("buy"),
    FILL("fill"),
    TAKE("take"),
    REMAINING("remaining"),
    EXIT("exit");

    private final String name;
    Actions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String getPossibleActionsAsStringSurroundedByParanthesis() {
        List<String> actionList = new ArrayList<>();
        for(Actions action : values()) {
            actionList.add(action.getName());
        }

        return Arrays.toString(actionList.toArray())
                .replace('[', '(')
                .replace(']', ')');

    }
}


