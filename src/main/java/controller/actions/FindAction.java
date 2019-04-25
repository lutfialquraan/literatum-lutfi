package controller.actions;

import utilities.TransformationUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public final class FindAction {

    private static HashMap <String,String> urlToClassMap;

    private FindAction(){}

    static {
        urlToClassMap = new HashMap<String, String>();
        fillActionsToMap();
    }

    private static void fillActionsToMap ()
    {
        String convertedXml = TransformationUtil.getXml("/home/lquran/Desktop/Litratum/literatum-lutfi/web/actions/actions.xml","/home/lquran/Desktop/Litratum/literatum-lutfi/web/actions/actions.xsl");
//        String convertedXml = TransformationUtil.getXml("C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\literatum-lutfi\\web\\actions\\actions.xml","C:\\Users\\LUTFI\\Desktop\\lutfi-atypon\\literatum-lutfi\\web\\actions\\actions.xsl");
        String actionUrl;
        String actionClass;
        String [] lines = convertedXml.split(System.lineSeparator());

        for (int i = 1; i<lines.length;i++)
        {
            String [] line = lines[i].trim().split(" ");
            actionUrl=line[0];
            actionClass=line[1];
            urlToClassMap.put(actionUrl,actionClass);
        }


    }


    public static IAction findAction(String requestURL) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {


        Class<?> action = Class.forName(urlToClassMap.get(requestURL));
        Constructor actionConstructor = action.getConstructor();
        return (IAction) actionConstructor.newInstance();
    }
}
