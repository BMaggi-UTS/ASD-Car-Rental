package model;

public class Supplier {
    
    private int supplierID;
    private String businessName;
    private String ABN;
    private String ACN;
    private String contactName;
    private String contactPhone;
    private String imagePath;

    


    public Supplier(int supplierID, String businessName, String aBN, String aCN, String contactName,
            String contactPhone, String imagePath) {
        this.supplierID = supplierID;
        this.businessName = businessName;
        ABN = aBN;
        ACN = aCN;
        this.contactName = contactName;
        this.contactPhone = contactPhone;
        this.imagePath = imagePath;
    }
    public int getSupplierID() {
        return supplierID;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public String getBusinessName() {
        return businessName;
    }
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public String getABN() {
        return ABN;
    }
    public void setABN(String aBN) {
        ABN = aBN;
    }
    public String getACN() {
        return ACN;
    }
    public void setACN(String aCN) {
        ACN = aCN;
    }
    public String getContactName() {
        return contactName;
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
    public String getContactPhone() {
        return contactPhone;
    }
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

}
