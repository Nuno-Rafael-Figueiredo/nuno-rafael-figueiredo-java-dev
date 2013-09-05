package sakila.model;

import design.patterns.factory.Factory;

/**
 * User: Nuno
 * Date: 05-09-2013
 * Time: 19:35
 */
public class SakilaTableFactory extends Factory<SakilaTable> {
    public static final SakilaTableFactory INSTANCE = new SakilaTableFactory();

    private SakilaTableFactory() {
    }

    @Override
    public SakilaTable create(String name) {
        return super.create("sakila.model.entities." + name);
    }
}
