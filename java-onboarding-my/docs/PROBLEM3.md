## 🚀 기능 요구 사항

배달이가 좋아하는 369게임을 하고자 한다. 놀이법은 1부터 숫자를 하나씩 대면서, 3, 6, 9가 들어가는 숫자는 숫자를 말하는 대신 3, 6, 9의 개수만큼 손뼉을 쳐야 한다.

숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.

### 제한사항

- number는 1 이상 10,000 이하인 자연수이다.

### 실행 결과 예시

| number | result |
| --- | --- |
| 13 | 4 |
| 33 | 14 |

### 기능 요구 사항

- [x] 입력값이 1 이상 10,000 이하인 자연수인지 검증한다.
- [x] 입력값의 각 자리수 숫자를 추출한다.
- [x] 각 자리수에서 추출된 숫자들을 바탕으로 3, 6, 9의 개수를 구한다. 
- [x] 1부터 입력값 n까지 각 숫자들로부터 반환되는 손뼉 수를 전부 더한다.
- [x] 최종적으로 손뼉을 쳐야 하는 횟수를 반환한다.
