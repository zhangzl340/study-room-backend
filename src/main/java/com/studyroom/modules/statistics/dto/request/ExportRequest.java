package com.studyroom.modules.statistics.dto.request;

public class ExportRequest {
    private StatisticsQueryRequest queryRequest;
    private String exportType;
    private String exportFormat;
    private String fileName;

    public StatisticsQueryRequest getQueryRequest() {
        return queryRequest;
    }

    public void setQueryRequest(StatisticsQueryRequest queryRequest) {
        this.queryRequest = queryRequest;
    }

    public String getExportType() {
        return exportType;
    }

    public void setExportType(String exportType) {
        this.exportType = exportType;
    }

    public String getExportFormat() {
        return exportFormat;
    }

    public void setExportFormat(String exportFormat) {
        this.exportFormat = exportFormat;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
