package utilities;

import controller.actions.IAction;

import java.lang.reflect.Constructor;
import java.util.HashMap;

public final class FindAction {

    private static HashMap<String, String> urlToClassMap;

    private FindAction() {
    }

    static {
        urlToClassMap = new HashMap<>();
        fillActionsToMap();
    }

    private static void fillActionsToMap() {
        String convertedXml = TransformationUtil.getXml(WebFilesPaths.ACTION_XML_PATH, WebFilesPaths.ACTION_XSL_PATH);

        String actionUrl;
        String actionClass;
        String[] lines = convertedXml.split(System.lineSeparator());
        for (int i = 1; i < lines.length; i++) {
            String[] line = lines[i].trim().split(" ");
            actionUrl = line[0];
            actionClass = line[1];
            urlToClassMap.put(actionUrl, actionClass);
        }
    }

    public static IAction getAction(String requestURL) {

        try {
            Class<?> action = Class.forName(urlToClassMap.get(requestURL));
            Constructor actionConstructor = action.getConstructor();
            return (IAction) actionConstructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
