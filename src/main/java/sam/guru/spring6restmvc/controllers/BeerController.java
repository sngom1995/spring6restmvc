package sam.guru.spring6restmvc.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sam.guru.spring6restmvc.models.BeerDto;
import sam.guru.spring6restmvc.service.BeerService;

import java.util.UUID;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @GetMapping
    public ResponseEntity<?> getBeers() {
        log.debug("In getBeer called");
        return ResponseEntity.ok(beerService.getBeers());
    }

    @PostMapping
    public ResponseEntity<?> saveBeer(@RequestBody BeerDto beer) {
        log.debug("In saveBeer called");
        BeerDto savedBeer = BeerDto
                .builder()
                .id(UUID.randomUUID())
                .version(beer.getVersion())
                .beerName(beer.getBeerName())
                .beerStyle(beer.getBeerStyle())
                .upc(beer.getUpc())
                .createdDate(beer.getCreatedDate())
                .updatedDate(beer.getUpdatedDate())
                .price(beer.getPrice())
                .quantityOnHand(beer.getQuantityOnHand())
                .build();
        beerService.saveBeer(savedBeer);
        return ResponseEntity.status(201).build();

    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDto> getBeer(@PathVariable UUID beerId) {
        log.debug("In getBeer called"+beerId);
        return ResponseEntity.ok(beerService.getBeerById(beerId));
    }

    @PutMapping("/{beerId}")
    public ResponseEntity<?> updateBeer(@PathVariable UUID beerId, @RequestBody BeerDto beer) {
        log.debug("In updateBeer called");
        beerService.updateBeer(beerId, beer);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity<?> deleteBeer(@PathVariable UUID beerId) {
        log.debug("In deleteBeer called");
        beerService.deleteBeer(beerId);
        return ResponseEntity.status(204).build();
    }
}
