package tian.pusen.offer.web.vo.page;

import io.swagger.annotations.ApiModelProperty;
import tian.pusen.offer.web.vo.entity.RespEntity;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈功能详细描述〉
 * Date: 2017/11/15 20:33
 *
 * @author tianpusen
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class PageResp<T> implements RespEntity {
    @ApiModelProperty(value = "总条数")
    private String recordTotal;
    @ApiModelProperty(value = "总页数")
    private String pageTotal;
    @ApiModelProperty(value = "当前请求页数")
    private String pageIndex;
    @ApiModelProperty(value = "每页显示数据")
    private String pageSize;
    @ApiModelProperty(value = "记录列表")
    private List<T> records;
	public String getRecordTotal() {
		return recordTotal;
	}
	public void setRecordTotal(String recordTotal) {
		this.recordTotal = recordTotal;
	}
	public String getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(String pageTotal) {
		this.pageTotal = pageTotal;
	}
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
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}

	@Override
	public String toString() {
		return "PageResp{" +
				"recordTotal='" + recordTotal + '\'' +
				", pageTotal='" + pageTotal + '\'' +
				", pageIndex='" + pageIndex + '\'' +
				", pageSize='" + pageSize + '\'' +
				", records=" + records +
				'}';
	}
}
