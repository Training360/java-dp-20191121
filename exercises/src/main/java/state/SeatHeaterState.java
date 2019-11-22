package state;

public enum SeatHeaterState {
    OFF {
        SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }

        @Override
        int getPower() {
            return 0;
        }
    },
    THREE {
        SeatHeaterState next() {
            return SeatHeaterState.TWO;
        }

        @Override
        int getPower() {
            return 3;
        }
    },
    TWO {
        SeatHeaterState next() {
            return SeatHeaterState.ONE;
        }

        @Override
        int getPower() {
            return 2;
        }
    },
    ONE {
        SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }

        @Override
        int getPower() {
            return 1;
        }
    };

    abstract SeatHeaterState next();

    abstract int getPower();

}
