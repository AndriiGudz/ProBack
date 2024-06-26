package homeworks_02.nation.config;

import homeworks_02.nation.countrysLeadership.HeadOfParliament;
import homeworks_02.nation.countrysLeadership.President;
import homeworks_02.nation.countrysLeadership.PrimeMinister;
import homeworks_02.nation.executivePower.MinisterOfForeignAffairs;
import homeworks_02.nation.executivePower.MinisterOfTheInterior;
import homeworks_02.nation.parlament.Deputy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryConfig {
    @Bean
    public President president() {
        return new President();
    }

    @Bean
    public HeadOfParliament headOfParliament() {
        return new HeadOfParliament();
    }

    @Bean
    public PrimeMinister primeMinister() {
        return new PrimeMinister();
    }

    @Bean
    public MinisterOfForeignAffairs ministerOfForeignAffairs() {
        return new MinisterOfForeignAffairs();
    }

    @Bean
    public MinisterOfTheInterior ministerOfTheInterior() {
        return new MinisterOfTheInterior();
    }

    @Bean
    public Deputy deputy() {
        return new Deputy();
    }
}
