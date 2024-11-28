public class password {
    private static String convert(String fullName) {
        String[] word = fullName.split(" ");

        String words = "";
        for (int i = 0; i < word.length; i++) {
            char[] russian =   {' ','а','б','в','г','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
            StringBuilder builder = getStringBuilder(word[i], russian);
            words += " "+builder.toString();
        }
        return words;
    }

    private static StringBuilder getStringBuilder(String fullName, char[] russian) {
        String[] latin = {" ", "a", "b", "v", "g","e","yo","zh","z","i","iy","k","l","m","n","o","p","r","s","t","u","f","h","c","sh","sh","","","","yu","ya"};
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < fullName.length(); i++) {
            for (int x = 0; x < russian.length; x++ ) {
                if (fullName.charAt(i) == russian[x]) {
                    builder.append(latin[x]);
                }
            }
        }
        return builder;
    }
    private  static String refactorPassword(String fullName) {
        String[] fullNameSplit = fullName.strip().split(" ");
        String name = fullNameSplit[0]+".";

        for (int i = 1; i < fullNameSplit.length; i++) {
            name += fullNameSplit[i].substring(0,1);
        }
        return  name;
    }
    public static String create(String fullName) {
        return refactorPassword(convert(fullName));
    }

}
