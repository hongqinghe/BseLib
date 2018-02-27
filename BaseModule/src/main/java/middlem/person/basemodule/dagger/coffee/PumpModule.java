package middlem.person.basemodule.dagger.coffee;

import dagger.Module;

@Module
abstract class PumpModule {

  abstract Pump providePump(Thermosiphon pump);
}
