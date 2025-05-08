+----------------+       +--------------------+     +---------------------+
|    Weather     |       |    Wilaya          |     |   CoastalWilaya     |
+----------------+       +--------------------+     +---------------------+
| - date         |       | - name             |     | - humidityRate      |
| - temp         |       | - dailyWeather     |     | - waveHeight        |
| - wind         |       +--------------------+     +---------------------+
| - rainfall     |       | + addWeather()     |     | + setHumidityRate() |
+----------------+       | + print()          |     | + setWaveHeight()   |
                         | + getAvrageWeather |     | + print()           |                               
                         +--------------------+     +---------------------+               






Object-Oriented Principles Applied:
Inheritance: CoastalWilaya extends Wilaya, reusing its attributes and methods.
Polymorphism: The print method in CoastalWilaya overrides Wilaya’s print, allowing different behavior for coastal provinces.
Encapsulation: Attributes are private with public getters/setters, controlling access.
Open/Closed Principle: The design is open for extension (adding CoastalWilaya) without modifying Wilaya or ClimateTracker.
Liskov Substitution Principle: CoastalWilaya can be used anywhere a Wilaya is expected, as it maintains the parent’s contract.
Minimal Modification: Adding CoastalWilaya required no changes to Wilaya or ClimateTracker, only a new class and overridden behavior.