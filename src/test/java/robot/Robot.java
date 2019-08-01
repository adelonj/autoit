package robot;

/**
 * Created by delonj on 17/07/2019.
 */
public class Robot implements RobotConnection {
    private int x;
    private int y;
    private Direction direction;

    public Robot(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    Direction getDirection() {
        return direction;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }


    @Override
    public void close() {
        System.out.println("close connection");

    }

    @Override
    public void moveRobotTo(int toX, int toY) {
        if (x == 10)
            throw new RuntimeException("aaaaqqq");
        if (getY() != toY) {
            if (toY > getY()) {
                while (getDirection() != Direction.UP)
                    turnRight();
                while (toY != getY())
                    stepForward();

            } else {
                while (getDirection() != Direction.DOWN)
                    turnRight();
                while (toY != getY())
                    stepForward();
            }
        }

        if (getX() != toX) {
            if (toX > getX()) {
                while (getDirection() != Direction.RIGHT)
                    turnRight();
                while (toX != getX()) {
                    stepForward();
                }
            } else {
                while (getDirection() != Direction.LEFT)
                    turnRight();
                while (getX() != toX)
                    stepForward();
            }
        }
    }

    private void turnRight() {
        System.out.println("поворот по часовой стрелке");
        if (this.direction == Direction.DOWN) {
            System.out.println("Вниз -> влево");
            this.direction = Direction.LEFT;
            return;
        }

        if (this.direction == Direction.UP) {
            System.out.println("Вверх -> вправо");
            this.direction = Direction.RIGHT;
            return;
        }

        if (this.direction == Direction.LEFT) {
            System.out.println("Влево -> вверх");
            this.direction = Direction.UP;
            return;
        }

        if (this.direction == Direction.RIGHT) {
            System.out.println("Вправо -> вниз");
            this.direction = Direction.DOWN;
            return;
        }
    }

    private void stepForward() {
        if (direction == Direction.DOWN) {
            System.out.println("вниз");
            this.y--;
        }

        if (direction == Direction.UP) {
            System.out.println("вверх");
            this.y++;
        }

        if (direction == Direction.LEFT) {
            System.out.println("налево");
            this.x--;
        }

        if (direction == Direction.RIGHT) {
            System.out.println("направо");
            this.x++;
        }
    }
}
