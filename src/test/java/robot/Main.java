package robot;

/**
 * Created by delonj on 17/07/2019.
 */
public class Main {
    public static void main(String[] args) {

//        Robot robot = new Robot(0, 0, Direction.UP);
//        moveRobot(robot, 0, 3);
//        System.out.println("x=" + robot.getX() + " y=" + robot.getY());
//
//
//        robot = new Robot(0, 0, Direction.UP);
//        moveRobot(robot, 3, -1);
//        System.out.println("x=" + robot.getX() + " y=" + robot.getY());
//        robot = new Robot(0, 0, Direction.UP);
//        moveRobot(robot, -5, 3);
//
// System.out.println("x=" + robot.getX() + " y=" + robot.getY());
        RobotConnectionManager manager = new RobotConnectionManagerImpl(1, 3, Direction.UP);

        RobotConnection connection = new Robot(10, 3, Direction.UP);
        int i = 0;
        while (i != 3)
            try {
                connection = manager.getConnection();
                connection.moveRobotTo(10, 4);
                break;
            } catch (RobotConnectionException e) {
                i++;
                System.out.println(i + " = попытка");
            } finally {
                if (connection != null)
                    connection.close();
            }

    }


}