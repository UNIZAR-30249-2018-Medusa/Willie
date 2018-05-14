package willie.Infraestructura;

import java.util.UUID;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * JPA Convention to automatically convert UUID from Database (PostgreSQL) into Java and vice versa.
 * @author Sukma Wardana
 * @link https://medium.com/@swhp/work-with-uuid-in-jpa-and-postgresql-86a59ea989cd
 */
@Converter(autoApply = true)
public class UuidConverter implements AttributeConverter<UUID, UUID> {

    @Override
    public UUID convertToDatabaseColumn(UUID attribute) {
        return attribute;
    }

    @Override
    public UUID convertToEntityAttribute(UUID dbData) {
        return dbData;
    }

}