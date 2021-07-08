package be.cyimena.airbnb.assetsservice.mappers;

import be.cyimena.airbnb.assetsservice.domain.Account;
import be.cyimena.airbnb.assetsservice.web.models.AccountDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IAccountMapper {
    IAccountMapper INSTANCE = Mappers.getMapper(IAccountMapper.class);

    @Mapping(target = "user", ignore = true)
    Account mapToAccount(AccountDto source);

    @Mapping(target = "user", ignore = true)
    AccountDto mapToAccountDto(Account source);

}
