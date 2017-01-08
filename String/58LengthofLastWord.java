58. Length of Last Word

public int lengthOfLastWord(String s) {
        String news = s.trim();
        int index = news.lastIndexOf(" ");
        return news.length() - index - 1;
    }