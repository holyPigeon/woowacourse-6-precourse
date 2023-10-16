package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        return getSolution(cryptogram);
    }

    static String getSolution(String crypto) {
        try {
            validateCrypto(crypto);
        } catch (IllegalArgumentException exception) {
            System.out.println("ERROR ->" + exception.getMessage());
        }

        return removeDuplicateChar(crypto);
    }

    static String removeDuplicateChar(String crypto) {
        String result = crypto;
        boolean isDuplicateCharExist;

        do { // 최소한 한 번의 while문 실행을 통해 해당 문자열에 중복된 문자가 있는지 검사
            isDuplicateCharExist = false;
            for (int i = 0; i < result.length() - 1; i++) {
                if (result.charAt(i) == result.charAt(i + 1)) { // 만약 연속으로 중복된 문자가 발견된다면 해당 문자들을 모두 제거한다.
                    result = result.substring(0, i) + result.substring(i + 2);
                    isDuplicateCharExist = true;
                    break; // for문을 탈출 후, index=0부터 다시 중복된 문자를 조사한다.
                }
            }
        } while(isDuplicateCharExist);

        return result;
    }

    static void validateCrypto(String crypto) {
        validateCryptoLength(crypto);
        validateCryptoLowerCase(crypto);
    }

    static void validateCryptoLength(String crypto) {
        if (crypto.length() < 1 || crypto.length() > 100) {
            throw new IllegalArgumentException("길이가 1 이상 1000 이하인 문자열이 아닙니다.");
        }
    }

    static void validateCryptoLowerCase(String crypto) {
        for (int i = 0; i < crypto.length(); i++) {
            if (Character.isUpperCase(crypto.charAt(i))) {
                throw new IllegalArgumentException("소문자로만 이루어진 문자열이 아닙니다.");
            }
        }
    }
}
