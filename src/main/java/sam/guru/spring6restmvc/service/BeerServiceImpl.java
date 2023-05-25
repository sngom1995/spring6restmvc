package sam.guru.spring6restmvc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sam.guru.spring6restmvc.models.BeerDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    Map<UUID, BeerDto> beerMap ;

    public BeerServiceImpl() {
        beerMap = new HashMap<>();
        BeerDto beer1 = BeerDto.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .upc(337010000001L)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .price(new BigDecimal("12.95"))
                .quantityOnHand(200)
                .build();

        BeerDto beer2 = BeerDto.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .upc(337010000001L)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .price(new BigDecimal("12.95"))
                .quantityOnHand(200)
                .build();
        BeerDto beer3 = BeerDto.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .upc(337010000001L)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .price(new BigDecimal("12.95"))
                .quantityOnHand(200)
                .build();
        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);

    }


    @Override
    public List<BeerDto> getBeers() {
        log.debug("Get beers");
        return beerMap.values().stream().toList();
    }

    @Override
    public void saveBeer(BeerDto beer) {
        log.debug("Save beer: " + beer);
        beerMap.put(beer.getId(), beer);
    }

    @Override
    public BeerDto getBeerById(UUID beerId) {
        log.debug("Get beerById: " + beerId);
        return beerMap.get(beerId);
    }
     @Override
    public void updateBeer(UUID beerId, BeerDto beer) {
         BeerDto beerToUpdate = beerMap.get(beerId);
         if (beerToUpdate == null) {
             log.error("Beer not found: " + beerId);
             return;
         }
            beerToUpdate.setBeerName(beer.getBeerName());
            beerToUpdate.setBeerStyle(beer.getBeerStyle());
            beerToUpdate.setPrice(beer.getPrice());
            beerToUpdate.setQuantityOnHand(beer.getQuantityOnHand());
            beerToUpdate.setUpc(beer.getUpc());
            beerToUpdate.setUpdatedDate(LocalDateTime.now());
            beerToUpdate.setVersion(beer.getVersion());
            beerMap.put(beerId, beerToUpdate);

         log.debug("Update beer: " + beerId);
         beerMap.put(beerId, beerToUpdate);
     }

        @Override
    public void deleteBeer(UUID beerId) {
        log.debug("Delete beer: " + beerId);
        }
}
