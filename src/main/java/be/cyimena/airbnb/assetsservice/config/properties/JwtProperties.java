package be.cyimena.airbnb.assetsservice.config.properties;

import lombok.Data;

@Data
public class JwtProperties {
    private String secretKey = "zdtlD3JK56m6wTTgsNFhqzjqP";
    private int expirationDuration = 36000000; // 10h
    private int expirationActivateAccountDuration;
}
