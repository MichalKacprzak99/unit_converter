# Simple unit converter

## Description
Simple unit converter allowing conversion of various units. 
Implementation of converter allows extending it easily when adding new units.
The main goal of this project was to focus on the SOLID principles.

* Program is a single threaded standalone application
* Program parameters passed from command line in following format:

        <value> <unit_to_be_converted> <unit_after_convertion>
        
    Please see examples below:
        
        1500100900 kg lb
        
    <a></a>
        
        666 cm in
    
## Supported 
### conversions
* from kilograms [kg] to pounds [lb] and vice versa
* from centimeters [cm] to inches [in] and vice versa

### values
* integers
* doubles
