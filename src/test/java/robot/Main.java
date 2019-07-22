package robot;

/**
 * Created by delonj on 17/07/2019.
 */
public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(0, 0, Direction.UP);
        moveRobot(robot, 0, 3);
        System.out.println("x=" + robot.getX() + " y=" + robot.getY());


        robot = new Robot(0, 0, Direction.UP);
        moveRobot(robot, 3, -1);
        System.out.println("x=" + robot.getX() + " y=" + robot.getY());
        robot = new Robot(0, 0, Direction.UP);
        moveRobot(robot, -5, 3);
        System.out.println("x=" + robot.getX() + " y=" + robot.getY());


    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        Direction current = robot.getDirection();

        if (robot.getY() != toY) {
            if (toY > robot.getY()) {
                current = turnToDirection(robot, current, Direction.UP);
                while (toY != robot.getY()) {
                    robot.stepForward();
                }
            } else {
                current = turnToDirection(robot, current, Direction.DOWN);
                while (toY != robot.getY()) {
                    robot.stepForward();
                }
            }
        }

        if (robot.getX() != toX) {
            if (toX > robot.getX()) {
                current = turnToDirection(robot, current, Direction.RIGHT);
                while (toX != robot.getX()) {
                    robot.stepForward();
                }
            } else {
                current = turnToDirection(robot, current, Direction.LEFT);
                while (robot.getX() != toX) {
                    robot.stepForward();
                }
            }
        }
    }


    private static Direction turnToDirection(Robot robot, Direction current, Direction toDirection) {
        if (!toDirection.equals(current)) {
            if (current.equals(Direction.UP) && toDirection.equals(Direction.LEFT)
                    || current.equals(Direction.DOWN) && toDirection.equals(Direction.RIGHT)) {
                robot.turnLeft();
            } else if (current.equals(Direction.UP) && toDirection.equals(Direction.RIGHT)
                    || current.equals(Direction.DOWN) && toDirection.equals(Direction.LEFT)) {
                robot.turnRight();
            } else {
                robot.turnLeft();
                robot.turnLeft();
            }
            return toDirection;
        }
        return current;
    }

}