package si.fri.rso.skupina3.rv_catalog.models.converters;

import si.fri.rso.skupina3.lib.Rv;
import si.fri.rso.skupina3.rv_catalog.models.entities.RvEntity;

public class RvConverter {

    public static Rv toDto(RvEntity entity) {

        Rv dto = new Rv();
        dto.setRv_id(entity.getRv_id());
        dto.setUser_id(entity.getUser_id());
        dto.setCapacity(entity.getCapacity());
        dto.setManufacturer(entity.getManufacturer());
        dto.setYear(entity.getYear());
        dto.setDescription(entity.getDescription());
        dto.setRating(entity.getRating());
        dto.setCost_per_day(entity.getCost_per_day());
        dto.setNum_of_reviews(entity.getNum_of_reviews());

        return dto;
    }

    public static RvEntity toEntity(Rv dto) {

        RvEntity entity = new RvEntity();
        entity.setUser_id(dto.getUser_id());
        entity.setCapacity(dto.getCapacity());
        entity.setManufacturer(dto.getManufacturer());
        entity.setYear(dto.getYear());
        entity.setDescription(dto.getDescription());
        entity.setRating(dto.getRating());
        entity.setCost_per_day(dto.getCost_per_day());
        entity.setNum_of_reviews(dto.getNum_of_reviews());

        return entity;

    }

}
