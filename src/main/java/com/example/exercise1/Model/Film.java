package com.example.exercise1.Model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.example.exercise1.Enum.Rating.Rating;
import com.example.exercise1.Validation.SetValidation.ValidSet;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "film")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private Integer filmId;

    @Column(name = "title")
    @NotBlank(message = "The title may not be blank")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "release_year")
    @Nullable
    @Min(value = 1000, message = "The release year must be greater than or equal to 0")
    @Max(value = 9999, message = "The release year must be less than or equal to 255")
    private Integer releaseYear;

    @Column(name = "language_id")
    @Min(value = 0, message = "The language id must be greater than or equal to 0")
    @Max(value = 255, message = "The language id must be less than or equal to 255")
    private Integer languageId;

    @Column(name = "original_language_id")
    @Min(value = 0, message = "The original language id must be greater than or equal to 0")
    @Max(value = 255, message = "The original language id must be less than or equal to 255")
    @Nullable
    private Integer originalLanguageId;

    @Column(name = "rental_duration")
    @Min(value = 0, message = "The rental duration id must be greater than or equal to 0")
    @Max(value = 255, message = "The rental duration id must be less than or equal to 255")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    @DecimalMin(value = "0.0", message = "The rental rate must be greater than 0.0")
    @DecimalMax(value = "9999.99", message = "The rental rate must be less than 9999.99")
    private BigDecimal rentalRate;

    @Column(name = "length")
    @Min(value = 0, message = "The length must be greater than or equal to 0")
    @Max(value = 65535, message = "The length must be less than or equal to 255")
    @Nullable
    private Integer length;

    @Column(name = "replacement_cost")
    @DecimalMin(value = "0.0", message = "The replacement cost must be greater than 0.0")
    @DecimalMax(value = "99999.99", message = "The replacement cost must be less than 99999.99")
    private BigDecimal replacementCost;

    @Column(name = "rating")
    @Nullable
    private Rating rating;

    @Column(name = "special_features")
    @ValidSet(allowedValues = { "Trailers", "Commentaries", "Deleted Scenes", "Behind the Scenes" })
    private String specialFeatures;

    @Column(name = "last_update")
    private Timestamp lastUpdate;

    public Film() {
    }

    public Film(Integer filmId, String title, String description, Integer releaseYear, Integer languageId,
            Integer originalLanguageId, Integer rentalDuration, BigDecimal rentalRate, Integer length,
            BigDecimal replacementCost, Rating rating, String specialFeatures, Timestamp lastUpdate) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.languageId = languageId;
        this.originalLanguageId = originalLanguageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.lastUpdate = lastUpdate;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    public Integer getOriginalLanguageId() {
        return originalLanguageId;
    }

    public void setOriginalLanguageId(Integer originalLanguageId) {
        this.originalLanguageId = originalLanguageId;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
