package dev.melusi.taco_cloud;

import dev.melusi.taco_cloud.Ingredient.Type;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;

@Configuration
public class LoadDatabase {


    @Bean
    public CommandLineRunner dataLoader(JdbcAggregateTemplate template) {
        return args -> {
            // JDBC uses the save method as an update method in the database
            template.insert(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
            template.insert(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
            template.insert(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
            template.insert(new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN));
            template.insert(new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
            template.insert(new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
            template.insert(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
            template.insert(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
            template.insert(new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
            template.insert(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
        };
    }

    /*
    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo) {
         return args -> {
             if(repo.count() == 0) {
                 repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
                 repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
                 repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
                 repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
                 repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
                 repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
                 repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
                 repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
                 repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
                 repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
             }
        };
    }*/

}
