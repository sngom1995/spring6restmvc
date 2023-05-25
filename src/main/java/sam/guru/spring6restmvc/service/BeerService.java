package sam.guru.spring6restmvc.service;

import sam.guru.spring6restmvc.models.BeerDto;

import java.util.List;
import java.util.Set;
import java.util.UUID;



public interface BeerService {

    BeerDto getBeerById(UUID beerId);
    List<BeerDto> getBeers();

    void saveBeer(BeerDto beer);

    void updateBeer(UUID beerId, BeerDto beer);

    void deleteBeer(UUID beerId);
}
