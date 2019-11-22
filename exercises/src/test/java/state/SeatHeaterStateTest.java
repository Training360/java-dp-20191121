package state;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeatHeaterStateTest {

    @Test
    public void testOffNext() {
        SeatHeaterState state = SeatHeaterState.OFF;
        state = state.next();
        assertEquals(SeatHeaterState.THREE, state);
        assertEquals(3, state.getPower());
    }

    @Test
    public void testThreeNext() {
        SeatHeaterState state = SeatHeaterState.THREE;
        state = state.next();
        assertEquals(SeatHeaterState.TWO, state);
        assertEquals(2, state.getPower());
    }

    @Test
    public void testTwoNext() {
        SeatHeaterState state = SeatHeaterState.TWO;
        state = state.next();
        assertEquals(SeatHeaterState.ONE, state);
        assertEquals(1, state.getPower());
    }

    @Test
    public void testOneNext() {
        SeatHeaterState state = SeatHeaterState.ONE;
        state = state.next();
        assertEquals(SeatHeaterState.OFF, state);
        assertEquals(0, state.getPower());
    }
}
