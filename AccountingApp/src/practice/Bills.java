package practice;

public class Bills {
    //fields
    public String category;
    public String account;
    public String type;
    public double total;
    public String date;
    public String notes;

    //methods
    public Bills() {
    }

    public Bills(String category, String account, String type, double total, String date, String notes) {
        this.category = category;
        this.account = account;
        this.type = type;
        this.total = total;
        this.date = date;
        this.notes = notes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
