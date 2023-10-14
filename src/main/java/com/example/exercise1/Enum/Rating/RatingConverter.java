package com.example.exercise1.Enum.Rating;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class RatingConverter implements AttributeConverter<Rating, String> {
    @Override
    public String convertToDatabaseColumn(Rating rating) {
        if (rating == null)
            return null;

        return rating.getCode();
    }

    @Override
    public Rating convertToEntityAttribute(String code) {
        if (code == null)
            return null;

        return Rating.fromCode(code);
    }
}
