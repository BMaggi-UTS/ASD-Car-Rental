package model;

public class Report {
    private int reportID;
    private String reportDate;
    private String reportType;
    private int totalCustomers;
    private double totalRevenue;
    private String additionalField1;
    private String additionalField2;

    // Constructor with additional fields
    public Report(int reportID, String reportDate, String reportType, int totalCustomers, double totalRevenue, String additionalField1, String additionalField2) {
        this.reportID = reportID;
        this.reportDate = reportDate;
        this.reportType = reportType;
        this.totalCustomers = totalCustomers;
        this.totalRevenue = totalRevenue;
        this.additionalField1 = additionalField1;
        this.additionalField2 = additionalField2;
    }

    // Getter and Setter methods
    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(int totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public String getAdditionalField1() {
        return additionalField1;
    }

    public void setAdditionalField1(String additionalField1) {
        this.additionalField1 = additionalField1;
    }

    public String getAdditionalField2() {
        return additionalField2;
    }

    public void setAdditionalField2(String additionalField2) {
        this.additionalField2 = additionalField2;
    }
}
