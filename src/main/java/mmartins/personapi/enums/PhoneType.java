package mmartins.personapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Enumerated;

@Getter
@AllArgsConstructor
public enum PhoneType {

    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    private final String description;
}
