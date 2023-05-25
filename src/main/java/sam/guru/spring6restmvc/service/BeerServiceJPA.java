package sam.guru.spring6restmvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sam.guru.spring6restmvc.mappers.BeerMapper;
import sam.guru.spring6restmvc.models.BeerDto;
import sam.guru.spring6restmvc.repositories.BeerRepository;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Primary
public class BeerServiceJPA implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerRepository.findById(beerId).map(beerMapper::beerToBeerDto).orElseThrow(RuntimeException::new);

    }

    @Override
    public List<BeerDto> getBeers() {
        return beerRepository.findAll().stream().map(beerMapper::beerToBeerDto).collect(Collectors.toList());
    }

    @Override
    public void saveBeer(BeerDto beer) {
        beerRepository.save(beerMapper.beerDtoToBeer(beer));
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beer) {

    }

    @Override
    public void deleteBeer(UUID beerId) {

    }
}
