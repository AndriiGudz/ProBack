package lessons_02.config;

import lessons_02.staff.administration.Director;
import lessons_02.staff.administration.ProdactionChief;
import lessons_02.staff.administration.SalesChief;
import lessons_02.staff.specialists.prodaction.MachineOperator;
import lessons_02.staff.specialists.prodaction.Storekeeper;
import lessons_02.staff.specialists.sales.Merchandiser;
import lessons_02.staff.specialists.sales.SalesManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Director director() {
        return new Director();
    }

    @Bean
    public SalesChief salesChief() {
        return new SalesChief();
    }
    @Bean
    public Merchandiser merchandiser() {
        return new Merchandiser();
    }
    @Bean
    public SalesManager salesManager() {
        return new SalesManager();
    }
    @Bean
    public ProdactionChief prodactionChief() {
        return new ProdactionChief();
    }
    @Bean
    public MachineOperator machineOperator() {
        return new MachineOperator();
    }
    @Bean
    public Storekeeper storekeeper() {
        return new Storekeeper();
    }
}
