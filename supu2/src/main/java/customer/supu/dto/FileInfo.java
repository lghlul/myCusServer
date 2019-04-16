package customer.supu.dto;

public class FileInfo {
	private String url;

	private String reportName;

	private String rReportName;

	private long  fileSize;


	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getrReportName() {
		return rReportName;
	}

	public void setrReportName(String rReportName) {
		this.rReportName = rReportName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
