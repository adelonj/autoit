package robot;

/**
 * Created by delonj on 25/07/2019.
 */
public interface RobotConnection extends AutoCloseable {
    void moveRobotTo(int x, int y);
    @Override
    void close();

}
