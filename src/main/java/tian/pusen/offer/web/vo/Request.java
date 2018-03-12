package tian.pusen.offer.web.vo;


import tian.pusen.offer.web.vo.entity.ReqEntity;
import tian.pusen.offer.web.vo.header.ReqHeader;

/**
 * Created by tianpusen on 2017/7/15.
 */
public class Request<T extends ReqEntity> {
    ReqHeader reqHeader;
    T reqBody;

    public ReqHeader getReqHeader() {
        return reqHeader;
    }

    public void setReqHeader(ReqHeader reqHeader) {
        this.reqHeader = reqHeader;
    }

    public T getReqBody() {
        return reqBody;
    }

    public void setReqBody(T reqBody) {
        this.reqBody = reqBody;
    }

    @Override
    public String toString() {
        return "Request{" +
                "reqHeader=" + reqHeader +
                ", reqBody=" + reqBody +
                '}';
    }
}
