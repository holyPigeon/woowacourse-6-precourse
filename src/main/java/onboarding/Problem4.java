package onboarding;

public class Problem4 {
    public static String solution(String word) {
        return getSolution(word);
    }

    public static String getSolution(String string) {
        try {
            validateStringLength(string);
        } catch (IllegalArgumentException exception) {
            System.out.println("ERROR -> " + exception.getMessage());
        }

        return convertWord(string);
    }

    public static String convertWord(String string) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (Character.isUpperCase(c)) { // 대문자인 경우만 변환
                int diff = c - 'A';
                char convertedChar = (char) ('Z' - diff);
                sb.append(convertedChar);
            } else if (Character.isLowerCase(c)) { // 소문자인 경우만 변환
                int diff = c - 'a';
                char convertedChar = (char) ('z' - diff);
                sb.append(convertedChar);
            } else { // 알파벳이 아닌 경우 그대로 추가
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void validateStringLength(String string) {
        if (string.length() < 1 || string.length() > 1000) {
            throw new IllegalArgumentException("입력 문자열의 길이는 1 이상 1,000 이하이어야 합니다.");
        }
    }
}
