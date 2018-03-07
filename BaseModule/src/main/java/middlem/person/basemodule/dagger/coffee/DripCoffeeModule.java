package middlem.person.basemodule.dagger.coffee;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

//@Module(includes = PumpModule.class)
class DripCoffeeModule {
    @Singleton
    Heater provideHeater() {
        return new ElectricHeater();
    }
}
