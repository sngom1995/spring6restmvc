package sam.guru.spring6restmvc.mappers;


import org.mapstruct.Mapper;
import sam.guru.spring6restmvc.entities.Beer;
import sam.guru.spring6restmvc.models.BeerDto;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDto beer);
    BeerDto beerToBeerDto(Beer beer);
}
