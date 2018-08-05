
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by Yan Meng on 2016/9/30.
 */
public class FileUploadClientHandler extends IoHandlerAdapter {

    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("client open");
    }

    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("client session close");
    }

    public void messageReceived(IoSession session, Object message)
            throws Exception {
        System.out.println("thr result is" + message);
    }
}
