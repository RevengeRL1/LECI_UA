#include <detpic32.h>
// 2,7Hz = 0,37037037s
// 0,37037037 * 20000000 = 7407407
int main(void){
TRISE = TRISE & 0xFF87;

int counter = 0;

while(1){
    LATE = (LATE & 0xFF87) | counter << 3;

    resetCoreTimer();
    while(readCoreTimer() < 7407407);

    counter = (counter > 0) ? counter - 1 : 9;
}
}

