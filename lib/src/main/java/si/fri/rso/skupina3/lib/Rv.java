package si.fri.rso.skupina3.lib;

public class Rv {

    private Integer rv_id;
    private Integer user_id;
    private Integer capacity;
    private String manufacturer;
    private Integer year;
    private String description;
    private Float rating;
    private Float cost_per_day;

    public Integer getRv_id() {
        return rv_id;
    }

    public void setRv_id(Integer rv_id) {
        this.rv_id = rv_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Float getCost_per_day() {
        return cost_per_day;
    }

    public void setCost_per_day(Float cost_per_day) {
        this.cost_per_day = cost_per_day;
    }
}
