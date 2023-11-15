package christmas.domain.order.menu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("메뉴 테스트")
class MenuTest {

    @Test
    @DisplayName("메뉴 이름이 주어졌을 때, 해당 이름의 Menu를 반환한다.")
    void return_Menu_when_menuName_is_given() {
        //given
        String menuName = "티본스테이크";

        //when
        Menu findMenu = Menu.findByName(menuName);

        //then
        assertThat(menuName).isEqualTo(findMenu.getName());
    }
}