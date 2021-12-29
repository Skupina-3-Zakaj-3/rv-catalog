package si.fri.rso.skupina3.rv_catalog.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "rvs")
@NamedQueries(value =
        {
                @NamedQuery(name = "RvEntity.getAll",
                        query = "SELECT rv FROM RvEntity rv"),
        })
public class RvEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rv_id;

    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "year")
    private Integer year;

    @Column(name = "description")
    private String description;

    @Column(name = "rating")
    private Float rating;

    @Column(name = "cost_per_day")
    private Float cost_per_day;

    @Column(name = "num_of_reviews")
    private Integer num_of_reviews;


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

    public Integer getNum_of_reviews() {
        return num_of_reviews;
    }

    public void setNum_of_reviews(Integer num_of_reviews) {
        this.num_of_reviews = num_of_reviews;
    }
}
