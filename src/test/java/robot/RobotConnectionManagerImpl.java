package robot;

/**
 * Created by delonj on 25/07/2019.
 */
public class RobotConnectionManagerImpl implements RobotConnectionManager {
    private Robot robot;
    private int i = 10;


    public RobotConnectionManagerImpl(int x,int y,Direction direction) {
        this.robot = new Robot(x,y,direction);

    }

    @Override
    public RobotConnection getConnection()  {
        System.out.println("start connection");
        if(i>2) {
            i--;
            System.out.println("fail connection");

            //throw new RobotConnectionException("something wrong");
            throw new RuntimeException("runtime error");
        }
        return robot;
    }
}
