# Verspaetung public transport

### Assumptions/Deductions
Given the limited information I assume/deduct the following:

* I assume that Vehicle and Line are not the same. Therefore I introduced a Vehicle object
* In our modelling, Vehicle and Line have a 1 to 1 relationship, with the reasoning:
* Given the data that a Delay object is associated with only one line via line_name, I are not able to provide specific delay data if multiple vehicles are given.

* I assume the delay information is given in minutes.

* Find a vehicle for a given timeAfterDelay and X & Y coordinates. With the given data set, the service can only handle requests with X & Y coordinates which can be mapped to stops, as I do not have route information.
* Return the vehicle arriving next at a given stop. Assume that "arriving next" means the next vehicle to arrive relative to Zeitpunkt when the request was sent.