package christmas.domain.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("뱃지 테스트")
class BadgeTest {

    @Test
    @DisplayName("가격이 5000원보다 낮을 시, NONE 뱃지를 반환한다.")
    void return_none_badge_when_price_less_than_5000() {
        // given
        int price = 1000;

        // when
        Badge badge = Badge.calculateBadge(price);

        // then
        assertThat(badge).isEqualTo(Badge.NONE);
    }

    @Test
    @DisplayName("가격이 5000원보다 높고 10000원보다 낮을 시, STAR 뱃지를 반환한다.")
    void return_none_badge_when_price_greater_than_5000_and_less_than_10000() {
        // given
        int price = 8000;

        // when
        Badge badge = Badge.calculateBadge(price);

        // then
        assertThat(badge).isEqualTo(Badge.STAR);
    }

    @Test
    @DisplayName("가격이 10000원보다 높고 15000원보다 낮을 시, TREE 뱃지를 반환한다.")
    void return_none_badge_when_price_greater_than_10000_and_less_than_20000() {
        // given
        int price = 17000;

        // when
        Badge badge = Badge.calculateBadge(price);

        // then
        assertThat(badge).isEqualTo(Badge.TREE);
    }

    @Test
    @DisplayName("가격이 20000원보다 높을 시, SANTA 뱃지를 반환한다.")
    void return_none_badge_when_price_greater_than_20000() {
        // given
        int price = 20000;

        // when
        Badge badge = Badge.calculateBadge(price);

        // then
        assertThat(badge).isEqualTo(Badge.SANTA);
    }
}