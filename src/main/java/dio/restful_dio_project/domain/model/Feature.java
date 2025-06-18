package dio.restful_dio_project.domain.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "features")
@Getter
@Setter
public class Feature extends BaseItem { }
