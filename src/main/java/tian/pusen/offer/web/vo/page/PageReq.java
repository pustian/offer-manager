package tian.pusen.offer.web.vo.page;

import io.swagger.annotations.ApiModelProperty;
import tian.pusen.offer.web.vo.entity.ReqEntity;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/11/15 20:33
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PageReq<T> implements ReqEntity {
    @ApiModelProperty(value = "当前请求页编码", example="1")
    private String pageIndex = "1";
    @ApiModelProperty(value = "每页显示条数", example = "20")
    private String pageSize = "20";
    private T t;

    public String getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(String pageIndex) {
        this.pageIndex = pageIndex;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "PageReq{" +
                "pageIndex='" + pageIndex + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", t=" + t +
                '}';
    }

}
