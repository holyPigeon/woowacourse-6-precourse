package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        return getSolution(forms);
    }

    public static List<String> getSolution(List<List<String>> forms) {
        try {
            validateForm(forms);
        } catch (IllegalArgumentException exception) {
            System.out.println("ERROR -> " + exception.getMessage());
        }

        return getAscSortedList(getDuplicateEmailList(forms));
    }

     public static List<String> getAscSortedList(List<String> list) {
         Collections.sort(list);
         return list;
     }

    public static List<String> getDuplicateEmailList(List<List<String>> forms) {
        return findDuplicates(forms);
    }

    private static List<String> findDuplicates(List<List<String>> data) {
        Map<String, String> substrings = new HashMap<>();
        Set<String> duplicates = new HashSet<>();

        for (List<String> entry : data){
            processNickname(substrings, duplicates, entry.get(1), entry.get(0));
        }

        return new ArrayList<>(duplicates);
    }

    private static void processNickname(Map<String, String> substrings,
                                        Set<String> duplicates,
                                        String nickname,
                                        String email){
        int windowSize = 2;

        for(int i=0; i<=nickname.length()-windowSize; i++){
            String subStr=nickname.substring(i,i+windowSize);

            if(substrings.containsKey(subStr)){
                duplicates.add(email);
                duplicates.add(substrings.get(subStr));
            } else{
                substrings.put(subStr, email);
            }
        }
    }

    public static void validateForm(List<List<String>> forms) {
        validateCrewNumber(forms);
        validateEmailLength(forms);
        validateEmailForm(forms);
        validateNicknameLength(forms);
    }

    public static void validateCrewNumber(List<List<String>> forms) {
        int crewNumber = forms.size();

        if (crewNumber < 1 || crewNumber > 10000) {
            throw new IllegalArgumentException("크루는 1명 이상 10,000명 이하이어야 합니다.");
        }
    }

    public static void validateEmailLength(List<List<String>> forms) {
        for (List<String> form : forms) {
            if (form.get(0).length() < 11 || form.get(0).length() > 10000) {
                throw new IllegalArgumentException("이메일의 길이는 11자 이상 20자 미만이어야 합니다.");
            }
        }
    }

    public static void validateEmailForm(List<List<String>> forms) {
        for (List<String> form : forms) {
            if (!form.get(0).matches("^.+@email\\.com$")) {
                throw new IllegalArgumentException("이메일은 이메일 형식에 부합해야 합니다.");
            }
        }
    }

    public static void validateNicknameLength(List<List<String>> forms) {
        for (List<String> form : forms) {
            if (form.get(1).length() < 1 || form.get(1).length() > 10000) {
                throw new IllegalArgumentException("닉네임의 길이는 1자 이상 20자 미만이어야 합니다.");
            }
        }
    }
}
