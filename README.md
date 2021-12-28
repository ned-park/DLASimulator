# 3D Diffusion Limited Aggregation Simulator

## About
The idea for this program happened during a C++ course where we were given an 
assignment to produce a 2D DLA simulator.  I found the result
intriguing and wondered about adding a third dimension dimension.

Some months later, I was thinking about a similar problem and decided 
to build a 3D DLA simulator in Java thinking some examples might 
lend a little more insight into the problem at hand.  The result is here, and 
it performs 3D DLA simulations using random walks then prints 
the result of the simulation in slices to console.  

This version features a Simulator Interface, implemented by both open
and closed simulators, and a set of command line flags the facilitate batch 
simulations when desired.  

The size of the system is 20x20x20.

## Build instructions

Assuming you have a jdk installed:

    git clone https://github.com/ned-park/DLASimulator.git  
    cd DLASimulator  
    javac *.java   

## Usage:

java DLArunner -t <o|c> -n <integer> -a <integer>

## Flags
-a The number of attempts to make for each particle entry (defaults to 100000 
if not specified to prevent infinite loops in dense systems without much inhibition
of the random starting placement in small-scale systems).

-n The number of particles to add to the system (defaults to 0) so it is recommended to set.

-t The type of system to simulate.  Accepted values are `c` for a closed periodic
simulation and `o` for an open simulation (defaults to `c`).

## Examples:

    java DLArunner -t p -n 400 -a 15000  
    java DLArunner -t o -n 1000 

## Sample output

    --------------------    
    ....++..++..........  
    ..+++...............  
    ...++.++++..........  
    ..++++..............  
    .++++++++...........  
    ..++++++++..........  
    +..+...+++..........  
    ++++.+++..+.........  
    ...+.+..............  
    ......+.............  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ........++..........  
    --------------------    
    ++..+++.+...........  
    ++++++.+++..........  
    ...+...+++..........  
    ....+.+.+...........  
    ....++.+............  
    +....++++...........  
    +.+..+.+++..........  
    ..++...+++..........  
    ...+.+..+...........  
    ...+................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    --------------------    
    ..+.+++++...........  
    ..+.++.++...........  
    +++...++++..........  
    .+++.++.+...........  
    ....+..+.+..........  
    +...+++++...........  
    +..+++..+...........  
    ++++++.+++..........  
    ..+.+++.+...........  
    ++....++............  
    ......+.............  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....+...+...........  
    --------------------    
    ..++.+++............  
    ....++..+...........  
    .+++++++.+..........  
    ..+++.++............  
    ..++++++++..........  
    ....+++++...........  
    ..+++...+...........  
    ++++++++.+..........  
    +.++.+++............  
    ++++.+..............  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ..+..+..............  
    ..++++..............  
    --------------------    
    .++++..+............  
    ..+++++.+...........  
    ++++++..............  
    +.++.++++...........  
    .+...+.+............  
    ...+++++............  
    ++..+.++++..........  
    +++.................  
    ..+.++.++...........  
    ...++++.+...........  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ...++...............  
    ....+...............  
    --------------------    
    ...+.++.++..+.......  
    ....++++++.++.......  
    ..+..+++++..........  
    .++..+++............  
    ++..++.++...........  
    +..+++++++..........  
    +..++++++++.........  
    +.+++.++............  
    +..+..++++..........  
    ..+.....++..........  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....+...............  
    --------------------    
    ...+.......+........  
    ...++.+++.++........  
    .+.+.++++...........  
    .++.+++.+...........  
    .+..++.++...........  
    ..++++++++..........  
    ....+.+..+..........  
    ++++.+++++.........+  
    +..+.+++.+..........  
    +++..++..+........++  
    ..+.................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    --------------------    
    ......+.+...........  
    .++..++++++++.......  
    ...+++++.+..........  
    ....+++++...........  
    ......+++...........  
    ....++++++..........  
    .+.+++++............  
    ++++++.............+  
    +.++................  
    +++..+...+.........+  
    ..+.................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    .....+..............  
    --------------------    
    .++.++++............  
    +.+++++++.+.........  
    +...+.+.............  
    ....+..+.+..........  
    .......+............  
    +...+..+++..........  
    +.+...+.+...........  
    +++.++++...........+  
    +.+++.+.............  
    .+++.+..............  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    .....+..............  
    --------------------    
    ++++.++.............  
    ++....++............  
    +.++++..++..........  
    +.++.++.++..........  
    .+..++...+..........  
    ..+++...+++.........  
    .++.+..+++..........  
    .+...+..............  
    +.+++...............  
    .+...+..............  
    .+..................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    .....+..............  
    .....+..............  
    --------------------    
    ++++...+++..........  
    ++++...+++.........+  
    .++.++++++..........  
    ..+.+++++...........  
    .+++++..+...........  
    .++.++.+............  
    ....++.++...........  
    ++...+..............  
    +++....+............  
    +.+....++...........  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ........++..........  
    --------------------    
    .+.++.++.++.........  
    +++.+.+............+  
    .+++++.+++.........+  
    +++.+++++...........  
    ++++..+.++..........  
    ++++..++++..........  
    ..+.++++.+..........  
    ++...+..............  
    .......+............  
    ......+.............  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    .........+..........  
    --------------------    
    .+.++.++++..........  
    +...+++............+  
    .+++..+++++.........  
    ..+.+++.............  
    ..+.+.+.+...........  
    ++.+.+++.+..........  
    +..+++++............  
    +...+..+++..........  
    ++..+.++...........+  
    +...++++...........+  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    --------------------    
    +...+....+..........  
    ++..................  
    ++......+++........+  
    +...++++++..........  
    ..+.++.+............  
    .....+..............  
    ++..++++............  
    +++....+............  
    .++++..+............  
    ....+...............  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    --------------------    
    ....................  
    ..+++...............  
    .+....+.+...........  
    ++...+++++..........  
    ++....++.+..........  
    ....+...++..........  
    ....+.++.+..........  
    ..+....+............  
    ....+....+..........  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    --------------------    
    .......+............  
    ...++...++..........  
    ......+.............  
    +.....+.++..........  
    .+.++++++...........  
    ..+.++.+++..........  
    ....+++..+..........  
    ....+...++..........  
    .........+..........  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    --------------------    
    .......++...........  
    ....+.+.+...........  
    ........+...........  
    .+.+.++.............  
    .++++.++++..........  
    .++.+++++...........  
    .+.+++++............  
    ...++++++...........  
    ....++..............  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    --------------------    
    .......+............  
    ....+.+++...........  
    ...++.+.+...........  
    .+.++.+.............  
    ...++++.+...........  
    +++.++.............+  
    +..+++...+..........  
    .++....+............  
    .+..++++............  
    .....++.............  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    ....................  
    .......++...........  
    --------------------      
    ..+.+..++...........    
    ..++++++++..........    
    ..+++...............    
    +.++..+.............    
    +...++++++..........    
    ++..+.+++...........    
    .+++++...+..........    
    ..++.+.++.+.........    
    ..++.+..............    
    ...+................    
    ....................    
    ....................    
    ....................    
    ....................    
    ....................    
    ....................    
    ....................    
    ....................    
    ....................    
    .......++...........    
    --------------------      
    .....+..............    
    ..+.+.+.+...........    
    .....+..++..........    
    ..+..++.+...........    
    ....+.+.+...........    
    +.....++++..........    
    ....++.+++..........    
    ...+.+++.++.........    
    ...+...+++..........    
    ..++..++.+..........    
    ....................    
    ....................    
    ....................    
    ....................    
    ....................    
    ....................    
    ....................    
    .......+............    
    .......+............    
    .......++...........    
    --------------------      
      
      
        
