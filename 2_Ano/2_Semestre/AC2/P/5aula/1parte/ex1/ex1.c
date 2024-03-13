#include <detpic32.h>

void send2displays(unsigned char value){
    static const char disp7Scodes[] = {0x3F, 0x06, 0x5B, 0x47, 0x66, 0x6D, 0x7D, 0x07, 0x7F, 0x6F, 0x77, 0x7C, 0x39, 0x5E, 0x79, 0x71};
    // Select display high
    LATD = (LATD & 0xFF9F) | 0x0020;

    // Send digit high to display 
    LATB = value >> 4; 

    // Select display low
    LATD = (LATD & 0xFF9F) | 0x0040;

    // Send digit low to display
    LATB = value & 0x0F;

}