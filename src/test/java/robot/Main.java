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

        moveRobot(manager, 1, 4);

    }

    //    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
//        RobotConnection connection = null;
//        int i = 0;
//        while (i < 3)
//            try {
//                connection = robotConnectionManager.getConnection();
//                connection.moveRobotTo(toX, toY);
//                i=3;
//            } catch (RobotConnectionException e) {
//                i++;
//                if(i==3)
//                    throw new RobotConnectionException(e.getMessage());
//            } finally {
//                if (connection != null)
//                    connection.close();

    //            }
//    }
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        for (int i = 0; i < 3; ) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                i = 3;
            } catch (RobotConnectionException e) {
                if (i == 2)
                    throw new RobotConnectionException(e.getMessage());
                i++;
            }
        }
    }
}