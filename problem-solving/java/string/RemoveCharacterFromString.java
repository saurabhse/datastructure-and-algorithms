package string;

public class RemoveCharacterFromString {

    public static void main(String[] args) {
        RemoveCharacterFromString removeCharacterFromString = new RemoveCharacterFromString();
        System.out.println(removeCharacterFromString.removeCharacter("abc abc",'a'));
        System.out.println (removeCharInString
                ("abc abc",  'a'));

    }

    private String removeCharacter(String text, char charToRemove){
        return text.replace(String.valueOf(charToRemove),"");
    }

    public static String removeCharInString
            (String str, char charToBeRemoved) {
        if (str == null)
            return "";
        StringBuilder strBuild = new StringBuilder ();
        for (int i = 0; i < str.length (); i++) {
            char ch = str.charAt (i);
            if (ch == charToBeRemoved)
                continue;
            strBuild.append (ch);
        }
        return strBuild.toString ();
    }
}
